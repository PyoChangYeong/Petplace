# Pet Place

프로젝트명 : Pet Place (P.P) 프로젝트 설명 : 사업자는 반려동물에 관한 업체(병원,미용,카페)를 등록하고, 유저가 검색, 필터링 할 수 있는 웹페이지 (위치기반정보제공 서비스)

노션 링크 : https://bow-starfish-ba2.notion.site/Team3-Pet-Place-7d132d0dc6764eee90799fe342dec49f

# 프로젝트 소개   

유저의 위치에 따른 반려동물 관련 시설 및 동반시설에 대한 정보를 제공하고 추천합니다.
검색 및 정렬을 사용하여 플레이스를 조회할 수 있습니다.
방문 시설에 대한 후기를 작성하고, 평가를 할 수 있습니다.
사업자의 경우 업체를 등록하고 홍보하며, 후기에 대한 알림을 확인할 수 있습니다.

## 👤 FE/BE 팀 정보

| 이름     | FE/BE           | Github                           |
| -------- | --------------- | -------------------------------- |
| 남궁윤서 | FE , Sub-Leader | https://github.com/lionloopy     |
| 신은진   | FE              | https://github.com/JESin10       |
| 이건호   | BE, Leader      | https://github.com/Kuno1734      |
| 김우영   | BE              | https://github.com/micheal1woo   |
| 표창영   | BE              | https://github.com/PyoChangYeong |


## 📚 기술스택

<div align="center">
	<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat&logo=Spring Boot&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat&logo=Spring Security&logoColor=white" />
  <img src="https://img.shields.io/badge/Amazon S3-569A31?style=flat&logo=Amazon S3&logoColor=white" />
  <img src="https://img.shields.io/badge/Amazon RDS-527FFF?style=flat&logo=Amazon RDS&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white" />
  <img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=flat&logo=Amazon EC2&logoColor=white" />
  <img src="https://img.shields.io/badge/Linux-FCC624?style=flat&logo=linux&logoColor=white" />
  <img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=flat&logo=github Actions&logoColor=white" />
  <img src="https://img.shields.io/badge/Ubuntu-E95420?style=flat&logo=ubuntu&logoColor=white" />

</div>

## ⚙️ 협업 Tools
<div>
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white" />
  <img src="https://img.shields.io/badge/Slack-4A154B?style=flat&logo=slack&logoColor=white"/>
  <img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=notion&logoColor=white"/>
</div>

## 📝 아키텍쳐

