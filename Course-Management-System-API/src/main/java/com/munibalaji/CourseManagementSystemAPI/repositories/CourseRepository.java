package com.munibalaji.CourseManagementSystemAPI.repositories;

import com.munibalaji.CourseManagementSystemAPI.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
