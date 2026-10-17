
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY src ./src

# Fix Windows line endings for Linux
RUN sed -i 's/\r$//' mvnw \
    && chmod +x mvnw

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar UserCURD-0.0.1-SNAPSHOT.jar.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar UserCURD-0.0.1-SNAPSHOT.jar.jar"]
