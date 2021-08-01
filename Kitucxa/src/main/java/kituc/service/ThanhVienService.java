package kituc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kituc.data.ThanhVienRepository;
import kituc.dto.KhachDto;
import kituc.dto.ThanhvienDto;
import kituc.entity.Khach;
import kituc.entity.Thanhvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThanhVienService {
	@Autowired
	private ThanhVienRepository svRepo;

	@Autowired
	private KhachService khachService;

	public ThanhvienDto convertToDto(Thanhvien thanhvien){
		ThanhvienDto thanhvienDto = new ThanhvienDto();
		thanhvienDto.setId(thanhvien.getId());
		thanhvienDto.setTen(thanhvien.getTen());
		thanhvienDto.setUserName(thanhvien.getUserName());
		thanhvienDto.setNgaysinh(thanhvien.getNgaysinh());
		thanhvienDto.setSoCMT(thanhvien.getSoCMT());
		thanhvienDto.setQuequan(thanhvien.getQuequan());
		thanhvienDto.setVitri(thanhvien.getVitri());
		thanhvienDto.setLop(thanhvien.getLop());
		List<KhachDto> khachDtoList = new ArrayList<>();
		for (Khach khach : thanhvien.getKhach()){
			khachDtoList.add(khachService.convertToDto(khach));
		}
		thanhvienDto.setKhachDtoList(khachDtoList);
		return thanhvienDto;
	}

	public Iterable<Thanhvien> findAllSinhvien(){
		return svRepo.findAllSinhvien();
	}
	
	public Iterable<Thanhvien> timSinhvien(String keyword){
		return svRepo.findAllByKey(keyword);
	}
	public Thanhvien checkLogin(String userName,String password){
		return svRepo.checkLogin(userName,password);
	}
	
	public Thanhvien sinhvienById(int id) {
		Optional<Thanhvien> optSv = svRepo.findById(id);
		if (optSv.isPresent()) {
			return optSv.get();
		}
		return null;
	}
	
	public Thanhvien luuSinhvien(Thanhvien sv) {
		return svRepo.save(sv);
	}
	public Thanhvien update(Thanhvien thanhvien){
		Optional<Thanhvien> byId = svRepo.findById(thanhvien.getId());
		if(!byId.isPresent()){
			//throw exception
			return null;
		}
		return byId.get();
	}
	
	public void xoaSinhvien(int id) {
		svRepo.deleteById(id);
	}
}
