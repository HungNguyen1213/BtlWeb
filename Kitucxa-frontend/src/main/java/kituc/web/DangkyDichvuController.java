package kituc.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import kituc.model.Thanhvien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import kituc.model.Dichvu;
import kituc.model.DichvuSudung;

@Controller
@RequestMapping("/dang-ky-dich-vu")
public class DangkyDichvuController {
	RestTemplate rest = new RestTemplate();
	
	@GetMapping
	private String showFormDangki(Model model) {
		List<Dichvu> listDv = Arrays.asList(rest.getForObject("http://localhost:8080/dichvu", Dichvu[].class));
		model.addAttribute("listDv", listDv);
		model.addAttribute("dvsd", new DichvuSudung());
		return "dangkyDichvu";
	}
	
	@PostMapping
	private String dangkiDichvu(@RequestParam("thoigiankt") String tgkt, @RequestParam("dichvu") int id) throws ParseException {
		DichvuSudung dvsd = new DichvuSudung();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date thoigiankt = formatter.parse(tgkt);
		Dichvu dv = rest.getForObject("http://localhost:8080/dichvu/{id}", Dichvu.class, id);
		Thanhvien sv = rest.getForObject("http://localhost:8080/sinhvien/{id}", Thanhvien.class, 1);
		dvsd.setThoigiankt(thoigiankt);
		dvsd.setDongia(dv.getDongia());
		dvsd.setDichvu(dv);
		dvsd.setThanhvien(sv);
		rest.postForObject("http://localhost:8080/dichvuSudung", dvsd, DichvuSudung.class);
		return "redirect:/quan-ly-sinh-vien";
	}
}
