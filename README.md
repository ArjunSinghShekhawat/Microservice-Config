# 1-Month Microservices Preparation with Durgesh Sir's Playlist

This repository documents my 1-month learning journey focused on **Microservices** architecture, following Durgesh Sir’s comprehensive playlist. The playlist covered a wide range of essential topics that form the backbone of modern microservice-based systems.

## Key Concepts Covered

1. **API Gateway**
   - Managing multiple microservices with a single entry point.
   - Handling routing, load balancing, security, and monitoring at the gateway level.

2. **Eureka Server & Eureka Client**
   - Implementing **Service Discovery** to enable dynamic communication between services.
   - Setting up **Eureka Server** as a registry and connecting microservices (clients) to it for seamless interaction.

3. **Load Balancer**
   - Understanding and implementing **Load Balancing** strategies to distribute traffic efficiently across multiple instances of microservices.
   - Optimizing performance by ensuring that each service instance is equally loaded.

4. **Resilience4j**
   - Implementing **Fault Tolerance** mechanisms using **Circuit Breaker**, **Retry**, **Rate Limiter**, and **Bulkhead** patterns.
   - Ensuring that microservices can gracefully handle failures and maintain system stability.

5. **Security**
   - Securing microservices using various techniques such as **JWT Authentication**, **OAuth2**, and **Role-Based Access Control (RBAC)**.
   - Implementing security at the API Gateway level and across services.

6. **Config Server**
   - Setting up a **Centralized Configuration Server** to manage and distribute configuration properties for all microservices.
   - Enabling externalized configuration to manage environment-specific properties effectively.

7. **Other Topics**
   - Insights into **Spring Cloud** integration, **Service-to-Service Communication** strategies, and **Distributed Tracing** for monitoring microservices.
   - Real-world use cases for building resilient, scalable, and maintainable microservices.

## Tools and Technologies Used

- **Spring Boot**: For creating the microservices.
- **Spring Cloud**: For building and deploying cloud-native applications.
- **Eureka Server**: For service discovery.
- **Resilience4j**: For handling fault tolerance and circuit breaking.
- **Spring Security**: For securing microservices.
- **Spring Cloud Config**: For centralized configuration management.

## How to Run the Project

### Prerequisites

- Java 11 or later
- Maven 3.x

### Steps to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/ArjunSinghShekhawat/Microservice-Config.git
   cd microservices-preparation
