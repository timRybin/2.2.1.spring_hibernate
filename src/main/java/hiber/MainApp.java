package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Pobeda", 1)));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Niva", 2)));
//        userService.add(new User("User5", "Lastname5", "user5@mail.ru"));
//        userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("Zhiguli", 3)));
//        userService.add(new User("User7", "Lastname7", "user7@mail.ru"));
//        userService.add(new User("User8", "Lastname8", "user8@mail.ru", new Car("Volga", 4)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }

        User user2 = userService.getUserByCar("Pobeda", 1);
        System.out.println(user2);

        User user4 = userService.getUserByCar("Niva", 2);
        System.out.println(user4);

        User user6 = userService.getUserByCar("Zhiguli", 3);
        System.out.println(user6);

        User user8 = userService.getUserByCar("Volga", 4);
        System.out.println(user8);

        context.close();
    }
}
