package Project.QualiCheck;

import java.util.ArrayList;
import Project.QualiCheck.Product.Batch;

public class Report {
	public static void printReport(String batchId) {
		Batch batch = User.currentUser.searchBatch(batchId);
		if (batch == null) {
			System.out.println("Tidak terdapat batch dengan ID tersebut.");
			return;
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("|         Laporan Hasil Quality Control         |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Batch Id: " + batch.getBatchId() + "\t\t\t\t\t|");
		System.out.println("| Tanggal Produksi: " + batch.getProductionDate() + "\t\t\t|");
		System.out.println("| Tipe: " + batch.getType() + "\t\t\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Keadaan  \t\t\t\t\t|");
		System.out.println("| Bau\t\t\t\t| " + (batch.getSample().getSmell() ? "Normal" : "Tidak Normal") + "\t|");
		System.out.println("| Warna\t\t\t\t| " + (batch.getSample().getColor() ? "Normal" : "Tidak Normal") + "\t|");
		System.out.println("| Rasa\t\t\t\t| " + (batch.getSample().getTaste() ? "Normal" : "Tidak Normal") + "\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Protein\t\t\t| " + batch.getSample().getProtein() + "\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Lemak\t\t\t\t| " + batch.getSample().getFat() + "\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Total Padatan Bukan Lemak\t| " + batch.getSample().getSnf() + "\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Cemaran Logam\t\t\t\t\t|");
		System.out.println("| Kadmium(Cd)\t\t\t| " + batch.getSample().getCadmiumCont() + "\t\t|");
		System.out.println("| Timbal(Pb)\t\t\t| " + batch.getSample().getLeadCont() + "\t\t|");
		System.out.println("| Timah(Sn)\t\t\t| " + batch.getSample().getTinCont() + "\t\t|");
		System.out.println("| Merkuri(Hg)\t\t\t| " + batch.getSample().getMercuryCont() + "\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Cemaran arsen(Ar)\t\t| " + batch.getSample().getArsenicCont() + "\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Aflatoksin(M1)\t\t| " + batch.getSample().getAflatoxinCont() + "\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Cemaran Mikroba\t\t\t\t|");
		System.out.println("| Angka Lempeng Total\t\t| " + batch.getSample().getTpcCont() + "\t\t|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Hasil: " + QCResult(batch.checkSample(batch.getSample())) + "\t\t|"); 
		System.out.println("-------------------------------------------------");
	}
	
	public static String QCResult(ArrayList<Boolean> results) {
		for (Boolean result : results) {
			if (result == false) {
				return "Sampel tidak lulus uji.";
			}
		}
		return "Sampel lulus uji.";
	}
}
