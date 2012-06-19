package de.htw.SemInt;

import com.hp.hpl.jena.ontology.OntClass;
import java.io.FileNotFoundException;
import java.util.Iterator;

import com.hp.hpl.jena.util.iterator.Filter;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;
import com.hp.hpl.jena.util.PrintUtil;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OntologyTest {

	public static void main(String[] args) {
            String ns = "http://www.semanticweb.org/bline_asus/ontologies/2012/5/untitled-ontology-5#";
            String ontopath = "./onto.owl";
            
             try {
                OntModel onto = ModelFactory.createOntologyModel(
                                OntModelSpec.OWL_MEM, null);

                //onto.read( "file:art.n3", "N3" );
                onto.read((new FileInputStream(ontopath)), "RDF/XML");

                Iterator i = onto.listHierarchyRootClasses()
                        .filterDrop( new Filter() {
                            public boolean accept( Object o ) {
                            return ((Resource) o).isAnon();
                            }} );

                while (i.hasNext()) {
                    System.out.println(i.next().toString());
                }
                
                OntClass sm = onto.getOntClass(ns + "Smartphone");
                System.out.println("Equivalent Class: " + sm.getEquivalentClass());
                 
                Reasoner reasoner = ReasonerRegistry.getOWLMiniReasoner();
                reasoner = reasoner.bindSchema (onto);
                
                //To use that together with instance data we have to load that into a separate model:
                Model instances = ModelFactory.createDefaultModel();
                instances.read ((new FileInputStream(ontopath)), "RDF/XML");
                
                InfModel model = ModelFactory.createInfModel (reasoner, instances);
                Resource r = model.getResource (ns + "Kunde");
                for (StmtIterator sti = model.listStatements(r, null, (RDFNode) null);
                     sti.hasNext(); ) {
                     Statement stmt = sti.nextStatement();
                     System.out.println(" - " + PrintUtil.print(stmt));
                }
                
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(OntologyTest.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
}
