/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.iterator.ExtendedIterator;

/**
 *
 * @author Filipe
 */
public class Ontologia {

    String inputFileName = "c://urbanus.owl";

    public Ontologia(String inputFileName) {
        this.inputFileName = inputFileName;
    }
//create the reasoning model using the base
    

    public List listarClasses() {
        OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        String URI = "http://www.owl-ontologies.com/unnamed.owl#";
        InputStream in = FileManager.get().open(inputFileName);
            if (in == null) {
                throw new IllegalArgumentException("File: " + inputFileName + " not found");
            }
        inf.read(in, "");
        ArrayList<String> o = new ArrayList<String>();

        ExtendedIterator classes = inf.listClasses();

        while (classes.hasNext()) {
            OntClass essaClasse = (OntClass) classes.next();

            String vClasse = essaClasse.getLocalName();
            o.add(vClasse);

        }
        return o;
    }

    public List listarSubClasses(String classe) {
        OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        String URI = "http://www.owl-ontologies.com/unnamed.owl#";
        InputStream in = FileManager.get().open(inputFileName);
            if (in == null) {
                throw new IllegalArgumentException("File: " + inputFileName + " not found");
            }
        inf.read(in, "");
        OntClass cla = inf.getOntClass(URI + classe);
        ArrayList<String> sc = new ArrayList<String>();
        if (cla.hasSubClass()) {
            for (Iterator i = cla.listSubClasses(); i.hasNext();) {
                OntClass c = (OntClass) i.next();

                String VSubClasses = c.getLocalName();
                sc.add(VSubClasses);

            }

        }
        return sc;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

}
