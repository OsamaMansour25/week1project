package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {
    CarRepository carRepository;
    MemberRepository memberRepository;
    ReservationRepository reservationRepository;

    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Car> cars = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        // Setup car data
        cars.add(new Car("Toyota", "Corolla", 500, 5));
        cars.add(new Car("Honda", "Civic", 600, 10));
        cars.add(new Car("Ford", "Focus", 450, 15));
        cars.add(new Car("Chevrolet", "Cruze", 700, 20));
        cars.add(new Car("Volkswagen", "Golf", 550, 25));
        cars.add(new Car("Audi", "A4", 800, 30));
        cars.add(new Car("BMW", "3 Series", 900, 35));
        cars.add(new Car("Mercedes-Benz", "C-Class", 750, 40));
        cars.add(new Car("Hyundai", "Elantra", 400, 45));
        cars.add(new Car("Kia", "Optima", 650, 2));
        cars.add(new Car("Nissan", "Altima", 550, 5));
        cars.add(new Car("Mazda", "3", 600, 10));
        cars.add(new Car("Subaru", "Impreza", 450, 15));
        cars.add(new Car("Mitsubishi", "Lancer", 700, 20));
        cars.add(new Car("Volvo", "S60", 550, 25));
        cars.add(new Car("Jaguar", "XE", 800, 30));
        cars.add(new Car("Land Rover", "Discovery", 900, 35));
        cars.add(new Car("Lexus", "ES", 750, 40));
        cars.add(new Car("Acura", "TLX", 400, 45));
        cars.add(new Car("Infiniti", "Q50", 650, 2));
        cars.add(new Car("Porsche", "Panamera", 850, 5));
        cars.add(new Car("Ferrari", "488 GTB", 1000, 10));
        cars.add(new Car("Lamborghini", "Huracan", 1200, 15));
        cars.add(new Car("McLaren", "720S", 1100, 20));
        cars.add(new Car("Bugatti", "Chiron", 1500, 25));
        cars.add(new Car("Koenigsegg", "Jesko", 1400, 30));
        cars.add(new Car("Pagani", "Huayra", 1300, 35));
        cars.add(new Car("Maserati", "Quattroporte", 900, 40));
        cars.add(new Car("Alfa Romeo", "Giulia", 800, 45));
        cars.add(new Car("Rolls-Royce", "Phantom", 2000, 2));
        cars.add(new Car("Bentley", "Continental GT", 1800, 5));
        cars.add(new Car("Aston Martin", "DB11", 1600, 10));
        cars.add(new Car("Lotus", "Evora", 1400, 15));
        cars.add(new Car("Tesla", "Model S", 1200, 20));
        cars.add(new Car("Ford", "Mustang", 1000, 25));
        cars.add(new Car("Chevrolet", "Camaro", 900, 30));
        cars.add(new Car("Dodge", "Challenger", 1100, 35));
        cars.add(new Car("Jeep", "Wrangler", 800, 40));
        cars.add(new Car("GMC", "Sierra", 700, 45));
        cars.add(new Car("Ram", "1500", 750, 2));
        cars.add(new Car("Toyota", "Tundra", 850, 5));
        cars.add(new Car("Nissan", "Titan", 950, 10));
        cars.add(new Car("Honda", "Ridgeline", 800, 15));
        cars.add(new Car("Chevrolet", "Silverado", 900, 20));
        cars.add(new Car("Ford", "Ranger", 750, 25));
        cars.add(new Car("Dodge", "Ram 1500", 700, 30));
        cars.add(new Car("GMC", "Canyon", 650, 35));
        cars.add(new Car("Nissan", "Frontier", 600, 40));
        cars.add(new Car("Toyota", "Tacoma", 550, 45));
        cars.add(new Car("Mitsubishi", "Outlander", 500, 2));
        Car car1 = new Car("Mitsubishi", "Outlander", 500, 2);
        cars.add(car1);
        carRepository.saveAll(cars);


        Member member1 = new Member("user1", "password1", "user1@example.com", "John", "Doe", "123 Main St", "City1", "12345");
        members.add(member1);
        Member member2 = new Member("user2", "password2", "user2@example.com", "Jane", "Smith", "456 Elm St", "City2", "67890");
        members.add(new Member("user2", "password2", "user2@example.com", "Jane", "Smith", "456 Elm St", "City2", "67890"));
        members.add(new Member("user3", "password3", "user3@example.com", "Michael", "Johnson", "789 Oak St", "City3", "13579"));
        members.add(new Member("user4", "password4", "user4@example.com", "Emily", "Williams", "987 Maple St", "City4", "24680"));
        members.add(new Member("user5", "password5", "user5@example.com", "David", "Brown", "654 Pine St", "City5", "98765"));
        memberRepository.saveAll(members);

        LocalDate date = LocalDate.now().plusDays(2);
        LocalDate date2 = LocalDate.of(2024, 05, 03);
        Reservation r1 = new Reservation(date, car1, member1);
        Reservation r2 = new Reservation(date2, car1, member2);
        reservationRepository.save(r1);
        reservationRepository.save(r2);
        System.out.println(car1.getReservations().size() + "size");
        System.out.println(reservationRepository.existsByCar_IdAndRentalDate(51, date2));

        setupUserWithRoleUsers();

    }

    @Autowired
    UserWithRolesRepository userWithRolesRepository;

    final String passwordUsedByAll = "test12";

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {

        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user11", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user22", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user33", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user44", passwordUsedByAll, "user4@a.dk");
        Member member23 = new Member("user23", passwordUsedByAll, "user23@a.dk","David", "Brown", "654 Pine St", "City5", "98765");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        user4.addRole(Role.USER);
        member23.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
        userWithRolesRepository.save(member23);

    }

}
