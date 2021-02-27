import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

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

                int number = getNumber();
                int mask = getMask();

                printResult(number & mask);

            }
        });

        ORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int number = getNumber();
                int mask = getMask();

                printResult(number | mask);

            }
        });

        XORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int number = getNumber();
                int mask = getMask();

                printResult(number ^ mask);
            }
        });

        NOTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (numDataType.contentEquals("Binary")) {
                    StringBuilder number = new StringBuilder(numberTextField.getText());

                    for (int i = 0; i < number.length(); i++) {

                        if (number.charAt(i) == '0') {
                            number.setCharAt(i, '1');
                        } else {
                            number.setCharAt(i, '0');
                        }
                    }

                    if (resultDataType.contentEquals("Binary")) {
                        resultTextField.setText(number.toString());
                        return;
                    }

                    printResult(Integer.parseInt(number.toString(), 2));

                    return;
                }

                int number = getNumber();
                int length = Integer.toBinaryString(number).length();

                int mask = -1;
                number ^= mask;
                mask = mask >>> (32 - length);

                printResult(number & mask);

            }
        });

        shiftLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int number = getNumber();
                int mask = getMask();

                printResult(number << mask);
            }
        });

        shiftRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int number = getNumber();
                int mask = getMask();

                printResult(number >> mask);
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
                number = Integer.parseInt(numberTextField.getText(), 2);
                break;
            case "Decimal":
                number = Integer.parseInt(numberTextField.getText());
                break;
            case "Hex":
                number = Integer.parseInt(numberTextField.getText(), 16);
                break;
        }

        return number;
    }

    private int getMask() {

        int mask = 0;

        switch (maskDataType) {
            case "Binary":
                mask = Integer.parseInt(maskTextField.getText(), 2);
                break;
            case "Decimal":
                mask = Integer.parseInt(maskTextField.getText());
                break;
            case "Hex":
                mask = Integer.parseInt(maskTextField.getText(), 16);
                break;
        }

        return mask;

    }

    private void printResult(int result) {

        switch (resultDataType) {
            case "Binary":
                resultTextField.setText(Integer.toString(result, 2));
                break;
            case "Decimal":
                resultTextField.setText(Integer.toString(result));
                break;
            case "Hex":
                resultTextField.setText(Integer.toString(result, 16));
                break;
        }

    }

    private void error() {


    }

    // ------------------------------------------------------------------------------------------------

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 9, new Insets(20, 20, 20, 20), -1, -1));
        Font panelFont = this.$$$getFont$$$(null, Font.PLAIN, 20, panel.getFont());
        if (panelFont != null) panel.setFont(panelFont);
        numberTextField = new JTextField();
        Font numberTextFieldFont = this.$$$getFont$$$("Tahoma", Font.PLAIN, 20, numberTextField.getFont());
        if (numberTextFieldFont != null) numberTextField.setFont(numberTextFieldFont);
        numberTextField.setText("");
        panel.add(numberTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBox1 = new JComboBox();
        Font comboBox1Font = this.$$$getFont$$$(null, Font.PLAIN, 20, comboBox1.getFont());
        if (comboBox1Font != null) comboBox1.setFont(comboBox1Font);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Binary");
        defaultComboBoxModel1.addElement("Decimal");
        defaultComboBoxModel1.addElement("Hex");
        comboBox1.setModel(defaultComboBoxModel1);
        panel.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(0, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.PLAIN, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Number");
        panel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        maskTextField = new JTextField();
        Font maskTextFieldFont = this.$$$getFont$$$(null, Font.PLAIN, 20, maskTextField.getFont());
        if (maskTextFieldFont != null) maskTextField.setFont(maskTextFieldFont);
        panel.add(maskTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, Font.PLAIN, 20, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Mask");
        panel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        Font comboBox2Font = this.$$$getFont$$$(null, Font.PLAIN, 20, comboBox2.getFont());
        if (comboBox2Font != null) comboBox2.setFont(comboBox2Font);
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Binary");
        defaultComboBoxModel2.addElement("Decimal");
        defaultComboBoxModel2.addElement("Hex");
        comboBox2.setModel(defaultComboBoxModel2);
        panel.add(comboBox2, new com.intellij.uiDesigner.core.GridConstraints(1, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ORButton = new JButton();
        Font ORButtonFont = this.$$$getFont$$$(null, Font.PLAIN, 20, ORButton.getFont());
        if (ORButtonFont != null) ORButton.setFont(ORButtonFont);
        ORButton.setText("OR");
        panel.add(ORButton, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        XORButton = new JButton();
        Font XORButtonFont = this.$$$getFont$$$(null, Font.PLAIN, 20, XORButton.getFont());
        if (XORButtonFont != null) XORButton.setFont(XORButtonFont);
        XORButton.setText("XOR");
        panel.add(XORButton, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NOTButton = new JButton();
        Font NOTButtonFont = this.$$$getFont$$$(null, Font.PLAIN, 20, NOTButton.getFont());
        if (NOTButtonFont != null) NOTButton.setFont(NOTButtonFont);
        NOTButton.setText("NOT");
        panel.add(NOTButton, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        shiftLeftButton = new JButton();
        Font shiftLeftButtonFont = this.$$$getFont$$$(null, Font.PLAIN, 20, shiftLeftButton.getFont());
        if (shiftLeftButtonFont != null) shiftLeftButton.setFont(shiftLeftButtonFont);
        shiftLeftButton.setText("Shift Left");
        panel.add(shiftLeftButton, new com.intellij.uiDesigner.core.GridConstraints(2, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        shiftRightButton = new JButton();
        Font shiftRightButtonFont = this.$$$getFont$$$(null, Font.PLAIN, 20, shiftRightButton.getFont());
        if (shiftRightButtonFont != null) shiftRightButton.setFont(shiftRightButtonFont);
        shiftRightButton.setText("Shift Right");
        panel.add(shiftRightButton, new com.intellij.uiDesigner.core.GridConstraints(2, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ANDButton = new JButton();
        Font ANDButtonFont = this.$$$getFont$$$(null, Font.PLAIN, 20, ANDButton.getFont());
        if (ANDButtonFont != null) ANDButton.setFont(ANDButtonFont);
        ANDButton.setText("AND");
        panel.add(ANDButton, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        resultTextField = new JTextField();
        resultTextField.setEditable(false);
        Font resultTextFieldFont = this.$$$getFont$$$(null, Font.PLAIN, 20, resultTextField.getFont());
        if (resultTextFieldFont != null) resultTextField.setFont(resultTextFieldFont);
        panel.add(resultTextField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, Font.PLAIN, 20, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Result");
        panel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox3 = new JComboBox();
        Font comboBox3Font = this.$$$getFont$$$(null, Font.PLAIN, 20, comboBox3.getFont());
        if (comboBox3Font != null) comboBox3.setFont(comboBox3Font);
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Binary");
        defaultComboBoxModel3.addElement("Decimal");
        defaultComboBoxModel3.addElement("Hex");
        comboBox3.setModel(defaultComboBoxModel3);
        panel.add(comboBox3, new com.intellij.uiDesigner.core.GridConstraints(3, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        convertButton = new JButton();
        Font convertButtonFont = this.$$$getFont$$$(null, Font.PLAIN, 20, convertButton.getFont());
        if (convertButtonFont != null) convertButton.setFont(convertButtonFont);
        convertButton.setText("Convert");
        panel.add(convertButton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
