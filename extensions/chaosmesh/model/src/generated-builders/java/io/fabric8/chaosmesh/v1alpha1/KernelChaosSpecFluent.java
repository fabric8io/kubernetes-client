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
public class KernelChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.KernelChaosSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> containerNames = new ArrayList<String>();
  private String duration;
  private FailKernRequestBuilder failKernRequest;
  private String mode;
  private String remoteCluster;
  private PodSelectorSpecBuilder selector;
  private String value;

  public KernelChaosSpecFluent() {
  }
  
  public KernelChaosSpecFluent(KernelChaosSpec instance) {
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
  
  public FailKernRequest buildFailKernRequest() {
    return this.failKernRequest != null ? this.failKernRequest.build() : null;
  }
  
  public PodSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(KernelChaosSpec instance) {
    instance = instance != null ? instance : new KernelChaosSpec();
    if (instance != null) {
        this.withContainerNames(instance.getContainerNames());
        this.withDuration(instance.getDuration());
        this.withFailKernRequest(instance.getFailKernRequest());
        this.withMode(instance.getMode());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withSelector(instance.getSelector());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FailKernRequestNested<A> editFailKernRequest() {
    return this.withNewFailKernRequestLike(Optional.ofNullable(this.buildFailKernRequest()).orElse(null));
  }
  
  public FailKernRequestNested<A> editOrNewFailKernRequest() {
    return this.withNewFailKernRequestLike(Optional.ofNullable(this.buildFailKernRequest()).orElse(new FailKernRequestBuilder().build()));
  }
  
  public FailKernRequestNested<A> editOrNewFailKernRequestLike(FailKernRequest item) {
    return this.withNewFailKernRequestLike(Optional.ofNullable(this.buildFailKernRequest()).orElse(item));
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
    KernelChaosSpecFluent that = (KernelChaosSpecFluent) o;
    if (!(Objects.equals(containerNames, that.containerNames))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(failKernRequest, that.failKernRequest))) {
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
  
  public String getLastContainerName() {
    return this.containerNames.get(containerNames.size() - 1);
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
  
  public String getValue() {
    return this.value;
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
  
  public boolean hasFailKernRequest() {
    return this.failKernRequest != null;
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
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerNames, duration, failKernRequest, mode, remoteCluster, selector, value, additionalProperties);
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
  
  public A removeFromContainerNames(String... items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(failKernRequest == null)) {
        sb.append("failKernRequest:");
        sb.append(failKernRequest);
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
  
  public A withFailKernRequest(FailKernRequest failKernRequest) {
    this._visitables.remove("failKernRequest");
    if (failKernRequest != null) {
        this.failKernRequest = new FailKernRequestBuilder(failKernRequest);
        this._visitables.get("failKernRequest").add(this.failKernRequest);
    } else {
        this.failKernRequest = null;
        this._visitables.get("failKernRequest").remove(this.failKernRequest);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public FailKernRequestNested<A> withNewFailKernRequest() {
    return new FailKernRequestNested(null);
  }
  
  public FailKernRequestNested<A> withNewFailKernRequestLike(FailKernRequest item) {
    return new FailKernRequestNested(item);
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
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class FailKernRequestNested<N> extends FailKernRequestFluent<FailKernRequestNested<N>> implements Nested<N>{
  
    FailKernRequestBuilder builder;
  
    FailKernRequestNested(FailKernRequest item) {
      this.builder = new FailKernRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) KernelChaosSpecFluent.this.withFailKernRequest(builder.build());
    }
    
    public N endFailKernRequest() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends PodSelectorSpecFluent<SelectorNested<N>> implements Nested<N>{
  
    PodSelectorSpecBuilder builder;
  
    SelectorNested(PodSelectorSpec item) {
      this.builder = new PodSelectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KernelChaosSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}