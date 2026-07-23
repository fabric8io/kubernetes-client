package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ReplicatedPolicyStatusFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.ReplicatedPolicyStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String compliant;
  private ArrayList<ReplicatedDetailsPerTemplateBuilder> details = new ArrayList<ReplicatedDetailsPerTemplateBuilder>();
  private String violationMessage;

  public ReplicatedPolicyStatusFluent() {
  }
  
  public ReplicatedPolicyStatusFluent(ReplicatedPolicyStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToDetails(Collection<ReplicatedDetailsPerTemplate> items) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    for (ReplicatedDetailsPerTemplate item : items) {
        ReplicatedDetailsPerTemplateBuilder builder = new ReplicatedDetailsPerTemplateBuilder(item);
        _visitables.get("details").add(builder);
        this.details.add(builder);
    }
    return (A) this;
  }
  
  public DetailsNested<A> addNewDetail() {
    return new DetailsNested(-1, null);
  }
  
  public DetailsNested<A> addNewDetailLike(ReplicatedDetailsPerTemplate item) {
    return new DetailsNested(-1, item);
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
  
  public A addToDetails(ReplicatedDetailsPerTemplate... items) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    for (ReplicatedDetailsPerTemplate item : items) {
        ReplicatedDetailsPerTemplateBuilder builder = new ReplicatedDetailsPerTemplateBuilder(item);
        _visitables.get("details").add(builder);
        this.details.add(builder);
    }
    return (A) this;
  }
  
  public A addToDetails(int index,ReplicatedDetailsPerTemplate item) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    ReplicatedDetailsPerTemplateBuilder builder = new ReplicatedDetailsPerTemplateBuilder(item);
    if (index < 0 || index >= details.size()) {
        _visitables.get("details").add(builder);
        details.add(builder);
    } else {
        _visitables.get("details").add(builder);
        details.add(index, builder);
    }
    return (A) this;
  }
  
  public ReplicatedDetailsPerTemplate buildDetail(int index) {
    return this.details.get(index).build();
  }
  
  public List<ReplicatedDetailsPerTemplate> buildDetails() {
    return this.details != null ? build(details) : null;
  }
  
  public ReplicatedDetailsPerTemplate buildFirstDetail() {
    return this.details.get(0).build();
  }
  
  public ReplicatedDetailsPerTemplate buildLastDetail() {
    return this.details.get(details.size() - 1).build();
  }
  
  public ReplicatedDetailsPerTemplate buildMatchingDetail(Predicate<ReplicatedDetailsPerTemplateBuilder> predicate) {
      for (ReplicatedDetailsPerTemplateBuilder item : details) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ReplicatedPolicyStatus instance) {
    instance = instance != null ? instance : new ReplicatedPolicyStatus();
    if (instance != null) {
        this.withCompliant(instance.getCompliant());
        this.withDetails(instance.getDetails());
        this.withViolationMessage(instance.getViolationMessage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DetailsNested<A> editDetail(int index) {
    if (details.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public DetailsNested<A> editFirstDetail() {
    if (details.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "details"));
    }
    return this.setNewDetailLike(0, this.buildDetail(0));
  }
  
  public DetailsNested<A> editLastDetail() {
    int index = details.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public DetailsNested<A> editMatchingDetail(Predicate<ReplicatedDetailsPerTemplateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < details.size();i++) {
      if (predicate.test(details.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
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
    ReplicatedPolicyStatusFluent that = (ReplicatedPolicyStatusFluent) o;
    if (!(Objects.equals(compliant, that.compliant))) {
      return false;
    }
    if (!(Objects.equals(details, that.details))) {
      return false;
    }
    if (!(Objects.equals(violationMessage, that.violationMessage))) {
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
  
  public String getCompliant() {
    return this.compliant;
  }
  
  public String getViolationMessage() {
    return this.violationMessage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompliant() {
    return this.compliant != null;
  }
  
  public boolean hasDetails() {
    return this.details != null && !(this.details.isEmpty());
  }
  
  public boolean hasMatchingDetail(Predicate<ReplicatedDetailsPerTemplateBuilder> predicate) {
      for (ReplicatedDetailsPerTemplateBuilder item : details) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasViolationMessage() {
    return this.violationMessage != null;
  }
  
  public int hashCode() {
    return Objects.hash(compliant, details, violationMessage, additionalProperties);
  }
  
  public A removeAllFromDetails(Collection<ReplicatedDetailsPerTemplate> items) {
    if (this.details == null) {
      return (A) this;
    }
    for (ReplicatedDetailsPerTemplate item : items) {
        ReplicatedDetailsPerTemplateBuilder builder = new ReplicatedDetailsPerTemplateBuilder(item);
        _visitables.get("details").remove(builder);
        this.details.remove(builder);
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
  
  public A removeFromDetails(ReplicatedDetailsPerTemplate... items) {
    if (this.details == null) {
      return (A) this;
    }
    for (ReplicatedDetailsPerTemplate item : items) {
        ReplicatedDetailsPerTemplateBuilder builder = new ReplicatedDetailsPerTemplateBuilder(item);
        _visitables.get("details").remove(builder);
        this.details.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDetails(Predicate<ReplicatedDetailsPerTemplateBuilder> predicate) {
    if (details == null) {
      return (A) this;
    }
    Iterator<ReplicatedDetailsPerTemplateBuilder> each = details.iterator();
    List visitables = _visitables.get("details");
    while (each.hasNext()) {
        ReplicatedDetailsPerTemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DetailsNested<A> setNewDetailLike(int index,ReplicatedDetailsPerTemplate item) {
    return new DetailsNested(index, item);
  }
  
  public A setToDetails(int index,ReplicatedDetailsPerTemplate item) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    ReplicatedDetailsPerTemplateBuilder builder = new ReplicatedDetailsPerTemplateBuilder(item);
    if (index < 0 || index >= details.size()) {
        _visitables.get("details").add(builder);
        details.add(builder);
    } else {
        _visitables.get("details").add(builder);
        details.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(compliant == null)) {
        sb.append("compliant:");
        sb.append(compliant);
        sb.append(",");
    }
    if (!(details == null) && !(details.isEmpty())) {
        sb.append("details:");
        sb.append(details);
        sb.append(",");
    }
    if (!(violationMessage == null)) {
        sb.append("violationMessage:");
        sb.append(violationMessage);
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
  
  public A withCompliant(String compliant) {
    this.compliant = compliant;
    return (A) this;
  }
  
  public A withDetails(List<ReplicatedDetailsPerTemplate> details) {
    if (this.details != null) {
      this._visitables.get("details").clear();
    }
    if (details != null) {
        this.details = new ArrayList();
        for (ReplicatedDetailsPerTemplate item : details) {
          this.addToDetails(item);
        }
    } else {
      this.details = null;
    }
    return (A) this;
  }
  
  public A withDetails(ReplicatedDetailsPerTemplate... details) {
    if (this.details != null) {
        this.details.clear();
        _visitables.remove("details");
    }
    if (details != null) {
      for (ReplicatedDetailsPerTemplate item : details) {
        this.addToDetails(item);
      }
    }
    return (A) this;
  }
  
  public A withViolationMessage(String violationMessage) {
    this.violationMessage = violationMessage;
    return (A) this;
  }
  public class DetailsNested<N> extends ReplicatedDetailsPerTemplateFluent<DetailsNested<N>> implements Nested<N>{
  
    ReplicatedDetailsPerTemplateBuilder builder;
    int index;
  
    DetailsNested(int index,ReplicatedDetailsPerTemplate item) {
      this.index = index;
      this.builder = new ReplicatedDetailsPerTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) ReplicatedPolicyStatusFluent.this.setToDetails(index, builder.build());
    }
    
    public N endDetail() {
      return and();
    }
    
  }
}