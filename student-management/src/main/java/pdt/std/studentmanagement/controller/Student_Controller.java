package pdt.std.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pdt.std.studentmanagement.entity.Student;
import pdt.std.studentmanagement.service.Student_Service;

@Controller
public class Student_Controller {

	
	@Autowired
	private  Student_Service service;

	public Student_Controller(Student_Service service) {
		super();
		this.service = service;
	}
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
	return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return  "create_student";
		
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student", service.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id ,@ModelAttribute("student")Student student ,Model model ) {
		Student existingstuednt=service.getStudentById(id);
		existingstuednt.setId(id);
		existingstuednt.setFirstName(student.getFirstName());
		existingstuednt.setLastName(student.getLastName());
		existingstuednt.setEmail(student.getEmail());
	
	service.updateStudent(existingstuednt);
	return "redirect:/students";
	
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deletebyid(id);
		return "redirect:/students";
		
	}
	
	
	
}
