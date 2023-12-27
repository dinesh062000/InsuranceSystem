
package dao;
import exception.PolicyNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;


import entity.Policy;
import util.DBConnUtil;

public class InsuranceServiceImpl implements IPolicyService {

    @Override
    public boolean createPolicy(Policy policy) {
    	
        Connection conn = DBConnUtil.getConnection();

		boolean status=false;
		try {
			String sql = "insert into policy (policyid, policyname, policytype, coverageamount) values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, policy.getPolicyId()); 
            preparedStatement.setString(2, policy.getPolicyName()); 
            preparedStatement.setString(3, policy.getPolicyType()); 
            preparedStatement.setDouble(4, policy.getCoverageAmount()); 

          
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
		}
            catch(Exception e) {
				System.out.println("Query exception :" +e);
			}
		
			return status;
    }
	
    @Override
    public Policy getPolicy(int policyId) {
    	Connection conn = DBConnUtil.getConnection();

		Policy result=null;
		try {
			
			String query = "Select * from policy where policyId=?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, policyId);
			
			
			ResultSet res = pstmt.executeQuery();
			if(res.next())
			result=new Policy(res.getInt("policyId"),res.getString("policyName"),res.getString("policyType"),res.getDouble("coverageAmount"));
			if(result==null)
				throw new PolicyNotFoundException(policyId);
			
			return result;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
    }

    @Override
    public Collection<Policy> getAllPolicies() {
    	
    	Collection<Policy> policies = new ArrayList<>();
		
		try {
			String sql="select * from policy";
			Connection conn = DBConnUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
            Policy policy = new Policy();
            policy.setPolicyId(resultSet.getInt("policyid"));
            policy.setPolicyName(resultSet.getString("policyname"));
            policy.setCoverageAmount(resultSet.getDouble("coverageamount"));
            // Set other attributes as needed

            policies.add(policy);
        }
		return policies;
		}
            catch(Exception e) {
				System.out.println("Query exception :" +e);
			}
    	
		return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
		Connection conn = DBConnUtil.getConnection();

		boolean status=true;
		try {
			
			String query = "UPDATE Policy SET policyName=?,policyType=?,coverageAmount=? WHERE policyId = ? ";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, policy.getPolicyName());
			pstmt.setString(2, policy.getPolicyType());
			pstmt.setDouble(3, policy.getCoverageAmount());
			pstmt.setInt(4, policy.getPolicyId());
			
			int a = pstmt.executeUpdate();
			
			if(a==0)
            {
                throw new PolicyNotFoundException(0);
            }
			return status;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		return status;

    }

    @Override
    public boolean deletePolicy(int policyId) {
    	Connection conn = DBConnUtil.getConnection();

		boolean status=true;
		try {
			
			String query = "DELETE FROM Policy WHERE policyId = ?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, policyId);
			
			int a = pstmt.executeUpdate();
			if(a==0)
            {
                throw new PolicyNotFoundException(policyId);
            }
			return status;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		return status;

    }

    
}
