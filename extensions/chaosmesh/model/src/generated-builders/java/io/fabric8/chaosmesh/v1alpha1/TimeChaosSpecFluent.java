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
public class TimeChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.TimeChaosSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> clockIds = new ArrayList<String>();
  private List<String> containerNames = new ArrayList<String>();
  private String duration;
  private String mode;
  private String remoteCluster;
  private PodSelectorSpecBuilder selector;
  private String timeOffset;
  private String value;

  public TimeChaosSpecFluent() {
  }
  
  public TimeChaosSpecFluent(TimeChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToClockIds(Collection<String> items) {
    if (this.clockIds == null) {
      this.clockIds = new ArrayList();
    }
    for (String item : items) {
      this.clockIds.add(item);
    }
    return (A) this;
  }
  
  public A addAllToContainerNames(Collection<String> items) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    for (String item : items) {
      this.containerNames.add(item);
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
  
  public A addToClockIds(String... items) {
    if (this.clockIds == null) {
      this.clockIds = new ArrayList();
    }
    for (String item : items) {
      this.clockIds.add(item);
    }
    return (A) this;
  }
  
  public A addToClockIds(int index,String item) {
    if (this.clockIds == null) {
      this.clockIds = new ArrayList();
    }
    this.clockIds.add(index, item);
    return (A) this;
  }
  
  public A addToContainerNames(String... items) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    for (String item : items) {
      this.containerNames.add(item);
    }
    return (A) this;
  }
  
  public A addToContainerNames(int index,String item) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    this.containerNames.add(index, item);
    return (A) this;
  }
  
  public PodSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(TimeChaosSpec instance) {
    instance = instance != null ? instance : new TimeChaosSpec();
    if (instance != null) {
        this.withClockIds(instance.getClockIds());
        this.withContainerNames(instance.getContainerNames());
        this.withDuration(instance.getDuration());
        this.withMode(instance.getMode());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withSelector(instance.getSelector());
        this.withTimeOffset(instance.getTimeOffset());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new PodSelectorSpecBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(PodSelectorSpec item) {
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
    TimeChaosSpecFluent that = (TimeChaosSpecFluent) o;
    if (!(Objects.equals(clockIds, that.clockIds))) {
      return false;
    }
    if (!(Objects.equals(containerNames, that.containerNames))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(timeOffset, that.timeOffset))) {
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
  
  public String getClockId(int index) {
    return this.clockIds.get(index);
  }
  
  public List<String> getClockIds() {
    return this.clockIds;
  }
  
  public String getContainerName(int index) {
    return this.containerNames.get(index);
  }
  
  public List<String> getContainerNames() {
    return this.containerNames;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getFirstClockId() {
    return this.clockIds.get(0);
  }
  
  public String getFirstContainerName() {
    return this.containerNames.get(0);
  }
  
  public String getLastClockId() {
    return this.clockIds.get(clockIds.size() - 1);
  }
  
  public String getLastContainerName() {
    return this.containerNames.get(containerNames.size() - 1);
  }
  
  public String getMatchingClockId(Predicate<String> predicate) {
      for (String item : clockIds) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getTimeOffset() {
    return this.timeOffset;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClockIds() {
    return this.clockIds != null && !(this.clockIds.isEmpty());
  }
  
  public boolean hasContainerNames() {
    return this.containerNames != null && !(this.containerNames.isEmpty());
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasMatchingClockId(Predicate<String> predicate) {
      for (String item : clockIds) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTimeOffset() {
    return this.timeOffset != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(clockIds, containerNames, duration, mode, remoteCluster, selector, timeOffset, value, additionalProperties);
  }
  
  public A removeAllFromClockIds(Collection<String> items) {
    if (this.clockIds == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clockIds.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromContainerNames(Collection<String> items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
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
  
  public A removeFromClockIds(String... items) {
    if (this.clockIds == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clockIds.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromContainerNames(String... items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToClockIds(int index,String item) {
    if (this.clockIds == null) {
      this.clockIds = new ArrayList();
    }
    this.clockIds.set(index, item);
    return (A) this;
  }
  
  public A setToContainerNames(int index,String item) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    this.containerNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clockIds == null) && !(clockIds.isEmpty())) {
        sb.append("clockIds:");
        sb.append(clockIds);
        sb.append(",");
    }
    if (!(containerNames == null) && !(containerNames.isEmpty())) {
        sb.append("containerNames:");
        sb.append(containerNames);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(remoteCluster == null)) {
        sb.append("remoteCluster:");
        sb.append(remoteCluster);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(timeOffset == null)) {
        sb.append("timeOffset:");
        sb.append(timeOffset);
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
  
  public A withClockIds(List<String> clockIds) {
    if (clockIds != null) {
        this.clockIds = new ArrayList();
        for (String item : clockIds) {
          this.addToClockIds(item);
        }
    } else {
      this.clockIds = null;
    }
    return (A) this;
  }
  
  public A withClockIds(String... clockIds) {
    if (this.clockIds != null) {
        this.clockIds.clear();
        _visitables.remove("clockIds");
    }
    if (clockIds != null) {
      for (String item : clockIds) {
        this.addToClockIds(item);
      }
    }
    return (A) this;
  }
  
  public A withContainerNames(List<String> containerNames) {
    if (containerNames != null) {
        this.containerNames = new ArrayList();
        for (String item : containerNames) {
          this.addToContainerNames(item);
        }
    } else {
      this.containerNames = null;
    }
    return (A) this;
  }
  
  public A withContainerNames(String... containerNames) {
    if (this.containerNames != null) {
        this.containerNames.clear();
        _visitables.remove("containerNames");
    }
    if (containerNames != null) {
      for (String item : containerNames) {
        this.addToContainerNames(item);
      }
    }
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(PodSelectorSpec item) {
    return new SelectorNested(item);
  }
  
  public A withRemoteCluster(String remoteCluster) {
    this.remoteCluster = remoteCluster;
    return (A) this;
  }
  
  public A withSelector(PodSelectorSpec selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new PodSelectorSpecBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withTimeOffset(String timeOffset) {
    this.timeOffset = timeOffset;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class SelectorNested<N> extends PodSelectorSpecFluent<SelectorNested<N>> implements Nested<N>{
  
    PodSelectorSpecBuilder builder;
  
    SelectorNested(PodSelectorSpec item) {
      this.builder = new PodSelectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TimeChaosSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}