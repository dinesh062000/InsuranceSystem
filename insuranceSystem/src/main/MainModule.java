package main;
import java.util.*;
import entity.*;
import dao.InsuranceServiceImpl;


public class MainModule {

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	String option;
    	InsuranceServiceImpl obj= new InsuranceServiceImpl();
    	try
    	{
    		
    		
			do{
                System.out.println("1. Create policy\n2. get "
                		+ "Policy\n3. get all policies\n4. update policy\n5. delete policy");
               
                System.out.println("enter your Option Please:\t");
                int opt=sc.nextInt();
                switch(opt)
                {
                    case 1->{
                            System.out.println("Enter PolicyId:\t");
                            int policyId=sc.nextInt();
                            System.out.println("Enter policy name:\t");
                            String policyName=sc.next();
                            System.out.println("Enter policy Type:\t");
                            String policyType=sc.next();
                            System.out.println("Enter policy coverageAmount:\t");
                            double amount=sc.nextDouble();
                            Policy policy=new Policy(policyId,policyName, policyType, amount);
                            
                            boolean bool= obj.createPolicy(policy);
                            if (bool==true)
                            {
                            	System.out.println("Policy created sucessfully");
                            }
                            else
                            {
                            	System.out.println("Policy creation failed !!!! please try again");
                            }
                            
                        }
                    case 2->{
                    	System.out.println("Enter PolicyId:\t");
                    	int policyID=sc.nextInt();
                    	Policy pol=obj.getPolicy(policyID);
                    	if(pol!=null)
                    	{
                    		System.out.println(pol);
                    	}
                    }
                    
                    case 3->
                    {
                    	
                           
                            Collection<Policy> policies = obj.getAllPolicies();

                            
                            System.out.println("All Policies:");
                            for (Policy policy : policies) {
                                System.out.println(policy);
                            }

                            
                    	
                    }
                    case 4->
                    {
                    	System.out.println("Enter policy id to be updated :\t");
                        int policyId=sc.nextInt();
                        System.out.println("Enter updated policy name:\t");
                        String policyName=sc.next();
                        System.out.println("Enter updated policy Type:\t");
                        String policyType=sc.next();
                        System.out.println("Enter updated policy coverageAmount:\t");
                        double amount=sc.nextDouble();
                        Policy policy=new Policy(policyId,policyName, policyType, amount);
                        
                        boolean bool= obj.updatePolicy(policy);
                        if (bool==true)
                        {
                        	System.out.println("Policy details has updated");
                        }
                        else
                        {
                        	System.out.println("Policy updation failed !!!! please try again");
                        }
                    }
                    case 5->
                    {
                	
                     	System.out.println("Enter PolicyId to be deleted:\t");
                     	int policyID=sc.nextInt();
                     	boolean pol=obj.deletePolicy(policyID);
                     	if(pol==true)
                     	{
                     		System.out.println("policy has been deleted with policyid:"+policyID);
                     	}
                     	
                     	
                         
                    }
                    
                    default->throw new IllegalStateException("Invalid Option: " + opt);
                }
                System.out.println("Do you wonna continue(yes/no)");
                 option=sc.next();
            }while(option.equals("yes"));

			
    		
    	}
        catch (Exception e)
        {
        	
        	e.printStackTrace();
        }
    	sc.close();
            
    }
}


