package kituc.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kituc.entity.DichvuSudung;
import kituc.service.DichvuSudungService;

@RestController
@RequestMapping(path = "/dichvuSudung", produces = "application/json")
@CrossOrigin(origins = "*")
public class DichvuSudungController {
	@Autowired
	private DichvuSudungService dvsdService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DichvuSudung themDichvuSudung(@RequestBody DichvuSudung dvsd) {
		return dvsdService.luuDvsd(dvsd);
	}
}
