package com.practice.jaxb.JAXB;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);

			// marshal java object into xml
			Marshaller marshaller = context.createMarshaller();
			Patient patient = new Patient();
			patient.setName("swati");
			patient.setAge(12);
			patient.setId(1);

			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);

			System.out.println(writer);

			// unmarshall xml into java object

			Unmarshaller unmarshaller = context.createUnmarshaller();
			// Patient patientDeserializeData = unmarshaller.unmarshal(writer.toString());
			// we cant use the above writer.toString directly as it will not accpet a string
			// directly.

			Patient patientDeserializeData = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));

			System.out.println(patientDeserializeData.getAge()); // result is 12
			System.out.println(patientDeserializeData.getName()); // result is Swati
			System.out.println(patientDeserializeData.getId()); // result is 1

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
