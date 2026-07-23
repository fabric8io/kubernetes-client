package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class FirmwareFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.FirmwareFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BIOSBuilder bios;

  public FirmwareFluent() {
  }
  
  public FirmwareFluent(Firmware instance) {
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
  
  public BIOS buildBios() {
    return this.bios != null ? this.bios.build() : null;
  }
  
  protected void copyInstance(Firmware instance) {
    instance = instance != null ? instance : new Firmware();
    if (instance != null) {
        this.withBios(instance.getBios());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BiosNested<A> editBios() {
    return this.withNewBiosLike(Optional.ofNullable(this.buildBios()).orElse(null));
  }
  
  public BiosNested<A> editOrNewBios() {
    return this.withNewBiosLike(Optional.ofNullable(this.buildBios()).orElse(new BIOSBuilder().build()));
  }
  
  public BiosNested<A> editOrNewBiosLike(BIOS item) {
    return this.withNewBiosLike(Optional.ofNullable(this.buildBios()).orElse(item));
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
    FirmwareFluent that = (FirmwareFluent) o;
    if (!(Objects.equals(bios, that.bios))) {
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
  
  public boolean hasBios() {
    return this.bios != null;
  }
  
  public int hashCode() {
    return Objects.hash(bios, additionalProperties);
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
    if (!(bios == null)) {
        sb.append("bios:");
        sb.append(bios);
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
  
  public A withBios(BIOS bios) {
    this._visitables.remove("bios");
    if (bios != null) {
        this.bios = new BIOSBuilder(bios);
        this._visitables.get("bios").add(this.bios);
    } else {
        this.bios = null;
        this._visitables.get("bios").remove(this.bios);
    }
    return (A) this;
  }
  
  public BiosNested<A> withNewBios() {
    return new BiosNested(null);
  }
  
  public A withNewBios(String date,String vendor,String version) {
    return (A) this.withBios(new BIOS(date, vendor, version));
  }
  
  public BiosNested<A> withNewBiosLike(BIOS item) {
    return new BiosNested(item);
  }
  public class BiosNested<N> extends BIOSFluent<BiosNested<N>> implements Nested<N>{
  
    BIOSBuilder builder;
  
    BiosNested(BIOS item) {
      this.builder = new BIOSBuilder(this, item);
    }
  
    public N and() {
      return (N) FirmwareFluent.this.withBios(builder.build());
    }
    
    public N endBios() {
      return and();
    }
    
  }
}