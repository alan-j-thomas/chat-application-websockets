# 💬 Real-Time Chat Application using Spring Boot WebSocket

A simple yet powerful real-time chat application built using **Spring Boot**, **WebSocket**, **STOMP Protocol**, and **SockJS**.  
This project demonstrates bi-directional communication between client and server with live message broadcasting functionality.

---

# 🚀 Features

- ⚡ Real-time messaging using WebSockets
- 👥 Multiple users can join the chatroom simultaneously
- 🟢 User join notifications
- 🔴 User leave/disconnect notifications
- 🎨 Dynamic user avatars with random colors
- 🔄 Live message broadcasting using STOMP messaging
- 🧩 Clean frontend using HTML, CSS, and JavaScript
- 🌐 SockJS fallback support for browsers without native WebSocket support

---

# 🛠️ Tech Stack

## Backend
- Java
- Spring Boot
- Spring WebSocket
- STOMP Protocol

## Frontend
- HTML5
- CSS3
- JavaScript

## Communication
- WebSocket
- SockJS
- STOMP.js

---

# 📂 Project Structure

```bash
src
├── main
│   ├── java
│   │   └── com.demo.chat_application_websocket
│   │       ├── config
│   │       │   ├── WebSocketConfig.java
│   │       │   └── WebSocketEventListener.java
│   │       ├── controller
│   │       │   └── ChatController.java
│   │       └── model
│   │           ├── ChatMessage.java
│   │           └── MessageType.java
│   │
│   └── resources
│       ├── static
│       │   ├── css
│       │   ├── js
│       │   └── index.html
│       └── application.properties
```

---

# 🔥 How It Works

## 1️⃣ User Connection

Client connects to WebSocket endpoint:

```text
/ws
```

SockJS establishes the connection.

---

## 2️⃣ STOMP Messaging

### Client sends messages to:

```text
/app/chat.sendMessage
```

### Client joins chat through:

```text
/app/chat.addUser
```

---

## 3️⃣ Message Broadcasting

Server broadcasts all messages to:

```text
/topic/public
```

All subscribed users receive messages instantly.

---

# 🧠 WebSocket Flow

```text
Client → /app/chat.sendMessage
        ↓
ChatController
        ↓
/topic/public
        ↓
All Connected Clients
```

---

# 📸 Functionalities Demonstrated

## ✅ Real-Time Communication

Messages appear instantly without page refresh.

---

## ✅ Session Handling

Username stored using:

```java
accessor.getSessionAttributes().put("username", message.getSender());
```

---

## ✅ Disconnect Listener

When a user disconnects:

- LEAVE event is generated
- Notification broadcasted to all users

---

# ⚙️ Running the Application

## Prerequisites

- Java 17+ (or compatible version)
- Maven

---

## Clone Repository

```bash
git clone <your-repo-url>
cd chat-application-websocket
```

---

## Run the Application

```bash
mvn spring-boot:run
```

---

## Open in Browser

```text
http://localhost:8080
```

---

# 📌 Important Endpoints

| Endpoint | Description |
|----------|-------------|
| `/ws` | WebSocket connection endpoint |
| `/app/chat.sendMessage` | Send chat message |
| `/app/chat.addUser` | Add user to chat |
| `/topic/public` | Public message subscription |

---

# 🧩 Core Concepts Used

- WebSocket Protocol
- STOMP Messaging
- Publish-Subscribe Model
- Event-Driven Architecture
- Real-Time Broadcasting
- Session Management
- Frontend WebSocket Integration

---

# 📖 Learning Outcomes

This project helps in understanding:

- How WebSockets work internally
- Real-time communication in Spring Boot
- STOMP messaging architecture
- Client-server event handling
- Live broadcasting systems
- Session-based user tracking

---

# 🚀 Future Enhancements

- 🔐 Authentication & Authorization
- 💾 Message persistence using Database
- 👤 Private messaging
- 🟢 Online users list
- 📱 Responsive UI improvements
- ☁️ Deployment using Docker & Cloud
- 🔔 Typing indicators
- 📎 File sharing support
