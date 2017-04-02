
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.VCARD;

public class Tutorial03 extends Object {

    public static void main(String args[]) {
//  Criando um modelo vazio
        Model model = ModelFactory.createDefaultModel();

        String personURI = "http://somewhere/JohnSmith";
        String givenName = "John";
        String familyName = "Smith";
        String fullName = givenName + " " + familyName;
        
//  Criando um resouce
        Resource johnSmith
        = model.createResource(personURI).addProperty(VCARD.FN, fullName)
        .addProperty(VCARD.N, model.createResource()
        .addProperty(VCARD.Given, givenName)
        .addProperty(VCARD.Family, familyName));

//  Listando os statements no modelo
        StmtIterator iter = model.listStatements();
        
//  Imprimir o predicado, assunto e objeto de cada declaração
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement(); // Pegar próxima instrução
            Resource subject = stmt.getSubject(); // Pegar próximo sujeito
            Property predicate = stmt.getPredicate(); // Pegar o predicato 
            RDFNode object = stmt.getObject(); // Pegar o objeto
            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
//  Objeto literal
                System.out.print(" \"" + object.toString() + "\"");
            }
            System.out.println(" .");

        }
        model.write(System.out, "RDF/XML-ABBREV");//exporta em xml
    }

}
