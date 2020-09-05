package Test;

import javax.swing.JOptionPane;

public class JOptionPaneTest {

    public static void main(String[] args) {

        String[] options = {"Burger", "Pizza", "Ice Cream"};
        String msg = "Select one";
        String title = "Selection";

        String selection = JOptionPane.showInputDialog(null, msg, title, JOptionPane.QUESTION_MESSAGE, null, options, options[0]).toString();

        System.out.println(selection);

    }
}
