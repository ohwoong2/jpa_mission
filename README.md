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
> 기존 가상머신에 설치를 하려했다가, 문제가 있다면 빨리 새로 설치하는 것도 방법이라는 것을 깨달았다. 필터를 통해 내가 원하는 데이터가 나올 수 있도록 하는 것이 신기하면서도, 코드에 대해 빨리 공부를 해야겠다고 생각했다.
<br>

### [이연희](https://github.com/LeeYeonhee-00)
> logstash config파일에서 filter를 사용하여 데이터 전처리 하는 법을 연습할 수 있어서 좋았다. 또한, mysql + ELK pipeline 환경 구축을 하며 연결되어 값이 들어오는 것을 확인하고 kibana로 시각화해보는 과정이 재미있었다. 

<br>

### [김상민](https://github.com/isshomin)
> 키바나를 통해 visualize 할 때 아직 기능에 대한 것이 많이 미숙하다고 느꼈다. 한 번 만들었던 표를 여러 번 반복해서 만들면서 반복숙달로 통해 점점 익숙해져가는 느낌이 들었다. 다른 팀 발표를 보면서 전처리 과정이 sql을 이용하든 logstash를 이용하든 다양하게 할 수 있다는 것을 깨달았다.

<br>

### [오재웅](https://github.com/ohwoong2)
> 환경 구축부터 시각화까지 했으나 그중 Logstash의 필터 기능으로 데이터를 처리하는 과정이 가장 인상 깊었습니다. 시각화를 통해 데이터를 표현하는 과정을 더 잘할 수 있었을 것 같은데 그러지 못해서 아쉬웠습니다. 가설을 검증하는 과정들이 재미있었어요

---



