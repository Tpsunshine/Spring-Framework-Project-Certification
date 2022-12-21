package co.edureka.application.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import co.edureka.application.interfaces.PartyDaoIF;
import co.edureka.application.model.Login;
import co.edureka.application.model.Party;
import co.edureka.application.repository.LoginRepository;
import co.edureka.application.repository.PartyRepository;

@Service
@Transactional
public class PartyDaoImpl implements PartyDaoIF {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private PartyRepository partyRepo;
	
	public void addNewRegistration(Party party) {
		
	}

	@Override
	public Party retrieveLoginDetails(Integer userId, String password) {
		Party party = new Party();
			try {
				String response = loginRepository.fetchLoginDetais(userId, password);

				String[] res = response.split(",");
				
				party.setPartyId((Integer.parseInt(res[0])));
				party.setFirstName(res[1]);
				
			} catch(Exception e) {
				//e.getMessage()
			}
				
			return party;
			
	}

	
	public Party modifyRegistration(Party party, String password) {

		Login login = new Login();
		login.setPassword(password);
		Login newLogin= loginRepository.save(login);
		party.setUserId(newLogin.getUserId());
		Party newParty = partyRepo.save(party);
		return newParty;
	}

	public Party retrievePartyDetails(Integer partyId) {

		Optional<Party> party = partyRepo.findById(partyId);
		return party.get();
	}
}
