package kituc.web;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import kituc.model.Khach;
import kituc.model.Sinhvien;

@Controller
@RequestMapping("/quanlykhach")
public class QuanlyKhachdenchoi {
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public String showQLkhach(Model model) {
		List<Sinhvien> ListSv = Arrays.asList(rest.getForObject("http://localhost:8080/quanlykhach", Sinhvien[].class) );
		model.addAttribute("sinhviens",ListSv);
		return "QLKhachdenchoi";
	}
	
	@GetMapping("/dskhach")
	public String showKhachTheoIdSV(Sinhvien sv, Model model){
		List<Khach> listKhach = Arrays.asList(rest.getForObject("http://localhost:8080/quanlykhach/laydskhach/{id}", Khach.class, sv.getId()));
		model.addAttribute("Khachs", listKhach);
		return "redirect:/";
	}
}
