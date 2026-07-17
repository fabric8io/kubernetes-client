package io.fabric8.openshift.api.model.hive.agent.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class BareMetalPlatformFluent<A extends io.fabric8.openshift.api.model.hive.agent.v1.BareMetalPlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder agentSelector;

  public BareMetalPlatformFluent() {
  }
  
  public BareMetalPlatformFluent(BareMetalPlatform instance) {
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
  
  public LabelSelector buildAgentSelector() {
    return this.agentSelector != null ? this.agentSelector.build() : null;
  }
  
  protected void copyInstance(BareMetalPlatform instance) {
    instance = instance != null ? instance : new BareMetalPlatform();
    if (instance != null) {
        this.withAgentSelector(instance.getAgentSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AgentSelectorNested<A> editAgentSelector() {
    return this.withNewAgentSelectorLike(Optional.ofNullable(this.buildAgentSelector()).orElse(null));
  }
  
  public AgentSelectorNested<A> editOrNewAgentSelector() {
    return this.withNewAgentSelectorLike(Optional.ofNullable(this.buildAgentSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public AgentSelectorNested<A> editOrNewAgentSelectorLike(LabelSelector item) {
    return this.withNewAgentSelectorLike(Optional.ofNullable(this.buildAgentSelector()).orElse(item));
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
    BareMetalPlatformFluent that = (BareMetalPlatformFluent) o;
    if (!(Objects.equals(agentSelector, that.agentSelector))) {
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
  
  public boolean hasAgentSelector() {
    return this.agentSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(agentSelector, additionalProperties);
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
    if (!(agentSelector == null)) {
        sb.append("agentSelector:");
        sb.append(agentSelector);
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
  
  public A withAgentSelector(LabelSelector agentSelector) {
    this._visitables.remove("agentSelector");
    if (agentSelector != null) {
        this.agentSelector = new LabelSelectorBuilder(agentSelector);
        this._visitables.get("agentSelector").add(this.agentSelector);
    } else {
        this.agentSelector = null;
        this._visitables.get("agentSelector").remove(this.agentSelector);
    }
    return (A) this;
  }
  
  public AgentSelectorNested<A> withNewAgentSelector() {
    return new AgentSelectorNested(null);
  }
  
  public AgentSelectorNested<A> withNewAgentSelectorLike(LabelSelector item) {
    return new AgentSelectorNested(item);
  }
  public class AgentSelectorNested<N> extends LabelSelectorFluent<AgentSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    AgentSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalPlatformFluent.this.withAgentSelector(builder.build());
    }
    
    public N endAgentSelector() {
      return and();
    }
    
  }
}