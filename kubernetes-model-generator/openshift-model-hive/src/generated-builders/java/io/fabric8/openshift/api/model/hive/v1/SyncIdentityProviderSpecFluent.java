package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.openshift.api.model.config.v1.IdentityProvider;
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
public class SyncIdentityProviderSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.SyncIdentityProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<LocalObjectReferenceBuilder> clusterDeploymentRefs = new ArrayList<LocalObjectReferenceBuilder>();
  private List<IdentityProvider> identityProviders = new ArrayList<IdentityProvider>();

  public SyncIdentityProviderSpecFluent() {
  }
  
  public SyncIdentityProviderSpecFluent(SyncIdentityProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterDeploymentRefs(Collection<LocalObjectReference> items) {
    if (this.clusterDeploymentRefs == null) {
      this.clusterDeploymentRefs = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("clusterDeploymentRefs").add(builder);
        this.clusterDeploymentRefs.add(builder);
    }
    return (A) this;
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
  
  public ClusterDeploymentRefsNested<A> addNewClusterDeploymentRef() {
    return new ClusterDeploymentRefsNested(-1, null);
  }
  
  public A addNewClusterDeploymentRef(String name) {
    return (A) this.addToClusterDeploymentRefs(new LocalObjectReference(name));
  }
  
  public ClusterDeploymentRefsNested<A> addNewClusterDeploymentRefLike(LocalObjectReference item) {
    return new ClusterDeploymentRefsNested(-1, item);
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
  
  public A addToClusterDeploymentRefs(LocalObjectReference... items) {
    if (this.clusterDeploymentRefs == null) {
      this.clusterDeploymentRefs = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("clusterDeploymentRefs").add(builder);
        this.clusterDeploymentRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterDeploymentRefs(int index,LocalObjectReference item) {
    if (this.clusterDeploymentRefs == null) {
      this.clusterDeploymentRefs = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= clusterDeploymentRefs.size()) {
        _visitables.get("clusterDeploymentRefs").add(builder);
        clusterDeploymentRefs.add(builder);
    } else {
        _visitables.get("clusterDeploymentRefs").add(builder);
        clusterDeploymentRefs.add(index, builder);
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
  
  public LocalObjectReference buildClusterDeploymentRef(int index) {
    return this.clusterDeploymentRefs.get(index).build();
  }
  
  public List<LocalObjectReference> buildClusterDeploymentRefs() {
    return this.clusterDeploymentRefs != null ? build(clusterDeploymentRefs) : null;
  }
  
  public LocalObjectReference buildFirstClusterDeploymentRef() {
    return this.clusterDeploymentRefs.get(0).build();
  }
  
  public LocalObjectReference buildLastClusterDeploymentRef() {
    return this.clusterDeploymentRefs.get(clusterDeploymentRefs.size() - 1).build();
  }
  
  public LocalObjectReference buildMatchingClusterDeploymentRef(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : clusterDeploymentRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(SyncIdentityProviderSpec instance) {
    instance = instance != null ? instance : new SyncIdentityProviderSpec();
    if (instance != null) {
        this.withClusterDeploymentRefs(instance.getClusterDeploymentRefs());
        this.withIdentityProviders(instance.getIdentityProviders());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterDeploymentRefsNested<A> editClusterDeploymentRef(int index) {
    if (clusterDeploymentRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterDeploymentRefs"));
    }
    return this.setNewClusterDeploymentRefLike(index, this.buildClusterDeploymentRef(index));
  }
  
  public ClusterDeploymentRefsNested<A> editFirstClusterDeploymentRef() {
    if (clusterDeploymentRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterDeploymentRefs"));
    }
    return this.setNewClusterDeploymentRefLike(0, this.buildClusterDeploymentRef(0));
  }
  
  public ClusterDeploymentRefsNested<A> editLastClusterDeploymentRef() {
    int index = clusterDeploymentRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterDeploymentRefs"));
    }
    return this.setNewClusterDeploymentRefLike(index, this.buildClusterDeploymentRef(index));
  }
  
  public ClusterDeploymentRefsNested<A> editMatchingClusterDeploymentRef(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterDeploymentRefs.size();i++) {
      if (predicate.test(clusterDeploymentRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterDeploymentRefs"));
    }
    return this.setNewClusterDeploymentRefLike(index, this.buildClusterDeploymentRef(index));
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
    SyncIdentityProviderSpecFluent that = (SyncIdentityProviderSpecFluent) o;
    if (!(Objects.equals(clusterDeploymentRefs, that.clusterDeploymentRefs))) {
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
  
  public boolean hasClusterDeploymentRefs() {
    return this.clusterDeploymentRefs != null && !(this.clusterDeploymentRefs.isEmpty());
  }
  
  public boolean hasIdentityProviders() {
    return this.identityProviders != null && !(this.identityProviders.isEmpty());
  }
  
  public boolean hasMatchingClusterDeploymentRef(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : clusterDeploymentRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
    return Objects.hash(clusterDeploymentRefs, identityProviders, additionalProperties);
  }
  
  public A removeAllFromClusterDeploymentRefs(Collection<LocalObjectReference> items) {
    if (this.clusterDeploymentRefs == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("clusterDeploymentRefs").remove(builder);
        this.clusterDeploymentRefs.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromClusterDeploymentRefs(LocalObjectReference... items) {
    if (this.clusterDeploymentRefs == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("clusterDeploymentRefs").remove(builder);
        this.clusterDeploymentRefs.remove(builder);
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
  
  public A removeMatchingFromClusterDeploymentRefs(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (clusterDeploymentRefs == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = clusterDeploymentRefs.iterator();
    List visitables = _visitables.get("clusterDeploymentRefs");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterDeploymentRefsNested<A> setNewClusterDeploymentRefLike(int index,LocalObjectReference item) {
    return new ClusterDeploymentRefsNested(index, item);
  }
  
  public A setToClusterDeploymentRefs(int index,LocalObjectReference item) {
    if (this.clusterDeploymentRefs == null) {
      this.clusterDeploymentRefs = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= clusterDeploymentRefs.size()) {
        _visitables.get("clusterDeploymentRefs").add(builder);
        clusterDeploymentRefs.add(builder);
    } else {
        _visitables.get("clusterDeploymentRefs").add(builder);
        clusterDeploymentRefs.set(index, builder);
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
    if (!(clusterDeploymentRefs == null) && !(clusterDeploymentRefs.isEmpty())) {
        sb.append("clusterDeploymentRefs:");
        sb.append(clusterDeploymentRefs);
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
  
  public A withClusterDeploymentRefs(List<LocalObjectReference> clusterDeploymentRefs) {
    if (this.clusterDeploymentRefs != null) {
      this._visitables.get("clusterDeploymentRefs").clear();
    }
    if (clusterDeploymentRefs != null) {
        this.clusterDeploymentRefs = new ArrayList();
        for (LocalObjectReference item : clusterDeploymentRefs) {
          this.addToClusterDeploymentRefs(item);
        }
    } else {
      this.clusterDeploymentRefs = null;
    }
    return (A) this;
  }
  
  public A withClusterDeploymentRefs(LocalObjectReference... clusterDeploymentRefs) {
    if (this.clusterDeploymentRefs != null) {
        this.clusterDeploymentRefs.clear();
        _visitables.remove("clusterDeploymentRefs");
    }
    if (clusterDeploymentRefs != null) {
      for (LocalObjectReference item : clusterDeploymentRefs) {
        this.addToClusterDeploymentRefs(item);
      }
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
  public class ClusterDeploymentRefsNested<N> extends LocalObjectReferenceFluent<ClusterDeploymentRefsNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    ClusterDeploymentRefsNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SyncIdentityProviderSpecFluent.this.setToClusterDeploymentRefs(index, builder.build());
    }
    
    public N endClusterDeploymentRef() {
      return and();
    }
    
  }
}