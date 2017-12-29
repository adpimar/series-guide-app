package resources;

import abs.ILocalManager;

public enum LocalManagerFactory {

	R01_1_1_1() {

		@Override
		public ILocalManager getLocalManager() {
			return new FakeBDL("R01.1.1.1.txt");
		}

	},

	R04_1_1_1() {

		@Override
		public ILocalManager getLocalManager() {
			return new FakeBDL("R04.1.1.1.txt");
		}

	};

	public abstract ILocalManager getLocalManager();

}
