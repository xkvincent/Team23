package Main;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import Plugin.DataLocal;
import Plugin.DataPlugin;
import Plugin.DataWeb;
import Plugin.Display1;
import Plugin.Display2;
import Plugin.DisplayPlugin;
import framework.Framework;

public class StartApp extends JFrame{
    /**
     * 
     */
//    private static final long serialVersionUID = 1L;
//    private static JComboBox<String> jcb;
//    private static JComboBox<String> jcb2;
//    private static Framework framework;
//    private static DataPlugin dataPlugin;
//    private static DisplayPlugin displayPlugin;
    
    public static void main(String[] args) {
        //show select plugin type frame
        SelectTypeUI selectTypeUI = new SelectTypeUI();
        selectTypeUI.startUp();
    }
    
//    public static void showSelector() {
//        
//        jcb = new JComboBox<>();
//        jcb.addItem("Data 1");
//        jcb.addItem("Data 2");
//        
//        jcb2 = new JComboBox<>();
//        jcb2.addItem("Display 1");
//        jcb2.addItem("Display 2");
//        
//        String type1 = (String) jcb.getSelectedItem();
//        String type2 = (String) jcb2.getSelectedItem();
//        System.out.println(type1);
//        System.out.println(type2);
//        
//        if (type1.equals("Data 1")) {
//            dataPlugin = new DataLocal();
//            
//        } else {
//            dataPlugin = new DataWeb();
//            
//        }
//        if (type2.equals("Display 1")) {
//            displayPlugin = new Display1();
//        } else {
//            displayPlugin = new Display2();
//        }
//        
//        
//        framework = new Framework(dataPlugin, displayPlugin);
//        framework.setVisible(true);
//    }
    
}
