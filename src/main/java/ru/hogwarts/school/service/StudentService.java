package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long generatedId = 0L;

    public Student createStudent(Student student) {
        student.setId(++generatedId);
        students.put(generatedId, student);
        return student;
    }

    public Student editStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student getStudent(Long id) {
        return students.get(id);
    }

    public Student removeStudent(Long id) {
        return students.remove(id);
    }
}