> This is my second real-world project — an **AI-powered health advisory and air monitoring system** built with Spring Boot and Local LLMs.

# 🌬️ Health Advisor & Air Monitor

Health Advisor & Air Monitor is a backend application that helps users understand **air quality levels** in their city and receive **personalized health recommendations** based on their medical condition. It integrates **real-time AQI and weather APIs** with a **local AI model** (LLaMA via Ollama) to generate meaningful health guidance.

---

## 📖 About the Project

This application allows users to:

- Register and store their health profile (e.g., Asthma, Heart Disease, Allergies, etc.)
- Authenticate and log in securely
- Fetch **real-time Air Quality Index** and **weather information** by city
- Generate **AI-powered personalized health advice** based on:
    - User's health condition
    - Current AQI + weather data
- Interact with a **health advisory chatbot** that keeps memory of the last 20 messages
- Understand air-risk levels and recommended precautions

This project was built as part of learning **Spring Boot + AI + External API Integration**.

---

## 🛠️ Tech Stack

| Technology | Role |
|----------|------|
| **Java 21** | Core application language |
| **Spring Boot** | Backend framework |
| **Spring AI** | LLM prompt orchestration |
| **Ollama + LLaMA 3.1 (5B)** | Local LLM for advisory responses |
| **MySQL** | Persistent storage |
| **AQICN API** | Air Quality Index data |
| **OpenWeather API** | Weather data |
| **Maven** | Build tool |
| **Swagger / OpenAPI** | API documentation |

---

## 🧩 Modules

### 1️⃣ 👤 User Module
**Features**
- Register user with: `name`, `age`, `healthCondition`, and encoded password
- Login with username & password
- Store and retrieve user profile from database

**HealthCondition Enum**
```java
ASTHMA, COPD, HEART_DISEASE, PREGNANT, ALLERGIES,
DIABETES, HYPERTENSION, KIDNEY_DISEASE, LUNG_DISEASE, NONE
