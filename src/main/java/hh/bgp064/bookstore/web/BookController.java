package hh.bgp064.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping("/index")
	public String hello() {
		return "bookstore";
		
	}
}
