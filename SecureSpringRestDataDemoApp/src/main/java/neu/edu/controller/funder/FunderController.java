package neu.edu.controller.funder;

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

import neu.edu.controller.startup.StartupModel;
import neu.edu.service.FunderService;
import neu.edu.service.StartupServiceService;

@RestController
@RequestMapping(path="/funder")
public class FunderController {
	@Autowired
	private FunderService funderService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FunderModel> findAll() {
		
		return funderService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createFunder(@RequestBody @Valid FunderModel funderModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		FunderModel projectProfile = null;
		if ((projectProfile = funderService.createFunder(funderModel)) != null) {
			responseEntity = new ResponseEntity<>(projectProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{projectId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateFunder(@NotNull @PathVariable("funderId") Integer funderId,
			@RequestBody FunderModel funderModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (funderService.updateFunder(funderId, funderModel)) {
			responseEntity = new ResponseEntity<>("Service update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{funderId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFunder(@NotNull @PathVariable("funderId") Integer funderId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (funderService.deleteFunder(funderId)) {
			responseEntity = new ResponseEntity<>("Service Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
}
