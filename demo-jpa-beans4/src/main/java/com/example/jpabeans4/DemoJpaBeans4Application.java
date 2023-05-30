package com.example.jpabeans4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoJpaBeans4Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaBeans4Application.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(MyConfig.class);

		ctx.refresh();

		HelloWorld obj1 = ctx.getBean(HelloWorld.class);

		obj1.setMsg("This is an object");
		obj1.setData("12345");

		HelloWorld obj = ctx.getBean(HelloWorld.class);

		/*obj.setMsg("This is an object");
		obj.setData("12345");*/

		System.out.println(obj1);
		System.out.println(obj);

	}

}
