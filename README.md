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
 #### 1. TODO 추가하기
![FireShot Capture 007 - spring-todo - 52 78 203 121](https://user-images.githubusercontent.com/45555378/58023484-def67180-7b4a-11e9-83d3-e22fdeeb7389.png)
![todo-list-capture3](https://user-images.githubusercontent.com/45555378/58023478-d867fa00-7b4a-11e9-850a-439cbf118f91.png)

 * 'TODO 추가' 버튼을 눌러 새로운 TODO를 작성할 수 있습니다.
 * 마감기한은 오늘부터 그 이후로 선택할 수 있습니다.
 * 우선순위를 High, Medium, Low 중 선택할 수 있습니다.
 * 우선순위를 선택하지 않으면 기본 Low값이 , 마감기한을 선택하지 않으면 기본으로 오늘 날짜로 저장됩니다.
 #### 2. TODO 수정하기
 * '수정' 버튼을 눌러 해당 TODO를 수정할 수 있습니다.
 #### 3. TODO 삭제하기
 * '삭제' 버튼을 눌러 해당 TODO를 삭제할 수 있습니다.
 #### 4. TODO 완료하기
 * 체크박스를 누르면 해당 TODO가 완료됩니다.
 #### 5. TODO 목록
 * TODO list는 한 페이지 당 5개의 TODO가 보여집니다.
 * 정렬은 가장 최근에 등록한 TODO부터 내림차순으로 정렬됩니다.
 * next , previous 버튼을 눌러 다음 페이지, 이전 페이지 목록을 볼 수 있습니다.
#### 6. TODO 알람
 * 처음 접속하면 마감기한이 지났는데 완료되지 않은 TODO 제목들을 알람으로 띄웁니다.
