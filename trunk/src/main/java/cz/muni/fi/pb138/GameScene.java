/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class GameScene {
    private String sceneName;
    private String sceneDesc;
    private List<Choice> choices = new ArrayList<>();

    public GameScene() {
    }

    public GameScene(String sceneName, String sceneDesc) {
        this.sceneName = sceneName;
        this.sceneDesc = sceneDesc;
    }

    public String getSceneName() {
        return sceneName;
    }

    public String getSceneDesc() {
        return sceneDesc;
    }

    public void setChoice(Choice choice) {
        choices.add(choice);
    }
    
    public Choice getChoice(int id) {
        return choices.get(id);
    }
    
    public int getChoicesCount() {
        return choices.size();
    }
}
