package com.javatraining.jooleprojectteam2;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Repository.ProductRepository;
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


    //section for testing User repository
//    @Bean
//    public CommandLineRunner run(UserRepository repository) {
//        return (args -> {
            //this sends to the database
//            insertUser(repository);

            //this returns an entity count
//            System.out.println(repository.count());

            //this prints all
//            System.out.println(repository.findAll());

            //prints Roles starting with "Man"
//           System.out.println(repository.findByRoleStartingWith("Man"));

            //broken for now, need correct query syntax for user_name
//            System.out.println(repository.findByusernameStartingWith("A"));
//        });
//    }

        //test user table entries
//    private void insertUser (UserRepository repository) {
//        repository.save (new User("Tim", "Manager", "12345", new Date()));
//        repository.save (new User("John", "Director", "23443", new Date()));
//        repository.save (new User("Sally", "Buyer", "23443", new Date()));
//        repository.save (new User("Fred", "Trader", "23443", new Date()));
//        repository.save (new User("Andy", "Bladerunner", "23443", new Date()));
//        repository.save (new User("Albert", "Android", "23443", new Date()));
//
//        }

    //section for testing Product repository
//    @Bean
//    public CommandLineRunner run(ProductRepository repository) {
//        return (args -> {
            //this sends to the database
//            insertProduct(repository);

            //this returns an entity count
//            System.out.println(repository.count());

            //this prints all
//            System.out.println(repository.findAll());

            //prints brand ending with a
//           System.out.println(repository.findByBrandEndingWith("a"));

            //prints certifications that contain p
//            System.out.println(repository.findByCertificationContaining ("p"));

            //broken for now, need correct query syntax for user_name
//            System.out.println(repository.findByusernameStartingWith("A"));
//        });
//    }

        //test product table entries
//        private void insertProduct (ProductRepository repository) {
//            repository.save(new Product(12, 2000, "Honda", "Safe", new Date()));
//            repository.save(new Product(4, 1998, "Buick", "Cheap", new Date()));
//            repository.save(new Product(34, 1998, "BMW", "Expensive", new Date()));
//            repository.save(new Product(7, 1995, "Mazda", "Convertible", new Date()));
//            repository.save(new Product(42, 2013, "Chevy", "Truck", new Date()));
//            repository.save(new Product(14, 2003, "Landrover", "Unreliable", new Date()));
//          }

}