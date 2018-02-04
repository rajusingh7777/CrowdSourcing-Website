package neu.edu.controller.user;

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

import neu.edu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping(method = RequestMethod.POST,path="/register/")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserCreation userCreation) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("User Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		UserModel userProfile = null;
		if ((userProfile = userService.createUser(userCreation)) != null) {
			responseEntity = new ResponseEntity<>(userProfile, HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(path = "/{userId}/role", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserRole(@NotNull @PathVariable("userId") Integer userId,
			@RequestBody UserModel userModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("User(role) updated Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.updateUserRole(userId, userModel.getRole().getRoleId())) {
			responseEntity = new ResponseEntity<>("User(role) updated", HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> updateUserRole(@NotNull @PathVariable("userId") Integer userId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("User delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.deletedUser(userId)) {
			responseEntity = new ResponseEntity<>("User Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.GET)
	public  ResponseEntity<?> findAll() {
		 List<UserModel> userModels = userService.findAll();
		return  new  ResponseEntity<>(userModels, HttpStatus.OK);
	}

}
