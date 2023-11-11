package com.example.formmovita;

public class Form {
   private String name;
   private boolean screen1;
   private boolean screen2;
   private boolean screen3;

   private char gender;

   private boolean boughtFurniture;
   private boolean interestFurniture;
   private boolean interestRA;
   public Form(String name, boolean screen1, boolean screen2, boolean screen3, char gender,
               boolean boughtFurniture, boolean interestFurniture, boolean interestRA) {
      this.name = String.valueOf(name);
      this.screen1 = screen1;
      this.screen2 = screen2;
      this.screen3 = screen3;
      this.gender = gender;
      this.boughtFurniture = boughtFurniture;
      this.interestFurniture = interestFurniture;
      this.interestRA = interestRA;
   }
   public boolean isBoughtFurniture() {
      return boughtFurniture;
   }

   public void setBoughtFurniture(boolean boughtFurniture) {
      this.boughtFurniture = boughtFurniture;
   }

   public boolean isInterestFurniture() {
      return interestFurniture;
   }

   public void setInterestFurniture(boolean interestFurniture) {
      this.interestFurniture = interestFurniture;
   }

   public boolean isInterestRA() {
      return interestRA;
   }

   public void setInterestRA(boolean interestRA) {
      this.interestRA = interestRA;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public boolean isScreen1() {
      return screen1;
   }

   public void setScreen1(boolean screen1) {
      this.screen1 = screen1;
   }

   public boolean isScreen2() {
      return screen2;
   }

   public void setScreen2(boolean screen2) {
      this.screen2 = screen2;
   }

   public boolean isScreen3() {
      return screen3;
   }

   public void setScreen3(boolean screen3) {
      this.screen3 = screen3;
   }

   public char getGender() {
      return gender;
   }

   public void setGender(char gender) {
      this.gender = gender;
   }
}
