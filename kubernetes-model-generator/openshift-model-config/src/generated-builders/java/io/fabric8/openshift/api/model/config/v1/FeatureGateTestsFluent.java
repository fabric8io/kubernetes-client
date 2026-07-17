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
public class FeatureGateTestsFluent<A extends io.fabric8.openshift.api.model.config.v1.FeatureGateTestsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String featureGate;
  private ArrayList<TestDetailsBuilder> tests = new ArrayList<TestDetailsBuilder>();

  public FeatureGateTestsFluent() {
  }
  
  public FeatureGateTestsFluent(FeatureGateTests instance) {
    this.copyInstance(instance);
  }

  public A addAllToTests(Collection<TestDetails> items) {
    if (this.tests == null) {
      this.tests = new ArrayList();
    }
    for (TestDetails item : items) {
        TestDetailsBuilder builder = new TestDetailsBuilder(item);
        _visitables.get("tests").add(builder);
        this.tests.add(builder);
    }
    return (A) this;
  }
  
  public TestsNested<A> addNewTest() {
    return new TestsNested(-1, null);
  }
  
  public A addNewTest(String testName) {
    return (A) this.addToTests(new TestDetails(testName));
  }
  
  public TestsNested<A> addNewTestLike(TestDetails item) {
    return new TestsNested(-1, item);
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
  
  public A addToTests(TestDetails... items) {
    if (this.tests == null) {
      this.tests = new ArrayList();
    }
    for (TestDetails item : items) {
        TestDetailsBuilder builder = new TestDetailsBuilder(item);
        _visitables.get("tests").add(builder);
        this.tests.add(builder);
    }
    return (A) this;
  }
  
  public A addToTests(int index,TestDetails item) {
    if (this.tests == null) {
      this.tests = new ArrayList();
    }
    TestDetailsBuilder builder = new TestDetailsBuilder(item);
    if (index < 0 || index >= tests.size()) {
        _visitables.get("tests").add(builder);
        tests.add(builder);
    } else {
        _visitables.get("tests").add(builder);
        tests.add(index, builder);
    }
    return (A) this;
  }
  
  public TestDetails buildFirstTest() {
    return this.tests.get(0).build();
  }
  
  public TestDetails buildLastTest() {
    return this.tests.get(tests.size() - 1).build();
  }
  
  public TestDetails buildMatchingTest(Predicate<TestDetailsBuilder> predicate) {
      for (TestDetailsBuilder item : tests) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TestDetails buildTest(int index) {
    return this.tests.get(index).build();
  }
  
  public List<TestDetails> buildTests() {
    return this.tests != null ? build(tests) : null;
  }
  
  protected void copyInstance(FeatureGateTests instance) {
    instance = instance != null ? instance : new FeatureGateTests();
    if (instance != null) {
        this.withFeatureGate(instance.getFeatureGate());
        this.withTests(instance.getTests());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TestsNested<A> editFirstTest() {
    if (tests.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tests"));
    }
    return this.setNewTestLike(0, this.buildTest(0));
  }
  
  public TestsNested<A> editLastTest() {
    int index = tests.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tests"));
    }
    return this.setNewTestLike(index, this.buildTest(index));
  }
  
  public TestsNested<A> editMatchingTest(Predicate<TestDetailsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tests.size();i++) {
      if (predicate.test(tests.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tests"));
    }
    return this.setNewTestLike(index, this.buildTest(index));
  }
  
  public TestsNested<A> editTest(int index) {
    if (tests.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tests"));
    }
    return this.setNewTestLike(index, this.buildTest(index));
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
    FeatureGateTestsFluent that = (FeatureGateTestsFluent) o;
    if (!(Objects.equals(featureGate, that.featureGate))) {
      return false;
    }
    if (!(Objects.equals(tests, that.tests))) {
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
  
  public String getFeatureGate() {
    return this.featureGate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFeatureGate() {
    return this.featureGate != null;
  }
  
  public boolean hasMatchingTest(Predicate<TestDetailsBuilder> predicate) {
      for (TestDetailsBuilder item : tests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTests() {
    return this.tests != null && !(this.tests.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(featureGate, tests, additionalProperties);
  }
  
  public A removeAllFromTests(Collection<TestDetails> items) {
    if (this.tests == null) {
      return (A) this;
    }
    for (TestDetails item : items) {
        TestDetailsBuilder builder = new TestDetailsBuilder(item);
        _visitables.get("tests").remove(builder);
        this.tests.remove(builder);
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
  
  public A removeFromTests(TestDetails... items) {
    if (this.tests == null) {
      return (A) this;
    }
    for (TestDetails item : items) {
        TestDetailsBuilder builder = new TestDetailsBuilder(item);
        _visitables.get("tests").remove(builder);
        this.tests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTests(Predicate<TestDetailsBuilder> predicate) {
    if (tests == null) {
      return (A) this;
    }
    Iterator<TestDetailsBuilder> each = tests.iterator();
    List visitables = _visitables.get("tests");
    while (each.hasNext()) {
        TestDetailsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TestsNested<A> setNewTestLike(int index,TestDetails item) {
    return new TestsNested(index, item);
  }
  
  public A setToTests(int index,TestDetails item) {
    if (this.tests == null) {
      this.tests = new ArrayList();
    }
    TestDetailsBuilder builder = new TestDetailsBuilder(item);
    if (index < 0 || index >= tests.size()) {
        _visitables.get("tests").add(builder);
        tests.add(builder);
    } else {
        _visitables.get("tests").add(builder);
        tests.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(featureGate == null)) {
        sb.append("featureGate:");
        sb.append(featureGate);
        sb.append(",");
    }
    if (!(tests == null) && !(tests.isEmpty())) {
        sb.append("tests:");
        sb.append(tests);
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
  
  public A withFeatureGate(String featureGate) {
    this.featureGate = featureGate;
    return (A) this;
  }
  
  public A withTests(List<TestDetails> tests) {
    if (this.tests != null) {
      this._visitables.get("tests").clear();
    }
    if (tests != null) {
        this.tests = new ArrayList();
        for (TestDetails item : tests) {
          this.addToTests(item);
        }
    } else {
      this.tests = null;
    }
    return (A) this;
  }
  
  public A withTests(TestDetails... tests) {
    if (this.tests != null) {
        this.tests.clear();
        _visitables.remove("tests");
    }
    if (tests != null) {
      for (TestDetails item : tests) {
        this.addToTests(item);
      }
    }
    return (A) this;
  }
  public class TestsNested<N> extends TestDetailsFluent<TestsNested<N>> implements Nested<N>{
  
    TestDetailsBuilder builder;
    int index;
  
    TestsNested(int index,TestDetails item) {
      this.index = index;
      this.builder = new TestDetailsBuilder(this, item);
    }
  
    public N and() {
      return (N) FeatureGateTestsFluent.this.setToTests(index, builder.build());
    }
    
    public N endTest() {
      return and();
    }
    
  }
}