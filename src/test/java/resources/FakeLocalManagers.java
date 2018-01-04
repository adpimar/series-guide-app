package resources;

import java.io.File;

import abs.ILocalManager;

public enum FakeLocalManagers {

	R01_1_1_1("R01.1.1.1.txt"),
	R01_1_2_1("R01.1.2.1.txt"),
	R01_1_3_1("R01.1.3.1.txt"),
	
	R02_1_1_1("R02.1.1.1.txt"),
	R02_1_1_2("R02.1.1.2.txt"),
	R02_1_2_1("R02.1.2.1.txt"),
	R02_1_2_2("R02.1.2.2.txt"),
	R02_1_2_3("R02.1.2.3.txt"),
	
	R03_1_1_1("R03.1.1.1.txt"),
	R03_1_1_2("R03.1.1.2.txt"),
	R03_1_1_3("R03.1.1.3.txt"),
	R03_1_2_1("R03.1.2.1.txt"),
	
	R04_1_1_1("R04.1.1.1.txt"),
	R04_1_1_2("R04.1.1.2.txt"),
	R04_1_1_3("R04.1.1.3.txt"),
	R04_1_2_1("R04.1.2.1.txt"),
	R04_1_3_1("R04.1.3.1.txt"),
	
	R05_1_1_1("R05.1.1.1.txt"),
	R05_1_1_2("R05.1.1.2.txt"),
	R05_1_1_3("R05.1.1.3.txt"),
	R05_1_2_1("R05.1.2.1.txt"),
	R05_1_3_1("R05.1.3.1.txt"),
	R05_1_4_1("R05.1.4.1.txt"),
	
	R06_1_1_1("R06.1.1.1.txt"),
	R06_1_1_2("R06.1.1.2.txt"),
	R06_1_1_3("R06.1.1.3.txt"),
	R06_1_2_1("R06.1.2.1.txt"),
	R06_1_2_2("R06.1.2.2.txt"),
	R06_1_2_3("R06.1.2.3.txt"),
	
	R07_1_1_1("R07.1.1.1.txt"),
	R07_1_1_2("R07.1.1.2.txt"),
	R07_1_2_1("R07.1.2.1.txt"),
	R07_1_2_2("R07.1.2.2.txt"),
	R07_1_3_1("R07.1.3.1.txt"),
	R07_1_3_2("R07.1.3.2.txt"),
	R07_1_3_3("R07.1.3.3.txt"),
	R07_2_1_1("R07.2.1.1.txt"),
	R07_2_2_1("R07.2.2.1.txt"),
	R07_2_2_2("R07.2.2.2.txt"),
	R07_2_2_3("R07.2.2.3.txt"),
	R07_2_3_1("R07.2.3.1.txt"),
	R07_2_4_1("R07.2.4.1.txt"),
	R07_2_4_2("R07.2.4.2.txt"),
	R07_2_4_3("R07.2.4.3.txt"),
	
	R08_1_1_1("R08.1.1.1.txt"),
	R08_1_2_1("R08.1.2.1.txt"),
	R08_1_2_2("R08.1.2.2.txt"),
	R08_1_2_3("R08.1.2.3.txt"),
	R08_1_3_1("R08.1.3.1.txt"),
	R08_1_3_2("R08.1.3.2.txt"),
	R08_1_3_3("R08.1.3.3.txt"),

	R09_1_1_1("R09.1.1.1.txt"),
	R09_1_1_2("R09.1.1.2.txt"),
	R09_1_1_3("R09.1.1.3.txt"),
	R09_1_1_4("R09.1.1.4.txt"),
	R09_1_2_1("R09.1.2.1.txt"),
	R09_1_3_1("R09.1.3.1.txt"),
	R09_1_3_2("R09.1.3.2.txt"),
	
	R10_1_1_1("R10.1.1.1.txt"),
	R10_1_1_2("R10.1.1.2.txt"),
	R10_1_1_3("R10.1.1.3.txt"),
	R10_1_1_4("R10.1.1.4.txt"),
	R10_1_2_1("R10.1.2.1.txt"),
	
	R11_1_1_1("R11.1.1.1.txt"),
	R11_1_1_2("R11.1.1.2.txt"),
	R11_1_1_3("R11.1.1.3.txt"),
	R11_1_2_1("R11.1.2.1.txt"),
	R11_1_2_2("R11.1.2.2.txt"),
	R11_1_3_1("R11.1.3.1.txt"),
	
	R13_2_1_1("R13.2.1.1.txt"),
	R13_2_2_1("R13.2.2.1.txt"),
	
	R15_1_1_1("R15.1.1.1.txt"),
	R15_1_1_2("R15.1.1.2.txt"),
	R15_1_1_3("R15.1.1.3.txt"),
	R15_1_1_4("R15.1.1.4.txt"),
	R15_1_2_1("R15.1.2.1.txt"),
	R15_1_2_2("R15.1.2.2.txt"),
	R15_2_1_1("R15.2.1.1.txt"),
	R15_2_1_2("R15.2.1.2.txt"),
	R15_2_1_3("R15.2.1.3.txt"),
	R15_2_1_4("R15.2.1.4.txt"),
	R15_2_2_1("R15.2.2.1.txt"),
	R15_2_2_2("R15.2.2.2.txt");
	
	private static final String PATH;
	private static final boolean fakeDependencies = true;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "statesLocalManager" + File.separator;
	}
	
	private final String filename;
	
	private FakeLocalManagers(final String filename) {
        this.filename = filename;
    }
	
	public ILocalManager getLocalManager() {
		if (fakeDependencies)
			return new AuxiliarBDL(PATH + filename);
		return null;
	}

}
