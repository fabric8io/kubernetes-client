package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class GatewayClassStatusFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClassStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<SupportedFeatureBuilder> supportedFeatures = new ArrayList<SupportedFeatureBuilder>();

  public GatewayClassStatusFluent() {
  }
  
  public GatewayClassStatusFluent(GatewayClassStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSupportedFeatures(Collection<SupportedFeature> items) {
    if (this.supportedFeatures == null) {
      this.supportedFeatures = new ArrayList();
    }
    for (SupportedFeature item : items) {
        SupportedFeatureBuilder builder = new SupportedFeatureBuilder(item);
        _visitables.get("supportedFeatures").add(builder);
        this.supportedFeatures.add(builder);
    }
    return (A) this;
  }
  
  public SupportedFeaturesNested<A> addNewSupportedFeature() {
    return new SupportedFeaturesNested(-1, null);
  }
  
  public A addNewSupportedFeature(String name) {
    return (A) this.addToSupportedFeatures(new SupportedFeature(name));
  }
  
  public SupportedFeaturesNested<A> addNewSupportedFeatureLike(SupportedFeature item) {
    return new SupportedFeaturesNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToSupportedFeatures(SupportedFeature... items) {
    if (this.supportedFeatures == null) {
      this.supportedFeatures = new ArrayList();
    }
    for (SupportedFeature item : items) {
        SupportedFeatureBuilder builder = new SupportedFeatureBuilder(item);
        _visitables.get("supportedFeatures").add(builder);
        this.supportedFeatures.add(builder);
    }
    return (A) this;
  }
  
  public A addToSupportedFeatures(int index,SupportedFeature item) {
    if (this.supportedFeatures == null) {
      this.supportedFeatures = new ArrayList();
    }
    SupportedFeatureBuilder builder = new SupportedFeatureBuilder(item);
    if (index < 0 || index >= supportedFeatures.size()) {
        _visitables.get("supportedFeatures").add(builder);
        supportedFeatures.add(builder);
    } else {
        _visitables.get("supportedFeatures").add(builder);
        supportedFeatures.add(index, builder);
    }
    return (A) this;
  }
  
  public SupportedFeature buildFirstSupportedFeature() {
    return this.supportedFeatures.get(0).build();
  }
  
  public SupportedFeature buildLastSupportedFeature() {
    return this.supportedFeatures.get(supportedFeatures.size() - 1).build();
  }
  
  public SupportedFeature buildMatchingSupportedFeature(Predicate<SupportedFeatureBuilder> predicate) {
      for (SupportedFeatureBuilder item : supportedFeatures) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SupportedFeature buildSupportedFeature(int index) {
    return this.supportedFeatures.get(index).build();
  }
  
  public List<SupportedFeature> buildSupportedFeatures() {
    return this.supportedFeatures != null ? build(supportedFeatures) : null;
  }
  
  protected void copyInstance(GatewayClassStatus instance) {
    instance = instance != null ? instance : new GatewayClassStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withSupportedFeatures(instance.getSupportedFeatures());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SupportedFeaturesNested<A> editFirstSupportedFeature() {
    if (supportedFeatures.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "supportedFeatures"));
    }
    return this.setNewSupportedFeatureLike(0, this.buildSupportedFeature(0));
  }
  
  public SupportedFeaturesNested<A> editLastSupportedFeature() {
    int index = supportedFeatures.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "supportedFeatures"));
    }
    return this.setNewSupportedFeatureLike(index, this.buildSupportedFeature(index));
  }
  
  public SupportedFeaturesNested<A> editMatchingSupportedFeature(Predicate<SupportedFeatureBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < supportedFeatures.size();i++) {
      if (predicate.test(supportedFeatures.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "supportedFeatures"));
    }
    return this.setNewSupportedFeatureLike(index, this.buildSupportedFeature(index));
  }
  
  public SupportedFeaturesNested<A> editSupportedFeature(int index) {
    if (supportedFeatures.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "supportedFeatures"));
    }
    return this.setNewSupportedFeatureLike(index, this.buildSupportedFeature(index));
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
    GatewayClassStatusFluent that = (GatewayClassStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(supportedFeatures, that.supportedFeatures))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSupportedFeature(Predicate<SupportedFeatureBuilder> predicate) {
      for (SupportedFeatureBuilder item : supportedFeatures) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSupportedFeatures() {
    return this.supportedFeatures != null && !(this.supportedFeatures.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, supportedFeatures, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSupportedFeatures(Collection<SupportedFeature> items) {
    if (this.supportedFeatures == null) {
      return (A) this;
    }
    for (SupportedFeature item : items) {
        SupportedFeatureBuilder builder = new SupportedFeatureBuilder(item);
        _visitables.get("supportedFeatures").remove(builder);
        this.supportedFeatures.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSupportedFeatures(SupportedFeature... items) {
    if (this.supportedFeatures == null) {
      return (A) this;
    }
    for (SupportedFeature item : items) {
        SupportedFeatureBuilder builder = new SupportedFeatureBuilder(item);
        _visitables.get("supportedFeatures").remove(builder);
        this.supportedFeatures.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSupportedFeatures(Predicate<SupportedFeatureBuilder> predicate) {
    if (supportedFeatures == null) {
      return (A) this;
    }
    Iterator<SupportedFeatureBuilder> each = supportedFeatures.iterator();
    List visitables = _visitables.get("supportedFeatures");
    while (each.hasNext()) {
        SupportedFeatureBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SupportedFeaturesNested<A> setNewSupportedFeatureLike(int index,SupportedFeature item) {
    return new SupportedFeaturesNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToSupportedFeatures(int index,SupportedFeature item) {
    if (this.supportedFeatures == null) {
      this.supportedFeatures = new ArrayList();
    }
    SupportedFeatureBuilder builder = new SupportedFeatureBuilder(item);
    if (index < 0 || index >= supportedFeatures.size()) {
        _visitables.get("supportedFeatures").add(builder);
        supportedFeatures.add(builder);
    } else {
        _visitables.get("supportedFeatures").add(builder);
        supportedFeatures.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(supportedFeatures == null) && !(supportedFeatures.isEmpty())) {
        sb.append("supportedFeatures:");
        sb.append(supportedFeatures);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withSupportedFeatures(List<SupportedFeature> supportedFeatures) {
    if (this.supportedFeatures != null) {
      this._visitables.get("supportedFeatures").clear();
    }
    if (supportedFeatures != null) {
        this.supportedFeatures = new ArrayList();
        for (SupportedFeature item : supportedFeatures) {
          this.addToSupportedFeatures(item);
        }
    } else {
      this.supportedFeatures = null;
    }
    return (A) this;
  }
  
  public A withSupportedFeatures(SupportedFeature... supportedFeatures) {
    if (this.supportedFeatures != null) {
        this.supportedFeatures.clear();
        _visitables.remove("supportedFeatures");
    }
    if (supportedFeatures != null) {
      for (SupportedFeature item : supportedFeatures) {
        this.addToSupportedFeatures(item);
      }
    }
    return (A) this;
  }
  public class SupportedFeaturesNested<N> extends SupportedFeatureFluent<SupportedFeaturesNested<N>> implements Nested<N>{
  
    SupportedFeatureBuilder builder;
    int index;
  
    SupportedFeaturesNested(int index,SupportedFeature item) {
      this.index = index;
      this.builder = new SupportedFeatureBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayClassStatusFluent.this.setToSupportedFeatures(index, builder.build());
    }
    
    public N endSupportedFeature() {
      return and();
    }
    
  }
}