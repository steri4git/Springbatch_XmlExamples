package de.steri.springbatch.xml.complexwriter.processing;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;


/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("writer1")
public class Writer1 implements ItemWriter<Object> {

	private static final Log log = LogFactory.getLog(Writer1.class);
	
	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Object> data) throws Exception {
		System.out.println("WRITER 1 AUFGERUFEN");
		if (data != null){
			System.out.println("Anzahl der Items: " + data.size());
		}
		log.info(data);
	}
}
