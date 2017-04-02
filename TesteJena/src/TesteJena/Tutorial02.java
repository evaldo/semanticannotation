
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class Tutorial02 extends Object {

    public static void main(String args[]) {

//  Definiçoes
        String personURI = "http://somewhere/JohnSmith";
        String givenName = "John";
        String familyName = "Smith";
        String fullName = givenName + " " + familyName;
        
//  Criando um modelo vazio
        Model model = ModelFactory.createDefaultModel();
        
//  Criando um resouce e adcionando as propiedades em cascata
        Resource johnSmith
        = model.createResource(personURI).addProperty(VCARD.FN, fullName)
        .addProperty(VCARD.N, model.createResource()
        .addProperty(VCARD.Given, givenName)
        .addProperty(VCARD.Family, familyName));
        
        model.write(System.out);
    }
}
