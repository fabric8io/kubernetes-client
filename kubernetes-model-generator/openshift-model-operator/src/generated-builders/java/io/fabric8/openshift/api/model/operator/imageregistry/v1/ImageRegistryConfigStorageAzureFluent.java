package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class ImageRegistryConfigStorageAzureFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageAzureFluent<A>> extends BaseFluent<A>{

  private String accountName;
  private Map<String,Object> additionalProperties;
  private String cloudName;
  private String container;
  private AzureNetworkAccessBuilder networkAccess;

  public ImageRegistryConfigStorageAzureFluent() {
  }
  
  public ImageRegistryConfigStorageAzureFluent(ImageRegistryConfigStorageAzure instance) {
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
  
  public AzureNetworkAccess buildNetworkAccess() {
    return this.networkAccess != null ? this.networkAccess.build() : null;
  }
  
  protected void copyInstance(ImageRegistryConfigStorageAzure instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorageAzure();
    if (instance != null) {
        this.withAccountName(instance.getAccountName());
        this.withCloudName(instance.getCloudName());
        this.withContainer(instance.getContainer());
        this.withNetworkAccess(instance.getNetworkAccess());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkAccessNested<A> editNetworkAccess() {
    return this.withNewNetworkAccessLike(Optional.ofNullable(this.buildNetworkAccess()).orElse(null));
  }
  
  public NetworkAccessNested<A> editOrNewNetworkAccess() {
    return this.withNewNetworkAccessLike(Optional.ofNullable(this.buildNetworkAccess()).orElse(new AzureNetworkAccessBuilder().build()));
  }
  
  public NetworkAccessNested<A> editOrNewNetworkAccessLike(AzureNetworkAccess item) {
    return this.withNewNetworkAccessLike(Optional.ofNullable(this.buildNetworkAccess()).orElse(item));
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
    ImageRegistryConfigStorageAzureFluent that = (ImageRegistryConfigStorageAzureFluent) o;
    if (!(Objects.equals(accountName, that.accountName))) {
      return false;
    }
    if (!(Objects.equals(cloudName, that.cloudName))) {
      return false;
    }
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(networkAccess, that.networkAccess))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccountName() {
    return this.accountName;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getCloudName() {
    return this.cloudName;
  }
  
  public String getContainer() {
    return this.container;
  }
  
  public boolean hasAccountName() {
    return this.accountName != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloudName() {
    return this.cloudName != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasNetworkAccess() {
    return this.networkAccess != null;
  }
  
  public int hashCode() {
    return Objects.hash(accountName, cloudName, container, networkAccess, additionalProperties);
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
    if (!(accountName == null)) {
        sb.append("accountName:");
        sb.append(accountName);
        sb.append(",");
    }
    if (!(cloudName == null)) {
        sb.append("cloudName:");
        sb.append(cloudName);
        sb.append(",");
    }
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(networkAccess == null)) {
        sb.append("networkAccess:");
        sb.append(networkAccess);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccountName(String accountName) {
    this.accountName = accountName;
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
  
  public A withCloudName(String cloudName) {
    this.cloudName = cloudName;
    return (A) this;
  }
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withNetworkAccess(AzureNetworkAccess networkAccess) {
    this._visitables.remove("networkAccess");
    if (networkAccess != null) {
        this.networkAccess = new AzureNetworkAccessBuilder(networkAccess);
        this._visitables.get("networkAccess").add(this.networkAccess);
    } else {
        this.networkAccess = null;
        this._visitables.get("networkAccess").remove(this.networkAccess);
    }
    return (A) this;
  }
  
  public NetworkAccessNested<A> withNewNetworkAccess() {
    return new NetworkAccessNested(null);
  }
  
  public NetworkAccessNested<A> withNewNetworkAccessLike(AzureNetworkAccess item) {
    return new NetworkAccessNested(item);
  }
  public class NetworkAccessNested<N> extends AzureNetworkAccessFluent<NetworkAccessNested<N>> implements Nested<N>{
  
    AzureNetworkAccessBuilder builder;
  
    NetworkAccessNested(AzureNetworkAccess item) {
      this.builder = new AzureNetworkAccessBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageAzureFluent.this.withNetworkAccess(builder.build());
    }
    
    public N endNetworkAccess() {
      return and();
    }
    
  }
}