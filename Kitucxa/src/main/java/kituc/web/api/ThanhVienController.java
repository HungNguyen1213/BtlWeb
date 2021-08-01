package kituc.web.api;

import kituc.dto.ThanhvienDto;
import kituc.entity.Thanhvien;
import kituc.service.ThanhVienService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/thanhvien", produces = "application/json")
@CrossOrigin(origins = "*")
public class ThanhVienController {
	@Autowired
	private ThanhVienService thanhVienService;
	@PostMapping("/login")
	public Thanhvien checkLogin(@RequestBody Thanhvien thanhvien){
		return thanhVienService.checkLogin(thanhvien.getUserName(),thanhvien.getPassword());
	}

	@GetMapping
	public Iterable<Thanhvien> getAllSinhvien() {
		return thanhVienService.findAllSinhvien();
	}

	@GetMapping("tim-sinh-vien/{keyword}")
	public List<ThanhvienDto> findSinhvienByName(@PathVariable("keyword") String keyword){
		List<ThanhvienDto> thanhvienDtoList = new ArrayList<>();
		List<Thanhvien> thanhvienList = (List<Thanhvien>) thanhVienService.timSinhvien(keyword);
		for (Thanhvien thanhvien : thanhvienList){
			thanhvienDtoList.add(thanhVienService.convertToDto(thanhvien));
		}
		return thanhvienDtoList;
	}

	@GetMapping("/tim-theo-id/{id}")
	public ThanhvienDto findSinhvienById(@PathVariable("id") int id) {
		return thanhVienService.convertToDto(thanhVienService.sinhvienById(id));
	}

	@GetMapping("tim/{keyword}")
	public Iterable<Thanhvien> timSinhvien(@PathVariable("keyword") String keyword){
		return thanhVienService.timSinhvien(keyword);
	}
	
	@GetMapping("/{id}")
	public Thanhvien sinhvienById(@PathVariable("id") int id) {
		return thanhVienService.sinhvienById(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Thanhvien themSinhvien(@RequestBody Thanhvien sv) {
		return thanhVienService.luuSinhvien(sv);
	}
	
	@PutMapping("/{id}")
	public Thanhvien suaSinhvien(@RequestBody Thanhvien sv) {
		return thanhVienService.luuSinhvien(sv);
	}
	
	@DeleteMapping("/{id}")
	public void xoaSinhvien(@PathVariable("id") int id) {
		thanhVienService.xoaSinhvien(id);
	}
}
