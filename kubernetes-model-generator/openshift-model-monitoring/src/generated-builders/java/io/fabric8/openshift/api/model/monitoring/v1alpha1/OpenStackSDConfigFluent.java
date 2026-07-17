package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigFluent;
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
public class OpenStackSDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.OpenStackSDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allTenants;
  private String applicationCredentialId;
  private String applicationCredentialName;
  private SecretKeySelector applicationCredentialSecret;
  private String availability;
  private String domainID;
  private String domainName;
  private String identityEndpoint;
  private SecretKeySelector password;
  private Integer port;
  private String projectID;
  private String projectName;
  private String refreshInterval;
  private String region;
  private String role;
  private SafeTLSConfigBuilder tlsConfig;
  private String userid;
  private String username;

  public OpenStackSDConfigFluent() {
  }
  
  public OpenStackSDConfigFluent(OpenStackSDConfig instance) {
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
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(OpenStackSDConfig instance) {
    instance = instance != null ? instance : new OpenStackSDConfig();
    if (instance != null) {
        this.withAllTenants(instance.getAllTenants());
        this.withApplicationCredentialId(instance.getApplicationCredentialId());
        this.withApplicationCredentialName(instance.getApplicationCredentialName());
        this.withApplicationCredentialSecret(instance.getApplicationCredentialSecret());
        this.withAvailability(instance.getAvailability());
        this.withDomainID(instance.getDomainID());
        this.withDomainName(instance.getDomainName());
        this.withIdentityEndpoint(instance.getIdentityEndpoint());
        this.withPassword(instance.getPassword());
        this.withPort(instance.getPort());
        this.withProjectID(instance.getProjectID());
        this.withProjectName(instance.getProjectName());
        this.withRefreshInterval(instance.getRefreshInterval());
        this.withRegion(instance.getRegion());
        this.withRole(instance.getRole());
        this.withTlsConfig(instance.getTlsConfig());
        this.withUserid(instance.getUserid());
        this.withUsername(instance.getUsername());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(SafeTLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public TlsConfigNested<A> editTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(null));
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
    OpenStackSDConfigFluent that = (OpenStackSDConfigFluent) o;
    if (!(Objects.equals(allTenants, that.allTenants))) {
      return false;
    }
    if (!(Objects.equals(applicationCredentialId, that.applicationCredentialId))) {
      return false;
    }
    if (!(Objects.equals(applicationCredentialName, that.applicationCredentialName))) {
      return false;
    }
    if (!(Objects.equals(applicationCredentialSecret, that.applicationCredentialSecret))) {
      return false;
    }
    if (!(Objects.equals(availability, that.availability))) {
      return false;
    }
    if (!(Objects.equals(domainID, that.domainID))) {
      return false;
    }
    if (!(Objects.equals(domainName, that.domainName))) {
      return false;
    }
    if (!(Objects.equals(identityEndpoint, that.identityEndpoint))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(projectName, that.projectName))) {
      return false;
    }
    if (!(Objects.equals(refreshInterval, that.refreshInterval))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(userid, that.userid))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public Boolean getAllTenants() {
    return this.allTenants;
  }
  
  public String getApplicationCredentialId() {
    return this.applicationCredentialId;
  }
  
  public String getApplicationCredentialName() {
    return this.applicationCredentialName;
  }
  
  public SecretKeySelector getApplicationCredentialSecret() {
    return this.applicationCredentialSecret;
  }
  
  public String getAvailability() {
    return this.availability;
  }
  
  public String getDomainID() {
    return this.domainID;
  }
  
  public String getDomainName() {
    return this.domainName;
  }
  
  public String getIdentityEndpoint() {
    return this.identityEndpoint;
  }
  
  public SecretKeySelector getPassword() {
    return this.password;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public String getProjectName() {
    return this.projectName;
  }
  
  public String getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public String getUserid() {
    return this.userid;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllTenants() {
    return this.allTenants != null;
  }
  
  public boolean hasApplicationCredentialId() {
    return this.applicationCredentialId != null;
  }
  
  public boolean hasApplicationCredentialName() {
    return this.applicationCredentialName != null;
  }
  
  public boolean hasApplicationCredentialSecret() {
    return this.applicationCredentialSecret != null;
  }
  
  public boolean hasAvailability() {
    return this.availability != null;
  }
  
  public boolean hasDomainID() {
    return this.domainID != null;
  }
  
  public boolean hasDomainName() {
    return this.domainName != null;
  }
  
  public boolean hasIdentityEndpoint() {
    return this.identityEndpoint != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasProjectName() {
    return this.projectName != null;
  }
  
  public boolean hasRefreshInterval() {
    return this.refreshInterval != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasUserid() {
    return this.userid != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(allTenants, applicationCredentialId, applicationCredentialName, applicationCredentialSecret, availability, domainID, domainName, identityEndpoint, password, port, projectID, projectName, refreshInterval, region, role, tlsConfig, userid, username, additionalProperties);
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
    if (!(allTenants == null)) {
        sb.append("allTenants:");
        sb.append(allTenants);
        sb.append(",");
    }
    if (!(applicationCredentialId == null)) {
        sb.append("applicationCredentialId:");
        sb.append(applicationCredentialId);
        sb.append(",");
    }
    if (!(applicationCredentialName == null)) {
        sb.append("applicationCredentialName:");
        sb.append(applicationCredentialName);
        sb.append(",");
    }
    if (!(applicationCredentialSecret == null)) {
        sb.append("applicationCredentialSecret:");
        sb.append(applicationCredentialSecret);
        sb.append(",");
    }
    if (!(availability == null)) {
        sb.append("availability:");
        sb.append(availability);
        sb.append(",");
    }
    if (!(domainID == null)) {
        sb.append("domainID:");
        sb.append(domainID);
        sb.append(",");
    }
    if (!(domainName == null)) {
        sb.append("domainName:");
        sb.append(domainName);
        sb.append(",");
    }
    if (!(identityEndpoint == null)) {
        sb.append("identityEndpoint:");
        sb.append(identityEndpoint);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(projectName == null)) {
        sb.append("projectName:");
        sb.append(projectName);
        sb.append(",");
    }
    if (!(refreshInterval == null)) {
        sb.append("refreshInterval:");
        sb.append(refreshInterval);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(userid == null)) {
        sb.append("userid:");
        sb.append(userid);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
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
  
  public A withAllTenants() {
    return withAllTenants(true);
  }
  
  public A withAllTenants(Boolean allTenants) {
    this.allTenants = allTenants;
    return (A) this;
  }
  
  public A withApplicationCredentialId(String applicationCredentialId) {
    this.applicationCredentialId = applicationCredentialId;
    return (A) this;
  }
  
  public A withApplicationCredentialName(String applicationCredentialName) {
    this.applicationCredentialName = applicationCredentialName;
    return (A) this;
  }
  
  public A withApplicationCredentialSecret(SecretKeySelector applicationCredentialSecret) {
    this.applicationCredentialSecret = applicationCredentialSecret;
    return (A) this;
  }
  
  public A withAvailability(String availability) {
    this.availability = availability;
    return (A) this;
  }
  
  public A withDomainID(String domainID) {
    this.domainID = domainID;
    return (A) this;
  }
  
  public A withDomainName(String domainName) {
    this.domainName = domainName;
    return (A) this;
  }
  
  public A withIdentityEndpoint(String identityEndpoint) {
    this.identityEndpoint = identityEndpoint;
    return (A) this;
  }
  
  public A withNewApplicationCredentialSecret(String key,String name,Boolean optional) {
    return (A) this.withApplicationCredentialSecret(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewPassword(String key,String name,Boolean optional) {
    return (A) this.withPassword(new SecretKeySelector(key, name, optional));
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withPassword(SecretKeySelector password) {
    this.password = password;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withProjectName(String projectName) {
    this.projectName = projectName;
    return (A) this;
  }
  
  public A withRefreshInterval(String refreshInterval) {
    this.refreshInterval = refreshInterval;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withTlsConfig(SafeTLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new SafeTLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  
  public A withUserid(String userid) {
    this.userid = userid;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenStackSDConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}