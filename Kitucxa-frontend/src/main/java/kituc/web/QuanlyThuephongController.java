package kituc.web;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import kituc.model.Thanhvien;

@Controller
@RequestMapping("/dang-ki-thue-phong")
public class QuanlyThuephongController {

	private RestTemplate rest = new RestTemplate();
	@Autowired
	private HttpSession session;
	
	@GetMapping
	public String getAllSv(Model model) {		
		List<Thanhvien> listSv = Arrays.asList(rest.getForObject("http://localhost:8080/thanhvien", Thanhvien[].class));
		model.addAttribute("sinhviens",listSv);	
		return "homeThuephong";
	}
	
	@GetMapping("/dsphong")
	public String getPhongtrong(Model model) {
		
		return "";
	}
}
