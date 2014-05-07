package de.steri.springbatch.xml.nonjaxbreader.processing;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class PersonHandler extends XMLEventReaderDelegate {

	public PersonHandler(XMLEventReader delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public XMLEvent nextEvent() throws XMLStreamException {
		XMLEvent event = super.nextEvent();
		if (event.isStartElement()) {
			System.out.println(event.asStartElement().getName());
		}
		return event;
	}
}