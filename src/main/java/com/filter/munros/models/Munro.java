package com.filter.munros.models;

public class Munro {

  private String name;
  private int height;
  private String hillCategory; //may change
  private String gridReference;

  public Munro(String name, int height, String hillCategory, String gridReference) {
    this.name = name;
    this.height = height;
    this.hillCategory = hillCategory;
    this.gridReference = gridReference;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getHillCategory() {
    return hillCategory;
  }

  public void setHillCategory(String hillCategory) {
    this.hillCategory = hillCategory;
  }

  public String getGridReference() {
    return gridReference;
  }

  public void setGridReference(String gridReference) {
    this.gridReference = gridReference;
  }
}
