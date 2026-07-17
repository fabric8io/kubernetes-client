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
public class BitbucketWebHookCauseFluent<A extends io.fabric8.openshift.api.model.BitbucketWebHookCauseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SourceRevisionBuilder revision;
  private String secret;

  public BitbucketWebHookCauseFluent() {
  }
  
  public BitbucketWebHookCauseFluent(BitbucketWebHookCause instance) {
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
  
  public SourceRevision buildRevision() {
    return this.revision != null ? this.revision.build() : null;
  }
  
  protected void copyInstance(BitbucketWebHookCause instance) {
    instance = instance != null ? instance : new BitbucketWebHookCause();
    if (instance != null) {
        this.withRevision(instance.getRevision());
        this.withSecret(instance.getSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RevisionNested<A> editOrNewRevision() {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(new SourceRevisionBuilder().build()));
  }
  
  public RevisionNested<A> editOrNewRevisionLike(SourceRevision item) {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(item));
  }
  
  public RevisionNested<A> editRevision() {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(null));
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
    BitbucketWebHookCauseFluent that = (BitbucketWebHookCauseFluent) o;
    if (!(Objects.equals(revision, that.revision))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
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
  
  public String getSecret() {
    return this.secret;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRevision() {
    return this.revision != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public int hashCode() {
    return Objects.hash(revision, secret, additionalProperties);
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
    if (!(revision == null)) {
        sb.append("revision:");
        sb.append(revision);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
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
  
  public RevisionNested<A> withNewRevision() {
    return new RevisionNested(null);
  }
  
  public RevisionNested<A> withNewRevisionLike(SourceRevision item) {
    return new RevisionNested(item);
  }
  
  public A withRevision(SourceRevision revision) {
    this._visitables.remove("revision");
    if (revision != null) {
        this.revision = new SourceRevisionBuilder(revision);
        this._visitables.get("revision").add(this.revision);
    } else {
        this.revision = null;
        this._visitables.get("revision").remove(this.revision);
    }
    return (A) this;
  }
  
  public A withSecret(String secret) {
    this.secret = secret;
    return (A) this;
  }
  public class RevisionNested<N> extends SourceRevisionFluent<RevisionNested<N>> implements Nested<N>{
  
    SourceRevisionBuilder builder;
  
    RevisionNested(SourceRevision item) {
      this.builder = new SourceRevisionBuilder(this, item);
    }
  
    public N and() {
      return (N) BitbucketWebHookCauseFluent.this.withRevision(builder.build());
    }
    
    public N endRevision() {
      return and();
    }
    
  }
}