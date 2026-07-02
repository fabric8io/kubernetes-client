package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class DownwardAPIProjectionFluent<A extends io.fabric8.kubernetes.api.model.DownwardAPIProjectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DownwardAPIVolumeFileBuilder> items = new ArrayList<DownwardAPIVolumeFileBuilder>();

  public DownwardAPIProjectionFluent() {
  }
  
  public DownwardAPIProjectionFluent(DownwardAPIProjection instance) {
    this.copyInstance(instance);
  }

  public A addAllToItems(Collection<DownwardAPIVolumeFile> items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (DownwardAPIVolumeFile item : items) {
        DownwardAPIVolumeFileBuilder builder = new DownwardAPIVolumeFileBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public ItemsNested<A> addNewItem() {
    return new ItemsNested(-1, null);
  }
  
  public ItemsNested<A> addNewItemLike(DownwardAPIVolumeFile item) {
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
  
  public A addToItems(DownwardAPIVolumeFile... items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (DownwardAPIVolumeFile item : items) {
        DownwardAPIVolumeFileBuilder builder = new DownwardAPIVolumeFileBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public A addToItems(int index,DownwardAPIVolumeFile item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    DownwardAPIVolumeFileBuilder builder = new DownwardAPIVolumeFileBuilder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.add(index, builder);
    }
    return (A) this;
  }
  
  public DownwardAPIVolumeFile buildFirstItem() {
    return this.items.get(0).build();
  }
  
  public DownwardAPIVolumeFile buildItem(int index) {
    return this.items.get(index).build();
  }
  
  public List<DownwardAPIVolumeFile> buildItems() {
    return this.items != null ? build(items) : null;
  }
  
  public DownwardAPIVolumeFile buildLastItem() {
    return this.items.get(items.size() - 1).build();
  }
  
  public DownwardAPIVolumeFile buildMatchingItem(Predicate<DownwardAPIVolumeFileBuilder> predicate) {
      for (DownwardAPIVolumeFileBuilder item : items) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DownwardAPIProjection instance) {
    instance = instance != null ? instance : new DownwardAPIProjection();
    if (instance != null) {
        this.withItems(instance.getItems());
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
  
  public ItemsNested<A> editMatchingItem(Predicate<DownwardAPIVolumeFileBuilder> predicate) {
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
    DownwardAPIProjectionFluent that = (DownwardAPIProjectionFluent) o;
    if (!(Objects.equals(items, that.items))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasItems() {
    return this.items != null && !(this.items.isEmpty());
  }
  
  public boolean hasMatchingItem(Predicate<DownwardAPIVolumeFileBuilder> predicate) {
      for (DownwardAPIVolumeFileBuilder item : items) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(items, additionalProperties);
  }
  
  public A removeAllFromItems(Collection<DownwardAPIVolumeFile> items) {
    if (this.items == null) {
      return (A) this;
    }
    for (DownwardAPIVolumeFile item : items) {
        DownwardAPIVolumeFileBuilder builder = new DownwardAPIVolumeFileBuilder(item);
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
  
  public A removeFromItems(DownwardAPIVolumeFile... items) {
    if (this.items == null) {
      return (A) this;
    }
    for (DownwardAPIVolumeFile item : items) {
        DownwardAPIVolumeFileBuilder builder = new DownwardAPIVolumeFileBuilder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromItems(Predicate<DownwardAPIVolumeFileBuilder> predicate) {
    if (items == null) {
      return (A) this;
    }
    Iterator<DownwardAPIVolumeFileBuilder> each = items.iterator();
    List visitables = _visitables.get("items");
    while (each.hasNext()) {
        DownwardAPIVolumeFileBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ItemsNested<A> setNewItemLike(int index,DownwardAPIVolumeFile item) {
    return new ItemsNested(index, item);
  }
  
  public A setToItems(int index,DownwardAPIVolumeFile item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    DownwardAPIVolumeFileBuilder builder = new DownwardAPIVolumeFileBuilder(item);
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
  
  public A withItems(List<DownwardAPIVolumeFile> items) {
    if (this.items != null) {
      this._visitables.get("items").clear();
    }
    if (items != null) {
        this.items = new ArrayList();
        for (DownwardAPIVolumeFile item : items) {
          this.addToItems(item);
        }
    } else {
      this.items = null;
    }
    return (A) this;
  }
  
  public A withItems(DownwardAPIVolumeFile... items) {
    if (this.items != null) {
        this.items.clear();
        _visitables.remove("items");
    }
    if (items != null) {
      for (DownwardAPIVolumeFile item : items) {
        this.addToItems(item);
      }
    }
    return (A) this;
  }
  public class ItemsNested<N> extends DownwardAPIVolumeFileFluent<ItemsNested<N>> implements Nested<N>{
  
    DownwardAPIVolumeFileBuilder builder;
    int index;
  
    ItemsNested(int index,DownwardAPIVolumeFile item) {
      this.index = index;
      this.builder = new DownwardAPIVolumeFileBuilder(this, item);
    }
  
    public N and() {
      return (N) DownwardAPIProjectionFluent.this.setToItems(index, builder.build());
    }
    
    public N endItem() {
      return and();
    }
    
  }
}