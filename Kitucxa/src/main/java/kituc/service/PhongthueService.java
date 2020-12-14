package kituc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kituc.data.PhongthueRepository;

@Service
public class PhongthueService{
	
	@Autowired
	private PhongthueRepository PtRep;
	
	
}
