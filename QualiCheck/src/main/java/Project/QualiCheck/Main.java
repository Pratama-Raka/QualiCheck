package Project.QualiCheck;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Project.QualiCheck.Product.Batch;
import Project.QualiCheck.Standard.BooleanQualityStandard;
import Project.QualiCheck.Standard.DoubleQualityStandard;

public class Main {
    public static void main( String[] args ){
    	Scanner in = new Scanner(System.in);
    	ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123", "Ani"));
        BooleanQualityStandard.initializeStandard();
        DoubleQualityStandard.initializeStandard();
        
        while(true) {
        	System.out.println("Selamat datang di QualiCheck!");
        	System.out.println("======================LOGIN======================");
        	System.out.print("ID: ");
        	String id = in.nextLine();
        	System.out.print("Name: ");
        	String name = in.nextLine();
        	
        	if(!User.searchUser(users, id, name)) {
        		User.signIn(users);
        		continue;
        	}
        	break;
        }
        
        int pilihan = -1;
        while (pilihan != 0) {
        	try {
        		Option.displayOption();
        		System.out.print("Pilihan: ");
        		pilihan = in.nextInt();
        		switch (pilihan) {
            	case 1:
            		User.currentUser.usersActivity();
            		break;
            	case 2:
            		User.currentUser.newBatch();
            		break;
            	case 3:
            		System.out.print(">>Masukkan ID Batch yang akan diprint: ");
            		String batchId = in.next();
            		Report.printReport(batchId);
            		break;
            	case 0:
            		System.out.println("Keluar dari program.");
            		break;
            	default:
            		System.out.println("Input salah, masukkan pilihan yang benar.");
            		break;
            	}
			} catch (InputMismatchException e) {
				System.out.println("Input tidak valid, hanya bisa input angka.");
				in.nextLine();
			}	
			
		}
        
    }
}
