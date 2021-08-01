package kituc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachDto {
    private int id;
    private String soCMT;
    private String ten;
    private String ngayden;
    private String ngaysinh;
    private int idThanhvien;

}
