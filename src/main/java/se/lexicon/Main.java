package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.util.UserInputService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inversion of Control and Dependency injection in Spring");
//        System.out.println("Hello Jean-Pierre");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);

    }
}