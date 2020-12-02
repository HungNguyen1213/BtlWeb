package kituc.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kituc.data.DichvuRepository;
import kituc.entity.Dichvu;

@RestController
@RequestMapping(path = "/dichvu", produces = "application/json")
@CrossOrigin(origins = "*")
public class DichvuController {
	DichvuRepository dvRepo;
	@Autowired
	public DichvuController(DichvuRepository dvRepo) {
		this.dvRepo = dvRepo;
	}
	
	@GetMapping
	public Iterable<Dichvu> getAllDichvu() {
		 return dvRepo.findAll();
	}
	
	@GetMapping("/{maDv}")
	public Dichvu getDichvuByMavd(@PathVariable("maDv") String maDv) {
		Optional<Dichvu> optDv = dvRepo.findById(maDv);
		if(optDv.isPresent()) {
			return optDv.get();
		}
		return null;
	}
	
	@GetMapping("/tim/{keyword}")
	public Iterable<Dichvu> searchDichvu(@PathVariable("keyword") String keyword){
		return dvRepo.findAll(keyword);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Dichvu themDichvu(@RequestBody Dichvu dv) {
		return dvRepo.save(dv);
	}
	
	@PutMapping("/{maDv}")
	public Dichvu suaDichvu(@RequestBody Dichvu dv) {
		return dvRepo.save(dv);
	}
	
	@DeleteMapping("/{maDv}")
	public void xoaDichvu(@PathVariable("maDv") String maDv) {
		dvRepo.deleteById(maDv);
	}
}
