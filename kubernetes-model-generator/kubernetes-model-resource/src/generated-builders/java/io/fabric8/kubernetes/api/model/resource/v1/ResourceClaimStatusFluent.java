package io.fabric8.kubernetes.api.model.resource.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ResourceClaimStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.ResourceClaimStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AllocationResultBuilder allocation;
  private ArrayList<AllocatedDeviceStatusBuilder> devices = new ArrayList<AllocatedDeviceStatusBuilder>();
  private ArrayList<ResourceClaimConsumerReferenceBuilder> reservedFor = new ArrayList<ResourceClaimConsumerReferenceBuilder>();

  public ResourceClaimStatusFluent() {
  }
  
  public ResourceClaimStatusFluent(ResourceClaimStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToDevices(Collection<AllocatedDeviceStatus> items) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    for (AllocatedDeviceStatus item : items) {
        AllocatedDeviceStatusBuilder builder = new AllocatedDeviceStatusBuilder(item);
        _visitables.get("devices").add(builder);
        this.devices.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToReservedFor(Collection<ResourceClaimConsumerReference> items) {
    if (this.reservedFor == null) {
      this.reservedFor = new ArrayList();
    }
    for (ResourceClaimConsumerReference item : items) {
        ResourceClaimConsumerReferenceBuilder builder = new ResourceClaimConsumerReferenceBuilder(item);
        _visitables.get("reservedFor").add(builder);
        this.reservedFor.add(builder);
    }
    return (A) this;
  }
  
  public DevicesNested<A> addNewDevice() {
    return new DevicesNested(-1, null);
  }
  
  public DevicesNested<A> addNewDeviceLike(AllocatedDeviceStatus item) {
    return new DevicesNested(-1, item);
  }
  
  public ReservedForNested<A> addNewReservedFor() {
    return new ReservedForNested(-1, null);
  }
  
  public A addNewReservedFor(String apiGroup,String name,String resource,String uid) {
    return (A) this.addToReservedFor(new ResourceClaimConsumerReference(apiGroup, name, resource, uid));
  }
  
  public ReservedForNested<A> addNewReservedForLike(ResourceClaimConsumerReference item) {
    return new ReservedForNested(-1, item);
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
  
  public A addToDevices(AllocatedDeviceStatus... items) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    for (AllocatedDeviceStatus item : items) {
        AllocatedDeviceStatusBuilder builder = new AllocatedDeviceStatusBuilder(item);
        _visitables.get("devices").add(builder);
        this.devices.add(builder);
    }
    return (A) this;
  }
  
  public A addToDevices(int index,AllocatedDeviceStatus item) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    AllocatedDeviceStatusBuilder builder = new AllocatedDeviceStatusBuilder(item);
    if (index < 0 || index >= devices.size()) {
        _visitables.get("devices").add(builder);
        devices.add(builder);
    } else {
        _visitables.get("devices").add(builder);
        devices.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToReservedFor(ResourceClaimConsumerReference... items) {
    if (this.reservedFor == null) {
      this.reservedFor = new ArrayList();
    }
    for (ResourceClaimConsumerReference item : items) {
        ResourceClaimConsumerReferenceBuilder builder = new ResourceClaimConsumerReferenceBuilder(item);
        _visitables.get("reservedFor").add(builder);
        this.reservedFor.add(builder);
    }
    return (A) this;
  }
  
  public A addToReservedFor(int index,ResourceClaimConsumerReference item) {
    if (this.reservedFor == null) {
      this.reservedFor = new ArrayList();
    }
    ResourceClaimConsumerReferenceBuilder builder = new ResourceClaimConsumerReferenceBuilder(item);
    if (index < 0 || index >= reservedFor.size()) {
        _visitables.get("reservedFor").add(builder);
        reservedFor.add(builder);
    } else {
        _visitables.get("reservedFor").add(builder);
        reservedFor.add(index, builder);
    }
    return (A) this;
  }
  
  public AllocationResult buildAllocation() {
    return this.allocation != null ? this.allocation.build() : null;
  }
  
  public AllocatedDeviceStatus buildDevice(int index) {
    return this.devices.get(index).build();
  }
  
  public List<AllocatedDeviceStatus> buildDevices() {
    return this.devices != null ? build(devices) : null;
  }
  
  public AllocatedDeviceStatus buildFirstDevice() {
    return this.devices.get(0).build();
  }
  
  public ResourceClaimConsumerReference buildFirstReservedFor() {
    return this.reservedFor.get(0).build();
  }
  
  public AllocatedDeviceStatus buildLastDevice() {
    return this.devices.get(devices.size() - 1).build();
  }
  
  public ResourceClaimConsumerReference buildLastReservedFor() {
    return this.reservedFor.get(reservedFor.size() - 1).build();
  }
  
  public AllocatedDeviceStatus buildMatchingDevice(Predicate<AllocatedDeviceStatusBuilder> predicate) {
      for (AllocatedDeviceStatusBuilder item : devices) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceClaimConsumerReference buildMatchingReservedFor(Predicate<ResourceClaimConsumerReferenceBuilder> predicate) {
      for (ResourceClaimConsumerReferenceBuilder item : reservedFor) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<ResourceClaimConsumerReference> buildReservedFor() {
    return this.reservedFor != null ? build(reservedFor) : null;
  }
  
  public ResourceClaimConsumerReference buildReservedFor(int index) {
    return this.reservedFor.get(index).build();
  }
  
  protected void copyInstance(ResourceClaimStatus instance) {
    instance = instance != null ? instance : new ResourceClaimStatus();
    if (instance != null) {
        this.withAllocation(instance.getAllocation());
        this.withDevices(instance.getDevices());
        this.withReservedFor(instance.getReservedFor());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllocationNested<A> editAllocation() {
    return this.withNewAllocationLike(Optional.ofNullable(this.buildAllocation()).orElse(null));
  }
  
  public DevicesNested<A> editDevice(int index) {
    if (devices.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "devices"));
    }
    return this.setNewDeviceLike(index, this.buildDevice(index));
  }
  
  public DevicesNested<A> editFirstDevice() {
    if (devices.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "devices"));
    }
    return this.setNewDeviceLike(0, this.buildDevice(0));
  }
  
  public ReservedForNested<A> editFirstReservedFor() {
    if (reservedFor.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "reservedFor"));
    }
    return this.setNewReservedForLike(0, this.buildReservedFor(0));
  }
  
  public DevicesNested<A> editLastDevice() {
    int index = devices.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "devices"));
    }
    return this.setNewDeviceLike(index, this.buildDevice(index));
  }
  
  public ReservedForNested<A> editLastReservedFor() {
    int index = reservedFor.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "reservedFor"));
    }
    return this.setNewReservedForLike(index, this.buildReservedFor(index));
  }
  
  public DevicesNested<A> editMatchingDevice(Predicate<AllocatedDeviceStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < devices.size();i++) {
      if (predicate.test(devices.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "devices"));
    }
    return this.setNewDeviceLike(index, this.buildDevice(index));
  }
  
  public ReservedForNested<A> editMatchingReservedFor(Predicate<ResourceClaimConsumerReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < reservedFor.size();i++) {
      if (predicate.test(reservedFor.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "reservedFor"));
    }
    return this.setNewReservedForLike(index, this.buildReservedFor(index));
  }
  
  public AllocationNested<A> editOrNewAllocation() {
    return this.withNewAllocationLike(Optional.ofNullable(this.buildAllocation()).orElse(new AllocationResultBuilder().build()));
  }
  
  public AllocationNested<A> editOrNewAllocationLike(AllocationResult item) {
    return this.withNewAllocationLike(Optional.ofNullable(this.buildAllocation()).orElse(item));
  }
  
  public ReservedForNested<A> editReservedFor(int index) {
    if (reservedFor.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "reservedFor"));
    }
    return this.setNewReservedForLike(index, this.buildReservedFor(index));
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
    ResourceClaimStatusFluent that = (ResourceClaimStatusFluent) o;
    if (!(Objects.equals(allocation, that.allocation))) {
      return false;
    }
    if (!(Objects.equals(devices, that.devices))) {
      return false;
    }
    if (!(Objects.equals(reservedFor, that.reservedFor))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocation() {
    return this.allocation != null;
  }
  
  public boolean hasDevices() {
    return this.devices != null && !(this.devices.isEmpty());
  }
  
  public boolean hasMatchingDevice(Predicate<AllocatedDeviceStatusBuilder> predicate) {
      for (AllocatedDeviceStatusBuilder item : devices) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingReservedFor(Predicate<ResourceClaimConsumerReferenceBuilder> predicate) {
      for (ResourceClaimConsumerReferenceBuilder item : reservedFor) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReservedFor() {
    return this.reservedFor != null && !(this.reservedFor.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allocation, devices, reservedFor, additionalProperties);
  }
  
  public A removeAllFromDevices(Collection<AllocatedDeviceStatus> items) {
    if (this.devices == null) {
      return (A) this;
    }
    for (AllocatedDeviceStatus item : items) {
        AllocatedDeviceStatusBuilder builder = new AllocatedDeviceStatusBuilder(item);
        _visitables.get("devices").remove(builder);
        this.devices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromReservedFor(Collection<ResourceClaimConsumerReference> items) {
    if (this.reservedFor == null) {
      return (A) this;
    }
    for (ResourceClaimConsumerReference item : items) {
        ResourceClaimConsumerReferenceBuilder builder = new ResourceClaimConsumerReferenceBuilder(item);
        _visitables.get("reservedFor").remove(builder);
        this.reservedFor.remove(builder);
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
  
  public A removeFromDevices(AllocatedDeviceStatus... items) {
    if (this.devices == null) {
      return (A) this;
    }
    for (AllocatedDeviceStatus item : items) {
        AllocatedDeviceStatusBuilder builder = new AllocatedDeviceStatusBuilder(item);
        _visitables.get("devices").remove(builder);
        this.devices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromReservedFor(ResourceClaimConsumerReference... items) {
    if (this.reservedFor == null) {
      return (A) this;
    }
    for (ResourceClaimConsumerReference item : items) {
        ResourceClaimConsumerReferenceBuilder builder = new ResourceClaimConsumerReferenceBuilder(item);
        _visitables.get("reservedFor").remove(builder);
        this.reservedFor.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDevices(Predicate<AllocatedDeviceStatusBuilder> predicate) {
    if (devices == null) {
      return (A) this;
    }
    Iterator<AllocatedDeviceStatusBuilder> each = devices.iterator();
    List visitables = _visitables.get("devices");
    while (each.hasNext()) {
        AllocatedDeviceStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromReservedFor(Predicate<ResourceClaimConsumerReferenceBuilder> predicate) {
    if (reservedFor == null) {
      return (A) this;
    }
    Iterator<ResourceClaimConsumerReferenceBuilder> each = reservedFor.iterator();
    List visitables = _visitables.get("reservedFor");
    while (each.hasNext()) {
        ResourceClaimConsumerReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DevicesNested<A> setNewDeviceLike(int index,AllocatedDeviceStatus item) {
    return new DevicesNested(index, item);
  }
  
  public ReservedForNested<A> setNewReservedForLike(int index,ResourceClaimConsumerReference item) {
    return new ReservedForNested(index, item);
  }
  
  public A setToDevices(int index,AllocatedDeviceStatus item) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    AllocatedDeviceStatusBuilder builder = new AllocatedDeviceStatusBuilder(item);
    if (index < 0 || index >= devices.size()) {
        _visitables.get("devices").add(builder);
        devices.add(builder);
    } else {
        _visitables.get("devices").add(builder);
        devices.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToReservedFor(int index,ResourceClaimConsumerReference item) {
    if (this.reservedFor == null) {
      this.reservedFor = new ArrayList();
    }
    ResourceClaimConsumerReferenceBuilder builder = new ResourceClaimConsumerReferenceBuilder(item);
    if (index < 0 || index >= reservedFor.size()) {
        _visitables.get("reservedFor").add(builder);
        reservedFor.add(builder);
    } else {
        _visitables.get("reservedFor").add(builder);
        reservedFor.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocation == null)) {
        sb.append("allocation:");
        sb.append(allocation);
        sb.append(",");
    }
    if (!(devices == null) && !(devices.isEmpty())) {
        sb.append("devices:");
        sb.append(devices);
        sb.append(",");
    }
    if (!(reservedFor == null) && !(reservedFor.isEmpty())) {
        sb.append("reservedFor:");
        sb.append(reservedFor);
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
  
  public A withAllocation(AllocationResult allocation) {
    this._visitables.remove("allocation");
    if (allocation != null) {
        this.allocation = new AllocationResultBuilder(allocation);
        this._visitables.get("allocation").add(this.allocation);
    } else {
        this.allocation = null;
        this._visitables.get("allocation").remove(this.allocation);
    }
    return (A) this;
  }
  
  public A withDevices(List<AllocatedDeviceStatus> devices) {
    if (this.devices != null) {
      this._visitables.get("devices").clear();
    }
    if (devices != null) {
        this.devices = new ArrayList();
        for (AllocatedDeviceStatus item : devices) {
          this.addToDevices(item);
        }
    } else {
      this.devices = null;
    }
    return (A) this;
  }
  
  public A withDevices(AllocatedDeviceStatus... devices) {
    if (this.devices != null) {
        this.devices.clear();
        _visitables.remove("devices");
    }
    if (devices != null) {
      for (AllocatedDeviceStatus item : devices) {
        this.addToDevices(item);
      }
    }
    return (A) this;
  }
  
  public AllocationNested<A> withNewAllocation() {
    return new AllocationNested(null);
  }
  
  public AllocationNested<A> withNewAllocationLike(AllocationResult item) {
    return new AllocationNested(item);
  }
  
  public A withReservedFor(List<ResourceClaimConsumerReference> reservedFor) {
    if (this.reservedFor != null) {
      this._visitables.get("reservedFor").clear();
    }
    if (reservedFor != null) {
        this.reservedFor = new ArrayList();
        for (ResourceClaimConsumerReference item : reservedFor) {
          this.addToReservedFor(item);
        }
    } else {
      this.reservedFor = null;
    }
    return (A) this;
  }
  
  public A withReservedFor(ResourceClaimConsumerReference... reservedFor) {
    if (this.reservedFor != null) {
        this.reservedFor.clear();
        _visitables.remove("reservedFor");
    }
    if (reservedFor != null) {
      for (ResourceClaimConsumerReference item : reservedFor) {
        this.addToReservedFor(item);
      }
    }
    return (A) this;
  }
  public class AllocationNested<N> extends AllocationResultFluent<AllocationNested<N>> implements Nested<N>{
  
    AllocationResultBuilder builder;
  
    AllocationNested(AllocationResult item) {
      this.builder = new AllocationResultBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClaimStatusFluent.this.withAllocation(builder.build());
    }
    
    public N endAllocation() {
      return and();
    }
    
  }
  public class DevicesNested<N> extends AllocatedDeviceStatusFluent<DevicesNested<N>> implements Nested<N>{
  
    AllocatedDeviceStatusBuilder builder;
    int index;
  
    DevicesNested(int index,AllocatedDeviceStatus item) {
      this.index = index;
      this.builder = new AllocatedDeviceStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClaimStatusFluent.this.setToDevices(index, builder.build());
    }
    
    public N endDevice() {
      return and();
    }
    
  }
  public class ReservedForNested<N> extends ResourceClaimConsumerReferenceFluent<ReservedForNested<N>> implements Nested<N>{
  
    ResourceClaimConsumerReferenceBuilder builder;
    int index;
  
    ReservedForNested(int index,ResourceClaimConsumerReference item) {
      this.index = index;
      this.builder = new ResourceClaimConsumerReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClaimStatusFluent.this.setToReservedFor(index, builder.build());
    }
    
    public N endReservedFor() {
      return and();
    }
    
  }
}