package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao", "metier", "ext");

        IMetier metier = context.getBean(IMetier.class);
        System.out.println("result is " + metier.calcul());
    }
}
