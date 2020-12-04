package kituc.model;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Xe {

	private int id;

	private String bienso;

	private String loaixe;

	private Vethang vethang; 
	
	private List<Xegui> xegui = new ArrayList<>();
	
}
