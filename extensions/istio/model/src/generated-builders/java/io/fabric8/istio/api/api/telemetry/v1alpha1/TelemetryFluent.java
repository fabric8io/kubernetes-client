package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceBuilder;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceFluent;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TelemetryFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.TelemetryFluent<A>> extends BaseFluent<A>{

  private ArrayList<AccessLoggingBuilder> accessLogging = new ArrayList<AccessLoggingBuilder>();
  private Map<String,Object> additionalProperties;
  private ArrayList<MetricsBuilder> metrics = new ArrayList<MetricsBuilder>();
  private WorkloadSelectorBuilder selector;
  private PolicyTargetReferenceBuilder targetRef;
  private ArrayList<PolicyTargetReferenceBuilder> targetRefs = new ArrayList<PolicyTargetReferenceBuilder>();
  private ArrayList<TracingBuilder> tracing = new ArrayList<TracingBuilder>();

  public TelemetryFluent() {
  }
  
  public TelemetryFluent(Telemetry instance) {
    this.copyInstance(instance);
  }

  public A addAllToAccessLogging(Collection<AccessLogging> items) {
    if (this.accessLogging == null) {
      this.accessLogging = new ArrayList();
    }
    for (AccessLogging item : items) {
        AccessLoggingBuilder builder = new AccessLoggingBuilder(item);
        _visitables.get("accessLogging").add(builder);
        this.accessLogging.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMetrics(Collection<Metrics> items) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    for (Metrics item : items) {
        MetricsBuilder builder = new MetricsBuilder(item);
        _visitables.get("metrics").add(builder);
        this.metrics.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTargetRefs(Collection<PolicyTargetReference> items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTracing(Collection<Tracing> items) {
    if (this.tracing == null) {
      this.tracing = new ArrayList();
    }
    for (Tracing item : items) {
        TracingBuilder builder = new TracingBuilder(item);
        _visitables.get("tracing").add(builder);
        this.tracing.add(builder);
    }
    return (A) this;
  }
  
  public AccessLoggingNested<A> addNewAccessLogging() {
    return new AccessLoggingNested(-1, null);
  }
  
  public AccessLoggingNested<A> addNewAccessLoggingLike(AccessLogging item) {
    return new AccessLoggingNested(-1, item);
  }
  
  public MetricsNested<A> addNewMetric() {
    return new MetricsNested(-1, null);
  }
  
  public MetricsNested<A> addNewMetricLike(Metrics item) {
    return new MetricsNested(-1, item);
  }
  
  public TargetRefsNested<A> addNewTargetRef() {
    return new TargetRefsNested(-1, null);
  }
  
  public A addNewTargetRef(String group,String kind,String name,String namespace) {
    return (A) this.addToTargetRefs(new PolicyTargetReference(group, kind, name, namespace));
  }
  
  public TargetRefsNested<A> addNewTargetRefLike(PolicyTargetReference item) {
    return new TargetRefsNested(-1, item);
  }
  
  public TracingNested<A> addNewTracing() {
    return new TracingNested(-1, null);
  }
  
  public TracingNested<A> addNewTracingLike(Tracing item) {
    return new TracingNested(-1, item);
  }
  
  public A addToAccessLogging(AccessLogging... items) {
    if (this.accessLogging == null) {
      this.accessLogging = new ArrayList();
    }
    for (AccessLogging item : items) {
        AccessLoggingBuilder builder = new AccessLoggingBuilder(item);
        _visitables.get("accessLogging").add(builder);
        this.accessLogging.add(builder);
    }
    return (A) this;
  }
  
  public A addToAccessLogging(int index,AccessLogging item) {
    if (this.accessLogging == null) {
      this.accessLogging = new ArrayList();
    }
    AccessLoggingBuilder builder = new AccessLoggingBuilder(item);
    if (index < 0 || index >= accessLogging.size()) {
        _visitables.get("accessLogging").add(builder);
        accessLogging.add(builder);
    } else {
        _visitables.get("accessLogging").add(builder);
        accessLogging.add(index, builder);
    }
    return (A) this;
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
  
  public A addToMetrics(Metrics... items) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    for (Metrics item : items) {
        MetricsBuilder builder = new MetricsBuilder(item);
        _visitables.get("metrics").add(builder);
        this.metrics.add(builder);
    }
    return (A) this;
  }
  
  public A addToMetrics(int index,Metrics item) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    MetricsBuilder builder = new MetricsBuilder(item);
    if (index < 0 || index >= metrics.size()) {
        _visitables.get("metrics").add(builder);
        metrics.add(builder);
    } else {
        _visitables.get("metrics").add(builder);
        metrics.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTargetRefs(PolicyTargetReference... items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToTargetRefs(int index,PolicyTargetReference item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTracing(Tracing... items) {
    if (this.tracing == null) {
      this.tracing = new ArrayList();
    }
    for (Tracing item : items) {
        TracingBuilder builder = new TracingBuilder(item);
        _visitables.get("tracing").add(builder);
        this.tracing.add(builder);
    }
    return (A) this;
  }
  
  public A addToTracing(int index,Tracing item) {
    if (this.tracing == null) {
      this.tracing = new ArrayList();
    }
    TracingBuilder builder = new TracingBuilder(item);
    if (index < 0 || index >= tracing.size()) {
        _visitables.get("tracing").add(builder);
        tracing.add(builder);
    } else {
        _visitables.get("tracing").add(builder);
        tracing.add(index, builder);
    }
    return (A) this;
  }
  
  public List<AccessLogging> buildAccessLogging() {
    return this.accessLogging != null ? build(accessLogging) : null;
  }
  
  public AccessLogging buildAccessLogging(int index) {
    return this.accessLogging.get(index).build();
  }
  
  public AccessLogging buildFirstAccessLogging() {
    return this.accessLogging.get(0).build();
  }
  
  public Metrics buildFirstMetric() {
    return this.metrics.get(0).build();
  }
  
  public PolicyTargetReference buildFirstTargetRef() {
    return this.targetRefs.get(0).build();
  }
  
  public Tracing buildFirstTracing() {
    return this.tracing.get(0).build();
  }
  
  public AccessLogging buildLastAccessLogging() {
    return this.accessLogging.get(accessLogging.size() - 1).build();
  }
  
  public Metrics buildLastMetric() {
    return this.metrics.get(metrics.size() - 1).build();
  }
  
  public PolicyTargetReference buildLastTargetRef() {
    return this.targetRefs.get(targetRefs.size() - 1).build();
  }
  
  public Tracing buildLastTracing() {
    return this.tracing.get(tracing.size() - 1).build();
  }
  
  public AccessLogging buildMatchingAccessLogging(Predicate<AccessLoggingBuilder> predicate) {
      for (AccessLoggingBuilder item : accessLogging) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Metrics buildMatchingMetric(Predicate<MetricsBuilder> predicate) {
      for (MetricsBuilder item : metrics) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PolicyTargetReference buildMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
      for (PolicyTargetReferenceBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Tracing buildMatchingTracing(Predicate<TracingBuilder> predicate) {
      for (TracingBuilder item : tracing) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Metrics buildMetric(int index) {
    return this.metrics.get(index).build();
  }
  
  public List<Metrics> buildMetrics() {
    return this.metrics != null ? build(metrics) : null;
  }
  
  public WorkloadSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef() {
    return this.targetRef != null ? this.targetRef.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef(int index) {
    return this.targetRefs.get(index).build();
  }
  
  public List<PolicyTargetReference> buildTargetRefs() {
    return this.targetRefs != null ? build(targetRefs) : null;
  }
  
  public List<Tracing> buildTracing() {
    return this.tracing != null ? build(tracing) : null;
  }
  
  public Tracing buildTracing(int index) {
    return this.tracing.get(index).build();
  }
  
  protected void copyInstance(Telemetry instance) {
    instance = instance != null ? instance : new Telemetry();
    if (instance != null) {
        this.withAccessLogging(instance.getAccessLogging());
        this.withMetrics(instance.getMetrics());
        this.withSelector(instance.getSelector());
        this.withTargetRef(instance.getTargetRef());
        this.withTargetRefs(instance.getTargetRefs());
        this.withTracing(instance.getTracing());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccessLoggingNested<A> editAccessLogging(int index) {
    if (accessLogging.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "accessLogging"));
    }
    return this.setNewAccessLoggingLike(index, this.buildAccessLogging(index));
  }
  
  public AccessLoggingNested<A> editFirstAccessLogging() {
    if (accessLogging.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "accessLogging"));
    }
    return this.setNewAccessLoggingLike(0, this.buildAccessLogging(0));
  }
  
  public MetricsNested<A> editFirstMetric() {
    if (metrics.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "metrics"));
    }
    return this.setNewMetricLike(0, this.buildMetric(0));
  }
  
  public TargetRefsNested<A> editFirstTargetRef() {
    if (targetRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(0, this.buildTargetRef(0));
  }
  
  public TracingNested<A> editFirstTracing() {
    if (tracing.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tracing"));
    }
    return this.setNewTracingLike(0, this.buildTracing(0));
  }
  
  public AccessLoggingNested<A> editLastAccessLogging() {
    int index = accessLogging.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "accessLogging"));
    }
    return this.setNewAccessLoggingLike(index, this.buildAccessLogging(index));
  }
  
  public MetricsNested<A> editLastMetric() {
    int index = metrics.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "metrics"));
    }
    return this.setNewMetricLike(index, this.buildMetric(index));
  }
  
  public TargetRefsNested<A> editLastTargetRef() {
    int index = targetRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public TracingNested<A> editLastTracing() {
    int index = tracing.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tracing"));
    }
    return this.setNewTracingLike(index, this.buildTracing(index));
  }
  
  public AccessLoggingNested<A> editMatchingAccessLogging(Predicate<AccessLoggingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < accessLogging.size();i++) {
      if (predicate.test(accessLogging.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "accessLogging"));
    }
    return this.setNewAccessLoggingLike(index, this.buildAccessLogging(index));
  }
  
  public MetricsNested<A> editMatchingMetric(Predicate<MetricsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < metrics.size();i++) {
      if (predicate.test(metrics.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "metrics"));
    }
    return this.setNewMetricLike(index, this.buildMetric(index));
  }
  
  public TargetRefsNested<A> editMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < targetRefs.size();i++) {
      if (predicate.test(targetRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public TracingNested<A> editMatchingTracing(Predicate<TracingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tracing.size();i++) {
      if (predicate.test(tracing.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tracing"));
    }
    return this.setNewTracingLike(index, this.buildTracing(index));
  }
  
  public MetricsNested<A> editMetric(int index) {
    if (metrics.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "metrics"));
    }
    return this.setNewMetricLike(index, this.buildMetric(index));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(WorkloadSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public TargetRefNested<A> editOrNewTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(new PolicyTargetReferenceBuilder().build()));
  }
  
  public TargetRefNested<A> editOrNewTargetRefLike(PolicyTargetReference item) {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public TargetRefNested<A> editTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(null));
  }
  
  public TargetRefsNested<A> editTargetRef(int index) {
    if (targetRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public TracingNested<A> editTracing(int index) {
    if (tracing.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tracing"));
    }
    return this.setNewTracingLike(index, this.buildTracing(index));
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
    TelemetryFluent that = (TelemetryFluent) o;
    if (!(Objects.equals(accessLogging, that.accessLogging))) {
      return false;
    }
    if (!(Objects.equals(metrics, that.metrics))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(targetRef, that.targetRef))) {
      return false;
    }
    if (!(Objects.equals(targetRefs, that.targetRefs))) {
      return false;
    }
    if (!(Objects.equals(tracing, that.tracing))) {
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
  
  public boolean hasAccessLogging() {
    return this.accessLogging != null && !(this.accessLogging.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingAccessLogging(Predicate<AccessLoggingBuilder> predicate) {
      for (AccessLoggingBuilder item : accessLogging) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMetric(Predicate<MetricsBuilder> predicate) {
      for (MetricsBuilder item : metrics) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
      for (PolicyTargetReferenceBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTracing(Predicate<TracingBuilder> predicate) {
      for (TracingBuilder item : tracing) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetrics() {
    return this.metrics != null && !(this.metrics.isEmpty());
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTargetRef() {
    return this.targetRef != null;
  }
  
  public boolean hasTargetRefs() {
    return this.targetRefs != null && !(this.targetRefs.isEmpty());
  }
  
  public boolean hasTracing() {
    return this.tracing != null && !(this.tracing.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(accessLogging, metrics, selector, targetRef, targetRefs, tracing, additionalProperties);
  }
  
  public A removeAllFromAccessLogging(Collection<AccessLogging> items) {
    if (this.accessLogging == null) {
      return (A) this;
    }
    for (AccessLogging item : items) {
        AccessLoggingBuilder builder = new AccessLoggingBuilder(item);
        _visitables.get("accessLogging").remove(builder);
        this.accessLogging.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMetrics(Collection<Metrics> items) {
    if (this.metrics == null) {
      return (A) this;
    }
    for (Metrics item : items) {
        MetricsBuilder builder = new MetricsBuilder(item);
        _visitables.get("metrics").remove(builder);
        this.metrics.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetRefs(Collection<PolicyTargetReference> items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTracing(Collection<Tracing> items) {
    if (this.tracing == null) {
      return (A) this;
    }
    for (Tracing item : items) {
        TracingBuilder builder = new TracingBuilder(item);
        _visitables.get("tracing").remove(builder);
        this.tracing.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAccessLogging(AccessLogging... items) {
    if (this.accessLogging == null) {
      return (A) this;
    }
    for (AccessLogging item : items) {
        AccessLoggingBuilder builder = new AccessLoggingBuilder(item);
        _visitables.get("accessLogging").remove(builder);
        this.accessLogging.remove(builder);
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
  
  public A removeFromMetrics(Metrics... items) {
    if (this.metrics == null) {
      return (A) this;
    }
    for (Metrics item : items) {
        MetricsBuilder builder = new MetricsBuilder(item);
        _visitables.get("metrics").remove(builder);
        this.metrics.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTargetRefs(PolicyTargetReference... items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTracing(Tracing... items) {
    if (this.tracing == null) {
      return (A) this;
    }
    for (Tracing item : items) {
        TracingBuilder builder = new TracingBuilder(item);
        _visitables.get("tracing").remove(builder);
        this.tracing.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAccessLogging(Predicate<AccessLoggingBuilder> predicate) {
    if (accessLogging == null) {
      return (A) this;
    }
    Iterator<AccessLoggingBuilder> each = accessLogging.iterator();
    List visitables = _visitables.get("accessLogging");
    while (each.hasNext()) {
        AccessLoggingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMetrics(Predicate<MetricsBuilder> predicate) {
    if (metrics == null) {
      return (A) this;
    }
    Iterator<MetricsBuilder> each = metrics.iterator();
    List visitables = _visitables.get("metrics");
    while (each.hasNext()) {
        MetricsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTargetRefs(Predicate<PolicyTargetReferenceBuilder> predicate) {
    if (targetRefs == null) {
      return (A) this;
    }
    Iterator<PolicyTargetReferenceBuilder> each = targetRefs.iterator();
    List visitables = _visitables.get("targetRefs");
    while (each.hasNext()) {
        PolicyTargetReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTracing(Predicate<TracingBuilder> predicate) {
    if (tracing == null) {
      return (A) this;
    }
    Iterator<TracingBuilder> each = tracing.iterator();
    List visitables = _visitables.get("tracing");
    while (each.hasNext()) {
        TracingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AccessLoggingNested<A> setNewAccessLoggingLike(int index,AccessLogging item) {
    return new AccessLoggingNested(index, item);
  }
  
  public MetricsNested<A> setNewMetricLike(int index,Metrics item) {
    return new MetricsNested(index, item);
  }
  
  public TargetRefsNested<A> setNewTargetRefLike(int index,PolicyTargetReference item) {
    return new TargetRefsNested(index, item);
  }
  
  public TracingNested<A> setNewTracingLike(int index,Tracing item) {
    return new TracingNested(index, item);
  }
  
  public A setToAccessLogging(int index,AccessLogging item) {
    if (this.accessLogging == null) {
      this.accessLogging = new ArrayList();
    }
    AccessLoggingBuilder builder = new AccessLoggingBuilder(item);
    if (index < 0 || index >= accessLogging.size()) {
        _visitables.get("accessLogging").add(builder);
        accessLogging.add(builder);
    } else {
        _visitables.get("accessLogging").add(builder);
        accessLogging.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMetrics(int index,Metrics item) {
    if (this.metrics == null) {
      this.metrics = new ArrayList();
    }
    MetricsBuilder builder = new MetricsBuilder(item);
    if (index < 0 || index >= metrics.size()) {
        _visitables.get("metrics").add(builder);
        metrics.add(builder);
    } else {
        _visitables.get("metrics").add(builder);
        metrics.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTargetRefs(int index,PolicyTargetReference item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTracing(int index,Tracing item) {
    if (this.tracing == null) {
      this.tracing = new ArrayList();
    }
    TracingBuilder builder = new TracingBuilder(item);
    if (index < 0 || index >= tracing.size()) {
        _visitables.get("tracing").add(builder);
        tracing.add(builder);
    } else {
        _visitables.get("tracing").add(builder);
        tracing.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessLogging == null) && !(accessLogging.isEmpty())) {
        sb.append("accessLogging:");
        sb.append(accessLogging);
        sb.append(",");
    }
    if (!(metrics == null) && !(metrics.isEmpty())) {
        sb.append("metrics:");
        sb.append(metrics);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(targetRef == null)) {
        sb.append("targetRef:");
        sb.append(targetRef);
        sb.append(",");
    }
    if (!(targetRefs == null) && !(targetRefs.isEmpty())) {
        sb.append("targetRefs:");
        sb.append(targetRefs);
        sb.append(",");
    }
    if (!(tracing == null) && !(tracing.isEmpty())) {
        sb.append("tracing:");
        sb.append(tracing);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessLogging(List<AccessLogging> accessLogging) {
    if (this.accessLogging != null) {
      this._visitables.get("accessLogging").clear();
    }
    if (accessLogging != null) {
        this.accessLogging = new ArrayList();
        for (AccessLogging item : accessLogging) {
          this.addToAccessLogging(item);
        }
    } else {
      this.accessLogging = null;
    }
    return (A) this;
  }
  
  public A withAccessLogging(AccessLogging... accessLogging) {
    if (this.accessLogging != null) {
        this.accessLogging.clear();
        _visitables.remove("accessLogging");
    }
    if (accessLogging != null) {
      for (AccessLogging item : accessLogging) {
        this.addToAccessLogging(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withMetrics(List<Metrics> metrics) {
    if (this.metrics != null) {
      this._visitables.get("metrics").clear();
    }
    if (metrics != null) {
        this.metrics = new ArrayList();
        for (Metrics item : metrics) {
          this.addToMetrics(item);
        }
    } else {
      this.metrics = null;
    }
    return (A) this;
  }
  
  public A withMetrics(Metrics... metrics) {
    if (this.metrics != null) {
        this.metrics.clear();
        _visitables.remove("metrics");
    }
    if (metrics != null) {
      for (Metrics item : metrics) {
        this.addToMetrics(item);
      }
    }
    return (A) this;
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(WorkloadSelector item) {
    return new SelectorNested(item);
  }
  
  public TargetRefNested<A> withNewTargetRef() {
    return new TargetRefNested(null);
  }
  
  public A withNewTargetRef(String group,String kind,String name,String namespace) {
    return (A) this.withTargetRef(new PolicyTargetReference(group, kind, name, namespace));
  }
  
  public TargetRefNested<A> withNewTargetRefLike(PolicyTargetReference item) {
    return new TargetRefNested(item);
  }
  
  public A withSelector(WorkloadSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new WorkloadSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withTargetRef(PolicyTargetReference targetRef) {
    this._visitables.remove("targetRef");
    if (targetRef != null) {
        this.targetRef = new PolicyTargetReferenceBuilder(targetRef);
        this._visitables.get("targetRef").add(this.targetRef);
    } else {
        this.targetRef = null;
        this._visitables.get("targetRef").remove(this.targetRef);
    }
    return (A) this;
  }
  
  public A withTargetRefs(List<PolicyTargetReference> targetRefs) {
    if (this.targetRefs != null) {
      this._visitables.get("targetRefs").clear();
    }
    if (targetRefs != null) {
        this.targetRefs = new ArrayList();
        for (PolicyTargetReference item : targetRefs) {
          this.addToTargetRefs(item);
        }
    } else {
      this.targetRefs = null;
    }
    return (A) this;
  }
  
  public A withTargetRefs(PolicyTargetReference... targetRefs) {
    if (this.targetRefs != null) {
        this.targetRefs.clear();
        _visitables.remove("targetRefs");
    }
    if (targetRefs != null) {
      for (PolicyTargetReference item : targetRefs) {
        this.addToTargetRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withTracing(List<Tracing> tracing) {
    if (this.tracing != null) {
      this._visitables.get("tracing").clear();
    }
    if (tracing != null) {
        this.tracing = new ArrayList();
        for (Tracing item : tracing) {
          this.addToTracing(item);
        }
    } else {
      this.tracing = null;
    }
    return (A) this;
  }
  
  public A withTracing(Tracing... tracing) {
    if (this.tracing != null) {
        this.tracing.clear();
        _visitables.remove("tracing");
    }
    if (tracing != null) {
      for (Tracing item : tracing) {
        this.addToTracing(item);
      }
    }
    return (A) this;
  }
  public class AccessLoggingNested<N> extends AccessLoggingFluent<AccessLoggingNested<N>> implements Nested<N>{
  
    AccessLoggingBuilder builder;
    int index;
  
    AccessLoggingNested(int index,AccessLogging item) {
      this.index = index;
      this.builder = new AccessLoggingBuilder(this, item);
    }
  
    public N and() {
      return (N) TelemetryFluent.this.setToAccessLogging(index, builder.build());
    }
    
    public N endAccessLogging() {
      return and();
    }
    
  }
  public class MetricsNested<N> extends MetricsFluent<MetricsNested<N>> implements Nested<N>{
  
    MetricsBuilder builder;
    int index;
  
    MetricsNested(int index,Metrics item) {
      this.index = index;
      this.builder = new MetricsBuilder(this, item);
    }
  
    public N and() {
      return (N) TelemetryFluent.this.setToMetrics(index, builder.build());
    }
    
    public N endMetric() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends WorkloadSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    SelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) TelemetryFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TargetRefNested<N> extends PolicyTargetReferenceFluent<TargetRefNested<N>> implements Nested<N>{
  
    PolicyTargetReferenceBuilder builder;
  
    TargetRefNested(PolicyTargetReference item) {
      this.builder = new PolicyTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TelemetryFluent.this.withTargetRef(builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
  public class TargetRefsNested<N> extends PolicyTargetReferenceFluent<TargetRefsNested<N>> implements Nested<N>{
  
    PolicyTargetReferenceBuilder builder;
    int index;
  
    TargetRefsNested(int index,PolicyTargetReference item) {
      this.index = index;
      this.builder = new PolicyTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TelemetryFluent.this.setToTargetRefs(index, builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
  public class TracingNested<N> extends TracingFluent<TracingNested<N>> implements Nested<N>{
  
    TracingBuilder builder;
    int index;
  
    TracingNested(int index,Tracing item) {
      this.index = index;
      this.builder = new TracingBuilder(this, item);
    }
  
    public N and() {
      return (N) TelemetryFluent.this.setToTracing(index, builder.build());
    }
    
    public N endTracing() {
      return and();
    }
    
  }
}