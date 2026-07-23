package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class StructuredResourceHandleFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.StructuredResourceHandleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String nodeName;
  private ArrayList<DriverAllocationResultBuilder> results = new ArrayList<DriverAllocationResultBuilder>();
  private Object vendorClaimParameters;
  private Object vendorClassParameters;

  public StructuredResourceHandleFluent() {
  }
  
  public StructuredResourceHandleFluent(StructuredResourceHandle instance) {
    this.copyInstance(instance);
  }

  public A addAllToResults(Collection<DriverAllocationResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (DriverAllocationResult item : items) {
        DriverAllocationResultBuilder builder = new DriverAllocationResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public ResultsNested<A> addNewResultLike(DriverAllocationResult item) {
    return new ResultsNested(-1, item);
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
  
  public A addToResults(DriverAllocationResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (DriverAllocationResult item : items) {
        DriverAllocationResultBuilder builder = new DriverAllocationResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,DriverAllocationResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    DriverAllocationResultBuilder builder = new DriverAllocationResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public DriverAllocationResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public DriverAllocationResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public DriverAllocationResult buildMatchingResult(Predicate<DriverAllocationResultBuilder> predicate) {
      for (DriverAllocationResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DriverAllocationResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<DriverAllocationResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  protected void copyInstance(StructuredResourceHandle instance) {
    instance = instance != null ? instance : new StructuredResourceHandle();
    if (instance != null) {
        this.withNodeName(instance.getNodeName());
        this.withResults(instance.getResults());
        this.withVendorClaimParameters(instance.getVendorClaimParameters());
        this.withVendorClassParameters(instance.getVendorClassParameters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public ResultsNested<A> editMatchingResult(Predicate<DriverAllocationResultBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < results.size();i++) {
      if (predicate.test(results.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public ResultsNested<A> editResult(int index) {
    if (results.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
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
    StructuredResourceHandleFluent that = (StructuredResourceHandleFluent) o;
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(vendorClaimParameters, that.vendorClaimParameters))) {
      return false;
    }
    if (!(Objects.equals(vendorClassParameters, that.vendorClassParameters))) {
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
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public Object getVendorClaimParameters() {
    return this.vendorClaimParameters;
  }
  
  public Object getVendorClassParameters() {
    return this.vendorClassParameters;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingResult(Predicate<DriverAllocationResultBuilder> predicate) {
      for (DriverAllocationResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public boolean hasVendorClaimParameters() {
    return this.vendorClaimParameters != null;
  }
  
  public boolean hasVendorClassParameters() {
    return this.vendorClassParameters != null;
  }
  
  public int hashCode() {
    return Objects.hash(nodeName, results, vendorClaimParameters, vendorClassParameters, additionalProperties);
  }
  
  public A removeAllFromResults(Collection<DriverAllocationResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (DriverAllocationResult item : items) {
        DriverAllocationResultBuilder builder = new DriverAllocationResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
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
  
  public A removeFromResults(DriverAllocationResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (DriverAllocationResult item : items) {
        DriverAllocationResultBuilder builder = new DriverAllocationResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<DriverAllocationResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<DriverAllocationResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        DriverAllocationResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResultsNested<A> setNewResultLike(int index,DriverAllocationResult item) {
    return new ResultsNested(index, item);
  }
  
  public A setToResults(int index,DriverAllocationResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    DriverAllocationResultBuilder builder = new DriverAllocationResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(results == null) && !(results.isEmpty())) {
        sb.append("results:");
        sb.append(results);
        sb.append(",");
    }
    if (!(vendorClaimParameters == null)) {
        sb.append("vendorClaimParameters:");
        sb.append(vendorClaimParameters);
        sb.append(",");
    }
    if (!(vendorClassParameters == null)) {
        sb.append("vendorClassParameters:");
        sb.append(vendorClassParameters);
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
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withResults(List<DriverAllocationResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (DriverAllocationResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(DriverAllocationResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (DriverAllocationResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withVendorClaimParameters(Object vendorClaimParameters) {
    this.vendorClaimParameters = vendorClaimParameters;
    return (A) this;
  }
  
  public A withVendorClassParameters(Object vendorClassParameters) {
    this.vendorClassParameters = vendorClassParameters;
    return (A) this;
  }
  public class ResultsNested<N> extends DriverAllocationResultFluent<ResultsNested<N>> implements Nested<N>{
  
    DriverAllocationResultBuilder builder;
    int index;
  
    ResultsNested(int index,DriverAllocationResult item) {
      this.index = index;
      this.builder = new DriverAllocationResultBuilder(this, item);
    }
  
    public N and() {
      return (N) StructuredResourceHandleFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
}