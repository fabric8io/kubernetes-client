package io.javaoperatorsdk.jenvtest.binary.repo;

import java.util.List;

public class ObjectList {

  private List<ObjectListItem> items;

  public List<ObjectListItem> getItems() {
    return items;
  }

  public ObjectList setItems(List<ObjectListItem> items) {
    this.items = items;
    return this;
  }
}
