package data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.domain.LaptopEntity;
import data.services.ParameterService;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ParameterService parameterService;

    private static String CHROME_LOCATION = "src/main/resources/drivers/chromedriver.exe";
    private static String URL = "https://www.x-kom.pl/szukaj?q=";
    private String item;
    private List<LaptopEntity> laptopList = new ArrayList<>();


    @RequestMapping(value = "/")
    public String start(){
        return "homePage";
    }

    @RequestMapping(value = "/homePage")
    public String homePage(){
        return "homePage";
    }

    @RequestMapping(value = "/extract", method = RequestMethod.POST)
    @ResponseBody
    public String extract(@RequestParam("itemToSearch") String itemToSearch){
        String SERACH_ITEAM_URL = URL+itemToSearch;
        int counter = 0;
        try {
            if (itemToSearch.equals(""))
                return "Pole wyszukiwania jest puste";

            System.setProperty("webdriver.chrome.driver",CHROME_LOCATION);
            WebDriver driver;
            driver = new ChromeDriver();
            driver.get(SERACH_ITEAM_URL);

            List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product-item product-impression']"));
            if(driver.getPageSource().contains("Niestety nie znaleźliśmy tego czego szukasz")) {
                driver.close();
                return "Nie znaleziono przedmiotu";
            }
            else {
                PageFactory.initElements(driver, this);

                //                               Get list of all search products
                //List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product-item product-impression']"));
                for(Integer item=1; item<=productList.size(); item++) {
                    JSONObject o = new JSONObject();

                    //                        Click at the each product and get it's parameters
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement product = driver.findElement(By.xpath("//div[@class='product-list product-list-tiles']/div["+item+"]/a"));
                    product.click();

                    //                               Get NAME of product
                    String name = driver.findElement(By.xpath("//*[contains(@class,'wu42cx-10 eenxIx sc-87ubip-0 kaOsdS')]")).getText();
                    o.put("Nazwa produktu", name);

                    //                               Get PRICE of product
                    String price = driver.findElement(By.xpath("//*[contains(@class,'y67i6l-4 cgNVal')]")).getText();
                    o.put("Cena", price);

                    //                               Get CATEGORY of product
                    String category = driver.findElement(By.xpath("*//*[contains(@class,'k25yhy-9 fbkoGA')]/*[contains(@class,'k25yhy-5 kNQJoO sc-673ayz-1 dwaJTI')]")).getText();
                    o.put("Kategoria", category);

                    //                               Get PARAMETERS of product
                    List<WebElement> paremeterList = driver.findElements(By.xpath("//div[@class='sc-1ogetub-2 enJAZP']/*"));
                    for (int param = 1; param <= paremeterList.size(); param++) {
                        List<WebElement> parametres = driver.findElements(By.xpath("//div[@class='sc-1ogetub-2 enJAZP']/div["+param+"]/div"));
                        o.put(parametres.get(0).getText(), parametres.get(1).getText());
                    }

//                               Save parameters to JSON
                    String fileName = "src\\main\\resources\\files\\product" + item.toString() + ".json";
                    try (Writer file = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);) {
                        file.write(o.toJSONString());
                        file.flush();
                        counter++;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "Liczba wyekstraktowanych rekordów: " + counter;
                    }
                    driver.navigate().back();
                }
                driver.close();
//                return "redirect:/homePage?response="+itemToSearch+"&flag=true";
                return "Liczba wyekstraktowanych rekordów: " + counter;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Liczba wyekstraktowanych rekordów: " + counter;
        }
    }


    @RequestMapping(value = "/transform")
    @ResponseBody
    public String transform(){

        File directory = new File("src\\main\\resources\\files");

        if(directory.listFiles().length==0)
            return "Nie można przeprowadzić operacji transform";

        laptopList.clear();
        ObjectMapper mapper = new ObjectMapper();

        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                JsonNode node = mapper.readTree(file);
                LaptopEntity laptop = new LaptopEntity();

                Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    laptop.setValueByKey(entry.getKey(), entry.getValue().textValue());
                }
                laptopList.add(laptop);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        parameterService.purgeDirectory();
        return "Liczba utworzonych obiektów: " + laptopList.size();
    }

    @RequestMapping(value = "/load")
    @ResponseBody
    public String load(){
        int itemToDatabase = 0;
        if(laptopList.size()==0)
            return "Brak rekordów do załadowania";
        for (LaptopEntity laptop: laptopList) {
            if(parameterService.isLaptop(laptop)) {
                parameterService.addLaptop(laptop);
                itemToDatabase++;
            }
        }
//        parameterService.addLaptops(laptopList);
        int lapSize = laptopList.size();
        parameterService.purgeDirectory();
        laptopList.clear();
        return "Liczba dodanych rekordów do bazy: " + itemToDatabase;
    }


    @RequestMapping(value = "/etl", method = RequestMethod.POST)
    @ResponseBody
    public String etl(@RequestParam("itemToSearch") String itemToSearch){

        System.out.println(itemToSearch);
        ModelAndView mav = new ModelAndView();
        if (itemToSearch.equals("")){
            return "Pole wyszukiwania jest puste";
        }

        extract(itemToSearch);

        if(new File("src\\main\\resources\\files").listFiles().length==0)
            return "Nie znaleziono przedmiotu";
            //return "redirect:/homePage?response=notfound";

        transform();
        String loadAmount;
        loadAmount = load();
        return "Proces ETL zakończono z sukcesem! :) \n"  + loadAmount;
        //return "redirect:/homePage";
    }
}
