package it.unicam.cs.ids.LoyalityPlatform;

import java.util.List;

public class FidelityPlatform {
     private List<FidelityProgram> programs;

     private String description;

     public FidelityPlatform(){

     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }
}
