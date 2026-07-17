package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import java.lang.Integer;
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
public class ControllerConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.ControllerConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer clientBurst;
  private Integer clientQPS;
  private Integer concurrentReconciles;
  private Integer queueBurst;
  private Integer queueQPS;
  private Integer replicas;
  private ResourceRequirementsBuilder resources;

  public ControllerConfigFluent() {
  }
  
  public ControllerConfigFluent(ControllerConfig instance) {
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
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  protected void copyInstance(ControllerConfig instance) {
    instance = instance != null ? instance : new ControllerConfig();
    if (instance != null) {
        this.withClientBurst(instance.getClientBurst());
        this.withClientQPS(instance.getClientQPS());
        this.withConcurrentReconciles(instance.getConcurrentReconciles());
        this.withQueueBurst(instance.getQueueBurst());
        this.withQueueQPS(instance.getQueueQPS());
        this.withReplicas(instance.getReplicas());
        this.withResources(instance.getResources());
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
    ControllerConfigFluent that = (ControllerConfigFluent) o;
    if (!(Objects.equals(clientBurst, that.clientBurst))) {
      return false;
    }
    if (!(Objects.equals(clientQPS, that.clientQPS))) {
      return false;
    }
    if (!(Objects.equals(concurrentReconciles, that.concurrentReconciles))) {
      return false;
    }
    if (!(Objects.equals(queueBurst, that.queueBurst))) {
      return false;
    }
    if (!(Objects.equals(queueQPS, that.queueQPS))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
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
  
  public Integer getClientBurst() {
    return this.clientBurst;
  }
  
  public Integer getClientQPS() {
    return this.clientQPS;
  }
  
  public Integer getConcurrentReconciles() {
    return this.concurrentReconciles;
  }
  
  public Integer getQueueBurst() {
    return this.queueBurst;
  }
  
  public Integer getQueueQPS() {
    return this.queueQPS;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientBurst() {
    return this.clientBurst != null;
  }
  
  public boolean hasClientQPS() {
    return this.clientQPS != null;
  }
  
  public boolean hasConcurrentReconciles() {
    return this.concurrentReconciles != null;
  }
  
  public boolean hasQueueBurst() {
    return this.queueBurst != null;
  }
  
  public boolean hasQueueQPS() {
    return this.queueQPS != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientBurst, clientQPS, concurrentReconciles, queueBurst, queueQPS, replicas, resources, additionalProperties);
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
    if (!(clientBurst == null)) {
        sb.append("clientBurst:");
        sb.append(clientBurst);
        sb.append(",");
    }
    if (!(clientQPS == null)) {
        sb.append("clientQPS:");
        sb.append(clientQPS);
        sb.append(",");
    }
    if (!(concurrentReconciles == null)) {
        sb.append("concurrentReconciles:");
        sb.append(concurrentReconciles);
        sb.append(",");
    }
    if (!(queueBurst == null)) {
        sb.append("queueBurst:");
        sb.append(queueBurst);
        sb.append(",");
    }
    if (!(queueQPS == null)) {
        sb.append("queueQPS:");
        sb.append(queueQPS);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
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
  
  public A withClientBurst(Integer clientBurst) {
    this.clientBurst = clientBurst;
    return (A) this;
  }
  
  public A withClientQPS(Integer clientQPS) {
    this.clientQPS = clientQPS;
    return (A) this;
  }
  
  public A withConcurrentReconciles(Integer concurrentReconciles) {
    this.concurrentReconciles = concurrentReconciles;
    return (A) this;
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public A withQueueBurst(Integer queueBurst) {
    this.queueBurst = queueBurst;
    return (A) this;
  }
  
  public A withQueueQPS(Integer queueQPS) {
    this.queueQPS = queueQPS;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
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
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllerConfigFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
}