package task6.client.clientParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task6.client.Client;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClientParser {
    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder builder;
    private File file;
    private Document document;

    public ClientParser(String filePath) throws ParserConfigurationException, IOException, SAXException {
        ClientParser.builder = ClientParser.factory.newDocumentBuilder();
        this.file = new File(filePath);
        this.document = builder.parse(file);
    }

    public List<Client> parseClient() throws IOException, ParserConfigurationException, SAXException, ParseException {
        List<Client> clients = new ArrayList<>();
        NodeList userNodeList = document.getElementsByTagName("user");

        for (int i = 0; i < userNodeList.getLength(); i++) {

            Client client = new Client();
            if (userNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element userElement = (Element) userNodeList.item(i);
                NodeList userChildNodeList = userElement.getChildNodes();

                for (int j = 0; j < userChildNodeList.getLength(); j++) {
                    if (userChildNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {

                        Element childElement = (Element) userChildNodeList.item(j);
                        client.setId(Integer.parseInt(userElement.getAttribute("id")));

                        setClientsProperty(client, childElement);

                    }
                }
                clients.add(client);
            }
        }

        return clients;
    }

    private void setClientsProperty(Client client, Element childElement) throws ParseException {
        switch (childElement.getNodeName()) {
            case "fullName": {
                client.setFullName(childElement.getTextContent());
                break;
            }
            case "birthday": {
                String birthdayDate = childElement.getTextContent();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
                LocalDate birthday = LocalDate.parse(birthdayDate, formatter);
                client.setBirthday(birthday);
                break;
            }
            case "address": {
                client.setAddress(childElement.getTextContent());
                break;
            }
            case "balance": {
                client.setBalance(Double.parseDouble(childElement.getTextContent()));
                break;
            }
            case "job": {
                client.setJob(childElement.getTextContent());
                break;
            }
            case "position": {
                client.setPosition(childElement.getTextContent());
                break;
            }
            case "salary": {
                client.setSalary(Integer.parseInt(childElement.getTextContent()));
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid property name");
        }
    }
}