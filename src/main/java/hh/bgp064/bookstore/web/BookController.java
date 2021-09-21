package hh.bgp064.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.bgp064.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository; 
	
	@RequestMapping("/index")
	public String hello() {
		return "bookstore";
		
	}
	@RequestMapping(value="/booklist")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
		
	}
	
}
