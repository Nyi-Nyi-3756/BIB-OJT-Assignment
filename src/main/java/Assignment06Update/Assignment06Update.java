package main.java.Assignment06Update;

import java.sql.*;
import java.util.Scanner;

public class Assignment06Update {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/mydatabase";
        String user = "root";
        String password = "NyiNyiKKT337221";

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Database Connected Successfully!");

            while (true) {
                System.out.println("\n MENU ");
                System.out.println("1. Insert Data");
                System.out.println("2. View All Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        // INSERT
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        String insertSQL = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
                        try (PreparedStatement ps = con.prepareStatement(insertSQL)) {
                            ps.setString(1, name);
                            ps.setString(2, email);
                            ps.setInt(3, age);
                            int rows = ps.executeUpdate();
                            System.out.println(" Record inserted successfully.");
                        }
                        break;

                    case 2:
                        // READ
                        String readSQL = "SELECT * FROM users";
                        try (Statement st = con.createStatement();
                             ResultSet result = st.executeQuery(readSQL)) {
                            System.out.println("\n USER LIST ");
                            while (result.next()) {
                                System.out.println("ID: " + result.getInt("id"));
                                System.out.println("Name: " + result.getString("name"));
                                System.out.println("Email: " + result.getString("email"));
                                System.out.println("Age: " + result.getInt("age"));
                            }
                        }
                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter user ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();

                        System.out.print("Enter new age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();

                        String updateSQL = "UPDATE users SET name=?, email=?, age=? WHERE id=?";
                        try (PreparedStatement ps = con.prepareStatement(updateSQL)) {
                            ps.setString(1, newName);
                            ps.setString(2, newEmail);
                            ps.setInt(3, newAge);
                            ps.setInt(4, uid);
                            int rows = ps.executeUpdate();
                            System.out.println(" Record updated successfully.");
                        }
                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter user ID to delete: ");
                        int did = sc.nextInt();
                        sc.nextLine();

                        String deleteSQL = "DELETE FROM users WHERE id=?";
                        try (PreparedStatement ps = con.prepareStatement(deleteSQL)) {
                            ps.setInt(1, did);
                            int rows = ps.executeUpdate();
                            System.out.println(" Record deleted successfully.");
                        }
                        break;

                    case 5:
                        System.out.println(" Exiting program...");
                        sc.close();
                        con.close();
                        return;

                    default:
                        System.out.println("❌ Invalid choice. Please try again!");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }
}

