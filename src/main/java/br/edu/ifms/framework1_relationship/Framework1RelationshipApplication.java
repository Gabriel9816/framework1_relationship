package br.edu.ifms.framework1_relationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class Framework1RelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(Framework1RelationshipApplication.class, args);
	}
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
