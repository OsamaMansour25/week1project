package dat3.car.repository;

import dat3.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
Car findByBrandAndModel(String brand, String model);
Car findByPricePrDay(int price);
}
