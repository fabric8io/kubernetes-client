package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class Metal3DataTemplateSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3DataTemplateSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterName;
  private MetaDataBuilder metaData;
  private NetworkDataBuilder networkData;
  private String templateReference;

  public Metal3DataTemplateSpecFluent() {
  }
  
  public Metal3DataTemplateSpecFluent(Metal3DataTemplateSpec instance) {
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
  
  public MetaData buildMetaData() {
    return this.metaData != null ? this.metaData.build() : null;
  }
  
  public NetworkData buildNetworkData() {
    return this.networkData != null ? this.networkData.build() : null;
  }
  
  protected void copyInstance(Metal3DataTemplateSpec instance) {
    instance = instance != null ? instance : new Metal3DataTemplateSpec();
    if (instance != null) {
        this.withClusterName(instance.getClusterName());
        this.withMetaData(instance.getMetaData());
        this.withNetworkData(instance.getNetworkData());
        this.withTemplateReference(instance.getTemplateReference());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetaDataNested<A> editMetaData() {
    return this.withNewMetaDataLike(Optional.ofNullable(this.buildMetaData()).orElse(null));
  }
  
  public NetworkDataNested<A> editNetworkData() {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(null));
  }
  
  public MetaDataNested<A> editOrNewMetaData() {
    return this.withNewMetaDataLike(Optional.ofNullable(this.buildMetaData()).orElse(new MetaDataBuilder().build()));
  }
  
  public MetaDataNested<A> editOrNewMetaDataLike(MetaData item) {
    return this.withNewMetaDataLike(Optional.ofNullable(this.buildMetaData()).orElse(item));
  }
  
  public NetworkDataNested<A> editOrNewNetworkData() {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(new NetworkDataBuilder().build()));
  }
  
  public NetworkDataNested<A> editOrNewNetworkDataLike(NetworkData item) {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(item));
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
    Metal3DataTemplateSpecFluent that = (Metal3DataTemplateSpecFluent) o;
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(metaData, that.metaData))) {
      return false;
    }
    if (!(Objects.equals(networkData, that.networkData))) {
      return false;
    }
    if (!(Objects.equals(templateReference, that.templateReference))) {
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
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public String getTemplateReference() {
    return this.templateReference;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasMetaData() {
    return this.metaData != null;
  }
  
  public boolean hasNetworkData() {
    return this.networkData != null;
  }
  
  public boolean hasTemplateReference() {
    return this.templateReference != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterName, metaData, networkData, templateReference, additionalProperties);
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
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(metaData == null)) {
        sb.append("metaData:");
        sb.append(metaData);
        sb.append(",");
    }
    if (!(networkData == null)) {
        sb.append("networkData:");
        sb.append(networkData);
        sb.append(",");
    }
    if (!(templateReference == null)) {
        sb.append("templateReference:");
        sb.append(templateReference);
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
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withMetaData(MetaData metaData) {
    this._visitables.remove("metaData");
    if (metaData != null) {
        this.metaData = new MetaDataBuilder(metaData);
        this._visitables.get("metaData").add(this.metaData);
    } else {
        this.metaData = null;
        this._visitables.get("metaData").remove(this.metaData);
    }
    return (A) this;
  }
  
  public A withNetworkData(NetworkData networkData) {
    this._visitables.remove("networkData");
    if (networkData != null) {
        this.networkData = new NetworkDataBuilder(networkData);
        this._visitables.get("networkData").add(this.networkData);
    } else {
        this.networkData = null;
        this._visitables.get("networkData").remove(this.networkData);
    }
    return (A) this;
  }
  
  public MetaDataNested<A> withNewMetaData() {
    return new MetaDataNested(null);
  }
  
  public MetaDataNested<A> withNewMetaDataLike(MetaData item) {
    return new MetaDataNested(item);
  }
  
  public NetworkDataNested<A> withNewNetworkData() {
    return new NetworkDataNested(null);
  }
  
  public NetworkDataNested<A> withNewNetworkDataLike(NetworkData item) {
    return new NetworkDataNested(item);
  }
  
  public A withTemplateReference(String templateReference) {
    this.templateReference = templateReference;
    return (A) this;
  }
  public class MetaDataNested<N> extends MetaDataFluent<MetaDataNested<N>> implements Nested<N>{
  
    MetaDataBuilder builder;
  
    MetaDataNested(MetaData item) {
      this.builder = new MetaDataBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3DataTemplateSpecFluent.this.withMetaData(builder.build());
    }
    
    public N endMetaData() {
      return and();
    }
    
  }
  public class NetworkDataNested<N> extends NetworkDataFluent<NetworkDataNested<N>> implements Nested<N>{
  
    NetworkDataBuilder builder;
  
    NetworkDataNested(NetworkData item) {
      this.builder = new NetworkDataBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3DataTemplateSpecFluent.this.withNetworkData(builder.build());
    }
    
    public N endNetworkData() {
      return and();
    }
    
  }
}