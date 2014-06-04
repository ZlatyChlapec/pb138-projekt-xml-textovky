/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

/**
 *
 * @author Filip
 */
public class SchemaValidateException extends Exception {
    public SchemaValidateException() {
        super();
    }
    
    public SchemaValidateException(String message) {
        super(message);
    }
}
