package data.repositories;

import data.domain.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends JpaRepository<LaptopEntity,Integer> {

    LaptopEntity getLaptopEntityByNazwaProduktu(String nazwaProduktu);
    LaptopEntity getLaptopEntityById(Integer id);
}
