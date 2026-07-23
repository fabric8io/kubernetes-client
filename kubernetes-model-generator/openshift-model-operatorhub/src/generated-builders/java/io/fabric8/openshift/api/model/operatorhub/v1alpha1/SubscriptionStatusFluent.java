package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Integer;
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
public class SubscriptionStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.SubscriptionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SubscriptionCatalogHealthBuilder> catalogHealth = new ArrayList<SubscriptionCatalogHealthBuilder>();
  private ArrayList<SubscriptionConditionBuilder> conditions = new ArrayList<SubscriptionConditionBuilder>();
  private String currentCSV;
  private Integer installPlanGeneration;
  private ObjectReferenceBuilder installPlanRef;
  private String installedCSV;
  private InstallPlanReferenceBuilder installplan;
  private String lastUpdated;
  private String reason;
  private String state;

  public SubscriptionStatusFluent() {
  }
  
  public SubscriptionStatusFluent(SubscriptionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToCatalogHealth(Collection<SubscriptionCatalogHealth> items) {
    if (this.catalogHealth == null) {
      this.catalogHealth = new ArrayList();
    }
    for (SubscriptionCatalogHealth item : items) {
        SubscriptionCatalogHealthBuilder builder = new SubscriptionCatalogHealthBuilder(item);
        _visitables.get("catalogHealth").add(builder);
        this.catalogHealth.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<SubscriptionCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (SubscriptionCondition item : items) {
        SubscriptionConditionBuilder builder = new SubscriptionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public CatalogHealthNested<A> addNewCatalogHealth() {
    return new CatalogHealthNested(-1, null);
  }
  
  public CatalogHealthNested<A> addNewCatalogHealthLike(SubscriptionCatalogHealth item) {
    return new CatalogHealthNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(SubscriptionCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToCatalogHealth(SubscriptionCatalogHealth... items) {
    if (this.catalogHealth == null) {
      this.catalogHealth = new ArrayList();
    }
    for (SubscriptionCatalogHealth item : items) {
        SubscriptionCatalogHealthBuilder builder = new SubscriptionCatalogHealthBuilder(item);
        _visitables.get("catalogHealth").add(builder);
        this.catalogHealth.add(builder);
    }
    return (A) this;
  }
  
  public A addToCatalogHealth(int index,SubscriptionCatalogHealth item) {
    if (this.catalogHealth == null) {
      this.catalogHealth = new ArrayList();
    }
    SubscriptionCatalogHealthBuilder builder = new SubscriptionCatalogHealthBuilder(item);
    if (index < 0 || index >= catalogHealth.size()) {
        _visitables.get("catalogHealth").add(builder);
        catalogHealth.add(builder);
    } else {
        _visitables.get("catalogHealth").add(builder);
        catalogHealth.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(SubscriptionCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (SubscriptionCondition item : items) {
        SubscriptionConditionBuilder builder = new SubscriptionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,SubscriptionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    SubscriptionConditionBuilder builder = new SubscriptionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public List<SubscriptionCatalogHealth> buildCatalogHealth() {
    return this.catalogHealth != null ? build(catalogHealth) : null;
  }
  
  public SubscriptionCatalogHealth buildCatalogHealth(int index) {
    return this.catalogHealth.get(index).build();
  }
  
  public SubscriptionCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<SubscriptionCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public SubscriptionCatalogHealth buildFirstCatalogHealth() {
    return this.catalogHealth.get(0).build();
  }
  
  public SubscriptionCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ObjectReference buildInstallPlanRef() {
    return this.installPlanRef != null ? this.installPlanRef.build() : null;
  }
  
  public InstallPlanReference buildInstallplan() {
    return this.installplan != null ? this.installplan.build() : null;
  }
  
  public SubscriptionCatalogHealth buildLastCatalogHealth() {
    return this.catalogHealth.get(catalogHealth.size() - 1).build();
  }
  
  public SubscriptionCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public SubscriptionCatalogHealth buildMatchingCatalogHealth(Predicate<SubscriptionCatalogHealthBuilder> predicate) {
      for (SubscriptionCatalogHealthBuilder item : catalogHealth) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubscriptionCondition buildMatchingCondition(Predicate<SubscriptionConditionBuilder> predicate) {
      for (SubscriptionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(SubscriptionStatus instance) {
    instance = instance != null ? instance : new SubscriptionStatus();
    if (instance != null) {
        this.withCatalogHealth(instance.getCatalogHealth());
        this.withConditions(instance.getConditions());
        this.withCurrentCSV(instance.getCurrentCSV());
        this.withInstallPlanGeneration(instance.getInstallPlanGeneration());
        this.withInstallPlanRef(instance.getInstallPlanRef());
        this.withInstalledCSV(instance.getInstalledCSV());
        this.withInstallplan(instance.getInstallplan());
        this.withLastUpdated(instance.getLastUpdated());
        this.withReason(instance.getReason());
        this.withState(instance.getState());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CatalogHealthNested<A> editCatalogHealth(int index) {
    if (catalogHealth.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "catalogHealth"));
    }
    return this.setNewCatalogHealthLike(index, this.buildCatalogHealth(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CatalogHealthNested<A> editFirstCatalogHealth() {
    if (catalogHealth.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "catalogHealth"));
    }
    return this.setNewCatalogHealthLike(0, this.buildCatalogHealth(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public InstallPlanRefNested<A> editInstallPlanRef() {
    return this.withNewInstallPlanRefLike(Optional.ofNullable(this.buildInstallPlanRef()).orElse(null));
  }
  
  public InstallplanNested<A> editInstallplan() {
    return this.withNewInstallplanLike(Optional.ofNullable(this.buildInstallplan()).orElse(null));
  }
  
  public CatalogHealthNested<A> editLastCatalogHealth() {
    int index = catalogHealth.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "catalogHealth"));
    }
    return this.setNewCatalogHealthLike(index, this.buildCatalogHealth(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CatalogHealthNested<A> editMatchingCatalogHealth(Predicate<SubscriptionCatalogHealthBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < catalogHealth.size();i++) {
      if (predicate.test(catalogHealth.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "catalogHealth"));
    }
    return this.setNewCatalogHealthLike(index, this.buildCatalogHealth(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<SubscriptionConditionBuilder> predicate) {
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
  
  public InstallPlanRefNested<A> editOrNewInstallPlanRef() {
    return this.withNewInstallPlanRefLike(Optional.ofNullable(this.buildInstallPlanRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public InstallPlanRefNested<A> editOrNewInstallPlanRefLike(ObjectReference item) {
    return this.withNewInstallPlanRefLike(Optional.ofNullable(this.buildInstallPlanRef()).orElse(item));
  }
  
  public InstallplanNested<A> editOrNewInstallplan() {
    return this.withNewInstallplanLike(Optional.ofNullable(this.buildInstallplan()).orElse(new InstallPlanReferenceBuilder().build()));
  }
  
  public InstallplanNested<A> editOrNewInstallplanLike(InstallPlanReference item) {
    return this.withNewInstallplanLike(Optional.ofNullable(this.buildInstallplan()).orElse(item));
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
    SubscriptionStatusFluent that = (SubscriptionStatusFluent) o;
    if (!(Objects.equals(catalogHealth, that.catalogHealth))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentCSV, that.currentCSV))) {
      return false;
    }
    if (!(Objects.equals(installPlanGeneration, that.installPlanGeneration))) {
      return false;
    }
    if (!(Objects.equals(installPlanRef, that.installPlanRef))) {
      return false;
    }
    if (!(Objects.equals(installedCSV, that.installedCSV))) {
      return false;
    }
    if (!(Objects.equals(installplan, that.installplan))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
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
  
  public String getCurrentCSV() {
    return this.currentCSV;
  }
  
  public Integer getInstallPlanGeneration() {
    return this.installPlanGeneration;
  }
  
  public String getInstalledCSV() {
    return this.installedCSV;
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getState() {
    return this.state;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCatalogHealth() {
    return this.catalogHealth != null && !(this.catalogHealth.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCurrentCSV() {
    return this.currentCSV != null;
  }
  
  public boolean hasInstallPlanGeneration() {
    return this.installPlanGeneration != null;
  }
  
  public boolean hasInstallPlanRef() {
    return this.installPlanRef != null;
  }
  
  public boolean hasInstalledCSV() {
    return this.installedCSV != null;
  }
  
  public boolean hasInstallplan() {
    return this.installplan != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingCatalogHealth(Predicate<SubscriptionCatalogHealthBuilder> predicate) {
      for (SubscriptionCatalogHealthBuilder item : catalogHealth) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<SubscriptionConditionBuilder> predicate) {
      for (SubscriptionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public int hashCode() {
    return Objects.hash(catalogHealth, conditions, currentCSV, installPlanGeneration, installPlanRef, installedCSV, installplan, lastUpdated, reason, state, additionalProperties);
  }
  
  public A removeAllFromCatalogHealth(Collection<SubscriptionCatalogHealth> items) {
    if (this.catalogHealth == null) {
      return (A) this;
    }
    for (SubscriptionCatalogHealth item : items) {
        SubscriptionCatalogHealthBuilder builder = new SubscriptionCatalogHealthBuilder(item);
        _visitables.get("catalogHealth").remove(builder);
        this.catalogHealth.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<SubscriptionCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (SubscriptionCondition item : items) {
        SubscriptionConditionBuilder builder = new SubscriptionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromCatalogHealth(SubscriptionCatalogHealth... items) {
    if (this.catalogHealth == null) {
      return (A) this;
    }
    for (SubscriptionCatalogHealth item : items) {
        SubscriptionCatalogHealthBuilder builder = new SubscriptionCatalogHealthBuilder(item);
        _visitables.get("catalogHealth").remove(builder);
        this.catalogHealth.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(SubscriptionCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (SubscriptionCondition item : items) {
        SubscriptionConditionBuilder builder = new SubscriptionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCatalogHealth(Predicate<SubscriptionCatalogHealthBuilder> predicate) {
    if (catalogHealth == null) {
      return (A) this;
    }
    Iterator<SubscriptionCatalogHealthBuilder> each = catalogHealth.iterator();
    List visitables = _visitables.get("catalogHealth");
    while (each.hasNext()) {
        SubscriptionCatalogHealthBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<SubscriptionConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<SubscriptionConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        SubscriptionConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CatalogHealthNested<A> setNewCatalogHealthLike(int index,SubscriptionCatalogHealth item) {
    return new CatalogHealthNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,SubscriptionCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToCatalogHealth(int index,SubscriptionCatalogHealth item) {
    if (this.catalogHealth == null) {
      this.catalogHealth = new ArrayList();
    }
    SubscriptionCatalogHealthBuilder builder = new SubscriptionCatalogHealthBuilder(item);
    if (index < 0 || index >= catalogHealth.size()) {
        _visitables.get("catalogHealth").add(builder);
        catalogHealth.add(builder);
    } else {
        _visitables.get("catalogHealth").add(builder);
        catalogHealth.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,SubscriptionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    SubscriptionConditionBuilder builder = new SubscriptionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(catalogHealth == null) && !(catalogHealth.isEmpty())) {
        sb.append("catalogHealth:");
        sb.append(catalogHealth);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(currentCSV == null)) {
        sb.append("currentCSV:");
        sb.append(currentCSV);
        sb.append(",");
    }
    if (!(installPlanGeneration == null)) {
        sb.append("installPlanGeneration:");
        sb.append(installPlanGeneration);
        sb.append(",");
    }
    if (!(installPlanRef == null)) {
        sb.append("installPlanRef:");
        sb.append(installPlanRef);
        sb.append(",");
    }
    if (!(installedCSV == null)) {
        sb.append("installedCSV:");
        sb.append(installedCSV);
        sb.append(",");
    }
    if (!(installplan == null)) {
        sb.append("installplan:");
        sb.append(installplan);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
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
  
  public A withCatalogHealth(List<SubscriptionCatalogHealth> catalogHealth) {
    if (this.catalogHealth != null) {
      this._visitables.get("catalogHealth").clear();
    }
    if (catalogHealth != null) {
        this.catalogHealth = new ArrayList();
        for (SubscriptionCatalogHealth item : catalogHealth) {
          this.addToCatalogHealth(item);
        }
    } else {
      this.catalogHealth = null;
    }
    return (A) this;
  }
  
  public A withCatalogHealth(SubscriptionCatalogHealth... catalogHealth) {
    if (this.catalogHealth != null) {
        this.catalogHealth.clear();
        _visitables.remove("catalogHealth");
    }
    if (catalogHealth != null) {
      for (SubscriptionCatalogHealth item : catalogHealth) {
        this.addToCatalogHealth(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<SubscriptionCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (SubscriptionCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(SubscriptionCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (SubscriptionCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentCSV(String currentCSV) {
    this.currentCSV = currentCSV;
    return (A) this;
  }
  
  public A withInstallPlanGeneration(Integer installPlanGeneration) {
    this.installPlanGeneration = installPlanGeneration;
    return (A) this;
  }
  
  public A withInstallPlanRef(ObjectReference installPlanRef) {
    this._visitables.remove("installPlanRef");
    if (installPlanRef != null) {
        this.installPlanRef = new ObjectReferenceBuilder(installPlanRef);
        this._visitables.get("installPlanRef").add(this.installPlanRef);
    } else {
        this.installPlanRef = null;
        this._visitables.get("installPlanRef").remove(this.installPlanRef);
    }
    return (A) this;
  }
  
  public A withInstalledCSV(String installedCSV) {
    this.installedCSV = installedCSV;
    return (A) this;
  }
  
  public A withInstallplan(InstallPlanReference installplan) {
    this._visitables.remove("installplan");
    if (installplan != null) {
        this.installplan = new InstallPlanReferenceBuilder(installplan);
        this._visitables.get("installplan").add(this.installplan);
    } else {
        this.installplan = null;
        this._visitables.get("installplan").remove(this.installplan);
    }
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public InstallPlanRefNested<A> withNewInstallPlanRef() {
    return new InstallPlanRefNested(null);
  }
  
  public InstallPlanRefNested<A> withNewInstallPlanRefLike(ObjectReference item) {
    return new InstallPlanRefNested(item);
  }
  
  public InstallplanNested<A> withNewInstallplan() {
    return new InstallplanNested(null);
  }
  
  public A withNewInstallplan(String apiVersion,String kind,String name,String uuid) {
    return (A) this.withInstallplan(new InstallPlanReference(apiVersion, kind, name, uuid));
  }
  
  public InstallplanNested<A> withNewInstallplanLike(InstallPlanReference item) {
    return new InstallplanNested(item);
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  public class CatalogHealthNested<N> extends SubscriptionCatalogHealthFluent<CatalogHealthNested<N>> implements Nested<N>{
  
    SubscriptionCatalogHealthBuilder builder;
    int index;
  
    CatalogHealthNested(int index,SubscriptionCatalogHealth item) {
      this.index = index;
      this.builder = new SubscriptionCatalogHealthBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionStatusFluent.this.setToCatalogHealth(index, builder.build());
    }
    
    public N endCatalogHealth() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends SubscriptionConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    SubscriptionConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,SubscriptionCondition item) {
      this.index = index;
      this.builder = new SubscriptionConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class InstallPlanRefNested<N> extends ObjectReferenceFluent<InstallPlanRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    InstallPlanRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionStatusFluent.this.withInstallPlanRef(builder.build());
    }
    
    public N endInstallPlanRef() {
      return and();
    }
    
  }
  public class InstallplanNested<N> extends InstallPlanReferenceFluent<InstallplanNested<N>> implements Nested<N>{
  
    InstallPlanReferenceBuilder builder;
  
    InstallplanNested(InstallPlanReference item) {
      this.builder = new InstallPlanReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionStatusFluent.this.withInstallplan(builder.build());
    }
    
    public N endInstallplan() {
      return and();
    }
    
  }
}