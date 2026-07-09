package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

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
public class MetricStatusFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta2.MetricStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ContainerResourceMetricStatusBuilder containerResource;
  private ExternalMetricStatusBuilder external;
  private ObjectMetricStatusBuilder object;
  private PodsMetricStatusBuilder pods;
  private ResourceMetricStatusBuilder resource;
  private String type;

  public MetricStatusFluent() {
  }
  
  public MetricStatusFluent(MetricStatus instance) {
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
  
  public ContainerResourceMetricStatus buildContainerResource() {
    return this.containerResource != null ? this.containerResource.build() : null;
  }
  
  public ExternalMetricStatus buildExternal() {
    return this.external != null ? this.external.build() : null;
  }
  
  public ObjectMetricStatus buildObject() {
    return this.object != null ? this.object.build() : null;
  }
  
  public PodsMetricStatus buildPods() {
    return this.pods != null ? this.pods.build() : null;
  }
  
  public ResourceMetricStatus buildResource() {
    return this.resource != null ? this.resource.build() : null;
  }
  
  protected void copyInstance(MetricStatus instance) {
    instance = instance != null ? instance : new MetricStatus();
    if (instance != null) {
        this.withContainerResource(instance.getContainerResource());
        this.withExternal(instance.getExternal());
        this.withObject(instance.getObject());
        this.withPods(instance.getPods());
        this.withResource(instance.getResource());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerResourceNested<A> editContainerResource() {
    return this.withNewContainerResourceLike(Optional.ofNullable(this.buildContainerResource()).orElse(null));
  }
  
  public ExternalNested<A> editExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(null));
  }
  
  public ObjectNested<A> editObject() {
    return this.withNewObjectLike(Optional.ofNullable(this.buildObject()).orElse(null));
  }
  
  public ContainerResourceNested<A> editOrNewContainerResource() {
    return this.withNewContainerResourceLike(Optional.ofNullable(this.buildContainerResource()).orElse(new ContainerResourceMetricStatusBuilder().build()));
  }
  
  public ContainerResourceNested<A> editOrNewContainerResourceLike(ContainerResourceMetricStatus item) {
    return this.withNewContainerResourceLike(Optional.ofNullable(this.buildContainerResource()).orElse(item));
  }
  
  public ExternalNested<A> editOrNewExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(new ExternalMetricStatusBuilder().build()));
  }
  
  public ExternalNested<A> editOrNewExternalLike(ExternalMetricStatus item) {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(item));
  }
  
  public ObjectNested<A> editOrNewObject() {
    return this.withNewObjectLike(Optional.ofNullable(this.buildObject()).orElse(new ObjectMetricStatusBuilder().build()));
  }
  
  public ObjectNested<A> editOrNewObjectLike(ObjectMetricStatus item) {
    return this.withNewObjectLike(Optional.ofNullable(this.buildObject()).orElse(item));
  }
  
  public PodsNested<A> editOrNewPods() {
    return this.withNewPodsLike(Optional.ofNullable(this.buildPods()).orElse(new PodsMetricStatusBuilder().build()));
  }
  
  public PodsNested<A> editOrNewPodsLike(PodsMetricStatus item) {
    return this.withNewPodsLike(Optional.ofNullable(this.buildPods()).orElse(item));
  }
  
  public ResourceNested<A> editOrNewResource() {
    return this.withNewResourceLike(Optional.ofNullable(this.buildResource()).orElse(new ResourceMetricStatusBuilder().build()));
  }
  
  public ResourceNested<A> editOrNewResourceLike(ResourceMetricStatus item) {
    return this.withNewResourceLike(Optional.ofNullable(this.buildResource()).orElse(item));
  }
  
  public PodsNested<A> editPods() {
    return this.withNewPodsLike(Optional.ofNullable(this.buildPods()).orElse(null));
  }
  
  public ResourceNested<A> editResource() {
    return this.withNewResourceLike(Optional.ofNullable(this.buildResource()).orElse(null));
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
    MetricStatusFluent that = (MetricStatusFluent) o;
    if (!(Objects.equals(containerResource, that.containerResource))) {
      return false;
    }
    if (!(Objects.equals(external, that.external))) {
      return false;
    }
    if (!(Objects.equals(object, that.object))) {
      return false;
    }
    if (!(Objects.equals(pods, that.pods))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerResource() {
    return this.containerResource != null;
  }
  
  public boolean hasExternal() {
    return this.external != null;
  }
  
  public boolean hasObject() {
    return this.object != null;
  }
  
  public boolean hasPods() {
    return this.pods != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerResource, external, object, pods, resource, type, additionalProperties);
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
    if (!(containerResource == null)) {
        sb.append("containerResource:");
        sb.append(containerResource);
        sb.append(",");
    }
    if (!(external == null)) {
        sb.append("external:");
        sb.append(external);
        sb.append(",");
    }
    if (!(object == null)) {
        sb.append("object:");
        sb.append(object);
        sb.append(",");
    }
    if (!(pods == null)) {
        sb.append("pods:");
        sb.append(pods);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withContainerResource(ContainerResourceMetricStatus containerResource) {
    this._visitables.remove("containerResource");
    if (containerResource != null) {
        this.containerResource = new ContainerResourceMetricStatusBuilder(containerResource);
        this._visitables.get("containerResource").add(this.containerResource);
    } else {
        this.containerResource = null;
        this._visitables.get("containerResource").remove(this.containerResource);
    }
    return (A) this;
  }
  
  public A withExternal(ExternalMetricStatus external) {
    this._visitables.remove("external");
    if (external != null) {
        this.external = new ExternalMetricStatusBuilder(external);
        this._visitables.get("external").add(this.external);
    } else {
        this.external = null;
        this._visitables.get("external").remove(this.external);
    }
    return (A) this;
  }
  
  public ContainerResourceNested<A> withNewContainerResource() {
    return new ContainerResourceNested(null);
  }
  
  public ContainerResourceNested<A> withNewContainerResourceLike(ContainerResourceMetricStatus item) {
    return new ContainerResourceNested(item);
  }
  
  public ExternalNested<A> withNewExternal() {
    return new ExternalNested(null);
  }
  
  public ExternalNested<A> withNewExternalLike(ExternalMetricStatus item) {
    return new ExternalNested(item);
  }
  
  public ObjectNested<A> withNewObject() {
    return new ObjectNested(null);
  }
  
  public ObjectNested<A> withNewObjectLike(ObjectMetricStatus item) {
    return new ObjectNested(item);
  }
  
  public PodsNested<A> withNewPods() {
    return new PodsNested(null);
  }
  
  public PodsNested<A> withNewPodsLike(PodsMetricStatus item) {
    return new PodsNested(item);
  }
  
  public ResourceNested<A> withNewResource() {
    return new ResourceNested(null);
  }
  
  public ResourceNested<A> withNewResourceLike(ResourceMetricStatus item) {
    return new ResourceNested(item);
  }
  
  public A withObject(ObjectMetricStatus object) {
    this._visitables.remove("object");
    if (object != null) {
        this.object = new ObjectMetricStatusBuilder(object);
        this._visitables.get("object").add(this.object);
    } else {
        this.object = null;
        this._visitables.get("object").remove(this.object);
    }
    return (A) this;
  }
  
  public A withPods(PodsMetricStatus pods) {
    this._visitables.remove("pods");
    if (pods != null) {
        this.pods = new PodsMetricStatusBuilder(pods);
        this._visitables.get("pods").add(this.pods);
    } else {
        this.pods = null;
        this._visitables.get("pods").remove(this.pods);
    }
    return (A) this;
  }
  
  public A withResource(ResourceMetricStatus resource) {
    this._visitables.remove("resource");
    if (resource != null) {
        this.resource = new ResourceMetricStatusBuilder(resource);
        this._visitables.get("resource").add(this.resource);
    } else {
        this.resource = null;
        this._visitables.get("resource").remove(this.resource);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ContainerResourceNested<N> extends ContainerResourceMetricStatusFluent<ContainerResourceNested<N>> implements Nested<N>{
  
    ContainerResourceMetricStatusBuilder builder;
  
    ContainerResourceNested(ContainerResourceMetricStatus item) {
      this.builder = new ContainerResourceMetricStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricStatusFluent.this.withContainerResource(builder.build());
    }
    
    public N endContainerResource() {
      return and();
    }
    
  }
  public class ExternalNested<N> extends ExternalMetricStatusFluent<ExternalNested<N>> implements Nested<N>{
  
    ExternalMetricStatusBuilder builder;
  
    ExternalNested(ExternalMetricStatus item) {
      this.builder = new ExternalMetricStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricStatusFluent.this.withExternal(builder.build());
    }
    
    public N endExternal() {
      return and();
    }
    
  }
  public class ObjectNested<N> extends ObjectMetricStatusFluent<ObjectNested<N>> implements Nested<N>{
  
    ObjectMetricStatusBuilder builder;
  
    ObjectNested(ObjectMetricStatus item) {
      this.builder = new ObjectMetricStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricStatusFluent.this.withObject(builder.build());
    }
    
    public N endObject() {
      return and();
    }
    
  }
  public class PodsNested<N> extends PodsMetricStatusFluent<PodsNested<N>> implements Nested<N>{
  
    PodsMetricStatusBuilder builder;
  
    PodsNested(PodsMetricStatus item) {
      this.builder = new PodsMetricStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricStatusFluent.this.withPods(builder.build());
    }
    
    public N endPods() {
      return and();
    }
    
  }
  public class ResourceNested<N> extends ResourceMetricStatusFluent<ResourceNested<N>> implements Nested<N>{
  
    ResourceMetricStatusBuilder builder;
  
    ResourceNested(ResourceMetricStatus item) {
      this.builder = new ResourceMetricStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricStatusFluent.this.withResource(builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
}