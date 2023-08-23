package dat3.car.car.repository;

import dat3.car.car.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;
    boolean isInitalized = false;

    @BeforeEach
    void setUp() {
        if (!isInitalized) {
            carRepository.deleteAll();
            carRepository.save(new Car("Toyota", "Corolla", 500, 5));
            carRepository.save(new Car("Chevrolet", "Cruze", 700, 20));
            isInitalized = true;
        }
    }

    @Test
    void findByBrand() {
        Car c1 = carRepository.findByBrand("Toyota");
        assertEquals("Toyota", c1.getBrand());
    }

    @Test
    void findByPricePrDay() {
        Car c2 = carRepository.findByPricePrDay(700);
        assertEquals(700, c2.getPricePrDay());
    }
}