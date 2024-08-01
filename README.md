# JPA 문법 이해를 위한 미션 문제 제작

<h2 style="font-size: 25px;"> 개발팀원👨‍👨‍👧‍👦💻<br>
<br>

|<img src="https://avatars.githubusercontent.com/u/175369539?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/98442485?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/79312705?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/175371231?v=4" width="150" height="150"/>|
|:-:|:-:|:-:|:-:|
|[@김성호](https://github.com/castlhoo)|[@이연희](https://github.com/LeeYeonhee-00)|[@김상민](https://github.com/isshomin)|[@오재웅](https://github.com/ohwoong2)|
---
<br>

# 프로젝트 개요

- JPA 문법 이해 향상
- JPA JOIN 문법 확인 및 JPQL 이해도 확인

<br>

# 학습 목적 

 - JPA JOIN 문법 관련 문제 출제를 통한 복습
 - JPQL 역량 강화

<br>


### ⁉️ 문제 1. 아래와 같이 실행 후 에러가 발생했다. 에러에 대해 분석하고, 해결책을 제시하라!
```java
ERROR!
-> javax.persistence.PersistenceException: org.hibernate.PropertyAccessException: Null value was assigned to a property 

@Test
public void test1() {
	EntityManager em = DBUtil.getEntityManager();

	Emp e = em.find(Emp.class, 7839);
	System.out.println(e);

	em.close();

	}
```

### ⁉️ 문제 2. 아래 JPQL 문장의 ? 에 알맞은 코드를 넣어라!
```java
@Test
public void test2() {
EntityManager em = DBUtil.getEntityManager();

  List<Emp> datas1 = em .createQuery("select e from Emp e join ? d where ?.ename = :ename and ?.deptno = :deptno", Emp.class)
			.setParameter("ename", "SMITH").setParameter("deptno", 20).getResultList();
		datas1.forEach(System.out::println);
		em.close();
	}
```


### ⁉️ 문제 3. 전략적으로 어떤 로딩 방식을 선택하면 좋을지 이유와 함께 설명해주세요! 
#### (다른 환경은 모두 동일하다고 가정)

```java
(Member.java)
		.....
		@ManyToOne
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="team_id") 
		
		System.out.println(m.getTeamId().getTeamName());
```
		최고사양
		CPU (코어 수 : 56 / 스래드 수 : 112 / 기본 클럭속도 : 2.0GHz)
		메모리 (용량 : 8TB / 클럭속도 : 6400 MHz)
		최저사양
		CPU (코어 수 : 2 / 스래드 수 : 2 / 기본 클럭속도 : 1.35GHz)
		메모리 (용량 : 2GB / 클럭속도 : 1066 MHz)

---




