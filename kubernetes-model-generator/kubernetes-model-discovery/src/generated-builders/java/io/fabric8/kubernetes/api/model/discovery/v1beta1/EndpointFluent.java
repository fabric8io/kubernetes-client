package io.fabric8.kubernetes.api.model.discovery.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
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
public class EndpointFluent<A extends io.fabric8.kubernetes.api.model.discovery.v1beta1.EndpointFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> addresses = new ArrayList<String>();
  private EndpointConditionsBuilder conditions;
  private EndpointHintsBuilder hints;
  private String hostname;
  private String nodeName;
  private ObjectReferenceBuilder targetRef;
  private Map<String,String> topology;

  public EndpointFluent() {
  }
  
  public EndpointFluent(Endpoint instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<String> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (String item : items) {
      this.addresses.add(item);
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
  
  public A addToAddresses(String... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (String item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,String item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.add(index, item);
    return (A) this;
  }
  
  public A addToTopology(Map<String,String> map) {
    if (this.topology == null && map != null) {
      this.topology = new LinkedHashMap();
    }
    if (map != null) {
      this.topology.putAll(map);
    }
    return (A) this;
  }
  
  public A addToTopology(String key,String value) {
    if (this.topology == null && key != null && value != null) {
      this.topology = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.topology.put(key, value);
    }
    return (A) this;
  }
  
  public EndpointConditions buildConditions() {
    return this.conditions != null ? this.conditions.build() : null;
  }
  
  public EndpointHints buildHints() {
    return this.hints != null ? this.hints.build() : null;
  }
  
  public ObjectReference buildTargetRef() {
    return this.targetRef != null ? this.targetRef.build() : null;
  }
  
  protected void copyInstance(Endpoint instance) {
    instance = instance != null ? instance : new Endpoint();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withConditions(instance.getConditions());
        this.withHints(instance.getHints());
        this.withHostname(instance.getHostname());
        this.withNodeName(instance.getNodeName());
        this.withTargetRef(instance.getTargetRef());
        this.withTopology(instance.getTopology());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editConditions() {
    return this.withNewConditionsLike(Optional.ofNullable(this.buildConditions()).orElse(null));
  }
  
  public HintsNested<A> editHints() {
    return this.withNewHintsLike(Optional.ofNullable(this.buildHints()).orElse(null));
  }
  
  public ConditionsNested<A> editOrNewConditions() {
    return this.withNewConditionsLike(Optional.ofNullable(this.buildConditions()).orElse(new EndpointConditionsBuilder().build()));
  }
  
  public ConditionsNested<A> editOrNewConditionsLike(EndpointConditions item) {
    return this.withNewConditionsLike(Optional.ofNullable(this.buildConditions()).orElse(item));
  }
  
  public HintsNested<A> editOrNewHints() {
    return this.withNewHintsLike(Optional.ofNullable(this.buildHints()).orElse(new EndpointHintsBuilder().build()));
  }
  
  public HintsNested<A> editOrNewHintsLike(EndpointHints item) {
    return this.withNewHintsLike(Optional.ofNullable(this.buildHints()).orElse(item));
  }
  
  public TargetRefNested<A> editOrNewTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public TargetRefNested<A> editOrNewTargetRefLike(ObjectReference item) {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(item));
  }
  
  public TargetRefNested<A> editTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(null));
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
    EndpointFluent that = (EndpointFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(hints, that.hints))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(targetRef, that.targetRef))) {
      return false;
    }
    if (!(Objects.equals(topology, that.topology))) {
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
  
  public String getAddress(int index) {
    return this.addresses.get(index);
  }
  
  public List<String> getAddresses() {
    return this.addresses;
  }
  
  public String getFirstAddress() {
    return this.addresses.get(0);
  }
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getLastAddress() {
    return this.addresses.get(addresses.size() - 1);
  }
  
  public String getMatchingAddress(Predicate<String> predicate) {
      for (String item : addresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public Map<String,String> getTopology() {
    return this.topology;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null;
  }
  
  public boolean hasHints() {
    return this.hints != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasMatchingAddress(Predicate<String> predicate) {
      for (String item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasTargetRef() {
    return this.targetRef != null;
  }
  
  public boolean hasTopology() {
    return this.topology != null;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, conditions, hints, hostname, nodeName, targetRef, topology, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<String> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.addresses.remove(item);
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
  
  public A removeFromAddresses(String... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTopology(String key) {
    if (this.topology == null) {
      return (A) this;
    }
    if (key != null && this.topology != null) {
      this.topology.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromTopology(Map<String,String> map) {
    if (this.topology == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.topology != null) {
          this.topology.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToAddresses(int index,String item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
        sb.append(",");
    }
    if (!(conditions == null)) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(hints == null)) {
        sb.append("hints:");
        sb.append(hints);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(targetRef == null)) {
        sb.append("targetRef:");
        sb.append(targetRef);
        sb.append(",");
    }
    if (!(topology == null) && !(topology.isEmpty())) {
        sb.append("topology:");
        sb.append(topology);
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
  
  public A withAddresses(List<String> addresses) {
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (String item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(String... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (String item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(EndpointConditions conditions) {
    this._visitables.remove("conditions");
    if (conditions != null) {
        this.conditions = new EndpointConditionsBuilder(conditions);
        this._visitables.get("conditions").add(this.conditions);
    } else {
        this.conditions = null;
        this._visitables.get("conditions").remove(this.conditions);
    }
    return (A) this;
  }
  
  public A withHints(EndpointHints hints) {
    this._visitables.remove("hints");
    if (hints != null) {
        this.hints = new EndpointHintsBuilder(hints);
        this._visitables.get("hints").add(this.hints);
    } else {
        this.hints = null;
        this._visitables.get("hints").remove(this.hints);
    }
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public ConditionsNested<A> withNewConditions() {
    return new ConditionsNested(null);
  }
  
  public A withNewConditions(Boolean ready,Boolean serving,Boolean terminating) {
    return (A) this.withConditions(new EndpointConditions(ready, serving, terminating));
  }
  
  public ConditionsNested<A> withNewConditionsLike(EndpointConditions item) {
    return new ConditionsNested(item);
  }
  
  public HintsNested<A> withNewHints() {
    return new HintsNested(null);
  }
  
  public HintsNested<A> withNewHintsLike(EndpointHints item) {
    return new HintsNested(item);
  }
  
  public TargetRefNested<A> withNewTargetRef() {
    return new TargetRefNested(null);
  }
  
  public TargetRefNested<A> withNewTargetRefLike(ObjectReference item) {
    return new TargetRefNested(item);
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withTargetRef(ObjectReference targetRef) {
    this._visitables.remove("targetRef");
    if (targetRef != null) {
        this.targetRef = new ObjectReferenceBuilder(targetRef);
        this._visitables.get("targetRef").add(this.targetRef);
    } else {
        this.targetRef = null;
        this._visitables.get("targetRef").remove(this.targetRef);
    }
    return (A) this;
  }
  
  public <K,V>A withTopology(Map<String,String> topology) {
    if (topology == null) {
      this.topology = null;
    } else {
      this.topology = new LinkedHashMap(topology);
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends EndpointConditionsFluent<ConditionsNested<N>> implements Nested<N>{
  
    EndpointConditionsBuilder builder;
  
    ConditionsNested(EndpointConditions item) {
      this.builder = new EndpointConditionsBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withConditions(builder.build());
    }
    
    public N endConditions() {
      return and();
    }
    
  }
  public class HintsNested<N> extends EndpointHintsFluent<HintsNested<N>> implements Nested<N>{
  
    EndpointHintsBuilder builder;
  
    HintsNested(EndpointHints item) {
      this.builder = new EndpointHintsBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withHints(builder.build());
    }
    
    public N endHints() {
      return and();
    }
    
  }
  public class TargetRefNested<N> extends ObjectReferenceFluent<TargetRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    TargetRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withTargetRef(builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
}