# 🎟️ Event booking application – Backend System (Java + Spring Boot)

This project is a Java-based clone of an online ticket booking platform (like BookMyShow), built with Spring Boot, Hibernate/JPA, MySQL, Redis, and Apache Kafka. It provides RESTful APIs for user authentication, event/show listings, seat selection, and ticket booking.
Key system design elements include JWT-based user authentication, an optimistic locking mechanism to prevent double-booking of seats, and an asynchronous, event-driven architecture using Kafka for reliable inter-service communication.
---

## 🚀 Tech Stack

- **Languages & Frameworks:** Java 17, Spring Boot (REST API, Spring Security), Spring Data JPA (Hibernate)
- **Database:** MySQL for persistent data (users, events, shows, seats, bookings)
- **Caching:** Redis (in-memory cache for seat availability and other hot data)
- **Messaging:** Apache Kafka
- **Testing:** JUnit, Mockito
- **Build & Tooling:** Maven (wrapper included), Lombok, Swagger/OpenAPI (for API docs, if enabled)
- **DevOps (Optional):** Docker, AWS (for future deployment)

---

## 🧩 Core Features



- ✅ **User Authentication** – Secure login/signup with JWT
- ✅ **Event & Show Management** – Add/manage movies, shows, seats
- ✅ **Seat Locking with Pessimistic Locking** – Prevent double bookings by immediately locking the particular DB row.
- ✅ **Event-Driven Architecture** – Kafka-based messaging for scalable async operations
- ✅ **Redis Caching** – Speed up frequent queries and reduce DB load
- ✅ **Role-Based Access** – Secure endpoints based on user roles (Admin/User)

---

## 📌 Architecture Overview


Client (UI)
│
└──▶ REST API (Spring Boot Controllers)
│
├──▶ Authentication Service (JWT)
├──▶ Event/Show Service
├──▶ Booking Service
│      ├── Optimistic Locking on Seats
│      ├── Publish Kafka Event: BookingCreated
│
└──▶ Kafka Producer → Kafka Broker → Kafka Consumer(s)
│
└──▶ Notification / Payment / Ticket Services (Future Scope)
│
Redis Cache     MySQL (Data Persistence)



## 🛠️ How to Run the Project

### Prerequisites
- Java 17+
- Maven
- MySQL (Create DB `bookmyshow`)
- Redis
- Apache Kafka (single-node setup works)
  
### Configuration
Update `application.properties`:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.kafka.bootstrap-servers=localhost:9092
spring.redis.host=localhost
spring.redis.port=6379


### Run Locally


# Clone the project
git clone https://github.com/choppasai/BookMyShow.git
cd BookMyShow

# Build and run
./mvnw clean install
./mvnw spring-boot:run


---

## 🔗 API Endpoints Overview

| Endpoint                | Method | Description                                  |
| ----------------------- | ------ | -------------------------------------------- |
| `/auth/register`        | POST   | Register a new user                          |
| `/auth/login`           | POST   | Login with username/password                 |
| `/events`               | GET    | List all events/movies                       |
| `/shows/{eventId}`      | GET    | Get shows for a movie                        |
| `/shows/{showId}/seats` | GET    | View seat layout                             |
| `/bookings`             | POST   | Book seats (uses optimistic locking + Kafka) |
| `/users/{id}/bookings`  | GET    | Get bookings for a user                      |

📌 Use JWT in `Authorization: Bearer <token>` header after login.

---

## 📈 Highlights

### 🪑 Seat Locking Mechanism

Uses **Optimistic Locking** with a version field on seat entities to avoid concurrent seat bookings. Only one transaction can succeed when trying to book the same seat — ensuring data consistency.

### ⚙️ Event-Driven Design with Kafka

Kafka is used to publish booking events, making the system scalable and decoupled. Future services (e.g. Payments, Notifications) can subscribe to these topics.

---

## 🧪 Testing

* Unit testing with **JUnit & Mockito**
* Coverage > 85% for core modules
* Integration tests for seat locking and booking flow (optional)

---

## 🔮 Future Enhancements

* Integrate real **payment gateway** (e.g. Razorpay/Stripe)
* Add **notification service** using Kafka consumer
* Build an **admin dashboard** for event/show management
* Containerize using **Docker & Docker Compose**
* Add **Swagger API Docs** and Postman collection

---

## 🧑‍💻 Author

**Manikanta Sai**
[LinkedIn](https://www.linkedin.com/in/choppa-penchala-manikanta-sai-237852177/) | [GitHub](https://github.com/choppasai) | [LeetCode](https://leetcode.com/u/choppasai5/) | [Scaler](https://scaler.com/academy/profile/d0ee28020853)

---

⭐ If you found this project helpful or insightful, give it a ⭐ on GitHub and feel free to connect!




