package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class InstallPlanStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallPlanStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder attenuatedServiceAccountRef;
  private ArrayList<BundleLookupBuilder> bundleLookups = new ArrayList<BundleLookupBuilder>();
  private List<String> catalogSources = new ArrayList<String>();
  private ArrayList<InstallPlanConditionBuilder> conditions = new ArrayList<InstallPlanConditionBuilder>();
  private String message;
  private String phase;
  private ArrayList<StepBuilder> plan = new ArrayList<StepBuilder>();
  private String startTime;

  public InstallPlanStatusFluent() {
  }
  
  public InstallPlanStatusFluent(InstallPlanStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToBundleLookups(Collection<BundleLookup> items) {
    if (this.bundleLookups == null) {
      this.bundleLookups = new ArrayList();
    }
    for (BundleLookup item : items) {
        BundleLookupBuilder builder = new BundleLookupBuilder(item);
        _visitables.get("bundleLookups").add(builder);
        this.bundleLookups.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToCatalogSources(Collection<String> items) {
    if (this.catalogSources == null) {
      this.catalogSources = new ArrayList();
    }
    for (String item : items) {
      this.catalogSources.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<InstallPlanCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (InstallPlanCondition item : items) {
        InstallPlanConditionBuilder builder = new InstallPlanConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPlan(Collection<Step> items) {
    if (this.plan == null) {
      this.plan = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("plan").add(builder);
        this.plan.add(builder);
    }
    return (A) this;
  }
  
  public BundleLookupsNested<A> addNewBundleLookup() {
    return new BundleLookupsNested(-1, null);
  }
  
  public BundleLookupsNested<A> addNewBundleLookupLike(BundleLookup item) {
    return new BundleLookupsNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(InstallPlanCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public PlanNested<A> addNewPlan() {
    return new PlanNested(-1, null);
  }
  
  public PlanNested<A> addNewPlanLike(Step item) {
    return new PlanNested(-1, item);
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
  
  public A addToBundleLookups(BundleLookup... items) {
    if (this.bundleLookups == null) {
      this.bundleLookups = new ArrayList();
    }
    for (BundleLookup item : items) {
        BundleLookupBuilder builder = new BundleLookupBuilder(item);
        _visitables.get("bundleLookups").add(builder);
        this.bundleLookups.add(builder);
    }
    return (A) this;
  }
  
  public A addToBundleLookups(int index,BundleLookup item) {
    if (this.bundleLookups == null) {
      this.bundleLookups = new ArrayList();
    }
    BundleLookupBuilder builder = new BundleLookupBuilder(item);
    if (index < 0 || index >= bundleLookups.size()) {
        _visitables.get("bundleLookups").add(builder);
        bundleLookups.add(builder);
    } else {
        _visitables.get("bundleLookups").add(builder);
        bundleLookups.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToCatalogSources(String... items) {
    if (this.catalogSources == null) {
      this.catalogSources = new ArrayList();
    }
    for (String item : items) {
      this.catalogSources.add(item);
    }
    return (A) this;
  }
  
  public A addToCatalogSources(int index,String item) {
    if (this.catalogSources == null) {
      this.catalogSources = new ArrayList();
    }
    this.catalogSources.add(index, item);
    return (A) this;
  }
  
  public A addToConditions(InstallPlanCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (InstallPlanCondition item : items) {
        InstallPlanConditionBuilder builder = new InstallPlanConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,InstallPlanCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    InstallPlanConditionBuilder builder = new InstallPlanConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPlan(Step... items) {
    if (this.plan == null) {
      this.plan = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("plan").add(builder);
        this.plan.add(builder);
    }
    return (A) this;
  }
  
  public A addToPlan(int index,Step item) {
    if (this.plan == null) {
      this.plan = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= plan.size()) {
        _visitables.get("plan").add(builder);
        plan.add(builder);
    } else {
        _visitables.get("plan").add(builder);
        plan.add(index, builder);
    }
    return (A) this;
  }
  
  public ObjectReference buildAttenuatedServiceAccountRef() {
    return this.attenuatedServiceAccountRef != null ? this.attenuatedServiceAccountRef.build() : null;
  }
  
  public BundleLookup buildBundleLookup(int index) {
    return this.bundleLookups.get(index).build();
  }
  
  public List<BundleLookup> buildBundleLookups() {
    return this.bundleLookups != null ? build(bundleLookups) : null;
  }
  
  public InstallPlanCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<InstallPlanCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public BundleLookup buildFirstBundleLookup() {
    return this.bundleLookups.get(0).build();
  }
  
  public InstallPlanCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public Step buildFirstPlan() {
    return this.plan.get(0).build();
  }
  
  public BundleLookup buildLastBundleLookup() {
    return this.bundleLookups.get(bundleLookups.size() - 1).build();
  }
  
  public InstallPlanCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public Step buildLastPlan() {
    return this.plan.get(plan.size() - 1).build();
  }
  
  public BundleLookup buildMatchingBundleLookup(Predicate<BundleLookupBuilder> predicate) {
      for (BundleLookupBuilder item : bundleLookups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public InstallPlanCondition buildMatchingCondition(Predicate<InstallPlanConditionBuilder> predicate) {
      for (InstallPlanConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Step buildMatchingPlan(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : plan) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<Step> buildPlan() {
    return this.plan != null ? build(plan) : null;
  }
  
  public Step buildPlan(int index) {
    return this.plan.get(index).build();
  }
  
  protected void copyInstance(InstallPlanStatus instance) {
    instance = instance != null ? instance : new InstallPlanStatus();
    if (instance != null) {
        this.withAttenuatedServiceAccountRef(instance.getAttenuatedServiceAccountRef());
        this.withBundleLookups(instance.getBundleLookups());
        this.withCatalogSources(instance.getCatalogSources());
        this.withConditions(instance.getConditions());
        this.withMessage(instance.getMessage());
        this.withPhase(instance.getPhase());
        this.withPlan(instance.getPlan());
        this.withStartTime(instance.getStartTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttenuatedServiceAccountRefNested<A> editAttenuatedServiceAccountRef() {
    return this.withNewAttenuatedServiceAccountRefLike(Optional.ofNullable(this.buildAttenuatedServiceAccountRef()).orElse(null));
  }
  
  public BundleLookupsNested<A> editBundleLookup(int index) {
    if (bundleLookups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "bundleLookups"));
    }
    return this.setNewBundleLookupLike(index, this.buildBundleLookup(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public BundleLookupsNested<A> editFirstBundleLookup() {
    if (bundleLookups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "bundleLookups"));
    }
    return this.setNewBundleLookupLike(0, this.buildBundleLookup(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public PlanNested<A> editFirstPlan() {
    if (plan.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "plan"));
    }
    return this.setNewPlanLike(0, this.buildPlan(0));
  }
  
  public BundleLookupsNested<A> editLastBundleLookup() {
    int index = bundleLookups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "bundleLookups"));
    }
    return this.setNewBundleLookupLike(index, this.buildBundleLookup(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public PlanNested<A> editLastPlan() {
    int index = plan.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "plan"));
    }
    return this.setNewPlanLike(index, this.buildPlan(index));
  }
  
  public BundleLookupsNested<A> editMatchingBundleLookup(Predicate<BundleLookupBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < bundleLookups.size();i++) {
      if (predicate.test(bundleLookups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "bundleLookups"));
    }
    return this.setNewBundleLookupLike(index, this.buildBundleLookup(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<InstallPlanConditionBuilder> predicate) {
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
  
  public PlanNested<A> editMatchingPlan(Predicate<StepBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < plan.size();i++) {
      if (predicate.test(plan.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "plan"));
    }
    return this.setNewPlanLike(index, this.buildPlan(index));
  }
  
  public AttenuatedServiceAccountRefNested<A> editOrNewAttenuatedServiceAccountRef() {
    return this.withNewAttenuatedServiceAccountRefLike(Optional.ofNullable(this.buildAttenuatedServiceAccountRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public AttenuatedServiceAccountRefNested<A> editOrNewAttenuatedServiceAccountRefLike(ObjectReference item) {
    return this.withNewAttenuatedServiceAccountRefLike(Optional.ofNullable(this.buildAttenuatedServiceAccountRef()).orElse(item));
  }
  
  public PlanNested<A> editPlan(int index) {
    if (plan.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "plan"));
    }
    return this.setNewPlanLike(index, this.buildPlan(index));
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
    InstallPlanStatusFluent that = (InstallPlanStatusFluent) o;
    if (!(Objects.equals(attenuatedServiceAccountRef, that.attenuatedServiceAccountRef))) {
      return false;
    }
    if (!(Objects.equals(bundleLookups, that.bundleLookups))) {
      return false;
    }
    if (!(Objects.equals(catalogSources, that.catalogSources))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(plan, that.plan))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
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
  
  public String getCatalogSource(int index) {
    return this.catalogSources.get(index);
  }
  
  public List<String> getCatalogSources() {
    return this.catalogSources;
  }
  
  public String getFirstCatalogSource() {
    return this.catalogSources.get(0);
  }
  
  public String getLastCatalogSource() {
    return this.catalogSources.get(catalogSources.size() - 1);
  }
  
  public String getMatchingCatalogSource(Predicate<String> predicate) {
      for (String item : catalogSources) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttenuatedServiceAccountRef() {
    return this.attenuatedServiceAccountRef != null;
  }
  
  public boolean hasBundleLookups() {
    return this.bundleLookups != null && !(this.bundleLookups.isEmpty());
  }
  
  public boolean hasCatalogSources() {
    return this.catalogSources != null && !(this.catalogSources.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingBundleLookup(Predicate<BundleLookupBuilder> predicate) {
      for (BundleLookupBuilder item : bundleLookups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCatalogSource(Predicate<String> predicate) {
      for (String item : catalogSources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<InstallPlanConditionBuilder> predicate) {
      for (InstallPlanConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPlan(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : plan) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasPlan() {
    return this.plan != null && !(this.plan.isEmpty());
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(attenuatedServiceAccountRef, bundleLookups, catalogSources, conditions, message, phase, plan, startTime, additionalProperties);
  }
  
  public A removeAllFromBundleLookups(Collection<BundleLookup> items) {
    if (this.bundleLookups == null) {
      return (A) this;
    }
    for (BundleLookup item : items) {
        BundleLookupBuilder builder = new BundleLookupBuilder(item);
        _visitables.get("bundleLookups").remove(builder);
        this.bundleLookups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromCatalogSources(Collection<String> items) {
    if (this.catalogSources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.catalogSources.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<InstallPlanCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (InstallPlanCondition item : items) {
        InstallPlanConditionBuilder builder = new InstallPlanConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPlan(Collection<Step> items) {
    if (this.plan == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("plan").remove(builder);
        this.plan.remove(builder);
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
  
  public A removeFromBundleLookups(BundleLookup... items) {
    if (this.bundleLookups == null) {
      return (A) this;
    }
    for (BundleLookup item : items) {
        BundleLookupBuilder builder = new BundleLookupBuilder(item);
        _visitables.get("bundleLookups").remove(builder);
        this.bundleLookups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromCatalogSources(String... items) {
    if (this.catalogSources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.catalogSources.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConditions(InstallPlanCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (InstallPlanCondition item : items) {
        InstallPlanConditionBuilder builder = new InstallPlanConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPlan(Step... items) {
    if (this.plan == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("plan").remove(builder);
        this.plan.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBundleLookups(Predicate<BundleLookupBuilder> predicate) {
    if (bundleLookups == null) {
      return (A) this;
    }
    Iterator<BundleLookupBuilder> each = bundleLookups.iterator();
    List visitables = _visitables.get("bundleLookups");
    while (each.hasNext()) {
        BundleLookupBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<InstallPlanConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<InstallPlanConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        InstallPlanConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPlan(Predicate<StepBuilder> predicate) {
    if (plan == null) {
      return (A) this;
    }
    Iterator<StepBuilder> each = plan.iterator();
    List visitables = _visitables.get("plan");
    while (each.hasNext()) {
        StepBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BundleLookupsNested<A> setNewBundleLookupLike(int index,BundleLookup item) {
    return new BundleLookupsNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,InstallPlanCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public PlanNested<A> setNewPlanLike(int index,Step item) {
    return new PlanNested(index, item);
  }
  
  public A setToBundleLookups(int index,BundleLookup item) {
    if (this.bundleLookups == null) {
      this.bundleLookups = new ArrayList();
    }
    BundleLookupBuilder builder = new BundleLookupBuilder(item);
    if (index < 0 || index >= bundleLookups.size()) {
        _visitables.get("bundleLookups").add(builder);
        bundleLookups.add(builder);
    } else {
        _visitables.get("bundleLookups").add(builder);
        bundleLookups.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToCatalogSources(int index,String item) {
    if (this.catalogSources == null) {
      this.catalogSources = new ArrayList();
    }
    this.catalogSources.set(index, item);
    return (A) this;
  }
  
  public A setToConditions(int index,InstallPlanCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    InstallPlanConditionBuilder builder = new InstallPlanConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPlan(int index,Step item) {
    if (this.plan == null) {
      this.plan = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= plan.size()) {
        _visitables.get("plan").add(builder);
        plan.add(builder);
    } else {
        _visitables.get("plan").add(builder);
        plan.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attenuatedServiceAccountRef == null)) {
        sb.append("attenuatedServiceAccountRef:");
        sb.append(attenuatedServiceAccountRef);
        sb.append(",");
    }
    if (!(bundleLookups == null) && !(bundleLookups.isEmpty())) {
        sb.append("bundleLookups:");
        sb.append(bundleLookups);
        sb.append(",");
    }
    if (!(catalogSources == null) && !(catalogSources.isEmpty())) {
        sb.append("catalogSources:");
        sb.append(catalogSources);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(plan == null) && !(plan.isEmpty())) {
        sb.append("plan:");
        sb.append(plan);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
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
  
  public A withAttenuatedServiceAccountRef(ObjectReference attenuatedServiceAccountRef) {
    this._visitables.remove("attenuatedServiceAccountRef");
    if (attenuatedServiceAccountRef != null) {
        this.attenuatedServiceAccountRef = new ObjectReferenceBuilder(attenuatedServiceAccountRef);
        this._visitables.get("attenuatedServiceAccountRef").add(this.attenuatedServiceAccountRef);
    } else {
        this.attenuatedServiceAccountRef = null;
        this._visitables.get("attenuatedServiceAccountRef").remove(this.attenuatedServiceAccountRef);
    }
    return (A) this;
  }
  
  public A withBundleLookups(List<BundleLookup> bundleLookups) {
    if (this.bundleLookups != null) {
      this._visitables.get("bundleLookups").clear();
    }
    if (bundleLookups != null) {
        this.bundleLookups = new ArrayList();
        for (BundleLookup item : bundleLookups) {
          this.addToBundleLookups(item);
        }
    } else {
      this.bundleLookups = null;
    }
    return (A) this;
  }
  
  public A withBundleLookups(BundleLookup... bundleLookups) {
    if (this.bundleLookups != null) {
        this.bundleLookups.clear();
        _visitables.remove("bundleLookups");
    }
    if (bundleLookups != null) {
      for (BundleLookup item : bundleLookups) {
        this.addToBundleLookups(item);
      }
    }
    return (A) this;
  }
  
  public A withCatalogSources(List<String> catalogSources) {
    if (catalogSources != null) {
        this.catalogSources = new ArrayList();
        for (String item : catalogSources) {
          this.addToCatalogSources(item);
        }
    } else {
      this.catalogSources = null;
    }
    return (A) this;
  }
  
  public A withCatalogSources(String... catalogSources) {
    if (this.catalogSources != null) {
        this.catalogSources.clear();
        _visitables.remove("catalogSources");
    }
    if (catalogSources != null) {
      for (String item : catalogSources) {
        this.addToCatalogSources(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<InstallPlanCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (InstallPlanCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(InstallPlanCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (InstallPlanCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public AttenuatedServiceAccountRefNested<A> withNewAttenuatedServiceAccountRef() {
    return new AttenuatedServiceAccountRefNested(null);
  }
  
  public AttenuatedServiceAccountRefNested<A> withNewAttenuatedServiceAccountRefLike(ObjectReference item) {
    return new AttenuatedServiceAccountRefNested(item);
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withPlan(List<Step> plan) {
    if (this.plan != null) {
      this._visitables.get("plan").clear();
    }
    if (plan != null) {
        this.plan = new ArrayList();
        for (Step item : plan) {
          this.addToPlan(item);
        }
    } else {
      this.plan = null;
    }
    return (A) this;
  }
  
  public A withPlan(Step... plan) {
    if (this.plan != null) {
        this.plan.clear();
        _visitables.remove("plan");
    }
    if (plan != null) {
      for (Step item : plan) {
        this.addToPlan(item);
      }
    }
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class AttenuatedServiceAccountRefNested<N> extends ObjectReferenceFluent<AttenuatedServiceAccountRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    AttenuatedServiceAccountRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallPlanStatusFluent.this.withAttenuatedServiceAccountRef(builder.build());
    }
    
    public N endAttenuatedServiceAccountRef() {
      return and();
    }
    
  }
  public class BundleLookupsNested<N> extends BundleLookupFluent<BundleLookupsNested<N>> implements Nested<N>{
  
    BundleLookupBuilder builder;
    int index;
  
    BundleLookupsNested(int index,BundleLookup item) {
      this.index = index;
      this.builder = new BundleLookupBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallPlanStatusFluent.this.setToBundleLookups(index, builder.build());
    }
    
    public N endBundleLookup() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends InstallPlanConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    InstallPlanConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,InstallPlanCondition item) {
      this.index = index;
      this.builder = new InstallPlanConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallPlanStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class PlanNested<N> extends StepFluent<PlanNested<N>> implements Nested<N>{
  
    StepBuilder builder;
    int index;
  
    PlanNested(int index,Step item) {
      this.index = index;
      this.builder = new StepBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallPlanStatusFluent.this.setToPlan(index, builder.build());
    }
    
    public N endPlan() {
      return and();
    }
    
  }
}