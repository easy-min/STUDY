# back_web_week1_01_servlet

## Servlet
**Servlet**은 `server` + `applet`의 합성어로, Java 언어로 작성된 웹 애플리케이션의 서버 측 프로그램이다.

### **Servlet 특징**
- Java를 이용하여 웹페이지를 동적으로 생성할 수 있음
- Servlet은 자바 코드 안에 HTML을 포함
- 웹 컨테이너(Tomcat 등)에 의해 실행되고 관리됨

---

## **Servlet 생명주기 (Life cycle)**
Servlet 인스턴스는 웹 컨테이너에 의해 제어되며, 다음과 같은 단계로 실행된다.

1. **Servlet 클래스 로드**
2. **Servlet 인스턴스 생성**
3. **Servlet 인스턴스 초기화** (`init()` 호출)
4. **웹 컨테이너에 의한 서비스 메서드 호출** (`service()` → `doGet()` or `doPost()` 실행)
5. **`destroy()` 메서드 호출하여 Servlet 종료**

- 서비스(`service()`) 메서드는 요청이 들어올 때마다 호출됨

---

## **URI, URL, URN 개념 정리**
### 1️⃣ **URI (Uniform Resource Identifier)**
- 인터넷 상의 자원을 고유하게 식별하는 식별자
- **URL + URN을 포함하는 상위 개념**

### 2️⃣ **URL (Uniform Resource Locator)**
- 자원의 **위치**를 나타내는 주소 (예: `https://www.google.com/search?q=ssafy`)

### 3️⃣ **URN (Uniform Resource Name)**
- 자원에 대한 **고유한 이름을 제공**


---

## **URL의 구성 요소**
`https://www.google.com/search?q=ssafy`
1. **프로토콜**: `https://` → 절차를 포함한 통신 규약
2. **서버**: `www.google.com` → 요청할 서버의 주소
3. **경로**: `/search` → 서버 내의 상세 경로
4. **쿼리 스트링**: `?q=ssafy` → 추가 데이터를 서버에 전송하는 부분
    - `?`로 시작하며, `parameter_name=value` 형태로 작성
    - 여러 개의 파라미터는 `&`로 구분

---

## **GET과 POST 차이점**

### **1️⃣ GET** (지정된 리소스에서 데이터를 요청)
- 쿼리 스트링이 URL에 포함되어 전송됨 → **보안 취약**
- URL 길이 제한이 있음 (최대 `2048`자, ASCII만 가능)

### **2️⃣ POST** (리소스를 생성, 업데이트할 때 사용)
- HTTP Header의 Body에 파라미터 포함하여 전송
- **데이터 길이 제한 없음**
- 매개변수가 브라우저나 웹 서버에 저장되지 않음 → **보안성 높음**
- 바이너리 데이터도 전송 가능

---

## **Servlet의 주요 메서드**
Servlet은 `HttpServlet` 클래스를 상속받아 사용하며, 다음과 같은 주요 메서드를 포함한다.

### **1️⃣ `doGet(HttpServletRequest req, HttpServletResponse res)`**
- GET 요청을 처리하는 메서드.
- 브라우저에서 URL을 직접 입력하거나, `<a>` 태그를 클릭할 때 주로 사용됨.

### **2️⃣ `doPost(HttpServletRequest req, HttpServletResponse res)`**
- POST 요청을 처리하는 메서드.
- HTML `<form>` 태그에서 `method="post"`를 사용할 때 실행됨.

### **3️⃣ `service(HttpServletRequest req, HttpServletResponse res)`**
- HTTP 요청이 들어올 때 실행되는 메서드.
- `doGet()` 또는 `doPost()`를 호출하는 역할.

### **4️⃣ `init(ServletConfig config)`**
- Servlet이 최초 생성될 때 한 번만 실행됨.
- 데이터베이스 연결 등 **초기 설정**을 수행할 때 사용.

### **5️⃣ `destroy()`**
- Servlet이 종료될 때 실행됨.
- **자원 해제(DB 연결 닫기 등)**를 수행할 때 사용.

---

