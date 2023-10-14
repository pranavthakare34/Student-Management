package pdt.std.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pdt.std.studentmanagement.entity.Student;
import pdt.std.studentmanagement.repo.Studentmanagementrepo;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
	@Autowired
	private Studentmanagementrepo repo;

	@Override
	public void run(String... args) throws Exception {
		
		Student ref =new Student(1L, "Pranav", "thkarae", "pst@904481");
		
		repo.save(ref);
	}

	

}
