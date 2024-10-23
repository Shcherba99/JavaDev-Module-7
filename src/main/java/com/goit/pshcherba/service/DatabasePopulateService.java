package com.goit.pshcherba.service;


import com.goit.pshcherba.config.Database;
import com.goit.pshcherba.entity.Client;
import com.goit.pshcherba.entity.Project;
import com.goit.pshcherba.entity.ProjectWorker;
import com.goit.pshcherba.entity.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();

        //Insert into worker
        List<Worker> workers = databasePopulateService.addWorkers();
        databasePopulateService.insertIntoWorker(workers);

        //Insert into client
        List<Client> clients = databasePopulateService.addClients();
        databasePopulateService.insertIntoClient(clients);

        //Insert into project
        List<Project> projects = databasePopulateService.addProjects();
        databasePopulateService.insertIntoProject(projects);

        //Insert into project_worker
        List<ProjectWorker> projectsWorkers = databasePopulateService.addProjectsWorkers();
        databasePopulateService.insertIntoProjectWorker(projectsWorkers);
    }


    public void insertIntoWorker(List<Worker> workers) {
        String sql = "insert into megasoft.worker(ID, NAME, BIRTHDAY, LEVEL, SALARY)" +
                "values(?, ?, ?, ?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (Worker worker : workers) {
                statement.setInt(1, worker.getId());
                statement.setString(2, worker.getName());
                statement.setDate(3, Date.valueOf(worker.getBirthday()));
                statement.setString(4, worker.getLevel());
                statement.setInt(5, worker.getSalary());
                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertIntoClient(List<Client> clients) {
        String sql = "insert into megasoft.client(ID, NAME)" +
                "values(?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (Client client : clients) {
                statement.setInt(1, client.getId());
                statement.setString(2, client.getName());
                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertIntoProject(List<Project> projects) {
        String sql = "insert into megasoft.project(ID, CLIENT_ID, START_DATE, FINISH_DATE)" +
                "values(?, ?, ?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (Project project : projects) {
                statement.setInt(1, project.getId());
                statement.setInt(2, project.getClientId());
                statement.setDate(3, Date.valueOf(project.getStartDate()));
                statement.setDate(4, Date.valueOf(project.getFinishDate()));
                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertIntoProjectWorker(List<ProjectWorker> projectsWorkers) {
        String sql = "insert into megasoft.project_worker(PROJECT_ID, WORKER_ID)" +
                "values(?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (ProjectWorker projectWorker: projectsWorkers) {
                statement.setInt(1, projectWorker.getProjectId());
                statement.setInt(2, projectWorker.getWorkerId());
                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private List<Worker> addWorkers() {
        List<Worker> workers = new ArrayList<>();

        workers.add(new Worker(
                1, "Pavlo", LocalDate.of(1985, 1, 2), "Trainee", 900));
        workers.add(new Worker(
                2, "Ihor", LocalDate.of(1986, 2, 3), "Junior", 1500));
        workers.add(new Worker(
                3, "Ivan", LocalDate.of(1987, 3, 4), "Senior", 300));
        workers.add(new Worker(
                4, "Oksana", LocalDate.of(1988, 4, 5), "Middle", 2200));
        workers.add(new Worker(
                5, "Olga", LocalDate.of(1989, 5, 5), "Trainee", 1050));
        workers.add(new Worker(
                6, "Serhiy", LocalDate.of(1990, 6, 7), "Junior", 1700));
        workers.add(new Worker(
                7, "Natalia", LocalDate.of(1991, 7, 8), "Middle", 2500));
        workers.add(new Worker(
                8, "Mykola", LocalDate.of(1992, 8, 9), "Senior", 3500));
        workers.add(new Worker(
                9, "Yulia", LocalDate.of(1993, 9, 10), "Trainee", 1100));
        workers.add(new Worker(
                10, "Viktor", LocalDate.of(1994, 10, 11), "Senior", 5500));

        return workers;
    }


    private List<Client> addClients() {
        List<Client> clients = new ArrayList<>();

        clients.add(new Client(1, "Oleksandr"));
        clients.add(new Client(2, "Dmytro"));
        clients.add(new Client(3, "Andriy"));
        clients.add(new Client(4, "Kateryna"));
        clients.add(new Client(5, "Svetlana"));
        clients.add(new Client(6, "Vasyl"));
        clients.add(new Client(7, "Tetiana"));
        clients.add(new Client(8, "Mykhailo"));
        clients.add(new Client(9, "Yevhen"));
        clients.add(new Client(10, "Lilia"));

        return clients;
    }


    private List<Project> addProjects() {
        List<Project> projects = new ArrayList<>();

        projects.add(new Project(
                1, 10, LocalDate.of(2024, 8, 1), LocalDate.of(2024, 9, 25)));
        projects.add(new Project(
                2, 9, LocalDate.of(2024, 8, 2), LocalDate.of(2024, 10, 25)));
        projects.add(new Project(
                3, 9, LocalDate.of(2024, 8, 3), LocalDate.of(2024, 11, 25)));
        projects.add(new Project(
                4, 9, LocalDate.of(2024, 8, 4), LocalDate.of(2024, 12, 15)));
        projects.add(new Project(
                5, 6, LocalDate.of(2024, 8, 5), LocalDate.of(2025, 1, 25)));
        projects.add(new Project(
                6, 5, LocalDate.of(2024, 8, 6), LocalDate.of(2025, 2, 25)));
        projects.add(new Project(
                7, 4, LocalDate.of(2024, 8, 7), LocalDate.of(2025, 3, 25)));
        projects.add(new Project(
                8, 3, LocalDate.of(2024, 8, 8), LocalDate.of(2025, 4, 25)));
        projects.add(new Project(
                9, 2, LocalDate.of(2024, 8, 9), LocalDate.of(2025, 5, 25)));
        projects.add(new Project(
                10, 1, LocalDate.of(2024, 8, 10), LocalDate.of(2025, 6, 25)));

        return projects;
    }


    private List<ProjectWorker> addProjectsWorkers() {
        List<ProjectWorker> projectsWorkers = new ArrayList<>();

        projectsWorkers.add(new ProjectWorker(1, 1));
        projectsWorkers.add(new ProjectWorker(1, 2));
        projectsWorkers.add(new ProjectWorker(1, 3));
        projectsWorkers.add(new ProjectWorker(2, 4));
        projectsWorkers.add(new ProjectWorker(2, 5));
        projectsWorkers.add(new ProjectWorker(3, 6));
        projectsWorkers.add(new ProjectWorker(4, 7));
        projectsWorkers.add(new ProjectWorker(4, 8));
        projectsWorkers.add(new ProjectWorker(5, 9));
        projectsWorkers.add(new ProjectWorker(6, 10));
        projectsWorkers.add(new ProjectWorker(7, 5));
        projectsWorkers.add(new ProjectWorker(8, 6));
        projectsWorkers.add(new ProjectWorker(9, 7));
        projectsWorkers.add(new ProjectWorker(10, 8));

        return projectsWorkers;
    }
}
