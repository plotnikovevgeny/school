package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedId = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++generatedId);
        faculties.put(generatedId, faculty);
        return faculty;
    }

    public Faculty editFaculty(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty getFaculty(Long id) {
        return faculties.get(id);
    }

    public Faculty removeFaculty(Long id) {
        return faculties.remove(id);
    }
}
