package dat3.car.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cars")

public class Car extends AdminDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "car_brand", length = 50, nullable = false)
    String brand;
    @Column(name = "car_model", length = 60, nullable = false)
    String model;
    @Column(name = "rental_price_day")
    int pricePrDay;
    @Column(name = "max_discount")
    int bestDiscount;

    public Car(String brand, String model, int pricePrDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }


}
