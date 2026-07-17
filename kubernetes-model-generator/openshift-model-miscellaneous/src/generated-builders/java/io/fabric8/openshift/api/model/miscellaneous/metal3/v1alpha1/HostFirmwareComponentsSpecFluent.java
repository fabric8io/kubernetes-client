package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class HostFirmwareComponentsSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostFirmwareComponentsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FirmwareUpdateBuilder> updates = new ArrayList<FirmwareUpdateBuilder>();

  public HostFirmwareComponentsSpecFluent() {
  }
  
  public HostFirmwareComponentsSpecFluent(HostFirmwareComponentsSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToUpdates(Collection<FirmwareUpdate> items) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").add(builder);
        this.updates.add(builder);
    }
    return (A) this;
  }
  
  public UpdatesNested<A> addNewUpdate() {
    return new UpdatesNested(-1, null);
  }
  
  public A addNewUpdate(String component,String url) {
    return (A) this.addToUpdates(new FirmwareUpdate(component, url));
  }
  
  public UpdatesNested<A> addNewUpdateLike(FirmwareUpdate item) {
    return new UpdatesNested(-1, item);
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
  
  public A addToUpdates(FirmwareUpdate... items) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").add(builder);
        this.updates.add(builder);
    }
    return (A) this;
  }
  
  public A addToUpdates(int index,FirmwareUpdate item) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
    if (index < 0 || index >= updates.size()) {
        _visitables.get("updates").add(builder);
        updates.add(builder);
    } else {
        _visitables.get("updates").add(builder);
        updates.add(index, builder);
    }
    return (A) this;
  }
  
  public FirmwareUpdate buildFirstUpdate() {
    return this.updates.get(0).build();
  }
  
  public FirmwareUpdate buildLastUpdate() {
    return this.updates.get(updates.size() - 1).build();
  }
  
  public FirmwareUpdate buildMatchingUpdate(Predicate<FirmwareUpdateBuilder> predicate) {
      for (FirmwareUpdateBuilder item : updates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FirmwareUpdate buildUpdate(int index) {
    return this.updates.get(index).build();
  }
  
  public List<FirmwareUpdate> buildUpdates() {
    return this.updates != null ? build(updates) : null;
  }
  
  protected void copyInstance(HostFirmwareComponentsSpec instance) {
    instance = instance != null ? instance : new HostFirmwareComponentsSpec();
    if (instance != null) {
        this.withUpdates(instance.getUpdates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UpdatesNested<A> editFirstUpdate() {
    if (updates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "updates"));
    }
    return this.setNewUpdateLike(0, this.buildUpdate(0));
  }
  
  public UpdatesNested<A> editLastUpdate() {
    int index = updates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "updates"));
    }
    return this.setNewUpdateLike(index, this.buildUpdate(index));
  }
  
  public UpdatesNested<A> editMatchingUpdate(Predicate<FirmwareUpdateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < updates.size();i++) {
      if (predicate.test(updates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "updates"));
    }
    return this.setNewUpdateLike(index, this.buildUpdate(index));
  }
  
  public UpdatesNested<A> editUpdate(int index) {
    if (updates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "updates"));
    }
    return this.setNewUpdateLike(index, this.buildUpdate(index));
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
    HostFirmwareComponentsSpecFluent that = (HostFirmwareComponentsSpecFluent) o;
    if (!(Objects.equals(updates, that.updates))) {
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
  
  public boolean hasMatchingUpdate(Predicate<FirmwareUpdateBuilder> predicate) {
      for (FirmwareUpdateBuilder item : updates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUpdates() {
    return this.updates != null && !(this.updates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(updates, additionalProperties);
  }
  
  public A removeAllFromUpdates(Collection<FirmwareUpdate> items) {
    if (this.updates == null) {
      return (A) this;
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").remove(builder);
        this.updates.remove(builder);
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
  
  public A removeFromUpdates(FirmwareUpdate... items) {
    if (this.updates == null) {
      return (A) this;
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").remove(builder);
        this.updates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromUpdates(Predicate<FirmwareUpdateBuilder> predicate) {
    if (updates == null) {
      return (A) this;
    }
    Iterator<FirmwareUpdateBuilder> each = updates.iterator();
    List visitables = _visitables.get("updates");
    while (each.hasNext()) {
        FirmwareUpdateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public UpdatesNested<A> setNewUpdateLike(int index,FirmwareUpdate item) {
    return new UpdatesNested(index, item);
  }
  
  public A setToUpdates(int index,FirmwareUpdate item) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
    if (index < 0 || index >= updates.size()) {
        _visitables.get("updates").add(builder);
        updates.add(builder);
    } else {
        _visitables.get("updates").add(builder);
        updates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(updates == null) && !(updates.isEmpty())) {
        sb.append("updates:");
        sb.append(updates);
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
  
  public A withUpdates(List<FirmwareUpdate> updates) {
    if (this.updates != null) {
      this._visitables.get("updates").clear();
    }
    if (updates != null) {
        this.updates = new ArrayList();
        for (FirmwareUpdate item : updates) {
          this.addToUpdates(item);
        }
    } else {
      this.updates = null;
    }
    return (A) this;
  }
  
  public A withUpdates(FirmwareUpdate... updates) {
    if (this.updates != null) {
        this.updates.clear();
        _visitables.remove("updates");
    }
    if (updates != null) {
      for (FirmwareUpdate item : updates) {
        this.addToUpdates(item);
      }
    }
    return (A) this;
  }
  public class UpdatesNested<N> extends FirmwareUpdateFluent<UpdatesNested<N>> implements Nested<N>{
  
    FirmwareUpdateBuilder builder;
    int index;
  
    UpdatesNested(int index,FirmwareUpdate item) {
      this.index = index;
      this.builder = new FirmwareUpdateBuilder(this, item);
    }
  
    public N and() {
      return (N) HostFirmwareComponentsSpecFluent.this.setToUpdates(index, builder.build());
    }
    
    public N endUpdate() {
      return and();
    }
    
  }
}