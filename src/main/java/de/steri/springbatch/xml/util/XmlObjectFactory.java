package de.steri.springbatch.xml.util;

import java.util.ArrayList;
import java.util.List;

import de.steri.springbatch.xml.domain.AdresseType;
import de.steri.springbatch.xml.domain.DateiType;
import de.steri.springbatch.xml.domain.FooterType;
import de.steri.springbatch.xml.domain.GeschaeftsPartnerType;
import de.steri.springbatch.xml.domain.HeaderType;
import de.steri.springbatch.xml.domain.ObjectFactory;
import de.steri.springbatch.xml.domain.PersonType;

public class XmlObjectFactory {

	ObjectFactory factory = new ObjectFactory();

	public static void main(String[] args) {
		
		XmlObjectFactory com = new XmlObjectFactory();
		System.out.println(com.createDateiType(10,10,2));
	}

	public DateiType createDateiType (int anzahlPersonen, int anzahlPartner, int anzahlAdressen){
		DateiType datei = factory.createDateiType();
		datei.setErstellungsdatum("2014_05_01");
		datei.setHeader(createHeaderType());
		datei.setFooter(createFooter());	
		datei.getPerson().addAll(createPersonTypeListe(anzahlPersonen));
		datei.getGeschaeftspartner().addAll(createPartnerTypeListe(anzahlPartner));
		return datei;
	}
	
	public HeaderType createHeaderType (){
		HeaderType header = factory.createHeaderType();
		header.setEmpfängerID("1");
		header.setEmpfängerName("KKH");
		return header;		
	}
	
	public FooterType createFooter(){
		FooterType footer = factory.createFooterType();
		footer.setAnzahlDatensätze(11);
		footer.setErstellungsdatum("2014.04.24");
		return footer;		
	}

	public List<PersonType> createPersonTypeListe (int anzahlPersonen) {
		List<PersonType> personListe = new ArrayList<PersonType>();
		for (int i = 0; i < anzahlPersonen; i++) {
			personListe.add(createPersonType(i, 1));
		}
		return personListe;
		
	}
	public PersonType createPersonType(int id, int anzahlAdressen) {
		PersonType person = factory.createPersonType();
		person.setName("Max" + id);
		person.setVorname("Mustermann" + id);
		person.getAdressen().addAll(createAdresseTypeListe(id, anzahlAdressen));
		return person;
	}
	
	public List<GeschaeftsPartnerType> createPartnerTypeListe (int anzahlPartner) {
		List<GeschaeftsPartnerType> partnerListe = new ArrayList<GeschaeftsPartnerType>();
		for (int i = 0; i < anzahlPartner; i++) {
			partnerListe.add(createPartnerType(i, 1));
		}
		return partnerListe;
		
	}
	public GeschaeftsPartnerType createPartnerType(int id, int anzahlAdressen) {
		GeschaeftsPartnerType partner = factory.createGeschaeftsPartnerType();
		partner.setName("KKH-Partner");
		partner.getAdressen().addAll(createAdresseTypeListe(id, anzahlAdressen));
		return partner;
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
