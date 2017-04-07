package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

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
    
    public void startUp() {
        
        jcb = new JComboBox<>();
        jcb.addItem("Data 1");
        jcb.addItem("Data 2");
        
        jcb2 = new JComboBox<>();
        jcb2.addItem("Display 1");
        jcb2.addItem("Display 2");
        
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
                framework = new Framework(dataPlugin, displayPlugin);
            }
        });
        
        jcb.setBounds(250, 0, 150, 20);
        jcb2.setBounds(250, 0, 150, 20);
        //submit.setBounds(250, 50, 100, 20);
        
        this.add(jcb);
        this.add(jcb2);
        this.add(submit);
        this.setVisible(true);
    }

}
