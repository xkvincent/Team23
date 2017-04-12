package main.Plugin;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import main.framework.Framework;

public class DataLocal implements DataPlugin {
    
    private Map<String, Double> mappy;
    private Framework framework;
    
    public DataLocal() {
        mappy = new HashMap<>();        
    }

    @Override
    public void setFramework(Framework framework) {
        this.framework = framework;
    }

    @Override
    public void parseSource(String source) {
        String line;
        String name;
        double star;
        String[] splitedParts;
        FileReader read;
        try {
            read = new FileReader(source);
            BufferedReader bf = new BufferedReader(read);
            try {
                while ((line = bf.readLine()) != null) {
                    splitedParts = line.split("-");
                    name = splitedParts[0];
                    star = Double.parseDouble(splitedParts[1]);
                    if (!mappy.containsKey(name)) {
                        mappy.put(name, star);
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("OOPS");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

    @Override
    public Map<String, Double> getMap() {
        return mappy;
    }
    
    
    private static Map<String, Double> sortByComparator(
            Map<String, Double> unsortMap) {
        List<Entry<String, Double>> list = new ArrayList<>(
                unsortMap.entrySet());
        // sort list based on comparator
        Collections.sort(list, new Comparator<Entry<String, Double>>() {
            public int compare(Entry<String, Double> o1, 
                    Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // put sorted list into map again
        // LinkedHashMap make sure order in which keys were inserted
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Iterator<Entry<String, Double>> it = list.iterator();
                it.hasNext(); ) {
            Entry<String, Double> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
    
    
    @Override
    public Map<String, Double> getSortedMap() {
        Map<String, Double> sortedMap = sortByComparator(mappy);
        return sortedMap;
//        Map<String, Double> sortedMap2 = new HashMap<String, Double>();
        
//        for (Object key : sortedMap.keySet()) {
//            String keyS = (String) key;
//            sortedMap2.put(keyS, (double) sortedMap.get(keyS));
//        }
//        return sortedMap2;
    }  
}