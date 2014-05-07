package de.steri.springbatch.xml.nonjaxbreader.processing;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLEventReader;
import javax.xml.transform.Source;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.batch.item.xml.StaxUtils;
import org.springframework.oxm.Unmarshaller;

public class CustomValidatingUnmarshaller implements Unmarshaller {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object unmarshal(Source source) {

		try {
			
			XMLEventReader reader;
			System.out.println("CustomUnmarshaller: " + source.getClass());

			SchemaFactory factory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema;
			schema = factory
					.newSchema(new File(
							"C:/springsource/workspace/Springbatch_XmlExamples/src/main/java/de/steri/springbatch/xml/domain/Dateiaustausch3.xsd"));
			Validator validator = schema.newValidator();

			StAXSource src1 = (StAXSource) source;
			PersonHandler pers = new PersonHandler(src1.getXMLEventReader());
			StAXSource src2 = (StAXSource)StaxUtils.getSource(pers);
			validator.validate(src2);
			//XMLEventReader parser = src.getXMLEventReader();
			
			// StringBuilder spacer = new StringBuilder();

//			while (parser.hasNext()) {
//				XMLEvent se = parser.nextEvent();
//				if (se.isStartElement()) {
//					System.out.println(se.asStartElement().getName());
//					
//				}
				
	//		}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Object();
	}
}
