package com.boot.billing_software.dao;

import com.boot.billing_software.entity.Customer;
import com.boot.billing_software.exception.ResourceNotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao implements CustomerDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer save(Customer customer) {
        String sql = "INSERT INTO customer(id, name, phone, email, address) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                customer.getId(),
                customer.getName(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getAddress()
        );
        return customer;
    }

    @Override
    public Customer findById(int id) {
        String sql = "SELECT * FROM customer WHERE id=?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Customer.class),
                id
        );
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Customer.class)
        );
    }

    @Override
    public Customer updateById(int id,Customer customer) {
        String sql = """
                UPDATE customer
                SET name=?, phone=?, email=?, address=?
                WHERE id=?
                """;

        int rows = jdbcTemplate.update(
                sql,
                customer.getName(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getId()
        );

        if (rows == 0) {
            throw new ResourceNotFoundException("Customer not found with id " + customer.getId());
        }
        return customer;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM customer WHERE id=?";
        int rows = jdbcTemplate.update(sql, id);

        if (rows == 0) {
            throw new ResourceNotFoundException("Customer not found with id " + id);
        }
    }



}
