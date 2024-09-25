package tan.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tan.app.entity.UserAccount;
import tan.app.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountRepo userAccRepo;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		
		Integer userId = userAcc.getUserId();
		
		userAccRepo.save(userAcc);
		
		if (userId == null) {
			return "User Record Saved";
			
		} else {
			return "User Record Updated";
		}
		
		
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		
		/*List<UserAccount> accounts= userAccRepo.findAll();
		return accounts; */
		
		return userAccRepo.findAll(); 
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		
		 Optional<UserAccount> findById = userAccRepo.findById(userId);
		
		 if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		
	/*	try {
			
			userAccRepo.deleteById(userId);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false; */
		
		boolean existsById = userAccRepo.existsById(userId);
		if (existsById) {
			userAccRepo.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		
		try {
			userAccRepo.updateUserAccStatus(userId, status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

}
