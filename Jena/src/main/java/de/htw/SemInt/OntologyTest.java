package de.htw.SemInt;

import java.util.Iterator;

import com.hp.hpl.jena.util.iterator.Filter;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;

public class OntologyTest {

	public static void main(String[] args) {
		OntModel onto = ModelFactory.createOntologyModel(
				OntModelSpec.OWL_MEM, null);
		
		onto.read( "file:art.n3", "N3" );
		
//		Iterator i = onto.listHierarchyRootClasses()
//		        .filterDrop( new Filter() {
//		            public boolean accept( Object o ) {
//		            return ((Resource) o).isAnon();
//		            }} );
//
//		while (i.hasNext()) {
//		    System.out.println(i.next().toString());
//		}
		
		Reasoner reasoner = ReasonerRegistry.getOWLMiniReasoner();
	}
	
}
