package com.tech.bikemember;

import com.tech.bikemember.model.BikeMember;
import com.tech.bikemember.repository.BikeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BikememberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BikememberApplication.class, args);
		System.out.println("main 실행");

	}
	@Autowired
	private BikeMemberRepository bikeMemberRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("run run");
//		BikeMember bikeMember=new BikeMember();
//		bikeMember.setFirstName("Tom1");
//		bikeMember.setLastName("John1");
//		bikeMember.setEmailID("Tom1@a.com");
//		bikeMemberRepository.save(bikeMember);
	}
}
