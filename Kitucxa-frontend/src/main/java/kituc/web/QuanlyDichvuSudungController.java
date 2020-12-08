package kituc.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import kituc.model.DichvuSudung;
import kituc.model.Sinhvien;

@Controller
@RequestMapping("/quan-ly-dich-vu-su-dung")
public class QuanlyDichvuSudungController {
	RestTemplate rest = new RestTemplate();
	
	@GetMapping
	private String showQuanlyDichvuSudugnForm() {
		return "quanlyDichvuSudung";
	}
	
	@GetMapping("/tim-sinh-vien")
	private String timSinhvien(Model model, @RequestParam("keyword") String keyword) {
		List<Sinhvien> listSv = Arrays.asList(rest.getForObject("http://localhost:8080/sinhvien/tim/{keyword}", Sinhvien[].class, keyword));
		model.addAttribute("listSv", listSv);
		return "quanlyDichvuSudung";
	}
	
	@GetMapping("/sinhvien/{id}")
	private String showDichvuSudungForSinhvien(Model model, @PathVariable("id") int id) {
		List<DichvuSudung> listDvsd = Arrays.asList(rest.getForObject("http://localhost:8080/dichvuSudung/sinhvien/{id}", DichvuSudung[].class, id));
		Sinhvien sv = rest.getForObject("http://localhost:8080/sinhvien/{id}", Sinhvien.class, id);
		model.addAttribute("sv", sv);
		model.addAttribute("listDvsd", listDvsd);
		return "dichvuSudungForSinhvien";
	}
}
