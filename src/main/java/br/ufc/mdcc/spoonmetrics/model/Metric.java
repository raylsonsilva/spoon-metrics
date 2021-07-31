package br.ufc.mdcc.spoonmetrics.model;

public enum Metric {

	// Chidamber and Kemerer (C&K) Metrics
	WMC("CK_WMC", "Weighted Methods per Class", ""), 
	DIT("CK_DIT", "Depth of Inheritance Tree", ""),
	NOC("CK_NOC", "Number of Children", ""), 
	CBO("CK_CBO", "Coupling Between Objects", ""),
	RFC("CK_RFC", "Response For Class", ""), 
	LCOM("CK_LCOM", "Lack of Cohesion of Methods v1", ""),

	// Other OO Metrics
	LoC("OO_LoC", "Lines of Code", ""), 
	LCOM2("OO_LCOM2", "Lack of Cohesion of Methods v2", ""),
	LCOM3("OO_LCOM3", "Lack of Cohesion of Methods v3", ""), 
	Ca("OO_Ca", "Fan in = Afferent Coupling", ""),
	Ce("OO_Ce", "Fan out = Efferent Coupling", ""),
	
	//My Metrics
	NODA("MM_NODA", "Number of Declared Attributes", ""),
	NOPA("MM_NOPA", "Number of Public Attributes", ""),
	NOPRA("MM_NOPRA", "Number of Private Attributes", ""),
	NODM("MM_NODM", "Number of Declared Methods", ""),
	NOPM("MM_NOPM", "Number of Public Methods", ""),
	NOPRM("MM_NOPRM", "Number of Private Attributes", ""),
	NOECB("MM_NOECB", "Number of Empty Catch Blocks", ""),
	NOSE("MM_NOSE", "Number of Signaled Exceptions", ""),
	NORE("MM_NORE", "Number of Raised Exceptions", "");

	private final String shortName;

	private final String fullName;

	private final String description;

	Metric(String shortName, String fullName, String description) {
		this.shortName = shortName;
		this.fullName = fullName;
		this.description = description;
	}

	public String getShortName() {
		return shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getDescription() {
		return description;
	}
}
