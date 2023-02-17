package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/index")
	public String Bookstore() {
		return "index";
	}
	
	@RequestMapping(value = {"/booklist", "/"} )
	//@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") long id, Model model) {
    	bookRepository.deleteById(id);
        return "redirect:../booklist";
    }     
    
    @GetMapping("/add")
    public String newBook(Model model) {
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", categoryRepository.findAll());
    	return "addbook";
    }  
    
    @PostMapping("/save")
    public String save(Book book, Model model) {
    	bookRepository.save(book);
    	return "redirect:/booklist";
    }
    
    @GetMapping("editbook/{id}")
	public String editbook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editbook", bookRepository.findById(id));
		return "editbook";
	}
    

}