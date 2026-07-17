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
public class SettingSchemaFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.SettingSchemaFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> allowableValues = new ArrayList<String>();
  private String attributeType;
  private Integer lowerBound;
  private Integer maxLength;
  private Integer minLength;
  private Boolean readOnly;
  private Boolean unique;
  private Integer upperBound;

  public SettingSchemaFluent() {
  }
  
  public SettingSchemaFluent(SettingSchema instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowableValues(Collection<String> items) {
    if (this.allowableValues == null) {
      this.allowableValues = new ArrayList();
    }
    for (String item : items) {
      this.allowableValues.add(item);
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
  
  public A addToAllowableValues(String... items) {
    if (this.allowableValues == null) {
      this.allowableValues = new ArrayList();
    }
    for (String item : items) {
      this.allowableValues.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowableValues(int index,String item) {
    if (this.allowableValues == null) {
      this.allowableValues = new ArrayList();
    }
    this.allowableValues.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(SettingSchema instance) {
    instance = instance != null ? instance : new SettingSchema();
    if (instance != null) {
        this.withAllowableValues(instance.getAllowableValues());
        this.withAttributeType(instance.getAttributeType());
        this.withLowerBound(instance.getLowerBound());
        this.withMaxLength(instance.getMaxLength());
        this.withMinLength(instance.getMinLength());
        this.withReadOnly(instance.getReadOnly());
        this.withUnique(instance.getUnique());
        this.withUpperBound(instance.getUpperBound());
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
    SettingSchemaFluent that = (SettingSchemaFluent) o;
    if (!(Objects.equals(allowableValues, that.allowableValues))) {
      return false;
    }
    if (!(Objects.equals(attributeType, that.attributeType))) {
      return false;
    }
    if (!(Objects.equals(lowerBound, that.lowerBound))) {
      return false;
    }
    if (!(Objects.equals(maxLength, that.maxLength))) {
      return false;
    }
    if (!(Objects.equals(minLength, that.minLength))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(unique, that.unique))) {
      return false;
    }
    if (!(Objects.equals(upperBound, that.upperBound))) {
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
  
  public String getAllowableValue(int index) {
    return this.allowableValues.get(index);
  }
  
  public List<String> getAllowableValues() {
    return this.allowableValues;
  }
  
  public String getAttributeType() {
    return this.attributeType;
  }
  
  public String getFirstAllowableValue() {
    return this.allowableValues.get(0);
  }
  
  public String getLastAllowableValue() {
    return this.allowableValues.get(allowableValues.size() - 1);
  }
  
  public Integer getLowerBound() {
    return this.lowerBound;
  }
  
  public String getMatchingAllowableValue(Predicate<String> predicate) {
      for (String item : allowableValues) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMaxLength() {
    return this.maxLength;
  }
  
  public Integer getMinLength() {
    return this.minLength;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public Boolean getUnique() {
    return this.unique;
  }
  
  public Integer getUpperBound() {
    return this.upperBound;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowableValues() {
    return this.allowableValues != null && !(this.allowableValues.isEmpty());
  }
  
  public boolean hasAttributeType() {
    return this.attributeType != null;
  }
  
  public boolean hasLowerBound() {
    return this.lowerBound != null;
  }
  
  public boolean hasMatchingAllowableValue(Predicate<String> predicate) {
      for (String item : allowableValues) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxLength() {
    return this.maxLength != null;
  }
  
  public boolean hasMinLength() {
    return this.minLength != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasUnique() {
    return this.unique != null;
  }
  
  public boolean hasUpperBound() {
    return this.upperBound != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowableValues, attributeType, lowerBound, maxLength, minLength, readOnly, unique, upperBound, additionalProperties);
  }
  
  public A removeAllFromAllowableValues(Collection<String> items) {
    if (this.allowableValues == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowableValues.remove(item);
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
  
  public A removeFromAllowableValues(String... items) {
    if (this.allowableValues == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowableValues.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowableValues(int index,String item) {
    if (this.allowableValues == null) {
      this.allowableValues = new ArrayList();
    }
    this.allowableValues.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowableValues == null) && !(allowableValues.isEmpty())) {
        sb.append("allowableValues:");
        sb.append(allowableValues);
        sb.append(",");
    }
    if (!(attributeType == null)) {
        sb.append("attributeType:");
        sb.append(attributeType);
        sb.append(",");
    }
    if (!(lowerBound == null)) {
        sb.append("lowerBound:");
        sb.append(lowerBound);
        sb.append(",");
    }
    if (!(maxLength == null)) {
        sb.append("maxLength:");
        sb.append(maxLength);
        sb.append(",");
    }
    if (!(minLength == null)) {
        sb.append("minLength:");
        sb.append(minLength);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(unique == null)) {
        sb.append("unique:");
        sb.append(unique);
        sb.append(",");
    }
    if (!(upperBound == null)) {
        sb.append("upperBound:");
        sb.append(upperBound);
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
  
  public A withAllowableValues(List<String> allowableValues) {
    if (allowableValues != null) {
        this.allowableValues = new ArrayList();
        for (String item : allowableValues) {
          this.addToAllowableValues(item);
        }
    } else {
      this.allowableValues = null;
    }
    return (A) this;
  }
  
  public A withAllowableValues(String... allowableValues) {
    if (this.allowableValues != null) {
        this.allowableValues.clear();
        _visitables.remove("allowableValues");
    }
    if (allowableValues != null) {
      for (String item : allowableValues) {
        this.addToAllowableValues(item);
      }
    }
    return (A) this;
  }
  
  public A withAttributeType(String attributeType) {
    this.attributeType = attributeType;
    return (A) this;
  }
  
  public A withLowerBound(Integer lowerBound) {
    this.lowerBound = lowerBound;
    return (A) this;
  }
  
  public A withMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
    return (A) this;
  }
  
  public A withMinLength(Integer minLength) {
    this.minLength = minLength;
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withUnique() {
    return withUnique(true);
  }
  
  public A withUnique(Boolean unique) {
    this.unique = unique;
    return (A) this;
  }
  
  public A withUpperBound(Integer upperBound) {
    this.upperBound = upperBound;
    return (A) this;
  }
  
}