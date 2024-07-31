package com.uni.AppMain;

import java.util.Scanner;

import com.uni.impl.EmployeeImpl;


public class App 
{
    public static void main( String[] args )
    {
    print();
           }
    public static void print() {
    	
    	Scanner sc = new Scanner(System.in);
        EmployeeImpl empimpl = new EmployeeImpl();
        
        System.out.println();
        System.out.println("\t\t Employee Operations");
        System.out.println("\t\t *********************************");
        System.out.println("\t\t 1.Create");
        System.out.println("\t\t 2.Read");
        System.out.println("\t\t 3.Update");
        System.out.println("\t\t 4.Delete by Id");
        System.out.println("\t\t 5.Delete All");
        System.out.println("\t\t 6.Exit");
        System.out.println(); 
        System.out.println("\t\t ----------------------------------");
        System.out.println(); 
        System.out.print("\t\t Enter Choice :");
        int userChoice = sc.nextInt();
        sc.nextLine();
        
        if(userChoice > 0 ){
        	
        	do {
        		switch(userChoice){
        		
        		case 1:empimpl.createEmp();
        		break;
        		
        		case 2:empimpl.readEmp();
        		break;
        		
        		case 3:empimpl.updateEmp();
        		break;
        		
        		case 4:empimpl.deleteByIdEmp();
        		break;
        		
        		case 5:empimpl.deleteAllEmp();
        		break;
        		
        		case 6:System.out.println();
        		       System.out.println("\t\t********** Thank You..!! Visit Again**********");
        			   System.exit(0);
        		break;
        		
        		default:
        			throw new IllegalArgumentException("Unexpected value : " + userChoice);
        		
        		}
        		
        	}
        	while(userChoice != 6);
        	
        }else {
        	System.out.println("Your Choice must be greater than zero or positive number.");
        	
        }
        sc.close();
    	
    }
}
