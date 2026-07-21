package io.fabric8.knative.eventing.v1;

import io.fabric8.knative.duck.v1.AuthStatus;
import io.fabric8.knative.duck.v1.AuthStatusBuilder;
import io.fabric8.knative.duck.v1.AuthStatusFluent;
import io.fabric8.knative.pkg.apis.Condition;
import io.fabric8.knative.pkg.apis.ConditionBuilder;
import io.fabric8.knative.pkg.apis.ConditionFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class TriggerStatusFluent<A extends io.fabric8.knative.eventing.v1.TriggerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private AuthStatusBuilder auth;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private String deadLetterSinkAudience;
  private String deadLetterSinkCACerts;
  private String deadLetterSinkUri;
  private Long observedGeneration;
  private String subscriberAudience;
  private String subscriberCACerts;
  private String subscriberUri;

  public TriggerStatusFluent() {
  }
  
  public TriggerStatusFluent(TriggerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(Condition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public AuthStatus buildAuth() {
    return this.auth != null ? this.auth.build() : null;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(TriggerStatus instance) {
    instance = instance != null ? instance : new TriggerStatus();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withAuth(instance.getAuth());
        this.withConditions(instance.getConditions());
        this.withDeadLetterSinkAudience(instance.getDeadLetterSinkAudience());
        this.withDeadLetterSinkCACerts(instance.getDeadLetterSinkCACerts());
        this.withDeadLetterSinkUri(instance.getDeadLetterSinkUri());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withSubscriberAudience(instance.getSubscriberAudience());
        this.withSubscriberCACerts(instance.getSubscriberCACerts());
        this.withSubscriberUri(instance.getSubscriberUri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new AuthStatusBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(AuthStatus item) {
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
    TriggerStatusFluent that = (TriggerStatusFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(auth, that.auth))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSinkAudience, that.deadLetterSinkAudience))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSinkCACerts, that.deadLetterSinkCACerts))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSinkUri, that.deadLetterSinkUri))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(subscriberAudience, that.subscriberAudience))) {
      return false;
    }
    if (!(Objects.equals(subscriberCACerts, that.subscriberCACerts))) {
      return false;
    }
    if (!(Objects.equals(subscriberUri, that.subscriberUri))) {
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
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public String getDeadLetterSinkAudience() {
    return this.deadLetterSinkAudience;
  }
  
  public String getDeadLetterSinkCACerts() {
    return this.deadLetterSinkCACerts;
  }
  
  public String getDeadLetterSinkUri() {
    return this.deadLetterSinkUri;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getSubscriberAudience() {
    return this.subscriberAudience;
  }
  
  public String getSubscriberCACerts() {
    return this.subscriberCACerts;
  }
  
  public String getSubscriberUri() {
    return this.subscriberUri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasAuth() {
    return this.auth != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDeadLetterSinkAudience() {
    return this.deadLetterSinkAudience != null;
  }
  
  public boolean hasDeadLetterSinkCACerts() {
    return this.deadLetterSinkCACerts != null;
  }
  
  public boolean hasDeadLetterSinkUri() {
    return this.deadLetterSinkUri != null;
  }
  
  public boolean hasMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasSubscriberAudience() {
    return this.subscriberAudience != null;
  }
  
  public boolean hasSubscriberCACerts() {
    return this.subscriberCACerts != null;
  }
  
  public boolean hasSubscriberUri() {
    return this.subscriberUri != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, auth, conditions, deadLetterSinkAudience, deadLetterSinkCACerts, deadLetterSinkUri, observedGeneration, subscriberAudience, subscriberCACerts, subscriberUri, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(auth == null)) {
        sb.append("auth:");
        sb.append(auth);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(deadLetterSinkAudience == null)) {
        sb.append("deadLetterSinkAudience:");
        sb.append(deadLetterSinkAudience);
        sb.append(",");
    }
    if (!(deadLetterSinkCACerts == null)) {
        sb.append("deadLetterSinkCACerts:");
        sb.append(deadLetterSinkCACerts);
        sb.append(",");
    }
    if (!(deadLetterSinkUri == null)) {
        sb.append("deadLetterSinkUri:");
        sb.append(deadLetterSinkUri);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(subscriberAudience == null)) {
        sb.append("subscriberAudience:");
        sb.append(subscriberAudience);
        sb.append(",");
    }
    if (!(subscriberCACerts == null)) {
        sb.append("subscriberCACerts:");
        sb.append(subscriberCACerts);
        sb.append(",");
    }
    if (!(subscriberUri == null)) {
        sb.append("subscriberUri:");
        sb.append(subscriberUri);
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
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withAuth(AuthStatus auth) {
    this._visitables.remove("auth");
    if (auth != null) {
        this.auth = new AuthStatusBuilder(auth);
        this._visitables.get("auth").add(this.auth);
    } else {
        this.auth = null;
        this._visitables.get("auth").remove(this.auth);
    }
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withDeadLetterSinkAudience(String deadLetterSinkAudience) {
    this.deadLetterSinkAudience = deadLetterSinkAudience;
    return (A) this;
  }
  
  public A withDeadLetterSinkCACerts(String deadLetterSinkCACerts) {
    this.deadLetterSinkCACerts = deadLetterSinkCACerts;
    return (A) this;
  }
  
  public A withDeadLetterSinkUri(String deadLetterSinkUri) {
    this.deadLetterSinkUri = deadLetterSinkUri;
    return (A) this;
  }
  
  public AuthNested<A> withNewAuth() {
    return new AuthNested(null);
  }
  
  public AuthNested<A> withNewAuthLike(AuthStatus item) {
    return new AuthNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withSubscriberAudience(String subscriberAudience) {
    this.subscriberAudience = subscriberAudience;
    return (A) this;
  }
  
  public A withSubscriberCACerts(String subscriberCACerts) {
    this.subscriberCACerts = subscriberCACerts;
    return (A) this;
  }
  
  public A withSubscriberUri(String subscriberUri) {
    this.subscriberUri = subscriberUri;
    return (A) this;
  }
  public class AuthNested<N> extends AuthStatusFluent<AuthNested<N>> implements Nested<N>{
  
    AuthStatusBuilder builder;
  
    AuthNested(AuthStatus item) {
      this.builder = new AuthStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerStatusFluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends ConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,Condition item) {
      this.index = index;
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}