package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GitRepoVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.GitRepoVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String directory;
  private String repository;
  private String revision;

  public GitRepoVolumeSourceFluent() {
  }
  
  public GitRepoVolumeSourceFluent(GitRepoVolumeSource instance) {
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
  
  protected void copyInstance(GitRepoVolumeSource instance) {
    instance = instance != null ? instance : new GitRepoVolumeSource();
    if (instance != null) {
        this.withDirectory(instance.getDirectory());
        this.withRepository(instance.getRepository());
        this.withRevision(instance.getRevision());
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
    GitRepoVolumeSourceFluent that = (GitRepoVolumeSourceFluent) o;
    if (!(Objects.equals(directory, that.directory))) {
      return false;
    }
    if (!(Objects.equals(repository, that.repository))) {
      return false;
    }
    if (!(Objects.equals(revision, that.revision))) {
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
  
  public String getDirectory() {
    return this.directory;
  }
  
  public String getRepository() {
    return this.repository;
  }
  
  public String getRevision() {
    return this.revision;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDirectory() {
    return this.directory != null;
  }
  
  public boolean hasRepository() {
    return this.repository != null;
  }
  
  public boolean hasRevision() {
    return this.revision != null;
  }
  
  public int hashCode() {
    return Objects.hash(directory, repository, revision, additionalProperties);
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
    if (!(directory == null)) {
        sb.append("directory:");
        sb.append(directory);
        sb.append(",");
    }
    if (!(repository == null)) {
        sb.append("repository:");
        sb.append(repository);
        sb.append(",");
    }
    if (!(revision == null)) {
        sb.append("revision:");
        sb.append(revision);
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
  
  public A withDirectory(String directory) {
    this.directory = directory;
    return (A) this;
  }
  
  public A withRepository(String repository) {
    this.repository = repository;
    return (A) this;
  }
  
  public A withRevision(String revision) {
    this.revision = revision;
    return (A) this;
  }
  
}