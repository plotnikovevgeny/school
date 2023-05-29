package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {

        return studentRepository.findById(id).orElse(null);
    }

    public void removeStudent(Long id) {

        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudentsByAge(Long age) {
        return studentRepository.getStudentsByAge(age);
    }
}
