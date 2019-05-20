# spring-todo
SpringBoot를 이용해 구현한 TODO list 입니다.

![todo-list-capture-1](https://user-images.githubusercontent.com/45555378/58020103-262c3480-7b42-11e9-86ce-83bfeb9c9a2c.png)

## 빌드 환경
jdk 1.8
Maven 3.6.0

## 빌드 방법 
 프로젝트를 클론합니다.
 ~~~
 git clone https://github.com/misudev/spring-todo.git
 ~~~
 
 Maven을 설치합니다.
 
 ~~~
 sudo apt install maven
 ~~~
 
 프로젝트 폴더로 이동 한 후 Maven으로 빌드합니다. ( 테스트 제외 )
 
 ~~~
 mvn packpage -Dmaven.test.skip=true
 ~~~
 
 jar 파일을 실행시킵니다.
 
 ~~~
 java -jar target/spring-todo-0.0.1-SNAPSHOT.jar
 ~~~
 
 
## 주요 기능

 ** 1. TODO 추가하기 **

