package tan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import tan.app.entity.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

	@Transactional
	@Modifying
	@Query("update UserAccount set activeSw=:status where userId=:userId")
	public void updateUserAccStatus(Integer userId, String status);
}
