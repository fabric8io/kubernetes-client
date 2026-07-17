package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.openshift.api.model.config.v1.IdentityProvider;
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
public class SelectorSyncIdentityProviderSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder clusterDeploymentSelector;
  private List<IdentityProvider> identityProviders = new ArrayList<IdentityProvider>();

  public SelectorSyncIdentityProviderSpecFluent() {
  }
  
  public SelectorSyncIdentityProviderSpecFluent(SelectorSyncIdentityProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToIdentityProviders(Collection<IdentityProvider> items) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    for (IdentityProvider item : items) {
      this.identityProviders.add(item);
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
  
  public A addToIdentityProviders(IdentityProvider... items) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    for (IdentityProvider item : items) {
      this.identityProviders.add(item);
    }
    return (A) this;
  }
  
  public A addToIdentityProviders(int index,IdentityProvider item) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    this.identityProviders.add(index, item);
    return (A) this;
  }
  
  public LabelSelector buildClusterDeploymentSelector() {
    return this.clusterDeploymentSelector != null ? this.clusterDeploymentSelector.build() : null;
  }
  
  protected void copyInstance(SelectorSyncIdentityProviderSpec instance) {
    instance = instance != null ? instance : new SelectorSyncIdentityProviderSpec();
    if (instance != null) {
        this.withClusterDeploymentSelector(instance.getClusterDeploymentSelector());
        this.withIdentityProviders(instance.getIdentityProviders());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterDeploymentSelectorNested<A> editClusterDeploymentSelector() {
    return this.withNewClusterDeploymentSelectorLike(Optional.ofNullable(this.buildClusterDeploymentSelector()).orElse(null));
  }
  
  public ClusterDeploymentSelectorNested<A> editOrNewClusterDeploymentSelector() {
    return this.withNewClusterDeploymentSelectorLike(Optional.ofNullable(this.buildClusterDeploymentSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ClusterDeploymentSelectorNested<A> editOrNewClusterDeploymentSelectorLike(LabelSelector item) {
    return this.withNewClusterDeploymentSelectorLike(Optional.ofNullable(this.buildClusterDeploymentSelector()).orElse(item));
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
    SelectorSyncIdentityProviderSpecFluent that = (SelectorSyncIdentityProviderSpecFluent) o;
    if (!(Objects.equals(clusterDeploymentSelector, that.clusterDeploymentSelector))) {
      return false;
    }
    if (!(Objects.equals(identityProviders, that.identityProviders))) {
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
  
  public IdentityProvider getFirstIdentityProvider() {
    return this.identityProviders.get(0);
  }
  
  public IdentityProvider getIdentityProvider(int index) {
    return this.identityProviders.get(index);
  }
  
  public List<IdentityProvider> getIdentityProviders() {
    return this.identityProviders;
  }
  
  public IdentityProvider getLastIdentityProvider() {
    return this.identityProviders.get(identityProviders.size() - 1);
  }
  
  public IdentityProvider getMatchingIdentityProvider(Predicate<IdentityProvider> predicate) {
      for (IdentityProvider item : identityProviders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterDeploymentSelector() {
    return this.clusterDeploymentSelector != null;
  }
  
  public boolean hasIdentityProviders() {
    return this.identityProviders != null && !(this.identityProviders.isEmpty());
  }
  
  public boolean hasMatchingIdentityProvider(Predicate<IdentityProvider> predicate) {
      for (IdentityProvider item : identityProviders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterDeploymentSelector, identityProviders, additionalProperties);
  }
  
  public A removeAllFromIdentityProviders(Collection<IdentityProvider> items) {
    if (this.identityProviders == null) {
      return (A) this;
    }
    for (IdentityProvider item : items) {
      this.identityProviders.remove(item);
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
  
  public A removeFromIdentityProviders(IdentityProvider... items) {
    if (this.identityProviders == null) {
      return (A) this;
    }
    for (IdentityProvider item : items) {
      this.identityProviders.remove(item);
    }
    return (A) this;
  }
  
  public A setToIdentityProviders(int index,IdentityProvider item) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    this.identityProviders.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterDeploymentSelector == null)) {
        sb.append("clusterDeploymentSelector:");
        sb.append(clusterDeploymentSelector);
        sb.append(",");
    }
    if (!(identityProviders == null) && !(identityProviders.isEmpty())) {
        sb.append("identityProviders:");
        sb.append(identityProviders);
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
  
  public A withClusterDeploymentSelector(LabelSelector clusterDeploymentSelector) {
    this._visitables.remove("clusterDeploymentSelector");
    if (clusterDeploymentSelector != null) {
        this.clusterDeploymentSelector = new LabelSelectorBuilder(clusterDeploymentSelector);
        this._visitables.get("clusterDeploymentSelector").add(this.clusterDeploymentSelector);
    } else {
        this.clusterDeploymentSelector = null;
        this._visitables.get("clusterDeploymentSelector").remove(this.clusterDeploymentSelector);
    }
    return (A) this;
  }
  
  public A withIdentityProviders(List<IdentityProvider> identityProviders) {
    if (identityProviders != null) {
        this.identityProviders = new ArrayList();
        for (IdentityProvider item : identityProviders) {
          this.addToIdentityProviders(item);
        }
    } else {
      this.identityProviders = null;
    }
    return (A) this;
  }
  
  public A withIdentityProviders(IdentityProvider... identityProviders) {
    if (this.identityProviders != null) {
        this.identityProviders.clear();
        _visitables.remove("identityProviders");
    }
    if (identityProviders != null) {
      for (IdentityProvider item : identityProviders) {
        this.addToIdentityProviders(item);
      }
    }
    return (A) this;
  }
  
  public ClusterDeploymentSelectorNested<A> withNewClusterDeploymentSelector() {
    return new ClusterDeploymentSelectorNested(null);
  }
  
  public ClusterDeploymentSelectorNested<A> withNewClusterDeploymentSelectorLike(LabelSelector item) {
    return new ClusterDeploymentSelectorNested(item);
  }
  public class ClusterDeploymentSelectorNested<N> extends LabelSelectorFluent<ClusterDeploymentSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ClusterDeploymentSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) SelectorSyncIdentityProviderSpecFluent.this.withClusterDeploymentSelector(builder.build());
    }
    
    public N endClusterDeploymentSelector() {
      return and();
    }
    
  }
}