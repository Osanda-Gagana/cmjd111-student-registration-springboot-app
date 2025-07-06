package lk.ijse.cmjd_111.CourseRegistration2025.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserDTO implements Serializable {
    private String  userId;
    private String  password;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String  addressLine1;
    private String  addressLine2;
    private String  addressLine3;
    private String  city;
    private Role role;
}
