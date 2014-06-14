package cz.muni.fi.pb138;

import cz.muni.fi.pb138.exceptions.SchemaValidateException;
import cz.muni.fi.pb138.validators.XmlValidator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * Testing of XMLSchema
 *
 * @author Stefan Malcek - 422715
 *         created on June 3, 2014
 */
public class XmlValidatorTest {
    private XmlValidator validator;
    private final String PATH = "src/test/resources/XmlValidatorTestFiles/";

    /**
     * Setup of validator.
     * Sets up validator before each test.
     */
    @Before
    public void setUp() {
        validator = new XmlValidator();
    }

    /**
     * Tests xml file.
     * File correctXml.xml is valid.
     */
    @Test
    public void correctXml() {
        try {
            validator.validateGameXml(PATH + "correctXML.xml");
        } catch (IOException ioe) {
            fail("IOError - correctXML.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            fail("Fail - correctXML.xml should be correct: " + ex.getMessage());
        }
    }

    /**
     * Tests xml file.
     * File emptySceneDescription.xml is valid.
     */
    @Test
    public void emptySceneDescription() {
        try {
            validator.validateGameXml(PATH + "emptySceneDescription.xml");
        } catch (IOException ioe) {
            fail("IOError - emptySceneDescription.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            fail("Fail - emptySceneDescription.xml should be correct: " + ex.getMessage());
        }
    }

    /**
     * Tests xml file.
     * File emptySceneChoices is valid.
     */
    @Test
    public void emptySceneChoices() {
        try {
            validator.validateGameXml(PATH + "emptySceneChoices.xml");
        } catch (IOException ioe) {
            fail("IOError - emptySceneChoices.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ex) {
            fail("Fail - emptySceneChoices.xml should be correct: " + ex.getMessage());
        }
    }

    /**
     * Tests xml file.
     * File duplicitSceneId.xml is invalid.
     */
    @Test
    public void duplicitSceneId() {
        try {
            validator.validateGameXml(PATH + "duplicitSceneId.xml");
            fail("Fail - non unique scene id");
        } catch (IOException ioe) {
            fail("IOError - duplicitSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File wrongRootName.xml is invalid.
     */
    @Test
    public void wrongRootName() {
        try {
            validator.validateGameXml(PATH + "wrongRootName.xml");
            fail("Fail - wrong name of root element");
        } catch (IOException ioe) {
            fail("IOError - wrongRootName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingGameName.xml is invalid.
     */
    @Test
    public void missingGameName() {
        try {
            validator.validateGameXml(PATH + "missingGameName.xml");
            fail("Fail - missing attribute name in element game");
        } catch (IOException ioe) {
            fail("IOError - missingGameName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File emptyGameName.xml is invalid.
     */
    @Test
    public void emptyGameName() {
        try {
            validator.validateGameXml(PATH + "emptyGameName.xml");
            fail("Fail - attribute name in element game could not be empty");
        } catch (IOException ioe) {
            fail("IOError - emptyGameName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingGameStartingScene.xml.
     */
    @Test
    public void missingGameStartingScene() {
        try {
            validator.validateGameXml(PATH + "missingGameStartingScene.xml");
            fail("Fail - missing attribute starting scene in element game");
        } catch (IOException ioe) {
            fail("IOError - missingGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File emptyGameStartingScene.xml is invalid.
     */
    @Test
    public void emptyGameStartingScene() {
        try {
            validator.validateGameXml(PATH + "emptyGameStartingScene.xml");
            fail("Fail - attribute starting scene in element game could not be empty");
        } catch (IOException ioe) {
            fail("IOError - emptyGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File negativeGameStartingScene.xml is invalid.
     */
    @Test
    public void negativeGameStartingScene() {
        try {
            validator.validateGameXml(PATH + "negativeGameStartingScene.xml");
            fail("Fail - negative value of attribute starting scene in element game");
        } catch (IOException ioe) {
            fail("IOError - negativeGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File stringGameStartingScene.xml is invalid.
     */
    @Test
    public void stringGameStartingScene() {
        try {
            validator.validateGameXml(PATH + "stringGameStartingScene.xml");
            fail("Fail - string value of attribute starting scene in element game");
        } catch (IOException ioe) {
            fail("IOError - stringGameStartingScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File oneScene.xml is invalid.
     */
    @Test
    public void oneScene() {
        try {
            validator.validateGameXml(PATH + "oneScene.xml");
            fail("Fail - xml file must have more than one scene");
        } catch (IOException ioe) {
            fail("IOError - oneScene.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingSceneId.xml is invalid.
     */
    @Test
    public void missingSceneId() {
        try {
            validator.validateGameXml(PATH + "missingSceneId.xml");
            fail("Fail - missing attribute id in element scene");
        } catch (IOException ioe) {
            fail("IOError - missingSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File emptySceneId.xml is invalid.
     */
    @Test
    public void emptySceneId() {
        try {
            validator.validateGameXml(PATH + "emptySceneId.xml");
            fail("Fail - attribute id in element scene could not be empty");
        } catch (IOException ioe) {
            fail("IOError - emptySceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File negativeSceneId.xml is invalid.
     */
    @Test
    public void negativeSceneId() {
        try {
            validator.validateGameXml(PATH + "negativeSceneId.xml");
            fail("Fail - negative value of attribute id in element scene");
        } catch (IOException ioe) {
            fail("IOError - negativeSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File stringSceneId.xml is invalid.
     */
    @Test
    public void stringSceneId() {
        try {
            validator.validateGameXml(PATH + "stringSceneId.xml");
            fail("Fail - string value of attribute id in element scene");
        } catch (IOException ioe) {
            fail("IOError - stringSceneId.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingSceneName.xml is invalid.
     */
    @Test
    public void missingSceneName() {
        try {
            validator.validateGameXml(PATH + "missingSceneName.xml");
            fail("Fail - missing attribute name in element scene");
        } catch (IOException ioe) {
            fail("IOError - missingSceneName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File emptySceneName.xml is invalid.
     */
    @Test
    public void emptySceneName() {
        try {
            validator.validateGameXml(PATH + "emptySceneName.xml");
            fail("Fail - attribute name in element scene could not be empty");
        } catch (IOException ioe) {
            fail("IOError - emptySceneName.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingSceneDescription.xml is invalid.
     */
    @Test
    public void missingSceneDescription() {
        try {
            validator.validateGameXml(PATH + "missingSceneDescription.xml");
            fail("Fail - missing element description in element scene");
        } catch (IOException ioe) {
            fail("IOError - missingSceneDescription.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingSceneChoices.xml is invalid.
     */
    @Test
    public void missingSceneChoices() {
        try {
            validator.validateGameXml(PATH + "missingSceneChoices.xml");
            fail("Fail - missing element choices in element scene");
        } catch (IOException ioe) {
            fail("IOError - missingSceneChoices.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File tooMuchSceneChoices.xml is invalid.
     */
    @Test
    public void tooMuchSceneChoices() {
        try {
            validator.validateGameXml(PATH + "tooMuchSceneChoices.xml");
            fail("Fail - element choices could not have more than four elements");
        } catch (IOException ioe) {
            fail("IOError - tooMuchSceneChoices.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingChoiceText.xml is invalid.
     */
    @Test
    public void missingChoiceText() {
        try {
            validator.validateGameXml(PATH + "missingChoiceText.xml");
            fail("Fail - missing element text in element choice");
        } catch (IOException ioe) {
            fail("IOError - missingChoiceText.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File emptyChoiceText.xml is invalid.
     */
    @Test
    public void emptyChoiceText() {
        try {
            validator.validateGameXml(PATH + "emptyChoiceText.xml");
            fail("Fail - element text in element choice could not be empty");
        } catch (IOException ioe) {
            fail("IOError - emptyChoiceText.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File duplicitChoiceText.xml is invalid.
     */
    @Test
    public void duplicitChoiceText() {
        try {
            validator.validateGameXml(PATH + "duplicitChoiceText.xml");
            fail("Fail - element choice could not have more than one element text");
        } catch (IOException ioe) {
            fail("IOError - duplicitChoiceText.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File missingChoiceGoTo.xml is invalid.
     */
    @Test
    public void missingChoiceGoTo() {
        try {
            validator.validateGameXml(PATH + "missingChoiceGoTo.xml");
            fail("Fail - missing attribute goTo in element choice");
        } catch (IOException ioe) {
            fail("IOError - missingChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File emptyChoiceGoTo.xml is invalid.
     */
    @Test
    public void emptyChoiceGoTo() {
        try {
            validator.validateGameXml(PATH + "emptyChoiceGoTo.xml");
            fail("Fail - attribute goTo in element choice could not be empty");
        } catch (IOException ioe) {
            fail("IOError - emptyChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File negativeChoiceGoTo.xml is invalid.
     */
    @Test
    public void negativeChoiceGoTo() {
        try {
            validator.validateGameXml(PATH + "negativeChoiceGoTo.xml");
            fail("Fail - negative value of attribute goTo in element choice");
        } catch (IOException ioe) {
            fail("IOError - negativeChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }

    /**
     * Tests xml file.
     * File stringChoiceGoTo.xml is invalid.
     */
    @Test
    public void stringChoiceGoTo() {
        try {
            validator.validateGameXml(PATH + "stringChoiceGoTo.xml");
            fail("Fail - string value of attribute goTo in element choice");
        } catch (IOException ioe) {
            fail("IOError - stringChoiceGoTo.xml: " + ioe.getMessage());
        } catch (SchemaValidateException ignored) {
        }
    }
}
