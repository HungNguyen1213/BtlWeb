package kituc.web.api;

import kituc.entity.Vethang;
import kituc.payload.VeThangRequest;
import kituc.service.VeThangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/vethang", produces = "application/json")
@RestController
@CrossOrigin(origins = "*")
public class VeThangApi {
    @Autowired
    private VeThangService veThangService;
    @GetMapping
    public List<Vethang> findAll(){
        return veThangService.findAll();
    }
    @GetMapping("/{id}")
    public Vethang findById(@PathVariable Integer id){
        return veThangService.findById(id);
    }
    @GetMapping("/search/{bienSo}")
    public List<Vethang> findByBienSo(@PathVariable String bienSo){
        return veThangService.findByBienSo(bienSo);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeThangRequest addNew(@RequestBody VeThangRequest vethang){
        return veThangService.addNew(vethang);
    }
    @PutMapping
    public VeThangRequest update(@RequestBody VeThangRequest vethang){
        return veThangService.update(vethang);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Integer id){
        veThangService.delete(id);
    }
}
