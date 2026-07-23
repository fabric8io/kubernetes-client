package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CredentialsRequestSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cloudTokenPath;
  private Object providerSpec;
  private ObjectReferenceBuilder secretRef;
  private List<String> serviceAccountNames = new ArrayList<String>();

  public CredentialsRequestSpecFluent() {
  }
  
  public CredentialsRequestSpecFluent(CredentialsRequestSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToServiceAccountNames(Collection<String> items) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    for (String item : items) {
      this.serviceAccountNames.add(item);
    }
    return (A) this;
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
  
  public A addToServiceAccountNames(String... items) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    for (String item : items) {
      this.serviceAccountNames.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceAccountNames(int index,String item) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    this.serviceAccountNames.add(index, item);
    return (A) this;
  }
  
  public ObjectReference buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(CredentialsRequestSpec instance) {
    instance = instance != null ? instance : new CredentialsRequestSpec();
    if (instance != null) {
        this.withCloudTokenPath(instance.getCloudTokenPath());
        this.withProviderSpec(instance.getProviderSpec());
        this.withSecretRef(instance.getSecretRef());
        this.withServiceAccountNames(instance.getServiceAccountNames());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(ObjectReference item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    CredentialsRequestSpecFluent that = (CredentialsRequestSpecFluent) o;
    if (!(Objects.equals(cloudTokenPath, that.cloudTokenPath))) {
      return false;
    }
    if (!(Objects.equals(providerSpec, that.providerSpec))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountNames, that.serviceAccountNames))) {
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
  
  public String getCloudTokenPath() {
    return this.cloudTokenPath;
  }
  
  public String getFirstServiceAccountName() {
    return this.serviceAccountNames.get(0);
  }
  
  public String getLastServiceAccountName() {
    return this.serviceAccountNames.get(serviceAccountNames.size() - 1);
  }
  
  public String getMatchingServiceAccountName(Predicate<String> predicate) {
      for (String item : serviceAccountNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Object getProviderSpec() {
    return this.providerSpec;
  }
  
  public String getServiceAccountName(int index) {
    return this.serviceAccountNames.get(index);
  }
  
  public List<String> getServiceAccountNames() {
    return this.serviceAccountNames;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloudTokenPath() {
    return this.cloudTokenPath != null;
  }
  
  public boolean hasMatchingServiceAccountName(Predicate<String> predicate) {
      for (String item : serviceAccountNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProviderSpec() {
    return this.providerSpec != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public boolean hasServiceAccountNames() {
    return this.serviceAccountNames != null && !(this.serviceAccountNames.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(cloudTokenPath, providerSpec, secretRef, serviceAccountNames, additionalProperties);
  }
  
  public A removeAllFromServiceAccountNames(Collection<String> items) {
    if (this.serviceAccountNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceAccountNames.remove(item);
    }
    return (A) this;
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
  
  public A removeFromServiceAccountNames(String... items) {
    if (this.serviceAccountNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceAccountNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToServiceAccountNames(int index,String item) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    this.serviceAccountNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cloudTokenPath == null)) {
        sb.append("cloudTokenPath:");
        sb.append(cloudTokenPath);
        sb.append(",");
    }
    if (!(providerSpec == null)) {
        sb.append("providerSpec:");
        sb.append(providerSpec);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
        sb.append(",");
    }
    if (!(serviceAccountNames == null) && !(serviceAccountNames.isEmpty())) {
        sb.append("serviceAccountNames:");
        sb.append(serviceAccountNames);
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
  
  public A withCloudTokenPath(String cloudTokenPath) {
    this.cloudTokenPath = cloudTokenPath;
    return (A) this;
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public SecretRefNested<A> withNewSecretRefLike(ObjectReference item) {
    return new SecretRefNested(item);
  }
  
  public A withProviderSpec(Object providerSpec) {
    this.providerSpec = providerSpec;
    return (A) this;
  }
  
  public A withSecretRef(ObjectReference secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new ObjectReferenceBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
    return (A) this;
  }
  
  public A withServiceAccountNames(List<String> serviceAccountNames) {
    if (serviceAccountNames != null) {
        this.serviceAccountNames = new ArrayList();
        for (String item : serviceAccountNames) {
          this.addToServiceAccountNames(item);
        }
    } else {
      this.serviceAccountNames = null;
    }
    return (A) this;
  }
  
  public A withServiceAccountNames(String... serviceAccountNames) {
    if (this.serviceAccountNames != null) {
        this.serviceAccountNames.clear();
        _visitables.remove("serviceAccountNames");
    }
    if (serviceAccountNames != null) {
      for (String item : serviceAccountNames) {
        this.addToServiceAccountNames(item);
      }
    }
    return (A) this;
  }
  public class SecretRefNested<N> extends ObjectReferenceFluent<SecretRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    SecretRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CredentialsRequestSpecFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}