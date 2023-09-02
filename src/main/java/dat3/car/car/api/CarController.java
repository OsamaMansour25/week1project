package dat3.car.car.api;

import dat3.car.car.dto.CarResponse;
import dat3.car.car.dto.MemberResponse;
import dat3.car.car.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    @GetMapping(path = "/{brand}")
    CarResponse getCarByBrand(@PathVariable String brand) throws Exception {
        return carService.findByBrand(brand);
    }

}
