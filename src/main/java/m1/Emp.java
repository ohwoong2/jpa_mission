package m1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Emp {
	@Id
	private int empno;
	
	private int comm;
	
	private String ename;
	
	private String hiredate;
	
	private String job;
	
	private int mgr;
	
	private int sal;
	
	@ManyToOne
	@JoinColumn(name="deptno")
	private Dept deptno;



}
