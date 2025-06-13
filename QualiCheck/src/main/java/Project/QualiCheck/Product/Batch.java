package Project.QualiCheck.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import Project.QualiCheck.QualityCheck;

public class Batch {
	private String batchId;
	private LocalDate productionDate;
	private String type;
	private MilkSample sample;
	
	public Batch(String batchId, LocalDate productionDate, String type, MilkSample sample) {
		this.batchId = batchId;
		this.productionDate = productionDate;
		this.type = type;
		this.sample = sample;
	}
	
	public String getBatchId() {
		return batchId;
	}

	public LocalDate getProductionDate() {
		return productionDate;
	}

	public String getType() {
		return type;
	}
	
	public MilkSample getSample() {
		return sample;
	}

	public void inputData(Boolean smell, Boolean color, Boolean taste, double protein, double fat, double snf,
			double cadmiumCont, double leadCont, double tinCont, double mercuryCont, double arsenicCont,
			double aflatoxinCont, double tpcCont){
		this.sample = new MilkSample(smell, color, taste, protein, fat, snf, cadmiumCont, leadCont, tinCont, 
				mercuryCont, arsenicCont, aflatoxinCont, tpcCont);
	}
	
	public ArrayList<Boolean> checkSample(MilkSample sample){
		ArrayList<Boolean> checkResult = new ArrayList<Boolean>();
		checkResult.add(QualityCheck.checkSmell(sample));
		checkResult.add(QualityCheck.checkColor(sample));
		checkResult.add(QualityCheck.checkTaste(sample));
		checkResult.add(QualityCheck.checkProtein(sample));
		checkResult.add(QualityCheck.checkFat(sample));
		checkResult.add(QualityCheck.checkSNF(sample));
		checkResult.add(QualityCheck.checkCadmiumCont(sample));
		checkResult.add(QualityCheck.checkLeadCont(sample));
		checkResult.add(QualityCheck.checkTinCont(sample));
		checkResult.add(QualityCheck.checkMercuryCont(sample));
		checkResult.add(QualityCheck.checkArsenicCont(sample));
		checkResult.add(QualityCheck.checkAflatoxinCont(sample));
		checkResult.add(QualityCheck.checkTPCCont(sample));
		return checkResult;
	}
}
