package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Avion {
	
	private IntegerProperty code;
	private StringProperty nom;
	private IntegerProperty capacite;
	private StringProperty localisation;
	
	public Avion(int code, String nom, int capacite, String localisation) {
		this.code = new SimpleIntegerProperty(code);
		this.nom = new SimpleStringProperty(nom);
		this.capacite = new SimpleIntegerProperty(capacite);
		this.localisation = new SimpleStringProperty(localisation);
	}

	public IntegerProperty getCode() {
		return code;
	}

	public void setCode(IntegerProperty code) {
		this.code = code;
	}

	public StringProperty getNom() {
		return nom;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public IntegerProperty getCapacite() {
		return capacite;
	}

	public void setCapacite(IntegerProperty capacite) {
		this.capacite = capacite;
	}

	public StringProperty getLocalisation() {
		return localisation;
	}

	public void setLocalisation(StringProperty localisation) {
		this.localisation = localisation;
	}
	
}
