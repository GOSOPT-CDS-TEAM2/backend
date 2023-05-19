# backend
GOSOPT 합동세미나 웹 2조 서버

## 👩‍👧‍👧 Our Team

|                **🍀 [박수린](https://github.com/RinRinPARK)**                 |                **🍀 [김성은](https://github.com/sung-silver)**                 |
  |:-----------------------------------:|:-----------------------------------:|
| <img src="https://avatars.githubusercontent.com/u/87180069?v=4" width="300" height="300" /> |<img src ="https://avatars.githubusercontent.com/u/81363864?v=4" width="300" height="300" /> |
|                                 Server Developer                                  |                               Server Developer                              |
|        프로젝트 세팅<br /> Brand API, Main API<br />       |       회의록 작성<br /> Cart API, Main API<br />         |

## 🔨 Project Structure
```
├─📁 main
│  ├─📁 java
│  │  └─📁 sopt
│  │      └─📁 org
│  │          └─📁 oliveyoungServer
│  │              ├─📁 common
│  │              │  ├─📁 advice
│  │              │  └─📁 dto
│  │              ├─📁 controller
│  │              │  └─📁 dto
│  │              │      ├─📁 request
│  │              │      └─📁 response
│  │              ├─📁 domain
│  │              ├─📁 exception
│  │              │  └─📁 model
│  │              ├─📁 infrastructure
│  │              └─📁 service
│  └─📁 resources
│      ├─static
│      └─templates
└─📁 test

```



## 🛠️ ERD
<img src="https://github.com/GOSOPT-CDS-TEAM2/backend/assets/87180069/eb051ba0-c286-4dba-85ab-da38a6b3c467" />



## 🌳 Branch

🌱 git branch 전략

`main branch` : 배포 단위 branch

`dev branch` : 주요 개발 branch, main merge 전 거치는 branch

`feat branch`: 각자 개발 branch

- 할 일 issue 등록 후 issue 번호와 isuue 이름으로 branch 생성 후 작업
  - ex) FEAT/#`issue num`-`isuue name`
- 해당 branch 작업 완료 후 PR 보내기
  - 항상 local에서 충돌 해결 후 → remote에 올리기
  - reviewer에 서로 tag후 code-review
  - comment 전 merge 불가!
  - review반영 후, 본인이 merge.

### 🌳 branch 구조

```jsx
- main
- dev
- feat
   ├── #1-isuue name1
   └── #2-isuue name2
```

</aside>
<hr>
</br>

## 🧵 Commit Convention

<aside>
📍  git commit message convention

ex) [FEAT]#32 - getDetailViewAPI구현
  
- FEAT:      새로운 기능 구현
- FIX:       버그, 오류 해결
- CHORE:     src 또는 test 파일을 수정하지 않는 기타 변경 사항 ( 새로운 파일 생성, 파일 이동, 이름 변경 등 )
- REFACTOR:  버그 수정이나 기능 추가가 없는 코드 변경 ( 코드 구조 변경 등의 리팩토링 )
- BUILD:     빌드 시스템 또는 외부에 영향을 미치는 변경 사항 종속성 ( 라이브러리 추가 등 )
- TEST:      테스트 추가 또는 이전 테스트 수정
- DOCS:      README나 WIKI 등의 문서 개정
- CI:        CI 구성 파일 및 스크립트 변경
- MERGE:     다른브랜치를 merge하는 경우
- INIT :     Initial commit을 하는 경우
  
## 🧶 Code Convention
<details>
<summary>Naming</summary>
<div>

1. 변수는 CamelCase를 기본으로 한다. <br>
2. URL, 파일명 등은 kebab-case를 사용한다. <br>
3. 패키지명은 단어가 달라지더라도 무조건 소문자를 사용한다. <br>
4. ENUM이나 상수는 대문자로 네이밍한다. <br>
5. 함수명은 소문자로 시작하고 동사로 네이밍한다. <br>
6. 클래스명은 명사로 작성하고 UpperCamelCase를 사용한다. <br>
7. 객체 이름을 함수 이름에 중복해서 넣지 않는다. (= 상위 이름을 하위 이름에 중복시키지 않는다.) <br>
8. 컬렉션은 복수형을 사용하거나 컬렉션을 명시해준다. <br>
9. 이중적인 의미를 가지는 단어는 지양한다. <br>
10. 의도가 드러난다면 되도록 짧은 이름을 선택한다. <br>

</div>
</details>
  
<details>
<summary>Structure</summary>
<div>
1. 패키지는 목적별로 묶는다. <br>
2. Controller에서는 최대한 어떤 Service를 호출할지 결정하는 역할과 Exception처리만을 담당하자. <br>
3. 하나의 클래스 안에서는 같은 목적을 둔 코드들의 집합이여야한다. <br>
4. 메소드와 클래스는 최대한 작게 만든다. <br>
5. 도메인 서비스를 만들어지는 것을 피하자. <br>

</div>
</details>

