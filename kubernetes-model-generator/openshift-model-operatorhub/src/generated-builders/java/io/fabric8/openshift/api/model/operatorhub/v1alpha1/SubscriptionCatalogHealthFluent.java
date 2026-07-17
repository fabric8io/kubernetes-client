package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SubscriptionCatalogHealthFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.SubscriptionCatalogHealthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder catalogSourceRef;
  private Boolean healthy;
  private String lastUpdated;

  public SubscriptionCatalogHealthFluent() {
  }
  
  public SubscriptionCatalogHealthFluent(SubscriptionCatalogHealth instance) {
    this.copyInstance(instance);
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
  
  public ObjectReference buildCatalogSourceRef() {
    return this.catalogSourceRef != null ? this.catalogSourceRef.build() : null;
  }
  
  protected void copyInstance(SubscriptionCatalogHealth instance) {
    instance = instance != null ? instance : new SubscriptionCatalogHealth();
    if (instance != null) {
        this.withCatalogSourceRef(instance.getCatalogSourceRef());
        this.withHealthy(instance.getHealthy());
        this.withLastUpdated(instance.getLastUpdated());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CatalogSourceRefNested<A> editCatalogSourceRef() {
    return this.withNewCatalogSourceRefLike(Optional.ofNullable(this.buildCatalogSourceRef()).orElse(null));
  }
  
  public CatalogSourceRefNested<A> editOrNewCatalogSourceRef() {
    return this.withNewCatalogSourceRefLike(Optional.ofNullable(this.buildCatalogSourceRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public CatalogSourceRefNested<A> editOrNewCatalogSourceRefLike(ObjectReference item) {
    return this.withNewCatalogSourceRefLike(Optional.ofNullable(this.buildCatalogSourceRef()).orElse(item));
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
    SubscriptionCatalogHealthFluent that = (SubscriptionCatalogHealthFluent) o;
    if (!(Objects.equals(catalogSourceRef, that.catalogSourceRef))) {
      return false;
    }
    if (!(Objects.equals(healthy, that.healthy))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
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
  
  public Boolean getHealthy() {
    return this.healthy;
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCatalogSourceRef() {
    return this.catalogSourceRef != null;
  }
  
  public boolean hasHealthy() {
    return this.healthy != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public int hashCode() {
    return Objects.hash(catalogSourceRef, healthy, lastUpdated, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(catalogSourceRef == null)) {
        sb.append("catalogSourceRef:");
        sb.append(catalogSourceRef);
        sb.append(",");
    }
    if (!(healthy == null)) {
        sb.append("healthy:");
        sb.append(healthy);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
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
  
  public A withCatalogSourceRef(ObjectReference catalogSourceRef) {
    this._visitables.remove("catalogSourceRef");
    if (catalogSourceRef != null) {
        this.catalogSourceRef = new ObjectReferenceBuilder(catalogSourceRef);
        this._visitables.get("catalogSourceRef").add(this.catalogSourceRef);
    } else {
        this.catalogSourceRef = null;
        this._visitables.get("catalogSourceRef").remove(this.catalogSourceRef);
    }
    return (A) this;
  }
  
  public A withHealthy() {
    return withHealthy(true);
  }
  
  public A withHealthy(Boolean healthy) {
    this.healthy = healthy;
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public CatalogSourceRefNested<A> withNewCatalogSourceRef() {
    return new CatalogSourceRefNested(null);
  }
  
  public CatalogSourceRefNested<A> withNewCatalogSourceRefLike(ObjectReference item) {
    return new CatalogSourceRefNested(item);
  }
  public class CatalogSourceRefNested<N> extends ObjectReferenceFluent<CatalogSourceRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    CatalogSourceRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionCatalogHealthFluent.this.withCatalogSourceRef(builder.build());
    }
    
    public N endCatalogSourceRef() {
      return and();
    }
    
  }
}