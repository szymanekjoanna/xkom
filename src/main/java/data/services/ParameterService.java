package data.services;

import data.domain.LaptopEntity;
import data.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
public class ParameterService implements LaptopService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addLaptops(List<LaptopEntity> laptops) {
        laptops.forEach(e -> laptopRepository.save(e));
    }

    public List<LaptopEntity> getProducts() {
        return laptopRepository.findAll();
    }

    public void clearTable() {
        laptopRepository.deleteAll();
    }

    public LaptopEntity getProductByName(String name){
        return laptopRepository.getLaptopEntityByNazwaProduktu(name);
    }

    public LaptopEntity getProductById(Integer id){
        return laptopRepository.getLaptopEntityById(id);
    }

    public static void writeToCSV(List<LaptopEntity> productList) {
        String CSV_SEPARATOR = "|";
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\main\\resources\\textFiles\\products.csv"), "UTF-8"));
            for (LaptopEntity product : productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(product.getId() <=0 ? "" : product.getId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getNazwaProduktu().trim().length() == 0? "" : product.getNazwaProduktu());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getCena().trim().length() == 0? "" : product.getCena());
                oneLine.append(CSV_SEPARATOR);
                //oneLine.append(product.getSzerokosc().trim().length() == 0? "" : product.getSzerokosc());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "src\\main\\resources\\textFiles\\products.csv");
            pb.environment().put("LANG", "pl.UTF-8");
            pb.start();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    public static void purgeDirectory() {
        Arrays.stream(new File("src\\main\\resources\\files\\").listFiles()).forEach(File::delete);
    }

    public void updateProduct(Integer id, String nazwaProduktu, String cena, String kategoria,
                              String procesor, String bateria, String waga, String szerokosc) {

        if(!laptopRepository.exists(id)){
            throw new IllegalArgumentException("Komentarz nie istnieje!");
        }
        String sql = "UPDATE products set nazwa_produktu="+ "'" +nazwaProduktu + "'" +
                                        ",cena="+"'" +cena + "'" +
                                        ",kategoria="+ "'" +kategoria + "'" +
                                        ",procesor="+ "'" +procesor + "'" +
                                        ",bateria="+ "'" +bateria + "'" +
                                        ",waga="+ "'" +waga + "'" +
                                        ",szerokosc="+ "'" +szerokosc + "'" +
                    "WHERE id="+id;
        jdbcTemplate.update(sql);
    }

    public boolean isLaptop(LaptopEntity laptop){
        if(laptopRepository.getLaptopEntityByNazwaProduktu(laptop.getNazwaProduktu()) != null){
            return false;
        }
        return true;
    }

    public void addLaptop(LaptopEntity laptop) {
        laptopRepository.save(laptop);
    }
}
