# 기존 FROM openjdk:21-jdk-slim 대신 아래 중 하나를 사용하세요
FROM eclipse-temurin:21-jdk-alpine 
# (alpine은 용량이 매우 작지만, 간혹 라이브러리 호환성 문제가 있다면 아래를 사용)
# FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew build -x test

EXPOSE 8080

# 빌드 결과물이 여러 개일 경우를 대비해 쉘 실행 방식을 권장합니다
# 'plain'이라는 글자가 들어가지 않은 jar 파일만 찾아 실행합니다.
ENTRYPOINT ["sh", "-c", "java -jar build/libs/*[!plain].jar"]