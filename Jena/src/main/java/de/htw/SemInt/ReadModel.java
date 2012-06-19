package de.htw.SemInt;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.ProfileRegistry;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

public class ReadModel {

	public static void main(String[] args) {
            String ns = "http://www.semanticweb.org/bline_asus/ontologies/2012/5/untitled-ontology-5#";
	    String xmlbase = "http://www.soctrace.org/ontologies/#";
	    String ontopath = "./onto.owl";
	    //String ontopath = "Z:\\workspace\\SI_Projekt\\SemInt\\Jena\\onto.owl";
		
               try {
                    OntModel model = ModelFactory.createOntologyModel(ProfileRegistry.OWL_DL_LANG);

                    //Jena does not support OWL/XML format
                    //RDF/XML format ist needed
                    model.read((new FileInputStream(ontopath)), "RDF/XML");
                    model.write(System.out);

                    System.out.println("Zugriff auf Model: Get Smartphone classes");
                    OntClass c1 = model.getOntClass(ns + "Smartphone");
                    //OntClass c1 = model.getOntClass(ns + "SpieleSmartphone");
                    for (Iterator i = c1.listSubClasses(); i.hasNext();){
                            OntClass c = (OntClass) i.next();
                            System.out.println(c.getURI());
                    }

                    Resource r = model.getResource(ns + "Smartphone");
                    System.out.println("Res: " + r.toString());
                    Property property = model.getProperty(ns + "hatEigenschaft");
                    //System.out.println("isProp:" +   property.isProperty());
                    //System.out.println("URI:" + property.getURI());
                    System.out.println("Prop: " + r.getProperty(property));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			//e.printStackTrace();
		}    
	}
	
}
