package kituc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kituc.data.KhachReponsitory;
import kituc.entity.Khach;

@Service
public class KhachService {
	@Autowired
	private KhachReponsitory khachRep;

	public Iterable<Khach> getAllKhach() {
		return khachRep.findAll();
	}
	
	public Iterable<Khach> getClientByIdSv(int id){
		return khachRep.getAllClientBySvId(id);
	}
}
