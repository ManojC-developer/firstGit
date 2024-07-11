package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class UserService {

	

	private String insuranceid;
	private String insurancename;
	private String coverage;
	
	public UserService( String insuranceid, String insurancename, String coverage) {
		

		this.insuranceid = insuranceid;
		this.insurancename = insurancename;
		this.coverage = coverage;
	}




	public String getInsuranceid() {
		return insuranceid;
	}



	public String getInsurancename() {
		return insurancename;
	}



	public String getCoverage() {
		return coverage;
	}

	@Override
	public String toString() {
		return "UserService [ insuranceid=" + insuranceid
				+ ", insurancename=" + insurancename + ", coverage=" + coverage + "]";
	}



		
		      

	}


