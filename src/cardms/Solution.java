package cardms;


import java.util.Scanner;

import customException.InvalidChoiceException;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		CarManagentSystemImp car=new CarManagentSystem ();
		while(true) {
			
			System.out.println("----WELCOME TO CAR DAT BASE---");
			System.out.println("1:Add Car\n2:Display Car\n3:Display All Cars");
			System.out.println("4:Remove car\n5:Remove All Carss\n6:Update Car");
			System.out.println("7:Count cars\n8:Sort Car \n9:Get Car With Lowest Price\n10:Get Car With Higest price");
			System.out.println("11:Exit\nEnter your Choice");
			
			int choice=scan.nextInt();
			
			switch(choice) {
				case 1:
					car.addCar();
					break;
					
				case 2:
					car.displayCar();
					break;
					
				case 3:
					car.displayAllCars();
					break;
					
				case 4:
					car.removeCar();
					break;
					
				case 5:
					car.removeAllCars();
					break;
					
				case 6:
					car.updateCar();
					break;
					
				case 7:
					car.countCars();
					break;
					
				case 8:
					car.sortCars();
					break;
					
				case 9:
					car.getCarsWithLowestPrice();
					break;
					
				case 10:
					car.getCarsWithHigesPrice();
					break;
					
				case 11:
					System.out.println("Thank You");
					System.exit(0);
					break;
				
					default:
						try {
							throw new InvalidChoiceException("Invalid choice");
						}
						catch(Exception e) {
						System.out.println(e.getMessage());
						
						}
			}
			System.out.println("----------------------------------------");

		}		
	}

}
