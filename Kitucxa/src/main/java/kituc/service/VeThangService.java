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
import java.util.stream.Collectors;

@Service
public class VeThangService {
    @Autowired
    private VethangRepository vethangRepository;
    @Autowired
    private XeRepository xeRepository;
    @Autowired
    private DichvuRepository dichvuRepository;
    // convert vethang to vethangRequest
    public List<VeThangRequest> findAll(){
        return vethangRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }
//    public VeThangRequest findById(Integer id){
//        Optional<Vethang> byId = vethangRepository.findById(id);
//        if(!byId.isPresent()){
//            //throw exception
//            return null;
//        }
//        return this.convert(byId.get());
//    }
    public List<VeThangRequest> findByBienSo(String bienSo){
//        if(bienSo.isEmpty()){
//            bienSo="";
//        }
        List<Xe> allByBienSo = xeRepository.findAllByBienSo(bienSo);
        List<Vethang> vethangs= new ArrayList<>();
        if(allByBienSo.isEmpty()){
            // throw ex
            return null;
        }
        for(int i=0;i<allByBienSo.size();++i){
            Vethang allByXeId = vethangRepository.findAllByXeId(allByBienSo.get(i).getId());
            if(allByXeId!=null){
                vethangs.add(allByXeId);
            }
        }
        return vethangs.stream().map(this::convert).collect(Collectors.toList());
    }
    public VeThangRequest addNew(VeThangRequest veThangRequest){
        Vethang allByXeId = vethangRepository.findAllByXeId(veThangRequest.getXeId());

        if(allByXeId!=null){
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
        vethangRepository.save(vethang);
        return veThangRequest;
    }
    public VeThangRequest update(VeThangRequest veThangRequest){
        Vethang allByXeId = vethangRepository.findAllByXeId(veThangRequest.getXeId());

        if(allByXeId!=null){
            // tạo 1 vethang mới để hứng lấy các thuộc tính
            Vethang vethang=new Vethang();
            BeanUtils.copyProperties(veThangRequest,vethang);

            Optional<Xe> byId1 = xeRepository.findById(veThangRequest.getXeId());
            Optional<Dichvu> byId2 = dichvuRepository.findById(veThangRequest.getDichVuId());
            if(!byId1.isPresent()||!byId2.isPresent()){
                // throw ex
                return null;
            }
            vethang.setId(allByXeId.getId());
            vethang.setXe(byId1.get());
            vethangRepository.save(vethang);
            return veThangRequest;
        }
        //throw ex
        return null;
    }
    public void delete(Integer id){
        Optional<Xe> byId = xeRepository.findById(id);
        if(byId.isPresent()){
            vethangRepository.deleteById(vethangRepository.findAllByXeId(byId.get().getId()).getId());
        }
    }
    public VeThangRequest convert(Vethang vethang){
        VeThangRequest veThangRequest=new VeThangRequest();
        BeanUtils.copyProperties(vethang,veThangRequest);
        veThangRequest.setXeId(vethang.getXe().getId());
        return veThangRequest;
    }
}
