package data.services;

import data.domain.LaptopEntity;

import java.util.List;

public interface LaptopService {

    void addLaptops(List<LaptopEntity> laptops);
    List<LaptopEntity> getProducts();
    void clearTable();
}
