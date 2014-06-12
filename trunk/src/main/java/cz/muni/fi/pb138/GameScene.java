/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip Sonta
 * @version 1.0
 */
public class GameScene {
    private long id;
    private String sceneName;
    private String sceneDesc;
    private List<Choice> choices = new ArrayList<>();

    public GameScene() {
    }

    public GameScene(long id, String sceneName, String sceneDesc) {
        this.id = id;
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
    
    public long getChoiceGoTo(int id) {
        return choices.get(id).getGoTo();
    }
    
    public String getChoiceText(int id) {
        return choices.get(id).getText();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameScene other = (GameScene) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GameScene{" + "id=" + id + ", sceneName=" + sceneName + ", sceneDesc=" + sceneDesc + '}';
    }
    
    
}