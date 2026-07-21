package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class PlacementConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.PlacementConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FeatureGateBuilder> featureGates = new ArrayList<FeatureGateBuilder>();

  public PlacementConfigurationFluent() {
  }
  
  public PlacementConfigurationFluent(PlacementConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToFeatureGates(Collection<FeatureGate> items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> addNewFeatureGate() {
    return new FeatureGatesNested(-1, null);
  }
  
  public A addNewFeatureGate(String feature,String mode) {
    return (A) this.addToFeatureGates(new FeatureGate(feature, mode));
  }
  
  public FeatureGatesNested<A> addNewFeatureGateLike(FeatureGate item) {
    return new FeatureGatesNested(-1, item);
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
  
  public A addToFeatureGates(FeatureGate... items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToFeatureGates(int index,FeatureGate item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateBuilder builder = new FeatureGateBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.add(index, builder);
    }
    return (A) this;
  }
  
  public FeatureGate buildFeatureGate(int index) {
    return this.featureGates.get(index).build();
  }
  
  public List<FeatureGate> buildFeatureGates() {
    return this.featureGates != null ? build(featureGates) : null;
  }
  
  public FeatureGate buildFirstFeatureGate() {
    return this.featureGates.get(0).build();
  }
  
  public FeatureGate buildLastFeatureGate() {
    return this.featureGates.get(featureGates.size() - 1).build();
  }
  
  public FeatureGate buildMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
      for (FeatureGateBuilder item : featureGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PlacementConfiguration instance) {
    instance = instance != null ? instance : new PlacementConfiguration();
    if (instance != null) {
        this.withFeatureGates(instance.getFeatureGates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FeatureGatesNested<A> editFeatureGate(int index) {
    if (featureGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public FeatureGatesNested<A> editFirstFeatureGate() {
    if (featureGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(0, this.buildFeatureGate(0));
  }
  
  public FeatureGatesNested<A> editLastFeatureGate() {
    int index = featureGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public FeatureGatesNested<A> editMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < featureGates.size();i++) {
      if (predicate.test(featureGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
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
    PlacementConfigurationFluent that = (PlacementConfigurationFluent) o;
    if (!(Objects.equals(featureGates, that.featureGates))) {
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
  
  public boolean hasFeatureGates() {
    return this.featureGates != null && !(this.featureGates.isEmpty());
  }
  
  public boolean hasMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
      for (FeatureGateBuilder item : featureGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(featureGates, additionalProperties);
  }
  
  public A removeAllFromFeatureGates(Collection<FeatureGate> items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
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
  
  public A removeFromFeatureGates(FeatureGate... items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFeatureGates(Predicate<FeatureGateBuilder> predicate) {
    if (featureGates == null) {
      return (A) this;
    }
    Iterator<FeatureGateBuilder> each = featureGates.iterator();
    List visitables = _visitables.get("featureGates");
    while (each.hasNext()) {
        FeatureGateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> setNewFeatureGateLike(int index,FeatureGate item) {
    return new FeatureGatesNested(index, item);
  }
  
  public A setToFeatureGates(int index,FeatureGate item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateBuilder builder = new FeatureGateBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(featureGates == null) && !(featureGates.isEmpty())) {
        sb.append("featureGates:");
        sb.append(featureGates);
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
  
  public A withFeatureGates(List<FeatureGate> featureGates) {
    if (this.featureGates != null) {
      this._visitables.get("featureGates").clear();
    }
    if (featureGates != null) {
        this.featureGates = new ArrayList();
        for (FeatureGate item : featureGates) {
          this.addToFeatureGates(item);
        }
    } else {
      this.featureGates = null;
    }
    return (A) this;
  }
  
  public A withFeatureGates(FeatureGate... featureGates) {
    if (this.featureGates != null) {
        this.featureGates.clear();
        _visitables.remove("featureGates");
    }
    if (featureGates != null) {
      for (FeatureGate item : featureGates) {
        this.addToFeatureGates(item);
      }
    }
    return (A) this;
  }
  public class FeatureGatesNested<N> extends FeatureGateFluent<FeatureGatesNested<N>> implements Nested<N>{
  
    FeatureGateBuilder builder;
    int index;
  
    FeatureGatesNested(int index,FeatureGate item) {
      this.index = index;
      this.builder = new FeatureGateBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementConfigurationFluent.this.setToFeatureGates(index, builder.build());
    }
    
    public N endFeatureGate() {
      return and();
    }
    
  }
}