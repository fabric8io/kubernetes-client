package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class DeviceSubRequestFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta1.DeviceSubRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String allocationMode;
  private CapacityRequirementsBuilder capacity;
  private Long count;
  private String deviceClassName;
  private String name;
  private ArrayList<DeviceSelectorBuilder> selectors = new ArrayList<DeviceSelectorBuilder>();
  private ArrayList<DeviceTolerationBuilder> tolerations = new ArrayList<DeviceTolerationBuilder>();

  public DeviceSubRequestFluent() {
  }
  
  public DeviceSubRequestFluent(DeviceSubRequest instance) {
    this.copyInstance(instance);
  }

  public A addAllToSelectors(Collection<DeviceSelector> items) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").add(builder);
        this.selectors.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTolerations(Collection<DeviceToleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (DeviceToleration item : items) {
        DeviceTolerationBuilder builder = new DeviceTolerationBuilder(item);
        _visitables.get("tolerations").add(builder);
        this.tolerations.add(builder);
    }
    return (A) this;
  }
  
  public SelectorsNested<A> addNewSelector() {
    return new SelectorsNested(-1, null);
  }
  
  public SelectorsNested<A> addNewSelectorLike(DeviceSelector item) {
    return new SelectorsNested(-1, item);
  }
  
  public TolerationsNested<A> addNewToleration() {
    return new TolerationsNested(-1, null);
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new DeviceToleration(effect, key, operator, tolerationSeconds, value));
  }
  
  public TolerationsNested<A> addNewTolerationLike(DeviceToleration item) {
    return new TolerationsNested(-1, item);
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
  
  public A addToSelectors(DeviceSelector... items) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").add(builder);
        this.selectors.add(builder);
    }
    return (A) this;
  }
  
  public A addToSelectors(int index,DeviceSelector item) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
    if (index < 0 || index >= selectors.size()) {
        _visitables.get("selectors").add(builder);
        selectors.add(builder);
    } else {
        _visitables.get("selectors").add(builder);
        selectors.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTolerations(DeviceToleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (DeviceToleration item : items) {
        DeviceTolerationBuilder builder = new DeviceTolerationBuilder(item);
        _visitables.get("tolerations").add(builder);
        this.tolerations.add(builder);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,DeviceToleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    DeviceTolerationBuilder builder = new DeviceTolerationBuilder(item);
    if (index < 0 || index >= tolerations.size()) {
        _visitables.get("tolerations").add(builder);
        tolerations.add(builder);
    } else {
        _visitables.get("tolerations").add(builder);
        tolerations.add(index, builder);
    }
    return (A) this;
  }
  
  public CapacityRequirements buildCapacity() {
    return this.capacity != null ? this.capacity.build() : null;
  }
  
  public DeviceSelector buildFirstSelector() {
    return this.selectors.get(0).build();
  }
  
  public DeviceToleration buildFirstToleration() {
    return this.tolerations.get(0).build();
  }
  
  public DeviceSelector buildLastSelector() {
    return this.selectors.get(selectors.size() - 1).build();
  }
  
  public DeviceToleration buildLastToleration() {
    return this.tolerations.get(tolerations.size() - 1).build();
  }
  
  public DeviceSelector buildMatchingSelector(Predicate<DeviceSelectorBuilder> predicate) {
      for (DeviceSelectorBuilder item : selectors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceToleration buildMatchingToleration(Predicate<DeviceTolerationBuilder> predicate) {
      for (DeviceTolerationBuilder item : tolerations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceSelector buildSelector(int index) {
    return this.selectors.get(index).build();
  }
  
  public List<DeviceSelector> buildSelectors() {
    return this.selectors != null ? build(selectors) : null;
  }
  
  public DeviceToleration buildToleration(int index) {
    return this.tolerations.get(index).build();
  }
  
  public List<DeviceToleration> buildTolerations() {
    return this.tolerations != null ? build(tolerations) : null;
  }
  
  protected void copyInstance(DeviceSubRequest instance) {
    instance = instance != null ? instance : new DeviceSubRequest();
    if (instance != null) {
        this.withAllocationMode(instance.getAllocationMode());
        this.withCapacity(instance.getCapacity());
        this.withCount(instance.getCount());
        this.withDeviceClassName(instance.getDeviceClassName());
        this.withName(instance.getName());
        this.withSelectors(instance.getSelectors());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CapacityNested<A> editCapacity() {
    return this.withNewCapacityLike(Optional.ofNullable(this.buildCapacity()).orElse(null));
  }
  
  public SelectorsNested<A> editFirstSelector() {
    if (selectors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "selectors"));
    }
    return this.setNewSelectorLike(0, this.buildSelector(0));
  }
  
  public TolerationsNested<A> editFirstToleration() {
    if (tolerations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tolerations"));
    }
    return this.setNewTolerationLike(0, this.buildToleration(0));
  }
  
  public SelectorsNested<A> editLastSelector() {
    int index = selectors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
  }
  
  public TolerationsNested<A> editLastToleration() {
    int index = tolerations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
  }
  
  public SelectorsNested<A> editMatchingSelector(Predicate<DeviceSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < selectors.size();i++) {
      if (predicate.test(selectors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
  }
  
  public TolerationsNested<A> editMatchingToleration(Predicate<DeviceTolerationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tolerations.size();i++) {
      if (predicate.test(tolerations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
  }
  
  public CapacityNested<A> editOrNewCapacity() {
    return this.withNewCapacityLike(Optional.ofNullable(this.buildCapacity()).orElse(new CapacityRequirementsBuilder().build()));
  }
  
  public CapacityNested<A> editOrNewCapacityLike(CapacityRequirements item) {
    return this.withNewCapacityLike(Optional.ofNullable(this.buildCapacity()).orElse(item));
  }
  
  public SelectorsNested<A> editSelector(int index) {
    if (selectors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
  }
  
  public TolerationsNested<A> editToleration(int index) {
    if (tolerations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
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
    DeviceSubRequestFluent that = (DeviceSubRequestFluent) o;
    if (!(Objects.equals(allocationMode, that.allocationMode))) {
      return false;
    }
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(count, that.count))) {
      return false;
    }
    if (!(Objects.equals(deviceClassName, that.deviceClassName))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(selectors, that.selectors))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public String getAllocationMode() {
    return this.allocationMode;
  }
  
  public Long getCount() {
    return this.count;
  }
  
  public String getDeviceClassName() {
    return this.deviceClassName;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocationMode() {
    return this.allocationMode != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null;
  }
  
  public boolean hasCount() {
    return this.count != null;
  }
  
  public boolean hasDeviceClassName() {
    return this.deviceClassName != null;
  }
  
  public boolean hasMatchingSelector(Predicate<DeviceSelectorBuilder> predicate) {
      for (DeviceSelectorBuilder item : selectors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingToleration(Predicate<DeviceTolerationBuilder> predicate) {
      for (DeviceTolerationBuilder item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSelectors() {
    return this.selectors != null && !(this.selectors.isEmpty());
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allocationMode, capacity, count, deviceClassName, name, selectors, tolerations, additionalProperties);
  }
  
  public A removeAllFromSelectors(Collection<DeviceSelector> items) {
    if (this.selectors == null) {
      return (A) this;
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").remove(builder);
        this.selectors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTolerations(Collection<DeviceToleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (DeviceToleration item : items) {
        DeviceTolerationBuilder builder = new DeviceTolerationBuilder(item);
        _visitables.get("tolerations").remove(builder);
        this.tolerations.remove(builder);
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
  
  public A removeFromSelectors(DeviceSelector... items) {
    if (this.selectors == null) {
      return (A) this;
    }
    for (DeviceSelector item : items) {
        DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
        _visitables.get("selectors").remove(builder);
        this.selectors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTolerations(DeviceToleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (DeviceToleration item : items) {
        DeviceTolerationBuilder builder = new DeviceTolerationBuilder(item);
        _visitables.get("tolerations").remove(builder);
        this.tolerations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSelectors(Predicate<DeviceSelectorBuilder> predicate) {
    if (selectors == null) {
      return (A) this;
    }
    Iterator<DeviceSelectorBuilder> each = selectors.iterator();
    List visitables = _visitables.get("selectors");
    while (each.hasNext()) {
        DeviceSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTolerations(Predicate<DeviceTolerationBuilder> predicate) {
    if (tolerations == null) {
      return (A) this;
    }
    Iterator<DeviceTolerationBuilder> each = tolerations.iterator();
    List visitables = _visitables.get("tolerations");
    while (each.hasNext()) {
        DeviceTolerationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SelectorsNested<A> setNewSelectorLike(int index,DeviceSelector item) {
    return new SelectorsNested(index, item);
  }
  
  public TolerationsNested<A> setNewTolerationLike(int index,DeviceToleration item) {
    return new TolerationsNested(index, item);
  }
  
  public A setToSelectors(int index,DeviceSelector item) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    DeviceSelectorBuilder builder = new DeviceSelectorBuilder(item);
    if (index < 0 || index >= selectors.size()) {
        _visitables.get("selectors").add(builder);
        selectors.add(builder);
    } else {
        _visitables.get("selectors").add(builder);
        selectors.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,DeviceToleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    DeviceTolerationBuilder builder = new DeviceTolerationBuilder(item);
    if (index < 0 || index >= tolerations.size()) {
        _visitables.get("tolerations").add(builder);
        tolerations.add(builder);
    } else {
        _visitables.get("tolerations").add(builder);
        tolerations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocationMode == null)) {
        sb.append("allocationMode:");
        sb.append(allocationMode);
        sb.append(",");
    }
    if (!(capacity == null)) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(count == null)) {
        sb.append("count:");
        sb.append(count);
        sb.append(",");
    }
    if (!(deviceClassName == null)) {
        sb.append("deviceClassName:");
        sb.append(deviceClassName);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(selectors == null) && !(selectors.isEmpty())) {
        sb.append("selectors:");
        sb.append(selectors);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withAllocationMode(String allocationMode) {
    this.allocationMode = allocationMode;
    return (A) this;
  }
  
  public A withCapacity(CapacityRequirements capacity) {
    this._visitables.remove("capacity");
    if (capacity != null) {
        this.capacity = new CapacityRequirementsBuilder(capacity);
        this._visitables.get("capacity").add(this.capacity);
    } else {
        this.capacity = null;
        this._visitables.get("capacity").remove(this.capacity);
    }
    return (A) this;
  }
  
  public A withCount(Long count) {
    this.count = count;
    return (A) this;
  }
  
  public A withDeviceClassName(String deviceClassName) {
    this.deviceClassName = deviceClassName;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public CapacityNested<A> withNewCapacity() {
    return new CapacityNested(null);
  }
  
  public CapacityNested<A> withNewCapacityLike(CapacityRequirements item) {
    return new CapacityNested(item);
  }
  
  public A withSelectors(List<DeviceSelector> selectors) {
    if (this.selectors != null) {
      this._visitables.get("selectors").clear();
    }
    if (selectors != null) {
        this.selectors = new ArrayList();
        for (DeviceSelector item : selectors) {
          this.addToSelectors(item);
        }
    } else {
      this.selectors = null;
    }
    return (A) this;
  }
  
  public A withSelectors(DeviceSelector... selectors) {
    if (this.selectors != null) {
        this.selectors.clear();
        _visitables.remove("selectors");
    }
    if (selectors != null) {
      for (DeviceSelector item : selectors) {
        this.addToSelectors(item);
      }
    }
    return (A) this;
  }
  
  public A withTolerations(List<DeviceToleration> tolerations) {
    if (this.tolerations != null) {
      this._visitables.get("tolerations").clear();
    }
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (DeviceToleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(DeviceToleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (DeviceToleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class CapacityNested<N> extends CapacityRequirementsFluent<CapacityNested<N>> implements Nested<N>{
  
    CapacityRequirementsBuilder builder;
  
    CapacityNested(CapacityRequirements item) {
      this.builder = new CapacityRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceSubRequestFluent.this.withCapacity(builder.build());
    }
    
    public N endCapacity() {
      return and();
    }
    
  }
  public class SelectorsNested<N> extends DeviceSelectorFluent<SelectorsNested<N>> implements Nested<N>{
  
    DeviceSelectorBuilder builder;
    int index;
  
    SelectorsNested(int index,DeviceSelector item) {
      this.index = index;
      this.builder = new DeviceSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceSubRequestFluent.this.setToSelectors(index, builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TolerationsNested<N> extends DeviceTolerationFluent<TolerationsNested<N>> implements Nested<N>{
  
    DeviceTolerationBuilder builder;
    int index;
  
    TolerationsNested(int index,DeviceToleration item) {
      this.index = index;
      this.builder = new DeviceTolerationBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceSubRequestFluent.this.setToTolerations(index, builder.build());
    }
    
    public N endToleration() {
      return and();
    }
    
  }
}