package lk.ijse.inventorybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int id;
    private int customer_id;
    private String customer_name;
    private String date;
    private String amount;
    private String type;
}
