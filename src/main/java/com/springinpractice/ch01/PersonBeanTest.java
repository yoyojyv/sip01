package com.springinpractice.ch01;

import com.springinpractice.ch01.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonBeanTest {

  private static final Logger logger = LoggerFactory.getLogger(PersonBeanTest.class);

  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    Person jaeyong = context.getBean("jaeyongAsPerson", Person.class);
    Person other = context.getBean("anotherPerson", Person.class);
    Person other2 = context.getBean("anotherPerson2", Person.class);


    Person jaeyong2 = context.getBean("jaeyongAsPerson", Person.class);

    System.out.println(jaeyong);
    System.out.println(other);

    System.out.println(jaeyong2);
    System.out.println(other2);



    System.out.println(jaeyong == jaeyong2);

  }

}
