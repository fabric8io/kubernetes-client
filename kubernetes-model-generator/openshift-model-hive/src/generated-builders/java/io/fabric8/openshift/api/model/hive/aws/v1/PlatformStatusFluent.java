package io.fabric8.openshift.api.model.hive.aws.v1;

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
public class PlatformStatusFluent<A extends io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PrivateLinkAccessStatusBuilder privateLink;

  public PlatformStatusFluent() {
  }
  
  public PlatformStatusFluent(PlatformStatus instance) {
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
  
  public PrivateLinkAccessStatus buildPrivateLink() {
    return this.privateLink != null ? this.privateLink.build() : null;
  }
  
  protected void copyInstance(PlatformStatus instance) {
    instance = instance != null ? instance : new PlatformStatus();
    if (instance != null) {
        this.withPrivateLink(instance.getPrivateLink());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PrivateLinkNested<A> editOrNewPrivateLink() {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(new PrivateLinkAccessStatusBuilder().build()));
  }
  
  public PrivateLinkNested<A> editOrNewPrivateLinkLike(PrivateLinkAccessStatus item) {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(item));
  }
  
  public PrivateLinkNested<A> editPrivateLink() {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(null));
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
    PlatformStatusFluent that = (PlatformStatusFluent) o;
    if (!(Objects.equals(privateLink, that.privateLink))) {
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
  
  public boolean hasPrivateLink() {
    return this.privateLink != null;
  }
  
  public int hashCode() {
    return Objects.hash(privateLink, additionalProperties);
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
    if (!(privateLink == null)) {
        sb.append("privateLink:");
        sb.append(privateLink);
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
  
  public PrivateLinkNested<A> withNewPrivateLink() {
    return new PrivateLinkNested(null);
  }
  
  public PrivateLinkNested<A> withNewPrivateLinkLike(PrivateLinkAccessStatus item) {
    return new PrivateLinkNested(item);
  }
  
  public A withPrivateLink(PrivateLinkAccessStatus privateLink) {
    this._visitables.remove("privateLink");
    if (privateLink != null) {
        this.privateLink = new PrivateLinkAccessStatusBuilder(privateLink);
        this._visitables.get("privateLink").add(this.privateLink);
    } else {
        this.privateLink = null;
        this._visitables.get("privateLink").remove(this.privateLink);
    }
    return (A) this;
  }
  public class PrivateLinkNested<N> extends PrivateLinkAccessStatusFluent<PrivateLinkNested<N>> implements Nested<N>{
  
    PrivateLinkAccessStatusBuilder builder;
  
    PrivateLinkNested(PrivateLinkAccessStatus item) {
      this.builder = new PrivateLinkAccessStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withPrivateLink(builder.build());
    }
    
    public N endPrivateLink() {
      return and();
    }
    
  }
}