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
public class DNSChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.DNSChaosSpecFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private List<String> containerNames = new ArrayList<String>();
  private String duration;
  private String mode;
  private List<String> patterns = new ArrayList<String>();
  private String remoteCluster;
  private PodSelectorSpecBuilder selector;
  private String value;

  public DNSChaosSpecFluent() {
  }
  
  public DNSChaosSpecFluent(DNSChaosSpec instance) {
    this.copyInstance(instance);
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
  
  public A addAllToPatterns(Collection<String> items) {
    if (this.patterns == null) {
      this.patterns = new ArrayList();
    }
    for (String item : items) {
      this.patterns.add(item);
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
  
  public A addToPatterns(String... items) {
    if (this.patterns == null) {
      this.patterns = new ArrayList();
    }
    for (String item : items) {
      this.patterns.add(item);
    }
    return (A) this;
  }
  
  public A addToPatterns(int index,String item) {
    if (this.patterns == null) {
      this.patterns = new ArrayList();
    }
    this.patterns.add(index, item);
    return (A) this;
  }
  
  public PodSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(DNSChaosSpec instance) {
    instance = instance != null ? instance : new DNSChaosSpec();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withContainerNames(instance.getContainerNames());
        this.withDuration(instance.getDuration());
        this.withMode(instance.getMode());
        this.withPatterns(instance.getPatterns());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withSelector(instance.getSelector());
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
    DNSChaosSpecFluent that = (DNSChaosSpecFluent) o;
    if (!(Objects.equals(action, that.action))) {
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
    if (!(Objects.equals(patterns, that.patterns))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
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
  
  public String getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
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
  
  public String getFirstContainerName() {
    return this.containerNames.get(0);
  }
  
  public String getFirstPattern() {
    return this.patterns.get(0);
  }
  
  public String getLastContainerName() {
    return this.containerNames.get(containerNames.size() - 1);
  }
  
  public String getLastPattern() {
    return this.patterns.get(patterns.size() - 1);
  }
  
  public String getMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPattern(Predicate<String> predicate) {
      for (String item : patterns) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getPattern(int index) {
    return this.patterns.get(index);
  }
  
  public List<String> getPatterns() {
    return this.patterns;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerNames() {
    return this.containerNames != null && !(this.containerNames.isEmpty());
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPattern(Predicate<String> predicate) {
      for (String item : patterns) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPatterns() {
    return this.patterns != null && !(this.patterns.isEmpty());
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, containerNames, duration, mode, patterns, remoteCluster, selector, value, additionalProperties);
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
  
  public A removeAllFromPatterns(Collection<String> items) {
    if (this.patterns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.patterns.remove(item);
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
  
  public A removeFromContainerNames(String... items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPatterns(String... items) {
    if (this.patterns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.patterns.remove(item);
    }
    return (A) this;
  }
  
  public A setToContainerNames(int index,String item) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    this.containerNames.set(index, item);
    return (A) this;
  }
  
  public A setToPatterns(int index,String item) {
    if (this.patterns == null) {
      this.patterns = new ArrayList();
    }
    this.patterns.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
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
    if (!(patterns == null) && !(patterns.isEmpty())) {
        sb.append("patterns:");
        sb.append(patterns);
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
  
  public A withAction(String action) {
    this.action = action;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
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
  
  public A withPatterns(List<String> patterns) {
    if (patterns != null) {
        this.patterns = new ArrayList();
        for (String item : patterns) {
          this.addToPatterns(item);
        }
    } else {
      this.patterns = null;
    }
    return (A) this;
  }
  
  public A withPatterns(String... patterns) {
    if (this.patterns != null) {
        this.patterns.clear();
        _visitables.remove("patterns");
    }
    if (patterns != null) {
      for (String item : patterns) {
        this.addToPatterns(item);
      }
    }
    return (A) this;
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
      return (N) DNSChaosSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}