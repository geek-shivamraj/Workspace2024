package com.srvcode.jdbc.repository;

import com.srvcode.jdbc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getAllProduct() {
        String sql = "SELECT id, category, name FROM products;";
        return jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getLong(1));
                product.setCategory(rs.getString(2));
                product.setName(rs.getString(3));
                return product;
            }
        });
    }

    public Product findProductById(Long id) {
        String sql = "SELECT id, category, name FROM products where id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {
            @Override
            public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
                Product product = null;
                while(rs.next()) {
                    product = new Product();
                    product.setId(rs.getLong("id"));
                    product.setCategory(rs.getString("category"));
                    product.setName(rs.getString("name"));
                }
                return product;
            }
        }, id);
    }

    public Integer saveProduct(Product product) {
        String sql = "INSERT INTO products (category, name) values(?, ?)";
        return jdbcTemplate.update(sql, product.getCategory(), product.getName());
    }

    public Integer updateProduct(Product product) {
        String sql = "UPDATE products SET category = ?, name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, product.getCategory(), product.getName(), product.getId());
    }

    public int deleteProductById(Long id) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
