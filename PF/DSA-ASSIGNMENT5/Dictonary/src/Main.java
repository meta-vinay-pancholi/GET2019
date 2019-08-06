import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
	public static void main(String[] args) throws Exception   {
		DictionaryImplementation obj  = new DictionaryImplementation();
        Object obj1 = new JSONParser().parse(new FileReader("C:/workspace/Dictonary/input.json.txt")); 
        JSONObject jo = (JSONObject) obj1; 
        @SuppressWarnings({ "rawtypes", "unchecked" })
		Iterator<Map.Entry> itr1 = jo.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            @SuppressWarnings("rawtypes")
			Map.Entry pair = itr1.next(); 
            obj.addKeyValue(Integer.valueOf((String) pair.getKey() ), (String)pair.getValue() , obj.getRoot());
        } 
        System.out.println("-------------------------------------------------1");
        obj.sortedList(obj.getRoot());
        System.out.println("-------------------------------------------------2");
		obj.getKeyValue(90, obj.getRoot());
		System.out.println("-------------------------------------------------3");
		obj.sortInBetween(23, 40, obj.getRoot());
		System.out.println("-------------------------------------------------4");
		obj.deleteKey(90);
		obj.sortedList(obj.getRoot());		
	}
}


