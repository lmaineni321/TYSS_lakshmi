package Practices;

import com.vtiger.generic.Excelutility;


public class ExcelvaluerangeTest {
	
public static void main(String[] args) throws Throwable
{
	Excelutility eut=new Excelutility();
	
    for(int i=0;i<=eut.getLastRow("Sheet1");i++)
    {
    	int value=eut.readnumericdata("Sheet1", i, 1);
    	String name=eut.readdatafromexcel("Sheet1", i, 0);
    	if(value>=15000)
    	{
    		System.out.println(name);
    	}
    }
}
}
