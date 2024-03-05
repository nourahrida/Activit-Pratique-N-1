    package org.miniproject.config;

    import org.miniproject.service.impl.AnotherBulletinServiceImpl;
    import org.miniproject.service.impl.BulletinServiceImpl;
    import org.miniproject.service.impl.ThirdBulletinServiceImpl;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    public class BeansConfig {
        @Bean
        public BulletinServiceImpl bulletinServiceImpl(){
            return new BulletinServiceImpl();
        }
        @Bean
        public AnotherBulletinServiceImpl anotherBulletinServiceImpl(){
            return new AnotherBulletinServiceImpl();
        }
        @Bean
        public ThirdBulletinServiceImpl thirdBulletinServiceImpl(){
            return new ThirdBulletinServiceImpl();
        }
    }
