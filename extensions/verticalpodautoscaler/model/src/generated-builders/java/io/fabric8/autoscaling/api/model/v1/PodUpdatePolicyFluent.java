package io.fabric8.autoscaling.api.model.v1;

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
public class PodUpdatePolicyFluent<A extends io.fabric8.autoscaling.api.model.v1.PodUpdatePolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer evictAfterOOMSeconds;
  private ArrayList<EvictionRequirementBuilder> evictionRequirements = new ArrayList<EvictionRequirementBuilder>();
  private Integer minReplicas;
  private String updateMode;

  public PodUpdatePolicyFluent() {
  }
  
  public PodUpdatePolicyFluent(PodUpdatePolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToEvictionRequirements(Collection<EvictionRequirement> items) {
    if (this.evictionRequirements == null) {
      this.evictionRequirements = new ArrayList();
    }
    for (EvictionRequirement item : items) {
        EvictionRequirementBuilder builder = new EvictionRequirementBuilder(item);
        _visitables.get("evictionRequirements").add(builder);
        this.evictionRequirements.add(builder);
    }
    return (A) this;
  }
  
  public EvictionRequirementsNested<A> addNewEvictionRequirement() {
    return new EvictionRequirementsNested(-1, null);
  }
  
  public EvictionRequirementsNested<A> addNewEvictionRequirementLike(EvictionRequirement item) {
    return new EvictionRequirementsNested(-1, item);
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
  
  public A addToEvictionRequirements(EvictionRequirement... items) {
    if (this.evictionRequirements == null) {
      this.evictionRequirements = new ArrayList();
    }
    for (EvictionRequirement item : items) {
        EvictionRequirementBuilder builder = new EvictionRequirementBuilder(item);
        _visitables.get("evictionRequirements").add(builder);
        this.evictionRequirements.add(builder);
    }
    return (A) this;
  }
  
  public A addToEvictionRequirements(int index,EvictionRequirement item) {
    if (this.evictionRequirements == null) {
      this.evictionRequirements = new ArrayList();
    }
    EvictionRequirementBuilder builder = new EvictionRequirementBuilder(item);
    if (index < 0 || index >= evictionRequirements.size()) {
        _visitables.get("evictionRequirements").add(builder);
        evictionRequirements.add(builder);
    } else {
        _visitables.get("evictionRequirements").add(builder);
        evictionRequirements.add(index, builder);
    }
    return (A) this;
  }
  
  public EvictionRequirement buildEvictionRequirement(int index) {
    return this.evictionRequirements.get(index).build();
  }
  
  public List<EvictionRequirement> buildEvictionRequirements() {
    return this.evictionRequirements != null ? build(evictionRequirements) : null;
  }
  
  public EvictionRequirement buildFirstEvictionRequirement() {
    return this.evictionRequirements.get(0).build();
  }
  
  public EvictionRequirement buildLastEvictionRequirement() {
    return this.evictionRequirements.get(evictionRequirements.size() - 1).build();
  }
  
  public EvictionRequirement buildMatchingEvictionRequirement(Predicate<EvictionRequirementBuilder> predicate) {
      for (EvictionRequirementBuilder item : evictionRequirements) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PodUpdatePolicy instance) {
    instance = instance != null ? instance : new PodUpdatePolicy();
    if (instance != null) {
        this.withEvictAfterOOMSeconds(instance.getEvictAfterOOMSeconds());
        this.withEvictionRequirements(instance.getEvictionRequirements());
        this.withMinReplicas(instance.getMinReplicas());
        this.withUpdateMode(instance.getUpdateMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EvictionRequirementsNested<A> editEvictionRequirement(int index) {
    if (evictionRequirements.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "evictionRequirements"));
    }
    return this.setNewEvictionRequirementLike(index, this.buildEvictionRequirement(index));
  }
  
  public EvictionRequirementsNested<A> editFirstEvictionRequirement() {
    if (evictionRequirements.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "evictionRequirements"));
    }
    return this.setNewEvictionRequirementLike(0, this.buildEvictionRequirement(0));
  }
  
  public EvictionRequirementsNested<A> editLastEvictionRequirement() {
    int index = evictionRequirements.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "evictionRequirements"));
    }
    return this.setNewEvictionRequirementLike(index, this.buildEvictionRequirement(index));
  }
  
  public EvictionRequirementsNested<A> editMatchingEvictionRequirement(Predicate<EvictionRequirementBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < evictionRequirements.size();i++) {
      if (predicate.test(evictionRequirements.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "evictionRequirements"));
    }
    return this.setNewEvictionRequirementLike(index, this.buildEvictionRequirement(index));
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
    PodUpdatePolicyFluent that = (PodUpdatePolicyFluent) o;
    if (!(Objects.equals(evictAfterOOMSeconds, that.evictAfterOOMSeconds))) {
      return false;
    }
    if (!(Objects.equals(evictionRequirements, that.evictionRequirements))) {
      return false;
    }
    if (!(Objects.equals(minReplicas, that.minReplicas))) {
      return false;
    }
    if (!(Objects.equals(updateMode, that.updateMode))) {
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
  
  public Integer getEvictAfterOOMSeconds() {
    return this.evictAfterOOMSeconds;
  }
  
  public Integer getMinReplicas() {
    return this.minReplicas;
  }
  
  public String getUpdateMode() {
    return this.updateMode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEvictAfterOOMSeconds() {
    return this.evictAfterOOMSeconds != null;
  }
  
  public boolean hasEvictionRequirements() {
    return this.evictionRequirements != null && !(this.evictionRequirements.isEmpty());
  }
  
  public boolean hasMatchingEvictionRequirement(Predicate<EvictionRequirementBuilder> predicate) {
      for (EvictionRequirementBuilder item : evictionRequirements) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinReplicas() {
    return this.minReplicas != null;
  }
  
  public boolean hasUpdateMode() {
    return this.updateMode != null;
  }
  
  public int hashCode() {
    return Objects.hash(evictAfterOOMSeconds, evictionRequirements, minReplicas, updateMode, additionalProperties);
  }
  
  public A removeAllFromEvictionRequirements(Collection<EvictionRequirement> items) {
    if (this.evictionRequirements == null) {
      return (A) this;
    }
    for (EvictionRequirement item : items) {
        EvictionRequirementBuilder builder = new EvictionRequirementBuilder(item);
        _visitables.get("evictionRequirements").remove(builder);
        this.evictionRequirements.remove(builder);
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
  
  public A removeFromEvictionRequirements(EvictionRequirement... items) {
    if (this.evictionRequirements == null) {
      return (A) this;
    }
    for (EvictionRequirement item : items) {
        EvictionRequirementBuilder builder = new EvictionRequirementBuilder(item);
        _visitables.get("evictionRequirements").remove(builder);
        this.evictionRequirements.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEvictionRequirements(Predicate<EvictionRequirementBuilder> predicate) {
    if (evictionRequirements == null) {
      return (A) this;
    }
    Iterator<EvictionRequirementBuilder> each = evictionRequirements.iterator();
    List visitables = _visitables.get("evictionRequirements");
    while (each.hasNext()) {
        EvictionRequirementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EvictionRequirementsNested<A> setNewEvictionRequirementLike(int index,EvictionRequirement item) {
    return new EvictionRequirementsNested(index, item);
  }
  
  public A setToEvictionRequirements(int index,EvictionRequirement item) {
    if (this.evictionRequirements == null) {
      this.evictionRequirements = new ArrayList();
    }
    EvictionRequirementBuilder builder = new EvictionRequirementBuilder(item);
    if (index < 0 || index >= evictionRequirements.size()) {
        _visitables.get("evictionRequirements").add(builder);
        evictionRequirements.add(builder);
    } else {
        _visitables.get("evictionRequirements").add(builder);
        evictionRequirements.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(evictAfterOOMSeconds == null)) {
        sb.append("evictAfterOOMSeconds:");
        sb.append(evictAfterOOMSeconds);
        sb.append(",");
    }
    if (!(evictionRequirements == null) && !(evictionRequirements.isEmpty())) {
        sb.append("evictionRequirements:");
        sb.append(evictionRequirements);
        sb.append(",");
    }
    if (!(minReplicas == null)) {
        sb.append("minReplicas:");
        sb.append(minReplicas);
        sb.append(",");
    }
    if (!(updateMode == null)) {
        sb.append("updateMode:");
        sb.append(updateMode);
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
  
  public A withEvictAfterOOMSeconds(Integer evictAfterOOMSeconds) {
    this.evictAfterOOMSeconds = evictAfterOOMSeconds;
    return (A) this;
  }
  
  public A withEvictionRequirements(List<EvictionRequirement> evictionRequirements) {
    if (this.evictionRequirements != null) {
      this._visitables.get("evictionRequirements").clear();
    }
    if (evictionRequirements != null) {
        this.evictionRequirements = new ArrayList();
        for (EvictionRequirement item : evictionRequirements) {
          this.addToEvictionRequirements(item);
        }
    } else {
      this.evictionRequirements = null;
    }
    return (A) this;
  }
  
  public A withEvictionRequirements(EvictionRequirement... evictionRequirements) {
    if (this.evictionRequirements != null) {
        this.evictionRequirements.clear();
        _visitables.remove("evictionRequirements");
    }
    if (evictionRequirements != null) {
      for (EvictionRequirement item : evictionRequirements) {
        this.addToEvictionRequirements(item);
      }
    }
    return (A) this;
  }
  
  public A withMinReplicas(Integer minReplicas) {
    this.minReplicas = minReplicas;
    return (A) this;
  }
  
  public A withUpdateMode(String updateMode) {
    this.updateMode = updateMode;
    return (A) this;
  }
  public class EvictionRequirementsNested<N> extends EvictionRequirementFluent<EvictionRequirementsNested<N>> implements Nested<N>{
  
    EvictionRequirementBuilder builder;
    int index;
  
    EvictionRequirementsNested(int index,EvictionRequirement item) {
      this.index = index;
      this.builder = new EvictionRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) PodUpdatePolicyFluent.this.setToEvictionRequirements(index, builder.build());
    }
    
    public N endEvictionRequirement() {
      return and();
    }
    
  }
}