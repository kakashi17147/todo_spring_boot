package come.try3.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserLogin {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int user_id;

       private String username;
       private String password;

       //@OneToMany(mappedBy = "userlogin")
       //private List<ToDo> todos;


//       public UserLogin(int user_id, String username, String password) {
//              this.user_id = new Random().nextInt(1000);
//              this.username = username;
//              this.password = password;
//       }
}
