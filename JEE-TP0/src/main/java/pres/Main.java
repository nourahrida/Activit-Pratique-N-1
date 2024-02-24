package pres;

import dao.IDao;
import metier.IMetier;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // LoadBalancer
//        MetierImpl m = new MetierImpl(new DaoImpl());
//        MetierImpl m1 = m;
//        System.out.println(m1.calcul());
//        m1.setDao(new DaoImplSecondary());
//        System.out.println(m1.calcul());
//        MetierImpl m2 = new MetierImpl(new DaoImplSecondary());
//        System.out.println(m2.calcul());
//        System.out.println("Hello world!");
        Scanner s = new Scanner(new File("C:\\Users\\Pro\\IdeaProjects\\JEE-TP01\\src\\config.txt"));
        String docClassName = s.nextLine();
        Class cDao = Class.forName(docClassName);
        IDao dao = (IDao) cDao.newInstance();


        String docClassNameMetier = s.nextLine();
        Class cMetier = Class.forName(docClassNameMetier);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao", IDao.class);
        method.invoke(metier, dao);

        System.out.println("result is " + metier.calcul());
    }
}