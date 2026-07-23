package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
public class MultiClusterObservabilitySpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.MultiClusterObservabilitySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AdvancedConfigBuilder advanced;
  private CapabilitiesSpecBuilder capabilities;
  private Boolean enableDownsampling;
  private String imagePullPolicy;
  private String imagePullSecret;
  private String instanceSize;
  private Map<String,String> nodeSelector;
  private ObservabilityAddonSpecBuilder observabilityAddonSpec;
  private StorageConfigBuilder storageConfig;
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
  
  public AdvancedConfig buildAdvanced() {
    return this.advanced != null ? this.advanced.build() : null;
  }
  
  public CapabilitiesSpec buildCapabilities() {
    return this.capabilities != null ? this.capabilities.build() : null;
  }
  
  public ObservabilityAddonSpec buildObservabilityAddonSpec() {
    return this.observabilityAddonSpec != null ? this.observabilityAddonSpec.build() : null;
  }
  
  public StorageConfig buildStorageConfig() {
    return this.storageConfig != null ? this.storageConfig.build() : null;
  }
  
  protected void copyInstance(MultiClusterObservabilitySpec instance) {
    instance = instance != null ? instance : new MultiClusterObservabilitySpec();
    if (instance != null) {
        this.withAdvanced(instance.getAdvanced());
        this.withCapabilities(instance.getCapabilities());
        this.withEnableDownsampling(instance.getEnableDownsampling());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withInstanceSize(instance.getInstanceSize());
        this.withNodeSelector(instance.getNodeSelector());
        this.withObservabilityAddonSpec(instance.getObservabilityAddonSpec());
        this.withStorageConfig(instance.getStorageConfig());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdvancedNested<A> editAdvanced() {
    return this.withNewAdvancedLike(Optional.ofNullable(this.buildAdvanced()).orElse(null));
  }
  
  public CapabilitiesNested<A> editCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(null));
  }
  
  public ObservabilityAddonSpecNested<A> editObservabilityAddonSpec() {
    return this.withNewObservabilityAddonSpecLike(Optional.ofNullable(this.buildObservabilityAddonSpec()).orElse(null));
  }
  
  public AdvancedNested<A> editOrNewAdvanced() {
    return this.withNewAdvancedLike(Optional.ofNullable(this.buildAdvanced()).orElse(new AdvancedConfigBuilder().build()));
  }
  
  public AdvancedNested<A> editOrNewAdvancedLike(AdvancedConfig item) {
    return this.withNewAdvancedLike(Optional.ofNullable(this.buildAdvanced()).orElse(item));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(new CapabilitiesSpecBuilder().build()));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilitiesLike(CapabilitiesSpec item) {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(item));
  }
  
  public ObservabilityAddonSpecNested<A> editOrNewObservabilityAddonSpec() {
    return this.withNewObservabilityAddonSpecLike(Optional.ofNullable(this.buildObservabilityAddonSpec()).orElse(new ObservabilityAddonSpecBuilder().build()));
  }
  
  public ObservabilityAddonSpecNested<A> editOrNewObservabilityAddonSpecLike(ObservabilityAddonSpec item) {
    return this.withNewObservabilityAddonSpecLike(Optional.ofNullable(this.buildObservabilityAddonSpec()).orElse(item));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfig() {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(new StorageConfigBuilder().build()));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfigLike(StorageConfig item) {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(item));
  }
  
  public StorageConfigNested<A> editStorageConfig() {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(null));
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
    if (!(Objects.equals(advanced, that.advanced))) {
      return false;
    }
    if (!(Objects.equals(capabilities, that.capabilities))) {
      return false;
    }
    if (!(Objects.equals(enableDownsampling, that.enableDownsampling))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(instanceSize, that.instanceSize))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(observabilityAddonSpec, that.observabilityAddonSpec))) {
      return false;
    }
    if (!(Objects.equals(storageConfig, that.storageConfig))) {
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
  
  public Boolean getEnableDownsampling() {
    return this.enableDownsampling;
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
  
  public String getInstanceSize() {
    return this.instanceSize;
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
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdvanced() {
    return this.advanced != null;
  }
  
  public boolean hasCapabilities() {
    return this.capabilities != null;
  }
  
  public boolean hasEnableDownsampling() {
    return this.enableDownsampling != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasInstanceSize() {
    return this.instanceSize != null;
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
  
  public boolean hasStorageConfig() {
    return this.storageConfig != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(advanced, capabilities, enableDownsampling, imagePullPolicy, imagePullSecret, instanceSize, nodeSelector, observabilityAddonSpec, storageConfig, tolerations, additionalProperties);
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
    if (!(advanced == null)) {
        sb.append("advanced:");
        sb.append(advanced);
        sb.append(",");
    }
    if (!(capabilities == null)) {
        sb.append("capabilities:");
        sb.append(capabilities);
        sb.append(",");
    }
    if (!(enableDownsampling == null)) {
        sb.append("enableDownsampling:");
        sb.append(enableDownsampling);
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
    if (!(instanceSize == null)) {
        sb.append("instanceSize:");
        sb.append(instanceSize);
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
    if (!(storageConfig == null)) {
        sb.append("storageConfig:");
        sb.append(storageConfig);
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
  
  public A withAdvanced(AdvancedConfig advanced) {
    this._visitables.remove("advanced");
    if (advanced != null) {
        this.advanced = new AdvancedConfigBuilder(advanced);
        this._visitables.get("advanced").add(this.advanced);
    } else {
        this.advanced = null;
        this._visitables.get("advanced").remove(this.advanced);
    }
    return (A) this;
  }
  
  public A withCapabilities(CapabilitiesSpec capabilities) {
    this._visitables.remove("capabilities");
    if (capabilities != null) {
        this.capabilities = new CapabilitiesSpecBuilder(capabilities);
        this._visitables.get("capabilities").add(this.capabilities);
    } else {
        this.capabilities = null;
        this._visitables.get("capabilities").remove(this.capabilities);
    }
    return (A) this;
  }
  
  public A withEnableDownsampling() {
    return withEnableDownsampling(true);
  }
  
  public A withEnableDownsampling(Boolean enableDownsampling) {
    this.enableDownsampling = enableDownsampling;
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
  
  public A withInstanceSize(String instanceSize) {
    this.instanceSize = instanceSize;
    return (A) this;
  }
  
  public AdvancedNested<A> withNewAdvanced() {
    return new AdvancedNested(null);
  }
  
  public AdvancedNested<A> withNewAdvancedLike(AdvancedConfig item) {
    return new AdvancedNested(item);
  }
  
  public CapabilitiesNested<A> withNewCapabilities() {
    return new CapabilitiesNested(null);
  }
  
  public CapabilitiesNested<A> withNewCapabilitiesLike(CapabilitiesSpec item) {
    return new CapabilitiesNested(item);
  }
  
  public ObservabilityAddonSpecNested<A> withNewObservabilityAddonSpec() {
    return new ObservabilityAddonSpecNested(null);
  }
  
  public ObservabilityAddonSpecNested<A> withNewObservabilityAddonSpecLike(ObservabilityAddonSpec item) {
    return new ObservabilityAddonSpecNested(item);
  }
  
  public StorageConfigNested<A> withNewStorageConfig() {
    return new StorageConfigNested(null);
  }
  
  public StorageConfigNested<A> withNewStorageConfigLike(StorageConfig item) {
    return new StorageConfigNested(item);
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
  
  public A withStorageConfig(StorageConfig storageConfig) {
    this._visitables.remove("storageConfig");
    if (storageConfig != null) {
        this.storageConfig = new StorageConfigBuilder(storageConfig);
        this._visitables.get("storageConfig").add(this.storageConfig);
    } else {
        this.storageConfig = null;
        this._visitables.get("storageConfig").remove(this.storageConfig);
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
  public class AdvancedNested<N> extends AdvancedConfigFluent<AdvancedNested<N>> implements Nested<N>{
  
    AdvancedConfigBuilder builder;
  
    AdvancedNested(AdvancedConfig item) {
      this.builder = new AdvancedConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterObservabilitySpecFluent.this.withAdvanced(builder.build());
    }
    
    public N endAdvanced() {
      return and();
    }
    
  }
  public class CapabilitiesNested<N> extends CapabilitiesSpecFluent<CapabilitiesNested<N>> implements Nested<N>{
  
    CapabilitiesSpecBuilder builder;
  
    CapabilitiesNested(CapabilitiesSpec item) {
      this.builder = new CapabilitiesSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterObservabilitySpecFluent.this.withCapabilities(builder.build());
    }
    
    public N endCapabilities() {
      return and();
    }
    
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
  public class StorageConfigNested<N> extends StorageConfigFluent<StorageConfigNested<N>> implements Nested<N>{
  
    StorageConfigBuilder builder;
  
    StorageConfigNested(StorageConfig item) {
      this.builder = new StorageConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterObservabilitySpecFluent.this.withStorageConfig(builder.build());
    }
    
    public N endStorageConfig() {
      return and();
    }
    
  }
}