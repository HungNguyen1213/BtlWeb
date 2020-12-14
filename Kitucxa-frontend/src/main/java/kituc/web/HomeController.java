package kituc.web;

import kituc.model.Thanhvien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
    RestTemplate rest = new RestTemplate();
    @GetMapping
    public String login(Model model){
        model.addAttribute("thanhvien",new Thanhvien());
        return "login";
    }
    @PostMapping
    public String trangchu(@ModelAttribute Thanhvien thanhvien){
        Thanhvien thanhvien1 = rest.postForObject("http://localhost:8080/thanhvien/login", thanhvien, Thanhvien.class);
        if(thanhvien1==null) return "redirect:/";
        else if(thanhvien1.getVitri()=="admin")return "trangchuadmin";
        return "trangtrusinhvien";
    }
}
