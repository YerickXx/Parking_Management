# 🚗 Parking Management System (Java)

A robust, Object-Oriented parking management solution designed to handle vehicle check-ins, check-outs, and automated fee calculations. This project demonstrates clean code principles, architectural layering, and efficient logic handling in Java.

## 🌟 Key Features
* **Real-time Occupancy Tracking:** Manage available parking slots and prevent overbooking.
* **Automated Fee Engine:** Logic-based fare calculation based on entry/exit timestamps.
* **Plate Validation:** Regex-based validation for vehicle identification.
* **Persistence Layer:** Organized data handling to maintain state during runtime.
* **Clean GUI:** User-friendly interface built with Java Swing/AWT for seamless interaction.

## 🏗️ Architecture & Design
This project follows a **Layered Architecture** to ensure high technical standards and decoupling:
* **Presentation Layer (GUI):** Handles all user interactions without containing business logic.
* **Logic Layer:** Manages validation rules, fee calculations, and system constraints.
* **Data/Object Layer:** Defines the core entities (Vehicles, Slots, Reports) using POJO (Plain Old Java Objects) and Encapsulation.

## 🛠️ Tech Stack
* **Language:** Java 17+
* **Environment:** NetBeans IDE
* **Version Control:** Git & GitHub

