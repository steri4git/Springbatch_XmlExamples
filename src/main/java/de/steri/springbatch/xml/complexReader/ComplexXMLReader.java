package de.steri.springbatch.xml.complexReader;

import java.util.ArrayList;
import java.util.List;

import de.steri.springbatch.xml.domain.AdresseType;
import de.steri.springbatch.xml.domain.DateiType;
import de.steri.springbatch.xml.domain.FooterType;
import de.steri.springbatch.xml.domain.HeaderType;
import de.steri.springbatch.xml.domain.ObjectFactory;
import de.steri.springbatch.xml.domain.PartnerType;
import de.steri.springbatch.xml.domain.PersonType;

public class ComplexXMLReader {

	ObjectFactory factory = new ObjectFactory();

	public static void main(String[] args) {

		PersonType person = factory.createPersonType();
		person.setName("Max");
		person.setVorname("Mustermann");
		person.getAdressen().add(factory.createAdresseType());

		PartnerType partner = factory.createPartnerType();
		partner.setName("Partner");
		partner.getAdressen().add(factory.createAdresseType());
	}

	public DateiType createDateiType (int anzahlPersonen, int anzahlPartner, int anzahlAdressen){
		//ObjectFactory factory = new ObjectFactory();		
		DateiType datei = factory.createDateiType();
		HeaderType header = factory.createHeaderType();
		header.setEmpfängerID("1");
		header.setEmpfängerName("KKH");
		
		FooterType footer = factory.createFooterType();
		footer.setAnzahlDatensätze(11);
		footer.setErstellungsdatum("2014.04.24");
		
		for (int i = 0; i < anzahlPersonen; i++) {
			datei.getPersonen().add(createPersonType(i,1));
		
		}
		
		return datei;
		
	}

	public PersonType createPersonType(int id, int anzahlAdressen) {
		PersonType person = factory.createPersonType();
		person.setName("Max" + id);
		person.setVorname("Mustermann" + id);
		person.getAdressen().addAll(createAdresseTypeListe(id, anzahlAdressen));
		return person;

	}

	public List<AdresseType> createAdresseTypeListe(int id, int anzahlAdressen) {
		List<AdresseType> adresseListe = new ArrayList<AdresseType>();
		for (int i = 0; i < anzahlAdressen; i++) {
			adresseListe.add(createAdresseType(id));
		}
		return adresseListe;
	}

	public AdresseType createAdresseType(int id){
		AdresseType adresse = factory.createAdresseType();
		adresse.setHausnummer(Integer.toString(id));
		adresse.setPlz("30159");
		adresse.setStadt("Musterstadt" + id);
		adresse.setStrasse("Musterstraße" + id);
		return adresse;
	}
}
