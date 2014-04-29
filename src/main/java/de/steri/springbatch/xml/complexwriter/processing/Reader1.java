package de.steri.springbatch.xml.complexwriter.processing;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import de.steri.springbatch.xml.domain.DateiType;
import de.steri.springbatch.xml.util.XmlObjectFactory;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader1")
public class Reader1 implements ItemReader<DateiType> {
	
	XmlObjectFactory factory = new XmlObjectFactory();
	private DateiType[] input = {factory.createDateiType(20, 20, 2)};
	
	private int index = 0;
	
	/**
	 * Reads next record from input
	 */
	public DateiType read() throws Exception {
		System.out.println("READER 1 AUFFERUFEN");
		if (index < input.length) {
			return input[index++];
		}
		else {
			return null;
		}
	}
}
