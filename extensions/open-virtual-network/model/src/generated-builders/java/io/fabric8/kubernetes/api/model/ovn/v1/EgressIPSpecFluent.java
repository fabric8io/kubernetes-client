package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class EgressIPSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.EgressIPSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> egressIPs = new ArrayList<String>();
  private LabelSelectorBuilder namespaceSelector;
  private LabelSelectorBuilder podSelector;

  public EgressIPSpecFluent() {
  }
  
  public EgressIPSpecFluent(EgressIPSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEgressIPs(Collection<String> items) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    for (String item : items) {
      this.egressIPs.add(item);
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
  
  public A addToEgressIPs(String... items) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    for (String item : items) {
      this.egressIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToEgressIPs(int index,String item) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    this.egressIPs.add(index, item);
    return (A) this;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public LabelSelector buildPodSelector() {
    return this.podSelector != null ? this.podSelector.build() : null;
  }
  
  protected void copyInstance(EgressIPSpec instance) {
    instance = instance != null ? instance : new EgressIPSpec();
    if (instance != null) {
        this.withEgressIPs(instance.getEgressIPs());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withPodSelector(instance.getPodSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public PodSelectorNested<A> editOrNewPodSelector() {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public PodSelectorNested<A> editOrNewPodSelectorLike(LabelSelector item) {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(item));
  }
  
  public PodSelectorNested<A> editPodSelector() {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(null));
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
    EgressIPSpecFluent that = (EgressIPSpecFluent) o;
    if (!(Objects.equals(egressIPs, that.egressIPs))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(podSelector, that.podSelector))) {
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
  
  public String getEgressIP(int index) {
    return this.egressIPs.get(index);
  }
  
  public List<String> getEgressIPs() {
    return this.egressIPs;
  }
  
  public String getFirstEgressIP() {
    return this.egressIPs.get(0);
  }
  
  public String getLastEgressIP() {
    return this.egressIPs.get(egressIPs.size() - 1);
  }
  
  public String getMatchingEgressIP(Predicate<String> predicate) {
      for (String item : egressIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEgressIPs() {
    return this.egressIPs != null && !(this.egressIPs.isEmpty());
  }
  
  public boolean hasMatchingEgressIP(Predicate<String> predicate) {
      for (String item : egressIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasPodSelector() {
    return this.podSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(egressIPs, namespaceSelector, podSelector, additionalProperties);
  }
  
  public A removeAllFromEgressIPs(Collection<String> items) {
    if (this.egressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.egressIPs.remove(item);
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
  
  public A removeFromEgressIPs(String... items) {
    if (this.egressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.egressIPs.remove(item);
    }
    return (A) this;
  }
  
  public A setToEgressIPs(int index,String item) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    this.egressIPs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(egressIPs == null) && !(egressIPs.isEmpty())) {
        sb.append("egressIPs:");
        sb.append(egressIPs);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(podSelector == null)) {
        sb.append("podSelector:");
        sb.append(podSelector);
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
  
  public A withEgressIPs(List<String> egressIPs) {
    if (egressIPs != null) {
        this.egressIPs = new ArrayList();
        for (String item : egressIPs) {
          this.addToEgressIPs(item);
        }
    } else {
      this.egressIPs = null;
    }
    return (A) this;
  }
  
  public A withEgressIPs(String... egressIPs) {
    if (this.egressIPs != null) {
        this.egressIPs.clear();
        _visitables.remove("egressIPs");
    }
    if (egressIPs != null) {
      for (String item : egressIPs) {
        this.addToEgressIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public PodSelectorNested<A> withNewPodSelector() {
    return new PodSelectorNested(null);
  }
  
  public PodSelectorNested<A> withNewPodSelectorLike(LabelSelector item) {
    return new PodSelectorNested(item);
  }
  
  public A withPodSelector(LabelSelector podSelector) {
    this._visitables.remove("podSelector");
    if (podSelector != null) {
        this.podSelector = new LabelSelectorBuilder(podSelector);
        this._visitables.get("podSelector").add(this.podSelector);
    } else {
        this.podSelector = null;
        this._visitables.get("podSelector").remove(this.podSelector);
    }
    return (A) this;
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressIPSpecFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class PodSelectorNested<N> extends LabelSelectorFluent<PodSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    PodSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressIPSpecFluent.this.withPodSelector(builder.build());
    }
    
    public N endPodSelector() {
      return and();
    }
    
  }
}