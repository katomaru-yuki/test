package dbtest;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Db implements Closeable{
    Connection conection = null;
    Statement smt = null;
    public Db() throws SQLException{
        conection = DriverManager.getConnection(
                “jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode = true&serverTimezone=UTC”, “root”,
                “mysql”);
        smt = conection.createStatement();
    }
    public ResultSet executeQuery(String sql) throws SQLException{
        return smt.executeQuery(sql);
    }
    public int executeUpdate(String sql) throws SQLException {
        return smt.executeUpdate(sql);
    }
    @Override
    public void close() throws IOException {
        try {
            smt.close();
        }catch(SQLException e){
        }
        try {
            conection.close();
        }catch(SQLException e){
        }
    }
}
