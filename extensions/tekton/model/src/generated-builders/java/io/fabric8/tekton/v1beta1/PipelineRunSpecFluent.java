package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
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
public class PipelineRunSpecFluent<A extends io.fabric8.tekton.v1beta1.PipelineRunSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String managedBy;
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();
  private PipelineRefBuilder pipelineRef;
  private PipelineSpecBuilder pipelineSpec;
  private TemplateBuilder podTemplate;
  private ArrayList<PipelineResourceBindingBuilder> resources = new ArrayList<PipelineResourceBindingBuilder>();
  private String serviceAccountName;
  private String status;
  private ArrayList<PipelineTaskRunSpecBuilder> taskRunSpecs = new ArrayList<PipelineTaskRunSpecBuilder>();
  private Duration timeout;
  private TimeoutFieldsBuilder timeouts;
  private ArrayList<WorkspaceBindingBuilder> workspaces = new ArrayList<WorkspaceBindingBuilder>();

  public PipelineRunSpecFluent() {
  }
  
  public PipelineRunSpecFluent(PipelineRunSpec instance) {
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
  
  public A addAllToResources(Collection<PipelineResourceBinding> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (PipelineResourceBinding item : items) {
        PipelineResourceBindingBuilder builder = new PipelineResourceBindingBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTaskRunSpecs(Collection<PipelineTaskRunSpec> items) {
    if (this.taskRunSpecs == null) {
      this.taskRunSpecs = new ArrayList();
    }
    for (PipelineTaskRunSpec item : items) {
        PipelineTaskRunSpecBuilder builder = new PipelineTaskRunSpecBuilder(item);
        _visitables.get("taskRunSpecs").add(builder);
        this.taskRunSpecs.add(builder);
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
  
  public ResourcesNested<A> addNewResource() {
    return new ResourcesNested(-1, null);
  }
  
  public ResourcesNested<A> addNewResourceLike(PipelineResourceBinding item) {
    return new ResourcesNested(-1, item);
  }
  
  public TaskRunSpecsNested<A> addNewTaskRunSpec() {
    return new TaskRunSpecsNested(-1, null);
  }
  
  public TaskRunSpecsNested<A> addNewTaskRunSpecLike(PipelineTaskRunSpec item) {
    return new TaskRunSpecsNested(-1, item);
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
  
  public A addToResources(PipelineResourceBinding... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (PipelineResourceBinding item : items) {
        PipelineResourceBindingBuilder builder = new PipelineResourceBindingBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addToResources(int index,PipelineResourceBinding item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    PipelineResourceBindingBuilder builder = new PipelineResourceBindingBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTaskRunSpecs(PipelineTaskRunSpec... items) {
    if (this.taskRunSpecs == null) {
      this.taskRunSpecs = new ArrayList();
    }
    for (PipelineTaskRunSpec item : items) {
        PipelineTaskRunSpecBuilder builder = new PipelineTaskRunSpecBuilder(item);
        _visitables.get("taskRunSpecs").add(builder);
        this.taskRunSpecs.add(builder);
    }
    return (A) this;
  }
  
  public A addToTaskRunSpecs(int index,PipelineTaskRunSpec item) {
    if (this.taskRunSpecs == null) {
      this.taskRunSpecs = new ArrayList();
    }
    PipelineTaskRunSpecBuilder builder = new PipelineTaskRunSpecBuilder(item);
    if (index < 0 || index >= taskRunSpecs.size()) {
        _visitables.get("taskRunSpecs").add(builder);
        taskRunSpecs.add(builder);
    } else {
        _visitables.get("taskRunSpecs").add(builder);
        taskRunSpecs.add(index, builder);
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
  
  public Param buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public PipelineResourceBinding buildFirstResource() {
    return this.resources.get(0).build();
  }
  
  public PipelineTaskRunSpec buildFirstTaskRunSpec() {
    return this.taskRunSpecs.get(0).build();
  }
  
  public WorkspaceBinding buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public Param buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public PipelineResourceBinding buildLastResource() {
    return this.resources.get(resources.size() - 1).build();
  }
  
  public PipelineTaskRunSpec buildLastTaskRunSpec() {
    return this.taskRunSpecs.get(taskRunSpecs.size() - 1).build();
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
  
  public PipelineResourceBinding buildMatchingResource(Predicate<PipelineResourceBindingBuilder> predicate) {
      for (PipelineResourceBindingBuilder item : resources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineTaskRunSpec buildMatchingTaskRunSpec(Predicate<PipelineTaskRunSpecBuilder> predicate) {
      for (PipelineTaskRunSpecBuilder item : taskRunSpecs) {
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
  
  public PipelineRef buildPipelineRef() {
    return this.pipelineRef != null ? this.pipelineRef.build() : null;
  }
  
  public PipelineSpec buildPipelineSpec() {
    return this.pipelineSpec != null ? this.pipelineSpec.build() : null;
  }
  
  public Template buildPodTemplate() {
    return this.podTemplate != null ? this.podTemplate.build() : null;
  }
  
  public PipelineResourceBinding buildResource(int index) {
    return this.resources.get(index).build();
  }
  
  public List<PipelineResourceBinding> buildResources() {
    return this.resources != null ? build(resources) : null;
  }
  
  public PipelineTaskRunSpec buildTaskRunSpec(int index) {
    return this.taskRunSpecs.get(index).build();
  }
  
  public List<PipelineTaskRunSpec> buildTaskRunSpecs() {
    return this.taskRunSpecs != null ? build(taskRunSpecs) : null;
  }
  
  public TimeoutFields buildTimeouts() {
    return this.timeouts != null ? this.timeouts.build() : null;
  }
  
  public WorkspaceBinding buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspaceBinding> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(PipelineRunSpec instance) {
    instance = instance != null ? instance : new PipelineRunSpec();
    if (instance != null) {
        this.withManagedBy(instance.getManagedBy());
        this.withParams(instance.getParams());
        this.withPipelineRef(instance.getPipelineRef());
        this.withPipelineSpec(instance.getPipelineSpec());
        this.withPodTemplate(instance.getPodTemplate());
        this.withResources(instance.getResources());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withStatus(instance.getStatus());
        this.withTaskRunSpecs(instance.getTaskRunSpecs());
        this.withTimeout(instance.getTimeout());
        this.withTimeouts(instance.getTimeouts());
        this.withWorkspaces(instance.getWorkspaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public ResourcesNested<A> editFirstResource() {
    if (resources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(0, this.buildResource(0));
  }
  
  public TaskRunSpecsNested<A> editFirstTaskRunSpec() {
    if (taskRunSpecs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "taskRunSpecs"));
    }
    return this.setNewTaskRunSpecLike(0, this.buildTaskRunSpec(0));
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
  
  public ResourcesNested<A> editLastResource() {
    int index = resources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public TaskRunSpecsNested<A> editLastTaskRunSpec() {
    int index = taskRunSpecs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "taskRunSpecs"));
    }
    return this.setNewTaskRunSpecLike(index, this.buildTaskRunSpec(index));
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
  
  public ResourcesNested<A> editMatchingResource(Predicate<PipelineResourceBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resources.size();i++) {
      if (predicate.test(resources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public TaskRunSpecsNested<A> editMatchingTaskRunSpec(Predicate<PipelineTaskRunSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < taskRunSpecs.size();i++) {
      if (predicate.test(taskRunSpecs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "taskRunSpecs"));
    }
    return this.setNewTaskRunSpecLike(index, this.buildTaskRunSpec(index));
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
  
  public PipelineRefNested<A> editOrNewPipelineRef() {
    return this.withNewPipelineRefLike(Optional.ofNullable(this.buildPipelineRef()).orElse(new PipelineRefBuilder().build()));
  }
  
  public PipelineRefNested<A> editOrNewPipelineRefLike(PipelineRef item) {
    return this.withNewPipelineRefLike(Optional.ofNullable(this.buildPipelineRef()).orElse(item));
  }
  
  public PipelineSpecNested<A> editOrNewPipelineSpec() {
    return this.withNewPipelineSpecLike(Optional.ofNullable(this.buildPipelineSpec()).orElse(new PipelineSpecBuilder().build()));
  }
  
  public PipelineSpecNested<A> editOrNewPipelineSpecLike(PipelineSpec item) {
    return this.withNewPipelineSpecLike(Optional.ofNullable(this.buildPipelineSpec()).orElse(item));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(new TemplateBuilder().build()));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplateLike(Template item) {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(item));
  }
  
  public TimeoutsNested<A> editOrNewTimeouts() {
    return this.withNewTimeoutsLike(Optional.ofNullable(this.buildTimeouts()).orElse(new TimeoutFieldsBuilder().build()));
  }
  
  public TimeoutsNested<A> editOrNewTimeoutsLike(TimeoutFields item) {
    return this.withNewTimeoutsLike(Optional.ofNullable(this.buildTimeouts()).orElse(item));
  }
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public PipelineRefNested<A> editPipelineRef() {
    return this.withNewPipelineRefLike(Optional.ofNullable(this.buildPipelineRef()).orElse(null));
  }
  
  public PipelineSpecNested<A> editPipelineSpec() {
    return this.withNewPipelineSpecLike(Optional.ofNullable(this.buildPipelineSpec()).orElse(null));
  }
  
  public PodTemplateNested<A> editPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(null));
  }
  
  public ResourcesNested<A> editResource(int index) {
    if (resources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public TaskRunSpecsNested<A> editTaskRunSpec(int index) {
    if (taskRunSpecs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "taskRunSpecs"));
    }
    return this.setNewTaskRunSpecLike(index, this.buildTaskRunSpec(index));
  }
  
  public TimeoutsNested<A> editTimeouts() {
    return this.withNewTimeoutsLike(Optional.ofNullable(this.buildTimeouts()).orElse(null));
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
    PipelineRunSpecFluent that = (PipelineRunSpecFluent) o;
    if (!(Objects.equals(managedBy, that.managedBy))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(pipelineRef, that.pipelineRef))) {
      return false;
    }
    if (!(Objects.equals(pipelineSpec, that.pipelineSpec))) {
      return false;
    }
    if (!(Objects.equals(podTemplate, that.podTemplate))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(taskRunSpecs, that.taskRunSpecs))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(timeouts, that.timeouts))) {
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
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public Duration getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
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
  
  public boolean hasMatchingResource(Predicate<PipelineResourceBindingBuilder> predicate) {
      for (PipelineResourceBindingBuilder item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTaskRunSpec(Predicate<PipelineTaskRunSpecBuilder> predicate) {
      for (PipelineTaskRunSpecBuilder item : taskRunSpecs) {
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
  
  public boolean hasPipelineRef() {
    return this.pipelineRef != null;
  }
  
  public boolean hasPipelineSpec() {
    return this.pipelineSpec != null;
  }
  
  public boolean hasPodTemplate() {
    return this.podTemplate != null;
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasTaskRunSpecs() {
    return this.taskRunSpecs != null && !(this.taskRunSpecs.isEmpty());
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasTimeouts() {
    return this.timeouts != null;
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(managedBy, params, pipelineRef, pipelineSpec, podTemplate, resources, serviceAccountName, status, taskRunSpecs, timeout, timeouts, workspaces, additionalProperties);
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
  
  public A removeAllFromResources(Collection<PipelineResourceBinding> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (PipelineResourceBinding item : items) {
        PipelineResourceBindingBuilder builder = new PipelineResourceBindingBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTaskRunSpecs(Collection<PipelineTaskRunSpec> items) {
    if (this.taskRunSpecs == null) {
      return (A) this;
    }
    for (PipelineTaskRunSpec item : items) {
        PipelineTaskRunSpecBuilder builder = new PipelineTaskRunSpecBuilder(item);
        _visitables.get("taskRunSpecs").remove(builder);
        this.taskRunSpecs.remove(builder);
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
  
  public A removeFromResources(PipelineResourceBinding... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (PipelineResourceBinding item : items) {
        PipelineResourceBindingBuilder builder = new PipelineResourceBindingBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTaskRunSpecs(PipelineTaskRunSpec... items) {
    if (this.taskRunSpecs == null) {
      return (A) this;
    }
    for (PipelineTaskRunSpec item : items) {
        PipelineTaskRunSpecBuilder builder = new PipelineTaskRunSpecBuilder(item);
        _visitables.get("taskRunSpecs").remove(builder);
        this.taskRunSpecs.remove(builder);
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
  
  public A removeMatchingFromResources(Predicate<PipelineResourceBindingBuilder> predicate) {
    if (resources == null) {
      return (A) this;
    }
    Iterator<PipelineResourceBindingBuilder> each = resources.iterator();
    List visitables = _visitables.get("resources");
    while (each.hasNext()) {
        PipelineResourceBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTaskRunSpecs(Predicate<PipelineTaskRunSpecBuilder> predicate) {
    if (taskRunSpecs == null) {
      return (A) this;
    }
    Iterator<PipelineTaskRunSpecBuilder> each = taskRunSpecs.iterator();
    List visitables = _visitables.get("taskRunSpecs");
    while (each.hasNext()) {
        PipelineTaskRunSpecBuilder builder = each.next();
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
  
  public ResourcesNested<A> setNewResourceLike(int index,PipelineResourceBinding item) {
    return new ResourcesNested(index, item);
  }
  
  public TaskRunSpecsNested<A> setNewTaskRunSpecLike(int index,PipelineTaskRunSpec item) {
    return new TaskRunSpecsNested(index, item);
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
  
  public A setToResources(int index,PipelineResourceBinding item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    PipelineResourceBindingBuilder builder = new PipelineResourceBindingBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTaskRunSpecs(int index,PipelineTaskRunSpec item) {
    if (this.taskRunSpecs == null) {
      this.taskRunSpecs = new ArrayList();
    }
    PipelineTaskRunSpecBuilder builder = new PipelineTaskRunSpecBuilder(item);
    if (index < 0 || index >= taskRunSpecs.size()) {
        _visitables.get("taskRunSpecs").add(builder);
        taskRunSpecs.add(builder);
    } else {
        _visitables.get("taskRunSpecs").add(builder);
        taskRunSpecs.set(index, builder);
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
    if (!(pipelineRef == null)) {
        sb.append("pipelineRef:");
        sb.append(pipelineRef);
        sb.append(",");
    }
    if (!(pipelineSpec == null)) {
        sb.append("pipelineSpec:");
        sb.append(pipelineSpec);
        sb.append(",");
    }
    if (!(podTemplate == null)) {
        sb.append("podTemplate:");
        sb.append(podTemplate);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(taskRunSpecs == null) && !(taskRunSpecs.isEmpty())) {
        sb.append("taskRunSpecs:");
        sb.append(taskRunSpecs);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(timeouts == null)) {
        sb.append("timeouts:");
        sb.append(timeouts);
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
  
  public A withManagedBy(String managedBy) {
    this.managedBy = managedBy;
    return (A) this;
  }
  
  public PipelineRefNested<A> withNewPipelineRef() {
    return new PipelineRefNested(null);
  }
  
  public PipelineRefNested<A> withNewPipelineRefLike(PipelineRef item) {
    return new PipelineRefNested(item);
  }
  
  public PipelineSpecNested<A> withNewPipelineSpec() {
    return new PipelineSpecNested(null);
  }
  
  public PipelineSpecNested<A> withNewPipelineSpecLike(PipelineSpec item) {
    return new PipelineSpecNested(item);
  }
  
  public PodTemplateNested<A> withNewPodTemplate() {
    return new PodTemplateNested(null);
  }
  
  public PodTemplateNested<A> withNewPodTemplateLike(Template item) {
    return new PodTemplateNested(item);
  }
  
  public TimeoutsNested<A> withNewTimeouts() {
    return new TimeoutsNested(null);
  }
  
  public TimeoutsNested<A> withNewTimeoutsLike(TimeoutFields item) {
    return new TimeoutsNested(item);
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
  
  public A withPipelineRef(PipelineRef pipelineRef) {
    this._visitables.remove("pipelineRef");
    if (pipelineRef != null) {
        this.pipelineRef = new PipelineRefBuilder(pipelineRef);
        this._visitables.get("pipelineRef").add(this.pipelineRef);
    } else {
        this.pipelineRef = null;
        this._visitables.get("pipelineRef").remove(this.pipelineRef);
    }
    return (A) this;
  }
  
  public A withPipelineSpec(PipelineSpec pipelineSpec) {
    this._visitables.remove("pipelineSpec");
    if (pipelineSpec != null) {
        this.pipelineSpec = new PipelineSpecBuilder(pipelineSpec);
        this._visitables.get("pipelineSpec").add(this.pipelineSpec);
    } else {
        this.pipelineSpec = null;
        this._visitables.get("pipelineSpec").remove(this.pipelineSpec);
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
  
  public A withResources(List<PipelineResourceBinding> resources) {
    if (this.resources != null) {
      this._visitables.get("resources").clear();
    }
    if (resources != null) {
        this.resources = new ArrayList();
        for (PipelineResourceBinding item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(PipelineResourceBinding... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (PipelineResourceBinding item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
  public A withTaskRunSpecs(List<PipelineTaskRunSpec> taskRunSpecs) {
    if (this.taskRunSpecs != null) {
      this._visitables.get("taskRunSpecs").clear();
    }
    if (taskRunSpecs != null) {
        this.taskRunSpecs = new ArrayList();
        for (PipelineTaskRunSpec item : taskRunSpecs) {
          this.addToTaskRunSpecs(item);
        }
    } else {
      this.taskRunSpecs = null;
    }
    return (A) this;
  }
  
  public A withTaskRunSpecs(PipelineTaskRunSpec... taskRunSpecs) {
    if (this.taskRunSpecs != null) {
        this.taskRunSpecs.clear();
        _visitables.remove("taskRunSpecs");
    }
    if (taskRunSpecs != null) {
      for (PipelineTaskRunSpec item : taskRunSpecs) {
        this.addToTaskRunSpecs(item);
      }
    }
    return (A) this;
  }
  
  public A withTimeout(Duration timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
  public A withTimeouts(TimeoutFields timeouts) {
    this._visitables.remove("timeouts");
    if (timeouts != null) {
        this.timeouts = new TimeoutFieldsBuilder(timeouts);
        this._visitables.get("timeouts").add(this.timeouts);
    } else {
        this.timeouts = null;
        this._visitables.get("timeouts").remove(this.timeouts);
    }
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
  public class ParamsNested<N> extends ParamFluent<ParamsNested<N>> implements Nested<N>{
  
    ParamBuilder builder;
    int index;
  
    ParamsNested(int index,Param item) {
      this.index = index;
      this.builder = new ParamBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class PipelineRefNested<N> extends PipelineRefFluent<PipelineRefNested<N>> implements Nested<N>{
  
    PipelineRefBuilder builder;
  
    PipelineRefNested(PipelineRef item) {
      this.builder = new PipelineRefBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunSpecFluent.this.withPipelineRef(builder.build());
    }
    
    public N endPipelineRef() {
      return and();
    }
    
  }
  public class PipelineSpecNested<N> extends PipelineSpecFluent<PipelineSpecNested<N>> implements Nested<N>{
  
    PipelineSpecBuilder builder;
  
    PipelineSpecNested(PipelineSpec item) {
      this.builder = new PipelineSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunSpecFluent.this.withPipelineSpec(builder.build());
    }
    
    public N endPipelineSpec() {
      return and();
    }
    
  }
  public class PodTemplateNested<N> extends TemplateFluent<PodTemplateNested<N>> implements Nested<N>{
  
    TemplateBuilder builder;
  
    PodTemplateNested(Template item) {
      this.builder = new TemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunSpecFluent.this.withPodTemplate(builder.build());
    }
    
    public N endPodTemplate() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends PipelineResourceBindingFluent<ResourcesNested<N>> implements Nested<N>{
  
    PipelineResourceBindingBuilder builder;
    int index;
  
    ResourcesNested(int index,PipelineResourceBinding item) {
      this.index = index;
      this.builder = new PipelineResourceBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunSpecFluent.this.setToResources(index, builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
  public class TaskRunSpecsNested<N> extends PipelineTaskRunSpecFluent<TaskRunSpecsNested<N>> implements Nested<N>{
  
    PipelineTaskRunSpecBuilder builder;
    int index;
  
    TaskRunSpecsNested(int index,PipelineTaskRunSpec item) {
      this.index = index;
      this.builder = new PipelineTaskRunSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunSpecFluent.this.setToTaskRunSpecs(index, builder.build());
    }
    
    public N endTaskRunSpec() {
      return and();
    }
    
  }
  public class TimeoutsNested<N> extends TimeoutFieldsFluent<TimeoutsNested<N>> implements Nested<N>{
  
    TimeoutFieldsBuilder builder;
  
    TimeoutsNested(TimeoutFields item) {
      this.builder = new TimeoutFieldsBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunSpecFluent.this.withTimeouts(builder.build());
    }
    
    public N endTimeouts() {
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
      return (N) PipelineRunSpecFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}