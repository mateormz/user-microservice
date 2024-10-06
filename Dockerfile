# Usa una imagen base de Java
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo jar generado por Spring Boot a la imagen
COPY target/user-management-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el contenedor
EXPOSE 8081

# Comando para ejecutar el archivo jar
ENTRYPOINT ["java", "-jar", "app.jar"]