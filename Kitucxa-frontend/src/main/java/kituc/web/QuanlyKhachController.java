package kituc.web;

import java.text.ParseException;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import kituc.dto.KhachDto;
import kituc.dto.ThanhvienDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/quanlykhach")
public class QuanlyKhachController {
	
	private RestTemplate rest = new RestTemplate();
	@Autowired
	private HttpSession session;
	
	@GetMapping
	public String showQLkhach(Model model) {
		List<ThanhvienDto> ListSv = Arrays.asList(rest.getForObject("http://localhost:8080/api/v1.1/khach/dskhach", ThanhvienDto[].class) );
		model.addAttribute("sinhviens",ListSv);
		return "QLKhachdenchoi";
	}
	
	@GetMapping("/timkiem")
	private String timSinhvien(Model model, @RequestParam("txtSearch") String keyword) {
		List<ThanhvienDto> listSv = Arrays.asList(rest.getForObject("http://localhost:8080/thanhvien/tim-sinh-vien/{keyword}", ThanhvienDto[].class, keyword));
		model.addAttribute("sinhviens", listSv);
		return "QLKhachdenchoi";
	} 
	
	@GetMapping("/dskhach")
	public String showKhachTheoIdSV(@RequestParam("chon") int id, Model model ) throws ParseException{
		List<KhachDto> listKhach = Arrays.asList(rest.getForObject("http://localhost:8080/api/v1.1/khach/lay-danh-sach-khach/{id}", KhachDto[].class, id));
		ThanhvienDto thanhvienDto = rest.getForObject("http://localhost:8080/thanhvien/tim-theo-id/{id}",ThanhvienDto.class, id);
		session.setAttribute("id", id);
		session.setAttribute("sinhvien", thanhvienDto);
		model.addAttribute("khachs", listKhach);
		return "QLDSkhach";
	}
	
	@GetMapping("/them")
	public String getluuKhach(Model model) {
		model.addAttribute("khach", new KhachDto());
		return "ThemKhachDen";
	}
	
	@GetMapping("/tim-khach")
	public String timKhach(Model model, @RequestParam("txtSearchClient") String key) {
		int id = (int) session.getAttribute("id");
		List<KhachDto> arrKhach = Arrays.asList(rest.getForObject("http://localhost:8080/api/v1.1/khach/tim-khach/{name}&{id}", KhachDto[].class, key, id));
		model.addAttribute("khachs", arrKhach);
		return "QLDSkhach";
	}
	
	@PostMapping("/luu-khach")
	public String luuKhach(@ModelAttribute("khach") KhachDto khachDto) throws ParseException {
		int idSinhvien = (int) session.getAttribute("id");
		khachDto.setIdThanhvien(idSinhvien);
		rest.postForObject("http://localhost:8080/api/v1.1/khach/add", khachDto , KhachDto.class);
		return "redirect:/quanlykhach/dskhach?chon="+idSinhvien;
	}
	
//	@PostMapping("/luu-ngay-den-choi")
//	public String luuNgay(@RequestParam("ngayden") String ngay, @RequestParam("chon") List<String> ArridKhach) throws ParseException {
//		for(int i=0; i<ArridKhach.size(); i++) {
//			KhachDto khachDto = new KhachDto();
//			khachDto.setId(Integer.parseInt(ArridKhach.get(i)));
//			khachDto.setNgayden(ngay);
//		}
//		rest.postForObject("http://localhost:8080/api/v1.1/khach/luu-ngay-den", arrNgayden , arrNgayden.getClass());
//		return "redirect:/quanlykhach";
//	}
//
	@GetMapping("/sua/{id}")
	public String getKhachToSua(Model model, @PathVariable("id") int id) {
		KhachDto khachDto = rest.getForObject("http://localhost:8080/api/v1.1/khach/sua/{id}", KhachDto.class, id);
		session.setAttribute("idkhach", khachDto.getId());
		model.addAttribute("khach", khachDto);
		return "SuaKhach";
	}
	
	@PostMapping("/suakhach")
	public String suaKhach(@ModelAttribute("khach") KhachDto khachDto) {
		int idSinhvien = (int) session.getAttribute("id");
		int idkhach = (int) session.getAttribute("idkhach");
		khachDto.setId(idkhach);
		khachDto.setIdThanhvien(idSinhvien);
		rest.put("http://localhost:8080/api/v1.1/khach/sua-khach/{id}", khachDto , idkhach );
		return "redirect:/quanlykhach/dskhach?chon="+idSinhvien;
	}
	
	@GetMapping("/xoa/{id}")
	public String xoaKhach(@PathVariable("id") int id) {
		int idsv = (int) session.getAttribute("id");
		rest.delete("http://localhost:8080/api/v1.1/khach/xoa/{id}", id);
		return "redirect:/quanlykhach/dskhach?chon="+idsv;
	}
	
	@GetMapping("/quaylai")
	public String quayLai() {
		int id = (int) session.getAttribute("id");
		return "redirect:/quanlykhach/dskhach?chon="+id;
	}
	
	@GetMapping("/dskhachdenchoi")
	public String showDSkhachdenchoi(Model model) {
		List<ThanhvienDto> thanhvienDtoList = Arrays.asList(rest.getForObject("http://localhost:8080/api/v1.1/khach/dskhach", ThanhvienDto[].class));
		model.addAttribute("listKhach", thanhvienDtoList);
		return "inDsKhachTheoThoigian";
	}
	
	@GetMapping("/dskhach-den-choi-trong-thoigian")
	public String getDSfortime(Model model, @RequestParam("thoigianbd") String thoigianbd, @RequestParam("thoigiankt") String thoigiankt){
		List<ThanhvienDto> thanhvienDtoList = Arrays.asList(rest.getForObject("http://localhost:8080/api/v1.1/khach/dskhach-den-trong-khoang/{ngaybd}&{ngaykt}", ThanhvienDto[].class, thoigianbd, thoigiankt));
		model.addAttribute("listKhach", thanhvienDtoList);
		return "inDsKhachTheoThoigian";
	}
}
