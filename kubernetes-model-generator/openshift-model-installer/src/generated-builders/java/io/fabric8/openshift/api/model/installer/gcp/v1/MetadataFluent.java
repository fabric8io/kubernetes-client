package io.fabric8.openshift.api.model.installer.gcp.v1;

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
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.gcp.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PSCEndpointBuilder endpoint;
  private String firewallRulesManagement;
  private String networkProjectID;
  private String privateZoneDomain;
  private String privateZoneProjectID;
  private String projectID;
  private String region;

  public MetadataFluent() {
  }
  
  public MetadataFluent(Metadata instance) {
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
  
  public PSCEndpoint buildEndpoint() {
    return this.endpoint != null ? this.endpoint.build() : null;
  }
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withEndpoint(instance.getEndpoint());
        this.withFirewallRulesManagement(instance.getFirewallRulesManagement());
        this.withNetworkProjectID(instance.getNetworkProjectID());
        this.withPrivateZoneDomain(instance.getPrivateZoneDomain());
        this.withPrivateZoneProjectID(instance.getPrivateZoneProjectID());
        this.withProjectID(instance.getProjectID());
        this.withRegion(instance.getRegion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EndpointNested<A> editEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(null));
  }
  
  public EndpointNested<A> editOrNewEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(new PSCEndpointBuilder().build()));
  }
  
  public EndpointNested<A> editOrNewEndpointLike(PSCEndpoint item) {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(item));
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
    MetadataFluent that = (MetadataFluent) o;
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(firewallRulesManagement, that.firewallRulesManagement))) {
      return false;
    }
    if (!(Objects.equals(networkProjectID, that.networkProjectID))) {
      return false;
    }
    if (!(Objects.equals(privateZoneDomain, that.privateZoneDomain))) {
      return false;
    }
    if (!(Objects.equals(privateZoneProjectID, that.privateZoneProjectID))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
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
  
  public String getFirewallRulesManagement() {
    return this.firewallRulesManagement;
  }
  
  public String getNetworkProjectID() {
    return this.networkProjectID;
  }
  
  public String getPrivateZoneDomain() {
    return this.privateZoneDomain;
  }
  
  public String getPrivateZoneProjectID() {
    return this.privateZoneProjectID;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasFirewallRulesManagement() {
    return this.firewallRulesManagement != null;
  }
  
  public boolean hasNetworkProjectID() {
    return this.networkProjectID != null;
  }
  
  public boolean hasPrivateZoneDomain() {
    return this.privateZoneDomain != null;
  }
  
  public boolean hasPrivateZoneProjectID() {
    return this.privateZoneProjectID != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public int hashCode() {
    return Objects.hash(endpoint, firewallRulesManagement, networkProjectID, privateZoneDomain, privateZoneProjectID, projectID, region, additionalProperties);
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
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
        sb.append(",");
    }
    if (!(firewallRulesManagement == null)) {
        sb.append("firewallRulesManagement:");
        sb.append(firewallRulesManagement);
        sb.append(",");
    }
    if (!(networkProjectID == null)) {
        sb.append("networkProjectID:");
        sb.append(networkProjectID);
        sb.append(",");
    }
    if (!(privateZoneDomain == null)) {
        sb.append("privateZoneDomain:");
        sb.append(privateZoneDomain);
        sb.append(",");
    }
    if (!(privateZoneProjectID == null)) {
        sb.append("privateZoneProjectID:");
        sb.append(privateZoneProjectID);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
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
  
  public A withEndpoint(PSCEndpoint endpoint) {
    this._visitables.remove("endpoint");
    if (endpoint != null) {
        this.endpoint = new PSCEndpointBuilder(endpoint);
        this._visitables.get("endpoint").add(this.endpoint);
    } else {
        this.endpoint = null;
        this._visitables.get("endpoint").remove(this.endpoint);
    }
    return (A) this;
  }
  
  public A withFirewallRulesManagement(String firewallRulesManagement) {
    this.firewallRulesManagement = firewallRulesManagement;
    return (A) this;
  }
  
  public A withNetworkProjectID(String networkProjectID) {
    this.networkProjectID = networkProjectID;
    return (A) this;
  }
  
  public EndpointNested<A> withNewEndpoint() {
    return new EndpointNested(null);
  }
  
  public A withNewEndpoint(Boolean clusterUseOnly,String name,String region) {
    return (A) this.withEndpoint(new PSCEndpoint(clusterUseOnly, name, region));
  }
  
  public EndpointNested<A> withNewEndpointLike(PSCEndpoint item) {
    return new EndpointNested(item);
  }
  
  public A withPrivateZoneDomain(String privateZoneDomain) {
    this.privateZoneDomain = privateZoneDomain;
    return (A) this;
  }
  
  public A withPrivateZoneProjectID(String privateZoneProjectID) {
    this.privateZoneProjectID = privateZoneProjectID;
    return (A) this;
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  public class EndpointNested<N> extends PSCEndpointFluent<EndpointNested<N>> implements Nested<N>{
  
    PSCEndpointBuilder builder;
  
    EndpointNested(PSCEndpoint item) {
      this.builder = new PSCEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) MetadataFluent.this.withEndpoint(builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
}