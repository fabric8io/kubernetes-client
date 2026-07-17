package io.fabric8.openshift.api.model.operator.v1;

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
public class IngressControllerHTTPHeadersFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerHTTPHeadersFluent<A>> extends BaseFluent<A>{

  private IngressControllerHTTPHeaderActionsBuilder actions;
  private Map<String,Object> additionalProperties;
  private String forwardedHeaderPolicy;
  private List<String> headerNameCaseAdjustments = new ArrayList<String>();
  private IngressControllerHTTPUniqueIdHeaderPolicyBuilder uniqueId;

  public IngressControllerHTTPHeadersFluent() {
  }
  
  public IngressControllerHTTPHeadersFluent(IngressControllerHTTPHeaders instance) {
    this.copyInstance(instance);
  }

  public A addAllToHeaderNameCaseAdjustments(Collection<String> items) {
    if (this.headerNameCaseAdjustments == null) {
      this.headerNameCaseAdjustments = new ArrayList();
    }
    for (String item : items) {
      this.headerNameCaseAdjustments.add(item);
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
  
  public A addToHeaderNameCaseAdjustments(String... items) {
    if (this.headerNameCaseAdjustments == null) {
      this.headerNameCaseAdjustments = new ArrayList();
    }
    for (String item : items) {
      this.headerNameCaseAdjustments.add(item);
    }
    return (A) this;
  }
  
  public A addToHeaderNameCaseAdjustments(int index,String item) {
    if (this.headerNameCaseAdjustments == null) {
      this.headerNameCaseAdjustments = new ArrayList();
    }
    this.headerNameCaseAdjustments.add(index, item);
    return (A) this;
  }
  
  public IngressControllerHTTPHeaderActions buildActions() {
    return this.actions != null ? this.actions.build() : null;
  }
  
  public IngressControllerHTTPUniqueIdHeaderPolicy buildUniqueId() {
    return this.uniqueId != null ? this.uniqueId.build() : null;
  }
  
  protected void copyInstance(IngressControllerHTTPHeaders instance) {
    instance = instance != null ? instance : new IngressControllerHTTPHeaders();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withForwardedHeaderPolicy(instance.getForwardedHeaderPolicy());
        this.withHeaderNameCaseAdjustments(instance.getHeaderNameCaseAdjustments());
        this.withUniqueId(instance.getUniqueId());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionsNested<A> editActions() {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(null));
  }
  
  public ActionsNested<A> editOrNewActions() {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(new IngressControllerHTTPHeaderActionsBuilder().build()));
  }
  
  public ActionsNested<A> editOrNewActionsLike(IngressControllerHTTPHeaderActions item) {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(item));
  }
  
  public UniqueIdNested<A> editOrNewUniqueId() {
    return this.withNewUniqueIdLike(Optional.ofNullable(this.buildUniqueId()).orElse(new IngressControllerHTTPUniqueIdHeaderPolicyBuilder().build()));
  }
  
  public UniqueIdNested<A> editOrNewUniqueIdLike(IngressControllerHTTPUniqueIdHeaderPolicy item) {
    return this.withNewUniqueIdLike(Optional.ofNullable(this.buildUniqueId()).orElse(item));
  }
  
