package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru",1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",4));
      userService.add(new User("User5", "Lastname4", "user4@mail.ru",5));

      carService.addCar(new Car(1,"Mersedes Benz",111, 001));
      carService.addCar(new Car(2,"BMW", 222, 002));
      carService.addCar(new Car(3,"Opel",333, 003));
      carService.addCar(new Car(4,"Porsche",444, 004));
      carService.addCar(new Car(5,"Volkswagen",555, 005));


      List<Car> cars = carService.listCars();
      for (Car car : cars) {
         System.out.println("Id = " + car.getId());
         System.out.println("Name =" + car.getName());
         System.out.println("Car_Number =" + car.getNumber());
         System.out.println("Series = " + car.getSeries());
         System.out.println();
      }

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getName() );
         System.out.println();
      }

      User user = userService.getUserCarByNumberAndSeries(222,002);
      System.out.println(user.getFirstName());
      context.close();
   }
}