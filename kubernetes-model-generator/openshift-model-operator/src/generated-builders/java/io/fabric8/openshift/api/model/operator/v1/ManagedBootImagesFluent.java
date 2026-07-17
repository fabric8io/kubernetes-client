package io.fabric8.openshift.api.model.operator.v1;

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
public class ManagedBootImagesFluent<A extends io.fabric8.openshift.api.model.operator.v1.ManagedBootImagesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<MachineManagerBuilder> machineManagers = new ArrayList<MachineManagerBuilder>();

  public ManagedBootImagesFluent() {
  }
  
  public ManagedBootImagesFluent(ManagedBootImages instance) {
    this.copyInstance(instance);
  }

  public A addAllToMachineManagers(Collection<MachineManager> items) {
    if (this.machineManagers == null) {
      this.machineManagers = new ArrayList();
    }
    for (MachineManager item : items) {
        MachineManagerBuilder builder = new MachineManagerBuilder(item);
        _visitables.get("machineManagers").add(builder);
        this.machineManagers.add(builder);
    }
    return (A) this;
  }
  
  public MachineManagersNested<A> addNewMachineManager() {
    return new MachineManagersNested(-1, null);
  }
  
  public MachineManagersNested<A> addNewMachineManagerLike(MachineManager item) {
    return new MachineManagersNested(-1, item);
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
  
  public A addToMachineManagers(MachineManager... items) {
    if (this.machineManagers == null) {
      this.machineManagers = new ArrayList();
    }
    for (MachineManager item : items) {
        MachineManagerBuilder builder = new MachineManagerBuilder(item);
        _visitables.get("machineManagers").add(builder);
        this.machineManagers.add(builder);
    }
    return (A) this;
  }
  
  public A addToMachineManagers(int index,MachineManager item) {
    if (this.machineManagers == null) {
      this.machineManagers = new ArrayList();
    }
    MachineManagerBuilder builder = new MachineManagerBuilder(item);
    if (index < 0 || index >= machineManagers.size()) {
        _visitables.get("machineManagers").add(builder);
        machineManagers.add(builder);
    } else {
        _visitables.get("machineManagers").add(builder);
        machineManagers.add(index, builder);
    }
    return (A) this;
  }
  
  public MachineManager buildFirstMachineManager() {
    return this.machineManagers.get(0).build();
  }
  
  public MachineManager buildLastMachineManager() {
    return this.machineManagers.get(machineManagers.size() - 1).build();
  }
  
  public MachineManager buildMachineManager(int index) {
    return this.machineManagers.get(index).build();
  }
  
  public List<MachineManager> buildMachineManagers() {
    return this.machineManagers != null ? build(machineManagers) : null;
  }
  
  public MachineManager buildMatchingMachineManager(Predicate<MachineManagerBuilder> predicate) {
      for (MachineManagerBuilder item : machineManagers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ManagedBootImages instance) {
    instance = instance != null ? instance : new ManagedBootImages();
    if (instance != null) {
        this.withMachineManagers(instance.getMachineManagers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MachineManagersNested<A> editFirstMachineManager() {
    if (machineManagers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "machineManagers"));
    }
    return this.setNewMachineManagerLike(0, this.buildMachineManager(0));
  }
  
  public MachineManagersNested<A> editLastMachineManager() {
    int index = machineManagers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "machineManagers"));
    }
    return this.setNewMachineManagerLike(index, this.buildMachineManager(index));
  }
  
  public MachineManagersNested<A> editMachineManager(int index) {
    if (machineManagers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "machineManagers"));
    }
    return this.setNewMachineManagerLike(index, this.buildMachineManager(index));
  }
  
  public MachineManagersNested<A> editMatchingMachineManager(Predicate<MachineManagerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < machineManagers.size();i++) {
      if (predicate.test(machineManagers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "machineManagers"));
    }
    return this.setNewMachineManagerLike(index, this.buildMachineManager(index));
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
    ManagedBootImagesFluent that = (ManagedBootImagesFluent) o;
    if (!(Objects.equals(machineManagers, that.machineManagers))) {
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
  
  public boolean hasMachineManagers() {
    return this.machineManagers != null && !(this.machineManagers.isEmpty());
  }
  
  public boolean hasMatchingMachineManager(Predicate<MachineManagerBuilder> predicate) {
      for (MachineManagerBuilder item : machineManagers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(machineManagers, additionalProperties);
  }
  
  public A removeAllFromMachineManagers(Collection<MachineManager> items) {
    if (this.machineManagers == null) {
      return (A) this;
    }
    for (MachineManager item : items) {
        MachineManagerBuilder builder = new MachineManagerBuilder(item);
        _visitables.get("machineManagers").remove(builder);
        this.machineManagers.remove(builder);
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
  
  public A removeFromMachineManagers(MachineManager... items) {
    if (this.machineManagers == null) {
      return (A) this;
    }
    for (MachineManager item : items) {
        MachineManagerBuilder builder = new MachineManagerBuilder(item);
        _visitables.get("machineManagers").remove(builder);
        this.machineManagers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMachineManagers(Predicate<MachineManagerBuilder> predicate) {
    if (machineManagers == null) {
      return (A) this;
    }
    Iterator<MachineManagerBuilder> each = machineManagers.iterator();
    List visitables = _visitables.get("machineManagers");
    while (each.hasNext()) {
        MachineManagerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MachineManagersNested<A> setNewMachineManagerLike(int index,MachineManager item) {
    return new MachineManagersNested(index, item);
  }
  
  public A setToMachineManagers(int index,MachineManager item) {
    if (this.machineManagers == null) {
      this.machineManagers = new ArrayList();
    }
    MachineManagerBuilder builder = new MachineManagerBuilder(item);
    if (index < 0 || index >= machineManagers.size()) {
        _visitables.get("machineManagers").add(builder);
        machineManagers.add(builder);
    } else {
        _visitables.get("machineManagers").add(builder);
        machineManagers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(machineManagers == null) && !(machineManagers.isEmpty())) {
        sb.append("machineManagers:");
        sb.append(machineManagers);
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
  
  public A withMachineManagers(List<MachineManager> machineManagers) {
    if (this.machineManagers != null) {
      this._visitables.get("machineManagers").clear();
    }
    if (machineManagers != null) {
        this.machineManagers = new ArrayList();
        for (MachineManager item : machineManagers) {
          this.addToMachineManagers(item);
        }
    } else {
      this.machineManagers = null;
    }
    return (A) this;
  }
  
  public A withMachineManagers(MachineManager... machineManagers) {
    if (this.machineManagers != null) {
        this.machineManagers.clear();
        _visitables.remove("machineManagers");
    }
    if (machineManagers != null) {
      for (MachineManager item : machineManagers) {
        this.addToMachineManagers(item);
      }
    }
    return (A) this;
  }
  public class MachineManagersNested<N> extends MachineManagerFluent<MachineManagersNested<N>> implements Nested<N>{
  
    MachineManagerBuilder builder;
    int index;
  
    MachineManagersNested(int index,MachineManager item) {
      this.index = index;
      this.builder = new MachineManagerBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedBootImagesFluent.this.setToMachineManagers(index, builder.build());
    }
    
    public N endMachineManager() {
      return and();
    }
    
  }
}