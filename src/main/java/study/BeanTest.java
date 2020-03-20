package study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BeanTest {



    void f(){
        System.out.println("heihei");
    }

}
//@SpringBootApplication
class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
      //  ApplicationContext context1 = SpringApplication.run(Main.class,args);
        ApplicationContext context1 = new AnnotationConfigApplicationContext("study");
     //   String[] names = context1.getBeanDefinitionNames();



        BeanTest bean1 = (BeanTest) context1.getBean("beanTest");
        bean1.f();
        System.out.println(context1.getBeanDefinitionCount());



    }
}
