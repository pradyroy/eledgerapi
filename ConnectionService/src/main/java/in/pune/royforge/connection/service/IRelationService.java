package in.pune.royforge.connection.service;

import java.util.List;

import in.pune.royforge.connection.model.RelationCustomer;
import in.pune.royforge.connection.model.RelationReport;

public interface IRelationService {

	List<RelationCustomer> getUsers(String lenderId);
	
	List<RelationReport> getAllUsers(String lenderId);
}
