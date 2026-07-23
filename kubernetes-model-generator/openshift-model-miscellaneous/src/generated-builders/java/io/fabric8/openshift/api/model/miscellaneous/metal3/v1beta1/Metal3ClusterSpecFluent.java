package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.FailureDomainSpec;
import java.lang.Boolean;
import java.lang.Integer;
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
public class Metal3ClusterSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3ClusterSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean cloudProviderEnabled;
  private APIEndpointBuilder controlPlaneEndpoint;
  private Map<String,FailureDomainSpec> failureDomains;
  private Boolean noCloudProvider;

  public Metal3ClusterSpecFluent() {
  }
  
  public Metal3ClusterSpecFluent(Metal3ClusterSpec instance) {
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
  
  public A addToFailureDomains(Map<String,FailureDomainSpec> map) {
    if (this.failureDomains == null && map != null) {
      this.failureDomains = new LinkedHashMap();
    }
    if (map != null) {
      this.failureDomains.putAll(map);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(String key,FailureDomainSpec value) {
    if (this.failureDomains == null && key != null && value != null) {
      this.failureDomains = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.failureDomains.put(key, value);
    }
    return (A) this;
  }
  
  public APIEndpoint buildControlPlaneEndpoint() {
    return this.controlPlaneEndpoint != null ? this.controlPlaneEndpoint.build() : null;
  }
  
  protected void copyInstance(Metal3ClusterSpec instance) {
    instance = instance != null ? instance : new Metal3ClusterSpec();
    if (instance != null) {
        this.withCloudProviderEnabled(instance.getCloudProviderEnabled());
        this.withControlPlaneEndpoint(instance.getControlPlaneEndpoint());
        this.withFailureDomains(instance.getFailureDomains());
        this.withNoCloudProvider(instance.getNoCloudProvider());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ControlPlaneEndpointNested<A> editControlPlaneEndpoint() {
    return this.withNewControlPlaneEndpointLike(Optional.ofNullable(this.buildControlPlaneEndpoint()).orElse(null));
  }
  
  public ControlPlaneEndpointNested<A> editOrNewControlPlaneEndpoint() {
    return this.withNewControlPlaneEndpointLike(Optional.ofNullable(this.buildControlPlaneEndpoint()).orElse(new APIEndpointBuilder().build()));
  }
  
  public ControlPlaneEndpointNested<A> editOrNewControlPlaneEndpointLike(APIEndpoint item) {
    return this.withNewControlPlaneEndpointLike(Optional.ofNullable(this.buildControlPlaneEndpoint()).orElse(item));
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
    Metal3ClusterSpecFluent that = (Metal3ClusterSpecFluent) o;
    if (!(Objects.equals(cloudProviderEnabled, that.cloudProviderEnabled))) {
      return false;
    }
    if (!(Objects.equals(controlPlaneEndpoint, that.controlPlaneEndpoint))) {
      return false;
    }
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(noCloudProvider, that.noCloudProvider))) {
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
  
  public Boolean getCloudProviderEnabled() {
    return this.cloudProviderEnabled;
  }
  
  public Map<String,FailureDomainSpec> getFailureDomains() {
    return this.failureDomains;
  }
  
  public Boolean getNoCloudProvider() {
    return this.noCloudProvider;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloudProviderEnabled() {
    return this.cloudProviderEnabled != null;
  }
  
  public boolean hasControlPlaneEndpoint() {
    return this.controlPlaneEndpoint != null;
  }
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null;
  }
  
  public boolean hasNoCloudProvider() {
    return this.noCloudProvider != null;
  }
  
  public int hashCode() {
    return Objects.hash(cloudProviderEnabled, controlPlaneEndpoint, failureDomains, noCloudProvider, additionalProperties);
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
  
  public A removeFromFailureDomains(String key) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    if (key != null && this.failureDomains != null) {
      this.failureDomains.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromFailureDomains(Map<String,FailureDomainSpec> map) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.failureDomains != null) {
          this.failureDomains.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cloudProviderEnabled == null)) {
        sb.append("cloudProviderEnabled:");
        sb.append(cloudProviderEnabled);
        sb.append(",");
    }
    if (!(controlPlaneEndpoint == null)) {
        sb.append("controlPlaneEndpoint:");
        sb.append(controlPlaneEndpoint);
        sb.append(",");
    }
    if (!(failureDomains == null) && !(failureDomains.isEmpty())) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(noCloudProvider == null)) {
        sb.append("noCloudProvider:");
        sb.append(noCloudProvider);
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
  
  public A withCloudProviderEnabled() {
    return withCloudProviderEnabled(true);
  }
  
  public A withCloudProviderEnabled(Boolean cloudProviderEnabled) {
    this.cloudProviderEnabled = cloudProviderEnabled;
    return (A) this;
  }
  
  public A withControlPlaneEndpoint(APIEndpoint controlPlaneEndpoint) {
    this._visitables.remove("controlPlaneEndpoint");
    if (controlPlaneEndpoint != null) {
        this.controlPlaneEndpoint = new APIEndpointBuilder(controlPlaneEndpoint);
        this._visitables.get("controlPlaneEndpoint").add(this.controlPlaneEndpoint);
    } else {
        this.controlPlaneEndpoint = null;
        this._visitables.get("controlPlaneEndpoint").remove(this.controlPlaneEndpoint);
    }
    return (A) this;
  }
  
  public <K,V>A withFailureDomains(Map<String,FailureDomainSpec> failureDomains) {
    if (failureDomains == null) {
      this.failureDomains = null;
    } else {
      this.failureDomains = new LinkedHashMap(failureDomains);
    }
    return (A) this;
  }
  
  public ControlPlaneEndpointNested<A> withNewControlPlaneEndpoint() {
    return new ControlPlaneEndpointNested(null);
  }
  
  public A withNewControlPlaneEndpoint(String host,Integer port) {
    return (A) this.withControlPlaneEndpoint(new APIEndpoint(host, port));
  }
  
  public ControlPlaneEndpointNested<A> withNewControlPlaneEndpointLike(APIEndpoint item) {
    return new ControlPlaneEndpointNested(item);
  }
  
  public A withNoCloudProvider() {
    return withNoCloudProvider(true);
  }
  
  public A withNoCloudProvider(Boolean noCloudProvider) {
    this.noCloudProvider = noCloudProvider;
    return (A) this;
  }
  public class ControlPlaneEndpointNested<N> extends APIEndpointFluent<ControlPlaneEndpointNested<N>> implements Nested<N>{
  
    APIEndpointBuilder builder;
  
    ControlPlaneEndpointNested(APIEndpoint item) {
      this.builder = new APIEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3ClusterSpecFluent.this.withControlPlaneEndpoint(builder.build());
    }
    
    public N endControlPlaneEndpoint() {
      return and();
    }
    
  }
}