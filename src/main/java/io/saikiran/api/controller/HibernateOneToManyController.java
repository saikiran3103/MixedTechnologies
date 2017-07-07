package io.saikiran.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.saikiran.api.entity.BookCategory;
import io.saikiran.api.repository.BookCategoryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "books")
@Api(tags = "Books")
public class HibernateOneToManyController {

	
	   
	    private BookCategoryRepository bookCategoryRepository;
	    
	    public HibernateOneToManyController(BookCategoryRepository service) {
			this.bookCategoryRepository = service;
		}
	    
	    
	    
	    @RequestMapping(method = RequestMethod.POST)
		@ApiOperation(value = "Create Book Category", notes = "Creates a book category in the DB")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 500, message = "Internal Server Error"), })
		public  BookCategory create(@RequestBody BookCategory bookCategory) {
			return bookCategoryRepository.save(bookCategory);
		}
	    
	    
	    
	    
	    
	    @RequestMapping(method = RequestMethod.GET)
		@ApiOperation(value = "Find All Book Categories", notes = "Returns a list of Book Categories in the app")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
				@ApiResponse(code = 500, message = "Internal Server Error"), })
		public List<BookCategory> findAll() {
			return bookCategoryRepository.findAll();
		}
}
