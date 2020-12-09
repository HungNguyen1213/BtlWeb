package kituc.service;

import kituc.data.DichvuRepository;
import kituc.data.VethangRepository;
import kituc.data.XeRepository;
import kituc.entity.Dichvu;
import kituc.entity.Vethang;
import kituc.entity.Xe;
import kituc.payload.VeThangRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeThangService {
    @Autowired
    private VethangRepository vethangRepository;
    @Autowired
    private XeRepository xeRepository;
    @Autowired
    private DichvuRepository dichvuRepository;
    public List<Vethang> findAll(){
        return vethangRepository.findAll();
    }
    public Vethang findById(Integer id){
        Optional<Vethang> byId = vethangRepository.findById(id);
        if(!byId.isPresent()){
            //throw exception
            return null;
        }
        return byId.get();
    }
    public List<Vethang> findByBienSo(String bienSo){
        List<Xe> allByBienSo = xeRepository.findAllByBienSo(bienSo);
        List<Vethang> vethangs= new ArrayList<>();
        if(allByBienSo.isEmpty()){
            // throw ex
            return null;
        }
        for(int i=0;i<allByBienSo.size();++i){
            Optional<Vethang> byId = vethangRepository.findById(allByBienSo.get(i).getId());
            if(byId.isPresent()){
                vethangs.add(byId.get());
            }
        }
        return vethangs;
    }
    public VeThangRequest addNew(VeThangRequest veThangRequest){
        Optional<Vethang> byId = vethangRepository.findById(veThangRequest.getId());

        if(byId.isPresent()){
            //throw ex
            return null;
        }
        // tạo 1 vethang mới để hứng lấy các thuộc tính
        Vethang vethang=new Vethang();
        BeanUtils.copyProperties(veThangRequest,vethang);

        Optional<Xe> byId1 = xeRepository.findById(veThangRequest.getXeId());
        Optional<Dichvu> byId2 = dichvuRepository.findById(veThangRequest.getDichVuId());
        if(!byId1.isPresent()||!byId2.isPresent()){
            // throw ex
            return null;
        }
        vethang.setXe(byId1.get());
        vethang.setDichvu(byId2.get());
        vethangRepository.save(vethang);
        return veThangRequest;
    }
    public VeThangRequest update(VeThangRequest veThangRequest){
        Optional<Vethang> byId = vethangRepository.findById(veThangRequest.getId());

        if(!byId.isPresent()){
            //throw ex
            return null;
        }
        // tạo 1 vethang mới để hứng lấy các thuộc tính
        Vethang vethang=new Vethang();
        BeanUtils.copyProperties(veThangRequest,vethang);

        Optional<Xe> byId1 = xeRepository.findById(veThangRequest.getXeId());
        Optional<Dichvu> byId2 = dichvuRepository.findById(veThangRequest.getDichVuId());
        if(!byId1.isPresent()||!byId2.isPresent()){
            // throw ex
            return null;
        }
        vethang.setXe(byId1.get());
        vethang.setDichvu(byId2.get());
        vethangRepository.save(vethang);
        return veThangRequest;
    }
    public void delete(Integer id){
        vethangRepository.deleteById(id);
    }
}
