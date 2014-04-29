package de.steri.springbatch.xml.complexwriter.processing;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import de.steri.springbatch.xml.domain.DateiType;
import de.steri.springbatch.xml.domain.PersonType;
import de.steri.springbatch.xml.util.XmlObjectFactory;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader2")
public class Reader2 implements ItemReader<PersonType> {
	
	XmlObjectFactory factory = new XmlObjectFactory();
	private PersonType[] input = (PersonType[]) factory.createPersonTypeListe(100).toArray(new PersonType[0]);
	
	private int index = 0;
	
	/**
	 * Reads next record from input
	 */
	public PersonType read() throws Exception {
		System.out.println("READER 1 AUFFERUFEN");
		if (index < input.length) {
			return input[index++];
		}
		else {
			return null;
		}
	}
}
