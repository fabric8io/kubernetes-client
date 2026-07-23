package io.fabric8.tekton.v1beta1;

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
public class PipelineTaskRunSpecFluent<A extends io.fabric8.tekton.v1beta1.PipelineTaskRunSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ResourceRequirementsBuilder computeResources;
  private PipelineTaskMetadataBuilder metadata;
  private String pipelineTaskName;
  private ArrayList<TaskRunSidecarOverrideBuilder> sidecarOverrides = new ArrayList<TaskRunSidecarOverrideBuilder>();
  private ArrayList<TaskRunStepOverrideBuilder> stepOverrides = new ArrayList<TaskRunStepOverrideBuilder>();
  private TemplateBuilder taskPodTemplate;
  private String taskServiceAccountName;
  private Duration timeout;

  public PipelineTaskRunSpecFluent() {
  }
  
  public PipelineTaskRunSpecFluent(PipelineTaskRunSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSidecarOverrides(Collection<TaskRunSidecarOverride> items) {
    if (this.sidecarOverrides == null) {
      this.sidecarOverrides = new ArrayList();
    }
    for (TaskRunSidecarOverride item : items) {
        TaskRunSidecarOverrideBuilder builder = new TaskRunSidecarOverrideBuilder(item);
        _visitables.get("sidecarOverrides").add(builder);
        this.sidecarOverrides.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStepOverrides(Collection<TaskRunStepOverride> items) {
    if (this.stepOverrides == null) {
      this.stepOverrides = new ArrayList();
    }
    for (TaskRunStepOverride item : items) {
        TaskRunStepOverrideBuilder builder = new TaskRunStepOverrideBuilder(item);
        _visitables.get("stepOverrides").add(builder);
        this.stepOverrides.add(builder);
    }
    return (A) this;
  }
  
  public SidecarOverridesNested<A> addNewSidecarOverride() {
    return new SidecarOverridesNested(-1, null);
  }
  
  public SidecarOverridesNested<A> addNewSidecarOverrideLike(TaskRunSidecarOverride item) {
    return new SidecarOverridesNested(-1, item);
  }
  
  public StepOverridesNested<A> addNewStepOverride() {
    return new StepOverridesNested(-1, null);
  }
  
  public StepOverridesNested<A> addNewStepOverrideLike(TaskRunStepOverride item) {
    return new StepOverridesNested(-1, item);
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
  
  public A addToSidecarOverrides(TaskRunSidecarOverride... items) {
    if (this.sidecarOverrides == null) {
      this.sidecarOverrides = new ArrayList();
    }
    for (TaskRunSidecarOverride item : items) {
        TaskRunSidecarOverrideBuilder builder = new TaskRunSidecarOverrideBuilder(item);
        _visitables.get("sidecarOverrides").add(builder);
        this.sidecarOverrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToSidecarOverrides(int index,TaskRunSidecarOverride item) {
    if (this.sidecarOverrides == null) {
      this.sidecarOverrides = new ArrayList();
    }
    TaskRunSidecarOverrideBuilder builder = new TaskRunSidecarOverrideBuilder(item);
    if (index < 0 || index >= sidecarOverrides.size()) {
        _visitables.get("sidecarOverrides").add(builder);
        sidecarOverrides.add(builder);
    } else {
        _visitables.get("sidecarOverrides").add(builder);
        sidecarOverrides.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStepOverrides(TaskRunStepOverride... items) {
    if (this.stepOverrides == null) {
      this.stepOverrides = new ArrayList();
    }
    for (TaskRunStepOverride item : items) {
        TaskRunStepOverrideBuilder builder = new TaskRunStepOverrideBuilder(item);
        _visitables.get("stepOverrides").add(builder);
        this.stepOverrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToStepOverrides(int index,TaskRunStepOverride item) {
    if (this.stepOverrides == null) {
      this.stepOverrides = new ArrayList();
    }
    TaskRunStepOverrideBuilder builder = new TaskRunStepOverrideBuilder(item);
    if (index < 0 || index >= stepOverrides.size()) {
        _visitables.get("stepOverrides").add(builder);
        stepOverrides.add(builder);
    } else {
        _visitables.get("stepOverrides").add(builder);
        stepOverrides.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceRequirements buildComputeResources() {
    return this.computeResources != null ? this.computeResources.build() : null;
  }
  
  public TaskRunSidecarOverride buildFirstSidecarOverride() {
    return this.sidecarOverrides.get(0).build();
  }
  
  public TaskRunStepOverride buildFirstStepOverride() {
    return this.stepOverrides.get(0).build();
  }
  
  public TaskRunSidecarOverride buildLastSidecarOverride() {
    return this.sidecarOverrides.get(sidecarOverrides.size() - 1).build();
  }
  
  public TaskRunStepOverride buildLastStepOverride() {
    return this.stepOverrides.get(stepOverrides.size() - 1).build();
  }
  
  public TaskRunSidecarOverride buildMatchingSidecarOverride(Predicate<TaskRunSidecarOverrideBuilder> predicate) {
      for (TaskRunSidecarOverrideBuilder item : sidecarOverrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskRunStepOverride buildMatchingStepOverride(Predicate<TaskRunStepOverrideBuilder> predicate) {
      for (TaskRunStepOverrideBuilder item : stepOverrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineTaskMetadata buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public TaskRunSidecarOverride buildSidecarOverride(int index) {
    return this.sidecarOverrides.get(index).build();
  }
  
  public List<TaskRunSidecarOverride> buildSidecarOverrides() {
    return this.sidecarOverrides != null ? build(sidecarOverrides) : null;
  }
  
  public TaskRunStepOverride buildStepOverride(int index) {
    return this.stepOverrides.get(index).build();
  }
  
  public List<TaskRunStepOverride> buildStepOverrides() {
    return this.stepOverrides != null ? build(stepOverrides) : null;
  }
  
  public Template buildTaskPodTemplate() {
    return this.taskPodTemplate != null ? this.taskPodTemplate.build() : null;
  }
  
  protected void copyInstance(PipelineTaskRunSpec instance) {
    instance = instance != null ? instance : new PipelineTaskRunSpec();
    if (instance != null) {
        this.withComputeResources(instance.getComputeResources());
        this.withMetadata(instance.getMetadata());
        this.withPipelineTaskName(instance.getPipelineTaskName());
        this.withSidecarOverrides(instance.getSidecarOverrides());
        this.withStepOverrides(instance.getStepOverrides());
        this.withTaskPodTemplate(instance.getTaskPodTemplate());
        this.withTaskServiceAccountName(instance.getTaskServiceAccountName());
        this.withTimeout(instance.getTimeout());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComputeResourcesNested<A> editComputeResources() {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(null));
  }
  
  public SidecarOverridesNested<A> editFirstSidecarOverride() {
    if (sidecarOverrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sidecarOverrides"));
    }
    return this.setNewSidecarOverrideLike(0, this.buildSidecarOverride(0));
  }
  
  public StepOverridesNested<A> editFirstStepOverride() {
    if (stepOverrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "stepOverrides"));
    }
    return this.setNewStepOverrideLike(0, this.buildStepOverride(0));
  }
  
  public SidecarOverridesNested<A> editLastSidecarOverride() {
    int index = sidecarOverrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sidecarOverrides"));
    }
    return this.setNewSidecarOverrideLike(index, this.buildSidecarOverride(index));
  }
  
  public StepOverridesNested<A> editLastStepOverride() {
    int index = stepOverrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "stepOverrides"));
    }
    return this.setNewStepOverrideLike(index, this.buildStepOverride(index));
  }
  
  public SidecarOverridesNested<A> editMatchingSidecarOverride(Predicate<TaskRunSidecarOverrideBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sidecarOverrides.size();i++) {
      if (predicate.test(sidecarOverrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sidecarOverrides"));
    }
    return this.setNewSidecarOverrideLike(index, this.buildSidecarOverride(index));
  }
  
  public StepOverridesNested<A> editMatchingStepOverride(Predicate<TaskRunStepOverrideBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < stepOverrides.size();i++) {
      if (predicate.test(stepOverrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "stepOverrides"));
    }
    return this.setNewStepOverrideLike(index, this.buildStepOverride(index));
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
  
  public TaskPodTemplateNested<A> editOrNewTaskPodTemplate() {
    return this.withNewTaskPodTemplateLike(Optional.ofNullable(this.buildTaskPodTemplate()).orElse(new TemplateBuilder().build()));
  }
  
  public TaskPodTemplateNested<A> editOrNewTaskPodTemplateLike(Template item) {
    return this.withNewTaskPodTemplateLike(Optional.ofNullable(this.buildTaskPodTemplate()).orElse(item));
  }
  
  public SidecarOverridesNested<A> editSidecarOverride(int index) {
    if (sidecarOverrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sidecarOverrides"));
    }
    return this.setNewSidecarOverrideLike(index, this.buildSidecarOverride(index));
  }
  
  public StepOverridesNested<A> editStepOverride(int index) {
    if (stepOverrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "stepOverrides"));
    }
    return this.setNewStepOverrideLike(index, this.buildStepOverride(index));
  }
  
  public TaskPodTemplateNested<A> editTaskPodTemplate() {
    return this.withNewTaskPodTemplateLike(Optional.ofNullable(this.buildTaskPodTemplate()).orElse(null));
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
    if (!(Objects.equals(sidecarOverrides, that.sidecarOverrides))) {
      return false;
    }
    if (!(Objects.equals(stepOverrides, that.stepOverrides))) {
      return false;
    }
    if (!(Objects.equals(taskPodTemplate, that.taskPodTemplate))) {
      return false;
    }
    if (!(Objects.equals(taskServiceAccountName, that.taskServiceAccountName))) {
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
  
  public String getTaskServiceAccountName() {
    return this.taskServiceAccountName;
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
  
  public boolean hasMatchingSidecarOverride(Predicate<TaskRunSidecarOverrideBuilder> predicate) {
      for (TaskRunSidecarOverrideBuilder item : sidecarOverrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStepOverride(Predicate<TaskRunStepOverrideBuilder> predicate) {
      for (TaskRunStepOverrideBuilder item : stepOverrides) {
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
  
  public boolean hasSidecarOverrides() {
    return this.sidecarOverrides != null && !(this.sidecarOverrides.isEmpty());
  }
  
  public boolean hasStepOverrides() {
    return this.stepOverrides != null && !(this.stepOverrides.isEmpty());
  }
  
  public boolean hasTaskPodTemplate() {
    return this.taskPodTemplate != null;
  }
  
  public boolean hasTaskServiceAccountName() {
    return this.taskServiceAccountName != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(computeResources, metadata, pipelineTaskName, sidecarOverrides, stepOverrides, taskPodTemplate, taskServiceAccountName, timeout, additionalProperties);
  }
  
  public A removeAllFromSidecarOverrides(Collection<TaskRunSidecarOverride> items) {
    if (this.sidecarOverrides == null) {
      return (A) this;
    }
    for (TaskRunSidecarOverride item : items) {
        TaskRunSidecarOverrideBuilder builder = new TaskRunSidecarOverrideBuilder(item);
        _visitables.get("sidecarOverrides").remove(builder);
        this.sidecarOverrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStepOverrides(Collection<TaskRunStepOverride> items) {
    if (this.stepOverrides == null) {
      return (A) this;
    }
    for (TaskRunStepOverride item : items) {
        TaskRunStepOverrideBuilder builder = new TaskRunStepOverrideBuilder(item);
        _visitables.get("stepOverrides").remove(builder);
        this.stepOverrides.remove(builder);
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
  
  public A removeFromSidecarOverrides(TaskRunSidecarOverride... items) {
    if (this.sidecarOverrides == null) {
      return (A) this;
    }
    for (TaskRunSidecarOverride item : items) {
        TaskRunSidecarOverrideBuilder builder = new TaskRunSidecarOverrideBuilder(item);
        _visitables.get("sidecarOverrides").remove(builder);
        this.sidecarOverrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStepOverrides(TaskRunStepOverride... items) {
    if (this.stepOverrides == null) {
      return (A) this;
    }
    for (TaskRunStepOverride item : items) {
        TaskRunStepOverrideBuilder builder = new TaskRunStepOverrideBuilder(item);
        _visitables.get("stepOverrides").remove(builder);
        this.stepOverrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSidecarOverrides(Predicate<TaskRunSidecarOverrideBuilder> predicate) {
    if (sidecarOverrides == null) {
      return (A) this;
    }
    Iterator<TaskRunSidecarOverrideBuilder> each = sidecarOverrides.iterator();
    List visitables = _visitables.get("sidecarOverrides");
    while (each.hasNext()) {
        TaskRunSidecarOverrideBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStepOverrides(Predicate<TaskRunStepOverrideBuilder> predicate) {
    if (stepOverrides == null) {
      return (A) this;
    }
    Iterator<TaskRunStepOverrideBuilder> each = stepOverrides.iterator();
    List visitables = _visitables.get("stepOverrides");
    while (each.hasNext()) {
        TaskRunStepOverrideBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SidecarOverridesNested<A> setNewSidecarOverrideLike(int index,TaskRunSidecarOverride item) {
    return new SidecarOverridesNested(index, item);
  }
  
  public StepOverridesNested<A> setNewStepOverrideLike(int index,TaskRunStepOverride item) {
    return new StepOverridesNested(index, item);
  }
  
  public A setToSidecarOverrides(int index,TaskRunSidecarOverride item) {
    if (this.sidecarOverrides == null) {
      this.sidecarOverrides = new ArrayList();
    }
    TaskRunSidecarOverrideBuilder builder = new TaskRunSidecarOverrideBuilder(item);
    if (index < 0 || index >= sidecarOverrides.size()) {
        _visitables.get("sidecarOverrides").add(builder);
        sidecarOverrides.add(builder);
    } else {
        _visitables.get("sidecarOverrides").add(builder);
        sidecarOverrides.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStepOverrides(int index,TaskRunStepOverride item) {
    if (this.stepOverrides == null) {
      this.stepOverrides = new ArrayList();
    }
    TaskRunStepOverrideBuilder builder = new TaskRunStepOverrideBuilder(item);
    if (index < 0 || index >= stepOverrides.size()) {
        _visitables.get("stepOverrides").add(builder);
        stepOverrides.add(builder);
    } else {
        _visitables.get("stepOverrides").add(builder);
        stepOverrides.set(index, builder);
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
    if (!(sidecarOverrides == null) && !(sidecarOverrides.isEmpty())) {
        sb.append("sidecarOverrides:");
        sb.append(sidecarOverrides);
        sb.append(",");
    }
    if (!(stepOverrides == null) && !(stepOverrides.isEmpty())) {
        sb.append("stepOverrides:");
        sb.append(stepOverrides);
        sb.append(",");
    }
    if (!(taskPodTemplate == null)) {
        sb.append("taskPodTemplate:");
        sb.append(taskPodTemplate);
        sb.append(",");
    }
    if (!(taskServiceAccountName == null)) {
        sb.append("taskServiceAccountName:");
        sb.append(taskServiceAccountName);
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
  
  public TaskPodTemplateNested<A> withNewTaskPodTemplate() {
    return new TaskPodTemplateNested(null);
  }
  
  public TaskPodTemplateNested<A> withNewTaskPodTemplateLike(Template item) {
    return new TaskPodTemplateNested(item);
  }
  
  public A withPipelineTaskName(String pipelineTaskName) {
    this.pipelineTaskName = pipelineTaskName;
    return (A) this;
  }
  
  public A withSidecarOverrides(List<TaskRunSidecarOverride> sidecarOverrides) {
    if (this.sidecarOverrides != null) {
      this._visitables.get("sidecarOverrides").clear();
    }
    if (sidecarOverrides != null) {
        this.sidecarOverrides = new ArrayList();
        for (TaskRunSidecarOverride item : sidecarOverrides) {
          this.addToSidecarOverrides(item);
        }
    } else {
      this.sidecarOverrides = null;
    }
    return (A) this;
  }
  
  public A withSidecarOverrides(TaskRunSidecarOverride... sidecarOverrides) {
    if (this.sidecarOverrides != null) {
        this.sidecarOverrides.clear();
        _visitables.remove("sidecarOverrides");
    }
    if (sidecarOverrides != null) {
      for (TaskRunSidecarOverride item : sidecarOverrides) {
        this.addToSidecarOverrides(item);
      }
    }
    return (A) this;
  }
  
  public A withStepOverrides(List<TaskRunStepOverride> stepOverrides) {
    if (this.stepOverrides != null) {
      this._visitables.get("stepOverrides").clear();
    }
    if (stepOverrides != null) {
        this.stepOverrides = new ArrayList();
        for (TaskRunStepOverride item : stepOverrides) {
          this.addToStepOverrides(item);
        }
    } else {
      this.stepOverrides = null;
    }
    return (A) this;
  }
  
  public A withStepOverrides(TaskRunStepOverride... stepOverrides) {
    if (this.stepOverrides != null) {
        this.stepOverrides.clear();
        _visitables.remove("stepOverrides");
    }
    if (stepOverrides != null) {
      for (TaskRunStepOverride item : stepOverrides) {
        this.addToStepOverrides(item);
      }
    }
    return (A) this;
  }
  
  public A withTaskPodTemplate(Template taskPodTemplate) {
    this._visitables.remove("taskPodTemplate");
    if (taskPodTemplate != null) {
        this.taskPodTemplate = new TemplateBuilder(taskPodTemplate);
        this._visitables.get("taskPodTemplate").add(this.taskPodTemplate);
    } else {
        this.taskPodTemplate = null;
        this._visitables.get("taskPodTemplate").remove(this.taskPodTemplate);
    }
    return (A) this;
  }
  
  public A withTaskServiceAccountName(String taskServiceAccountName) {
    this.taskServiceAccountName = taskServiceAccountName;
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
  public class SidecarOverridesNested<N> extends TaskRunSidecarOverrideFluent<SidecarOverridesNested<N>> implements Nested<N>{
  
    TaskRunSidecarOverrideBuilder builder;
    int index;
  
    SidecarOverridesNested(int index,TaskRunSidecarOverride item) {
      this.index = index;
      this.builder = new TaskRunSidecarOverrideBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.setToSidecarOverrides(index, builder.build());
    }
    
    public N endSidecarOverride() {
      return and();
    }
    
  }
  public class StepOverridesNested<N> extends TaskRunStepOverrideFluent<StepOverridesNested<N>> implements Nested<N>{
  
    TaskRunStepOverrideBuilder builder;
    int index;
  
    StepOverridesNested(int index,TaskRunStepOverride item) {
      this.index = index;
      this.builder = new TaskRunStepOverrideBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.setToStepOverrides(index, builder.build());
    }
    
    public N endStepOverride() {
      return and();
    }
    
  }
  public class TaskPodTemplateNested<N> extends TemplateFluent<TaskPodTemplateNested<N>> implements Nested<N>{
  
    TemplateBuilder builder;
  
    TaskPodTemplateNested(Template item) {
      this.builder = new TemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskRunSpecFluent.this.withTaskPodTemplate(builder.build());
    }
    
    public N endTaskPodTemplate() {
      return and();
    }
    
  }
}