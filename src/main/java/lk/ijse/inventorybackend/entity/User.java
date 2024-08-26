package lk.ijse.inventorybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data
public class User {
    private String id;
    private String user_name;
    private String password;
}
