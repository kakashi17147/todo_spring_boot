package come.try3.demo.repo;

import come.try3.demo.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
     List<ToDo> findByUid(int uid);
      //List<ToDo> findByName(String name);
}
