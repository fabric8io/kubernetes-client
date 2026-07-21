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
public class CustomRunSpecFluent<A extends io.fabric8.tekton.v1beta1.CustomRunSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TaskRefBuilder customRef;
  private EmbeddedCustomRunSpecBuilder customSpec;
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();
  private Integer retries;
  private String serviceAccountName;
  private String status;
  private String statusMessage;
  private Duration timeout;
  private ArrayList<WorkspaceBindingBuilder> workspaces = new ArrayList<WorkspaceBindingBuilder>();

  public CustomRunSpecFluent() {
  }
  
  public CustomRunSpecFluent(CustomRunSpec instance) {
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
  
  public TaskRef buildCustomRef() {
    return this.customRef != null ? this.customRef.build() : null;
  }
  
  public EmbeddedCustomRunSpec buildCustomSpec() {
    return this.customSpec != null ? this.customSpec.build() : null;
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
  
  public WorkspaceBinding buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspaceBinding> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(CustomRunSpec instance) {
    instance = instance != null ? instance : new CustomRunSpec();
    if (instance != null) {
        this.withCustomRef(instance.getCustomRef());
        this.withCustomSpec(instance.getCustomSpec());
        this.withParams(instance.getParams());
        this.withRetries(instance.getRetries());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withStatus(instance.getStatus());
        this.withStatusMessage(instance.getStatusMessage());
        this.withTimeout(instance.getTimeout());
        this.withWorkspaces(instance.getWorkspaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomRefNested<A> editCustomRef() {
    return this.withNewCustomRefLike(Optional.ofNullable(this.buildCustomRef()).orElse(null));
  }
  
  public CustomSpecNested<A> editCustomSpec() {
    return this.withNewCustomSpecLike(Optional.ofNullable(this.buildCustomSpec()).orElse(null));
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
  
  public CustomRefNested<A> editOrNewCustomRef() {
    return this.withNewCustomRefLike(Optional.ofNullable(this.buildCustomRef()).orElse(new TaskRefBuilder().build()));
  }
  
  public CustomRefNested<A> editOrNewCustomRefLike(TaskRef item) {
    return this.withNewCustomRefLike(Optional.ofNullable(this.buildCustomRef()).orElse(item));
  }
  
  public CustomSpecNested<A> editOrNewCustomSpec() {
    return this.withNewCustomSpecLike(Optional.ofNullable(this.buildCustomSpec()).orElse(new EmbeddedCustomRunSpecBuilder().build()));
  }
  
  public CustomSpecNested<A> editOrNewCustomSpecLike(EmbeddedCustomRunSpec item) {
    return this.withNewCustomSpecLike(Optional.ofNullable(this.buildCustomSpec()).orElse(item));
  }
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
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
    CustomRunSpecFluent that = (CustomRunSpecFluent) o;
    if (!(Objects.equals(customRef, that.customRef))) {
      return false;
    }
    if (!(Objects.equals(customSpec, that.customSpec))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(retries, that.retries))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
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
  
  public boolean hasCustomRef() {
    return this.customRef != null;
  }
  
  public boolean hasCustomSpec() {
    return this.customSpec != null;
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
  
  public boolean hasRetries() {
    return this.retries != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
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
    return Objects.hash(customRef, customSpec, params, retries, serviceAccountName, status, statusMessage, timeout, workspaces, additionalProperties);
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
    if (!(customRef == null)) {
        sb.append("customRef:");
        sb.append(customRef);
        sb.append(",");
    }
    if (!(customSpec == null)) {
        sb.append("customSpec:");
        sb.append(customSpec);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
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
  
  public A withCustomRef(TaskRef customRef) {
    this._visitables.remove("customRef");
    if (customRef != null) {
        this.customRef = new TaskRefBuilder(customRef);
        this._visitables.get("customRef").add(this.customRef);
    } else {
        this.customRef = null;
        this._visitables.get("customRef").remove(this.customRef);
    }
    return (A) this;
  }
  
  public A withCustomSpec(EmbeddedCustomRunSpec customSpec) {
    this._visitables.remove("customSpec");
    if (customSpec != null) {
        this.customSpec = new EmbeddedCustomRunSpecBuilder(customSpec);
        this._visitables.get("customSpec").add(this.customSpec);
    } else {
        this.customSpec = null;
        this._visitables.get("customSpec").remove(this.customSpec);
    }
    return (A) this;
  }
  
  public CustomRefNested<A> withNewCustomRef() {
    return new CustomRefNested(null);
  }
  
  public CustomRefNested<A> withNewCustomRefLike(TaskRef item) {
    return new CustomRefNested(item);
  }
  
  public CustomSpecNested<A> withNewCustomSpec() {
    return new CustomSpecNested(null);
  }
  
  public CustomSpecNested<A> withNewCustomSpecLike(EmbeddedCustomRunSpec item) {
    return new CustomSpecNested(item);
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
  
  public A withRetries(Integer retries) {
    this.retries = retries;
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
  public class CustomRefNested<N> extends TaskRefFluent<CustomRefNested<N>> implements Nested<N>{
  
    TaskRefBuilder builder;
  
    CustomRefNested(TaskRef item) {
      this.builder = new TaskRefBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomRunSpecFluent.this.withCustomRef(builder.build());
    }
    
    public N endCustomRef() {
      return and();
    }
    
  }
  public class CustomSpecNested<N> extends EmbeddedCustomRunSpecFluent<CustomSpecNested<N>> implements Nested<N>{
  
    EmbeddedCustomRunSpecBuilder builder;
  
    CustomSpecNested(EmbeddedCustomRunSpec item) {
      this.builder = new EmbeddedCustomRunSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomRunSpecFluent.this.withCustomSpec(builder.build());
    }
    
    public N endCustomSpec() {
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
      return (N) CustomRunSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
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
      return (N) CustomRunSpecFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}