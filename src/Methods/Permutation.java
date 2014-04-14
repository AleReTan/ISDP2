package Methods;
import UI.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Александр on 01.04.14.
 */
public class Permutation extends JFrame implements Method{
    Display ta = new Display();
    JTextField textField = new JTextField(10);
    private String displacement;
/*
    public void setCryptText() {
        this.cryptText = ta.textArea.getText();
    }
*/
    public void runWindow(){
        setTitle("Введите смещение");
        setSize(200,200);

        JLabel label1 = new JLabel("Введите смещение:");
       // JTextField textField = new JTextField(10);
        textField.setMaximumSize(textField.getPreferredSize());

        Box hbox1 = Box.createHorizontalBox();
        hbox1.add(label1);
        hbox1.add(Box.createHorizontalStrut(10));
        hbox1.add(textField);

        JButton okButton = new JButton("Ok");
        Box hbox2 = Box.createHorizontalBox();
        hbox2.add(okButton);
        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                displacement = textField.getText();
                System.exit(0);

            }
        });

        Box vbox = Box.createVerticalBox();
        vbox.add(hbox1);
        vbox.add(hbox2);

        Container contentPane1 = getContentPane();
        contentPane1.add(vbox, BorderLayout.CENTER);

    }

    public void encrypt(){
        String cryptText = ta.textArea.getText();
        char [] charString = cryptText.toCharArray();
        int [] askiiString = new int [charString.length];
        char [] newCharString = new char[charString.length];
        for (int i = 0; i < charString.length; i++)
            {
                askiiString[i] = (int) charString[i];
                askiiString[i] += Integer.parseInt(displacement);
                newCharString[i] = (char) askiiString[i];

            }
       String newCryptText = new String(newCharString);
        ta.textArea.append("\n" + newCryptText);
    }
    public void decrypt(){
        String cryptText = ta.textArea.getText();
        char [] charString = cryptText.toCharArray();
        int [] askiiString = new int [charString.length];
        char [] newCharString = new char[charString.length];
        for (int i = 0; i < charString.length; i++)
        {
            askiiString[i] = (int) charString[i];
            askiiString[i] -= Integer.parseInt(displacement);
            newCharString[i] = (char) askiiString[i];

        }
        String newCryptText = new String(newCharString);
        ta.textArea.append("\n" + newCryptText);
    }
}
