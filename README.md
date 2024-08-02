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

---

# Entity

## Emp Table

|Field      |Type        |Null|Key|Default|Extra|  
|-----------|------------|----|---|-------|-----|
|EMPNO |int         |NO  |PRIMARY KEY   |       |     |
|COMM   |int         |YES |   |       |     |
|ENAME     |String         |YES |   |       |     |
|JOB       |String |YES |   |       |     |
|HIERDATE     |String |YES |   |       |     |
|SAL        |int      |YES |   |       |     |
|MGR      |int         |YES |   |       |     |
|DEPTNO      |int         |YES |FOREIGN KEY   |       |     |

<br>

## Dept Table

|Field      |Type        |Null|Key|Default|Extra|  
|-----------|------------|----|---|-------|-----|
|DEPTNO |int         |NO  |PRIMARY KEY   |       |     |
|DNAME   |String         |YES |   |       |     |
|LOC     |String         |YES |   |       |     |


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

<br>
<br>

### ⁉️ 문제 2. 아래 JPQL 문장의 물음표(?)에 알맞은 코드를 넣어라!

<br>

<p align="left"><img src="https://github.com/user-attachments/assets/575d8a7d-a9ed-4d08-894b-3052b4a7442e"></p><br><br>

<br>

### ⁉️ 문제 3. 전략적으로 어떤 로딩 방식을 선택하면 좋을지 이유와 함께 설명해주세요! 
#### ${\textsf{\color{red}(다른 환경은 모두 동일하다고 가정)}}$


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

## 회 고 📝

### [김성호](https://github.com/castlhoo)
> JPA Join에 관해 개념이 불명확하고, 코딩을 하는 부분에 있어 다소 어려움이 있었는데 문제를 내고 서로 안에서 풀어보면서 Join에 대한 개념이 명확해졌으며, JPQL 문장 작성에도 다소 익숙해졌다. 
<br>

### [이연희](https://github.com/LeeYeonhee-00)
> logstash config파일에서 filter를 사용하여 데이터 전처리 하는 법을 연습할 수 있어서 좋았다. 또한, mysql + ELK pipeline 환경 구축을 하며 연결되어 값이 들어오는 것을 확인하고 kibana로 시각화해보는 과정이 재미있었다. 

<br>

### [김상민](https://github.com/isshomin)
> 알고 있던 지식들을 막상 문제로 만드려니 바로 도출되지 않아서 아직 다 습득하지 못했다는 것을 깨달았다. JPA에 대해 더 깊게 다시 생각해보는 과정을 통해서 복습하고 되돌아 보는 경험이 되어서 좋았고 inner join 뿐만 아니라 outer join와 같은 심화 개념에 도전해 봐야겠다고 생각했다.

<br>

### [오재웅](https://github.com/ohwoong2)
> JPA에서 데이터 타입이 중요하다는 것을 배울 수 있었다. JPQL 문법이 어색해서 어려움을 느꼈지만 팀원들의 도움으로 배울 수 있는 기회였다. JPA가 어렵다는 것을 알 수 있었고 계속해서 학습해서 익숙해질 수 있게 돼야 한다 생각했다.

---



