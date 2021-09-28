package hh.bgp064.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.bgp064.bookstore.domain.Book;
import hh.bgp064.bookstore.domain.CatRepository;
import hh.bgp064.bookstore.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private CatRepository categoryRepository; 
	
	@RequestMapping(value="/categorylist")
		public String getCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addcategory")
		public String addCategory(Model model){
		model.addAttribute("category", new Category());
		return "addcategory";
}     

	@RequestMapping(value = "/saveCat", method = RequestMethod.POST)
		public String save(Category cat){
		categoryRepository.save(cat);
		return "redirect:categorylist";
}   
}
