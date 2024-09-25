package tan.app.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAccount {

	@Id
	@GeneratedValue
	private Integer userId;
	
	private String fullName;
	
	private String email;
	
	private Long phno;
	
	private String gender;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	
	private Long ssn;
	
	private String activeSw= "Y";
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(insertable  = false)
	private LocalDate updatedDate;
	
	
}
