package hh.bgp064.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.bgp064.bookstore.domain.CatRepository;
import hh.bgp064.bookstore.domain.Category;

@CrossOrigin
@Controller
public class CategoryController {

	@Autowired
	private CatRepository categoryRepository; 
	
	// RESTful service to get all departments
    @RequestMapping(value="/categories", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategoriesRest() {	
        return (List<Category>) categoryRepository.findAll();
    }    

	// RESTful service to get department by id
    @RequestMapping(value="/categories/{categoryid}", method = RequestMethod.GET)
    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("categoryid") Long dId) {	
    	return categoryRepository.findById(dId);
    } 
    
	
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
