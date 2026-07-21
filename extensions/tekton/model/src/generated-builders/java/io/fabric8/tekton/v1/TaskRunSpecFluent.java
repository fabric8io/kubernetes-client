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
public class TaskRunSpecFluent<A extends io.fabric8.tekton.v1.TaskRunSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ResourceRequirementsBuilder computeResources;
  private TaskRunDebugBuilder debug;
  private String managedBy;
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();
  private TemplateBuilder podTemplate;
  private Integer retries;
  private String serviceAccountName;
  private ArrayList<TaskRunSidecarSpecBuilder> sidecarSpecs = new ArrayList<TaskRunSidecarSpecBuilder>();
  private String status;
  private String statusMessage;
  private ArrayList<TaskRunStepSpecBuilder> stepSpecs = new ArrayList<TaskRunStepSpecBuilder>();
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
  
  public TaskRunSidecarSpec buildFirstSidecarSpec() {
    return this.sidecarSpecs.get(0).build();
  }
  
  public TaskRunStepSpec buildFirstStepSpec() {
    return this.stepSpecs.get(0).build();
  }
  
  public WorkspaceBinding buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public Param buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public TaskRunSidecarSpec buildLastSidecarSpec() {
    return this.sidecarSpecs.get(sidecarSpecs.size() - 1).build();
  }
  
  public TaskRunStepSpec buildLastStepSpec() {
    return this.stepSpecs.get(stepSpecs.size() - 1).build();
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
        this.withRetries(instance.getRetries());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSidecarSpecs(instance.getSidecarSpecs());
        this.withStatus(instance.getStatus());
        this.withStatusMessage(instance.getStatusMessage());
        this.withStepSpecs(instance.getStepSpecs());
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
    if (!(Objects.equals(retries, that.retries))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(sidecarSpecs, that.sidecarSpecs))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(statusMessage, that.statusMessage))) {
      return false;
    }
    if (!(Objects.equals(stepSpecs, that.stepSpecs))) {
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
  
  public boolean hasRetries() {
    return this.retries != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSidecarSpecs() {
    return this.sidecarSpecs != null && !(this.sidecarSpecs.isEmpty());
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasStatusMessage() {
    return this.statusMessage != null;
  }
  
  public boolean hasStepSpecs() {
    return this.stepSpecs != null && !(this.stepSpecs.isEmpty());
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
    return Objects.hash(computeResources, debug, managedBy, params, podTemplate, retries, serviceAccountName, sidecarSpecs, status, statusMessage, stepSpecs, taskRef, taskSpec, timeout, workspaces, additionalProperties);
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
  
  public SidecarSpecsNested<A> setNewSidecarSpecLike(int index,TaskRunSidecarSpec item) {
    return new SidecarSpecsNested(index, item);
  }
  
  public StepSpecsNested<A> setNewStepSpecLike(int index,TaskRunStepSpec item) {
    return new StepSpecsNested(index, item);
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
    if (!(sidecarSpecs == null) && !(sidecarSpecs.isEmpty())) {
        sb.append("sidecarSpecs:");
        sb.append(sidecarSpecs);
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
    if (!(stepSpecs == null) && !(stepSpecs.isEmpty())) {
        sb.append("stepSpecs:");
        sb.append(stepSpecs);
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
  
  public A withRetries(Integer retries) {
    this.retries = retries;
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
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
  public A withStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
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
  public class SidecarSpecsNested<N> extends TaskRunSidecarSpecFluent<SidecarSpecsNested<N>> implements Nested<N>{
  
    TaskRunSidecarSpecBuilder builder;
    int index;
  
    SidecarSpecsNested(int index,TaskRunSidecarSpec item) {
      this.index = index;
      this.builder = new TaskRunSidecarSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunSpecFluent.this.setToSidecarSpecs(index, builder.build());
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
      return (N) TaskRunSpecFluent.this.setToStepSpecs(index, builder.build());
    }
    
    public N endStepSpec() {
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