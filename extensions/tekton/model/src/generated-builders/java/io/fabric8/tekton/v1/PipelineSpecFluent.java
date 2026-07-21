package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class PipelineSpecFluent<A extends io.fabric8.tekton.v1.PipelineSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<PipelineTaskBuilder> _finally = new ArrayList<PipelineTaskBuilder>();
  private Map<String,Object> additionalProperties;
  private String description;
  private String displayName;
  private ArrayList<ParamSpecBuilder> params = new ArrayList<ParamSpecBuilder>();
  private ArrayList<PipelineResultBuilder> results = new ArrayList<PipelineResultBuilder>();
  private ArrayList<PipelineTaskBuilder> tasks = new ArrayList<PipelineTaskBuilder>();
  private ArrayList<PipelineWorkspaceDeclarationBuilder> workspaces = new ArrayList<PipelineWorkspaceDeclarationBuilder>();

  public PipelineSpecFluent() {
  }
  
  public PipelineSpecFluent(PipelineSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToFinally(Collection<PipelineTask> items) {
    if (this._finally == null) {
      this._finally = new ArrayList();
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("_finally").add(builder);
        this._finally.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToParams(Collection<ParamSpec> items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResults(Collection<PipelineResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (PipelineResult item : items) {
        PipelineResultBuilder builder = new PipelineResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTasks(Collection<PipelineTask> items) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("tasks").add(builder);
        this.tasks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWorkspaces(Collection<PipelineWorkspaceDeclaration> items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (PipelineWorkspaceDeclaration item : items) {
        PipelineWorkspaceDeclarationBuilder builder = new PipelineWorkspaceDeclarationBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public FinallyNested<A> addNewFinally() {
    return new FinallyNested(-1, null);
  }
  
  public FinallyNested<A> addNewFinallyLike(PipelineTask item) {
    return new FinallyNested(-1, item);
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public ParamsNested<A> addNewParamLike(ParamSpec item) {
    return new ParamsNested(-1, item);
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public ResultsNested<A> addNewResultLike(PipelineResult item) {
    return new ResultsNested(-1, item);
  }
  
  public TasksNested<A> addNewTask() {
    return new TasksNested(-1, null);
  }
  
  public TasksNested<A> addNewTaskLike(PipelineTask item) {
    return new TasksNested(-1, item);
  }
  
  public WorkspacesNested<A> addNewWorkspace() {
    return new WorkspacesNested(-1, null);
  }
  
  public A addNewWorkspace(String description,String name,Boolean optional) {
    return (A) this.addToWorkspaces(new PipelineWorkspaceDeclaration(description, name, optional));
  }
  
  public WorkspacesNested<A> addNewWorkspaceLike(PipelineWorkspaceDeclaration item) {
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
  
  public A addToFinally(PipelineTask... items) {
    if (this._finally == null) {
      this._finally = new ArrayList();
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("_finally").add(builder);
        this._finally.add(builder);
    }
    return (A) this;
  }
  
  public A addToFinally(int index,PipelineTask item) {
    if (this._finally == null) {
      this._finally = new ArrayList();
    }
    PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
    if (index < 0 || index >= _finally.size()) {
        _visitables.get("_finally").add(builder);
        _finally.add(builder);
    } else {
        _visitables.get("_finally").add(builder);
        _finally.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToParams(ParamSpec... items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addToParams(int index,ParamSpec item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamSpecBuilder builder = new ParamSpecBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResults(PipelineResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (PipelineResult item : items) {
        PipelineResultBuilder builder = new PipelineResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,PipelineResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    PipelineResultBuilder builder = new PipelineResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTasks(PipelineTask... items) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("tasks").add(builder);
        this.tasks.add(builder);
    }
    return (A) this;
  }
  
  public A addToTasks(int index,PipelineTask item) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
    if (index < 0 || index >= tasks.size()) {
        _visitables.get("tasks").add(builder);
        tasks.add(builder);
    } else {
        _visitables.get("tasks").add(builder);
        tasks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(PipelineWorkspaceDeclaration... items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (PipelineWorkspaceDeclaration item : items) {
        PipelineWorkspaceDeclarationBuilder builder = new PipelineWorkspaceDeclarationBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(int index,PipelineWorkspaceDeclaration item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    PipelineWorkspaceDeclarationBuilder builder = new PipelineWorkspaceDeclarationBuilder(item);
    if (index < 0 || index >= workspaces.size()) {
        _visitables.get("workspaces").add(builder);
        workspaces.add(builder);
    } else {
        _visitables.get("workspaces").add(builder);
        workspaces.add(index, builder);
    }
    return (A) this;
  }
  
  public List<PipelineTask> buildFinally() {
    return this._finally != null ? build(_finally) : null;
  }
  
  public PipelineTask buildFinally(int index) {
    return this._finally.get(index).build();
  }
  
  public PipelineTask buildFirstFinally() {
    return this._finally.get(0).build();
  }
  
  public ParamSpec buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public PipelineResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public PipelineTask buildFirstTask() {
    return this.tasks.get(0).build();
  }
  
  public PipelineWorkspaceDeclaration buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public PipelineTask buildLastFinally() {
    return this._finally.get(_finally.size() - 1).build();
  }
  
  public ParamSpec buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public PipelineResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public PipelineTask buildLastTask() {
    return this.tasks.get(tasks.size() - 1).build();
  }
  
  public PipelineWorkspaceDeclaration buildLastWorkspace() {
    return this.workspaces.get(workspaces.size() - 1).build();
  }
  
  public PipelineTask buildMatchingFinally(Predicate<PipelineTaskBuilder> predicate) {
      for (PipelineTaskBuilder item : _finally) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ParamSpec buildMatchingParam(Predicate<ParamSpecBuilder> predicate) {
      for (ParamSpecBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineResult buildMatchingResult(Predicate<PipelineResultBuilder> predicate) {
      for (PipelineResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineTask buildMatchingTask(Predicate<PipelineTaskBuilder> predicate) {
      for (PipelineTaskBuilder item : tasks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineWorkspaceDeclaration buildMatchingWorkspace(Predicate<PipelineWorkspaceDeclarationBuilder> predicate) {
      for (PipelineWorkspaceDeclarationBuilder item : workspaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ParamSpec buildParam(int index) {
    return this.params.get(index).build();
  }
  
  public List<ParamSpec> buildParams() {
    return this.params != null ? build(params) : null;
  }
  
  public PipelineResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<PipelineResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  public PipelineTask buildTask(int index) {
    return this.tasks.get(index).build();
  }
  
  public List<PipelineTask> buildTasks() {
    return this.tasks != null ? build(tasks) : null;
  }
  
  public PipelineWorkspaceDeclaration buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<PipelineWorkspaceDeclaration> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(PipelineSpec instance) {
    instance = instance != null ? instance : new PipelineSpec();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withFinally(instance.getFinally());
        this.withParams(instance.getParams());
        this.withResults(instance.getResults());
        this.withTasks(instance.getTasks());
        this.withWorkspaces(instance.getWorkspaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FinallyNested<A> editFinally(int index) {
    if (_finally.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "_finally"));
    }
    return this.setNewFinallyLike(index, this.buildFinally(index));
  }
  
  public FinallyNested<A> editFirstFinally() {
    if (_finally.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "_finally"));
    }
    return this.setNewFinallyLike(0, this.buildFinally(0));
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public TasksNested<A> editFirstTask() {
    if (tasks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tasks"));
    }
    return this.setNewTaskLike(0, this.buildTask(0));
  }
  
  public WorkspacesNested<A> editFirstWorkspace() {
    if (workspaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "workspaces"));
    }
    return this.setNewWorkspaceLike(0, this.buildWorkspace(0));
  }
  
  public FinallyNested<A> editLastFinally() {
    int index = _finally.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "_finally"));
    }
    return this.setNewFinallyLike(index, this.buildFinally(index));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public TasksNested<A> editLastTask() {
    int index = tasks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public WorkspacesNested<A> editLastWorkspace() {
    int index = workspaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "workspaces"));
    }
    return this.setNewWorkspaceLike(index, this.buildWorkspace(index));
  }
  
  public FinallyNested<A> editMatchingFinally(Predicate<PipelineTaskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < _finally.size();i++) {
      if (predicate.test(_finally.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "_finally"));
    }
    return this.setNewFinallyLike(index, this.buildFinally(index));
  }
  
  public ParamsNested<A> editMatchingParam(Predicate<ParamSpecBuilder> predicate) {
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
  
  public ResultsNested<A> editMatchingResult(Predicate<PipelineResultBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < results.size();i++) {
      if (predicate.test(results.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public TasksNested<A> editMatchingTask(Predicate<PipelineTaskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tasks.size();i++) {
      if (predicate.test(tasks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public WorkspacesNested<A> editMatchingWorkspace(Predicate<PipelineWorkspaceDeclarationBuilder> predicate) {
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
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public ResultsNested<A> editResult(int index) {
    if (results.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public TasksNested<A> editTask(int index) {
    if (tasks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
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
    PipelineSpecFluent that = (PipelineSpecFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(_finally, that._finally))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(tasks, that.tasks))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasFinally() {
    return this._finally != null && !(this._finally.isEmpty());
  }
  
  public boolean hasMatchingFinally(Predicate<PipelineTaskBuilder> predicate) {
      for (PipelineTaskBuilder item : _finally) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingParam(Predicate<ParamSpecBuilder> predicate) {
      for (ParamSpecBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResult(Predicate<PipelineResultBuilder> predicate) {
      for (PipelineResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTask(Predicate<PipelineTaskBuilder> predicate) {
      for (PipelineTaskBuilder item : tasks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWorkspace(Predicate<PipelineWorkspaceDeclarationBuilder> predicate) {
      for (PipelineWorkspaceDeclarationBuilder item : workspaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParams() {
    return this.params != null && !(this.params.isEmpty());
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public boolean hasTasks() {
    return this.tasks != null && !(this.tasks.isEmpty());
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(description, displayName, _finally, params, results, tasks, workspaces, additionalProperties);
  }
  
  public A removeAllFromFinally(Collection<PipelineTask> items) {
    if (this._finally == null) {
      return (A) this;
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("_finally").remove(builder);
        this._finally.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromParams(Collection<ParamSpec> items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResults(Collection<PipelineResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (PipelineResult item : items) {
        PipelineResultBuilder builder = new PipelineResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTasks(Collection<PipelineTask> items) {
    if (this.tasks == null) {
      return (A) this;
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("tasks").remove(builder);
        this.tasks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWorkspaces(Collection<PipelineWorkspaceDeclaration> items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (PipelineWorkspaceDeclaration item : items) {
        PipelineWorkspaceDeclarationBuilder builder = new PipelineWorkspaceDeclarationBuilder(item);
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
  
  public A removeFromFinally(PipelineTask... items) {
    if (this._finally == null) {
      return (A) this;
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("_finally").remove(builder);
        this._finally.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromParams(ParamSpec... items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResults(PipelineResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (PipelineResult item : items) {
        PipelineResultBuilder builder = new PipelineResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTasks(PipelineTask... items) {
    if (this.tasks == null) {
      return (A) this;
    }
    for (PipelineTask item : items) {
        PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
        _visitables.get("tasks").remove(builder);
        this.tasks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWorkspaces(PipelineWorkspaceDeclaration... items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (PipelineWorkspaceDeclaration item : items) {
        PipelineWorkspaceDeclarationBuilder builder = new PipelineWorkspaceDeclarationBuilder(item);
        _visitables.get("workspaces").remove(builder);
        this.workspaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFinally(Predicate<PipelineTaskBuilder> predicate) {
    if (_finally == null) {
      return (A) this;
    }
    Iterator<PipelineTaskBuilder> each = _finally.iterator();
    List visitables = _visitables.get("_finally");
    while (each.hasNext()) {
        PipelineTaskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromParams(Predicate<ParamSpecBuilder> predicate) {
    if (params == null) {
      return (A) this;
    }
    Iterator<ParamSpecBuilder> each = params.iterator();
    List visitables = _visitables.get("params");
    while (each.hasNext()) {
        ParamSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<PipelineResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<PipelineResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        PipelineResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTasks(Predicate<PipelineTaskBuilder> predicate) {
    if (tasks == null) {
      return (A) this;
    }
    Iterator<PipelineTaskBuilder> each = tasks.iterator();
    List visitables = _visitables.get("tasks");
    while (each.hasNext()) {
        PipelineTaskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWorkspaces(Predicate<PipelineWorkspaceDeclarationBuilder> predicate) {
    if (workspaces == null) {
      return (A) this;
    }
    Iterator<PipelineWorkspaceDeclarationBuilder> each = workspaces.iterator();
    List visitables = _visitables.get("workspaces");
    while (each.hasNext()) {
        PipelineWorkspaceDeclarationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FinallyNested<A> setNewFinallyLike(int index,PipelineTask item) {
    return new FinallyNested(index, item);
  }
  
  public ParamsNested<A> setNewParamLike(int index,ParamSpec item) {
    return new ParamsNested(index, item);
  }
  
  public ResultsNested<A> setNewResultLike(int index,PipelineResult item) {
    return new ResultsNested(index, item);
  }
  
  public TasksNested<A> setNewTaskLike(int index,PipelineTask item) {
    return new TasksNested(index, item);
  }
  
  public WorkspacesNested<A> setNewWorkspaceLike(int index,PipelineWorkspaceDeclaration item) {
    return new WorkspacesNested(index, item);
  }
  
  public A setToFinally(int index,PipelineTask item) {
    if (this._finally == null) {
      this._finally = new ArrayList();
    }
    PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
    if (index < 0 || index >= _finally.size()) {
        _visitables.get("_finally").add(builder);
        _finally.add(builder);
    } else {
        _visitables.get("_finally").add(builder);
        _finally.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToParams(int index,ParamSpec item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamSpecBuilder builder = new ParamSpecBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResults(int index,PipelineResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    PipelineResultBuilder builder = new PipelineResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTasks(int index,PipelineTask item) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    PipelineTaskBuilder builder = new PipelineTaskBuilder(item);
    if (index < 0 || index >= tasks.size()) {
        _visitables.get("tasks").add(builder);
        tasks.add(builder);
    } else {
        _visitables.get("tasks").add(builder);
        tasks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWorkspaces(int index,PipelineWorkspaceDeclaration item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    PipelineWorkspaceDeclarationBuilder builder = new PipelineWorkspaceDeclarationBuilder(item);
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
    if (!(_finally == null) && !(_finally.isEmpty())) {
        sb.append("_finally:");
        sb.append(_finally);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
        sb.append(",");
    }
    if (!(results == null) && !(results.isEmpty())) {
        sb.append("results:");
        sb.append(results);
        sb.append(",");
    }
    if (!(tasks == null) && !(tasks.isEmpty())) {
        sb.append("tasks:");
        sb.append(tasks);
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
  
  public A withFinally(List<PipelineTask> _finally) {
    if (this._finally != null) {
      this._visitables.get("_finally").clear();
    }
    if (_finally != null) {
        this._finally = new ArrayList();
        for (PipelineTask item : _finally) {
          this.addToFinally(item);
        }
    } else {
      this._finally = null;
    }
    return (A) this;
  }
  
  public A withFinally(PipelineTask... _finally) {
    if (this._finally != null) {
        this._finally.clear();
        _visitables.remove("_finally");
    }
    if (_finally != null) {
      for (PipelineTask item : _finally) {
        this.addToFinally(item);
      }
    }
    return (A) this;
  }
  
  public A withParams(List<ParamSpec> params) {
    if (this.params != null) {
      this._visitables.get("params").clear();
    }
    if (params != null) {
        this.params = new ArrayList();
        for (ParamSpec item : params) {
          this.addToParams(item);
        }
    } else {
      this.params = null;
    }
    return (A) this;
  }
  
  public A withParams(ParamSpec... params) {
    if (this.params != null) {
        this.params.clear();
        _visitables.remove("params");
    }
    if (params != null) {
      for (ParamSpec item : params) {
        this.addToParams(item);
      }
    }
    return (A) this;
  }
  
  public A withResults(List<PipelineResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (PipelineResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(PipelineResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (PipelineResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withTasks(List<PipelineTask> tasks) {
    if (this.tasks != null) {
      this._visitables.get("tasks").clear();
    }
    if (tasks != null) {
        this.tasks = new ArrayList();
        for (PipelineTask item : tasks) {
          this.addToTasks(item);
        }
    } else {
      this.tasks = null;
    }
    return (A) this;
  }
  
  public A withTasks(PipelineTask... tasks) {
    if (this.tasks != null) {
        this.tasks.clear();
        _visitables.remove("tasks");
    }
    if (tasks != null) {
      for (PipelineTask item : tasks) {
        this.addToTasks(item);
      }
    }
    return (A) this;
  }
  
  public A withWorkspaces(List<PipelineWorkspaceDeclaration> workspaces) {
    if (this.workspaces != null) {
      this._visitables.get("workspaces").clear();
    }
    if (workspaces != null) {
        this.workspaces = new ArrayList();
        for (PipelineWorkspaceDeclaration item : workspaces) {
          this.addToWorkspaces(item);
        }
    } else {
      this.workspaces = null;
    }
    return (A) this;
  }
  
  public A withWorkspaces(PipelineWorkspaceDeclaration... workspaces) {
    if (this.workspaces != null) {
        this.workspaces.clear();
        _visitables.remove("workspaces");
    }
    if (workspaces != null) {
      for (PipelineWorkspaceDeclaration item : workspaces) {
        this.addToWorkspaces(item);
      }
    }
    return (A) this;
  }
  public class FinallyNested<N> extends PipelineTaskFluent<FinallyNested<N>> implements Nested<N>{
  
    PipelineTaskBuilder builder;
    int index;
  
    FinallyNested(int index,PipelineTask item) {
      this.index = index;
      this.builder = new PipelineTaskBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineSpecFluent.this.setToFinally(index, builder.build());
    }
    
    public N endFinally() {
      return and();
    }
    
  }
  public class ParamsNested<N> extends ParamSpecFluent<ParamsNested<N>> implements Nested<N>{
  
    ParamSpecBuilder builder;
    int index;
  
    ParamsNested(int index,ParamSpec item) {
      this.index = index;
      this.builder = new ParamSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class ResultsNested<N> extends PipelineResultFluent<ResultsNested<N>> implements Nested<N>{
  
    PipelineResultBuilder builder;
    int index;
  
    ResultsNested(int index,PipelineResult item) {
      this.index = index;
      this.builder = new PipelineResultBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineSpecFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
  public class TasksNested<N> extends PipelineTaskFluent<TasksNested<N>> implements Nested<N>{
  
    PipelineTaskBuilder builder;
    int index;
  
    TasksNested(int index,PipelineTask item) {
      this.index = index;
      this.builder = new PipelineTaskBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineSpecFluent.this.setToTasks(index, builder.build());
    }
    
    public N endTask() {
      return and();
    }
    
  }
  public class WorkspacesNested<N> extends PipelineWorkspaceDeclarationFluent<WorkspacesNested<N>> implements Nested<N>{
  
    PipelineWorkspaceDeclarationBuilder builder;
    int index;
  
    WorkspacesNested(int index,PipelineWorkspaceDeclaration item) {
      this.index = index;
      this.builder = new PipelineWorkspaceDeclarationBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineSpecFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}