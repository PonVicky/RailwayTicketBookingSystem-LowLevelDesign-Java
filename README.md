# Railway Ticket Booking System - Low-Level Design (Java)

This repository contains a **Railway Ticket Booking System** implemented in Java. The project is a demonstration of **low-level design (LLD)** principles and uses a modular structure to simulate the ticket booking and cancellation process in a railway system.

---

## 📖 Features

- **Seat Allocation**:
  - Allocates tickets in the order of **Lower Berth**, **Middle Berth**, **Upper Berth**, **RAC (Reservation Against Cancellation)**, and **Waiting List**.
- **Dynamic Handling**:
  - When a ticket is canceled, passengers from RAC are upgraded to the available seat.
  - Passengers from the waiting list move to RAC in turn.
- **Passenger Management**:
  - Handles passenger details and ensures proper allocation across different categories.
- **Input Validation**:
  - Ensures valid booking and cancellation requests.
- **View Tickets**:
  - You can view free tickets and booked tickets.

---

## 🛠️ Tech Stack

- **Language**: Java  
- **Design Principles**:
  - Low Level System Design (LLD)
  - Object-Oriented Programming (OOP)
  - Single Responsibility Principle (SRP)
  - Separation of Concerns

---

### Key Components
1. **Main**: Handles the user interface (console-based) and interacts with the `TicketBooker`.
2. **Passenger**: Represents a passenger with attributes like name, age, berth preference, and ticket status.
3. **TicketBooker**: Implements the core logic for ticket booking, cancellation, and seat management.

---

##🖥️ How It Works

**Booking Process**⬇️

1.Seats are allocated based on availability in the following order:
  - Lower Berth
  - Middle Berth
  - Upper Berth
  - RAC
  - Waiting List
2.If a seat is unavailable, the passenger is added to the next category in order.


**Cancellation Process**⬇️

1.When a ticket is canceled:
  - A passenger from the RAC list is upgraded to the canceled seat.
  - A passenger from the Waiting List is moved to the RAC list.
2.The system ensures that all categories are dynamically updated.


**Example Flow**⬇️

1.Booking:
  - Passenger A requests a lower berth → Allocated.
  - Passenger B requests a middle berth → Allocated.
  - Passenger C requests a lower berth but it's unavailable → Allocated to RAC.
2.Cancellation:
  - Passenger A cancels their ticket.
  - Passenger C (RAC) is moved to the lower berth.
  - Next passenger in the waiting list is moved to RAC.
