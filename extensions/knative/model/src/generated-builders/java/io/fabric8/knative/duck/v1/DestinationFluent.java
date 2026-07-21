package io.fabric8.knative.duck.v1;

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
public class DestinationFluent<A extends io.fabric8.knative.duck.v1.DestinationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String audience;
  private String cACerts;
  private KReferenceBuilder ref;
  private String uri;

  public DestinationFluent() {
  }
  
  public DestinationFluent(Destination instance) {
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
  
  public KReference buildRef() {
    return this.ref != null ? this.ref.build() : null;
  }
  
  protected void copyInstance(Destination instance) {
    instance = instance != null ? instance : new Destination();
    if (instance != null) {
        this.withCACerts(instance.getCACerts());
        this.withAudience(instance.getAudience());
        this.withRef(instance.getRef());
        this.withUri(instance.getUri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RefNested<A> editOrNewRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(new KReferenceBuilder().build()));
  }
  
  public RefNested<A> editOrNewRefLike(KReference item) {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(item));
  }
  
  public RefNested<A> editRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(null));
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
    DestinationFluent that = (DestinationFluent) o;
    if (!(Objects.equals(cACerts, that.cACerts))) {
      return false;
    }
    if (!(Objects.equals(audience, that.audience))) {
      return false;
    }
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
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
  
  public String getAudience() {
    return this.audience;
  }
  
  public String getCACerts() {
    return this.cACerts;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAudience() {
    return this.audience != null;
  }
  
  public boolean hasCACerts() {
    return this.cACerts != null;
  }
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(cACerts, audience, ref, uri, additionalProperties);
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
    if (!(cACerts == null)) {
        sb.append("cACerts:");
        sb.append(cACerts);
        sb.append(",");
    }
    if (!(audience == null)) {
        sb.append("audience:");
        sb.append(audience);
        sb.append(",");
    }
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
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
  
  public A withAudience(String audience) {
    this.audience = audience;
    return (A) this;
  }
  
  public A withCACerts(String cACerts) {
    this.cACerts = cACerts;
    return (A) this;
  }
  
  public RefNested<A> withNewRef() {
    return new RefNested(null);
  }
  
  public RefNested<A> withNewRefLike(KReference item) {
    return new RefNested(item);
  }
  
  public A withRef(KReference ref) {
    this._visitables.remove("ref");
    if (ref != null) {
        this.ref = new KReferenceBuilder(ref);
        this._visitables.get("ref").add(this.ref);
    } else {
        this.ref = null;
        this._visitables.get("ref").remove(this.ref);
    }
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  public class RefNested<N> extends KReferenceFluent<RefNested<N>> implements Nested<N>{
  
    KReferenceBuilder builder;
  
    RefNested(KReference item) {
      this.builder = new KReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DestinationFluent.this.withRef(builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
}