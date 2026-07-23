package io.fabric8.kubernetes.api.model;

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
public class NodeConfigStatusFluent<A extends io.fabric8.kubernetes.api.model.NodeConfigStatusFluent<A>> extends BaseFluent<A>{

  private NodeConfigSourceBuilder active;
  private Map<String,Object> additionalProperties;
  private NodeConfigSourceBuilder assigned;
  private String error;
  private NodeConfigSourceBuilder lastKnownGood;

  public NodeConfigStatusFluent() {
  }
  
  public NodeConfigStatusFluent(NodeConfigStatus instance) {
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
  
  public NodeConfigSource buildActive() {
    return this.active != null ? this.active.build() : null;
  }
  
  public NodeConfigSource buildAssigned() {
    return this.assigned != null ? this.assigned.build() : null;
  }
  
  public NodeConfigSource buildLastKnownGood() {
    return this.lastKnownGood != null ? this.lastKnownGood.build() : null;
  }
  
  protected void copyInstance(NodeConfigStatus instance) {
    instance = instance != null ? instance : new NodeConfigStatus();
    if (instance != null) {
        this.withActive(instance.getActive());
        this.withAssigned(instance.getAssigned());
        this.withError(instance.getError());
        this.withLastKnownGood(instance.getLastKnownGood());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActiveNested<A> editActive() {
    return this.withNewActiveLike(Optional.ofNullable(this.buildActive()).orElse(null));
  }
  
  public AssignedNested<A> editAssigned() {
    return this.withNewAssignedLike(Optional.ofNullable(this.buildAssigned()).orElse(null));
  }
  
  public LastKnownGoodNested<A> editLastKnownGood() {
    return this.withNewLastKnownGoodLike(Optional.ofNullable(this.buildLastKnownGood()).orElse(null));
  }
  
  public ActiveNested<A> editOrNewActive() {
    return this.withNewActiveLike(Optional.ofNullable(this.buildActive()).orElse(new NodeConfigSourceBuilder().build()));
  }
  
  public ActiveNested<A> editOrNewActiveLike(NodeConfigSource item) {
    return this.withNewActiveLike(Optional.ofNullable(this.buildActive()).orElse(item));
  }
  
  public AssignedNested<A> editOrNewAssigned() {
    return this.withNewAssignedLike(Optional.ofNullable(this.buildAssigned()).orElse(new NodeConfigSourceBuilder().build()));
  }
  
  public AssignedNested<A> editOrNewAssignedLike(NodeConfigSource item) {
    return this.withNewAssignedLike(Optional.ofNullable(this.buildAssigned()).orElse(item));
  }
  
  public LastKnownGoodNested<A> editOrNewLastKnownGood() {
    return this.withNewLastKnownGoodLike(Optional.ofNullable(this.buildLastKnownGood()).orElse(new NodeConfigSourceBuilder().build()));
  }
  
  public LastKnownGoodNested<A> editOrNewLastKnownGoodLike(NodeConfigSource item) {
    return this.withNewLastKnownGoodLike(Optional.ofNullable(this.buildLastKnownGood()).orElse(item));
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
    NodeConfigStatusFluent that = (NodeConfigStatusFluent) o;
    if (!(Objects.equals(active, that.active))) {
      return false;
    }
    if (!(Objects.equals(assigned, that.assigned))) {
      return false;
    }
    if (!(Objects.equals(error, that.error))) {
      return false;
    }
    if (!(Objects.equals(lastKnownGood, that.lastKnownGood))) {
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
  
  public String getError() {
    return this.error;
  }
  
  public boolean hasActive() {
    return this.active != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAssigned() {
    return this.assigned != null;
  }
  
  public boolean hasError() {
    return this.error != null;
  }
  
  public boolean hasLastKnownGood() {
    return this.lastKnownGood != null;
  }
  
  public int hashCode() {
    return Objects.hash(active, assigned, error, lastKnownGood, additionalProperties);
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
    if (!(active == null)) {
        sb.append("active:");
        sb.append(active);
        sb.append(",");
    }
    if (!(assigned == null)) {
        sb.append("assigned:");
        sb.append(assigned);
        sb.append(",");
    }
    if (!(error == null)) {
        sb.append("error:");
        sb.append(error);
        sb.append(",");
    }
    if (!(lastKnownGood == null)) {
        sb.append("lastKnownGood:");
        sb.append(lastKnownGood);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActive(NodeConfigSource active) {
    this._visitables.remove("active");
    if (active != null) {
        this.active = new NodeConfigSourceBuilder(active);
        this._visitables.get("active").add(this.active);
    } else {
        this.active = null;
        this._visitables.get("active").remove(this.active);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAssigned(NodeConfigSource assigned) {
    this._visitables.remove("assigned");
    if (assigned != null) {
        this.assigned = new NodeConfigSourceBuilder(assigned);
        this._visitables.get("assigned").add(this.assigned);
    } else {
        this.assigned = null;
        this._visitables.get("assigned").remove(this.assigned);
    }
    return (A) this;
  }
  
  public A withError(String error) {
    this.error = error;
    return (A) this;
  }
  
  public A withLastKnownGood(NodeConfigSource lastKnownGood) {
    this._visitables.remove("lastKnownGood");
    if (lastKnownGood != null) {
        this.lastKnownGood = new NodeConfigSourceBuilder(lastKnownGood);
        this._visitables.get("lastKnownGood").add(this.lastKnownGood);
    } else {
        this.lastKnownGood = null;
        this._visitables.get("lastKnownGood").remove(this.lastKnownGood);
    }
    return (A) this;
  }
  
  public ActiveNested<A> withNewActive() {
    return new ActiveNested(null);
  }
  
  public ActiveNested<A> withNewActiveLike(NodeConfigSource item) {
    return new ActiveNested(item);
  }
  
  public AssignedNested<A> withNewAssigned() {
    return new AssignedNested(null);
  }
  
  public AssignedNested<A> withNewAssignedLike(NodeConfigSource item) {
    return new AssignedNested(item);
  }
  
  public LastKnownGoodNested<A> withNewLastKnownGood() {
    return new LastKnownGoodNested(null);
  }
  
  public LastKnownGoodNested<A> withNewLastKnownGoodLike(NodeConfigSource item) {
    return new LastKnownGoodNested(item);
  }
  public class ActiveNested<N> extends NodeConfigSourceFluent<ActiveNested<N>> implements Nested<N>{
  
    NodeConfigSourceBuilder builder;
  
    ActiveNested(NodeConfigSource item) {
      this.builder = new NodeConfigSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeConfigStatusFluent.this.withActive(builder.build());
    }
    
    public N endActive() {
      return and();
    }
    
  }
  public class AssignedNested<N> extends NodeConfigSourceFluent<AssignedNested<N>> implements Nested<N>{
  
    NodeConfigSourceBuilder builder;
  
    AssignedNested(NodeConfigSource item) {
      this.builder = new NodeConfigSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeConfigStatusFluent.this.withAssigned(builder.build());
    }
    
    public N endAssigned() {
      return and();
    }
    
  }
  public class LastKnownGoodNested<N> extends NodeConfigSourceFluent<LastKnownGoodNested<N>> implements Nested<N>{
  
    NodeConfigSourceBuilder builder;
  
    LastKnownGoodNested(NodeConfigSource item) {
      this.builder = new NodeConfigSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeConfigStatusFluent.this.withLastKnownGood(builder.build());
    }
    
    public N endLastKnownGood() {
      return and();
    }
    
  }
}