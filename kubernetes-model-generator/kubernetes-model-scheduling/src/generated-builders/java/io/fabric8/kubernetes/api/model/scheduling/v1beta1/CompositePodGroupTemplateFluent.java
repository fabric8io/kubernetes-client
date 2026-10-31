package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class CompositePodGroupTemplateFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1beta1.CompositePodGroupTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<CompositePodGroupTemplateBuilder> compositePodGroupTemplates = new ArrayList<CompositePodGroupTemplateBuilder>();
  private CompositeDisruptionModeBuilder disruptionMode;
  private String name;
  private ArrayList<PodGroupTemplateBuilder> podGroupTemplates = new ArrayList<PodGroupTemplateBuilder>();
  private String preemptionPolicy;
  private Integer priority;
  private String priorityClassName;
  private CompositePodGroupSchedulingConstraintsBuilder schedulingConstraints;
  private CompositePodGroupSchedulingPolicyBuilder schedulingPolicy;

  public CompositePodGroupTemplateFluent() {
  }
  
  public CompositePodGroupTemplateFluent(CompositePodGroupTemplate instance) {
    this.copyInstance(instance);
  }

  public A addAllToCompositePodGroupTemplates(Collection<CompositePodGroupTemplate> items) {
    if (this.compositePodGroupTemplates == null) {
      this.compositePodGroupTemplates = new ArrayList();
    }
    for (CompositePodGroupTemplate item : items) {
        CompositePodGroupTemplateBuilder builder = new CompositePodGroupTemplateBuilder(item);
        _visitables.get("compositePodGroupTemplates").add(builder);
        this.compositePodGroupTemplates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPodGroupTemplates(Collection<PodGroupTemplate> items) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").add(builder);
        this.podGroupTemplates.add(builder);
    }
    return (A) this;
  }
  
  public CompositePodGroupTemplatesNested<A> addNewCompositePodGroupTemplate() {
    return new CompositePodGroupTemplatesNested(-1, null);
  }
  
  public CompositePodGroupTemplatesNested<A> addNewCompositePodGroupTemplateLike(CompositePodGroupTemplate item) {
    return new CompositePodGroupTemplatesNested(-1, item);
  }
  
  public PodGroupTemplatesNested<A> addNewPodGroupTemplate() {
    return new PodGroupTemplatesNested(-1, null);
  }
  
  public PodGroupTemplatesNested<A> addNewPodGroupTemplateLike(PodGroupTemplate item) {
    return new PodGroupTemplatesNested(-1, item);
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
  
  public A addToCompositePodGroupTemplates(CompositePodGroupTemplate... items) {
    if (this.compositePodGroupTemplates == null) {
      this.compositePodGroupTemplates = new ArrayList();
    }
    for (CompositePodGroupTemplate item : items) {
        CompositePodGroupTemplateBuilder builder = new CompositePodGroupTemplateBuilder(item);
        _visitables.get("compositePodGroupTemplates").add(builder);
        this.compositePodGroupTemplates.add(builder);
    }
    return (A) this;
  }
  
  public A addToCompositePodGroupTemplates(int index,CompositePodGroupTemplate item) {
    if (this.compositePodGroupTemplates == null) {
      this.compositePodGroupTemplates = new ArrayList();
    }
    CompositePodGroupTemplateBuilder builder = new CompositePodGroupTemplateBuilder(item);
    if (index < 0 || index >= compositePodGroupTemplates.size()) {
        _visitables.get("compositePodGroupTemplates").add(builder);
        compositePodGroupTemplates.add(builder);
    } else {
        _visitables.get("compositePodGroupTemplates").add(builder);
        compositePodGroupTemplates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPodGroupTemplates(PodGroupTemplate... items) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").add(builder);
        this.podGroupTemplates.add(builder);
    }
    return (A) this;
  }
  
  public A addToPodGroupTemplates(int index,PodGroupTemplate item) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
    if (index < 0 || index >= podGroupTemplates.size()) {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.add(builder);
    } else {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.add(index, builder);
    }
    return (A) this;
  }
  
  public CompositePodGroupTemplate buildCompositePodGroupTemplate(int index) {
    return this.compositePodGroupTemplates.get(index).build();
  }
  
  public List<CompositePodGroupTemplate> buildCompositePodGroupTemplates() {
    return this.compositePodGroupTemplates != null ? build(compositePodGroupTemplates) : null;
  }
  
  public CompositeDisruptionMode buildDisruptionMode() {
    return this.disruptionMode != null ? this.disruptionMode.build() : null;
  }
  
  public CompositePodGroupTemplate buildFirstCompositePodGroupTemplate() {
    return this.compositePodGroupTemplates.get(0).build();
  }
  
  public PodGroupTemplate buildFirstPodGroupTemplate() {
    return this.podGroupTemplates.get(0).build();
  }
  
  public CompositePodGroupTemplate buildLastCompositePodGroupTemplate() {
    return this.compositePodGroupTemplates.get(compositePodGroupTemplates.size() - 1).build();
  }
  
  public PodGroupTemplate buildLastPodGroupTemplate() {
    return this.podGroupTemplates.get(podGroupTemplates.size() - 1).build();
  }
  
  public CompositePodGroupTemplate buildMatchingCompositePodGroupTemplate(Predicate<CompositePodGroupTemplateBuilder> predicate) {
      for (CompositePodGroupTemplateBuilder item : compositePodGroupTemplates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodGroupTemplate buildMatchingPodGroupTemplate(Predicate<PodGroupTemplateBuilder> predicate) {
      for (PodGroupTemplateBuilder item : podGroupTemplates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodGroupTemplate buildPodGroupTemplate(int index) {
    return this.podGroupTemplates.get(index).build();
  }
  
  public List<PodGroupTemplate> buildPodGroupTemplates() {
    return this.podGroupTemplates != null ? build(podGroupTemplates) : null;
  }
  
  public CompositePodGroupSchedulingConstraints buildSchedulingConstraints() {
    return this.schedulingConstraints != null ? this.schedulingConstraints.build() : null;
  }
  
  public CompositePodGroupSchedulingPolicy buildSchedulingPolicy() {
    return this.schedulingPolicy != null ? this.schedulingPolicy.build() : null;
  }
  
  protected void copyInstance(CompositePodGroupTemplate instance) {
    instance = instance != null ? instance : new CompositePodGroupTemplate();
    if (instance != null) {
        this.withCompositePodGroupTemplates(instance.getCompositePodGroupTemplates());
        this.withDisruptionMode(instance.getDisruptionMode());
        this.withName(instance.getName());
        this.withPodGroupTemplates(instance.getPodGroupTemplates());
        this.withPreemptionPolicy(instance.getPreemptionPolicy());
        this.withPriority(instance.getPriority());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withSchedulingConstraints(instance.getSchedulingConstraints());
        this.withSchedulingPolicy(instance.getSchedulingPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CompositePodGroupTemplatesNested<A> editCompositePodGroupTemplate(int index) {
    if (compositePodGroupTemplates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "compositePodGroupTemplates"));
    }
    return this.setNewCompositePodGroupTemplateLike(index, this.buildCompositePodGroupTemplate(index));
  }
  
  public DisruptionModeNested<A> editDisruptionMode() {
    return this.withNewDisruptionModeLike(Optional.ofNullable(this.buildDisruptionMode()).orElse(null));
  }
  
  public CompositePodGroupTemplatesNested<A> editFirstCompositePodGroupTemplate() {
    if (compositePodGroupTemplates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "compositePodGroupTemplates"));
    }
    return this.setNewCompositePodGroupTemplateLike(0, this.buildCompositePodGroupTemplate(0));
  }
  
  public PodGroupTemplatesNested<A> editFirstPodGroupTemplate() {
    if (podGroupTemplates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(0, this.buildPodGroupTemplate(0));
  }
  
  public CompositePodGroupTemplatesNested<A> editLastCompositePodGroupTemplate() {
    int index = compositePodGroupTemplates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "compositePodGroupTemplates"));
    }
    return this.setNewCompositePodGroupTemplateLike(index, this.buildCompositePodGroupTemplate(index));
  }
  
  public PodGroupTemplatesNested<A> editLastPodGroupTemplate() {
    int index = podGroupTemplates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(index, this.buildPodGroupTemplate(index));
  }
  
  public CompositePodGroupTemplatesNested<A> editMatchingCompositePodGroupTemplate(Predicate<CompositePodGroupTemplateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < compositePodGroupTemplates.size();i++) {
      if (predicate.test(compositePodGroupTemplates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "compositePodGroupTemplates"));
    }
    return this.setNewCompositePodGroupTemplateLike(index, this.buildCompositePodGroupTemplate(index));
  }
  
  public PodGroupTemplatesNested<A> editMatchingPodGroupTemplate(Predicate<PodGroupTemplateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < podGroupTemplates.size();i++) {
      if (predicate.test(podGroupTemplates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(index, this.buildPodGroupTemplate(index));
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
  
  public PodGroupTemplatesNested<A> editPodGroupTemplate(int index) {
    if (podGroupTemplates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(index, this.buildPodGroupTemplate(index));
  }
  
  public SchedulingConstraintsNested<A> editSchedulingConstraints() {
    return this.withNewSchedulingConstraintsLike(Optional.ofNullable(this.buildSchedulingConstraints()).orElse(null));
  }
  
  public SchedulingPolicyNested<A> editSchedulingPolicy() {
    return this.withNewSchedulingPolicyLike(Optional.ofNullable(this.buildSchedulingPolicy()).orElse(null));
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
    CompositePodGroupTemplateFluent that = (CompositePodGroupTemplateFluent) o;
    if (!(Objects.equals(compositePodGroupTemplates, that.compositePodGroupTemplates))) {
      return false;
    }
    if (!(Objects.equals(disruptionMode, that.disruptionMode))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(podGroupTemplates, that.podGroupTemplates))) {
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
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getName() {
    return this.name;
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
  
  public boolean hasCompositePodGroupTemplates() {
    return this.compositePodGroupTemplates != null && !(this.compositePodGroupTemplates.isEmpty());
  }
  
  public boolean hasDisruptionMode() {
    return this.disruptionMode != null;
  }
  
  public boolean hasMatchingCompositePodGroupTemplate(Predicate<CompositePodGroupTemplateBuilder> predicate) {
      for (CompositePodGroupTemplateBuilder item : compositePodGroupTemplates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPodGroupTemplate(Predicate<PodGroupTemplateBuilder> predicate) {
      for (PodGroupTemplateBuilder item : podGroupTemplates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPodGroupTemplates() {
    return this.podGroupTemplates != null && !(this.podGroupTemplates.isEmpty());
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
  
  public int hashCode() {
    return Objects.hash(compositePodGroupTemplates, disruptionMode, name, podGroupTemplates, preemptionPolicy, priority, priorityClassName, schedulingConstraints, schedulingPolicy, additionalProperties);
  }
  
  public A removeAllFromCompositePodGroupTemplates(Collection<CompositePodGroupTemplate> items) {
    if (this.compositePodGroupTemplates == null) {
      return (A) this;
    }
    for (CompositePodGroupTemplate item : items) {
        CompositePodGroupTemplateBuilder builder = new CompositePodGroupTemplateBuilder(item);
        _visitables.get("compositePodGroupTemplates").remove(builder);
        this.compositePodGroupTemplates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPodGroupTemplates(Collection<PodGroupTemplate> items) {
    if (this.podGroupTemplates == null) {
      return (A) this;
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").remove(builder);
        this.podGroupTemplates.remove(builder);
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
  
  public A removeFromCompositePodGroupTemplates(CompositePodGroupTemplate... items) {
    if (this.compositePodGroupTemplates == null) {
      return (A) this;
    }
    for (CompositePodGroupTemplate item : items) {
        CompositePodGroupTemplateBuilder builder = new CompositePodGroupTemplateBuilder(item);
        _visitables.get("compositePodGroupTemplates").remove(builder);
        this.compositePodGroupTemplates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPodGroupTemplates(PodGroupTemplate... items) {
    if (this.podGroupTemplates == null) {
      return (A) this;
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").remove(builder);
        this.podGroupTemplates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCompositePodGroupTemplates(Predicate<CompositePodGroupTemplateBuilder> predicate) {
    if (compositePodGroupTemplates == null) {
      return (A) this;
    }
    Iterator<CompositePodGroupTemplateBuilder> each = compositePodGroupTemplates.iterator();
    List visitables = _visitables.get("compositePodGroupTemplates");
    while (each.hasNext()) {
        CompositePodGroupTemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPodGroupTemplates(Predicate<PodGroupTemplateBuilder> predicate) {
    if (podGroupTemplates == null) {
      return (A) this;
    }
    Iterator<PodGroupTemplateBuilder> each = podGroupTemplates.iterator();
    List visitables = _visitables.get("podGroupTemplates");
    while (each.hasNext()) {
        PodGroupTemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CompositePodGroupTemplatesNested<A> setNewCompositePodGroupTemplateLike(int index,CompositePodGroupTemplate item) {
    return new CompositePodGroupTemplatesNested(index, item);
  }
  
  public PodGroupTemplatesNested<A> setNewPodGroupTemplateLike(int index,PodGroupTemplate item) {
    return new PodGroupTemplatesNested(index, item);
  }
  
  public A setToCompositePodGroupTemplates(int index,CompositePodGroupTemplate item) {
    if (this.compositePodGroupTemplates == null) {
      this.compositePodGroupTemplates = new ArrayList();
    }
    CompositePodGroupTemplateBuilder builder = new CompositePodGroupTemplateBuilder(item);
    if (index < 0 || index >= compositePodGroupTemplates.size()) {
        _visitables.get("compositePodGroupTemplates").add(builder);
        compositePodGroupTemplates.add(builder);
    } else {
        _visitables.get("compositePodGroupTemplates").add(builder);
        compositePodGroupTemplates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPodGroupTemplates(int index,PodGroupTemplate item) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
    if (index < 0 || index >= podGroupTemplates.size()) {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.add(builder);
    } else {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(compositePodGroupTemplates == null) && !(compositePodGroupTemplates.isEmpty())) {
        sb.append("compositePodGroupTemplates:");
        sb.append(compositePodGroupTemplates);
        sb.append(",");
    }
    if (!(disruptionMode == null)) {
        sb.append("disruptionMode:");
        sb.append(disruptionMode);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(podGroupTemplates == null) && !(podGroupTemplates.isEmpty())) {
        sb.append("podGroupTemplates:");
        sb.append(podGroupTemplates);
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
  
  public A withCompositePodGroupTemplates(List<CompositePodGroupTemplate> compositePodGroupTemplates) {
    if (this.compositePodGroupTemplates != null) {
      this._visitables.get("compositePodGroupTemplates").clear();
    }
    if (compositePodGroupTemplates != null) {
        this.compositePodGroupTemplates = new ArrayList();
        for (CompositePodGroupTemplate item : compositePodGroupTemplates) {
          this.addToCompositePodGroupTemplates(item);
        }
    } else {
      this.compositePodGroupTemplates = null;
    }
    return (A) this;
  }
  
  public A withCompositePodGroupTemplates(CompositePodGroupTemplate... compositePodGroupTemplates) {
    if (this.compositePodGroupTemplates != null) {
        this.compositePodGroupTemplates.clear();
        _visitables.remove("compositePodGroupTemplates");
    }
    if (compositePodGroupTemplates != null) {
      for (CompositePodGroupTemplate item : compositePodGroupTemplates) {
        this.addToCompositePodGroupTemplates(item);
      }
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
  
  public A withName(String name) {
    this.name = name;
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
  
  public A withPodGroupTemplates(List<PodGroupTemplate> podGroupTemplates) {
    if (this.podGroupTemplates != null) {
      this._visitables.get("podGroupTemplates").clear();
    }
    if (podGroupTemplates != null) {
        this.podGroupTemplates = new ArrayList();
        for (PodGroupTemplate item : podGroupTemplates) {
          this.addToPodGroupTemplates(item);
        }
    } else {
      this.podGroupTemplates = null;
    }
    return (A) this;
  }
  
  public A withPodGroupTemplates(PodGroupTemplate... podGroupTemplates) {
    if (this.podGroupTemplates != null) {
        this.podGroupTemplates.clear();
        _visitables.remove("podGroupTemplates");
    }
    if (podGroupTemplates != null) {
      for (PodGroupTemplate item : podGroupTemplates) {
        this.addToPodGroupTemplates(item);
      }
    }
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
  public class CompositePodGroupTemplatesNested<N> extends CompositePodGroupTemplateFluent<CompositePodGroupTemplatesNested<N>> implements Nested<N>{
  
    CompositePodGroupTemplateBuilder builder;
    int index;
  
    CompositePodGroupTemplatesNested(int index,CompositePodGroupTemplate item) {
      this.index = index;
      this.builder = new CompositePodGroupTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupTemplateFluent.this.setToCompositePodGroupTemplates(index, builder.build());
    }
    
    public N endCompositePodGroupTemplate() {
      return and();
    }
    
  }
  public class DisruptionModeNested<N> extends CompositeDisruptionModeFluent<DisruptionModeNested<N>> implements Nested<N>{
  
    CompositeDisruptionModeBuilder builder;
  
    DisruptionModeNested(CompositeDisruptionMode item) {
      this.builder = new CompositeDisruptionModeBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupTemplateFluent.this.withDisruptionMode(builder.build());
    }
    
    public N endDisruptionMode() {
      return and();
    }
    
  }
  public class PodGroupTemplatesNested<N> extends PodGroupTemplateFluent<PodGroupTemplatesNested<N>> implements Nested<N>{
  
    PodGroupTemplateBuilder builder;
    int index;
  
    PodGroupTemplatesNested(int index,PodGroupTemplate item) {
      this.index = index;
      this.builder = new PodGroupTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupTemplateFluent.this.setToPodGroupTemplates(index, builder.build());
    }
    
    public N endPodGroupTemplate() {
      return and();
    }
    
  }
  public class SchedulingConstraintsNested<N> extends CompositePodGroupSchedulingConstraintsFluent<SchedulingConstraintsNested<N>> implements Nested<N>{
  
    CompositePodGroupSchedulingConstraintsBuilder builder;
  
    SchedulingConstraintsNested(CompositePodGroupSchedulingConstraints item) {
      this.builder = new CompositePodGroupSchedulingConstraintsBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupTemplateFluent.this.withSchedulingConstraints(builder.build());
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
      return (N) CompositePodGroupTemplateFluent.this.withSchedulingPolicy(builder.build());
    }
    
    public N endSchedulingPolicy() {
      return and();
    }
    
  }
}