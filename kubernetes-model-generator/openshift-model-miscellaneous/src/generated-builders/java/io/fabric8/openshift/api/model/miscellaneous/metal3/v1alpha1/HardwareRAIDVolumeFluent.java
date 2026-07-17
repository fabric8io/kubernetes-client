package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HardwareRAIDVolumeFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HardwareRAIDVolumeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String controller;
  private String level;
  private String name;
  private Integer numberOfPhysicalDisks;
  private List<String> physicalDisks = new ArrayList<String>();
  private Boolean rotational;
  private Integer sizeGibibytes;

  public HardwareRAIDVolumeFluent() {
  }
  
  public HardwareRAIDVolumeFluent(HardwareRAIDVolume instance) {
    this.copyInstance(instance);
  }

  public A addAllToPhysicalDisks(Collection<String> items) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    for (String item : items) {
      this.physicalDisks.add(item);
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
  
  public A addToPhysicalDisks(String... items) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    for (String item : items) {
      this.physicalDisks.add(item);
    }
    return (A) this;
  }
  
  public A addToPhysicalDisks(int index,String item) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    this.physicalDisks.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(HardwareRAIDVolume instance) {
    instance = instance != null ? instance : new HardwareRAIDVolume();
    if (instance != null) {
        this.withController(instance.getController());
        this.withLevel(instance.getLevel());
        this.withName(instance.getName());
        this.withNumberOfPhysicalDisks(instance.getNumberOfPhysicalDisks());
        this.withPhysicalDisks(instance.getPhysicalDisks());
        this.withRotational(instance.getRotational());
        this.withSizeGibibytes(instance.getSizeGibibytes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    HardwareRAIDVolumeFluent that = (HardwareRAIDVolumeFluent) o;
    if (!(Objects.equals(controller, that.controller))) {
      return false;
    }
    if (!(Objects.equals(level, that.level))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(numberOfPhysicalDisks, that.numberOfPhysicalDisks))) {
      return false;
    }
    if (!(Objects.equals(physicalDisks, that.physicalDisks))) {
      return false;
    }
    if (!(Objects.equals(rotational, that.rotational))) {
      return false;
    }
    if (!(Objects.equals(sizeGibibytes, that.sizeGibibytes))) {
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
  
  public String getController() {
    return this.controller;
  }
  
  public String getFirstPhysicalDisk() {
    return this.physicalDisks.get(0);
  }
  
  public String getLastPhysicalDisk() {
    return this.physicalDisks.get(physicalDisks.size() - 1);
  }
  
  public String getLevel() {
    return this.level;
  }
  
  public String getMatchingPhysicalDisk(Predicate<String> predicate) {
      for (String item : physicalDisks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getNumberOfPhysicalDisks() {
    return this.numberOfPhysicalDisks;
  }
  
  public String getPhysicalDisk(int index) {
    return this.physicalDisks.get(index);
  }
  
  public List<String> getPhysicalDisks() {
    return this.physicalDisks;
  }
  
  public Boolean getRotational() {
    return this.rotational;
  }
  
  public Integer getSizeGibibytes() {
    return this.sizeGibibytes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasController() {
    return this.controller != null;
  }
  
  public boolean hasLevel() {
    return this.level != null;
  }
  
  public boolean hasMatchingPhysicalDisk(Predicate<String> predicate) {
      for (String item : physicalDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNumberOfPhysicalDisks() {
    return this.numberOfPhysicalDisks != null;
  }
  
  public boolean hasPhysicalDisks() {
    return this.physicalDisks != null && !(this.physicalDisks.isEmpty());
  }
  
  public boolean hasRotational() {
    return this.rotational != null;
  }
  
  public boolean hasSizeGibibytes() {
    return this.sizeGibibytes != null;
  }
  
  public int hashCode() {
    return Objects.hash(controller, level, name, numberOfPhysicalDisks, physicalDisks, rotational, sizeGibibytes, additionalProperties);
  }
  
  public A removeAllFromPhysicalDisks(Collection<String> items) {
    if (this.physicalDisks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.physicalDisks.remove(item);
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
  
  public A removeFromPhysicalDisks(String... items) {
    if (this.physicalDisks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.physicalDisks.remove(item);
    }
    return (A) this;
  }
  
  public A setToPhysicalDisks(int index,String item) {
    if (this.physicalDisks == null) {
      this.physicalDisks = new ArrayList();
    }
    this.physicalDisks.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(controller == null)) {
        sb.append("controller:");
        sb.append(controller);
        sb.append(",");
    }
    if (!(level == null)) {
        sb.append("level:");
        sb.append(level);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(numberOfPhysicalDisks == null)) {
        sb.append("numberOfPhysicalDisks:");
        sb.append(numberOfPhysicalDisks);
        sb.append(",");
    }
    if (!(physicalDisks == null) && !(physicalDisks.isEmpty())) {
        sb.append("physicalDisks:");
        sb.append(physicalDisks);
        sb.append(",");
    }
    if (!(rotational == null)) {
        sb.append("rotational:");
        sb.append(rotational);
        sb.append(",");
    }
    if (!(sizeGibibytes == null)) {
        sb.append("sizeGibibytes:");
        sb.append(sizeGibibytes);
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
  
  public A withController(String controller) {
    this.controller = controller;
    return (A) this;
  }
  
  public A withLevel(String level) {
    this.level = level;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNumberOfPhysicalDisks(Integer numberOfPhysicalDisks) {
    this.numberOfPhysicalDisks = numberOfPhysicalDisks;
    return (A) this;
  }
  
  public A withPhysicalDisks(List<String> physicalDisks) {
    if (physicalDisks != null) {
        this.physicalDisks = new ArrayList();
        for (String item : physicalDisks) {
          this.addToPhysicalDisks(item);
        }
    } else {
      this.physicalDisks = null;
    }
    return (A) this;
  }
  
  public A withPhysicalDisks(String... physicalDisks) {
    if (this.physicalDisks != null) {
        this.physicalDisks.clear();
        _visitables.remove("physicalDisks");
    }
    if (physicalDisks != null) {
      for (String item : physicalDisks) {
        this.addToPhysicalDisks(item);
      }
    }
    return (A) this;
  }
  
  public A withRotational() {
    return withRotational(true);
  }
  
  public A withRotational(Boolean rotational) {
    this.rotational = rotational;
    return (A) this;
  }
  
  public A withSizeGibibytes(Integer sizeGibibytes) {
    this.sizeGibibytes = sizeGibibytes;
    return (A) this;
  }
  
}