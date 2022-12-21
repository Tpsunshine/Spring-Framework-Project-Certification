package co.edureka.application.interfaces;

import org.springframework.context.annotation.Bean;

import co.edureka.application.model.Party;

public interface PartyDaoIF {

	@Bean
	Party retrieveLoginDetails(Integer userId, String password);

	Party modifyRegistration(Party party, String password);

	Party retrievePartyDetails(Integer partyId);

}
