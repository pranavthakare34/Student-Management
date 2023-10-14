package pdt.std.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pdt.std.studentmanagement.entity.Student;
import pdt.std.studentmanagement.repo.Studentmanagementrepo;

@Service
public class Student_Service {

	@Autowired
	private Studentmanagementrepo repo;
	
	public List<Student> getAllStudents(){
		return repo.findAll();
	}

	public Student_Service(Studentmanagementrepo repo) {
		super();
		this.repo = repo;
	}
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	public Student getStudentById(Long id) {
		return repo.findById(id).get();
	}
	
	public Student updateStudent(Student student) {
		return repo.save(student);
	}
	
	
	public void deletebyid(Long id) {
		repo.deleteById(id);
	}
	
}
