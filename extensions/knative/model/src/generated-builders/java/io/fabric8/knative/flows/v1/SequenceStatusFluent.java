package io.fabric8.knative.flows.v1;

import io.fabric8.knative.duck.v1.Addressable;
import io.fabric8.knative.duck.v1.AddressableBuilder;
import io.fabric8.knative.duck.v1.AddressableFluent;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRef;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRefBuilder;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRefFluent;
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
public class SequenceStatusFluent<A extends io.fabric8.knative.flows.v1.SequenceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AddressableBuilder address;
  private Map<String,String> annotations;
  private AuthStatusBuilder auth;
  private ArrayList<SequenceChannelStatusBuilder> channelStatuses = new ArrayList<SequenceChannelStatusBuilder>();
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private Long observedGeneration;
  private ArrayList<AppliedEventPolicyRefBuilder> policies = new ArrayList<AppliedEventPolicyRefBuilder>();
  private ArrayList<SequenceSubscriptionStatusBuilder> subscriptionStatuses = new ArrayList<SequenceSubscriptionStatusBuilder>();

  public SequenceStatusFluent() {
  }
  
  public SequenceStatusFluent(SequenceStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToChannelStatuses(Collection<SequenceChannelStatus> items) {
    if (this.channelStatuses == null) {
      this.channelStatuses = new ArrayList();
    }
    for (SequenceChannelStatus item : items) {
        SequenceChannelStatusBuilder builder = new SequenceChannelStatusBuilder(item);
        _visitables.get("channelStatuses").add(builder);
        this.channelStatuses.add(builder);
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
  
  public A addAllToSubscriptionStatuses(Collection<SequenceSubscriptionStatus> items) {
    if (this.subscriptionStatuses == null) {
      this.subscriptionStatuses = new ArrayList();
    }
    for (SequenceSubscriptionStatus item : items) {
        SequenceSubscriptionStatusBuilder builder = new SequenceSubscriptionStatusBuilder(item);
        _visitables.get("subscriptionStatuses").add(builder);
        this.subscriptionStatuses.add(builder);
    }
    return (A) this;
  }
  
  public ChannelStatusesNested<A> addNewChannelStatus() {
    return new ChannelStatusesNested(-1, null);
  }
  
  public ChannelStatusesNested<A> addNewChannelStatusLike(SequenceChannelStatus item) {
    return new ChannelStatusesNested(-1, item);
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
  
  public SubscriptionStatusesNested<A> addNewSubscriptionStatus() {
    return new SubscriptionStatusesNested(-1, null);
  }
  
  public SubscriptionStatusesNested<A> addNewSubscriptionStatusLike(SequenceSubscriptionStatus item) {
    return new SubscriptionStatusesNested(-1, item);
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
  
  public A addToChannelStatuses(SequenceChannelStatus... items) {
    if (this.channelStatuses == null) {
      this.channelStatuses = new ArrayList();
    }
    for (SequenceChannelStatus item : items) {
        SequenceChannelStatusBuilder builder = new SequenceChannelStatusBuilder(item);
        _visitables.get("channelStatuses").add(builder);
        this.channelStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToChannelStatuses(int index,SequenceChannelStatus item) {
    if (this.channelStatuses == null) {
      this.channelStatuses = new ArrayList();
    }
    SequenceChannelStatusBuilder builder = new SequenceChannelStatusBuilder(item);
    if (index < 0 || index >= channelStatuses.size()) {
        _visitables.get("channelStatuses").add(builder);
        channelStatuses.add(builder);
    } else {
        _visitables.get("channelStatuses").add(builder);
        channelStatuses.add(index, builder);
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
  
  public A addToSubscriptionStatuses(SequenceSubscriptionStatus... items) {
    if (this.subscriptionStatuses == null) {
      this.subscriptionStatuses = new ArrayList();
    }
    for (SequenceSubscriptionStatus item : items) {
        SequenceSubscriptionStatusBuilder builder = new SequenceSubscriptionStatusBuilder(item);
        _visitables.get("subscriptionStatuses").add(builder);
        this.subscriptionStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubscriptionStatuses(int index,SequenceSubscriptionStatus item) {
    if (this.subscriptionStatuses == null) {
      this.subscriptionStatuses = new ArrayList();
    }
    SequenceSubscriptionStatusBuilder builder = new SequenceSubscriptionStatusBuilder(item);
    if (index < 0 || index >= subscriptionStatuses.size()) {
        _visitables.get("subscriptionStatuses").add(builder);
        subscriptionStatuses.add(builder);
    } else {
        _visitables.get("subscriptionStatuses").add(builder);
        subscriptionStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public Addressable buildAddress() {
    return this.address != null ? this.address.build() : null;
  }
  
  public AuthStatus buildAuth() {
    return this.auth != null ? this.auth.build() : null;
  }
  
  public SequenceChannelStatus buildChannelStatus(int index) {
    return this.channelStatuses.get(index).build();
  }
  
  public List<SequenceChannelStatus> buildChannelStatuses() {
    return this.channelStatuses != null ? build(channelStatuses) : null;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public SequenceChannelStatus buildFirstChannelStatus() {
    return this.channelStatuses.get(0).build();
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public AppliedEventPolicyRef buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public SequenceSubscriptionStatus buildFirstSubscriptionStatus() {
    return this.subscriptionStatuses.get(0).build();
  }
  
  public SequenceChannelStatus buildLastChannelStatus() {
    return this.channelStatuses.get(channelStatuses.size() - 1).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public AppliedEventPolicyRef buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public SequenceSubscriptionStatus buildLastSubscriptionStatus() {
    return this.subscriptionStatuses.get(subscriptionStatuses.size() - 1).build();
  }
  
  public SequenceChannelStatus buildMatchingChannelStatus(Predicate<SequenceChannelStatusBuilder> predicate) {
      for (SequenceChannelStatusBuilder item : channelStatuses) {
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
  
  public SequenceSubscriptionStatus buildMatchingSubscriptionStatus(Predicate<SequenceSubscriptionStatusBuilder> predicate) {
      for (SequenceSubscriptionStatusBuilder item : subscriptionStatuses) {
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
  
  public SequenceSubscriptionStatus buildSubscriptionStatus(int index) {
    return this.subscriptionStatuses.get(index).build();
  }
  
  public List<SequenceSubscriptionStatus> buildSubscriptionStatuses() {
    return this.subscriptionStatuses != null ? build(subscriptionStatuses) : null;
  }
  
  protected void copyInstance(SequenceStatus instance) {
    instance = instance != null ? instance : new SequenceStatus();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withAnnotations(instance.getAnnotations());
        this.withAuth(instance.getAuth());
        this.withChannelStatuses(instance.getChannelStatuses());
        this.withConditions(instance.getConditions());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPolicies(instance.getPolicies());
        this.withSubscriptionStatuses(instance.getSubscriptionStatuses());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddressNested<A> editAddress() {
    return this.withNewAddressLike(Optional.ofNullable(this.buildAddress()).orElse(null));
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public ChannelStatusesNested<A> editChannelStatus(int index) {
    if (channelStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "channelStatuses"));
    }
    return this.setNewChannelStatusLike(index, this.buildChannelStatus(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ChannelStatusesNested<A> editFirstChannelStatus() {
    if (channelStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "channelStatuses"));
    }
    return this.setNewChannelStatusLike(0, this.buildChannelStatus(0));
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
  
  public SubscriptionStatusesNested<A> editFirstSubscriptionStatus() {
    if (subscriptionStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subscriptionStatuses"));
    }
    return this.setNewSubscriptionStatusLike(0, this.buildSubscriptionStatus(0));
  }
  
  public ChannelStatusesNested<A> editLastChannelStatus() {
    int index = channelStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "channelStatuses"));
    }
    return this.setNewChannelStatusLike(index, this.buildChannelStatus(index));
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
  
  public SubscriptionStatusesNested<A> editLastSubscriptionStatus() {
    int index = subscriptionStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subscriptionStatuses"));
    }
    return this.setNewSubscriptionStatusLike(index, this.buildSubscriptionStatus(index));
  }
  
  public ChannelStatusesNested<A> editMatchingChannelStatus(Predicate<SequenceChannelStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < channelStatuses.size();i++) {
      if (predicate.test(channelStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "channelStatuses"));
    }
    return this.setNewChannelStatusLike(index, this.buildChannelStatus(index));
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
  
  public SubscriptionStatusesNested<A> editMatchingSubscriptionStatus(Predicate<SequenceSubscriptionStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subscriptionStatuses.size();i++) {
      if (predicate.test(subscriptionStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subscriptionStatuses"));
    }
    return this.setNewSubscriptionStatusLike(index, this.buildSubscriptionStatus(index));
  }
  
  public AddressNested<A> editOrNewAddress() {
    return this.withNewAddressLike(Optional.ofNullable(this.buildAddress()).orElse(new AddressableBuilder().build()));
  }
  
  public AddressNested<A> editOrNewAddressLike(Addressable item) {
    return this.withNewAddressLike(Optional.ofNullable(this.buildAddress()).orElse(item));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new AuthStatusBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(AuthStatus item) {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(item));
  }
  
  public PoliciesNested<A> editPolicy(int index) {
    if (policies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public SubscriptionStatusesNested<A> editSubscriptionStatus(int index) {
    if (subscriptionStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subscriptionStatuses"));
    }
    return this.setNewSubscriptionStatusLike(index, this.buildSubscriptionStatus(index));
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
    SequenceStatusFluent that = (SequenceStatusFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(auth, that.auth))) {
      return false;
    }
    if (!(Objects.equals(channelStatuses, that.channelStatuses))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(subscriptionStatuses, that.subscriptionStatuses))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasAuth() {
    return this.auth != null;
  }
  
  public boolean hasChannelStatuses() {
    return this.channelStatuses != null && !(this.channelStatuses.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingChannelStatus(Predicate<SequenceChannelStatusBuilder> predicate) {
      for (SequenceChannelStatusBuilder item : channelStatuses) {
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
  
  public boolean hasMatchingSubscriptionStatus(Predicate<SequenceSubscriptionStatusBuilder> predicate) {
      for (SequenceSubscriptionStatusBuilder item : subscriptionStatuses) {
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
  
  public boolean hasSubscriptionStatuses() {
    return this.subscriptionStatuses != null && !(this.subscriptionStatuses.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(address, annotations, auth, channelStatuses, conditions, observedGeneration, policies, subscriptionStatuses, additionalProperties);
  }
  
  public A removeAllFromChannelStatuses(Collection<SequenceChannelStatus> items) {
    if (this.channelStatuses == null) {
      return (A) this;
    }
    for (SequenceChannelStatus item : items) {
        SequenceChannelStatusBuilder builder = new SequenceChannelStatusBuilder(item);
        _visitables.get("channelStatuses").remove(builder);
        this.channelStatuses.remove(builder);
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
  
  public A removeAllFromSubscriptionStatuses(Collection<SequenceSubscriptionStatus> items) {
    if (this.subscriptionStatuses == null) {
      return (A) this;
    }
    for (SequenceSubscriptionStatus item : items) {
        SequenceSubscriptionStatusBuilder builder = new SequenceSubscriptionStatusBuilder(item);
        _visitables.get("subscriptionStatuses").remove(builder);
        this.subscriptionStatuses.remove(builder);
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
  
  public A removeFromChannelStatuses(SequenceChannelStatus... items) {
    if (this.channelStatuses == null) {
      return (A) this;
    }
    for (SequenceChannelStatus item : items) {
        SequenceChannelStatusBuilder builder = new SequenceChannelStatusBuilder(item);
        _visitables.get("channelStatuses").remove(builder);
        this.channelStatuses.remove(builder);
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
  
  public A removeFromSubscriptionStatuses(SequenceSubscriptionStatus... items) {
    if (this.subscriptionStatuses == null) {
      return (A) this;
    }
    for (SequenceSubscriptionStatus item : items) {
        SequenceSubscriptionStatusBuilder builder = new SequenceSubscriptionStatusBuilder(item);
        _visitables.get("subscriptionStatuses").remove(builder);
        this.subscriptionStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromChannelStatuses(Predicate<SequenceChannelStatusBuilder> predicate) {
    if (channelStatuses == null) {
      return (A) this;
    }
    Iterator<SequenceChannelStatusBuilder> each = channelStatuses.iterator();
    List visitables = _visitables.get("channelStatuses");
    while (each.hasNext()) {
        SequenceChannelStatusBuilder builder = each.next();
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
  
  public A removeMatchingFromSubscriptionStatuses(Predicate<SequenceSubscriptionStatusBuilder> predicate) {
    if (subscriptionStatuses == null) {
      return (A) this;
    }
    Iterator<SequenceSubscriptionStatusBuilder> each = subscriptionStatuses.iterator();
    List visitables = _visitables.get("subscriptionStatuses");
    while (each.hasNext()) {
        SequenceSubscriptionStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ChannelStatusesNested<A> setNewChannelStatusLike(int index,SequenceChannelStatus item) {
    return new ChannelStatusesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,AppliedEventPolicyRef item) {
    return new PoliciesNested(index, item);
  }
  
  public SubscriptionStatusesNested<A> setNewSubscriptionStatusLike(int index,SequenceSubscriptionStatus item) {
    return new SubscriptionStatusesNested(index, item);
  }
  
  public A setToChannelStatuses(int index,SequenceChannelStatus item) {
    if (this.channelStatuses == null) {
      this.channelStatuses = new ArrayList();
    }
    SequenceChannelStatusBuilder builder = new SequenceChannelStatusBuilder(item);
    if (index < 0 || index >= channelStatuses.size()) {
        _visitables.get("channelStatuses").add(builder);
        channelStatuses.add(builder);
    } else {
        _visitables.get("channelStatuses").add(builder);
        channelStatuses.set(index, builder);
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
  
  public A setToSubscriptionStatuses(int index,SequenceSubscriptionStatus item) {
    if (this.subscriptionStatuses == null) {
      this.subscriptionStatuses = new ArrayList();
    }
    SequenceSubscriptionStatusBuilder builder = new SequenceSubscriptionStatusBuilder(item);
    if (index < 0 || index >= subscriptionStatuses.size()) {
        _visitables.get("subscriptionStatuses").add(builder);
        subscriptionStatuses.add(builder);
    } else {
        _visitables.get("subscriptionStatuses").add(builder);
        subscriptionStatuses.set(index, builder);
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
    if (!(channelStatuses == null) && !(channelStatuses.isEmpty())) {
        sb.append("channelStatuses:");
        sb.append(channelStatuses);
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
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
        sb.append(",");
    }
    if (!(subscriptionStatuses == null) && !(subscriptionStatuses.isEmpty())) {
        sb.append("subscriptionStatuses:");
        sb.append(subscriptionStatuses);
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
  
  public A withChannelStatuses(List<SequenceChannelStatus> channelStatuses) {
    if (this.channelStatuses != null) {
      this._visitables.get("channelStatuses").clear();
    }
    if (channelStatuses != null) {
        this.channelStatuses = new ArrayList();
        for (SequenceChannelStatus item : channelStatuses) {
          this.addToChannelStatuses(item);
        }
    } else {
      this.channelStatuses = null;
    }
    return (A) this;
  }
  
  public A withChannelStatuses(SequenceChannelStatus... channelStatuses) {
    if (this.channelStatuses != null) {
        this.channelStatuses.clear();
        _visitables.remove("channelStatuses");
    }
    if (channelStatuses != null) {
      for (SequenceChannelStatus item : channelStatuses) {
        this.addToChannelStatuses(item);
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
  
  public AddressNested<A> withNewAddress() {
    return new AddressNested(null);
  }
  
  public A withNewAddress(String cACerts,String audience,String name,String url) {
    return (A) this.withAddress(new Addressable(cACerts, audience, name, url));
  }
  
  public AddressNested<A> withNewAddressLike(Addressable item) {
    return new AddressNested(item);
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
  
  public A withSubscriptionStatuses(List<SequenceSubscriptionStatus> subscriptionStatuses) {
    if (this.subscriptionStatuses != null) {
      this._visitables.get("subscriptionStatuses").clear();
    }
    if (subscriptionStatuses != null) {
        this.subscriptionStatuses = new ArrayList();
        for (SequenceSubscriptionStatus item : subscriptionStatuses) {
          this.addToSubscriptionStatuses(item);
        }
    } else {
      this.subscriptionStatuses = null;
    }
    return (A) this;
  }
  
  public A withSubscriptionStatuses(SequenceSubscriptionStatus... subscriptionStatuses) {
    if (this.subscriptionStatuses != null) {
        this.subscriptionStatuses.clear();
        _visitables.remove("subscriptionStatuses");
    }
    if (subscriptionStatuses != null) {
      for (SequenceSubscriptionStatus item : subscriptionStatuses) {
        this.addToSubscriptionStatuses(item);
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
      return (N) SequenceStatusFluent.this.withAddress(builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class AuthNested<N> extends AuthStatusFluent<AuthNested<N>> implements Nested<N>{
  
    AuthStatusBuilder builder;
  
    AuthNested(AuthStatus item) {
      this.builder = new AuthStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceStatusFluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
  public class ChannelStatusesNested<N> extends SequenceChannelStatusFluent<ChannelStatusesNested<N>> implements Nested<N>{
  
    SequenceChannelStatusBuilder builder;
    int index;
  
    ChannelStatusesNested(int index,SequenceChannelStatus item) {
      this.index = index;
      this.builder = new SequenceChannelStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceStatusFluent.this.setToChannelStatuses(index, builder.build());
    }
    
    public N endChannelStatus() {
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
      return (N) SequenceStatusFluent.this.setToConditions(index, builder.build());
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
      return (N) SequenceStatusFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
  public class SubscriptionStatusesNested<N> extends SequenceSubscriptionStatusFluent<SubscriptionStatusesNested<N>> implements Nested<N>{
  
    SequenceSubscriptionStatusBuilder builder;
    int index;
  
    SubscriptionStatusesNested(int index,SequenceSubscriptionStatus item) {
      this.index = index;
      this.builder = new SequenceSubscriptionStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceStatusFluent.this.setToSubscriptionStatuses(index, builder.build());
    }
    
    public N endSubscriptionStatus() {
      return and();
    }
    
  }
}