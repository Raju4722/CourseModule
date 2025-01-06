package com.praxctice.CouMod.Modules;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxctice.CouMod.Course.CourseEntity;
import com.praxctice.CouMod.Course.CourseRepository;
import com.praxctice.CouMod.Exceptions.usernotfound;

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
		if(byId==null) {
			throw new usernotfound("NOFinding");
		}
	
		int id2 = byId.getId();
         List<ModulesEntity> all = repo.findAll();
         List<ModulesEntity> collect = all.stream().filter(a-> a.getCourse().getId()==id2).collect(Collectors.toList());
         if (collect==null) {
        	 throw new usernotfound("NO finding");
         }
         return collect;
	}
//	public ModulesEntity putmod(int id,ModulesEntity mode) {
//		mode.setCourseid(id);
//		ModulesEntity save = repo.save(mode);
//		return save;
//	}


	public ModulesEntity putmod(int id, ModulesEntity mode) {
	CourseEntity got = repocour.findById(id).orElse(null);
	if(got==null) {
		throw new usernotfound("No such user exist to insert a module");
	}
		   ModulesEntity save = repo.save(new ModulesEntity(mode.getModid(),mode.getModname(),mode.getDuration(),got));
		return save;
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
