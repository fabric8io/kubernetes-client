package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.knative.duck.v1.Addressable;
import io.fabric8.knative.duck.v1.AddressableBuilder;
import io.fabric8.knative.duck.v1.AddressableFluent;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRef;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRefBuilder;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRefFluent;
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
public class EventTransformStatusFluent<A extends io.fabric8.knative.eventing.v1alpha1.EventTransformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AddressableBuilder address;
  private ArrayList<AddressableBuilder> addresses = new ArrayList<AddressableBuilder>();
  private Map<String,String> annotations;
  private AuthStatusBuilder auth;
  private ArrayList<CloudEventAttributesBuilder> ceAttributes = new ArrayList<CloudEventAttributesBuilder>();
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private JsonataEventTransformationStatusBuilder jsonata;
  private Long observedGeneration;
  private ArrayList<AppliedEventPolicyRefBuilder> policies = new ArrayList<AppliedEventPolicyRefBuilder>();
  private String sinkAudience;
  private String sinkCACerts;
  private String sinkUri;

  public EventTransformStatusFluent() {
  }
  
  public EventTransformStatusFluent(EventTransformStatus instance) {
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
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String cACerts,String audience,String name,String url) {
    return (A) this.addToAddresses(new Addressable(cACerts, audience, name, url));
  }
  
  public AddressesNested<A> addNewAddressLike(Addressable item) {
    return new AddressesNested(-1, item);
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
  
  public PoliciesNested<A> addNewPolicy() {
    return new PoliciesNested(-1, null);
  }
  
  public A addNewPolicy(String apiVersion,String name) {
    return (A) this.addToPolicies(new AppliedEventPolicyRef(apiVersion, name));
  }
  
  public PoliciesNested<A> addNewPolicyLike(AppliedEventPolicyRef item) {
    return new PoliciesNested(-1, item);
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
  
  public Addressable buildAddress() {
    return this.address != null ? this.address.build() : null;
  }
  
  public Addressable buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<Addressable> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
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
  
  public Addressable buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public CloudEventAttributes buildFirstCeAttribute() {
    return this.ceAttributes.get(0).build();
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public AppliedEventPolicyRef buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public JsonataEventTransformationStatus buildJsonata() {
    return this.jsonata != null ? this.jsonata.build() : null;
  }
  
  public Addressable buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public CloudEventAttributes buildLastCeAttribute() {
    return this.ceAttributes.get(ceAttributes.size() - 1).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public AppliedEventPolicyRef buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public Addressable buildMatchingAddress(Predicate<AddressableBuilder> predicate) {
      for (AddressableBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
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
  
  public AppliedEventPolicyRef buildMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
      for (AppliedEventPolicyRefBuilder item : policies) {
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
  
  protected void copyInstance(EventTransformStatus instance) {
    instance = instance != null ? instance : new EventTransformStatus();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withAddresses(instance.getAddresses());
        this.withAnnotations(instance.getAnnotations());
        this.withAuth(instance.getAuth());
        this.withCeAttributes(instance.getCeAttributes());
        this.withConditions(instance.getConditions());
        this.withJsonata(instance.getJsonata());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPolicies(instance.getPolicies());
        this.withSinkAudience(instance.getSinkAudience());
        this.withSinkCACerts(instance.getSinkCACerts());
        this.withSinkUri(instance.getSinkUri());
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
  
  public AddressesNested<A> editFirstAddress() {
    if (addresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(0, this.buildAddress(0));
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
  
  public PoliciesNested<A> editFirstPolicy() {
    if (policies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(0, this.buildPolicy(0));
  }
  
  public JsonataNested<A> editJsonata() {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(null));
  }
  
  public AddressesNested<A> editLastAddress() {
    int index = addresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
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
  
  public PoliciesNested<A> editLastPolicy() {
    int index = policies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
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
  
  public JsonataNested<A> editOrNewJsonata() {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(new JsonataEventTransformationStatusBuilder().build()));
  }
  
  public JsonataNested<A> editOrNewJsonataLike(JsonataEventTransformationStatus item) {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(item));
  }
  
  public PoliciesNested<A> editPolicy(int index) {
    if (policies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
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
    EventTransformStatusFluent that = (EventTransformStatusFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
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
    if (!(Objects.equals(jsonata, that.jsonata))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
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
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
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
  
  public boolean hasJsonata() {
    return this.jsonata != null;
  }
  
  public boolean hasMatchingAddress(Predicate<AddressableBuilder> predicate) {
      for (AddressableBuilder item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
  
  public boolean hasMatchingPolicy(Predicate<AppliedEventPolicyRefBuilder> predicate) {
      for (AppliedEventPolicyRefBuilder item : policies) {
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
    return Objects.hash(address, addresses, annotations, auth, ceAttributes, conditions, jsonata, observedGeneration, policies, sinkAudience, sinkCACerts, sinkUri, additionalProperties);
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
  
  public AddressesNested<A> setNewAddressLike(int index,Addressable item) {
    return new AddressesNested(index, item);
  }
  
  public CeAttributesNested<A> setNewCeAttributeLike(int index,CloudEventAttributes item) {
    return new CeAttributesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,AppliedEventPolicyRef item) {
    return new PoliciesNested(index, item);
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
    if (!(jsonata == null)) {
        sb.append("jsonata:");
        sb.append(jsonata);
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
  
  public A withJsonata(JsonataEventTransformationStatus jsonata) {
    this._visitables.remove("jsonata");
    if (jsonata != null) {
        this.jsonata = new JsonataEventTransformationStatusBuilder(jsonata);
        this._visitables.get("jsonata").add(this.jsonata);
    } else {
        this.jsonata = null;
        this._visitables.get("jsonata").remove(this.jsonata);
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
  
  public JsonataNested<A> withNewJsonata() {
    return new JsonataNested(null);
  }
  
  public JsonataNested<A> withNewJsonataLike(JsonataEventTransformationStatus item) {
    return new JsonataNested(item);
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
  public class AddressNested<N> extends AddressableFluent<AddressNested<N>> implements Nested<N>{
  
    AddressableBuilder builder;
  
    AddressNested(Addressable item) {
      this.builder = new AddressableBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTransformStatusFluent.this.withAddress(builder.build());
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
      return (N) EventTransformStatusFluent.this.setToAddresses(index, builder.build());
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
      return (N) EventTransformStatusFluent.this.withAuth(builder.build());
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
      return (N) EventTransformStatusFluent.this.setToCeAttributes(index, builder.build());
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
      return (N) EventTransformStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class JsonataNested<N> extends JsonataEventTransformationStatusFluent<JsonataNested<N>> implements Nested<N>{
  
    JsonataEventTransformationStatusBuilder builder;
  
    JsonataNested(JsonataEventTransformationStatus item) {
      this.builder = new JsonataEventTransformationStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTransformStatusFluent.this.withJsonata(builder.build());
    }
    
    public N endJsonata() {
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
      return (N) EventTransformStatusFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
}