package br.edu.ifms.framework1_relationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/") // caminho
public class Framework1RelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(Framework1RelationshipApplication.class, args);
	}
	@GetMapping("/")
    public String index() {
        return "HomeScreen";
    }
	@GetMapping("/cadHome")
    public String cadHome() {
        return "cadHome";
    }
	@GetMapping("/listHome")
    public String listHome() {
        return "listHome";
    }
    @GetMapping("/errorPage")
    public String errorPage() {
        return "errorPage";
    }
}
