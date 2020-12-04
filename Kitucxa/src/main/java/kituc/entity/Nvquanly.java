package kituc.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="nvquanly")
@Embeddable
public class Nvquanly extends Thanhvien{

}
