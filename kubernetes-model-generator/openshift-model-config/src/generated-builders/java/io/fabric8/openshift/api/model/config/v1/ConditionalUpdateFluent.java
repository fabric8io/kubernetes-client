package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class ConditionalUpdateFluent<A extends io.fabric8.openshift.api.model.config.v1.ConditionalUpdateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ReleaseBuilder release;
  private List<String> riskNames = new ArrayList<String>();
  private ArrayList<ConditionalUpdateRiskBuilder> risks = new ArrayList<ConditionalUpdateRiskBuilder>();

  public ConditionalUpdateFluent() {
  }
  
  public ConditionalUpdateFluent(ConditionalUpdate instance) {
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
  
  public A addAllToRiskNames(Collection<String> items) {
    if (this.riskNames == null) {
      this.riskNames = new ArrayList();
    }
    for (String item : items) {
      this.riskNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRisks(Collection<ConditionalUpdateRisk> items) {
    if (this.risks == null) {
      this.risks = new ArrayList();
    }
    for (ConditionalUpdateRisk item : items) {
        ConditionalUpdateRiskBuilder builder = new ConditionalUpdateRiskBuilder(item);
        _visitables.get("risks").add(builder);
        this.risks.add(builder);
    }
    return (A) this;
  }
  
  public RisksNested<A> addNewRisk() {
    return new RisksNested(-1, null);
  }
  
  public RisksNested<A> addNewRiskLike(ConditionalUpdateRisk item) {
    return new RisksNested(-1, item);
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
  
  public A addToRiskNames(String... items) {
    if (this.riskNames == null) {
      this.riskNames = new ArrayList();
    }
    for (String item : items) {
      this.riskNames.add(item);
    }
    return (A) this;
  }
  
  public A addToRiskNames(int index,String item) {
    if (this.riskNames == null) {
      this.riskNames = new ArrayList();
    }
    this.riskNames.add(index, item);
    return (A) this;
  }
  
  public A addToRisks(ConditionalUpdateRisk... items) {
    if (this.risks == null) {
      this.risks = new ArrayList();
    }
    for (ConditionalUpdateRisk item : items) {
        ConditionalUpdateRiskBuilder builder = new ConditionalUpdateRiskBuilder(item);
        _visitables.get("risks").add(builder);
        this.risks.add(builder);
    }
    return (A) this;
  }
  
  public A addToRisks(int index,ConditionalUpdateRisk item) {
    if (this.risks == null) {
      this.risks = new ArrayList();
    }
    ConditionalUpdateRiskBuilder builder = new ConditionalUpdateRiskBuilder(item);
    if (index < 0 || index >= risks.size()) {
        _visitables.get("risks").add(builder);
        risks.add(builder);
    } else {
        _visitables.get("risks").add(builder);
        risks.add(index, builder);
    }
    return (A) this;
  }
  
  public ConditionalUpdateRisk buildFirstRisk() {
    return this.risks.get(0).build();
  }
  
  public ConditionalUpdateRisk buildLastRisk() {
    return this.risks.get(risks.size() - 1).build();
  }
  
  public ConditionalUpdateRisk buildMatchingRisk(Predicate<ConditionalUpdateRiskBuilder> predicate) {
      for (ConditionalUpdateRiskBuilder item : risks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Release buildRelease() {
    return this.release != null ? this.release.build() : null;
  }
  
  public ConditionalUpdateRisk buildRisk(int index) {
    return this.risks.get(index).build();
  }
  
  public List<ConditionalUpdateRisk> buildRisks() {
    return this.risks != null ? build(risks) : null;
  }
  
  protected void copyInstance(ConditionalUpdate instance) {
    instance = instance != null ? instance : new ConditionalUpdate();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withRelease(instance.getRelease());
        this.withRiskNames(instance.getRiskNames());
        this.withRisks(instance.getRisks());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RisksNested<A> editFirstRisk() {
    if (risks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "risks"));
    }
    return this.setNewRiskLike(0, this.buildRisk(0));
  }
  
  public RisksNested<A> editLastRisk() {
    int index = risks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "risks"));
    }
    return this.setNewRiskLike(index, this.buildRisk(index));
  }
  
  public RisksNested<A> editMatchingRisk(Predicate<ConditionalUpdateRiskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < risks.size();i++) {
      if (predicate.test(risks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "risks"));
    }
    return this.setNewRiskLike(index, this.buildRisk(index));
  }
  
  public ReleaseNested<A> editOrNewRelease() {
    return this.withNewReleaseLike(Optional.ofNullable(this.buildRelease()).orElse(new ReleaseBuilder().build()));
  }
  
  public ReleaseNested<A> editOrNewReleaseLike(Release item) {
    return this.withNewReleaseLike(Optional.ofNullable(this.buildRelease()).orElse(item));
  }
  
  public ReleaseNested<A> editRelease() {
    return this.withNewReleaseLike(Optional.ofNullable(this.buildRelease()).orElse(null));
  }
  
  public RisksNested<A> editRisk(int index) {
    if (risks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "risks"));
    }
    return this.setNewRiskLike(index, this.buildRisk(index));
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
    ConditionalUpdateFluent that = (ConditionalUpdateFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(release, that.release))) {
      return false;
    }
    if (!(Objects.equals(riskNames, that.riskNames))) {
      return false;
    }
    if (!(Objects.equals(risks, that.risks))) {
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
  
  public String getFirstRiskName() {
    return this.riskNames.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastRiskName() {
    return this.riskNames.get(riskNames.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRiskName(Predicate<String> predicate) {
      for (String item : riskNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRiskName(int index) {
    return this.riskNames.get(index);
  }
  
  public List<String> getRiskNames() {
    return this.riskNames;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRisk(Predicate<ConditionalUpdateRiskBuilder> predicate) {
      for (ConditionalUpdateRiskBuilder item : risks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRiskName(Predicate<String> predicate) {
      for (String item : riskNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRelease() {
    return this.release != null;
  }
  
  public boolean hasRiskNames() {
    return this.riskNames != null && !(this.riskNames.isEmpty());
  }
  
  public boolean hasRisks() {
    return this.risks != null && !(this.risks.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, release, riskNames, risks, additionalProperties);
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
  
  public A removeAllFromRiskNames(Collection<String> items) {
    if (this.riskNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.riskNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRisks(Collection<ConditionalUpdateRisk> items) {
    if (this.risks == null) {
      return (A) this;
    }
    for (ConditionalUpdateRisk item : items) {
        ConditionalUpdateRiskBuilder builder = new ConditionalUpdateRiskBuilder(item);
        _visitables.get("risks").remove(builder);
        this.risks.remove(builder);
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
  
  public A removeFromRiskNames(String... items) {
    if (this.riskNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.riskNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRisks(ConditionalUpdateRisk... items) {
    if (this.risks == null) {
      return (A) this;
    }
    for (ConditionalUpdateRisk item : items) {
        ConditionalUpdateRiskBuilder builder = new ConditionalUpdateRiskBuilder(item);
        _visitables.get("risks").remove(builder);
        this.risks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRisks(Predicate<ConditionalUpdateRiskBuilder> predicate) {
    if (risks == null) {
      return (A) this;
    }
    Iterator<ConditionalUpdateRiskBuilder> each = risks.iterator();
    List visitables = _visitables.get("risks");
    while (each.hasNext()) {
        ConditionalUpdateRiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RisksNested<A> setNewRiskLike(int index,ConditionalUpdateRisk item) {
    return new RisksNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToRiskNames(int index,String item) {
    if (this.riskNames == null) {
      this.riskNames = new ArrayList();
    }
    this.riskNames.set(index, item);
    return (A) this;
  }
  
  public A setToRisks(int index,ConditionalUpdateRisk item) {
    if (this.risks == null) {
      this.risks = new ArrayList();
    }
    ConditionalUpdateRiskBuilder builder = new ConditionalUpdateRiskBuilder(item);
    if (index < 0 || index >= risks.size()) {
        _visitables.get("risks").add(builder);
        risks.add(builder);
    } else {
        _visitables.get("risks").add(builder);
        risks.set(index, builder);
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
    if (!(release == null)) {
        sb.append("release:");
        sb.append(release);
        sb.append(",");
    }
    if (!(riskNames == null) && !(riskNames.isEmpty())) {
        sb.append("riskNames:");
        sb.append(riskNames);
        sb.append(",");
    }
    if (!(risks == null) && !(risks.isEmpty())) {
        sb.append("risks:");
        sb.append(risks);
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
  
  public ReleaseNested<A> withNewRelease() {
    return new ReleaseNested(null);
  }
  
  public ReleaseNested<A> withNewReleaseLike(Release item) {
    return new ReleaseNested(item);
  }
  
  public A withRelease(Release release) {
    this._visitables.remove("release");
    if (release != null) {
        this.release = new ReleaseBuilder(release);
        this._visitables.get("release").add(this.release);
    } else {
        this.release = null;
        this._visitables.get("release").remove(this.release);
    }
    return (A) this;
  }
  
  public A withRiskNames(List<String> riskNames) {
    if (riskNames != null) {
        this.riskNames = new ArrayList();
        for (String item : riskNames) {
          this.addToRiskNames(item);
        }
    } else {
      this.riskNames = null;
    }
    return (A) this;
  }
  
  public A withRiskNames(String... riskNames) {
    if (this.riskNames != null) {
        this.riskNames.clear();
        _visitables.remove("riskNames");
    }
    if (riskNames != null) {
      for (String item : riskNames) {
        this.addToRiskNames(item);
      }
    }
    return (A) this;
  }
  
  public A withRisks(List<ConditionalUpdateRisk> risks) {
    if (this.risks != null) {
      this._visitables.get("risks").clear();
    }
    if (risks != null) {
        this.risks = new ArrayList();
        for (ConditionalUpdateRisk item : risks) {
          this.addToRisks(item);
        }
    } else {
      this.risks = null;
    }
    return (A) this;
  }
  
  public A withRisks(ConditionalUpdateRisk... risks) {
    if (this.risks != null) {
        this.risks.clear();
        _visitables.remove("risks");
    }
    if (risks != null) {
      for (ConditionalUpdateRisk item : risks) {
        this.addToRisks(item);
      }
    }
    return (A) this;
  }
  public class ReleaseNested<N> extends ReleaseFluent<ReleaseNested<N>> implements Nested<N>{
  
    ReleaseBuilder builder;
  
    ReleaseNested(Release item) {
      this.builder = new ReleaseBuilder(this, item);
    }
  
    public N and() {
      return (N) ConditionalUpdateFluent.this.withRelease(builder.build());
    }
    
    public N endRelease() {
      return and();
    }
    
  }
  public class RisksNested<N> extends ConditionalUpdateRiskFluent<RisksNested<N>> implements Nested<N>{
  
    ConditionalUpdateRiskBuilder builder;
    int index;
  
    RisksNested(int index,ConditionalUpdateRisk item) {
      this.index = index;
      this.builder = new ConditionalUpdateRiskBuilder(this, item);
    }
  
    public N and() {
      return (N) ConditionalUpdateFluent.this.setToRisks(index, builder.build());
    }
    
    public N endRisk() {
      return and();
    }
    
  }
}