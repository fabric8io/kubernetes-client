package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ExperimentStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.ExperimentStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RecordBuilder> containerRecords = new ArrayList<RecordBuilder>();
  private String desiredPhase;

  public ExperimentStatusFluent() {
  }
  
  public ExperimentStatusFluent(ExperimentStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainerRecords(Collection<Record> items) {
    if (this.containerRecords == null) {
      this.containerRecords = new ArrayList();
    }
    for (Record item : items) {
        RecordBuilder builder = new RecordBuilder(item);
        _visitables.get("containerRecords").add(builder);
        this.containerRecords.add(builder);
    }
    return (A) this;
  }
  
  public ContainerRecordsNested<A> addNewContainerRecord() {
    return new ContainerRecordsNested(-1, null);
  }
  
  public ContainerRecordsNested<A> addNewContainerRecordLike(Record item) {
    return new ContainerRecordsNested(-1, item);
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
  
  public A addToContainerRecords(Record... items) {
    if (this.containerRecords == null) {
      this.containerRecords = new ArrayList();
    }
    for (Record item : items) {
        RecordBuilder builder = new RecordBuilder(item);
        _visitables.get("containerRecords").add(builder);
        this.containerRecords.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainerRecords(int index,Record item) {
    if (this.containerRecords == null) {
      this.containerRecords = new ArrayList();
    }
    RecordBuilder builder = new RecordBuilder(item);
    if (index < 0 || index >= containerRecords.size()) {
        _visitables.get("containerRecords").add(builder);
        containerRecords.add(builder);
    } else {
        _visitables.get("containerRecords").add(builder);
        containerRecords.add(index, builder);
    }
    return (A) this;
  }
  
  public Record buildContainerRecord(int index) {
    return this.containerRecords.get(index).build();
  }
  
  public List<Record> buildContainerRecords() {
    return this.containerRecords != null ? build(containerRecords) : null;
  }
  
  public Record buildFirstContainerRecord() {
    return this.containerRecords.get(0).build();
  }
  
  public Record buildLastContainerRecord() {
    return this.containerRecords.get(containerRecords.size() - 1).build();
  }
  
  public Record buildMatchingContainerRecord(Predicate<RecordBuilder> predicate) {
      for (RecordBuilder item : containerRecords) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ExperimentStatus instance) {
    instance = instance != null ? instance : new ExperimentStatus();
    if (instance != null) {
        this.withContainerRecords(instance.getContainerRecords());
        this.withDesiredPhase(instance.getDesiredPhase());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerRecordsNested<A> editContainerRecord(int index) {
    if (containerRecords.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containerRecords"));
    }
    return this.setNewContainerRecordLike(index, this.buildContainerRecord(index));
  }
  
  public ContainerRecordsNested<A> editFirstContainerRecord() {
    if (containerRecords.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containerRecords"));
    }
    return this.setNewContainerRecordLike(0, this.buildContainerRecord(0));
  }
  
  public ContainerRecordsNested<A> editLastContainerRecord() {
    int index = containerRecords.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containerRecords"));
    }
    return this.setNewContainerRecordLike(index, this.buildContainerRecord(index));
  }
  
  public ContainerRecordsNested<A> editMatchingContainerRecord(Predicate<RecordBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containerRecords.size();i++) {
      if (predicate.test(containerRecords.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containerRecords"));
    }
    return this.setNewContainerRecordLike(index, this.buildContainerRecord(index));
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
    ExperimentStatusFluent that = (ExperimentStatusFluent) o;
    if (!(Objects.equals(containerRecords, that.containerRecords))) {
      return false;
    }
    if (!(Objects.equals(desiredPhase, that.desiredPhase))) {
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
  
  public String getDesiredPhase() {
    return this.desiredPhase;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerRecords() {
    return this.containerRecords != null && !(this.containerRecords.isEmpty());
  }
  
  public boolean hasDesiredPhase() {
    return this.desiredPhase != null;
  }
  
  public boolean hasMatchingContainerRecord(Predicate<RecordBuilder> predicate) {
      for (RecordBuilder item : containerRecords) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(containerRecords, desiredPhase, additionalProperties);
  }
  
  public A removeAllFromContainerRecords(Collection<Record> items) {
    if (this.containerRecords == null) {
      return (A) this;
    }
    for (Record item : items) {
        RecordBuilder builder = new RecordBuilder(item);
        _visitables.get("containerRecords").remove(builder);
        this.containerRecords.remove(builder);
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
  
  public A removeFromContainerRecords(Record... items) {
    if (this.containerRecords == null) {
      return (A) this;
    }
    for (Record item : items) {
        RecordBuilder builder = new RecordBuilder(item);
        _visitables.get("containerRecords").remove(builder);
        this.containerRecords.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainerRecords(Predicate<RecordBuilder> predicate) {
    if (containerRecords == null) {
      return (A) this;
    }
    Iterator<RecordBuilder> each = containerRecords.iterator();
    List visitables = _visitables.get("containerRecords");
    while (each.hasNext()) {
        RecordBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContainerRecordsNested<A> setNewContainerRecordLike(int index,Record item) {
    return new ContainerRecordsNested(index, item);
  }
  
  public A setToContainerRecords(int index,Record item) {
    if (this.containerRecords == null) {
      this.containerRecords = new ArrayList();
    }
    RecordBuilder builder = new RecordBuilder(item);
    if (index < 0 || index >= containerRecords.size()) {
        _visitables.get("containerRecords").add(builder);
        containerRecords.add(builder);
    } else {
        _visitables.get("containerRecords").add(builder);
        containerRecords.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerRecords == null) && !(containerRecords.isEmpty())) {
        sb.append("containerRecords:");
        sb.append(containerRecords);
        sb.append(",");
    }
    if (!(desiredPhase == null)) {
        sb.append("desiredPhase:");
        sb.append(desiredPhase);
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
  
  public A withContainerRecords(List<Record> containerRecords) {
    if (this.containerRecords != null) {
      this._visitables.get("containerRecords").clear();
    }
    if (containerRecords != null) {
        this.containerRecords = new ArrayList();
        for (Record item : containerRecords) {
          this.addToContainerRecords(item);
        }
    } else {
      this.containerRecords = null;
    }
    return (A) this;
  }
  
  public A withContainerRecords(Record... containerRecords) {
    if (this.containerRecords != null) {
        this.containerRecords.clear();
        _visitables.remove("containerRecords");
    }
    if (containerRecords != null) {
      for (Record item : containerRecords) {
        this.addToContainerRecords(item);
      }
    }
    return (A) this;
  }
  
  public A withDesiredPhase(String desiredPhase) {
    this.desiredPhase = desiredPhase;
    return (A) this;
  }
  public class ContainerRecordsNested<N> extends RecordFluent<ContainerRecordsNested<N>> implements Nested<N>{
  
    RecordBuilder builder;
    int index;
  
    ContainerRecordsNested(int index,Record item) {
      this.index = index;
      this.builder = new RecordBuilder(this, item);
    }
  
    public N and() {
      return (N) ExperimentStatusFluent.this.setToContainerRecords(index, builder.build());
    }
    
    public N endContainerRecord() {
      return and();
    }
    
  }
}