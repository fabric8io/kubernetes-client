package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachineConfigNodeStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineConfigNodeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private MachineConfigNodeStatusMachineConfigVersionBuilder configVersion;
  private ArrayList<IrreconcilableChangeDiffBuilder> irreconcilableChanges = new ArrayList<IrreconcilableChangeDiffBuilder>();
  private Long observedGeneration;
  private ArrayList<MachineConfigNodeStatusPinnedImageSetBuilder> pinnedImageSets = new ArrayList<MachineConfigNodeStatusPinnedImageSetBuilder>();

  public MachineConfigNodeStatusFluent() {
  }
  
  public MachineConfigNodeStatusFluent(MachineConfigNodeStatus instance) {
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
  
  public A addAllToIrreconcilableChanges(Collection<IrreconcilableChangeDiff> items) {
    if (this.irreconcilableChanges == null) {
      this.irreconcilableChanges = new ArrayList();
    }
    for (IrreconcilableChangeDiff item : items) {
        IrreconcilableChangeDiffBuilder builder = new IrreconcilableChangeDiffBuilder(item);
        _visitables.get("irreconcilableChanges").add(builder);
        this.irreconcilableChanges.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPinnedImageSets(Collection<MachineConfigNodeStatusPinnedImageSet> items) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    for (MachineConfigNodeStatusPinnedImageSet item : items) {
        MachineConfigNodeStatusPinnedImageSetBuilder builder = new MachineConfigNodeStatusPinnedImageSetBuilder(item);
        _visitables.get("pinnedImageSets").add(builder);
        this.pinnedImageSets.add(builder);
    }
    return (A) this;
  }
  
  public IrreconcilableChangesNested<A> addNewIrreconcilableChange() {
    return new IrreconcilableChangesNested(-1, null);
  }
  
  public A addNewIrreconcilableChange(String diff,String fieldPath) {
    return (A) this.addToIrreconcilableChanges(new IrreconcilableChangeDiff(diff, fieldPath));
  }
  
  public IrreconcilableChangesNested<A> addNewIrreconcilableChangeLike(IrreconcilableChangeDiff item) {
    return new IrreconcilableChangesNested(-1, item);
  }
  
  public PinnedImageSetsNested<A> addNewPinnedImageSet() {
    return new PinnedImageSetsNested(-1, null);
  }
  
  public A addNewPinnedImageSet(Integer currentGeneration,Integer desiredGeneration,Integer lastFailedGeneration,String lastFailedGenerationError,String name) {
    return (A) this.addToPinnedImageSets(new MachineConfigNodeStatusPinnedImageSet(currentGeneration, desiredGeneration, lastFailedGeneration, lastFailedGenerationError, name));
  }
  
  public PinnedImageSetsNested<A> addNewPinnedImageSetLike(MachineConfigNodeStatusPinnedImageSet item) {
    return new PinnedImageSetsNested(-1, item);
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
  
  public A addToIrreconcilableChanges(IrreconcilableChangeDiff... items) {
    if (this.irreconcilableChanges == null) {
      this.irreconcilableChanges = new ArrayList();
    }
    for (IrreconcilableChangeDiff item : items) {
        IrreconcilableChangeDiffBuilder builder = new IrreconcilableChangeDiffBuilder(item);
        _visitables.get("irreconcilableChanges").add(builder);
        this.irreconcilableChanges.add(builder);
    }
    return (A) this;
  }
  
  public A addToIrreconcilableChanges(int index,IrreconcilableChangeDiff item) {
    if (this.irreconcilableChanges == null) {
      this.irreconcilableChanges = new ArrayList();
    }
    IrreconcilableChangeDiffBuilder builder = new IrreconcilableChangeDiffBuilder(item);
    if (index < 0 || index >= irreconcilableChanges.size()) {
        _visitables.get("irreconcilableChanges").add(builder);
        irreconcilableChanges.add(builder);
    } else {
        _visitables.get("irreconcilableChanges").add(builder);
        irreconcilableChanges.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPinnedImageSets(MachineConfigNodeStatusPinnedImageSet... items) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    for (MachineConfigNodeStatusPinnedImageSet item : items) {
        MachineConfigNodeStatusPinnedImageSetBuilder builder = new MachineConfigNodeStatusPinnedImageSetBuilder(item);
        _visitables.get("pinnedImageSets").add(builder);
        this.pinnedImageSets.add(builder);
    }
    return (A) this;
  }
  
  public A addToPinnedImageSets(int index,MachineConfigNodeStatusPinnedImageSet item) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    MachineConfigNodeStatusPinnedImageSetBuilder builder = new MachineConfigNodeStatusPinnedImageSetBuilder(item);
    if (index < 0 || index >= pinnedImageSets.size()) {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.add(builder);
    } else {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.add(index, builder);
    }
    return (A) this;
  }
  
  public MachineConfigNodeStatusMachineConfigVersion buildConfigVersion() {
    return this.configVersion != null ? this.configVersion.build() : null;
  }
  
  public IrreconcilableChangeDiff buildFirstIrreconcilableChange() {
    return this.irreconcilableChanges.get(0).build();
  }
  
  public MachineConfigNodeStatusPinnedImageSet buildFirstPinnedImageSet() {
    return this.pinnedImageSets.get(0).build();
  }
  
  public IrreconcilableChangeDiff buildIrreconcilableChange(int index) {
    return this.irreconcilableChanges.get(index).build();
  }
  
  public List<IrreconcilableChangeDiff> buildIrreconcilableChanges() {
    return this.irreconcilableChanges != null ? build(irreconcilableChanges) : null;
  }
  
  public IrreconcilableChangeDiff buildLastIrreconcilableChange() {
    return this.irreconcilableChanges.get(irreconcilableChanges.size() - 1).build();
  }
  
  public MachineConfigNodeStatusPinnedImageSet buildLastPinnedImageSet() {
    return this.pinnedImageSets.get(pinnedImageSets.size() - 1).build();
  }
  
  public IrreconcilableChangeDiff buildMatchingIrreconcilableChange(Predicate<IrreconcilableChangeDiffBuilder> predicate) {
      for (IrreconcilableChangeDiffBuilder item : irreconcilableChanges) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachineConfigNodeStatusPinnedImageSet buildMatchingPinnedImageSet(Predicate<MachineConfigNodeStatusPinnedImageSetBuilder> predicate) {
      for (MachineConfigNodeStatusPinnedImageSetBuilder item : pinnedImageSets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachineConfigNodeStatusPinnedImageSet buildPinnedImageSet(int index) {
    return this.pinnedImageSets.get(index).build();
  }
  
  public List<MachineConfigNodeStatusPinnedImageSet> buildPinnedImageSets() {
    return this.pinnedImageSets != null ? build(pinnedImageSets) : null;
  }
  
  protected void copyInstance(MachineConfigNodeStatus instance) {
    instance = instance != null ? instance : new MachineConfigNodeStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withConfigVersion(instance.getConfigVersion());
        this.withIrreconcilableChanges(instance.getIrreconcilableChanges());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPinnedImageSets(instance.getPinnedImageSets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigVersionNested<A> editConfigVersion() {
    return this.withNewConfigVersionLike(Optional.ofNullable(this.buildConfigVersion()).orElse(null));
  }
  
  public IrreconcilableChangesNested<A> editFirstIrreconcilableChange() {
    if (irreconcilableChanges.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "irreconcilableChanges"));
    }
    return this.setNewIrreconcilableChangeLike(0, this.buildIrreconcilableChange(0));
  }
  
  public PinnedImageSetsNested<A> editFirstPinnedImageSet() {
    if (pinnedImageSets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(0, this.buildPinnedImageSet(0));
  }
  
  public IrreconcilableChangesNested<A> editIrreconcilableChange(int index) {
    if (irreconcilableChanges.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "irreconcilableChanges"));
    }
    return this.setNewIrreconcilableChangeLike(index, this.buildIrreconcilableChange(index));
  }
  
  public IrreconcilableChangesNested<A> editLastIrreconcilableChange() {
    int index = irreconcilableChanges.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "irreconcilableChanges"));
    }
    return this.setNewIrreconcilableChangeLike(index, this.buildIrreconcilableChange(index));
  }
  
  public PinnedImageSetsNested<A> editLastPinnedImageSet() {
    int index = pinnedImageSets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(index, this.buildPinnedImageSet(index));
  }
  
  public IrreconcilableChangesNested<A> editMatchingIrreconcilableChange(Predicate<IrreconcilableChangeDiffBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < irreconcilableChanges.size();i++) {
      if (predicate.test(irreconcilableChanges.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "irreconcilableChanges"));
    }
    return this.setNewIrreconcilableChangeLike(index, this.buildIrreconcilableChange(index));
  }
  
  public PinnedImageSetsNested<A> editMatchingPinnedImageSet(Predicate<MachineConfigNodeStatusPinnedImageSetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pinnedImageSets.size();i++) {
      if (predicate.test(pinnedImageSets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(index, this.buildPinnedImageSet(index));
  }
  
  public ConfigVersionNested<A> editOrNewConfigVersion() {
    return this.withNewConfigVersionLike(Optional.ofNullable(this.buildConfigVersion()).orElse(new MachineConfigNodeStatusMachineConfigVersionBuilder().build()));
  }
  
  public ConfigVersionNested<A> editOrNewConfigVersionLike(MachineConfigNodeStatusMachineConfigVersion item) {
    return this.withNewConfigVersionLike(Optional.ofNullable(this.buildConfigVersion()).orElse(item));
  }
  
  public PinnedImageSetsNested<A> editPinnedImageSet(int index) {
    if (pinnedImageSets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pinnedImageSets"));
    }
    return this.setNewPinnedImageSetLike(index, this.buildPinnedImageSet(index));
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
    MachineConfigNodeStatusFluent that = (MachineConfigNodeStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(configVersion, that.configVersion))) {
      return false;
    }
    if (!(Objects.equals(irreconcilableChanges, that.irreconcilableChanges))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(pinnedImageSets, that.pinnedImageSets))) {
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
  
  public boolean hasConfigVersion() {
    return this.configVersion != null;
  }
  
  public boolean hasIrreconcilableChanges() {
    return this.irreconcilableChanges != null && !(this.irreconcilableChanges.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIrreconcilableChange(Predicate<IrreconcilableChangeDiffBuilder> predicate) {
      for (IrreconcilableChangeDiffBuilder item : irreconcilableChanges) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPinnedImageSet(Predicate<MachineConfigNodeStatusPinnedImageSetBuilder> predicate) {
      for (MachineConfigNodeStatusPinnedImageSetBuilder item : pinnedImageSets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPinnedImageSets() {
    return this.pinnedImageSets != null && !(this.pinnedImageSets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, configVersion, irreconcilableChanges, observedGeneration, pinnedImageSets, additionalProperties);
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
  
  public A removeAllFromIrreconcilableChanges(Collection<IrreconcilableChangeDiff> items) {
    if (this.irreconcilableChanges == null) {
      return (A) this;
    }
    for (IrreconcilableChangeDiff item : items) {
        IrreconcilableChangeDiffBuilder builder = new IrreconcilableChangeDiffBuilder(item);
        _visitables.get("irreconcilableChanges").remove(builder);
        this.irreconcilableChanges.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPinnedImageSets(Collection<MachineConfigNodeStatusPinnedImageSet> items) {
    if (this.pinnedImageSets == null) {
      return (A) this;
    }
    for (MachineConfigNodeStatusPinnedImageSet item : items) {
        MachineConfigNodeStatusPinnedImageSetBuilder builder = new MachineConfigNodeStatusPinnedImageSetBuilder(item);
        _visitables.get("pinnedImageSets").remove(builder);
        this.pinnedImageSets.remove(builder);
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
  
  public A removeFromIrreconcilableChanges(IrreconcilableChangeDiff... items) {
    if (this.irreconcilableChanges == null) {
      return (A) this;
    }
    for (IrreconcilableChangeDiff item : items) {
        IrreconcilableChangeDiffBuilder builder = new IrreconcilableChangeDiffBuilder(item);
        _visitables.get("irreconcilableChanges").remove(builder);
        this.irreconcilableChanges.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPinnedImageSets(MachineConfigNodeStatusPinnedImageSet... items) {
    if (this.pinnedImageSets == null) {
      return (A) this;
    }
    for (MachineConfigNodeStatusPinnedImageSet item : items) {
        MachineConfigNodeStatusPinnedImageSetBuilder builder = new MachineConfigNodeStatusPinnedImageSetBuilder(item);
        _visitables.get("pinnedImageSets").remove(builder);
        this.pinnedImageSets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromIrreconcilableChanges(Predicate<IrreconcilableChangeDiffBuilder> predicate) {
    if (irreconcilableChanges == null) {
      return (A) this;
    }
    Iterator<IrreconcilableChangeDiffBuilder> each = irreconcilableChanges.iterator();
    List visitables = _visitables.get("irreconcilableChanges");
    while (each.hasNext()) {
        IrreconcilableChangeDiffBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPinnedImageSets(Predicate<MachineConfigNodeStatusPinnedImageSetBuilder> predicate) {
    if (pinnedImageSets == null) {
      return (A) this;
    }
    Iterator<MachineConfigNodeStatusPinnedImageSetBuilder> each = pinnedImageSets.iterator();
    List visitables = _visitables.get("pinnedImageSets");
    while (each.hasNext()) {
        MachineConfigNodeStatusPinnedImageSetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public IrreconcilableChangesNested<A> setNewIrreconcilableChangeLike(int index,IrreconcilableChangeDiff item) {
    return new IrreconcilableChangesNested(index, item);
  }
  
  public PinnedImageSetsNested<A> setNewPinnedImageSetLike(int index,MachineConfigNodeStatusPinnedImageSet item) {
    return new PinnedImageSetsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToIrreconcilableChanges(int index,IrreconcilableChangeDiff item) {
    if (this.irreconcilableChanges == null) {
      this.irreconcilableChanges = new ArrayList();
    }
    IrreconcilableChangeDiffBuilder builder = new IrreconcilableChangeDiffBuilder(item);
    if (index < 0 || index >= irreconcilableChanges.size()) {
        _visitables.get("irreconcilableChanges").add(builder);
        irreconcilableChanges.add(builder);
    } else {
        _visitables.get("irreconcilableChanges").add(builder);
        irreconcilableChanges.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPinnedImageSets(int index,MachineConfigNodeStatusPinnedImageSet item) {
    if (this.pinnedImageSets == null) {
      this.pinnedImageSets = new ArrayList();
    }
    MachineConfigNodeStatusPinnedImageSetBuilder builder = new MachineConfigNodeStatusPinnedImageSetBuilder(item);
    if (index < 0 || index >= pinnedImageSets.size()) {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.add(builder);
    } else {
        _visitables.get("pinnedImageSets").add(builder);
        pinnedImageSets.set(index, builder);
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
    if (!(configVersion == null)) {
        sb.append("configVersion:");
        sb.append(configVersion);
        sb.append(",");
    }
    if (!(irreconcilableChanges == null) && !(irreconcilableChanges.isEmpty())) {
        sb.append("irreconcilableChanges:");
        sb.append(irreconcilableChanges);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(pinnedImageSets == null) && !(pinnedImageSets.isEmpty())) {
        sb.append("pinnedImageSets:");
        sb.append(pinnedImageSets);
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
  
  public A withConfigVersion(MachineConfigNodeStatusMachineConfigVersion configVersion) {
    this._visitables.remove("configVersion");
    if (configVersion != null) {
        this.configVersion = new MachineConfigNodeStatusMachineConfigVersionBuilder(configVersion);
        this._visitables.get("configVersion").add(this.configVersion);
    } else {
        this.configVersion = null;
        this._visitables.get("configVersion").remove(this.configVersion);
    }
    return (A) this;
  }
  
  public A withIrreconcilableChanges(List<IrreconcilableChangeDiff> irreconcilableChanges) {
    if (this.irreconcilableChanges != null) {
      this._visitables.get("irreconcilableChanges").clear();
    }
    if (irreconcilableChanges != null) {
        this.irreconcilableChanges = new ArrayList();
        for (IrreconcilableChangeDiff item : irreconcilableChanges) {
          this.addToIrreconcilableChanges(item);
        }
    } else {
      this.irreconcilableChanges = null;
    }
    return (A) this;
  }
  
  public A withIrreconcilableChanges(IrreconcilableChangeDiff... irreconcilableChanges) {
    if (this.irreconcilableChanges != null) {
        this.irreconcilableChanges.clear();
        _visitables.remove("irreconcilableChanges");
    }
    if (irreconcilableChanges != null) {
      for (IrreconcilableChangeDiff item : irreconcilableChanges) {
        this.addToIrreconcilableChanges(item);
      }
    }
    return (A) this;
  }
  
  public ConfigVersionNested<A> withNewConfigVersion() {
    return new ConfigVersionNested(null);
  }
  
  public A withNewConfigVersion(String current,String desired) {
    return (A) this.withConfigVersion(new MachineConfigNodeStatusMachineConfigVersion(current, desired));
  }
  
  public ConfigVersionNested<A> withNewConfigVersionLike(MachineConfigNodeStatusMachineConfigVersion item) {
    return new ConfigVersionNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPinnedImageSets(List<MachineConfigNodeStatusPinnedImageSet> pinnedImageSets) {
    if (this.pinnedImageSets != null) {
      this._visitables.get("pinnedImageSets").clear();
    }
    if (pinnedImageSets != null) {
        this.pinnedImageSets = new ArrayList();
        for (MachineConfigNodeStatusPinnedImageSet item : pinnedImageSets) {
          this.addToPinnedImageSets(item);
        }
    } else {
      this.pinnedImageSets = null;
    }
    return (A) this;
  }
  
  public A withPinnedImageSets(MachineConfigNodeStatusPinnedImageSet... pinnedImageSets) {
    if (this.pinnedImageSets != null) {
        this.pinnedImageSets.clear();
        _visitables.remove("pinnedImageSets");
    }
    if (pinnedImageSets != null) {
      for (MachineConfigNodeStatusPinnedImageSet item : pinnedImageSets) {
        this.addToPinnedImageSets(item);
      }
    }
    return (A) this;
  }
  public class ConfigVersionNested<N> extends MachineConfigNodeStatusMachineConfigVersionFluent<ConfigVersionNested<N>> implements Nested<N>{
  
    MachineConfigNodeStatusMachineConfigVersionBuilder builder;
  
    ConfigVersionNested(MachineConfigNodeStatusMachineConfigVersion item) {
      this.builder = new MachineConfigNodeStatusMachineConfigVersionBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigNodeStatusFluent.this.withConfigVersion(builder.build());
    }
    
    public N endConfigVersion() {
      return and();
    }
    
  }
  public class IrreconcilableChangesNested<N> extends IrreconcilableChangeDiffFluent<IrreconcilableChangesNested<N>> implements Nested<N>{
  
    IrreconcilableChangeDiffBuilder builder;
    int index;
  
    IrreconcilableChangesNested(int index,IrreconcilableChangeDiff item) {
      this.index = index;
      this.builder = new IrreconcilableChangeDiffBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigNodeStatusFluent.this.setToIrreconcilableChanges(index, builder.build());
    }
    
    public N endIrreconcilableChange() {
      return and();
    }
    
  }
  public class PinnedImageSetsNested<N> extends MachineConfigNodeStatusPinnedImageSetFluent<PinnedImageSetsNested<N>> implements Nested<N>{
  
    MachineConfigNodeStatusPinnedImageSetBuilder builder;
    int index;
  
    PinnedImageSetsNested(int index,MachineConfigNodeStatusPinnedImageSet item) {
      this.index = index;
      this.builder = new MachineConfigNodeStatusPinnedImageSetBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigNodeStatusFluent.this.setToPinnedImageSets(index, builder.build());
    }
    
    public N endPinnedImageSet() {
      return and();
    }
    
  }
}