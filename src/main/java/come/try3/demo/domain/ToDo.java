package come.try3.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDo {

     @Id
     @GeneratedValue
     private int tid;

     private String name;
     private String desc;
     private String status;

    public ToDo(int tid, String name, String desc, String status) {
        this.tid = tid;
        this.name = name;
        this.desc = desc;
        this.status = status;
    }

    public ToDo() {

    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

