package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConfigMapProjectionFluent<A extends io.fabric8.kubernetes.api.model.ConfigMapProjectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<KeyToPathBuilder> items = new ArrayList<KeyToPathBuilder>();
  private String name;
  private Boolean optional;

  public ConfigMapProjectionFluent() {
  }
  
  public ConfigMapProjectionFluent(ConfigMapProjection instance) {
    this.copyInstance(instance);
  }

  public A addAllToItems(Collection<KeyToPath> items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (KeyToPath item : items) {
        KeyToPathBuilder builder = new KeyToPathBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public ItemsNested<A> addNewItem() {
    return new ItemsNested(-1, null);
  }
  
  public A addNewItem(String key,Integer mode,String path) {
    return (A) this.addToItems(new KeyToPath(key, mode, path));
  }
  
  public ItemsNested<A> addNewItemLike(KeyToPath item) {
    return new ItemsNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToItems(KeyToPath... items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (KeyToPath item : items) {
        KeyToPathBuilder builder = new KeyToPathBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public A addToItems(int index,KeyToPath item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    KeyToPathBuilder builder = new KeyToPathBuilder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.add(index, builder);
    }
    return (A) this;
  }
  
  public KeyToPath buildFirstItem() {
    return this.items.get(0).build();
  }
  
  public KeyToPath buildItem(int index) {
    return this.items.get(index).build();
  }
  
  public List<KeyToPath> buildItems() {
    return this.items != null ? build(items) : null;
  }
  
  public KeyToPath buildLastItem() {
    return this.items.get(items.size() - 1).build();
  }
  
  public KeyToPath buildMatchingItem(Predicate<KeyToPathBuilder> predicate) {
      for (KeyToPathBuilder item : items) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ConfigMapProjection instance) {
    instance = instance != null ? instance : new ConfigMapProjection();
    if (instance != null) {
        this.withItems(instance.getItems());
        this.withName(instance.getName());
        this.withOptional(instance.getOptional());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ItemsNested<A> editFirstItem() {
    if (items.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "items"));
    }
    return this.setNewItemLike(0, this.buildItem(0));
  }
  
  public ItemsNested<A> editItem(int index) {
    if (items.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "items"));
    }
    return this.setNewItemLike(index, this.buildItem(index));
  }
  
  public ItemsNested<A> editLastItem() {
    int index = items.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "items"));
    }
    return this.setNewItemLike(index, this.buildItem(index));
  }
  
  public ItemsNested<A> editMatchingItem(Predicate<KeyToPathBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < items.size();i++) {
      if (predicate.test(items.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "items"));
    }
    return this.setNewItemLike(index, this.buildItem(index));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ConfigMapProjectionFluent that = (ConfigMapProjectionFluent) o;
    if (!(Objects.equals(items, that.items))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(optional, that.optional))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getOptional() {
    return this.optional;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasItems() {
    return this.items != null && !(this.items.isEmpty());
  }
  
  public boolean hasMatchingItem(Predicate<KeyToPathBuilder> predicate) {
      for (KeyToPathBuilder item : items) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOptional() {
    return this.optional != null;
  }
  
  public int hashCode() {
    return Objects.hash(items, name, optional, additionalProperties);
  }
  
  public A removeAllFromItems(Collection<KeyToPath> items) {
    if (this.items == null) {
      return (A) this;
    }
    for (KeyToPath item : items) {
        KeyToPathBuilder builder = new KeyToPathBuilder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromItems(KeyToPath... items) {
    if (this.items == null) {
      return (A) this;
    }
    for (KeyToPath item : items) {
        KeyToPathBuilder builder = new KeyToPathBuilder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromItems(Predicate<KeyToPathBuilder> predicate) {
    if (items == null) {
      return (A) this;
    }
    Iterator<KeyToPathBuilder> each = items.iterator();
    List visitables = _visitables.get("items");
    while (each.hasNext()) {
        KeyToPathBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ItemsNested<A> setNewItemLike(int index,KeyToPath item) {
    return new ItemsNested(index, item);
  }
  
  public A setToItems(int index,KeyToPath item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    KeyToPathBuilder builder = new KeyToPathBuilder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(items == null) && !(items.isEmpty())) {
        sb.append("items:");
        sb.append(items);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(optional == null)) {
        sb.append("optional:");
        sb.append(optional);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withItems(List<KeyToPath> items) {
    if (this.items != null) {
      this._visitables.get("items").clear();
    }
    if (items != null) {
        this.items = new ArrayList();
        for (KeyToPath item : items) {
          this.addToItems(item);
        }
    } else {
      this.items = null;
    }
    return (A) this;
  }
  
  public A withItems(KeyToPath... items) {
    if (this.items != null) {
        this.items.clear();
        _visitables.remove("items");
    }
    if (items != null) {
      for (KeyToPath item : items) {
        this.addToItems(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withOptional() {
    return withOptional(true);
  }
  
  public A withOptional(Boolean optional) {
    this.optional = optional;
    return (A) this;
  }
  public class ItemsNested<N> extends KeyToPathFluent<ItemsNested<N>> implements Nested<N>{
  
    KeyToPathBuilder builder;
    int index;
  
    ItemsNested(int index,KeyToPath item) {
      this.index = index;
      this.builder = new KeyToPathBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigMapProjectionFluent.this.setToItems(index, builder.build());
    }
    
    public N endItem() {
      return and();
    }
    
  }
}