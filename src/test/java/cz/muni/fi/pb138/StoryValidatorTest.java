package cz.muni.fi.pb138;

import cz.muni.fi.pb138.exceptions.StoryValidateException;
import cz.muni.fi.pb138.validators.StoryValidator;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * Testing of story lines.
 *
 * @author Stefan Malcek - 422715
 *         created on June 8, 2014
 */
public class StoryValidatorTest {
    private StoryValidator storyValidator;
    private final String PATH = "src/test/resources/StoryValidatorTestFiles/";

    /**
     * Tests story line.
     * File directWayToEnd.xml is valid.
     */
    @Test
    public void directWayToEnd() {
        try {
            storyValidator = new StoryValidator(PATH + "directWayToEnd.xml");
            storyValidator.validateGameStory();
        } catch (IOException ioe) {
            fail("IOError - directWayToEnd.xml: " + ioe.getMessage());
        } catch (StoryValidateException ex) {
            fail("Fail - directWayToEnd.xml should be correct: " + ex.getMessage());
        }
    }

    /**
     * Tests story line.
     * File indirectWayToEnd.xml is valid.
     */
    @Test
    public void indirectWayToEnd() {
        try {
            storyValidator = new StoryValidator(PATH + "indirectWayToEnd.xml");
            storyValidator.validateGameStory();
        } catch (IOException ioe) {
            fail("IOError - indirectWayToEnd.xml: " + ioe.getMessage());
        } catch (StoryValidateException ex) {
            fail("Fail - indirectWayToEnd.xml should be correct: " + ex.getMessage());
        }
    }

    /**
     * Tests story line.
     * File twoFinalScenes.xml is valid.
     */
    @Test
    public void twoFinalScenes() {
        try {
            storyValidator = new StoryValidator(PATH + "twoFinalScenes.xml");
            storyValidator.validateGameStory();
        } catch (IOException ioe) {
            fail("IOError - twoFinalScenes.xml: " + ioe.getMessage());
        } catch (StoryValidateException ex) {
            fail("Fail - twoFinalScenes.xml should be correct: " + ex.getMessage());
        }
    }

    /**
     * Tests story line.
     * File endlessGame.xml is invalid.
     */
    @Test
    public void endlessGame() {
        try {
            storyValidator = new StoryValidator(PATH + "endlessGame.xml");
            storyValidator.validateGameStory();
            fail("Fail - endlessGame.xml could not be correct - contains endless loop");
        } catch (IOException ioe) {
            fail("IOError - endlessGame.xml: " + ioe.getMessage());
        } catch (StoryValidateException ignored) {
        }
    }

    /**
     * Tests story line.
     * File goToSelf.xml is invalid.
     */
    @Test
    public void goToSelf() {
        try {
            storyValidator = new StoryValidator(PATH + "goToSelf.xml");
            storyValidator.validateGameStory();
            fail("Fail - goToSelf.xml could not be correct - goTo pointing on self");
        } catch (IOException ioe) {
            fail("IOError - goToSelf.xml: " + ioe.getMessage());
        } catch (StoryValidateException ignored) {
        }
    }

    /**
     * Tests story line.
     * File incorrectGoTo.xml is invalid.
     */
    @Test
    public void incorrectGoTo() {
        try {
            storyValidator = new StoryValidator(PATH + "incorrectGoTo.xml");
            storyValidator.validateGameStory();
            fail("Fail - incorrectGoTo.xml could not be correct - goTo contains non existing scene id");
        } catch (IOException ioe) {
            fail("IOError - incorrectGoTo.xml: " + ioe.getMessage());
        } catch (StoryValidateException ignored) {
        }
    }

    /**
     * Tests story line.
     * File unusedScene.xml is invalid.
     */
    @Test
    public void unusedScene() {
        try {
            storyValidator = new StoryValidator(PATH + "unusedScene.xml");
            storyValidator.validateGameStory();
            fail("Fail - unusedScene.xml could not be correct - contains unused scene");
        } catch (IOException ioe) {
            fail("IOError - unusedScene.xml: " + ioe.getMessage());
        } catch (StoryValidateException ignored) {
        }
    }

    /**
     * Tests story line.
     * File wrongStartingScene.xml is invalid.
     */
    @Test
    public void wrongStartingScene() {
        try {
            storyValidator = new StoryValidator(PATH + "wrongStartingScene.xml");
            storyValidator.validateGameStory();
            fail("Fail - wrongStartingScene.xml could not be correct - startingScene contains non existing scene id");
        } catch (IOException ioe) {
            fail("IOError - wrongStartingScene.xml: " + ioe.getMessage());
        } catch (StoryValidateException ignored) {
        }
    }

}
