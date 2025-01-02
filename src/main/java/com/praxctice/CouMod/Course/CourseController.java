package com.praxctice.CouMod.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	private CourseService serv;

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
	public CourseEntity Inserting(@RequestBody CourseEntity cour) {
		CourseEntity addings = serv.addings(cour);
		return addings;
	}
	@GetMapping("/courses/{id}")
	public Optional<CourseEntity> getone(@PathVariable int id) {
		return serv.gettingone(id);
	}
	@DeleteMapping("courses/{id}")
	public String getones(@PathVariable int id) {
		 serv.deletingone(id);
		 return "redirect:courses";
	}
}
