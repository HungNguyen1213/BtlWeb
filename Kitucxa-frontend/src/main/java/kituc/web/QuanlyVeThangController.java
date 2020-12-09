package kituc.web;

import kituc.payload.VeThangRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/quan-ly-ve-thang")
public class QuanlyVeThangController {
	RestTemplate rest = new RestTemplate();
	@GetMapping()
	private String showQuanlyVeThangForm(Model model) {
		List<VeThangRequest> listVeThang = Arrays.asList(rest.getForObject("http://localhost:8080/vethang", VeThangRequest[].class));
		model.addAttribute("listVeThang", listVeThang);
		return "quanlyVeThang";
	}
	
	@GetMapping("/them")
	private String showThemVeThangFrom(Model model) {
		model.addAttribute("veThang", new VeThangRequest());
		return "VeThangForm";
	}
	
	@PostMapping("/them")
	private String themPhong(@ModelAttribute("veThang") VeThangRequest veThang ) {
		rest.postForObject("http://localhost:8080/vethang", veThang, VeThangRequest.class);
		return "redirect:/quan-ly-ve-thang";
	}
	
	@GetMapping("/sua/{xeId}")
	private String showSuaVeThangForm(Model model, @PathVariable("xeId") int xeId) {
		VeThangRequest veThangRequest = rest.getForObject("http://localhost:8080/vethang/search/{xeId}", VeThangRequest.class, xeId);
		model.addAttribute("veThangRequest", veThangRequest);
		return "veThangForm";
	}
	
	@PostMapping("/sua/{xeId}")
	private String suaPhong(@ModelAttribute("veThang") VeThangRequest veThang) {
		rest.put("http://localhost:8080/vethang/{xeId}", veThang, veThang.getXeId());
		return "redirect:/quan-ly-ve-thang";
	}
	
	@GetMapping("/xoa/{xeId}")
	private String xoaPhong(@PathVariable("xeId") int xeId) {
		rest.delete("http://localhost:8080/vethang/{xeId}", xeId);
		return "redirect:/quan-ly-ve-thang";
	}
	
	@GetMapping("/tim")
	private String timPhong (Model model, @RequestParam("keyword") String keyword) {
		if(keyword == null|| keyword.isEmpty()|| keyword.length()==0) {
			List<VeThangRequest> listVeThang = Arrays.asList(rest.getForObject("http://localhost:8080/vethang", VeThangRequest[].class));
			model.addAttribute("listVeThang", listVeThang);
			return "quanlyVeThang";
		}
		List<VeThangRequest> listVeThang = Arrays.asList(rest.getForObject("http://localhost:8080/vethang/search/{keyword}", VeThangRequest[].class, keyword));
		model.addAttribute("listVeThang", listVeThang);
		return "quanlyVeThang";
	}
}
