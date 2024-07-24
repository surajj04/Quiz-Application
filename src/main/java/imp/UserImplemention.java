package imp;

import data.Jdbc;
import model.User;
import repo.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserImplemention implements UserRepository {

    private Jdbc jdbc = new Jdbc();

    @Override
    public User addUser(User user) {
        try {

            Connection con = jdbc.getCon();

            PreparedStatement ps = con.prepareStatement("INSERT INTO player (name, score) VALUES (?, ?)");
            ps.setString(1, user.getName());
            ps.setDouble(2, user.getScore());

            int result = ps.executeUpdate();

            if (result == 1) {
                return user;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
