package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ListMeta;
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
public class ImageDigestMirrorSetListFluent<A extends io.fabric8.openshift.api.model.config.v1.ImageDigestMirrorSetListFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<ImageDigestMirrorSetBuilder> items = new ArrayList<ImageDigestMirrorSetBuilder>();
  private String kind;
  private ListMeta metadata;

  public ImageDigestMirrorSetListFluent() {
  }
  
  public ImageDigestMirrorSetListFluent(ImageDigestMirrorSetList instance) {
    this.copyInstance(instance);
  }

  public A addAllToItems(Collection<ImageDigestMirrorSet> items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (ImageDigestMirrorSet item : items) {
        ImageDigestMirrorSetBuilder builder = new ImageDigestMirrorSetBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public ItemsNested<A> addNewItem() {
    return new ItemsNested(-1, null);
  }
  
  public ItemsNested<A> addNewItemLike(ImageDigestMirrorSet item) {
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
  
  public A addToItems(ImageDigestMirrorSet... items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (ImageDigestMirrorSet item : items) {
        ImageDigestMirrorSetBuilder builder = new ImageDigestMirrorSetBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public A addToItems(int index,ImageDigestMirrorSet item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    ImageDigestMirrorSetBuilder builder = new ImageDigestMirrorSetBuilder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageDigestMirrorSet buildFirstItem() {
    return this.items.get(0).build();
  }
  
  public ImageDigestMirrorSet buildItem(int index) {
    return this.items.get(index).build();
  }
  
  public List<ImageDigestMirrorSet> buildItems() {
    return this.items != null ? build(items) : null;
  }
  
  public ImageDigestMirrorSet buildLastItem() {
    return this.items.get(items.size() - 1).build();
  }
  
  public ImageDigestMirrorSet buildMatchingItem(Predicate<ImageDigestMirrorSetBuilder> predicate) {
      for (ImageDigestMirrorSetBuilder item : items) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ImageDigestMirrorSetList instance) {
    instance = instance != null ? instance : new ImageDigestMirrorSetList();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withItems(instance.getItems());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
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
  
  public ItemsNested<A> editMatchingItem(Predicate<ImageDigestMirrorSetBuilder> predicate) {
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
    ImageDigestMirrorSetListFluent that = (ImageDigestMirrorSetListFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(items, that.items))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public ListMeta getMetadata() {
    return this.metadata;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasItems() {
    return this.items != null && !(this.items.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingItem(Predicate<ImageDigestMirrorSetBuilder> predicate) {
      for (ImageDigestMirrorSetBuilder item : items) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, items, kind, metadata, additionalProperties);
  }
  
  public A removeAllFromItems(Collection<ImageDigestMirrorSet> items) {
    if (this.items == null) {
      return (A) this;
    }
    for (ImageDigestMirrorSet item : items) {
        ImageDigestMirrorSetBuilder builder = new ImageDigestMirrorSetBuilder(item);
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
  
  public A removeFromItems(ImageDigestMirrorSet... items) {
    if (this.items == null) {
      return (A) this;
    }
    for (ImageDigestMirrorSet item : items) {
        ImageDigestMirrorSetBuilder builder = new ImageDigestMirrorSetBuilder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromItems(Predicate<ImageDigestMirrorSetBuilder> predicate) {
    if (items == null) {
      return (A) this;
    }
    Iterator<ImageDigestMirrorSetBuilder> each = items.iterator();
    List visitables = _visitables.get("items");
    while (each.hasNext()) {
        ImageDigestMirrorSetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ItemsNested<A> setNewItemLike(int index,ImageDigestMirrorSet item) {
    return new ItemsNested(index, item);
  }
  
  public A setToItems(int index,ImageDigestMirrorSet item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    ImageDigestMirrorSetBuilder builder = new ImageDigestMirrorSetBuilder(item);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(items == null) && !(items.isEmpty())) {
        sb.append("items:");
        sb.append(items);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withItems(List<ImageDigestMirrorSet> items) {
    if (this.items != null) {
      this._visitables.get("items").clear();
    }
    if (items != null) {
        this.items = new ArrayList();
        for (ImageDigestMirrorSet item : items) {
          this.addToItems(item);
        }
    } else {
      this.items = null;
    }
    return (A) this;
  }
  
  public A withItems(ImageDigestMirrorSet... items) {
    if (this.items != null) {
        this.items.clear();
        _visitables.remove("items");
    }
    if (items != null) {
      for (ImageDigestMirrorSet item : items) {
        this.addToItems(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ListMeta metadata) {
    this.metadata = metadata;
    return (A) this;
  }
  public class ItemsNested<N> extends ImageDigestMirrorSetFluent<ItemsNested<N>> implements Nested<N>{
  
    ImageDigestMirrorSetBuilder builder;
    int index;
  
    ItemsNested(int index,ImageDigestMirrorSet item) {
      this.index = index;
      this.builder = new ImageDigestMirrorSetBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageDigestMirrorSetListFluent.this.setToItems(index, builder.build());
    }
    
    public N endItem() {
      return and();
    }
    
  }
}