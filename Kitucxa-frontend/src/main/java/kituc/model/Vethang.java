package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vethang{
		
	private int id;
	
	private Date thang;
	
	private int solanguitoida;
	
	private Xe xe;

	private Dichvu dichvu;
}
