package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
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
public class Sigv4Fluent<A extends io.fabric8.openshift.api.model.monitoring.v1.Sigv4Fluent<A>> extends BaseFluent<A>{

  private SecretKeySelector accessKey;
  private Map<String,Object> additionalProperties;
  private String externalId;
  private String profile;
  private String region;
  private String roleArn;
  private SecretKeySelector secretKey;
  private Boolean useFIPSSTSEndpoint;

  public Sigv4Fluent() {
  }
  
  public Sigv4Fluent(Sigv4 instance) {
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
  
  protected void copyInstance(Sigv4 instance) {
    instance = instance != null ? instance : new Sigv4();
    if (instance != null) {
        this.withAccessKey(instance.getAccessKey());
        this.withExternalId(instance.getExternalId());
        this.withProfile(instance.getProfile());
        this.withRegion(instance.getRegion());
        this.withRoleArn(instance.getRoleArn());
        this.withSecretKey(instance.getSecretKey());
        this.withUseFIPSSTSEndpoint(instance.getUseFIPSSTSEndpoint());
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
    Sigv4Fluent that = (Sigv4Fluent) o;
    if (!(Objects.equals(accessKey, that.accessKey))) {
      return false;
    }
    if (!(Objects.equals(externalId, that.externalId))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(roleArn, that.roleArn))) {
      return false;
    }
    if (!(Objects.equals(secretKey, that.secretKey))) {
      return false;
    }
    if (!(Objects.equals(useFIPSSTSEndpoint, that.useFIPSSTSEndpoint))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public SecretKeySelector getAccessKey() {
    return this.accessKey;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getExternalId() {
    return this.externalId;
  }
  
  public String getProfile() {
    return this.profile;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRoleArn() {
    return this.roleArn;
  }
  
  public SecretKeySelector getSecretKey() {
    return this.secretKey;
  }
  
  public Boolean getUseFIPSSTSEndpoint() {
    return this.useFIPSSTSEndpoint;
  }
  
  public boolean hasAccessKey() {
    return this.accessKey != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExternalId() {
    return this.externalId != null;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasRoleArn() {
    return this.roleArn != null;
  }
  
  public boolean hasSecretKey() {
    return this.secretKey != null;
  }
  
  public boolean hasUseFIPSSTSEndpoint() {
    return this.useFIPSSTSEndpoint != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessKey, externalId, profile, region, roleArn, secretKey, useFIPSSTSEndpoint, additionalProperties);
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
    if (!(accessKey == null)) {
        sb.append("accessKey:");
        sb.append(accessKey);
        sb.append(",");
    }
    if (!(externalId == null)) {
        sb.append("externalId:");
        sb.append(externalId);
        sb.append(",");
    }
    if (!(profile == null)) {
        sb.append("profile:");
        sb.append(profile);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(roleArn == null)) {
        sb.append("roleArn:");
        sb.append(roleArn);
        sb.append(",");
    }
    if (!(secretKey == null)) {
        sb.append("secretKey:");
        sb.append(secretKey);
        sb.append(",");
    }
    if (!(useFIPSSTSEndpoint == null)) {
        sb.append("useFIPSSTSEndpoint:");
        sb.append(useFIPSSTSEndpoint);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessKey(SecretKeySelector accessKey) {
    this.accessKey = accessKey;
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
  
  public A withExternalId(String externalId) {
    this.externalId = externalId;
    return (A) this;
  }
  
  public A withNewAccessKey(String key,String name,Boolean optional) {
    return (A) this.withAccessKey(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewSecretKey(String key,String name,Boolean optional) {
    return (A) this.withSecretKey(new SecretKeySelector(key, name, optional));
  }
  
  public A withProfile(String profile) {
    this.profile = profile;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRoleArn(String roleArn) {
    this.roleArn = roleArn;
    return (A) this;
  }
  
  public A withSecretKey(SecretKeySelector secretKey) {
    this.secretKey = secretKey;
    return (A) this;
  }
  
  public A withUseFIPSSTSEndpoint() {
    return withUseFIPSSTSEndpoint(true);
  }
  
  public A withUseFIPSSTSEndpoint(Boolean useFIPSSTSEndpoint) {
    this.useFIPSSTSEndpoint = useFIPSSTSEndpoint;
    return (A) this;
  }
  
}