package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
public class PolicySetStatusFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicySetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String compliant;
  private ArrayList<PolicySetStatusPlacementBuilder> placement = new ArrayList<PolicySetStatusPlacementBuilder>();
  private String statusMessage;

  public PolicySetStatusFluent() {
  }
  
  public PolicySetStatusFluent(PolicySetStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToPlacement(Collection<PolicySetStatusPlacement> items) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    for (PolicySetStatusPlacement item : items) {
        PolicySetStatusPlacementBuilder builder = new PolicySetStatusPlacementBuilder(item);
        _visitables.get("placement").add(builder);
        this.placement.add(builder);
    }
    return (A) this;
  }
  
  public PlacementNested<A> addNewPlacement() {
    return new PlacementNested(-1, null);
  }
  
  public A addNewPlacement(String placement,String placementBinding,String placementRule) {
    return (A) this.addToPlacement(new PolicySetStatusPlacement(placement, placementBinding, placementRule));
  }
  
  public PlacementNested<A> addNewPlacementLike(PolicySetStatusPlacement item) {
    return new PlacementNested(-1, item);
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
  
  public A addToPlacement(PolicySetStatusPlacement... items) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    for (PolicySetStatusPlacement item : items) {
        PolicySetStatusPlacementBuilder builder = new PolicySetStatusPlacementBuilder(item);
        _visitables.get("placement").add(builder);
        this.placement.add(builder);
    }
    return (A) this;
  }
  
  public A addToPlacement(int index,PolicySetStatusPlacement item) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    PolicySetStatusPlacementBuilder builder = new PolicySetStatusPlacementBuilder(item);
    if (index < 0 || index >= placement.size()) {
        _visitables.get("placement").add(builder);
        placement.add(builder);
    } else {
        _visitables.get("placement").add(builder);
        placement.add(index, builder);
    }
    return (A) this;
  }
  
  public PolicySetStatusPlacement buildFirstPlacement() {
    return this.placement.get(0).build();
  }
  
  public PolicySetStatusPlacement buildLastPlacement() {
    return this.placement.get(placement.size() - 1).build();
  }
  
  public PolicySetStatusPlacement buildMatchingPlacement(Predicate<PolicySetStatusPlacementBuilder> predicate) {
      for (PolicySetStatusPlacementBuilder item : placement) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<PolicySetStatusPlacement> buildPlacement() {
    return this.placement != null ? build(placement) : null;
  }
  
  public PolicySetStatusPlacement buildPlacement(int index) {
    return this.placement.get(index).build();
  }
  
  protected void copyInstance(PolicySetStatus instance) {
    instance = instance != null ? instance : new PolicySetStatus();
    if (instance != null) {
        this.withCompliant(instance.getCompliant());
        this.withPlacement(instance.getPlacement());
        this.withStatusMessage(instance.getStatusMessage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PlacementNested<A> editFirstPlacement() {
    if (placement.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "placement"));
    }
    return this.setNewPlacementLike(0, this.buildPlacement(0));
  }
  
  public PlacementNested<A> editLastPlacement() {
    int index = placement.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "placement"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
  }
  
  public PlacementNested<A> editMatchingPlacement(Predicate<PolicySetStatusPlacementBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < placement.size();i++) {
      if (predicate.test(placement.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "placement"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
  }
  
  public PlacementNested<A> editPlacement(int index) {
    if (placement.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "placement"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
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
    PolicySetStatusFluent that = (PolicySetStatusFluent) o;
    if (!(Objects.equals(compliant, that.compliant))) {
      return false;
    }
    if (!(Objects.equals(placement, that.placement))) {
      return false;
    }
    if (!(Objects.equals(statusMessage, that.statusMessage))) {
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
  
  public String getCompliant() {
    return this.compliant;
  }
  
  public String getStatusMessage() {
    return this.statusMessage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompliant() {
    return this.compliant != null;
  }
  
  public boolean hasMatchingPlacement(Predicate<PolicySetStatusPlacementBuilder> predicate) {
      for (PolicySetStatusPlacementBuilder item : placement) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPlacement() {
    return this.placement != null && !(this.placement.isEmpty());
  }
  
  public boolean hasStatusMessage() {
    return this.statusMessage != null;
  }
  
  public int hashCode() {
    return Objects.hash(compliant, placement, statusMessage, additionalProperties);
  }
  
  public A removeAllFromPlacement(Collection<PolicySetStatusPlacement> items) {
    if (this.placement == null) {
      return (A) this;
    }
    for (PolicySetStatusPlacement item : items) {
        PolicySetStatusPlacementBuilder builder = new PolicySetStatusPlacementBuilder(item);
        _visitables.get("placement").remove(builder);
        this.placement.remove(builder);
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
  
  public A removeFromPlacement(PolicySetStatusPlacement... items) {
    if (this.placement == null) {
      return (A) this;
    }
    for (PolicySetStatusPlacement item : items) {
        PolicySetStatusPlacementBuilder builder = new PolicySetStatusPlacementBuilder(item);
        _visitables.get("placement").remove(builder);
        this.placement.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPlacement(Predicate<PolicySetStatusPlacementBuilder> predicate) {
    if (placement == null) {
      return (A) this;
    }
    Iterator<PolicySetStatusPlacementBuilder> each = placement.iterator();
    List visitables = _visitables.get("placement");
    while (each.hasNext()) {
        PolicySetStatusPlacementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PlacementNested<A> setNewPlacementLike(int index,PolicySetStatusPlacement item) {
    return new PlacementNested(index, item);
  }
  
  public A setToPlacement(int index,PolicySetStatusPlacement item) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    PolicySetStatusPlacementBuilder builder = new PolicySetStatusPlacementBuilder(item);
    if (index < 0 || index >= placement.size()) {
        _visitables.get("placement").add(builder);
        placement.add(builder);
    } else {
        _visitables.get("placement").add(builder);
        placement.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(compliant == null)) {
        sb.append("compliant:");
        sb.append(compliant);
        sb.append(",");
    }
    if (!(placement == null) && !(placement.isEmpty())) {
        sb.append("placement:");
        sb.append(placement);
        sb.append(",");
    }
    if (!(statusMessage == null)) {
        sb.append("statusMessage:");
        sb.append(statusMessage);
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
  
  public A withCompliant(String compliant) {
    this.compliant = compliant;
    return (A) this;
  }
  
  public A withPlacement(List<PolicySetStatusPlacement> placement) {
    if (this.placement != null) {
      this._visitables.get("placement").clear();
    }
    if (placement != null) {
        this.placement = new ArrayList();
        for (PolicySetStatusPlacement item : placement) {
          this.addToPlacement(item);
        }
    } else {
      this.placement = null;
    }
    return (A) this;
  }
  
  public A withPlacement(PolicySetStatusPlacement... placement) {
    if (this.placement != null) {
        this.placement.clear();
        _visitables.remove("placement");
    }
    if (placement != null) {
      for (PolicySetStatusPlacement item : placement) {
        this.addToPlacement(item);
      }
    }
    return (A) this;
  }
  
  public A withStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
    return (A) this;
  }
  public class PlacementNested<N> extends PolicySetStatusPlacementFluent<PlacementNested<N>> implements Nested<N>{
  
    PolicySetStatusPlacementBuilder builder;
    int index;
  
    PlacementNested(int index,PolicySetStatusPlacement item) {
      this.index = index;
      this.builder = new PolicySetStatusPlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicySetStatusFluent.this.setToPlacement(index, builder.build());
    }
    
    public N endPlacement() {
      return and();
    }
    
  }
}