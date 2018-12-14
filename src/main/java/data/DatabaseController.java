package data;

import data.domain.LaptopEntity;
import data.services.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.List;

@Controller
public class DatabaseController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ParameterService parameterService;

    @RequestMapping("/database")
    public String showDatabase(ModelMap modelMap) {
        try {
            modelMap.addAttribute("products", parameterService.getProducts());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "database";
    }

    @RequestMapping("/deleteDatabase")
    public String deleteDatabase(ModelMap modelMap) {
        parameterService.clearTable();
        return "redirect:/database";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    @ResponseBody
    public String updateProduct(@ModelAttribute("id") Integer id,
                                @ModelAttribute("nazwaProduktu") String nazwaProduktu,
                                @ModelAttribute("cena") String cena,
                                @ModelAttribute("kategoria") String kategoria,
                                @ModelAttribute("procesor") String procesor,
                                @ModelAttribute("bateria") String bateria,
                                @ModelAttribute("waga") String waga,
                                @ModelAttribute("szerokosc") String szerokosc,
                           ModelMap modelMap) {
        parameterService.updateProduct(id,nazwaProduktu,cena,kategoria,procesor,bateria,waga,szerokosc);
        return "Zupdatowano produkt";
    }

    @RequestMapping(value = "/createTxtFile/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String createTxtFile(@PathVariable("id") Integer id){
        LaptopEntity laptop = parameterService.getProductById(id);
        try{
            File file = new File("src\\main\\resources\\textFiles\\product"+id+".txt");
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(laptop.toString());
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "src\\main\\resources\\textFiles\\product"+id+".txt");
            pb.environment().put("LANG", "pl.UTF-8");
            pb.start();
            o.close();
            f.close();
            return "Wygerenrowano nowy plik .txt";
        } catch (Exception e) {
            e.printStackTrace();
            return "Nie udalo sie wygenerowac pliku .txt";
        }
    }

    @RequestMapping("/generateCsv")
    public String generateCsvFile() {
        List<LaptopEntity> laptops = parameterService.getProducts();
        parameterService.writeToCSV(laptops);
        return "redirect:/database";
    }
}
