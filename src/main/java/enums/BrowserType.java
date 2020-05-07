package enums;

public enum BrowserType {

	CHROME(new String[] { "chrome", "google chrome", "googlechrome" }), 
	FIREFOX(new String[] { "firefox", "fire fox" }),
	INTERNETEXPLORE(new String[] { "internetexplore", "internet explorer", "ie" }),
	EDGE(new String[] { "edge", "microsoft edge", "microsoftedge" });

	private String[] aliases;

	private BrowserType(String[] aliases) {
		this.aliases = aliases;
	}

	public static BrowserType driversTypeForName(String driversType) throws IllegalArgumentException {
		for (BrowserType ct : values()) {
			for (String alias : ct.aliases) {
				if (alias.equalsIgnoreCase(driversType)) {
					return ct;
				}
			}
		}
		throw driversTypeNotFound(driversType);
	}

	private static IllegalArgumentException driversTypeNotFound(String ct) {
		return new IllegalArgumentException(("O driver selecionado invalido! -> [" + ct + "]"));
	}
}
