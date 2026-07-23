package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.knative.duck.v1.AuthStatus;
import io.fabric8.knative.duck.v1.AuthStatusBuilder;
import io.fabric8.knative.duck.v1.AuthStatusFluent;
import io.fabric8.knative.duck.v1.CloudEventAttributes;
import io.fabric8.knative.duck.v1.CloudEventAttributesBuilder;
import io.fabric8.knative.duck.v1.CloudEventAttributesFluent;
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
public class CouchDbSourceStatusFluent<A extends io.fabric8.knative.sources.v1alpha1.CouchDbSourceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private AuthStatusBuilder auth;
  private ArrayList<CloudEventAttributesBuilder> ceAttributes = new ArrayList<CloudEventAttributesBuilder>();
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private Long observedGeneration;
  private String sinkAudience;
  private String sinkCACerts;
  private String sinkUri;

  public CouchDbSourceStatusFluent() {
  }
  
  public CouchDbSourceStatusFluent(CouchDbSourceStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToCeAttributes(Collection<CloudEventAttributes> items) {
    if (this.ceAttributes == null) {
      this.ceAttributes = new ArrayList();
    }
    for (CloudEventAttributes item : items) {
        CloudEventAttributesBuilder builder = new CloudEventAttributesBuilder(item);
        _visitables.get("ceAttributes").add(builder);
        this.ceAttributes.add(builder);
    }
    return (A) this;
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
  
  public CeAttributesNested<A> addNewCeAttribute() {
    return new CeAttributesNested(-1, null);
  }
  
  public A addNewCeAttribute(String source,String type) {
    return (A) this.addToCeAttributes(new CloudEventAttributes(source, type));
  }
  
  public CeAttributesNested<A> addNewCeAttributeLike(CloudEventAttributes item) {
    return new CeAttributesNested(-1, item);
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
  
  public A addToCeAttributes(CloudEventAttributes... items) {
    if (this.ceAttributes == null) {
      this.ceAttributes = new ArrayList();
    }
    for (CloudEventAttributes item : items) {
        CloudEventAttributesBuilder builder = new CloudEventAttributesBuilder(item);
        _visitables.get("ceAttributes").add(builder);
        this.ceAttributes.add(builder);
    }
    return (A) this;
  }
  
  public A addToCeAttributes(int index,CloudEventAttributes item) {
    if (this.ceAttributes == null) {
      this.ceAttributes = new ArrayList();
    }
    CloudEventAttributesBuilder builder = new CloudEventAttributesBuilder(item);
    if (index < 0 || index >= ceAttributes.size()) {
        _visitables.get("ceAttributes").add(builder);
        ceAttributes.add(builder);
    } else {
        _visitables.get("ceAttributes").add(builder);
        ceAttributes.add(index, builder);
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
  
  public CloudEventAttributes buildCeAttribute(int index) {
    return this.ceAttributes.get(index).build();
  }
  
  public List<CloudEventAttributes> buildCeAttributes() {
    return this.ceAttributes != null ? build(ceAttributes) : null;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public CloudEventAttributes buildFirstCeAttribute() {
    return this.ceAttributes.get(0).build();
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public CloudEventAttributes buildLastCeAttribute() {
    return this.ceAttributes.get(ceAttributes.size() - 1).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public CloudEventAttributes buildMatchingCeAttribute(Predicate<CloudEventAttributesBuilder> predicate) {
      for (CloudEventAttributesBuilder item : ceAttributes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CouchDbSourceStatus instance) {
    instance = instance != null ? instance : new CouchDbSourceStatus();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withAuth(instance.getAuth());
        this.withCeAttributes(instance.getCeAttributes());
        this.withConditions(instance.getConditions());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withSinkAudience(instance.getSinkAudience());
        this.withSinkCACerts(instance.getSinkCACerts());
        this.withSinkUri(instance.getSinkUri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public CeAttributesNested<A> editCeAttribute(int index) {
    if (ceAttributes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ceAttributes"));
    }
    return this.setNewCeAttributeLike(index, this.buildCeAttribute(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CeAttributesNested<A> editFirstCeAttribute() {
    if (ceAttributes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ceAttributes"));
    }
    return this.setNewCeAttributeLike(0, this.buildCeAttribute(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public CeAttributesNested<A> editLastCeAttribute() {
    int index = ceAttributes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ceAttributes"));
    }
    return this.setNewCeAttributeLike(index, this.buildCeAttribute(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CeAttributesNested<A> editMatchingCeAttribute(Predicate<CloudEventAttributesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ceAttributes.size();i++) {
      if (predicate.test(ceAttributes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ceAttributes"));
    }
    return this.setNewCeAttributeLike(index, this.buildCeAttribute(index));
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
    CouchDbSourceStatusFluent that = (CouchDbSourceStatusFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(auth, that.auth))) {
      return false;
    }
    if (!(Objects.equals(ceAttributes, that.ceAttributes))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(sinkAudience, that.sinkAudience))) {
      return false;
    }
    if (!(Objects.equals(sinkCACerts, that.sinkCACerts))) {
      return false;
    }
    if (!(Objects.equals(sinkUri, that.sinkUri))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getSinkAudience() {
    return this.sinkAudience;
  }
  
  public String getSinkCACerts() {
    return this.sinkCACerts;
  }
  
  public String getSinkUri() {
    return this.sinkUri;
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
  
  public boolean hasCeAttributes() {
    return this.ceAttributes != null && !(this.ceAttributes.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCeAttribute(Predicate<CloudEventAttributesBuilder> predicate) {
      for (CloudEventAttributesBuilder item : ceAttributes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
  
  public boolean hasSinkAudience() {
    return this.sinkAudience != null;
  }
  
  public boolean hasSinkCACerts() {
    return this.sinkCACerts != null;
  }
  
  public boolean hasSinkUri() {
    return this.sinkUri != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, auth, ceAttributes, conditions, observedGeneration, sinkAudience, sinkCACerts, sinkUri, additionalProperties);
  }
  
  public A removeAllFromCeAttributes(Collection<CloudEventAttributes> items) {
    if (this.ceAttributes == null) {
      return (A) this;
    }
    for (CloudEventAttributes item : items) {
        CloudEventAttributesBuilder builder = new CloudEventAttributesBuilder(item);
        _visitables.get("ceAttributes").remove(builder);
        this.ceAttributes.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromCeAttributes(CloudEventAttributes... items) {
    if (this.ceAttributes == null) {
      return (A) this;
    }
    for (CloudEventAttributes item : items) {
        CloudEventAttributesBuilder builder = new CloudEventAttributesBuilder(item);
        _visitables.get("ceAttributes").remove(builder);
        this.ceAttributes.remove(builder);
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
  
  public A removeMatchingFromCeAttributes(Predicate<CloudEventAttributesBuilder> predicate) {
    if (ceAttributes == null) {
      return (A) this;
    }
    Iterator<CloudEventAttributesBuilder> each = ceAttributes.iterator();
    List visitables = _visitables.get("ceAttributes");
    while (each.hasNext()) {
        CloudEventAttributesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public CeAttributesNested<A> setNewCeAttributeLike(int index,CloudEventAttributes item) {
    return new CeAttributesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToCeAttributes(int index,CloudEventAttributes item) {
    if (this.ceAttributes == null) {
      this.ceAttributes = new ArrayList();
    }
    CloudEventAttributesBuilder builder = new CloudEventAttributesBuilder(item);
    if (index < 0 || index >= ceAttributes.size()) {
        _visitables.get("ceAttributes").add(builder);
        ceAttributes.add(builder);
    } else {
        _visitables.get("ceAttributes").add(builder);
        ceAttributes.set(index, builder);
    }
    return (A) this;
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
    if (!(ceAttributes == null) && !(ceAttributes.isEmpty())) {
        sb.append("ceAttributes:");
        sb.append(ceAttributes);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(sinkAudience == null)) {
        sb.append("sinkAudience:");
        sb.append(sinkAudience);
        sb.append(",");
    }
    if (!(sinkCACerts == null)) {
        sb.append("sinkCACerts:");
        sb.append(sinkCACerts);
        sb.append(",");
    }
    if (!(sinkUri == null)) {
        sb.append("sinkUri:");
        sb.append(sinkUri);
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
  
  public A withCeAttributes(List<CloudEventAttributes> ceAttributes) {
    if (this.ceAttributes != null) {
      this._visitables.get("ceAttributes").clear();
    }
    if (ceAttributes != null) {
        this.ceAttributes = new ArrayList();
        for (CloudEventAttributes item : ceAttributes) {
          this.addToCeAttributes(item);
        }
    } else {
      this.ceAttributes = null;
    }
    return (A) this;
  }
  
  public A withCeAttributes(CloudEventAttributes... ceAttributes) {
    if (this.ceAttributes != null) {
        this.ceAttributes.clear();
        _visitables.remove("ceAttributes");
    }
    if (ceAttributes != null) {
      for (CloudEventAttributes item : ceAttributes) {
        this.addToCeAttributes(item);
      }
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
  
  public A withSinkAudience(String sinkAudience) {
    this.sinkAudience = sinkAudience;
    return (A) this;
  }
  
  public A withSinkCACerts(String sinkCACerts) {
    this.sinkCACerts = sinkCACerts;
    return (A) this;
  }
  
  public A withSinkUri(String sinkUri) {
    this.sinkUri = sinkUri;
    return (A) this;
  }
  public class AuthNested<N> extends AuthStatusFluent<AuthNested<N>> implements Nested<N>{
  
    AuthStatusBuilder builder;
  
    AuthNested(AuthStatus item) {
      this.builder = new AuthStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) CouchDbSourceStatusFluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
  public class CeAttributesNested<N> extends CloudEventAttributesFluent<CeAttributesNested<N>> implements Nested<N>{
  
    CloudEventAttributesBuilder builder;
    int index;
  
    CeAttributesNested(int index,CloudEventAttributes item) {
      this.index = index;
      this.builder = new CloudEventAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) CouchDbSourceStatusFluent.this.setToCeAttributes(index, builder.build());
    }
    
    public N endCeAttribute() {
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
      return (N) CouchDbSourceStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}