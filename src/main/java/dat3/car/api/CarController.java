package dat3.car.api;

import dat3.car.dto.CarResponse;
import dat3.car.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/cars")
public class CarController {
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    //Security Admin only
    @GetMapping
    List<CarResponse> getCars(){
        return carService.getCars(false);
    }
    //Security admin
    @GetMapping(path = "/{brand}/{model}")
    CarResponse getCarByBrandAndModel(@PathVariable String brand, String model) throws Exception {
        return carService.findByBrandAndModel(brand, model);
    }

}
