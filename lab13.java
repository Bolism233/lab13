package lab13_lab;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class lab13 
{
	public ArrayList<Integer> values = new ArrayList<Integer>();
	
	public void readData(String filename)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			String st;
			
			while((st = br.readLine()) != null)
			{		
				values.add(Integer.parseInt(st));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public long getTotalCount()
	{
		return values.stream().count();
	}
	
	public long getOddCount()
	{
		return values.stream().filter(x -> x%2 == 1).count();
	}
	
	public long getEvenCount ()
	{
		return values.stream().filter(x -> x%2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return values.stream().filter(x -> x>5).distinct().count();
	} //distinct//
	
	public Integer[] getResult1()
	{
		return values.stream().filter(x -> x%2 == 0 && x > 5 && x < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return values.stream().limit(50).map(x -> x * x * 3).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return values.stream().filter(x -> x%2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
