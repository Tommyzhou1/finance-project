# Use the official OpenJDK image as the base
FROM openjdk:11

# Set the working directory
WORKDIR /app

# Copy the JAR file built with 'mvn package' into the container
COPY target/personal-finance-app-*.jar /

# Expose the port your app runs on
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
