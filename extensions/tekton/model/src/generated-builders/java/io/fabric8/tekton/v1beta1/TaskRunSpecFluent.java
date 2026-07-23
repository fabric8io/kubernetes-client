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
public class TaskRunSpecFluent<A extends io.fabric8.tekton.v1beta1.TaskRunSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ResourceRequirementsBuilder computeResources;
  private TaskRunDebugBuilder debug;
  private String managedBy;
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();
  private TemplateBuilder podTemplate;
  private TaskRunResourcesBuilder resources;
  private Integer retries;
  private String serviceAccountName;
  private ArrayList<TaskRunSidecarOverrideBuilder> sidecarOverrides = new ArrayList<TaskRunSidecarOverrideBuilder>();
  private String status;
  private String statusMessage;
  private ArrayList<TaskRunStepOverrideBuilder> stepOverrides = new ArrayList<TaskRunStepOverrideBuilder>();
  private TaskRefBuilder taskRef;
  private TaskSpecBuilder taskSpec;
  private Duration timeout;
  private ArrayList<WorkspaceBindingBuilder> workspaces = new ArrayList<WorkspaceBindingBuilder>();

  public TaskRunSpecFluent() {
  }
  
  public TaskRunSpecFluent(TaskRunSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToParams(Collection<Param> items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
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
  
  public A addAllToWorkspaces(Collection<WorkspaceBinding> items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspaceBinding item : items) {
        WorkspaceBindingBuilder builder = new WorkspaceBindingBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public ParamsNested<A> addNewParamLike(Param item) {
    return new ParamsNested(-1, item);
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
  
  public WorkspacesNested<A> addNewWorkspace() {
    return new WorkspacesNested(-1, null);
  }
  
  public WorkspacesNested<A> addNewWorkspaceLike(WorkspaceBinding item) {
    return new WorkspacesNested(-1, item);
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
  
  public A addToParams(Param... items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addToParams(int index,Param item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamBuilder builder = new ParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.add(index, builder);
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
  
  public A addToWorkspaces(WorkspaceBinding... items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspaceBinding item : items) {
        WorkspaceBindingBuilder builder = new WorkspaceBindingBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(int index,WorkspaceBinding item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspaceBindingBuilder builder = new WorkspaceBindingBuilder(item);
    if (index < 0 || index >= workspaces.size()) {
        _visitables.get("workspaces").add(builder);
        workspaces.add(builder);
    } else {
        _visitables.get("workspaces").add(builder);
        workspaces.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceRequirements buildComputeResources() {
    return this.computeResources != null ? this.computeResources.build() : null;
  }
  
  public TaskRunDebug buildDebug() {
    return this.debug != null ? this.debug.build() : null;
  }
  
  public Param buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public TaskRunSidecarOverride buildFirstSidecarOverride() {
    return this.sidecarOverrides.get(0).build();
  }
  
  public TaskRunStepOverride buildFirstStepOverride() {
    return this.stepOverrides.get(0).build();
  }
  
  public WorkspaceBinding buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public Param buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public TaskRunSidecarOverride buildLastSidecarOverride() {
    return this.sidecarOverrides.get(sidecarOverrides.size() - 1).build();
  }
  
  public TaskRunStepOverride buildLastStepOverride() {
    return this.stepOverrides.get(stepOverrides.size() - 1).build();
  }
  
  public WorkspaceBinding buildLastWorkspace() {
    return this.workspaces.get(workspaces.size() - 1).build();
  }
  
  public Param buildMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
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
  
  public WorkspaceBinding buildMatchingWorkspace(Predicate<WorkspaceBindingBuilder> predicate) {
      for (WorkspaceBindingBuilder item : workspaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Param buildParam(int index) {
    return this.params.get(index).build();
  }
  
  public List<Param> buildParams() {
    return this.params != null ? build(params) : null;
  }
  
  public Template buildPodTemplate() {
    return this.podTemplate != null ? this.podTemplate.build() : null;
  }
  
  public TaskRunResources buildResources() {
    return this.resources != null ? this.resources.build() : null;
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
  
  public TaskRef buildTaskRef() {
    return this.taskRef != null ? this.taskRef.build() : null;
  }
  
  public TaskSpec buildTaskSpec() {
    return this.taskSpec != null ? this.taskSpec.build() : null;
  }
  
  public WorkspaceBinding buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspaceBinding> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(TaskRunSpec instance) {
    instance = instance != null ? instance : new TaskRunSpec();
    if (instance != null) {
        this.withComputeResources(instance.getComputeResources());
        this.withDebug(instance.getDebug());
        this.withManagedBy(instance.getManagedBy());
        this.withParams(instance.getParams());
        this.withPodTemplate(instance.getPodTemplate());
        this.withResources(instance.getResources());
        this.withRetries(instance.getRetries());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSidecarOverrides(instance.getSidecarOverrides());
        this.withStatus(instance.getStatus());
        this.withStatusMessage(instance.getStatusMessage());
        this.withStepOverrides(instance.getStepOverrides());
        this.withTaskRef(instance.getTaskRef());
        this.withTaskSpec(instance.getTaskSpec());
        this.withTimeout(instance.getTimeout());
        this.withWorkspaces(instance.getWorkspaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComputeResourcesNested<A> editComputeResources() {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(null));
  }
  
  public DebugNested<A> editDebug() {
    return this.withNewDebugLike(Optional.ofNullable(this.buildDebug()).orElse(null));
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
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
  
  public WorkspacesNested<A> editFirstWorkspace() {
    if (workspaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "workspaces"));
    }
    return this.setNewWorkspaceLike(0, this.buildWorkspace(0));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
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
  
  public WorkspacesNested<A> editLastWorkspace() {
    int index = workspaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "workspaces"));
    }
    return this.setNewWorkspaceLike(index, this.buildWorkspace(index));
  }
  
  public ParamsNested<A> editMatchingParam(Predicate<ParamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < params.size();i++) {
      if (predicate.test(params.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
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
  
  public WorkspacesNested<A> editMatchingWorkspace(Predicate<WorkspaceBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < workspaces.size();i++) {
      if (predicate.test(workspaces.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "workspaces"));
    }
    return this.setNewWorkspaceLike(index, this.buildWorkspace(index));
  }
  
  public ComputeResourcesNested<A> editOrNewComputeResources() {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ComputeResourcesNested<A> editOrNewComputeResourcesLike(ResourceRequirements item) {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(item));
  }
  
  public DebugNested<A> editOrNewDebug() {
    return this.withNewDebugLike(Optional.ofNullable(this.buildDebug()).orElse(new TaskRunDebugBuilder().build()));
  }
  
  public DebugNested<A> editOrNewDebugLike(TaskRunDebug item) {
    return this.withNewDebugLike(Optional.ofNullable(this.buildDebug()).orElse(item));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(new TemplateBuilder().build()));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplateLike(Template item) {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new TaskRunResourcesBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(TaskRunResources item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public TaskRefNested<A> editOrNewTaskRef() {
    return this.withNewTaskRefLike(Optional.ofNullable(this.buildTaskRef()).orElse(new TaskRefBuilder().build()));
  }
  
  public TaskRefNested<A> editOrNewTaskRefLike(TaskRef item) {
    return this.withNewTaskRefLike(Optional.ofNullable(this.buildTaskRef()).orElse(item));
  }
  
  public TaskSpecNested<A> editOrNewTaskSpec() {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(new TaskSpecBuilder().build()));
  }
  
  public TaskSpecNested<A> editOrNewTaskSpecLike(TaskSpec item) {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(item));
  }
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public PodTemplateNested<A> editPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(null));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
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
  
  public TaskRefNested<A> editTaskRef() {
    return this.withNewTaskRefLike(Optional.ofNullable(this.buildTaskRef()).orElse(null));
  }
  
  public TaskSpecNested<A> editTaskSpec() {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(null));
  }
  
  public WorkspacesNested<A> editWorkspace(int index) {
    if (workspaces.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "workspaces"));
    }
    return this.setNewWorkspaceLike(index, this.buildWorkspace(index));
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
    TaskRunSpecFluent that = (TaskRunSpecFluent) o;
    if (!(Objects.equals(computeResources, that.computeResources))) {
      return false;
    }
    if (!(Objects.equals(debug, that.debug))) {
      return false;
    }
    if (!(Objects.equals(managedBy, that.managedBy))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(podTemplate, that.podTemplate))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(retries, that.retries))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(sidecarOverrides, that.sidecarOverrides))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(statusMessage, that.statusMessage))) {
      return false;
    }
    if (!(Objects.equals(stepOverrides, that.stepOverrides))) {
      return false;
    }
    if (!(Objects.equals(taskRef, that.taskRef))) {
      return false;
    }
    if (!(Objects.equals(taskSpec, that.taskSpec))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(workspaces, that.workspaces))) {
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
  
  public String getManagedBy() {
    return this.managedBy;
  }
  
  public Integer getRetries() {
    return this.retries;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public String getStatusMessage() {
    return this.statusMessage;
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
  
  public boolean hasDebug() {
    return this.debug != null;
  }
  
  public boolean hasManagedBy() {
    return this.managedBy != null;
  }
  
  public boolean hasMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
  
  public boolean hasMatchingWorkspace(Predicate<WorkspaceBindingBuilder> predicate) {
      for (WorkspaceBindingBuilder item : workspaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParams() {
    return this.params != null && !(this.params.isEmpty());
  }
  
  public boolean hasPodTemplate() {
    return this.podTemplate != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRetries() {
    return this.retries != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSidecarOverrides() {
    return this.sidecarOverrides != null && !(this.sidecarOverrides.isEmpty());
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasStatusMessage() {
    return this.statusMessage != null;
  }
  
  public boolean hasStepOverrides() {
    return this.stepOverrides != null && !(this.stepOverrides.isEmpty());
  }
  
  public boolean hasTaskRef() {
    return this.taskRef != null;
  }
  
  public boolean hasTaskSpec() {
    return this.taskSpec != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(computeResources, debug, managedBy, params, podTemplate, resources, retries, serviceAccountName, sidecarOverrides, status, statusMessage, stepOverrides, taskRef, taskSpec, timeout, workspaces, additionalProperties);
  }
  
  public A removeAllFromParams(Collection<Param> items) {
    if (this.params == null) {
      return (A) this;
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
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
  
  public A removeAllFromWorkspaces(Collection<WorkspaceBinding> items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspaceBinding item : items) {
        WorkspaceBindingBuilder builder = new WorkspaceBindingBuilder(item);
        _visitables.get("workspaces").remove(builder);
        this.workspaces.remove(builder);
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
  
  public A removeFromParams(Param... items) {
    if (this.params == null) {
      return (A) this;
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
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
  
  public A removeFromWorkspaces(WorkspaceBinding... items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspaceBinding item : items) {
        WorkspaceBindingBuilder builder = new WorkspaceBindingBuilder(item);
        _visitables.get("workspaces").remove(builder);
        this.workspaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromParams(Predicate<ParamBuilder> predicate) {
    if (params == null) {
      return (A) this;
    }
    Iterator<ParamBuilder> each = params.iterator();
    List visitables = _visitables.get("params");
    while (each.hasNext()) {
        ParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public A removeMatchingFromWorkspaces(Predicate<WorkspaceBindingBuilder> predicate) {
    if (workspaces == null) {
      return (A) this;
    }
    Iterator<WorkspaceBindingBuilder> each = workspaces.iterator();
    List visitables = _visitables.get("workspaces");
    while (each.hasNext()) {
        WorkspaceBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParamsNested<A> setNewParamLike(int index,Param item) {
    return new ParamsNested(index, item);
  }
  
  public SidecarOverridesNested<A> setNewSidecarOverrideLike(int index,TaskRunSidecarOverride item) {
    return new SidecarOverridesNested(index, item);
  }
  
  public StepOverridesNested<A> setNewStepOverrideLike(int index,TaskRunStepOverride item) {
    return new StepOverridesNested(index, item);
  }
  
  public WorkspacesNested<A> setNewWorkspaceLike(int index,WorkspaceBinding item) {
    return new WorkspacesNested(index, item);
  }
  
  public A setToParams(int index,Param item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamBuilder builder = new ParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.set(index, builder);
    }
    return (A) this;
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
  
  public A setToWorkspaces(int index,WorkspaceBinding item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspaceBindingBuilder builder = new WorkspaceBindingBuilder(item);
    if (index < 0 || index >= workspaces.size()) {
        _visitables.get("workspaces").add(builder);
        workspaces.add(builder);
    } else {
        _visitables.get("workspaces").add(builder);
        workspaces.set(index, builder);
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
    if (!(debug == null)) {
        sb.append("debug:");
        sb.append(debug);
        sb.append(",");
    }
    if (!(managedBy == null)) {
        sb.append("managedBy:");
        sb.append(managedBy);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
        sb.append(",");
    }
    if (!(podTemplate == null)) {
        sb.append("podTemplate:");
        sb.append(podTemplate);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(retries == null)) {
        sb.append("retries:");
        sb.append(retries);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(sidecarOverrides == null) && !(sidecarOverrides.isEmpty())) {
        sb.append("sidecarOverrides:");
        sb.append(sidecarOverrides);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(statusMessage == null)) {
        sb.append("statusMessage:");
        sb.append(statusMessage);
        sb.append(",");
    }
    if (!(stepOverrides == null) && !(stepOverrides.isEmpty())) {
        sb.append("stepOverrides:");
        sb.append(stepOverrides);
        sb.append(",");
    }
    if (!(taskRef == null)) {
        sb.append("taskRef:");
        sb.append(taskRef);
        sb.append(",");
    }
    if (!(taskSpec == null)) {
        sb.append("taskSpec:");
        sb.append(taskSpec);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(workspaces == null) && !(workspaces.isEmpty())) {
        sb.append("workspaces:");
        sb.append(workspaces);
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
  
  public A withDebug(TaskRunDebug debug) {
    this._visitables.remove("debug");
    if (debug != null) {
        this.debug = new TaskRunDebugBuilder(debug);
        this._visitables.get("debug").add(this.debug);
    } else {
        this.debug = null;
        this._visitables.get("debug").remove(this.debug);
    }
    return (A) this;
  }
  
  public A withManagedBy(String managedBy) {
    this.managedBy = managedBy;
    return (A) this;
  }
  
  public ComputeResourcesNested<A> withNewComputeResources() {
    return new ComputeResourcesNested(null);
  }
  
  public ComputeResourcesNested<A> withNewComputeResourcesLike(ResourceRequirements item) {
    return new ComputeResourcesNested(item);
  }
  
  public DebugNested<A> withNewDebug() {
    return new DebugNested(null);
  }
  
  public DebugNested<A> withNewDebugLike(TaskRunDebug item) {
    return new DebugNested(item);
  }
  
  public PodTemplateNested<A> withNewPodTemplate() {
    return new PodTemplateNested(null);
  }
  
  public PodTemplateNested<A> withNewPodTemplateLike(Template item) {
    return new PodTemplateNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(TaskRunResources item) {
    return new ResourcesNested(item);
  }
  
  public TaskRefNested<A> withNewTaskRef() {
    return new TaskRefNested(null);
  }
  
  public TaskRefNested<A> withNewTaskRefLike(TaskRef item) {
    return new TaskRefNested(item);
  }
  
  public TaskSpecNested<A> withNewTaskSpec() {
    return new TaskSpecNested(null);
  }
  
  public TaskSpecNested<A> withNewTaskSpecLike(TaskSpec item) {
    return new TaskSpecNested(item);
  }
  
  public A withParams(List<Param> params) {
    if (this.params != null) {
      this._visitables.get("params").clear();
    }
    if (params != null) {
        this.params = new ArrayList();
        for (Param item : params) {
          this.addToParams(item);
        }
    } else {
      this.params = null;
    }
    return (A) this;
  }
  
  public A withParams(Param... params) {
    if (this.params != null) {
        this.params.clear();
        _visitables.remove("params");
    }
    if (params != null) {
      for (Param item : params) {
        this.addToParams(item);
      }
    }
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
  
  public A withResources(TaskRunResources resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new TaskRunResourcesBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withRetries(Integer retries) {
    this.retries = retries;
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
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
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
  public A withStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
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
  
  public A withTaskRef(TaskRef taskRef) {
    this._visitables.remove("taskRef");
    if (taskRef != null) {
        this.taskRef = new TaskRefBuilder(taskRef);
        this._visitables.get("taskRef").add(this.taskRef);
    } else {
        this.taskRef = null;
        this._visitables.get("taskRef").remove(this.taskRef);
    }
    return (A) this;
  }
  
  public A withTaskSpec(TaskSpec taskSpec) {
    this._visitables.remove("taskSpec");
    if (taskSpec != null) {
        this.taskSpec = new TaskSpecBuilder(taskSpec);
        this._visitables.get("taskSpec").add(this.taskSpec);
    } else {
        this.taskSpec = null;
        this._visitables.get("taskSpec").remove(this.taskSpec);
    }
    return (A) this;
  }
  
  public A withTimeout(Duration timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
  public A withWorkspaces(List<WorkspaceBinding> workspaces) {
    if (this.workspaces != null) {
      this._visitables.get("workspaces").clear();
    }
    if (workspaces != null) {
        this.workspaces = new ArrayList();
        for (WorkspaceBinding item : workspaces) {
          this.addToWorkspaces(item);
        }
    } else {
      this.workspaces = null;
    }
    return (A) this;
  }
  
  public A withWorkspaces(WorkspaceBinding... workspaces) {
    if (this.workspaces != null) {
        this.workspaces.clear();
        _visitables.remove("workspaces");
    }
    if (workspaces != null) {
      for (WorkspaceBinding item : workspaces) {
        this.addToWorkspaces(item);
      }
    }
    return (A) this;
  }
  public class ComputeResourcesNested<N> extends ResourceRequirementsFluent<ComputeResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ComputeResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.withComputeResources(builder.build());
    }
    
    public N endComputeResources() {
      return and();
    }
    
  }
  public class DebugNested<N> extends TaskRunDebugFluent<DebugNested<N>> implements Nested<N>{
  
    TaskRunDebugBuilder builder;
  
    DebugNested(TaskRunDebug item) {
      this.builder = new TaskRunDebugBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.withDebug(builder.build());
    }
    
    public N endDebug() {
      return and();
    }
    
  }
  public class ParamsNested<N> extends ParamFluent<ParamsNested<N>> implements Nested<N>{
  
    ParamBuilder builder;
    int index;
  
    ParamsNested(int index,Param item) {
      this.index = index;
      this.builder = new ParamBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class PodTemplateNested<N> extends TemplateFluent<PodTemplateNested<N>> implements Nested<N>{
  
    TemplateBuilder builder;
  
    PodTemplateNested(Template item) {
      this.builder = new TemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.withPodTemplate(builder.build());
    }
    
    public N endPodTemplate() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends TaskRunResourcesFluent<ResourcesNested<N>> implements Nested<N>{
  
    TaskRunResourcesBuilder builder;
  
    ResourcesNested(TaskRunResources item) {
      this.builder = new TaskRunResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
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
      return (N) TaskRunSpecFluent.this.setToSidecarOverrides(index, builder.build());
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
      return (N) TaskRunSpecFluent.this.setToStepOverrides(index, builder.build());
    }
    
    public N endStepOverride() {
      return and();
    }
    
  }
  public class TaskRefNested<N> extends TaskRefFluent<TaskRefNested<N>> implements Nested<N>{
  
    TaskRefBuilder builder;
  
    TaskRefNested(TaskRef item) {
      this.builder = new TaskRefBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.withTaskRef(builder.build());
    }
    
    public N endTaskRef() {
      return and();
    }
    
  }
  public class TaskSpecNested<N> extends TaskSpecFluent<TaskSpecNested<N>> implements Nested<N>{
  
    TaskSpecBuilder builder;
  
    TaskSpecNested(TaskSpec item) {
      this.builder = new TaskSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.withTaskSpec(builder.build());
    }
    
    public N endTaskSpec() {
      return and();
    }
    
  }
  public class WorkspacesNested<N> extends WorkspaceBindingFluent<WorkspacesNested<N>> implements Nested<N>{
  
    WorkspaceBindingBuilder builder;
    int index;
  
    WorkspacesNested(int index,WorkspaceBinding item) {
      this.index = index;
      this.builder = new WorkspaceBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}