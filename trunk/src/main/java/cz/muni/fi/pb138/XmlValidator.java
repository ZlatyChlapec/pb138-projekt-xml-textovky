/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.*;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Filip Sonta
 * @version 18.5.2014
 */
public class XmlValidator {
    private DocumentBuilder docBuilder;
    
    private class ValidationErrorHandler implements ErrorHandler{

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            Logger.getAnonymousLogger(XmlValidator.class.getName()).log(Level.INFO,exception.getMessage());
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            throw new SAXException(exception.getMessage());
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            throw new SAXException(exception.getMessage());
        }
    }
    
    public XmlValidator(){
    }

    public void validateGameXml(String xmlName) throws IOException, SchemaValidateException {
//        try {
//            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
//            File schemaLocation = new File(gameSchema);
//            Schema schema = factory.newSchema(schemaLocation);
//            Validator validator = schema.newValidator();
//            Source source = new StreamSource(xmlName);
//            validator.validate(source);
//            System.out.println(xmlName + " is valid.");
//        }
//        catch (SAXException ex) {
//            System.out.println(xmlName + " is not valid because ");
//            System.out.println(ex.getMessage());
//        }  
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("textGameXmlSchema.xsd"));
            
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            
            dbf.setSchema(schema);
            docBuilder = dbf.newDocumentBuilder();
            docBuilder.setErrorHandler(new ValidationErrorHandler());
            Document doc = docBuilder.parse(new File(xmlName));
        } catch (SAXException ex) {
            System.err.println("Error: " + ex.getMessage());
            throw new SchemaValidateException(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            System.err.println("Parser configuration error: " + ex.getMessage());
            throw new SchemaValidateException(ex.getMessage());
        }
    }
}
