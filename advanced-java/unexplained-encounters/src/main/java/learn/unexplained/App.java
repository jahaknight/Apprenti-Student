package learn.unexplained;

import learn.unexplained.ui.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "learn.unexplained")     // finds @Component/@Service/@Repository
@PropertySource("classpath:app.properties")            // loads the encounters.csv.path

public class App {

@Bean
public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
}

public static void main(String[] args) {
        // Load beans from src/main/resources/di.xml
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        // Gets controller bean
        Controller controller = ctx.getBean(Controller.class);
        controller.run();
    }
}

