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

    String inputFileName = "";
    String URI = "";
    String arvore;
    List<String> Listarvore = new ArrayList<>();
    
    public Ontologia(String inputFileName, String URI) {
        this.inputFileName = inputFileName;
        this.URI = URI;
        
    }
    

    
    
    public List<String> listarClasses() {

        try {

            OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
            InputStream in = FileManager.get().open(inputFileName);
            if (in == null) {
                throw new IllegalArgumentException("File: " + inputFileName + " not found");
            }
            inf.read(in, "");
            if (inf.getNsPrefixURI("") != null) {
                URI = inf.getNsPrefixURI("");
            }
            
            ExtendedIterator classes = inf.listClasses();
            while (classes.hasNext()) {
                OntClass essaClasse = (OntClass) classes.next();
                String vClasse = essaClasse.getLocalName();
                if (vClasse != null && !essaClasse.hasSuperClass()) {

                    if (essaClasse.hasSubClass()) {
                        arvore = "<details><summary>Classe:" + vClasse + "</summary>";
                        Listarvore.add(arvore);
                        for (Iterator i = essaClasse.listSubClasses(); i.hasNext();) {
                            OntClass c = (OntClass) i.next();
                            String subClasse = c.getLocalName();
                            listarSubClasses(subClasse);
                        }
                        arvore = "</details>";
                        Listarvore.add(arvore);
                    } else {
                        arvore = "<summary>Classe:" + vClasse + "</summary>";
                        Listarvore.add(arvore);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Listarvore;
    }

    public void listarSubClasses(String classe) {
        OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException("File: " + inputFileName + " not found");
        }
        inf.read(in, "");
        OntClass cla = inf.getOntClass(URI + classe);
        ArrayList<String> sc = new ArrayList<String>();
        if (cla.hasSubClass()) {
            arvore = "<details><summary>SubClasse:" + classe + "</summary>";
            Listarvore.add(arvore);
            for (Iterator i = cla.listSubClasses(); i.hasNext();) {
                OntClass c = (OntClass) i.next();

                String VSubClasses = c.getLocalName();

                arvore = VSubClasses + "<p>";//mudei aqui
                Listarvore.add(arvore);
                if (c.hasSubClass()) {
                    listarSubClasses(VSubClasses);
                }
            }
            arvore = "</details>";
            Listarvore.add(arvore);
        } else {
            arvore = "<summary>" + classe + "</summary>";
            Listarvore.add(arvore);
        }
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

}
