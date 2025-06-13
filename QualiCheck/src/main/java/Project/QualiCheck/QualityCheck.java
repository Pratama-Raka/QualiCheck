package Project.QualiCheck;

import Project.QualiCheck.Product.*;
import Project.QualiCheck.Standard.BooleanQualityStandard;
import Project.QualiCheck.Standard.DoubleQualityStandard;

public class QualityCheck {
	public static Boolean checkSmell(MilkSample sample) {
		if (sample.getSmell() == BooleanQualityStandard.get("SMELL").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkColor(MilkSample sample) {
		if (sample.getColor() == BooleanQualityStandard.get("COLOR").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkTaste(MilkSample sample) {
		if (sample.getTaste() == BooleanQualityStandard.get("TASTE").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkProtein(MilkSample sample) {
		if (sample.getProtein() >= DoubleQualityStandard.get("PROTEIN").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkFat(MilkSample sample) {
		if (sample instanceof FatFree) {
			if (sample.getFat() <= DoubleQualityStandard.get("MAX_FAT_FATFREE").getStandardValue()) {
				return true;
			} 
		} else if (sample instanceof LowFat) {
			if (sample.getFat() >= DoubleQualityStandard.get("MAX_FAT_FATFREE").getStandardValue() && 
					sample.getFat() <= DoubleQualityStandard.get("MIN_FAT").getStandardValue()) {
				return true;
			}
		} else if (sample instanceof LowFat) {
			if (sample.getFat() <= DoubleQualityStandard.get("MIN_FAT").getStandardValue()) {
				return true;
			}
		}
		return false;
	}
	
	public static Boolean checkSNF(MilkSample sample) {
		if (sample.getSnf() >= DoubleQualityStandard.get("SNF").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkCadmiumCont(MilkSample sample) {
		if (sample.getCadmiumCont() <= DoubleQualityStandard.get("CADMIUM_CONT").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkLeadCont(MilkSample sample) {
		if (sample.getLeadCont() <= DoubleQualityStandard.get("LEAD_CONT").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkTinCont(MilkSample sample) {
		if (sample.getTinCont() <= DoubleQualityStandard.get("TIN_CONT").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkMercuryCont(MilkSample sample) {
		if (sample.getMercuryCont() <= DoubleQualityStandard.get("MERCURY_CONT").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkArsenicCont(MilkSample sample) {
		if (sample.getArsenicCont() <= DoubleQualityStandard.get("ARSENIC_CONT").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkAflatoxinCont(MilkSample sample) {
		if (sample.getAflatoxinCont() <= DoubleQualityStandard.get("AFLATOXIN_CONT").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
	public static Boolean checkTPCCont(MilkSample sample) {
		if (sample.getTpcCont() <= DoubleQualityStandard.get("TPC_CONT").getStandardValue()) {
			return true;
		} else {
			return false;
		}
	}
}
