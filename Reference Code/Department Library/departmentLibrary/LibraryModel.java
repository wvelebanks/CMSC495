package departmentLibrary;

//Model class
//stores the book information

public class LibraryModel {
	
	private int id;
	private String type;
	private String name;
	private String info;
	private String available;
	
	public LibraryModel() {}
	
	public LibraryModel(int id, String type, String name, String info, String available)
	{
		this.id = id;
		this.type = type;
		this.name = name;
		this.info = info;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}	

}
