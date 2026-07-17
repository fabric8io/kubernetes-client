package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import io.fabric8.kubernetes.api.model.Toleration;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
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
public class ImagePrunerSpecFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImagePrunerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Affinity affinity;
  private Integer failedJobsHistoryLimit;
  private Boolean ignoreInvalidImageReferences;
  private Integer keepTagRevisions;
  private Long keepYoungerThan;
  private String keepYoungerThanDuration;
  private String logLevel;
  private Map<String,String> nodeSelector;
  private ResourceRequirementsBuilder resources;
  private String schedule;
  private Integer successfulJobsHistoryLimit;
  private Boolean suspend;
  private List<Toleration> tolerations = new ArrayList<Toleration>();

  public ImagePrunerSpecFluent() {
  }
  
  public ImagePrunerSpecFluent(ImagePrunerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  protected void copyInstance(ImagePrunerSpec instance) {
    instance = instance != null ? instance : new ImagePrunerSpec();
    if (instance != null) {
        this.withAffinity(instance.getAffinity());
        this.withFailedJobsHistoryLimit(instance.getFailedJobsHistoryLimit());
        this.withIgnoreInvalidImageReferences(instance.getIgnoreInvalidImageReferences());
        this.withKeepTagRevisions(instance.getKeepTagRevisions());
        this.withKeepYoungerThan(instance.getKeepYoungerThan());
        this.withKeepYoungerThanDuration(instance.getKeepYoungerThanDuration());
        this.withLogLevel(instance.getLogLevel());
        this.withNodeSelector(instance.getNodeSelector());
        this.withResources(instance.getResources());
        this.withSchedule(instance.getSchedule());
        this.withSuccessfulJobsHistoryLimit(instance.getSuccessfulJobsHistoryLimit());
        this.withSuspend(instance.getSuspend());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
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
    ImagePrunerSpecFluent that = (ImagePrunerSpecFluent) o;
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(failedJobsHistoryLimit, that.failedJobsHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(ignoreInvalidImageReferences, that.ignoreInvalidImageReferences))) {
      return false;
    }
    if (!(Objects.equals(keepTagRevisions, that.keepTagRevisions))) {
      return false;
    }
    if (!(Objects.equals(keepYoungerThan, that.keepYoungerThan))) {
      return false;
    }
    if (!(Objects.equals(keepYoungerThanDuration, that.keepYoungerThanDuration))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(schedule, that.schedule))) {
      return false;
    }
    if (!(Objects.equals(successfulJobsHistoryLimit, that.successfulJobsHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(suspend, that.suspend))) {
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
  
  public Affinity getAffinity() {
    return this.affinity;
  }
  
  public Integer getFailedJobsHistoryLimit() {
    return this.failedJobsHistoryLimit;
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public Boolean getIgnoreInvalidImageReferences() {
    return this.ignoreInvalidImageReferences;
  }
  
  public Integer getKeepTagRevisions() {
    return this.keepTagRevisions;
  }
  
  public Long getKeepYoungerThan() {
    return this.keepYoungerThan;
  }
  
  public String getKeepYoungerThanDuration() {
    return this.keepYoungerThanDuration;
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public String getSchedule() {
    return this.schedule;
  }
  
  public Integer getSuccessfulJobsHistoryLimit() {
    return this.successfulJobsHistoryLimit;
  }
  
  public Boolean getSuspend() {
    return this.suspend;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasFailedJobsHistoryLimit() {
    return this.failedJobsHistoryLimit != null;
  }
  
  public boolean hasIgnoreInvalidImageReferences() {
    return this.ignoreInvalidImageReferences != null;
  }
  
  public boolean hasKeepTagRevisions() {
    return this.keepTagRevisions != null;
  }
  
  public boolean hasKeepYoungerThan() {
    return this.keepYoungerThan != null;
  }
  
  public boolean hasKeepYoungerThanDuration() {
    return this.keepYoungerThanDuration != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasSchedule() {
    return this.schedule != null;
  }
  
  public boolean hasSuccessfulJobsHistoryLimit() {
    return this.successfulJobsHistoryLimit != null;
  }
  
  public boolean hasSuspend() {
    return this.suspend != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(affinity, failedJobsHistoryLimit, ignoreInvalidImageReferences, keepTagRevisions, keepYoungerThan, keepYoungerThanDuration, logLevel, nodeSelector, resources, schedule, successfulJobsHistoryLimit, suspend, tolerations, additionalProperties);
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(failedJobsHistoryLimit == null)) {
        sb.append("failedJobsHistoryLimit:");
        sb.append(failedJobsHistoryLimit);
        sb.append(",");
    }
    if (!(ignoreInvalidImageReferences == null)) {
        sb.append("ignoreInvalidImageReferences:");
        sb.append(ignoreInvalidImageReferences);
        sb.append(",");
    }
    if (!(keepTagRevisions == null)) {
        sb.append("keepTagRevisions:");
        sb.append(keepTagRevisions);
        sb.append(",");
    }
    if (!(keepYoungerThan == null)) {
        sb.append("keepYoungerThan:");
        sb.append(keepYoungerThan);
        sb.append(",");
    }
    if (!(keepYoungerThanDuration == null)) {
        sb.append("keepYoungerThanDuration:");
        sb.append(keepYoungerThanDuration);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(schedule == null)) {
        sb.append("schedule:");
        sb.append(schedule);
        sb.append(",");
    }
    if (!(successfulJobsHistoryLimit == null)) {
        sb.append("successfulJobsHistoryLimit:");
        sb.append(successfulJobsHistoryLimit);
        sb.append(",");
    }
    if (!(suspend == null)) {
        sb.append("suspend:");
        sb.append(suspend);
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
  
  public A withAffinity(Affinity affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withFailedJobsHistoryLimit(Integer failedJobsHistoryLimit) {
    this.failedJobsHistoryLimit = failedJobsHistoryLimit;
    return (A) this;
  }
  
  public A withIgnoreInvalidImageReferences() {
    return withIgnoreInvalidImageReferences(true);
  }
  
  public A withIgnoreInvalidImageReferences(Boolean ignoreInvalidImageReferences) {
    this.ignoreInvalidImageReferences = ignoreInvalidImageReferences;
    return (A) this;
  }
  
  public A withKeepTagRevisions(Integer keepTagRevisions) {
    this.keepTagRevisions = keepTagRevisions;
    return (A) this;
  }
  
  public A withKeepYoungerThan(Long keepYoungerThan) {
    this.keepYoungerThan = keepYoungerThan;
    return (A) this;
  }
  
  public A withKeepYoungerThanDuration(String keepYoungerThanDuration) {
    this.keepYoungerThanDuration = keepYoungerThanDuration;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withSchedule(String schedule) {
    this.schedule = schedule;
    return (A) this;
  }
  
  public A withSuccessfulJobsHistoryLimit(Integer successfulJobsHistoryLimit) {
    this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
    return (A) this;
  }
  
  public A withSuspend() {
    return withSuspend(true);
  }
  
  public A withSuspend(Boolean suspend) {
    this.suspend = suspend;
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImagePrunerSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
}