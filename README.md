# OTP Generation and Validation Project

## Overview
This project implements an **OTP (One-Time Password) Generation and Validation System** using Spring Boot and Thymeleaf. The application provides a simple web interface to generate and validate OTPs, which can be integrated with an SMS gateway like Twilio for real-time delivery.

## Features
- Generate OTP and send it to a phone number.
- Validate the OTP entered by the user.
- Built with Spring Boot for backend and Thymeleaf for frontend.
- Reactive endpoints using `RouterFunction` for handling requests.

## Prerequisites
- Java 17 or later
- Maven 3.8 or later
- Spring Boot 3.x
- Twilio account (optional, for SMS integration)

## Technologies Used
- **Backend:** Spring Boot 3.x
- **Frontend:** Thymeleaf (HTML templates)
- **Database:** (Optional, if persistence is needed)
- **Build Tool:** Maven
- **Reactive Programming:** Project Reactor

## Project Structure
```
src/main/java/com/otp_generation/
├── config/            # Configuration classes
│   ├── TwilioConfig.java
├── controller/        # Controller classes for handling HTTP requests
│   ├── OtpController.java
├── model/             # Domain models
│   ├── OtpRequest.java
│   ├── OtpResponse.java
├── service/           # Service layer
│   ├── OtpService.java
├── resource/          # Reactive RouterFunction configuration
│   ├── RouterConfig.java
├── OtpGenerationApplication.java  # Main application entry point
src/main/resources/
├── templates/         # Thymeleaf templates
│   ├── otpForm.html
│   ├── otpValidation.html
├── application.properties
```

## Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd otp-generation
```

### 2. Configure Application Properties
Update the `src/main/resources/application.properties` file with necessary configurations:
```properties
server.port=8080
spring.thymeleaf.cache=false
# Add Twilio configurations if needed
twilio.account.sid=your_account_sid
twilio.auth.token=your_auth_token
twilio.phone.number=your_twilio_phone_number
```

### 3. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 4. Access the Application
Open a browser and visit:
```
http://localhost:8080
```

## Usage

### Generate OTP
1. Enter a valid phone number on the **Generate OTP** page.
2. Click the "Generate OTP" button to send the OTP.

### Validate OTP
1. Enter the received OTP on the **Validate OTP** page.
2. Click the "Validate" button to verify the OTP.

## RouterFunction Endpoints
- `POST /sendotp`: Handles OTP generation requests.
- `POST /validateotp`: Validates the entered OTP.

## Thymeleaf Templates
- **otpForm.html**: Form for entering the phone number to generate OTP.
- **otpValidation.html**: Form for entering and validating the OTP.

## Future Enhancements
- Add persistence for OTPs using a database (e.g., MySQL, PostgreSQL).
- Integrate with Twilio for real-time SMS delivery.
- Implement rate limiting for OTP requests.

## Pictures 
1.
 ![Screenshot (7)](https://github.com/user-attachments/assets/d2f31c8f-49b1-4cf1-95eb-7cbce72ac5b0)


2.
 ![Screenshot (8)](https://github.com/user-attachments/assets/cf69183e-f209-4fad-b00a-90fe9da565de)


3.
 ![Screenshot (9)](https://github.com/user-attachments/assets/3584b54d-d65f-40b1-adae-0fc0a34ccb9b)

Output:- 

![42615b0f-2b1f-4a16-8b5a-09a4496a17e3](https://github.com/user-attachments/assets/8ca2ceeb-36ba-46c1-ba50-1c2287de44de)



## Contact
For any questions or issues, please reach out to:
- **Author:** Abhishek Hanmant Ekal
- **Email:** ekalabhishek4@gmail.com
- **Phone:** +91-7219144791

