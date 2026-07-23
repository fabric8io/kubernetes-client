package io.fabric8.openshift.api.model.machine.v1;

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
public class OpenStackFailureDomainFluent<A extends io.fabric8.openshift.api.model.machine.v1.OpenStackFailureDomainFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String availabilityZone;
  private RootVolumeBuilder rootVolume;

  public OpenStackFailureDomainFluent() {
  }
  
  public OpenStackFailureDomainFluent(OpenStackFailureDomain instance) {
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
  
  public RootVolume buildRootVolume() {
    return this.rootVolume != null ? this.rootVolume.build() : null;
  }
  
  protected void copyInstance(OpenStackFailureDomain instance) {
    instance = instance != null ? instance : new OpenStackFailureDomain();
    if (instance != null) {
        this.withAvailabilityZone(instance.getAvailabilityZone());
        this.withRootVolume(instance.getRootVolume());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RootVolumeNested<A> editOrNewRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(new RootVolumeBuilder().build()));
  }
  
  public RootVolumeNested<A> editOrNewRootVolumeLike(RootVolume item) {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(item));
  }
  
  public RootVolumeNested<A> editRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(null));
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
    OpenStackFailureDomainFluent that = (OpenStackFailureDomainFluent) o;
    if (!(Objects.equals(availabilityZone, that.availabilityZone))) {
      return false;
    }
    if (!(Objects.equals(rootVolume, that.rootVolume))) {
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
  
  public String getAvailabilityZone() {
    return this.availabilityZone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailabilityZone() {
    return this.availabilityZone != null;
  }
  
  public boolean hasRootVolume() {
    return this.rootVolume != null;
  }
  
  public int hashCode() {
    return Objects.hash(availabilityZone, rootVolume, additionalProperties);
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
    if (!(availabilityZone == null)) {
        sb.append("availabilityZone:");
        sb.append(availabilityZone);
        sb.append(",");
    }
    if (!(rootVolume == null)) {
        sb.append("rootVolume:");
        sb.append(rootVolume);
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
  
  public A withAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return (A) this;
  }
  
  public RootVolumeNested<A> withNewRootVolume() {
    return new RootVolumeNested(null);
  }
  
  public A withNewRootVolume(String availabilityZone,String volumeType) {
    return (A) this.withRootVolume(new RootVolume(availabilityZone, volumeType));
  }
  
  public RootVolumeNested<A> withNewRootVolumeLike(RootVolume item) {
    return new RootVolumeNested(item);
  }
  
  public A withRootVolume(RootVolume rootVolume) {
    this._visitables.remove("rootVolume");
    if (rootVolume != null) {
        this.rootVolume = new RootVolumeBuilder(rootVolume);
        this._visitables.get("rootVolume").add(this.rootVolume);
    } else {
        this.rootVolume = null;
        this._visitables.get("rootVolume").remove(this.rootVolume);
    }
    return (A) this;
  }
  public class RootVolumeNested<N> extends RootVolumeFluent<RootVolumeNested<N>> implements Nested<N>{
  
    RootVolumeBuilder builder;
  
    RootVolumeNested(RootVolume item) {
      this.builder = new RootVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenStackFailureDomainFluent.this.withRootVolume(builder.build());
    }
    
    public N endRootVolume() {
      return and();
    }
    
  }
}