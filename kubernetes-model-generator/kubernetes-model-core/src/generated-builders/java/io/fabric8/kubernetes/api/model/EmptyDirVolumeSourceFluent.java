package io.fabric8.kubernetes.api.model;

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
public class EmptyDirVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.EmptyDirVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String medium;
  private QuantityBuilder sizeLimit;

  public EmptyDirVolumeSourceFluent() {
  }
  
  public EmptyDirVolumeSourceFluent(EmptyDirVolumeSource instance) {
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
  
  public Quantity buildSizeLimit() {
    return this.sizeLimit != null ? this.sizeLimit.build() : null;
  }
  
  protected void copyInstance(EmptyDirVolumeSource instance) {
    instance = instance != null ? instance : new EmptyDirVolumeSource();
    if (instance != null) {
        this.withMedium(instance.getMedium());
        this.withSizeLimit(instance.getSizeLimit());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SizeLimitNested<A> editOrNewSizeLimit() {
    return this.withNewSizeLimitLike(Optional.ofNullable(this.buildSizeLimit()).orElse(new QuantityBuilder().build()));
  }
  
  public SizeLimitNested<A> editOrNewSizeLimitLike(Quantity item) {
    return this.withNewSizeLimitLike(Optional.ofNullable(this.buildSizeLimit()).orElse(item));
  }
  
  public SizeLimitNested<A> editSizeLimit() {
    return this.withNewSizeLimitLike(Optional.ofNullable(this.buildSizeLimit()).orElse(null));
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
    EmptyDirVolumeSourceFluent that = (EmptyDirVolumeSourceFluent) o;
    if (!(Objects.equals(medium, that.medium))) {
      return false;
    }
    if (!(Objects.equals(sizeLimit, that.sizeLimit))) {
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
  
  public String getMedium() {
    return this.medium;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMedium() {
    return this.medium != null;
  }
  
  public boolean hasSizeLimit() {
    return this.sizeLimit != null;
  }
  
  public int hashCode() {
    return Objects.hash(medium, sizeLimit, additionalProperties);
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
    if (!(medium == null)) {
        sb.append("medium:");
        sb.append(medium);
        sb.append(",");
    }
    if (!(sizeLimit == null)) {
        sb.append("sizeLimit:");
        sb.append(sizeLimit);
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
  
  public A withMedium(String medium) {
    this.medium = medium;
    return (A) this;
  }
  
  public SizeLimitNested<A> withNewSizeLimit() {
    return new SizeLimitNested(null);
  }
  
  public A withNewSizeLimit(String amount) {
    return (A) this.withSizeLimit(new Quantity(amount));
  }
  
  public A withNewSizeLimit(String amount,String format) {
    return (A) this.withSizeLimit(new Quantity(amount, format));
  }
  
  public SizeLimitNested<A> withNewSizeLimitLike(Quantity item) {
    return new SizeLimitNested(item);
  }
  
  public A withSizeLimit(Quantity sizeLimit) {
    this._visitables.remove("sizeLimit");
    if (sizeLimit != null) {
        this.sizeLimit = new QuantityBuilder(sizeLimit);
        this._visitables.get("sizeLimit").add(this.sizeLimit);
    } else {
        this.sizeLimit = null;
        this._visitables.get("sizeLimit").remove(this.sizeLimit);
    }
    return (A) this;
  }
  public class SizeLimitNested<N> extends QuantityFluent<SizeLimitNested<N>> implements Nested<N>{
  
    QuantityBuilder builder;
  
    SizeLimitNested(Quantity item) {
      this.builder = new QuantityBuilder(this, item);
    }
  
    public N and() {
      return (N) EmptyDirVolumeSourceFluent.this.withSizeLimit(builder.build());
    }
    
    public N endSizeLimit() {
      return and();
    }
    
  }
}