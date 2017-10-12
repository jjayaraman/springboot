package com.jai.springboot.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */
@Controller
@SpringBootApplication
public class App {

	public static void main(String args[]) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	@ResponseBody
	Person helloApi() {
		return new Person("Tom", 23);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Harry", 11));
		persons.add(new Person("Mickey", 121));
		persons.add(new Person("Ravi", 21));
		return persons;
	}

}

class Person {

	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}