package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.TopologySelectorTerm;
import java.lang.Boolean;
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
public class StorageClassFluent<A extends io.fabric8.kubernetes.api.model.storage.v1beta1.StorageClassFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowVolumeExpansion;
  private List<TopologySelectorTerm> allowedTopologies = new ArrayList<TopologySelectorTerm>();
  private String apiVersion;
  private String kind;
  private ObjectMetaBuilder metadata;
  private List<String> mountOptions = new ArrayList<String>();
  private Map<String,String> parameters;
  private String provisioner;
  private String reclaimPolicy;
  private String volumeBindingMode;

  public StorageClassFluent() {
  }
  
  public StorageClassFluent(StorageClass instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedTopologies(Collection<TopologySelectorTerm> items) {
    if (this.allowedTopologies == null) {
      this.allowedTopologies = new ArrayList();
    }
    for (TopologySelectorTerm item : items) {
      this.allowedTopologies.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMountOptions(Collection<String> items) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    for (String item : items) {
      this.mountOptions.add(item);
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
  
  public A addToAllowedTopologies(TopologySelectorTerm... items) {
    if (this.allowedTopologies == null) {
      this.allowedTopologies = new ArrayList();
    }
    for (TopologySelectorTerm item : items) {
      this.allowedTopologies.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedTopologies(int index,TopologySelectorTerm item) {
    if (this.allowedTopologies == null) {
      this.allowedTopologies = new ArrayList();
    }
    this.allowedTopologies.add(index, item);
    return (A) this;
  }
  
  public A addToMountOptions(String... items) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    for (String item : items) {
      this.mountOptions.add(item);
    }
    return (A) this;
  }
  
  public A addToMountOptions(int index,String item) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    this.mountOptions.add(index, item);
    return (A) this;
  }
  
  public A addToParameters(Map<String,String> map) {
    if (this.parameters == null && map != null) {
      this.parameters = new LinkedHashMap();
    }
    if (map != null) {
      this.parameters.putAll(map);
    }
    return (A) this;
  }
  
  public A addToParameters(String key,String value) {
    if (this.parameters == null && key != null && value != null) {
      this.parameters = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.parameters.put(key, value);
    }
    return (A) this;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(StorageClass instance) {
    instance = instance != null ? instance : new StorageClass();
    if (instance != null) {
        this.withAllowVolumeExpansion(instance.getAllowVolumeExpansion());
        this.withAllowedTopologies(instance.getAllowedTopologies());
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withMountOptions(instance.getMountOptions());
        this.withParameters(instance.getParameters());
        this.withProvisioner(instance.getProvisioner());
        this.withReclaimPolicy(instance.getReclaimPolicy());
        this.withVolumeBindingMode(instance.getVolumeBindingMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    StorageClassFluent that = (StorageClassFluent) o;
    if (!(Objects.equals(allowVolumeExpansion, that.allowVolumeExpansion))) {
      return false;
    }
    if (!(Objects.equals(allowedTopologies, that.allowedTopologies))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(mountOptions, that.mountOptions))) {
      return false;
    }
    if (!(Objects.equals(parameters, that.parameters))) {
      return false;
    }
    if (!(Objects.equals(provisioner, that.provisioner))) {
      return false;
    }
    if (!(Objects.equals(reclaimPolicy, that.reclaimPolicy))) {
      return false;
    }
    if (!(Objects.equals(volumeBindingMode, that.volumeBindingMode))) {
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
  
  public Boolean getAllowVolumeExpansion() {
    return this.allowVolumeExpansion;
  }
  
  public List<TopologySelectorTerm> getAllowedTopologies() {
    return this.allowedTopologies;
  }
  
  public TopologySelectorTerm getAllowedTopology(int index) {
    return this.allowedTopologies.get(index);
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public TopologySelectorTerm getFirstAllowedTopology() {
    return this.allowedTopologies.get(0);
  }
  
  public String getFirstMountOption() {
    return this.mountOptions.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public TopologySelectorTerm getLastAllowedTopology() {
    return this.allowedTopologies.get(allowedTopologies.size() - 1);
  }
  
  public String getLastMountOption() {
    return this.mountOptions.get(mountOptions.size() - 1);
  }
  
  public TopologySelectorTerm getMatchingAllowedTopology(Predicate<TopologySelectorTerm> predicate) {
      for (TopologySelectorTerm item : allowedTopologies) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMountOption(Predicate<String> predicate) {
      for (String item : mountOptions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMountOption(int index) {
    return this.mountOptions.get(index);
  }
  
  public List<String> getMountOptions() {
    return this.mountOptions;
  }
  
  public Map<String,String> getParameters() {
    return this.parameters;
  }
  
  public String getProvisioner() {
    return this.provisioner;
  }
  
  public String getReclaimPolicy() {
    return this.reclaimPolicy;
  }
  
  public String getVolumeBindingMode() {
    return this.volumeBindingMode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowVolumeExpansion() {
    return this.allowVolumeExpansion != null;
  }
  
  public boolean hasAllowedTopologies() {
    return this.allowedTopologies != null && !(this.allowedTopologies.isEmpty());
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingAllowedTopology(Predicate<TopologySelectorTerm> predicate) {
      for (TopologySelectorTerm item : allowedTopologies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMountOption(Predicate<String> predicate) {
      for (String item : mountOptions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasMountOptions() {
    return this.mountOptions != null && !(this.mountOptions.isEmpty());
  }
  
  public boolean hasParameters() {
    return this.parameters != null;
  }
  
  public boolean hasProvisioner() {
    return this.provisioner != null;
  }
  
  public boolean hasReclaimPolicy() {
    return this.reclaimPolicy != null;
  }
  
  public boolean hasVolumeBindingMode() {
    return this.volumeBindingMode != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowVolumeExpansion, allowedTopologies, apiVersion, kind, metadata, mountOptions, parameters, provisioner, reclaimPolicy, volumeBindingMode, additionalProperties);
  }
  
  public A removeAllFromAllowedTopologies(Collection<TopologySelectorTerm> items) {
    if (this.allowedTopologies == null) {
      return (A) this;
    }
    for (TopologySelectorTerm item : items) {
      this.allowedTopologies.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMountOptions(Collection<String> items) {
    if (this.mountOptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mountOptions.remove(item);
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
  
  public A removeFromAllowedTopologies(TopologySelectorTerm... items) {
    if (this.allowedTopologies == null) {
      return (A) this;
    }
    for (TopologySelectorTerm item : items) {
      this.allowedTopologies.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMountOptions(String... items) {
    if (this.mountOptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mountOptions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromParameters(String key) {
    if (this.parameters == null) {
      return (A) this;
    }
    if (key != null && this.parameters != null) {
      this.parameters.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromParameters(Map<String,String> map) {
    if (this.parameters == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.parameters != null) {
          this.parameters.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToAllowedTopologies(int index,TopologySelectorTerm item) {
    if (this.allowedTopologies == null) {
      this.allowedTopologies = new ArrayList();
    }
    this.allowedTopologies.set(index, item);
    return (A) this;
  }
  
  public A setToMountOptions(int index,String item) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    this.mountOptions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowVolumeExpansion == null)) {
        sb.append("allowVolumeExpansion:");
        sb.append(allowVolumeExpansion);
        sb.append(",");
    }
    if (!(allowedTopologies == null) && !(allowedTopologies.isEmpty())) {
        sb.append("allowedTopologies:");
        sb.append(allowedTopologies);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(mountOptions == null) && !(mountOptions.isEmpty())) {
        sb.append("mountOptions:");
        sb.append(mountOptions);
        sb.append(",");
    }
    if (!(parameters == null) && !(parameters.isEmpty())) {
        sb.append("parameters:");
        sb.append(parameters);
        sb.append(",");
    }
    if (!(provisioner == null)) {
        sb.append("provisioner:");
        sb.append(provisioner);
        sb.append(",");
    }
    if (!(reclaimPolicy == null)) {
        sb.append("reclaimPolicy:");
        sb.append(reclaimPolicy);
        sb.append(",");
    }
    if (!(volumeBindingMode == null)) {
        sb.append("volumeBindingMode:");
        sb.append(volumeBindingMode);
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
  
  public A withAllowVolumeExpansion() {
    return withAllowVolumeExpansion(true);
  }
  
  public A withAllowVolumeExpansion(Boolean allowVolumeExpansion) {
    this.allowVolumeExpansion = allowVolumeExpansion;
    return (A) this;
  }
  
  public A withAllowedTopologies(List<TopologySelectorTerm> allowedTopologies) {
    if (allowedTopologies != null) {
        this.allowedTopologies = new ArrayList();
        for (TopologySelectorTerm item : allowedTopologies) {
          this.addToAllowedTopologies(item);
        }
    } else {
      this.allowedTopologies = null;
    }
    return (A) this;
  }
  
  public A withAllowedTopologies(TopologySelectorTerm... allowedTopologies) {
    if (this.allowedTopologies != null) {
        this.allowedTopologies.clear();
        _visitables.remove("allowedTopologies");
    }
    if (allowedTopologies != null) {
      for (TopologySelectorTerm item : allowedTopologies) {
        this.addToAllowedTopologies(item);
      }
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public A withMountOptions(List<String> mountOptions) {
    if (mountOptions != null) {
        this.mountOptions = new ArrayList();
        for (String item : mountOptions) {
          this.addToMountOptions(item);
        }
    } else {
      this.mountOptions = null;
    }
    return (A) this;
  }
  
  public A withMountOptions(String... mountOptions) {
    if (this.mountOptions != null) {
        this.mountOptions.clear();
        _visitables.remove("mountOptions");
    }
    if (mountOptions != null) {
      for (String item : mountOptions) {
        this.addToMountOptions(item);
      }
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public <K,V>A withParameters(Map<String,String> parameters) {
    if (parameters == null) {
      this.parameters = null;
    } else {
      this.parameters = new LinkedHashMap(parameters);
    }
    return (A) this;
  }
  
  public A withProvisioner(String provisioner) {
    this.provisioner = provisioner;
    return (A) this;
  }
  
  public A withReclaimPolicy(String reclaimPolicy) {
    this.reclaimPolicy = reclaimPolicy;
    return (A) this;
  }
  
  public A withVolumeBindingMode(String volumeBindingMode) {
    this.volumeBindingMode = volumeBindingMode;
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageClassFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}