  public UniqueIdNested<A> editUniqueId() {
    return this.withNewUniqueIdLike(Optional.ofNullable(this.buildUniqueId()).orElse(null));
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
    IngressControllerHTTPHeadersFluent that = (IngressControllerHTTPHeadersFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
      return false;
    }
    if (!(Objects.equals(forwardedHeaderPolicy, that.forwardedHeaderPolicy))) {
      return false;
    }
    if (!(Objects.equals(headerNameCaseAdjustments, that.headerNameCaseAdjustments))) {
      return false;
    }
    if (!(Objects.equals(uniqueId, that.uniqueId))) {
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
  
  public String getFirstHeaderNameCaseAdjustment() {
    return this.headerNameCaseAdjustments.get(0);
  }
  
  public String getForwardedHeaderPolicy() {
    return this.forwardedHeaderPolicy;
  }
  
  public String getHeaderNameCaseAdjustment(int index) {
    return this.headerNameCaseAdjustments.get(index);
  }
  
  public List<String> getHeaderNameCaseAdjustments() {
    return this.headerNameCaseAdjustments;
  }
  
  public String getLastHeaderNameCaseAdjustment() {
    return this.headerNameCaseAdjustments.get(headerNameCaseAdjustments.size() - 1);
  }
  
  public String getMatchingHeaderNameCaseAdjustment(Predicate<String> predicate) {
      for (String item : headerNameCaseAdjustments) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasActions() {
    return this.actions != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasForwardedHeaderPolicy() {
    return this.forwardedHeaderPolicy != null;
  }
  
  public boolean hasHeaderNameCaseAdjustments() {
    return this.headerNameCaseAdjustments != null && !(this.headerNameCaseAdjustments.isEmpty());
  }
  
  public boolean hasMatchingHeaderNameCaseAdjustment(Predicate<String> predicate) {
      for (String item : headerNameCaseAdjustments) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUniqueId() {
    return this.uniqueId != null;
  }
  
  public int hashCode() {
    return Objects.hash(actions, forwardedHeaderPolicy, headerNameCaseAdjustments, uniqueId, additionalProperties);
  }
  
  public A removeAllFromHeaderNameCaseAdjustments(Collection<String> items) {
    if (this.headerNameCaseAdjustments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.headerNameCaseAdjustments.remove(item);
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
  
  public A removeFromHeaderNameCaseAdjustments(String... items) {
    if (this.headerNameCaseAdjustments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.headerNameCaseAdjustments.remove(item);
    }
    return (A) this;
  }
  
  public A setToHeaderNameCaseAdjustments(int index,String item) {
    if (this.headerNameCaseAdjustments == null) {
      this.headerNameCaseAdjustments = new ArrayList();
    }
    this.headerNameCaseAdjustments.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actions == null)) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(forwardedHeaderPolicy == null)) {
        sb.append("forwardedHeaderPolicy:");
        sb.append(forwardedHeaderPolicy);
        sb.append(",");
    }
    if (!(headerNameCaseAdjustments == null) && !(headerNameCaseAdjustments.isEmpty())) {
        sb.append("headerNameCaseAdjustments:");
        sb.append(headerNameCaseAdjustments);
        sb.append(",");
    }
    if (!(uniqueId == null)) {
        sb.append("uniqueId:");
        sb.append(uniqueId);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(IngressControllerHTTPHeaderActions actions) {
    this._visitables.remove("actions");
    if (actions != null) {
        this.actions = new IngressControllerHTTPHeaderActionsBuilder(actions);
        this._visitables.get("actions").add(this.actions);
    } else {
        this.actions = null;
        this._visitables.get("actions").remove(this.actions);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withForwardedHeaderPolicy(String forwardedHeaderPolicy) {
    this.forwardedHeaderPolicy = forwardedHeaderPolicy;
    return (A) this;
  }
  
  public A withHeaderNameCaseAdjustments(List<String> headerNameCaseAdjustments) {
    if (headerNameCaseAdjustments != null) {
        this.headerNameCaseAdjustments = new ArrayList();
        for (String item : headerNameCaseAdjustments) {
          this.addToHeaderNameCaseAdjustments(item);
        }
    } else {
      this.headerNameCaseAdjustments = null;
    }
    return (A) this;
  }
  
  public A withHeaderNameCaseAdjustments(String... headerNameCaseAdjustments) {
    if (this.headerNameCaseAdjustments != null) {
        this.headerNameCaseAdjustments.clear();
        _visitables.remove("headerNameCaseAdjustments");
    }
    if (headerNameCaseAdjustments != null) {
      for (String item : headerNameCaseAdjustments) {
        this.addToHeaderNameCaseAdjustments(item);
      }
    }
    return (A) this;
  }
  
  public ActionsNested<A> withNewActions() {
    return new ActionsNested(null);
  }
  
  public ActionsNested<A> withNewActionsLike(IngressControllerHTTPHeaderActions item) {
    return new ActionsNested(item);
  }
  
  public UniqueIdNested<A> withNewUniqueId() {
    return new UniqueIdNested(null);
  }
  
  public A withNewUniqueId(String format,String name) {
    return (A) this.withUniqueId(new IngressControllerHTTPUniqueIdHeaderPolicy(format, name));
  }
  
  public UniqueIdNested<A> withNewUniqueIdLike(IngressControllerHTTPUniqueIdHeaderPolicy item) {
    return new UniqueIdNested(item);
  }
  
  public A withUniqueId(IngressControllerHTTPUniqueIdHeaderPolicy uniqueId) {
    this._visitables.remove("uniqueId");
    if (uniqueId != null) {
        this.uniqueId = new IngressControllerHTTPUniqueIdHeaderPolicyBuilder(uniqueId);
        this._visitables.get("uniqueId").add(this.uniqueId);
    } else {
        this.uniqueId = null;
        this._visitables.get("uniqueId").remove(this.uniqueId);
    }
    return (A) this;
  }
  public class ActionsNested<N> extends IngressControllerHTTPHeaderActionsFluent<ActionsNested<N>> implements Nested<N>{
  
    IngressControllerHTTPHeaderActionsBuilder builder;
  
    ActionsNested(IngressControllerHTTPHeaderActions item) {
      this.builder = new IngressControllerHTTPHeaderActionsBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerHTTPHeadersFluent.this.withActions(builder.build());
    }
    
    public N endActions() {
      return and();
    }
    
  }
  public class UniqueIdNested<N> extends IngressControllerHTTPUniqueIdHeaderPolicyFluent<UniqueIdNested<N>> implements Nested<N>{
  
    IngressControllerHTTPUniqueIdHeaderPolicyBuilder builder;
  
    UniqueIdNested(IngressControllerHTTPUniqueIdHeaderPolicy item) {
      this.builder = new IngressControllerHTTPUniqueIdHeaderPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerHTTPHeadersFluent.this.withUniqueId(builder.build());
    }
    
    public N endUniqueId() {
      return and();
    }
    
  }
}