package kituc.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kituc.data.KhachReponsitory;
import kituc.data.NgaydenReponsitory;
import kituc.entity.Khach;
import kituc.entity.Ngayden;
import kituc.entity.Sinhvien;

@Service
public class KhachService {
	@Autowired
	private KhachReponsitory khachRep;
	@Autowired
	private NgaydenReponsitory ngaydenRep;

	public Iterable<Khach> getAllKhach() {
		return khachRep.findAll();
	}
	
	public Iterable<Khach> getClientByIdSv(int id){
		return khachRep.getAllClientBySvId(id);
	}
	
	public Khach save(Khach k){
		return khachRep.save(k);
	}
	
	public List<Ngayden> saveNgayden(List<Ngayden> n) {
		return ngaydenRep.saveAll(n);
	}
	
	public List<Khach> findKhachByName(String name, int sinhvienid){
		return khachRep.findKhachByName(name, sinhvienid);
	}
	
	public void deleteById(int id) {
		khachRep.deleteById(id);
	}
	
	public Khach findKhachById(int id) {
		Optional<Khach> khach = khachRep.findById(id);
		if(khach.isPresent()) {
			return khach.get();
		}
		return null;
	}
}
