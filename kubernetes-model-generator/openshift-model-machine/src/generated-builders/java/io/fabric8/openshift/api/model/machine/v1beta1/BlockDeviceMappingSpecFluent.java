package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class BlockDeviceMappingSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.BlockDeviceMappingSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String deviceName;
  private EBSBlockDeviceSpecBuilder ebs;
  private String noDevice;
  private String virtualName;

  public BlockDeviceMappingSpecFluent() {
  }
  
  public BlockDeviceMappingSpecFluent(BlockDeviceMappingSpec instance) {
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
  
  public EBSBlockDeviceSpec buildEbs() {
    return this.ebs != null ? this.ebs.build() : null;
  }
  
  protected void copyInstance(BlockDeviceMappingSpec instance) {
    instance = instance != null ? instance : new BlockDeviceMappingSpec();
    if (instance != null) {
        this.withDeviceName(instance.getDeviceName());
        this.withEbs(instance.getEbs());
        this.withNoDevice(instance.getNoDevice());
        this.withVirtualName(instance.getVirtualName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EbsNested<A> editEbs() {
    return this.withNewEbsLike(Optional.ofNullable(this.buildEbs()).orElse(null));
  }
  
  public EbsNested<A> editOrNewEbs() {
    return this.withNewEbsLike(Optional.ofNullable(this.buildEbs()).orElse(new EBSBlockDeviceSpecBuilder().build()));
  }
  
  public EbsNested<A> editOrNewEbsLike(EBSBlockDeviceSpec item) {
    return this.withNewEbsLike(Optional.ofNullable(this.buildEbs()).orElse(item));
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
    BlockDeviceMappingSpecFluent that = (BlockDeviceMappingSpecFluent) o;
    if (!(Objects.equals(deviceName, that.deviceName))) {
      return false;
    }
    if (!(Objects.equals(ebs, that.ebs))) {
      return false;
    }
    if (!(Objects.equals(noDevice, that.noDevice))) {
      return false;
    }
    if (!(Objects.equals(virtualName, that.virtualName))) {
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
  
  public String getDeviceName() {
    return this.deviceName;
  }
  
  public String getNoDevice() {
    return this.noDevice;
  }
  
  public String getVirtualName() {
    return this.virtualName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeviceName() {
    return this.deviceName != null;
  }
  
  public boolean hasEbs() {
    return this.ebs != null;
  }
  
  public boolean hasNoDevice() {
    return this.noDevice != null;
  }
  
  public boolean hasVirtualName() {
    return this.virtualName != null;
  }
  
  public int hashCode() {
    return Objects.hash(deviceName, ebs, noDevice, virtualName, additionalProperties);
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
    if (!(deviceName == null)) {
        sb.append("deviceName:");
        sb.append(deviceName);
        sb.append(",");
    }
    if (!(ebs == null)) {
        sb.append("ebs:");
        sb.append(ebs);
        sb.append(",");
    }
    if (!(noDevice == null)) {
        sb.append("noDevice:");
        sb.append(noDevice);
        sb.append(",");
    }
    if (!(virtualName == null)) {
        sb.append("virtualName:");
        sb.append(virtualName);
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
  
  public A withDeviceName(String deviceName) {
    this.deviceName = deviceName;
    return (A) this;
  }
  
  public A withEbs(EBSBlockDeviceSpec ebs) {
    this._visitables.remove("ebs");
    if (ebs != null) {
        this.ebs = new EBSBlockDeviceSpecBuilder(ebs);
        this._visitables.get("ebs").add(this.ebs);
    } else {
        this.ebs = null;
        this._visitables.get("ebs").remove(this.ebs);
    }
    return (A) this;
  }
  
  public EbsNested<A> withNewEbs() {
    return new EbsNested(null);
  }
  
  public EbsNested<A> withNewEbsLike(EBSBlockDeviceSpec item) {
    return new EbsNested(item);
  }
  
  public A withNoDevice(String noDevice) {
    this.noDevice = noDevice;
    return (A) this;
  }
  
  public A withVirtualName(String virtualName) {
    this.virtualName = virtualName;
    return (A) this;
  }
  public class EbsNested<N> extends EBSBlockDeviceSpecFluent<EbsNested<N>> implements Nested<N>{
  
    EBSBlockDeviceSpecBuilder builder;
  
    EbsNested(EBSBlockDeviceSpec item) {
      this.builder = new EBSBlockDeviceSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) BlockDeviceMappingSpecFluent.this.withEbs(builder.build());
    }
    
    public N endEbs() {
      return and();
    }
    
  }
}