![1](https://user-images.githubusercontent.com/107843779/233069317-4c3051d3-626a-4da0-b93e-740d4ea8dbb4.png)


## 💡 주요기능

### 1. 유저/사업자별 회원가입
### 2. 로그인/로그아웃
### 3. 소셜(카카오)로그인
### 4. 근거리기반 장소 확인
### 5. 카테고리별 게시글 정렬 (무한스크롤 적용)
### 6. 근거리순 / 별점순 / 후기순 정렬
### 7. 업체명 / 내용 / 장소 기반의 검색
### 8. 찜하기 및 찜하기 취소
### 9. 지도 내의 업체 위치 확인 및 길찾기 연결
### 10. 후기 및 별점 등록
### 11. 프로필이미지 및 닉네임 수정
### 12. 댓글 및 찜목록 조회 / 수정 / 삭제
### 13. 등록 업체 모아보기 및 수정



## 🏗️ API명세서

<div align="center">
<img width=70% src=https://user-images.githubusercontent.com/107843779/232747808-52219ec5-a182-42af-a466-a9203bb2e32e.png >

[API 명세서 상세보기](https://bow-starfish-ba2.notion.site/API-5843adb55eb34576be3bfd447d8269f3)
</div>


## 🧱 ERD

<div align="center">
<img width="70%" alt="스크린샷 2023-04-18 오전 2 43 48" src="https://user-images.githubusercontent.com/107843779/232655250-e93b3cb3-68dd-45bc-bee0-49279482f5e7.png">
</div>

## 🔗 와이어 프레임

<div align="center">
<img width="70%" alt="1" src="https://user-images.githubusercontent.com/107843779/232656078-f32b5829-1db7-4fc8-a9bc-528801995fda.png">
<img width="70%" alt="2" src="https://user-images.githubusercontent.com/107843779/232656083-3951d433-8741-43cd-90ab-268866118d71.png">
</div>

## 🔎 참고 링크

- [협업 노션 페이지](https://jin29.notion.site/e1fbb1aaf8b94ee1a2b265eeb347ccb8?v=abae7a28c2d84bcdb71da069beaa933e)
- [BE 진행 현황 페이지](https://bow-starfish-ba2.notion.site/a311d9a7965d46bd82da973e33b446ca)

## ⁉️ Trouble Shooting

### 1. - 리눅스 권한
    
    문제상황
    
    - CodeDeploy를 통해서 CICD를 구축해서 AWS EC2에 Spring Server를 배포.
    - FE서버와의 연결상태 확인.
    - 게시글 작성에서 이미지를 리스트로 업로드하는 부분이 서버상에서 작동하지 않는다..
    
    에러코드
    
    - java.io.ioexception: permission denied
    - ??? 갑자기 이게 무슨일인가 했다.
    
    시도 및 확인
    
    - Local환경에서 Test 결과 - 성공
    - 서버 환경에서 Test결과 - 실패
    - 어떤 변수값에 의한 문제발생인지 파악이 필요했다.
    - 대부분의 기능들이 정상적으로 작동하나 이미지 업로드와 관련된 부분에서 동일한 에러가 발생함을 확인.
        - 이미지 사이즈에 의한 문제인가? - 아니다 - 로컬상에도 사이즈를 줄여서 해봤지만 지정한 예외가 처리되게 되어있다.
        - 이미지 용량에 의한 문제인가? - 아니다 - 로컬상에서 도합 10MB넘는 용량을 업로드하면 지정한 예외가 처리되었다.
    - 코드나 기능상에서 예상할 수 있는 문제는 모두 아닌것으로 생각되었다.
    - 환경이나 설정의 문제라고 생각.
    - 권한이라는 단어에 집중했다 -> 어디의 권한인가? -> 서버상의 권한일것 -> 서버는 어디인가? -> 우분투 서버이며 이는 리눅스 기반의 서버이다.
    - 시도1. 현재 ubuntu 에서 사용자 권환상태를 확인.
    - 시도2. 권한 침범이 예상되는 경로에 chmod 755 -R /경로 를 사용해서 권한 업데이트 후 메서드 실행 - 실패
    
    해결
    
    - appspec.yml에서 petmissions 부분을 변경.
	version: 0.0
	os: linux

	files:
	  - source:  /
	    destination: /home/ubuntu/app
	    overwrite: yes

	permissions:
	  - object: /
	    pattern: "**"
	    owner: ubuntu -> root 로 변경
	    group: ubuntu

	hooks:
	  AfterInstall:
	    - location: scripts/stop.sh
	      timeout: 60
	      runas: ubuntu
	  ApplicationStart:
	    - location: scripts/start.sh
	      timeout: 60
	      runas: root
	      
### 2. - 카카오로그인 구현 중 잘못된 접근 토큰 오류 발생
    
    문제
    
    1. 프론트에서 localhost:3000으로 시도를 하였을때 1명은 되고 1명은 안되는 현상 그래서 배포 이후에 다시 구현하기로 결정
    2. 프론트 배포 후 리다이렉트uri를 프론트 배포 사이트에 맞추니 오류 시작
    
    시도
    
    1. BackEnd에 있는 KakaoService 코드 전체 리팩토링
    2. 리다이렉트 변경 후 시도
    3. 카카오devtalk 문의
    
    해결
    
    카카오 내애플리케이션에서 허용IP를 확인해보니 저번에 이것저것 만저보다가 실수로 추가했던 허용IP들 때문에 안됐습니다. 그래서 삭제 후 시도하니 작동

### 3. - 서버 터짐 현상?
    
    문제
    
    CI/CD 진행 후 다음날이 되니 서버가 작동을 하지 않고 있었습니다. 개발자모드로 console을 찍어보니 CORS현상
    
    시도
    
    1차 시도 : EC2 중지 후 재시작
    
    2차 시도 : setAllowedOrigins으로 허용
    
    해결
    
    WebConfig 클래스에 securityFilterChain안에 cors.setAllowedOrigins(List.of(”https://fe-fawn.vercel.app”));을 추가하니 CORS문제가 해결됐습니다.
    
### 4. - Nginx 언더스코어(_)가 포함된 헤더를 제거하는 현상
    
    문제상황
    
    - public static final *String* REFRESH_TOKEN = "Refresh_token";
    - Refresh_token을 선언하여 Response header에 추가해주는 로직.
    - Local 환경에서 테스트를 진행시  header에 "Refresh_token" 이 정상적으로 들어온것을 확인.
    - 배포된 서버에서 Refresh_token 을 갱신할때 문제 발생.
    - Refresh_token을 갱신할때 HttpServletRequest header 에서 값을 읽어 와야하는데 로그를 전부 찍어보니 Refresh_token 이 추가되어 들어오지 않았다.
    
    시도
    
    - 1차 : Refresh_token이 들어가는 모든부분에 log를 찍어서 어떤 부분에서 진행이 되지 않는지 확인.
    - 2차 : PostMan에서 임의의 값을 header에 포함시켜서 호출시 → Response header에 확인됨.
    - 3차 : 문자에 대한 이상이 아닌 특수문자를 의심하여 Refresh_token 선언을 변경 → RefreshToken → 정상적으로 Response header 에 정상적으로 추가됨을 확인.
    
    검증
    
    - 언더스코어("RefreshToken_Id")를 추가해서 실험해본 결과 헤더에 추가가 되지 않는 현상을 확인.
    
    확인
    
    - 클라이언트와 응답과 요청을 받을때 배포서버는 Nginx를 거치게 되는대 Nginx에서 헤더에 언더스코어( _ )가 포함된 경우 제거하는 설정이 디폴트값으로 되어 있었다.
    - 설정을 통해서 언더스코어를 허용할 수 있다.
    - conf/nginx.conf에 다음 설정을 추가하면 허용할 수 있다.
    - underscores_in_headers on;

### 5. - GitHub
    
    문제 : Commit → Push → margin → 풀을 받은 후 확인 했지만 인텔리제이에 안들어옴
    
    시도 : 풀을 3번 받아보고 새로고침도 해보았지만 실패
    
    해결 : 인텔리제이에서 main폴더에 오른쪽마우스버튼 클릭후 ‘디스크에서 다시로드’을 클릭하니까 margin한 자료가 나왔습니다.
    
### 6. - **DB 데이터 오류**
    
    발생상황
    
    1. 게시글 작성 기능이 작동하다가 갑자기 게시글 작성할 때 오류 발생
    2. 게시글 수정을 시도해봤는데 수정도 실패
    3. 로그를 확인해보니 SQL 구문에서 에러 발생
    4. DB를 확인해보니 작성한 게시글이 DB에 들어가지 않음
    5. 필요하지 않은 Colum이 생성되어 있음
    6. 초반에 구현할때 mapdata라는 컬럼을 만들었다가 지운적이 있음
    7. mapdata가 계속 발생하지는 않지만 잊을만할때 발생함
    
    에러코드
    
    could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement”
    
    데이터베이스 제약 조건 위반으로 인해 발생한 것으로 확인
    
    시도
    
    1. DB에 mapdata컬럼을 drop으로 삭제
    2. 데이터베이스를 전체 Drop으로 밀어본적 있음
    3. DB저장 방식을 updata를 validata로 바꾸었음
    4. postman으로 테스트 시에 누군가 mapdata가 남아있을 가능성
    5. JPA ORM 자동스키마 생성 기능을 사용할 경우,데이터베이스 스키마가 애플리케이션 실행 중 자동으로 생성되거나 업데이트 될 가능성
    
    해결방법
    
    1. validata로 변경 후 현재까지는 발생한적 없지만 원인은 updata로 추측됨
    2. updata를 쓸 경우 여러가지 문제가 있을 수 있음
    — 일관성 문제 : 일부 필수 데이터가 누락될 가능성
    — 동시성 문제 : 여러 사용자가 동시에 데이터를 업데이트하려고 할 때, 동시성 문제가 발생      할 수 있음
    3. postman 에 mapdata가 남아있는지 확인 후 삭제
    4. 만약 validata로 바꿨는데 그래도 컬럼이 재생성되면 JPA ORM에서 데이터베이스 스키마를 자동으로 생성하거나 업데이트할 때 이 과정에서 예기치 않은 컬럼이 생성할 수도 있으며, 생성되는 컬럼은 애플리케이션 코드에서 생성하지 않은 컬럼일 수 있으며, 이는 데이터베이스 스키마를 자동으로 생성하거나 업데이트할 때 JPA ORM이 알아서 생성한 컬럼일 수 있습니다. 그래서 자동 스키마 생성 기능을 사용하지 않고, 수동으로 스키마를 변경하는 방법을 사용하여 데이터베이스 스키마를 관리하는 것으로 해결할 예정입니다.

