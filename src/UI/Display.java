package UI;

import Methods.Permutation;
import Methods.SuperMethod;
import Methods.XorСipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Александр on 24.03.14.
 */
public class Display extends JFrame{
    public Display(){
        //Получение разрешения экрана и установка его высоты и ширины
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize( screenWidth / 2 , screenHeight / 2 );
        setLocation( screenWidth / 4, screenHeight / 4);
        setTitle("ISDP");

        Container contentPane = getContentPane();//Создание основной панели

        //Создание кнопок зашифровать и расшифровать
        cryptPanel = new JPanel();
        JButton encryptButton = new JButton("Encrypt");
        cryptPanel.add(encryptButton);
        encryptButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Lalka ");
                //method.encrypt;
            }
        });
        JButton decryptButton = new JButton("Decrypt");
        cryptPanel.add(decryptButton);
        decryptButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("LalkaNeЙа ");
                //method.decrypt;
            }
        });
        contentPane.add(cryptPanel, BorderLayout.SOUTH);//Добавление панели с кнопками на основную панель

        //Создание текстового поля
        textArea = new JTextArea(10,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);//Добавление текстовой зоны на основную панель

        //Создание панели выбора методов
        methodPanel = new JPanel();
        buttonGroup = new ButtonGroup();
        //addRadioButton("Replacement");//Замена с
        addRadioButton("Permutation");//Перестановкасмещением
        addRadioButton("XOR cipher");//Метод гаммирования

        contentPane.add(methodPanel, BorderLayout.EAST);
    }

    public void addRadioButton(final String name){
        JRadioButton button = new JRadioButton(name);
        buttonGroup.add(button);
        methodPanel.add(button);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Здесь создаем объект метода для дальнейшей работы");
               if(name == "Permutation"){
                //Permutation permutation = new Permutation();
                   SuperMethod method = new SuperMethod(new Permutation());
               }
               else {
                   //XorСipher xorСipher = new XorСipher();
                   SuperMethod method = new SuperMethod(new XorСipher());
               }
            }
        };
        button.addActionListener(listener);
    }//Метод для создания кнопок выбора методов

    public JTextArea textArea;
    private JPanel cryptPanel;
    private JScrollPane scrollPane;
    private JPanel methodPanel;
    private ButtonGroup buttonGroup;
}
