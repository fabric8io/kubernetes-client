package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CompositePodGroupSpecFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha3.CompositePodGroupSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CompositeDisruptionModeBuilder disruptionMode;
  private String parentCompositePodGroupName;
  private String preemptionPolicy;
  private Integer priority;
  private String priorityClassName;
  private CompositePodGroupSchedulingConstraintsBuilder schedulingConstraints;
  private CompositePodGroupSchedulingPolicyBuilder schedulingPolicy;
  private WorkloadReferenceBuilder workloadRef;

  public CompositePodGroupSpecFluent() {
  }
  
  public CompositePodGroupSpecFluent(CompositePodGroupSpec instance) {
    this.copyInstance(instance);
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
  
  public CompositeDisruptionMode buildDisruptionMode() {
    return this.disruptionMode != null ? this.disruptionMode.build() : null;
  }
  
  public CompositePodGroupSchedulingConstraints buildSchedulingConstraints() {
    return this.schedulingConstraints != null ? this.schedulingConstraints.build() : null;
  }
  
  public CompositePodGroupSchedulingPolicy buildSchedulingPolicy() {
    return this.schedulingPolicy != null ? this.schedulingPolicy.build() : null;
  }
  
  public WorkloadReference buildWorkloadRef() {
    return this.workloadRef != null ? this.workloadRef.build() : null;
  }
  
  protected void copyInstance(CompositePodGroupSpec instance) {
    instance = instance != null ? instance : new CompositePodGroupSpec();
    if (instance != null) {
        this.withDisruptionMode(instance.getDisruptionMode());
        this.withParentCompositePodGroupName(instance.getParentCompositePodGroupName());
        this.withPreemptionPolicy(instance.getPreemptionPolicy());
        this.withPriority(instance.getPriority());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withSchedulingConstraints(instance.getSchedulingConstraints());
        this.withSchedulingPolicy(instance.getSchedulingPolicy());
        this.withWorkloadRef(instance.getWorkloadRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DisruptionModeNested<A> editDisruptionMode() {
    return this.withNewDisruptionModeLike(Optional.ofNullable(this.buildDisruptionMode()).orElse(null));
  }
  
  public DisruptionModeNested<A> editOrNewDisruptionMode() {
    return this.withNewDisruptionModeLike(Optional.ofNullable(this.buildDisruptionMode()).orElse(new CompositeDisruptionModeBuilder().build()));
  }
  
  public DisruptionModeNested<A> editOrNewDisruptionModeLike(CompositeDisruptionMode item) {
    return this.withNewDisruptionModeLike(Optional.ofNullable(this.buildDisruptionMode()).orElse(item));
  }
  
  public SchedulingConstraintsNested<A> editOrNewSchedulingConstraints() {
    return this.withNewSchedulingConstraintsLike(Optional.ofNullable(this.buildSchedulingConstraints()).orElse(new CompositePodGroupSchedulingConstraintsBuilder().build()));
  }
  
  public SchedulingConstraintsNested<A> editOrNewSchedulingConstraintsLike(CompositePodGroupSchedulingConstraints item) {
    return this.withNewSchedulingConstraintsLike(Optional.ofNullable(this.buildSchedulingConstraints()).orElse(item));
  }
  
  public SchedulingPolicyNested<A> editOrNewSchedulingPolicy() {
    return this.withNewSchedulingPolicyLike(Optional.ofNullable(this.buildSchedulingPolicy()).orElse(new CompositePodGroupSchedulingPolicyBuilder().build()));
  }
  
  public SchedulingPolicyNested<A> editOrNewSchedulingPolicyLike(CompositePodGroupSchedulingPolicy item) {
    return this.withNewSchedulingPolicyLike(Optional.ofNullable(this.buildSchedulingPolicy()).orElse(item));
  }
  
  public WorkloadRefNested<A> editOrNewWorkloadRef() {
    return this.withNewWorkloadRefLike(Optional.ofNullable(this.buildWorkloadRef()).orElse(new WorkloadReferenceBuilder().build()));
  }
  
  public WorkloadRefNested<A> editOrNewWorkloadRefLike(WorkloadReference item) {
    return this.withNewWorkloadRefLike(Optional.ofNullable(this.buildWorkloadRef()).orElse(item));
  }
  
  public SchedulingConstraintsNested<A> editSchedulingConstraints() {
    return this.withNewSchedulingConstraintsLike(Optional.ofNullable(this.buildSchedulingConstraints()).orElse(null));
  }
  
  public SchedulingPolicyNested<A> editSchedulingPolicy() {
    return this.withNewSchedulingPolicyLike(Optional.ofNullable(this.buildSchedulingPolicy()).orElse(null));
  }
  
  public WorkloadRefNested<A> editWorkloadRef() {
    return this.withNewWorkloadRefLike(Optional.ofNullable(this.buildWorkloadRef()).orElse(null));
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
    CompositePodGroupSpecFluent that = (CompositePodGroupSpecFluent) o;
    if (!(Objects.equals(disruptionMode, that.disruptionMode))) {
      return false;
    }
    if (!(Objects.equals(parentCompositePodGroupName, that.parentCompositePodGroupName))) {
      return false;
    }
    if (!(Objects.equals(preemptionPolicy, that.preemptionPolicy))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(schedulingConstraints, that.schedulingConstraints))) {
      return false;
    }
    if (!(Objects.equals(schedulingPolicy, that.schedulingPolicy))) {
      return false;
    }
    if (!(Objects.equals(workloadRef, that.workloadRef))) {
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
  
  public String getParentCompositePodGroupName() {
    return this.parentCompositePodGroupName;
  }
  
  public String getPreemptionPolicy() {
    return this.preemptionPolicy;
  }
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisruptionMode() {
    return this.disruptionMode != null;
  }
  
  public boolean hasParentCompositePodGroupName() {
    return this.parentCompositePodGroupName != null;
  }
  
  public boolean hasPreemptionPolicy() {
    return this.preemptionPolicy != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasSchedulingConstraints() {
    return this.schedulingConstraints != null;
  }
  
  public boolean hasSchedulingPolicy() {
    return this.schedulingPolicy != null;
  }
  
  public boolean hasWorkloadRef() {
    return this.workloadRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(disruptionMode, parentCompositePodGroupName, preemptionPolicy, priority, priorityClassName, schedulingConstraints, schedulingPolicy, workloadRef, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disruptionMode == null)) {
        sb.append("disruptionMode:");
        sb.append(disruptionMode);
        sb.append(",");
    }
    if (!(parentCompositePodGroupName == null)) {
        sb.append("parentCompositePodGroupName:");
        sb.append(parentCompositePodGroupName);
        sb.append(",");
    }
    if (!(preemptionPolicy == null)) {
        sb.append("preemptionPolicy:");
        sb.append(preemptionPolicy);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(schedulingConstraints == null)) {
        sb.append("schedulingConstraints:");
        sb.append(schedulingConstraints);
        sb.append(",");
    }
    if (!(schedulingPolicy == null)) {
        sb.append("schedulingPolicy:");
        sb.append(schedulingPolicy);
        sb.append(",");
    }
    if (!(workloadRef == null)) {
        sb.append("workloadRef:");
        sb.append(workloadRef);
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
  
  public A withDisruptionMode(CompositeDisruptionMode disruptionMode) {
    this._visitables.remove("disruptionMode");
    if (disruptionMode != null) {
        this.disruptionMode = new CompositeDisruptionModeBuilder(disruptionMode);
        this._visitables.get("disruptionMode").add(this.disruptionMode);
    } else {
        this.disruptionMode = null;
        this._visitables.get("disruptionMode").remove(this.disruptionMode);
    }
    return (A) this;
  }
  
  public DisruptionModeNested<A> withNewDisruptionMode() {
    return new DisruptionModeNested(null);
  }
  
  public DisruptionModeNested<A> withNewDisruptionModeLike(CompositeDisruptionMode item) {
    return new DisruptionModeNested(item);
  }
  
  public SchedulingConstraintsNested<A> withNewSchedulingConstraints() {
    return new SchedulingConstraintsNested(null);
  }
  
  public SchedulingConstraintsNested<A> withNewSchedulingConstraintsLike(CompositePodGroupSchedulingConstraints item) {
    return new SchedulingConstraintsNested(item);
  }
  
  public SchedulingPolicyNested<A> withNewSchedulingPolicy() {
    return new SchedulingPolicyNested(null);
  }
  
  public SchedulingPolicyNested<A> withNewSchedulingPolicyLike(CompositePodGroupSchedulingPolicy item) {
    return new SchedulingPolicyNested(item);
  }
  
  public WorkloadRefNested<A> withNewWorkloadRef() {
    return new WorkloadRefNested(null);
  }
  
  public A withNewWorkloadRef(String templateName,String workloadName) {
    return (A) this.withWorkloadRef(new WorkloadReference(templateName, workloadName));
  }
  
  public WorkloadRefNested<A> withNewWorkloadRefLike(WorkloadReference item) {
    return new WorkloadRefNested(item);
  }
  
  public A withParentCompositePodGroupName(String parentCompositePodGroupName) {
    this.parentCompositePodGroupName = parentCompositePodGroupName;
    return (A) this;
  }
  
  public A withPreemptionPolicy(String preemptionPolicy) {
    this.preemptionPolicy = preemptionPolicy;
    return (A) this;
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withSchedulingConstraints(CompositePodGroupSchedulingConstraints schedulingConstraints) {
    this._visitables.remove("schedulingConstraints");
    if (schedulingConstraints != null) {
        this.schedulingConstraints = new CompositePodGroupSchedulingConstraintsBuilder(schedulingConstraints);
        this._visitables.get("schedulingConstraints").add(this.schedulingConstraints);
    } else {
        this.schedulingConstraints = null;
        this._visitables.get("schedulingConstraints").remove(this.schedulingConstraints);
    }
    return (A) this;
  }
  
  public A withSchedulingPolicy(CompositePodGroupSchedulingPolicy schedulingPolicy) {
    this._visitables.remove("schedulingPolicy");
    if (schedulingPolicy != null) {
        this.schedulingPolicy = new CompositePodGroupSchedulingPolicyBuilder(schedulingPolicy);
        this._visitables.get("schedulingPolicy").add(this.schedulingPolicy);
    } else {
        this.schedulingPolicy = null;
        this._visitables.get("schedulingPolicy").remove(this.schedulingPolicy);
    }
    return (A) this;
  }
  
  public A withWorkloadRef(WorkloadReference workloadRef) {
    this._visitables.remove("workloadRef");
    if (workloadRef != null) {
        this.workloadRef = new WorkloadReferenceBuilder(workloadRef);
        this._visitables.get("workloadRef").add(this.workloadRef);
    } else {
        this.workloadRef = null;
        this._visitables.get("workloadRef").remove(this.workloadRef);
    }
    return (A) this;
  }
  public class DisruptionModeNested<N> extends CompositeDisruptionModeFluent<DisruptionModeNested<N>> implements Nested<N>{
  
    CompositeDisruptionModeBuilder builder;
  
    DisruptionModeNested(CompositeDisruptionMode item) {
      this.builder = new CompositeDisruptionModeBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupSpecFluent.this.withDisruptionMode(builder.build());
    }
    
    public N endDisruptionMode() {
      return and();
    }
    
  }
  public class SchedulingConstraintsNested<N> extends CompositePodGroupSchedulingConstraintsFluent<SchedulingConstraintsNested<N>> implements Nested<N>{
  
    CompositePodGroupSchedulingConstraintsBuilder builder;
  
    SchedulingConstraintsNested(CompositePodGroupSchedulingConstraints item) {
      this.builder = new CompositePodGroupSchedulingConstraintsBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupSpecFluent.this.withSchedulingConstraints(builder.build());
    }
    
    public N endSchedulingConstraints() {
      return and();
    }
    
  }
  public class SchedulingPolicyNested<N> extends CompositePodGroupSchedulingPolicyFluent<SchedulingPolicyNested<N>> implements Nested<N>{
  
    CompositePodGroupSchedulingPolicyBuilder builder;
  
    SchedulingPolicyNested(CompositePodGroupSchedulingPolicy item) {
      this.builder = new CompositePodGroupSchedulingPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupSpecFluent.this.withSchedulingPolicy(builder.build());
    }
    
    public N endSchedulingPolicy() {
      return and();
    }
    
  }
  public class WorkloadRefNested<N> extends WorkloadReferenceFluent<WorkloadRefNested<N>> implements Nested<N>{
  
    WorkloadReferenceBuilder builder;
  
    WorkloadRefNested(WorkloadReference item) {
      this.builder = new WorkloadReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupSpecFluent.this.withWorkloadRef(builder.build());
    }
    
    public N endWorkloadRef() {
      return and();
    }
    
  }
}