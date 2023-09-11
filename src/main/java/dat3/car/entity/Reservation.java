package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation extends AdminDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private LocalDate rentalDate;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Member member;

    public Reservation(LocalDate rentalDate, Car car, Member member) {
        this.rentalDate = rentalDate;
        this.car = car;
        this.member = member;
        car.addReservation(this);
        member.addReservation(this);
    }
}
