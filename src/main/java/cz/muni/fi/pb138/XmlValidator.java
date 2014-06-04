/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void validateGameXml(String xmlName) throws IOException, SchemaValidateException{
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
            throw new SchemaValidateException(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            throw new SchemaValidateException(ex.getMessage());
        }
    }
}
