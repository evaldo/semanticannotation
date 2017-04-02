
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class Tutorial01 extends Object {
// Definiçoes

    static String personURI = "C:\\Users\\Filipe\\Google Drive\\TCC\\urbanus.owl";// Como vamos fazer?
    static String fullName = "John Smith";

    public static void main(String args[]) {
// Criando um modelo vazio
        Model model = ModelFactory.createDefaultModel();
// Criando um resouce
        Resource johnSmith = model.createResource(personURI);
// Adicionando a propiedade
        johnSmith.addProperty(VCARD.FN, fullName);
// Escrever o modelo em xml
        model.write(System.out);
    }
}
