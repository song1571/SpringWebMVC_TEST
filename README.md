### 프로젝트 설명: **SpringWebMVCTestApp**

`SpringWebMVCTestApp`은 Spring MVC와 Hibernate를 사용한 웹 애플리케이션 프로젝트로, 간단한 CRUD 기능과 파일 업로드 기능을 제공합니다. 주요 목표는 Spring MVC 구조와 Hibernate ORM의 기본 사용법을 익히는 것입니다.

---

### 주요 기능
1. **CRUD 기능**: 게시물 추가, 수정, 삭제
2. **JSP 뷰 렌더링**: 동적 HTML 생성
3. **Hibernate 데이터 연동**: DB와 상호작용
4. **파일 업로드 및 다운로드**: 파일 저장과 관리

---

### 폴더 구조 및 주요 파일 설명

#### 1. **컨트롤러 (`com.taehun.controller`)**
- **`ContactController`**
  - `/contact` 경로 요청 처리
  - 연락처 정보 저장 및 표시

- **`FileController`**
  - 파일 업로드 및 다운로드 처리

#### 2. **서비스 (`com.taehun.service`)**
- **`ContactService`**
  - 연락처 관련 비즈니스 로직 수행

- **`FileService`**
  - 파일 저장 및 불러오기 로직 처리

#### 3. **DAO (`com.taehun.dao`)**
- **`ContactDao`**
  - 연락처 정보의 DB CRUD 작업 담당

- **`FileDao`**
  - 파일 메타데이터 저장 및 조회

#### 4. **뷰 (`src/main/webapp/WEB-INF/views`)**
- **`contact.jsp`**
  - 연락처 입력 폼 및 표시 화면

- **`fileUpload.jsp`**
  - 파일 업로드 인터페이스 및 결과 표시

#### 5. **설정 파일 (`src/main/resources`)**
- **`application.properties`**
  - DB 연결 설정 및 파일 저장 경로

---
