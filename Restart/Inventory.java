package Restart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 public class Inventory {
     private String snackLocation;
     private String snackName;
     private int snackPrice;
     private String snackType;
     private String[] snacks;

     public Map<String, Snacks> itemData = new HashMap<>();


     public String inventoryList() {
         File inventoryFile = new File("vendingmachine.csv");
         String line = null;
         try (Scanner fileStreamer = new Scanner(inventoryFile)) {
             while (fileStreamer.hasNextLine()) {
                 line = fileStreamer.nextLine();
                 String[] snacks = line.split("\\|");
                 String snackLocation = snacks[0];
                 String snackName = snacks[1];
                 String snackPrice = snacks[2];
                 String snackType = snacks[3];
                 Double priceDouble = Double.parseDouble(snackPrice);
                 Snacks item;
                 if (snackType.equals("Drink")) {
                     item = new Beverages(snackLocation, snackName, priceDouble, snackType, "Glug Glug, Yum!");
                     itemData.put(snackLocation, item);
                      }
                 else if (snackType.equals("Chip")) {
                     item = new Chips(snackLocation, snackName, priceDouble, snackType, "Crunch Crunch,Yum!");
                     itemData.put(snackLocation, item);
                 }
                 else if (snackType.equals("Gum")) {
                     item = new Gum(snackLocation, snackName, priceDouble, snackType, "Chew Chew, Yum!");
                     itemData.put(snackLocation, item);
                 }
                 else if (snackType.equals("Candy")) {
                     item = new Candy(snackLocation, snackName, priceDouble, snackType, "Munch Munch.Yum!");
                     itemData.put(snackLocation, item);
                 }

             }


         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         return line;
     }



     public String getSnackLocation() {
         return snackLocation;
     }

     public String getSnackName() {
         return snackName;
     }

     public int getSnackPrice() {
         return snackPrice;
     }

     public String getSnackType() {
         return snackType;
     }

     public String[] getSnacks() {
         return snacks;
     }

     public Map<String, Snacks> getItemData() {
         return itemData;
     }
 }

