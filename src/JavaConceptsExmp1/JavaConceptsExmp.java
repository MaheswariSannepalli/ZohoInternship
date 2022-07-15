package JavaConceptsExmp1;

import java.io.*;
import java.util.*;

public class JavaConceptsExmp {

	//interface creation
	interface updates {
		
		void increaseWorkingDays(int days);
		void payAmount(int amount);
	}
	
	//making classes as static
	//Inheriting an interface
	public static class Intern implements updates {
		private  int id;
		private String name;
		private int daysWorked;
		private int paidAmount;
		private int totalStipend;
		
		//Parameterized constructor for passing student details
		 Intern(int id,String name,int daysWorked,int paidAmount)
		{
			// This keyword for referring to the current instance 
			this.id = id;
			this.name = name;
			this.daysWorked = daysWorked;
			this.paidAmount = paidAmount;
			this.totalStipend =  500*daysWorked;
		}
		 
		 //overriding toString() method
		 public String toString()
		 {
			  return "Intern ID  "+id+"  Name  "+name+"  daysWorked  "+daysWorked+" paidAmount  "+paidAmount  +"  totalStipend  "+totalStipend;  
		 }  
		 
		 //Implementing inherited abstract methods
		public void increaseWorkingDays(int days)
		 {
			 this.daysWorked = this.daysWorked + days ;
			 this.totalStipend = this.totalStipend + 500*days ;
		 }
		public	void payAmount(int amount)
		{
				if ( this.totalStipend >= (this.paidAmount + amount) )
				{
						this.paidAmount = this.paidAmount + amount ;
						
						String data = "You are changing paid amount of "+this.name+" to "+this.paidAmount;
					    WritingToFile(data);
				}
				else
				{
						System.out.println("You are paying an  extra amount");
				}
		}	
		
		//Writing changes to the file
		private static void WritingToFile(String data)
		{
			//Using Exceptions
			try {  
		        FileWriter fwrite = new FileWriter("C:\\Users\\mahi0\\Documents\\ChangedDetails.txt");  
		        // writing the content into the FileOperationExample.txt file  
		        fwrite.write(data);   
		   
		        // Closing the stream  
		        fwrite.close();   
		        System.out.println("Change you made is loaded to the log file");  
		    } catch (IOException e) {  
		        System.out.println("Unexpected error occurred");  
		        e.printStackTrace();  
		        }  
		}
	}
	
	// Department class contains list of student objects. It is associated with student class through its Objects
	public static class Department {
	   
	    String name;
	    private List<Intern> Interns;
	    Department(String name, List<Intern> Interns)
	    {
	        this.name = name;
	        this.Interns = Interns;
	    }
	 
	    // Method of Department class
	    public void getInterns()
	    {
	        // Displaying list of user defined type through iteration of classes
	    	 for (Intern s : Interns) {
	               System.out.println(s);
	            }
	    }
	}
	
	//  Institute class contains list of Department Objects. It is associated with Department class through its Objects
	public static class Institute {
	 
	    String companyName;
	    private List<Department> departments;
	 
	    Institute(String companyName,List<Department> departments)
	    {
	        this.companyName = companyName;
	        this.departments = departments;
	    }
	}
	
	//Writing changes to the file
	public static void ReadingTheFile()
	{
		try {  
	         // Creating f1 object of the file to read data  
             File f1 = new File("C:\\Users\\mahi0\\Documents\\ChangedDetails.txt");    
             Scanner dataReader = new Scanner(f1);  
             while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();  
                System.out.println(fileData);  
             }  
             dataReader.close();  
	        } catch (IOException e) {  
	               System.out.println("Unexpected error occurred");  
	               e.printStackTrace();  
	              }  
	}
	
	public static void main(String[] args)
	{
	
		 // Creating object of Intern class
		Intern Int1 = new Intern(2105,"Maheswari", 10, 0);
		Intern Int2 = new Intern(2106,"Siddu", 15, 0);
		Intern Int3 = new Intern(2107,"Chandu", 5, 0);
		Intern Int4 = new Intern(2108,"Sree",6, 0);
		
        // Creating a List of Interns belongs to appx department and crm department
        List<Intern> appx_interns = new ArrayList<Intern>();
        List<Intern> crm_interns = new ArrayList<Intern>();
 
        // Adding Interns into teams
        appx_interns.add(Int1);
        appx_interns.add(Int2);
        crm_interns.add(Int3);
        crm_interns.add(Int4);
 
        // Creating objects for appx and crm departments and adding them
        Department appx = new Department("APPX", appx_interns);
        Department crm = new Department("CRM", crm_interns);
 
        List<Department> departments = new ArrayList<Department>();
        departments.add(appx);
        departments.add(crm);
 
        //Creating an instance of Institute
        Institute institute = new Institute("Zoho", departments);
 
        //System.out.println(Int1);
        appx.getInterns();
        Int1.increaseWorkingDays(2);
        System.out.println(Int1);
        Int1.payAmount(5000);
        System.out.println(Int1);
        ReadingTheFile();
	}
	
}
