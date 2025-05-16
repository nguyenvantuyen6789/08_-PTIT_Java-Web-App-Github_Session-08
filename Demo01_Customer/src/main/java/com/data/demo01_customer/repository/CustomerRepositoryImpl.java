package com.data.demo01_customer.repository;

import com.data.demo01_customer.connection.ConnectionDB;
import com.data.demo01_customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;

        List<Customer> customers = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFullName(rs.getString("full_name"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setCustomerType(rs.getString("customer_type"));
                // add to list
                customers.add(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return customers;
    }

    @Override
    public Customer findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;

        Customer customer = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFullName(rs.getString("full_name"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setCustomerType(rs.getString("customer_type"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return customer;
    }

    @Override
    public List<Customer> search(String fullName, String email) {
        Connection conn = null;
        CallableStatement callSt = null;

        List<Customer> customers = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_customer(?, ?)}");
            callSt.setString(1, fullName);
            callSt.setString(2, email);

            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFullName(rs.getString("full_name"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setCustomerType(rs.getString("customer_type"));
                // add to list
                customers.add(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return customers;
    }

    @Override
    public boolean save(Customer customer) {
        Connection conn = null;
        CallableStatement callSt = null;

        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_customer(?, ?, ?, ?)}");
            callSt.setString(1, customer.getFullName());
            callSt.setString(2, customer.getEmail());
            callSt.setString(3, customer.getGender());
            callSt.setString(4, customer.getCustomerType());

            // execute
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return result;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;

        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_customer_by_id(?)}");
            callSt.setInt(1, id);

            // execute
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return result;
    }
}
