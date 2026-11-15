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
public class ListenerFilterFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ListenerFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder extensionRef;
  private HTTPExternalAuthFilterBuilder externalAuth;
  private String type;

  public ListenerFilterFluent() {
  }
  
  public ListenerFilterFluent(ListenerFilter instance) {
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
  
  public LocalObjectReference buildExtensionRef() {
    return this.extensionRef != null ? this.extensionRef.build() : null;
  }
  
  public HTTPExternalAuthFilter buildExternalAuth() {
    return this.externalAuth != null ? this.externalAuth.build() : null;
  }
  
  protected void copyInstance(ListenerFilter instance) {
    instance = instance != null ? instance : new ListenerFilter();
    if (instance != null) {
        this.withExtensionRef(instance.getExtensionRef());
        this.withExternalAuth(instance.getExternalAuth());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExtensionRefNested<A> editExtensionRef() {
    return this.withNewExtensionRefLike(Optional.ofNullable(this.buildExtensionRef()).orElse(null));
  }
  
  public ExternalAuthNested<A> editExternalAuth() {
    return this.withNewExternalAuthLike(Optional.ofNullable(this.buildExternalAuth()).orElse(null));
  }
  
  public ExtensionRefNested<A> editOrNewExtensionRef() {
    return this.withNewExtensionRefLike(Optional.ofNullable(this.buildExtensionRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ExtensionRefNested<A> editOrNewExtensionRefLike(LocalObjectReference item) {
    return this.withNewExtensionRefLike(Optional.ofNullable(this.buildExtensionRef()).orElse(item));
  }
  
  public ExternalAuthNested<A> editOrNewExternalAuth() {
    return this.withNewExternalAuthLike(Optional.ofNullable(this.buildExternalAuth()).orElse(new HTTPExternalAuthFilterBuilder().build()));
  }
  
  public ExternalAuthNested<A> editOrNewExternalAuthLike(HTTPExternalAuthFilter item) {
    return this.withNewExternalAuthLike(Optional.ofNullable(this.buildExternalAuth()).orElse(item));
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
    ListenerFilterFluent that = (ListenerFilterFluent) o;
    if (!(Objects.equals(extensionRef, that.extensionRef))) {
      return false;
    }
    if (!(Objects.equals(externalAuth, that.externalAuth))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExtensionRef() {
    return this.extensionRef != null;
  }
  
  public boolean hasExternalAuth() {
    return this.externalAuth != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(extensionRef, externalAuth, type, additionalProperties);
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
    if (!(extensionRef == null)) {
        sb.append("extensionRef:");
        sb.append(extensionRef);
        sb.append(",");
    }
    if (!(externalAuth == null)) {
        sb.append("externalAuth:");
        sb.append(externalAuth);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withExtensionRef(LocalObjectReference extensionRef) {
    this._visitables.remove("extensionRef");
    if (extensionRef != null) {
        this.extensionRef = new LocalObjectReferenceBuilder(extensionRef);
        this._visitables.get("extensionRef").add(this.extensionRef);
    } else {
        this.extensionRef = null;
        this._visitables.get("extensionRef").remove(this.extensionRef);
    }
    return (A) this;
  }
  
  public A withExternalAuth(HTTPExternalAuthFilter externalAuth) {
    this._visitables.remove("externalAuth");
    if (externalAuth != null) {
        this.externalAuth = new HTTPExternalAuthFilterBuilder(externalAuth);
        this._visitables.get("externalAuth").add(this.externalAuth);
    } else {
        this.externalAuth = null;
        this._visitables.get("externalAuth").remove(this.externalAuth);
    }
    return (A) this;
  }
  
  public ExtensionRefNested<A> withNewExtensionRef() {
    return new ExtensionRefNested(null);
  }
  
  public A withNewExtensionRef(String group,String kind,String name) {
    return (A) this.withExtensionRef(new LocalObjectReference(group, kind, name));
  }
  
  public ExtensionRefNested<A> withNewExtensionRefLike(LocalObjectReference item) {
    return new ExtensionRefNested(item);
  }
  
  public ExternalAuthNested<A> withNewExternalAuth() {
    return new ExternalAuthNested(null);
  }
  
  public ExternalAuthNested<A> withNewExternalAuthLike(HTTPExternalAuthFilter item) {
    return new ExternalAuthNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ExtensionRefNested<N> extends LocalObjectReferenceFluent<ExtensionRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ExtensionRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerFilterFluent.this.withExtensionRef(builder.build());
    }
    
    public N endExtensionRef() {
      return and();
    }
    
  }
  public class ExternalAuthNested<N> extends HTTPExternalAuthFilterFluent<ExternalAuthNested<N>> implements Nested<N>{
  
    HTTPExternalAuthFilterBuilder builder;
  
    ExternalAuthNested(HTTPExternalAuthFilter item) {
      this.builder = new HTTPExternalAuthFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerFilterFluent.this.withExternalAuth(builder.build());
    }
    
    public N endExternalAuth() {
      return and();
    }
    
  }
}