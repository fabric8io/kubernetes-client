package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.NodeSelector;
import java.lang.Boolean;
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
public class ResourceSliceSpecFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.ResourceSliceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allNodes;
  private ArrayList<DeviceBuilder> devices = new ArrayList<DeviceBuilder>();
  private String driver;
  private String nodeName;
  private NodeSelector nodeSelector;
  private Boolean perDeviceNodeSelection;
  private ResourcePoolBuilder pool;
  private ArrayList<CounterSetBuilder> sharedCounters = new ArrayList<CounterSetBuilder>();

  public ResourceSliceSpecFluent() {
  }
  
  public ResourceSliceSpecFluent(ResourceSliceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDevices(Collection<Device> items) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    for (Device item : items) {
        DeviceBuilder builder = new DeviceBuilder(item);
        _visitables.get("devices").add(builder);
        this.devices.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSharedCounters(Collection<CounterSet> items) {
    if (this.sharedCounters == null) {
      this.sharedCounters = new ArrayList();
    }
    for (CounterSet item : items) {
        CounterSetBuilder builder = new CounterSetBuilder(item);
        _visitables.get("sharedCounters").add(builder);
        this.sharedCounters.add(builder);
    }
    return (A) this;
  }
  
  public DevicesNested<A> addNewDevice() {
    return new DevicesNested(-1, null);
  }
  
  public DevicesNested<A> addNewDeviceLike(Device item) {
    return new DevicesNested(-1, item);
  }
  
  public SharedCountersNested<A> addNewSharedCounter() {
    return new SharedCountersNested(-1, null);
  }
  
  public SharedCountersNested<A> addNewSharedCounterLike(CounterSet item) {
    return new SharedCountersNested(-1, item);
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
  
  public A addToDevices(Device... items) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    for (Device item : items) {
        DeviceBuilder builder = new DeviceBuilder(item);
        _visitables.get("devices").add(builder);
        this.devices.add(builder);
    }
    return (A) this;
  }
  
  public A addToDevices(int index,Device item) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    DeviceBuilder builder = new DeviceBuilder(item);
    if (index < 0 || index >= devices.size()) {
        _visitables.get("devices").add(builder);
        devices.add(builder);
    } else {
        _visitables.get("devices").add(builder);
        devices.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSharedCounters(CounterSet... items) {
    if (this.sharedCounters == null) {
      this.sharedCounters = new ArrayList();
    }
    for (CounterSet item : items) {
        CounterSetBuilder builder = new CounterSetBuilder(item);
        _visitables.get("sharedCounters").add(builder);
        this.sharedCounters.add(builder);
    }
    return (A) this;
  }
  
  public A addToSharedCounters(int index,CounterSet item) {
    if (this.sharedCounters == null) {
      this.sharedCounters = new ArrayList();
    }
    CounterSetBuilder builder = new CounterSetBuilder(item);
    if (index < 0 || index >= sharedCounters.size()) {
        _visitables.get("sharedCounters").add(builder);
        sharedCounters.add(builder);
    } else {
        _visitables.get("sharedCounters").add(builder);
        sharedCounters.add(index, builder);
    }
    return (A) this;
  }
  
  public Device buildDevice(int index) {
    return this.devices.get(index).build();
  }
  
  public List<Device> buildDevices() {
    return this.devices != null ? build(devices) : null;
  }
  
  public Device buildFirstDevice() {
    return this.devices.get(0).build();
  }
  
  public CounterSet buildFirstSharedCounter() {
    return this.sharedCounters.get(0).build();
  }
  
  public Device buildLastDevice() {
    return this.devices.get(devices.size() - 1).build();
  }
  
  public CounterSet buildLastSharedCounter() {
    return this.sharedCounters.get(sharedCounters.size() - 1).build();
  }
  
  public Device buildMatchingDevice(Predicate<DeviceBuilder> predicate) {
      for (DeviceBuilder item : devices) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CounterSet buildMatchingSharedCounter(Predicate<CounterSetBuilder> predicate) {
      for (CounterSetBuilder item : sharedCounters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourcePool buildPool() {
    return this.pool != null ? this.pool.build() : null;
  }
  
  public CounterSet buildSharedCounter(int index) {
    return this.sharedCounters.get(index).build();
  }
  
  public List<CounterSet> buildSharedCounters() {
    return this.sharedCounters != null ? build(sharedCounters) : null;
  }
  
  protected void copyInstance(ResourceSliceSpec instance) {
    instance = instance != null ? instance : new ResourceSliceSpec();
    if (instance != null) {
        this.withAllNodes(instance.getAllNodes());
        this.withDevices(instance.getDevices());
        this.withDriver(instance.getDriver());
        this.withNodeName(instance.getNodeName());
        this.withNodeSelector(instance.getNodeSelector());
        this.withPerDeviceNodeSelection(instance.getPerDeviceNodeSelection());
        this.withPool(instance.getPool());
        this.withSharedCounters(instance.getSharedCounters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public SharedCountersNested<A> editFirstSharedCounter() {
    if (sharedCounters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sharedCounters"));
    }
    return this.setNewSharedCounterLike(0, this.buildSharedCounter(0));
  }
  
  public DevicesNested<A> editLastDevice() {
    int index = devices.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "devices"));
    }
    return this.setNewDeviceLike(index, this.buildDevice(index));
  }
  
  public SharedCountersNested<A> editLastSharedCounter() {
    int index = sharedCounters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sharedCounters"));
    }
    return this.setNewSharedCounterLike(index, this.buildSharedCounter(index));
  }
  
  public DevicesNested<A> editMatchingDevice(Predicate<DeviceBuilder> predicate) {
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
  
  public SharedCountersNested<A> editMatchingSharedCounter(Predicate<CounterSetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sharedCounters.size();i++) {
      if (predicate.test(sharedCounters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sharedCounters"));
    }
    return this.setNewSharedCounterLike(index, this.buildSharedCounter(index));
  }
  
  public PoolNested<A> editOrNewPool() {
    return this.withNewPoolLike(Optional.ofNullable(this.buildPool()).orElse(new ResourcePoolBuilder().build()));
  }
  
  public PoolNested<A> editOrNewPoolLike(ResourcePool item) {
    return this.withNewPoolLike(Optional.ofNullable(this.buildPool()).orElse(item));
  }
  
  public PoolNested<A> editPool() {
    return this.withNewPoolLike(Optional.ofNullable(this.buildPool()).orElse(null));
  }
  
  public SharedCountersNested<A> editSharedCounter(int index) {
    if (sharedCounters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sharedCounters"));
    }
    return this.setNewSharedCounterLike(index, this.buildSharedCounter(index));
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
    ResourceSliceSpecFluent that = (ResourceSliceSpecFluent) o;
    if (!(Objects.equals(allNodes, that.allNodes))) {
      return false;
    }
    if (!(Objects.equals(devices, that.devices))) {
      return false;
    }
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(perDeviceNodeSelection, that.perDeviceNodeSelection))) {
      return false;
    }
    if (!(Objects.equals(pool, that.pool))) {
      return false;
    }
    if (!(Objects.equals(sharedCounters, that.sharedCounters))) {
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
  
  public Boolean getAllNodes() {
    return this.allNodes;
  }
  
  public String getDriver() {
    return this.driver;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public NodeSelector getNodeSelector() {
    return this.nodeSelector;
  }
  
  public Boolean getPerDeviceNodeSelection() {
    return this.perDeviceNodeSelection;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllNodes() {
    return this.allNodes != null;
  }
  
  public boolean hasDevices() {
    return this.devices != null && !(this.devices.isEmpty());
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasMatchingDevice(Predicate<DeviceBuilder> predicate) {
      for (DeviceBuilder item : devices) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSharedCounter(Predicate<CounterSetBuilder> predicate) {
      for (CounterSetBuilder item : sharedCounters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasPerDeviceNodeSelection() {
    return this.perDeviceNodeSelection != null;
  }
  
  public boolean hasPool() {
    return this.pool != null;
  }
  
  public boolean hasSharedCounters() {
    return this.sharedCounters != null && !(this.sharedCounters.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allNodes, devices, driver, nodeName, nodeSelector, perDeviceNodeSelection, pool, sharedCounters, additionalProperties);
  }
  
  public A removeAllFromDevices(Collection<Device> items) {
    if (this.devices == null) {
      return (A) this;
    }
    for (Device item : items) {
        DeviceBuilder builder = new DeviceBuilder(item);
        _visitables.get("devices").remove(builder);
        this.devices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSharedCounters(Collection<CounterSet> items) {
    if (this.sharedCounters == null) {
      return (A) this;
    }
    for (CounterSet item : items) {
        CounterSetBuilder builder = new CounterSetBuilder(item);
        _visitables.get("sharedCounters").remove(builder);
        this.sharedCounters.remove(builder);
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
  
  public A removeFromDevices(Device... items) {
    if (this.devices == null) {
      return (A) this;
    }
    for (Device item : items) {
        DeviceBuilder builder = new DeviceBuilder(item);
        _visitables.get("devices").remove(builder);
        this.devices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSharedCounters(CounterSet... items) {
    if (this.sharedCounters == null) {
      return (A) this;
    }
    for (CounterSet item : items) {
        CounterSetBuilder builder = new CounterSetBuilder(item);
        _visitables.get("sharedCounters").remove(builder);
        this.sharedCounters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDevices(Predicate<DeviceBuilder> predicate) {
    if (devices == null) {
      return (A) this;
    }
    Iterator<DeviceBuilder> each = devices.iterator();
    List visitables = _visitables.get("devices");
    while (each.hasNext()) {
        DeviceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSharedCounters(Predicate<CounterSetBuilder> predicate) {
    if (sharedCounters == null) {
      return (A) this;
    }
    Iterator<CounterSetBuilder> each = sharedCounters.iterator();
    List visitables = _visitables.get("sharedCounters");
    while (each.hasNext()) {
        CounterSetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DevicesNested<A> setNewDeviceLike(int index,Device item) {
    return new DevicesNested(index, item);
  }
  
  public SharedCountersNested<A> setNewSharedCounterLike(int index,CounterSet item) {
    return new SharedCountersNested(index, item);
  }
  
  public A setToDevices(int index,Device item) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    DeviceBuilder builder = new DeviceBuilder(item);
    if (index < 0 || index >= devices.size()) {
        _visitables.get("devices").add(builder);
        devices.add(builder);
    } else {
        _visitables.get("devices").add(builder);
        devices.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSharedCounters(int index,CounterSet item) {
    if (this.sharedCounters == null) {
      this.sharedCounters = new ArrayList();
    }
    CounterSetBuilder builder = new CounterSetBuilder(item);
    if (index < 0 || index >= sharedCounters.size()) {
        _visitables.get("sharedCounters").add(builder);
        sharedCounters.add(builder);
    } else {
        _visitables.get("sharedCounters").add(builder);
        sharedCounters.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allNodes == null)) {
        sb.append("allNodes:");
        sb.append(allNodes);
        sb.append(",");
    }
    if (!(devices == null) && !(devices.isEmpty())) {
        sb.append("devices:");
        sb.append(devices);
        sb.append(",");
    }
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(nodeSelector == null)) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(perDeviceNodeSelection == null)) {
        sb.append("perDeviceNodeSelection:");
        sb.append(perDeviceNodeSelection);
        sb.append(",");
    }
    if (!(pool == null)) {
        sb.append("pool:");
        sb.append(pool);
        sb.append(",");
    }
    if (!(sharedCounters == null) && !(sharedCounters.isEmpty())) {
        sb.append("sharedCounters:");
        sb.append(sharedCounters);
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
  
  public A withAllNodes() {
    return withAllNodes(true);
  }
  
  public A withAllNodes(Boolean allNodes) {
    this.allNodes = allNodes;
    return (A) this;
  }
  
  public A withDevices(List<Device> devices) {
    if (this.devices != null) {
      this._visitables.get("devices").clear();
    }
    if (devices != null) {
        this.devices = new ArrayList();
        for (Device item : devices) {
          this.addToDevices(item);
        }
    } else {
      this.devices = null;
    }
    return (A) this;
  }
  
  public A withDevices(Device... devices) {
    if (this.devices != null) {
        this.devices.clear();
        _visitables.remove("devices");
    }
    if (devices != null) {
      for (Device item : devices) {
        this.addToDevices(item);
      }
    }
    return (A) this;
  }
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public PoolNested<A> withNewPool() {
    return new PoolNested(null);
  }
  
  public A withNewPool(Long generation,String name,Long resourceSliceCount) {
    return (A) this.withPool(new ResourcePool(generation, name, resourceSliceCount));
  }
  
  public PoolNested<A> withNewPoolLike(ResourcePool item) {
    return new PoolNested(item);
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withNodeSelector(NodeSelector nodeSelector) {
    this.nodeSelector = nodeSelector;
    return (A) this;
  }
  
  public A withPerDeviceNodeSelection() {
    return withPerDeviceNodeSelection(true);
  }
  
  public A withPerDeviceNodeSelection(Boolean perDeviceNodeSelection) {
    this.perDeviceNodeSelection = perDeviceNodeSelection;
    return (A) this;
  }
  
  public A withPool(ResourcePool pool) {
    this._visitables.remove("pool");
    if (pool != null) {
        this.pool = new ResourcePoolBuilder(pool);
        this._visitables.get("pool").add(this.pool);
    } else {
        this.pool = null;
        this._visitables.get("pool").remove(this.pool);
    }
    return (A) this;
  }
  
  public A withSharedCounters(List<CounterSet> sharedCounters) {
    if (this.sharedCounters != null) {
      this._visitables.get("sharedCounters").clear();
    }
    if (sharedCounters != null) {
        this.sharedCounters = new ArrayList();
        for (CounterSet item : sharedCounters) {
          this.addToSharedCounters(item);
        }
    } else {
      this.sharedCounters = null;
    }
    return (A) this;
  }
  
  public A withSharedCounters(CounterSet... sharedCounters) {
    if (this.sharedCounters != null) {
        this.sharedCounters.clear();
        _visitables.remove("sharedCounters");
    }
    if (sharedCounters != null) {
      for (CounterSet item : sharedCounters) {
        this.addToSharedCounters(item);
      }
    }
    return (A) this;
  }
  public class DevicesNested<N> extends DeviceFluent<DevicesNested<N>> implements Nested<N>{
  
    DeviceBuilder builder;
    int index;
  
    DevicesNested(int index,Device item) {
      this.index = index;
      this.builder = new DeviceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceSliceSpecFluent.this.setToDevices(index, builder.build());
    }
    
    public N endDevice() {
      return and();
    }
    
  }
  public class PoolNested<N> extends ResourcePoolFluent<PoolNested<N>> implements Nested<N>{
  
    ResourcePoolBuilder builder;
  
    PoolNested(ResourcePool item) {
      this.builder = new ResourcePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceSliceSpecFluent.this.withPool(builder.build());
    }
    
    public N endPool() {
      return and();
    }
    
  }
  public class SharedCountersNested<N> extends CounterSetFluent<SharedCountersNested<N>> implements Nested<N>{
  
    CounterSetBuilder builder;
    int index;
  
    SharedCountersNested(int index,CounterSet item) {
      this.index = index;
      this.builder = new CounterSetBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceSliceSpecFluent.this.setToSharedCounters(index, builder.build());
    }
    
    public N endSharedCounter() {
      return and();
    }
    
  }
}