package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.StartupServices;

@Repository
public interface StartupDao extends JpaRepository<StartupServices, Integer>{
	
}
