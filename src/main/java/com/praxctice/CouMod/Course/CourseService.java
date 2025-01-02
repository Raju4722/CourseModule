package com.praxctice.CouMod.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxctice.CouMod.Modules.ModuleRepositories;
import com.praxctice.CouMod.Modules.ModuleService;

@Service
public class CourseService {
	private CourseRepository repo;
	@Autowired
	private ModuleService servs;
	public CourseService(CourseRepository repo) {
		super();
		this.repo = repo;
	}


	
    public List<CourseEntity> fetching(){
    	List<CourseEntity> all = repo.findAll();
    	return all;
    }



	public CourseEntity addings(CourseEntity cour) {
		CourseEntity save = repo.save(cour);
		return save;
	}
	public Optional<CourseEntity> gettingone(int id) {
		 if(repo.findById(id)!=null) {
			 return repo.findById(id);
		 }
		 return null;
	}



	public void deletingone(int id) {
		servs.deleteallmodules(id);
		repo.deleteById(id);
		
	}
}
