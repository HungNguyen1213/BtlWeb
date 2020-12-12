package kituc.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// vì ve tháng chứa object xe+ dich vụ
// nên phải tạo VeThangRequest chỉ chứa id của 2 object thôi
// sau đó tìm kiếm và add vào
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeThangRequest {
    private int thang;
    private int soLanGuiToiDa;
    private Integer dichVuId;
    private Integer xeId;
}
