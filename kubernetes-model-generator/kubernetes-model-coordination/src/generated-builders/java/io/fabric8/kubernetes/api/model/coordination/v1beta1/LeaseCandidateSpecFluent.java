package io.fabric8.kubernetes.api.model.coordination.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.MicroTime;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class LeaseCandidateSpecFluent<A extends io.fabric8.kubernetes.api.model.coordination.v1beta1.LeaseCandidateSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String binaryVersion;
  private String emulationVersion;
  private String leaseName;
  private MicroTime pingTime;
  private MicroTime renewTime;
  private String strategy;

  public LeaseCandidateSpecFluent() {
  }
  
  public LeaseCandidateSpecFluent(LeaseCandidateSpec instance) {
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
  
  protected void copyInstance(LeaseCandidateSpec instance) {
    instance = instance != null ? instance : new LeaseCandidateSpec();
    if (instance != null) {
        this.withBinaryVersion(instance.getBinaryVersion());
        this.withEmulationVersion(instance.getEmulationVersion());
        this.withLeaseName(instance.getLeaseName());
        this.withPingTime(instance.getPingTime());
        this.withRenewTime(instance.getRenewTime());
        this.withStrategy(instance.getStrategy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    LeaseCandidateSpecFluent that = (LeaseCandidateSpecFluent) o;
    if (!(Objects.equals(binaryVersion, that.binaryVersion))) {
      return false;
    }
    if (!(Objects.equals(emulationVersion, that.emulationVersion))) {
      return false;
    }
    if (!(Objects.equals(leaseName, that.leaseName))) {
      return false;
    }
    if (!(Objects.equals(pingTime, that.pingTime))) {
      return false;
    }
    if (!(Objects.equals(renewTime, that.renewTime))) {
      return false;
    }
    if (!(Objects.equals(strategy, that.strategy))) {
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
  
  public String getBinaryVersion() {
    return this.binaryVersion;
  }
  
  public String getEmulationVersion() {
    return this.emulationVersion;
  }
  
  public String getLeaseName() {
    return this.leaseName;
  }
  
  public MicroTime getPingTime() {
    return this.pingTime;
  }
  
  public MicroTime getRenewTime() {
    return this.renewTime;
  }
  
  public String getStrategy() {
    return this.strategy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBinaryVersion() {
    return this.binaryVersion != null;
  }
  
  public boolean hasEmulationVersion() {
    return this.emulationVersion != null;
  }
  
  public boolean hasLeaseName() {
    return this.leaseName != null;
  }
  
  public boolean hasPingTime() {
    return this.pingTime != null;
  }
  
  public boolean hasRenewTime() {
    return this.renewTime != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(binaryVersion, emulationVersion, leaseName, pingTime, renewTime, strategy, additionalProperties);
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
    if (!(binaryVersion == null)) {
        sb.append("binaryVersion:");
        sb.append(binaryVersion);
        sb.append(",");
    }
    if (!(emulationVersion == null)) {
        sb.append("emulationVersion:");
        sb.append(emulationVersion);
        sb.append(",");
    }
    if (!(leaseName == null)) {
        sb.append("leaseName:");
        sb.append(leaseName);
        sb.append(",");
    }
    if (!(pingTime == null)) {
        sb.append("pingTime:");
        sb.append(pingTime);
        sb.append(",");
    }
    if (!(renewTime == null)) {
        sb.append("renewTime:");
        sb.append(renewTime);
        sb.append(",");
    }
    if (!(strategy == null)) {
        sb.append("strategy:");
        sb.append(strategy);
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
  
  public A withBinaryVersion(String binaryVersion) {
    this.binaryVersion = binaryVersion;
    return (A) this;
  }
  
  public A withEmulationVersion(String emulationVersion) {
    this.emulationVersion = emulationVersion;
    return (A) this;
  }
  
  public A withLeaseName(String leaseName) {
    this.leaseName = leaseName;
    return (A) this;
  }
  
  public A withNewPingTime(String time) {
    return (A) this.withPingTime(new MicroTime(time));
  }
  
  public A withNewRenewTime(String time) {
    return (A) this.withRenewTime(new MicroTime(time));
  }
  
  public A withPingTime(MicroTime pingTime) {
    this.pingTime = pingTime;
    return (A) this;
  }
  
  public A withRenewTime(MicroTime renewTime) {
    this.renewTime = renewTime;
    return (A) this;
  }
  
  public A withStrategy(String strategy) {
    this.strategy = strategy;
    return (A) this;
  }
  
}