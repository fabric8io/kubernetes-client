package io.fabric8.openshift.api.model.console.v1;

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
public class ConsoleSampleSourceFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleSampleSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConsoleSampleContainerImportSourceBuilder containerImport;
  private ConsoleSampleGitImportSourceBuilder gitImport;
  private String type;

  public ConsoleSampleSourceFluent() {
  }
  
  public ConsoleSampleSourceFluent(ConsoleSampleSource instance) {
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
  
  public ConsoleSampleContainerImportSource buildContainerImport() {
    return this.containerImport != null ? this.containerImport.build() : null;
  }
  
  public ConsoleSampleGitImportSource buildGitImport() {
    return this.gitImport != null ? this.gitImport.build() : null;
  }
  
  protected void copyInstance(ConsoleSampleSource instance) {
    instance = instance != null ? instance : new ConsoleSampleSource();
    if (instance != null) {
        this.withContainerImport(instance.getContainerImport());
        this.withGitImport(instance.getGitImport());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerImportNested<A> editContainerImport() {
    return this.withNewContainerImportLike(Optional.ofNullable(this.buildContainerImport()).orElse(null));
  }
  
  public GitImportNested<A> editGitImport() {
    return this.withNewGitImportLike(Optional.ofNullable(this.buildGitImport()).orElse(null));
  }
  
  public ContainerImportNested<A> editOrNewContainerImport() {
    return this.withNewContainerImportLike(Optional.ofNullable(this.buildContainerImport()).orElse(new ConsoleSampleContainerImportSourceBuilder().build()));
  }
  
  public ContainerImportNested<A> editOrNewContainerImportLike(ConsoleSampleContainerImportSource item) {
    return this.withNewContainerImportLike(Optional.ofNullable(this.buildContainerImport()).orElse(item));
  }
  
  public GitImportNested<A> editOrNewGitImport() {
    return this.withNewGitImportLike(Optional.ofNullable(this.buildGitImport()).orElse(new ConsoleSampleGitImportSourceBuilder().build()));
  }
  
  public GitImportNested<A> editOrNewGitImportLike(ConsoleSampleGitImportSource item) {
    return this.withNewGitImportLike(Optional.ofNullable(this.buildGitImport()).orElse(item));
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
    ConsoleSampleSourceFluent that = (ConsoleSampleSourceFluent) o;
    if (!(Objects.equals(containerImport, that.containerImport))) {
      return false;
    }
    if (!(Objects.equals(gitImport, that.gitImport))) {
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
  
  public boolean hasContainerImport() {
    return this.containerImport != null;
  }
  
  public boolean hasGitImport() {
    return this.gitImport != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerImport, gitImport, type, additionalProperties);
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
    if (!(containerImport == null)) {
        sb.append("containerImport:");
        sb.append(containerImport);
        sb.append(",");
    }
    if (!(gitImport == null)) {
        sb.append("gitImport:");
        sb.append(gitImport);
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
  
  public A withContainerImport(ConsoleSampleContainerImportSource containerImport) {
    this._visitables.remove("containerImport");
    if (containerImport != null) {
        this.containerImport = new ConsoleSampleContainerImportSourceBuilder(containerImport);
        this._visitables.get("containerImport").add(this.containerImport);
    } else {
        this.containerImport = null;
        this._visitables.get("containerImport").remove(this.containerImport);
    }
    return (A) this;
  }
  
  public A withGitImport(ConsoleSampleGitImportSource gitImport) {
    this._visitables.remove("gitImport");
    if (gitImport != null) {
        this.gitImport = new ConsoleSampleGitImportSourceBuilder(gitImport);
        this._visitables.get("gitImport").add(this.gitImport);
    } else {
        this.gitImport = null;
        this._visitables.get("gitImport").remove(this.gitImport);
    }
    return (A) this;
  }
  
  public ContainerImportNested<A> withNewContainerImport() {
    return new ContainerImportNested(null);
  }
  
  public ContainerImportNested<A> withNewContainerImportLike(ConsoleSampleContainerImportSource item) {
    return new ContainerImportNested(item);
  }
  
  public GitImportNested<A> withNewGitImport() {
    return new GitImportNested(null);
  }
  
  public GitImportNested<A> withNewGitImportLike(ConsoleSampleGitImportSource item) {
    return new GitImportNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ContainerImportNested<N> extends ConsoleSampleContainerImportSourceFluent<ContainerImportNested<N>> implements Nested<N>{
  
    ConsoleSampleContainerImportSourceBuilder builder;
  
    ContainerImportNested(ConsoleSampleContainerImportSource item) {
      this.builder = new ConsoleSampleContainerImportSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSampleSourceFluent.this.withContainerImport(builder.build());
    }
    
    public N endContainerImport() {
      return and();
    }
    
  }
  public class GitImportNested<N> extends ConsoleSampleGitImportSourceFluent<GitImportNested<N>> implements Nested<N>{
  
    ConsoleSampleGitImportSourceBuilder builder;
  
    GitImportNested(ConsoleSampleGitImportSource item) {
      this.builder = new ConsoleSampleGitImportSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSampleSourceFluent.this.withGitImport(builder.build());
    }
    
    public N endGitImport() {
      return and();
    }
    
  }
}