package io.fabric8.knative.messaging.v1;

import io.fabric8.knative.duck.v1.Addressable;
import io.fabric8.knative.duck.v1.AddressableBuilder;
import io.fabric8.knative.duck.v1.AddressableFluent;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRef;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRefBuilder;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRefFluent;
import io.fabric8.knative.duck.v1.SubscriberStatus;
import io.fabric8.knative.duck.v1.SubscriberStatusBuilder;
import io.fabric8.knative.duck.v1.SubscriberStatusFluent;
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
public class KafkaChannelStatusFluent<A extends io.fabric8.knative.messaging.v1.KafkaChannelStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AddressableBuilder address;
  private ArrayList<AddressableBuilder> addresses = new ArrayList<AddressableBuilder>();
  private Map<String,String> annotations;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private String deadLetterSinkAudience;
  private String deadLetterSinkCACerts;
  private String deadLetterSinkUri;
  private Long observedGeneration;
  private ArrayList<AppliedEventPolicyRefBuilder> policies = new ArrayList<AppliedEventPolicyRefBuilder>();
  private ArrayList<SubscriberStatusBuilder> subscribers = new ArrayList<SubscriberStatusBuilder>();

  public KafkaChannelStatusFluent() {
  }
  
  public KafkaChannelStatusFluent(KafkaChannelStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<Addressable> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (Addressable item : items) {
        AddressableBuilder builder = new AddressableBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
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
  
  public A addAllToPolicies(Collection<AppliedEventPolicyRef> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSubscribers(Collection<SubscriberStatus> items) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").add(builder);
        this.subscribers.add(builder);
    }
    return (A) this;
  }
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String cACerts,String audience,String name,String url) {
    return (A) this.addToAddresses(new Addressable(cACerts, audience, name, url));
  }
  
  public AddressesNested<A> addNewAddressLike(Addressable item) {
    return new AddressesNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(Condition item) {
    return new ConditionsNested(-1, item);
  }
  
  public PoliciesNested<A> addNewPolicy() {
    return new PoliciesNested(-1, null);
  }
  
  public A addNewPolicy(String apiVersion,String name) {
    return (A) this.addToPolicies(new AppliedEventPolicyRef(apiVersion, name));
  }
  
  public PoliciesNested<A> addNewPolicyLike(AppliedEventPolicyRef item) {
    return new PoliciesNested(-1, item);
  }
  
  public SubscribersNested<A> addNewSubscriber() {
    return new SubscribersNested(-1, null);
  }
  
  public SubscribersNested<A> addNewSubscriberLike(SubscriberStatus item) {
    return new SubscribersNested(-1, item);
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
  
  public A addToAddresses(Addressable... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (Addressable item : items) {
        AddressableBuilder builder = new AddressableBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,Addressable item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    AddressableBuilder builder = new AddressableBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
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
  
  public A addToPolicies(AppliedEventPolicyRef... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,AppliedEventPolicyRef item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSubscribers(SubscriberStatus... items) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").add(builder);
        this.subscribers.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubscribers(int index,SubscriberStatus item) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
    if (index < 0 || index >= subscribers.size()) {
        _visitables.get("subscribers").add(builder);
        subscribers.add(builder);
    } else {
        _visitables.get("subscribers").add(builder);
        subscribers.add(index, builder);
    }
    return (A) this;
  }
  
  public Addressable buildAddress() {
    return this.address != null ? this.address.build() : null;
  }
  
  public Addressable buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<Addressable> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public Addressable buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public AppliedEventPolicyRef buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public SubscriberStatus buildFirstSubscriber() {
    return this.subscribers.get(0).build();
  }
  
  public Addressable buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public AppliedEventPolicyRef buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public SubscriberStatus buildLastSubscriber() {
    return this.subscribers.get(subscribers.size() - 1).build();
  }
  
  public Addressable buildMatchingAddress(Predicate<AddressableBuilder> predicate) {
      for (AddressableBuilder item : addresses) {
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
  
  public AppliedEventPolicyRef buildMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
      for (AppliedEventPolicyRefBuilder item : policies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubscriberStatus buildMatchingSubscriber(Predicate<SubscriberStatusBuilder> predicate) {
      for (SubscriberStatusBuilder item : subscribers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<AppliedEventPolicyRef> buildPolicies() {
    return this.policies != null ? build(policies) : null;
  }
  
  public AppliedEventPolicyRef buildPolicy(int index) {
    return this.policies.get(index).build();
  }
  
  public SubscriberStatus buildSubscriber(int index) {
    return this.subscribers.get(index).build();
  }
  
  public List<SubscriberStatus> buildSubscribers() {
    return this.subscribers != null ? build(subscribers) : null;
  }
  
  protected void copyInstance(KafkaChannelStatus instance) {
    instance = instance != null ? instance : new KafkaChannelStatus();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withAddresses(instance.getAddresses());
        this.withAnnotations(instance.getAnnotations());
        this.withConditions(instance.getConditions());
        this.withDeadLetterSinkAudience(instance.getDeadLetterSinkAudience());
        this.withDeadLetterSinkCACerts(instance.getDeadLetterSinkCACerts());
        this.withDeadLetterSinkUri(instance.getDeadLetterSinkUri());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPolicies(instance.getPolicies());
        this.withSubscribers(instance.getSubscribers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddressNested<A> editAddress() {
    return this.withNewAddressLike(Optional.ofNullable(this.buildAddress()).orElse(null));
  }
  
  public AddressesNested<A> editAddress(int index) {
    if (addresses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public AddressesNested<A> editFirstAddress() {
    if (addresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(0, this.buildAddress(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public PoliciesNested<A> editFirstPolicy() {
    if (policies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(0, this.buildPolicy(0));
  }
  
  public SubscribersNested<A> editFirstSubscriber() {
    if (subscribers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subscribers"));
    }
    return this.setNewSubscriberLike(0, this.buildSubscriber(0));
  }
  
  public AddressesNested<A> editLastAddress() {
    int index = addresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public PoliciesNested<A> editLastPolicy() {
    int index = policies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public SubscribersNested<A> editLastSubscriber() {
    int index = subscribers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subscribers"));
    }
    return this.setNewSubscriberLike(index, this.buildSubscriber(index));
  }
  
  public AddressesNested<A> editMatchingAddress(Predicate<AddressableBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < addresses.size();i++) {
      if (predicate.test(addresses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
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
  
  public PoliciesNested<A> editMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < policies.size();i++) {
      if (predicate.test(policies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public SubscribersNested<A> editMatchingSubscriber(Predicate<SubscriberStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subscribers.size();i++) {
      if (predicate.test(subscribers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subscribers"));
    }
    return this.setNewSubscriberLike(index, this.buildSubscriber(index));
  }
  
  public AddressNested<A> editOrNewAddress() {
    return this.withNewAddressLike(Optional.ofNullable(this.buildAddress()).orElse(new AddressableBuilder().build()));
  }
  
  public AddressNested<A> editOrNewAddressLike(Addressable item) {
    return this.withNewAddressLike(Optional.ofNullable(this.buildAddress()).orElse(item));
  }
  
  public PoliciesNested<A> editPolicy(int index) {
    if (policies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public SubscribersNested<A> editSubscriber(int index) {
    if (subscribers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subscribers"));
    }
    return this.setNewSubscriberLike(index, this.buildSubscriber(index));
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
    KafkaChannelStatusFluent that = (KafkaChannelStatusFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(annotations, that.annotations))) {
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
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(subscribers, that.subscribers))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
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
  
  public boolean hasMatchingAddress(Predicate<AddressableBuilder> predicate) {
      for (AddressableBuilder item : addresses) {
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
  
  public boolean hasMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
      for (AppliedEventPolicyRefBuilder item : policies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubscriber(Predicate<SubscriberStatusBuilder> predicate) {
      for (SubscriberStatusBuilder item : subscribers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPolicies() {
    return this.policies != null && !(this.policies.isEmpty());
  }
  
  public boolean hasSubscribers() {
    return this.subscribers != null && !(this.subscribers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(address, addresses, annotations, conditions, deadLetterSinkAudience, deadLetterSinkCACerts, deadLetterSinkUri, observedGeneration, policies, subscribers, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<Addressable> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (Addressable item : items) {
        AddressableBuilder builder = new AddressableBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
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
  
  public A removeAllFromPolicies(Collection<AppliedEventPolicyRef> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSubscribers(Collection<SubscriberStatus> items) {
    if (this.subscribers == null) {
      return (A) this;
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").remove(builder);
        this.subscribers.remove(builder);
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
  
  public A removeFromAddresses(Addressable... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (Addressable item : items) {
        AddressableBuilder builder = new AddressableBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
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
  
  public A removeFromPolicies(AppliedEventPolicyRef... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (AppliedEventPolicyRef item : items) {
        AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSubscribers(SubscriberStatus... items) {
    if (this.subscribers == null) {
      return (A) this;
    }
    for (SubscriberStatus item : items) {
        SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
        _visitables.get("subscribers").remove(builder);
        this.subscribers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddresses(Predicate<AddressableBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<AddressableBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        AddressableBuilder builder = each.next();
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
  
  public A removeMatchingFromPolicies(Predicate<AppliedEventPolicyRefBuilder> predicate) {
    if (policies == null) {
      return (A) this;
    }
    Iterator<AppliedEventPolicyRefBuilder> each = policies.iterator();
    List visitables = _visitables.get("policies");
    while (each.hasNext()) {
        AppliedEventPolicyRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubscribers(Predicate<SubscriberStatusBuilder> predicate) {
    if (subscribers == null) {
      return (A) this;
    }
    Iterator<SubscriberStatusBuilder> each = subscribers.iterator();
    List visitables = _visitables.get("subscribers");
    while (each.hasNext()) {
        SubscriberStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesNested<A> setNewAddressLike(int index,Addressable item) {
    return new AddressesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,AppliedEventPolicyRef item) {
    return new PoliciesNested(index, item);
  }
  
  public SubscribersNested<A> setNewSubscriberLike(int index,SubscriberStatus item) {
    return new SubscribersNested(index, item);
  }
  
  public A setToAddresses(int index,Addressable item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    AddressableBuilder builder = new AddressableBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
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
  
  public A setToPolicies(int index,AppliedEventPolicyRef item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    AppliedEventPolicyRefBuilder builder = new AppliedEventPolicyRefBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSubscribers(int index,SubscriberStatus item) {
    if (this.subscribers == null) {
      this.subscribers = new ArrayList();
    }
    SubscriberStatusBuilder builder = new SubscriberStatusBuilder(item);
    if (index < 0 || index >= subscribers.size()) {
        _visitables.get("subscribers").add(builder);
        subscribers.add(builder);
    } else {
        _visitables.get("subscribers").add(builder);
        subscribers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(address == null)) {
        sb.append("address:");
        sb.append(address);
        sb.append(",");
    }
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
        sb.append(",");
    }
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
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
        sb.append(",");
    }
    if (!(subscribers == null) && !(subscribers.isEmpty())) {
        sb.append("subscribers:");
        sb.append(subscribers);
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
  
  public A withAddress(Addressable address) {
    this._visitables.remove("address");
    if (address != null) {
        this.address = new AddressableBuilder(address);
        this._visitables.get("address").add(this.address);
    } else {
        this.address = null;
        this._visitables.get("address").remove(this.address);
    }
    return (A) this;
  }
  
  public A withAddresses(List<Addressable> addresses) {
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (Addressable item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(Addressable... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (Addressable item : addresses) {
        this.addToAddresses(item);
      }
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
  
  public AddressNested<A> withNewAddress() {
    return new AddressNested(null);
  }
  
  public A withNewAddress(String cACerts,String audience,String name,String url) {
    return (A) this.withAddress(new Addressable(cACerts, audience, name, url));
  }
  
  public AddressNested<A> withNewAddressLike(Addressable item) {
    return new AddressNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPolicies(List<AppliedEventPolicyRef> policies) {
    if (this.policies != null) {
      this._visitables.get("policies").clear();
    }
    if (policies != null) {
        this.policies = new ArrayList();
        for (AppliedEventPolicyRef item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(AppliedEventPolicyRef... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (AppliedEventPolicyRef item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  
  public A withSubscribers(List<SubscriberStatus> subscribers) {
    if (this.subscribers != null) {
      this._visitables.get("subscribers").clear();
    }
    if (subscribers != null) {
        this.subscribers = new ArrayList();
        for (SubscriberStatus item : subscribers) {
          this.addToSubscribers(item);
        }
    } else {
      this.subscribers = null;
    }
    return (A) this;
  }
  
  public A withSubscribers(SubscriberStatus... subscribers) {
    if (this.subscribers != null) {
        this.subscribers.clear();
        _visitables.remove("subscribers");
    }
    if (subscribers != null) {
      for (SubscriberStatus item : subscribers) {
        this.addToSubscribers(item);
      }
    }
    return (A) this;
  }
  public class AddressNested<N> extends AddressableFluent<AddressNested<N>> implements Nested<N>{
  
    AddressableBuilder builder;
  
    AddressNested(Addressable item) {
      this.builder = new AddressableBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaChannelStatusFluent.this.withAddress(builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class AddressesNested<N> extends AddressableFluent<AddressesNested<N>> implements Nested<N>{
  
    AddressableBuilder builder;
    int index;
  
    AddressesNested(int index,Addressable item) {
      this.index = index;
      this.builder = new AddressableBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaChannelStatusFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
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
      return (N) KafkaChannelStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class PoliciesNested<N> extends AppliedEventPolicyRefFluent<PoliciesNested<N>> implements Nested<N>{
  
    AppliedEventPolicyRefBuilder builder;
    int index;
  
    PoliciesNested(int index,AppliedEventPolicyRef item) {
      this.index = index;
      this.builder = new AppliedEventPolicyRefBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaChannelStatusFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
  public class SubscribersNested<N> extends SubscriberStatusFluent<SubscribersNested<N>> implements Nested<N>{
  
    SubscriberStatusBuilder builder;
    int index;
  
    SubscribersNested(int index,SubscriberStatus item) {
      this.index = index;
      this.builder = new SubscriberStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaChannelStatusFluent.this.setToSubscribers(index, builder.build());
    }
    
    public N endSubscriber() {
      return and();
    }
    
  }
}