package kituc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
