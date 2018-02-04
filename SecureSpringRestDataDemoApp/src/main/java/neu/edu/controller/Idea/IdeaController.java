package neu.edu.controller.Idea;

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

import neu.edu.service.IdeaService;

@RestController
@RequestMapping(path="/project")
public class IdeaController {

	@Autowired
	private IdeaService ideaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Idea> findAll() {
		return ideaService.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createProject(@RequestBody @Valid Idea idea) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		Idea projectProfile = null;
		if ((projectProfile = ideaService.createProject(idea)) != null) {
			responseEntity = new ResponseEntity<>(projectProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{projectId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProject(@NotNull @PathVariable("projectId") Integer projectId,
			@RequestBody Idea ideaModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (ideaService.updateProject(projectId, ideaModel)) {
			responseEntity = new ResponseEntity<>("Service update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{projectId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProject(@NotNull @PathVariable("projectId") Integer projectId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (ideaService.deleteProject(projectId)) {
			responseEntity = new ResponseEntity<>("Service Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}

}
