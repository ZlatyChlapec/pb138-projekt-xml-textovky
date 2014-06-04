package cz.muni.fi.pb138;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Stefan Malcek - 422715
 *         created on June 3, 2014
 */
public class ValidatorTest {
    private XmlValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new XmlValidator();
    }

    @After
    public void tearDown() {
    }

    //correct xml files
    @Test
    public void correctXml() {
        try {
            validator.validateGameXml("testXML.xml");
            assertThat(message, is(nullValue()));
        } catch (IOException ioe) {
            fail("IOError - textXml.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptySceneDescription() {
        try {
            validator.validateGameXml("emptySceneDescription.xml");
            assertThat(message, is(nullValue()));
        } catch (IOException ioe) {
            fail("IOError - emptySceneDescription.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //incorrect xml files
    @Test
    public void duplicitSceneId() {
        try {
            validator.validateGameXml("duplicitSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - duplicitSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void wrongRootName() {
        try {
            validator.validateGameXml("wrongRootName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - wrongRootName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingGameName() {
        try {
            validator.validateGameXml("missingGameName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingGameName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptyGameName() {
        try {
            validator.validateGameXml("emptyGameName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyGameName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingGameStartingScene() {
        try {
            validator.validateGameXml("missingGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptyGameStartingScene() {
        try {
            validator.validateGameXml("emptyGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void negativeGameStartingScene() {
        try {
            validator.validateGameXml("negativeGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - negativeGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void stringGameStartingScene() {
        try {
            validator.validateGameXml("stringGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void oneScene() {
        try {
            validator.validateGameXml("oneScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - oneScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingSceneId() {
        try {
            validator.validateGameXml("missingSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptySceneId() {
        try {
            validator.validateGameXml("emptySceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptySceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void negativeSceneId() {
        try {
            validator.validateGameXml("negativeSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - negativeSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void stringSceneId() {
        try {
            validator.validateGameXml("stringSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingSceneName() {
        try {
            validator.validateGameXml("missingSceneName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptySceneName() {
        try {
            validator.validateGameXml("emptySceneName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptySceneName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingSceneDescription() {
        try {
            validator.validateGameXml("missingSceneDescription.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneDescription.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingSceneChoices() {
        try {
            validator.validateGameXml("missingSceneChoices.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneChoices.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptySceneChoices() {
        try {
            validator.validateGameXml("emptySceneChoices.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptySceneChoices.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void tooMuchSceneChoices() {
        try {
            validator.validateGameXml("tooMuchSceneChoices.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - tooMuchSceneChoices.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingChoiceText() {
        try {
            validator.validateGameXml("missingChoiceText.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingChoiceText.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptyChoiceText() {
        try {
            validator.validateGameXml("emptyChoiceText.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyChoiceText.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void duplicitChoiceText() {
        try {
            validator.validateGameXml("duplicitChoiceText.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - duplicitChoiceText.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingChoiceGoTo() {
        try {
            validator.validateGameXml("missingChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptyChoiceGoTo() {
        try {
            validator.validateGameXml("emptyChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void negativeChoiceGoTo() {
        try {
            validator.validateGameXml("negativeChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - negativeChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void stringChoiceGoTo() {
        try {
            validator.validateGameXml("stringChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void missingChoicePoints() {
        try {
            validator.validateGameXml("missingChoicePoints.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingChoicePoints.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            Logger.getLogger(ValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void emptyChoicePoints() {
        try {
            validator.validateGameXml("emptyChoicePoints.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyChoicePoints.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void stringChoicePoints() {
        try {
            validator.validateGameXml("stringChoicePoints.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringChoicePoints.xml: " + ioe.getMessage());
        }
    }
}
