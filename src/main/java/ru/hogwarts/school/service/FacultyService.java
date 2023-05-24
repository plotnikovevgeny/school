package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (faculties.containsValue(faculty)) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty getFaculty(Long id) {
        return faculties.get(id);
    }

    public Faculty removeFaculty(Long id) {
        return faculties.remove(id);
    }

    public Collection<Faculty> getFacultiesByColor(String color) {
        return faculties.values().stream().filter(faculty -> faculty.getColor().equals(color)).collect(Collectors.toList());
    }
}
