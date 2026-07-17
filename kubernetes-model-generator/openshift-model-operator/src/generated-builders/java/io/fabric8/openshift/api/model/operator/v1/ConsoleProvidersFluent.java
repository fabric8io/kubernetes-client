package io.fabric8.openshift.api.model.operator.v1;

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
public class ConsoleProvidersFluent<A extends io.fabric8.openshift.api.model.operator.v1.ConsoleProvidersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private StatuspageProviderBuilder statuspage;

  public ConsoleProvidersFluent() {
  }
  
  public ConsoleProvidersFluent(ConsoleProviders instance) {
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
  
  public StatuspageProvider buildStatuspage() {
    return this.statuspage != null ? this.statuspage.build() : null;
  }
  
  protected void copyInstance(ConsoleProviders instance) {
    instance = instance != null ? instance : new ConsoleProviders();
    if (instance != null) {
        this.withStatuspage(instance.getStatuspage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StatuspageNested<A> editOrNewStatuspage() {
    return this.withNewStatuspageLike(Optional.ofNullable(this.buildStatuspage()).orElse(new StatuspageProviderBuilder().build()));
  }
  
  public StatuspageNested<A> editOrNewStatuspageLike(StatuspageProvider item) {
    return this.withNewStatuspageLike(Optional.ofNullable(this.buildStatuspage()).orElse(item));
  }
  
  public StatuspageNested<A> editStatuspage() {
    return this.withNewStatuspageLike(Optional.ofNullable(this.buildStatuspage()).orElse(null));
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
    ConsoleProvidersFluent that = (ConsoleProvidersFluent) o;
    if (!(Objects.equals(statuspage, that.statuspage))) {
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
  
  public boolean hasStatuspage() {
    return this.statuspage != null;
  }
  
  public int hashCode() {
    return Objects.hash(statuspage, additionalProperties);
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
    if (!(statuspage == null)) {
        sb.append("statuspage:");
        sb.append(statuspage);
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
  
  public StatuspageNested<A> withNewStatuspage() {
    return new StatuspageNested(null);
  }
  
  public A withNewStatuspage(String pageID) {
    return (A) this.withStatuspage(new StatuspageProvider(pageID));
  }
  
  public StatuspageNested<A> withNewStatuspageLike(StatuspageProvider item) {
    return new StatuspageNested(item);
  }
  
  public A withStatuspage(StatuspageProvider statuspage) {
    this._visitables.remove("statuspage");
    if (statuspage != null) {
        this.statuspage = new StatuspageProviderBuilder(statuspage);
        this._visitables.get("statuspage").add(this.statuspage);
    } else {
        this.statuspage = null;
        this._visitables.get("statuspage").remove(this.statuspage);
    }
    return (A) this;
  }
  public class StatuspageNested<N> extends StatuspageProviderFluent<StatuspageNested<N>> implements Nested<N>{
  
    StatuspageProviderBuilder builder;
  
    StatuspageNested(StatuspageProvider item) {
      this.builder = new StatuspageProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleProvidersFluent.this.withStatuspage(builder.build());
    }
    
    public N endStatuspage() {
      return and();
    }
    
  }
}