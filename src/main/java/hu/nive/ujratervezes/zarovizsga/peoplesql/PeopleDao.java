package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstname, String lastname) {

        try (Connection conn = dataSource.getConnection();

             PreparedStatement ps = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")) {

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            if (getResult(ps).isEmpty()) {
                throw new IllegalArgumentException("Not found");
            }
            return getResult(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private String getResult(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            return getIpAddress(rs);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }


    private String getIpAddress(ResultSet rs) throws SQLException {
        List<String > result = new ArrayList<>();

        while (rs.next()) {
            result.add(rs.getString("ip_address"));
        }
        return result.get(0);
    }



}
