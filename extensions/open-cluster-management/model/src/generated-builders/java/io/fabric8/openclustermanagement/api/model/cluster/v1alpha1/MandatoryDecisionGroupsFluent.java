package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

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
public class MandatoryDecisionGroupsFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.MandatoryDecisionGroupsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<MandatoryDecisionGroupBuilder> mandatoryDecisionGroups = new ArrayList<MandatoryDecisionGroupBuilder>();

  public MandatoryDecisionGroupsFluent() {
  }
  
  public MandatoryDecisionGroupsFluent(MandatoryDecisionGroups instance) {
    this.copyInstance(instance);
  }

  public A addAllToMandatoryDecisionGroups(Collection<MandatoryDecisionGroup> items) {
    if (this.mandatoryDecisionGroups == null) {
      this.mandatoryDecisionGroups = new ArrayList();
    }
    for (MandatoryDecisionGroup item : items) {
        MandatoryDecisionGroupBuilder builder = new MandatoryDecisionGroupBuilder(item);
        _visitables.get("mandatoryDecisionGroups").add(builder);
        this.mandatoryDecisionGroups.add(builder);
    }
    return (A) this;
  }
  
  public MandatoryDecisionGroupsNested<A> addNewMandatoryDecisionGroup() {
    return new MandatoryDecisionGroupsNested(-1, null);
  }
  
  public A addNewMandatoryDecisionGroup(Integer groupIndex,String groupName) {
    return (A) this.addToMandatoryDecisionGroups(new MandatoryDecisionGroup(groupIndex, groupName));
  }
  
  public MandatoryDecisionGroupsNested<A> addNewMandatoryDecisionGroupLike(MandatoryDecisionGroup item) {
    return new MandatoryDecisionGroupsNested(-1, item);
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
  
  public A addToMandatoryDecisionGroups(MandatoryDecisionGroup... items) {
    if (this.mandatoryDecisionGroups == null) {
      this.mandatoryDecisionGroups = new ArrayList();
    }
    for (MandatoryDecisionGroup item : items) {
        MandatoryDecisionGroupBuilder builder = new MandatoryDecisionGroupBuilder(item);
        _visitables.get("mandatoryDecisionGroups").add(builder);
        this.mandatoryDecisionGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToMandatoryDecisionGroups(int index,MandatoryDecisionGroup item) {
    if (this.mandatoryDecisionGroups == null) {
      this.mandatoryDecisionGroups = new ArrayList();
    }
    MandatoryDecisionGroupBuilder builder = new MandatoryDecisionGroupBuilder(item);
    if (index < 0 || index >= mandatoryDecisionGroups.size()) {
        _visitables.get("mandatoryDecisionGroups").add(builder);
        mandatoryDecisionGroups.add(builder);
    } else {
        _visitables.get("mandatoryDecisionGroups").add(builder);
        mandatoryDecisionGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public MandatoryDecisionGroup buildFirstMandatoryDecisionGroup() {
    return this.mandatoryDecisionGroups.get(0).build();
  }
  
  public MandatoryDecisionGroup buildLastMandatoryDecisionGroup() {
    return this.mandatoryDecisionGroups.get(mandatoryDecisionGroups.size() - 1).build();
  }
  
  public MandatoryDecisionGroup buildMandatoryDecisionGroup(int index) {
    return this.mandatoryDecisionGroups.get(index).build();
  }
  
  public List<MandatoryDecisionGroup> buildMandatoryDecisionGroups() {
    return this.mandatoryDecisionGroups != null ? build(mandatoryDecisionGroups) : null;
  }
  
  public MandatoryDecisionGroup buildMatchingMandatoryDecisionGroup(Predicate<MandatoryDecisionGroupBuilder> predicate) {
      for (MandatoryDecisionGroupBuilder item : mandatoryDecisionGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(MandatoryDecisionGroups instance) {
    instance = instance != null ? instance : new MandatoryDecisionGroups();
    if (instance != null) {
        this.withMandatoryDecisionGroups(instance.getMandatoryDecisionGroups());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MandatoryDecisionGroupsNested<A> editFirstMandatoryDecisionGroup() {
    if (mandatoryDecisionGroups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "mandatoryDecisionGroups"));
    }
    return this.setNewMandatoryDecisionGroupLike(0, this.buildMandatoryDecisionGroup(0));
  }
  
  public MandatoryDecisionGroupsNested<A> editLastMandatoryDecisionGroup() {
    int index = mandatoryDecisionGroups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "mandatoryDecisionGroups"));
    }
    return this.setNewMandatoryDecisionGroupLike(index, this.buildMandatoryDecisionGroup(index));
  }
  
  public MandatoryDecisionGroupsNested<A> editMandatoryDecisionGroup(int index) {
    if (mandatoryDecisionGroups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "mandatoryDecisionGroups"));
    }
    return this.setNewMandatoryDecisionGroupLike(index, this.buildMandatoryDecisionGroup(index));
  }
  
  public MandatoryDecisionGroupsNested<A> editMatchingMandatoryDecisionGroup(Predicate<MandatoryDecisionGroupBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < mandatoryDecisionGroups.size();i++) {
      if (predicate.test(mandatoryDecisionGroups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "mandatoryDecisionGroups"));
    }
    return this.setNewMandatoryDecisionGroupLike(index, this.buildMandatoryDecisionGroup(index));
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
    MandatoryDecisionGroupsFluent that = (MandatoryDecisionGroupsFluent) o;
    if (!(Objects.equals(mandatoryDecisionGroups, that.mandatoryDecisionGroups))) {
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
  
  public boolean hasMandatoryDecisionGroups() {
    return this.mandatoryDecisionGroups != null && !(this.mandatoryDecisionGroups.isEmpty());
  }
  
  public boolean hasMatchingMandatoryDecisionGroup(Predicate<MandatoryDecisionGroupBuilder> predicate) {
      for (MandatoryDecisionGroupBuilder item : mandatoryDecisionGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(mandatoryDecisionGroups, additionalProperties);
  }
  
  public A removeAllFromMandatoryDecisionGroups(Collection<MandatoryDecisionGroup> items) {
    if (this.mandatoryDecisionGroups == null) {
      return (A) this;
    }
    for (MandatoryDecisionGroup item : items) {
        MandatoryDecisionGroupBuilder builder = new MandatoryDecisionGroupBuilder(item);
        _visitables.get("mandatoryDecisionGroups").remove(builder);
        this.mandatoryDecisionGroups.remove(builder);
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
  
  public A removeFromMandatoryDecisionGroups(MandatoryDecisionGroup... items) {
    if (this.mandatoryDecisionGroups == null) {
      return (A) this;
    }
    for (MandatoryDecisionGroup item : items) {
        MandatoryDecisionGroupBuilder builder = new MandatoryDecisionGroupBuilder(item);
        _visitables.get("mandatoryDecisionGroups").remove(builder);
        this.mandatoryDecisionGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMandatoryDecisionGroups(Predicate<MandatoryDecisionGroupBuilder> predicate) {
    if (mandatoryDecisionGroups == null) {
      return (A) this;
    }
    Iterator<MandatoryDecisionGroupBuilder> each = mandatoryDecisionGroups.iterator();
    List visitables = _visitables.get("mandatoryDecisionGroups");
    while (each.hasNext()) {
        MandatoryDecisionGroupBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MandatoryDecisionGroupsNested<A> setNewMandatoryDecisionGroupLike(int index,MandatoryDecisionGroup item) {
    return new MandatoryDecisionGroupsNested(index, item);
  }
  
  public A setToMandatoryDecisionGroups(int index,MandatoryDecisionGroup item) {
    if (this.mandatoryDecisionGroups == null) {
      this.mandatoryDecisionGroups = new ArrayList();
    }
    MandatoryDecisionGroupBuilder builder = new MandatoryDecisionGroupBuilder(item);
    if (index < 0 || index >= mandatoryDecisionGroups.size()) {
        _visitables.get("mandatoryDecisionGroups").add(builder);
        mandatoryDecisionGroups.add(builder);
    } else {
        _visitables.get("mandatoryDecisionGroups").add(builder);
        mandatoryDecisionGroups.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(mandatoryDecisionGroups == null) && !(mandatoryDecisionGroups.isEmpty())) {
        sb.append("mandatoryDecisionGroups:");
        sb.append(mandatoryDecisionGroups);
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
  
  public A withMandatoryDecisionGroups(List<MandatoryDecisionGroup> mandatoryDecisionGroups) {
    if (this.mandatoryDecisionGroups != null) {
      this._visitables.get("mandatoryDecisionGroups").clear();
    }
    if (mandatoryDecisionGroups != null) {
        this.mandatoryDecisionGroups = new ArrayList();
        for (MandatoryDecisionGroup item : mandatoryDecisionGroups) {
          this.addToMandatoryDecisionGroups(item);
        }
    } else {
      this.mandatoryDecisionGroups = null;
    }
    return (A) this;
  }
  
  public A withMandatoryDecisionGroups(MandatoryDecisionGroup... mandatoryDecisionGroups) {
    if (this.mandatoryDecisionGroups != null) {
        this.mandatoryDecisionGroups.clear();
        _visitables.remove("mandatoryDecisionGroups");
    }
    if (mandatoryDecisionGroups != null) {
      for (MandatoryDecisionGroup item : mandatoryDecisionGroups) {
        this.addToMandatoryDecisionGroups(item);
      }
    }
    return (A) this;
  }
  public class MandatoryDecisionGroupsNested<N> extends MandatoryDecisionGroupFluent<MandatoryDecisionGroupsNested<N>> implements Nested<N>{
  
    MandatoryDecisionGroupBuilder builder;
    int index;
  
    MandatoryDecisionGroupsNested(int index,MandatoryDecisionGroup item) {
      this.index = index;
      this.builder = new MandatoryDecisionGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) MandatoryDecisionGroupsFluent.this.setToMandatoryDecisionGroups(index, builder.build());
    }
    
    public N endMandatoryDecisionGroup() {
      return and();
    }
    
  }
}