package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {
    public static void main(String[] args) {
        // To instanciate the objects we need
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // to use them
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("result is " + metier.calcul());

    }
}
