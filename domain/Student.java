package domain;

public class Student {
	int id;
	String username;
	String nume_student;
	String adresa_email;
	String numar_telefon;
	String Facultate;
	String specializare;
	String situatie_de_munca;
	String denumire_post;
	String tip_post;
	String nume_companie;
	String oras_unde_lucreaza;
	String situatie_scolara;
	String dorinta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNume_student() {
		return nume_student;
	}
	public void setNume_student(String nume_student) {
		this.nume_student = nume_student;
	}
	public String getAdresa_email() {
		return adresa_email;
	}
	public void setAdresa_email(String adresa_email) {
		this.adresa_email = adresa_email;
	}
	public String getNumar_telefon() {
		return numar_telefon;
	}
	public void setNumar_telefon(String numar_telefon) {
		this.numar_telefon = numar_telefon;
	}
	public String getFacultate() {
		return Facultate;
	}
	public void setFacultate(String facultate) {
		Facultate = facultate;
	}
	public String getSpecializare() {
		return specializare;
	}
	public void setSpecializare(String specializare) {
		this.specializare = specializare;
	}
	public String getSituatie_de_munca() {
		return situatie_de_munca;
	}
	public void setSituatie_de_munca(String situatie_de_munca) {
		this.situatie_de_munca = situatie_de_munca;
	}
	public String getDenumire_post() {
		return denumire_post;
	}
	public void setDenumire_post(String denumire_post) {
		this.denumire_post = denumire_post;
	}
	public String getTip_post() {
		return tip_post;
	}
	public void setTip_post(String tip_post) {
		this.tip_post = tip_post;
	}
	public String getNume_companie() {
		return nume_companie;
	}
	public void setNume_companie(String nume_companie) {
		this.nume_companie = nume_companie;
	}
	public String getOras_unde_lucreaza() {
		return oras_unde_lucreaza;
	}
	public void setOras_unde_lucreaza(String oras_unde_lucreaza) {
		this.oras_unde_lucreaza = oras_unde_lucreaza;
	}
	public String getSituatie_scolara() {
		return situatie_scolara;
	}
	public void setSituatie_scolara(String situatie_scolara) {
		this.situatie_scolara = situatie_scolara;
	}
	public String getDorinta() {
		return dorinta;
	}
	public void setDorinta(String dorinta) {
		this.dorinta = dorinta;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", nume_student=" + nume_student + ", adresa_email="
				+ adresa_email + ", numar_telefon=" + numar_telefon + ", Facultate=" + Facultate + ", specializare="
				+ specializare + ", situatie_de_munca=" + situatie_de_munca + ", denumire_post=" + denumire_post
				+ ", tip_post=" + tip_post + ", nume_companie=" + nume_companie + ", oras_unde_lucreaza="
				+ oras_unde_lucreaza + ", situatie_scolara=" + situatie_scolara + ", dorinta=" + dorinta + "]";
	}
	
	
}
