package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "UserID",nullable = false,length = 4)
    private String id;

    @Column(name = "Name",length = 20,nullable = false)
    private String name;

    @Column(name = "Address",nullable = false)
    private String address;

    @Column(name ="Email" ,nullable = false)
    private String email;

    @Column(name = "Username",length = 10,nullable = false)
    private String username;

    @Column(name = "Password",length = 8,nullable = false)
    private String password;

}
