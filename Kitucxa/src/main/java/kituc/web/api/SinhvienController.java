package kituc.web.api;

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

import kituc.entity.Sinhvien;
import kituc.service.SinhvienService;

@RestController
@RequestMapping(path = "/sinhvien", produces = "application/json")
@CrossOrigin(origins = "*")
public class SinhvienController {
	@Autowired
	private SinhvienService svService;
	

	@GetMapping
	public Iterable<Sinhvien> getAllSinhvien() {
		return svService.findAll();
	}
	
	@GetMapping("tim/{keyword}")
	public Iterable<Sinhvien> timSinhvien(@PathVariable("keyword") String keyword){
		return svService.timSinhvien(keyword);
	}
	
	@GetMapping("/{ma}")
	public Sinhvien sinhvienByMa(@PathVariable("ma") int ma) {
		return svService.sinhvienByMa(ma);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Sinhvien themSinhvien(@RequestBody Sinhvien sv) {
		return svService.luuSinhvien(sv);
	}
	
	@PutMapping("/{ma}")
	public Sinhvien suaSinhvien(@RequestBody Sinhvien sv) {
		return svService.luuSinhvien(sv);
	}
	
	@DeleteMapping("/{ma}")
	public void xoaSinhvien(@PathVariable("ma") int ma) {
		svService.xoaSinhvien(ma);
	}
}
