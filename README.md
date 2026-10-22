# demo

**Spring Boot 웹 서버의 가장 기본 틀**입니다. Spring Initializr로 만든 프로젝트에 인사말을 돌려주는 주소(`/hello`) 하나를 붙인 상태입니다.

## 할 수 있는 것

| 주소 | 응답 |
| --- | --- |
| `GET /hello` | `Hello "World" Spring!` |
| `GET /hello?param=Claude` | `Hello "Claude" Spring!` |

## 사용 기술

| 구분 | 내용 |
| --- | --- |
| 언어 / 빌드 | Java 17, Maven (Maven Wrapper 포함) |
| 프레임워크 | Spring Boot 3.5.0 (`spring-boot-starter-web`) |
| 기타 | Lombok(설치만 됨, 쓰는 코드 없음), JUnit 5 + MockMvc |
| 패키지 | `com.example.java` |

## 폴더 구조

```
demo/
├── pom.xml, mvnw, mvnw.cmd, .mvn/wrapper/   # Maven 설정과 Wrapper
└── src/
    ├── main/java/com/example/java/
    │   ├── demo/DemoApplication.java         # 시작점
    │   └── controller/HelloController.java   # /hello
    ├── main/resources/application.properties # 앱 이름만 지정
    └── test/java/com/example/java/demo/DemoApplicationTests.java
```

## 실행 방법

```bash
git clone https://github.com/jeong-jihyun/demo.git
cd demo
./mvnw spring-boot:run      # http://localhost:8080/hello
./mvnw test                 # 테스트 실행
```

JDK 17 이상이 필요합니다.

## 개선 내역 (2026-10)

| 구분 | 문제 | 수정 내용 |
| --- | --- | --- |
| 주소가 동작하지 않음 | 시작점이 `com.example.java.demo`에 있고 컨트롤러는 `com.example.java.controller`에 있어, 스프링이 컨트롤러를 찾지 못해 `/hello`가 404가 됨 | `@SpringBootApplication(scanBasePackages = "com.example.java")`로 스캔 범위 확장 |
| 어색한 응답 | `param`을 안 주면 `Hello "null" Spring!`이 나옴 | 기본값 `World` 지정 |
| 테스트 | 아무것도 확인하지 않는 `contextLoads`뿐 | `/hello` 응답 2가지를 확인하는 MockMvc 테스트 추가 |

## 확인하지 못한 것

이 작업 환경에서는 Maven Central에 접속할 수 없어 **빌드·테스트·서버 실행은 하지 못했습니다.** 위 수정은 코드를 읽고 판단한 것입니다. (스캔 범위 문제는 패키지 구조에서 분명히 확인됩니다.)
