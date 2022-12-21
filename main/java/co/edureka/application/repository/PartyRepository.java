package co.edureka.application.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edureka.application.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Serializable> {

	
	@Query(value = "select * from party_details where party_id= ?", nativeQuery = true)
	Party fetchPartyDetails(@Param("party_Id") Integer partyId);

	@Query(value = "select party_id from party_details where user_id= ?", nativeQuery = true)
	Integer findPartyByUserId(@Param("user_Id")int userId);

}
