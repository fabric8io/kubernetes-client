package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class PodMetricsFluent<A extends io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<ContainerMetricsBuilder> containers = new ArrayList<ContainerMetricsBuilder>();
  private String kind;
  private ObjectMetaBuilder metadata;
  private String timestamp;
  private Duration window;

  public PodMetricsFluent() {
  }
  
  public PodMetricsFluent(PodMetrics instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainers(Collection<ContainerMetrics> items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (ContainerMetrics item : items) {
        ContainerMetricsBuilder builder = new ContainerMetricsBuilder(item);
        _visitables.get("containers").add(builder);
        this.containers.add(builder);
    }
    return (A) this;
  }
  
  public ContainersNested<A> addNewContainer() {
    return new ContainersNested(-1, null);
  }
  
  public ContainersNested<A> addNewContainerLike(ContainerMetrics item) {
    return new ContainersNested(-1, item);
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
  
  public A addToContainers(ContainerMetrics... items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (ContainerMetrics item : items) {
        ContainerMetricsBuilder builder = new ContainerMetricsBuilder(item);
        _visitables.get("containers").add(builder);
        this.containers.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainers(int index,ContainerMetrics item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    ContainerMetricsBuilder builder = new ContainerMetricsBuilder(item);
    if (index < 0 || index >= containers.size()) {
        _visitables.get("containers").add(builder);
        containers.add(builder);
    } else {
        _visitables.get("containers").add(builder);
        containers.add(index, builder);
    }
    return (A) this;
  }
  
  public ContainerMetrics buildContainer(int index) {
    return this.containers.get(index).build();
  }
  
  public List<ContainerMetrics> buildContainers() {
    return this.containers != null ? build(containers) : null;
  }
  
  public ContainerMetrics buildFirstContainer() {
    return this.containers.get(0).build();
  }
  
  public ContainerMetrics buildLastContainer() {
    return this.containers.get(containers.size() - 1).build();
  }
  
  public ContainerMetrics buildMatchingContainer(Predicate<ContainerMetricsBuilder> predicate) {
      for (ContainerMetricsBuilder item : containers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(PodMetrics instance) {
    instance = instance != null ? instance : new PodMetrics();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withContainers(instance.getContainers());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withTimestamp(instance.getTimestamp());
        this.withWindow(instance.getWindow());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainersNested<A> editContainer(int index) {
    if (containers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public ContainersNested<A> editFirstContainer() {
    if (containers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(0, this.buildContainer(0));
  }
  
  public ContainersNested<A> editLastContainer() {
    int index = containers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public ContainersNested<A> editMatchingContainer(Predicate<ContainerMetricsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containers.size();i++) {
      if (predicate.test(containers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
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
    PodMetricsFluent that = (PodMetricsFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(containers, that.containers))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(timestamp, that.timestamp))) {
      return false;
    }
    if (!(Objects.equals(window, that.window))) {
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
  
  public String getKind() {
    return this.kind;
  }
  
  public String getTimestamp() {
    return this.timestamp;
  }
  
  public Duration getWindow() {
    return this.window;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasContainers() {
    return this.containers != null && !(this.containers.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingContainer(Predicate<ContainerMetricsBuilder> predicate) {
      for (ContainerMetricsBuilder item : containers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasTimestamp() {
    return this.timestamp != null;
  }
  
  public boolean hasWindow() {
    return this.window != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, containers, kind, metadata, timestamp, window, additionalProperties);
  }
  
  public A removeAllFromContainers(Collection<ContainerMetrics> items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (ContainerMetrics item : items) {
        ContainerMetricsBuilder builder = new ContainerMetricsBuilder(item);
        _visitables.get("containers").remove(builder);
        this.containers.remove(builder);
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
  
  public A removeFromContainers(ContainerMetrics... items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (ContainerMetrics item : items) {
        ContainerMetricsBuilder builder = new ContainerMetricsBuilder(item);
        _visitables.get("containers").remove(builder);
        this.containers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainers(Predicate<ContainerMetricsBuilder> predicate) {
    if (containers == null) {
      return (A) this;
    }
    Iterator<ContainerMetricsBuilder> each = containers.iterator();
    List visitables = _visitables.get("containers");
    while (each.hasNext()) {
        ContainerMetricsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContainersNested<A> setNewContainerLike(int index,ContainerMetrics item) {
    return new ContainersNested(index, item);
  }
  
  public A setToContainers(int index,ContainerMetrics item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    ContainerMetricsBuilder builder = new ContainerMetricsBuilder(item);
    if (index < 0 || index >= containers.size()) {
        _visitables.get("containers").add(builder);
        containers.add(builder);
    } else {
        _visitables.get("containers").add(builder);
        containers.set(index, builder);
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
    if (!(containers == null) && !(containers.isEmpty())) {
        sb.append("containers:");
        sb.append(containers);
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
    if (!(timestamp == null)) {
        sb.append("timestamp:");
        sb.append(timestamp);
        sb.append(",");
    }
    if (!(window == null)) {
        sb.append("window:");
        sb.append(window);
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
  
  public A withContainers(List<ContainerMetrics> containers) {
    if (this.containers != null) {
      this._visitables.get("containers").clear();
    }
    if (containers != null) {
        this.containers = new ArrayList();
        for (ContainerMetrics item : containers) {
          this.addToContainers(item);
        }
    } else {
      this.containers = null;
    }
    return (A) this;
  }
  
  public A withContainers(ContainerMetrics... containers) {
    if (this.containers != null) {
        this.containers.clear();
        _visitables.remove("containers");
    }
    if (containers != null) {
      for (ContainerMetrics item : containers) {
        this.addToContainers(item);
      }
    }
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
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withTimestamp(String timestamp) {
    this.timestamp = timestamp;
    return (A) this;
  }
  
  public A withWindow(Duration window) {
    this.window = window;
    return (A) this;
  }
  public class ContainersNested<N> extends ContainerMetricsFluent<ContainersNested<N>> implements Nested<N>{
  
    ContainerMetricsBuilder builder;
    int index;
  
    ContainersNested(int index,ContainerMetrics item) {
      this.index = index;
      this.builder = new ContainerMetricsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodMetricsFluent.this.setToContainers(index, builder.build());
    }
    
    public N endContainer() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) PodMetricsFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}