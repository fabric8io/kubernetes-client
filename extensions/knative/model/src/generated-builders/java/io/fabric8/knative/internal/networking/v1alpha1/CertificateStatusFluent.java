package io.fabric8.knative.internal.networking.v1alpha1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CertificateStatusFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.CertificateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private ArrayList<HTTP01ChallengeBuilder> http01Challenges = new ArrayList<HTTP01ChallengeBuilder>();
  private String notAfter;
  private Long observedGeneration;

  public CertificateStatusFluent() {
  }
  
  public CertificateStatusFluent(CertificateStatus instance) {
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
  
  public A addAllToHttp01Challenges(Collection<HTTP01Challenge> items) {
    if (this.http01Challenges == null) {
      this.http01Challenges = new ArrayList();
    }
    for (HTTP01Challenge item : items) {
        HTTP01ChallengeBuilder builder = new HTTP01ChallengeBuilder(item);
        _visitables.get("http01Challenges").add(builder);
        this.http01Challenges.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(Condition item) {
    return new ConditionsNested(-1, item);
  }
  
  public Http01ChallengesNested<A> addNewHttp01Challenge() {
    return new Http01ChallengesNested(-1, null);
  }
  
  public Http01ChallengesNested<A> addNewHttp01ChallengeLike(HTTP01Challenge item) {
    return new Http01ChallengesNested(-1, item);
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
  
  public A addToHttp01Challenges(HTTP01Challenge... items) {
    if (this.http01Challenges == null) {
      this.http01Challenges = new ArrayList();
    }
    for (HTTP01Challenge item : items) {
        HTTP01ChallengeBuilder builder = new HTTP01ChallengeBuilder(item);
        _visitables.get("http01Challenges").add(builder);
        this.http01Challenges.add(builder);
    }
    return (A) this;
  }
  
  public A addToHttp01Challenges(int index,HTTP01Challenge item) {
    if (this.http01Challenges == null) {
      this.http01Challenges = new ArrayList();
    }
    HTTP01ChallengeBuilder builder = new HTTP01ChallengeBuilder(item);
    if (index < 0 || index >= http01Challenges.size()) {
        _visitables.get("http01Challenges").add(builder);
        http01Challenges.add(builder);
    } else {
        _visitables.get("http01Challenges").add(builder);
        http01Challenges.add(index, builder);
    }
    return (A) this;
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
  
  public HTTP01Challenge buildFirstHttp01Challenge() {
    return this.http01Challenges.get(0).build();
  }
  
  public HTTP01Challenge buildHttp01Challenge(int index) {
    return this.http01Challenges.get(index).build();
  }
  
  public List<HTTP01Challenge> buildHttp01Challenges() {
    return this.http01Challenges != null ? build(http01Challenges) : null;
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public HTTP01Challenge buildLastHttp01Challenge() {
    return this.http01Challenges.get(http01Challenges.size() - 1).build();
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTP01Challenge buildMatchingHttp01Challenge(Predicate<HTTP01ChallengeBuilder> predicate) {
      for (HTTP01ChallengeBuilder item : http01Challenges) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CertificateStatus instance) {
    instance = instance != null ? instance : new CertificateStatus();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withConditions(instance.getConditions());
        this.withHttp01Challenges(instance.getHttp01Challenges());
        this.withNotAfter(instance.getNotAfter());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public Http01ChallengesNested<A> editFirstHttp01Challenge() {
    if (http01Challenges.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "http01Challenges"));
    }
    return this.setNewHttp01ChallengeLike(0, this.buildHttp01Challenge(0));
  }
  
  public Http01ChallengesNested<A> editHttp01Challenge(int index) {
    if (http01Challenges.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "http01Challenges"));
    }
    return this.setNewHttp01ChallengeLike(index, this.buildHttp01Challenge(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public Http01ChallengesNested<A> editLastHttp01Challenge() {
    int index = http01Challenges.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "http01Challenges"));
    }
    return this.setNewHttp01ChallengeLike(index, this.buildHttp01Challenge(index));
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
  
  public Http01ChallengesNested<A> editMatchingHttp01Challenge(Predicate<HTTP01ChallengeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < http01Challenges.size();i++) {
      if (predicate.test(http01Challenges.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "http01Challenges"));
    }
    return this.setNewHttp01ChallengeLike(index, this.buildHttp01Challenge(index));
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
    CertificateStatusFluent that = (CertificateStatusFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(http01Challenges, that.http01Challenges))) {
      return false;
    }
    if (!(Objects.equals(notAfter, that.notAfter))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
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
  
  public String getNotAfter() {
    return this.notAfter;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasHttp01Challenges() {
    return this.http01Challenges != null && !(this.http01Challenges.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHttp01Challenge(Predicate<HTTP01ChallengeBuilder> predicate) {
      for (HTTP01ChallengeBuilder item : http01Challenges) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNotAfter() {
    return this.notAfter != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, conditions, http01Challenges, notAfter, observedGeneration, additionalProperties);
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
  
  public A removeAllFromHttp01Challenges(Collection<HTTP01Challenge> items) {
    if (this.http01Challenges == null) {
      return (A) this;
    }
    for (HTTP01Challenge item : items) {
        HTTP01ChallengeBuilder builder = new HTTP01ChallengeBuilder(item);
        _visitables.get("http01Challenges").remove(builder);
        this.http01Challenges.remove(builder);
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
  
  public A removeFromHttp01Challenges(HTTP01Challenge... items) {
    if (this.http01Challenges == null) {
      return (A) this;
    }
    for (HTTP01Challenge item : items) {
        HTTP01ChallengeBuilder builder = new HTTP01ChallengeBuilder(item);
        _visitables.get("http01Challenges").remove(builder);
        this.http01Challenges.remove(builder);
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
  
  public A removeMatchingFromHttp01Challenges(Predicate<HTTP01ChallengeBuilder> predicate) {
    if (http01Challenges == null) {
      return (A) this;
    }
    Iterator<HTTP01ChallengeBuilder> each = http01Challenges.iterator();
    List visitables = _visitables.get("http01Challenges");
    while (each.hasNext()) {
        HTTP01ChallengeBuilder builder = each.next();
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
  
  public Http01ChallengesNested<A> setNewHttp01ChallengeLike(int index,HTTP01Challenge item) {
    return new Http01ChallengesNested(index, item);
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
  
  public A setToHttp01Challenges(int index,HTTP01Challenge item) {
    if (this.http01Challenges == null) {
      this.http01Challenges = new ArrayList();
    }
    HTTP01ChallengeBuilder builder = new HTTP01ChallengeBuilder(item);
    if (index < 0 || index >= http01Challenges.size()) {
        _visitables.get("http01Challenges").add(builder);
        http01Challenges.add(builder);
    } else {
        _visitables.get("http01Challenges").add(builder);
        http01Challenges.set(index, builder);
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
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(http01Challenges == null) && !(http01Challenges.isEmpty())) {
        sb.append("http01Challenges:");
        sb.append(http01Challenges);
        sb.append(",");
    }
    if (!(notAfter == null)) {
        sb.append("notAfter:");
        sb.append(notAfter);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
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
  
  public A withHttp01Challenges(List<HTTP01Challenge> http01Challenges) {
    if (this.http01Challenges != null) {
      this._visitables.get("http01Challenges").clear();
    }
    if (http01Challenges != null) {
        this.http01Challenges = new ArrayList();
        for (HTTP01Challenge item : http01Challenges) {
          this.addToHttp01Challenges(item);
        }
    } else {
      this.http01Challenges = null;
    }
    return (A) this;
  }
  
  public A withHttp01Challenges(HTTP01Challenge... http01Challenges) {
    if (this.http01Challenges != null) {
        this.http01Challenges.clear();
        _visitables.remove("http01Challenges");
    }
    if (http01Challenges != null) {
      for (HTTP01Challenge item : http01Challenges) {
        this.addToHttp01Challenges(item);
      }
    }
    return (A) this;
  }
  
  public A withNotAfter(String notAfter) {
    this.notAfter = notAfter;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends ConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,Condition item) {
      this.index = index;
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class Http01ChallengesNested<N> extends HTTP01ChallengeFluent<Http01ChallengesNested<N>> implements Nested<N>{
  
    HTTP01ChallengeBuilder builder;
    int index;
  
    Http01ChallengesNested(int index,HTTP01Challenge item) {
      this.index = index;
      this.builder = new HTTP01ChallengeBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateStatusFluent.this.setToHttp01Challenges(index, builder.build());
    }
    
    public N endHttp01Challenge() {
      return and();
    }
    
  }
}