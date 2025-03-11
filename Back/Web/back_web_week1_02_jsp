
# back_web_week1_02_jsp

## JSP (Java Server Pages)
JSP는 **Servlet 표준을 기반으로 작성된 Web Application 개발 언어**로, 실행 시 Servlet으로 변환된다.

### **JSP 특징**
- HTML 내에 Java 코드를 작성하여 **동적으로 웹 페이지를 생성**할 수 있음.
- **HTML 내 Java 작성 가능** (반대로 Servlet은 Java 안에 HTML 포함).
- JSP 자체도 **하나의 Servlet**이며, JSP 코드가 **Servlet 코드로 변환된 후 실행**됨.
- HTML과 유사한 형식으로 작성할 수 있어 유지보수가 용이함.

---

## **JSP의 구성 요소**
1. **지시자**: JSP 페이지 설정 정보 지정 (`<%@ %>`)
2. **스크립트 요소**: 동적 생성 (스크립틀릿, 표현식, 선언부)
3. **JSP 기본 객체**: 요청 및 응답 객체 제공
4. **표현 언어 (EL)**: JSP를 간결하게 표현하는 방법
5. **Action Tag & JSTL**: 자주 사용하는 기능을 미리 태그 형태로 정의하여 사용

---

## **JSP 태그 종류**
1. **스크립틀릿 (`<% %>`)**
   - 자바 코드 작성 가능
   - JSP 요청마다 실행됨
   ```jsp
   <% int count = 0; count++; %>
   ```

2. **선언 (`<%! %>`)**
   - 변수 및 메소드 선언 가능
   - JSP 인스턴스(클래스) 전체에서 공유됨 (JSP 처음 로드될 때 실행)
   ```jsp
   <%! int totalCount = 0; %>
   ```

3. **표현식 (`<%= %>`)**
   - 계산식이나 함수 호출 결과를 문자열 형태로 출력 (세미콜론 `;` 없음)
   ```jsp
   <%= "현재 카운트: " + count %>
   ```

4. **주석 (`<%-- --%>`)**
   - HTML 주석과 JSP 주석의 차이
   ```jsp
   <!-- HTML 주석 (클라이언트가 볼 수 있음) -->
   <%-- JSP 주석 (클라이언트가 볼 수 없음) --%>
   <% // Java 주석 (Servlet 변환 시 포함됨) %>
   ```

5. **지시자 (`<%@ %>`)**
   - JSP 페이지 속성 지정 (웹 컨테이너가 JSP를 번역 및 실행할 때 사용)
   - 종류:
     - `page`: JSP 페이지 전반적 환경 설정
     - `include`: 다른 파일 내용을 현재 페이지에 삽입
     - `taglib`: 태그 라이브러리를 불러와 기능 제공

---

## **JSP에서의 페이지 이동 방법**
1. **포워드 방식 (`RequestDispatcher`)**
   - 요청받은 JSP/Servlet이 직접 응답하지 않고, **서버 내부에서 다른 JSP/Servlet으로 전달**하여 처리
   ```java
   RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
   dispatcher.forward(request, response);
   ```

2. **리다이렉트 방식 (`sendRedirect`)**
   - 요청을 처리한 후 **클라이언트에게 새로운 URL로 이동하도록 응답**
   ```java
   response.sendRedirect("/home.jsp");
   ```

---

## **Servlet과 JSP의 차이점**
| 구분       | JSP (View) | Servlet (Controller) |
|------------|-----------|----------------------|
| 역할       | 화면 (UI) 렌더링 | 비즈니스 로직 처리 |
| 작성 방식  | HTML 중심, Java 코드 사용 가능 | Java 코드 중심 |
| 가독성     | HTML 작성이 편리함 | Java 코드가 많아지면 유지보수 어려움 |
| 사용 목적  | 클라이언트에게 화면을 제공 | 요청 처리 및 데이터 가공 |


---

## **프로젝트 구조 및 역할**

1. **`src/main/java`** → 서블릿 위치 (컴파일 시 `WEB-INF/classes` 폴더에 `.class` 파일로 저장됨).
   - 클라이언트가 직접 접근할 수 없음 (`Tomcat` 같은 웹 서버가 실행해야 함).

2. **`webapp`** → 정적 웹 프로그램 위치 (`HTML`, `CSS`, `JS`, `JSP` 포함).
   - 클라이언트가 `http://localhost:8080/index.html`을 입력하면 `webapp/index.html`이 실행됨.

3. **`WEB-INF`** → **외부에서 접근할 수 없는 보안 디렉터리**
   - `web.xml` 설정 파일이 포함됨.

---

## **서블릿에 접근하는 방법 (매핑)**
서블릿은 클라이언트가 직접 접근할 수 없으므로, **경로를 매핑해야 함.**

### **1. `web.xml`을 이용한 매핑**
```xml
<servlet>
    <servlet-name>MainServlet</servlet-name>
    <servlet-class>com.ssafy.servlet.MainServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>MainServlet</servlet-name>
    <url-pattern>/main</url-pattern>
</servlet-mapping>
```
📌 **설명:**
- `<servlet>`: 서블릿 클래스를 웹 애플리케이션에 등록
- `<servlet-mapping>`: 클라이언트가 특정 URL(`/main`)을 요청하면 해당 서블릿이 실행됨.

🚨 **주의:**
- `<servlet>`만 있으면 **URL로 실행할 방법이 없음.**
- `<servlet-mapping>`만 있으면 **실행할 서블릿을 찾을 수 없음.**

---

### **2. `@WebServlet` 어노테이션을 이용한 매핑**
```java
@WebServlet("/main")  // 클라이언트가 "/main" 경로로 요청하면 실행
public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().println("Hello, JSP & Servlet!");
    }
}
```
📌 **설명:**
- `@WebServlet("/main")` → `/main` URL 요청 시 `MainServlet` 실행됨.
- 별도의 `web.xml` 설정 없이 서블릿을 매핑할 수 있음.

---

## **결론**
- **JSP는 HTML 안에 Java 코드를 포함하여 웹페이지를 동적으로 생성하는 기술.**
- **Servlet은 Java 코드 안에서 HTTP 요청을 처리하는 역할을 담당.**
- **둘을 함께 사용하면 비즈니스 로직(Servlet)과 UI(JSP)를 분리하여 유지보수가 편리해짐.**

이제 JSP와 Servlet의 차이, 그리고 프로젝트에서 어떻게 동작하는지 이해됐지? 🚀🔥

