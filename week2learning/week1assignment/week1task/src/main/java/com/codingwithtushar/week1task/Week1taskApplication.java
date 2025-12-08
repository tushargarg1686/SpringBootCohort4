package com.codingwithtushar.week1task;

import com.codingwithtushar.week1task.baker.CakeBaker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week1taskApplication implements CommandLineRunner {
	private final CakeBaker cakeBaker;

    public Week1taskApplication(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }

    public static void main(String[] args) {
		SpringApplication.run(Week1taskApplication.class, args);
		System.out.println("week1task application is running");
	}

	@Override
	public void run(String... args) throws Exception {
		//cakeBaker.bakeCake();
	}
}
