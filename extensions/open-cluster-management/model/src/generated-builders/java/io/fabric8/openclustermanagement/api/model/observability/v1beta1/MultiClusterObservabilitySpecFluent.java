package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.openclustermanagement.api.model.shared.ObservabilityAddonSpec;
import io.fabric8.openclustermanagement.api.model.shared.ObservabilityAddonSpecBuilder;
import io.fabric8.openclustermanagement.api.model.shared.ObservabilityAddonSpecFluent;
import java.lang.Boolean;
import java.lang.Long;
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
public class MultiClusterObservabilitySpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta1.MultiClusterObservabilitySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String availabilityConfig;
  private Boolean enableDownSampling;
  private String imagePullPolicy;
  private String imagePullSecret;
  private Map<String,String> nodeSelector;
  private ObservabilityAddonSpecBuilder observabilityAddonSpec;
  private String retentionResolution1h;
  private String retentionResolution5m;
  private String retentionResolutionRaw;
  private StorageConfigObjectBuilder storageConfigObject;
  private List<Toleration> tolerations = new ArrayList<Toleration>();

  public MultiClusterObservabilitySpecFluent() {
  }
  
  public MultiClusterObservabilitySpecFluent(MultiClusterObservabilitySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public ObservabilityAddonSpec buildObservabilityAddonSpec() {
    return this.observabilityAddonSpec != null ? this.observabilityAddonSpec.build() : null;
  }
  
  public StorageConfigObject buildStorageConfigObject() {
    return this.storageConfigObject != null ? this.storageConfigObject.build() : null;
  }
  
  protected void copyInstance(MultiClusterObservabilitySpec instance) {
    instance = instance != null ? instance : new MultiClusterObservabilitySpec();
    if (instance != null) {
        this.withAvailabilityConfig(instance.getAvailabilityConfig());
        this.withEnableDownSampling(instance.getEnableDownSampling());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withNodeSelector(instance.getNodeSelector());
        this.withObservabilityAddonSpec(instance.getObservabilityAddonSpec());
        this.withRetentionResolution1h(instance.getRetentionResolution1h());
        this.withRetentionResolution5m(instance.getRetentionResolution5m());
        this.withRetentionResolutionRaw(instance.getRetentionResolutionRaw());
        this.withStorageConfigObject(instance.getStorageConfigObject());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ObservabilityAddonSpecNested<A> editObservabilityAddonSpec() {
    return this.withNewObservabilityAddonSpecLike(Optional.ofNullable(this.buildObservabilityAddonSpec()).orElse(null));
  }
  
  public ObservabilityAddonSpecNested<A> editOrNewObservabilityAddonSpec() {
    return this.withNewObservabilityAddonSpecLike(Optional.ofNullable(this.buildObservabilityAddonSpec()).orElse(new ObservabilityAddonSpecBuilder().build()));
  }
  
  public ObservabilityAddonSpecNested<A> editOrNewObservabilityAddonSpecLike(ObservabilityAddonSpec item) {
    return this.withNewObservabilityAddonSpecLike(Optional.ofNullable(this.buildObservabilityAddonSpec()).orElse(item));
  }
  
  public StorageConfigObjectNested<A> editOrNewStorageConfigObject() {
    return this.withNewStorageConfigObjectLike(Optional.ofNullable(this.buildStorageConfigObject()).orElse(new StorageConfigObjectBuilder().build()));
  }
  
  public StorageConfigObjectNested<A> editOrNewStorageConfigObjectLike(StorageConfigObject item) {
    return this.withNewStorageConfigObjectLike(Optional.ofNullable(this.buildStorageConfigObject()).orElse(item));
  }
  
  public StorageConfigObjectNested<A> editStorageConfigObject() {
    return this.withNewStorageConfigObjectLike(Optional.ofNullable(this.buildStorageConfigObject()).orElse(null));
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
    MultiClusterObservabilitySpecFluent that = (MultiClusterObservabilitySpecFluent) o;
    if (!(Objects.equals(availabilityConfig, that.availabilityConfig))) {
      return false;
    }
    if (!(Objects.equals(enableDownSampling, that.enableDownSampling))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(observabilityAddonSpec, that.observabilityAddonSpec))) {
      return false;
    }
    if (!(Objects.equals(retentionResolution1h, that.retentionResolution1h))) {
      return false;
    }
    if (!(Objects.equals(retentionResolution5m, that.retentionResolution5m))) {
      return false;
    }
    if (!(Objects.equals(retentionResolutionRaw, that.retentionResolutionRaw))) {
      return false;
    }
    if (!(Objects.equals(storageConfigObject, that.storageConfigObject))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public String getAvailabilityConfig() {
    return this.availabilityConfig;
  }
  
  public Boolean getEnableDownSampling() {
    return this.enableDownSampling;
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getImagePullSecret() {
    return this.imagePullSecret;
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public String getRetentionResolution1h() {
    return this.retentionResolution1h;
  }
  
  public String getRetentionResolution5m() {
    return this.retentionResolution5m;
  }
  
  public String getRetentionResolutionRaw() {
    return this.retentionResolutionRaw;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailabilityConfig() {
    return this.availabilityConfig != null;
  }
  
  public boolean hasEnableDownSampling() {
    return this.enableDownSampling != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasObservabilityAddonSpec() {
    return this.observabilityAddonSpec != null;
  }
  
  public boolean hasRetentionResolution1h() {
    return this.retentionResolution1h != null;
  }
  
  public boolean hasRetentionResolution5m() {
    return this.retentionResolution5m != null;
  }
  
  public boolean hasRetentionResolutionRaw() {
    return this.retentionResolutionRaw != null;
  }
  
  public boolean hasStorageConfigObject() {
    return this.storageConfigObject != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(availabilityConfig, enableDownSampling, imagePullPolicy, imagePullSecret, nodeSelector, observabilityAddonSpec, retentionResolution1h, retentionResolution5m, retentionResolutionRaw, storageConfigObject, tolerations, additionalProperties);
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availabilityConfig == null)) {
        sb.append("availabilityConfig:");
        sb.append(availabilityConfig);
        sb.append(",");
    }
    if (!(enableDownSampling == null)) {
        sb.append("enableDownSampling:");
        sb.append(enableDownSampling);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(imagePullSecret == null)) {
        sb.append("imagePullSecret:");
        sb.append(imagePullSecret);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(observabilityAddonSpec == null)) {
        sb.append("observabilityAddonSpec:");
        sb.append(observabilityAddonSpec);
        sb.append(",");
    }
    if (!(retentionResolution1h == null)) {
        sb.append("retentionResolution1h:");
        sb.append(retentionResolution1h);
        sb.append(",");
    }
    if (!(retentionResolution5m == null)) {
        sb.append("retentionResolution5m:");
        sb.append(retentionResolution5m);
        sb.append(",");
    }
    if (!(retentionResolutionRaw == null)) {
        sb.append("retentionResolutionRaw:");
        sb.append(retentionResolutionRaw);
        sb.append(",");
    }
    if (!(storageConfigObject == null)) {
        sb.append("storageConfigObject:");
        sb.append(storageConfigObject);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withAvailabilityConfig(String availabilityConfig) {
    this.availabilityConfig = availabilityConfig;
    return (A) this;
  }
  
  public A withEnableDownSampling() {
    return withEnableDownSampling(true);
  }
  
  public A withEnableDownSampling(Boolean enableDownSampling) {
    this.enableDownSampling = enableDownSampling;
    return (A) this;
  }
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return (A) this;
  }
  
  public ObservabilityAddonSpecNested<A> withNewObservabilityAddonSpec() {
    return new ObservabilityAddonSpecNested(null);
  }
  
  public ObservabilityAddonSpecNested<A> withNewObservabilityAddonSpecLike(ObservabilityAddonSpec item) {
    return new ObservabilityAddonSpecNested(item);
  }
  
  public StorageConfigObjectNested<A> withNewStorageConfigObject() {
    return new StorageConfigObjectNested(null);
  }
  
  public StorageConfigObjectNested<A> withNewStorageConfigObjectLike(StorageConfigObject item) {
    return new StorageConfigObjectNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withObservabilityAddonSpec(ObservabilityAddonSpec observabilityAddonSpec) {
    this._visitables.remove("observabilityAddonSpec");
    if (observabilityAddonSpec != null) {
        this.observabilityAddonSpec = new ObservabilityAddonSpecBuilder(observabilityAddonSpec);
        this._visitables.get("observabilityAddonSpec").add(this.observabilityAddonSpec);
    } else {
        this.observabilityAddonSpec = null;
        this._visitables.get("observabilityAddonSpec").remove(this.observabilityAddonSpec);
    }
    return (A) this;
  }
  
  public A withRetentionResolution1h(String retentionResolution1h) {
    this.retentionResolution1h = retentionResolution1h;
    return (A) this;
  }
  
  public A withRetentionResolution5m(String retentionResolution5m) {
    this.retentionResolution5m = retentionResolution5m;
    return (A) this;
  }
  
  public A withRetentionResolutionRaw(String retentionResolutionRaw) {
    this.retentionResolutionRaw = retentionResolutionRaw;
    return (A) this;
  }
  
  public A withStorageConfigObject(StorageConfigObject storageConfigObject) {
    this._visitables.remove("storageConfigObject");
    if (storageConfigObject != null) {
        this.storageConfigObject = new StorageConfigObjectBuilder(storageConfigObject);
        this._visitables.get("storageConfigObject").add(this.storageConfigObject);
    } else {
        this.storageConfigObject = null;
        this._visitables.get("storageConfigObject").remove(this.storageConfigObject);
    }
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class ObservabilityAddonSpecNested<N> extends ObservabilityAddonSpecFluent<ObservabilityAddonSpecNested<N>> implements Nested<N>{
  
    ObservabilityAddonSpecBuilder builder;
  
    ObservabilityAddonSpecNested(ObservabilityAddonSpec item) {
      this.builder = new ObservabilityAddonSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterObservabilitySpecFluent.this.withObservabilityAddonSpec(builder.build());
    }
    
    public N endObservabilityAddonSpec() {
      return and();
    }
    
  }
  public class StorageConfigObjectNested<N> extends StorageConfigObjectFluent<StorageConfigObjectNested<N>> implements Nested<N>{
  
    StorageConfigObjectBuilder builder;
  
    StorageConfigObjectNested(StorageConfigObject item) {
      this.builder = new StorageConfigObjectBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterObservabilitySpecFluent.this.withStorageConfigObject(builder.build());
    }
    
    public N endStorageConfigObject() {
      return and();
    }
    
  }
}