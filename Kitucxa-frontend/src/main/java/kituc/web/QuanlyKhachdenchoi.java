package kituc.web;

import java.util.Arrays;
import java.util.List;

import kituc.model.Thanhvien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import kituc.model.Khach;

@Controller
@RequestMapping("/quanlykhach")
public class QuanlyKhachdenchoi {
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public String showQLkhach(Model model) {
		List<Thanhvien> ListSv = Arrays.asList(rest.getForObject("http://localhost:8080/quanlykhach", Thanhvien[].class) );
		model.addAttribute("sinhviens",ListSv);
		return "QLKhachdenchoi";
	}
	
	@GetMapping("/dskhach")
	public String showKhachTheoIdSV(Thanhvien sv, Model model){
		List<Khach> listKhach = Arrays.asList(rest.getForObject("http://localhost:8080/quanlykhach/laydskhach/{id}", Khach.class, sv.getId()));
		model.addAttribute("Khachs", listKhach);
		return "redirect:/";
	}
}
