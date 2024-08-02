# JPA 문법 이해를 위해 스스로 문제 만들고 생각해보기

<h2 style="font-size: 25px;"> 스터디팀원👨‍👨‍👧‍👦✏
	
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
<details>
<summary> <h3 style="font-size: 10px;">🔥 문제 1. 답안</summary>
<br>

<p> "src/main/java/m1/Emp.java" 파일에 정의한 Emp class 수정</p>

```java
...
private int comm;
...
private int mgr;
...
```
<p> 실제 저장된 데이터를 보면 comm과 mgr에 null값인 데이터가 존재하기 때문에 에러 발생</p>
<p> -> 위의 항목을 Integer 객체로 수정</p>

<p>최종 답안)</p>

```java
...
private Integer comm;
...
private Integer mgr;
...
```
</details>
	
<br>
<br>


### ⁉️ 문제 2. 아래 JPQL 문장의 물음표(?)에 알맞은 코드를 넣어라!

<br>

```sql
select ename, e.deptno, dname
from emp e inner join dept d
on ename = 'SMITH' and d.deptno = 20;
``` 

<p align="left"><img src="https://github.com/user-attachments/assets/575d8a7d-a9ed-4d08-894b-3052b4a7442e"></p><br><br>

<details>
<summary> <h3 style="font-size: 10px;">🔥 문제 2. 답안</summary>

<p> Emp 객체의 deptno를 통해 Dept객체를 접근</p>

```java 
List<Emp> datas1 = em.createQuery("select e from Emp e join e.deptno d where e.ename = :ename and d.deptno = :deptno", Emp.class)
			.setParameter("ename", "SMITH").setParameter("deptno", 20).getResultList();
datas1.forEach(System.out::println);
``` 
</details>

<br>
<br>

### ⁉️ 문제 3. 전략적으로 어떤 로딩 방식을 선택하면 좋을지 이유와 함께 설명해주세요! 
#### ${\textsf{\color{red}(다른 환경은 모두 동일하다고 가정)}}$


```java
(Member.java)
		.....
		@ManyToOne // 1번
		@ManyToOne(fetch = FetchType.LAZY) // 2번
		@JoinColumn(name="team_id") 
		
		System.out.println(m.getTeamId().getTeamName());
```
		최고사양
		CPU (코어 수 : 56 / 스래드 수 : 112 / 기본 클럭속도 : 2.0GHz)
		메모리 (용량 : 8TB / 클럭속도 : 6400 MHz)
  
		최저사양
		CPU (코어 수 : 2 / 스래드 수 : 2 / 기본 클럭속도 : 1.35GHz)
		메모리 (용량 : 2GB / 클럭속도 : 1066 MHz)

<details>
<summary> <h3 style="font-size: 10px;">🔥 문제 3. 답안</summary>
<br>

<p>컴퓨터 사양에 따라 이 두 가지 로딩 전략을 적절히 선택하는 것이 중요</p>
<p>@ManyToOne -> 즉시 로딩: 데이터가 항상 필요하고 메모리와 CPU 자원이 충분한 경우 사용하면 도움이 될 수 있음</p>
<p>@ManyToOne(fetch = FetchType.LAZY) -> 지연 로딩: 데이터가 조건부로 필요하고 메모리와 CPU 자원이 제한적인 경우 사용하면 도움이 될 수 있음</p>

<p>결론) </p>
<p>즉시 로딩은 많은 데이터를 한 번에 메모리에 로드하므로 고성능 CPU와 대용량 메모리를 가진 시스템에서 유리</p>
<p>반면, 저성능 시스템에서는 메모리 부족이나 CPU 과부하 문제가 발생할 수 있음으로 지연 로딩 사용하는 것이 유리</p>


</details>



---

## 회 고 📝

### [김성호](https://github.com/castlhoo)
> JPA Join에 관해 개념이 불명확하고, 코딩을 하는 부분에 있어 다소 어려움이 있었는데 문제를 내고 서로 안에서 풀어보면서 Join에 대한 개념이 명확해졌으며, JPQL 문장 작성에도 다소 익숙해졌다. 
<br>

### [이연희](https://github.com/LeeYeonhee-00)
> JPA를 학습하며 헷갈렸던 JPQL문법에 대해 더 심도있게 이해할 수 있는 기회였다. 또한, 실제 데이터베이스와 연결해서 데이터를 주고받는 과정에서 확인해야할 사항들이 많다는 것을 느꼈다. 

<br>

### [김상민](https://github.com/isshomin)
> 알고 있던 지식들을 막상 문제로 만드려니 바로 도출되지 않아서 아직 다 습득하지 못했다는 것을 깨달았다. JPA에 대해 더 깊게 다시 생각해보는 과정을 통해서 복습하고 되돌아 보는 경험이 되어서 좋았고 inner join 뿐만 아니라 outer join와 같은 심화 개념에 도전해 봐야겠다고 생각했다.

<br>

### [오재웅](https://github.com/ohwoong2)
> JPA에서 데이터 타입이 중요하다는 것을 배울 수 있었다. JPQL 문법이 어색해서 어려움을 느꼈지만 팀원들의 도움으로 배울 수 있는 기회였다. JPA가 어렵다는 것을 알 수 있었고 계속해서 학습해서 익숙해질 수 있게 돼야 한다 생각했다.

---



