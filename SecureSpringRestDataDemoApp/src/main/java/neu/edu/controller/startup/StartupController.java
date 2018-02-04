package neu.edu.controller.startup;

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

import neu.edu.controller.Idea.Idea;
import neu.edu.service.StartupServiceService;

@RestController
@RequestMapping(path="/startup")
public class StartupController {
	
	@Autowired
	private StartupServiceService startupServiceService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<StartupModel> findAll() {
		
		return startupServiceService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createStartup(@RequestBody @Valid StartupModel startupModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		StartupModel projectProfile = null;
		if ((projectProfile = startupServiceService.createStartup(startupModel)) != null) {
			responseEntity = new ResponseEntity<>(projectProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{projectId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStartup(@NotNull @PathVariable("startupId") Integer startupId,
			@RequestBody StartupModel startupModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (startupServiceService.updateStartup(startupId, startupModel)) {
			responseEntity = new ResponseEntity<>("Service update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{startupId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStartup(@NotNull @PathVariable("startupId") Integer startupId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (startupServiceService.deleteStartup(startupId)) {
			responseEntity = new ResponseEntity<>("Service Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}

}
