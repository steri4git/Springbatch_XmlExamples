package de.steri.springbatch.xml.complexwriter.processing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import de.steri.springbatch.xml.domain.DateiType;
import de.steri.springbatch.xml.domain.PersonType;
import de.steri.springbatch.xml.util.XmlObjectFactory;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader3")
public class Reader3 implements ItemReader<Object> {
	
	XmlObjectFactory factory = new XmlObjectFactory();
	List<Object> list = new ArrayList<Object>();
	private Object[] input = new Object[500];
	
	private int index = 0;
	
	/**
	 * Reads next record from input
	 */
	public Object read() throws Exception {
		
		System.out.println("READER 1 AUFFERUFEN");

		if (index < input.length) {
			return input[index++];
		}
		else {
			return null;
		}
	}
	Reader3(){
		list.addAll(factory.createPersonTypeListe(100));
		list.addAll(factory.createPartnerTypeListe(100));
		input = list.toArray(new Object[0]);
	}
}
