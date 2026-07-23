package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class StorageFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.StorageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> alternateNames = new ArrayList<String>();
  private String hctl;
  private String model;
  private String name;
  private Boolean rotational;
  private String serialNumber;
  private Long sizeBytes;
  private String type;
  private String vendor;
  private String wwn;
  private String wwnVendorExtension;
  private String wwnWithExtension;

  public StorageFluent() {
  }
  
  public StorageFluent(Storage instance) {
    this.copyInstance(instance);
  }

  public A addAllToAlternateNames(Collection<String> items) {
    if (this.alternateNames == null) {
      this.alternateNames = new ArrayList();
    }
    for (String item : items) {
      this.alternateNames.add(item);
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
  
  public A addToAlternateNames(String... items) {
    if (this.alternateNames == null) {
      this.alternateNames = new ArrayList();
    }
    for (String item : items) {
      this.alternateNames.add(item);
    }
    return (A) this;
  }
  
  public A addToAlternateNames(int index,String item) {
    if (this.alternateNames == null) {
      this.alternateNames = new ArrayList();
    }
    this.alternateNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Storage instance) {
    instance = instance != null ? instance : new Storage();
    if (instance != null) {
        this.withAlternateNames(instance.getAlternateNames());
        this.withHctl(instance.getHctl());
        this.withModel(instance.getModel());
        this.withName(instance.getName());
        this.withRotational(instance.getRotational());
        this.withSerialNumber(instance.getSerialNumber());
        this.withSizeBytes(instance.getSizeBytes());
        this.withType(instance.getType());
        this.withVendor(instance.getVendor());
        this.withWwn(instance.getWwn());
        this.withWwnVendorExtension(instance.getWwnVendorExtension());
        this.withWwnWithExtension(instance.getWwnWithExtension());
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
    StorageFluent that = (StorageFluent) o;
    if (!(Objects.equals(alternateNames, that.alternateNames))) {
      return false;
    }
    if (!(Objects.equals(hctl, that.hctl))) {
      return false;
    }
    if (!(Objects.equals(model, that.model))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(rotational, that.rotational))) {
      return false;
    }
    if (!(Objects.equals(serialNumber, that.serialNumber))) {
      return false;
    }
    if (!(Objects.equals(sizeBytes, that.sizeBytes))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(vendor, that.vendor))) {
      return false;
    }
    if (!(Objects.equals(wwn, that.wwn))) {
      return false;
    }
    if (!(Objects.equals(wwnVendorExtension, that.wwnVendorExtension))) {
      return false;
    }
    if (!(Objects.equals(wwnWithExtension, that.wwnWithExtension))) {
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
  
  public String getAlternateName(int index) {
    return this.alternateNames.get(index);
  }
  
  public List<String> getAlternateNames() {
    return this.alternateNames;
  }
  
  public String getFirstAlternateName() {
    return this.alternateNames.get(0);
  }
  
  public String getHctl() {
    return this.hctl;
  }
  
  public String getLastAlternateName() {
    return this.alternateNames.get(alternateNames.size() - 1);
  }
  
  public String getMatchingAlternateName(Predicate<String> predicate) {
      for (String item : alternateNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getRotational() {
    return this.rotational;
  }
  
  public String getSerialNumber() {
    return this.serialNumber;
  }
  
  public Long getSizeBytes() {
    return this.sizeBytes;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getVendor() {
    return this.vendor;
  }
  
  public String getWwn() {
    return this.wwn;
  }
  
  public String getWwnVendorExtension() {
    return this.wwnVendorExtension;
  }
  
  public String getWwnWithExtension() {
    return this.wwnWithExtension;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlternateNames() {
    return this.alternateNames != null && !(this.alternateNames.isEmpty());
  }
  
  public boolean hasHctl() {
    return this.hctl != null;
  }
  
  public boolean hasMatchingAlternateName(Predicate<String> predicate) {
      for (String item : alternateNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasModel() {
    return this.model != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRotational() {
    return this.rotational != null;
  }
  
  public boolean hasSerialNumber() {
    return this.serialNumber != null;
  }
  
  public boolean hasSizeBytes() {
    return this.sizeBytes != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasVendor() {
    return this.vendor != null;
  }
  
  public boolean hasWwn() {
    return this.wwn != null;
  }
  
  public boolean hasWwnVendorExtension() {
    return this.wwnVendorExtension != null;
  }
  
  public boolean hasWwnWithExtension() {
    return this.wwnWithExtension != null;
  }
  
  public int hashCode() {
    return Objects.hash(alternateNames, hctl, model, name, rotational, serialNumber, sizeBytes, type, vendor, wwn, wwnVendorExtension, wwnWithExtension, additionalProperties);
  }
  
  public A removeAllFromAlternateNames(Collection<String> items) {
    if (this.alternateNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.alternateNames.remove(item);
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
  
  public A removeFromAlternateNames(String... items) {
    if (this.alternateNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.alternateNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToAlternateNames(int index,String item) {
    if (this.alternateNames == null) {
      this.alternateNames = new ArrayList();
    }
    this.alternateNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alternateNames == null) && !(alternateNames.isEmpty())) {
        sb.append("alternateNames:");
        sb.append(alternateNames);
        sb.append(",");
    }
    if (!(hctl == null)) {
        sb.append("hctl:");
        sb.append(hctl);
        sb.append(",");
    }
    if (!(model == null)) {
        sb.append("model:");
        sb.append(model);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(rotational == null)) {
        sb.append("rotational:");
        sb.append(rotational);
        sb.append(",");
    }
    if (!(serialNumber == null)) {
        sb.append("serialNumber:");
        sb.append(serialNumber);
        sb.append(",");
    }
    if (!(sizeBytes == null)) {
        sb.append("sizeBytes:");
        sb.append(sizeBytes);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(vendor == null)) {
        sb.append("vendor:");
        sb.append(vendor);
        sb.append(",");
    }
    if (!(wwn == null)) {
        sb.append("wwn:");
        sb.append(wwn);
        sb.append(",");
    }
    if (!(wwnVendorExtension == null)) {
        sb.append("wwnVendorExtension:");
        sb.append(wwnVendorExtension);
        sb.append(",");
    }
    if (!(wwnWithExtension == null)) {
        sb.append("wwnWithExtension:");
        sb.append(wwnWithExtension);
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
  
  public A withAlternateNames(List<String> alternateNames) {
    if (alternateNames != null) {
        this.alternateNames = new ArrayList();
        for (String item : alternateNames) {
          this.addToAlternateNames(item);
        }
    } else {
      this.alternateNames = null;
    }
    return (A) this;
  }
  
  public A withAlternateNames(String... alternateNames) {
    if (this.alternateNames != null) {
        this.alternateNames.clear();
        _visitables.remove("alternateNames");
    }
    if (alternateNames != null) {
      for (String item : alternateNames) {
        this.addToAlternateNames(item);
      }
    }
    return (A) this;
  }
  
  public A withHctl(String hctl) {
    this.hctl = hctl;
    return (A) this;
  }
  
  public A withModel(String model) {
    this.model = model;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withRotational() {
    return withRotational(true);
  }
  
  public A withRotational(Boolean rotational) {
    this.rotational = rotational;
    return (A) this;
  }
  
  public A withSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return (A) this;
  }
  
  public A withSizeBytes(Long sizeBytes) {
    this.sizeBytes = sizeBytes;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withVendor(String vendor) {
    this.vendor = vendor;
    return (A) this;
  }
  
  public A withWwn(String wwn) {
    this.wwn = wwn;
    return (A) this;
  }
  
  public A withWwnVendorExtension(String wwnVendorExtension) {
    this.wwnVendorExtension = wwnVendorExtension;
    return (A) this;
  }
  
  public A withWwnWithExtension(String wwnWithExtension) {
    this.wwnWithExtension = wwnWithExtension;
    return (A) this;
  }
  
}