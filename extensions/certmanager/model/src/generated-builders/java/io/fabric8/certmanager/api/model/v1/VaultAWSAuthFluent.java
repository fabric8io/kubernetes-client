package io.fabric8.certmanager.api.model.v1;

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
public class VaultAWSAuthFluent<A extends io.fabric8.certmanager.api.model.v1.VaultAWSAuthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String iamRoleArn;
  private String mountPath;
  private String region;
  private String role;
  private ServiceAccountRefBuilder serviceAccountRef;
  private String vaultHeaderValue;

  public VaultAWSAuthFluent() {
  }
  
  public VaultAWSAuthFluent(VaultAWSAuth instance) {
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
  
  public ServiceAccountRef buildServiceAccountRef() {
    return this.serviceAccountRef != null ? this.serviceAccountRef.build() : null;
  }
  
  protected void copyInstance(VaultAWSAuth instance) {
    instance = instance != null ? instance : new VaultAWSAuth();
    if (instance != null) {
        this.withIamRoleArn(instance.getIamRoleArn());
        this.withMountPath(instance.getMountPath());
        this.withRegion(instance.getRegion());
        this.withRole(instance.getRole());
        this.withServiceAccountRef(instance.getServiceAccountRef());
        this.withVaultHeaderValue(instance.getVaultHeaderValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRef() {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(new ServiceAccountRefBuilder().build()));
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRefLike(ServiceAccountRef item) {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(item));
  }
  
  public ServiceAccountRefNested<A> editServiceAccountRef() {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(null));
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
    VaultAWSAuthFluent that = (VaultAWSAuthFluent) o;
    if (!(Objects.equals(iamRoleArn, that.iamRoleArn))) {
      return false;
    }
    if (!(Objects.equals(mountPath, that.mountPath))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountRef, that.serviceAccountRef))) {
      return false;
    }
    if (!(Objects.equals(vaultHeaderValue, that.vaultHeaderValue))) {
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
  
  public String getIamRoleArn() {
    return this.iamRoleArn;
  }
  
  public String getMountPath() {
    return this.mountPath;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public String getVaultHeaderValue() {
    return this.vaultHeaderValue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIamRoleArn() {
    return this.iamRoleArn != null;
  }
  
  public boolean hasMountPath() {
    return this.mountPath != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasServiceAccountRef() {
    return this.serviceAccountRef != null;
  }
  
  public boolean hasVaultHeaderValue() {
    return this.vaultHeaderValue != null;
  }
  
  public int hashCode() {
    return Objects.hash(iamRoleArn, mountPath, region, role, serviceAccountRef, vaultHeaderValue, additionalProperties);
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
    if (!(iamRoleArn == null)) {
        sb.append("iamRoleArn:");
        sb.append(iamRoleArn);
        sb.append(",");
    }
    if (!(mountPath == null)) {
        sb.append("mountPath:");
        sb.append(mountPath);
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
    if (!(serviceAccountRef == null)) {
        sb.append("serviceAccountRef:");
        sb.append(serviceAccountRef);
        sb.append(",");
    }
    if (!(vaultHeaderValue == null)) {
        sb.append("vaultHeaderValue:");
        sb.append(vaultHeaderValue);
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
  
  public A withIamRoleArn(String iamRoleArn) {
    this.iamRoleArn = iamRoleArn;
    return (A) this;
  }
  
  public A withMountPath(String mountPath) {
    this.mountPath = mountPath;
    return (A) this;
  }
  
  public ServiceAccountRefNested<A> withNewServiceAccountRef() {
    return new ServiceAccountRefNested(null);
  }
  
  public ServiceAccountRefNested<A> withNewServiceAccountRefLike(ServiceAccountRef item) {
    return new ServiceAccountRefNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withServiceAccountRef(ServiceAccountRef serviceAccountRef) {
    this._visitables.remove("serviceAccountRef");
    if (serviceAccountRef != null) {
        this.serviceAccountRef = new ServiceAccountRefBuilder(serviceAccountRef);
        this._visitables.get("serviceAccountRef").add(this.serviceAccountRef);
    } else {
        this.serviceAccountRef = null;
        this._visitables.get("serviceAccountRef").remove(this.serviceAccountRef);
    }
    return (A) this;
  }
  
  public A withVaultHeaderValue(String vaultHeaderValue) {
    this.vaultHeaderValue = vaultHeaderValue;
    return (A) this;
  }
  public class ServiceAccountRefNested<N> extends ServiceAccountRefFluent<ServiceAccountRefNested<N>> implements Nested<N>{
  
    ServiceAccountRefBuilder builder;
  
    ServiceAccountRefNested(ServiceAccountRef item) {
      this.builder = new ServiceAccountRefBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultAWSAuthFluent.this.withServiceAccountRef(builder.build());
    }
    
    public N endServiceAccountRef() {
      return and();
    }
    
  }
}