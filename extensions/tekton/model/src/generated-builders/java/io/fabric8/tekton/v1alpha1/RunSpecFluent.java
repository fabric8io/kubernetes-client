package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.tekton.pod.Template;
import io.fabric8.tekton.pod.TemplateBuilder;
import io.fabric8.tekton.pod.TemplateFluent;
import io.fabric8.tekton.v1beta1.Param;
import io.fabric8.tekton.v1beta1.ParamBuilder;
import io.fabric8.tekton.v1beta1.ParamFluent;
import io.fabric8.tekton.v1beta1.TaskRef;
import io.fabric8.tekton.v1beta1.TaskRefBuilder;
import io.fabric8.tekton.v1beta1.TaskRefFluent;
import io.fabric8.tekton.v1beta1.WorkspaceBinding;
import io.fabric8.tekton.v1beta1.WorkspaceBindingBuilder;
import io.fabric8.tekton.v1beta1.WorkspaceBindingFluent;
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
public class RunSpecFluent<A extends io.fabric8.tekton.v1alpha1.RunSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();
  private TemplateBuilder podTemplate;
  private TaskRefBuilder ref;
  private Integer retries;
  private String serviceAccountName;
  private EmbeddedRunSpecBuilder spec;
  private String status;
  private String statusMessage;
  private Duration timeout;
  private ArrayList<WorkspaceBindingBuilder> workspaces = new ArrayList<WorkspaceBindingBuilder>();

  public RunSpecFluent() {
  }
  
  public RunSpecFluent(RunSpec instance) {
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
  
  public WorkspaceBinding buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public Param buildLastParam() {
    return this.params.get(params.size() - 1).build();
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
  
  public TaskRef buildRef() {
    return this.ref != null ? this.ref.build() : null;
  }
  
  public EmbeddedRunSpec buildSpec() {
    return this.spec != null ? this.spec.build() : null;
  }
  
  public WorkspaceBinding buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspaceBinding> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(RunSpec instance) {
    instance = instance != null ? instance : new RunSpec();
    if (instance != null) {
        this.withParams(instance.getParams());
        this.withPodTemplate(instance.getPodTemplate());
        this.withRef(instance.getRef());
        this.withRetries(instance.getRetries());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSpec(instance.getSpec());
        this.withStatus(instance.getStatus());
        this.withStatusMessage(instance.getStatusMessage());
        this.withTimeout(instance.getTimeout());
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
  
  public PodTemplateNested<A> editOrNewPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(new TemplateBuilder().build()));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplateLike(Template item) {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(item));
  }
  
  public RefNested<A> editOrNewRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(new TaskRefBuilder().build()));
  }
  
  public RefNested<A> editOrNewRefLike(TaskRef item) {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(item));
  }
  
  public SpecNested<A> editOrNewSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(new EmbeddedRunSpecBuilder().build()));
  }
  
  public SpecNested<A> editOrNewSpecLike(EmbeddedRunSpec item) {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(item));
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
  
  public RefNested<A> editRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(null));
  }
  
  public SpecNested<A> editSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(null));
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
    RunSpecFluent that = (RunSpecFluent) o;
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(podTemplate, that.podTemplate))) {
      return false;
    }
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(retries, that.retries))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(spec, that.spec))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(statusMessage, that.statusMessage))) {
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
  
  public boolean hasMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
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
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasRetries() {
    return this.retries != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasStatusMessage() {
    return this.statusMessage != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(params, podTemplate, ref, retries, serviceAccountName, spec, status, statusMessage, timeout, workspaces, additionalProperties);
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
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
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
    if (!(spec == null)) {
        sb.append("spec:");
        sb.append(spec);
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
  
  public PodTemplateNested<A> withNewPodTemplate() {
    return new PodTemplateNested(null);
  }
  
  public PodTemplateNested<A> withNewPodTemplateLike(Template item) {
    return new PodTemplateNested(item);
  }
  
  public RefNested<A> withNewRef() {
    return new RefNested(null);
  }
  
  public RefNested<A> withNewRefLike(TaskRef item) {
    return new RefNested(item);
  }
  
  public SpecNested<A> withNewSpec() {
    return new SpecNested(null);
  }
  
  public SpecNested<A> withNewSpecLike(EmbeddedRunSpec item) {
    return new SpecNested(item);
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
  
  public A withRef(TaskRef ref) {
    this._visitables.remove("ref");
    if (ref != null) {
        this.ref = new TaskRefBuilder(ref);
        this._visitables.get("ref").add(this.ref);
    } else {
        this.ref = null;
        this._visitables.get("ref").remove(this.ref);
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
  
  public A withSpec(EmbeddedRunSpec spec) {
    this._visitables.remove("spec");
    if (spec != null) {
        this.spec = new EmbeddedRunSpecBuilder(spec);
        this._visitables.get("spec").add(this.spec);
    } else {
        this.spec = null;
        this._visitables.get("spec").remove(this.spec);
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
  public class ParamsNested<N> extends ParamFluent<ParamsNested<N>> implements Nested<N>{
  
    ParamBuilder builder;
    int index;
  
    ParamsNested(int index,Param item) {
      this.index = index;
      this.builder = new ParamBuilder(this, item);
    }
  
    public N and() {
      return (N) RunSpecFluent.this.setToParams(index, builder.build());
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
      return (N) RunSpecFluent.this.withPodTemplate(builder.build());
    }
    
    public N endPodTemplate() {
      return and();
    }
    
  }
  public class RefNested<N> extends TaskRefFluent<RefNested<N>> implements Nested<N>{
  
    TaskRefBuilder builder;
  
    RefNested(TaskRef item) {
      this.builder = new TaskRefBuilder(this, item);
    }
  
    public N and() {
      return (N) RunSpecFluent.this.withRef(builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
  public class SpecNested<N> extends EmbeddedRunSpecFluent<SpecNested<N>> implements Nested<N>{
  
    EmbeddedRunSpecBuilder builder;
  
    SpecNested(EmbeddedRunSpec item) {
      this.builder = new EmbeddedRunSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RunSpecFluent.this.withSpec(builder.build());
    }
    
    public N endSpec() {
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
      return (N) RunSpecFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}