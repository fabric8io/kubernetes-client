package io.fabric8.kubeapitest.binary.repo;

public class ObjectListItem {

  private String name;

  public String getName() {
    return name;
  }

  public ObjectListItem setName(String name) {
    this.name = name;
    return this;
  }
}
