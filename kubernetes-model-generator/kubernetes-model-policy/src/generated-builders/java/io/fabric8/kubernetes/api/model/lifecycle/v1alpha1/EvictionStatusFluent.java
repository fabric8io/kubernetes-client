package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Integer;
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
public class EvictionStatusFluent<A extends io.fabric8.kubernetes.api.model.lifecycle.v1alpha1.EvictionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Long observedGeneration;
  private ArrayList<RequesterBuilder> requesters = new ArrayList<RequesterBuilder>();
  private ArrayList<ResponderStatusBuilder> responders = new ArrayList<ResponderStatusBuilder>();
  private ArrayList<TargetResponderBuilder> targetResponders = new ArrayList<TargetResponderBuilder>();

  public EvictionStatusFluent() {
  }
  
  public EvictionStatusFluent(EvictionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRequesters(Collection<Requester> items) {
    if (this.requesters == null) {
      this.requesters = new ArrayList();
    }
    for (Requester item : items) {
        RequesterBuilder builder = new RequesterBuilder(item);
        _visitables.get("requesters").add(builder);
        this.requesters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResponders(Collection<ResponderStatus> items) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    for (ResponderStatus item : items) {
        ResponderStatusBuilder builder = new ResponderStatusBuilder(item);
        _visitables.get("responders").add(builder);
        this.responders.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTargetResponders(Collection<TargetResponder> items) {
    if (this.targetResponders == null) {
      this.targetResponders = new ArrayList();
    }
    for (TargetResponder item : items) {
        TargetResponderBuilder builder = new TargetResponderBuilder(item);
        _visitables.get("targetResponders").add(builder);
        this.targetResponders.add(builder);
    }
    return (A) this;
  }
  
  public RequestersNested<A> addNewRequester() {
    return new RequestersNested(-1, null);
  }
  
  public A addNewRequester(String intent,String name) {
    return (A) this.addToRequesters(new Requester(intent, name));
  }
  
  public RequestersNested<A> addNewRequesterLike(Requester item) {
    return new RequestersNested(-1, item);
  }
  
  public RespondersNested<A> addNewResponder() {
    return new RespondersNested(-1, null);
  }
  
  public RespondersNested<A> addNewResponderLike(ResponderStatus item) {
    return new RespondersNested(-1, item);
  }
  
  public TargetRespondersNested<A> addNewTargetResponder() {
    return new TargetRespondersNested(-1, null);
  }
  
  public A addNewTargetResponder(String name,Integer priority,String state) {
    return (A) this.addToTargetResponders(new TargetResponder(name, priority, state));
  }
  
  public TargetRespondersNested<A> addNewTargetResponderLike(TargetResponder item) {
    return new TargetRespondersNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToRequesters(Requester... items) {
    if (this.requesters == null) {
      this.requesters = new ArrayList();
    }
    for (Requester item : items) {
        RequesterBuilder builder = new RequesterBuilder(item);
        _visitables.get("requesters").add(builder);
        this.requesters.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequesters(int index,Requester item) {
    if (this.requesters == null) {
      this.requesters = new ArrayList();
    }
    RequesterBuilder builder = new RequesterBuilder(item);
    if (index < 0 || index >= requesters.size()) {
        _visitables.get("requesters").add(builder);
        requesters.add(builder);
    } else {
        _visitables.get("requesters").add(builder);
        requesters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResponders(ResponderStatus... items) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    for (ResponderStatus item : items) {
        ResponderStatusBuilder builder = new ResponderStatusBuilder(item);
        _visitables.get("responders").add(builder);
        this.responders.add(builder);
    }
    return (A) this;
  }
  
  public A addToResponders(int index,ResponderStatus item) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    ResponderStatusBuilder builder = new ResponderStatusBuilder(item);
    if (index < 0 || index >= responders.size()) {
        _visitables.get("responders").add(builder);
        responders.add(builder);
    } else {
        _visitables.get("responders").add(builder);
        responders.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTargetResponders(TargetResponder... items) {
    if (this.targetResponders == null) {
      this.targetResponders = new ArrayList();
    }
    for (TargetResponder item : items) {
        TargetResponderBuilder builder = new TargetResponderBuilder(item);
        _visitables.get("targetResponders").add(builder);
        this.targetResponders.add(builder);
    }
    return (A) this;
  }
  
  public A addToTargetResponders(int index,TargetResponder item) {
    if (this.targetResponders == null) {
      this.targetResponders = new ArrayList();
    }
    TargetResponderBuilder builder = new TargetResponderBuilder(item);
    if (index < 0 || index >= targetResponders.size()) {
        _visitables.get("targetResponders").add(builder);
        targetResponders.add(builder);
    } else {
        _visitables.get("targetResponders").add(builder);
        targetResponders.add(index, builder);
    }
    return (A) this;
  }
  
  public Requester buildFirstRequester() {
    return this.requesters.get(0).build();
  }
  
  public ResponderStatus buildFirstResponder() {
    return this.responders.get(0).build();
  }
  
  public TargetResponder buildFirstTargetResponder() {
    return this.targetResponders.get(0).build();
  }
  
  public Requester buildLastRequester() {
    return this.requesters.get(requesters.size() - 1).build();
  }
  
  public ResponderStatus buildLastResponder() {
    return this.responders.get(responders.size() - 1).build();
  }
  
  public TargetResponder buildLastTargetResponder() {
    return this.targetResponders.get(targetResponders.size() - 1).build();
  }
  
  public Requester buildMatchingRequester(Predicate<RequesterBuilder> predicate) {
      for (RequesterBuilder item : requesters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResponderStatus buildMatchingResponder(Predicate<ResponderStatusBuilder> predicate) {
      for (ResponderStatusBuilder item : responders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TargetResponder buildMatchingTargetResponder(Predicate<TargetResponderBuilder> predicate) {
      for (TargetResponderBuilder item : targetResponders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Requester buildRequester(int index) {
    return this.requesters.get(index).build();
  }
  
  public List<Requester> buildRequesters() {
    return this.requesters != null ? build(requesters) : null;
  }
  
  public ResponderStatus buildResponder(int index) {
    return this.responders.get(index).build();
  }
  
  public List<ResponderStatus> buildResponders() {
    return this.responders != null ? build(responders) : null;
  }
  
  public TargetResponder buildTargetResponder(int index) {
    return this.targetResponders.get(index).build();
  }
  
  public List<TargetResponder> buildTargetResponders() {
    return this.targetResponders != null ? build(targetResponders) : null;
  }
  
  protected void copyInstance(EvictionStatus instance) {
    instance = instance != null ? instance : new EvictionStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withRequesters(instance.getRequesters());
        this.withResponders(instance.getResponders());
        this.withTargetResponders(instance.getTargetResponders());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequestersNested<A> editFirstRequester() {
    if (requesters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "requesters"));
    }
    return this.setNewRequesterLike(0, this.buildRequester(0));
  }
  
  public RespondersNested<A> editFirstResponder() {
    if (responders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "responders"));
    }
    return this.setNewResponderLike(0, this.buildResponder(0));
  }
  
  public TargetRespondersNested<A> editFirstTargetResponder() {
    if (targetResponders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetResponders"));
    }
    return this.setNewTargetResponderLike(0, this.buildTargetResponder(0));
  }
  
  public RequestersNested<A> editLastRequester() {
    int index = requesters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "requesters"));
    }
    return this.setNewRequesterLike(index, this.buildRequester(index));
  }
  
  public RespondersNested<A> editLastResponder() {
    int index = responders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "responders"));
    }
    return this.setNewResponderLike(index, this.buildResponder(index));
  }
  
  public TargetRespondersNested<A> editLastTargetResponder() {
    int index = targetResponders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetResponders"));
    }
    return this.setNewTargetResponderLike(index, this.buildTargetResponder(index));
  }
  
  public RequestersNested<A> editMatchingRequester(Predicate<RequesterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < requesters.size();i++) {
      if (predicate.test(requesters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "requesters"));
    }
    return this.setNewRequesterLike(index, this.buildRequester(index));
  }
  
  public RespondersNested<A> editMatchingResponder(Predicate<ResponderStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < responders.size();i++) {
      if (predicate.test(responders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "responders"));
    }
    return this.setNewResponderLike(index, this.buildResponder(index));
  }
  
  public TargetRespondersNested<A> editMatchingTargetResponder(Predicate<TargetResponderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < targetResponders.size();i++) {
      if (predicate.test(targetResponders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "targetResponders"));
    }
    return this.setNewTargetResponderLike(index, this.buildTargetResponder(index));
  }
  
  public RequestersNested<A> editRequester(int index) {
    if (requesters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "requesters"));
    }
    return this.setNewRequesterLike(index, this.buildRequester(index));
  }
  
  public RespondersNested<A> editResponder(int index) {
    if (responders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "responders"));
    }
    return this.setNewResponderLike(index, this.buildResponder(index));
  }
  
  public TargetRespondersNested<A> editTargetResponder(int index) {
    if (targetResponders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targetResponders"));
    }
    return this.setNewTargetResponderLike(index, this.buildTargetResponder(index));
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
    EvictionStatusFluent that = (EvictionStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(requesters, that.requesters))) {
      return false;
    }
    if (!(Objects.equals(responders, that.responders))) {
      return false;
    }
    if (!(Objects.equals(targetResponders, that.targetResponders))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequester(Predicate<RequesterBuilder> predicate) {
      for (RequesterBuilder item : requesters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResponder(Predicate<ResponderStatusBuilder> predicate) {
      for (ResponderStatusBuilder item : responders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetResponder(Predicate<TargetResponderBuilder> predicate) {
      for (TargetResponderBuilder item : targetResponders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasRequesters() {
    return this.requesters != null && !(this.requesters.isEmpty());
  }
  
  public boolean hasResponders() {
    return this.responders != null && !(this.responders.isEmpty());
  }
  
  public boolean hasTargetResponders() {
    return this.targetResponders != null && !(this.targetResponders.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, observedGeneration, requesters, responders, targetResponders, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRequesters(Collection<Requester> items) {
    if (this.requesters == null) {
      return (A) this;
    }
    for (Requester item : items) {
        RequesterBuilder builder = new RequesterBuilder(item);
        _visitables.get("requesters").remove(builder);
        this.requesters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResponders(Collection<ResponderStatus> items) {
    if (this.responders == null) {
      return (A) this;
    }
    for (ResponderStatus item : items) {
        ResponderStatusBuilder builder = new ResponderStatusBuilder(item);
        _visitables.get("responders").remove(builder);
        this.responders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetResponders(Collection<TargetResponder> items) {
    if (this.targetResponders == null) {
      return (A) this;
    }
    for (TargetResponder item : items) {
        TargetResponderBuilder builder = new TargetResponderBuilder(item);
        _visitables.get("targetResponders").remove(builder);
        this.targetResponders.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRequesters(Requester... items) {
    if (this.requesters == null) {
      return (A) this;
    }
    for (Requester item : items) {
        RequesterBuilder builder = new RequesterBuilder(item);
        _visitables.get("requesters").remove(builder);
        this.requesters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResponders(ResponderStatus... items) {
    if (this.responders == null) {
      return (A) this;
    }
    for (ResponderStatus item : items) {
        ResponderStatusBuilder builder = new ResponderStatusBuilder(item);
        _visitables.get("responders").remove(builder);
        this.responders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTargetResponders(TargetResponder... items) {
    if (this.targetResponders == null) {
      return (A) this;
    }
    for (TargetResponder item : items) {
        TargetResponderBuilder builder = new TargetResponderBuilder(item);
        _visitables.get("targetResponders").remove(builder);
        this.targetResponders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequesters(Predicate<RequesterBuilder> predicate) {
    if (requesters == null) {
      return (A) this;
    }
    Iterator<RequesterBuilder> each = requesters.iterator();
    List visitables = _visitables.get("requesters");
    while (each.hasNext()) {
        RequesterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResponders(Predicate<ResponderStatusBuilder> predicate) {
    if (responders == null) {
      return (A) this;
    }
    Iterator<ResponderStatusBuilder> each = responders.iterator();
    List visitables = _visitables.get("responders");
    while (each.hasNext()) {
        ResponderStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTargetResponders(Predicate<TargetResponderBuilder> predicate) {
    if (targetResponders == null) {
      return (A) this;
    }
    Iterator<TargetResponderBuilder> each = targetResponders.iterator();
    List visitables = _visitables.get("targetResponders");
    while (each.hasNext()) {
        TargetResponderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RequestersNested<A> setNewRequesterLike(int index,Requester item) {
    return new RequestersNested(index, item);
  }
  
  public RespondersNested<A> setNewResponderLike(int index,ResponderStatus item) {
    return new RespondersNested(index, item);
  }
  
  public TargetRespondersNested<A> setNewTargetResponderLike(int index,TargetResponder item) {
    return new TargetRespondersNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToRequesters(int index,Requester item) {
    if (this.requesters == null) {
      this.requesters = new ArrayList();
    }
    RequesterBuilder builder = new RequesterBuilder(item);
    if (index < 0 || index >= requesters.size()) {
        _visitables.get("requesters").add(builder);
        requesters.add(builder);
    } else {
        _visitables.get("requesters").add(builder);
        requesters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResponders(int index,ResponderStatus item) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    ResponderStatusBuilder builder = new ResponderStatusBuilder(item);
    if (index < 0 || index >= responders.size()) {
        _visitables.get("responders").add(builder);
        responders.add(builder);
    } else {
        _visitables.get("responders").add(builder);
        responders.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTargetResponders(int index,TargetResponder item) {
    if (this.targetResponders == null) {
      this.targetResponders = new ArrayList();
    }
    TargetResponderBuilder builder = new TargetResponderBuilder(item);
    if (index < 0 || index >= targetResponders.size()) {
        _visitables.get("targetResponders").add(builder);
        targetResponders.add(builder);
    } else {
        _visitables.get("targetResponders").add(builder);
        targetResponders.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(requesters == null) && !(requesters.isEmpty())) {
        sb.append("requesters:");
        sb.append(requesters);
        sb.append(",");
    }
    if (!(responders == null) && !(responders.isEmpty())) {
        sb.append("responders:");
        sb.append(responders);
        sb.append(",");
    }
    if (!(targetResponders == null) && !(targetResponders.isEmpty())) {
        sb.append("targetResponders:");
        sb.append(targetResponders);
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
  
  public A withConditions(List<Condition> conditions) {
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
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withRequesters(List<Requester> requesters) {
    if (this.requesters != null) {
      this._visitables.get("requesters").clear();
    }
    if (requesters != null) {
        this.requesters = new ArrayList();
        for (Requester item : requesters) {
          this.addToRequesters(item);
        }
    } else {
      this.requesters = null;
    }
    return (A) this;
  }
  
  public A withRequesters(Requester... requesters) {
    if (this.requesters != null) {
        this.requesters.clear();
        _visitables.remove("requesters");
    }
    if (requesters != null) {
      for (Requester item : requesters) {
        this.addToRequesters(item);
      }
    }
    return (A) this;
  }
  
  public A withResponders(List<ResponderStatus> responders) {
    if (this.responders != null) {
      this._visitables.get("responders").clear();
    }
    if (responders != null) {
        this.responders = new ArrayList();
        for (ResponderStatus item : responders) {
          this.addToResponders(item);
        }
    } else {
      this.responders = null;
    }
    return (A) this;
  }
  
  public A withResponders(ResponderStatus... responders) {
    if (this.responders != null) {
        this.responders.clear();
        _visitables.remove("responders");
    }
    if (responders != null) {
      for (ResponderStatus item : responders) {
        this.addToResponders(item);
      }
    }
    return (A) this;
  }
  
  public A withTargetResponders(List<TargetResponder> targetResponders) {
    if (this.targetResponders != null) {
      this._visitables.get("targetResponders").clear();
    }
    if (targetResponders != null) {
        this.targetResponders = new ArrayList();
        for (TargetResponder item : targetResponders) {
          this.addToTargetResponders(item);
        }
    } else {
      this.targetResponders = null;
    }
    return (A) this;
  }
  
  public A withTargetResponders(TargetResponder... targetResponders) {
    if (this.targetResponders != null) {
        this.targetResponders.clear();
        _visitables.remove("targetResponders");
    }
    if (targetResponders != null) {
      for (TargetResponder item : targetResponders) {
        this.addToTargetResponders(item);
      }
    }
    return (A) this;
  }
  public class RequestersNested<N> extends RequesterFluent<RequestersNested<N>> implements Nested<N>{
  
    RequesterBuilder builder;
    int index;
  
    RequestersNested(int index,Requester item) {
      this.index = index;
      this.builder = new RequesterBuilder(this, item);
    }
  
    public N and() {
      return (N) EvictionStatusFluent.this.setToRequesters(index, builder.build());
    }
    
    public N endRequester() {
      return and();
    }
    
  }
  public class RespondersNested<N> extends ResponderStatusFluent<RespondersNested<N>> implements Nested<N>{
  
    ResponderStatusBuilder builder;
    int index;
  
    RespondersNested(int index,ResponderStatus item) {
      this.index = index;
      this.builder = new ResponderStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) EvictionStatusFluent.this.setToResponders(index, builder.build());
    }
    
    public N endResponder() {
      return and();
    }
    
  }
  public class TargetRespondersNested<N> extends TargetResponderFluent<TargetRespondersNested<N>> implements Nested<N>{
  
    TargetResponderBuilder builder;
    int index;
  
    TargetRespondersNested(int index,TargetResponder item) {
      this.index = index;
      this.builder = new TargetResponderBuilder(this, item);
    }
  
    public N and() {
      return (N) EvictionStatusFluent.this.setToTargetResponders(index, builder.build());
    }
    
    public N endTargetResponder() {
      return and();
    }
    
  }
}