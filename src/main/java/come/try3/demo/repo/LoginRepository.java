package come.try3.demo.repo;

import come.try3.demo.domain.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserLogin,Integer> {

      UserLogin findByUsernameAndPassword(String username,String password);

}
