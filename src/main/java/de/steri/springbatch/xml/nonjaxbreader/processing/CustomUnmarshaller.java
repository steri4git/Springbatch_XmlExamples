package de.steri.springbatch.xml.nonjaxbreader.processing;

import java.io.IOException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Source;
import javax.xml.transform.stax.StAXSource;

import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class CustomUnmarshaller implements Unmarshaller {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object unmarshal(Source source) throws IOException,
			XmlMappingException {

		System.out.println("CustomUnmarshaller: " + source.getClass());

		StAXSource src = (StAXSource) source;
		XMLEventReader parser = src.getXMLEventReader();
		// StringBuilder spacer = new StringBuilder();
		try {
			while (parser.hasNext()) {
				XMLEvent se = parser.nextEvent();
				if (se.isStartElement()){
					System.out.println(se.asStartElement().getName());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Object();
	}
}
