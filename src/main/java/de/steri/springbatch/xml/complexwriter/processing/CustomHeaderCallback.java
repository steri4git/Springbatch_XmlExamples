package de.steri.springbatch.xml.complexwriter.processing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.xml.StaxWriterCallback;

import de.steri.springbatch.xml.domain.PersonType;
import de.steri.springbatch.xml.util.XmlObjectFactory;

public class CustomHeaderCallback extends StepExecutionListenerSupport
		implements StaxWriterCallback {

	XmlObjectFactory xmlfactory = new XmlObjectFactory();
	private StepExecution stepExecution;

	@Override
	public void write(XMLEventWriter writer) {
		XMLEventFactory factory = XMLEventFactory.newInstance();
		Marshaller marshaller = null;
		stepExecution.getJobExecution().getExecutionContext()
				.get("xmlItemWriter");
		try {
			marshaller = JAXBContext.newInstance(PersonType.class)
					.createMarshaller();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			writer.add(factory.createStartElement("", "", "header"));

			writer.add(factory.createStartElement("", "", "someTag"));
			writer.add(factory.createEndElement("", "", "someTag"));
			writer.add(factory.createEndElement("", "", "header"));
			marshaller.marshal(xmlfactory.createPersonType(1, 1), writer);
			marshaller.marshal(xmlfactory.createPersonType(1, 1), writer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}