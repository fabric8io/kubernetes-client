package io.fabric8.knative.eventing.v1alpha1;

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
public class EventPolicySpecToFluent<A extends io.fabric8.knative.eventing.v1alpha1.EventPolicySpecToFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EventPolicyToReferenceBuilder ref;
  private EventPolicySelectorBuilder selector;

  public EventPolicySpecToFluent() {
  }
  
  public EventPolicySpecToFluent(EventPolicySpecTo instance) {
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
  
  public EventPolicyToReference buildRef() {
    return this.ref != null ? this.ref.build() : null;
  }
  
  public EventPolicySelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(EventPolicySpecTo instance) {
    instance = instance != null ? instance : new EventPolicySpecTo();
    if (instance != null) {
        this.withRef(instance.getRef());
        this.withSelector(instance.getSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RefNested<A> editOrNewRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(new EventPolicyToReferenceBuilder().build()));
  }
  
  public RefNested<A> editOrNewRefLike(EventPolicyToReference item) {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new EventPolicySelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(EventPolicySelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public RefNested<A> editRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    EventPolicySpecToFluent that = (EventPolicySpecToFluent) o;
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(ref, selector, additionalProperties);
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
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
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
  
  public RefNested<A> withNewRef() {
    return new RefNested(null);
  }
  
  public A withNewRef(String apiVersion,String kind,String name) {
    return (A) this.withRef(new EventPolicyToReference(apiVersion, kind, name));
  }
  
  public RefNested<A> withNewRefLike(EventPolicyToReference item) {
    return new RefNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(EventPolicySelector item) {
    return new SelectorNested(item);
  }
  
  public A withRef(EventPolicyToReference ref) {
    this._visitables.remove("ref");
    if (ref != null) {
        this.ref = new EventPolicyToReferenceBuilder(ref);
        this._visitables.get("ref").add(this.ref);
    } else {
        this.ref = null;
        this._visitables.get("ref").remove(this.ref);
    }
    return (A) this;
  }
  
  public A withSelector(EventPolicySelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new EventPolicySelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  public class RefNested<N> extends EventPolicyToReferenceFluent<RefNested<N>> implements Nested<N>{
  
    EventPolicyToReferenceBuilder builder;
  
    RefNested(EventPolicyToReference item) {
      this.builder = new EventPolicyToReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EventPolicySpecToFluent.this.withRef(builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends EventPolicySelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    EventPolicySelectorBuilder builder;
  
    SelectorNested(EventPolicySelector item) {
      this.builder = new EventPolicySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EventPolicySpecToFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}