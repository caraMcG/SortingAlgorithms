/**
 * Created on Nov 17, 2011
 *
 * Project: assignment3SortingPolygons 
 */
package sortingPolygonsForName;

import sortingUtilities.Sorts;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import polygons.*;

import java.io.*;

/**
 * PolygonSorter.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: 
 */
public class PolygonSorterForName
{
	//Attributes
	private Polygon []			polygonArray;
	private char				compareType;
	private char 				sortType;
	private String				fileName;
	private FileInputStream 	fis;
	private StringBuffer 		sb;
	private int					count;

	//Constructors
	public PolygonSorterForName(String arg1, String arg2, String arg3)
	{
		arg1 = arg1.toLowerCase();
		arg2 = arg2.toLowerCase();
		arg3 = arg3.toLowerCase();
		
		if(arg1.charAt(1) == 'f')
		
		{
			fileName = arg1.substring(2);
		}
		else if(arg2.charAt(1) == 'f')
		{
			fileName = arg2.substring(2);
		}
		else
		{
			fileName = arg3.substring(2);
		}
		
		if(arg1.charAt(1) == 't')
		{
			compareType = arg1.charAt(2);
		}
		else if(arg2.charAt(1) == 't')
		{
			compareType = arg2.charAt(2);
		}
		else
		{
			compareType = arg3.charAt(2);
		}
		
		if(arg1.charAt(1) == 's')
		{
			sortType = arg1.charAt(2);
		}
		else if(arg2.charAt(1) == 's')
		{
			sortType = arg2.charAt(2);
		}
		else
		{
			sortType = arg3.charAt(2);
		}
		 
		System.out.println(fileName+" "+compareType+" "+sortType);
	}
	
	public void loadPolygonsToArray()
	{
		try
		{ 
			fis = new FileInputStream("res/"+fileName);
			
			sb = readNext();
			count = Integer.parseInt(sb.toString());
			polygonArray = new Polygon[count];
			
			for(int i = 0; i < count; i++)
			{
				sb = readNext();
				String className = "polygons."+sb.toString();
				
				Class cls = Class.forName(className);
				
				Class paramTypes[] = new Class[3];
				
				paramTypes[0] = Double.TYPE;
				paramTypes[1] = Double.TYPE;
				paramTypes[2] = Character.TYPE;
				
				Constructor ct = cls.getConstructor(paramTypes);
				
				Object argList[] = new Object[3];
				argList[0] = new Double(Double.parseDouble(readNext().toString()));
				argList[1] = new Double(Double.parseDouble(readNext().toString()));
				argList[2] = new Character(compareType);
				
				Object o = ct.newInstance(argList);
				
//				ArrayList<Polygon> polys = new ArrayList<Polygon>();
//				polys.add((Polygon)o);
//				polygonArray = polys.toArray(Polygon[] polygonArray);
				polygonArray[i] = (Polygon)o;
			}//end for loop
			
			fis.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}//end of loadPolygonsToArray method
	
	private StringBuffer readNext()
	{
		StringBuffer sbl = new StringBuffer();
		try
		{
			// read byte as ASCII code
			int c = fis.read();
			
			// check if char is 'space' or EOF
			while((c != -1) && (c != 32))
			{
				sbl.append((char)c);
				c = fis.read();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return sbl;
	}//end of readNext Method
	
	public void sortPolygons()
	{
		long start, stop;
		
		System.out.print("Starting sort...... ");
		/*for(int i = 0; i < polygonArray.length; i++)
		{
			System.out.println(polygonArray[i]);
		}*/
		start = System.currentTimeMillis();
		
		if(sortType == 'b')
		{
			Sorts.bubbleSort(polygonArray, polygonArray.length);
		}
		if(sortType == 's')
		{
			Sorts.selectionSort(polygonArray, polygonArray.length);
		}
		if(sortType == 'i')
		{
			Sorts.insertionSort(polygonArray, polygonArray.length);
		}
		if(sortType == 'm')
		{
			Sorts.mergeSort(polygonArray, 0, polygonArray.length - 1);
		}
		if(sortType == 'q')
		{
			Sorts.quickSort(polygonArray, 0, polygonArray.length - 1);
		}
		if(sortType == 'z')
		{
			Sorts.shellSort(polygonArray);
		}
		
		stop = System.currentTimeMillis();
		System.out.println("Done!");
		/*for(int i = 0; i < polygonArray.length; i++)
		{
			System.out.println(polygonArray[i]);
		}*/
		for(int i = 0; i < count; i = i + 1000)
		{
			System.out.println(i+1 + "th: " + polygonArray[i]);
		}
		System.out.println("Last element: " + polygonArray[count-1]);
		System.out.println("\nTime = "+(stop - start));
	}
}
