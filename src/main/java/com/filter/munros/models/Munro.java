package com.filter.munros.models;

public class Munro {

  private String name;
  private String height;
  private String hillCategory;
  private String gridReference;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
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
