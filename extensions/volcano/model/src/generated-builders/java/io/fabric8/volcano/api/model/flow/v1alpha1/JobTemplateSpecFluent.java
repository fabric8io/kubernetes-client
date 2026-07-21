package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.volcano.api.model.batch.v1alpha1.JobSpec;
import io.fabric8.volcano.api.model.batch.v1alpha1.JobSpecBuilder;
import io.fabric8.volcano.api.model.batch.v1alpha1.JobSpecFluent;
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
public class JobTemplateSpecFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.JobTemplateSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private JobSpecBuilder jobSpec;

  public JobTemplateSpecFluent() {
  }
  
  public JobTemplateSpecFluent(JobTemplateSpec instance) {
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
  
  public JobSpec buildJobSpec() {
    return this.jobSpec != null ? this.jobSpec.build() : null;
  }
  
  protected void copyInstance(JobTemplateSpec instance) {
    instance = instance != null ? instance : new JobTemplateSpec();
    if (instance != null) {
        this.withJobSpec(instance.getJobSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JobSpecNested<A> editJobSpec() {
    return this.withNewJobSpecLike(Optional.ofNullable(this.buildJobSpec()).orElse(null));
  }
  
  public JobSpecNested<A> editOrNewJobSpec() {
    return this.withNewJobSpecLike(Optional.ofNullable(this.buildJobSpec()).orElse(new JobSpecBuilder().build()));
  }
  
  public JobSpecNested<A> editOrNewJobSpecLike(JobSpec item) {
    return this.withNewJobSpecLike(Optional.ofNullable(this.buildJobSpec()).orElse(item));
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
    JobTemplateSpecFluent that = (JobTemplateSpecFluent) o;
    if (!(Objects.equals(jobSpec, that.jobSpec))) {
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
  
  public boolean hasJobSpec() {
    return this.jobSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(jobSpec, additionalProperties);
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
    if (!(jobSpec == null)) {
        sb.append("jobSpec:");
        sb.append(jobSpec);
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
  
  public A withJobSpec(JobSpec jobSpec) {
    this._visitables.remove("jobSpec");
    if (jobSpec != null) {
        this.jobSpec = new JobSpecBuilder(jobSpec);
        this._visitables.get("jobSpec").add(this.jobSpec);
    } else {
        this.jobSpec = null;
        this._visitables.get("jobSpec").remove(this.jobSpec);
    }
    return (A) this;
  }
  
  public JobSpecNested<A> withNewJobSpec() {
    return new JobSpecNested(null);
  }
  
  public JobSpecNested<A> withNewJobSpecLike(JobSpec item) {
    return new JobSpecNested(item);
  }
  public class JobSpecNested<N> extends JobSpecFluent<JobSpecNested<N>> implements Nested<N>{
  
    JobSpecBuilder builder;
  
    JobSpecNested(JobSpec item) {
      this.builder = new JobSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) JobTemplateSpecFluent.this.withJobSpec(builder.build());
    }
    
    public N endJobSpec() {
      return and();
    }
    
  }
}