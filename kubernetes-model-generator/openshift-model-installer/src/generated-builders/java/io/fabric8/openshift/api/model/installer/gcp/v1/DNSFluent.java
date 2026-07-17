package io.fabric8.openshift.api.model.installer.gcp.v1;

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
public class DNSFluent<A extends io.fabric8.openshift.api.model.installer.gcp.v1.DNSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DNSZoneBuilder privateZone;

  public DNSFluent() {
  }
  
  public DNSFluent(DNS instance) {
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
  
  public DNSZone buildPrivateZone() {
    return this.privateZone != null ? this.privateZone.build() : null;
  }
  
  protected void copyInstance(DNS instance) {
    instance = instance != null ? instance : new DNS();
    if (instance != null) {
        this.withPrivateZone(instance.getPrivateZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PrivateZoneNested<A> editOrNewPrivateZone() {
    return this.withNewPrivateZoneLike(Optional.ofNullable(this.buildPrivateZone()).orElse(new DNSZoneBuilder().build()));
  }
  
  public PrivateZoneNested<A> editOrNewPrivateZoneLike(DNSZone item) {
    return this.withNewPrivateZoneLike(Optional.ofNullable(this.buildPrivateZone()).orElse(item));
  }
  
  public PrivateZoneNested<A> editPrivateZone() {
    return this.withNewPrivateZoneLike(Optional.ofNullable(this.buildPrivateZone()).orElse(null));
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
    DNSFluent that = (DNSFluent) o;
    if (!(Objects.equals(privateZone, that.privateZone))) {
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
  
  public boolean hasPrivateZone() {
    return this.privateZone != null;
  }
  
  public int hashCode() {
    return Objects.hash(privateZone, additionalProperties);
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
    if (!(privateZone == null)) {
        sb.append("privateZone:");
        sb.append(privateZone);
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
  
  public PrivateZoneNested<A> withNewPrivateZone() {
    return new PrivateZoneNested(null);
  }
  
  public A withNewPrivateZone(String name,String projectID) {
    return (A) this.withPrivateZone(new DNSZone(name, projectID));
  }
  
  public PrivateZoneNested<A> withNewPrivateZoneLike(DNSZone item) {
    return new PrivateZoneNested(item);
  }
  
  public A withPrivateZone(DNSZone privateZone) {
    this._visitables.remove("privateZone");
    if (privateZone != null) {
        this.privateZone = new DNSZoneBuilder(privateZone);
        this._visitables.get("privateZone").add(this.privateZone);
    } else {
        this.privateZone = null;
        this._visitables.get("privateZone").remove(this.privateZone);
    }
    return (A) this;
  }
  public class PrivateZoneNested<N> extends DNSZoneFluent<PrivateZoneNested<N>> implements Nested<N>{
  
    DNSZoneBuilder builder;
  
    PrivateZoneNested(DNSZone item) {
      this.builder = new DNSZoneBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSFluent.this.withPrivateZone(builder.build());
    }
    
    public N endPrivateZone() {
      return and();
    }
    
  }
}