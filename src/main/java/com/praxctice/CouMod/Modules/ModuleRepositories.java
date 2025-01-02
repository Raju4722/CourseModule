package com.praxctice.CouMod.Modules;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praxctice.CouMod.Course.CourseEntity;

public interface ModuleRepositories extends JpaRepository<ModulesEntity, Integer> {
//   List<ModulesEntity> findAll(CourseEntity cour);
//   void deleteByCourse(CourseEntity cour);
}
