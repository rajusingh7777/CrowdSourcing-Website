package neu.edu.controller.category;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.service.IdeaCategoryService;
@RestController
@RequestMapping(path="/category")
public class IdeaCategory{
	
	@Autowired
	private IdeaCategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<IdeaCategoryModel> findAll() {
		
		return categoryService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createCategory(
			@RequestBody IdeaCategoryModel ideaCategoryModel) {
		
		ResponseEntity<String> response = new ResponseEntity<String>("Category Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if (categoryService.createCategory( ideaCategoryModel) != null) {
			response = new ResponseEntity<String>("Role Created", HttpStatus.OK);
		}
		return response;
	}


	@RequestMapping(path = "/{categoryId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("categoryId") Integer categoryId) {
		ResponseEntity<?> response = new ResponseEntity<>("Category Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = categoryService.deleteIdeaCategory(categoryId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = "/{categoryId:[0-9]+}/user/{userId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRole(@PathVariable("categoryId") Integer categoryId, @RequestBody @Valid IdeaCategoryModel newIdeaCategory, @PathVariable("userId") Integer userId) {
		ResponseEntity<?> response = new ResponseEntity<>("Category Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = categoryService.updateCategory(categoryId, newIdeaCategory,userId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

}
