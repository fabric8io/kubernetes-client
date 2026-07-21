package io.fabric8.certmanager.api.model.acme.v1;

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
public class ACMEIssuerDNS01ProviderCloudDNSFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderCloudDNSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hostedZoneName;
  private String project;
  private SecretKeySelectorBuilder serviceAccountSecretRef;

  public ACMEIssuerDNS01ProviderCloudDNSFluent() {
  }
  
  public ACMEIssuerDNS01ProviderCloudDNSFluent(ACMEIssuerDNS01ProviderCloudDNS instance) {
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
  
  public SecretKeySelector buildServiceAccountSecretRef() {
    return this.serviceAccountSecretRef != null ? this.serviceAccountSecretRef.build() : null;
  }
  
  protected void copyInstance(ACMEIssuerDNS01ProviderCloudDNS instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderCloudDNS();
    if (instance != null) {
        this.withHostedZoneName(instance.getHostedZoneName());
        this.withProject(instance.getProject());
        this.withServiceAccountSecretRef(instance.getServiceAccountSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceAccountSecretRefNested<A> editOrNewServiceAccountSecretRef() {
    return this.withNewServiceAccountSecretRefLike(Optional.ofNullable(this.buildServiceAccountSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ServiceAccountSecretRefNested<A> editOrNewServiceAccountSecretRefLike(SecretKeySelector item) {
    return this.withNewServiceAccountSecretRefLike(Optional.ofNullable(this.buildServiceAccountSecretRef()).orElse(item));
  }
  
  public ServiceAccountSecretRefNested<A> editServiceAccountSecretRef() {
    return this.withNewServiceAccountSecretRefLike(Optional.ofNullable(this.buildServiceAccountSecretRef()).orElse(null));
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
    ACMEIssuerDNS01ProviderCloudDNSFluent that = (ACMEIssuerDNS01ProviderCloudDNSFluent) o;
    if (!(Objects.equals(hostedZoneName, that.hostedZoneName))) {
      return false;
    }
    if (!(Objects.equals(project, that.project))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountSecretRef, that.serviceAccountSecretRef))) {
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
  
  public String getHostedZoneName() {
    return this.hostedZoneName;
  }
  
  public String getProject() {
    return this.project;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostedZoneName() {
    return this.hostedZoneName != null;
  }
  
  public boolean hasProject() {
    return this.project != null;
  }
  
  public boolean hasServiceAccountSecretRef() {
    return this.serviceAccountSecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostedZoneName, project, serviceAccountSecretRef, additionalProperties);
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
    if (!(hostedZoneName == null)) {
        sb.append("hostedZoneName:");
        sb.append(hostedZoneName);
        sb.append(",");
    }
    if (!(project == null)) {
        sb.append("project:");
        sb.append(project);
        sb.append(",");
    }
    if (!(serviceAccountSecretRef == null)) {
        sb.append("serviceAccountSecretRef:");
        sb.append(serviceAccountSecretRef);
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
  
  public A withHostedZoneName(String hostedZoneName) {
    this.hostedZoneName = hostedZoneName;
    return (A) this;
  }
  
  public ServiceAccountSecretRefNested<A> withNewServiceAccountSecretRef() {
    return new ServiceAccountSecretRefNested(null);
  }
  
  public A withNewServiceAccountSecretRef(String key,String name) {
    return (A) this.withServiceAccountSecretRef(new SecretKeySelector(key, name));
  }
  
  public ServiceAccountSecretRefNested<A> withNewServiceAccountSecretRefLike(SecretKeySelector item) {
    return new ServiceAccountSecretRefNested(item);
  }
  
  public A withProject(String project) {
    this.project = project;
    return (A) this;
  }
  
  public A withServiceAccountSecretRef(SecretKeySelector serviceAccountSecretRef) {
    this._visitables.remove("serviceAccountSecretRef");
    if (serviceAccountSecretRef != null) {
        this.serviceAccountSecretRef = new SecretKeySelectorBuilder(serviceAccountSecretRef);
        this._visitables.get("serviceAccountSecretRef").add(this.serviceAccountSecretRef);
    } else {
        this.serviceAccountSecretRef = null;
        this._visitables.get("serviceAccountSecretRef").remove(this.serviceAccountSecretRef);
    }
    return (A) this;
  }
  public class ServiceAccountSecretRefNested<N> extends SecretKeySelectorFluent<ServiceAccountSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ServiceAccountSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderCloudDNSFluent.this.withServiceAccountSecretRef(builder.build());
    }
    
    public N endServiceAccountSecretRef() {
      return and();
    }
    
  }
}