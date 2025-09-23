package learn.battle;

import learn.battle.environment.Battle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("battle-config.xml");

        Battle battle1 = (Battle) context.getBean("battleCoconut");
        System.out.println("\n--- Battle #1 ----");
        battle1.run();

        Battle battle2 = (Battle) context.getBean("battleDungeon");
        System.out.println("\n--- Battle #2 ----");
        battle2.run();
    }
}
