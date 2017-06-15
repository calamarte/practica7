import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Created by Dgarcia on 14/06/2017.
 */
public class Getxml {
    public static DataBase cogexml() {
        //inicializacion variables
        String servidor = "";
        String usuario = "";
        String passwd = "";
        String database = "";
        DataBase db = null;
        try {
            //a partir del fichero xml coge los datos necesarios para conectarse a la base de datos
            File fXmlFile = new File("src/main/resources/application.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("properties");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    //las variables cogen el valor segun las etiquetas del xml
                    usuario = eElement.getElementsByTagName("username").item(0).getTextContent();
                    passwd = eElement.getElementsByTagName("password").item(0).getTextContent();
                    servidor = eElement.getElementsByTagName("server").item(0).getTextContent();
                    database = eElement.getElementsByTagName("database").item(0).getTextContent();
                }
            }
            db = new DataBase(servidor, database, usuario, passwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //devuelve objeto base de datos con los datos de conexion
        return db;
    }
}
