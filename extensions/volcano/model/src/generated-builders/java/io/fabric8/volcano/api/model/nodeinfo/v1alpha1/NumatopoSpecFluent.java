package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

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
public class NumatopoSpecFluent<A extends io.fabric8.volcano.api.model.nodeinfo.v1alpha1.NumatopoSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,CPUInfo> cpuDetail;
  private Map<String,ResourceInfo> numares;
  private ArrayList<PodAllocationBuilder> podAllocations = new ArrayList<PodAllocationBuilder>();
  private Map<String,String> policies;
  private Map<String,String> resReserved;

  public NumatopoSpecFluent() {
  }
  
  public NumatopoSpecFluent(NumatopoSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPodAllocations(Collection<PodAllocation> items) {
    if (this.podAllocations == null) {
      this.podAllocations = new ArrayList();
    }
    for (PodAllocation item : items) {
        PodAllocationBuilder builder = new PodAllocationBuilder(item);
        _visitables.get("podAllocations").add(builder);
        this.podAllocations.add(builder);
    }
    return (A) this;
  }
  
  public PodAllocationsNested<A> addNewPodAllocation() {
    return new PodAllocationsNested(-1, null);
  }
  
  public PodAllocationsNested<A> addNewPodAllocationLike(PodAllocation item) {
    return new PodAllocationsNested(-1, item);
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
  
  public A addToCpuDetail(Map<String,CPUInfo> map) {
    if (this.cpuDetail == null && map != null) {
      this.cpuDetail = new LinkedHashMap();
    }
    if (map != null) {
      this.cpuDetail.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCpuDetail(String key,CPUInfo value) {
    if (this.cpuDetail == null && key != null && value != null) {
      this.cpuDetail = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.cpuDetail.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNumares(Map<String,ResourceInfo> map) {
    if (this.numares == null && map != null) {
      this.numares = new LinkedHashMap();
    }
    if (map != null) {
      this.numares.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNumares(String key,ResourceInfo value) {
    if (this.numares == null && key != null && value != null) {
      this.numares = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.numares.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPodAllocations(PodAllocation... items) {
    if (this.podAllocations == null) {
      this.podAllocations = new ArrayList();
    }
    for (PodAllocation item : items) {
        PodAllocationBuilder builder = new PodAllocationBuilder(item);
        _visitables.get("podAllocations").add(builder);
        this.podAllocations.add(builder);
    }
    return (A) this;
  }
  
  public A addToPodAllocations(int index,PodAllocation item) {
    if (this.podAllocations == null) {
      this.podAllocations = new ArrayList();
    }
    PodAllocationBuilder builder = new PodAllocationBuilder(item);
    if (index < 0 || index >= podAllocations.size()) {
        _visitables.get("podAllocations").add(builder);
        podAllocations.add(builder);
    } else {
        _visitables.get("podAllocations").add(builder);
        podAllocations.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(Map<String,String> map) {
    if (this.policies == null && map != null) {
      this.policies = new LinkedHashMap();
    }
    if (map != null) {
      this.policies.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPolicies(String key,String value) {
    if (this.policies == null && key != null && value != null) {
      this.policies = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.policies.put(key, value);
    }
    return (A) this;
  }
  
  public A addToResReserved(Map<String,String> map) {
    if (this.resReserved == null && map != null) {
      this.resReserved = new LinkedHashMap();
    }
    if (map != null) {
      this.resReserved.putAll(map);
    }
    return (A) this;
  }
  
  public A addToResReserved(String key,String value) {
    if (this.resReserved == null && key != null && value != null) {
      this.resReserved = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.resReserved.put(key, value);
    }
    return (A) this;
  }
  
  public PodAllocation buildFirstPodAllocation() {
    return this.podAllocations.get(0).build();
  }
  
  public PodAllocation buildLastPodAllocation() {
    return this.podAllocations.get(podAllocations.size() - 1).build();
  }
  
  public PodAllocation buildMatchingPodAllocation(Predicate<PodAllocationBuilder> predicate) {
      for (PodAllocationBuilder item : podAllocations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodAllocation buildPodAllocation(int index) {
    return this.podAllocations.get(index).build();
  }
  
  public List<PodAllocation> buildPodAllocations() {
    return this.podAllocations != null ? build(podAllocations) : null;
  }
  
  protected void copyInstance(NumatopoSpec instance) {
    instance = instance != null ? instance : new NumatopoSpec();
    if (instance != null) {
        this.withCpuDetail(instance.getCpuDetail());
        this.withNumares(instance.getNumares());
        this.withPodAllocations(instance.getPodAllocations());
        this.withPolicies(instance.getPolicies());
        this.withResReserved(instance.getResReserved());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PodAllocationsNested<A> editFirstPodAllocation() {
    if (podAllocations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "podAllocations"));
    }
    return this.setNewPodAllocationLike(0, this.buildPodAllocation(0));
  }
  
  public PodAllocationsNested<A> editLastPodAllocation() {
    int index = podAllocations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "podAllocations"));
    }
    return this.setNewPodAllocationLike(index, this.buildPodAllocation(index));
  }
  
  public PodAllocationsNested<A> editMatchingPodAllocation(Predicate<PodAllocationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < podAllocations.size();i++) {
      if (predicate.test(podAllocations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "podAllocations"));
    }
    return this.setNewPodAllocationLike(index, this.buildPodAllocation(index));
  }
  
  public PodAllocationsNested<A> editPodAllocation(int index) {
    if (podAllocations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "podAllocations"));
    }
    return this.setNewPodAllocationLike(index, this.buildPodAllocation(index));
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
    NumatopoSpecFluent that = (NumatopoSpecFluent) o;
    if (!(Objects.equals(cpuDetail, that.cpuDetail))) {
      return false;
    }
    if (!(Objects.equals(numares, that.numares))) {
      return false;
    }
    if (!(Objects.equals(podAllocations, that.podAllocations))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(resReserved, that.resReserved))) {
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
  
  public Map<String,CPUInfo> getCpuDetail() {
    return this.cpuDetail;
  }
  
  public Map<String,ResourceInfo> getNumares() {
    return this.numares;
  }
  
  public Map<String,String> getPolicies() {
    return this.policies;
  }
  
  public Map<String,String> getResReserved() {
    return this.resReserved;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCpuDetail() {
    return this.cpuDetail != null;
  }
  
  public boolean hasMatchingPodAllocation(Predicate<PodAllocationBuilder> predicate) {
      for (PodAllocationBuilder item : podAllocations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNumares() {
    return this.numares != null;
  }
  
  public boolean hasPodAllocations() {
    return this.podAllocations != null && !(this.podAllocations.isEmpty());
  }
  
  public boolean hasPolicies() {
    return this.policies != null;
  }
  
  public boolean hasResReserved() {
    return this.resReserved != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpuDetail, numares, podAllocations, policies, resReserved, additionalProperties);
  }
  
  public A removeAllFromPodAllocations(Collection<PodAllocation> items) {
    if (this.podAllocations == null) {
      return (A) this;
    }
    for (PodAllocation item : items) {
        PodAllocationBuilder builder = new PodAllocationBuilder(item);
        _visitables.get("podAllocations").remove(builder);
        this.podAllocations.remove(builder);
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
  
  public A removeFromCpuDetail(String key) {
    if (this.cpuDetail == null) {
      return (A) this;
    }
    if (key != null && this.cpuDetail != null) {
      this.cpuDetail.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCpuDetail(Map<String,CPUInfo> map) {
    if (this.cpuDetail == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.cpuDetail != null) {
          this.cpuDetail.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNumares(String key) {
    if (this.numares == null) {
      return (A) this;
    }
    if (key != null && this.numares != null) {
      this.numares.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNumares(Map<String,ResourceInfo> map) {
    if (this.numares == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.numares != null) {
          this.numares.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPodAllocations(PodAllocation... items) {
    if (this.podAllocations == null) {
      return (A) this;
    }
    for (PodAllocation item : items) {
        PodAllocationBuilder builder = new PodAllocationBuilder(item);
        _visitables.get("podAllocations").remove(builder);
        this.podAllocations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPolicies(String key) {
    if (this.policies == null) {
      return (A) this;
    }
    if (key != null && this.policies != null) {
      this.policies.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPolicies(Map<String,String> map) {
    if (this.policies == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.policies != null) {
          this.policies.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromResReserved(String key) {
    if (this.resReserved == null) {
      return (A) this;
    }
    if (key != null && this.resReserved != null) {
      this.resReserved.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromResReserved(Map<String,String> map) {
    if (this.resReserved == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.resReserved != null) {
          this.resReserved.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPodAllocations(Predicate<PodAllocationBuilder> predicate) {
    if (podAllocations == null) {
      return (A) this;
    }
    Iterator<PodAllocationBuilder> each = podAllocations.iterator();
    List visitables = _visitables.get("podAllocations");
    while (each.hasNext()) {
        PodAllocationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PodAllocationsNested<A> setNewPodAllocationLike(int index,PodAllocation item) {
    return new PodAllocationsNested(index, item);
  }
  
  public A setToPodAllocations(int index,PodAllocation item) {
    if (this.podAllocations == null) {
      this.podAllocations = new ArrayList();
    }
    PodAllocationBuilder builder = new PodAllocationBuilder(item);
    if (index < 0 || index >= podAllocations.size()) {
        _visitables.get("podAllocations").add(builder);
        podAllocations.add(builder);
    } else {
        _visitables.get("podAllocations").add(builder);
        podAllocations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cpuDetail == null) && !(cpuDetail.isEmpty())) {
        sb.append("cpuDetail:");
        sb.append(cpuDetail);
        sb.append(",");
    }
    if (!(numares == null) && !(numares.isEmpty())) {
        sb.append("numares:");
        sb.append(numares);
        sb.append(",");
    }
    if (!(podAllocations == null) && !(podAllocations.isEmpty())) {
        sb.append("podAllocations:");
        sb.append(podAllocations);
        sb.append(",");
    }
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
        sb.append(",");
    }
    if (!(resReserved == null) && !(resReserved.isEmpty())) {
        sb.append("resReserved:");
        sb.append(resReserved);
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
  
  public <K,V>A withCpuDetail(Map<String,CPUInfo> cpuDetail) {
    if (cpuDetail == null) {
      this.cpuDetail = null;
    } else {
      this.cpuDetail = new LinkedHashMap(cpuDetail);
    }
    return (A) this;
  }
  
  public <K,V>A withNumares(Map<String,ResourceInfo> numares) {
    if (numares == null) {
      this.numares = null;
    } else {
      this.numares = new LinkedHashMap(numares);
    }
    return (A) this;
  }
  
  public A withPodAllocations(List<PodAllocation> podAllocations) {
    if (this.podAllocations != null) {
      this._visitables.get("podAllocations").clear();
    }
    if (podAllocations != null) {
        this.podAllocations = new ArrayList();
        for (PodAllocation item : podAllocations) {
          this.addToPodAllocations(item);
        }
    } else {
      this.podAllocations = null;
    }
    return (A) this;
  }
  
  public A withPodAllocations(PodAllocation... podAllocations) {
    if (this.podAllocations != null) {
        this.podAllocations.clear();
        _visitables.remove("podAllocations");
    }
    if (podAllocations != null) {
      for (PodAllocation item : podAllocations) {
        this.addToPodAllocations(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withPolicies(Map<String,String> policies) {
    if (policies == null) {
      this.policies = null;
    } else {
      this.policies = new LinkedHashMap(policies);
    }
    return (A) this;
  }
  
  public <K,V>A withResReserved(Map<String,String> resReserved) {
    if (resReserved == null) {
      this.resReserved = null;
    } else {
      this.resReserved = new LinkedHashMap(resReserved);
    }
    return (A) this;
  }
  public class PodAllocationsNested<N> extends PodAllocationFluent<PodAllocationsNested<N>> implements Nested<N>{
  
    PodAllocationBuilder builder;
    int index;
  
    PodAllocationsNested(int index,PodAllocation item) {
      this.index = index;
      this.builder = new PodAllocationBuilder(this, item);
    }
  
    public N and() {
      return (N) NumatopoSpecFluent.this.setToPodAllocations(index, builder.build());
    }
    
    public N endPodAllocation() {
      return and();
    }
    
  }
}