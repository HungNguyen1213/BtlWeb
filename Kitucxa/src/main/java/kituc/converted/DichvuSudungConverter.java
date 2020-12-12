package kituc.converted;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kituc.dto.DichvuSudungDto;
import kituc.entity.DichvuSudung;

@Component
public class DichvuSudungConverter {
	
	@Autowired
	DichvuConverter DvCvt;
	
	public DichvuSudung toDichvuSudungEntity(DichvuSudungDto dvsdDto) throws ParseException {
		DichvuSudung dvsdE = new DichvuSudung();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dvsdE.setId(dvsdDto.getId());
		dvsdE.setDichvu(DvCvt.toDichvuEntity(dvsdDto.getDichvu()));
		dvsdE.setSinhvien(dvsdDto.getSinhvien());
		dvsdE.setDongia(dvsdDto.getDichvu().getDongia());
		dvsdE.setThoigiansddv(dvsdDto.getDichvu().getThoigiansddv());
		dvsdE.setThoigianbd(formatter.parse(dvsdDto.getThoigianbd()));
		dvsdE.setThoigiankt(formatter.parse(dvsdDto.getThoigiankt()));
		return dvsdE;
	}
	
	public DichvuSudungDto toDichvuSudungDto(DichvuSudung dvsdE) {
		DichvuSudungDto dvsdDto = new DichvuSudungDto();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dvsdDto.setId(dvsdE.getId());
		dvsdDto.setDichvu(DvCvt.toDichvuDto(dvsdE.getDichvu()));
		dvsdDto.setSinhvien(dvsdE.getSinhvien());
		dvsdDto.setDongia(dvsdE.getDongia());
		dvsdDto.setThoigiansddv(dvsdE.getThoigiansddv());
		dvsdDto.setThoigianbd(formatter.format(dvsdE.getThoigianbd()));
		dvsdDto.setThoigiankt(formatter.format(dvsdE.getThoigiankt()));
		return dvsdDto;
	}
}
