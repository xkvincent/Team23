package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Plugin.DataLocal;
import Plugin.DataPlugin;
import Plugin.DataWeb;
import Plugin.Display1;
import Plugin.Display2;
import Plugin.DisplayPlugin;
import framework.Framework;
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
    
    
    public void startUp() {
        
        jcb = new JComboBox<>();
        jcb.addItem("Data 1");
        jcb.addItem("Data 2");
        
        jcb2 = new JComboBox<>();
        jcb2.addItem("Display 1");
        jcb2.addItem("Display 2");
        
        inputSource = new JTextField();
        
        submit = new JButton();
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    displayPlugin = new Display1();
                } else {
                    displayPlugin = new Display2();
                }
                framework = new Framework(dataPlugin, displayPlugin, inputSource.getText());
//                framework.();
            }
        });
        
        jcb.setBounds(100, 100, 100, 100);
        jcb2.setBounds(150, 150, 150, 150);
        
        submit.setSize(20, 20);
        this.setSize(500, 500);
        
        inputSource.setSize(200,30);
        
        this.add(jcb);
        this.add(jcb2);
        this.add(submit);
        this.add(inputSource);
        
        this.setVisible(true);
    }

}
