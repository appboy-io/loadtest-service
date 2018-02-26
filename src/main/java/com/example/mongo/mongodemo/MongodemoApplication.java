package com.example.mongo.mongodemo;

import com.example.mongo.mongodemo.common.Company;
import com.example.mongo.mongodemo.common.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableMongoRepositories
public class MongodemoApplication implements CommandLineRunner {

	public final static Logger logger = LoggerFactory.getLogger(MongodemoApplication.class);

	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		logger.info("Demo Started");
        final Project project = new Project("Project1","First Project");
		final Company company1 = new Company("Company1", "I am the first company", Arrays.asList(project));
		final Company company2 = new Company("Company2", "I am the second company", Collections.emptyList());


		companyRepository.save(company1);
		companyRepository.save(company2);

		logger.info("Finding all companies");
		companyRepository.findAll().stream().forEach(System.out::println);

		logger.info("Finding first company by name");
		Company firstCompany = companyRepository.findByName("Company1");
		logger.info(firstCompany.toString());

		logger.info("Udpdating company and then saving it");
		firstCompany.setName("New Company");
        firstCompany.addProject(project);
		companyRepository.save(firstCompany);

		logger.info("Fetching altered company with new information");
		Company newCompany = companyRepository.findByName("New Company");

		logger.info("Altered company: {}", newCompany);
	}
}