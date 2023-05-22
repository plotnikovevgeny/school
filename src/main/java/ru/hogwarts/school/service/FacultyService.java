package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedId = 1L;

    public Faculty createStudent(Faculty faculty) {
        faculties.put(generatedId, faculty);
        generatedId++;
        return faculty;
    }

    public Faculty editStudent(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty getStudent(Long id) {
        return faculties.get(id);
    }

    public Faculty removeStudent(Long id) {
        return faculties.remove(id);
    }
}
