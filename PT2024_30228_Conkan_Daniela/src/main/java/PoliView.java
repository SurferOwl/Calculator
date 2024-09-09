import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PoliView implements ParseClass{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(mainPanel);

        JPanel titlePanel = new JPanel();
        mainPanel.add(titlePanel);

        JLabel titleLabel = new JLabel("Calculator Polinomial");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, titleLabel.getFont().getSize() + 5));
        titlePanel.add(titleLabel);

        JPanel textFieldPanel = new JPanel(new GridBagLayout());
        mainPanel.add(textFieldPanel);

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = -1;
        c.gridy = 0;

        JLabel x1Label = new JLabel("x1:");
        x1Label.setHorizontalAlignment(SwingConstants.LEFT);
        x1Label.setFont(new Font("Times New Roman", Font.PLAIN, x1Label.getFont().getSize()));
        textFieldPanel.add(x1Label,c);

        c.gridx = 15;
        c.gridy = 0;
        JTextField x1 = new JTextField();
        x1.setColumns(25);
        x1.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldPanel.add(x1,c);

        c.gridx = -1;
        c.gridy = 1;

        JLabel x2Label = new JLabel("x2:");
        x2Label.setHorizontalAlignment(SwingConstants.LEFT);
        x2Label.setFont(new Font("Times New Roman", Font.PLAIN, x2Label.getFont().getSize()));
        textFieldPanel.add(x2Label,c);

        c.gridx = 15;
        c.gridy = 1;
        JTextField x2 = new JTextField();
        x2.setColumns(25);
        x2.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldPanel.add(x2,c);

        JPanel p = new JPanel(new GridBagLayout());
        mainPanel.add(p);

        GridBagConstraints d = new GridBagConstraints();

        c.gridx = -1;
        c.gridy = 0;

        JButton calc = new JButton("Calculeaza:");

        p.add(calc,c);

        String[] options = {"Adunarea", "Scaderea", "Inmultirea", "Derivarea", "Integrarea"};
        JComboBox<String> op = new JComboBox<>(options);
        p.add(op);

        JPanel result = new JPanel();
        mainPanel.add(result);

        JTextField x = new JTextField();
        x.setColumns(30);
        x.setHorizontalAlignment(SwingConstants.LEFT);
        result.add(x);
        x.setEditable(false);

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cerinta = op.getSelectedItem().toString();

                String  nr1= x1.getText();
                String nr2 = x2.getText();

                PoliModel p1 = ParseClass.createPolynom(nr1);
                PoliModel p2 = ParseClass.createPolynom(nr2);

                PoliModel result;

                System.out.println(p1);
                System.out.println(p2);

                if(cerinta.equals("Adunarea")){
                    result = PoliController.addition(p1,p2);
                    System.out.println(result);
                }

                else if(cerinta.equals("Scaderea")){
                    result = PoliController.substraction(p1,p2);
                    System.out.println(result);
                }

                else if(cerinta.equals("Inmultirea")){
                    result = PoliController.multiply(p1,p2);
                    System.out.println(result);
                }

                else if(cerinta.equals("Derivarea")){
                    result = PoliController.derivation(p1);
                    System.out.println(result);
                }

                else{
                    result = PoliController.integration(p1);
                }

                int j = result.getDeg();
                StringBuilder resultString = new StringBuilder();

                for (int i = j; i >= 0; i--) {
                    if(result.getC().get(i)!=null){
                        float coefficient = result.getC().get(i);

                        if (coefficient != 0) {
                            if (resultString.length() > 0) {
                                if (coefficient > 0) {
                                    resultString.append('+');
                                }
                            }

                            if (i > 1) {
                                if (coefficient != 1f && coefficient != -1f) {
                                    resultString.append(coefficient);
                                }

                                    if(coefficient == -1f)
                                        resultString.append("-x^").append(i);
                                   else resultString.append("x^").append(i);

                            } else if (i == 1) {
                                if (coefficient != 1f && coefficient != -1f) {
                                    resultString.append(coefficient);
                                }

                                if(coefficient == -1f)
                                    resultString.append("-x");
                                else resultString.append("x");

                            } else {
                                resultString.append(coefficient);
                            }
                        }
                    }
                }

                x.setText(resultString.toString());
                System.out.println(resultString.toString());
                System.out.println(result);
            }
        });

        frame.setVisible(true);
    }
}