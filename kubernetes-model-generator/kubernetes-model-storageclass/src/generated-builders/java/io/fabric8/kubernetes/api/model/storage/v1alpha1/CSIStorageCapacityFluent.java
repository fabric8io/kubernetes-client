package io.fabric8.kubernetes.api.model.storage.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class CSIStorageCapacityFluent<A extends io.fabric8.kubernetes.api.model.storage.v1alpha1.CSIStorageCapacityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Quantity capacity;
  private String kind;
  private Quantity maximumVolumeSize;
  private ObjectMetaBuilder metadata;
  private LabelSelectorBuilder nodeTopology;
  private String storageClassName;

  public CSIStorageCapacityFluent() {
  }
  
  public CSIStorageCapacityFluent(CSIStorageCapacity instance) {
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
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public LabelSelector buildNodeTopology() {
    return this.nodeTopology != null ? this.nodeTopology.build() : null;
  }
  
  protected void copyInstance(CSIStorageCapacity instance) {
    instance = instance != null ? instance : new CSIStorageCapacity();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withCapacity(instance.getCapacity());
        this.withKind(instance.getKind());
        this.withMaximumVolumeSize(instance.getMaximumVolumeSize());
        this.withMetadata(instance.getMetadata());
        this.withNodeTopology(instance.getNodeTopology());
        this.withStorageClassName(instance.getStorageClassName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public NodeTopologyNested<A> editNodeTopology() {
    return this.withNewNodeTopologyLike(Optional.ofNullable(this.buildNodeTopology()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public NodeTopologyNested<A> editOrNewNodeTopology() {
    return this.withNewNodeTopologyLike(Optional.ofNullable(this.buildNodeTopology()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NodeTopologyNested<A> editOrNewNodeTopologyLike(LabelSelector item) {
    return this.withNewNodeTopologyLike(Optional.ofNullable(this.buildNodeTopology()).orElse(item));
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
    CSIStorageCapacityFluent that = (CSIStorageCapacityFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(maximumVolumeSize, that.maximumVolumeSize))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(nodeTopology, that.nodeTopology))) {
      return false;
    }
    if (!(Objects.equals(storageClassName, that.storageClassName))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public Quantity getCapacity() {
    return this.capacity;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Quantity getMaximumVolumeSize() {
    return this.maximumVolumeSize;
  }
  
  public String getStorageClassName() {
    return this.storageClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMaximumVolumeSize() {
    return this.maximumVolumeSize != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNodeTopology() {
    return this.nodeTopology != null;
  }
  
  public boolean hasStorageClassName() {
    return this.storageClassName != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, capacity, kind, maximumVolumeSize, metadata, nodeTopology, storageClassName, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(capacity == null)) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(maximumVolumeSize == null)) {
        sb.append("maximumVolumeSize:");
        sb.append(maximumVolumeSize);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(nodeTopology == null)) {
        sb.append("nodeTopology:");
        sb.append(nodeTopology);
        sb.append(",");
    }
    if (!(storageClassName == null)) {
        sb.append("storageClassName:");
        sb.append(storageClassName);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withCapacity(Quantity capacity) {
    this.capacity = capacity;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMaximumVolumeSize(Quantity maximumVolumeSize) {
    this.maximumVolumeSize = maximumVolumeSize;
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
  
  public A withNewCapacity(String amount) {
    return (A) this.withCapacity(new Quantity(amount));
  }
  
  public A withNewCapacity(String amount,String format) {
    return (A) this.withCapacity(new Quantity(amount, format));
  }
  
  public A withNewMaximumVolumeSize(String amount) {
    return (A) this.withMaximumVolumeSize(new Quantity(amount));
  }
  
  public A withNewMaximumVolumeSize(String amount,String format) {
    return (A) this.withMaximumVolumeSize(new Quantity(amount, format));
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public NodeTopologyNested<A> withNewNodeTopology() {
    return new NodeTopologyNested(null);
  }
  
  public NodeTopologyNested<A> withNewNodeTopologyLike(LabelSelector item) {
    return new NodeTopologyNested(item);
  }
  
  public A withNodeTopology(LabelSelector nodeTopology) {
    this._visitables.remove("nodeTopology");
    if (nodeTopology != null) {
        this.nodeTopology = new LabelSelectorBuilder(nodeTopology);
        this._visitables.get("nodeTopology").add(this.nodeTopology);
    } else {
        this.nodeTopology = null;
        this._visitables.get("nodeTopology").remove(this.nodeTopology);
    }
    return (A) this;
  }
  
  public A withStorageClassName(String storageClassName) {
    this.storageClassName = storageClassName;
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIStorageCapacityFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class NodeTopologyNested<N> extends LabelSelectorFluent<NodeTopologyNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NodeTopologyNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIStorageCapacityFluent.this.withNodeTopology(builder.build());
    }
    
    public N endNodeTopology() {
      return and();
    }
    
  }
}