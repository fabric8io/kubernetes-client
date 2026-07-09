package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodGroupTemplateReferenceFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha2.PodGroupTemplateReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WorkloadPodGroupTemplateReferenceBuilder workload;

  public PodGroupTemplateReferenceFluent() {
  }
  
  public PodGroupTemplateReferenceFluent(PodGroupTemplateReference instance) {
    this.copyInstance(instance);
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
  
  public WorkloadPodGroupTemplateReference buildWorkload() {
    return this.workload != null ? this.workload.build() : null;
  }
  
  protected void copyInstance(PodGroupTemplateReference instance) {
    instance = instance != null ? instance : new PodGroupTemplateReference();
    if (instance != null) {
        this.withWorkload(instance.getWorkload());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WorkloadNested<A> editOrNewWorkload() {
    return this.withNewWorkloadLike(Optional.ofNullable(this.buildWorkload()).orElse(new WorkloadPodGroupTemplateReferenceBuilder().build()));
  }
  
  public WorkloadNested<A> editOrNewWorkloadLike(WorkloadPodGroupTemplateReference item) {
    return this.withNewWorkloadLike(Optional.ofNullable(this.buildWorkload()).orElse(item));
  }
  
  public WorkloadNested<A> editWorkload() {
    return this.withNewWorkloadLike(Optional.ofNullable(this.buildWorkload()).orElse(null));
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
    PodGroupTemplateReferenceFluent that = (PodGroupTemplateReferenceFluent) o;
    if (!(Objects.equals(workload, that.workload))) {
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
  
  public boolean hasWorkload() {
    return this.workload != null;
  }
  
  public int hashCode() {
    return Objects.hash(workload, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(workload == null)) {
        sb.append("workload:");
        sb.append(workload);
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
  
  public WorkloadNested<A> withNewWorkload() {
    return new WorkloadNested(null);
  }
  
  public A withNewWorkload(String podGroupTemplateName,String workloadName) {
    return (A) this.withWorkload(new WorkloadPodGroupTemplateReference(podGroupTemplateName, workloadName));
  }
  
  public WorkloadNested<A> withNewWorkloadLike(WorkloadPodGroupTemplateReference item) {
    return new WorkloadNested(item);
  }
  
  public A withWorkload(WorkloadPodGroupTemplateReference workload) {
    this._visitables.remove("workload");
    if (workload != null) {
        this.workload = new WorkloadPodGroupTemplateReferenceBuilder(workload);
        this._visitables.get("workload").add(this.workload);
    } else {
        this.workload = null;
        this._visitables.get("workload").remove(this.workload);
    }
    return (A) this;
  }
  public class WorkloadNested<N> extends WorkloadPodGroupTemplateReferenceFluent<WorkloadNested<N>> implements Nested<N>{
  
    WorkloadPodGroupTemplateReferenceBuilder builder;
  
    WorkloadNested(WorkloadPodGroupTemplateReference item) {
      this.builder = new WorkloadPodGroupTemplateReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupTemplateReferenceFluent.this.withWorkload(builder.build());
    }
    
    public N endWorkload() {
      return and();
    }
    
  }
}