
package dat3.car.entity;


import dat3.security.entity.UserWithRoles;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles {

    String firstName;
    String lastName;
    String street;
    String city;
    String zip;
    boolean approved;
    int ranking;
    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation) {
        if(reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }

    public Member(String username, String password, String email, String firstName, String lastName, String street,
                  String city, String zip) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
