package main.Simulator;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import main.Plugin.DataLocal;
import main.Plugin.DataPlugin;
import main.Plugin.DataWeb;
import main.Plugin.DisplayPieChar;
import main.Plugin.DisplayBarChar;
import main.Plugin.DisplayPlugin;
import main.framework.Framework;

public class StartApp extends JFrame{
    /**
     * 
     */
    
    public static void main(String[] args) {
        //show select plugin type frame
        SelectTypeUI selectTypeUI = new SelectTypeUI();
        selectTypeUI.startUp();
    }
        
}
