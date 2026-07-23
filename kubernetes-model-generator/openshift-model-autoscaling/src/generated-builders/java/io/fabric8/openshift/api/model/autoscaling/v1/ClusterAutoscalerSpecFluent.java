package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ClusterAutoscalerSpecFluent<A extends io.fabric8.openshift.api.model.autoscaling.v1.ClusterAutoscalerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean balanceSimilarNodeGroups;
  private List<String> balancingIgnoredLabels = new ArrayList<String>();
  private List<String> expanders = new ArrayList<String>();
  private Boolean ignoreDaemonsetsUtilization;
  private Integer logVerbosity;
  private String maxNodeProvisionTime;
  private Integer maxPodGracePeriod;
  private Integer podPriorityThreshold;
  private ClusterAutoscalerSpecResourceLimitsBuilder resourceLimits;
  private ClusterAutoscalerSpecScaleDownBuilder scaleDown;
  private ClusterAutoscalerSpecScaleUpBuilder scaleUp;
  private Boolean skipNodesWithLocalStorage;

  public ClusterAutoscalerSpecFluent() {
  }
  
  public ClusterAutoscalerSpecFluent(ClusterAutoscalerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToBalancingIgnoredLabels(Collection<String> items) {
    if (this.balancingIgnoredLabels == null) {
      this.balancingIgnoredLabels = new ArrayList();
    }
    for (String item : items) {
      this.balancingIgnoredLabels.add(item);
    }
    return (A) this;
  }
  
  public A addAllToExpanders(Collection<String> items) {
    if (this.expanders == null) {
      this.expanders = new ArrayList();
    }
    for (String item : items) {
      this.expanders.add(item);
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
  
  public A addToBalancingIgnoredLabels(String... items) {
    if (this.balancingIgnoredLabels == null) {
      this.balancingIgnoredLabels = new ArrayList();
    }
    for (String item : items) {
      this.balancingIgnoredLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToBalancingIgnoredLabels(int index,String item) {
    if (this.balancingIgnoredLabels == null) {
      this.balancingIgnoredLabels = new ArrayList();
    }
    this.balancingIgnoredLabels.add(index, item);
    return (A) this;
  }
  
  public A addToExpanders(String... items) {
    if (this.expanders == null) {
      this.expanders = new ArrayList();
    }
    for (String item : items) {
      this.expanders.add(item);
    }
    return (A) this;
  }
  
  public A addToExpanders(int index,String item) {
    if (this.expanders == null) {
      this.expanders = new ArrayList();
    }
    this.expanders.add(index, item);
    return (A) this;
  }
  
  public ClusterAutoscalerSpecResourceLimits buildResourceLimits() {
    return this.resourceLimits != null ? this.resourceLimits.build() : null;
  }
  
  public ClusterAutoscalerSpecScaleDown buildScaleDown() {
    return this.scaleDown != null ? this.scaleDown.build() : null;
  }
  
  public ClusterAutoscalerSpecScaleUp buildScaleUp() {
    return this.scaleUp != null ? this.scaleUp.build() : null;
  }
  
  protected void copyInstance(ClusterAutoscalerSpec instance) {
    instance = instance != null ? instance : new ClusterAutoscalerSpec();
    if (instance != null) {
        this.withBalanceSimilarNodeGroups(instance.getBalanceSimilarNodeGroups());
        this.withBalancingIgnoredLabels(instance.getBalancingIgnoredLabels());
        this.withExpanders(instance.getExpanders());
        this.withIgnoreDaemonsetsUtilization(instance.getIgnoreDaemonsetsUtilization());
        this.withLogVerbosity(instance.getLogVerbosity());
        this.withMaxNodeProvisionTime(instance.getMaxNodeProvisionTime());
        this.withMaxPodGracePeriod(instance.getMaxPodGracePeriod());
        this.withPodPriorityThreshold(instance.getPodPriorityThreshold());
        this.withResourceLimits(instance.getResourceLimits());
        this.withScaleDown(instance.getScaleDown());
        this.withScaleUp(instance.getScaleUp());
        this.withSkipNodesWithLocalStorage(instance.getSkipNodesWithLocalStorage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceLimitsNested<A> editOrNewResourceLimits() {
    return this.withNewResourceLimitsLike(Optional.ofNullable(this.buildResourceLimits()).orElse(new ClusterAutoscalerSpecResourceLimitsBuilder().build()));
  }
  
  public ResourceLimitsNested<A> editOrNewResourceLimitsLike(ClusterAutoscalerSpecResourceLimits item) {
    return this.withNewResourceLimitsLike(Optional.ofNullable(this.buildResourceLimits()).orElse(item));
  }
  
  public ScaleDownNested<A> editOrNewScaleDown() {
    return this.withNewScaleDownLike(Optional.ofNullable(this.buildScaleDown()).orElse(new ClusterAutoscalerSpecScaleDownBuilder().build()));
  }
  
  public ScaleDownNested<A> editOrNewScaleDownLike(ClusterAutoscalerSpecScaleDown item) {
    return this.withNewScaleDownLike(Optional.ofNullable(this.buildScaleDown()).orElse(item));
  }
  
  public ScaleUpNested<A> editOrNewScaleUp() {
    return this.withNewScaleUpLike(Optional.ofNullable(this.buildScaleUp()).orElse(new ClusterAutoscalerSpecScaleUpBuilder().build()));
  }
  
  public ScaleUpNested<A> editOrNewScaleUpLike(ClusterAutoscalerSpecScaleUp item) {
    return this.withNewScaleUpLike(Optional.ofNullable(this.buildScaleUp()).orElse(item));
  }
  
  public ResourceLimitsNested<A> editResourceLimits() {
    return this.withNewResourceLimitsLike(Optional.ofNullable(this.buildResourceLimits()).orElse(null));
  }
  
  public ScaleDownNested<A> editScaleDown() {
    return this.withNewScaleDownLike(Optional.ofNullable(this.buildScaleDown()).orElse(null));
  }
  
  public ScaleUpNested<A> editScaleUp() {
    return this.withNewScaleUpLike(Optional.ofNullable(this.buildScaleUp()).orElse(null));
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
    ClusterAutoscalerSpecFluent that = (ClusterAutoscalerSpecFluent) o;
    if (!(Objects.equals(balanceSimilarNodeGroups, that.balanceSimilarNodeGroups))) {
      return false;
    }
    if (!(Objects.equals(balancingIgnoredLabels, that.balancingIgnoredLabels))) {
      return false;
    }
    if (!(Objects.equals(expanders, that.expanders))) {
      return false;
    }
    if (!(Objects.equals(ignoreDaemonsetsUtilization, that.ignoreDaemonsetsUtilization))) {
      return false;
    }
    if (!(Objects.equals(logVerbosity, that.logVerbosity))) {
      return false;
    }
    if (!(Objects.equals(maxNodeProvisionTime, that.maxNodeProvisionTime))) {
      return false;
    }
    if (!(Objects.equals(maxPodGracePeriod, that.maxPodGracePeriod))) {
      return false;
    }
    if (!(Objects.equals(podPriorityThreshold, that.podPriorityThreshold))) {
      return false;
    }
    if (!(Objects.equals(resourceLimits, that.resourceLimits))) {
      return false;
    }
    if (!(Objects.equals(scaleDown, that.scaleDown))) {
      return false;
    }
    if (!(Objects.equals(scaleUp, that.scaleUp))) {
      return false;
    }
    if (!(Objects.equals(skipNodesWithLocalStorage, that.skipNodesWithLocalStorage))) {
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
  
  public Boolean getBalanceSimilarNodeGroups() {
    return this.balanceSimilarNodeGroups;
  }
  
  public String getBalancingIgnoredLabel(int index) {
    return this.balancingIgnoredLabels.get(index);
  }
  
  public List<String> getBalancingIgnoredLabels() {
    return this.balancingIgnoredLabels;
  }
  
  public String getExpander(int index) {
    return this.expanders.get(index);
  }
  
  public List<String> getExpanders() {
    return this.expanders;
  }
  
  public String getFirstBalancingIgnoredLabel() {
    return this.balancingIgnoredLabels.get(0);
  }
  
  public String getFirstExpander() {
    return this.expanders.get(0);
  }
  
  public Boolean getIgnoreDaemonsetsUtilization() {
    return this.ignoreDaemonsetsUtilization;
  }
  
  public String getLastBalancingIgnoredLabel() {
    return this.balancingIgnoredLabels.get(balancingIgnoredLabels.size() - 1);
  }
  
  public String getLastExpander() {
    return this.expanders.get(expanders.size() - 1);
  }
  
  public Integer getLogVerbosity() {
    return this.logVerbosity;
  }
  
  public String getMatchingBalancingIgnoredLabel(Predicate<String> predicate) {
      for (String item : balancingIgnoredLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingExpander(Predicate<String> predicate) {
      for (String item : expanders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMaxNodeProvisionTime() {
    return this.maxNodeProvisionTime;
  }
  
  public Integer getMaxPodGracePeriod() {
    return this.maxPodGracePeriod;
  }
  
  public Integer getPodPriorityThreshold() {
    return this.podPriorityThreshold;
  }
  
  public Boolean getSkipNodesWithLocalStorage() {
    return this.skipNodesWithLocalStorage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBalanceSimilarNodeGroups() {
    return this.balanceSimilarNodeGroups != null;
  }
  
  public boolean hasBalancingIgnoredLabels() {
    return this.balancingIgnoredLabels != null && !(this.balancingIgnoredLabels.isEmpty());
  }
  
  public boolean hasExpanders() {
    return this.expanders != null && !(this.expanders.isEmpty());
  }
  
  public boolean hasIgnoreDaemonsetsUtilization() {
    return this.ignoreDaemonsetsUtilization != null;
  }
  
  public boolean hasLogVerbosity() {
    return this.logVerbosity != null;
  }
  
  public boolean hasMatchingBalancingIgnoredLabel(Predicate<String> predicate) {
      for (String item : balancingIgnoredLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingExpander(Predicate<String> predicate) {
      for (String item : expanders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxNodeProvisionTime() {
    return this.maxNodeProvisionTime != null;
  }
  
  public boolean hasMaxPodGracePeriod() {
    return this.maxPodGracePeriod != null;
  }
  
  public boolean hasPodPriorityThreshold() {
    return this.podPriorityThreshold != null;
  }
  
  public boolean hasResourceLimits() {
    return this.resourceLimits != null;
  }
  
  public boolean hasScaleDown() {
    return this.scaleDown != null;
  }
  
  public boolean hasScaleUp() {
    return this.scaleUp != null;
  }
  
  public boolean hasSkipNodesWithLocalStorage() {
    return this.skipNodesWithLocalStorage != null;
  }
  
  public int hashCode() {
    return Objects.hash(balanceSimilarNodeGroups, balancingIgnoredLabels, expanders, ignoreDaemonsetsUtilization, logVerbosity, maxNodeProvisionTime, maxPodGracePeriod, podPriorityThreshold, resourceLimits, scaleDown, scaleUp, skipNodesWithLocalStorage, additionalProperties);
  }
  
  public A removeAllFromBalancingIgnoredLabels(Collection<String> items) {
    if (this.balancingIgnoredLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.balancingIgnoredLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromExpanders(Collection<String> items) {
    if (this.expanders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.expanders.remove(item);
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
  
  public A removeFromBalancingIgnoredLabels(String... items) {
    if (this.balancingIgnoredLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.balancingIgnoredLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromExpanders(String... items) {
    if (this.expanders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.expanders.remove(item);
    }
    return (A) this;
  }
  
  public A setToBalancingIgnoredLabels(int index,String item) {
    if (this.balancingIgnoredLabels == null) {
      this.balancingIgnoredLabels = new ArrayList();
    }
    this.balancingIgnoredLabels.set(index, item);
    return (A) this;
  }
  
  public A setToExpanders(int index,String item) {
    if (this.expanders == null) {
      this.expanders = new ArrayList();
    }
    this.expanders.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(balanceSimilarNodeGroups == null)) {
        sb.append("balanceSimilarNodeGroups:");
        sb.append(balanceSimilarNodeGroups);
        sb.append(",");
    }
    if (!(balancingIgnoredLabels == null) && !(balancingIgnoredLabels.isEmpty())) {
        sb.append("balancingIgnoredLabels:");
        sb.append(balancingIgnoredLabels);
        sb.append(",");
    }
    if (!(expanders == null) && !(expanders.isEmpty())) {
        sb.append("expanders:");
        sb.append(expanders);
        sb.append(",");
    }
    if (!(ignoreDaemonsetsUtilization == null)) {
        sb.append("ignoreDaemonsetsUtilization:");
        sb.append(ignoreDaemonsetsUtilization);
        sb.append(",");
    }
    if (!(logVerbosity == null)) {
        sb.append("logVerbosity:");
        sb.append(logVerbosity);
        sb.append(",");
    }
    if (!(maxNodeProvisionTime == null)) {
        sb.append("maxNodeProvisionTime:");
        sb.append(maxNodeProvisionTime);
        sb.append(",");
    }
    if (!(maxPodGracePeriod == null)) {
        sb.append("maxPodGracePeriod:");
        sb.append(maxPodGracePeriod);
        sb.append(",");
    }
    if (!(podPriorityThreshold == null)) {
        sb.append("podPriorityThreshold:");
        sb.append(podPriorityThreshold);
        sb.append(",");
    }
    if (!(resourceLimits == null)) {
        sb.append("resourceLimits:");
        sb.append(resourceLimits);
        sb.append(",");
    }
    if (!(scaleDown == null)) {
        sb.append("scaleDown:");
        sb.append(scaleDown);
        sb.append(",");
    }
    if (!(scaleUp == null)) {
        sb.append("scaleUp:");
        sb.append(scaleUp);
        sb.append(",");
    }
    if (!(skipNodesWithLocalStorage == null)) {
        sb.append("skipNodesWithLocalStorage:");
        sb.append(skipNodesWithLocalStorage);
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
  
  public A withBalanceSimilarNodeGroups() {
    return withBalanceSimilarNodeGroups(true);
  }
  
  public A withBalanceSimilarNodeGroups(Boolean balanceSimilarNodeGroups) {
    this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
    return (A) this;
  }
  
  public A withBalancingIgnoredLabels(List<String> balancingIgnoredLabels) {
    if (balancingIgnoredLabels != null) {
        this.balancingIgnoredLabels = new ArrayList();
        for (String item : balancingIgnoredLabels) {
          this.addToBalancingIgnoredLabels(item);
        }
    } else {
      this.balancingIgnoredLabels = null;
    }
    return (A) this;
  }
  
  public A withBalancingIgnoredLabels(String... balancingIgnoredLabels) {
    if (this.balancingIgnoredLabels != null) {
        this.balancingIgnoredLabels.clear();
        _visitables.remove("balancingIgnoredLabels");
    }
    if (balancingIgnoredLabels != null) {
      for (String item : balancingIgnoredLabels) {
        this.addToBalancingIgnoredLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withExpanders(List<String> expanders) {
    if (expanders != null) {
        this.expanders = new ArrayList();
        for (String item : expanders) {
          this.addToExpanders(item);
        }
    } else {
      this.expanders = null;
    }
    return (A) this;
  }
  
  public A withExpanders(String... expanders) {
    if (this.expanders != null) {
        this.expanders.clear();
        _visitables.remove("expanders");
    }
    if (expanders != null) {
      for (String item : expanders) {
        this.addToExpanders(item);
      }
    }
    return (A) this;
  }
  
  public A withIgnoreDaemonsetsUtilization() {
    return withIgnoreDaemonsetsUtilization(true);
  }
  
  public A withIgnoreDaemonsetsUtilization(Boolean ignoreDaemonsetsUtilization) {
    this.ignoreDaemonsetsUtilization = ignoreDaemonsetsUtilization;
    return (A) this;
  }
  
  public A withLogVerbosity(Integer logVerbosity) {
    this.logVerbosity = logVerbosity;
    return (A) this;
  }
  
  public A withMaxNodeProvisionTime(String maxNodeProvisionTime) {
    this.maxNodeProvisionTime = maxNodeProvisionTime;
    return (A) this;
  }
  
  public A withMaxPodGracePeriod(Integer maxPodGracePeriod) {
    this.maxPodGracePeriod = maxPodGracePeriod;
    return (A) this;
  }
  
  public ResourceLimitsNested<A> withNewResourceLimits() {
    return new ResourceLimitsNested(null);
  }
  
  public ResourceLimitsNested<A> withNewResourceLimitsLike(ClusterAutoscalerSpecResourceLimits item) {
    return new ResourceLimitsNested(item);
  }
  
  public ScaleDownNested<A> withNewScaleDown() {
    return new ScaleDownNested(null);
  }
  
  public ScaleDownNested<A> withNewScaleDownLike(ClusterAutoscalerSpecScaleDown item) {
    return new ScaleDownNested(item);
  }
  
  public ScaleUpNested<A> withNewScaleUp() {
    return new ScaleUpNested(null);
  }
  
  public A withNewScaleUp(String newPodScaleUpDelay) {
    return (A) this.withScaleUp(new ClusterAutoscalerSpecScaleUp(newPodScaleUpDelay));
  }
  
  public ScaleUpNested<A> withNewScaleUpLike(ClusterAutoscalerSpecScaleUp item) {
    return new ScaleUpNested(item);
  }
  
  public A withPodPriorityThreshold(Integer podPriorityThreshold) {
    this.podPriorityThreshold = podPriorityThreshold;
    return (A) this;
  }
  
  public A withResourceLimits(ClusterAutoscalerSpecResourceLimits resourceLimits) {
    this._visitables.remove("resourceLimits");
    if (resourceLimits != null) {
        this.resourceLimits = new ClusterAutoscalerSpecResourceLimitsBuilder(resourceLimits);
        this._visitables.get("resourceLimits").add(this.resourceLimits);
    } else {
        this.resourceLimits = null;
        this._visitables.get("resourceLimits").remove(this.resourceLimits);
    }
    return (A) this;
  }
  
  public A withScaleDown(ClusterAutoscalerSpecScaleDown scaleDown) {
    this._visitables.remove("scaleDown");
    if (scaleDown != null) {
        this.scaleDown = new ClusterAutoscalerSpecScaleDownBuilder(scaleDown);
        this._visitables.get("scaleDown").add(this.scaleDown);
    } else {
        this.scaleDown = null;
        this._visitables.get("scaleDown").remove(this.scaleDown);
    }
    return (A) this;
  }
  
  public A withScaleUp(ClusterAutoscalerSpecScaleUp scaleUp) {
    this._visitables.remove("scaleUp");
    if (scaleUp != null) {
        this.scaleUp = new ClusterAutoscalerSpecScaleUpBuilder(scaleUp);
        this._visitables.get("scaleUp").add(this.scaleUp);
    } else {
        this.scaleUp = null;
        this._visitables.get("scaleUp").remove(this.scaleUp);
    }
    return (A) this;
  }
  
  public A withSkipNodesWithLocalStorage() {
    return withSkipNodesWithLocalStorage(true);
  }
  
  public A withSkipNodesWithLocalStorage(Boolean skipNodesWithLocalStorage) {
    this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
    return (A) this;
  }
  public class ResourceLimitsNested<N> extends ClusterAutoscalerSpecResourceLimitsFluent<ResourceLimitsNested<N>> implements Nested<N>{
  
    ClusterAutoscalerSpecResourceLimitsBuilder builder;
  
    ResourceLimitsNested(ClusterAutoscalerSpecResourceLimits item) {
      this.builder = new ClusterAutoscalerSpecResourceLimitsBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAutoscalerSpecFluent.this.withResourceLimits(builder.build());
    }
    
    public N endResourceLimits() {
      return and();
    }
    
  }
  public class ScaleDownNested<N> extends ClusterAutoscalerSpecScaleDownFluent<ScaleDownNested<N>> implements Nested<N>{
  
    ClusterAutoscalerSpecScaleDownBuilder builder;
  
    ScaleDownNested(ClusterAutoscalerSpecScaleDown item) {
      this.builder = new ClusterAutoscalerSpecScaleDownBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAutoscalerSpecFluent.this.withScaleDown(builder.build());
    }
    
    public N endScaleDown() {
      return and();
    }
    
  }
  public class ScaleUpNested<N> extends ClusterAutoscalerSpecScaleUpFluent<ScaleUpNested<N>> implements Nested<N>{
  
    ClusterAutoscalerSpecScaleUpBuilder builder;
  
    ScaleUpNested(ClusterAutoscalerSpecScaleUp item) {
      this.builder = new ClusterAutoscalerSpecScaleUpBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAutoscalerSpecFluent.this.withScaleUp(builder.build());
    }
    
    public N endScaleUp() {
      return and();
    }
    
  }
}