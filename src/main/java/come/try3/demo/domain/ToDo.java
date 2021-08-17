package come.try3.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;

    private String name;
    private String desc;
    private String status;

    //@ManyToOne(cascade = CascadeType.ALL)
    private int uid;
}
