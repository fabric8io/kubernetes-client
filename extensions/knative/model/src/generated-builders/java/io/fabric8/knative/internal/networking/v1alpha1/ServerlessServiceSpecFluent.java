package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class ServerlessServiceSpecFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.ServerlessServiceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mode;
  private Integer numActivators;
  private ObjectReferenceBuilder objectRef;
  private String protocolType;

  public ServerlessServiceSpecFluent() {
  }
  
  public ServerlessServiceSpecFluent(ServerlessServiceSpec instance) {
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
  
  public ObjectReference buildObjectRef() {
    return this.objectRef != null ? this.objectRef.build() : null;
  }
  
  protected void copyInstance(ServerlessServiceSpec instance) {
    instance = instance != null ? instance : new ServerlessServiceSpec();
    if (instance != null) {
        this.withMode(instance.getMode());
        this.withNumActivators(instance.getNumActivators());
        this.withObjectRef(instance.getObjectRef());
        this.withProtocolType(instance.getProtocolType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ObjectRefNested<A> editObjectRef() {
    return this.withNewObjectRefLike(Optional.ofNullable(this.buildObjectRef()).orElse(null));
  }
  
  public ObjectRefNested<A> editOrNewObjectRef() {
    return this.withNewObjectRefLike(Optional.ofNullable(this.buildObjectRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ObjectRefNested<A> editOrNewObjectRefLike(ObjectReference item) {
    return this.withNewObjectRefLike(Optional.ofNullable(this.buildObjectRef()).orElse(item));
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
    ServerlessServiceSpecFluent that = (ServerlessServiceSpecFluent) o;
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(numActivators, that.numActivators))) {
      return false;
    }
    if (!(Objects.equals(objectRef, that.objectRef))) {
      return false;
    }
    if (!(Objects.equals(protocolType, that.protocolType))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public Integer getNumActivators() {
    return this.numActivators;
  }
  
  public String getProtocolType() {
    return this.protocolType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasNumActivators() {
    return this.numActivators != null;
  }
  
  public boolean hasObjectRef() {
    return this.objectRef != null;
  }
  
  public boolean hasProtocolType() {
    return this.protocolType != null;
  }
  
  public int hashCode() {
    return Objects.hash(mode, numActivators, objectRef, protocolType, additionalProperties);
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
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(numActivators == null)) {
        sb.append("numActivators:");
        sb.append(numActivators);
        sb.append(",");
    }
    if (!(objectRef == null)) {
        sb.append("objectRef:");
        sb.append(objectRef);
        sb.append(",");
    }
    if (!(protocolType == null)) {
        sb.append("protocolType:");
        sb.append(protocolType);
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
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public ObjectRefNested<A> withNewObjectRef() {
    return new ObjectRefNested(null);
  }
  
  public ObjectRefNested<A> withNewObjectRefLike(ObjectReference item) {
    return new ObjectRefNested(item);
  }
  
  public A withNumActivators(Integer numActivators) {
    this.numActivators = numActivators;
    return (A) this;
  }
  
  public A withObjectRef(ObjectReference objectRef) {
    this._visitables.remove("objectRef");
    if (objectRef != null) {
        this.objectRef = new ObjectReferenceBuilder(objectRef);
        this._visitables.get("objectRef").add(this.objectRef);
    } else {
        this.objectRef = null;
        this._visitables.get("objectRef").remove(this.objectRef);
    }
    return (A) this;
  }
  
  public A withProtocolType(String protocolType) {
    this.protocolType = protocolType;
    return (A) this;
  }
  public class ObjectRefNested<N> extends ObjectReferenceFluent<ObjectRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ObjectRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ServerlessServiceSpecFluent.this.withObjectRef(builder.build());
    }
    
    public N endObjectRef() {
      return and();
    }
    
  }
}