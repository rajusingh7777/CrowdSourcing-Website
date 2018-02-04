package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
	
	public List<Role> findByRoleName(String roleName);

}
