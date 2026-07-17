package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class MachineOSBuilderReferenceFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineOSBuilderReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String imageBuilderType;
  private ObjectReferenceBuilder job;

  public MachineOSBuilderReferenceFluent() {
  }
  
  public MachineOSBuilderReferenceFluent(MachineOSBuilderReference instance) {
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
  
  public ObjectReference buildJob() {
    return this.job != null ? this.job.build() : null;
  }
  
  protected void copyInstance(MachineOSBuilderReference instance) {
    instance = instance != null ? instance : new MachineOSBuilderReference();
    if (instance != null) {
        this.withImageBuilderType(instance.getImageBuilderType());
        this.withJob(instance.getJob());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JobNested<A> editJob() {
    return this.withNewJobLike(Optional.ofNullable(this.buildJob()).orElse(null));
  }
  
  public JobNested<A> editOrNewJob() {
    return this.withNewJobLike(Optional.ofNullable(this.buildJob()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public JobNested<A> editOrNewJobLike(ObjectReference item) {
    return this.withNewJobLike(Optional.ofNullable(this.buildJob()).orElse(item));
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
    MachineOSBuilderReferenceFluent that = (MachineOSBuilderReferenceFluent) o;
    if (!(Objects.equals(imageBuilderType, that.imageBuilderType))) {
      return false;
    }
    if (!(Objects.equals(job, that.job))) {
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
  
  public String getImageBuilderType() {
    return this.imageBuilderType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImageBuilderType() {
    return this.imageBuilderType != null;
  }
  
  public boolean hasJob() {
    return this.job != null;
  }
  
  public int hashCode() {
    return Objects.hash(imageBuilderType, job, additionalProperties);
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
    if (!(imageBuilderType == null)) {
        sb.append("imageBuilderType:");
        sb.append(imageBuilderType);
        sb.append(",");
    }
    if (!(job == null)) {
        sb.append("job:");
        sb.append(job);
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
  
  public A withImageBuilderType(String imageBuilderType) {
    this.imageBuilderType = imageBuilderType;
    return (A) this;
  }
  
  public A withJob(ObjectReference job) {
    this._visitables.remove("job");
    if (job != null) {
        this.job = new ObjectReferenceBuilder(job);
        this._visitables.get("job").add(this.job);
    } else {
        this.job = null;
        this._visitables.get("job").remove(this.job);
    }
    return (A) this;
  }
  
  public JobNested<A> withNewJob() {
    return new JobNested(null);
  }
  
  public A withNewJob(String group,String name,String namespace,String resource) {
    return (A) this.withJob(new ObjectReference(group, name, namespace, resource));
  }
  
  public JobNested<A> withNewJobLike(ObjectReference item) {
    return new JobNested(item);
  }
  public class JobNested<N> extends ObjectReferenceFluent<JobNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    JobNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSBuilderReferenceFluent.this.withJob(builder.build());
    }
    
    public N endJob() {
      return and();
    }
    
  }
}