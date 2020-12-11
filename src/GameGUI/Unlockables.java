/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


/**
 *
 * @author oussa
 */
public class Unlockables extends GridPane {

    private Label title;
    ArrayList<ItemNotInGame> ListOfItems = new ArrayList();
    ItemNotInGame it;
    

    public Unlockables() throws FileNotFoundException {
        this.title = new Label("Unlockables");
        
        InsertImagesInGrid(ListOfItems);
        insertbuttons();
        insertPrices();
        this.setHgap(20);
        this.setVgap(24);
        this.setAlignment(Pos.CENTER);
    }

    public void InsertImagesInGrid(ArrayList<ItemNotInGame> items) throws FileNotFoundException {

        for (int i = 1; i < 13; i++) {
            ListOfItems.add(new ItemNotInGame(i));
        }

        for (int i = 0; i < ListOfItems.size(); i++) {
            if (i < 6) {
                ListOfItems.get(i).setFitHeight(128);
                ListOfItems.get(i).setFitWidth(128);
                this.add(ListOfItems.get(i), i + 1, 1);

            }
            if (i < 12 && i > 5) {
                ListOfItems.get(i).setFitHeight(128);
                ListOfItems.get(i).setFitWidth(128);
                this.add(ListOfItems.get(i), i - 5, 4);

            }
        }

    }

    public void insertbuttons() {
        for (int i = 0; i < ListOfItems.size(); i++) {
            if(!ListOfItems.get(i).isBought()){
                Button buy = ListOfItems.get(i).getBuyButton();
                if (i < 6) {
                    this.setHalignment(buy, HPos.CENTER);
                    this.add(buy, i + 1, 2);
                }
                if (i < 12 && i > 5) {
                    this.setHalignment(buy, HPos.CENTER);
                    this.add(buy, i - 5, 5);
                }                
            }else{
                Label possessedItem = ListOfItems.get(i).getPossessedItem();
                if (i < 6) {
                    this.setHalignment(possessedItem, HPos.CENTER);
                    this.add(possessedItem, i + 1, 2);
                }
                if (i < 12 && i > 5) {
                    this.setHalignment(possessedItem, HPos.CENTER);
                    this.add(possessedItem, i - 5, 5);
                }   
            }
        }

    }

    public void insertPrices() {
        for (int i = 0; i < ListOfItems.size(); i++) {
            Label cost = new Label(Integer.toString(ListOfItems.get(i).getPrice()));
            cost.setTextFill(Color.web("#FFA500", 0.8));
            cost.setScaleX(2);
            cost.setScaleY(2);
            if (i < 6) {
                this.add(cost, i + 1, 0);
            }
            if (i < 12 && i > 5) {
                this.add(cost, i - 5, 3);
            }
        }
    }

    public ArrayList<ItemNotInGame> getListOfItems() {
        return ListOfItems;
    }

    public void setListOfItems(ArrayList<ItemNotInGame> ListOfItems) {
        this.ListOfItems = ListOfItems;
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public ItemNotInGame getIt() {
        return it;
    }

    public void setIt(ItemNotInGame it) {
        this.it = it;
    }

}
