package exception;

public class PolicyNotFoundException extends Exception{
	public PolicyNotFoundException(int policyID) {
	super(" The given policy not found with ID: "+policyID);
}
}