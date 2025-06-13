package Project.QualiCheck.Product;

public class FatFree extends MilkSample{

	public FatFree(Boolean smell, Boolean color, Boolean taste, double protein, double fat, double snf,
			double cadmiumCont, double leadCont, double tinCont, double mercuryCont, double arsenicCont,
			double aflatoxinCont, double tpcCont) {
		super(smell, color, taste, protein, fat, snf, cadmiumCont, leadCont, 
				tinCont, mercuryCont, arsenicCont, aflatoxinCont, tpcCont);
	}

}
