package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class CouchDbSourceSpecFluent<A extends io.fabric8.knative.sources.v1alpha1.CouchDbSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder credentials;
  private String database;
  private String feed;
  private String serviceAccountName;
  private DestinationBuilder sink;

  public CouchDbSourceSpecFluent() {
  }
  
  public CouchDbSourceSpecFluent(CouchDbSourceSpec instance) {
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
  
  public ObjectReference buildCredentials() {
    return this.credentials != null ? this.credentials.build() : null;
  }
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  protected void copyInstance(CouchDbSourceSpec instance) {
    instance = instance != null ? instance : new CouchDbSourceSpec();
    if (instance != null) {
        this.withCredentials(instance.getCredentials());
        this.withDatabase(instance.getDatabase());
        this.withFeed(instance.getFeed());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSink(instance.getSink());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsNested<A> editCredentials() {
    return this.withNewCredentialsLike(Optional.ofNullable(this.buildCredentials()).orElse(null));
  }
  
  public CredentialsNested<A> editOrNewCredentials() {
    return this.withNewCredentialsLike(Optional.ofNullable(this.buildCredentials()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public CredentialsNested<A> editOrNewCredentialsLike(ObjectReference item) {
    return this.withNewCredentialsLike(Optional.ofNullable(this.buildCredentials()).orElse(item));
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
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
    CouchDbSourceSpecFluent that = (CouchDbSourceSpecFluent) o;
    if (!(Objects.equals(credentials, that.credentials))) {
      return false;
    }
    if (!(Objects.equals(database, that.database))) {
      return false;
    }
    if (!(Objects.equals(feed, that.feed))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
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
  
  public String getDatabase() {
    return this.database;
  }
  
  public String getFeed() {
    return this.feed;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredentials() {
    return this.credentials != null;
  }
  
  public boolean hasDatabase() {
    return this.database != null;
  }
  
  public boolean hasFeed() {
    return this.feed != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public int hashCode() {
    return Objects.hash(credentials, database, feed, serviceAccountName, sink, additionalProperties);
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
    if (!(credentials == null)) {
        sb.append("credentials:");
        sb.append(credentials);
        sb.append(",");
    }
    if (!(database == null)) {
        sb.append("database:");
        sb.append(database);
        sb.append(",");
    }
    if (!(feed == null)) {
        sb.append("feed:");
        sb.append(feed);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
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
  
  public A withCredentials(ObjectReference credentials) {
    this._visitables.remove("credentials");
    if (credentials != null) {
        this.credentials = new ObjectReferenceBuilder(credentials);
        this._visitables.get("credentials").add(this.credentials);
    } else {
        this.credentials = null;
        this._visitables.get("credentials").remove(this.credentials);
    }
    return (A) this;
  }
  
  public A withDatabase(String database) {
    this.database = database;
    return (A) this;
  }
  
  public A withFeed(String feed) {
    this.feed = feed;
    return (A) this;
  }
  
  public CredentialsNested<A> withNewCredentials() {
    return new CredentialsNested(null);
  }
  
  public CredentialsNested<A> withNewCredentialsLike(ObjectReference item) {
    return new CredentialsNested(item);
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withSink(Destination sink) {
    this._visitables.remove("sink");
    if (sink != null) {
        this.sink = new DestinationBuilder(sink);
        this._visitables.get("sink").add(this.sink);
    } else {
        this.sink = null;
        this._visitables.get("sink").remove(this.sink);
    }
    return (A) this;
  }
  public class CredentialsNested<N> extends ObjectReferenceFluent<CredentialsNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    CredentialsNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CouchDbSourceSpecFluent.this.withCredentials(builder.build());
    }
    
    public N endCredentials() {
      return and();
    }
    
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) CouchDbSourceSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
}