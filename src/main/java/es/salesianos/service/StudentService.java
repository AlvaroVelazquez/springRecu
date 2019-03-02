package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Student;
import es.salesianos.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> selectAllStudent() {
		return repository.selectAllStudent();
	}

	public void insert(Student student) {
		repository.insert(student);
	}

	public void delete(int cod) {
		Student student = new Student();
		student.setCod(cod);
		repository.delete(student);
	}
}
