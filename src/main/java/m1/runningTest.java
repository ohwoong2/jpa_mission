package m1;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import util.DBUtil;

public class runningTest {
	
	//javax.persistence.PersistenceException: org.hibernate.PropertyAccessException: Null value was assigned to a property 
	// 미션 1) 위의 에러 발생 -> 해결책 제시
	@Test
	public void test1() {
		EntityManager em = DBUtil.getEntityManager();

		Emp e = em.find(Emp.class, 7839);
		System.out.println(e);

		em.close();

	}
	
	@Test
	public void test2() {
		EntityManager em = DBUtil.getEntityManager();

		// 미션 2) 아래 JPQL 문장의 ? 를 추가해주세요
		List<Emp> datas1 = em
				.createQuery("select e from Emp e join ? d where ?.ename = :ename and ?.deptno = :deptno", Emp.class)
				.setParameter("ename", "SMITH").setParameter("deptno", 20).getResultList();
		datas1.forEach(System.out::println);
		em.close();

	}

	/*
	 * 미션 3) 다른 환경은 모두 동일한 상황에서 CPU 및 메모리 성능이 고성능인 경우와 저성능인 경우 전략적으로 어떤 로딩 방식을 선택하면 좋을지 이유와 함께 설명해주세요.
		(Member.java)
		.....
		 @ManyToOne
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="team_id")  //Team3의 pk 변수에 선언된 매핑된 컬럼명 -> fk 설정 명령어
		private Team4 teamId;
		(실행코드)
		System.out.println(m.getTeamId().getTeamName());//?
		최고사양
		CPU (코어 수 : 56 / 스래드 수 : 112 / 기본 클럭속도 : 2.0GHz)
		메모리 (용량 : 8TB / 클럭속도 : 6400 MHz)
		최저사양
		CPU (코어 수 : 2 / 스래드 수 : 2 / 기본 클럭속도 : 1.35GHz)
		메모리 (용량 : 2GB / 클럭속도 : 1066 MHz)
	 */
}
