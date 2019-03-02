package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Student;
import es.salesianos.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping(path = "/student")
	public ModelAndView getStudents() {
		ModelAndView model = new ModelAndView("student");
		model.addObject("listAllStudents", service.selectAllStudent());
		return model;
	}

	@GetMapping(path = "/deleteStudent")
	public String deleteStudent(@RequestParam int cod) {
		service.delete(cod);
		return "index";
	}

	@PostMapping(path = "/insertStudent")
	public String insertStudent(@RequestParam int Cod, @RequestParam String name) {
		Student student = new Student();
		student.setCod(Cod);
		student.setName(name);
		service.insert(student);
		return "index";
	}
}
