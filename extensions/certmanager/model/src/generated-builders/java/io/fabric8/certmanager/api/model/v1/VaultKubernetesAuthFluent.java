package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
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
public class VaultKubernetesAuthFluent<A extends io.fabric8.certmanager.api.model.v1.VaultKubernetesAuthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mountPath;
  private String role;
  private SecretKeySelectorBuilder secretRef;
  private ServiceAccountRefBuilder serviceAccountRef;

  public VaultKubernetesAuthFluent() {
  }
  
  public VaultKubernetesAuthFluent(VaultKubernetesAuth instance) {
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
  
  public SecretKeySelector buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  public ServiceAccountRef buildServiceAccountRef() {
    return this.serviceAccountRef != null ? this.serviceAccountRef.build() : null;
  }
  
  protected void copyInstance(VaultKubernetesAuth instance) {
    instance = instance != null ? instance : new VaultKubernetesAuth();
    if (instance != null) {
        this.withMountPath(instance.getMountPath());
        this.withRole(instance.getRole());
        this.withSecretRef(instance.getSecretRef());
        this.withServiceAccountRef(instance.getServiceAccountRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(SecretKeySelector item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRef() {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(new ServiceAccountRefBuilder().build()));
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRefLike(ServiceAccountRef item) {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    VaultKubernetesAuthFluent that = (VaultKubernetesAuthFluent) o;
    if (!(Objects.equals(mountPath, that.mountPath))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountRef, that.serviceAccountRef))) {
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
  
  public String getMountPath() {
    return this.mountPath;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMountPath() {
    return this.mountPath != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public boolean hasServiceAccountRef() {
    return this.serviceAccountRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(mountPath, role, secretRef, serviceAccountRef, additionalProperties);
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
    if (!(mountPath == null)) {
        sb.append("mountPath:");
        sb.append(mountPath);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
        sb.append(",");
    }
    if (!(serviceAccountRef == null)) {
        sb.append("serviceAccountRef:");
        sb.append(serviceAccountRef);
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
  
  public A withMountPath(String mountPath) {
    this.mountPath = mountPath;
    return (A) this;
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public A withNewSecretRef(String key,String name) {
    return (A) this.withSecretRef(new SecretKeySelector(key, name));
  }
  
  public SecretRefNested<A> withNewSecretRefLike(SecretKeySelector item) {
    return new SecretRefNested(item);
  }
  
  public ServiceAccountRefNested<A> withNewServiceAccountRef() {
    return new ServiceAccountRefNested(null);
  }
  
  public ServiceAccountRefNested<A> withNewServiceAccountRefLike(ServiceAccountRef item) {
    return new ServiceAccountRefNested(item);
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withSecretRef(SecretKeySelector secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new SecretKeySelectorBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
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
  public class SecretRefNested<N> extends SecretKeySelectorFluent<SecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    SecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultKubernetesAuthFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
  public class ServiceAccountRefNested<N> extends ServiceAccountRefFluent<ServiceAccountRefNested<N>> implements Nested<N>{
  
    ServiceAccountRefBuilder builder;
  
    ServiceAccountRefNested(ServiceAccountRef item) {
      this.builder = new ServiceAccountRefBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultKubernetesAuthFluent.this.withServiceAccountRef(builder.build());
    }
    
    public N endServiceAccountRef() {
      return and();
    }
    
  }
}