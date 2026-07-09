package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.NodeSelector;
import java.lang.Boolean;
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
public class DeviceFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta2.DeviceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allNodes;
  private Boolean allowMultipleAllocations;
  private Map<String,DeviceAttribute> attributes;
  private List<String> bindingConditions = new ArrayList<String>();
  private List<String> bindingFailureConditions = new ArrayList<String>();
  private Boolean bindsToNode;
  private Map<String,DeviceCapacity> capacity;
  private ArrayList<DeviceCounterConsumptionBuilder> consumesCounters = new ArrayList<DeviceCounterConsumptionBuilder>();
  private String name;
  private Map<String,NodeAllocatableResourceMapping> nodeAllocatableResourceMappings;
  private String nodeName;
  private NodeSelector nodeSelector;
  private ArrayList<DeviceTaintBuilder> taints = new ArrayList<DeviceTaintBuilder>();

  public DeviceFluent() {
  }
  
  public DeviceFluent(Device instance) {
    this.copyInstance(instance);
  }

  public A addAllToBindingConditions(Collection<String> items) {
    if (this.bindingConditions == null) {
      this.bindingConditions = new ArrayList();
    }
    for (String item : items) {
      this.bindingConditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToBindingFailureConditions(Collection<String> items) {
    if (this.bindingFailureConditions == null) {
      this.bindingFailureConditions = new ArrayList();
    }
    for (String item : items) {
      this.bindingFailureConditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConsumesCounters(Collection<DeviceCounterConsumption> items) {
    if (this.consumesCounters == null) {
      this.consumesCounters = new ArrayList();
    }
    for (DeviceCounterConsumption item : items) {
        DeviceCounterConsumptionBuilder builder = new DeviceCounterConsumptionBuilder(item);
        _visitables.get("consumesCounters").add(builder);
        this.consumesCounters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTaints(Collection<DeviceTaint> items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (DeviceTaint item : items) {
        DeviceTaintBuilder builder = new DeviceTaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public ConsumesCountersNested<A> addNewConsumesCounter() {
    return new ConsumesCountersNested(-1, null);
  }
  
  public ConsumesCountersNested<A> addNewConsumesCounterLike(DeviceCounterConsumption item) {
    return new ConsumesCountersNested(-1, item);
  }
  
  public TaintsNested<A> addNewTaint() {
    return new TaintsNested(-1, null);
  }
  
  public A addNewTaint(String effect,String key,String timeAdded,String value) {
    return (A) this.addToTaints(new DeviceTaint(effect, key, timeAdded, value));
  }
  
  public TaintsNested<A> addNewTaintLike(DeviceTaint item) {
    return new TaintsNested(-1, item);
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
  
  public A addToAttributes(Map<String,DeviceAttribute> map) {
    if (this.attributes == null && map != null) {
      this.attributes = new LinkedHashMap();
    }
    if (map != null) {
      this.attributes.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAttributes(String key,DeviceAttribute value) {
    if (this.attributes == null && key != null && value != null) {
      this.attributes = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.attributes.put(key, value);
    }
    return (A) this;
  }
  
  public A addToBindingConditions(String... items) {
    if (this.bindingConditions == null) {
      this.bindingConditions = new ArrayList();
    }
    for (String item : items) {
      this.bindingConditions.add(item);
    }
    return (A) this;
  }
  
  public A addToBindingConditions(int index,String item) {
    if (this.bindingConditions == null) {
      this.bindingConditions = new ArrayList();
    }
    this.bindingConditions.add(index, item);
    return (A) this;
  }
  
  public A addToBindingFailureConditions(String... items) {
    if (this.bindingFailureConditions == null) {
      this.bindingFailureConditions = new ArrayList();
    }
    for (String item : items) {
      this.bindingFailureConditions.add(item);
    }
    return (A) this;
  }
  
  public A addToBindingFailureConditions(int index,String item) {
    if (this.bindingFailureConditions == null) {
      this.bindingFailureConditions = new ArrayList();
    }
    this.bindingFailureConditions.add(index, item);
    return (A) this;
  }
  
  public A addToCapacity(Map<String,DeviceCapacity> map) {
    if (this.capacity == null && map != null) {
      this.capacity = new LinkedHashMap();
    }
    if (map != null) {
      this.capacity.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCapacity(String key,DeviceCapacity value) {
    if (this.capacity == null && key != null && value != null) {
      this.capacity = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.capacity.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConsumesCounters(DeviceCounterConsumption... items) {
    if (this.consumesCounters == null) {
      this.consumesCounters = new ArrayList();
    }
    for (DeviceCounterConsumption item : items) {
        DeviceCounterConsumptionBuilder builder = new DeviceCounterConsumptionBuilder(item);
        _visitables.get("consumesCounters").add(builder);
        this.consumesCounters.add(builder);
    }
    return (A) this;
  }
  
  public A addToConsumesCounters(int index,DeviceCounterConsumption item) {
    if (this.consumesCounters == null) {
      this.consumesCounters = new ArrayList();
    }
    DeviceCounterConsumptionBuilder builder = new DeviceCounterConsumptionBuilder(item);
    if (index < 0 || index >= consumesCounters.size()) {
        _visitables.get("consumesCounters").add(builder);
        consumesCounters.add(builder);
    } else {
        _visitables.get("consumesCounters").add(builder);
        consumesCounters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNodeAllocatableResourceMappings(Map<String,NodeAllocatableResourceMapping> map) {
    if (this.nodeAllocatableResourceMappings == null && map != null) {
      this.nodeAllocatableResourceMappings = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeAllocatableResourceMappings.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeAllocatableResourceMappings(String key,NodeAllocatableResourceMapping value) {
    if (this.nodeAllocatableResourceMappings == null && key != null && value != null) {
      this.nodeAllocatableResourceMappings = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeAllocatableResourceMappings.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTaints(DeviceTaint... items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (DeviceTaint item : items) {
        DeviceTaintBuilder builder = new DeviceTaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public A addToTaints(int index,DeviceTaint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    DeviceTaintBuilder builder = new DeviceTaintBuilder(item);
    if (index < 0 || index >= taints.size()) {
        _visitables.get("taints").add(builder);
        taints.add(builder);
    } else {
        _visitables.get("taints").add(builder);
        taints.add(index, builder);
    }
    return (A) this;
  }
  
  public DeviceCounterConsumption buildConsumesCounter(int index) {
    return this.consumesCounters.get(index).build();
  }
  
  public List<DeviceCounterConsumption> buildConsumesCounters() {
    return this.consumesCounters != null ? build(consumesCounters) : null;
  }
  
  public DeviceCounterConsumption buildFirstConsumesCounter() {
    return this.consumesCounters.get(0).build();
  }
  
  public DeviceTaint buildFirstTaint() {
    return this.taints.get(0).build();
  }
  
  public DeviceCounterConsumption buildLastConsumesCounter() {
    return this.consumesCounters.get(consumesCounters.size() - 1).build();
  }
  
  public DeviceTaint buildLastTaint() {
    return this.taints.get(taints.size() - 1).build();
  }
  
  public DeviceCounterConsumption buildMatchingConsumesCounter(Predicate<DeviceCounterConsumptionBuilder> predicate) {
      for (DeviceCounterConsumptionBuilder item : consumesCounters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceTaint buildMatchingTaint(Predicate<DeviceTaintBuilder> predicate) {
      for (DeviceTaintBuilder item : taints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceTaint buildTaint(int index) {
    return this.taints.get(index).build();
  }
  
  public List<DeviceTaint> buildTaints() {
    return this.taints != null ? build(taints) : null;
  }
  
  protected void copyInstance(Device instance) {
    instance = instance != null ? instance : new Device();
    if (instance != null) {
        this.withAllNodes(instance.getAllNodes());
        this.withAllowMultipleAllocations(instance.getAllowMultipleAllocations());
        this.withAttributes(instance.getAttributes());
        this.withBindingConditions(instance.getBindingConditions());
        this.withBindingFailureConditions(instance.getBindingFailureConditions());
        this.withBindsToNode(instance.getBindsToNode());
        this.withCapacity(instance.getCapacity());
        this.withConsumesCounters(instance.getConsumesCounters());
        this.withName(instance.getName());
        this.withNodeAllocatableResourceMappings(instance.getNodeAllocatableResourceMappings());
        this.withNodeName(instance.getNodeName());
        this.withNodeSelector(instance.getNodeSelector());
        this.withTaints(instance.getTaints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConsumesCountersNested<A> editConsumesCounter(int index) {
    if (consumesCounters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "consumesCounters"));
    }
    return this.setNewConsumesCounterLike(index, this.buildConsumesCounter(index));
  }
  
  public ConsumesCountersNested<A> editFirstConsumesCounter() {
    if (consumesCounters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "consumesCounters"));
    }
    return this.setNewConsumesCounterLike(0, this.buildConsumesCounter(0));
  }
  
  public TaintsNested<A> editFirstTaint() {
    if (taints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(0, this.buildTaint(0));
  }
  
  public ConsumesCountersNested<A> editLastConsumesCounter() {
    int index = consumesCounters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "consumesCounters"));
    }
    return this.setNewConsumesCounterLike(index, this.buildConsumesCounter(index));
  }
  
  public TaintsNested<A> editLastTaint() {
    int index = taints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
  }
  
  public ConsumesCountersNested<A> editMatchingConsumesCounter(Predicate<DeviceCounterConsumptionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < consumesCounters.size();i++) {
      if (predicate.test(consumesCounters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "consumesCounters"));
    }
    return this.setNewConsumesCounterLike(index, this.buildConsumesCounter(index));
  }
  
  public TaintsNested<A> editMatchingTaint(Predicate<DeviceTaintBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < taints.size();i++) {
      if (predicate.test(taints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
  }
  
  public TaintsNested<A> editTaint(int index) {
    if (taints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
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
    DeviceFluent that = (DeviceFluent) o;
    if (!(Objects.equals(allNodes, that.allNodes))) {
      return false;
    }
    if (!(Objects.equals(allowMultipleAllocations, that.allowMultipleAllocations))) {
      return false;
    }
    if (!(Objects.equals(attributes, that.attributes))) {
      return false;
    }
    if (!(Objects.equals(bindingConditions, that.bindingConditions))) {
      return false;
    }
    if (!(Objects.equals(bindingFailureConditions, that.bindingFailureConditions))) {
      return false;
    }
    if (!(Objects.equals(bindsToNode, that.bindsToNode))) {
      return false;
    }
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(consumesCounters, that.consumesCounters))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(nodeAllocatableResourceMappings, that.nodeAllocatableResourceMappings))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(taints, that.taints))) {
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
  
  public Boolean getAllowMultipleAllocations() {
    return this.allowMultipleAllocations;
  }
  
  public Map<String,DeviceAttribute> getAttributes() {
    return this.attributes;
  }
  
  public String getBindingCondition(int index) {
    return this.bindingConditions.get(index);
  }
  
  public List<String> getBindingConditions() {
    return this.bindingConditions;
  }
  
  public String getBindingFailureCondition(int index) {
    return this.bindingFailureConditions.get(index);
  }
  
  public List<String> getBindingFailureConditions() {
    return this.bindingFailureConditions;
  }
  
  public Boolean getBindsToNode() {
    return this.bindsToNode;
  }
  
  public Map<String,DeviceCapacity> getCapacity() {
    return this.capacity;
  }
  
  public String getFirstBindingCondition() {
    return this.bindingConditions.get(0);
  }
  
  public String getFirstBindingFailureCondition() {
    return this.bindingFailureConditions.get(0);
  }
  
  public String getLastBindingCondition() {
    return this.bindingConditions.get(bindingConditions.size() - 1);
  }
  
  public String getLastBindingFailureCondition() {
    return this.bindingFailureConditions.get(bindingFailureConditions.size() - 1);
  }
  
  public String getMatchingBindingCondition(Predicate<String> predicate) {
      for (String item : bindingConditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingBindingFailureCondition(Predicate<String> predicate) {
      for (String item : bindingFailureConditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Map<String,NodeAllocatableResourceMapping> getNodeAllocatableResourceMappings() {
    return this.nodeAllocatableResourceMappings;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public NodeSelector getNodeSelector() {
    return this.nodeSelector;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllNodes() {
    return this.allNodes != null;
  }
  
  public boolean hasAllowMultipleAllocations() {
    return this.allowMultipleAllocations != null;
  }
  
  public boolean hasAttributes() {
    return this.attributes != null;
  }
  
  public boolean hasBindingConditions() {
    return this.bindingConditions != null && !(this.bindingConditions.isEmpty());
  }
  
  public boolean hasBindingFailureConditions() {
    return this.bindingFailureConditions != null && !(this.bindingFailureConditions.isEmpty());
  }
  
  public boolean hasBindsToNode() {
    return this.bindsToNode != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null;
  }
  
  public boolean hasConsumesCounters() {
    return this.consumesCounters != null && !(this.consumesCounters.isEmpty());
  }
  
  public boolean hasMatchingBindingCondition(Predicate<String> predicate) {
      for (String item : bindingConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingBindingFailureCondition(Predicate<String> predicate) {
      for (String item : bindingFailureConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConsumesCounter(Predicate<DeviceCounterConsumptionBuilder> predicate) {
      for (DeviceCounterConsumptionBuilder item : consumesCounters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTaint(Predicate<DeviceTaintBuilder> predicate) {
      for (DeviceTaintBuilder item : taints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNodeAllocatableResourceMappings() {
    return this.nodeAllocatableResourceMappings != null;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasTaints() {
    return this.taints != null && !(this.taints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allNodes, allowMultipleAllocations, attributes, bindingConditions, bindingFailureConditions, bindsToNode, capacity, consumesCounters, name, nodeAllocatableResourceMappings, nodeName, nodeSelector, taints, additionalProperties);
  }
  
  public A removeAllFromBindingConditions(Collection<String> items) {
    if (this.bindingConditions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindingConditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromBindingFailureConditions(Collection<String> items) {
    if (this.bindingFailureConditions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindingFailureConditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConsumesCounters(Collection<DeviceCounterConsumption> items) {
    if (this.consumesCounters == null) {
      return (A) this;
    }
    for (DeviceCounterConsumption item : items) {
        DeviceCounterConsumptionBuilder builder = new DeviceCounterConsumptionBuilder(item);
        _visitables.get("consumesCounters").remove(builder);
        this.consumesCounters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTaints(Collection<DeviceTaint> items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (DeviceTaint item : items) {
        DeviceTaintBuilder builder = new DeviceTaintBuilder(item);
        _visitables.get("taints").remove(builder);
        this.taints.remove(builder);
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
  
  public A removeFromAttributes(String key) {
    if (this.attributes == null) {
      return (A) this;
    }
    if (key != null && this.attributes != null) {
      this.attributes.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAttributes(Map<String,DeviceAttribute> map) {
    if (this.attributes == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.attributes != null) {
          this.attributes.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromBindingConditions(String... items) {
    if (this.bindingConditions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindingConditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromBindingFailureConditions(String... items) {
    if (this.bindingFailureConditions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindingFailureConditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCapacity(String key) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (key != null && this.capacity != null) {
      this.capacity.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCapacity(Map<String,DeviceCapacity> map) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.capacity != null) {
          this.capacity.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConsumesCounters(DeviceCounterConsumption... items) {
    if (this.consumesCounters == null) {
      return (A) this;
    }
    for (DeviceCounterConsumption item : items) {
        DeviceCounterConsumptionBuilder builder = new DeviceCounterConsumptionBuilder(item);
        _visitables.get("consumesCounters").remove(builder);
        this.consumesCounters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNodeAllocatableResourceMappings(String key) {
    if (this.nodeAllocatableResourceMappings == null) {
      return (A) this;
    }
    if (key != null && this.nodeAllocatableResourceMappings != null) {
      this.nodeAllocatableResourceMappings.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeAllocatableResourceMappings(Map<String,NodeAllocatableResourceMapping> map) {
    if (this.nodeAllocatableResourceMappings == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeAllocatableResourceMappings != null) {
          this.nodeAllocatableResourceMappings.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTaints(DeviceTaint... items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (DeviceTaint item : items) {
        DeviceTaintBuilder builder = new DeviceTaintBuilder(item);
        _visitables.get("taints").remove(builder);
        this.taints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConsumesCounters(Predicate<DeviceCounterConsumptionBuilder> predicate) {
    if (consumesCounters == null) {
      return (A) this;
    }
    Iterator<DeviceCounterConsumptionBuilder> each = consumesCounters.iterator();
    List visitables = _visitables.get("consumesCounters");
    while (each.hasNext()) {
        DeviceCounterConsumptionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTaints(Predicate<DeviceTaintBuilder> predicate) {
    if (taints == null) {
      return (A) this;
    }
    Iterator<DeviceTaintBuilder> each = taints.iterator();
    List visitables = _visitables.get("taints");
    while (each.hasNext()) {
        DeviceTaintBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConsumesCountersNested<A> setNewConsumesCounterLike(int index,DeviceCounterConsumption item) {
    return new ConsumesCountersNested(index, item);
  }
  
  public TaintsNested<A> setNewTaintLike(int index,DeviceTaint item) {
    return new TaintsNested(index, item);
  }
  
  public A setToBindingConditions(int index,String item) {
    if (this.bindingConditions == null) {
      this.bindingConditions = new ArrayList();
    }
    this.bindingConditions.set(index, item);
    return (A) this;
  }
  
  public A setToBindingFailureConditions(int index,String item) {
    if (this.bindingFailureConditions == null) {
      this.bindingFailureConditions = new ArrayList();
    }
    this.bindingFailureConditions.set(index, item);
    return (A) this;
  }
  
  public A setToConsumesCounters(int index,DeviceCounterConsumption item) {
    if (this.consumesCounters == null) {
      this.consumesCounters = new ArrayList();
    }
    DeviceCounterConsumptionBuilder builder = new DeviceCounterConsumptionBuilder(item);
    if (index < 0 || index >= consumesCounters.size()) {
        _visitables.get("consumesCounters").add(builder);
        consumesCounters.add(builder);
    } else {
        _visitables.get("consumesCounters").add(builder);
        consumesCounters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTaints(int index,DeviceTaint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    DeviceTaintBuilder builder = new DeviceTaintBuilder(item);
    if (index < 0 || index >= taints.size()) {
        _visitables.get("taints").add(builder);
        taints.add(builder);
    } else {
        _visitables.get("taints").add(builder);
        taints.set(index, builder);
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
    if (!(allowMultipleAllocations == null)) {
        sb.append("allowMultipleAllocations:");
        sb.append(allowMultipleAllocations);
        sb.append(",");
    }
    if (!(attributes == null) && !(attributes.isEmpty())) {
        sb.append("attributes:");
        sb.append(attributes);
        sb.append(",");
    }
    if (!(bindingConditions == null) && !(bindingConditions.isEmpty())) {
        sb.append("bindingConditions:");
        sb.append(bindingConditions);
        sb.append(",");
    }
    if (!(bindingFailureConditions == null) && !(bindingFailureConditions.isEmpty())) {
        sb.append("bindingFailureConditions:");
        sb.append(bindingFailureConditions);
        sb.append(",");
    }
    if (!(bindsToNode == null)) {
        sb.append("bindsToNode:");
        sb.append(bindsToNode);
        sb.append(",");
    }
    if (!(capacity == null) && !(capacity.isEmpty())) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(consumesCounters == null) && !(consumesCounters.isEmpty())) {
        sb.append("consumesCounters:");
        sb.append(consumesCounters);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(nodeAllocatableResourceMappings == null) && !(nodeAllocatableResourceMappings.isEmpty())) {
        sb.append("nodeAllocatableResourceMappings:");
        sb.append(nodeAllocatableResourceMappings);
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
    if (!(taints == null) && !(taints.isEmpty())) {
        sb.append("taints:");
        sb.append(taints);
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
  
  public A withAllowMultipleAllocations() {
    return withAllowMultipleAllocations(true);
  }
  
  public A withAllowMultipleAllocations(Boolean allowMultipleAllocations) {
    this.allowMultipleAllocations = allowMultipleAllocations;
    return (A) this;
  }
  
  public <K,V>A withAttributes(Map<String,DeviceAttribute> attributes) {
    if (attributes == null) {
      this.attributes = null;
    } else {
      this.attributes = new LinkedHashMap(attributes);
    }
    return (A) this;
  }
  
  public A withBindingConditions(List<String> bindingConditions) {
    if (bindingConditions != null) {
        this.bindingConditions = new ArrayList();
        for (String item : bindingConditions) {
          this.addToBindingConditions(item);
        }
    } else {
      this.bindingConditions = null;
    }
    return (A) this;
  }
  
  public A withBindingConditions(String... bindingConditions) {
    if (this.bindingConditions != null) {
        this.bindingConditions.clear();
        _visitables.remove("bindingConditions");
    }
    if (bindingConditions != null) {
      for (String item : bindingConditions) {
        this.addToBindingConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withBindingFailureConditions(List<String> bindingFailureConditions) {
    if (bindingFailureConditions != null) {
        this.bindingFailureConditions = new ArrayList();
        for (String item : bindingFailureConditions) {
          this.addToBindingFailureConditions(item);
        }
    } else {
      this.bindingFailureConditions = null;
    }
    return (A) this;
  }
  
  public A withBindingFailureConditions(String... bindingFailureConditions) {
    if (this.bindingFailureConditions != null) {
        this.bindingFailureConditions.clear();
        _visitables.remove("bindingFailureConditions");
    }
    if (bindingFailureConditions != null) {
      for (String item : bindingFailureConditions) {
        this.addToBindingFailureConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withBindsToNode() {
    return withBindsToNode(true);
  }
  
  public A withBindsToNode(Boolean bindsToNode) {
    this.bindsToNode = bindsToNode;
    return (A) this;
  }
  
  public <K,V>A withCapacity(Map<String,DeviceCapacity> capacity) {
    if (capacity == null) {
      this.capacity = null;
    } else {
      this.capacity = new LinkedHashMap(capacity);
    }
    return (A) this;
  }
  
  public A withConsumesCounters(List<DeviceCounterConsumption> consumesCounters) {
    if (this.consumesCounters != null) {
      this._visitables.get("consumesCounters").clear();
    }
    if (consumesCounters != null) {
        this.consumesCounters = new ArrayList();
        for (DeviceCounterConsumption item : consumesCounters) {
          this.addToConsumesCounters(item);
        }
    } else {
      this.consumesCounters = null;
    }
    return (A) this;
  }
  
  public A withConsumesCounters(DeviceCounterConsumption... consumesCounters) {
    if (this.consumesCounters != null) {
        this.consumesCounters.clear();
        _visitables.remove("consumesCounters");
    }
    if (consumesCounters != null) {
      for (DeviceCounterConsumption item : consumesCounters) {
        this.addToConsumesCounters(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public <K,V>A withNodeAllocatableResourceMappings(Map<String,NodeAllocatableResourceMapping> nodeAllocatableResourceMappings) {
    if (nodeAllocatableResourceMappings == null) {
      this.nodeAllocatableResourceMappings = null;
    } else {
      this.nodeAllocatableResourceMappings = new LinkedHashMap(nodeAllocatableResourceMappings);
    }
    return (A) this;
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withNodeSelector(NodeSelector nodeSelector) {
    this.nodeSelector = nodeSelector;
    return (A) this;
  }
  
  public A withTaints(List<DeviceTaint> taints) {
    if (this.taints != null) {
      this._visitables.get("taints").clear();
    }
    if (taints != null) {
        this.taints = new ArrayList();
        for (DeviceTaint item : taints) {
          this.addToTaints(item);
        }
    } else {
      this.taints = null;
    }
    return (A) this;
  }
  
  public A withTaints(DeviceTaint... taints) {
    if (this.taints != null) {
        this.taints.clear();
        _visitables.remove("taints");
    }
    if (taints != null) {
      for (DeviceTaint item : taints) {
        this.addToTaints(item);
      }
    }
    return (A) this;
  }
  public class ConsumesCountersNested<N> extends DeviceCounterConsumptionFluent<ConsumesCountersNested<N>> implements Nested<N>{
  
    DeviceCounterConsumptionBuilder builder;
    int index;
  
    ConsumesCountersNested(int index,DeviceCounterConsumption item) {
      this.index = index;
      this.builder = new DeviceCounterConsumptionBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceFluent.this.setToConsumesCounters(index, builder.build());
    }
    
    public N endConsumesCounter() {
      return and();
    }
    
  }
  public class TaintsNested<N> extends DeviceTaintFluent<TaintsNested<N>> implements Nested<N>{
  
    DeviceTaintBuilder builder;
    int index;
  
    TaintsNested(int index,DeviceTaint item) {
      this.index = index;
      this.builder = new DeviceTaintBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceFluent.this.setToTaints(index, builder.build());
    }
    
    public N endTaint() {
      return and();
    }
    
  }
}