import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.Vector;

public class ContactBookManager extends JFrame {
    private static final long serialVersionUID = 1L;
	private JTable contactTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, streetField, cityField, stateField, phoneField, emailField;
    private JButton addButton, removeButton, clearButton;
    private JPanel inputPanel, buttonPanel, mainPanel;
    private JScrollPane tableScrollPane;
    
    private static final String DEFAULT_DIR = System.getProperty("user.dir");

    public ContactBookManager() {
        super("Contact Book Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        getContentPane().setLayout(new BorderLayout());
        
        createMenu();
        
        mainPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"Name", "Street", "City", "State", "Phone", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        contactTable = new JTable(tableModel);
        tableScrollPane = new JScrollPane(contactTable);

        createInputFields();
        createButtons();

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        getContentPane().add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> loadContacts());
        
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveContacts());
        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
    
    private void createInputFields() {
        inputPanel = new JPanel(new GridLayout(0, 6, 10, 5));
        
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        nameField.setToolTipText("Please enter your name!");
        inputPanel.add(nameField);
        
        inputPanel.add(new JLabel("Street:"));
        streetField = new JTextField(20);
        streetField.setToolTipText("Please enter your address!");
        inputPanel.add(streetField);
        
        inputPanel.add(new JLabel("City:"));
        cityField = new JTextField(20);
        cityField.setToolTipText("Please enter your city!");
        inputPanel.add(cityField);
        
        inputPanel.add(new JLabel("State:"));
        stateField = new JTextField(20);
        stateField.setToolTipText("Please enter your state!");
        inputPanel.add(stateField);
        
        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField(20);
        phoneField.setToolTipText("Please enter your mobile number!");
        inputPanel.add(phoneField);
        
        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        emailField.setToolTipText("Please enter your email-id!");
        inputPanel.add(emailField);
        
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    private void createButtons() {
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        addButton = new JButton("Add Contact");
        addButton.addActionListener(e -> addContact());
        
        removeButton = new JButton("Remove Selected");
        removeButton.addActionListener(e -> removeSelectedContact());
        
        clearButton = new JButton("Clear All");
        clearButton.addActionListener(e -> clearAllContacts());
        
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
    }
    
    private void addContact() {
        String name = nameField.getText().trim();
        String street = streetField.getText().trim();
        String city = cityField.getText().trim();
        String state = stateField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        
        if (!name.isEmpty()) {
            Object[] rowData = {name, street, city, state, phone, email};
            tableModel.addRow(rowData);
            
            nameField.setText("");
            streetField.setText("");
            cityField.setText("");
            stateField.setText("");
            phoneField.setText("");
            emailField.setText("");
            
            nameField.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Name field cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void removeSelectedContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a contact to remove.", "Selection Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void clearAllContacts() {
        if (tableModel.getRowCount() > 0) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to remove all contacts?", 
                "Confirm Clear All", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.setRowCount(0);
            }
        }
    }
    
    private void saveContacts() {
        JFileChooser chooser = new JFileChooser(DEFAULT_DIR);
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filePath = chooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".csv")) {
                filePath += ".csv";
            }
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    writer.print(tableModel.getColumnName(i));
                    if (i < tableModel.getColumnCount() - 1) {
                        writer.print(",");
                    }
                }
                writer.println();
                
                for (int row = 0; row < tableModel.getRowCount(); row++) {
                    for (int col = 0; col < tableModel.getColumnCount(); col++) {
                        String value = tableModel.getValueAt(row, col) != null ? 
                                       tableModel.getValueAt(row, col).toString() : "";
                        if (value.contains(",")) {
                            writer.print("\"" + value + "\"");
                        } else {
                            writer.print(value);
                        }
                        
                        if (col < tableModel.getColumnCount() - 1) {
                            writer.print(",");
                        }
                    }
                    writer.println();
                }
                JOptionPane.showMessageDialog(this, "Contacts saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error saving file: " + e.getMessage(), 
                    "File Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadContacts() {
        JFileChooser chooser = new JFileChooser(DEFAULT_DIR);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filePath = chooser.getSelectedFile().getAbsolutePath();
            
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                tableModel.setRowCount(0);
                String line = reader.readLine();
                while ((line = reader.readLine()) != null) {
                    Vector<String> rowData = new Vector<>();
                    StringBuilder field = new StringBuilder();
                    boolean inQuotes = false;
                    
                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if (c == '"') {
                            inQuotes = !inQuotes;
                        } else if (c == ',' && !inQuotes) {
                            rowData.add(field.toString());
                            field = new StringBuilder();
                        } else {
                            field.append(c);
                        }
                    }
                    rowData.add(field.toString());
                    tableModel.addRow(rowData);
                }
                JOptionPane.showMessageDialog(this, "Contacts loaded successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error loading file: " + e.getMessage(), 
                    "File Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactBookManager manager = new ContactBookManager();
            manager.setVisible(true);
        });
    }
}