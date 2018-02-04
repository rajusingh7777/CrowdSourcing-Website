package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	
	List<User> findByPersonPersonId(Integer personPersonId);
	User findByUsername(String username);
	

}
