package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class PreprovisioningImageStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.PreprovisioningImageStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String architecture;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String extraKernelParams;
  private String format;
  private String imageUrl;
  private String kernelUrl;
  private SecretStatusBuilder networkData;

  public PreprovisioningImageStatusFluent() {
  }
  
  public PreprovisioningImageStatusFluent(PreprovisioningImageStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public SecretStatus buildNetworkData() {
    return this.networkData != null ? this.networkData.build() : null;
  }
  
  protected void copyInstance(PreprovisioningImageStatus instance) {
    instance = instance != null ? instance : new PreprovisioningImageStatus();
    if (instance != null) {
        this.withArchitecture(instance.getArchitecture());
        this.withConditions(instance.getConditions());
        this.withExtraKernelParams(instance.getExtraKernelParams());
        this.withFormat(instance.getFormat());
        this.withImageUrl(instance.getImageUrl());
        this.withKernelUrl(instance.getKernelUrl());
        this.withNetworkData(instance.getNetworkData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkDataNested<A> editNetworkData() {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(null));
  }
  
  public NetworkDataNested<A> editOrNewNetworkData() {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(new SecretStatusBuilder().build()));
  }
  
  public NetworkDataNested<A> editOrNewNetworkDataLike(SecretStatus item) {
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
    PreprovisioningImageStatusFluent that = (PreprovisioningImageStatusFluent) o;
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(extraKernelParams, that.extraKernelParams))) {
      return false;
    }
    if (!(Objects.equals(format, that.format))) {
      return false;
    }
    if (!(Objects.equals(imageUrl, that.imageUrl))) {
      return false;
    }
    if (!(Objects.equals(kernelUrl, that.kernelUrl))) {
      return false;
    }
    if (!(Objects.equals(networkData, that.networkData))) {
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
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getExtraKernelParams() {
    return this.extraKernelParams;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public String getFormat() {
    return this.format;
  }
  
  public String getImageUrl() {
    return this.imageUrl;
  }
  
  public String getKernelUrl() {
    return this.kernelUrl;
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasExtraKernelParams() {
    return this.extraKernelParams != null;
  }
  
  public boolean hasFormat() {
    return this.format != null;
  }
  
  public boolean hasImageUrl() {
    return this.imageUrl != null;
  }
  
  public boolean hasKernelUrl() {
    return this.kernelUrl != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkData() {
    return this.networkData != null;
  }
  
  public int hashCode() {
    return Objects.hash(architecture, conditions, extraKernelParams, format, imageUrl, kernelUrl, networkData, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(extraKernelParams == null)) {
        sb.append("extraKernelParams:");
        sb.append(extraKernelParams);
        sb.append(",");
    }
    if (!(format == null)) {
        sb.append("format:");
        sb.append(format);
        sb.append(",");
    }
    if (!(imageUrl == null)) {
        sb.append("imageUrl:");
        sb.append(imageUrl);
        sb.append(",");
    }
    if (!(kernelUrl == null)) {
        sb.append("kernelUrl:");
        sb.append(kernelUrl);
        sb.append(",");
    }
    if (!(networkData == null)) {
        sb.append("networkData:");
        sb.append(networkData);
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
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withExtraKernelParams(String extraKernelParams) {
    this.extraKernelParams = extraKernelParams;
    return (A) this;
  }
  
  public A withFormat(String format) {
    this.format = format;
    return (A) this;
  }
  
  public A withImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return (A) this;
  }
  
  public A withKernelUrl(String kernelUrl) {
    this.kernelUrl = kernelUrl;
    return (A) this;
  }
  
  public A withNetworkData(SecretStatus networkData) {
    this._visitables.remove("networkData");
    if (networkData != null) {
        this.networkData = new SecretStatusBuilder(networkData);
        this._visitables.get("networkData").add(this.networkData);
    } else {
        this.networkData = null;
        this._visitables.get("networkData").remove(this.networkData);
    }
    return (A) this;
  }
  
  public NetworkDataNested<A> withNewNetworkData() {
    return new NetworkDataNested(null);
  }
  
  public A withNewNetworkData(String name,String version) {
    return (A) this.withNetworkData(new SecretStatus(name, version));
  }
  
  public NetworkDataNested<A> withNewNetworkDataLike(SecretStatus item) {
    return new NetworkDataNested(item);
  }
  public class NetworkDataNested<N> extends SecretStatusFluent<NetworkDataNested<N>> implements Nested<N>{
  
    SecretStatusBuilder builder;
  
    NetworkDataNested(SecretStatus item) {
      this.builder = new SecretStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PreprovisioningImageStatusFluent.this.withNetworkData(builder.build());
    }
    
    public N endNetworkData() {
      return and();
    }
    
  }
}