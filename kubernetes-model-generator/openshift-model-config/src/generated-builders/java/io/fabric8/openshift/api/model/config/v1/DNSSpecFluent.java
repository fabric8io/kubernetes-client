package io.fabric8.openshift.api.model.config.v1;

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
public class DNSSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.DNSSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseDomain;
  private DNSPlatformSpecBuilder platform;
  private DNSZoneBuilder privateZone;
  private DNSZoneBuilder publicZone;

  public DNSSpecFluent() {
  }
  
  public DNSSpecFluent(DNSSpec instance) {
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
  
  public DNSPlatformSpec buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  public DNSZone buildPrivateZone() {
    return this.privateZone != null ? this.privateZone.build() : null;
  }
  
  public DNSZone buildPublicZone() {
    return this.publicZone != null ? this.publicZone.build() : null;
  }
  
  protected void copyInstance(DNSSpec instance) {
    instance = instance != null ? instance : new DNSSpec();
    if (instance != null) {
        this.withBaseDomain(instance.getBaseDomain());
        this.withPlatform(instance.getPlatform());
        this.withPrivateZone(instance.getPrivateZone());
        this.withPublicZone(instance.getPublicZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new DNSPlatformSpecBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(DNSPlatformSpec item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public PrivateZoneNested<A> editOrNewPrivateZone() {
    return this.withNewPrivateZoneLike(Optional.ofNullable(this.buildPrivateZone()).orElse(new DNSZoneBuilder().build()));
  }
  
  public PrivateZoneNested<A> editOrNewPrivateZoneLike(DNSZone item) {
    return this.withNewPrivateZoneLike(Optional.ofNullable(this.buildPrivateZone()).orElse(item));
  }
  
  public PublicZoneNested<A> editOrNewPublicZone() {
    return this.withNewPublicZoneLike(Optional.ofNullable(this.buildPublicZone()).orElse(new DNSZoneBuilder().build()));
  }
  
  public PublicZoneNested<A> editOrNewPublicZoneLike(DNSZone item) {
    return this.withNewPublicZoneLike(Optional.ofNullable(this.buildPublicZone()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
  }
  
  public PrivateZoneNested<A> editPrivateZone() {
    return this.withNewPrivateZoneLike(Optional.ofNullable(this.buildPrivateZone()).orElse(null));
  }
  
  public PublicZoneNested<A> editPublicZone() {
    return this.withNewPublicZoneLike(Optional.ofNullable(this.buildPublicZone()).orElse(null));
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
    DNSSpecFluent that = (DNSSpecFluent) o;
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(privateZone, that.privateZone))) {
      return false;
    }
    if (!(Objects.equals(publicZone, that.publicZone))) {
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
  
  public String getBaseDomain() {
    return this.baseDomain;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseDomain() {
    return this.baseDomain != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasPrivateZone() {
    return this.privateZone != null;
  }
  
  public boolean hasPublicZone() {
    return this.publicZone != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseDomain, platform, privateZone, publicZone, additionalProperties);
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
    if (!(baseDomain == null)) {
        sb.append("baseDomain:");
        sb.append(baseDomain);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(privateZone == null)) {
        sb.append("privateZone:");
        sb.append(privateZone);
        sb.append(",");
    }
    if (!(publicZone == null)) {
        sb.append("publicZone:");
        sb.append(publicZone);
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
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(DNSPlatformSpec item) {
    return new PlatformNested(item);
  }
  
  public PrivateZoneNested<A> withNewPrivateZone() {
    return new PrivateZoneNested(null);
  }
  
  public PrivateZoneNested<A> withNewPrivateZoneLike(DNSZone item) {
    return new PrivateZoneNested(item);
  }
  
  public PublicZoneNested<A> withNewPublicZone() {
    return new PublicZoneNested(null);
  }
  
  public PublicZoneNested<A> withNewPublicZoneLike(DNSZone item) {
    return new PublicZoneNested(item);
  }
  
  public A withPlatform(DNSPlatformSpec platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new DNSPlatformSpecBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
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
  
  public A withPublicZone(DNSZone publicZone) {
    this._visitables.remove("publicZone");
    if (publicZone != null) {
        this.publicZone = new DNSZoneBuilder(publicZone);
        this._visitables.get("publicZone").add(this.publicZone);
    } else {
        this.publicZone = null;
        this._visitables.get("publicZone").remove(this.publicZone);
    }
    return (A) this;
  }
  public class PlatformNested<N> extends DNSPlatformSpecFluent<PlatformNested<N>> implements Nested<N>{
  
    DNSPlatformSpecBuilder builder;
  
    PlatformNested(DNSPlatformSpec item) {
      this.builder = new DNSPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSSpecFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
  public class PrivateZoneNested<N> extends DNSZoneFluent<PrivateZoneNested<N>> implements Nested<N>{
  
    DNSZoneBuilder builder;
  
    PrivateZoneNested(DNSZone item) {
      this.builder = new DNSZoneBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSSpecFluent.this.withPrivateZone(builder.build());
    }
    
    public N endPrivateZone() {
      return and();
    }
    
  }
  public class PublicZoneNested<N> extends DNSZoneFluent<PublicZoneNested<N>> implements Nested<N>{
  
    DNSZoneBuilder builder;
  
    PublicZoneNested(DNSZone item) {
      this.builder = new DNSZoneBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSSpecFluent.this.withPublicZone(builder.build());
    }
    
    public N endPublicZone() {
      return and();
    }
    
  }
}