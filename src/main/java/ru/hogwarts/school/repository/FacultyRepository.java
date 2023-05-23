package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    @Query("SELECT faculty from Faculty faculty where faculty.color= :color")
    Collection<Faculty> getFacultiesByColor(@Param("color") String color);
}
