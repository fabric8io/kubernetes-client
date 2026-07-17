package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Long;
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
public class DeploymentConfigRollbackSpecFluent<A extends io.fabric8.openshift.api.model.DeploymentConfigRollbackSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder from;
  private Boolean includeReplicationMeta;
  private Boolean includeStrategy;
  private Boolean includeTemplate;
  private Boolean includeTriggers;
  private Long revision;

  public DeploymentConfigRollbackSpecFluent() {
  }
  
  public DeploymentConfigRollbackSpecFluent(DeploymentConfigRollbackSpec instance) {
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
  
  public ObjectReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  protected void copyInstance(DeploymentConfigRollbackSpec instance) {
    instance = instance != null ? instance : new DeploymentConfigRollbackSpec();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withIncludeReplicationMeta(instance.getIncludeReplicationMeta());
        this.withIncludeStrategy(instance.getIncludeStrategy());
        this.withIncludeTemplate(instance.getIncludeTemplate());
        this.withIncludeTriggers(instance.getIncludeTriggers());
        this.withRevision(instance.getRevision());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromNested<A> editFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(null));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ObjectReference item) {
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
    DeploymentConfigRollbackSpecFluent that = (DeploymentConfigRollbackSpecFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(includeReplicationMeta, that.includeReplicationMeta))) {
      return false;
    }
    if (!(Objects.equals(includeStrategy, that.includeStrategy))) {
      return false;
    }
    if (!(Objects.equals(includeTemplate, that.includeTemplate))) {
      return false;
    }
    if (!(Objects.equals(includeTriggers, that.includeTriggers))) {
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
  
  public Boolean getIncludeReplicationMeta() {
    return this.includeReplicationMeta;
  }
  
  public Boolean getIncludeStrategy() {
    return this.includeStrategy;
  }
  
  public Boolean getIncludeTemplate() {
    return this.includeTemplate;
  }
  
  public Boolean getIncludeTriggers() {
    return this.includeTriggers;
  }
  
  public Long getRevision() {
    return this.revision;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasIncludeReplicationMeta() {
    return this.includeReplicationMeta != null;
  }
  
  public boolean hasIncludeStrategy() {
    return this.includeStrategy != null;
  }
  
  public boolean hasIncludeTemplate() {
    return this.includeTemplate != null;
  }
  
  public boolean hasIncludeTriggers() {
    return this.includeTriggers != null;
  }
  
  public boolean hasRevision() {
    return this.revision != null;
  }
  
  public int hashCode() {
    return Objects.hash(from, includeReplicationMeta, includeStrategy, includeTemplate, includeTriggers, revision, additionalProperties);
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
    if (!(includeReplicationMeta == null)) {
        sb.append("includeReplicationMeta:");
        sb.append(includeReplicationMeta);
        sb.append(",");
    }
    if (!(includeStrategy == null)) {
        sb.append("includeStrategy:");
        sb.append(includeStrategy);
        sb.append(",");
    }
    if (!(includeTemplate == null)) {
        sb.append("includeTemplate:");
        sb.append(includeTemplate);
        sb.append(",");
    }
    if (!(includeTriggers == null)) {
        sb.append("includeTriggers:");
        sb.append(includeTriggers);
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
  
  public A withFrom(ObjectReference from) {
    this._visitables.remove("from");
    if (from != null) {
        this.from = new ObjectReferenceBuilder(from);
        this._visitables.get("from").add(this.from);
    } else {
        this.from = null;
        this._visitables.get("from").remove(this.from);
    }
    return (A) this;
  }
  
  public A withIncludeReplicationMeta() {
    return withIncludeReplicationMeta(true);
  }
  
  public A withIncludeReplicationMeta(Boolean includeReplicationMeta) {
    this.includeReplicationMeta = includeReplicationMeta;
    return (A) this;
  }
  
  public A withIncludeStrategy() {
    return withIncludeStrategy(true);
  }
  
  public A withIncludeStrategy(Boolean includeStrategy) {
    this.includeStrategy = includeStrategy;
    return (A) this;
  }
  
  public A withIncludeTemplate() {
    return withIncludeTemplate(true);
  }
  
  public A withIncludeTemplate(Boolean includeTemplate) {
    this.includeTemplate = includeTemplate;
    return (A) this;
  }
  
  public A withIncludeTriggers() {
    return withIncludeTriggers(true);
  }
  
  public A withIncludeTriggers(Boolean includeTriggers) {
    this.includeTriggers = includeTriggers;
    return (A) this;
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public FromNested<A> withNewFromLike(ObjectReference item) {
    return new FromNested(item);
  }
  
  public A withRevision(Long revision) {
    this.revision = revision;
    return (A) this;
  }
  public class FromNested<N> extends ObjectReferenceFluent<FromNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    FromNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentConfigRollbackSpecFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
}