package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorage;
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorageBuilder;
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorageFluent;
import java.lang.Boolean;
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
public class StorageConfigObjectFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta1.StorageConfigObjectFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PreConfiguredStorageBuilder metricObjectStorage;
  private String statefulSetSize;
  private String statefulSetStorageClass;

  public StorageConfigObjectFluent() {
  }
  
  public StorageConfigObjectFluent(StorageConfigObject instance) {
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
  
  public PreConfiguredStorage buildMetricObjectStorage() {
    return this.metricObjectStorage != null ? this.metricObjectStorage.build() : null;
  }
  
  protected void copyInstance(StorageConfigObject instance) {
    instance = instance != null ? instance : new StorageConfigObject();
    if (instance != null) {
        this.withMetricObjectStorage(instance.getMetricObjectStorage());
        this.withStatefulSetSize(instance.getStatefulSetSize());
        this.withStatefulSetStorageClass(instance.getStatefulSetStorageClass());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetricObjectStorageNested<A> editMetricObjectStorage() {
    return this.withNewMetricObjectStorageLike(Optional.ofNullable(this.buildMetricObjectStorage()).orElse(null));
  }
  
  public MetricObjectStorageNested<A> editOrNewMetricObjectStorage() {
    return this.withNewMetricObjectStorageLike(Optional.ofNullable(this.buildMetricObjectStorage()).orElse(new PreConfiguredStorageBuilder().build()));
  }
  
  public MetricObjectStorageNested<A> editOrNewMetricObjectStorageLike(PreConfiguredStorage item) {
    return this.withNewMetricObjectStorageLike(Optional.ofNullable(this.buildMetricObjectStorage()).orElse(item));
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
    StorageConfigObjectFluent that = (StorageConfigObjectFluent) o;
    if (!(Objects.equals(metricObjectStorage, that.metricObjectStorage))) {
      return false;
    }
    if (!(Objects.equals(statefulSetSize, that.statefulSetSize))) {
      return false;
    }
    if (!(Objects.equals(statefulSetStorageClass, that.statefulSetStorageClass))) {
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
  
  public String getStatefulSetSize() {
    return this.statefulSetSize;
  }
  
  public String getStatefulSetStorageClass() {
    return this.statefulSetStorageClass;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMetricObjectStorage() {
    return this.metricObjectStorage != null;
  }
  
  public boolean hasStatefulSetSize() {
    return this.statefulSetSize != null;
  }
  
  public boolean hasStatefulSetStorageClass() {
    return this.statefulSetStorageClass != null;
  }
  
  public int hashCode() {
    return Objects.hash(metricObjectStorage, statefulSetSize, statefulSetStorageClass, additionalProperties);
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
    if (!(metricObjectStorage == null)) {
        sb.append("metricObjectStorage:");
        sb.append(metricObjectStorage);
        sb.append(",");
    }
    if (!(statefulSetSize == null)) {
        sb.append("statefulSetSize:");
        sb.append(statefulSetSize);
        sb.append(",");
    }
    if (!(statefulSetStorageClass == null)) {
        sb.append("statefulSetStorageClass:");
        sb.append(statefulSetStorageClass);
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
  
  public A withMetricObjectStorage(PreConfiguredStorage metricObjectStorage) {
    this._visitables.remove("metricObjectStorage");
    if (metricObjectStorage != null) {
        this.metricObjectStorage = new PreConfiguredStorageBuilder(metricObjectStorage);
        this._visitables.get("metricObjectStorage").add(this.metricObjectStorage);
    } else {
        this.metricObjectStorage = null;
        this._visitables.get("metricObjectStorage").remove(this.metricObjectStorage);
    }
    return (A) this;
  }
  
  public MetricObjectStorageNested<A> withNewMetricObjectStorage() {
    return new MetricObjectStorageNested(null);
  }
  
  public A withNewMetricObjectStorage(String key,String name,Boolean serviceAccountProjection,String tlsSecretMountPath,String tlsSecretName) {
    return (A) this.withMetricObjectStorage(new PreConfiguredStorage(key, name, serviceAccountProjection, tlsSecretMountPath, tlsSecretName));
  }
  
  public MetricObjectStorageNested<A> withNewMetricObjectStorageLike(PreConfiguredStorage item) {
    return new MetricObjectStorageNested(item);
  }
  
  public A withStatefulSetSize(String statefulSetSize) {
    this.statefulSetSize = statefulSetSize;
    return (A) this;
  }
  
  public A withStatefulSetStorageClass(String statefulSetStorageClass) {
    this.statefulSetStorageClass = statefulSetStorageClass;
    return (A) this;
  }
  public class MetricObjectStorageNested<N> extends PreConfiguredStorageFluent<MetricObjectStorageNested<N>> implements Nested<N>{
  
    PreConfiguredStorageBuilder builder;
  
    MetricObjectStorageNested(PreConfiguredStorage item) {
      this.builder = new PreConfiguredStorageBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageConfigObjectFluent.this.withMetricObjectStorage(builder.build());
    }
    
    public N endMetricObjectStorage() {
      return and();
    }
    
  }
}