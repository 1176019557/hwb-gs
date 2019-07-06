package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hwb
 * @since 2019-04-29
 */
@TableName("medicine_info")
public class MedicineInfo extends Model<MedicineInfo> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @TableField("medicine_name")
    private String medicineName;
    @TableField("medicine_price")
    private String medicinePrice;
    @TableField("medicine_value")
    private String medicineValue;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineValue() {
        return medicineValue;
    }

    public void setMedicineValue(String medicineValue) {
        this.medicineValue = medicineValue;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MedicineInfo{" +
        ", id=" + id +
        ", medicineName=" + medicineName +
        ", medicinePrice=" + medicinePrice +
        ", medicineValue=" + medicineValue +
        "}";
    }
}
