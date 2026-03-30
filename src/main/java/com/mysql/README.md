
---

## 📌 Package Details

### 🔹 com.mysql.app
- Contains main class: `PayrollApp.java`
- Handles user input (menu-driven program)
- Calls DAO and Service methods

---

### 🔹 com.mysql.dao
- Handles database operations (CRUD)
- Uses JDBC (Connection, PreparedStatement, ResultSet)

#### Classes:
- `DBConnection.java` → Database connection setup  
- `EmployeeDAO.java` → Employee operations  
- `DepartmentDAO.java` → Department operations  

---

### 🔹 com.mysql.entity
- Represents database tables as Java classes (POJO)

#### Classes:
- `Employee.java` → Employee table  
- `Department.java` → Department table  
- `EmployeeDept.java` → JOIN result mapping  
- `DepartmentSalary.java` → GROUP BY result  

---

### 🔹 com.mysql.service
- Contains business logic

#### Classes:
- `PayrollService.java`
  - Calculates:
    - Tax
    - PF
    - Net Salary  

---

## 🔄 Application Flow

1. User selects option from menu  
2. `PayrollApp` receives input  
3. Calls DAO layer  
4. DAO executes SQL query  
5. Result returned as objects  
6. Data printed in formatted table  

---

---

## 💡 Design Concepts Used

- DAO Pattern  
- Layered Architecture  
- Separation of Concerns  
- OOP (Encapsulation, Abstraction)  

---

## 🧠 Important Notes

- All DB operations use PreparedStatement  
- Used Try-with-resources for resource management  
- Data formatted using `printf()`  

---

## 🚀 Developer Tip

This structure makes the project:
✔ Easy to maintain  
✔ Easy to extend  
✔ Suitable for real-world applications  

## 📊 Example Flow (Add Employee)
