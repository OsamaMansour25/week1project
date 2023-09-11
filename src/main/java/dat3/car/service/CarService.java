package dat3.car.service;

import dat3.car.dto.CarResponse;
import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {
    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<CarResponse> getCars(boolean includeAll) {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(car -> new CarResponse(car, includeAll)).toList();
    }
    public CarResponse findByBrandAndModel(String brand, String model) {
        Car car = carRepository.findByBrandAndModel(brand, model);
                if(car == null) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with this brand does not exist");
                }
        return new CarResponse(car, true);
    }
}
