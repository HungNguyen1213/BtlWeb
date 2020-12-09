package kituc.entity;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tblvethang")
public class Vethang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date thang;
    private int soLanGuiToiDa;
    @ManyToOne
    @JoinColumn(name = "dichVuId")
    private Dichvu dichvu;
    @OneToOne
    @JoinColumn(name = "xeId")
    private Xe xe;
}
