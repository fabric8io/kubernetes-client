package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
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
public class PoolStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha3.PoolStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer allocatedDevices;
  private Integer availableDevices;
  private String driver;
  private Long generation;
  private String nodeName;
  private ArrayList<PartitionTypeStatusBuilder> partitionSummary = new ArrayList<PartitionTypeStatusBuilder>();
  private String poolName;
  private Integer resourceSliceCount;
  private ShareableSummaryStatusBuilder shareableSummary;
  private Integer totalDevices;
  private Integer unavailableDevices;
  private String validationError;

  public PoolStatusFluent() {
  }
  
  public PoolStatusFluent(PoolStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToPartitionSummary(Collection<PartitionTypeStatus> items) {
    if (this.partitionSummary == null) {
      this.partitionSummary = new ArrayList();
    }
    for (PartitionTypeStatus item : items) {
        PartitionTypeStatusBuilder builder = new PartitionTypeStatusBuilder(item);
        _visitables.get("partitionSummary").add(builder);
        this.partitionSummary.add(builder);
    }
    return (A) this;
  }
  
  public PartitionSummaryNested<A> addNewPartitionSummary() {
    return new PartitionSummaryNested(-1, null);
  }
  
  public A addNewPartitionSummary(Integer allocatable,String attribute,Integer total,String type) {
    return (A) this.addToPartitionSummary(new PartitionTypeStatus(allocatable, attribute, total, type));
  }
  
  public PartitionSummaryNested<A> addNewPartitionSummaryLike(PartitionTypeStatus item) {
    return new PartitionSummaryNested(-1, item);
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
  
  public A addToPartitionSummary(PartitionTypeStatus... items) {
    if (this.partitionSummary == null) {
      this.partitionSummary = new ArrayList();
    }
    for (PartitionTypeStatus item : items) {
        PartitionTypeStatusBuilder builder = new PartitionTypeStatusBuilder(item);
        _visitables.get("partitionSummary").add(builder);
        this.partitionSummary.add(builder);
    }
    return (A) this;
  }
  
  public A addToPartitionSummary(int index,PartitionTypeStatus item) {
    if (this.partitionSummary == null) {
      this.partitionSummary = new ArrayList();
    }
    PartitionTypeStatusBuilder builder = new PartitionTypeStatusBuilder(item);
    if (index < 0 || index >= partitionSummary.size()) {
        _visitables.get("partitionSummary").add(builder);
        partitionSummary.add(builder);
    } else {
        _visitables.get("partitionSummary").add(builder);
        partitionSummary.add(index, builder);
    }
    return (A) this;
  }
  
  public PartitionTypeStatus buildFirstPartitionSummary() {
    return this.partitionSummary.get(0).build();
  }
  
  public PartitionTypeStatus buildLastPartitionSummary() {
    return this.partitionSummary.get(partitionSummary.size() - 1).build();
  }
  
  public PartitionTypeStatus buildMatchingPartitionSummary(Predicate<PartitionTypeStatusBuilder> predicate) {
      for (PartitionTypeStatusBuilder item : partitionSummary) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<PartitionTypeStatus> buildPartitionSummary() {
    return this.partitionSummary != null ? build(partitionSummary) : null;
  }
  
  public PartitionTypeStatus buildPartitionSummary(int index) {
    return this.partitionSummary.get(index).build();
  }
  
  public ShareableSummaryStatus buildShareableSummary() {
    return this.shareableSummary != null ? this.shareableSummary.build() : null;
  }
  
  protected void copyInstance(PoolStatus instance) {
    instance = instance != null ? instance : new PoolStatus();
    if (instance != null) {
        this.withAllocatedDevices(instance.getAllocatedDevices());
        this.withAvailableDevices(instance.getAvailableDevices());
        this.withDriver(instance.getDriver());
        this.withGeneration(instance.getGeneration());
        this.withNodeName(instance.getNodeName());
        this.withPartitionSummary(instance.getPartitionSummary());
        this.withPoolName(instance.getPoolName());
        this.withResourceSliceCount(instance.getResourceSliceCount());
        this.withShareableSummary(instance.getShareableSummary());
        this.withTotalDevices(instance.getTotalDevices());
        this.withUnavailableDevices(instance.getUnavailableDevices());
        this.withValidationError(instance.getValidationError());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PartitionSummaryNested<A> editFirstPartitionSummary() {
    if (partitionSummary.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "partitionSummary"));
    }
    return this.setNewPartitionSummaryLike(0, this.buildPartitionSummary(0));
  }
  
  public PartitionSummaryNested<A> editLastPartitionSummary() {
    int index = partitionSummary.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "partitionSummary"));
    }
    return this.setNewPartitionSummaryLike(index, this.buildPartitionSummary(index));
  }
  
  public PartitionSummaryNested<A> editMatchingPartitionSummary(Predicate<PartitionTypeStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < partitionSummary.size();i++) {
      if (predicate.test(partitionSummary.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "partitionSummary"));
    }
    return this.setNewPartitionSummaryLike(index, this.buildPartitionSummary(index));
  }
  
  public ShareableSummaryNested<A> editOrNewShareableSummary() {
    return this.withNewShareableSummaryLike(Optional.ofNullable(this.buildShareableSummary()).orElse(new ShareableSummaryStatusBuilder().build()));
  }
  
  public ShareableSummaryNested<A> editOrNewShareableSummaryLike(ShareableSummaryStatus item) {
    return this.withNewShareableSummaryLike(Optional.ofNullable(this.buildShareableSummary()).orElse(item));
  }
  
  public PartitionSummaryNested<A> editPartitionSummary(int index) {
    if (partitionSummary.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "partitionSummary"));
    }
    return this.setNewPartitionSummaryLike(index, this.buildPartitionSummary(index));
  }
  
  public ShareableSummaryNested<A> editShareableSummary() {
    return this.withNewShareableSummaryLike(Optional.ofNullable(this.buildShareableSummary()).orElse(null));
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
    PoolStatusFluent that = (PoolStatusFluent) o;
    if (!(Objects.equals(allocatedDevices, that.allocatedDevices))) {
      return false;
    }
    if (!(Objects.equals(availableDevices, that.availableDevices))) {
      return false;
    }
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(generation, that.generation))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(partitionSummary, that.partitionSummary))) {
      return false;
    }
    if (!(Objects.equals(poolName, that.poolName))) {
      return false;
    }
    if (!(Objects.equals(resourceSliceCount, that.resourceSliceCount))) {
      return false;
    }
    if (!(Objects.equals(shareableSummary, that.shareableSummary))) {
      return false;
    }
    if (!(Objects.equals(totalDevices, that.totalDevices))) {
      return false;
    }
    if (!(Objects.equals(unavailableDevices, that.unavailableDevices))) {
      return false;
    }
    if (!(Objects.equals(validationError, that.validationError))) {
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
  
  public Integer getAllocatedDevices() {
    return this.allocatedDevices;
  }
  
  public Integer getAvailableDevices() {
    return this.availableDevices;
  }
  
  public String getDriver() {
    return this.driver;
  }
  
  public Long getGeneration() {
    return this.generation;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public String getPoolName() {
    return this.poolName;
  }
  
  public Integer getResourceSliceCount() {
    return this.resourceSliceCount;
  }
  
  public Integer getTotalDevices() {
    return this.totalDevices;
  }
  
  public Integer getUnavailableDevices() {
    return this.unavailableDevices;
  }
  
  public String getValidationError() {
    return this.validationError;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatedDevices() {
    return this.allocatedDevices != null;
  }
  
  public boolean hasAvailableDevices() {
    return this.availableDevices != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasGeneration() {
    return this.generation != null;
  }
  
  public boolean hasMatchingPartitionSummary(Predicate<PartitionTypeStatusBuilder> predicate) {
      for (PartitionTypeStatusBuilder item : partitionSummary) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasPartitionSummary() {
    return this.partitionSummary != null && !(this.partitionSummary.isEmpty());
  }
  
  public boolean hasPoolName() {
    return this.poolName != null;
  }
  
  public boolean hasResourceSliceCount() {
    return this.resourceSliceCount != null;
  }
  
  public boolean hasShareableSummary() {
    return this.shareableSummary != null;
  }
  
  public boolean hasTotalDevices() {
    return this.totalDevices != null;
  }
  
  public boolean hasUnavailableDevices() {
    return this.unavailableDevices != null;
  }
  
  public boolean hasValidationError() {
    return this.validationError != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocatedDevices, availableDevices, driver, generation, nodeName, partitionSummary, poolName, resourceSliceCount, shareableSummary, totalDevices, unavailableDevices, validationError, additionalProperties);
  }
  
  public A removeAllFromPartitionSummary(Collection<PartitionTypeStatus> items) {
    if (this.partitionSummary == null) {
      return (A) this;
    }
    for (PartitionTypeStatus item : items) {
        PartitionTypeStatusBuilder builder = new PartitionTypeStatusBuilder(item);
        _visitables.get("partitionSummary").remove(builder);
        this.partitionSummary.remove(builder);
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
  
  public A removeFromPartitionSummary(PartitionTypeStatus... items) {
    if (this.partitionSummary == null) {
      return (A) this;
    }
    for (PartitionTypeStatus item : items) {
        PartitionTypeStatusBuilder builder = new PartitionTypeStatusBuilder(item);
        _visitables.get("partitionSummary").remove(builder);
        this.partitionSummary.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPartitionSummary(Predicate<PartitionTypeStatusBuilder> predicate) {
    if (partitionSummary == null) {
      return (A) this;
    }
    Iterator<PartitionTypeStatusBuilder> each = partitionSummary.iterator();
    List visitables = _visitables.get("partitionSummary");
    while (each.hasNext()) {
        PartitionTypeStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PartitionSummaryNested<A> setNewPartitionSummaryLike(int index,PartitionTypeStatus item) {
    return new PartitionSummaryNested(index, item);
  }
  
  public A setToPartitionSummary(int index,PartitionTypeStatus item) {
    if (this.partitionSummary == null) {
      this.partitionSummary = new ArrayList();
    }
    PartitionTypeStatusBuilder builder = new PartitionTypeStatusBuilder(item);
    if (index < 0 || index >= partitionSummary.size()) {
        _visitables.get("partitionSummary").add(builder);
        partitionSummary.add(builder);
    } else {
        _visitables.get("partitionSummary").add(builder);
        partitionSummary.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocatedDevices == null)) {
        sb.append("allocatedDevices:");
        sb.append(allocatedDevices);
        sb.append(",");
    }
    if (!(availableDevices == null)) {
        sb.append("availableDevices:");
        sb.append(availableDevices);
        sb.append(",");
    }
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(generation == null)) {
        sb.append("generation:");
        sb.append(generation);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(partitionSummary == null) && !(partitionSummary.isEmpty())) {
        sb.append("partitionSummary:");
        sb.append(partitionSummary);
        sb.append(",");
    }
    if (!(poolName == null)) {
        sb.append("poolName:");
        sb.append(poolName);
        sb.append(",");
    }
    if (!(resourceSliceCount == null)) {
        sb.append("resourceSliceCount:");
        sb.append(resourceSliceCount);
        sb.append(",");
    }
    if (!(shareableSummary == null)) {
        sb.append("shareableSummary:");
        sb.append(shareableSummary);
        sb.append(",");
    }
    if (!(totalDevices == null)) {
        sb.append("totalDevices:");
        sb.append(totalDevices);
        sb.append(",");
    }
    if (!(unavailableDevices == null)) {
        sb.append("unavailableDevices:");
        sb.append(unavailableDevices);
        sb.append(",");
    }
    if (!(validationError == null)) {
        sb.append("validationError:");
        sb.append(validationError);
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
  
  public A withAllocatedDevices(Integer allocatedDevices) {
    this.allocatedDevices = allocatedDevices;
    return (A) this;
  }
  
  public A withAvailableDevices(Integer availableDevices) {
    this.availableDevices = availableDevices;
    return (A) this;
  }
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public A withGeneration(Long generation) {
    this.generation = generation;
    return (A) this;
  }
  
  public ShareableSummaryNested<A> withNewShareableSummary() {
    return new ShareableSummaryNested(null);
  }
  
  public ShareableSummaryNested<A> withNewShareableSummaryLike(ShareableSummaryStatus item) {
    return new ShareableSummaryNested(item);
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withPartitionSummary(List<PartitionTypeStatus> partitionSummary) {
    if (this.partitionSummary != null) {
      this._visitables.get("partitionSummary").clear();
    }
    if (partitionSummary != null) {
        this.partitionSummary = new ArrayList();
        for (PartitionTypeStatus item : partitionSummary) {
          this.addToPartitionSummary(item);
        }
    } else {
      this.partitionSummary = null;
    }
    return (A) this;
  }
  
  public A withPartitionSummary(PartitionTypeStatus... partitionSummary) {
    if (this.partitionSummary != null) {
        this.partitionSummary.clear();
        _visitables.remove("partitionSummary");
    }
    if (partitionSummary != null) {
      for (PartitionTypeStatus item : partitionSummary) {
        this.addToPartitionSummary(item);
      }
    }
    return (A) this;
  }
  
  public A withPoolName(String poolName) {
    this.poolName = poolName;
    return (A) this;
  }
  
  public A withResourceSliceCount(Integer resourceSliceCount) {
    this.resourceSliceCount = resourceSliceCount;
    return (A) this;
  }
  
  public A withShareableSummary(ShareableSummaryStatus shareableSummary) {
    this._visitables.remove("shareableSummary");
    if (shareableSummary != null) {
        this.shareableSummary = new ShareableSummaryStatusBuilder(shareableSummary);
        this._visitables.get("shareableSummary").add(this.shareableSummary);
    } else {
        this.shareableSummary = null;
        this._visitables.get("shareableSummary").remove(this.shareableSummary);
    }
    return (A) this;
  }
  
  public A withTotalDevices(Integer totalDevices) {
    this.totalDevices = totalDevices;
    return (A) this;
  }
  
  public A withUnavailableDevices(Integer unavailableDevices) {
    this.unavailableDevices = unavailableDevices;
    return (A) this;
  }
  
  public A withValidationError(String validationError) {
    this.validationError = validationError;
    return (A) this;
  }
  public class PartitionSummaryNested<N> extends PartitionTypeStatusFluent<PartitionSummaryNested<N>> implements Nested<N>{
  
    PartitionTypeStatusBuilder builder;
    int index;
  
    PartitionSummaryNested(int index,PartitionTypeStatus item) {
      this.index = index;
      this.builder = new PartitionTypeStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PoolStatusFluent.this.setToPartitionSummary(index, builder.build());
    }
    
    public N endPartitionSummary() {
      return and();
    }
    
  }
  public class ShareableSummaryNested<N> extends ShareableSummaryStatusFluent<ShareableSummaryNested<N>> implements Nested<N>{
  
    ShareableSummaryStatusBuilder builder;
  
    ShareableSummaryNested(ShareableSummaryStatus item) {
      this.builder = new ShareableSummaryStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PoolStatusFluent.this.withShareableSummary(builder.build());
    }
    
    public N endShareableSummary() {
      return and();
    }
    
  }
}