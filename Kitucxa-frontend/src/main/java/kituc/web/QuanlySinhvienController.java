package kituc.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import kituc.model.Sinhvien;

@Controller
@RequestMapping("/quan-ly-sinh-vien")
public class QuanlySinhvienController {
	RestTemplate rest = new RestTemplate();
	
	@GetMapping
	private String showQuanlySinhvienForm(Model model) {
		List<Sinhvien> listSv = Arrays.asList(rest.getForObject("http://localhost:8080/sinhvien", Sinhvien[].class));
		model.addAttribute("listSv", listSv);
		return "quanlySinhvien";
	}
	
	@GetMapping("/them")
	private String showThemSinhvienForm(Model model) {
		model.addAttribute("sv", new Sinhvien());
		return "sinhvienForm";
	}
	
	@PostMapping("/them")
	private String themSinhvien(@ModelAttribute("sv") Sinhvien sv) {
		rest.postForObject("http://localhost:8080/sinhvien", sv, Sinhvien.class);
		return "redirect:/quan-ly-sinh-vien";
	}
	
	@GetMapping("/sua/{id}")
	private String showSuaSinhvienForm(Model model, @PathVariable("id") int id) {
		Sinhvien sv =rest.getForObject("http://localhost:8080/sinhvien/{id}", Sinhvien.class, id);
		model.addAttribute("sv", sv);
		return "sinhvienForm";
	}
	
	@PostMapping("/sua/{id}")
	private String suaSinhvien(@ModelAttribute("sv") Sinhvien sv) {
		rest.put("http://localhost:8080/sinhvien/{id}", sv, sv.getId());
		return "redirect:/quan-ly-sinh-vien";
	}
	
	@GetMapping("/xoa/{id}")
	private String xoaSinhvien(@PathVariable("id") int id) {
		rest.delete("http://localhost:8080/sinhvien/{id}", id);
		return "redirect:/quan-ly-sinh-vien";
	}
	
	@GetMapping("/tim")
	private String timSinhvien(Model model, @RequestParam("keyword") String keyword) {
		List<Sinhvien> listSv = Arrays.asList(rest.getForObject("http://localhost:8080/sinhvien/tim/{keyword}", Sinhvien[].class, keyword));
		model.addAttribute("listSv", listSv);
		return "quanlySinhvien";
	}
	
}
