package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.tekton.v1alpha1.PipelineResourceSpec;
import io.fabric8.tekton.v1alpha1.PipelineResourceSpecBuilder;
import io.fabric8.tekton.v1alpha1.PipelineResourceSpecFluent;
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
public class TaskResourceBindingFluent<A extends io.fabric8.tekton.v1beta1.TaskResourceBindingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private List<String> paths = new ArrayList<String>();
  private PipelineResourceRefBuilder resourceRef;
  private PipelineResourceSpecBuilder resourceSpec;

  public TaskResourceBindingFluent() {
  }
  
  public TaskResourceBindingFluent(TaskResourceBinding instance) {
    this.copyInstance(instance);
  }

  public A addAllToPaths(Collection<String> items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (String item : items) {
      this.paths.add(item);
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
  
  public A addToPaths(String... items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (String item : items) {
      this.paths.add(item);
    }
    return (A) this;
  }
  
  public A addToPaths(int index,String item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    this.paths.add(index, item);
    return (A) this;
  }
  
  public PipelineResourceRef buildResourceRef() {
    return this.resourceRef != null ? this.resourceRef.build() : null;
  }
  
  public PipelineResourceSpec buildResourceSpec() {
    return this.resourceSpec != null ? this.resourceSpec.build() : null;
  }
  
  protected void copyInstance(TaskResourceBinding instance) {
    instance = instance != null ? instance : new TaskResourceBinding();
    if (instance != null) {
        this.withName(instance.getName());
        this.withPaths(instance.getPaths());
        this.withResourceRef(instance.getResourceRef());
        this.withResourceSpec(instance.getResourceSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceRefNested<A> editOrNewResourceRef() {
    return this.withNewResourceRefLike(Optional.ofNullable(this.buildResourceRef()).orElse(new PipelineResourceRefBuilder().build()));
  }
  
  public ResourceRefNested<A> editOrNewResourceRefLike(PipelineResourceRef item) {
    return this.withNewResourceRefLike(Optional.ofNullable(this.buildResourceRef()).orElse(item));
  }
  
  public ResourceSpecNested<A> editOrNewResourceSpec() {
    return this.withNewResourceSpecLike(Optional.ofNullable(this.buildResourceSpec()).orElse(new PipelineResourceSpecBuilder().build()));
  }
  
  public ResourceSpecNested<A> editOrNewResourceSpecLike(PipelineResourceSpec item) {
    return this.withNewResourceSpecLike(Optional.ofNullable(this.buildResourceSpec()).orElse(item));
  }
  
  public ResourceRefNested<A> editResourceRef() {
    return this.withNewResourceRefLike(Optional.ofNullable(this.buildResourceRef()).orElse(null));
  }
  
  public ResourceSpecNested<A> editResourceSpec() {
    return this.withNewResourceSpecLike(Optional.ofNullable(this.buildResourceSpec()).orElse(null));
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
    TaskResourceBindingFluent that = (TaskResourceBindingFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(paths, that.paths))) {
      return false;
    }
    if (!(Objects.equals(resourceRef, that.resourceRef))) {
      return false;
    }
    if (!(Objects.equals(resourceSpec, that.resourceSpec))) {
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
  
  public String getFirstPath() {
    return this.paths.get(0);
  }
  
  public String getLastPath() {
    return this.paths.get(paths.size() - 1);
  }
  
  public String getMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPath(int index) {
    return this.paths.get(index);
  }
  
  public List<String> getPaths() {
    return this.paths;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPaths() {
    return this.paths != null && !(this.paths.isEmpty());
  }
  
  public boolean hasResourceRef() {
    return this.resourceRef != null;
  }
  
  public boolean hasResourceSpec() {
    return this.resourceSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, paths, resourceRef, resourceSpec, additionalProperties);
  }
  
  public A removeAllFromPaths(Collection<String> items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.paths.remove(item);
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
  
  public A removeFromPaths(String... items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.paths.remove(item);
    }
    return (A) this;
  }
  
  public A setToPaths(int index,String item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    this.paths.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(paths == null) && !(paths.isEmpty())) {
        sb.append("paths:");
        sb.append(paths);
        sb.append(",");
    }
    if (!(resourceRef == null)) {
        sb.append("resourceRef:");
        sb.append(resourceRef);
        sb.append(",");
    }
    if (!(resourceSpec == null)) {
        sb.append("resourceSpec:");
        sb.append(resourceSpec);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ResourceRefNested<A> withNewResourceRef() {
    return new ResourceRefNested(null);
  }
  
  public A withNewResourceRef(String apiVersion,String name) {
    return (A) this.withResourceRef(new PipelineResourceRef(apiVersion, name));
  }
  
  public ResourceRefNested<A> withNewResourceRefLike(PipelineResourceRef item) {
    return new ResourceRefNested(item);
  }
  
  public ResourceSpecNested<A> withNewResourceSpec() {
    return new ResourceSpecNested(null);
  }
  
  public ResourceSpecNested<A> withNewResourceSpecLike(PipelineResourceSpec item) {
    return new ResourceSpecNested(item);
  }
  
  public A withPaths(List<String> paths) {
    if (paths != null) {
        this.paths = new ArrayList();
        for (String item : paths) {
          this.addToPaths(item);
        }
    } else {
      this.paths = null;
    }
    return (A) this;
  }
  
  public A withPaths(String... paths) {
    if (this.paths != null) {
        this.paths.clear();
        _visitables.remove("paths");
    }
    if (paths != null) {
      for (String item : paths) {
        this.addToPaths(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceRef(PipelineResourceRef resourceRef) {
    this._visitables.remove("resourceRef");
    if (resourceRef != null) {
        this.resourceRef = new PipelineResourceRefBuilder(resourceRef);
        this._visitables.get("resourceRef").add(this.resourceRef);
    } else {
        this.resourceRef = null;
        this._visitables.get("resourceRef").remove(this.resourceRef);
    }
    return (A) this;
  }
  
  public A withResourceSpec(PipelineResourceSpec resourceSpec) {
    this._visitables.remove("resourceSpec");
    if (resourceSpec != null) {
        this.resourceSpec = new PipelineResourceSpecBuilder(resourceSpec);
        this._visitables.get("resourceSpec").add(this.resourceSpec);
    } else {
        this.resourceSpec = null;
        this._visitables.get("resourceSpec").remove(this.resourceSpec);
    }
    return (A) this;
  }
  public class ResourceRefNested<N> extends PipelineResourceRefFluent<ResourceRefNested<N>> implements Nested<N>{
  
    PipelineResourceRefBuilder builder;
  
    ResourceRefNested(PipelineResourceRef item) {
      this.builder = new PipelineResourceRefBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskResourceBindingFluent.this.withResourceRef(builder.build());
    }
    
    public N endResourceRef() {
      return and();
    }
    
  }
  public class ResourceSpecNested<N> extends PipelineResourceSpecFluent<ResourceSpecNested<N>> implements Nested<N>{
  
    PipelineResourceSpecBuilder builder;
  
    ResourceSpecNested(PipelineResourceSpec item) {
      this.builder = new PipelineResourceSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskResourceBindingFluent.this.withResourceSpec(builder.build());
    }
    
    public N endResourceSpec() {
      return and();
    }
    
  }
}