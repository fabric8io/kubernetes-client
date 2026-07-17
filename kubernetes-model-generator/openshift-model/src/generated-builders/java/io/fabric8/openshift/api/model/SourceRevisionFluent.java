package io.fabric8.openshift.api.model;

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
public class SourceRevisionFluent<A extends io.fabric8.openshift.api.model.SourceRevisionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GitSourceRevisionBuilder git;
  private String type;

  public SourceRevisionFluent() {
  }
  
  public SourceRevisionFluent(SourceRevision instance) {
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
  
  public GitSourceRevision buildGit() {
    return this.git != null ? this.git.build() : null;
  }
  
  protected void copyInstance(SourceRevision instance) {
    instance = instance != null ? instance : new SourceRevision();
    if (instance != null) {
        this.withGit(instance.getGit());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GitNested<A> editGit() {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(null));
  }
  
  public GitNested<A> editOrNewGit() {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(new GitSourceRevisionBuilder().build()));
  }
  
  public GitNested<A> editOrNewGitLike(GitSourceRevision item) {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(item));
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
    SourceRevisionFluent that = (SourceRevisionFluent) o;
    if (!(Objects.equals(git, that.git))) {
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
  
  public boolean hasGit() {
    return this.git != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(git, type, additionalProperties);
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
    if (!(git == null)) {
        sb.append("git:");
        sb.append(git);
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
  
  public A withGit(GitSourceRevision git) {
    this._visitables.remove("git");
    if (git != null) {
        this.git = new GitSourceRevisionBuilder(git);
        this._visitables.get("git").add(this.git);
    } else {
        this.git = null;
        this._visitables.get("git").remove(this.git);
    }
    return (A) this;
  }
  
  public GitNested<A> withNewGit() {
    return new GitNested(null);
  }
  
  public GitNested<A> withNewGitLike(GitSourceRevision item) {
    return new GitNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class GitNested<N> extends GitSourceRevisionFluent<GitNested<N>> implements Nested<N>{
  
    GitSourceRevisionBuilder builder;
  
    GitNested(GitSourceRevision item) {
      this.builder = new GitSourceRevisionBuilder(this, item);
    }
  
    public N and() {
      return (N) SourceRevisionFluent.this.withGit(builder.build());
    }
    
    public N endGit() {
      return and();
    }
    
  }
}