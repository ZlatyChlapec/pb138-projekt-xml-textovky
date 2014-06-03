package cz.muni.fi.pb138;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
    private Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = new Validator("textGameXmlSchema.xsd");
    }

    @After
    public void tearDown() {
    }

    //correct xml files
    @Test
    public void correctXml() {
        try {
            String message = validator.validate("testXML.xml");
            assertThat(message, is(nullValue()));
        } catch (IOException ioe) {
            fail("IOError - textXml.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptySceneDescription() {
        try {
            String message = validator.validate("emptySceneDescription.xml");
            assertThat(message, is(nullValue()));
        } catch (IOException ioe) {
            fail("IOError - emptySceneDescription.xml: " + ioe.getMessage());
        }
    }

    //incorrect xml files
    @Test
    public void duplicitSceneId() {
        try {
            String message = validator.validate("duplicitSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - duplicitSceneId.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void wrongRootName() {
        try {
            String message = validator.validate("wrongRootName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - wrongRootName.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingGameName() {
        try {
            String message = validator.validate("missingGameName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingGameName.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptyGameName() {
        try {
            String message = validator.validate("emptyGameName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyGameName.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingGameStartingScene() {
        try {
            String message = validator.validate("missingGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingGameStartingScene.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptyGameStartingScene() {
        try {
            String message = validator.validate("emptyGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyGameStartingScene.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void negativeGameStartingScene() {
        try {
            String message = validator.validate("negativeGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - negativeGameStartingScene.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void stringGameStartingScene() {
        try {
            String message = validator.validate("stringGameStartingScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringGameStartingScene.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void oneScene() {
        try {
            String message = validator.validate("oneScene.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - oneScene.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingSceneId() {
        try {
            String message = validator.validate("missingSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneId.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptySceneId() {
        try {
            String message = validator.validate("emptySceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptySceneId.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void negativeSceneId() {
        try {
            String message = validator.validate("negativeSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - negativeSceneId.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void stringSceneId() {
        try {
            String message = validator.validate("stringSceneId.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringSceneId.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingSceneName() {
        try {
            String message = validator.validate("missingSceneName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneName.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptySceneName() {
        try {
            String message = validator.validate("emptySceneName.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptySceneName.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingSceneDescription() {
        try {
            String message = validator.validate("missingSceneDescription.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneDescription.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingSceneChoices() {
        try {
            String message = validator.validate("missingSceneChoices.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingSceneChoices.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptySceneChoices() {
        try {
            String message = validator.validate("emptySceneChoices.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptySceneChoices.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void tooMuchSceneChoices() {
        try {
            String message = validator.validate("tooMuchSceneChoices.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - tooMuchSceneChoices.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingChoiceText() {
        try {
            String message = validator.validate("missingChoiceText.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingChoiceText.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptyChoiceText() {
        try {
            String message = validator.validate("emptyChoiceText.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyChoiceText.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void duplicitChoiceText() {
        try {
            String message = validator.validate("duplicitChoiceText.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - duplicitChoiceText.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingChoiceGoTo() {
        try {
            String message = validator.validate("missingChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingChoiceGoTo.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptyChoiceGoTo() {
        try {
            String message = validator.validate("emptyChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyChoiceGoTo.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void negativeChoiceGoTo() {
        try {
            String message = validator.validate("negativeChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - negativeChoiceGoTo.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void stringChoiceGoTo() {
        try {
            String message = validator.validate("stringChoiceGoTo.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringChoiceGoTo.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void missingChoicePoints() {
        try {
            String message = validator.validate("missingChoicePoints.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - missingChoicePoints.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void emptyChoicePoints() {
        try {
            String message = validator.validate("emptyChoicePoints.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - emptyChoicePoints.xml: " + ioe.getMessage());
        }
    }

    @Test
    public void stringChoicePoints() {
        try {
            String message = validator.validate("stringChoicePoints.xml");
            assertThat(message, is(not(nullValue())));
        } catch (IOException ioe) {
            fail("IOError - stringChoicePoints.xml: " + ioe.getMessage());
        }
    }
}
