package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class MachinePoolStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.MachinePoolStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<MachinePoolConditionBuilder> conditions = new ArrayList<MachinePoolConditionBuilder>();
  private Long controlledByReplica;
  private ArrayList<MachineSetStatusBuilder> machineSets = new ArrayList<MachineSetStatusBuilder>();
  private List<String> ownedLabels = new ArrayList<String>();
  private List<String> ownedMachineLabels = new ArrayList<String>();
  private ArrayList<TaintIdentifierBuilder> ownedTaints = new ArrayList<TaintIdentifierBuilder>();
  private Integer replicas;

  public MachinePoolStatusFluent() {
  }
  
  public MachinePoolStatusFluent(MachinePoolStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<MachinePoolCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (MachinePoolCondition item : items) {
        MachinePoolConditionBuilder builder = new MachinePoolConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMachineSets(Collection<MachineSetStatus> items) {
    if (this.machineSets == null) {
      this.machineSets = new ArrayList();
    }
    for (MachineSetStatus item : items) {
        MachineSetStatusBuilder builder = new MachineSetStatusBuilder(item);
        _visitables.get("machineSets").add(builder);
        this.machineSets.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOwnedLabels(Collection<String> items) {
    if (this.ownedLabels == null) {
      this.ownedLabels = new ArrayList();
    }
    for (String item : items) {
      this.ownedLabels.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOwnedMachineLabels(Collection<String> items) {
    if (this.ownedMachineLabels == null) {
      this.ownedMachineLabels = new ArrayList();
    }
    for (String item : items) {
      this.ownedMachineLabels.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOwnedTaints(Collection<TaintIdentifier> items) {
    if (this.ownedTaints == null) {
      this.ownedTaints = new ArrayList();
    }
    for (TaintIdentifier item : items) {
        TaintIdentifierBuilder builder = new TaintIdentifierBuilder(item);
        _visitables.get("ownedTaints").add(builder);
        this.ownedTaints.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(MachinePoolCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public MachineSetsNested<A> addNewMachineSet() {
    return new MachineSetsNested(-1, null);
  }
  
  public MachineSetsNested<A> addNewMachineSetLike(MachineSetStatus item) {
    return new MachineSetsNested(-1, item);
  }
  
  public OwnedTaintsNested<A> addNewOwnedTaint() {
    return new OwnedTaintsNested(-1, null);
  }
  
  public A addNewOwnedTaint(String effect,String key) {
    return (A) this.addToOwnedTaints(new TaintIdentifier(effect, key));
  }
  
  public OwnedTaintsNested<A> addNewOwnedTaintLike(TaintIdentifier item) {
    return new OwnedTaintsNested(-1, item);
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
  
  public A addToConditions(MachinePoolCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (MachinePoolCondition item : items) {
        MachinePoolConditionBuilder builder = new MachinePoolConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,MachinePoolCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    MachinePoolConditionBuilder builder = new MachinePoolConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMachineSets(MachineSetStatus... items) {
    if (this.machineSets == null) {
      this.machineSets = new ArrayList();
    }
    for (MachineSetStatus item : items) {
        MachineSetStatusBuilder builder = new MachineSetStatusBuilder(item);
        _visitables.get("machineSets").add(builder);
        this.machineSets.add(builder);
    }
    return (A) this;
  }
  
  public A addToMachineSets(int index,MachineSetStatus item) {
    if (this.machineSets == null) {
      this.machineSets = new ArrayList();
    }
    MachineSetStatusBuilder builder = new MachineSetStatusBuilder(item);
    if (index < 0 || index >= machineSets.size()) {
        _visitables.get("machineSets").add(builder);
        machineSets.add(builder);
    } else {
        _visitables.get("machineSets").add(builder);
        machineSets.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOwnedLabels(String... items) {
    if (this.ownedLabels == null) {
      this.ownedLabels = new ArrayList();
    }
    for (String item : items) {
      this.ownedLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToOwnedLabels(int index,String item) {
    if (this.ownedLabels == null) {
      this.ownedLabels = new ArrayList();
    }
    this.ownedLabels.add(index, item);
    return (A) this;
  }
  
  public A addToOwnedMachineLabels(String... items) {
    if (this.ownedMachineLabels == null) {
      this.ownedMachineLabels = new ArrayList();
    }
    for (String item : items) {
      this.ownedMachineLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToOwnedMachineLabels(int index,String item) {
    if (this.ownedMachineLabels == null) {
      this.ownedMachineLabels = new ArrayList();
    }
    this.ownedMachineLabels.add(index, item);
    return (A) this;
  }
  
  public A addToOwnedTaints(TaintIdentifier... items) {
    if (this.ownedTaints == null) {
      this.ownedTaints = new ArrayList();
    }
    for (TaintIdentifier item : items) {
        TaintIdentifierBuilder builder = new TaintIdentifierBuilder(item);
        _visitables.get("ownedTaints").add(builder);
        this.ownedTaints.add(builder);
    }
    return (A) this;
  }
  
  public A addToOwnedTaints(int index,TaintIdentifier item) {
    if (this.ownedTaints == null) {
      this.ownedTaints = new ArrayList();
    }
    TaintIdentifierBuilder builder = new TaintIdentifierBuilder(item);
    if (index < 0 || index >= ownedTaints.size()) {
        _visitables.get("ownedTaints").add(builder);
        ownedTaints.add(builder);
    } else {
        _visitables.get("ownedTaints").add(builder);
        ownedTaints.add(index, builder);
    }
    return (A) this;
  }
  
  public MachinePoolCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<MachinePoolCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public MachinePoolCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public MachineSetStatus buildFirstMachineSet() {
    return this.machineSets.get(0).build();
  }
  
  public TaintIdentifier buildFirstOwnedTaint() {
    return this.ownedTaints.get(0).build();
  }
  
  public MachinePoolCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public MachineSetStatus buildLastMachineSet() {
    return this.machineSets.get(machineSets.size() - 1).build();
  }
  
  public TaintIdentifier buildLastOwnedTaint() {
    return this.ownedTaints.get(ownedTaints.size() - 1).build();
  }
  
  public MachineSetStatus buildMachineSet(int index) {
    return this.machineSets.get(index).build();
  }
  
  public List<MachineSetStatus> buildMachineSets() {
    return this.machineSets != null ? build(machineSets) : null;
  }
  
  public MachinePoolCondition buildMatchingCondition(Predicate<MachinePoolConditionBuilder> predicate) {
      for (MachinePoolConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachineSetStatus buildMatchingMachineSet(Predicate<MachineSetStatusBuilder> predicate) {
      for (MachineSetStatusBuilder item : machineSets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaintIdentifier buildMatchingOwnedTaint(Predicate<TaintIdentifierBuilder> predicate) {
      for (TaintIdentifierBuilder item : ownedTaints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaintIdentifier buildOwnedTaint(int index) {
    return this.ownedTaints.get(index).build();
  }
  
  public List<TaintIdentifier> buildOwnedTaints() {
    return this.ownedTaints != null ? build(ownedTaints) : null;
  }
  
  protected void copyInstance(MachinePoolStatus instance) {
    instance = instance != null ? instance : new MachinePoolStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withControlledByReplica(instance.getControlledByReplica());
        this.withMachineSets(instance.getMachineSets());
        this.withOwnedLabels(instance.getOwnedLabels());
        this.withOwnedMachineLabels(instance.getOwnedMachineLabels());
        this.withOwnedTaints(instance.getOwnedTaints());
        this.withReplicas(instance.getReplicas());
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
  
  public MachineSetsNested<A> editFirstMachineSet() {
    if (machineSets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "machineSets"));
    }
    return this.setNewMachineSetLike(0, this.buildMachineSet(0));
  }
  
  public OwnedTaintsNested<A> editFirstOwnedTaint() {
    if (ownedTaints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ownedTaints"));
    }
    return this.setNewOwnedTaintLike(0, this.buildOwnedTaint(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public MachineSetsNested<A> editLastMachineSet() {
    int index = machineSets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "machineSets"));
    }
    return this.setNewMachineSetLike(index, this.buildMachineSet(index));
  }
  
  public OwnedTaintsNested<A> editLastOwnedTaint() {
    int index = ownedTaints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ownedTaints"));
    }
    return this.setNewOwnedTaintLike(index, this.buildOwnedTaint(index));
  }
  
  public MachineSetsNested<A> editMachineSet(int index) {
    if (machineSets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "machineSets"));
    }
    return this.setNewMachineSetLike(index, this.buildMachineSet(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<MachinePoolConditionBuilder> predicate) {
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
  
  public MachineSetsNested<A> editMatchingMachineSet(Predicate<MachineSetStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < machineSets.size();i++) {
      if (predicate.test(machineSets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "machineSets"));
    }
    return this.setNewMachineSetLike(index, this.buildMachineSet(index));
  }
  
  public OwnedTaintsNested<A> editMatchingOwnedTaint(Predicate<TaintIdentifierBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ownedTaints.size();i++) {
      if (predicate.test(ownedTaints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ownedTaints"));
    }
    return this.setNewOwnedTaintLike(index, this.buildOwnedTaint(index));
  }
  
  public OwnedTaintsNested<A> editOwnedTaint(int index) {
    if (ownedTaints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ownedTaints"));
    }
    return this.setNewOwnedTaintLike(index, this.buildOwnedTaint(index));
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
    MachinePoolStatusFluent that = (MachinePoolStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(controlledByReplica, that.controlledByReplica))) {
      return false;
    }
    if (!(Objects.equals(machineSets, that.machineSets))) {
      return false;
    }
    if (!(Objects.equals(ownedLabels, that.ownedLabels))) {
      return false;
    }
    if (!(Objects.equals(ownedMachineLabels, that.ownedMachineLabels))) {
      return false;
    }
    if (!(Objects.equals(ownedTaints, that.ownedTaints))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
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
  
  public Long getControlledByReplica() {
    return this.controlledByReplica;
  }
  
  public String getFirstOwnedLabel() {
    return this.ownedLabels.get(0);
  }
  
  public String getFirstOwnedMachineLabel() {
    return this.ownedMachineLabels.get(0);
  }
  
  public String getLastOwnedLabel() {
    return this.ownedLabels.get(ownedLabels.size() - 1);
  }
  
  public String getLastOwnedMachineLabel() {
    return this.ownedMachineLabels.get(ownedMachineLabels.size() - 1);
  }
  
  public String getMatchingOwnedLabel(Predicate<String> predicate) {
      for (String item : ownedLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingOwnedMachineLabel(Predicate<String> predicate) {
      for (String item : ownedMachineLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOwnedLabel(int index) {
    return this.ownedLabels.get(index);
  }
  
  public List<String> getOwnedLabels() {
    return this.ownedLabels;
  }
  
  public String getOwnedMachineLabel(int index) {
    return this.ownedMachineLabels.get(index);
  }
  
  public List<String> getOwnedMachineLabels() {
    return this.ownedMachineLabels;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasControlledByReplica() {
    return this.controlledByReplica != null;
  }
  
  public boolean hasMachineSets() {
    return this.machineSets != null && !(this.machineSets.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<MachinePoolConditionBuilder> predicate) {
      for (MachinePoolConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMachineSet(Predicate<MachineSetStatusBuilder> predicate) {
      for (MachineSetStatusBuilder item : machineSets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOwnedLabel(Predicate<String> predicate) {
      for (String item : ownedLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOwnedMachineLabel(Predicate<String> predicate) {
      for (String item : ownedMachineLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOwnedTaint(Predicate<TaintIdentifierBuilder> predicate) {
      for (TaintIdentifierBuilder item : ownedTaints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOwnedLabels() {
    return this.ownedLabels != null && !(this.ownedLabels.isEmpty());
  }
  
  public boolean hasOwnedMachineLabels() {
    return this.ownedMachineLabels != null && !(this.ownedMachineLabels.isEmpty());
  }
  
  public boolean hasOwnedTaints() {
    return this.ownedTaints != null && !(this.ownedTaints.isEmpty());
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, controlledByReplica, machineSets, ownedLabels, ownedMachineLabels, ownedTaints, replicas, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<MachinePoolCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (MachinePoolCondition item : items) {
        MachinePoolConditionBuilder builder = new MachinePoolConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMachineSets(Collection<MachineSetStatus> items) {
    if (this.machineSets == null) {
      return (A) this;
    }
    for (MachineSetStatus item : items) {
        MachineSetStatusBuilder builder = new MachineSetStatusBuilder(item);
        _visitables.get("machineSets").remove(builder);
        this.machineSets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOwnedLabels(Collection<String> items) {
    if (this.ownedLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ownedLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOwnedMachineLabels(Collection<String> items) {
    if (this.ownedMachineLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ownedMachineLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOwnedTaints(Collection<TaintIdentifier> items) {
    if (this.ownedTaints == null) {
      return (A) this;
    }
    for (TaintIdentifier item : items) {
        TaintIdentifierBuilder builder = new TaintIdentifierBuilder(item);
        _visitables.get("ownedTaints").remove(builder);
        this.ownedTaints.remove(builder);
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
  
  public A removeFromConditions(MachinePoolCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (MachinePoolCondition item : items) {
        MachinePoolConditionBuilder builder = new MachinePoolConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMachineSets(MachineSetStatus... items) {
    if (this.machineSets == null) {
      return (A) this;
    }
    for (MachineSetStatus item : items) {
        MachineSetStatusBuilder builder = new MachineSetStatusBuilder(item);
        _visitables.get("machineSets").remove(builder);
        this.machineSets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOwnedLabels(String... items) {
    if (this.ownedLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ownedLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOwnedMachineLabels(String... items) {
    if (this.ownedMachineLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ownedMachineLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOwnedTaints(TaintIdentifier... items) {
    if (this.ownedTaints == null) {
      return (A) this;
    }
    for (TaintIdentifier item : items) {
        TaintIdentifierBuilder builder = new TaintIdentifierBuilder(item);
        _visitables.get("ownedTaints").remove(builder);
        this.ownedTaints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<MachinePoolConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<MachinePoolConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        MachinePoolConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMachineSets(Predicate<MachineSetStatusBuilder> predicate) {
    if (machineSets == null) {
      return (A) this;
    }
    Iterator<MachineSetStatusBuilder> each = machineSets.iterator();
    List visitables = _visitables.get("machineSets");
    while (each.hasNext()) {
        MachineSetStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOwnedTaints(Predicate<TaintIdentifierBuilder> predicate) {
    if (ownedTaints == null) {
      return (A) this;
    }
    Iterator<TaintIdentifierBuilder> each = ownedTaints.iterator();
    List visitables = _visitables.get("ownedTaints");
    while (each.hasNext()) {
        TaintIdentifierBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,MachinePoolCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public MachineSetsNested<A> setNewMachineSetLike(int index,MachineSetStatus item) {
    return new MachineSetsNested(index, item);
  }
  
  public OwnedTaintsNested<A> setNewOwnedTaintLike(int index,TaintIdentifier item) {
    return new OwnedTaintsNested(index, item);
  }
  
  public A setToConditions(int index,MachinePoolCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    MachinePoolConditionBuilder builder = new MachinePoolConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMachineSets(int index,MachineSetStatus item) {
    if (this.machineSets == null) {
      this.machineSets = new ArrayList();
    }
    MachineSetStatusBuilder builder = new MachineSetStatusBuilder(item);
    if (index < 0 || index >= machineSets.size()) {
        _visitables.get("machineSets").add(builder);
        machineSets.add(builder);
    } else {
        _visitables.get("machineSets").add(builder);
        machineSets.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOwnedLabels(int index,String item) {
    if (this.ownedLabels == null) {
      this.ownedLabels = new ArrayList();
    }
    this.ownedLabels.set(index, item);
    return (A) this;
  }
  
  public A setToOwnedMachineLabels(int index,String item) {
    if (this.ownedMachineLabels == null) {
      this.ownedMachineLabels = new ArrayList();
    }
    this.ownedMachineLabels.set(index, item);
    return (A) this;
  }
  
  public A setToOwnedTaints(int index,TaintIdentifier item) {
    if (this.ownedTaints == null) {
      this.ownedTaints = new ArrayList();
    }
    TaintIdentifierBuilder builder = new TaintIdentifierBuilder(item);
    if (index < 0 || index >= ownedTaints.size()) {
        _visitables.get("ownedTaints").add(builder);
        ownedTaints.add(builder);
    } else {
        _visitables.get("ownedTaints").add(builder);
        ownedTaints.set(index, builder);
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
    if (!(controlledByReplica == null)) {
        sb.append("controlledByReplica:");
        sb.append(controlledByReplica);
        sb.append(",");
    }
    if (!(machineSets == null) && !(machineSets.isEmpty())) {
        sb.append("machineSets:");
        sb.append(machineSets);
        sb.append(",");
    }
    if (!(ownedLabels == null) && !(ownedLabels.isEmpty())) {
        sb.append("ownedLabels:");
        sb.append(ownedLabels);
        sb.append(",");
    }
    if (!(ownedMachineLabels == null) && !(ownedMachineLabels.isEmpty())) {
        sb.append("ownedMachineLabels:");
        sb.append(ownedMachineLabels);
        sb.append(",");
    }
    if (!(ownedTaints == null) && !(ownedTaints.isEmpty())) {
        sb.append("ownedTaints:");
        sb.append(ownedTaints);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
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
  
  public A withConditions(List<MachinePoolCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (MachinePoolCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(MachinePoolCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (MachinePoolCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withControlledByReplica(Long controlledByReplica) {
    this.controlledByReplica = controlledByReplica;
    return (A) this;
  }
  
  public A withMachineSets(List<MachineSetStatus> machineSets) {
    if (this.machineSets != null) {
      this._visitables.get("machineSets").clear();
    }
    if (machineSets != null) {
        this.machineSets = new ArrayList();
        for (MachineSetStatus item : machineSets) {
          this.addToMachineSets(item);
        }
    } else {
      this.machineSets = null;
    }
    return (A) this;
  }
  
  public A withMachineSets(MachineSetStatus... machineSets) {
    if (this.machineSets != null) {
        this.machineSets.clear();
        _visitables.remove("machineSets");
    }
    if (machineSets != null) {
      for (MachineSetStatus item : machineSets) {
        this.addToMachineSets(item);
      }
    }
    return (A) this;
  }
  
  public A withOwnedLabels(List<String> ownedLabels) {
    if (ownedLabels != null) {
        this.ownedLabels = new ArrayList();
        for (String item : ownedLabels) {
          this.addToOwnedLabels(item);
        }
    } else {
      this.ownedLabels = null;
    }
    return (A) this;
  }
  
  public A withOwnedLabels(String... ownedLabels) {
    if (this.ownedLabels != null) {
        this.ownedLabels.clear();
        _visitables.remove("ownedLabels");
    }
    if (ownedLabels != null) {
      for (String item : ownedLabels) {
        this.addToOwnedLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withOwnedMachineLabels(List<String> ownedMachineLabels) {
    if (ownedMachineLabels != null) {
        this.ownedMachineLabels = new ArrayList();
        for (String item : ownedMachineLabels) {
          this.addToOwnedMachineLabels(item);
        }
    } else {
      this.ownedMachineLabels = null;
    }
    return (A) this;
  }
  
  public A withOwnedMachineLabels(String... ownedMachineLabels) {
    if (this.ownedMachineLabels != null) {
        this.ownedMachineLabels.clear();
        _visitables.remove("ownedMachineLabels");
    }
    if (ownedMachineLabels != null) {
      for (String item : ownedMachineLabels) {
        this.addToOwnedMachineLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withOwnedTaints(List<TaintIdentifier> ownedTaints) {
    if (this.ownedTaints != null) {
      this._visitables.get("ownedTaints").clear();
    }
    if (ownedTaints != null) {
        this.ownedTaints = new ArrayList();
        for (TaintIdentifier item : ownedTaints) {
          this.addToOwnedTaints(item);
        }
    } else {
      this.ownedTaints = null;
    }
    return (A) this;
  }
  
  public A withOwnedTaints(TaintIdentifier... ownedTaints) {
    if (this.ownedTaints != null) {
        this.ownedTaints.clear();
        _visitables.remove("ownedTaints");
    }
    if (ownedTaints != null) {
      for (TaintIdentifier item : ownedTaints) {
        this.addToOwnedTaints(item);
      }
    }
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  public class ConditionsNested<N> extends MachinePoolConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    MachinePoolConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,MachinePoolCondition item) {
      this.index = index;
      this.builder = new MachinePoolConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class MachineSetsNested<N> extends MachineSetStatusFluent<MachineSetsNested<N>> implements Nested<N>{
  
    MachineSetStatusBuilder builder;
    int index;
  
    MachineSetsNested(int index,MachineSetStatus item) {
      this.index = index;
      this.builder = new MachineSetStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolStatusFluent.this.setToMachineSets(index, builder.build());
    }
    
    public N endMachineSet() {
      return and();
    }
    
  }
  public class OwnedTaintsNested<N> extends TaintIdentifierFluent<OwnedTaintsNested<N>> implements Nested<N>{
  
    TaintIdentifierBuilder builder;
    int index;
  
    OwnedTaintsNested(int index,TaintIdentifier item) {
      this.index = index;
      this.builder = new TaintIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolStatusFluent.this.setToOwnedTaints(index, builder.build());
    }
    
    public N endOwnedTaint() {
      return and();
    }
    
  }
}