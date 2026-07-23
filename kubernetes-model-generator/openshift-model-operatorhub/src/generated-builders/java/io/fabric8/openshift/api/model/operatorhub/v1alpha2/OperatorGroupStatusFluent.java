package io.fabric8.openshift.api.model.operatorhub.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class OperatorGroupStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha2.OperatorGroupStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String lastUpdated;
  private List<String> namespaces = new ArrayList<String>();
  private ObjectReferenceBuilder serviceAccountRef;

  public OperatorGroupStatusFluent() {
  }
  
  public OperatorGroupStatusFluent(OperatorGroupStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
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
  
  public A addToNamespaces(String... items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.add(index, item);
    return (A) this;
  }
  
  public ObjectReference buildServiceAccountRef() {
    return this.serviceAccountRef != null ? this.serviceAccountRef.build() : null;
  }
  
  protected void copyInstance(OperatorGroupStatus instance) {
    instance = instance != null ? instance : new OperatorGroupStatus();
    if (instance != null) {
        this.withLastUpdated(instance.getLastUpdated());
        this.withNamespaces(instance.getNamespaces());
        this.withServiceAccountRef(instance.getServiceAccountRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRef() {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRefLike(ObjectReference item) {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(item));
  }
  
  public ServiceAccountRefNested<A> editServiceAccountRef() {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(null));
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
    OperatorGroupStatusFluent that = (OperatorGroupStatusFluent) o;
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountRef, that.serviceAccountRef))) {
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
  
  public String getFirstNamespace() {
    return this.namespaces.get(0);
  }
  
  public String getLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1);
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public String getMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamespace(int index) {
    return this.namespaces.get(index);
  }
  
  public List<String> getNamespaces() {
    return this.namespaces;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasServiceAccountRef() {
    return this.serviceAccountRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(lastUpdated, namespaces, serviceAccountRef, additionalProperties);
  }
  
  public A removeAllFromNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
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
  
  public A removeFromNamespaces(String... items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A setToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(serviceAccountRef == null)) {
        sb.append("serviceAccountRef:");
        sb.append(serviceAccountRef);
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
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public A withNamespaces(List<String> namespaces) {
    if (namespaces != null) {
        this.namespaces = new ArrayList();
        for (String item : namespaces) {
          this.addToNamespaces(item);
        }
    } else {
      this.namespaces = null;
    }
    return (A) this;
  }
  
  public A withNamespaces(String... namespaces) {
    if (this.namespaces != null) {
        this.namespaces.clear();
        _visitables.remove("namespaces");
    }
    if (namespaces != null) {
      for (String item : namespaces) {
        this.addToNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public ServiceAccountRefNested<A> withNewServiceAccountRef() {
    return new ServiceAccountRefNested(null);
  }
  
  public ServiceAccountRefNested<A> withNewServiceAccountRefLike(ObjectReference item) {
    return new ServiceAccountRefNested(item);
  }
  
  public A withServiceAccountRef(ObjectReference serviceAccountRef) {
    this._visitables.remove("serviceAccountRef");
    if (serviceAccountRef != null) {
        this.serviceAccountRef = new ObjectReferenceBuilder(serviceAccountRef);
        this._visitables.get("serviceAccountRef").add(this.serviceAccountRef);
    } else {
        this.serviceAccountRef = null;
        this._visitables.get("serviceAccountRef").remove(this.serviceAccountRef);
    }
    return (A) this;
  }
  public class ServiceAccountRefNested<N> extends ObjectReferenceFluent<ServiceAccountRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ServiceAccountRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorGroupStatusFluent.this.withServiceAccountRef(builder.build());
    }
    
    public N endServiceAccountRef() {
      return and();
    }
    
  }
}