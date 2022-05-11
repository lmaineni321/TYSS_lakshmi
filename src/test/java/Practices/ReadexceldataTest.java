package Practices;

import java.util.HashMap;
import java.util.Map;

import com.vtiger.generic.Excelutility;


public class ReadexceldataTest {

	public static void main(String[] args) throws Throwable {
		
		Excelutility eut=new Excelutility();
		
		 Map<String, Integer> kv=new HashMap<String,Integer>();
	    for(int i=0;i<=eut.getLastRow("Sheet1");i++)
	    {
	    	int value=eut.readnumericdata("Sheet1", i, 1);
	    	String name=eut.readdatafromexcel("Sheet1", i, 0);

	    	kv.put(name, value);
//	    	 System.out.println(kv);
		    
	    }
	    System.out.println(kv);
	}
}