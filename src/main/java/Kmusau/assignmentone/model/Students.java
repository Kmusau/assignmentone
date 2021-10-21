package Kmusau.assignmentone.model;

public class Students {

	private String fname; 
	private String lname; 
	private String idnum; 
	private String course;
	
	
	public Students(String fname, String lname, String idnum, String course) {
		super();
		this.fname=fname;
		this.lname=lname;
		this.idnum=idnum;
		this.course=course;
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	} 
}
