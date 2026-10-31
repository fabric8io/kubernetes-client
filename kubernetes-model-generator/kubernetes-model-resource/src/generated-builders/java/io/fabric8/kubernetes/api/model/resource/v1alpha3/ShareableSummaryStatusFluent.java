package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ShareableSummaryStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha3.ShareableSummaryStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ShareableCapacityStatusBuilder> capacity = new ArrayList<ShareableCapacityStatusBuilder>();
  private Integer fullyAvailableDevices;
  private Integer partiallyAvailableDevices;

  public ShareableSummaryStatusFluent() {
  }
  
  public ShareableSummaryStatusFluent(ShareableSummaryStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToCapacity(Collection<ShareableCapacityStatus> items) {
    if (this.capacity == null) {
      this.capacity = new ArrayList();
    }
    for (ShareableCapacityStatus item : items) {
        ShareableCapacityStatusBuilder builder = new ShareableCapacityStatusBuilder(item);
        _visitables.get("capacity").add(builder);
        this.capacity.add(builder);
    }
    return (A) this;
  }
  
  public CapacityNested<A> addNewCapacity() {
    return new CapacityNested(-1, null);
  }
  
  public CapacityNested<A> addNewCapacityLike(ShareableCapacityStatus item) {
    return new CapacityNested(-1, item);
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
  
  public A addToCapacity(ShareableCapacityStatus... items) {
    if (this.capacity == null) {
      this.capacity = new ArrayList();
    }
    for (ShareableCapacityStatus item : items) {
        ShareableCapacityStatusBuilder builder = new ShareableCapacityStatusBuilder(item);
        _visitables.get("capacity").add(builder);
        this.capacity.add(builder);
    }
    return (A) this;
  }
  
  public A addToCapacity(int index,ShareableCapacityStatus item) {
    if (this.capacity == null) {
      this.capacity = new ArrayList();
    }
    ShareableCapacityStatusBuilder builder = new ShareableCapacityStatusBuilder(item);
    if (index < 0 || index >= capacity.size()) {
        _visitables.get("capacity").add(builder);
        capacity.add(builder);
    } else {
        _visitables.get("capacity").add(builder);
        capacity.add(index, builder);
    }
    return (A) this;
  }
  
  public List<ShareableCapacityStatus> buildCapacity() {
    return this.capacity != null ? build(capacity) : null;
  }
  
  public ShareableCapacityStatus buildCapacity(int index) {
    return this.capacity.get(index).build();
  }
  
  public ShareableCapacityStatus buildFirstCapacity() {
    return this.capacity.get(0).build();
  }
  
  public ShareableCapacityStatus buildLastCapacity() {
    return this.capacity.get(capacity.size() - 1).build();
  }
  
  public ShareableCapacityStatus buildMatchingCapacity(Predicate<ShareableCapacityStatusBuilder> predicate) {
      for (ShareableCapacityStatusBuilder item : capacity) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ShareableSummaryStatus instance) {
    instance = instance != null ? instance : new ShareableSummaryStatus();
    if (instance != null) {
        this.withCapacity(instance.getCapacity());
        this.withFullyAvailableDevices(instance.getFullyAvailableDevices());
        this.withPartiallyAvailableDevices(instance.getPartiallyAvailableDevices());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CapacityNested<A> editCapacity(int index) {
    if (capacity.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "capacity"));
    }
    return this.setNewCapacityLike(index, this.buildCapacity(index));
  }
  
  public CapacityNested<A> editFirstCapacity() {
    if (capacity.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "capacity"));
    }
    return this.setNewCapacityLike(0, this.buildCapacity(0));
  }
  
  public CapacityNested<A> editLastCapacity() {
    int index = capacity.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "capacity"));
    }
    return this.setNewCapacityLike(index, this.buildCapacity(index));
  }
  
  public CapacityNested<A> editMatchingCapacity(Predicate<ShareableCapacityStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < capacity.size();i++) {
      if (predicate.test(capacity.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "capacity"));
    }
    return this.setNewCapacityLike(index, this.buildCapacity(index));
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
    ShareableSummaryStatusFluent that = (ShareableSummaryStatusFluent) o;
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(fullyAvailableDevices, that.fullyAvailableDevices))) {
      return false;
    }
    if (!(Objects.equals(partiallyAvailableDevices, that.partiallyAvailableDevices))) {
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
  
  public Integer getFullyAvailableDevices() {
    return this.fullyAvailableDevices;
  }
  
  public Integer getPartiallyAvailableDevices() {
    return this.partiallyAvailableDevices;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null && !(this.capacity.isEmpty());
  }
  
  public boolean hasFullyAvailableDevices() {
    return this.fullyAvailableDevices != null;
  }
  
  public boolean hasMatchingCapacity(Predicate<ShareableCapacityStatusBuilder> predicate) {
      for (ShareableCapacityStatusBuilder item : capacity) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPartiallyAvailableDevices() {
    return this.partiallyAvailableDevices != null;
  }
  
  public int hashCode() {
    return Objects.hash(capacity, fullyAvailableDevices, partiallyAvailableDevices, additionalProperties);
  }
  
  public A removeAllFromCapacity(Collection<ShareableCapacityStatus> items) {
    if (this.capacity == null) {
      return (A) this;
    }
    for (ShareableCapacityStatus item : items) {
        ShareableCapacityStatusBuilder builder = new ShareableCapacityStatusBuilder(item);
        _visitables.get("capacity").remove(builder);
        this.capacity.remove(builder);
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
  
  public A removeFromCapacity(ShareableCapacityStatus... items) {
    if (this.capacity == null) {
      return (A) this;
    }
    for (ShareableCapacityStatus item : items) {
        ShareableCapacityStatusBuilder builder = new ShareableCapacityStatusBuilder(item);
        _visitables.get("capacity").remove(builder);
        this.capacity.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCapacity(Predicate<ShareableCapacityStatusBuilder> predicate) {
    if (capacity == null) {
      return (A) this;
    }
    Iterator<ShareableCapacityStatusBuilder> each = capacity.iterator();
    List visitables = _visitables.get("capacity");
    while (each.hasNext()) {
        ShareableCapacityStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CapacityNested<A> setNewCapacityLike(int index,ShareableCapacityStatus item) {
    return new CapacityNested(index, item);
  }
  
  public A setToCapacity(int index,ShareableCapacityStatus item) {
    if (this.capacity == null) {
      this.capacity = new ArrayList();
    }
    ShareableCapacityStatusBuilder builder = new ShareableCapacityStatusBuilder(item);
    if (index < 0 || index >= capacity.size()) {
        _visitables.get("capacity").add(builder);
        capacity.add(builder);
    } else {
        _visitables.get("capacity").add(builder);
        capacity.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(capacity == null) && !(capacity.isEmpty())) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(fullyAvailableDevices == null)) {
        sb.append("fullyAvailableDevices:");
        sb.append(fullyAvailableDevices);
        sb.append(",");
    }
    if (!(partiallyAvailableDevices == null)) {
        sb.append("partiallyAvailableDevices:");
        sb.append(partiallyAvailableDevices);
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
  
  public A withCapacity(List<ShareableCapacityStatus> capacity) {
    if (this.capacity != null) {
      this._visitables.get("capacity").clear();
    }
    if (capacity != null) {
        this.capacity = new ArrayList();
        for (ShareableCapacityStatus item : capacity) {
          this.addToCapacity(item);
        }
    } else {
      this.capacity = null;
    }
    return (A) this;
  }
  
  public A withCapacity(ShareableCapacityStatus... capacity) {
    if (this.capacity != null) {
        this.capacity.clear();
        _visitables.remove("capacity");
    }
    if (capacity != null) {
      for (ShareableCapacityStatus item : capacity) {
        this.addToCapacity(item);
      }
    }
    return (A) this;
  }
  
  public A withFullyAvailableDevices(Integer fullyAvailableDevices) {
    this.fullyAvailableDevices = fullyAvailableDevices;
    return (A) this;
  }
  
  public A withPartiallyAvailableDevices(Integer partiallyAvailableDevices) {
    this.partiallyAvailableDevices = partiallyAvailableDevices;
    return (A) this;
  }
  public class CapacityNested<N> extends ShareableCapacityStatusFluent<CapacityNested<N>> implements Nested<N>{
  
    ShareableCapacityStatusBuilder builder;
    int index;
  
    CapacityNested(int index,ShareableCapacityStatus item) {
      this.index = index;
      this.builder = new ShareableCapacityStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ShareableSummaryStatusFluent.this.setToCapacity(index, builder.build());
    }
    
    public N endCapacity() {
      return and();
    }
    
  }
}