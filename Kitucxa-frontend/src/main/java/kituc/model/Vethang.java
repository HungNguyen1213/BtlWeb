package kituc.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vethang extends Dichvu{
		
	private int id;
	
	private Date thang;
	
	private int solanguitoida;
	
	private Xe xe;	
}
