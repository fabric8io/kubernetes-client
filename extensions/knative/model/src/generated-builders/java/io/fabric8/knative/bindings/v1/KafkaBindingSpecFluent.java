package io.fabric8.knative.bindings.v1;

import io.fabric8.knative.pkg.tracker.Reference;
import io.fabric8.knative.pkg.tracker.ReferenceBuilder;
import io.fabric8.knative.pkg.tracker.ReferenceFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class KafkaBindingSpecFluent<A extends io.fabric8.knative.bindings.v1.KafkaBindingSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> bootstrapServers = new ArrayList<String>();
  private KafkaNetSpecBuilder net;
  private ReferenceBuilder subject;

  public KafkaBindingSpecFluent() {
  }
  
  public KafkaBindingSpecFluent(KafkaBindingSpec instance) {
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
  
  public KafkaNetSpec buildNet() {
    return this.net != null ? this.net.build() : null;
  }
  
  public Reference buildSubject() {
    return this.subject != null ? this.subject.build() : null;
  }
  
  protected void copyInstance(KafkaBindingSpec instance) {
    instance = instance != null ? instance : new KafkaBindingSpec();
    if (instance != null) {
        this.withBootstrapServers(instance.getBootstrapServers());
        this.withNet(instance.getNet());
        this.withSubject(instance.getSubject());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetNested<A> editNet() {
    return this.withNewNetLike(Optional.ofNullable(this.buildNet()).orElse(null));
  }
  
  public NetNested<A> editOrNewNet() {
    return this.withNewNetLike(Optional.ofNullable(this.buildNet()).orElse(new KafkaNetSpecBuilder().build()));
  }
  
  public NetNested<A> editOrNewNetLike(KafkaNetSpec item) {
    return this.withNewNetLike(Optional.ofNullable(this.buildNet()).orElse(item));
  }
  
  public SubjectNested<A> editOrNewSubject() {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(new ReferenceBuilder().build()));
  }
  
  public SubjectNested<A> editOrNewSubjectLike(Reference item) {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(item));
  }
  
  public SubjectNested<A> editSubject() {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(null));
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
    KafkaBindingSpecFluent that = (KafkaBindingSpecFluent) o;
    if (!(Objects.equals(bootstrapServers, that.bootstrapServers))) {
      return false;
    }
    if (!(Objects.equals(net, that.net))) {
      return false;
    }
    if (!(Objects.equals(subject, that.subject))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootstrapServers() {
    return this.bootstrapServers != null && !(this.bootstrapServers.isEmpty());
  }
  
  public boolean hasMatchingBootstrapServer(Predicate<String> predicate) {
      for (String item : bootstrapServers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNet() {
    return this.net != null;
  }
  
  public boolean hasSubject() {
    return this.subject != null;
  }
  
  public int hashCode() {
    return Objects.hash(bootstrapServers, net, subject, additionalProperties);
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
    if (!(bootstrapServers == null) && !(bootstrapServers.isEmpty())) {
        sb.append("bootstrapServers:");
        sb.append(bootstrapServers);
        sb.append(",");
    }
    if (!(net == null)) {
        sb.append("net:");
        sb.append(net);
        sb.append(",");
    }
    if (!(subject == null)) {
        sb.append("subject:");
        sb.append(subject);
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
  
  public A withNet(KafkaNetSpec net) {
    this._visitables.remove("net");
    if (net != null) {
        this.net = new KafkaNetSpecBuilder(net);
        this._visitables.get("net").add(this.net);
    } else {
        this.net = null;
        this._visitables.get("net").remove(this.net);
    }
    return (A) this;
  }
  
  public NetNested<A> withNewNet() {
    return new NetNested(null);
  }
  
  public NetNested<A> withNewNetLike(KafkaNetSpec item) {
    return new NetNested(item);
  }
  
  public SubjectNested<A> withNewSubject() {
    return new SubjectNested(null);
  }
  
  public SubjectNested<A> withNewSubjectLike(Reference item) {
    return new SubjectNested(item);
  }
  
  public A withSubject(Reference subject) {
    this._visitables.remove("subject");
    if (subject != null) {
        this.subject = new ReferenceBuilder(subject);
        this._visitables.get("subject").add(this.subject);
    } else {
        this.subject = null;
        this._visitables.get("subject").remove(this.subject);
    }
    return (A) this;
  }
  public class NetNested<N> extends KafkaNetSpecFluent<NetNested<N>> implements Nested<N>{
  
    KafkaNetSpecBuilder builder;
  
    NetNested(KafkaNetSpec item) {
      this.builder = new KafkaNetSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaBindingSpecFluent.this.withNet(builder.build());
    }
    
    public N endNet() {
      return and();
    }
    
  }
  public class SubjectNested<N> extends ReferenceFluent<SubjectNested<N>> implements Nested<N>{
  
    ReferenceBuilder builder;
  
    SubjectNested(Reference item) {
      this.builder = new ReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaBindingSpecFluent.this.withSubject(builder.build());
    }
    
    public N endSubject() {
      return and();
    }
    
  }
}