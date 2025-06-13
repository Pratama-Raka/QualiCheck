package Project.QualiCheck.Product;

public class MilkSample {
	private Boolean smell;
	private Boolean color; 
	private Boolean taste; 
	private double protein;
	private double fat;
	private double snf;
	private double cadmiumCont;
	private double leadCont;
	private double tinCont;
	private double mercuryCont;
	private double arsenicCont;
	private double aflatoxinCont;
	private double tpcCont;
	
	public MilkSample(Boolean smell, Boolean color, Boolean taste, double protein, double fat, double snf,
			double cadmiumCont, double leadCont, double tinCont, double mercuryCont, double arsenicCont,
			double aflatoxinCont, double tpcCont) {
		this.smell = smell;
		this.color = color;
		this.taste = taste;
		this.protein = protein;
		this.fat = fat;
		this.snf = snf;
		this.cadmiumCont = cadmiumCont;
		this.leadCont = leadCont;
		this.tinCont = tinCont;
		this.mercuryCont = mercuryCont;
		this.arsenicCont = arsenicCont;
		this.aflatoxinCont = aflatoxinCont;
		this.tpcCont = tpcCont;
	}

	public Boolean getSmell() {
		return smell;
	}

	public Boolean getColor() {
		return color;
	}

	public Boolean getTaste() {
		return taste;
	}

	public double getProtein() {
		return protein;
	}

	public double getFat() {
		return fat;
	}

	public double getSnf() {
		return snf;
	}

	public double getCadmiumCont() {
		return cadmiumCont;
	}

	public double getLeadCont() {
		return leadCont;
	}

	public double getTinCont() {
		return tinCont;
	}

	public double getMercuryCont() {
		return mercuryCont;
	}

	public double getArsenicCont() {
		return arsenicCont;
	}

	public double getAflatoxinCont() {
		return aflatoxinCont;
	}

	public double getTpcCont() {
		return tpcCont;
	}
	
}
