package ui;

import controller.TaskManager;
import model.AbstractTask;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class MainWindow extends JFrame {
    private final TaskManager taskManager;
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JButton addTaskButton;

    public MainWindow(TaskManager taskManager) {
        this.taskManager = taskManager;
        initializeUI();
        refreshTable();
    }

    private void initializeUI() {
        setTitle("To-Do List Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"Task ID", "Task Name", "Task Description", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        taskTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add Task button
        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTaskForm();
            }
        });
        add(addTaskButton, BorderLayout.NORTH);

        setVisible(true);
    }

    private void openTaskForm() {
        if (TaskForm.isFormOpen()) {
            JOptionPane.showMessageDialog(this, "Task form is already open.");
            return;
        }
        new TaskForm(taskManager, this);
    }

    public void refreshTable() {
        tableModel.setRowCount(0); // Clear table
        for (AbstractTask task : taskManager.getTasks()) {
            tableModel.addRow(new Object[]{
                task.getTaskId(),
                task.getTaskName(),
                task.getTaskDescription(),
                task.getStatus()
            });
        }
    }
}
