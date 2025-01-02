package com.praxctice.CouMod.Modules;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxctice.CouMod.Course.CourseEntity;
import com.praxctice.CouMod.Course.CourseRepository;

@Service
public class ModuleService {
	public ModuleService() {}
	@Autowired
	private ModuleRepositories repo;
	@Autowired
	private CourseRepository repocour;
    public ModuleService(ModuleRepositories repo,CourseRepository repocour) {	
		this.repo = repo;
		this.repocour = repocour;
		
	}
	
    
	public List<ModulesEntity> getone(int id) {
		CourseEntity byId = repocour.findById(id).orElse(null);
		
	
		int id2 = byId.getId();
         List<ModulesEntity> all = repo.findAll();
         List<ModulesEntity> collect = all.stream().filter(a-> a.getCourse().getId()==id2).collect(Collectors.toList());
         return collect;
	}
//	public ModulesEntity putmod(int id,ModulesEntity mode) {
//		mode.setCourseid(id);
//		ModulesEntity save = repo.save(mode);
//		return save;
//	}


	public ModulesEntity putmod(int id, ModulesEntity mode) {
		 CourseEntity got = repocour.getById(id);
		   repo.save(new ModulesEntity(mode.getModid(),mode.getModname(),mode.getDuration(),got));
		return null;
	}


	public void deleteallmodules(int id) {
        List<ModulesEntity> all = repo.findAll();
        List<ModulesEntity> collect = all.stream().filter(a-> a.getCourse().getId()==id).collect(Collectors.toList());
        Iterator<ModulesEntity> ab=collect.iterator();
        while(ab.hasNext()) {
        	ModulesEntity next = ab.next();
        	repo.deleteById(next.getModid());
        }
        
	}

}
