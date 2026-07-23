package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
public class InhibitRuleFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.InhibitRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> equal = new ArrayList<String>();
  private ArrayList<MatcherBuilder> sourceMatch = new ArrayList<MatcherBuilder>();
  private ArrayList<MatcherBuilder> targetMatch = new ArrayList<MatcherBuilder>();

  public InhibitRuleFluent() {
  }
  
  public InhibitRuleFluent(InhibitRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToEqual(Collection<String> items) {
    if (this.equal == null) {
      this.equal = new ArrayList();
    }
    for (String item : items) {
      this.equal.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSourceMatch(Collection<Matcher> items) {
    if (this.sourceMatch == null) {
      this.sourceMatch = new ArrayList();
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("sourceMatch").add(builder);
        this.sourceMatch.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTargetMatch(Collection<Matcher> items) {
    if (this.targetMatch == null) {
      this.targetMatch = new ArrayList();
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("targetMatch").add(builder);
        this.targetMatch.add(builder);
    }
    return (A) this;
  }
  
  public SourceMatchNested<A> addNewSourceMatch() {
    return new SourceMatchNested(-1, null);
  }
  
  public A addNewSourceMatch(String matchType,String name,Boolean regex,String value) {
    return (A) this.addToSourceMatch(new Matcher(matchType, name, regex, value));
  }
  
  public SourceMatchNested<A> addNewSourceMatchLike(Matcher item) {
    return new SourceMatchNested(-1, item);
  }
  
  public TargetMatchNested<A> addNewTargetMatch() {
    return new TargetMatchNested(-1, null);
  }
  
  public A addNewTargetMatch(String matchType,String name,Boolean regex,String value) {
    return (A) this.addToTargetMatch(new Matcher(matchType, name, regex, value));
  }
  
  public TargetMatchNested<A> addNewTargetMatchLike(Matcher item) {
    return new TargetMatchNested(-1, item);
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
  
  public A addToEqual(String... items) {
    if (this.equal == null) {
      this.equal = new ArrayList();
    }
    for (String item : items) {
      this.equal.add(item);
    }
    return (A) this;
  }
  
  public A addToEqual(int index,String item) {
    if (this.equal == null) {
      this.equal = new ArrayList();
    }
    this.equal.add(index, item);
    return (A) this;
  }
  
  public A addToSourceMatch(Matcher... items) {
    if (this.sourceMatch == null) {
      this.sourceMatch = new ArrayList();
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("sourceMatch").add(builder);
        this.sourceMatch.add(builder);
    }
    return (A) this;
  }
  
  public A addToSourceMatch(int index,Matcher item) {
    if (this.sourceMatch == null) {
      this.sourceMatch = new ArrayList();
    }
    MatcherBuilder builder = new MatcherBuilder(item);
    if (index < 0 || index >= sourceMatch.size()) {
        _visitables.get("sourceMatch").add(builder);
        sourceMatch.add(builder);
    } else {
        _visitables.get("sourceMatch").add(builder);
        sourceMatch.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTargetMatch(Matcher... items) {
    if (this.targetMatch == null) {
      this.targetMatch = new ArrayList();
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("targetMatch").add(builder);
        this.targetMatch.add(builder);
    }
    return (A) this;
  }
  
  public A addToTargetMatch(int index,Matcher item) {
    if (this.targetMatch == null) {
      this.targetMatch = new ArrayList();
    }
    MatcherBuilder builder = new MatcherBuilder(item);
    if (index < 0 || index >= targetMatch.size()) {
        _visitables.get("targetMatch").add(builder);
        targetMatch.add(builder);
    } else {
        _visitables.get("targetMatch").add(builder);
        targetMatch.add(index, builder);
    }
    return (A) this;
  }
  
  public Matcher buildFirstSourceMatch() {
    return this.sourceMatch.get(0).build();
  }
  
  public Matcher buildFirstTargetMatch() {
    return this.targetMatch.get(0).build();
  }
  
  public Matcher buildLastSourceMatch() {
    return this.sourceMatch.get(sourceMatch.size() - 1).build();
  }
  
  public Matcher buildLastTargetMatch() {
    return this.targetMatch.get(targetMatch.size() - 1).build();
  }
  
  public Matcher buildMatchingSourceMatch(Predicate<MatcherBuilder> predicate) {
      for (MatcherBuilder item : sourceMatch) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Matcher buildMatchingTargetMatch(Predicate<MatcherBuilder> predicate) {
      for (MatcherBuilder item : targetMatch) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<Matcher> buildSourceMatch() {
    return this.sourceMatch != null ? build(sourceMatch) : null;
  }
  
  public Matcher buildSourceMatch(int index) {
    return this.sourceMatch.get(index).build();
  }
  
  public List<Matcher> buildTargetMatch() {
    return this.targetMatch != null ? build(targetMatch) : null;
  }
  
  public Matcher buildTargetMatch(int index) {
    return this.targetMatch.get(index).build();
  }
  
  protected void copyInstance(InhibitRule instance) {
    instance = instance != null ? instance : new InhibitRule();
    if (instance != null) {
        this.withEqual(instance.getEqual());
        this.withSourceMatch(instance.getSourceMatch());
        this.withTargetMatch(instance.getTargetMatch());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourceMatchNested<A> editFirstSourceMatch() {
    if (sourceMatch.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sourceMatch"));
    }
    return this.setNewSourceMatchLike(0, this.buildSourceMatch(0));
  }
  
  public TargetMatchNested<A> editFirstTargetMatch() {
    if (targetMatch.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetMatch"));
    }
    return this.setNewTargetMatchLike(0, this.buildTargetMatch(0));
  }
  
  public SourceMatchNested<A> editLastSourceMatch() {
    int index = sourceMatch.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sourceMatch"));
    }
    return this.setNewSourceMatchLike(index, this.buildSourceMatch(index));
  }
  
  public TargetMatchNested<A> editLastTargetMatch() {
    int index = targetMatch.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetMatch"));
    }
    return this.setNewTargetMatchLike(index, this.buildTargetMatch(index));
  }
  
  public SourceMatchNested<A> editMatchingSourceMatch(Predicate<MatcherBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sourceMatch.size();i++) {
      if (predicate.test(sourceMatch.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sourceMatch"));
    }
    return this.setNewSourceMatchLike(index, this.buildSourceMatch(index));
  }
  
  public TargetMatchNested<A> editMatchingTargetMatch(Predicate<MatcherBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < targetMatch.size();i++) {
      if (predicate.test(targetMatch.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "targetMatch"));
    }
    return this.setNewTargetMatchLike(index, this.buildTargetMatch(index));
  }
  
  public SourceMatchNested<A> editSourceMatch(int index) {
    if (sourceMatch.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sourceMatch"));
    }
    return this.setNewSourceMatchLike(index, this.buildSourceMatch(index));
  }
  
  public TargetMatchNested<A> editTargetMatch(int index) {
    if (targetMatch.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targetMatch"));
    }
    return this.setNewTargetMatchLike(index, this.buildTargetMatch(index));
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
    InhibitRuleFluent that = (InhibitRuleFluent) o;
    if (!(Objects.equals(equal, that.equal))) {
      return false;
    }
    if (!(Objects.equals(sourceMatch, that.sourceMatch))) {
      return false;
    }
    if (!(Objects.equals(targetMatch, that.targetMatch))) {
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
  
  public List<String> getEqual() {
    return this.equal;
  }
  
  public String getEqual(int index) {
    return this.equal.get(index);
  }
  
  public String getFirstEqual() {
    return this.equal.get(0);
  }
  
  public String getLastEqual() {
    return this.equal.get(equal.size() - 1);
  }
  
  public String getMatchingEqual(Predicate<String> predicate) {
      for (String item : equal) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEqual() {
    return this.equal != null && !(this.equal.isEmpty());
  }
  
  public boolean hasMatchingEqual(Predicate<String> predicate) {
      for (String item : equal) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSourceMatch(Predicate<MatcherBuilder> predicate) {
      for (MatcherBuilder item : sourceMatch) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetMatch(Predicate<MatcherBuilder> predicate) {
      for (MatcherBuilder item : targetMatch) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSourceMatch() {
    return this.sourceMatch != null && !(this.sourceMatch.isEmpty());
  }
  
  public boolean hasTargetMatch() {
    return this.targetMatch != null && !(this.targetMatch.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(equal, sourceMatch, targetMatch, additionalProperties);
  }
  
  public A removeAllFromEqual(Collection<String> items) {
    if (this.equal == null) {
      return (A) this;
    }
    for (String item : items) {
      this.equal.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSourceMatch(Collection<Matcher> items) {
    if (this.sourceMatch == null) {
      return (A) this;
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("sourceMatch").remove(builder);
        this.sourceMatch.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetMatch(Collection<Matcher> items) {
    if (this.targetMatch == null) {
      return (A) this;
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("targetMatch").remove(builder);
        this.targetMatch.remove(builder);
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
  
  public A removeFromEqual(String... items) {
    if (this.equal == null) {
      return (A) this;
    }
    for (String item : items) {
      this.equal.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSourceMatch(Matcher... items) {
    if (this.sourceMatch == null) {
      return (A) this;
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("sourceMatch").remove(builder);
        this.sourceMatch.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTargetMatch(Matcher... items) {
    if (this.targetMatch == null) {
      return (A) this;
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("targetMatch").remove(builder);
        this.targetMatch.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSourceMatch(Predicate<MatcherBuilder> predicate) {
    if (sourceMatch == null) {
      return (A) this;
    }
    Iterator<MatcherBuilder> each = sourceMatch.iterator();
    List visitables = _visitables.get("sourceMatch");
    while (each.hasNext()) {
        MatcherBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTargetMatch(Predicate<MatcherBuilder> predicate) {
    if (targetMatch == null) {
      return (A) this;
    }
    Iterator<MatcherBuilder> each = targetMatch.iterator();
    List visitables = _visitables.get("targetMatch");
    while (each.hasNext()) {
        MatcherBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SourceMatchNested<A> setNewSourceMatchLike(int index,Matcher item) {
    return new SourceMatchNested(index, item);
  }
  
  public TargetMatchNested<A> setNewTargetMatchLike(int index,Matcher item) {
    return new TargetMatchNested(index, item);
  }
  
  public A setToEqual(int index,String item) {
    if (this.equal == null) {
      this.equal = new ArrayList();
    }
    this.equal.set(index, item);
    return (A) this;
  }
  
  public A setToSourceMatch(int index,Matcher item) {
    if (this.sourceMatch == null) {
      this.sourceMatch = new ArrayList();
    }
    MatcherBuilder builder = new MatcherBuilder(item);
    if (index < 0 || index >= sourceMatch.size()) {
        _visitables.get("sourceMatch").add(builder);
        sourceMatch.add(builder);
    } else {
        _visitables.get("sourceMatch").add(builder);
        sourceMatch.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTargetMatch(int index,Matcher item) {
    if (this.targetMatch == null) {
      this.targetMatch = new ArrayList();
    }
    MatcherBuilder builder = new MatcherBuilder(item);
    if (index < 0 || index >= targetMatch.size()) {
        _visitables.get("targetMatch").add(builder);
        targetMatch.add(builder);
    } else {
        _visitables.get("targetMatch").add(builder);
        targetMatch.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(equal == null) && !(equal.isEmpty())) {
        sb.append("equal:");
        sb.append(equal);
        sb.append(",");
    }
    if (!(sourceMatch == null) && !(sourceMatch.isEmpty())) {
        sb.append("sourceMatch:");
        sb.append(sourceMatch);
        sb.append(",");
    }
    if (!(targetMatch == null) && !(targetMatch.isEmpty())) {
        sb.append("targetMatch:");
        sb.append(targetMatch);
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
  
  public A withEqual(List<String> equal) {
    if (equal != null) {
        this.equal = new ArrayList();
        for (String item : equal) {
          this.addToEqual(item);
        }
    } else {
      this.equal = null;
    }
    return (A) this;
  }
  
  public A withEqual(String... equal) {
    if (this.equal != null) {
        this.equal.clear();
        _visitables.remove("equal");
    }
    if (equal != null) {
      for (String item : equal) {
        this.addToEqual(item);
      }
    }
    return (A) this;
  }
  
  public A withSourceMatch(List<Matcher> sourceMatch) {
    if (this.sourceMatch != null) {
      this._visitables.get("sourceMatch").clear();
    }
    if (sourceMatch != null) {
        this.sourceMatch = new ArrayList();
        for (Matcher item : sourceMatch) {
          this.addToSourceMatch(item);
        }
    } else {
      this.sourceMatch = null;
    }
    return (A) this;
  }
  
  public A withSourceMatch(Matcher... sourceMatch) {
    if (this.sourceMatch != null) {
        this.sourceMatch.clear();
        _visitables.remove("sourceMatch");
    }
    if (sourceMatch != null) {
      for (Matcher item : sourceMatch) {
        this.addToSourceMatch(item);
      }
    }
    return (A) this;
  }
  
  public A withTargetMatch(List<Matcher> targetMatch) {
    if (this.targetMatch != null) {
      this._visitables.get("targetMatch").clear();
    }
    if (targetMatch != null) {
        this.targetMatch = new ArrayList();
        for (Matcher item : targetMatch) {
          this.addToTargetMatch(item);
        }
    } else {
      this.targetMatch = null;
    }
    return (A) this;
  }
  
  public A withTargetMatch(Matcher... targetMatch) {
    if (this.targetMatch != null) {
        this.targetMatch.clear();
        _visitables.remove("targetMatch");
    }
    if (targetMatch != null) {
      for (Matcher item : targetMatch) {
        this.addToTargetMatch(item);
      }
    }
    return (A) this;
  }
  public class SourceMatchNested<N> extends MatcherFluent<SourceMatchNested<N>> implements Nested<N>{
  
    MatcherBuilder builder;
    int index;
  
    SourceMatchNested(int index,Matcher item) {
      this.index = index;
      this.builder = new MatcherBuilder(this, item);
    }
  
    public N and() {
      return (N) InhibitRuleFluent.this.setToSourceMatch(index, builder.build());
    }
    
    public N endSourceMatch() {
      return and();
    }
    
  }
  public class TargetMatchNested<N> extends MatcherFluent<TargetMatchNested<N>> implements Nested<N>{
  
    MatcherBuilder builder;
    int index;
  
    TargetMatchNested(int index,Matcher item) {
      this.index = index;
      this.builder = new MatcherBuilder(this, item);
    }
  
    public N and() {
      return (N) InhibitRuleFluent.this.setToTargetMatch(index, builder.build());
    }
    
    public N endTargetMatch() {
      return and();
    }
    
  }
}