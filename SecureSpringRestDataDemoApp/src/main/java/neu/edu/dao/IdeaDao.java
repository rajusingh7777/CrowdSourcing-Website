package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.CreatorIdea;

@Repository
public interface IdeaDao extends JpaRepository<CreatorIdea, Integer>{
	
	
}
