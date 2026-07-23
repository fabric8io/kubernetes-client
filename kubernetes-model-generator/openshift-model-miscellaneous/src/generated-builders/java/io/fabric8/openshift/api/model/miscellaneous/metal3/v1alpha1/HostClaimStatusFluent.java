package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HostClaimStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostClaimStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder bareMetalHost;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ObjectReferenceBuilder hardwareData;
  private String lastUpdated;
  private Boolean poweredOn;

  public HostClaimStatusFluent() {
  }
  
  public HostClaimStatusFluent(HostClaimStatus instance) {
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
  
  public ObjectReference buildBareMetalHost() {
    return this.bareMetalHost != null ? this.bareMetalHost.build() : null;
  }
  
  public ObjectReference buildHardwareData() {
    return this.hardwareData != null ? this.hardwareData.build() : null;
  }
  
  protected void copyInstance(HostClaimStatus instance) {
    instance = instance != null ? instance : new HostClaimStatus();
    if (instance != null) {
        this.withBareMetalHost(instance.getBareMetalHost());
        this.withConditions(instance.getConditions());
        this.withHardwareData(instance.getHardwareData());
        this.withLastUpdated(instance.getLastUpdated());
        this.withPoweredOn(instance.getPoweredOn());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BareMetalHostNested<A> editBareMetalHost() {
    return this.withNewBareMetalHostLike(Optional.ofNullable(this.buildBareMetalHost()).orElse(null));
  }
  
  public HardwareDataNested<A> editHardwareData() {
    return this.withNewHardwareDataLike(Optional.ofNullable(this.buildHardwareData()).orElse(null));
  }
  
  public BareMetalHostNested<A> editOrNewBareMetalHost() {
    return this.withNewBareMetalHostLike(Optional.ofNullable(this.buildBareMetalHost()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public BareMetalHostNested<A> editOrNewBareMetalHostLike(ObjectReference item) {
    return this.withNewBareMetalHostLike(Optional.ofNullable(this.buildBareMetalHost()).orElse(item));
  }
  
  public HardwareDataNested<A> editOrNewHardwareData() {
    return this.withNewHardwareDataLike(Optional.ofNullable(this.buildHardwareData()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public HardwareDataNested<A> editOrNewHardwareDataLike(ObjectReference item) {
    return this.withNewHardwareDataLike(Optional.ofNullable(this.buildHardwareData()).orElse(item));
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
    HostClaimStatusFluent that = (HostClaimStatusFluent) o;
    if (!(Objects.equals(bareMetalHost, that.bareMetalHost))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(hardwareData, that.hardwareData))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(poweredOn, that.poweredOn))) {
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
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getPoweredOn() {
    return this.poweredOn;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBareMetalHost() {
    return this.bareMetalHost != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasHardwareData() {
    return this.hardwareData != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPoweredOn() {
    return this.poweredOn != null;
  }
  
  public int hashCode() {
    return Objects.hash(bareMetalHost, conditions, hardwareData, lastUpdated, poweredOn, additionalProperties);
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
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bareMetalHost == null)) {
        sb.append("bareMetalHost:");
        sb.append(bareMetalHost);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(hardwareData == null)) {
        sb.append("hardwareData:");
        sb.append(hardwareData);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(poweredOn == null)) {
        sb.append("poweredOn:");
        sb.append(poweredOn);
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
  
  public A withBareMetalHost(ObjectReference bareMetalHost) {
    this._visitables.remove("bareMetalHost");
    if (bareMetalHost != null) {
        this.bareMetalHost = new ObjectReferenceBuilder(bareMetalHost);
        this._visitables.get("bareMetalHost").add(this.bareMetalHost);
    } else {
        this.bareMetalHost = null;
        this._visitables.get("bareMetalHost").remove(this.bareMetalHost);
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
  
  public A withHardwareData(ObjectReference hardwareData) {
    this._visitables.remove("hardwareData");
    if (hardwareData != null) {
        this.hardwareData = new ObjectReferenceBuilder(hardwareData);
        this._visitables.get("hardwareData").add(this.hardwareData);
    } else {
        this.hardwareData = null;
        this._visitables.get("hardwareData").remove(this.hardwareData);
    }
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public BareMetalHostNested<A> withNewBareMetalHost() {
    return new BareMetalHostNested(null);
  }
  
  public A withNewBareMetalHost(String name,String namespace) {
    return (A) this.withBareMetalHost(new ObjectReference(name, namespace));
  }
  
  public BareMetalHostNested<A> withNewBareMetalHostLike(ObjectReference item) {
    return new BareMetalHostNested(item);
  }
  
  public HardwareDataNested<A> withNewHardwareData() {
    return new HardwareDataNested(null);
  }
  
  public A withNewHardwareData(String name,String namespace) {
    return (A) this.withHardwareData(new ObjectReference(name, namespace));
  }
  
  public HardwareDataNested<A> withNewHardwareDataLike(ObjectReference item) {
    return new HardwareDataNested(item);
  }
  
  public A withPoweredOn() {
    return withPoweredOn(true);
  }
  
  public A withPoweredOn(Boolean poweredOn) {
    this.poweredOn = poweredOn;
    return (A) this;
  }
  public class BareMetalHostNested<N> extends ObjectReferenceFluent<BareMetalHostNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    BareMetalHostNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HostClaimStatusFluent.this.withBareMetalHost(builder.build());
    }
    
    public N endBareMetalHost() {
      return and();
    }
    
  }
  public class HardwareDataNested<N> extends ObjectReferenceFluent<HardwareDataNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    HardwareDataNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HostClaimStatusFluent.this.withHardwareData(builder.build());
    }
    
    public N endHardwareData() {
      return and();
    }
    
  }
}