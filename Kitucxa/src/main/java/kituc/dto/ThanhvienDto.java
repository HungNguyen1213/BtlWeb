package kituc.dto;

import kituc.entity.Khach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThanhvienDto {

    private int id;
    private String ten;
    private String soCMT;
    private String quequan;
    private String ngaysinh;
    private String vitri;
    private String userName;
    private String lop;
    private List<KhachDto> khachDtoList;

}
