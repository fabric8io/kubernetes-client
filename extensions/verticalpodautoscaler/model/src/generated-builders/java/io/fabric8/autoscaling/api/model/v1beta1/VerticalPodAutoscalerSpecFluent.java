package io.fabric8.autoscaling.api.model.v1beta1;

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
public class VerticalPodAutoscalerSpecFluent<A extends io.fabric8.autoscaling.api.model.v1beta1.VerticalPodAutoscalerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PodResourcePolicyBuilder resourcePolicy;
  private LabelSelectorBuilder selector;
  private PodUpdatePolicyBuilder updatePolicy;

  public VerticalPodAutoscalerSpecFluent() {
  }
  
  public VerticalPodAutoscalerSpecFluent(VerticalPodAutoscalerSpec instance) {
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
  
  public PodResourcePolicy buildResourcePolicy() {
    return this.resourcePolicy != null ? this.resourcePolicy.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PodUpdatePolicy buildUpdatePolicy() {
    return this.updatePolicy != null ? this.updatePolicy.build() : null;
  }
  
  protected void copyInstance(VerticalPodAutoscalerSpec instance) {
    instance = instance != null ? instance : new VerticalPodAutoscalerSpec();
    if (instance != null) {
        this.withResourcePolicy(instance.getResourcePolicy());
        this.withSelector(instance.getSelector());
        this.withUpdatePolicy(instance.getUpdatePolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourcePolicyNested<A> editOrNewResourcePolicy() {
    return this.withNewResourcePolicyLike(Optional.ofNullable(this.buildResourcePolicy()).orElse(new PodResourcePolicyBuilder().build()));
  }
  
  public ResourcePolicyNested<A> editOrNewResourcePolicyLike(PodResourcePolicy item) {
    return this.withNewResourcePolicyLike(Optional.ofNullable(this.buildResourcePolicy()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public UpdatePolicyNested<A> editOrNewUpdatePolicy() {
    return this.withNewUpdatePolicyLike(Optional.ofNullable(this.buildUpdatePolicy()).orElse(new PodUpdatePolicyBuilder().build()));
  }
  
  public UpdatePolicyNested<A> editOrNewUpdatePolicyLike(PodUpdatePolicy item) {
    return this.withNewUpdatePolicyLike(Optional.ofNullable(this.buildUpdatePolicy()).orElse(item));
  }
  
  public ResourcePolicyNested<A> editResourcePolicy() {
    return this.withNewResourcePolicyLike(Optional.ofNullable(this.buildResourcePolicy()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public UpdatePolicyNested<A> editUpdatePolicy() {
    return this.withNewUpdatePolicyLike(Optional.ofNullable(this.buildUpdatePolicy()).orElse(null));
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
    VerticalPodAutoscalerSpecFluent that = (VerticalPodAutoscalerSpecFluent) o;
    if (!(Objects.equals(resourcePolicy, that.resourcePolicy))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(updatePolicy, that.updatePolicy))) {
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
  
  public boolean hasResourcePolicy() {
    return this.resourcePolicy != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasUpdatePolicy() {
    return this.updatePolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(resourcePolicy, selector, updatePolicy, additionalProperties);
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
    if (!(resourcePolicy == null)) {
        sb.append("resourcePolicy:");
        sb.append(resourcePolicy);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(updatePolicy == null)) {
        sb.append("updatePolicy:");
        sb.append(updatePolicy);
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
  
  public ResourcePolicyNested<A> withNewResourcePolicy() {
    return new ResourcePolicyNested(null);
  }
  
  public ResourcePolicyNested<A> withNewResourcePolicyLike(PodResourcePolicy item) {
    return new ResourcePolicyNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public UpdatePolicyNested<A> withNewUpdatePolicy() {
    return new UpdatePolicyNested(null);
  }
  
  public A withNewUpdatePolicy(String updateMode) {
    return (A) this.withUpdatePolicy(new PodUpdatePolicy(updateMode));
  }
  
  public UpdatePolicyNested<A> withNewUpdatePolicyLike(PodUpdatePolicy item) {
    return new UpdatePolicyNested(item);
  }
  
  public A withResourcePolicy(PodResourcePolicy resourcePolicy) {
    this._visitables.remove("resourcePolicy");
    if (resourcePolicy != null) {
        this.resourcePolicy = new PodResourcePolicyBuilder(resourcePolicy);
        this._visitables.get("resourcePolicy").add(this.resourcePolicy);
    } else {
        this.resourcePolicy = null;
        this._visitables.get("resourcePolicy").remove(this.resourcePolicy);
    }
    return (A) this;
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withUpdatePolicy(PodUpdatePolicy updatePolicy) {
    this._visitables.remove("updatePolicy");
    if (updatePolicy != null) {
        this.updatePolicy = new PodUpdatePolicyBuilder(updatePolicy);
        this._visitables.get("updatePolicy").add(this.updatePolicy);
    } else {
        this.updatePolicy = null;
        this._visitables.get("updatePolicy").remove(this.updatePolicy);
    }
    return (A) this;
  }
  public class ResourcePolicyNested<N> extends PodResourcePolicyFluent<ResourcePolicyNested<N>> implements Nested<N>{
  
    PodResourcePolicyBuilder builder;
  
    ResourcePolicyNested(PodResourcePolicy item) {
      this.builder = new PodResourcePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerSpecFluent.this.withResourcePolicy(builder.build());
    }
    
    public N endResourcePolicy() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class UpdatePolicyNested<N> extends PodUpdatePolicyFluent<UpdatePolicyNested<N>> implements Nested<N>{
  
    PodUpdatePolicyBuilder builder;
  
    UpdatePolicyNested(PodUpdatePolicy item) {
      this.builder = new PodUpdatePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerSpecFluent.this.withUpdatePolicy(builder.build());
    }
    
    public N endUpdatePolicy() {
      return and();
    }
    
  }
}