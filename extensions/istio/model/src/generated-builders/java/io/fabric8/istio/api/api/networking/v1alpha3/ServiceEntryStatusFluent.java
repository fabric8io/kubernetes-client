package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.istio.api.api.analysis.v1alpha1.AnalysisMessageBase;
import io.fabric8.istio.api.api.analysis.v1alpha1.AnalysisMessageBaseBuilder;
import io.fabric8.istio.api.api.analysis.v1alpha1.AnalysisMessageBaseFluent;
import io.fabric8.istio.api.api.meta.v1alpha1.IstioCondition;
import io.fabric8.istio.api.api.meta.v1alpha1.IstioConditionBuilder;
import io.fabric8.istio.api.api.meta.v1alpha1.IstioConditionFluent;
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
public class ServiceEntryStatusFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ServiceEntryStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ServiceEntryAddressBuilder> addresses = new ArrayList<ServiceEntryAddressBuilder>();
  private ArrayList<IstioConditionBuilder> conditions = new ArrayList<IstioConditionBuilder>();
  private Long observedGeneration;
  private ArrayList<AnalysisMessageBaseBuilder> validationMessages = new ArrayList<AnalysisMessageBaseBuilder>();

  public ServiceEntryStatusFluent() {
  }
  
  public ServiceEntryStatusFluent(ServiceEntryStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<ServiceEntryAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (ServiceEntryAddress item : items) {
        ServiceEntryAddressBuilder builder = new ServiceEntryAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<IstioCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (IstioCondition item : items) {
        IstioConditionBuilder builder = new IstioConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToValidationMessages(Collection<AnalysisMessageBase> items) {
    if (this.validationMessages == null) {
      this.validationMessages = new ArrayList();
    }
    for (AnalysisMessageBase item : items) {
        AnalysisMessageBaseBuilder builder = new AnalysisMessageBaseBuilder(item);
        _visitables.get("validationMessages").add(builder);
        this.validationMessages.add(builder);
    }
    return (A) this;
  }
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String host,String value) {
    return (A) this.addToAddresses(new ServiceEntryAddress(host, value));
  }
  
  public AddressesNested<A> addNewAddressLike(ServiceEntryAddress item) {
    return new AddressesNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(IstioCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ValidationMessagesNested<A> addNewValidationMessage() {
    return new ValidationMessagesNested(-1, null);
  }
  
  public ValidationMessagesNested<A> addNewValidationMessageLike(AnalysisMessageBase item) {
    return new ValidationMessagesNested(-1, item);
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
  
  public A addToAddresses(ServiceEntryAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (ServiceEntryAddress item : items) {
        ServiceEntryAddressBuilder builder = new ServiceEntryAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,ServiceEntryAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    ServiceEntryAddressBuilder builder = new ServiceEntryAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(IstioCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (IstioCondition item : items) {
        IstioConditionBuilder builder = new IstioConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,IstioCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    IstioConditionBuilder builder = new IstioConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToValidationMessages(AnalysisMessageBase... items) {
    if (this.validationMessages == null) {
      this.validationMessages = new ArrayList();
    }
    for (AnalysisMessageBase item : items) {
        AnalysisMessageBaseBuilder builder = new AnalysisMessageBaseBuilder(item);
        _visitables.get("validationMessages").add(builder);
        this.validationMessages.add(builder);
    }
    return (A) this;
  }
  
  public A addToValidationMessages(int index,AnalysisMessageBase item) {
    if (this.validationMessages == null) {
      this.validationMessages = new ArrayList();
    }
    AnalysisMessageBaseBuilder builder = new AnalysisMessageBaseBuilder(item);
    if (index < 0 || index >= validationMessages.size()) {
        _visitables.get("validationMessages").add(builder);
        validationMessages.add(builder);
    } else {
        _visitables.get("validationMessages").add(builder);
        validationMessages.add(index, builder);
    }
    return (A) this;
  }
  
  public ServiceEntryAddress buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<ServiceEntryAddress> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public IstioCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<IstioCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ServiceEntryAddress buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public IstioCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public AnalysisMessageBase buildFirstValidationMessage() {
    return this.validationMessages.get(0).build();
  }
  
  public ServiceEntryAddress buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public IstioCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public AnalysisMessageBase buildLastValidationMessage() {
    return this.validationMessages.get(validationMessages.size() - 1).build();
  }
  
  public ServiceEntryAddress buildMatchingAddress(Predicate<ServiceEntryAddressBuilder> predicate) {
      for (ServiceEntryAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IstioCondition buildMatchingCondition(Predicate<IstioConditionBuilder> predicate) {
      for (IstioConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AnalysisMessageBase buildMatchingValidationMessage(Predicate<AnalysisMessageBaseBuilder> predicate) {
      for (AnalysisMessageBaseBuilder item : validationMessages) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AnalysisMessageBase buildValidationMessage(int index) {
    return this.validationMessages.get(index).build();
  }
  
  public List<AnalysisMessageBase> buildValidationMessages() {
    return this.validationMessages != null ? build(validationMessages) : null;
  }
  
  protected void copyInstance(ServiceEntryStatus instance) {
    instance = instance != null ? instance : new ServiceEntryStatus();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withConditions(instance.getConditions());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withValidationMessages(instance.getValidationMessages());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public ValidationMessagesNested<A> editFirstValidationMessage() {
    if (validationMessages.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "validationMessages"));
    }
    return this.setNewValidationMessageLike(0, this.buildValidationMessage(0));
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
  
  public ValidationMessagesNested<A> editLastValidationMessage() {
    int index = validationMessages.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "validationMessages"));
    }
    return this.setNewValidationMessageLike(index, this.buildValidationMessage(index));
  }
  
  public AddressesNested<A> editMatchingAddress(Predicate<ServiceEntryAddressBuilder> predicate) {
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<IstioConditionBuilder> predicate) {
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
  
  public ValidationMessagesNested<A> editMatchingValidationMessage(Predicate<AnalysisMessageBaseBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < validationMessages.size();i++) {
      if (predicate.test(validationMessages.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "validationMessages"));
    }
    return this.setNewValidationMessageLike(index, this.buildValidationMessage(index));
  }
  
  public ValidationMessagesNested<A> editValidationMessage(int index) {
    if (validationMessages.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "validationMessages"));
    }
    return this.setNewValidationMessageLike(index, this.buildValidationMessage(index));
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
    ServiceEntryStatusFluent that = (ServiceEntryStatusFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(validationMessages, that.validationMessages))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingAddress(Predicate<ServiceEntryAddressBuilder> predicate) {
      for (ServiceEntryAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<IstioConditionBuilder> predicate) {
      for (IstioConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingValidationMessage(Predicate<AnalysisMessageBaseBuilder> predicate) {
      for (AnalysisMessageBaseBuilder item : validationMessages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasValidationMessages() {
    return this.validationMessages != null && !(this.validationMessages.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(addresses, conditions, observedGeneration, validationMessages, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<ServiceEntryAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (ServiceEntryAddress item : items) {
        ServiceEntryAddressBuilder builder = new ServiceEntryAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<IstioCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (IstioCondition item : items) {
        IstioConditionBuilder builder = new IstioConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromValidationMessages(Collection<AnalysisMessageBase> items) {
    if (this.validationMessages == null) {
      return (A) this;
    }
    for (AnalysisMessageBase item : items) {
        AnalysisMessageBaseBuilder builder = new AnalysisMessageBaseBuilder(item);
        _visitables.get("validationMessages").remove(builder);
        this.validationMessages.remove(builder);
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
  
  public A removeFromAddresses(ServiceEntryAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (ServiceEntryAddress item : items) {
        ServiceEntryAddressBuilder builder = new ServiceEntryAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(IstioCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (IstioCondition item : items) {
        IstioConditionBuilder builder = new IstioConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromValidationMessages(AnalysisMessageBase... items) {
    if (this.validationMessages == null) {
      return (A) this;
    }
    for (AnalysisMessageBase item : items) {
        AnalysisMessageBaseBuilder builder = new AnalysisMessageBaseBuilder(item);
        _visitables.get("validationMessages").remove(builder);
        this.validationMessages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddresses(Predicate<ServiceEntryAddressBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<ServiceEntryAddressBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        ServiceEntryAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<IstioConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<IstioConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        IstioConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromValidationMessages(Predicate<AnalysisMessageBaseBuilder> predicate) {
    if (validationMessages == null) {
      return (A) this;
    }
    Iterator<AnalysisMessageBaseBuilder> each = validationMessages.iterator();
    List visitables = _visitables.get("validationMessages");
    while (each.hasNext()) {
        AnalysisMessageBaseBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesNested<A> setNewAddressLike(int index,ServiceEntryAddress item) {
    return new AddressesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,IstioCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public ValidationMessagesNested<A> setNewValidationMessageLike(int index,AnalysisMessageBase item) {
    return new ValidationMessagesNested(index, item);
  }
  
  public A setToAddresses(int index,ServiceEntryAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    ServiceEntryAddressBuilder builder = new ServiceEntryAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,IstioCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    IstioConditionBuilder builder = new IstioConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToValidationMessages(int index,AnalysisMessageBase item) {
    if (this.validationMessages == null) {
      this.validationMessages = new ArrayList();
    }
    AnalysisMessageBaseBuilder builder = new AnalysisMessageBaseBuilder(item);
    if (index < 0 || index >= validationMessages.size()) {
        _visitables.get("validationMessages").add(builder);
        validationMessages.add(builder);
    } else {
        _visitables.get("validationMessages").add(builder);
        validationMessages.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
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
    if (!(validationMessages == null) && !(validationMessages.isEmpty())) {
        sb.append("validationMessages:");
        sb.append(validationMessages);
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
  
  public A withAddresses(List<ServiceEntryAddress> addresses) {
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (ServiceEntryAddress item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(ServiceEntryAddress... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (ServiceEntryAddress item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<IstioCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (IstioCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(IstioCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (IstioCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withValidationMessages(List<AnalysisMessageBase> validationMessages) {
    if (this.validationMessages != null) {
      this._visitables.get("validationMessages").clear();
    }
    if (validationMessages != null) {
        this.validationMessages = new ArrayList();
        for (AnalysisMessageBase item : validationMessages) {
          this.addToValidationMessages(item);
        }
    } else {
      this.validationMessages = null;
    }
    return (A) this;
  }
  
  public A withValidationMessages(AnalysisMessageBase... validationMessages) {
    if (this.validationMessages != null) {
        this.validationMessages.clear();
        _visitables.remove("validationMessages");
    }
    if (validationMessages != null) {
      for (AnalysisMessageBase item : validationMessages) {
        this.addToValidationMessages(item);
      }
    }
    return (A) this;
  }
  public class AddressesNested<N> extends ServiceEntryAddressFluent<AddressesNested<N>> implements Nested<N>{
  
    ServiceEntryAddressBuilder builder;
    int index;
  
    AddressesNested(int index,ServiceEntryAddress item) {
      this.index = index;
      this.builder = new ServiceEntryAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceEntryStatusFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends IstioConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    IstioConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,IstioCondition item) {
      this.index = index;
      this.builder = new IstioConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceEntryStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ValidationMessagesNested<N> extends AnalysisMessageBaseFluent<ValidationMessagesNested<N>> implements Nested<N>{
  
    AnalysisMessageBaseBuilder builder;
    int index;
  
    ValidationMessagesNested(int index,AnalysisMessageBase item) {
      this.index = index;
      this.builder = new AnalysisMessageBaseBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceEntryStatusFluent.this.setToValidationMessages(index, builder.build());
    }
    
    public N endValidationMessage() {
      return and();
    }
    
  }
}