package dat3.car.dto;

import dat3.car.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class ReservationResponse {
    int id;
    int carId;
    String carBrand;
    String model;
    int price;

    LocalDate reservationDate;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.price = reservation.getCar().getPricePrDay();
        this.carId = reservation.getCar().getId();
        this.carBrand = reservation.getCar().getBrand();
        this.model = reservation.getCar().getModel();
        this.reservationDate = reservation.getRentalDate();
    }
}
