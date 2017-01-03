package domain;

public class Specializare {
	int id_specializare;
	String nume_specializare;
	
	public int getId_specializare() {
		return id_specializare;
	}
	public void setId_specializare(int id_specializare) {
		this.id_specializare = id_specializare;
	}
	public String getNume_specializare() {
		return nume_specializare;
	}
	public void setNume_specializare(String nume_specializare) {
		this.nume_specializare = nume_specializare;
	}
	@Override
	public String toString() {
		return "Specializare [id_specializare=" + id_specializare + ", nume_specializare=" + nume_specializare + "]";
	}
	
}
