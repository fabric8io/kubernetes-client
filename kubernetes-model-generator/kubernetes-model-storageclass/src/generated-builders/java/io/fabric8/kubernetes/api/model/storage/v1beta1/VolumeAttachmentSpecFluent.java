package io.fabric8.kubernetes.api.model.storage.v1beta1;

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
public class VolumeAttachmentSpecFluent<A extends io.fabric8.kubernetes.api.model.storage.v1beta1.VolumeAttachmentSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String attacher;
  private String nodeName;
  private VolumeAttachmentSourceBuilder source;

  public VolumeAttachmentSpecFluent() {
  }
  
  public VolumeAttachmentSpecFluent(VolumeAttachmentSpec instance) {
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
  
  public VolumeAttachmentSource buildSource() {
    return this.source != null ? this.source.build() : null;
  }
  
  protected void copyInstance(VolumeAttachmentSpec instance) {
    instance = instance != null ? instance : new VolumeAttachmentSpec();
    if (instance != null) {
        this.withAttacher(instance.getAttacher());
        this.withNodeName(instance.getNodeName());
        this.withSource(instance.getSource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourceNested<A> editOrNewSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(new VolumeAttachmentSourceBuilder().build()));
  }
  
  public SourceNested<A> editOrNewSourceLike(VolumeAttachmentSource item) {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(item));
  }
  
  public SourceNested<A> editSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(null));
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
    VolumeAttachmentSpecFluent that = (VolumeAttachmentSpecFluent) o;
    if (!(Objects.equals(attacher, that.attacher))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
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
  
  public String getAttacher() {
    return this.attacher;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttacher() {
    return this.attacher != null;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public int hashCode() {
    return Objects.hash(attacher, nodeName, source, additionalProperties);
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
    if (!(attacher == null)) {
        sb.append("attacher:");
        sb.append(attacher);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
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
  
  public A withAttacher(String attacher) {
    this.attacher = attacher;
    return (A) this;
  }
  
  public SourceNested<A> withNewSource() {
    return new SourceNested(null);
  }
  
  public SourceNested<A> withNewSourceLike(VolumeAttachmentSource item) {
    return new SourceNested(item);
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withSource(VolumeAttachmentSource source) {
    this._visitables.remove("source");
    if (source != null) {
        this.source = new VolumeAttachmentSourceBuilder(source);
        this._visitables.get("source").add(this.source);
    } else {
        this.source = null;
        this._visitables.get("source").remove(this.source);
    }
    return (A) this;
  }
  public class SourceNested<N> extends VolumeAttachmentSourceFluent<SourceNested<N>> implements Nested<N>{
  
    VolumeAttachmentSourceBuilder builder;
  
    SourceNested(VolumeAttachmentSource item) {
      this.builder = new VolumeAttachmentSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeAttachmentSpecFluent.this.withSource(builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}