package kituc.service;

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
import kituc.entity.Khach;
import kituc.entity.Sinhvien;

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
