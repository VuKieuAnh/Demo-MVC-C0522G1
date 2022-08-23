package com.codegym.cms.service;

import com.codegym.cms.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerService {
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/democ0522g1",
                    "root",
                    "123456@Abc"
            );
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ket noi khong thanh cong");
        }
        return connection;
    }

    @Override
    public List<Customer> findAll() {
        //tao moi 1 arrray list
        List<Customer> customers = new ArrayList<>();
        //ket noi csdl
        try(
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from customer;");){
            //goi truy van
            ResultSet resultSet = statement.executeQuery();
            //khop du lieu o csdl vao arraylist
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, name, email, address);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.findAll();
    }
}
