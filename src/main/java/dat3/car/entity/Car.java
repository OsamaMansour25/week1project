package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation) {
        if(reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }

    public Car(String brand, String model, int pricePrDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }


}
