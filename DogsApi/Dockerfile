# Use an official OpenJDK runtime as the base image
FROM openjdk:19

# Create a non-root user
RUN groupadd -r myuser && useradd -r -g myuser myuser

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/DogsApi-1.0.0-SNAPSHOT.jar app.jar

# Set the ownership of the working directory to the non-root user
RUN chown -R myuser:myuser /app

# Change to the non-root user
USER myuser

# Expose the port that the application is listening on
EXPOSE 8081

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
