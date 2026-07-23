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
public class ImageChangeTriggerStatusFluent<A extends io.fabric8.openshift.api.model.ImageChangeTriggerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ImageStreamTagReferenceBuilder from;
  private String lastTriggerTime;
  private String lastTriggeredImageID;

  public ImageChangeTriggerStatusFluent() {
  }
  
  public ImageChangeTriggerStatusFluent(ImageChangeTriggerStatus instance) {
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
  
  public ImageStreamTagReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  protected void copyInstance(ImageChangeTriggerStatus instance) {
    instance = instance != null ? instance : new ImageChangeTriggerStatus();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withLastTriggerTime(instance.getLastTriggerTime());
        this.withLastTriggeredImageID(instance.getLastTriggeredImageID());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromNested<A> editFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(null));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ImageStreamTagReferenceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ImageStreamTagReference item) {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(item));
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
    ImageChangeTriggerStatusFluent that = (ImageChangeTriggerStatusFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(lastTriggerTime, that.lastTriggerTime))) {
      return false;
    }
    if (!(Objects.equals(lastTriggeredImageID, that.lastTriggeredImageID))) {
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
  
  public String getLastTriggerTime() {
    return this.lastTriggerTime;
  }
  
  public String getLastTriggeredImageID() {
    return this.lastTriggeredImageID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasLastTriggerTime() {
    return this.lastTriggerTime != null;
  }
  
  public boolean hasLastTriggeredImageID() {
    return this.lastTriggeredImageID != null;
  }
  
  public int hashCode() {
    return Objects.hash(from, lastTriggerTime, lastTriggeredImageID, additionalProperties);
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
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(lastTriggerTime == null)) {
        sb.append("lastTriggerTime:");
        sb.append(lastTriggerTime);
        sb.append(",");
    }
    if (!(lastTriggeredImageID == null)) {
        sb.append("lastTriggeredImageID:");
        sb.append(lastTriggeredImageID);
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
  
  public A withFrom(ImageStreamTagReference from) {
    this._visitables.remove("from");
    if (from != null) {
        this.from = new ImageStreamTagReferenceBuilder(from);
        this._visitables.get("from").add(this.from);
    } else {
        this.from = null;
        this._visitables.get("from").remove(this.from);
    }
    return (A) this;
  }
  
  public A withLastTriggerTime(String lastTriggerTime) {
    this.lastTriggerTime = lastTriggerTime;
    return (A) this;
  }
  
  public A withLastTriggeredImageID(String lastTriggeredImageID) {
    this.lastTriggeredImageID = lastTriggeredImageID;
    return (A) this;
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public A withNewFrom(String name,String namespace) {
    return (A) this.withFrom(new ImageStreamTagReference(name, namespace));
  }
  
  public FromNested<A> withNewFromLike(ImageStreamTagReference item) {
    return new FromNested(item);
  }
  public class FromNested<N> extends ImageStreamTagReferenceFluent<FromNested<N>> implements Nested<N>{
  
    ImageStreamTagReferenceBuilder builder;
  
    FromNested(ImageStreamTagReference item) {
      this.builder = new ImageStreamTagReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageChangeTriggerStatusFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
}