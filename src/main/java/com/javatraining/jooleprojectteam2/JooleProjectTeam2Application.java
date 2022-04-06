package com.javatraining.jooleprojectteam2;

import com.javatraining.jooleprojectteam2.Entity.*;
import com.javatraining.jooleprojectteam2.Repository.ProductRepository;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import com.javatraining.jooleprojectteam2.Repository.ProjectRepository;
import com.javatraining.jooleprojectteam2.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JooleProjectTeam2Application {

    public static void main(String[] args) {
        SpringApplication.run(JooleProjectTeam2Application.class, args);
    }


//    section for testing User repository
//    @Bean
//    public CommandLineRunner run(UserRepository repository) {
//        return (args -> {
//            this sends to the database
//            insertUser(repository);

//            this returns an entity count
//            System.out.println(repository.count());

//            this prints all
//            System.out.println(repository.findAll());

//            prints Roles starting with "Man"
//           System.out.println(repository.findByRoleStartingWith("Man"));

//            prints users with userNames starting with 'A'
//            System.out.println(repository.findByUserNameStartingWith("A"))

//          prints users with userNames that contain the substring "al" in any case
//            System.out.println(repository.findByUserNameContainsIgnoreCase("al"));

//        });
//    }

//        test user table entries
//    private void insertUser (UserRepository repository) {
//        repository.save (new User("Tim", "Manager", "12345"));
//        repository.save (new User("John", "Director", "23443"));
//        repository.save (new User("Sally", "Buyer", "23443"));
//        repository.save (new User("Fred", "Trader", "23443"));
//        repository.save (new User("Andy", "Bladerunner", "23443"));
//        repository.save (new User("Albert", "Android", "23443"));
//
//        }

//    section for testing Product repository
//    @Bean
//    public CommandLineRunner run(ProductRepository repository) {
//        return (args -> {
//            //this sends to the database
//            insertProduct(repository);
//
//            //this returns an entity count
////            System.out.println(repository.count());
//
//            //this prints all
//            System.out.println(repository.findAll());
//
//////            prints product with brand ending with 'a'
////           System.out.println(repository.findByBrandEndingWith("a"));
////
//////            prints product with certifications that contain 'p'
////            System.out.println(repository.findByCertificationContaining ("p"));
////
//////            prints products with modelYear greater than 2000
////            System.out.println(repository.findByModelYearGreaterThan(2000));
//        });
//    }
//
////        test product table entries
//        private void insertProduct (ProductRepository repository) {
//            repository.save(new Product(MechanicalDetail.MECHANICAL, 2000, "Honda", "Safe"));
//            repository.save(new Product(MechanicalDetail.MECHANICAL, 1998, "Buick", "Cheap"));
//            repository.save(new Product(MechanicalDetail.ELECTRONICAL, 1998, "BMW", "Expensive"));
//            repository.save(new Product(MechanicalDetail.ELECTRONICAL, 1995, "Mazda", "Convertible"));
//            repository.save(new Product(MechanicalDetail.MECHANICAL, 2013, "Chevy", "Truck"));
//            repository.save(new Product(MechanicalDetail.MECHANICAL, 2003, "Landrover", "Unreliable"));
//          }


    //section for testing Project repository
//        @Bean
//            public CommandLineRunner run(ProjectRepository repository) {
//                return (args -> {
    //this sends to the database
//                insertProject(repository);

    //this returns an entity count
//            System.out.println(repository.count());

    //this prints all
//            System.out.println(repository.findAll());

    //prints projects that contain a User object that has userName "Norbert"
//          System.out.println(repository.findByUser_UserName ("Norbert"));
//        });
//    }
    //test project table entries
//    private void insertProject (ProjectRepository repository) {
//            repository.save(new Project(new User("Frank", "Builder", "12345")));
//            repository.save(new Project(new User("Norbert", "Oligarch", "23443")));
//            repository.save(new Project(new User("Fernando", "Fencer", "23443")));
//            repository.save(new Project(new User("Philip", "Astronaut", "23443")));
//          }

    //section for testing ProjectProduct repository
//    @Bean
//    public CommandLineRunner run(ProjectProductRepository repository) {
//        return (args -> {
//            //this sends to the database
//            insertProjectProduct(repository);

            //this returns an entity count
//            System.out.println(repository.count());

            //this prints all
//            System.out.println(repository.findAll());

            //prints ProjectProduct that contain a Product that has Brand which contains "x"
//          System.out.println(repository.findByProduct_BrandContains ("x"));
//        });
//    }
    //test project table entries
//    private void insertProjectProduct (ProjectProductRepository repository) {
//            repository.save(new ProjectProduct(new Project(new User("Roger", "Rabbit", "12345")), new Product(MechanicalDetail.MECHANICAL, 1998, "Batmobile", "Fast")));
//        repository.save(new ProjectProduct(new Project(new User("James", "King", "12345")), new Product(MechanicalDetail.MECHANICAL, 1598, "Chariot", "Classy")));
//        repository.save(new ProjectProduct(new Project(new User("Mars", "Deity", "12345")), new Product(MechanicalDetail.MECHANICAL, 2000, "Horse", "Smelly")));
//        repository.save(new ProjectProduct(new Project(new User("Luke", "Skywalker", "12345")), new Product(MechanicalDetail.MECHANICAL, 3000, "x-wing", "Maneuverable")));
//
//    }

}


