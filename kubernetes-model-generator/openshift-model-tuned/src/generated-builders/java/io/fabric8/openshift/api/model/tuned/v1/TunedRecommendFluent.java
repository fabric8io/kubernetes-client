package io.fabric8.openshift.api.model.tuned.v1;

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
public class TunedRecommendFluent<A extends io.fabric8.openshift.api.model.tuned.v1.TunedRecommendFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> machineConfigLabels;
  private ArrayList<TunedMatchBuilder> match = new ArrayList<TunedMatchBuilder>();
  private OperandConfigBuilder operand;
  private Long priority;
  private String profile;

  public TunedRecommendFluent() {
  }
  
  public TunedRecommendFluent(TunedRecommend instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatch(Collection<TunedMatch> items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public MatchNested<A> addNewMatch() {
    return new MatchNested(-1, null);
  }
  
  public MatchNested<A> addNewMatchLike(TunedMatch item) {
    return new MatchNested(-1, item);
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
  
  public A addToMachineConfigLabels(Map<String,String> map) {
    if (this.machineConfigLabels == null && map != null) {
      this.machineConfigLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.machineConfigLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMachineConfigLabels(String key,String value) {
    if (this.machineConfigLabels == null && key != null && value != null) {
      this.machineConfigLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.machineConfigLabels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMatch(TunedMatch... items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatch(int index,TunedMatch item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    TunedMatchBuilder builder = new TunedMatchBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.add(index, builder);
    }
    return (A) this;
  }
  
  public TunedMatch buildFirstMatch() {
    return this.match.get(0).build();
  }
  
  public TunedMatch buildLastMatch() {
    return this.match.get(match.size() - 1).build();
  }
  
  public List<TunedMatch> buildMatch() {
    return this.match != null ? build(match) : null;
  }
  
  public TunedMatch buildMatch(int index) {
    return this.match.get(index).build();
  }
  
  public TunedMatch buildMatchingMatch(Predicate<TunedMatchBuilder> predicate) {
      for (TunedMatchBuilder item : match) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OperandConfig buildOperand() {
    return this.operand != null ? this.operand.build() : null;
  }
  
  protected void copyInstance(TunedRecommend instance) {
    instance = instance != null ? instance : new TunedRecommend();
    if (instance != null) {
        this.withMachineConfigLabels(instance.getMachineConfigLabels());
        this.withMatch(instance.getMatch());
        this.withOperand(instance.getOperand());
        this.withPriority(instance.getPriority());
        this.withProfile(instance.getProfile());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchNested<A> editFirstMatch() {
    if (match.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(0, this.buildMatch(0));
  }
  
  public MatchNested<A> editLastMatch() {
    int index = match.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatch(int index) {
    if (match.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatchingMatch(Predicate<TunedMatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < match.size();i++) {
      if (predicate.test(match.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public OperandNested<A> editOperand() {
    return this.withNewOperandLike(Optional.ofNullable(this.buildOperand()).orElse(null));
  }
  
  public OperandNested<A> editOrNewOperand() {
    return this.withNewOperandLike(Optional.ofNullable(this.buildOperand()).orElse(new OperandConfigBuilder().build()));
  }
  
  public OperandNested<A> editOrNewOperandLike(OperandConfig item) {
    return this.withNewOperandLike(Optional.ofNullable(this.buildOperand()).orElse(item));
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
    TunedRecommendFluent that = (TunedRecommendFluent) o;
    if (!(Objects.equals(machineConfigLabels, that.machineConfigLabels))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(operand, that.operand))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
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
  
  public Map<String,String> getMachineConfigLabels() {
    return this.machineConfigLabels;
  }
  
  public Long getPriority() {
    return this.priority;
  }
  
  public String getProfile() {
    return this.profile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMachineConfigLabels() {
    return this.machineConfigLabels != null;
  }
  
  public boolean hasMatch() {
    return this.match != null && !(this.match.isEmpty());
  }
  
  public boolean hasMatchingMatch(Predicate<TunedMatchBuilder> predicate) {
      for (TunedMatchBuilder item : match) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOperand() {
    return this.operand != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public int hashCode() {
    return Objects.hash(machineConfigLabels, match, operand, priority, profile, additionalProperties);
  }
  
  public A removeAllFromMatch(Collection<TunedMatch> items) {
    if (this.match == null) {
      return (A) this;
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
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
  
  public A removeFromMachineConfigLabels(String key) {
    if (this.machineConfigLabels == null) {
      return (A) this;
    }
    if (key != null && this.machineConfigLabels != null) {
      this.machineConfigLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMachineConfigLabels(Map<String,String> map) {
    if (this.machineConfigLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.machineConfigLabels != null) {
          this.machineConfigLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMatch(TunedMatch... items) {
    if (this.match == null) {
      return (A) this;
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatch(Predicate<TunedMatchBuilder> predicate) {
    if (match == null) {
      return (A) this;
    }
    Iterator<TunedMatchBuilder> each = match.iterator();
    List visitables = _visitables.get("match");
    while (each.hasNext()) {
        TunedMatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchNested<A> setNewMatchLike(int index,TunedMatch item) {
    return new MatchNested(index, item);
  }
  
  public A setToMatch(int index,TunedMatch item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    TunedMatchBuilder builder = new TunedMatchBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(machineConfigLabels == null) && !(machineConfigLabels.isEmpty())) {
        sb.append("machineConfigLabels:");
        sb.append(machineConfigLabels);
        sb.append(",");
    }
    if (!(match == null) && !(match.isEmpty())) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(operand == null)) {
        sb.append("operand:");
        sb.append(operand);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(profile == null)) {
        sb.append("profile:");
        sb.append(profile);
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
  
  public <K,V>A withMachineConfigLabels(Map<String,String> machineConfigLabels) {
    if (machineConfigLabels == null) {
      this.machineConfigLabels = null;
    } else {
      this.machineConfigLabels = new LinkedHashMap(machineConfigLabels);
    }
    return (A) this;
  }
  
  public A withMatch(List<TunedMatch> match) {
    if (this.match != null) {
      this._visitables.get("match").clear();
    }
    if (match != null) {
        this.match = new ArrayList();
        for (TunedMatch item : match) {
          this.addToMatch(item);
        }
    } else {
      this.match = null;
    }
    return (A) this;
  }
  
  public A withMatch(TunedMatch... match) {
    if (this.match != null) {
        this.match.clear();
        _visitables.remove("match");
    }
    if (match != null) {
      for (TunedMatch item : match) {
        this.addToMatch(item);
      }
    }
    return (A) this;
  }
  
  public OperandNested<A> withNewOperand() {
    return new OperandNested(null);
  }
  
  public OperandNested<A> withNewOperandLike(OperandConfig item) {
    return new OperandNested(item);
  }
  
  public A withOperand(OperandConfig operand) {
    this._visitables.remove("operand");
    if (operand != null) {
        this.operand = new OperandConfigBuilder(operand);
        this._visitables.get("operand").add(this.operand);
    } else {
        this.operand = null;
        this._visitables.get("operand").remove(this.operand);
    }
    return (A) this;
  }
  
  public A withPriority(Long priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withProfile(String profile) {
    this.profile = profile;
    return (A) this;
  }
  public class MatchNested<N> extends TunedMatchFluent<MatchNested<N>> implements Nested<N>{
  
    TunedMatchBuilder builder;
    int index;
  
    MatchNested(int index,TunedMatch item) {
      this.index = index;
      this.builder = new TunedMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) TunedRecommendFluent.this.setToMatch(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class OperandNested<N> extends OperandConfigFluent<OperandNested<N>> implements Nested<N>{
  
    OperandConfigBuilder builder;
  
    OperandNested(OperandConfig item) {
      this.builder = new OperandConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) TunedRecommendFluent.this.withOperand(builder.build());
    }
    
    public N endOperand() {
      return and();
    }
    
  }
}