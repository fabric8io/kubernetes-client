package io.fabric8.openclustermanagement.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class DiscoveredClusterSpecFluent<A extends io.fabric8.openclustermanagement.api.model.discovery.v1.DiscoveredClusterSpecFluent<A>> extends BaseFluent<A>{

  private String activityTimestamp;
  private Map<String,Object> additionalProperties;
  private String apiUrl;
  private String cloudProvider;
  private String console;
  private String creationTimestamp;
  private ObjectReferenceBuilder credential;
  private String displayName;
  private Boolean importAsManagedCluster;
  private Boolean isManagedCluster;
  private String name;
  private String ocpClusterId;
  private String openshiftVersion;
  private String owner;
  private String region;
  private String rhocmClusterId;
  private String status;
  private String type;

  public DiscoveredClusterSpecFluent() {
  }
  
  public DiscoveredClusterSpecFluent(DiscoveredClusterSpec instance) {
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
  
  public ObjectReference buildCredential() {
    return this.credential != null ? this.credential.build() : null;
  }
  
  protected void copyInstance(DiscoveredClusterSpec instance) {
    instance = instance != null ? instance : new DiscoveredClusterSpec();
    if (instance != null) {
        this.withActivityTimestamp(instance.getActivityTimestamp());
        this.withApiUrl(instance.getApiUrl());
        this.withCloudProvider(instance.getCloudProvider());
        this.withConsole(instance.getConsole());
        this.withCreationTimestamp(instance.getCreationTimestamp());
        this.withCredential(instance.getCredential());
        this.withDisplayName(instance.getDisplayName());
        this.withImportAsManagedCluster(instance.getImportAsManagedCluster());
        this.withIsManagedCluster(instance.getIsManagedCluster());
        this.withName(instance.getName());
        this.withOcpClusterId(instance.getOcpClusterId());
        this.withOpenshiftVersion(instance.getOpenshiftVersion());
        this.withOwner(instance.getOwner());
        this.withRegion(instance.getRegion());
        this.withRhocmClusterId(instance.getRhocmClusterId());
        this.withStatus(instance.getStatus());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialNested<A> editCredential() {
    return this.withNewCredentialLike(Optional.ofNullable(this.buildCredential()).orElse(null));
  }
  
  public CredentialNested<A> editOrNewCredential() {
    return this.withNewCredentialLike(Optional.ofNullable(this.buildCredential()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public CredentialNested<A> editOrNewCredentialLike(ObjectReference item) {
    return this.withNewCredentialLike(Optional.ofNullable(this.buildCredential()).orElse(item));
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
    DiscoveredClusterSpecFluent that = (DiscoveredClusterSpecFluent) o;
    if (!(Objects.equals(activityTimestamp, that.activityTimestamp))) {
      return false;
    }
    if (!(Objects.equals(apiUrl, that.apiUrl))) {
      return false;
    }
    if (!(Objects.equals(cloudProvider, that.cloudProvider))) {
      return false;
    }
    if (!(Objects.equals(console, that.console))) {
      return false;
    }
    if (!(Objects.equals(creationTimestamp, that.creationTimestamp))) {
      return false;
    }
    if (!(Objects.equals(credential, that.credential))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(importAsManagedCluster, that.importAsManagedCluster))) {
      return false;
    }
    if (!(Objects.equals(isManagedCluster, that.isManagedCluster))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(ocpClusterId, that.ocpClusterId))) {
      return false;
    }
    if (!(Objects.equals(openshiftVersion, that.openshiftVersion))) {
      return false;
    }
    if (!(Objects.equals(owner, that.owner))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(rhocmClusterId, that.rhocmClusterId))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getActivityTimestamp() {
    return this.activityTimestamp;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiUrl() {
    return this.apiUrl;
  }
  
  public String getCloudProvider() {
    return this.cloudProvider;
  }
  
  public String getConsole() {
    return this.console;
  }
  
  public String getCreationTimestamp() {
    return this.creationTimestamp;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public Boolean getImportAsManagedCluster() {
    return this.importAsManagedCluster;
  }
  
  public Boolean getIsManagedCluster() {
    return this.isManagedCluster;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getOcpClusterId() {
    return this.ocpClusterId;
  }
  
  public String getOpenshiftVersion() {
    return this.openshiftVersion;
  }
  
  public String getOwner() {
    return this.owner;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRhocmClusterId() {
    return this.rhocmClusterId;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasActivityTimestamp() {
    return this.activityTimestamp != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiUrl() {
    return this.apiUrl != null;
  }
  
  public boolean hasCloudProvider() {
    return this.cloudProvider != null;
  }
  
  public boolean hasConsole() {
    return this.console != null;
  }
  
  public boolean hasCreationTimestamp() {
    return this.creationTimestamp != null;
  }
  
  public boolean hasCredential() {
    return this.credential != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasImportAsManagedCluster() {
    return this.importAsManagedCluster != null;
  }
  
  public boolean hasIsManagedCluster() {
    return this.isManagedCluster != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOcpClusterId() {
    return this.ocpClusterId != null;
  }
  
  public boolean hasOpenshiftVersion() {
    return this.openshiftVersion != null;
  }
  
  public boolean hasOwner() {
    return this.owner != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasRhocmClusterId() {
    return this.rhocmClusterId != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(activityTimestamp, apiUrl, cloudProvider, console, creationTimestamp, credential, displayName, importAsManagedCluster, isManagedCluster, name, ocpClusterId, openshiftVersion, owner, region, rhocmClusterId, status, type, additionalProperties);
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
    if (!(activityTimestamp == null)) {
        sb.append("activityTimestamp:");
        sb.append(activityTimestamp);
        sb.append(",");
    }
    if (!(apiUrl == null)) {
        sb.append("apiUrl:");
        sb.append(apiUrl);
        sb.append(",");
    }
    if (!(cloudProvider == null)) {
        sb.append("cloudProvider:");
        sb.append(cloudProvider);
        sb.append(",");
    }
    if (!(console == null)) {
        sb.append("console:");
        sb.append(console);
        sb.append(",");
    }
    if (!(creationTimestamp == null)) {
        sb.append("creationTimestamp:");
        sb.append(creationTimestamp);
        sb.append(",");
    }
    if (!(credential == null)) {
        sb.append("credential:");
        sb.append(credential);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(importAsManagedCluster == null)) {
        sb.append("importAsManagedCluster:");
        sb.append(importAsManagedCluster);
        sb.append(",");
    }
    if (!(isManagedCluster == null)) {
        sb.append("isManagedCluster:");
        sb.append(isManagedCluster);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(ocpClusterId == null)) {
        sb.append("ocpClusterId:");
        sb.append(ocpClusterId);
        sb.append(",");
    }
    if (!(openshiftVersion == null)) {
        sb.append("openshiftVersion:");
        sb.append(openshiftVersion);
        sb.append(",");
    }
    if (!(owner == null)) {
        sb.append("owner:");
        sb.append(owner);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(rhocmClusterId == null)) {
        sb.append("rhocmClusterId:");
        sb.append(rhocmClusterId);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActivityTimestamp(String activityTimestamp) {
    this.activityTimestamp = activityTimestamp;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
    return (A) this;
  }
  
  public A withCloudProvider(String cloudProvider) {
    this.cloudProvider = cloudProvider;
    return (A) this;
  }
  
  public A withConsole(String console) {
    this.console = console;
    return (A) this;
  }
  
  public A withCreationTimestamp(String creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
    return (A) this;
  }
  
  public A withCredential(ObjectReference credential) {
    this._visitables.remove("credential");
    if (credential != null) {
        this.credential = new ObjectReferenceBuilder(credential);
        this._visitables.get("credential").add(this.credential);
    } else {
        this.credential = null;
        this._visitables.get("credential").remove(this.credential);
    }
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withImportAsManagedCluster() {
    return withImportAsManagedCluster(true);
  }
  
  public A withImportAsManagedCluster(Boolean importAsManagedCluster) {
    this.importAsManagedCluster = importAsManagedCluster;
    return (A) this;
  }
  
  public A withIsManagedCluster() {
    return withIsManagedCluster(true);
  }
  
  public A withIsManagedCluster(Boolean isManagedCluster) {
    this.isManagedCluster = isManagedCluster;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public CredentialNested<A> withNewCredential() {
    return new CredentialNested(null);
  }
  
  public CredentialNested<A> withNewCredentialLike(ObjectReference item) {
    return new CredentialNested(item);
  }
  
  public A withOcpClusterId(String ocpClusterId) {
    this.ocpClusterId = ocpClusterId;
    return (A) this;
  }
  
  public A withOpenshiftVersion(String openshiftVersion) {
    this.openshiftVersion = openshiftVersion;
    return (A) this;
  }
  
  public A withOwner(String owner) {
    this.owner = owner;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRhocmClusterId(String rhocmClusterId) {
    this.rhocmClusterId = rhocmClusterId;
    return (A) this;
  }
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class CredentialNested<N> extends ObjectReferenceFluent<CredentialNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    CredentialNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DiscoveredClusterSpecFluent.this.withCredential(builder.build());
    }
    
    public N endCredential() {
      return and();
    }
    
  }
}