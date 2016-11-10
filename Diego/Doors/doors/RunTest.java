package doors;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RunTest
{
	@Test
	public void testRun()
	{
		Run run1 = new Run(100);
		assertNotNull(run1);
	}
	
	@Test
	public void testTotalDoors()
	{
		int size = 1000;
		Run run1 = new Run(size);
		assertEquals(size, run1.totalDoors());
		size=size*500;
		Run run2 = new Run(size);
		assertEquals(size, run2.totalDoors());
	}

	@Test
	public void testInitialize()
	{
		try
		{
			Run run1 = new Run(100);
			Method init1 = run1.getClass().getDeclaredMethod("initialize", Integer.TYPE);
			init1.setAccessible(true);
			assertEquals(true, init1.invoke(run1, 100));
		}
		catch (Exception e)
		{
			assertNotEquals(NoSuchMethodException.class, e.getClass());
			assertNotEquals(IllegalAccessException.class, e.getClass());
			assertNotEquals(IllegalArgumentException.class, e.getClass());
			assertNotEquals(InvocationTargetException.class, e.getClass());
		}
	}
	
	@Test
	public void testPass()
	{
		Run run1 = new Run(10);
		int rate1 = 2;
		ArrayList<Door> doors1 = run1.pass(rate1);
		assertEquals(run1.totalDoors(), doors1.size());
		assertEquals(true, checkDoors(doors1, rate1));
		
		Run run2 = new Run(10);
		int rate2 = 3;
		ArrayList<Door> doors2 = run2.pass(rate2);
		assertEquals(run2.totalDoors(), doors2.size());
		assertEquals(true, checkDoors(doors2, rate2));
		
		Run run3 = new Run(100);
		int rate3 = 5;
		ArrayList<Door> doors3 = run3.pass(rate3);
		assertEquals(run3.totalDoors(), doors3.size());
		assertEquals(true, checkDoors(doors3, rate3));
		
		Run run4 = new Run(100);
		int rate4 = 1;
		ArrayList<Door> doors4 = run4.pass(rate4);
		assertEquals(run4.totalDoors(), doors4.size());
		assertEquals(true, checkDoors(doors4, rate4));
	}

	public boolean checkDoors(ArrayList<Door> doors, int increment)
	{
		for (int i = 0; i < doors.size(); i++)
		{
			if ((i + 1) % increment == 0)
			{
				if (!doors.get(i).isOpen())
				{
					return false;
				}
			}
			else
			{
				if (doors.get(i).isOpen())
				{
					return false;
				}
			}
		}
		return true;
	}
}
