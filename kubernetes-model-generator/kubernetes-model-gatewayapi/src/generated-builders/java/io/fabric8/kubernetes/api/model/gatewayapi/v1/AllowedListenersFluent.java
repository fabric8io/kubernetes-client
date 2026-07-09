package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class AllowedListenersFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.AllowedListenersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ListenerNamespacesBuilder namespaces;

  public AllowedListenersFluent() {
  }
  
  public AllowedListenersFluent(AllowedListeners instance) {
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
  
  public ListenerNamespaces buildNamespaces() {
    return this.namespaces != null ? this.namespaces.build() : null;
  }
  
  protected void copyInstance(AllowedListeners instance) {
    instance = instance != null ? instance : new AllowedListeners();
    if (instance != null) {
        this.withNamespaces(instance.getNamespaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamespacesNested<A> editNamespaces() {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(null));
  }
  
  public NamespacesNested<A> editOrNewNamespaces() {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(new ListenerNamespacesBuilder().build()));
  }
  
  public NamespacesNested<A> editOrNewNamespacesLike(ListenerNamespaces item) {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(item));
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
    AllowedListenersFluent that = (AllowedListenersFluent) o;
    if (!(Objects.equals(namespaces, that.namespaces))) {
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
  
  public boolean hasNamespaces() {
    return this.namespaces != null;
  }
  
  public int hashCode() {
    return Objects.hash(namespaces, additionalProperties);
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
    if (!(namespaces == null)) {
        sb.append("namespaces:");
        sb.append(namespaces);
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
  
  public A withNamespaces(ListenerNamespaces namespaces) {
    this._visitables.remove("namespaces");
    if (namespaces != null) {
        this.namespaces = new ListenerNamespacesBuilder(namespaces);
        this._visitables.get("namespaces").add(this.namespaces);
    } else {
        this.namespaces = null;
        this._visitables.get("namespaces").remove(this.namespaces);
    }
    return (A) this;
  }
  
  public NamespacesNested<A> withNewNamespaces() {
    return new NamespacesNested(null);
  }
  
  public NamespacesNested<A> withNewNamespacesLike(ListenerNamespaces item) {
    return new NamespacesNested(item);
  }
  public class NamespacesNested<N> extends ListenerNamespacesFluent<NamespacesNested<N>> implements Nested<N>{
  
    ListenerNamespacesBuilder builder;
  
    NamespacesNested(ListenerNamespaces item) {
      this.builder = new ListenerNamespacesBuilder(this, item);
    }
  
    public N and() {
      return (N) AllowedListenersFluent.this.withNamespaces(builder.build());
    }
    
    public N endNamespaces() {
      return and();
    }
    
  }
}