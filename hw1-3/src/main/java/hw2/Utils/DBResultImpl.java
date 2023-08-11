package hw2.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBResultImpl implements DBResult {
    @Override
    public ResultSet getResultSet(String query) {
        try {
            Connection connection = DBUtil.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            connection.close();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException("getResultSet method exception");
        }
    }
}
