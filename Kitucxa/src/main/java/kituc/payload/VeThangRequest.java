package kituc.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
// vì ve tháng chứa object xe+ dich vụ
// nên phải tạo VeThangRequest chỉ chứa id của 2 object thôi
// sau đó tìm kiếm và add vào
@Data
@AllArgsConstructor
public class VeThangRequest {
    private Integer id;
    private int thang;
    private int soLanGuiToiDa;
    private Integer dichVuId;
    private Integer xeId;
}
