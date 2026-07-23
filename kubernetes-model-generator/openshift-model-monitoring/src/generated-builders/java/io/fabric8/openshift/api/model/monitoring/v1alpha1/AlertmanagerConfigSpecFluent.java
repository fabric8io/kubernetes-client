package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class AlertmanagerConfigSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<InhibitRuleBuilder> inhibitRules = new ArrayList<InhibitRuleBuilder>();
  private ArrayList<MuteTimeIntervalBuilder> muteTimeIntervals = new ArrayList<MuteTimeIntervalBuilder>();
  private ArrayList<ReceiverBuilder> receivers = new ArrayList<ReceiverBuilder>();
  private RouteBuilder route;

  public AlertmanagerConfigSpecFluent() {
  }
  
  public AlertmanagerConfigSpecFluent(AlertmanagerConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToInhibitRules(Collection<InhibitRule> items) {
    if (this.inhibitRules == null) {
      this.inhibitRules = new ArrayList();
    }
    for (InhibitRule item : items) {
        InhibitRuleBuilder builder = new InhibitRuleBuilder(item);
        _visitables.get("inhibitRules").add(builder);
        this.inhibitRules.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMuteTimeIntervals(Collection<MuteTimeInterval> items) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    for (MuteTimeInterval item : items) {
        MuteTimeIntervalBuilder builder = new MuteTimeIntervalBuilder(item);
        _visitables.get("muteTimeIntervals").add(builder);
        this.muteTimeIntervals.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToReceivers(Collection<Receiver> items) {
    if (this.receivers == null) {
      this.receivers = new ArrayList();
    }
    for (Receiver item : items) {
        ReceiverBuilder builder = new ReceiverBuilder(item);
        _visitables.get("receivers").add(builder);
        this.receivers.add(builder);
    }
    return (A) this;
  }
  
  public InhibitRulesNested<A> addNewInhibitRule() {
    return new InhibitRulesNested(-1, null);
  }
  
  public InhibitRulesNested<A> addNewInhibitRuleLike(InhibitRule item) {
    return new InhibitRulesNested(-1, item);
  }
  
  public MuteTimeIntervalsNested<A> addNewMuteTimeInterval() {
    return new MuteTimeIntervalsNested(-1, null);
  }
  
  public MuteTimeIntervalsNested<A> addNewMuteTimeIntervalLike(MuteTimeInterval item) {
    return new MuteTimeIntervalsNested(-1, item);
  }
  
  public ReceiversNested<A> addNewReceiver() {
    return new ReceiversNested(-1, null);
  }
  
  public ReceiversNested<A> addNewReceiverLike(Receiver item) {
    return new ReceiversNested(-1, item);
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
  
  public A addToInhibitRules(InhibitRule... items) {
    if (this.inhibitRules == null) {
      this.inhibitRules = new ArrayList();
    }
    for (InhibitRule item : items) {
        InhibitRuleBuilder builder = new InhibitRuleBuilder(item);
        _visitables.get("inhibitRules").add(builder);
        this.inhibitRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToInhibitRules(int index,InhibitRule item) {
    if (this.inhibitRules == null) {
      this.inhibitRules = new ArrayList();
    }
    InhibitRuleBuilder builder = new InhibitRuleBuilder(item);
    if (index < 0 || index >= inhibitRules.size()) {
        _visitables.get("inhibitRules").add(builder);
        inhibitRules.add(builder);
    } else {
        _visitables.get("inhibitRules").add(builder);
        inhibitRules.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMuteTimeIntervals(MuteTimeInterval... items) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    for (MuteTimeInterval item : items) {
        MuteTimeIntervalBuilder builder = new MuteTimeIntervalBuilder(item);
        _visitables.get("muteTimeIntervals").add(builder);
        this.muteTimeIntervals.add(builder);
    }
    return (A) this;
  }
  
  public A addToMuteTimeIntervals(int index,MuteTimeInterval item) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    MuteTimeIntervalBuilder builder = new MuteTimeIntervalBuilder(item);
    if (index < 0 || index >= muteTimeIntervals.size()) {
        _visitables.get("muteTimeIntervals").add(builder);
        muteTimeIntervals.add(builder);
    } else {
        _visitables.get("muteTimeIntervals").add(builder);
        muteTimeIntervals.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToReceivers(Receiver... items) {
    if (this.receivers == null) {
      this.receivers = new ArrayList();
    }
    for (Receiver item : items) {
        ReceiverBuilder builder = new ReceiverBuilder(item);
        _visitables.get("receivers").add(builder);
        this.receivers.add(builder);
    }
    return (A) this;
  }
  
  public A addToReceivers(int index,Receiver item) {
    if (this.receivers == null) {
      this.receivers = new ArrayList();
    }
    ReceiverBuilder builder = new ReceiverBuilder(item);
    if (index < 0 || index >= receivers.size()) {
        _visitables.get("receivers").add(builder);
        receivers.add(builder);
    } else {
        _visitables.get("receivers").add(builder);
        receivers.add(index, builder);
    }
    return (A) this;
  }
  
  public InhibitRule buildFirstInhibitRule() {
    return this.inhibitRules.get(0).build();
  }
  
  public MuteTimeInterval buildFirstMuteTimeInterval() {
    return this.muteTimeIntervals.get(0).build();
  }
  
  public Receiver buildFirstReceiver() {
    return this.receivers.get(0).build();
  }
  
  public InhibitRule buildInhibitRule(int index) {
    return this.inhibitRules.get(index).build();
  }
  
  public List<InhibitRule> buildInhibitRules() {
    return this.inhibitRules != null ? build(inhibitRules) : null;
  }
  
  public InhibitRule buildLastInhibitRule() {
    return this.inhibitRules.get(inhibitRules.size() - 1).build();
  }
  
  public MuteTimeInterval buildLastMuteTimeInterval() {
    return this.muteTimeIntervals.get(muteTimeIntervals.size() - 1).build();
  }
  
  public Receiver buildLastReceiver() {
    return this.receivers.get(receivers.size() - 1).build();
  }
  
  public InhibitRule buildMatchingInhibitRule(Predicate<InhibitRuleBuilder> predicate) {
      for (InhibitRuleBuilder item : inhibitRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MuteTimeInterval buildMatchingMuteTimeInterval(Predicate<MuteTimeIntervalBuilder> predicate) {
      for (MuteTimeIntervalBuilder item : muteTimeIntervals) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Receiver buildMatchingReceiver(Predicate<ReceiverBuilder> predicate) {
      for (ReceiverBuilder item : receivers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MuteTimeInterval buildMuteTimeInterval(int index) {
    return this.muteTimeIntervals.get(index).build();
  }
  
  public List<MuteTimeInterval> buildMuteTimeIntervals() {
    return this.muteTimeIntervals != null ? build(muteTimeIntervals) : null;
  }
  
  public Receiver buildReceiver(int index) {
    return this.receivers.get(index).build();
  }
  
  public List<Receiver> buildReceivers() {
    return this.receivers != null ? build(receivers) : null;
  }
  
  public Route buildRoute() {
    return this.route != null ? this.route.build() : null;
  }
  
  protected void copyInstance(AlertmanagerConfigSpec instance) {
    instance = instance != null ? instance : new AlertmanagerConfigSpec();
    if (instance != null) {
        this.withInhibitRules(instance.getInhibitRules());
        this.withMuteTimeIntervals(instance.getMuteTimeIntervals());
        this.withReceivers(instance.getReceivers());
        this.withRoute(instance.getRoute());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InhibitRulesNested<A> editFirstInhibitRule() {
    if (inhibitRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "inhibitRules"));
    }
    return this.setNewInhibitRuleLike(0, this.buildInhibitRule(0));
  }
  
  public MuteTimeIntervalsNested<A> editFirstMuteTimeInterval() {
    if (muteTimeIntervals.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "muteTimeIntervals"));
    }
    return this.setNewMuteTimeIntervalLike(0, this.buildMuteTimeInterval(0));
  }
  
  public ReceiversNested<A> editFirstReceiver() {
    if (receivers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "receivers"));
    }
    return this.setNewReceiverLike(0, this.buildReceiver(0));
  }
  
  public InhibitRulesNested<A> editInhibitRule(int index) {
    if (inhibitRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "inhibitRules"));
    }
    return this.setNewInhibitRuleLike(index, this.buildInhibitRule(index));
  }
  
  public InhibitRulesNested<A> editLastInhibitRule() {
    int index = inhibitRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "inhibitRules"));
    }
    return this.setNewInhibitRuleLike(index, this.buildInhibitRule(index));
  }
  
  public MuteTimeIntervalsNested<A> editLastMuteTimeInterval() {
    int index = muteTimeIntervals.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "muteTimeIntervals"));
    }
    return this.setNewMuteTimeIntervalLike(index, this.buildMuteTimeInterval(index));
  }
  
  public ReceiversNested<A> editLastReceiver() {
    int index = receivers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "receivers"));
    }
    return this.setNewReceiverLike(index, this.buildReceiver(index));
  }
  
  public InhibitRulesNested<A> editMatchingInhibitRule(Predicate<InhibitRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < inhibitRules.size();i++) {
      if (predicate.test(inhibitRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "inhibitRules"));
    }
    return this.setNewInhibitRuleLike(index, this.buildInhibitRule(index));
  }
  
  public MuteTimeIntervalsNested<A> editMatchingMuteTimeInterval(Predicate<MuteTimeIntervalBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < muteTimeIntervals.size();i++) {
      if (predicate.test(muteTimeIntervals.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "muteTimeIntervals"));
    }
    return this.setNewMuteTimeIntervalLike(index, this.buildMuteTimeInterval(index));
  }
  
  public ReceiversNested<A> editMatchingReceiver(Predicate<ReceiverBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < receivers.size();i++) {
      if (predicate.test(receivers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "receivers"));
    }
    return this.setNewReceiverLike(index, this.buildReceiver(index));
  }
  
  public MuteTimeIntervalsNested<A> editMuteTimeInterval(int index) {
    if (muteTimeIntervals.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "muteTimeIntervals"));
    }
    return this.setNewMuteTimeIntervalLike(index, this.buildMuteTimeInterval(index));
  }
  
  public RouteNested<A> editOrNewRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(new RouteBuilder().build()));
  }
  
  public RouteNested<A> editOrNewRouteLike(Route item) {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(item));
  }
  
  public ReceiversNested<A> editReceiver(int index) {
    if (receivers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "receivers"));
    }
    return this.setNewReceiverLike(index, this.buildReceiver(index));
  }
  
  public RouteNested<A> editRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(null));
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
    AlertmanagerConfigSpecFluent that = (AlertmanagerConfigSpecFluent) o;
    if (!(Objects.equals(inhibitRules, that.inhibitRules))) {
      return false;
    }
    if (!(Objects.equals(muteTimeIntervals, that.muteTimeIntervals))) {
      return false;
    }
    if (!(Objects.equals(receivers, that.receivers))) {
      return false;
    }
    if (!(Objects.equals(route, that.route))) {
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
  
  public boolean hasInhibitRules() {
    return this.inhibitRules != null && !(this.inhibitRules.isEmpty());
  }
  
  public boolean hasMatchingInhibitRule(Predicate<InhibitRuleBuilder> predicate) {
      for (InhibitRuleBuilder item : inhibitRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMuteTimeInterval(Predicate<MuteTimeIntervalBuilder> predicate) {
      for (MuteTimeIntervalBuilder item : muteTimeIntervals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingReceiver(Predicate<ReceiverBuilder> predicate) {
      for (ReceiverBuilder item : receivers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMuteTimeIntervals() {
    return this.muteTimeIntervals != null && !(this.muteTimeIntervals.isEmpty());
  }
  
  public boolean hasReceivers() {
    return this.receivers != null && !(this.receivers.isEmpty());
  }
  
  public boolean hasRoute() {
    return this.route != null;
  }
  
  public int hashCode() {
    return Objects.hash(inhibitRules, muteTimeIntervals, receivers, route, additionalProperties);
  }
  
  public A removeAllFromInhibitRules(Collection<InhibitRule> items) {
    if (this.inhibitRules == null) {
      return (A) this;
    }
    for (InhibitRule item : items) {
        InhibitRuleBuilder builder = new InhibitRuleBuilder(item);
        _visitables.get("inhibitRules").remove(builder);
        this.inhibitRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMuteTimeIntervals(Collection<MuteTimeInterval> items) {
    if (this.muteTimeIntervals == null) {
      return (A) this;
    }
    for (MuteTimeInterval item : items) {
        MuteTimeIntervalBuilder builder = new MuteTimeIntervalBuilder(item);
        _visitables.get("muteTimeIntervals").remove(builder);
        this.muteTimeIntervals.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromReceivers(Collection<Receiver> items) {
    if (this.receivers == null) {
      return (A) this;
    }
    for (Receiver item : items) {
        ReceiverBuilder builder = new ReceiverBuilder(item);
        _visitables.get("receivers").remove(builder);
        this.receivers.remove(builder);
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
  
  public A removeFromInhibitRules(InhibitRule... items) {
    if (this.inhibitRules == null) {
      return (A) this;
    }
    for (InhibitRule item : items) {
        InhibitRuleBuilder builder = new InhibitRuleBuilder(item);
        _visitables.get("inhibitRules").remove(builder);
        this.inhibitRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMuteTimeIntervals(MuteTimeInterval... items) {
    if (this.muteTimeIntervals == null) {
      return (A) this;
    }
    for (MuteTimeInterval item : items) {
        MuteTimeIntervalBuilder builder = new MuteTimeIntervalBuilder(item);
        _visitables.get("muteTimeIntervals").remove(builder);
        this.muteTimeIntervals.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromReceivers(Receiver... items) {
    if (this.receivers == null) {
      return (A) this;
    }
    for (Receiver item : items) {
        ReceiverBuilder builder = new ReceiverBuilder(item);
        _visitables.get("receivers").remove(builder);
        this.receivers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInhibitRules(Predicate<InhibitRuleBuilder> predicate) {
    if (inhibitRules == null) {
      return (A) this;
    }
    Iterator<InhibitRuleBuilder> each = inhibitRules.iterator();
    List visitables = _visitables.get("inhibitRules");
    while (each.hasNext()) {
        InhibitRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMuteTimeIntervals(Predicate<MuteTimeIntervalBuilder> predicate) {
    if (muteTimeIntervals == null) {
      return (A) this;
    }
    Iterator<MuteTimeIntervalBuilder> each = muteTimeIntervals.iterator();
    List visitables = _visitables.get("muteTimeIntervals");
    while (each.hasNext()) {
        MuteTimeIntervalBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromReceivers(Predicate<ReceiverBuilder> predicate) {
    if (receivers == null) {
      return (A) this;
    }
    Iterator<ReceiverBuilder> each = receivers.iterator();
    List visitables = _visitables.get("receivers");
    while (each.hasNext()) {
        ReceiverBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InhibitRulesNested<A> setNewInhibitRuleLike(int index,InhibitRule item) {
    return new InhibitRulesNested(index, item);
  }
  
  public MuteTimeIntervalsNested<A> setNewMuteTimeIntervalLike(int index,MuteTimeInterval item) {
    return new MuteTimeIntervalsNested(index, item);
  }
  
  public ReceiversNested<A> setNewReceiverLike(int index,Receiver item) {
    return new ReceiversNested(index, item);
  }
  
  public A setToInhibitRules(int index,InhibitRule item) {
    if (this.inhibitRules == null) {
      this.inhibitRules = new ArrayList();
    }
    InhibitRuleBuilder builder = new InhibitRuleBuilder(item);
    if (index < 0 || index >= inhibitRules.size()) {
        _visitables.get("inhibitRules").add(builder);
        inhibitRules.add(builder);
    } else {
        _visitables.get("inhibitRules").add(builder);
        inhibitRules.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMuteTimeIntervals(int index,MuteTimeInterval item) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    MuteTimeIntervalBuilder builder = new MuteTimeIntervalBuilder(item);
    if (index < 0 || index >= muteTimeIntervals.size()) {
        _visitables.get("muteTimeIntervals").add(builder);
        muteTimeIntervals.add(builder);
    } else {
        _visitables.get("muteTimeIntervals").add(builder);
        muteTimeIntervals.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToReceivers(int index,Receiver item) {
    if (this.receivers == null) {
      this.receivers = new ArrayList();
    }
    ReceiverBuilder builder = new ReceiverBuilder(item);
    if (index < 0 || index >= receivers.size()) {
        _visitables.get("receivers").add(builder);
        receivers.add(builder);
    } else {
        _visitables.get("receivers").add(builder);
        receivers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(inhibitRules == null) && !(inhibitRules.isEmpty())) {
        sb.append("inhibitRules:");
        sb.append(inhibitRules);
        sb.append(",");
    }
    if (!(muteTimeIntervals == null) && !(muteTimeIntervals.isEmpty())) {
        sb.append("muteTimeIntervals:");
        sb.append(muteTimeIntervals);
        sb.append(",");
    }
    if (!(receivers == null) && !(receivers.isEmpty())) {
        sb.append("receivers:");
        sb.append(receivers);
        sb.append(",");
    }
    if (!(route == null)) {
        sb.append("route:");
        sb.append(route);
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
  
  public A withInhibitRules(List<InhibitRule> inhibitRules) {
    if (this.inhibitRules != null) {
      this._visitables.get("inhibitRules").clear();
    }
    if (inhibitRules != null) {
        this.inhibitRules = new ArrayList();
        for (InhibitRule item : inhibitRules) {
          this.addToInhibitRules(item);
        }
    } else {
      this.inhibitRules = null;
    }
    return (A) this;
  }
  
  public A withInhibitRules(InhibitRule... inhibitRules) {
    if (this.inhibitRules != null) {
        this.inhibitRules.clear();
        _visitables.remove("inhibitRules");
    }
    if (inhibitRules != null) {
      for (InhibitRule item : inhibitRules) {
        this.addToInhibitRules(item);
      }
    }
    return (A) this;
  }
  
  public A withMuteTimeIntervals(List<MuteTimeInterval> muteTimeIntervals) {
    if (this.muteTimeIntervals != null) {
      this._visitables.get("muteTimeIntervals").clear();
    }
    if (muteTimeIntervals != null) {
        this.muteTimeIntervals = new ArrayList();
        for (MuteTimeInterval item : muteTimeIntervals) {
          this.addToMuteTimeIntervals(item);
        }
    } else {
      this.muteTimeIntervals = null;
    }
    return (A) this;
  }
  
  public A withMuteTimeIntervals(MuteTimeInterval... muteTimeIntervals) {
    if (this.muteTimeIntervals != null) {
        this.muteTimeIntervals.clear();
        _visitables.remove("muteTimeIntervals");
    }
    if (muteTimeIntervals != null) {
      for (MuteTimeInterval item : muteTimeIntervals) {
        this.addToMuteTimeIntervals(item);
      }
    }
    return (A) this;
  }
  
  public RouteNested<A> withNewRoute() {
    return new RouteNested(null);
  }
  
  public RouteNested<A> withNewRouteLike(Route item) {
    return new RouteNested(item);
  }
  
  public A withReceivers(List<Receiver> receivers) {
    if (this.receivers != null) {
      this._visitables.get("receivers").clear();
    }
    if (receivers != null) {
        this.receivers = new ArrayList();
        for (Receiver item : receivers) {
          this.addToReceivers(item);
        }
    } else {
      this.receivers = null;
    }
    return (A) this;
  }
  
  public A withReceivers(Receiver... receivers) {
    if (this.receivers != null) {
        this.receivers.clear();
        _visitables.remove("receivers");
    }
    if (receivers != null) {
      for (Receiver item : receivers) {
        this.addToReceivers(item);
      }
    }
    return (A) this;
  }
  
  public A withRoute(Route route) {
    this._visitables.remove("route");
    if (route != null) {
        this.route = new RouteBuilder(route);
        this._visitables.get("route").add(this.route);
    } else {
        this.route = null;
        this._visitables.get("route").remove(this.route);
    }
    return (A) this;
  }
  public class InhibitRulesNested<N> extends InhibitRuleFluent<InhibitRulesNested<N>> implements Nested<N>{
  
    InhibitRuleBuilder builder;
    int index;
  
    InhibitRulesNested(int index,InhibitRule item) {
      this.index = index;
      this.builder = new InhibitRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerConfigSpecFluent.this.setToInhibitRules(index, builder.build());
    }
    
    public N endInhibitRule() {
      return and();
    }
    
  }
  public class MuteTimeIntervalsNested<N> extends MuteTimeIntervalFluent<MuteTimeIntervalsNested<N>> implements Nested<N>{
  
    MuteTimeIntervalBuilder builder;
    int index;
  
    MuteTimeIntervalsNested(int index,MuteTimeInterval item) {
      this.index = index;
      this.builder = new MuteTimeIntervalBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerConfigSpecFluent.this.setToMuteTimeIntervals(index, builder.build());
    }
    
    public N endMuteTimeInterval() {
      return and();
    }
    
  }
  public class ReceiversNested<N> extends ReceiverFluent<ReceiversNested<N>> implements Nested<N>{
  
    ReceiverBuilder builder;
    int index;
  
    ReceiversNested(int index,Receiver item) {
      this.index = index;
      this.builder = new ReceiverBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerConfigSpecFluent.this.setToReceivers(index, builder.build());
    }
    
    public N endReceiver() {
      return and();
    }
    
  }
  public class RouteNested<N> extends RouteFluent<RouteNested<N>> implements Nested<N>{
  
    RouteBuilder builder;
  
    RouteNested(Route item) {
      this.builder = new RouteBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerConfigSpecFluent.this.withRoute(builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}