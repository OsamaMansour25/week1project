package dat3.car.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.car.entity.Car;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //A must for @Builder
@Builder  //I will demo it's purpose in the class
public class CarRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="car_brand", length = 50, nullable = false)
    String brand;
    @Column(name="car_model", length = 60, nullable = false)
    String model;
    @Column(name="rental_price_day")
    int pricePrDay;
    int bestDiscount;

    public static Car getCarRequestEntity(CarRequest c) {
        return new Car(c.getBrand(), c.getModel(), c.getPricePrDay(), c.getBestDiscount());
    }
    public CarRequest(String brand, String model, int pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }
}
