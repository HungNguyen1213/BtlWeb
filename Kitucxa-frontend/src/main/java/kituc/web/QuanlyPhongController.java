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
import org.springframework.web.client.RestTemplate;

import kituc.model.Phong;

@Controller
@RequestMapping("/quan-ly-phong")
public class QuanlyPhongController {
	RestTemplate rest = new RestTemplate();
	
	@GetMapping()
	private String showQuanlyPhongForm(Model model) {
		List<Phong> listPhong = Arrays.asList(rest.getForObject("http://localhost:8080/phong", Phong[].class));
		model.addAttribute("listPhong", listPhong);
		return "quanlyPhong";
	}
	
	@GetMapping("/them")
	private String showThemPhongFrom(Model model) {
		model.addAttribute("phong", new Phong());
		return "themPhong";
	}
	
	@PostMapping("/them")
	private String themPhong(@ModelAttribute("phong") Phong phong ) {
		rest.postForObject("http://localhost:8080/phong", phong, Phong.class);
		return "redirect:/quan-ly-phong";
	}
	
	@GetMapping("/sua/{soPhong}")
	private String showSuaPhongForm(Model model, @PathVariable("soPhong") String soPhong) {
		Phong phong = rest.getForObject("http://localhost:8080/phong/{soPhong}", Phong.class, soPhong);
		model.addAttribute("phong", phong);
		return "suaPhong";
	}
	
	@PostMapping("/sua/{soPhong}")
	private String suaPhong(@ModelAttribute("phong") Phong phong) {
		rest.put("http://localhost:8080/phong/{soPhong}", phong, phong.getSoPhong());
		return "redirect:/quan-ly-phong";
	}
	
	@GetMapping("/xoa/{soPhong}")
	private String xoaPhong(@PathVariable("soPhong") String soPhong) {
		rest.delete("http://localhost:8080/phong/{soPhong}", soPhong);
		return "redirect:/quan-ly-phong";
	}
}
