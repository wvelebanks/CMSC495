package departmentLibrary;

//user class
//stores information pertaining to who borrowed the book

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	
	private int cin;
	private int id;
	private String name;
	private String dateBorrow;
	private String dateReturn;
	private String dueBack;
	private boolean overdue;
	
	public User() {}
	
	public User(int cin, int id, String name, String dateBorrow, String dateReturn, String dueBack)
	{
		this.cin = cin;
		this.id = id;
		this.name = name;
		this.dateBorrow = dateBorrow;
		this.dateReturn = dateReturn;
		this.dueBack = dueBack;
		this.overdue = false;
	}

	public int getCin() {
		return cin;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateBorrow() {
		return dateBorrow;
	}

	public void setDateBorrow(String dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	public String getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}

	public String getDueBack() {
		return dueBack;
	}

	public void setDueBack(String dueBack) {
		this.dueBack = dueBack;
	}

	public boolean isOverdue() {		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();		
		
		String curDate = dateFormat.format(date);
		
		if(dueBack.isEmpty())
		{
			overdue = false;
		}		
		else if(curDate.compareTo(dueBack) <= 0)
		{
			overdue = false;
		}
		else
		{
			overdue = true;
		}
		
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	

}
