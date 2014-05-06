package de.steri.springbatch.xml.nonjaxbreader.processing;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import de.steri.springbatch.xml.domain.DateiType;



/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("jaxbItemWriter1")
public class Writer1 implements ItemWriter<DateiType> {

	//private static final Log log = LogFactory.getLog(Writer1.class);
	
	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends DateiType> data) throws Exception {
		System.out.println("WRITER 1 AUFGERUFEN");
		if (data != null){
			System.out.println("Anzahl der Items: " + data.size());
			
			for (Object object : data) {
				System.out.println(object.getClass());
			}
		}
		//log.info(data);
	}
}
