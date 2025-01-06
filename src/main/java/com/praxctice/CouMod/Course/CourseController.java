package com.praxctice.CouMod.Course;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class CourseController {
	private CourseService serv;
//	@Autowired
//	private PostgreSQLCONN2 data;
	public CourseController(CourseService serv) {
		super();
		this.serv = serv;
	}

	@GetMapping("courses")
	public List<CourseEntity> GettingAllcourses() {
	
		List<CourseEntity> fetching = serv.fetching();
		return fetching;
	}
	@PostMapping("courses")
	public ResponseEntity<CourseEntity> Inserting(@RequestBody CourseEntity cour) {
		CourseEntity addings = serv.addings(cour);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addings.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@GetMapping("/courses/{id}")
	public CourseEntity getone(@PathVariable int id) {
		return serv.gettingone(id);
	}
	@DeleteMapping("courses/{id}")
	public String getones(@PathVariable int id) {
		 serv.deletingone(id);
		 return "redirect:courses";
	}
}
