package io.fabric8.openclustermanagement.api.model.policy.v1;

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
public class CompliancePerClusterStatusFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.CompliancePerClusterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clustername;
  private String clusternamespace;
  private String compliant;
  private ArrayList<RemainingBindingBuilder> remainingBindings = new ArrayList<RemainingBindingBuilder>();

  public CompliancePerClusterStatusFluent() {
  }
  
  public CompliancePerClusterStatusFluent(CompliancePerClusterStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToRemainingBindings(Collection<RemainingBinding> items) {
    if (this.remainingBindings == null) {
      this.remainingBindings = new ArrayList();
    }
    for (RemainingBinding item : items) {
        RemainingBindingBuilder builder = new RemainingBindingBuilder(item);
        _visitables.get("remainingBindings").add(builder);
        this.remainingBindings.add(builder);
    }
    return (A) this;
  }
  
  public RemainingBindingsNested<A> addNewRemainingBinding() {
    return new RemainingBindingsNested(-1, null);
  }
  
  public A addNewRemainingBinding(String placementBinding) {
    return (A) this.addToRemainingBindings(new RemainingBinding(placementBinding));
  }
  
  public RemainingBindingsNested<A> addNewRemainingBindingLike(RemainingBinding item) {
    return new RemainingBindingsNested(-1, item);
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
  
  public A addToRemainingBindings(RemainingBinding... items) {
    if (this.remainingBindings == null) {
      this.remainingBindings = new ArrayList();
    }
    for (RemainingBinding item : items) {
        RemainingBindingBuilder builder = new RemainingBindingBuilder(item);
        _visitables.get("remainingBindings").add(builder);
        this.remainingBindings.add(builder);
    }
    return (A) this;
  }
  
  public A addToRemainingBindings(int index,RemainingBinding item) {
    if (this.remainingBindings == null) {
      this.remainingBindings = new ArrayList();
    }
    RemainingBindingBuilder builder = new RemainingBindingBuilder(item);
    if (index < 0 || index >= remainingBindings.size()) {
        _visitables.get("remainingBindings").add(builder);
        remainingBindings.add(builder);
    } else {
        _visitables.get("remainingBindings").add(builder);
        remainingBindings.add(index, builder);
    }
    return (A) this;
  }
  
  public RemainingBinding buildFirstRemainingBinding() {
    return this.remainingBindings.get(0).build();
  }
  
  public RemainingBinding buildLastRemainingBinding() {
    return this.remainingBindings.get(remainingBindings.size() - 1).build();
  }
  
  public RemainingBinding buildMatchingRemainingBinding(Predicate<RemainingBindingBuilder> predicate) {
      for (RemainingBindingBuilder item : remainingBindings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RemainingBinding buildRemainingBinding(int index) {
    return this.remainingBindings.get(index).build();
  }
  
  public List<RemainingBinding> buildRemainingBindings() {
    return this.remainingBindings != null ? build(remainingBindings) : null;
  }
  
  protected void copyInstance(CompliancePerClusterStatus instance) {
    instance = instance != null ? instance : new CompliancePerClusterStatus();
    if (instance != null) {
        this.withClustername(instance.getClustername());
        this.withClusternamespace(instance.getClusternamespace());
        this.withCompliant(instance.getCompliant());
        this.withRemainingBindings(instance.getRemainingBindings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RemainingBindingsNested<A> editFirstRemainingBinding() {
    if (remainingBindings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "remainingBindings"));
    }
    return this.setNewRemainingBindingLike(0, this.buildRemainingBinding(0));
  }
  
  public RemainingBindingsNested<A> editLastRemainingBinding() {
    int index = remainingBindings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "remainingBindings"));
    }
    return this.setNewRemainingBindingLike(index, this.buildRemainingBinding(index));
  }
  
  public RemainingBindingsNested<A> editMatchingRemainingBinding(Predicate<RemainingBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < remainingBindings.size();i++) {
      if (predicate.test(remainingBindings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "remainingBindings"));
    }
    return this.setNewRemainingBindingLike(index, this.buildRemainingBinding(index));
  }
  
  public RemainingBindingsNested<A> editRemainingBinding(int index) {
    if (remainingBindings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "remainingBindings"));
    }
    return this.setNewRemainingBindingLike(index, this.buildRemainingBinding(index));
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
    CompliancePerClusterStatusFluent that = (CompliancePerClusterStatusFluent) o;
    if (!(Objects.equals(clustername, that.clustername))) {
      return false;
    }
    if (!(Objects.equals(clusternamespace, that.clusternamespace))) {
      return false;
    }
    if (!(Objects.equals(compliant, that.compliant))) {
      return false;
    }
    if (!(Objects.equals(remainingBindings, that.remainingBindings))) {
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
  
  public String getClustername() {
    return this.clustername;
  }
  
  public String getClusternamespace() {
    return this.clusternamespace;
  }
  
  public String getCompliant() {
    return this.compliant;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClustername() {
    return this.clustername != null;
  }
  
  public boolean hasClusternamespace() {
    return this.clusternamespace != null;
  }
  
  public boolean hasCompliant() {
    return this.compliant != null;
  }
  
  public boolean hasMatchingRemainingBinding(Predicate<RemainingBindingBuilder> predicate) {
      for (RemainingBindingBuilder item : remainingBindings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRemainingBindings() {
    return this.remainingBindings != null && !(this.remainingBindings.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(clustername, clusternamespace, compliant, remainingBindings, additionalProperties);
  }
  
  public A removeAllFromRemainingBindings(Collection<RemainingBinding> items) {
    if (this.remainingBindings == null) {
      return (A) this;
    }
    for (RemainingBinding item : items) {
        RemainingBindingBuilder builder = new RemainingBindingBuilder(item);
        _visitables.get("remainingBindings").remove(builder);
        this.remainingBindings.remove(builder);
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
  
  public A removeFromRemainingBindings(RemainingBinding... items) {
    if (this.remainingBindings == null) {
      return (A) this;
    }
    for (RemainingBinding item : items) {
        RemainingBindingBuilder builder = new RemainingBindingBuilder(item);
        _visitables.get("remainingBindings").remove(builder);
        this.remainingBindings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRemainingBindings(Predicate<RemainingBindingBuilder> predicate) {
    if (remainingBindings == null) {
      return (A) this;
    }
    Iterator<RemainingBindingBuilder> each = remainingBindings.iterator();
    List visitables = _visitables.get("remainingBindings");
    while (each.hasNext()) {
        RemainingBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RemainingBindingsNested<A> setNewRemainingBindingLike(int index,RemainingBinding item) {
    return new RemainingBindingsNested(index, item);
  }
  
  public A setToRemainingBindings(int index,RemainingBinding item) {
    if (this.remainingBindings == null) {
      this.remainingBindings = new ArrayList();
    }
    RemainingBindingBuilder builder = new RemainingBindingBuilder(item);
    if (index < 0 || index >= remainingBindings.size()) {
        _visitables.get("remainingBindings").add(builder);
        remainingBindings.add(builder);
    } else {
        _visitables.get("remainingBindings").add(builder);
        remainingBindings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clustername == null)) {
        sb.append("clustername:");
        sb.append(clustername);
        sb.append(",");
    }
    if (!(clusternamespace == null)) {
        sb.append("clusternamespace:");
        sb.append(clusternamespace);
        sb.append(",");
    }
    if (!(compliant == null)) {
        sb.append("compliant:");
        sb.append(compliant);
        sb.append(",");
    }
    if (!(remainingBindings == null) && !(remainingBindings.isEmpty())) {
        sb.append("remainingBindings:");
        sb.append(remainingBindings);
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
  
  public A withClustername(String clustername) {
    this.clustername = clustername;
    return (A) this;
  }
  
  public A withClusternamespace(String clusternamespace) {
    this.clusternamespace = clusternamespace;
    return (A) this;
  }
  
  public A withCompliant(String compliant) {
    this.compliant = compliant;
    return (A) this;
  }
  
  public A withRemainingBindings(List<RemainingBinding> remainingBindings) {
    if (this.remainingBindings != null) {
      this._visitables.get("remainingBindings").clear();
    }
    if (remainingBindings != null) {
        this.remainingBindings = new ArrayList();
        for (RemainingBinding item : remainingBindings) {
          this.addToRemainingBindings(item);
        }
    } else {
      this.remainingBindings = null;
    }
    return (A) this;
  }
  
  public A withRemainingBindings(RemainingBinding... remainingBindings) {
    if (this.remainingBindings != null) {
        this.remainingBindings.clear();
        _visitables.remove("remainingBindings");
    }
    if (remainingBindings != null) {
      for (RemainingBinding item : remainingBindings) {
        this.addToRemainingBindings(item);
      }
    }
    return (A) this;
  }
  public class RemainingBindingsNested<N> extends RemainingBindingFluent<RemainingBindingsNested<N>> implements Nested<N>{
  
    RemainingBindingBuilder builder;
    int index;
  
    RemainingBindingsNested(int index,RemainingBinding item) {
      this.index = index;
      this.builder = new RemainingBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) CompliancePerClusterStatusFluent.this.setToRemainingBindings(index, builder.build());
    }
    
    public N endRemainingBinding() {
      return and();
    }
    
  }
}