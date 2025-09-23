package learn.unexplained;

import learn.unexplained.ui.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load beans from src/main/resources/di.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di.xml");

        // Gets controller bean
        Controller controller = ctx.getBean("controller", Controller.class);
        controller.run();
    }
}

