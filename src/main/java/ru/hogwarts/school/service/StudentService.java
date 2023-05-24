package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (students.containsValue(student)) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student getStudent(Long id) {
        return students.get(id);
    }

    public Student removeStudent(Long id) {
        return students.remove(id);
    }

    public Collection<Student> getStudentsByAge(Integer age) {
        return students.values().stream().filter(student -> student.getAge().equals(age)).collect(Collectors.toList());
    }
}
