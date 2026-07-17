package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class TagEventFluent<A extends io.fabric8.openshift.api.model.TagEventFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String created;
  private String dockerImageReference;
  private Long generation;
  private String image;

  public TagEventFluent() {
  }
  
  public TagEventFluent(TagEvent instance) {
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
  
  protected void copyInstance(TagEvent instance) {
    instance = instance != null ? instance : new TagEvent();
    if (instance != null) {
        this.withCreated(instance.getCreated());
        this.withDockerImageReference(instance.getDockerImageReference());
        this.withGeneration(instance.getGeneration());
        this.withImage(instance.getImage());
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
    TagEventFluent that = (TagEventFluent) o;
    if (!(Objects.equals(created, that.created))) {
      return false;
    }
    if (!(Objects.equals(dockerImageReference, that.dockerImageReference))) {
      return false;
    }
    if (!(Objects.equals(generation, that.generation))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
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
  
  public String getCreated() {
    return this.created;
  }
  
  public String getDockerImageReference() {
    return this.dockerImageReference;
  }
  
  public Long getGeneration() {
    return this.generation;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCreated() {
    return this.created != null;
  }
  
  public boolean hasDockerImageReference() {
    return this.dockerImageReference != null;
  }
  
  public boolean hasGeneration() {
    return this.generation != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public int hashCode() {
    return Objects.hash(created, dockerImageReference, generation, image, additionalProperties);
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
    if (!(created == null)) {
        sb.append("created:");
        sb.append(created);
        sb.append(",");
    }
    if (!(dockerImageReference == null)) {
        sb.append("dockerImageReference:");
        sb.append(dockerImageReference);
        sb.append(",");
    }
    if (!(generation == null)) {
        sb.append("generation:");
        sb.append(generation);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
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
  
  public A withCreated(String created) {
    this.created = created;
    return (A) this;
  }
  
  public A withDockerImageReference(String dockerImageReference) {
    this.dockerImageReference = dockerImageReference;
    return (A) this;
  }
  
  public A withGeneration(Long generation) {
    this.generation = generation;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
}