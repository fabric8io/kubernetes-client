package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
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
public class PipelineTaskFluent<A extends io.fabric8.tekton.v1beta1.PipelineTaskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private String displayName;
  private MatrixBuilder matrix;
  private String name;
  private String onError;
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();
  private PipelineRefBuilder pipelineRef;
  private PipelineSpecBuilder pipelineSpec;
  private PipelineTaskResourcesBuilder resources;
  private Integer retries;
  private List<String> runAfter = new ArrayList<String>();
  private TaskRefBuilder taskRef;
  private EmbeddedTaskBuilder taskSpec;
  private Duration timeout;
  private ArrayList<WhenExpressionBuilder> when = new ArrayList<WhenExpressionBuilder>();
  private ArrayList<WorkspacePipelineTaskBindingBuilder> workspaces = new ArrayList<WorkspacePipelineTaskBindingBuilder>();

  public PipelineTaskFluent() {
  }
  
  public PipelineTaskFluent(PipelineTask instance) {
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
  
  public A addAllToRunAfter(Collection<String> items) {
    if (this.runAfter == null) {
      this.runAfter = new ArrayList();
    }
    for (String item : items) {
      this.runAfter.add(item);
    }
    return (A) this;
  }
  
  public A addAllToWhen(Collection<WhenExpression> items) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("when").add(builder);
        this.when.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWorkspaces(Collection<WorkspacePipelineTaskBinding> items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspacePipelineTaskBinding item : items) {
        WorkspacePipelineTaskBindingBuilder builder = new WorkspacePipelineTaskBindingBuilder(item);
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
  
  public WhenNested<A> addNewWhen() {
    return new WhenNested(-1, null);
  }
  
  public WhenNested<A> addNewWhenLike(WhenExpression item) {
    return new WhenNested(-1, item);
  }
  
  public WorkspacesNested<A> addNewWorkspace() {
    return new WorkspacesNested(-1, null);
  }
  
  public A addNewWorkspace(String name,String subPath,String workspace) {
    return (A) this.addToWorkspaces(new WorkspacePipelineTaskBinding(name, subPath, workspace));
  }
  
  public WorkspacesNested<A> addNewWorkspaceLike(WorkspacePipelineTaskBinding item) {
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
  
  public A addToRunAfter(String... items) {
    if (this.runAfter == null) {
      this.runAfter = new ArrayList();
    }
    for (String item : items) {
      this.runAfter.add(item);
    }
    return (A) this;
  }
  
  public A addToRunAfter(int index,String item) {
    if (this.runAfter == null) {
      this.runAfter = new ArrayList();
    }
    this.runAfter.add(index, item);
    return (A) this;
  }
  
  public A addToWhen(WhenExpression... items) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("when").add(builder);
        this.when.add(builder);
    }
    return (A) this;
  }
  
  public A addToWhen(int index,WhenExpression item) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
    if (index < 0 || index >= when.size()) {
        _visitables.get("when").add(builder);
        when.add(builder);
    } else {
        _visitables.get("when").add(builder);
        when.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(WorkspacePipelineTaskBinding... items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspacePipelineTaskBinding item : items) {
        WorkspacePipelineTaskBindingBuilder builder = new WorkspacePipelineTaskBindingBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(int index,WorkspacePipelineTaskBinding item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspacePipelineTaskBindingBuilder builder = new WorkspacePipelineTaskBindingBuilder(item);
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
  
  public WhenExpression buildFirstWhen() {
    return this.when.get(0).build();
  }
  
  public WorkspacePipelineTaskBinding buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public Param buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public WhenExpression buildLastWhen() {
    return this.when.get(when.size() - 1).build();
  }
  
  public WorkspacePipelineTaskBinding buildLastWorkspace() {
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
  
  public WhenExpression buildMatchingWhen(Predicate<WhenExpressionBuilder> predicate) {
      for (WhenExpressionBuilder item : when) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WorkspacePipelineTaskBinding buildMatchingWorkspace(Predicate<WorkspacePipelineTaskBindingBuilder> predicate) {
      for (WorkspacePipelineTaskBindingBuilder item : workspaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Matrix buildMatrix() {
    return this.matrix != null ? this.matrix.build() : null;
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
  
  public PipelineTaskResources buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public TaskRef buildTaskRef() {
    return this.taskRef != null ? this.taskRef.build() : null;
  }
  
  public EmbeddedTask buildTaskSpec() {
    return this.taskSpec != null ? this.taskSpec.build() : null;
  }
  
  public List<WhenExpression> buildWhen() {
    return this.when != null ? build(when) : null;
  }
  
  public WhenExpression buildWhen(int index) {
    return this.when.get(index).build();
  }
  
  public WorkspacePipelineTaskBinding buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspacePipelineTaskBinding> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(PipelineTask instance) {
    instance = instance != null ? instance : new PipelineTask();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withMatrix(instance.getMatrix());
        this.withName(instance.getName());
        this.withOnError(instance.getOnError());
        this.withParams(instance.getParams());
        this.withPipelineRef(instance.getPipelineRef());
        this.withPipelineSpec(instance.getPipelineSpec());
        this.withResources(instance.getResources());
        this.withRetries(instance.getRetries());
        this.withRunAfter(instance.getRunAfter());
        this.withTaskRef(instance.getTaskRef());
        this.withTaskSpec(instance.getTaskSpec());
        this.withTimeout(instance.getTimeout());
        this.withWhen(instance.getWhen());
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
  
  public WhenNested<A> editFirstWhen() {
    if (when.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "when"));
    }
    return this.setNewWhenLike(0, this.buildWhen(0));
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
  
  public WhenNested<A> editLastWhen() {
    int index = when.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "when"));
    }
    return this.setNewWhenLike(index, this.buildWhen(index));
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
  
  public WhenNested<A> editMatchingWhen(Predicate<WhenExpressionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < when.size();i++) {
      if (predicate.test(when.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "when"));
    }
    return this.setNewWhenLike(index, this.buildWhen(index));
  }
  
  public WorkspacesNested<A> editMatchingWorkspace(Predicate<WorkspacePipelineTaskBindingBuilder> predicate) {
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
  
  public MatrixNested<A> editMatrix() {
    return this.withNewMatrixLike(Optional.ofNullable(this.buildMatrix()).orElse(null));
  }
  
  public MatrixNested<A> editOrNewMatrix() {
    return this.withNewMatrixLike(Optional.ofNullable(this.buildMatrix()).orElse(new MatrixBuilder().build()));
  }
  
  public MatrixNested<A> editOrNewMatrixLike(Matrix item) {
    return this.withNewMatrixLike(Optional.ofNullable(this.buildMatrix()).orElse(item));
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
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new PipelineTaskResourcesBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(PipelineTaskResources item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public TaskRefNested<A> editOrNewTaskRef() {
    return this.withNewTaskRefLike(Optional.ofNullable(this.buildTaskRef()).orElse(new TaskRefBuilder().build()));
  }
  
  public TaskRefNested<A> editOrNewTaskRefLike(TaskRef item) {
    return this.withNewTaskRefLike(Optional.ofNullable(this.buildTaskRef()).orElse(item));
  }
  
  public TaskSpecNested<A> editOrNewTaskSpec() {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(new EmbeddedTaskBuilder().build()));
  }
  
  public TaskSpecNested<A> editOrNewTaskSpecLike(EmbeddedTask item) {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(item));
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
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public TaskRefNested<A> editTaskRef() {
    return this.withNewTaskRefLike(Optional.ofNullable(this.buildTaskRef()).orElse(null));
  }
  
  public TaskSpecNested<A> editTaskSpec() {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(null));
  }
  
  public WhenNested<A> editWhen(int index) {
    if (when.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "when"));
    }
    return this.setNewWhenLike(index, this.buildWhen(index));
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
    PipelineTaskFluent that = (PipelineTaskFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(matrix, that.matrix))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(onError, that.onError))) {
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
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(retries, that.retries))) {
      return false;
    }
    if (!(Objects.equals(runAfter, that.runAfter))) {
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
    if (!(Objects.equals(when, that.when))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getFirstRunAfter() {
    return this.runAfter.get(0);
  }
  
  public String getLastRunAfter() {
    return this.runAfter.get(runAfter.size() - 1);
  }
  
  public String getMatchingRunAfter(Predicate<String> predicate) {
      for (String item : runAfter) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getOnError() {
    return this.onError;
  }
  
  public Integer getRetries() {
    return this.retries;
  }
  
  public List<String> getRunAfter() {
    return this.runAfter;
  }
  
  public String getRunAfter(int index) {
    return this.runAfter.get(index);
  }
  
  public Duration getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRunAfter(Predicate<String> predicate) {
      for (String item : runAfter) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWhen(Predicate<WhenExpressionBuilder> predicate) {
      for (WhenExpressionBuilder item : when) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWorkspace(Predicate<WorkspacePipelineTaskBindingBuilder> predicate) {
      for (WorkspacePipelineTaskBindingBuilder item : workspaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatrix() {
    return this.matrix != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOnError() {
    return this.onError != null;
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
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRetries() {
    return this.retries != null;
  }
  
  public boolean hasRunAfter() {
    return this.runAfter != null && !(this.runAfter.isEmpty());
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
  
  public boolean hasWhen() {
    return this.when != null && !(this.when.isEmpty());
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(description, displayName, matrix, name, onError, params, pipelineRef, pipelineSpec, resources, retries, runAfter, taskRef, taskSpec, timeout, when, workspaces, additionalProperties);
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
  
  public A removeAllFromRunAfter(Collection<String> items) {
    if (this.runAfter == null) {
      return (A) this;
    }
    for (String item : items) {
      this.runAfter.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromWhen(Collection<WhenExpression> items) {
    if (this.when == null) {
      return (A) this;
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("when").remove(builder);
        this.when.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWorkspaces(Collection<WorkspacePipelineTaskBinding> items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspacePipelineTaskBinding item : items) {
        WorkspacePipelineTaskBindingBuilder builder = new WorkspacePipelineTaskBindingBuilder(item);
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
  
  public A removeFromRunAfter(String... items) {
    if (this.runAfter == null) {
      return (A) this;
    }
    for (String item : items) {
      this.runAfter.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromWhen(WhenExpression... items) {
    if (this.when == null) {
      return (A) this;
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("when").remove(builder);
        this.when.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWorkspaces(WorkspacePipelineTaskBinding... items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspacePipelineTaskBinding item : items) {
        WorkspacePipelineTaskBindingBuilder builder = new WorkspacePipelineTaskBindingBuilder(item);
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
  
  public A removeMatchingFromWhen(Predicate<WhenExpressionBuilder> predicate) {
    if (when == null) {
      return (A) this;
    }
    Iterator<WhenExpressionBuilder> each = when.iterator();
    List visitables = _visitables.get("when");
    while (each.hasNext()) {
        WhenExpressionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWorkspaces(Predicate<WorkspacePipelineTaskBindingBuilder> predicate) {
    if (workspaces == null) {
      return (A) this;
    }
    Iterator<WorkspacePipelineTaskBindingBuilder> each = workspaces.iterator();
    List visitables = _visitables.get("workspaces");
    while (each.hasNext()) {
        WorkspacePipelineTaskBindingBuilder builder = each.next();
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
  
  public WhenNested<A> setNewWhenLike(int index,WhenExpression item) {
    return new WhenNested(index, item);
  }
  
  public WorkspacesNested<A> setNewWorkspaceLike(int index,WorkspacePipelineTaskBinding item) {
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
  
  public A setToRunAfter(int index,String item) {
    if (this.runAfter == null) {
      this.runAfter = new ArrayList();
    }
    this.runAfter.set(index, item);
    return (A) this;
  }
  
  public A setToWhen(int index,WhenExpression item) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
    if (index < 0 || index >= when.size()) {
        _visitables.get("when").add(builder);
        when.add(builder);
    } else {
        _visitables.get("when").add(builder);
        when.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWorkspaces(int index,WorkspacePipelineTaskBinding item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspacePipelineTaskBindingBuilder builder = new WorkspacePipelineTaskBindingBuilder(item);
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
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(matrix == null)) {
        sb.append("matrix:");
        sb.append(matrix);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(onError == null)) {
        sb.append("onError:");
        sb.append(onError);
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
    if (!(runAfter == null) && !(runAfter.isEmpty())) {
        sb.append("runAfter:");
        sb.append(runAfter);
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
    if (!(when == null) && !(when.isEmpty())) {
        sb.append("when:");
        sb.append(when);
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withMatrix(Matrix matrix) {
    this._visitables.remove("matrix");
    if (matrix != null) {
        this.matrix = new MatrixBuilder(matrix);
        this._visitables.get("matrix").add(this.matrix);
    } else {
        this.matrix = null;
        this._visitables.get("matrix").remove(this.matrix);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public MatrixNested<A> withNewMatrix() {
    return new MatrixNested(null);
  }
  
  public MatrixNested<A> withNewMatrixLike(Matrix item) {
    return new MatrixNested(item);
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
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(PipelineTaskResources item) {
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
  
  public TaskSpecNested<A> withNewTaskSpecLike(EmbeddedTask item) {
    return new TaskSpecNested(item);
  }
  
  public A withOnError(String onError) {
    this.onError = onError;
    return (A) this;
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
  
  public A withResources(PipelineTaskResources resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new PipelineTaskResourcesBuilder(resources);
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
  
  public A withRunAfter(List<String> runAfter) {
    if (runAfter != null) {
        this.runAfter = new ArrayList();
        for (String item : runAfter) {
          this.addToRunAfter(item);
        }
    } else {
      this.runAfter = null;
    }
    return (A) this;
  }
  
  public A withRunAfter(String... runAfter) {
    if (this.runAfter != null) {
        this.runAfter.clear();
        _visitables.remove("runAfter");
    }
    if (runAfter != null) {
      for (String item : runAfter) {
        this.addToRunAfter(item);
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
  
  public A withTaskSpec(EmbeddedTask taskSpec) {
    this._visitables.remove("taskSpec");
    if (taskSpec != null) {
        this.taskSpec = new EmbeddedTaskBuilder(taskSpec);
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
  
  public A withWhen(List<WhenExpression> when) {
    if (this.when != null) {
      this._visitables.get("when").clear();
    }
    if (when != null) {
        this.when = new ArrayList();
        for (WhenExpression item : when) {
          this.addToWhen(item);
        }
    } else {
      this.when = null;
    }
    return (A) this;
  }
  
  public A withWhen(WhenExpression... when) {
    if (this.when != null) {
        this.when.clear();
        _visitables.remove("when");
    }
    if (when != null) {
      for (WhenExpression item : when) {
        this.addToWhen(item);
      }
    }
    return (A) this;
  }
  
  public A withWorkspaces(List<WorkspacePipelineTaskBinding> workspaces) {
    if (this.workspaces != null) {
      this._visitables.get("workspaces").clear();
    }
    if (workspaces != null) {
        this.workspaces = new ArrayList();
        for (WorkspacePipelineTaskBinding item : workspaces) {
          this.addToWorkspaces(item);
        }
    } else {
      this.workspaces = null;
    }
    return (A) this;
  }
  
  public A withWorkspaces(WorkspacePipelineTaskBinding... workspaces) {
    if (this.workspaces != null) {
        this.workspaces.clear();
        _visitables.remove("workspaces");
    }
    if (workspaces != null) {
      for (WorkspacePipelineTaskBinding item : workspaces) {
        this.addToWorkspaces(item);
      }
    }
    return (A) this;
  }
  public class MatrixNested<N> extends MatrixFluent<MatrixNested<N>> implements Nested<N>{
  
    MatrixBuilder builder;
  
    MatrixNested(Matrix item) {
      this.builder = new MatrixBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskFluent.this.withMatrix(builder.build());
    }
    
    public N endMatrix() {
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
      return (N) PipelineTaskFluent.this.setToParams(index, builder.build());
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
      return (N) PipelineTaskFluent.this.withPipelineRef(builder.build());
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
      return (N) PipelineTaskFluent.this.withPipelineSpec(builder.build());
    }
    
    public N endPipelineSpec() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends PipelineTaskResourcesFluent<ResourcesNested<N>> implements Nested<N>{
  
    PipelineTaskResourcesBuilder builder;
  
    ResourcesNested(PipelineTaskResources item) {
      this.builder = new PipelineTaskResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class TaskRefNested<N> extends TaskRefFluent<TaskRefNested<N>> implements Nested<N>{
  
    TaskRefBuilder builder;
  
    TaskRefNested(TaskRef item) {
      this.builder = new TaskRefBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskFluent.this.withTaskRef(builder.build());
    }
    
    public N endTaskRef() {
      return and();
    }
    
  }
  public class TaskSpecNested<N> extends EmbeddedTaskFluent<TaskSpecNested<N>> implements Nested<N>{
  
    EmbeddedTaskBuilder builder;
  
    TaskSpecNested(EmbeddedTask item) {
      this.builder = new EmbeddedTaskBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskFluent.this.withTaskSpec(builder.build());
    }
    
    public N endTaskSpec() {
      return and();
    }
    
  }
  public class WhenNested<N> extends WhenExpressionFluent<WhenNested<N>> implements Nested<N>{
  
    WhenExpressionBuilder builder;
    int index;
  
    WhenNested(int index,WhenExpression item) {
      this.index = index;
      this.builder = new WhenExpressionBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskFluent.this.setToWhen(index, builder.build());
    }
    
    public N endWhen() {
      return and();
    }
    
  }
  public class WorkspacesNested<N> extends WorkspacePipelineTaskBindingFluent<WorkspacesNested<N>> implements Nested<N>{
  
    WorkspacePipelineTaskBindingBuilder builder;
    int index;
  
    WorkspacesNested(int index,WorkspacePipelineTaskBinding item) {
      this.index = index;
      this.builder = new WorkspacePipelineTaskBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}