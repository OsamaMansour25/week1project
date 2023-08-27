The idea with, and reasons for why to use a ORM-Mapper:
ORM-Mapping provides a way to automate the process of mapping database tables by using annotations in our program provided by our framework.

The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected:
JPA is a specification that defines a set of interfaces and annotations for ORM in Java.
Hibernate is an implementation of the JPA specification that provides the functionality for mapping Java objects to database tables.
Spring Data JPA is built in top of JPA and provides a simplified programming model for database interactions.
JPA provides a standardized API for working with object-relational mapping in Java. Hibernate is a implementation of the specification (JPA) with addtional features. Spring Data JPA is a spring-based project that furthere simplifies database access by integrating with JPA which typically is Hibernate.

How to create simple Java entities and map them to the database via the Spring Data API:
Create a interface that extends with JpaRepository and then use the @Entity annotation.

How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it:
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;

How to use and define repositories and relevant query methods using Spring Data JPAs repository pattern
Make interface that extends with JpaRepository. Spring Data JPA comes with CRUD operations. public interface CarRepository extends JpaRepository<Car, Integer> {
Car findByBrand(String brand);
Car findByPricePrDay(int price);
}

How to write simple "integration" tests, using H2 as a mock-database instead of MySQL
Use @DataJpaTest

How to add (dev) connection details for you local MySQL database:
By editing the configuration setting in the application