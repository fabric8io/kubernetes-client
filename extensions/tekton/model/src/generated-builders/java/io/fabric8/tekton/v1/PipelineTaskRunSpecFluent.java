package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import io.fabric8.tekton.pod.Template;
import io.fabric8.tekton.pod.TemplateBuilder;
import io.fabric8.tekton.pod.TemplateFluent;
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
public class PipelineTaskRunSpecFluent<A extends io.fabric8.tekton.v1.PipelineTaskRunSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ResourceRequirementsBuilder computeResources;
  private PipelineTaskMetadataBuilder metadata;
  private String pipelineTaskName;
  private TemplateBuilder podTemplate;
  private String serviceAccountName;
  private ArrayList<TaskRunSidecarSpecBuilder> sidecarSpecs = new ArrayList<TaskRunSidecarSpecBuilder>();
  private ArrayList<TaskRunStepSpecBuilder> stepSpecs = new ArrayList<TaskRunStepSpecBuilder>();
  private Duration timeout;

  public PipelineTaskRunSpecFluent() {
  }
  
  public PipelineTaskRunSpecFluent(PipelineTaskRunSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSidecarSpecs(Collection<TaskRunSidecarSpec> items) {
    if (this.sidecarSpecs == null) {
      this.sidecarSpecs = new ArrayList();
    }
    for (TaskRunSidecarSpec item : items) {
        TaskRunSidecarSpecBuilder builder = new TaskRunSidecarSpecBuilder(item);
        _visitables.get("sidecarSpecs").add(builder);
        this.sidecarSpecs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStepSpecs(Collection<TaskRunStepSpec> items) {
    if (this.stepSpecs == null) {
      this.stepSpecs = new ArrayList();
    }
    for (TaskRunStepSpec item : items) {
        TaskRunStepSpecBuilder builder = new TaskRunStepSpecBuilder(item);
        _visitables.get("stepSpecs").add(builder);
        this.stepSpecs.add(builder);
    }
    return (A) this;
  }
  
  public SidecarSpecsNested<A> addNewSidecarSpec() {
    return new SidecarSpecsNested(-1, null);
  }
  
  public SidecarSpecsNested<A> addNewSidecarSpecLike(TaskRunSidecarSpec item) {
    return new SidecarSpecsNested(-1, item);
  }
  
  public StepSpecsNested<A> addNewStepSpec() {
    return new StepSpecsNested(-1, null);
  }
  
  public StepSpecsNested<A> addNewStepSpecLike(TaskRunStepSpec item) {
    return new StepSpecsNested(-1, item);
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
  
  public A addToSidecarSpecs(TaskRunSidecarSpec... items) {
    if (this.sidecarSpecs == null) {
      this.sidecarSpecs = new ArrayList();
    }
    for (TaskRunSidecarSpec item : items) {
        TaskRunSidecarSpecBuilder builder = new TaskRunSidecarSpecBuilder(item);
        _visitables.get("sidecarSpecs").add(builder);
        this.sidecarSpecs.add(builder);
    }
    return (A) this;
  }
  
  public A addToSidecarSpecs(int index,TaskRunSidecarSpec item) {
    if (this.sidecarSpecs == null) {
      this.sidecarSpecs = new ArrayList();
    }
    TaskRunSidecarSpecBuilder builder = new TaskRunSidecarSpecBuilder(item);
    if (index < 0 || index >= sidecarSpecs.size()) {
        _visitables.get("sidecarSpecs").add(builder);
        sidecarSpecs.add(builder);
    } else {
        _visitables.get("sidecarSpecs").add(builder);
        sidecarSpecs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStepSpecs(TaskRunStepSpec... items) {
    if (this.stepSpecs == null) {
      this.stepSpecs = new ArrayList();
    }
    for (TaskRunStepSpec item : items) {
        TaskRunStepSpecBuilder builder = new TaskRunStepSpecBuilder(item);
        _visitables.get("stepSpecs").add(builder);
        this.stepSpecs.add(builder);
    }
    return (A) this;
  }
  
  public A addToStepSpecs(int index,TaskRunStepSpec item) {
    if (this.stepSpecs == null) {
      this.stepSpecs = new ArrayList();
    }
    TaskRunStepSpecBuilder builder = new TaskRunStepSpecBuilder(item);
    if (index < 0 || index >= stepSpecs.size()) {
        _visitables.get("stepSpecs").add(builder);
        stepSpecs.add(builder);
    } else {
        _visitables.get("stepSpecs").add(builder);
        stepSpecs.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceRequirements buildComputeResources() {
    return this.computeResources != null ? this.computeResources.build() : null;
  }
  
  public TaskRunSidecarSpec buildFirstSidecarSpec() {
    return this.sidecarSpecs.get(0).build();
  }
  
  public TaskRunStepSpec buildFirstStepSpec() {
    return this.stepSpecs.get(0).build();
  }
  
  public TaskRunSidecarSpec buildLastSidecarSpec() {
    return this.sidecarSpecs.get(sidecarSpecs.size() - 1).build();
  }
  
  public TaskRunStepSpec buildLastStepSpec() {
    return this.stepSpecs.get(stepSpecs.size() - 1).build();
  }
  
  public TaskRunSidecarSpec buildMatchingSidecarSpec(Predicate<TaskRunSidecarSpecBuilder> predicate) {
      for (TaskRunSidecarSpecBuilder item : sidecarSpecs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskRunStepSpec buildMatchingStepSpec(Predicate<TaskRunStepSpecBuilder> predicate) {
      for (TaskRunStepSpecBuilder item : stepSpecs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineTaskMetadata buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public Template buildPodTemplate() {
    return this.podTemplate != null ? this.podTemplate.build() : null;
  }
  
  public TaskRunSidecarSpec buildSidecarSpec(int index) {
    return this.sidecarSpecs.get(index).build();
  }
  
  public List<TaskRunSidecarSpec> buildSidecarSpecs() {
    return this.sidecarSpecs != null ? build(sidecarSpecs) : null;
  }
  
  public TaskRunStepSpec buildStepSpec(int index) {
    return this.stepSpecs.get(index).build();
  }
  
  public List<TaskRunStepSpec> buildStepSpecs() {
    return this.stepSpecs != null ? build(stepSpecs) : null;
  }
  
  protected void copyInstance(PipelineTaskRunSpec instance) {
    instance = instance != null ? instance : new PipelineTaskRunSpec();
    if (instance != null) {
        this.withComputeResources(instance.getComputeResources());
        this.withMetadata(instance.getMetadata());
        this.withPipelineTaskName(instance.getPipelineTaskName());
        this.withPodTemplate(instance.getPodTemplate());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSidecarSpecs(instance.getSidecarSpecs());
        this.withStepSpecs(instance.getStepSpecs());
        this.withTimeout(instance.getTimeout());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComputeResourcesNested<A> editComputeResources() {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(null));
  }
  
  public SidecarSpecsNested<A> editFirstSidecarSpec() {
    if (sidecarSpecs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sidecarSpecs"));
    }
    return this.setNewSidecarSpecLike(0, this.buildSidecarSpec(0));
  }
  
  public StepSpecsNested<A> editFirstStepSpec() {
    if (stepSpecs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "stepSpecs"));
    }
    return this.setNewStepSpecLike(0, this.buildStepSpec(0));
  }
  
  public SidecarSpecsNested<A> editLastSidecarSpec() {
    int index = sidecarSpecs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sidecarSpecs"));
    }
    return this.setNewSidecarSpecLike(index, this.buildSidecarSpec(index));
  }
  
  public StepSpecsNested<A> editLastStepSpec() {
    int index = stepSpecs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "stepSpecs"));
    }
    return this.setNewStepSpecLike(index, this.buildStepSpec(index));
  }
  
  public SidecarSpecsNested<A> editMatchingSidecarSpec(Predicate<TaskRunSidecarSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sidecarSpecs.size();i++) {
      if (predicate.test(sidecarSpecs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sidecarSpecs"));
    }
    return this.setNewSidecarSpecLike(index, this.buildSidecarSpec(index));
  }
  
  public StepSpecsNested<A> editMatchingStepSpec(Predicate<TaskRunStepSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < stepSpecs.size();i++) {
      if (predicate.test(stepSpecs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "stepSpecs"));
    }
    return this.setNewStepSpecLike(index, this.buildStepSpec(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public ComputeResourcesNested<A> editOrNewComputeResources() {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ComputeResourcesNested<A> editOrNewComputeResourcesLike(ResourceRequirements item) {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new PipelineTaskMetadataBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(PipelineTaskMetadata item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(new TemplateBuilder().build()));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplateLike(Template item) {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(item));
  }
  
  public PodTemplateNested<A> editPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(null));
  }
  
  public SidecarSpecsNested<A> editSidecarSpec(int index) {
    if (sidecarSpecs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sidecarSpecs"));
    }
    return this.setNewSidecarSpecLike(index, this.buildSidecarSpec(index));
  }
  
  public StepSpecsNested<A> editStepSpec(int index) {
    if (stepSpecs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "stepSpecs"));
    }
    return this.setNewStepSpecLike(index, this.buildStepSpec(index));
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
    PipelineTaskRunSpecFluent that = (PipelineTaskRunSpecFluent) o;
    if (!(Objects.equals(computeResources, that.computeResources))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(pipelineTaskName, that.pipelineTaskName))) {
      return false;
    }
    if (!(Objects.equals(podTemplate, that.podTemplate))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(sidecarSpecs, that.sidecarSpecs))) {
      return false;
    }
    if (!(Objects.equals(stepSpecs, that.stepSpecs))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
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
  
  public String getPipelineTaskName() {
    return this.pipelineTaskName;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public Duration getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComputeResources() {
    return this.computeResources != null;
  }
  
  public boolean hasMatchingSidecarSpec(Predicate<TaskRunSidecarSpecBuilder> predicate) {
      for (TaskRunSidecarSpecBuilder item : sidecarSpecs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStepSpec(Predicate<TaskRunStepSpecBuilder> predicate) {
      for (TaskRunStepSpecBuilder item : stepSpecs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasPipelineTaskName() {
    return this.pipelineTaskName != null;
  }
  
  public boolean hasPodTemplate() {
    return this.podTemplate != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSidecarSpecs() {
    return this.sidecarSpecs != null && !(this.sidecarSpecs.isEmpty());
  }
  
  public boolean hasStepSpecs() {
    return this.stepSpecs != null && !(this.stepSpecs.isEmpty());
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(computeResources, metadata, pipelineTaskName, podTemplate, serviceAccountName, sidecarSpecs, stepSpecs, timeout, additionalProperties);
  }
  
  public A removeAllFromSidecarSpecs(Collection<TaskRunSidecarSpec> items) {
    if (this.sidecarSpecs == null) {
      return (A) this;
    }
    for (TaskRunSidecarSpec item : items) {
        TaskRunSidecarSpecBuilder builder = new TaskRunSidecarSpecBuilder(item);
        _visitables.get("sidecarSpecs").remove(builder);
        this.sidecarSpecs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStepSpecs(Collection<TaskRunStepSpec> items) {
    if (this.stepSpecs == null) {
      return (A) this;
    }
    for (TaskRunStepSpec item : items) {
        TaskRunStepSpecBuilder builder = new TaskRunStepSpecBuilder(item);
        _visitables.get("stepSpecs").remove(builder);
        this.stepSpecs.remove(builder);
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
  
  public A removeFromSidecarSpecs(TaskRunSidecarSpec... items) {
    if (this.sidecarSpecs == null) {
      return (A) this;
    }
    for (TaskRunSidecarSpec item : items) {
        TaskRunSidecarSpecBuilder builder = new TaskRunSidecarSpecBuilder(item);
        _visitables.get("sidecarSpecs").remove(builder);
        this.sidecarSpecs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStepSpecs(TaskRunStepSpec... items) {
    if (this.stepSpecs == null) {
      return (A) this;
    }
    for (TaskRunStepSpec item : items) {
        TaskRunStepSpecBuilder builder = new TaskRunStepSpecBuilder(item);
        _visitables.get("stepSpecs").remove(builder);
        this.stepSpecs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSidecarSpecs(Predicate<TaskRunSidecarSpecBuilder> predicate) {
    if (sidecarSpecs == null) {
      return (A) this;
    }
    Iterator<TaskRunSidecarSpecBuilder> each = sidecarSpecs.iterator();
    List visitables = _visitables.get("sidecarSpecs");
    while (each.hasNext()) {
        TaskRunSidecarSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStepSpecs(Predicate<TaskRunStepSpecBuilder> predicate) {
    if (stepSpecs == null) {
      return (A) this;
    }
    Iterator<TaskRunStepSpecBuilder> each = stepSpecs.iterator();
    List visitables = _visitables.get("stepSpecs");
    while (each.hasNext()) {
        TaskRunStepSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SidecarSpecsNested<A> setNewSidecarSpecLike(int index,TaskRunSidecarSpec item) {
    return new SidecarSpecsNested(index, item);
  }
  
  public StepSpecsNested<A> setNewStepSpecLike(int index,TaskRunStepSpec item) {
    return new StepSpecsNested(index, item);
  }
  
  public A setToSidecarSpecs(int index,TaskRunSidecarSpec item) {
    if (this.sidecarSpecs == null) {
      this.sidecarSpecs = new ArrayList();
    }
    TaskRunSidecarSpecBuilder builder = new TaskRunSidecarSpecBuilder(item);
    if (index < 0 || index >= sidecarSpecs.size()) {
        _visitables.get("sidecarSpecs").add(builder);
        sidecarSpecs.add(builder);
    } else {
        _visitables.get("sidecarSpecs").add(builder);
        sidecarSpecs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStepSpecs(int index,TaskRunStepSpec item) {
    if (this.stepSpecs == null) {
      this.stepSpecs = new ArrayList();
    }
    TaskRunStepSpecBuilder builder = new TaskRunStepSpecBuilder(item);
    if (index < 0 || index >= stepSpecs.size()) {
        _visitables.get("stepSpecs").add(builder);
        stepSpecs.add(builder);
    } else {
        _visitables.get("stepSpecs").add(builder);
        stepSpecs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(computeResources == null)) {
        sb.append("computeResources:");
        sb.append(computeResources);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(pipelineTaskName == null)) {
        sb.append("pipelineTaskName:");
        sb.append(pipelineTaskName);
        sb.append(",");
    }
    if (!(podTemplate == null)) {
        sb.append("podTemplate:");
        sb.append(podTemplate);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(sidecarSpecs == null) && !(sidecarSpecs.isEmpty())) {
        sb.append("sidecarSpecs:");
        sb.append(sidecarSpecs);
        sb.append(",");
    }
    if (!(stepSpecs == null) && !(stepSpecs.isEmpty())) {
        sb.append("stepSpecs:");
        sb.append(stepSpecs);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
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
  
  public A withComputeResources(ResourceRequirements computeResources) {
    this._visitables.remove("computeResources");
    if (computeResources != null) {
        this.computeResources = new ResourceRequirementsBuilder(computeResources);
        this._visitables.get("computeResources").add(this.computeResources);
    } else {
        this.computeResources = null;
        this._visitables.get("computeResources").remove(this.computeResources);
    }
    return (A) this;
  }
  
  public A withMetadata(PipelineTaskMetadata metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new PipelineTaskMetadataBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public ComputeResourcesNested<A> withNewComputeResources() {
    return new ComputeResourcesNested(null);
  }
  
  public ComputeResourcesNested<A> withNewComputeResourcesLike(ResourceRequirements item) {
    return new ComputeResourcesNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(PipelineTaskMetadata item) {
    return new MetadataNested(item);
  }
  
  public PodTemplateNested<A> withNewPodTemplate() {
    return new PodTemplateNested(null);
  }
  
  public PodTemplateNested<A> withNewPodTemplateLike(Template item) {
    return new PodTemplateNested(item);
  }
  
  public A withPipelineTaskName(String pipelineTaskName) {
    this.pipelineTaskName = pipelineTaskName;
    return (A) this;
  }
  
  public A withPodTemplate(Template podTemplate) {
    this._visitables.remove("podTemplate");
    if (podTemplate != null) {
        this.podTemplate = new TemplateBuilder(podTemplate);
        this._visitables.get("podTemplate").add(this.podTemplate);
    } else {
        this.podTemplate = null;
        this._visitables.get("podTemplate").remove(this.podTemplate);
    }
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withSidecarSpecs(List<TaskRunSidecarSpec> sidecarSpecs) {
    if (this.sidecarSpecs != null) {
      this._visitables.get("sidecarSpecs").clear();
    }
    if (sidecarSpecs != null) {
        this.sidecarSpecs = new ArrayList();
        for (TaskRunSidecarSpec item : sidecarSpecs) {
          this.addToSidecarSpecs(item);
        }
    } else {
      this.sidecarSpecs = null;
    }
    return (A) this;
  }
  
  public A withSidecarSpecs(TaskRunSidecarSpec... sidecarSpecs) {
    if (this.sidecarSpecs != null) {
        this.sidecarSpecs.clear();
        _visitables.remove("sidecarSpecs");
    }
    if (sidecarSpecs != null) {
      for (TaskRunSidecarSpec item : sidecarSpecs) {
        this.addToSidecarSpecs(item);
      }
    }
    return (A) this;
  }
  
  public A withStepSpecs(List<TaskRunStepSpec> stepSpecs) {
    if (this.stepSpecs != null) {
      this._visitables.get("stepSpecs").clear();
    }
    if (stepSpecs != null) {
        this.stepSpecs = new ArrayList();
        for (TaskRunStepSpec item : stepSpecs) {
          this.addToStepSpecs(item);
        }
    } else {
      this.stepSpecs = null;
    }
    return (A) this;
  }
  
  public A withStepSpecs(TaskRunStepSpec... stepSpecs) {
    if (this.stepSpecs != null) {
        this.stepSpecs.clear();
        _visitables.remove("stepSpecs");
    }
    if (stepSpecs != null) {
      for (TaskRunStepSpec item : stepSpecs) {
        this.addToStepSpecs(item);
      }
    }
    return (A) this;
  }
  
  public A withTimeout(Duration timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  public class ComputeResourcesNested<N> extends ResourceRequirementsFluent<ComputeResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ComputeResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.withComputeResources(builder.build());
    }
    
    public N endComputeResources() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends PipelineTaskMetadataFluent<MetadataNested<N>> implements Nested<N>{
  
    PipelineTaskMetadataBuilder builder;
  
    MetadataNested(PipelineTaskMetadata item) {
      this.builder = new PipelineTaskMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class PodTemplateNested<N> extends TemplateFluent<PodTemplateNested<N>> implements Nested<N>{
  
    TemplateBuilder builder;
  
    PodTemplateNested(Template item) {
      this.builder = new TemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.withPodTemplate(builder.build());
    }
    
    public N endPodTemplate() {
      return and();
    }
    
  }
  public class SidecarSpecsNested<N> extends TaskRunSidecarSpecFluent<SidecarSpecsNested<N>> implements Nested<N>{
  
    TaskRunSidecarSpecBuilder builder;
    int index;
  
    SidecarSpecsNested(int index,TaskRunSidecarSpec item) {
      this.index = index;
      this.builder = new TaskRunSidecarSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.setToSidecarSpecs(index, builder.build());
    }
    
    public N endSidecarSpec() {
      return and();
    }
    
  }
  public class StepSpecsNested<N> extends TaskRunStepSpecFluent<StepSpecsNested<N>> implements Nested<N>{
  
    TaskRunStepSpecBuilder builder;
    int index;
  
    StepSpecsNested(int index,TaskRunStepSpec item) {
      this.index = index;
      this.builder = new TaskRunStepSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.setToStepSpecs(index, builder.build());
    }
    
    public N endStepSpec() {
      return and();
    }
    
  }
}