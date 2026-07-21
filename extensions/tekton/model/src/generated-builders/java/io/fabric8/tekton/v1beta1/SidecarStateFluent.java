package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.ContainerStateRunning;
import io.fabric8.kubernetes.api.model.ContainerStateTerminated;
import io.fabric8.kubernetes.api.model.ContainerStateWaiting;
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
public class SidecarStateFluent<A extends io.fabric8.tekton.v1beta1.SidecarStateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String container;
  private String imageID;
  private String name;
  private ContainerStateRunning running;
  private ContainerStateTerminated terminated;
  private ContainerStateWaiting waiting;

  public SidecarStateFluent() {
  }
  
  public SidecarStateFluent(SidecarState instance) {
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
  
  protected void copyInstance(SidecarState instance) {
    instance = instance != null ? instance : new SidecarState();
    if (instance != null) {
        this.withContainer(instance.getContainer());
        this.withImageID(instance.getImageID());
        this.withName(instance.getName());
        this.withRunning(instance.getRunning());
        this.withTerminated(instance.getTerminated());
        this.withWaiting(instance.getWaiting());
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
    SidecarStateFluent that = (SidecarStateFluent) o;
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(imageID, that.imageID))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(running, that.running))) {
      return false;
    }
    if (!(Objects.equals(terminated, that.terminated))) {
      return false;
    }
    if (!(Objects.equals(waiting, that.waiting))) {
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
  
  public String getContainer() {
    return this.container;
  }
  
  public String getImageID() {
    return this.imageID;
  }
  
  public String getName() {
    return this.name;
  }
  
  public ContainerStateRunning getRunning() {
    return this.running;
  }
  
  public ContainerStateTerminated getTerminated() {
    return this.terminated;
  }
  
  public ContainerStateWaiting getWaiting() {
    return this.waiting;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasImageID() {
    return this.imageID != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRunning() {
    return this.running != null;
  }
  
  public boolean hasTerminated() {
    return this.terminated != null;
  }
  
  public boolean hasWaiting() {
    return this.waiting != null;
  }
  
  public int hashCode() {
    return Objects.hash(container, imageID, name, running, terminated, waiting, additionalProperties);
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
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(imageID == null)) {
        sb.append("imageID:");
        sb.append(imageID);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(running == null)) {
        sb.append("running:");
        sb.append(running);
        sb.append(",");
    }
    if (!(terminated == null)) {
        sb.append("terminated:");
        sb.append(terminated);
        sb.append(",");
    }
    if (!(waiting == null)) {
        sb.append("waiting:");
        sb.append(waiting);
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
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withImageID(String imageID) {
    this.imageID = imageID;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNewRunning(String startedAt) {
    return (A) this.withRunning(new ContainerStateRunning(startedAt));
  }
  
  public A withNewWaiting(String message,String reason) {
    return (A) this.withWaiting(new ContainerStateWaiting(message, reason));
  }
  
  public A withRunning(ContainerStateRunning running) {
    this.running = running;
    return (A) this;
  }
  
  public A withTerminated(ContainerStateTerminated terminated) {
    this.terminated = terminated;
    return (A) this;
  }
  
  public A withWaiting(ContainerStateWaiting waiting) {
    this.waiting = waiting;
    return (A) this;
  }
  
}