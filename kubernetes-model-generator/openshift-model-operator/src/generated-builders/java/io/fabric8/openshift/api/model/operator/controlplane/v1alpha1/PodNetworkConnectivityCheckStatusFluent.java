package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class PodNetworkConnectivityCheckStatusFluent<A extends io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheckStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PodNetworkConnectivityCheckConditionBuilder> conditions = new ArrayList<PodNetworkConnectivityCheckConditionBuilder>();
  private ArrayList<LogEntryBuilder> failures = new ArrayList<LogEntryBuilder>();
  private ArrayList<OutageEntryBuilder> outages = new ArrayList<OutageEntryBuilder>();
  private ArrayList<LogEntryBuilder> successes = new ArrayList<LogEntryBuilder>();

  public PodNetworkConnectivityCheckStatusFluent() {
  }
  
  public PodNetworkConnectivityCheckStatusFluent(PodNetworkConnectivityCheckStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<PodNetworkConnectivityCheckCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PodNetworkConnectivityCheckCondition item : items) {
        PodNetworkConnectivityCheckConditionBuilder builder = new PodNetworkConnectivityCheckConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFailures(Collection<LogEntry> items) {
    if (this.failures == null) {
      this.failures = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("failures").add(builder);
        this.failures.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOutages(Collection<OutageEntry> items) {
    if (this.outages == null) {
      this.outages = new ArrayList();
    }
    for (OutageEntry item : items) {
        OutageEntryBuilder builder = new OutageEntryBuilder(item);
        _visitables.get("outages").add(builder);
        this.outages.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSuccesses(Collection<LogEntry> items) {
    if (this.successes == null) {
      this.successes = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("successes").add(builder);
        this.successes.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new PodNetworkConnectivityCheckCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(PodNetworkConnectivityCheckCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public FailuresNested<A> addNewFailure() {
    return new FailuresNested(-1, null);
  }
  
  public A addNewFailure(String latency,String message,String reason,Boolean success,String time) {
    return (A) this.addToFailures(new LogEntry(latency, message, reason, success, time));
  }
  
  public FailuresNested<A> addNewFailureLike(LogEntry item) {
    return new FailuresNested(-1, item);
  }
  
  public OutagesNested<A> addNewOutage() {
    return new OutagesNested(-1, null);
  }
  
  public OutagesNested<A> addNewOutageLike(OutageEntry item) {
    return new OutagesNested(-1, item);
  }
  
  public SuccessesNested<A> addNewSuccess() {
    return new SuccessesNested(-1, null);
  }
  
  public A addNewSuccess(String latency,String message,String reason,Boolean success,String time) {
    return (A) this.addToSuccesses(new LogEntry(latency, message, reason, success, time));
  }
  
  public SuccessesNested<A> addNewSuccessLike(LogEntry item) {
    return new SuccessesNested(-1, item);
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
  
  public A addToConditions(PodNetworkConnectivityCheckCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PodNetworkConnectivityCheckCondition item : items) {
        PodNetworkConnectivityCheckConditionBuilder builder = new PodNetworkConnectivityCheckConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,PodNetworkConnectivityCheckCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PodNetworkConnectivityCheckConditionBuilder builder = new PodNetworkConnectivityCheckConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFailures(LogEntry... items) {
    if (this.failures == null) {
      this.failures = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("failures").add(builder);
        this.failures.add(builder);
    }
    return (A) this;
  }
  
  public A addToFailures(int index,LogEntry item) {
    if (this.failures == null) {
      this.failures = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= failures.size()) {
        _visitables.get("failures").add(builder);
        failures.add(builder);
    } else {
        _visitables.get("failures").add(builder);
        failures.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOutages(OutageEntry... items) {
    if (this.outages == null) {
      this.outages = new ArrayList();
    }
    for (OutageEntry item : items) {
        OutageEntryBuilder builder = new OutageEntryBuilder(item);
        _visitables.get("outages").add(builder);
        this.outages.add(builder);
    }
    return (A) this;
  }
  
  public A addToOutages(int index,OutageEntry item) {
    if (this.outages == null) {
      this.outages = new ArrayList();
    }
    OutageEntryBuilder builder = new OutageEntryBuilder(item);
    if (index < 0 || index >= outages.size()) {
        _visitables.get("outages").add(builder);
        outages.add(builder);
    } else {
        _visitables.get("outages").add(builder);
        outages.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSuccesses(LogEntry... items) {
    if (this.successes == null) {
      this.successes = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("successes").add(builder);
        this.successes.add(builder);
    }
    return (A) this;
  }
  
  public A addToSuccesses(int index,LogEntry item) {
    if (this.successes == null) {
      this.successes = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= successes.size()) {
        _visitables.get("successes").add(builder);
        successes.add(builder);
    } else {
        _visitables.get("successes").add(builder);
        successes.add(index, builder);
    }
    return (A) this;
  }
  
  public PodNetworkConnectivityCheckCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<PodNetworkConnectivityCheckCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public LogEntry buildFailure(int index) {
    return this.failures.get(index).build();
  }
  
  public List<LogEntry> buildFailures() {
    return this.failures != null ? build(failures) : null;
  }
  
  public PodNetworkConnectivityCheckCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public LogEntry buildFirstFailure() {
    return this.failures.get(0).build();
  }
  
  public OutageEntry buildFirstOutage() {
    return this.outages.get(0).build();
  }
  
  public LogEntry buildFirstSuccess() {
    return this.successes.get(0).build();
  }
  
  public PodNetworkConnectivityCheckCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public LogEntry buildLastFailure() {
    return this.failures.get(failures.size() - 1).build();
  }
  
  public OutageEntry buildLastOutage() {
    return this.outages.get(outages.size() - 1).build();
  }
  
  public LogEntry buildLastSuccess() {
    return this.successes.get(successes.size() - 1).build();
  }
  
  public PodNetworkConnectivityCheckCondition buildMatchingCondition(Predicate<PodNetworkConnectivityCheckConditionBuilder> predicate) {
      for (PodNetworkConnectivityCheckConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LogEntry buildMatchingFailure(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : failures) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OutageEntry buildMatchingOutage(Predicate<OutageEntryBuilder> predicate) {
      for (OutageEntryBuilder item : outages) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LogEntry buildMatchingSuccess(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : successes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OutageEntry buildOutage(int index) {
    return this.outages.get(index).build();
  }
  
  public List<OutageEntry> buildOutages() {
    return this.outages != null ? build(outages) : null;
  }
  
  public LogEntry buildSuccess(int index) {
    return this.successes.get(index).build();
  }
  
  public List<LogEntry> buildSuccesses() {
    return this.successes != null ? build(successes) : null;
  }
  
  protected void copyInstance(PodNetworkConnectivityCheckStatus instance) {
    instance = instance != null ? instance : new PodNetworkConnectivityCheckStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withFailures(instance.getFailures());
        this.withOutages(instance.getOutages());
        this.withSuccesses(instance.getSuccesses());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public FailuresNested<A> editFailure(int index) {
    if (failures.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "failures"));
    }
    return this.setNewFailureLike(index, this.buildFailure(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public FailuresNested<A> editFirstFailure() {
    if (failures.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "failures"));
    }
    return this.setNewFailureLike(0, this.buildFailure(0));
  }
  
  public OutagesNested<A> editFirstOutage() {
    if (outages.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "outages"));
    }
    return this.setNewOutageLike(0, this.buildOutage(0));
  }
  
  public SuccessesNested<A> editFirstSuccess() {
    if (successes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "successes"));
    }
    return this.setNewSuccessLike(0, this.buildSuccess(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public FailuresNested<A> editLastFailure() {
    int index = failures.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "failures"));
    }
    return this.setNewFailureLike(index, this.buildFailure(index));
  }
  
  public OutagesNested<A> editLastOutage() {
    int index = outages.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "outages"));
    }
    return this.setNewOutageLike(index, this.buildOutage(index));
  }
  
  public SuccessesNested<A> editLastSuccess() {
    int index = successes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "successes"));
    }
    return this.setNewSuccessLike(index, this.buildSuccess(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<PodNetworkConnectivityCheckConditionBuilder> predicate) {
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
  
  public FailuresNested<A> editMatchingFailure(Predicate<LogEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < failures.size();i++) {
      if (predicate.test(failures.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "failures"));
    }
    return this.setNewFailureLike(index, this.buildFailure(index));
  }
  
  public OutagesNested<A> editMatchingOutage(Predicate<OutageEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < outages.size();i++) {
      if (predicate.test(outages.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "outages"));
    }
    return this.setNewOutageLike(index, this.buildOutage(index));
  }
  
  public SuccessesNested<A> editMatchingSuccess(Predicate<LogEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < successes.size();i++) {
      if (predicate.test(successes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "successes"));
    }
    return this.setNewSuccessLike(index, this.buildSuccess(index));
  }
  
  public OutagesNested<A> editOutage(int index) {
    if (outages.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "outages"));
    }
    return this.setNewOutageLike(index, this.buildOutage(index));
  }
  
  public SuccessesNested<A> editSuccess(int index) {
    if (successes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "successes"));
    }
    return this.setNewSuccessLike(index, this.buildSuccess(index));
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
    PodNetworkConnectivityCheckStatusFluent that = (PodNetworkConnectivityCheckStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(failures, that.failures))) {
      return false;
    }
    if (!(Objects.equals(outages, that.outages))) {
      return false;
    }
    if (!(Objects.equals(successes, that.successes))) {
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
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFailures() {
    return this.failures != null && !(this.failures.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<PodNetworkConnectivityCheckConditionBuilder> predicate) {
      for (PodNetworkConnectivityCheckConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailure(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : failures) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOutage(Predicate<OutageEntryBuilder> predicate) {
      for (OutageEntryBuilder item : outages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSuccess(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : successes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOutages() {
    return this.outages != null && !(this.outages.isEmpty());
  }
  
  public boolean hasSuccesses() {
    return this.successes != null && !(this.successes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, failures, outages, successes, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<PodNetworkConnectivityCheckCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PodNetworkConnectivityCheckCondition item : items) {
        PodNetworkConnectivityCheckConditionBuilder builder = new PodNetworkConnectivityCheckConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFailures(Collection<LogEntry> items) {
    if (this.failures == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("failures").remove(builder);
        this.failures.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOutages(Collection<OutageEntry> items) {
    if (this.outages == null) {
      return (A) this;
    }
    for (OutageEntry item : items) {
        OutageEntryBuilder builder = new OutageEntryBuilder(item);
        _visitables.get("outages").remove(builder);
        this.outages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSuccesses(Collection<LogEntry> items) {
    if (this.successes == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("successes").remove(builder);
        this.successes.remove(builder);
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
  
  public A removeFromConditions(PodNetworkConnectivityCheckCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PodNetworkConnectivityCheckCondition item : items) {
        PodNetworkConnectivityCheckConditionBuilder builder = new PodNetworkConnectivityCheckConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFailures(LogEntry... items) {
    if (this.failures == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("failures").remove(builder);
        this.failures.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOutages(OutageEntry... items) {
    if (this.outages == null) {
      return (A) this;
    }
    for (OutageEntry item : items) {
        OutageEntryBuilder builder = new OutageEntryBuilder(item);
        _visitables.get("outages").remove(builder);
        this.outages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSuccesses(LogEntry... items) {
    if (this.successes == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("successes").remove(builder);
        this.successes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<PodNetworkConnectivityCheckConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<PodNetworkConnectivityCheckConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        PodNetworkConnectivityCheckConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFailures(Predicate<LogEntryBuilder> predicate) {
    if (failures == null) {
      return (A) this;
    }
    Iterator<LogEntryBuilder> each = failures.iterator();
    List visitables = _visitables.get("failures");
    while (each.hasNext()) {
        LogEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOutages(Predicate<OutageEntryBuilder> predicate) {
    if (outages == null) {
      return (A) this;
    }
    Iterator<OutageEntryBuilder> each = outages.iterator();
    List visitables = _visitables.get("outages");
    while (each.hasNext()) {
        OutageEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSuccesses(Predicate<LogEntryBuilder> predicate) {
    if (successes == null) {
      return (A) this;
    }
    Iterator<LogEntryBuilder> each = successes.iterator();
    List visitables = _visitables.get("successes");
    while (each.hasNext()) {
        LogEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,PodNetworkConnectivityCheckCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public FailuresNested<A> setNewFailureLike(int index,LogEntry item) {
    return new FailuresNested(index, item);
  }
  
  public OutagesNested<A> setNewOutageLike(int index,OutageEntry item) {
    return new OutagesNested(index, item);
  }
  
  public SuccessesNested<A> setNewSuccessLike(int index,LogEntry item) {
    return new SuccessesNested(index, item);
  }
  
  public A setToConditions(int index,PodNetworkConnectivityCheckCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PodNetworkConnectivityCheckConditionBuilder builder = new PodNetworkConnectivityCheckConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFailures(int index,LogEntry item) {
    if (this.failures == null) {
      this.failures = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= failures.size()) {
        _visitables.get("failures").add(builder);
        failures.add(builder);
    } else {
        _visitables.get("failures").add(builder);
        failures.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOutages(int index,OutageEntry item) {
    if (this.outages == null) {
      this.outages = new ArrayList();
    }
    OutageEntryBuilder builder = new OutageEntryBuilder(item);
    if (index < 0 || index >= outages.size()) {
        _visitables.get("outages").add(builder);
        outages.add(builder);
    } else {
        _visitables.get("outages").add(builder);
        outages.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSuccesses(int index,LogEntry item) {
    if (this.successes == null) {
      this.successes = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= successes.size()) {
        _visitables.get("successes").add(builder);
        successes.add(builder);
    } else {
        _visitables.get("successes").add(builder);
        successes.set(index, builder);
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
    if (!(failures == null) && !(failures.isEmpty())) {
        sb.append("failures:");
        sb.append(failures);
        sb.append(",");
    }
    if (!(outages == null) && !(outages.isEmpty())) {
        sb.append("outages:");
        sb.append(outages);
        sb.append(",");
    }
    if (!(successes == null) && !(successes.isEmpty())) {
        sb.append("successes:");
        sb.append(successes);
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
  
  public A withConditions(List<PodNetworkConnectivityCheckCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (PodNetworkConnectivityCheckCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(PodNetworkConnectivityCheckCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (PodNetworkConnectivityCheckCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFailures(List<LogEntry> failures) {
    if (this.failures != null) {
      this._visitables.get("failures").clear();
    }
    if (failures != null) {
        this.failures = new ArrayList();
        for (LogEntry item : failures) {
          this.addToFailures(item);
        }
    } else {
      this.failures = null;
    }
    return (A) this;
  }
  
  public A withFailures(LogEntry... failures) {
    if (this.failures != null) {
        this.failures.clear();
        _visitables.remove("failures");
    }
    if (failures != null) {
      for (LogEntry item : failures) {
        this.addToFailures(item);
      }
    }
    return (A) this;
  }
  
  public A withOutages(List<OutageEntry> outages) {
    if (this.outages != null) {
      this._visitables.get("outages").clear();
    }
    if (outages != null) {
        this.outages = new ArrayList();
        for (OutageEntry item : outages) {
          this.addToOutages(item);
        }
    } else {
      this.outages = null;
    }
    return (A) this;
  }
  
  public A withOutages(OutageEntry... outages) {
    if (this.outages != null) {
        this.outages.clear();
        _visitables.remove("outages");
    }
    if (outages != null) {
      for (OutageEntry item : outages) {
        this.addToOutages(item);
      }
    }
    return (A) this;
  }
  
  public A withSuccesses(List<LogEntry> successes) {
    if (this.successes != null) {
      this._visitables.get("successes").clear();
    }
    if (successes != null) {
        this.successes = new ArrayList();
        for (LogEntry item : successes) {
          this.addToSuccesses(item);
        }
    } else {
      this.successes = null;
    }
    return (A) this;
  }
  
  public A withSuccesses(LogEntry... successes) {
    if (this.successes != null) {
        this.successes.clear();
        _visitables.remove("successes");
    }
    if (successes != null) {
      for (LogEntry item : successes) {
        this.addToSuccesses(item);
      }
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends PodNetworkConnectivityCheckConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    PodNetworkConnectivityCheckConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,PodNetworkConnectivityCheckCondition item) {
      this.index = index;
      this.builder = new PodNetworkConnectivityCheckConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) PodNetworkConnectivityCheckStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class FailuresNested<N> extends LogEntryFluent<FailuresNested<N>> implements Nested<N>{
  
    LogEntryBuilder builder;
    int index;
  
    FailuresNested(int index,LogEntry item) {
      this.index = index;
      this.builder = new LogEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) PodNetworkConnectivityCheckStatusFluent.this.setToFailures(index, builder.build());
    }
    
    public N endFailure() {
      return and();
    }
    
  }
  public class OutagesNested<N> extends OutageEntryFluent<OutagesNested<N>> implements Nested<N>{
  
    OutageEntryBuilder builder;
    int index;
  
    OutagesNested(int index,OutageEntry item) {
      this.index = index;
      this.builder = new OutageEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) PodNetworkConnectivityCheckStatusFluent.this.setToOutages(index, builder.build());
    }
    
    public N endOutage() {
      return and();
    }
    
  }
  public class SuccessesNested<N> extends LogEntryFluent<SuccessesNested<N>> implements Nested<N>{
  
    LogEntryBuilder builder;
    int index;
  
    SuccessesNested(int index,LogEntry item) {
      this.index = index;
      this.builder = new LogEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) PodNetworkConnectivityCheckStatusFluent.this.setToSuccesses(index, builder.build());
    }
    
    public N endSuccess() {
      return and();
    }
    
  }
}