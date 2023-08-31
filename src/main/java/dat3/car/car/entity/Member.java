
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
@Table(name = "Members")
public class Member extends AdminDetails {
    @Id
    String username;
    String password;
    String email;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;
    boolean approved;
    int ranking;

    public Member(String username, String password, String email, String firstName, String lastName, String street,
    String city, String zip) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
