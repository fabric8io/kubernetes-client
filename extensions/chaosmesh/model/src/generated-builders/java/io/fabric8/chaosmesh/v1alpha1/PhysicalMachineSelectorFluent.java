package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PhysicalMachineSelectorFluent<A extends io.fabric8.chaosmesh.v1alpha1.PhysicalMachineSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> address = new ArrayList<String>();
  private String mode;
  private PhysicalMachineSelectorSpecBuilder selector;
  private String value;

  public PhysicalMachineSelectorFluent() {
  }
  
  public PhysicalMachineSelectorFluent(PhysicalMachineSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddress(Collection<String> items) {
    if (this.address == null) {
      this.address = new ArrayList();
    }
    for (String item : items) {
      this.address.add(item);
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
  
  public A addToAddress(String... items) {
    if (this.address == null) {
      this.address = new ArrayList();
    }
    for (String item : items) {
      this.address.add(item);
    }
    return (A) this;
  }
  
  public A addToAddress(int index,String item) {
    if (this.address == null) {
      this.address = new ArrayList();
    }
    this.address.add(index, item);
    return (A) this;
  }
  
  public PhysicalMachineSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(PhysicalMachineSelector instance) {
    instance = instance != null ? instance : new PhysicalMachineSelector();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withMode(instance.getMode());
        this.withSelector(instance.getSelector());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new PhysicalMachineSelectorSpecBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(PhysicalMachineSelectorSpec item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    PhysicalMachineSelectorFluent that = (PhysicalMachineSelectorFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public List<String> getAddress() {
    return this.address;
  }
  
  public String getAddress(int index) {
    return this.address.get(index);
  }
  
  public String getFirstAddress() {
    return this.address.get(0);
  }
  
  public String getLastAddress() {
    return this.address.get(address.size() - 1);
  }
  
  public String getMatchingAddress(Predicate<String> predicate) {
      for (String item : address) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null && !(this.address.isEmpty());
  }
  
  public boolean hasMatchingAddress(Predicate<String> predicate) {
      for (String item : address) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(address, mode, selector, value, additionalProperties);
  }
  
  public A removeAllFromAddress(Collection<String> items) {
    if (this.address == null) {
      return (A) this;
    }
    for (String item : items) {
      this.address.remove(item);
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
  
  public A removeFromAddress(String... items) {
    if (this.address == null) {
      return (A) this;
    }
    for (String item : items) {
      this.address.remove(item);
    }
    return (A) this;
  }
  
  public A setToAddress(int index,String item) {
    if (this.address == null) {
      this.address = new ArrayList();
    }
    this.address.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(address == null) && !(address.isEmpty())) {
        sb.append("address:");
        sb.append(address);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public A withAddress(List<String> address) {
    if (address != null) {
        this.address = new ArrayList();
        for (String item : address) {
          this.addToAddress(item);
        }
    } else {
      this.address = null;
    }
    return (A) this;
  }
  
  public A withAddress(String... address) {
    if (this.address != null) {
        this.address.clear();
        _visitables.remove("address");
    }
    if (address != null) {
      for (String item : address) {
        this.addToAddress(item);
      }
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(PhysicalMachineSelectorSpec item) {
    return new SelectorNested(item);
  }
  
  public A withSelector(PhysicalMachineSelectorSpec selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new PhysicalMachineSelectorSpecBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class SelectorNested<N> extends PhysicalMachineSelectorSpecFluent<SelectorNested<N>> implements Nested<N>{
  
    PhysicalMachineSelectorSpecBuilder builder;
  
    SelectorNested(PhysicalMachineSelectorSpec item) {
      this.builder = new PhysicalMachineSelectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PhysicalMachineSelectorFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}