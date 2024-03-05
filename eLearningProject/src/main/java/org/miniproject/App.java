package org.miniproject;

import org.miniproject.config.BeansConfig;
import org.miniproject.model.Student;
import org.miniproject.service.impl.AnotherBulletinServiceImpl;
import org.miniproject.service.impl.BulletinServiceImpl;
import org.miniproject.service.impl.ThirdBulletinServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        BulletinServiceImpl bulletinService = context.getBean(BulletinServiceImpl.class);
        AnotherBulletinServiceImpl anotherBulletinService = context.getBean(AnotherBulletinServiceImpl.class);
        ThirdBulletinServiceImpl thirdBulletinService = context.getBean(ThirdBulletinServiceImpl.class);

        System.out.println("Bulletin Service Implementation: " + bulletinService.calculatingGrade());
        System.out.println("Another Bulletin Service Implementation: " + anotherBulletinService.calculatingGrade());
        System.out.println("Third Bulletin Service Implementation: " + thirdBulletinService.calculatingGrade());


        context.close();
    }
}
