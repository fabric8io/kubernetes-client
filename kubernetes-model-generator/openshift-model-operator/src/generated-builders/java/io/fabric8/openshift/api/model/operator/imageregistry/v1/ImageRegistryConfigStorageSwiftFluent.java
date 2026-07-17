package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class ImageRegistryConfigStorageSwiftFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageSwiftFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authURL;
  private String authVersion;
  private String container;
  private String domain;
  private String domainID;
  private String regionName;
  private String tenant;
  private String tenantID;

  public ImageRegistryConfigStorageSwiftFluent() {
  }
  
  public ImageRegistryConfigStorageSwiftFluent(ImageRegistryConfigStorageSwift instance) {
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
  
  protected void copyInstance(ImageRegistryConfigStorageSwift instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorageSwift();
    if (instance != null) {
        this.withAuthURL(instance.getAuthURL());
        this.withAuthVersion(instance.getAuthVersion());
        this.withContainer(instance.getContainer());
        this.withDomain(instance.getDomain());
        this.withDomainID(instance.getDomainID());
        this.withRegionName(instance.getRegionName());
        this.withTenant(instance.getTenant());
        this.withTenantID(instance.getTenantID());
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
    ImageRegistryConfigStorageSwiftFluent that = (ImageRegistryConfigStorageSwiftFluent) o;
    if (!(Objects.equals(authURL, that.authURL))) {
      return false;
    }
    if (!(Objects.equals(authVersion, that.authVersion))) {
      return false;
    }
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(domainID, that.domainID))) {
      return false;
    }
    if (!(Objects.equals(regionName, that.regionName))) {
      return false;
    }
    if (!(Objects.equals(tenant, that.tenant))) {
      return false;
    }
    if (!(Objects.equals(tenantID, that.tenantID))) {
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
  
  public String getAuthURL() {
    return this.authURL;
  }
  
  public String getAuthVersion() {
    return this.authVersion;
  }
  
  public String getContainer() {
    return this.container;
  }
  
  public String getDomain() {
    return this.domain;
  }
  
  public String getDomainID() {
    return this.domainID;
  }
  
  public String getRegionName() {
    return this.regionName;
  }
  
  public String getTenant() {
    return this.tenant;
  }
  
  public String getTenantID() {
    return this.tenantID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthURL() {
    return this.authURL != null;
  }
  
  public boolean hasAuthVersion() {
    return this.authVersion != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasDomainID() {
    return this.domainID != null;
  }
  
  public boolean hasRegionName() {
    return this.regionName != null;
  }
  
  public boolean hasTenant() {
    return this.tenant != null;
  }
  
  public boolean hasTenantID() {
    return this.tenantID != null;
  }
  
  public int hashCode() {
    return Objects.hash(authURL, authVersion, container, domain, domainID, regionName, tenant, tenantID, additionalProperties);
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
    if (!(authURL == null)) {
        sb.append("authURL:");
        sb.append(authURL);
        sb.append(",");
    }
    if (!(authVersion == null)) {
        sb.append("authVersion:");
        sb.append(authVersion);
        sb.append(",");
    }
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(domainID == null)) {
        sb.append("domainID:");
        sb.append(domainID);
        sb.append(",");
    }
    if (!(regionName == null)) {
        sb.append("regionName:");
        sb.append(regionName);
        sb.append(",");
    }
    if (!(tenant == null)) {
        sb.append("tenant:");
        sb.append(tenant);
        sb.append(",");
    }
    if (!(tenantID == null)) {
        sb.append("tenantID:");
        sb.append(tenantID);
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
  
  public A withAuthURL(String authURL) {
    this.authURL = authURL;
    return (A) this;
  }
  
  public A withAuthVersion(String authVersion) {
    this.authVersion = authVersion;
    return (A) this;
  }
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withDomainID(String domainID) {
    this.domainID = domainID;
    return (A) this;
  }
  
  public A withRegionName(String regionName) {
    this.regionName = regionName;
    return (A) this;
  }
  
  public A withTenant(String tenant) {
    this.tenant = tenant;
    return (A) this;
  }
  
  public A withTenantID(String tenantID) {
    this.tenantID = tenantID;
    return (A) this;
  }
  
}