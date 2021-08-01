package kituc.web.api;

import java.util.Date;
import java.util.List;

import kituc.dto.KhachDto;
import kituc.dto.ThanhvienDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import kituc.entity.Khach;
import kituc.service.KhachService;
import kituc.service.ThanhVienService;

@RestController
@RequestMapping(path="/api/v1.1/khach", produces="application/json" )
@CrossOrigin(origins = "*")
public class KhachController {

	@Autowired
	private KhachService khachSer;

	@Autowired
	private ThanhVienService thanhVienService;
	
	@GetMapping("/lay-danh-sach-khach/{id}")
	public List<KhachDto> getKhachBySvID(@PathVariable("id") int id){
		return khachSer.getClientByIdSv(id);
	}
	
	@GetMapping("/tim-khach/{name}&{id}")
	public List<KhachDto> getKhachByName(@PathVariable("name") String name, @PathVariable("id") int sinhvienid){
		return khachSer.findKhachByName(name, sinhvienid);
	}
	
	@PostMapping(path = "/add",consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public KhachDto LuuKhach(@RequestBody KhachDto khachDto) {
		return khachSer.save(khachDto);
	}
	
	@GetMapping("/sua/{id}")
	public KhachDto getKhachById(@PathVariable("id") int id) {
		return khachSer.findKhachById(id);
	}
	
	@PutMapping("/sua-khach/{id}")
	public KhachDto updateKhach(@RequestBody KhachDto khachDto) {
		return khachSer.save(khachDto);
	}
	
	@DeleteMapping("/xoa/{id}")
	public void deleteKhachById(@PathVariable("id") int id) {
		khachSer.deleteKhachById(id);
	}
	
	@GetMapping("/dskhach")
	public List<ThanhvienDto> getAllKhach(){
		return khachSer.getAllThanhvienKhach();
	}
	
	@GetMapping("/dskhach-den-trong-khoang/{ngaybd}&{ngaykt}")
	public List<ThanhvienDto> getNgaydenTrongkhoang(@PathVariable("ngaybd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaybd, @PathVariable("ngaykt") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date ngaykt){
		return khachSer.getKhachTrongKhoangThoiGian(ngaybd, ngaykt);
	}
}
