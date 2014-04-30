package de.steri.springbatch.xml.complexwriter.processing;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 * 
 */

public class CustomStaxEventItemWriter extends StaxEventItemWriter<Object> {

	@Override
	protected void startDocument(XMLEventWriter writer)
			throws XMLStreamException {
		XMLEventFactory factory = createXmlEventFactory();

		// write start document
		writer.add(factory.createStartDocument(getEncoding(), getVersion()));
		writer.add(factory.createIgnorableSpace(""));
		writer.flush();

	}

	@Override
	protected void endDocument(XMLEventWriter writer) throws XMLStreamException {
		// TODO Auto-generated method stub
	}
}
