package Plugin;

import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import framework.Framework;

public class DataWeb implements DataPlugin {
    private Map<String, Double> map;
    private Framework framework;
    private static final String restNameClass = "biz-name js-analytics-click";
    private static final String starClass = "i-stars";
    DataWeb() {
        map = new HashMap<>();
    }
    
    @Override
    public void setFramework(Framework framework) {
        this.framework = framework;
    }

    @Override
    public Map<String, Double> getMap() {
        return map;
    }

    /**
     * @param source input web URL
     */
    @Override
    public void parseSource(String source) {
        
        List<String> restName = new ArrayList<>();
        List<Double> stars = new ArrayList<>();
        Document doc;
        try {
//            File input = new File("/tmp/input.html");
//            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
            
            doc = Jsoup.connect(source).get();
            Elements elements = doc.getElementsByClass(restNameClass);
            System.out.println(elements.size());
            for (Element e : elements) {
//                Elements es = e.getElementsByTag("span");
                restName.add(e.text());
            }
            
            Elements elements2 = doc.getElementsByClass(starClass);
            int idx2 = 0;
            System.out.println(elements2.size());
            for (Element e : elements2) {
//                Elements es = e.getElementsByTag("span");
                double star = Double.parseDouble(e.attr("title").split(" ")[0]);
                stars.add(star);
            }
            //store two List into Map
            for (int i = 0; i < restName.size(); i++) {
                map.put(restName.get(i), stars.get(i));
//                System.out.println(restName.get(i) + " ----- " +stars.get(i));
            }
            
            
            
            // sort Map by value
            Map<Object, Object> sortedMap = sortByComparator(map);
            
            for (Object key : sortedMap.keySet()) {
                String keyS = (String) key;
                System.out.println(key + "  ------  " + sortedMap.get(keyS));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    /**
     * Transfer a unsorted HashMap to a sorted Map, which is sorted by
     * value's descending order.
     * @param unsortMap input unsorted HashMap
     * @return sorted Map
     */
    private static Map<Object, Object> sortByComparator(
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
        Map<Object, Object> sortedMap = new LinkedHashMap<>();
        for (Iterator<Entry<String, Double>> it = list.iterator();
                it.hasNext(); ) {
            Entry<String, Double> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }    
   
}
