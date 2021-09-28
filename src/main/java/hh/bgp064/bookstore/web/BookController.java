package hh.bgp064.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.bgp064.bookstore.domain.Book;
import hh.bgp064.bookstore.domain.BookRepository;
import hh.bgp064.bookstore.domain.CatRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CatRepository catRepository;
	
	@RequestMapping("/index")
	public String hello() {
		return "bookstore";
		
	}
	@RequestMapping(value="/booklist")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
		
	}
    @RequestMapping(value = "/addbook")
    public String addBook(Model model){
		model.addAttribute("categories", catRepository.findAll());
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }  
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", bookRepository.findById(bookId).get());
        return "editbook";
    } 
  
}
	
