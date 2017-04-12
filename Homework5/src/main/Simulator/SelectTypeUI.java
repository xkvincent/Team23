package main.Simulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import main.Plugin.DataLocal;
import main.Plugin.DataPlugin;
import main.Plugin.DataWeb;
import main.Plugin.DisplayPieChar;
import main.Plugin.DisplayBarChar;
import main.Plugin.DisplayPlugin;
import main.framework.Framework;
/**
 * This class is used to show the JFrame to get the plugin type.
 * @author 
 *
 */
public class SelectTypeUI extends JFrame{
    private final long serialVersionUID = 1L;
    private JComboBox<String> jcb;
    private JComboBox<String> jcb2;
    private Framework framework;
    private DataPlugin dataPlugin;
    private DisplayPlugin displayPlugin;
    private JButton submit;
    private JTextField inputSource;
    private JLabel sourceLabel;
    
    public void startUp() {
        
        this.setLayout(null); // very important !!!
        
        jcb = new JComboBox<>();
        jcb.addItem("Data 1");
        jcb.addItem("Data 2");
        
        jcb2 = new JComboBox<>();
        jcb2.addItem("Display 1");
        jcb2.addItem("Display 2");
        
        sourceLabel = new JLabel("Please input valid URL or File Name : ");
        inputSource = new JTextField();
        
        submit = new JButton();
        submit.setText("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("--------------- click button!");
                String type1 = (String) jcb.getSelectedItem();
                String type2 = (String) jcb2.getSelectedItem();
                System.out.println(type1);
                System.out.println(type2);
                
                if (type1.equals("Data 1")) {
                    dataPlugin = new DataLocal();
                    
                } else {
                    dataPlugin = new DataWeb();
                    
                }
                if (type2.equals("Display 1")) {
                    displayPlugin = new DisplayPieChar();
                } else {
                    displayPlugin = new DisplayBarChar();
                }
                if(inputSource.getText().length() > 1) {
                    System.out.println("input Source:" + inputSource.getText());
                    framework = new Framework(dataPlugin, displayPlugin, inputSource.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Your Must input a URL or File Name!");
                    System.out.println("Your Must input a URL or File Name!");
                }
                    
//                framework.();
            }
        });
        
        
        this.setSize(400, 350);
        jcb.setBounds(120, 20, 150, 20);
        jcb2.setBounds(120, 70, 150, 20);
        
        sourceLabel.setBounds(30, 150, 300,20);
        inputSource.setBounds(10, 180, 370, 20);
        
        submit.setBounds(150, 230, 100, 20);
        
        
        this.add(jcb);
        this.add(jcb2);
        this.add(sourceLabel);
        this.add(inputSource);
        this.add(submit);
//        this.pack();
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
