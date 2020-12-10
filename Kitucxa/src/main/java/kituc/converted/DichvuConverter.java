package kituc.converted;

import org.springframework.stereotype.Component;

import kituc.dto.DichvuDto;
import kituc.entity.Dichvu;

@Component
public class DichvuConverter {
	
	public Dichvu toDichvuEntity(DichvuDto dvDto) {
		Dichvu dvE = new Dichvu();
		dvE.setId(dvDto.getId());
		dvE.setTen(dvDto.getTen());
		dvE.setDongia(dvDto.getDongia());
		dvE.setThoigiansddv(dvDto.getThoigiansddv());
		return dvE;
	}
	
	public DichvuDto toDichvuDto(Dichvu dvE) {
		DichvuDto dvDto = new DichvuDto();
		dvDto.setId(dvE.getId());
		dvDto.setTen(dvE.getTen());
		dvDto.setDongia(dvE.getDongia());
		dvDto.setThoigiansddv(dvE.getThoigiansddv());
		return dvDto;
	}
}
