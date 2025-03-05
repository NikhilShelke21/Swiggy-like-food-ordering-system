# Swiggy-like-food-ordering-system
# Swiggy-like Food Ordering Website

## Introduction
This project is a food ordering web application similar to Swiggy, developed using Servlet, JSP, and MySQL. It allows users to browse restaurants, select dishes, place orders, and track their orders in real time. The admin can manage restaurants, menus, and user orders.

## Features
- **User Authentication:** Signup, login, and logout functionality for customers and admins.
- **Restaurant Management:** Admin can add, update, or remove restaurants.
- **Menu Management:** Restaurants can manage their food items and pricing.
- **Cart & Ordering System:** Users can add items to the cart and place orders.
- **Order Tracking:** Users can check the status of their orders.
- **Payment Integration:** Option to integrate payment gateways.
- **Admin Dashboard:** View and manage users, orders, and restaurant data.

## Technologies Used
- **Frontend:** HTML, CSS, JavaScript, Bootstrap
- **Backend:** Java (Servlet, JSP)
- **Database:** MySQL
- **Server:** Apache Tomcat

## Installation & Setup
### Prerequisites
- Install Java Development Kit (JDK 8+)
- Install Apache Tomcat Server (v9 or above)
- Install MySQL Server
- Setup a compatible IDE (Eclipse/IntelliJ IDEA)

### Steps to Run the Project
1. **Clone the Repository**
   ```sh
   git clone https://github.com/<your-username>/food-ordering-system.git
   cd food-ordering-system
   ```
2. **Import the Project**
   - Open Eclipse or IntelliJ IDEA.
   - Import as an existing Maven project.
3. **Setup Database**
   - Create a MySQL database.
   - Run the SQL scripts in `database.sql` to set up tables.
   - Configure `db.properties` with MySQL credentials.
4. **Deploy on Tomcat**
   - Configure Tomcat in the IDE.
   - Run the application.
5. **Access the Application**
   - Open `http://localhost:8080/` in a web browser.

## Folder Structure
```
/food-ordering-system
│── src/main/java (Servlets, Controllers, DAO)
│── src/main/webapp (JSP Pages, CSS, JS)
│── WEB-INF (web.xml configuration)
│── database.sql (Database setup script)
│── pom.xml (Maven dependencies)
```

## GitHub Setup
### Steps to Upload the Project to GitHub
1. **Initialize Git** in your project folder:
   ```sh
   git init
   ```
2. **Connect to GitHub Repository** (Replace `<your-username>` with your GitHub username):
   ```sh
   git remote add origin https://github.com/<your-username>/food-ordering-system.git
   ```
3. **Add Files and Commit Changes**:
   ```sh
   git add .
   git commit -m "Initial commit"
   ```
4. **Push to GitHub**:
   ```sh
   git branch -M main
   git push -u origin main
   ```

## Future Enhancements
- **Real-time Order Tracking with WebSockets**
- **Integration with Payment Gateways (Razorpay, Stripe, etc.)**
- **Mobile App Development**
- **AI-based Food Recommendations**

## Contributors
- [Nikhil Shelke]

## License
This project is licensed under the MIT License.

