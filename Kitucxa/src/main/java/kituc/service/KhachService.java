package kituc.service;

import kituc.data.KhachReponsitory;
import kituc.dto.KhachDto;
import kituc.dto.ThanhvienDto;
import kituc.entity.Khach;
import kituc.entity.Thanhvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KhachService {
    @Autowired
    private KhachReponsitory khachRep;

    @Autowired
    private ThanhVienService thanhVienService;

    public Khach convertToEntity(KhachDto khachDto) {
        Khach khach = new Khach();
        khach.setId(khachDto.getId());
        khach.setTen(khachDto.getTen());
        khach.setSoCMT(khachDto.getSoCMT());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            khach.setNgaysinh(sdf.parse(khachDto.getNgaysinh()));
            khach.setNgayden(sdf.parse(khachDto.getNgayden()));
			Thanhvien thanhvien = new Thanhvien();
			thanhvien.setId(khachDto.getIdThanhvien());
            khach.setThanhvien(thanhvien);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return khach;
    }

	public KhachDto convertToDto (Khach khach){
		KhachDto khachDto = new KhachDto();
		khachDto.setId(khach.getId());
		khachDto.setTen(khach.getTen());
		khachDto.setSoCMT(khach.getSoCMT());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		khachDto.setNgaysinh(sdf.format(khach.getNgaysinh()));
		khachDto.setNgayden(sdf.format(khach.getNgayden()));
		khachDto.setIdThanhvien(khach.getThanhvien().getId());
		return khachDto;
	}

    public List<KhachDto> getAllKhach() {
    	List<Khach> khachList = khachRep.findAll();
    	List<KhachDto> khachDtoList = new ArrayList<>();
        for (Khach khach : khachList){
        	KhachDto khachDto = convertToDto(khach);
        	khachDtoList.add(khachDto);
		}
    	return khachDtoList;
    }

    public List<KhachDto> getClientByIdSv(int id) {
		List<Khach> khachList = khachRep.getAllClientBySvId(id);
		List<KhachDto> khachDtoList = new ArrayList<>();
		for (Khach khach : khachList){
			KhachDto khachDto = convertToDto(khach);
			khachDtoList.add(khachDto);
		}
        return khachDtoList;
    }

    public KhachDto save(KhachDto khachDto) {
        return convertToDto(khachRep.save(convertToEntity(khachDto)));
    }

    public List<KhachDto> findKhachByName(String name, int thanhvienId) {
        List<Khach> khachList = khachRep.findKhachByName(name, thanhvienId);
        List<KhachDto> khachDtoList = new ArrayList<>();
        for (Khach khach : khachList){
            khachDtoList.add(convertToDto(khach));
        }
        return khachDtoList;
    }

    public void deleteKhachById(int id) {
        khachRep.deleteById(id);
    }

    public KhachDto findKhachById(int id) {
        Optional<Khach> khach = khachRep.findById(id);
        KhachDto khachDto = null;
        if (khach.isPresent()) {
            khachDto = convertToDto(khach.get());
            return khachDto;
        }
        return null;
    }

    public List<ThanhvienDto> getKhachTrongKhoangThoiGian(Date ngaybd, Date ngaykt) {
        List<Thanhvien> thanhvienList = khachRep.dsNgayden(ngaybd, ngaykt);
        List<ThanhvienDto> thanhvienDtoList = new ArrayList<>();
        for (Thanhvien thanhvien : thanhvienList){
            thanhvienDtoList.add(thanhVienService.convertToDto(thanhvien));
        }
        return thanhvienDtoList;
    }

    public List<ThanhvienDto> getAllThanhvienKhach(){
        List<Thanhvien> thanhvienList = (List<Thanhvien>) thanhVienService.findAllSinhvien();
        List<ThanhvienDto> thanhvienDtoList = new ArrayList<>();
        for (Thanhvien thanhvien : thanhvienList){
            thanhvienDtoList.add(thanhVienService.convertToDto(thanhvien));
        }
        return thanhvienDtoList;
    }
}
