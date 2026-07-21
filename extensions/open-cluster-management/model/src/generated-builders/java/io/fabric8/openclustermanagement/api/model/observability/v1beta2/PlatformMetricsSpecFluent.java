package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PlatformMetricsSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.PlatformMetricsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PlatformMetricsCollectionSpecBuilder collection;
  private UIConfigBuilder ui;

  public PlatformMetricsSpecFluent() {
  }
  
  public PlatformMetricsSpecFluent(PlatformMetricsSpec instance) {
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
  
  public PlatformMetricsCollectionSpec buildCollection() {
    return this.collection != null ? this.collection.build() : null;
  }
  
  public UIConfig buildUi() {
    return this.ui != null ? this.ui.build() : null;
  }
  
  protected void copyInstance(PlatformMetricsSpec instance) {
    instance = instance != null ? instance : new PlatformMetricsSpec();
    if (instance != null) {
        this.withCollection(instance.getCollection());
        this.withUi(instance.getUi());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CollectionNested<A> editCollection() {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(null));
  }
  
  public CollectionNested<A> editOrNewCollection() {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(new PlatformMetricsCollectionSpecBuilder().build()));
  }
  
  public CollectionNested<A> editOrNewCollectionLike(PlatformMetricsCollectionSpec item) {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(item));
  }
  
  public UiNested<A> editOrNewUi() {
    return this.withNewUiLike(Optional.ofNullable(this.buildUi()).orElse(new UIConfigBuilder().build()));
  }
  
  public UiNested<A> editOrNewUiLike(UIConfig item) {
    return this.withNewUiLike(Optional.ofNullable(this.buildUi()).orElse(item));
  }
  
  public UiNested<A> editUi() {
    return this.withNewUiLike(Optional.ofNullable(this.buildUi()).orElse(null));
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
    PlatformMetricsSpecFluent that = (PlatformMetricsSpecFluent) o;
    if (!(Objects.equals(collection, that.collection))) {
      return false;
    }
    if (!(Objects.equals(ui, that.ui))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCollection() {
    return this.collection != null;
  }
  
  public boolean hasUi() {
    return this.ui != null;
  }
  
  public int hashCode() {
    return Objects.hash(collection, ui, additionalProperties);
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
    if (!(collection == null)) {
        sb.append("collection:");
        sb.append(collection);
        sb.append(",");
    }
    if (!(ui == null)) {
        sb.append("ui:");
        sb.append(ui);
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
  
  public A withCollection(PlatformMetricsCollectionSpec collection) {
    this._visitables.remove("collection");
    if (collection != null) {
        this.collection = new PlatformMetricsCollectionSpecBuilder(collection);
        this._visitables.get("collection").add(this.collection);
    } else {
        this.collection = null;
        this._visitables.get("collection").remove(this.collection);
    }
    return (A) this;
  }
  
  public CollectionNested<A> withNewCollection() {
    return new CollectionNested(null);
  }
  
  public A withNewCollection(Boolean enabled) {
    return (A) this.withCollection(new PlatformMetricsCollectionSpec(enabled));
  }
  
  public CollectionNested<A> withNewCollectionLike(PlatformMetricsCollectionSpec item) {
    return new CollectionNested(item);
  }
  
  public UiNested<A> withNewUi() {
    return new UiNested(null);
  }
  
  public A withNewUi(Boolean enabled) {
    return (A) this.withUi(new UIConfig(enabled));
  }
  
  public UiNested<A> withNewUiLike(UIConfig item) {
    return new UiNested(item);
  }
  
  public A withUi(UIConfig ui) {
    this._visitables.remove("ui");
    if (ui != null) {
        this.ui = new UIConfigBuilder(ui);
        this._visitables.get("ui").add(this.ui);
    } else {
        this.ui = null;
        this._visitables.get("ui").remove(this.ui);
    }
    return (A) this;
  }
  public class CollectionNested<N> extends PlatformMetricsCollectionSpecFluent<CollectionNested<N>> implements Nested<N>{
  
    PlatformMetricsCollectionSpecBuilder builder;
  
    CollectionNested(PlatformMetricsCollectionSpec item) {
      this.builder = new PlatformMetricsCollectionSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformMetricsSpecFluent.this.withCollection(builder.build());
    }
    
    public N endCollection() {
      return and();
    }
    
  }
  public class UiNested<N> extends UIConfigFluent<UiNested<N>> implements Nested<N>{
  
    UIConfigBuilder builder;
  
    UiNested(UIConfig item) {
      this.builder = new UIConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformMetricsSpecFluent.this.withUi(builder.build());
    }
    
    public N endUi() {
      return and();
    }
    
  }
}