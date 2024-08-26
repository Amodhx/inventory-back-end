package lk.ijse.inventorybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_detailDTO {
    private int order_id;
    private int item_id;
}
