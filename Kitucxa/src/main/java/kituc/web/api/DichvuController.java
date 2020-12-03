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

import kituc.entity.Dichvu;
import kituc.service.DichvuService;

@RestController
@RequestMapping(path = "/dichvu", produces = "application/json")
@CrossOrigin(origins = "*")
public class DichvuController {
	@Autowired
	private DichvuService dvService;
	
	@GetMapping
	public Iterable<Dichvu> getAllDichvu() {
		 return dvService.getAllDichvu();
	}
	
	@GetMapping("/{maDv}")
	public Dichvu getDichvuByMavd(@PathVariable("maDv") String maDv) {
		return dvService.getDichvuByMavd(maDv);
	}
	
	@GetMapping("/tim/{keyword}")
	public Iterable<Dichvu> searchDichvu(@PathVariable("keyword") String keyword){
		return dvService.searchDichvu(keyword);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Dichvu themDichvu(@RequestBody Dichvu dv) {
		return dvService.luuDichvu(dv);
	}
	
	@PutMapping("/{maDv}")
	public Dichvu suaDichvu(@RequestBody Dichvu dv) {
		return dvService.luuDichvu(dv);
	}
	
	@DeleteMapping("/{maDv}")
	public void xoaDichvu(@PathVariable("maDv") String maDv) {
		dvService.xoaDichvu(maDv);
	}
}
