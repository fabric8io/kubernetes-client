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
public class InfrastructureStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.InfrastructureStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiServerInternalURI;
  private String apiServerURL;
  private String controlPlaneTopology;
  private String cpuPartitioning;
  private String etcdDiscoveryDomain;
  private String infrastructureName;
  private String infrastructureTopology;
  private String platform;
  private PlatformStatusBuilder platformStatus;

  public InfrastructureStatusFluent() {
  }
  
  public InfrastructureStatusFluent(InfrastructureStatus instance) {
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
  
  public PlatformStatus buildPlatformStatus() {
    return this.platformStatus != null ? this.platformStatus.build() : null;
  }
  
  protected void copyInstance(InfrastructureStatus instance) {
    instance = instance != null ? instance : new InfrastructureStatus();
    if (instance != null) {
        this.withApiServerInternalURI(instance.getApiServerInternalURI());
        this.withApiServerURL(instance.getApiServerURL());
        this.withControlPlaneTopology(instance.getControlPlaneTopology());
        this.withCpuPartitioning(instance.getCpuPartitioning());
        this.withEtcdDiscoveryDomain(instance.getEtcdDiscoveryDomain());
        this.withInfrastructureName(instance.getInfrastructureName());
        this.withInfrastructureTopology(instance.getInfrastructureTopology());
        this.withPlatform(instance.getPlatform());
        this.withPlatformStatus(instance.getPlatformStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PlatformStatusNested<A> editOrNewPlatformStatus() {
    return this.withNewPlatformStatusLike(Optional.ofNullable(this.buildPlatformStatus()).orElse(new PlatformStatusBuilder().build()));
  }
  
  public PlatformStatusNested<A> editOrNewPlatformStatusLike(PlatformStatus item) {
    return this.withNewPlatformStatusLike(Optional.ofNullable(this.buildPlatformStatus()).orElse(item));
  }
  
  public PlatformStatusNested<A> editPlatformStatus() {
    return this.withNewPlatformStatusLike(Optional.ofNullable(this.buildPlatformStatus()).orElse(null));
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
    InfrastructureStatusFluent that = (InfrastructureStatusFluent) o;
    if (!(Objects.equals(apiServerInternalURI, that.apiServerInternalURI))) {
      return false;
    }
    if (!(Objects.equals(apiServerURL, that.apiServerURL))) {
      return false;
    }
    if (!(Objects.equals(controlPlaneTopology, that.controlPlaneTopology))) {
      return false;
    }
    if (!(Objects.equals(cpuPartitioning, that.cpuPartitioning))) {
      return false;
    }
    if (!(Objects.equals(etcdDiscoveryDomain, that.etcdDiscoveryDomain))) {
      return false;
    }
    if (!(Objects.equals(infrastructureName, that.infrastructureName))) {
      return false;
    }
    if (!(Objects.equals(infrastructureTopology, that.infrastructureTopology))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(platformStatus, that.platformStatus))) {
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
  
  public String getApiServerInternalURI() {
    return this.apiServerInternalURI;
  }
  
  public String getApiServerURL() {
    return this.apiServerURL;
  }
  
  public String getControlPlaneTopology() {
    return this.controlPlaneTopology;
  }
  
  public String getCpuPartitioning() {
    return this.cpuPartitioning;
  }
  
  public String getEtcdDiscoveryDomain() {
    return this.etcdDiscoveryDomain;
  }
  
  public String getInfrastructureName() {
    return this.infrastructureName;
  }
  
  public String getInfrastructureTopology() {
    return this.infrastructureTopology;
  }
  
  public String getPlatform() {
    return this.platform;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiServerInternalURI() {
    return this.apiServerInternalURI != null;
  }
  
  public boolean hasApiServerURL() {
    return this.apiServerURL != null;
  }
  
  public boolean hasControlPlaneTopology() {
    return this.controlPlaneTopology != null;
  }
  
  public boolean hasCpuPartitioning() {
    return this.cpuPartitioning != null;
  }
  
  public boolean hasEtcdDiscoveryDomain() {
    return this.etcdDiscoveryDomain != null;
  }
  
  public boolean hasInfrastructureName() {
    return this.infrastructureName != null;
  }
  
  public boolean hasInfrastructureTopology() {
    return this.infrastructureTopology != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasPlatformStatus() {
    return this.platformStatus != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiServerInternalURI, apiServerURL, controlPlaneTopology, cpuPartitioning, etcdDiscoveryDomain, infrastructureName, infrastructureTopology, platform, platformStatus, additionalProperties);
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
    if (!(apiServerInternalURI == null)) {
        sb.append("apiServerInternalURI:");
        sb.append(apiServerInternalURI);
        sb.append(",");
    }
    if (!(apiServerURL == null)) {
        sb.append("apiServerURL:");
        sb.append(apiServerURL);
        sb.append(",");
    }
    if (!(controlPlaneTopology == null)) {
        sb.append("controlPlaneTopology:");
        sb.append(controlPlaneTopology);
        sb.append(",");
    }
    if (!(cpuPartitioning == null)) {
        sb.append("cpuPartitioning:");
        sb.append(cpuPartitioning);
        sb.append(",");
    }
    if (!(etcdDiscoveryDomain == null)) {
        sb.append("etcdDiscoveryDomain:");
        sb.append(etcdDiscoveryDomain);
        sb.append(",");
    }
    if (!(infrastructureName == null)) {
        sb.append("infrastructureName:");
        sb.append(infrastructureName);
        sb.append(",");
    }
    if (!(infrastructureTopology == null)) {
        sb.append("infrastructureTopology:");
        sb.append(infrastructureTopology);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(platformStatus == null)) {
        sb.append("platformStatus:");
        sb.append(platformStatus);
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
  
  public A withApiServerInternalURI(String apiServerInternalURI) {
    this.apiServerInternalURI = apiServerInternalURI;
    return (A) this;
  }
  
  public A withApiServerURL(String apiServerURL) {
    this.apiServerURL = apiServerURL;
    return (A) this;
  }
  
  public A withControlPlaneTopology(String controlPlaneTopology) {
    this.controlPlaneTopology = controlPlaneTopology;
    return (A) this;
  }
  
  public A withCpuPartitioning(String cpuPartitioning) {
    this.cpuPartitioning = cpuPartitioning;
    return (A) this;
  }
  
  public A withEtcdDiscoveryDomain(String etcdDiscoveryDomain) {
    this.etcdDiscoveryDomain = etcdDiscoveryDomain;
    return (A) this;
  }
  
  public A withInfrastructureName(String infrastructureName) {
    this.infrastructureName = infrastructureName;
    return (A) this;
  }
  
  public A withInfrastructureTopology(String infrastructureTopology) {
    this.infrastructureTopology = infrastructureTopology;
    return (A) this;
  }
  
  public PlatformStatusNested<A> withNewPlatformStatus() {
    return new PlatformStatusNested(null);
  }
  
  public PlatformStatusNested<A> withNewPlatformStatusLike(PlatformStatus item) {
    return new PlatformStatusNested(item);
  }
  
  public A withPlatform(String platform) {
    this.platform = platform;
    return (A) this;
  }
  
  public A withPlatformStatus(PlatformStatus platformStatus) {
    this._visitables.remove("platformStatus");
    if (platformStatus != null) {
        this.platformStatus = new PlatformStatusBuilder(platformStatus);
        this._visitables.get("platformStatus").add(this.platformStatus);
    } else {
        this.platformStatus = null;
        this._visitables.get("platformStatus").remove(this.platformStatus);
    }
    return (A) this;
  }
  public class PlatformStatusNested<N> extends PlatformStatusFluent<PlatformStatusNested<N>> implements Nested<N>{
  
    PlatformStatusBuilder builder;
  
    PlatformStatusNested(PlatformStatus item) {
      this.builder = new PlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) InfrastructureStatusFluent.this.withPlatformStatus(builder.build());
    }
    
    public N endPlatformStatus() {
      return and();
    }
    
  }
}