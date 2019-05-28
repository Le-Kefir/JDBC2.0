package service;

import bl.Util;
import dao.EmplProjDAO;
import entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {

    Connection connection = getConnection();

    public void add(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "insert into empl_project(employee_id, project_id) values (?, ?)";
         try {
             preparedStatement = connection.prepareStatement(sql);

             preparedStatement.setLong(1, emplProj.getEmployeeId());
             preparedStatement.setLong(2, emplProj.getProjectId());

             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             if (preparedStatement != null) {
                 preparedStatement.close();
             }
             if (connection != null) {
                 connection.close();
             }
         }

    }

    public List<EmplProj> getAll() throws SQLException {
        List<EmplProj> emplProjList = new ArrayList<EmplProj>();

        String sql = "SELECT employee_id, project_id from empl_project";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("employee_id"));
                emplProj.setProjectId(resultSet.getLong("project_id"));

                emplProjList.add(emplProj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
        return emplProjList;
    }

    public EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT employee_id, project_id from empl_project where employee_id = ? and project_id = ?";

        EmplProj emplProj = new EmplProj();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmployeeId(resultSet.getLong("employee_id"));
            emplProj.setProjectId(resultSet.getLong("project_id"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return emplProj;
    }

    public void update(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "update empl_project set employee_id = ?, project_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void remove(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "delete from empl_project where employee_id = ? and project_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
