package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

}
