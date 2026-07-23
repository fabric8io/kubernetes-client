package io.fabric8.tekton.triggers.v1alpha1;

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
public class GitLabInterceptorFluent<A extends io.fabric8.tekton.triggers.v1alpha1.GitLabInterceptorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> eventTypes = new ArrayList<String>();
  private SecretRefBuilder secretRef;

  public GitLabInterceptorFluent() {
  }
  
  public GitLabInterceptorFluent(GitLabInterceptor instance) {
    this.copyInstance(instance);
  }

  public A addAllToEventTypes(Collection<String> items) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    for (String item : items) {
      this.eventTypes.add(item);
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
  
  public A addToEventTypes(String... items) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    for (String item : items) {
      this.eventTypes.add(item);
    }
    return (A) this;
  }
  
  public A addToEventTypes(int index,String item) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    this.eventTypes.add(index, item);
    return (A) this;
  }
  
  public SecretRef buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(GitLabInterceptor instance) {
    instance = instance != null ? instance : new GitLabInterceptor();
    if (instance != null) {
        this.withEventTypes(instance.getEventTypes());
        this.withSecretRef(instance.getSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new SecretRefBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(SecretRef item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    GitLabInterceptorFluent that = (GitLabInterceptorFluent) o;
    if (!(Objects.equals(eventTypes, that.eventTypes))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
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
  
  public String getEventType(int index) {
    return this.eventTypes.get(index);
  }
  
  public List<String> getEventTypes() {
    return this.eventTypes;
  }
  
  public String getFirstEventType() {
    return this.eventTypes.get(0);
  }
  
  public String getLastEventType() {
    return this.eventTypes.get(eventTypes.size() - 1);
  }
  
  public String getMatchingEventType(Predicate<String> predicate) {
      for (String item : eventTypes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEventTypes() {
    return this.eventTypes != null && !(this.eventTypes.isEmpty());
  }
  
  public boolean hasMatchingEventType(Predicate<String> predicate) {
      for (String item : eventTypes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(eventTypes, secretRef, additionalProperties);
  }
  
  public A removeAllFromEventTypes(Collection<String> items) {
    if (this.eventTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.eventTypes.remove(item);
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
  
  public A removeFromEventTypes(String... items) {
    if (this.eventTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.eventTypes.remove(item);
    }
    return (A) this;
  }
  
  public A setToEventTypes(int index,String item) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    this.eventTypes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(eventTypes == null) && !(eventTypes.isEmpty())) {
        sb.append("eventTypes:");
        sb.append(eventTypes);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
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
  
  public A withEventTypes(List<String> eventTypes) {
    if (eventTypes != null) {
        this.eventTypes = new ArrayList();
        for (String item : eventTypes) {
          this.addToEventTypes(item);
        }
    } else {
      this.eventTypes = null;
    }
    return (A) this;
  }
  
  public A withEventTypes(String... eventTypes) {
    if (this.eventTypes != null) {
        this.eventTypes.clear();
        _visitables.remove("eventTypes");
    }
    if (eventTypes != null) {
      for (String item : eventTypes) {
        this.addToEventTypes(item);
      }
    }
    return (A) this;
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public A withNewSecretRef(String secretKey,String secretName) {
    return (A) this.withSecretRef(new SecretRef(secretKey, secretName));
  }
  
  public SecretRefNested<A> withNewSecretRefLike(SecretRef item) {
    return new SecretRefNested(item);
  }
  
  public A withSecretRef(SecretRef secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new SecretRefBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
    return (A) this;
  }
  public class SecretRefNested<N> extends SecretRefFluent<SecretRefNested<N>> implements Nested<N>{
  
    SecretRefBuilder builder;
  
    SecretRefNested(SecretRef item) {
      this.builder = new SecretRefBuilder(this, item);
    }
  
    public N and() {
      return (N) GitLabInterceptorFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}