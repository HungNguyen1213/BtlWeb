package kituc.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
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

import kituc.data.SinhvienRepositoty;
import kituc.entity.Sinhvien;

@RestController
@RequestMapping(path = "/sinhvien", produces = "application/json")
@CrossOrigin(origins = "*")
public class SinhvienController {
	private SinhvienRepositoty svRepo;
	@Autowired
	EntityLinks entityLinks;

	public SinhvienController(SinhvienRepositoty svRepo) {
		this.svRepo = svRepo;
	}

	@GetMapping
	public Iterable<Sinhvien> getAllSinhvien() {
		return svRepo.findAll();
	}
	
	@GetMapping("tim/{keyword}")
	public Iterable<Sinhvien> timSinhvien(@PathVariable("keyword") String keyword){
		return svRepo.findAll(keyword);
	}
	
	@GetMapping("/{id}")
	public Sinhvien sinhvienByMa(@PathVariable("id") int id) {
		Optional<Sinhvien> optSv = svRepo.findById(id);
		if (optSv.isPresent()) {
			return optSv.get();
		}
		return null;
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Sinhvien themSinhvien(@RequestBody Sinhvien sv) {
		return svRepo.save(sv);
	}
	
	@PutMapping("/{id}")
	public Sinhvien suaSinhvien(@RequestBody Sinhvien sv) {
		return svRepo.save(sv);
	}
	
	@DeleteMapping("/{id}")
	public void xoaSinhvien(@PathVariable("id") int id) {
		svRepo.deleteById(id);;
	}
}
