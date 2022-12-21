package co.edureka.application.repository;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edureka.application.model.Login;
import co.edureka.application.model.Party;

@Repository
public interface LoginRepository extends JpaRepository<Login, Serializable> {
	
	
	@Query(value = "select party_id, first_name from party_details where user_id = (select user_id from login_details where user_id = ?1 and password = ?2)", nativeQuery = true) 
	String fetchLoginDetais(@Param("user_Id") Integer userId, @Param("password") String password);

	
	//@Query(value = "Inset into Login_Details values (?1, ?2)")
	//Integer modifyLogin(@Param("password") String password);
		
		
		
	
	

}
