package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class DependsOnFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.DependsOnFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ProbeBuilder probe;
  private List<String> targets = new ArrayList<String>();

  public DependsOnFluent() {
  }
  
  public DependsOnFluent(DependsOn instance) {
    this.copyInstance(instance);
  }

  public A addAllToTargets(Collection<String> items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (String item : items) {
      this.targets.add(item);
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
  
  public A addToTargets(String... items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (String item : items) {
      this.targets.add(item);
    }
    return (A) this;
  }
  
  public A addToTargets(int index,String item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    this.targets.add(index, item);
    return (A) this;
  }
  
  public Probe buildProbe() {
    return this.probe != null ? this.probe.build() : null;
  }
  
  protected void copyInstance(DependsOn instance) {
    instance = instance != null ? instance : new DependsOn();
    if (instance != null) {
        this.withProbe(instance.getProbe());
        this.withTargets(instance.getTargets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ProbeNested<A> editOrNewProbe() {
    return this.withNewProbeLike(Optional.ofNullable(this.buildProbe()).orElse(new ProbeBuilder().build()));
  }
  
  public ProbeNested<A> editOrNewProbeLike(Probe item) {
    return this.withNewProbeLike(Optional.ofNullable(this.buildProbe()).orElse(item));
  }
  
  public ProbeNested<A> editProbe() {
    return this.withNewProbeLike(Optional.ofNullable(this.buildProbe()).orElse(null));
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
    DependsOnFluent that = (DependsOnFluent) o;
    if (!(Objects.equals(probe, that.probe))) {
      return false;
    }
    if (!(Objects.equals(targets, that.targets))) {
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
  
  public String getFirstTarget() {
    return this.targets.get(0);
  }
  
  public String getLastTarget() {
    return this.targets.get(targets.size() - 1);
  }
  
  public String getMatchingTarget(Predicate<String> predicate) {
      for (String item : targets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getTarget(int index) {
    return this.targets.get(index);
  }
  
  public List<String> getTargets() {
    return this.targets;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTarget(Predicate<String> predicate) {
      for (String item : targets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProbe() {
    return this.probe != null;
  }
  
  public boolean hasTargets() {
    return this.targets != null && !(this.targets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(probe, targets, additionalProperties);
  }
  
  public A removeAllFromTargets(Collection<String> items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targets.remove(item);
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
  
  public A removeFromTargets(String... items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targets.remove(item);
    }
    return (A) this;
  }
  
  public A setToTargets(int index,String item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    this.targets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(probe == null)) {
        sb.append("probe:");
        sb.append(probe);
        sb.append(",");
    }
    if (!(targets == null) && !(targets.isEmpty())) {
        sb.append("targets:");
        sb.append(targets);
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
  
  public ProbeNested<A> withNewProbe() {
    return new ProbeNested(null);
  }
  
  public ProbeNested<A> withNewProbeLike(Probe item) {
    return new ProbeNested(item);
  }
  
  public A withProbe(Probe probe) {
    this._visitables.remove("probe");
    if (probe != null) {
        this.probe = new ProbeBuilder(probe);
        this._visitables.get("probe").add(this.probe);
    } else {
        this.probe = null;
        this._visitables.get("probe").remove(this.probe);
    }
    return (A) this;
  }
  
  public A withTargets(List<String> targets) {
    if (targets != null) {
        this.targets = new ArrayList();
        for (String item : targets) {
          this.addToTargets(item);
        }
    } else {
      this.targets = null;
    }
    return (A) this;
  }
  
  public A withTargets(String... targets) {
    if (this.targets != null) {
        this.targets.clear();
        _visitables.remove("targets");
    }
    if (targets != null) {
      for (String item : targets) {
        this.addToTargets(item);
      }
    }
    return (A) this;
  }
  public class ProbeNested<N> extends ProbeFluent<ProbeNested<N>> implements Nested<N>{
  
    ProbeBuilder builder;
  
    ProbeNested(Probe item) {
      this.builder = new ProbeBuilder(this, item);
    }
  
    public N and() {
      return (N) DependsOnFluent.this.withProbe(builder.build());
    }
    
    public N endProbe() {
      return and();
    }
    
  }
}