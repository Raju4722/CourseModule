package com.praxctice.CouMod.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
//    CourseEntity findByName(String coursename);
}
