# Sử dụng image Java làm base
FROM openjdk:17-jdk-slim

# Thêm file jar vào container
COPY target/Lab-0.0.1-SNAPSHOT.jar app.jar

# Expose port (tùy bạn config)
EXPOSE 9001

# Lệnh để chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]