package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.FunderPayment;


@Repository
public interface FunderDao extends JpaRepository<FunderPayment, Integer>{

}

