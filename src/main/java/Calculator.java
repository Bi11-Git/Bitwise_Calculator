import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    private JPanel panel;
    private JTextField numberTextField;
    private JComboBox comboBox1;
    private JTextField maskTextField;
    private JComboBox comboBox2;
    private JButton ORButton;
    private JButton XORButton;
    private JButton NOTButton;
    private JButton shiftLeftButton;
    private JButton shiftRightButton;
    private JButton ANDButton;
    private JTextField resultTextField;
    private JComboBox comboBox3;
    private JButton convertButton;

    private String numDataType = "Binary";
    private String maskDataType = "Binary";
    private String resultDataType = "Binary";

    public Calculator() {

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                numDataType = comboBox1.getSelectedItem().toString();
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maskDataType = comboBox2.getSelectedItem().toString();
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultDataType = comboBox3.getSelectedItem().toString();
            }
        });


        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = getNumber();
                printResult(number);
            }
        });

        ANDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        XORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        NOTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        shiftLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        shiftRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private int getNumber() {
        int number = 0;

        switch (numDataType) {
            case "Binary":
                number = Integer.parseInt(numberTextField.getText() , 2);
                break;
            case "Decimal" :
                number = Integer.parseInt(numberTextField.getText());
                break;
            case "Hex" :
                number = Integer.parseInt(numberTextField.getText() , 16);
                break;
        }

        return number;
    }

    private int getMask(){

        return 0;
    }

    private void printResult(int result) {

        switch (resultDataType) {
            case "Binary":
                resultTextField.setText(Integer.toString(result, 2));
                break;
            case "Decimal" :
                resultTextField.setText(String.valueOf(result));
                break;
            case "Hex" :
                resultTextField.setText(Integer.toString(result, 16));
                break;
        }

    }

    private void error() {


    }
}
