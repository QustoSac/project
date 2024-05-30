import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField productTypeIdField;
    private JTextField materialTypeIdField;
    private JTextField productQuantityField;
    private JTextField param1Field;
    private JTextField param2Field;
    private JLabel resultLabel;

    public MainFrame() {
        setTitle("Material Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel productTypeIdLabel = new JLabel("Product Type ID:");
        productTypeIdLabel.setBounds(20, 20, 150, 25);
        add(productTypeIdLabel);

        productTypeIdField = new JTextField();
        productTypeIdField.setBounds(180, 20, 150, 25);
        add(productTypeIdField);

        JLabel materialTypeIdLabel = new JLabel("Material Type ID:");
        materialTypeIdLabel.setBounds(20, 60, 150, 25);
        add(materialTypeIdLabel);

        materialTypeIdField = new JTextField();
        materialTypeIdField.setBounds(180, 60, 150, 25);
        add(materialTypeIdField);

        JLabel productQuantityLabel = new JLabel("Product Quantity:");
        productQuantityLabel.setBounds(20, 100, 150, 25);
        add(productQuantityLabel);

        productQuantityField = new JTextField();
        productQuantityField.setBounds(180, 100, 150, 25);
        add(productQuantityField);

        JLabel param1Label = new JLabel("Parameter 1:");
        param1Label.setBounds(20, 140, 150, 25);
        add(param1Label);

        param1Field = new JTextField();
        param1Field.setBounds(180, 140, 150, 25);
        add(param1Field);

        JLabel param2Label = new JLabel("Parameter 2:");
        param2Label.setBounds(20, 180, 150, 25);
        add(param2Label);

        param2Field = new JTextField();
        param2Field.setBounds(180, 180, 150, 25);
        add(param2Field);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(20, 220, 150, 25);
        add(calculateButton);

        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(180, 220, 150, 25);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMaterial();
            }
        });
    }

    private void calculateMaterial() {
        String productTypeId = productTypeIdField.getText();
        String materialTypeId = materialTypeIdField.getText();
        int productQuantity;
        int param1;
        int param2;

        try {
            productQuantity = Integer.parseInt(productQuantityField.getText());
            param1 = Integer.parseInt(param1Field.getText());
            param2 = Integer.parseInt(param2Field.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input!");
            return;
        }

        int result = ProductMaterialCalculator.calculateMaterial(productTypeId, materialTypeId, productQuantity, param1,
                param2);
        resultLabel.setText("Result: " + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
