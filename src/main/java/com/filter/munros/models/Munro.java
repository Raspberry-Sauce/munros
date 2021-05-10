package com.filter.munros.models;

public class Munro {

  private String name;
  private float height;
  private String hillCategory;
  private String gridReference;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
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
