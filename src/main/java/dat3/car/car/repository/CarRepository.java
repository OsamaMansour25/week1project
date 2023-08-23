package dat3.car.car.repository;

import dat3.car.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
Car findByBrand(String brand);
Car findByPricePrDay(int price);
}
