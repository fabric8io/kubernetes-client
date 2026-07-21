package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class KafkaSinkSpecFluent<A extends io.fabric8.knative.eventing.v1alpha1.KafkaSinkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AuthBuilder auth;
  private List<String> bootstrapServers = new ArrayList<String>();
  private String contentMode;
  private Integer numPartitions;
  private Integer replicationFactor;
  private String topic;

  public KafkaSinkSpecFluent() {
  }
  
  public KafkaSinkSpecFluent(KafkaSinkSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToBootstrapServers(Collection<String> items) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    for (String item : items) {
      this.bootstrapServers.add(item);
    }
    return (A) this;
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
  
  public A addToBootstrapServers(String... items) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    for (String item : items) {
      this.bootstrapServers.add(item);
    }
    return (A) this;
  }
  
  public A addToBootstrapServers(int index,String item) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    this.bootstrapServers.add(index, item);
    return (A) this;
  }
  
  public Auth buildAuth() {
    return this.auth != null ? this.auth.build() : null;
  }
  
  protected void copyInstance(KafkaSinkSpec instance) {
    instance = instance != null ? instance : new KafkaSinkSpec();
    if (instance != null) {
        this.withAuth(instance.getAuth());
        this.withBootstrapServers(instance.getBootstrapServers());
        this.withContentMode(instance.getContentMode());
        this.withNumPartitions(instance.getNumPartitions());
        this.withReplicationFactor(instance.getReplicationFactor());
        this.withTopic(instance.getTopic());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new AuthBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(Auth item) {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(item));
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
    KafkaSinkSpecFluent that = (KafkaSinkSpecFluent) o;
    if (!(Objects.equals(auth, that.auth))) {
      return false;
    }
    if (!(Objects.equals(bootstrapServers, that.bootstrapServers))) {
      return false;
    }
    if (!(Objects.equals(contentMode, that.contentMode))) {
      return false;
    }
    if (!(Objects.equals(numPartitions, that.numPartitions))) {
      return false;
    }
    if (!(Objects.equals(replicationFactor, that.replicationFactor))) {
      return false;
    }
    if (!(Objects.equals(topic, that.topic))) {
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
  
  public String getBootstrapServer(int index) {
    return this.bootstrapServers.get(index);
  }
  
  public List<String> getBootstrapServers() {
    return this.bootstrapServers;
  }
  
  public String getContentMode() {
    return this.contentMode;
  }
  
  public String getFirstBootstrapServer() {
    return this.bootstrapServers.get(0);
  }
  
  public String getLastBootstrapServer() {
    return this.bootstrapServers.get(bootstrapServers.size() - 1);
  }
  
  public String getMatchingBootstrapServer(Predicate<String> predicate) {
      for (String item : bootstrapServers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getNumPartitions() {
    return this.numPartitions;
  }
  
  public Integer getReplicationFactor() {
    return this.replicationFactor;
  }
  
  public String getTopic() {
    return this.topic;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuth() {
    return this.auth != null;
  }
  
  public boolean hasBootstrapServers() {
    return this.bootstrapServers != null && !(this.bootstrapServers.isEmpty());
  }
  
  public boolean hasContentMode() {
    return this.contentMode != null;
  }
  
  public boolean hasMatchingBootstrapServer(Predicate<String> predicate) {
      for (String item : bootstrapServers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNumPartitions() {
    return this.numPartitions != null;
  }
  
  public boolean hasReplicationFactor() {
    return this.replicationFactor != null;
  }
  
  public boolean hasTopic() {
    return this.topic != null;
  }
  
  public int hashCode() {
    return Objects.hash(auth, bootstrapServers, contentMode, numPartitions, replicationFactor, topic, additionalProperties);
  }
  
  public A removeAllFromBootstrapServers(Collection<String> items) {
    if (this.bootstrapServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bootstrapServers.remove(item);
    }
    return (A) this;
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
  
  public A removeFromBootstrapServers(String... items) {
    if (this.bootstrapServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bootstrapServers.remove(item);
    }
    return (A) this;
  }
  
  public A setToBootstrapServers(int index,String item) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    this.bootstrapServers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(auth == null)) {
        sb.append("auth:");
        sb.append(auth);
        sb.append(",");
    }
    if (!(bootstrapServers == null) && !(bootstrapServers.isEmpty())) {
        sb.append("bootstrapServers:");
        sb.append(bootstrapServers);
        sb.append(",");
    }
    if (!(contentMode == null)) {
        sb.append("contentMode:");
        sb.append(contentMode);
        sb.append(",");
    }
    if (!(numPartitions == null)) {
        sb.append("numPartitions:");
        sb.append(numPartitions);
        sb.append(",");
    }
    if (!(replicationFactor == null)) {
        sb.append("replicationFactor:");
        sb.append(replicationFactor);
        sb.append(",");
    }
    if (!(topic == null)) {
        sb.append("topic:");
        sb.append(topic);
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
  
  public A withAuth(Auth auth) {
    this._visitables.remove("auth");
    if (auth != null) {
        this.auth = new AuthBuilder(auth);
        this._visitables.get("auth").add(this.auth);
    } else {
        this.auth = null;
        this._visitables.get("auth").remove(this.auth);
    }
    return (A) this;
  }
  
  public A withBootstrapServers(List<String> bootstrapServers) {
    if (bootstrapServers != null) {
        this.bootstrapServers = new ArrayList();
        for (String item : bootstrapServers) {
          this.addToBootstrapServers(item);
        }
    } else {
      this.bootstrapServers = null;
    }
    return (A) this;
  }
  
  public A withBootstrapServers(String... bootstrapServers) {
    if (this.bootstrapServers != null) {
        this.bootstrapServers.clear();
        _visitables.remove("bootstrapServers");
    }
    if (bootstrapServers != null) {
      for (String item : bootstrapServers) {
        this.addToBootstrapServers(item);
      }
    }
    return (A) this;
  }
  
  public A withContentMode(String contentMode) {
    this.contentMode = contentMode;
    return (A) this;
  }
  
  public AuthNested<A> withNewAuth() {
    return new AuthNested(null);
  }
  
  public AuthNested<A> withNewAuthLike(Auth item) {
    return new AuthNested(item);
  }
  
  public A withNumPartitions(Integer numPartitions) {
    this.numPartitions = numPartitions;
    return (A) this;
  }
  
  public A withReplicationFactor(Integer replicationFactor) {
    this.replicationFactor = replicationFactor;
    return (A) this;
  }
  
  public A withTopic(String topic) {
    this.topic = topic;
    return (A) this;
  }
  public class AuthNested<N> extends AuthFluent<AuthNested<N>> implements Nested<N>{
  
    AuthBuilder builder;
  
    AuthNested(Auth item) {
      this.builder = new AuthBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSinkSpecFluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
}