package lk.ijse.inventorybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private int id;
    private String product_name;
    private String buy_price;
    private String sel_price;
    private String expire_date;
    private String qty;
    private String brand;
}
