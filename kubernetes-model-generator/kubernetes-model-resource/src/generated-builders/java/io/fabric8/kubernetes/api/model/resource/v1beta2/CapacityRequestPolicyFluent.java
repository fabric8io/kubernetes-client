package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class CapacityRequestPolicyFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta2.CapacityRequestPolicyFluent<A>> extends BaseFluent<A>{

  private Quantity _default;
  private Map<String,Object> additionalProperties;
  private CapacityRequestPolicyRangeBuilder validRange;
  private List<Quantity> validValues = new ArrayList<Quantity>();

  public CapacityRequestPolicyFluent() {
  }
  
  public CapacityRequestPolicyFluent(CapacityRequestPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToValidValues(Collection<Quantity> items) {
    if (this.validValues == null) {
      this.validValues = new ArrayList();
    }
    for (Quantity item : items) {
      this.validValues.add(item);
    }
    return (A) this;
  }
  
  public A addNewValidValue(String amount) {
    return (A) this.addToValidValues(new Quantity(amount));
  }
  
  public A addNewValidValue(String amount,String format) {
    return (A) this.addToValidValues(new Quantity(amount, format));
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
  
  public A addToValidValues(Quantity... items) {
    if (this.validValues == null) {
      this.validValues = new ArrayList();
    }
    for (Quantity item : items) {
      this.validValues.add(item);
    }
    return (A) this;
  }
  
  public A addToValidValues(int index,Quantity item) {
    if (this.validValues == null) {
      this.validValues = new ArrayList();
    }
    this.validValues.add(index, item);
    return (A) this;
  }
  
  public CapacityRequestPolicyRange buildValidRange() {
    return this.validRange != null ? this.validRange.build() : null;
  }
  
  protected void copyInstance(CapacityRequestPolicy instance) {
    instance = instance != null ? instance : new CapacityRequestPolicy();
    if (instance != null) {
        this.withDefault(instance.getDefault());
        this.withValidRange(instance.getValidRange());
        this.withValidValues(instance.getValidValues());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ValidRangeNested<A> editOrNewValidRange() {
    return this.withNewValidRangeLike(Optional.ofNullable(this.buildValidRange()).orElse(new CapacityRequestPolicyRangeBuilder().build()));
  }
  
  public ValidRangeNested<A> editOrNewValidRangeLike(CapacityRequestPolicyRange item) {
    return this.withNewValidRangeLike(Optional.ofNullable(this.buildValidRange()).orElse(item));
  }
  
  public ValidRangeNested<A> editValidRange() {
    return this.withNewValidRangeLike(Optional.ofNullable(this.buildValidRange()).orElse(null));
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
    CapacityRequestPolicyFluent that = (CapacityRequestPolicyFluent) o;
    if (!(Objects.equals(_default, that._default))) {
      return false;
    }
    if (!(Objects.equals(validRange, that.validRange))) {
      return false;
    }
    if (!(Objects.equals(validValues, that.validValues))) {
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
  
  public Quantity getDefault() {
    return this._default;
  }
  
  public Quantity getFirstValidValue() {
    return this.validValues.get(0);
  }
  
  public Quantity getLastValidValue() {
    return this.validValues.get(validValues.size() - 1);
  }
  
  public Quantity getMatchingValidValue(Predicate<Quantity> predicate) {
      for (Quantity item : validValues) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Quantity getValidValue(int index) {
    return this.validValues.get(index);
  }
  
  public List<Quantity> getValidValues() {
    return this.validValues;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasMatchingValidValue(Predicate<Quantity> predicate) {
      for (Quantity item : validValues) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasValidRange() {
    return this.validRange != null;
  }
  
  public boolean hasValidValues() {
    return this.validValues != null && !(this.validValues.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(_default, validRange, validValues, additionalProperties);
  }
  
  public A removeAllFromValidValues(Collection<Quantity> items) {
    if (this.validValues == null) {
      return (A) this;
    }
    for (Quantity item : items) {
      this.validValues.remove(item);
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
  
  public A removeFromValidValues(Quantity... items) {
    if (this.validValues == null) {
      return (A) this;
    }
    for (Quantity item : items) {
      this.validValues.remove(item);
    }
    return (A) this;
  }
  
  public A setToValidValues(int index,Quantity item) {
    if (this.validValues == null) {
      this.validValues = new ArrayList();
    }
    this.validValues.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(validRange == null)) {
        sb.append("validRange:");
        sb.append(validRange);
        sb.append(",");
    }
    if (!(validValues == null) && !(validValues.isEmpty())) {
        sb.append("validValues:");
        sb.append(validValues);
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
  
  public A withDefault(Quantity _default) {
    this._default = _default;
    return (A) this;
  }
  
  public A withNewDefault(String amount) {
    return (A) this.withDefault(new Quantity(amount));
  }
  
  public A withNewDefault(String amount,String format) {
    return (A) this.withDefault(new Quantity(amount, format));
  }
  
  public ValidRangeNested<A> withNewValidRange() {
    return new ValidRangeNested(null);
  }
  
  public ValidRangeNested<A> withNewValidRangeLike(CapacityRequestPolicyRange item) {
    return new ValidRangeNested(item);
  }
  
  public A withValidRange(CapacityRequestPolicyRange validRange) {
    this._visitables.remove("validRange");
    if (validRange != null) {
        this.validRange = new CapacityRequestPolicyRangeBuilder(validRange);
        this._visitables.get("validRange").add(this.validRange);
    } else {
        this.validRange = null;
        this._visitables.get("validRange").remove(this.validRange);
    }
    return (A) this;
  }
  
  public A withValidValues(List<Quantity> validValues) {
    if (validValues != null) {
        this.validValues = new ArrayList();
        for (Quantity item : validValues) {
          this.addToValidValues(item);
        }
    } else {
      this.validValues = null;
    }
    return (A) this;
  }
  
  public A withValidValues(Quantity... validValues) {
    if (this.validValues != null) {
        this.validValues.clear();
        _visitables.remove("validValues");
    }
    if (validValues != null) {
      for (Quantity item : validValues) {
        this.addToValidValues(item);
      }
    }
    return (A) this;
  }
  public class ValidRangeNested<N> extends CapacityRequestPolicyRangeFluent<ValidRangeNested<N>> implements Nested<N>{
  
    CapacityRequestPolicyRangeBuilder builder;
  
    ValidRangeNested(CapacityRequestPolicyRange item) {
      this.builder = new CapacityRequestPolicyRangeBuilder(this, item);
    }
  
    public N and() {
      return (N) CapacityRequestPolicyFluent.this.withValidRange(builder.build());
    }
    
    public N endValidRange() {
      return and();
    }
    
  }
}