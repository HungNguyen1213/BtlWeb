package kituc.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeThangRequest {
//    private Integer id;
    private int thang;
    private int soLanGuiToiDa;
    private Integer dichVuId;
    private Integer xeId;
}
