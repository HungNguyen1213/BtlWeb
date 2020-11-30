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

import kituc.data.PhongRepository;
import kituc.entity.Phong;
//test commit
@RestController
@RequestMapping(path = "/phong", produces = "application/json")
@CrossOrigin(origins = "*")
public class PhongController {
	PhongRepository phongRepo;
	@Autowired
	public PhongController(PhongRepository phongRepo) {
		this.phongRepo = phongRepo;
	}
	
	@GetMapping
	public Iterable<Phong> getAllPhong(){
		return phongRepo.findAll();
	}
	
	@GetMapping("/{soPhong}")
	public Phong getPhongBySophong(@PathVariable("soPhong") String soPhong) {
		Optional<Phong> optPhong = phongRepo.findById(soPhong);
		if(optPhong.isPresent()) {
			return optPhong.get();
		}
		return null;
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Phong themPhong(@RequestBody Phong phong) {
		return phongRepo.save(phong);
	}
	
	@PutMapping("/{soPhong}")
	public Phong suaPhong(@RequestBody Phong phong) {
		return phongRepo.save(phong);
	}
	
	@DeleteMapping("/{soPhong}")
	public void xoaPhong(@PathVariable("soPhong") String soPhong) {
		phongRepo.deleteById(soPhong);
	}
}
