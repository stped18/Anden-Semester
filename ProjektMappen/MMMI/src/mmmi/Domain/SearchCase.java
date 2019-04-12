package mmmi.Domain;

import java.util.Date;

public class SearchCase {

	private Citizen citizen;
	private int caseNumber;
	private String caseStatus;
	private Date date;
	private String reason;
	private String EmployeeName;
	private int EmployeeID;

	public SearchCase() {
		// TODO - implement SearchCase.SearchCase
		throw new UnsupportedOperationException();
	}

	public Citizen getCitizen() {
		return this.citizen;
	}

	public int getCaseNumber() {
		return this.caseNumber;
	}

	public String getCaseStatus() {
		return this.caseStatus;
	}

	public Date getDate() {
		return this.date;
	}

	public String getReason() {
		return this.reason;
	}

	public String getEmployeeName() {
		// TODO - implement SearchCase.getEmployeeName
		throw new UnsupportedOperationException();
	}

	public int getEmployeeID() {
		// TODO - implement SearchCase.getEmployeeID
		throw new UnsupportedOperationException();
	}

}