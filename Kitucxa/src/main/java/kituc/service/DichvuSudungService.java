package kituc.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kituc.converted.DichvuSudungConverter;
import kituc.data.DichvuSudungRepository;
import kituc.dto.DichvuSudungDto;
import kituc.entity.DichvuSudung;

@Service
public class DichvuSudungService {
	@Autowired
	private DichvuSudungRepository dvsdRepo;
	
	@Autowired
	private DichvuSudungConverter dvsdCvt;
	
	public DichvuSudung luuDvsd(DichvuSudungDto dvsd) throws ParseException {
		return dvsdRepo.save(dvsdCvt.toDichvuSudungEntity(dvsd));
	}
	
	public List<DichvuSudungDto> getBySinhvienId(int id){
		List<DichvuSudung> listDvsdE =  dvsdRepo.findBySinhvienId(id);
		List<DichvuSudungDto> listDvsdDto = new ArrayList<>();
		for(DichvuSudung dvsd : listDvsdE) {
			listDvsdDto.add(dvsdCvt.toDichvuSudungDto(dvsd));
		}
		return listDvsdDto;
	}
}
