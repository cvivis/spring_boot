package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<User> getAll() throws SQLException{
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"),
                        rs.getString("password"));
                return user;
            }
        };

        return this.jdbcTemplate.query("select * from users",rowMapper);
    }

    public void insert(User user) throws SQLException {
        this.jdbcTemplate.update("INSERT INTO users(id, name,password) VALUES (?,?,?)",user.getId(),user.getName(),user.getPassword());
    }

    public User selectId(String id) throws SQLException {
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.queryForObject("select * from users where id = ?", rowMapper, id);
    }
    public int deleteAll() throws SQLException {
        String sql = "DELETE FROM users";

        return this.jdbcTemplate.update(sql);
    }

    public int getCount() throws SQLException {

        return this.jdbcTemplate.queryForObject("select count(*) from users",Integer.class);
    }


}
