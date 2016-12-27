package domain;

public class Raspuns {
	String raspuns;
	int id;
	int id_intrebare;
	public String getRaspuns() {
		return raspuns;
	}
	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_intrebare() {
		return id_intrebare;
	}
	public void setId_intrebare(int id_intrebare) {
		this.id_intrebare = id_intrebare;
	}
	@Override
	public String toString() {
		return "Raspuns [raspuns=" + raspuns + ", id=" + id + ", id_intrebare=" + id_intrebare + "]";
	}
	
}
