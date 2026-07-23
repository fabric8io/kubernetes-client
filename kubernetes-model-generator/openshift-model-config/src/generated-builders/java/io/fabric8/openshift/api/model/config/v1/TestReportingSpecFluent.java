package io.fabric8.openshift.api.model.config.v1;

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
public class TestReportingSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.TestReportingSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FeatureGateTestsBuilder> testsForFeatureGates = new ArrayList<FeatureGateTestsBuilder>();

  public TestReportingSpecFluent() {
  }
  
  public TestReportingSpecFluent(TestReportingSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTestsForFeatureGates(Collection<FeatureGateTests> items) {
    if (this.testsForFeatureGates == null) {
      this.testsForFeatureGates = new ArrayList();
    }
    for (FeatureGateTests item : items) {
        FeatureGateTestsBuilder builder = new FeatureGateTestsBuilder(item);
        _visitables.get("testsForFeatureGates").add(builder);
        this.testsForFeatureGates.add(builder);
    }
    return (A) this;
  }
  
  public TestsForFeatureGatesNested<A> addNewTestsForFeatureGate() {
    return new TestsForFeatureGatesNested(-1, null);
  }
  
  public TestsForFeatureGatesNested<A> addNewTestsForFeatureGateLike(FeatureGateTests item) {
    return new TestsForFeatureGatesNested(-1, item);
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
  
  public A addToTestsForFeatureGates(FeatureGateTests... items) {
    if (this.testsForFeatureGates == null) {
      this.testsForFeatureGates = new ArrayList();
    }
    for (FeatureGateTests item : items) {
        FeatureGateTestsBuilder builder = new FeatureGateTestsBuilder(item);
        _visitables.get("testsForFeatureGates").add(builder);
        this.testsForFeatureGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToTestsForFeatureGates(int index,FeatureGateTests item) {
    if (this.testsForFeatureGates == null) {
      this.testsForFeatureGates = new ArrayList();
    }
    FeatureGateTestsBuilder builder = new FeatureGateTestsBuilder(item);
    if (index < 0 || index >= testsForFeatureGates.size()) {
        _visitables.get("testsForFeatureGates").add(builder);
        testsForFeatureGates.add(builder);
    } else {
        _visitables.get("testsForFeatureGates").add(builder);
        testsForFeatureGates.add(index, builder);
    }
    return (A) this;
  }
  
  public FeatureGateTests buildFirstTestsForFeatureGate() {
    return this.testsForFeatureGates.get(0).build();
  }
  
  public FeatureGateTests buildLastTestsForFeatureGate() {
    return this.testsForFeatureGates.get(testsForFeatureGates.size() - 1).build();
  }
  
  public FeatureGateTests buildMatchingTestsForFeatureGate(Predicate<FeatureGateTestsBuilder> predicate) {
      for (FeatureGateTestsBuilder item : testsForFeatureGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FeatureGateTests buildTestsForFeatureGate(int index) {
    return this.testsForFeatureGates.get(index).build();
  }
  
  public List<FeatureGateTests> buildTestsForFeatureGates() {
    return this.testsForFeatureGates != null ? build(testsForFeatureGates) : null;
  }
  
  protected void copyInstance(TestReportingSpec instance) {
    instance = instance != null ? instance : new TestReportingSpec();
    if (instance != null) {
        this.withTestsForFeatureGates(instance.getTestsForFeatureGates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TestsForFeatureGatesNested<A> editFirstTestsForFeatureGate() {
    if (testsForFeatureGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "testsForFeatureGates"));
    }
    return this.setNewTestsForFeatureGateLike(0, this.buildTestsForFeatureGate(0));
  }
  
  public TestsForFeatureGatesNested<A> editLastTestsForFeatureGate() {
    int index = testsForFeatureGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "testsForFeatureGates"));
    }
    return this.setNewTestsForFeatureGateLike(index, this.buildTestsForFeatureGate(index));
  }
  
  public TestsForFeatureGatesNested<A> editMatchingTestsForFeatureGate(Predicate<FeatureGateTestsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < testsForFeatureGates.size();i++) {
      if (predicate.test(testsForFeatureGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "testsForFeatureGates"));
    }
    return this.setNewTestsForFeatureGateLike(index, this.buildTestsForFeatureGate(index));
  }
  
  public TestsForFeatureGatesNested<A> editTestsForFeatureGate(int index) {
    if (testsForFeatureGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "testsForFeatureGates"));
    }
    return this.setNewTestsForFeatureGateLike(index, this.buildTestsForFeatureGate(index));
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
    TestReportingSpecFluent that = (TestReportingSpecFluent) o;
    if (!(Objects.equals(testsForFeatureGates, that.testsForFeatureGates))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTestsForFeatureGate(Predicate<FeatureGateTestsBuilder> predicate) {
      for (FeatureGateTestsBuilder item : testsForFeatureGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTestsForFeatureGates() {
    return this.testsForFeatureGates != null && !(this.testsForFeatureGates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(testsForFeatureGates, additionalProperties);
  }
  
  public A removeAllFromTestsForFeatureGates(Collection<FeatureGateTests> items) {
    if (this.testsForFeatureGates == null) {
      return (A) this;
    }
    for (FeatureGateTests item : items) {
        FeatureGateTestsBuilder builder = new FeatureGateTestsBuilder(item);
        _visitables.get("testsForFeatureGates").remove(builder);
        this.testsForFeatureGates.remove(builder);
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
  
  public A removeFromTestsForFeatureGates(FeatureGateTests... items) {
    if (this.testsForFeatureGates == null) {
      return (A) this;
    }
    for (FeatureGateTests item : items) {
        FeatureGateTestsBuilder builder = new FeatureGateTestsBuilder(item);
        _visitables.get("testsForFeatureGates").remove(builder);
        this.testsForFeatureGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTestsForFeatureGates(Predicate<FeatureGateTestsBuilder> predicate) {
    if (testsForFeatureGates == null) {
      return (A) this;
    }
    Iterator<FeatureGateTestsBuilder> each = testsForFeatureGates.iterator();
    List visitables = _visitables.get("testsForFeatureGates");
    while (each.hasNext()) {
        FeatureGateTestsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TestsForFeatureGatesNested<A> setNewTestsForFeatureGateLike(int index,FeatureGateTests item) {
    return new TestsForFeatureGatesNested(index, item);
  }
  
  public A setToTestsForFeatureGates(int index,FeatureGateTests item) {
    if (this.testsForFeatureGates == null) {
      this.testsForFeatureGates = new ArrayList();
    }
    FeatureGateTestsBuilder builder = new FeatureGateTestsBuilder(item);
    if (index < 0 || index >= testsForFeatureGates.size()) {
        _visitables.get("testsForFeatureGates").add(builder);
        testsForFeatureGates.add(builder);
    } else {
        _visitables.get("testsForFeatureGates").add(builder);
        testsForFeatureGates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(testsForFeatureGates == null) && !(testsForFeatureGates.isEmpty())) {
        sb.append("testsForFeatureGates:");
        sb.append(testsForFeatureGates);
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
  
  public A withTestsForFeatureGates(List<FeatureGateTests> testsForFeatureGates) {
    if (this.testsForFeatureGates != null) {
      this._visitables.get("testsForFeatureGates").clear();
    }
    if (testsForFeatureGates != null) {
        this.testsForFeatureGates = new ArrayList();
        for (FeatureGateTests item : testsForFeatureGates) {
          this.addToTestsForFeatureGates(item);
        }
    } else {
      this.testsForFeatureGates = null;
    }
    return (A) this;
  }
  
  public A withTestsForFeatureGates(FeatureGateTests... testsForFeatureGates) {
    if (this.testsForFeatureGates != null) {
        this.testsForFeatureGates.clear();
        _visitables.remove("testsForFeatureGates");
    }
    if (testsForFeatureGates != null) {
      for (FeatureGateTests item : testsForFeatureGates) {
        this.addToTestsForFeatureGates(item);
      }
    }
    return (A) this;
  }
  public class TestsForFeatureGatesNested<N> extends FeatureGateTestsFluent<TestsForFeatureGatesNested<N>> implements Nested<N>{
  
    FeatureGateTestsBuilder builder;
    int index;
  
    TestsForFeatureGatesNested(int index,FeatureGateTests item) {
      this.index = index;
      this.builder = new FeatureGateTestsBuilder(this, item);
    }
  
    public N and() {
      return (N) TestReportingSpecFluent.this.setToTestsForFeatureGates(index, builder.build());
    }
    
    public N endTestsForFeatureGate() {
      return and();
    }
    
  }
}