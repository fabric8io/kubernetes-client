package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorage;
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorageBuilder;
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorageFluent;
import java.lang.Boolean;
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
public class StorageConfigFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.StorageConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String alertmanagerStorageSize;
  private String compactStorageSize;
  private PreConfiguredStorageBuilder metricObjectStorage;
  private String receiveStorageSize;
  private String ruleStorageSize;
  private String storageClass;
  private String storeStorageSize;
  private ArrayList<PreConfiguredStorageBuilder> writeStorage = new ArrayList<PreConfiguredStorageBuilder>();

  public StorageConfigFluent() {
  }
  
  public StorageConfigFluent(StorageConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToWriteStorage(Collection<PreConfiguredStorage> items) {
    if (this.writeStorage == null) {
      this.writeStorage = new ArrayList();
    }
    for (PreConfiguredStorage item : items) {
        PreConfiguredStorageBuilder builder = new PreConfiguredStorageBuilder(item);
        _visitables.get("writeStorage").add(builder);
        this.writeStorage.add(builder);
    }
    return (A) this;
  }
  
  public WriteStorageNested<A> addNewWriteStorage() {
    return new WriteStorageNested(-1, null);
  }
  
  public A addNewWriteStorage(String key,String name,Boolean serviceAccountProjection,String tlsSecretMountPath,String tlsSecretName) {
    return (A) this.addToWriteStorage(new PreConfiguredStorage(key, name, serviceAccountProjection, tlsSecretMountPath, tlsSecretName));
  }
  
  public WriteStorageNested<A> addNewWriteStorageLike(PreConfiguredStorage item) {
    return new WriteStorageNested(-1, item);
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
  
  public A addToWriteStorage(PreConfiguredStorage... items) {
    if (this.writeStorage == null) {
      this.writeStorage = new ArrayList();
    }
    for (PreConfiguredStorage item : items) {
        PreConfiguredStorageBuilder builder = new PreConfiguredStorageBuilder(item);
        _visitables.get("writeStorage").add(builder);
        this.writeStorage.add(builder);
    }
    return (A) this;
  }
  
  public A addToWriteStorage(int index,PreConfiguredStorage item) {
    if (this.writeStorage == null) {
      this.writeStorage = new ArrayList();
    }
    PreConfiguredStorageBuilder builder = new PreConfiguredStorageBuilder(item);
    if (index < 0 || index >= writeStorage.size()) {
        _visitables.get("writeStorage").add(builder);
        writeStorage.add(builder);
    } else {
        _visitables.get("writeStorage").add(builder);
        writeStorage.add(index, builder);
    }
    return (A) this;
  }
  
  public PreConfiguredStorage buildFirstWriteStorage() {
    return this.writeStorage.get(0).build();
  }
  
  public PreConfiguredStorage buildLastWriteStorage() {
    return this.writeStorage.get(writeStorage.size() - 1).build();
  }
  
  public PreConfiguredStorage buildMatchingWriteStorage(Predicate<PreConfiguredStorageBuilder> predicate) {
      for (PreConfiguredStorageBuilder item : writeStorage) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PreConfiguredStorage buildMetricObjectStorage() {
    return this.metricObjectStorage != null ? this.metricObjectStorage.build() : null;
  }
  
  public List<PreConfiguredStorage> buildWriteStorage() {
    return this.writeStorage != null ? build(writeStorage) : null;
  }
  
  public PreConfiguredStorage buildWriteStorage(int index) {
    return this.writeStorage.get(index).build();
  }
  
  protected void copyInstance(StorageConfig instance) {
    instance = instance != null ? instance : new StorageConfig();
    if (instance != null) {
        this.withAlertmanagerStorageSize(instance.getAlertmanagerStorageSize());
        this.withCompactStorageSize(instance.getCompactStorageSize());
        this.withMetricObjectStorage(instance.getMetricObjectStorage());
        this.withReceiveStorageSize(instance.getReceiveStorageSize());
        this.withRuleStorageSize(instance.getRuleStorageSize());
        this.withStorageClass(instance.getStorageClass());
        this.withStoreStorageSize(instance.getStoreStorageSize());
        this.withWriteStorage(instance.getWriteStorage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WriteStorageNested<A> editFirstWriteStorage() {
    if (writeStorage.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "writeStorage"));
    }
    return this.setNewWriteStorageLike(0, this.buildWriteStorage(0));
  }
  
  public WriteStorageNested<A> editLastWriteStorage() {
    int index = writeStorage.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "writeStorage"));
    }
    return this.setNewWriteStorageLike(index, this.buildWriteStorage(index));
  }
  
  public WriteStorageNested<A> editMatchingWriteStorage(Predicate<PreConfiguredStorageBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < writeStorage.size();i++) {
      if (predicate.test(writeStorage.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "writeStorage"));
    }
    return this.setNewWriteStorageLike(index, this.buildWriteStorage(index));
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
  
  public WriteStorageNested<A> editWriteStorage(int index) {
    if (writeStorage.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "writeStorage"));
    }
    return this.setNewWriteStorageLike(index, this.buildWriteStorage(index));
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
    StorageConfigFluent that = (StorageConfigFluent) o;
    if (!(Objects.equals(alertmanagerStorageSize, that.alertmanagerStorageSize))) {
      return false;
    }
    if (!(Objects.equals(compactStorageSize, that.compactStorageSize))) {
      return false;
    }
    if (!(Objects.equals(metricObjectStorage, that.metricObjectStorage))) {
      return false;
    }
    if (!(Objects.equals(receiveStorageSize, that.receiveStorageSize))) {
      return false;
    }
    if (!(Objects.equals(ruleStorageSize, that.ruleStorageSize))) {
      return false;
    }
    if (!(Objects.equals(storageClass, that.storageClass))) {
      return false;
    }
    if (!(Objects.equals(storeStorageSize, that.storeStorageSize))) {
      return false;
    }
    if (!(Objects.equals(writeStorage, that.writeStorage))) {
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
  
  public String getAlertmanagerStorageSize() {
    return this.alertmanagerStorageSize;
  }
  
  public String getCompactStorageSize() {
    return this.compactStorageSize;
  }
  
  public String getReceiveStorageSize() {
    return this.receiveStorageSize;
  }
  
  public String getRuleStorageSize() {
    return this.ruleStorageSize;
  }
  
  public String getStorageClass() {
    return this.storageClass;
  }
  
  public String getStoreStorageSize() {
    return this.storeStorageSize;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlertmanagerStorageSize() {
    return this.alertmanagerStorageSize != null;
  }
  
  public boolean hasCompactStorageSize() {
    return this.compactStorageSize != null;
  }
  
  public boolean hasMatchingWriteStorage(Predicate<PreConfiguredStorageBuilder> predicate) {
      for (PreConfiguredStorageBuilder item : writeStorage) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetricObjectStorage() {
    return this.metricObjectStorage != null;
  }
  
  public boolean hasReceiveStorageSize() {
    return this.receiveStorageSize != null;
  }
  
  public boolean hasRuleStorageSize() {
    return this.ruleStorageSize != null;
  }
  
  public boolean hasStorageClass() {
    return this.storageClass != null;
  }
  
  public boolean hasStoreStorageSize() {
    return this.storeStorageSize != null;
  }
  
  public boolean hasWriteStorage() {
    return this.writeStorage != null && !(this.writeStorage.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(alertmanagerStorageSize, compactStorageSize, metricObjectStorage, receiveStorageSize, ruleStorageSize, storageClass, storeStorageSize, writeStorage, additionalProperties);
  }
  
  public A removeAllFromWriteStorage(Collection<PreConfiguredStorage> items) {
    if (this.writeStorage == null) {
      return (A) this;
    }
    for (PreConfiguredStorage item : items) {
        PreConfiguredStorageBuilder builder = new PreConfiguredStorageBuilder(item);
        _visitables.get("writeStorage").remove(builder);
        this.writeStorage.remove(builder);
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
  
  public A removeFromWriteStorage(PreConfiguredStorage... items) {
    if (this.writeStorage == null) {
      return (A) this;
    }
    for (PreConfiguredStorage item : items) {
        PreConfiguredStorageBuilder builder = new PreConfiguredStorageBuilder(item);
        _visitables.get("writeStorage").remove(builder);
        this.writeStorage.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromWriteStorage(Predicate<PreConfiguredStorageBuilder> predicate) {
    if (writeStorage == null) {
      return (A) this;
    }
    Iterator<PreConfiguredStorageBuilder> each = writeStorage.iterator();
    List visitables = _visitables.get("writeStorage");
    while (each.hasNext()) {
        PreConfiguredStorageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public WriteStorageNested<A> setNewWriteStorageLike(int index,PreConfiguredStorage item) {
    return new WriteStorageNested(index, item);
  }
  
  public A setToWriteStorage(int index,PreConfiguredStorage item) {
    if (this.writeStorage == null) {
      this.writeStorage = new ArrayList();
    }
    PreConfiguredStorageBuilder builder = new PreConfiguredStorageBuilder(item);
    if (index < 0 || index >= writeStorage.size()) {
        _visitables.get("writeStorage").add(builder);
        writeStorage.add(builder);
    } else {
        _visitables.get("writeStorage").add(builder);
        writeStorage.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alertmanagerStorageSize == null)) {
        sb.append("alertmanagerStorageSize:");
        sb.append(alertmanagerStorageSize);
        sb.append(",");
    }
    if (!(compactStorageSize == null)) {
        sb.append("compactStorageSize:");
        sb.append(compactStorageSize);
        sb.append(",");
    }
    if (!(metricObjectStorage == null)) {
        sb.append("metricObjectStorage:");
        sb.append(metricObjectStorage);
        sb.append(",");
    }
    if (!(receiveStorageSize == null)) {
        sb.append("receiveStorageSize:");
        sb.append(receiveStorageSize);
        sb.append(",");
    }
    if (!(ruleStorageSize == null)) {
        sb.append("ruleStorageSize:");
        sb.append(ruleStorageSize);
        sb.append(",");
    }
    if (!(storageClass == null)) {
        sb.append("storageClass:");
        sb.append(storageClass);
        sb.append(",");
    }
    if (!(storeStorageSize == null)) {
        sb.append("storeStorageSize:");
        sb.append(storeStorageSize);
        sb.append(",");
    }
    if (!(writeStorage == null) && !(writeStorage.isEmpty())) {
        sb.append("writeStorage:");
        sb.append(writeStorage);
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
  
  public A withAlertmanagerStorageSize(String alertmanagerStorageSize) {
    this.alertmanagerStorageSize = alertmanagerStorageSize;
    return (A) this;
  }
  
  public A withCompactStorageSize(String compactStorageSize) {
    this.compactStorageSize = compactStorageSize;
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
  
  public A withReceiveStorageSize(String receiveStorageSize) {
    this.receiveStorageSize = receiveStorageSize;
    return (A) this;
  }
  
  public A withRuleStorageSize(String ruleStorageSize) {
    this.ruleStorageSize = ruleStorageSize;
    return (A) this;
  }
  
  public A withStorageClass(String storageClass) {
    this.storageClass = storageClass;
    return (A) this;
  }
  
  public A withStoreStorageSize(String storeStorageSize) {
    this.storeStorageSize = storeStorageSize;
    return (A) this;
  }
  
  public A withWriteStorage(List<PreConfiguredStorage> writeStorage) {
    if (this.writeStorage != null) {
      this._visitables.get("writeStorage").clear();
    }
    if (writeStorage != null) {
        this.writeStorage = new ArrayList();
        for (PreConfiguredStorage item : writeStorage) {
          this.addToWriteStorage(item);
        }
    } else {
      this.writeStorage = null;
    }
    return (A) this;
  }
  
  public A withWriteStorage(PreConfiguredStorage... writeStorage) {
    if (this.writeStorage != null) {
        this.writeStorage.clear();
        _visitables.remove("writeStorage");
    }
    if (writeStorage != null) {
      for (PreConfiguredStorage item : writeStorage) {
        this.addToWriteStorage(item);
      }
    }
    return (A) this;
  }
  public class MetricObjectStorageNested<N> extends PreConfiguredStorageFluent<MetricObjectStorageNested<N>> implements Nested<N>{
  
    PreConfiguredStorageBuilder builder;
  
    MetricObjectStorageNested(PreConfiguredStorage item) {
      this.builder = new PreConfiguredStorageBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageConfigFluent.this.withMetricObjectStorage(builder.build());
    }
    
    public N endMetricObjectStorage() {
      return and();
    }
    
  }
  public class WriteStorageNested<N> extends PreConfiguredStorageFluent<WriteStorageNested<N>> implements Nested<N>{
  
    PreConfiguredStorageBuilder builder;
    int index;
  
    WriteStorageNested(int index,PreConfiguredStorage item) {
      this.index = index;
      this.builder = new PreConfiguredStorageBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageConfigFluent.this.setToWriteStorage(index, builder.build());
    }
    
    public N endWriteStorage() {
      return and();
    }
    
  }
}