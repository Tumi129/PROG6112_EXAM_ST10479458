import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductGUI extends JFrame {

    JTextField txtCustomer, txtPrice;
    JComboBox<String> comboProduct;

    public ProductGUI() {
        setTitle("Product App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // --- MENU BAR ---
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // --- COMPONENTS ---
        txtCustomer = new JTextField(15);
        comboProduct = new JComboBox<>(new String[]{"Cozy Nights Monarch Mattress", "Restonic Barbados Matttress", "Sealy Phuket Mattress"});
        txtPrice = new JTextField(10);
        JButton btnProcess = new JButton("PROCESS");

        add(new JLabel("Customer Name:"));
        add(txtCustomer);
        add(new JLabel("Select Product:"));
        add(comboProduct);
        add(new JLabel("Enter Price:"));
        add(txtPrice);
        add(btnProcess);

        // --- ACTIONS ---
        exitItem.addActionListener(e -> System.exit(0));
        
        clearItem.addActionListener(e -> {
            txtCustomer.setText("");
            comboProduct.setSelectedIndex(0);
            txtPrice.setText("");
        });

        // Both the menu item and the button call the exact same method
        processItem.addActionListener(e -> processData());
        btnProcess.addActionListener(e -> processData());
    }

    private void processData() {
        try {
            String name = txtCustomer.getText();
            String product = (String) comboProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Use the logic class
            ProductCalculations calc = new ProductCalculations();
            double vat = calc.GetVat(price);
            double commission = calc.GetCommission(price);
            double total = calc.GetTotal(price);

            // Display message box (Q.2.3)
            String message = "Customer Name: " + name + "\n" +
                             "Product Name: " + product + "\n" +
                             "VAT Amount: R " + vat + "\n" +
                             "COMMISSION Amount: R " + commission + "\n" +
                             "TOTAL Sale Amount: R " + total;
            JOptionPane.showMessageDialog(this, message);

            // Save to file (Q.2.3)
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("************************");
                writer.println("Customer Name: " + name);
                writer.println("Product Name: " + product);
                writer.println("VAT Amount: R " + vat);
                writer.println("COMMISSION Amount: R " + commission);
                writer.println("TOTAL Sale Amount: R " + total);
                writer.println("************************");
            } catch (IOException ex) {
                System.out.println("Error saving file");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for price.");
        }
    }

    public static void main(String[] args) {
        new ProductGUI().setVisible(true);
    }
}
