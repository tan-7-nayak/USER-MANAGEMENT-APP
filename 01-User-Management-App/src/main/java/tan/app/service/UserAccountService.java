package tan.app.service;

import java.util.List;

import tan.app.entity.UserAccount;

public interface UserAccountService {
	
	public String saveOrUpdateUserAcc(UserAccount userAcc); 
	
	public List<UserAccount> getAllUserAccounts();
	
	public UserAccount getUserAcc(Integer userId);

	public boolean deleteUserAcc(Integer userId); 
	
	public boolean updateUserAccStatus(Integer userId, String status);
	
}
