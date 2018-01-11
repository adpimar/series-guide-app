package tests;

import java.io.File;

import impl.ConsoleInterface;
import impl.managers.remote.thetvdb.TheTVDBAdapter;
import resources.FakeBDL;

public class ConsoleInterfaceTest {

	public static void main(String[] args) {
		
		String filename = "src" 
				+ File.separator + "test" 
				+ File.separator + "resources" 
				+ File.separator + "interface" 
				+ File.separator + "bdl.txt";	
				
		new ConsoleInterface(new FakeBDL(filename), new TheTVDBAdapter());
		System.exit(0);
	}
	
}
