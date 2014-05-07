package de.steri.springbatch.xml.nonjaxbreader.processing;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;


public class XMLEventReaderDelegate implements XMLEventReader {
	
	XMLEventReader delegate;
	
	public XMLEventReaderDelegate(XMLEventReader delegate){
		this.delegate = delegate;
		
	}

	@Override
	public Object next() {
		return delegate.next();
		
	}

	@Override
	public void remove() {
		delegate.remove();
		
	}

	@Override
	public XMLEvent nextEvent() throws XMLStreamException {
		return delegate.nextEvent();

	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return delegate.hasNext();
	}

	@Override
	public XMLEvent peek() throws XMLStreamException {
		// TODO Auto-generated method stub
		return delegate.peek();
	}

	@Override
	public String getElementText() throws XMLStreamException {
		// TODO Auto-generated method stub
		return delegate.getElementText();
	}

	@Override
	public XMLEvent nextTag() throws XMLStreamException {
		// TODO Auto-generated method stub
		return delegate.nextTag();
	}

	@Override
	public Object getProperty(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return delegate.getProperty(name);
	}

	@Override
	public void close() throws XMLStreamException {
		delegate.close();
		
	}

}
