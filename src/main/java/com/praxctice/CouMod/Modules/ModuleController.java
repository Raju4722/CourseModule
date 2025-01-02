package com.praxctice.CouMod.Modules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleController {
	@Autowired
	private ModuleService serv;
	public ModuleController() {}
	public ModuleController(ModuleService serv) {
		super();
		this.serv = serv;
	}
	
   @GetMapping("/courses/modules/{id}")
   public List<ModulesEntity> gettiigone(@PathVariable int id){
	   return serv.getone(id);
   }
   @PostMapping("/courses/modules/{id}")
   public ModulesEntity puttingsall(@RequestBody ModulesEntity mode,@PathVariable int id){
	  
	   return serv.putmod(id,mode);
   }
}
