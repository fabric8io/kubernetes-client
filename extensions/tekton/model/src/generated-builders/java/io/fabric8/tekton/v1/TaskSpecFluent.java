package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TaskSpecFluent<A extends io.fabric8.tekton.v1.TaskSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private String displayName;
  private ArrayList<ParamSpecBuilder> params = new ArrayList<ParamSpecBuilder>();
  private ArrayList<TaskResultBuilder> results = new ArrayList<TaskResultBuilder>();
  private ArrayList<SidecarBuilder> sidecars = new ArrayList<SidecarBuilder>();
  private StepTemplateBuilder stepTemplate;
  private ArrayList<StepBuilder> steps = new ArrayList<StepBuilder>();
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();
  private ArrayList<WorkspaceDeclarationBuilder> workspaces = new ArrayList<WorkspaceDeclarationBuilder>();

  public TaskSpecFluent() {
  }
  
  public TaskSpecFluent(TaskSpec instance) {
    this.copyInstance(instance);
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
  
  public A addAllToResults(Collection<TaskResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (TaskResult item : items) {
        TaskResultBuilder builder = new TaskResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSidecars(Collection<Sidecar> items) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    for (Sidecar item : items) {
        SidecarBuilder builder = new SidecarBuilder(item);
        _visitables.get("sidecars").add(builder);
        this.sidecars.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSteps(Collection<Step> items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumes(Collection<Volume> items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWorkspaces(Collection<WorkspaceDeclaration> items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspaceDeclaration item : items) {
        WorkspaceDeclarationBuilder builder = new WorkspaceDeclarationBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
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
  
  public ResultsNested<A> addNewResultLike(TaskResult item) {
    return new ResultsNested(-1, item);
  }
  
  public SidecarsNested<A> addNewSidecar() {
    return new SidecarsNested(-1, null);
  }
  
  public SidecarsNested<A> addNewSidecarLike(Sidecar item) {
    return new SidecarsNested(-1, item);
  }
  
  public StepsNested<A> addNewStep() {
    return new StepsNested(-1, null);
  }
  
  public StepsNested<A> addNewStepLike(Step item) {
    return new StepsNested(-1, item);
  }
  
  public VolumesNested<A> addNewVolume() {
    return new VolumesNested(-1, null);
  }
  
  public VolumesNested<A> addNewVolumeLike(Volume item) {
    return new VolumesNested(-1, item);
  }
  
  public WorkspacesNested<A> addNewWorkspace() {
    return new WorkspacesNested(-1, null);
  }
  
  public A addNewWorkspace(String description,String mountPath,String name,Boolean optional,Boolean readOnly) {
    return (A) this.addToWorkspaces(new WorkspaceDeclaration(description, mountPath, name, optional, readOnly));
  }
  
  public WorkspacesNested<A> addNewWorkspaceLike(WorkspaceDeclaration item) {
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
  
  public A addToResults(TaskResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (TaskResult item : items) {
        TaskResultBuilder builder = new TaskResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,TaskResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    TaskResultBuilder builder = new TaskResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSidecars(Sidecar... items) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    for (Sidecar item : items) {
        SidecarBuilder builder = new SidecarBuilder(item);
        _visitables.get("sidecars").add(builder);
        this.sidecars.add(builder);
    }
    return (A) this;
  }
  
  public A addToSidecars(int index,Sidecar item) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    SidecarBuilder builder = new SidecarBuilder(item);
    if (index < 0 || index >= sidecars.size()) {
        _visitables.get("sidecars").add(builder);
        sidecars.add(builder);
    } else {
        _visitables.get("sidecars").add(builder);
        sidecars.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSteps(Step... items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public A addToSteps(int index,Step item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= steps.size()) {
        _visitables.get("steps").add(builder);
        steps.add(builder);
    } else {
        _visitables.get("steps").add(builder);
        steps.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(Volume... items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(int index,Volume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeBuilder builder = new VolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(WorkspaceDeclaration... items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspaceDeclaration item : items) {
        WorkspaceDeclarationBuilder builder = new WorkspaceDeclarationBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(int index,WorkspaceDeclaration item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspaceDeclarationBuilder builder = new WorkspaceDeclarationBuilder(item);
    if (index < 0 || index >= workspaces.size()) {
        _visitables.get("workspaces").add(builder);
        workspaces.add(builder);
    } else {
        _visitables.get("workspaces").add(builder);
        workspaces.add(index, builder);
    }
    return (A) this;
  }
  
  public ParamSpec buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public TaskResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public Sidecar buildFirstSidecar() {
    return this.sidecars.get(0).build();
  }
  
  public Step buildFirstStep() {
    return this.steps.get(0).build();
  }
  
  public Volume buildFirstVolume() {
    return this.volumes.get(0).build();
  }
  
  public WorkspaceDeclaration buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public ParamSpec buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public TaskResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public Sidecar buildLastSidecar() {
    return this.sidecars.get(sidecars.size() - 1).build();
  }
  
  public Step buildLastStep() {
    return this.steps.get(steps.size() - 1).build();
  }
  
  public Volume buildLastVolume() {
    return this.volumes.get(volumes.size() - 1).build();
  }
  
  public WorkspaceDeclaration buildLastWorkspace() {
    return this.workspaces.get(workspaces.size() - 1).build();
  }
  
  public ParamSpec buildMatchingParam(Predicate<ParamSpecBuilder> predicate) {
      for (ParamSpecBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskResult buildMatchingResult(Predicate<TaskResultBuilder> predicate) {
      for (TaskResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Sidecar buildMatchingSidecar(Predicate<SidecarBuilder> predicate) {
      for (SidecarBuilder item : sidecars) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Step buildMatchingStep(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : steps) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Volume buildMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WorkspaceDeclaration buildMatchingWorkspace(Predicate<WorkspaceDeclarationBuilder> predicate) {
      for (WorkspaceDeclarationBuilder item : workspaces) {
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
  
  public TaskResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<TaskResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  public Sidecar buildSidecar(int index) {
    return this.sidecars.get(index).build();
  }
  
  public List<Sidecar> buildSidecars() {
    return this.sidecars != null ? build(sidecars) : null;
  }
  
  public Step buildStep(int index) {
    return this.steps.get(index).build();
  }
  
  public StepTemplate buildStepTemplate() {
    return this.stepTemplate != null ? this.stepTemplate.build() : null;
  }
  
  public List<Step> buildSteps() {
    return this.steps != null ? build(steps) : null;
  }
  
  public Volume buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public List<Volume> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  public WorkspaceDeclaration buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspaceDeclaration> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(TaskSpec instance) {
    instance = instance != null ? instance : new TaskSpec();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withParams(instance.getParams());
        this.withResults(instance.getResults());
        this.withSidecars(instance.getSidecars());
        this.withStepTemplate(instance.getStepTemplate());
        this.withSteps(instance.getSteps());
        this.withVolumes(instance.getVolumes());
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
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public SidecarsNested<A> editFirstSidecar() {
    if (sidecars.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sidecars"));
    }
    return this.setNewSidecarLike(0, this.buildSidecar(0));
  }
  
  public StepsNested<A> editFirstStep() {
    if (steps.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(0, this.buildStep(0));
  }
  
  public VolumesNested<A> editFirstVolume() {
    if (volumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(0, this.buildVolume(0));
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
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public SidecarsNested<A> editLastSidecar() {
    int index = sidecars.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sidecars"));
    }
    return this.setNewSidecarLike(index, this.buildSidecar(index));
  }
  
  public StepsNested<A> editLastStep() {
    int index = steps.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public VolumesNested<A> editLastVolume() {
    int index = volumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public WorkspacesNested<A> editLastWorkspace() {
    int index = workspaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "workspaces"));
    }
    return this.setNewWorkspaceLike(index, this.buildWorkspace(index));
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
  
  public ResultsNested<A> editMatchingResult(Predicate<TaskResultBuilder> predicate) {
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
  
  public SidecarsNested<A> editMatchingSidecar(Predicate<SidecarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sidecars.size();i++) {
      if (predicate.test(sidecars.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sidecars"));
    }
    return this.setNewSidecarLike(index, this.buildSidecar(index));
  }
  
  public StepsNested<A> editMatchingStep(Predicate<StepBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < steps.size();i++) {
      if (predicate.test(steps.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public VolumesNested<A> editMatchingVolume(Predicate<VolumeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumes.size();i++) {
      if (predicate.test(volumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public WorkspacesNested<A> editMatchingWorkspace(Predicate<WorkspaceDeclarationBuilder> predicate) {
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
  
  public StepTemplateNested<A> editOrNewStepTemplate() {
    return this.withNewStepTemplateLike(Optional.ofNullable(this.buildStepTemplate()).orElse(new StepTemplateBuilder().build()));
  }
  
  public StepTemplateNested<A> editOrNewStepTemplateLike(StepTemplate item) {
    return this.withNewStepTemplateLike(Optional.ofNullable(this.buildStepTemplate()).orElse(item));
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
  
  public SidecarsNested<A> editSidecar(int index) {
    if (sidecars.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sidecars"));
    }
    return this.setNewSidecarLike(index, this.buildSidecar(index));
  }
  
  public StepsNested<A> editStep(int index) {
    if (steps.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public StepTemplateNested<A> editStepTemplate() {
    return this.withNewStepTemplateLike(Optional.ofNullable(this.buildStepTemplate()).orElse(null));
  }
  
  public VolumesNested<A> editVolume(int index) {
    if (volumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
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
    TaskSpecFluent that = (TaskSpecFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(sidecars, that.sidecars))) {
      return false;
    }
    if (!(Objects.equals(stepTemplate, that.stepTemplate))) {
      return false;
    }
    if (!(Objects.equals(steps, that.steps))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
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
  
  public boolean hasMatchingParam(Predicate<ParamSpecBuilder> predicate) {
      for (ParamSpecBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResult(Predicate<TaskResultBuilder> predicate) {
      for (TaskResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSidecar(Predicate<SidecarBuilder> predicate) {
      for (SidecarBuilder item : sidecars) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStep(Predicate<StepBuilder> predicate) {
      for (StepBuilder item : steps) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWorkspace(Predicate<WorkspaceDeclarationBuilder> predicate) {
      for (WorkspaceDeclarationBuilder item : workspaces) {
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
  
  public boolean hasSidecars() {
    return this.sidecars != null && !(this.sidecars.isEmpty());
  }
  
  public boolean hasStepTemplate() {
    return this.stepTemplate != null;
  }
  
  public boolean hasSteps() {
    return this.steps != null && !(this.steps.isEmpty());
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(description, displayName, params, results, sidecars, stepTemplate, steps, volumes, workspaces, additionalProperties);
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
  
  public A removeAllFromResults(Collection<TaskResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (TaskResult item : items) {
        TaskResultBuilder builder = new TaskResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSidecars(Collection<Sidecar> items) {
    if (this.sidecars == null) {
      return (A) this;
    }
    for (Sidecar item : items) {
        SidecarBuilder builder = new SidecarBuilder(item);
        _visitables.get("sidecars").remove(builder);
        this.sidecars.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSteps(Collection<Step> items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("steps").remove(builder);
        this.steps.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumes(Collection<Volume> items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWorkspaces(Collection<WorkspaceDeclaration> items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspaceDeclaration item : items) {
        WorkspaceDeclarationBuilder builder = new WorkspaceDeclarationBuilder(item);
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
  
  public A removeFromResults(TaskResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (TaskResult item : items) {
        TaskResultBuilder builder = new TaskResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSidecars(Sidecar... items) {
    if (this.sidecars == null) {
      return (A) this;
    }
    for (Sidecar item : items) {
        SidecarBuilder builder = new SidecarBuilder(item);
        _visitables.get("sidecars").remove(builder);
        this.sidecars.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSteps(Step... items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (Step item : items) {
        StepBuilder builder = new StepBuilder(item);
        _visitables.get("steps").remove(builder);
        this.steps.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVolumes(Volume... items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWorkspaces(WorkspaceDeclaration... items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspaceDeclaration item : items) {
        WorkspaceDeclarationBuilder builder = new WorkspaceDeclarationBuilder(item);
        _visitables.get("workspaces").remove(builder);
        this.workspaces.remove(builder);
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
  
  public A removeMatchingFromResults(Predicate<TaskResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<TaskResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        TaskResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSidecars(Predicate<SidecarBuilder> predicate) {
    if (sidecars == null) {
      return (A) this;
    }
    Iterator<SidecarBuilder> each = sidecars.iterator();
    List visitables = _visitables.get("sidecars");
    while (each.hasNext()) {
        SidecarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSteps(Predicate<StepBuilder> predicate) {
    if (steps == null) {
      return (A) this;
    }
    Iterator<StepBuilder> each = steps.iterator();
    List visitables = _visitables.get("steps");
    while (each.hasNext()) {
        StepBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumes(Predicate<VolumeBuilder> predicate) {
    if (volumes == null) {
      return (A) this;
    }
    Iterator<VolumeBuilder> each = volumes.iterator();
    List visitables = _visitables.get("volumes");
    while (each.hasNext()) {
        VolumeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWorkspaces(Predicate<WorkspaceDeclarationBuilder> predicate) {
    if (workspaces == null) {
      return (A) this;
    }
    Iterator<WorkspaceDeclarationBuilder> each = workspaces.iterator();
    List visitables = _visitables.get("workspaces");
    while (each.hasNext()) {
        WorkspaceDeclarationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParamsNested<A> setNewParamLike(int index,ParamSpec item) {
    return new ParamsNested(index, item);
  }
  
  public ResultsNested<A> setNewResultLike(int index,TaskResult item) {
    return new ResultsNested(index, item);
  }
  
  public SidecarsNested<A> setNewSidecarLike(int index,Sidecar item) {
    return new SidecarsNested(index, item);
  }
  
  public StepsNested<A> setNewStepLike(int index,Step item) {
    return new StepsNested(index, item);
  }
  
  public VolumesNested<A> setNewVolumeLike(int index,Volume item) {
    return new VolumesNested(index, item);
  }
  
  public WorkspacesNested<A> setNewWorkspaceLike(int index,WorkspaceDeclaration item) {
    return new WorkspacesNested(index, item);
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
  
  public A setToResults(int index,TaskResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    TaskResultBuilder builder = new TaskResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSidecars(int index,Sidecar item) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    SidecarBuilder builder = new SidecarBuilder(item);
    if (index < 0 || index >= sidecars.size()) {
        _visitables.get("sidecars").add(builder);
        sidecars.add(builder);
    } else {
        _visitables.get("sidecars").add(builder);
        sidecars.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSteps(int index,Step item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    StepBuilder builder = new StepBuilder(item);
    if (index < 0 || index >= steps.size()) {
        _visitables.get("steps").add(builder);
        steps.add(builder);
    } else {
        _visitables.get("steps").add(builder);
        steps.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumes(int index,Volume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeBuilder builder = new VolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWorkspaces(int index,WorkspaceDeclaration item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspaceDeclarationBuilder builder = new WorkspaceDeclarationBuilder(item);
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
    if (!(sidecars == null) && !(sidecars.isEmpty())) {
        sb.append("sidecars:");
        sb.append(sidecars);
        sb.append(",");
    }
    if (!(stepTemplate == null)) {
        sb.append("stepTemplate:");
        sb.append(stepTemplate);
        sb.append(",");
    }
    if (!(steps == null) && !(steps.isEmpty())) {
        sb.append("steps:");
        sb.append(steps);
        sb.append(",");
    }
    if (!(volumes == null) && !(volumes.isEmpty())) {
        sb.append("volumes:");
        sb.append(volumes);
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
  
  public StepTemplateNested<A> withNewStepTemplate() {
    return new StepTemplateNested(null);
  }
  
  public StepTemplateNested<A> withNewStepTemplateLike(StepTemplate item) {
    return new StepTemplateNested(item);
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
  
  public A withResults(List<TaskResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (TaskResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(TaskResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (TaskResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withSidecars(List<Sidecar> sidecars) {
    if (this.sidecars != null) {
      this._visitables.get("sidecars").clear();
    }
    if (sidecars != null) {
        this.sidecars = new ArrayList();
        for (Sidecar item : sidecars) {
          this.addToSidecars(item);
        }
    } else {
      this.sidecars = null;
    }
    return (A) this;
  }
  
  public A withSidecars(Sidecar... sidecars) {
    if (this.sidecars != null) {
        this.sidecars.clear();
        _visitables.remove("sidecars");
    }
    if (sidecars != null) {
      for (Sidecar item : sidecars) {
        this.addToSidecars(item);
      }
    }
    return (A) this;
  }
  
  public A withStepTemplate(StepTemplate stepTemplate) {
    this._visitables.remove("stepTemplate");
    if (stepTemplate != null) {
        this.stepTemplate = new StepTemplateBuilder(stepTemplate);
        this._visitables.get("stepTemplate").add(this.stepTemplate);
    } else {
        this.stepTemplate = null;
        this._visitables.get("stepTemplate").remove(this.stepTemplate);
    }
    return (A) this;
  }
  
  public A withSteps(List<Step> steps) {
    if (this.steps != null) {
      this._visitables.get("steps").clear();
    }
    if (steps != null) {
        this.steps = new ArrayList();
        for (Step item : steps) {
          this.addToSteps(item);
        }
    } else {
      this.steps = null;
    }
    return (A) this;
  }
  
  public A withSteps(Step... steps) {
    if (this.steps != null) {
        this.steps.clear();
        _visitables.remove("steps");
    }
    if (steps != null) {
      for (Step item : steps) {
        this.addToSteps(item);
      }
    }
    return (A) this;
  }
  
  public A withVolumes(List<Volume> volumes) {
    if (this.volumes != null) {
      this._visitables.get("volumes").clear();
    }
    if (volumes != null) {
        this.volumes = new ArrayList();
        for (Volume item : volumes) {
          this.addToVolumes(item);
        }
    } else {
      this.volumes = null;
    }
    return (A) this;
  }
  
  public A withVolumes(Volume... volumes) {
    if (this.volumes != null) {
        this.volumes.clear();
        _visitables.remove("volumes");
    }
    if (volumes != null) {
      for (Volume item : volumes) {
        this.addToVolumes(item);
      }
    }
    return (A) this;
  }
  
  public A withWorkspaces(List<WorkspaceDeclaration> workspaces) {
    if (this.workspaces != null) {
      this._visitables.get("workspaces").clear();
    }
    if (workspaces != null) {
        this.workspaces = new ArrayList();
        for (WorkspaceDeclaration item : workspaces) {
          this.addToWorkspaces(item);
        }
    } else {
      this.workspaces = null;
    }
    return (A) this;
  }
  
  public A withWorkspaces(WorkspaceDeclaration... workspaces) {
    if (this.workspaces != null) {
        this.workspaces.clear();
        _visitables.remove("workspaces");
    }
    if (workspaces != null) {
      for (WorkspaceDeclaration item : workspaces) {
        this.addToWorkspaces(item);
      }
    }
    return (A) this;
  }
  public class ParamsNested<N> extends ParamSpecFluent<ParamsNested<N>> implements Nested<N>{
  
    ParamSpecBuilder builder;
    int index;
  
    ParamsNested(int index,ParamSpec item) {
      this.index = index;
      this.builder = new ParamSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class ResultsNested<N> extends TaskResultFluent<ResultsNested<N>> implements Nested<N>{
  
    TaskResultBuilder builder;
    int index;
  
    ResultsNested(int index,TaskResult item) {
      this.index = index;
      this.builder = new TaskResultBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
  public class SidecarsNested<N> extends SidecarFluent<SidecarsNested<N>> implements Nested<N>{
  
    SidecarBuilder builder;
    int index;
  
    SidecarsNested(int index,Sidecar item) {
      this.index = index;
      this.builder = new SidecarBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.setToSidecars(index, builder.build());
    }
    
    public N endSidecar() {
      return and();
    }
    
  }
  public class StepTemplateNested<N> extends StepTemplateFluent<StepTemplateNested<N>> implements Nested<N>{
  
    StepTemplateBuilder builder;
  
    StepTemplateNested(StepTemplate item) {
      this.builder = new StepTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.withStepTemplate(builder.build());
    }
    
    public N endStepTemplate() {
      return and();
    }
    
  }
  public class StepsNested<N> extends StepFluent<StepsNested<N>> implements Nested<N>{
  
    StepBuilder builder;
    int index;
  
    StepsNested(int index,Step item) {
      this.index = index;
      this.builder = new StepBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.setToSteps(index, builder.build());
    }
    
    public N endStep() {
      return and();
    }
    
  }
  public class VolumesNested<N> extends VolumeFluent<VolumesNested<N>> implements Nested<N>{
  
    VolumeBuilder builder;
    int index;
  
    VolumesNested(int index,Volume item) {
      this.index = index;
      this.builder = new VolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
  public class WorkspacesNested<N> extends WorkspaceDeclarationFluent<WorkspacesNested<N>> implements Nested<N>{
  
    WorkspaceDeclarationBuilder builder;
    int index;
  
    WorkspacesNested(int index,WorkspaceDeclaration item) {
      this.index = index;
      this.builder = new WorkspaceDeclarationBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}