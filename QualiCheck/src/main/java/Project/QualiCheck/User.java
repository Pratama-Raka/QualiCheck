package Project.QualiCheck;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Project.QualiCheck.Product.*;

public class User {
	private String id;
	private String name;
	private ArrayList<Batch> batches = new ArrayList<Batch>(); 
	
	public static User currentUser;
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void usersActivity() {
		System.out.println("Nama User: " + this.getName());
		System.out.println("ID: " + this.getId());
		if (batches == null || batches.isEmpty()) {
			System.out.println("User belum memiliki aktivitas.");
		} else {
			for (int i = 0; i < batches.size(); i++) {
				System.out.println("Nomor Batch: " + batches.get(i).getBatchId());
				System.out.println("Tanggal Produksi: " + batches.get(i).getProductionDate());
				System.out.println("Tipe: " + batches.get(i).getType());
			}
		}
	}
	
	public void newBatch() {
		Scanner in = new Scanner(System.in);
		System.out.print(">>Batch Id: ");
		String batchId = in.next();
		
		LocalDate tanggalProduksi = null; 
        boolean dateInputValid = false;
        
        while (!dateInputValid) {
            System.out.print(">>Tanggal Produksi (Format: YYYY-MM-DD): ");
            String dateString = in.next();
            try {
                tanggalProduksi = LocalDate.parse(dateString); 
                dateInputValid = true; 
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal tidak valid. Mohon gunakan format YYYY-MM-DD.");
            }
        }
        
        in.nextLine();
		System.out.print("Tipe Susu: ");
		String type = in.nextLine();
		
		System.out.println("=================================================");
		System.out.println(">>>>>>>>>>>>>>>>Input Data Sampel<<<<<<<<<<<<<<<<");
		System.out.println("=================================================");
		System.out.print("Kondisi Bau: ");
		Boolean smell = in.nextBoolean();
		System.out.print("Kondisi Warna: ");
		Boolean color = in.nextBoolean();
		System.out.print("Kondisi Rasa: ");
		Boolean taste = in.nextBoolean();
		System.out.print("Kadar Protein: ");
		Double protein = in.nextDouble();
		System.out.print("Kadar Lemak: ");
		Double fat = in.nextDouble();
		System.out.print("Total Padatan Tanpa Lemak: ");
		Double snf = in.nextDouble();
		System.out.print("Cemaran Kadmium: ");
		Double cadmium = in.nextDouble();
		System.out.print("Cemaran Timbal: ");
		Double lead = in.nextDouble();
		System.out.print("Cemaran Timah: ");
		Double tin = in.nextDouble();
		System.out.print("Cemaran Merkuri: ");
		Double merc = in.nextDouble();
		System.out.print("Cemaran Arsen: ");
		Double arsenic = in.nextDouble();
		System.out.print("Cemaran Aflatoksin: ");
		Double aflatoxin = in.nextDouble();
		System.out.print("Cemaran Mikroba: ");
		Double tpc = in.nextDouble();
		
		MilkSample sample = null;
		if (type.equalsIgnoreCase("fat free")) {
			sample = new FatFree(smell, color, taste, protein, fat, snf, cadmium, lead, tin, merc, arsenic, aflatoxin, tpc);
		} else if (type.equalsIgnoreCase("low fat")) {
			sample = new LowFat(smell, color, taste, protein, fat, snf, cadmium, lead, tin, merc, arsenic, aflatoxin, tpc);
		} else if (type.equalsIgnoreCase("full cream")) {
			sample = new FullCream(smell, color, taste, protein, fat, snf, cadmium, lead, tin, merc, arsenic, aflatoxin, tpc);
		}
		
		batches.add(new Batch(batchId, tanggalProduksi, type, sample));
		System.out.println("Telah berhasil menambahkan data batch baru.");
	}
	
	public static Boolean searchUser(ArrayList<User> users, String id, String name) {
		for (User user : users) {
            if (user.getId().equals(id) && user.getName().equalsIgnoreCase(name) ) {
                System.out.println("Login berhasil! Selamat datang, " + user.getName() + "!");
                currentUser = user;
                return true;
            }
        }
		System.out.println("User tidak ditemukan, silakan Sign Up.");
        return false;
	}
	public static void signIn(ArrayList<User> users) {
		Scanner in = new Scanner(System.in);
		System.out.println("=====================SIGN UP=====================");
		System.out.print("Masukkan ID baru: ");
		String newId = in.nextLine();
		System.out.print("Masukkan Nama: ");
		String newName = in.nextLine();
		users.add(new User(newId, newName));
		System.out.println("Pendaftaran berhasil! Silakan login kembali.");
	}
	
	public Batch searchBatch(String batchId) {
		for (Batch batch : batches) {
			if (batch.getBatchId().equalsIgnoreCase(batchId)) {
				return batch;
			}
		}
		return null;
	}
}
