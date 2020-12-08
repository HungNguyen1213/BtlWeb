package kituc.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kituc.entity.Khach;
import kituc.entity.Sinhvien;
import kituc.service.KhachService;
import kituc.service.SinhvienService;

@RestController
@RequestMapping(path="/quanlykhach", produces="application/json" )
@CrossOrigin(origins = "*")
public class KhachController {

	@Autowired
	private KhachService khachSer;
	@Autowired
	private SinhvienService svSer;

//	@GetMapping
//	public Iterable<Sinhvien> getAllSinhvien(){
//		return svSer.findAll();
//	}
	
	@GetMapping
	public Iterable<Sinhvien> getAllSinhvien() {
		return svSer.findAll();
	}
	
	@GetMapping("/timkiem/{keyword}")
	public Iterable<Sinhvien> timkiem(@PathVariable("keyword") String key){
		 return svSer.timSinhvien(key);
	}
	
	@GetMapping("/laydanhsachkhach/{id}")
	public Iterable<Khach> getKhachBySvID(@PathVariable("id") int id){
		return khachSer.getClientByIdSv(id);
	}
}
