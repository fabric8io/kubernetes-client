package io.fabric8.openshift.api.model.installer.baremetal.v1;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class HostFluent<A extends io.fabric8.openshift.api.model.installer.baremetal.v1.HostFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BMCBuilder bmc;
  private String bootMACAddress;
  private String bootMode;
  private String hardwareProfile;
  private String name;
  private JsonNode networkConfig;
  private String role;
  private RootDeviceHintsBuilder rootDeviceHints;

  public HostFluent() {
  }
  
  public HostFluent(Host instance) {
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
  
  public BMC buildBmc() {
    return this.bmc != null ? this.bmc.build() : null;
  }
  
  public RootDeviceHints buildRootDeviceHints() {
    return this.rootDeviceHints != null ? this.rootDeviceHints.build() : null;
  }
  
  protected void copyInstance(Host instance) {
    instance = instance != null ? instance : new Host();
    if (instance != null) {
        this.withBmc(instance.getBmc());
        this.withBootMACAddress(instance.getBootMACAddress());
        this.withBootMode(instance.getBootMode());
        this.withHardwareProfile(instance.getHardwareProfile());
        this.withName(instance.getName());
        this.withNetworkConfig(instance.getNetworkConfig());
        this.withRole(instance.getRole());
        this.withRootDeviceHints(instance.getRootDeviceHints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BmcNested<A> editBmc() {
    return this.withNewBmcLike(Optional.ofNullable(this.buildBmc()).orElse(null));
  }
  
  public BmcNested<A> editOrNewBmc() {
    return this.withNewBmcLike(Optional.ofNullable(this.buildBmc()).orElse(new BMCBuilder().build()));
  }
  
  public BmcNested<A> editOrNewBmcLike(BMC item) {
    return this.withNewBmcLike(Optional.ofNullable(this.buildBmc()).orElse(item));
  }
  
  public RootDeviceHintsNested<A> editOrNewRootDeviceHints() {
    return this.withNewRootDeviceHintsLike(Optional.ofNullable(this.buildRootDeviceHints()).orElse(new RootDeviceHintsBuilder().build()));
  }
  
  public RootDeviceHintsNested<A> editOrNewRootDeviceHintsLike(RootDeviceHints item) {
    return this.withNewRootDeviceHintsLike(Optional.ofNullable(this.buildRootDeviceHints()).orElse(item));
  }
  
  public RootDeviceHintsNested<A> editRootDeviceHints() {
    return this.withNewRootDeviceHintsLike(Optional.ofNullable(this.buildRootDeviceHints()).orElse(null));
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
    HostFluent that = (HostFluent) o;
    if (!(Objects.equals(bmc, that.bmc))) {
      return false;
    }
    if (!(Objects.equals(bootMACAddress, that.bootMACAddress))) {
      return false;
    }
    if (!(Objects.equals(bootMode, that.bootMode))) {
      return false;
    }
    if (!(Objects.equals(hardwareProfile, that.hardwareProfile))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(networkConfig, that.networkConfig))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(rootDeviceHints, that.rootDeviceHints))) {
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
  
  public String getBootMACAddress() {
    return this.bootMACAddress;
  }
  
  public String getBootMode() {
    return this.bootMode;
  }
  
  public String getHardwareProfile() {
    return this.hardwareProfile;
  }
  
  public String getName() {
    return this.name;
  }
  
  public JsonNode getNetworkConfig() {
    return this.networkConfig;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBmc() {
    return this.bmc != null;
  }
  
  public boolean hasBootMACAddress() {
    return this.bootMACAddress != null;
  }
  
  public boolean hasBootMode() {
    return this.bootMode != null;
  }
  
  public boolean hasHardwareProfile() {
    return this.hardwareProfile != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNetworkConfig() {
    return this.networkConfig != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasRootDeviceHints() {
    return this.rootDeviceHints != null;
  }
  
  public int hashCode() {
    return Objects.hash(bmc, bootMACAddress, bootMode, hardwareProfile, name, networkConfig, role, rootDeviceHints, additionalProperties);
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
    if (!(bmc == null)) {
        sb.append("bmc:");
        sb.append(bmc);
        sb.append(",");
    }
    if (!(bootMACAddress == null)) {
        sb.append("bootMACAddress:");
        sb.append(bootMACAddress);
        sb.append(",");
    }
    if (!(bootMode == null)) {
        sb.append("bootMode:");
        sb.append(bootMode);
        sb.append(",");
    }
    if (!(hardwareProfile == null)) {
        sb.append("hardwareProfile:");
        sb.append(hardwareProfile);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(networkConfig == null)) {
        sb.append("networkConfig:");
        sb.append(networkConfig);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
        sb.append(",");
    }
    if (!(rootDeviceHints == null)) {
        sb.append("rootDeviceHints:");
        sb.append(rootDeviceHints);
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
  
  public A withBmc(BMC bmc) {
    this._visitables.remove("bmc");
    if (bmc != null) {
        this.bmc = new BMCBuilder(bmc);
        this._visitables.get("bmc").add(this.bmc);
    } else {
        this.bmc = null;
        this._visitables.get("bmc").remove(this.bmc);
    }
    return (A) this;
  }
  
  public A withBootMACAddress(String bootMACAddress) {
    this.bootMACAddress = bootMACAddress;
    return (A) this;
  }
  
  public A withBootMode(String bootMode) {
    this.bootMode = bootMode;
    return (A) this;
  }
  
  public A withHardwareProfile(String hardwareProfile) {
    this.hardwareProfile = hardwareProfile;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNetworkConfig(JsonNode networkConfig) {
    this.networkConfig = networkConfig;
    return (A) this;
  }
  
  public BmcNested<A> withNewBmc() {
    return new BmcNested(null);
  }
  
  public A withNewBmc(String address,Boolean disableCertificateVerification,String password,String username) {
    return (A) this.withBmc(new BMC(address, disableCertificateVerification, password, username));
  }
  
  public BmcNested<A> withNewBmcLike(BMC item) {
    return new BmcNested(item);
  }
  
  public RootDeviceHintsNested<A> withNewRootDeviceHints() {
    return new RootDeviceHintsNested(null);
  }
  
  public RootDeviceHintsNested<A> withNewRootDeviceHintsLike(RootDeviceHints item) {
    return new RootDeviceHintsNested(item);
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withRootDeviceHints(RootDeviceHints rootDeviceHints) {
    this._visitables.remove("rootDeviceHints");
    if (rootDeviceHints != null) {
        this.rootDeviceHints = new RootDeviceHintsBuilder(rootDeviceHints);
        this._visitables.get("rootDeviceHints").add(this.rootDeviceHints);
    } else {
        this.rootDeviceHints = null;
        this._visitables.get("rootDeviceHints").remove(this.rootDeviceHints);
    }
    return (A) this;
  }
  public class BmcNested<N> extends BMCFluent<BmcNested<N>> implements Nested<N>{
  
    BMCBuilder builder;
  
    BmcNested(BMC item) {
      this.builder = new BMCBuilder(this, item);
    }
  
    public N and() {
      return (N) HostFluent.this.withBmc(builder.build());
    }
    
    public N endBmc() {
      return and();
    }
    
  }
  public class RootDeviceHintsNested<N> extends RootDeviceHintsFluent<RootDeviceHintsNested<N>> implements Nested<N>{
  
    RootDeviceHintsBuilder builder;
  
    RootDeviceHintsNested(RootDeviceHints item) {
      this.builder = new RootDeviceHintsBuilder(this, item);
    }
  
    public N and() {
      return (N) HostFluent.this.withRootDeviceHints(builder.build());
    }
    
    public N endRootDeviceHints() {
      return and();
    }
    
  }
}