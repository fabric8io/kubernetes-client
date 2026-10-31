package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupDisruptionMode;
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupResourceClaim;
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupSchedulingConstraints;
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupSchedulingPolicy;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class JobSchedulingConfigurationFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.JobSchedulingConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WorkloadPodGroupDisruptionMode disruptionMode;
  private List<WorkloadPodGroupResourceClaim> resourceClaims = new ArrayList<WorkloadPodGroupResourceClaim>();
  private WorkloadPodGroupSchedulingConstraints schedulingConstraints;
  private WorkloadPodGroupSchedulingPolicy schedulingPolicy;

  public JobSchedulingConfigurationFluent() {
  }
  
  public JobSchedulingConfigurationFluent(JobSchedulingConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourceClaims(Collection<WorkloadPodGroupResourceClaim> items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (WorkloadPodGroupResourceClaim item : items) {
      this.resourceClaims.add(item);
    }
    return (A) this;
  }
  
  public A addNewResourceClaim(String name,String resourceClaimName,String resourceClaimTemplateName) {
    return (A) this.addToResourceClaims(new WorkloadPodGroupResourceClaim(name, resourceClaimName, resourceClaimTemplateName));
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
  
  public A addToResourceClaims(WorkloadPodGroupResourceClaim... items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (WorkloadPodGroupResourceClaim item : items) {
      this.resourceClaims.add(item);
    }
    return (A) this;
  }
  
  public A addToResourceClaims(int index,WorkloadPodGroupResourceClaim item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    this.resourceClaims.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(JobSchedulingConfiguration instance) {
    instance = instance != null ? instance : new JobSchedulingConfiguration();
    if (instance != null) {
        this.withDisruptionMode(instance.getDisruptionMode());
        this.withResourceClaims(instance.getResourceClaims());
        this.withSchedulingConstraints(instance.getSchedulingConstraints());
        this.withSchedulingPolicy(instance.getSchedulingPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    JobSchedulingConfigurationFluent that = (JobSchedulingConfigurationFluent) o;
    if (!(Objects.equals(disruptionMode, that.disruptionMode))) {
      return false;
    }
    if (!(Objects.equals(resourceClaims, that.resourceClaims))) {
      return false;
    }
    if (!(Objects.equals(schedulingConstraints, that.schedulingConstraints))) {
      return false;
    }
    if (!(Objects.equals(schedulingPolicy, that.schedulingPolicy))) {
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
  
  public WorkloadPodGroupDisruptionMode getDisruptionMode() {
    return this.disruptionMode;
  }
  
  public WorkloadPodGroupResourceClaim getFirstResourceClaim() {
    return this.resourceClaims.get(0);
  }
  
  public WorkloadPodGroupResourceClaim getLastResourceClaim() {
    return this.resourceClaims.get(resourceClaims.size() - 1);
  }
  
  public WorkloadPodGroupResourceClaim getMatchingResourceClaim(Predicate<WorkloadPodGroupResourceClaim> predicate) {
      for (WorkloadPodGroupResourceClaim item : resourceClaims) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public WorkloadPodGroupResourceClaim getResourceClaim(int index) {
    return this.resourceClaims.get(index);
  }
  
  public List<WorkloadPodGroupResourceClaim> getResourceClaims() {
    return this.resourceClaims;
  }
  
  public WorkloadPodGroupSchedulingConstraints getSchedulingConstraints() {
    return this.schedulingConstraints;
  }
  
  public WorkloadPodGroupSchedulingPolicy getSchedulingPolicy() {
    return this.schedulingPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisruptionMode() {
    return this.disruptionMode != null;
  }
  
  public boolean hasMatchingResourceClaim(Predicate<WorkloadPodGroupResourceClaim> predicate) {
      for (WorkloadPodGroupResourceClaim item : resourceClaims) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResourceClaims() {
    return this.resourceClaims != null && !(this.resourceClaims.isEmpty());
  }
  
  public boolean hasSchedulingConstraints() {
    return this.schedulingConstraints != null;
  }
  
  public boolean hasSchedulingPolicy() {
    return this.schedulingPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(disruptionMode, resourceClaims, schedulingConstraints, schedulingPolicy, additionalProperties);
  }
  
  public A removeAllFromResourceClaims(Collection<WorkloadPodGroupResourceClaim> items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (WorkloadPodGroupResourceClaim item : items) {
      this.resourceClaims.remove(item);
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
  
  public A removeFromResourceClaims(WorkloadPodGroupResourceClaim... items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (WorkloadPodGroupResourceClaim item : items) {
      this.resourceClaims.remove(item);
    }
    return (A) this;
  }
  
  public A setToResourceClaims(int index,WorkloadPodGroupResourceClaim item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    this.resourceClaims.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disruptionMode == null)) {
        sb.append("disruptionMode:");
        sb.append(disruptionMode);
        sb.append(",");
    }
    if (!(resourceClaims == null) && !(resourceClaims.isEmpty())) {
        sb.append("resourceClaims:");
        sb.append(resourceClaims);
        sb.append(",");
    }
    if (!(schedulingConstraints == null)) {
        sb.append("schedulingConstraints:");
        sb.append(schedulingConstraints);
        sb.append(",");
    }
    if (!(schedulingPolicy == null)) {
        sb.append("schedulingPolicy:");
        sb.append(schedulingPolicy);
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
  
  public A withDisruptionMode(WorkloadPodGroupDisruptionMode disruptionMode) {
    this.disruptionMode = disruptionMode;
    return (A) this;
  }
  
  public A withResourceClaims(List<WorkloadPodGroupResourceClaim> resourceClaims) {
    if (resourceClaims != null) {
        this.resourceClaims = new ArrayList();
        for (WorkloadPodGroupResourceClaim item : resourceClaims) {
          this.addToResourceClaims(item);
        }
    } else {
      this.resourceClaims = null;
    }
    return (A) this;
  }
  
  public A withResourceClaims(WorkloadPodGroupResourceClaim... resourceClaims) {
    if (this.resourceClaims != null) {
        this.resourceClaims.clear();
        _visitables.remove("resourceClaims");
    }
    if (resourceClaims != null) {
      for (WorkloadPodGroupResourceClaim item : resourceClaims) {
        this.addToResourceClaims(item);
      }
    }
    return (A) this;
  }
  
  public A withSchedulingConstraints(WorkloadPodGroupSchedulingConstraints schedulingConstraints) {
    this.schedulingConstraints = schedulingConstraints;
    return (A) this;
  }
  
  public A withSchedulingPolicy(WorkloadPodGroupSchedulingPolicy schedulingPolicy) {
    this.schedulingPolicy = schedulingPolicy;
    return (A) this;
  }
  
}