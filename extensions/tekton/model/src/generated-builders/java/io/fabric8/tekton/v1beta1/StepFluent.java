package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.ContainerPortBuilder;
import io.fabric8.kubernetes.api.model.ContainerPortFluent;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.EnvFromSource;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.Lifecycle;
import io.fabric8.kubernetes.api.model.Probe;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import io.fabric8.kubernetes.api.model.SecurityContext;
import io.fabric8.kubernetes.api.model.VolumeDevice;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.VolumeMountBuilder;
import io.fabric8.kubernetes.api.model.VolumeMountFluent;
import io.fabric8.tekton.v1.StepResult;
import io.fabric8.tekton.v1.StepResultBuilder;
import io.fabric8.tekton.v1.StepResultFluent;
import java.lang.Boolean;
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
public class StepFluent<A extends io.fabric8.tekton.v1beta1.StepFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> args = new ArrayList<String>();
  private List<String> command = new ArrayList<String>();
  private String displayName;
  private ArrayList<EnvVarBuilder> env = new ArrayList<EnvVarBuilder>();
  private List<EnvFromSource> envFrom = new ArrayList<EnvFromSource>();
  private String image;
  private String imagePullPolicy;
  private Lifecycle lifecycle;
  private Probe livenessProbe;
  private String name;
  private String onError;
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();
  private ArrayList<ContainerPortBuilder> ports = new ArrayList<ContainerPortBuilder>();
  private Probe readinessProbe;
  private RefBuilder ref;
  private ResourceRequirementsBuilder resources;
  private ArrayList<StepResultBuilder> results = new ArrayList<StepResultBuilder>();
  private String script;
  private SecurityContext securityContext;
  private Probe startupProbe;
  private StepOutputConfigBuilder stderrConfig;
  private Boolean stdin;
  private Boolean stdinOnce;
  private StepOutputConfigBuilder stdoutConfig;
  private String terminationMessagePath;
  private String terminationMessagePolicy;
  private Duration timeout;
  private Boolean tty;
  private List<VolumeDevice> volumeDevices = new ArrayList<VolumeDevice>();
  private ArrayList<VolumeMountBuilder> volumeMounts = new ArrayList<VolumeMountBuilder>();
  private ArrayList<WhenExpressionBuilder> when = new ArrayList<WhenExpressionBuilder>();
  private String workingDir;
  private ArrayList<WorkspaceUsageBuilder> workspaces = new ArrayList<WorkspaceUsageBuilder>();

  public StepFluent() {
  }
  
  public StepFluent(Step instance) {
    this.copyInstance(instance);
  }

  public A addAllToArgs(Collection<String> items) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    for (String item : items) {
      this.args.add(item);
    }
    return (A) this;
  }
  
  public A addAllToCommand(Collection<String> items) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    for (String item : items) {
      this.command.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEnv(Collection<EnvVar> items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEnvFrom(Collection<EnvFromSource> items) {
    if (this.envFrom == null) {
      this.envFrom = new ArrayList();
    }
    for (EnvFromSource item : items) {
      this.envFrom.add(item);
    }
    return (A) this;
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
  
  public A addAllToPorts(Collection<ContainerPort> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (ContainerPort item : items) {
        ContainerPortBuilder builder = new ContainerPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResults(Collection<StepResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (StepResult item : items) {
        StepResultBuilder builder = new StepResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumeDevices(Collection<VolumeDevice> items) {
    if (this.volumeDevices == null) {
      this.volumeDevices = new ArrayList();
    }
    for (VolumeDevice item : items) {
      this.volumeDevices.add(item);
    }
    return (A) this;
  }
  
  public A addAllToVolumeMounts(Collection<VolumeMount> items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
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
  
  public A addAllToWorkspaces(Collection<WorkspaceUsage> items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspaceUsage item : items) {
        WorkspaceUsageBuilder builder = new WorkspaceUsageBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public EnvNested<A> addNewEnvLike(EnvVar item) {
    return new EnvNested(-1, item);
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public ParamsNested<A> addNewParamLike(Param item) {
    return new ParamsNested(-1, item);
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public A addNewPort(Integer containerPort,String hostIP,Integer hostPort,String name,String protocol) {
    return (A) this.addToPorts(new ContainerPort(containerPort, hostIP, hostPort, name, protocol));
  }
  
  public PortsNested<A> addNewPortLike(ContainerPort item) {
    return new PortsNested(-1, item);
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public ResultsNested<A> addNewResultLike(StepResult item) {
    return new ResultsNested(-1, item);
  }
  
  public A addNewVolumeDevice(String devicePath,String name) {
    return (A) this.addToVolumeDevices(new VolumeDevice(devicePath, name));
  }
  
  public VolumeMountsNested<A> addNewVolumeMount() {
    return new VolumeMountsNested(-1, null);
  }
  
  public VolumeMountsNested<A> addNewVolumeMountLike(VolumeMount item) {
    return new VolumeMountsNested(-1, item);
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
  
  public A addNewWorkspace(String mountPath,String name) {
    return (A) this.addToWorkspaces(new WorkspaceUsage(mountPath, name));
  }
  
  public WorkspacesNested<A> addNewWorkspaceLike(WorkspaceUsage item) {
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
  
  public A addToArgs(String... items) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    for (String item : items) {
      this.args.add(item);
    }
    return (A) this;
  }
  
  public A addToArgs(int index,String item) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    this.args.add(index, item);
    return (A) this;
  }
  
  public A addToCommand(String... items) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    for (String item : items) {
      this.command.add(item);
    }
    return (A) this;
  }
  
  public A addToCommand(int index,String item) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    this.command.add(index, item);
    return (A) this;
  }
  
  public A addToEnv(EnvVar... items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnv(int index,EnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEnvFrom(EnvFromSource... items) {
    if (this.envFrom == null) {
      this.envFrom = new ArrayList();
    }
    for (EnvFromSource item : items) {
      this.envFrom.add(item);
    }
    return (A) this;
  }
  
  public A addToEnvFrom(int index,EnvFromSource item) {
    if (this.envFrom == null) {
      this.envFrom = new ArrayList();
    }
    this.envFrom.add(index, item);
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
  
  public A addToPorts(ContainerPort... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (ContainerPort item : items) {
        ContainerPortBuilder builder = new ContainerPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,ContainerPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    ContainerPortBuilder builder = new ContainerPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResults(StepResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (StepResult item : items) {
        StepResultBuilder builder = new StepResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,StepResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    StepResultBuilder builder = new StepResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVolumeDevices(VolumeDevice... items) {
    if (this.volumeDevices == null) {
      this.volumeDevices = new ArrayList();
    }
    for (VolumeDevice item : items) {
      this.volumeDevices.add(item);
    }
    return (A) this;
  }
  
  public A addToVolumeDevices(int index,VolumeDevice item) {
    if (this.volumeDevices == null) {
      this.volumeDevices = new ArrayList();
    }
    this.volumeDevices.add(index, item);
    return (A) this;
  }
  
  public A addToVolumeMounts(VolumeMount... items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumeMounts(int index,VolumeMount item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountBuilder builder = new VolumeMountBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(index, builder);
    }
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
  
  public A addToWorkspaces(WorkspaceUsage... items) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    for (WorkspaceUsage item : items) {
        WorkspaceUsageBuilder builder = new WorkspaceUsageBuilder(item);
        _visitables.get("workspaces").add(builder);
        this.workspaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToWorkspaces(int index,WorkspaceUsage item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspaceUsageBuilder builder = new WorkspaceUsageBuilder(item);
    if (index < 0 || index >= workspaces.size()) {
        _visitables.get("workspaces").add(builder);
        workspaces.add(builder);
    } else {
        _visitables.get("workspaces").add(builder);
        workspaces.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EnvVar> buildEnv() {
    return this.env != null ? build(env) : null;
  }
  
  public EnvVar buildEnv(int index) {
    return this.env.get(index).build();
  }
  
  public EnvVar buildFirstEnv() {
    return this.env.get(0).build();
  }
  
  public Param buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public ContainerPort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public StepResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public VolumeMount buildFirstVolumeMount() {
    return this.volumeMounts.get(0).build();
  }
  
  public WhenExpression buildFirstWhen() {
    return this.when.get(0).build();
  }
  
  public WorkspaceUsage buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public EnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public Param buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public ContainerPort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public StepResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public VolumeMount buildLastVolumeMount() {
    return this.volumeMounts.get(volumeMounts.size() - 1).build();
  }
  
  public WhenExpression buildLastWhen() {
    return this.when.get(when.size() - 1).build();
  }
  
  public WorkspaceUsage buildLastWorkspace() {
    return this.workspaces.get(workspaces.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Param buildMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerPort buildMatchingPort(Predicate<ContainerPortBuilder> predicate) {
      for (ContainerPortBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StepResult buildMatchingResult(Predicate<StepResultBuilder> predicate) {
      for (StepResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VolumeMount buildMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
      for (VolumeMountBuilder item : volumeMounts) {
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
  
  public WorkspaceUsage buildMatchingWorkspace(Predicate<WorkspaceUsageBuilder> predicate) {
      for (WorkspaceUsageBuilder item : workspaces) {
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
  
  public ContainerPort buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<ContainerPort> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  public Ref buildRef() {
    return this.ref != null ? this.ref.build() : null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public StepResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<StepResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  public StepOutputConfig buildStderrConfig() {
    return this.stderrConfig != null ? this.stderrConfig.build() : null;
  }
  
  public StepOutputConfig buildStdoutConfig() {
    return this.stdoutConfig != null ? this.stdoutConfig.build() : null;
  }
  
  public VolumeMount buildVolumeMount(int index) {
    return this.volumeMounts.get(index).build();
  }
  
  public List<VolumeMount> buildVolumeMounts() {
    return this.volumeMounts != null ? build(volumeMounts) : null;
  }
  
  public List<WhenExpression> buildWhen() {
    return this.when != null ? build(when) : null;
  }
  
  public WhenExpression buildWhen(int index) {
    return this.when.get(index).build();
  }
  
  public WorkspaceUsage buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspaceUsage> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(Step instance) {
    instance = instance != null ? instance : new Step();
    if (instance != null) {
        this.withArgs(instance.getArgs());
        this.withCommand(instance.getCommand());
        this.withDisplayName(instance.getDisplayName());
        this.withEnv(instance.getEnv());
        this.withEnvFrom(instance.getEnvFrom());
        this.withImage(instance.getImage());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withLifecycle(instance.getLifecycle());
        this.withLivenessProbe(instance.getLivenessProbe());
        this.withName(instance.getName());
        this.withOnError(instance.getOnError());
        this.withParams(instance.getParams());
        this.withPorts(instance.getPorts());
        this.withReadinessProbe(instance.getReadinessProbe());
        this.withRef(instance.getRef());
        this.withResources(instance.getResources());
        this.withResults(instance.getResults());
        this.withScript(instance.getScript());
        this.withSecurityContext(instance.getSecurityContext());
        this.withStartupProbe(instance.getStartupProbe());
        this.withStderrConfig(instance.getStderrConfig());
        this.withStdin(instance.getStdin());
        this.withStdinOnce(instance.getStdinOnce());
        this.withStdoutConfig(instance.getStdoutConfig());
        this.withTerminationMessagePath(instance.getTerminationMessagePath());
        this.withTerminationMessagePolicy(instance.getTerminationMessagePolicy());
        this.withTimeout(instance.getTimeout());
        this.withTty(instance.getTty());
        this.withVolumeDevices(instance.getVolumeDevices());
        this.withVolumeMounts(instance.getVolumeMounts());
        this.withWhen(instance.getWhen());
        this.withWorkingDir(instance.getWorkingDir());
        this.withWorkspaces(instance.getWorkspaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EnvNested<A> editEnv(int index) {
    if (env.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editFirstEnv() {
    if (env.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(0, this.buildEnv(0));
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public VolumeMountsNested<A> editFirstVolumeMount() {
    if (volumeMounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(0, this.buildVolumeMount(0));
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
  
  public EnvNested<A> editLastEnv() {
    int index = env.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public VolumeMountsNested<A> editLastVolumeMount() {
    int index = volumeMounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
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
  
  public EnvNested<A> editMatchingEnv(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < env.size();i++) {
      if (predicate.test(env.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
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
  
  public PortsNested<A> editMatchingPort(Predicate<ContainerPortBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ports.size();i++) {
      if (predicate.test(ports.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public ResultsNested<A> editMatchingResult(Predicate<StepResultBuilder> predicate) {
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
  
  public VolumeMountsNested<A> editMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumeMounts.size();i++) {
      if (predicate.test(volumeMounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
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
  
  public WorkspacesNested<A> editMatchingWorkspace(Predicate<WorkspaceUsageBuilder> predicate) {
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
  
  public RefNested<A> editOrNewRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(new RefBuilder().build()));
  }
  
  public RefNested<A> editOrNewRefLike(Ref item) {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public StderrConfigNested<A> editOrNewStderrConfig() {
    return this.withNewStderrConfigLike(Optional.ofNullable(this.buildStderrConfig()).orElse(new StepOutputConfigBuilder().build()));
  }
  
  public StderrConfigNested<A> editOrNewStderrConfigLike(StepOutputConfig item) {
    return this.withNewStderrConfigLike(Optional.ofNullable(this.buildStderrConfig()).orElse(item));
  }
  
  public StdoutConfigNested<A> editOrNewStdoutConfig() {
    return this.withNewStdoutConfigLike(Optional.ofNullable(this.buildStdoutConfig()).orElse(new StepOutputConfigBuilder().build()));
  }
  
  public StdoutConfigNested<A> editOrNewStdoutConfigLike(StepOutputConfig item) {
    return this.withNewStdoutConfigLike(Optional.ofNullable(this.buildStdoutConfig()).orElse(item));
  }
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public RefNested<A> editRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(null));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public ResultsNested<A> editResult(int index) {
    if (results.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public StderrConfigNested<A> editStderrConfig() {
    return this.withNewStderrConfigLike(Optional.ofNullable(this.buildStderrConfig()).orElse(null));
  }
  
  public StdoutConfigNested<A> editStdoutConfig() {
    return this.withNewStdoutConfigLike(Optional.ofNullable(this.buildStdoutConfig()).orElse(null));
  }
  
  public VolumeMountsNested<A> editVolumeMount(int index) {
    if (volumeMounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
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
    StepFluent that = (StepFluent) o;
    if (!(Objects.equals(args, that.args))) {
      return false;
    }
    if (!(Objects.equals(command, that.command))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(envFrom, that.envFrom))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(lifecycle, that.lifecycle))) {
      return false;
    }
    if (!(Objects.equals(livenessProbe, that.livenessProbe))) {
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
    if (!(Objects.equals(ports, that.ports))) {
      return false;
    }
    if (!(Objects.equals(readinessProbe, that.readinessProbe))) {
      return false;
    }
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(script, that.script))) {
      return false;
    }
    if (!(Objects.equals(securityContext, that.securityContext))) {
      return false;
    }
    if (!(Objects.equals(startupProbe, that.startupProbe))) {
      return false;
    }
    if (!(Objects.equals(stderrConfig, that.stderrConfig))) {
      return false;
    }
    if (!(Objects.equals(stdin, that.stdin))) {
      return false;
    }
    if (!(Objects.equals(stdinOnce, that.stdinOnce))) {
      return false;
    }
    if (!(Objects.equals(stdoutConfig, that.stdoutConfig))) {
      return false;
    }
    if (!(Objects.equals(terminationMessagePath, that.terminationMessagePath))) {
      return false;
    }
    if (!(Objects.equals(terminationMessagePolicy, that.terminationMessagePolicy))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(tty, that.tty))) {
      return false;
    }
    if (!(Objects.equals(volumeDevices, that.volumeDevices))) {
      return false;
    }
    if (!(Objects.equals(volumeMounts, that.volumeMounts))) {
      return false;
    }
    if (!(Objects.equals(when, that.when))) {
      return false;
    }
    if (!(Objects.equals(workingDir, that.workingDir))) {
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
  
  public String getArg(int index) {
    return this.args.get(index);
  }
  
  public List<String> getArgs() {
    return this.args;
  }
  
  public List<String> getCommand() {
    return this.command;
  }
  
  public String getCommand(int index) {
    return this.command.get(index);
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public List<EnvFromSource> getEnvFrom() {
    return this.envFrom;
  }
  
  public EnvFromSource getEnvFrom(int index) {
    return this.envFrom.get(index);
  }
  
  public String getFirstArg() {
    return this.args.get(0);
  }
  
  public String getFirstCommand() {
    return this.command.get(0);
  }
  
  public EnvFromSource getFirstEnvFrom() {
    return this.envFrom.get(0);
  }
  
  public VolumeDevice getFirstVolumeDevice() {
    return this.volumeDevices.get(0);
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getLastArg() {
    return this.args.get(args.size() - 1);
  }
  
  public String getLastCommand() {
    return this.command.get(command.size() - 1);
  }
  
  public EnvFromSource getLastEnvFrom() {
    return this.envFrom.get(envFrom.size() - 1);
  }
  
  public VolumeDevice getLastVolumeDevice() {
    return this.volumeDevices.get(volumeDevices.size() - 1);
  }
  
  public Lifecycle getLifecycle() {
    return this.lifecycle;
  }
  
  public Probe getLivenessProbe() {
    return this.livenessProbe;
  }
  
  public String getMatchingArg(Predicate<String> predicate) {
      for (String item : args) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingCommand(Predicate<String> predicate) {
      for (String item : command) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public EnvFromSource getMatchingEnvFrom(Predicate<EnvFromSource> predicate) {
      for (EnvFromSource item : envFrom) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public VolumeDevice getMatchingVolumeDevice(Predicate<VolumeDevice> predicate) {
      for (VolumeDevice item : volumeDevices) {
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
  
  public Probe getReadinessProbe() {
    return this.readinessProbe;
  }
  
  public String getScript() {
    return this.script;
  }
  
  public SecurityContext getSecurityContext() {
    return this.securityContext;
  }
  
  public Probe getStartupProbe() {
    return this.startupProbe;
  }
  
  public Boolean getStdin() {
    return this.stdin;
  }
  
  public Boolean getStdinOnce() {
    return this.stdinOnce;
  }
  
  public String getTerminationMessagePath() {
    return this.terminationMessagePath;
  }
  
  public String getTerminationMessagePolicy() {
    return this.terminationMessagePolicy;
  }
  
  public Duration getTimeout() {
    return this.timeout;
  }
  
  public Boolean getTty() {
    return this.tty;
  }
  
  public VolumeDevice getVolumeDevice(int index) {
    return this.volumeDevices.get(index);
  }
  
  public List<VolumeDevice> getVolumeDevices() {
    return this.volumeDevices;
  }
  
  public String getWorkingDir() {
    return this.workingDir;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArgs() {
    return this.args != null && !(this.args.isEmpty());
  }
  
  public boolean hasCommand() {
    return this.command != null && !(this.command.isEmpty());
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasEnvFrom() {
    return this.envFrom != null && !(this.envFrom.isEmpty());
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasLifecycle() {
    return this.lifecycle != null;
  }
  
  public boolean hasLivenessProbe() {
    return this.livenessProbe != null;
  }
  
  public boolean hasMatchingArg(Predicate<String> predicate) {
      for (String item : args) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCommand(Predicate<String> predicate) {
      for (String item : command) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnvFrom(Predicate<EnvFromSource> predicate) {
      for (EnvFromSource item : envFrom) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPort(Predicate<ContainerPortBuilder> predicate) {
      for (ContainerPortBuilder item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResult(Predicate<StepResultBuilder> predicate) {
      for (StepResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolumeDevice(Predicate<VolumeDevice> predicate) {
      for (VolumeDevice item : volumeDevices) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
      for (VolumeMountBuilder item : volumeMounts) {
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
  
  public boolean hasMatchingWorkspace(Predicate<WorkspaceUsageBuilder> predicate) {
      for (WorkspaceUsageBuilder item : workspaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public boolean hasReadinessProbe() {
    return this.readinessProbe != null;
  }
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public boolean hasScript() {
    return this.script != null;
  }
  
  public boolean hasSecurityContext() {
    return this.securityContext != null;
  }
  
  public boolean hasStartupProbe() {
    return this.startupProbe != null;
  }
  
  public boolean hasStderrConfig() {
    return this.stderrConfig != null;
  }
  
  public boolean hasStdin() {
    return this.stdin != null;
  }
  
  public boolean hasStdinOnce() {
    return this.stdinOnce != null;
  }
  
  public boolean hasStdoutConfig() {
    return this.stdoutConfig != null;
  }
  
  public boolean hasTerminationMessagePath() {
    return this.terminationMessagePath != null;
  }
  
  public boolean hasTerminationMessagePolicy() {
    return this.terminationMessagePolicy != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasTty() {
    return this.tty != null;
  }
  
  public boolean hasVolumeDevices() {
    return this.volumeDevices != null && !(this.volumeDevices.isEmpty());
  }
  
  public boolean hasVolumeMounts() {
    return this.volumeMounts != null && !(this.volumeMounts.isEmpty());
  }
  
  public boolean hasWhen() {
    return this.when != null && !(this.when.isEmpty());
  }
  
  public boolean hasWorkingDir() {
    return this.workingDir != null;
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(args, command, displayName, env, envFrom, image, imagePullPolicy, lifecycle, livenessProbe, name, onError, params, ports, readinessProbe, ref, resources, results, script, securityContext, startupProbe, stderrConfig, stdin, stdinOnce, stdoutConfig, terminationMessagePath, terminationMessagePolicy, timeout, tty, volumeDevices, volumeMounts, when, workingDir, workspaces, additionalProperties);
  }
  
  public A removeAllFromArgs(Collection<String> items) {
    if (this.args == null) {
      return (A) this;
    }
    for (String item : items) {
      this.args.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromCommand(Collection<String> items) {
    if (this.command == null) {
      return (A) this;
    }
    for (String item : items) {
      this.command.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEnv(Collection<EnvVar> items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEnvFrom(Collection<EnvFromSource> items) {
    if (this.envFrom == null) {
      return (A) this;
    }
    for (EnvFromSource item : items) {
      this.envFrom.remove(item);
    }
    return (A) this;
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
  
  public A removeAllFromPorts(Collection<ContainerPort> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (ContainerPort item : items) {
        ContainerPortBuilder builder = new ContainerPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResults(Collection<StepResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (StepResult item : items) {
        StepResultBuilder builder = new StepResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumeDevices(Collection<VolumeDevice> items) {
    if (this.volumeDevices == null) {
      return (A) this;
    }
    for (VolumeDevice item : items) {
      this.volumeDevices.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumeMounts(Collection<VolumeMount> items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
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
  
  public A removeAllFromWorkspaces(Collection<WorkspaceUsage> items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspaceUsage item : items) {
        WorkspaceUsageBuilder builder = new WorkspaceUsageBuilder(item);
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
  
  public A removeFromArgs(String... items) {
    if (this.args == null) {
      return (A) this;
    }
    for (String item : items) {
      this.args.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCommand(String... items) {
    if (this.command == null) {
      return (A) this;
    }
    for (String item : items) {
      this.command.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEnv(EnvVar... items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEnvFrom(EnvFromSource... items) {
    if (this.envFrom == null) {
      return (A) this;
    }
    for (EnvFromSource item : items) {
      this.envFrom.remove(item);
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
  
  public A removeFromPorts(ContainerPort... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (ContainerPort item : items) {
        ContainerPortBuilder builder = new ContainerPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResults(StepResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (StepResult item : items) {
        StepResultBuilder builder = new StepResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVolumeDevices(VolumeDevice... items) {
    if (this.volumeDevices == null) {
      return (A) this;
    }
    for (VolumeDevice item : items) {
      this.volumeDevices.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromVolumeMounts(VolumeMount... items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
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
  
  public A removeFromWorkspaces(WorkspaceUsage... items) {
    if (this.workspaces == null) {
      return (A) this;
    }
    for (WorkspaceUsage item : items) {
        WorkspaceUsageBuilder builder = new WorkspaceUsageBuilder(item);
        _visitables.get("workspaces").remove(builder);
        this.workspaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnv(Predicate<EnvVarBuilder> predicate) {
    if (env == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = env.iterator();
    List visitables = _visitables.get("env");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public A removeMatchingFromPorts(Predicate<ContainerPortBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<ContainerPortBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        ContainerPortBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<StepResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<StepResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        StepResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumeMounts(Predicate<VolumeMountBuilder> predicate) {
    if (volumeMounts == null) {
      return (A) this;
    }
    Iterator<VolumeMountBuilder> each = volumeMounts.iterator();
    List visitables = _visitables.get("volumeMounts");
    while (each.hasNext()) {
        VolumeMountBuilder builder = each.next();
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
  
  public A removeMatchingFromWorkspaces(Predicate<WorkspaceUsageBuilder> predicate) {
    if (workspaces == null) {
      return (A) this;
    }
    Iterator<WorkspaceUsageBuilder> each = workspaces.iterator();
    List visitables = _visitables.get("workspaces");
    while (each.hasNext()) {
        WorkspaceUsageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EnvNested<A> setNewEnvLike(int index,EnvVar item) {
    return new EnvNested(index, item);
  }
  
  public ParamsNested<A> setNewParamLike(int index,Param item) {
    return new ParamsNested(index, item);
  }
  
  public PortsNested<A> setNewPortLike(int index,ContainerPort item) {
    return new PortsNested(index, item);
  }
  
  public ResultsNested<A> setNewResultLike(int index,StepResult item) {
    return new ResultsNested(index, item);
  }
  
  public VolumeMountsNested<A> setNewVolumeMountLike(int index,VolumeMount item) {
    return new VolumeMountsNested(index, item);
  }
  
  public WhenNested<A> setNewWhenLike(int index,WhenExpression item) {
    return new WhenNested(index, item);
  }
  
  public WorkspacesNested<A> setNewWorkspaceLike(int index,WorkspaceUsage item) {
    return new WorkspacesNested(index, item);
  }
  
  public A setToArgs(int index,String item) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    this.args.set(index, item);
    return (A) this;
  }
  
  public A setToCommand(int index,String item) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    this.command.set(index, item);
    return (A) this;
  }
  
  public A setToEnv(int index,EnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEnvFrom(int index,EnvFromSource item) {
    if (this.envFrom == null) {
      this.envFrom = new ArrayList();
    }
    this.envFrom.set(index, item);
    return (A) this;
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
  
  public A setToPorts(int index,ContainerPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    ContainerPortBuilder builder = new ContainerPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResults(int index,StepResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    StepResultBuilder builder = new StepResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumeDevices(int index,VolumeDevice item) {
    if (this.volumeDevices == null) {
      this.volumeDevices = new ArrayList();
    }
    this.volumeDevices.set(index, item);
    return (A) this;
  }
  
  public A setToVolumeMounts(int index,VolumeMount item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountBuilder builder = new VolumeMountBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.set(index, builder);
    }
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
  
  public A setToWorkspaces(int index,WorkspaceUsage item) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList();
    }
    WorkspaceUsageBuilder builder = new WorkspaceUsageBuilder(item);
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
    if (!(args == null) && !(args.isEmpty())) {
        sb.append("args:");
        sb.append(args);
        sb.append(",");
    }
    if (!(command == null) && !(command.isEmpty())) {
        sb.append("command:");
        sb.append(command);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(envFrom == null) && !(envFrom.isEmpty())) {
        sb.append("envFrom:");
        sb.append(envFrom);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(lifecycle == null)) {
        sb.append("lifecycle:");
        sb.append(lifecycle);
        sb.append(",");
    }
    if (!(livenessProbe == null)) {
        sb.append("livenessProbe:");
        sb.append(livenessProbe);
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
    if (!(ports == null) && !(ports.isEmpty())) {
        sb.append("ports:");
        sb.append(ports);
        sb.append(",");
    }
    if (!(readinessProbe == null)) {
        sb.append("readinessProbe:");
        sb.append(readinessProbe);
        sb.append(",");
    }
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(results == null) && !(results.isEmpty())) {
        sb.append("results:");
        sb.append(results);
        sb.append(",");
    }
    if (!(script == null)) {
        sb.append("script:");
        sb.append(script);
        sb.append(",");
    }
    if (!(securityContext == null)) {
        sb.append("securityContext:");
        sb.append(securityContext);
        sb.append(",");
    }
    if (!(startupProbe == null)) {
        sb.append("startupProbe:");
        sb.append(startupProbe);
        sb.append(",");
    }
    if (!(stderrConfig == null)) {
        sb.append("stderrConfig:");
        sb.append(stderrConfig);
        sb.append(",");
    }
    if (!(stdin == null)) {
        sb.append("stdin:");
        sb.append(stdin);
        sb.append(",");
    }
    if (!(stdinOnce == null)) {
        sb.append("stdinOnce:");
        sb.append(stdinOnce);
        sb.append(",");
    }
    if (!(stdoutConfig == null)) {
        sb.append("stdoutConfig:");
        sb.append(stdoutConfig);
        sb.append(",");
    }
    if (!(terminationMessagePath == null)) {
        sb.append("terminationMessagePath:");
        sb.append(terminationMessagePath);
        sb.append(",");
    }
    if (!(terminationMessagePolicy == null)) {
        sb.append("terminationMessagePolicy:");
        sb.append(terminationMessagePolicy);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(tty == null)) {
        sb.append("tty:");
        sb.append(tty);
        sb.append(",");
    }
    if (!(volumeDevices == null) && !(volumeDevices.isEmpty())) {
        sb.append("volumeDevices:");
        sb.append(volumeDevices);
        sb.append(",");
    }
    if (!(volumeMounts == null) && !(volumeMounts.isEmpty())) {
        sb.append("volumeMounts:");
        sb.append(volumeMounts);
        sb.append(",");
    }
    if (!(when == null) && !(when.isEmpty())) {
        sb.append("when:");
        sb.append(when);
        sb.append(",");
    }
    if (!(workingDir == null)) {
        sb.append("workingDir:");
        sb.append(workingDir);
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
  
  public A withArgs(List<String> args) {
    if (args != null) {
        this.args = new ArrayList();
        for (String item : args) {
          this.addToArgs(item);
        }
    } else {
      this.args = null;
    }
    return (A) this;
  }
  
  public A withArgs(String... args) {
    if (this.args != null) {
        this.args.clear();
        _visitables.remove("args");
    }
    if (args != null) {
      for (String item : args) {
        this.addToArgs(item);
      }
    }
    return (A) this;
  }
  
  public A withCommand(List<String> command) {
    if (command != null) {
        this.command = new ArrayList();
        for (String item : command) {
          this.addToCommand(item);
        }
    } else {
      this.command = null;
    }
    return (A) this;
  }
  
  public A withCommand(String... command) {
    if (this.command != null) {
        this.command.clear();
        _visitables.remove("command");
    }
    if (command != null) {
      for (String item : command) {
        this.addToCommand(item);
      }
    }
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withEnv(List<EnvVar> env) {
    if (this.env != null) {
      this._visitables.get("env").clear();
    }
    if (env != null) {
        this.env = new ArrayList();
        for (EnvVar item : env) {
          this.addToEnv(item);
        }
    } else {
      this.env = null;
    }
    return (A) this;
  }
  
  public A withEnv(EnvVar... env) {
    if (this.env != null) {
        this.env.clear();
        _visitables.remove("env");
    }
    if (env != null) {
      for (EnvVar item : env) {
        this.addToEnv(item);
      }
    }
    return (A) this;
  }
  
  public A withEnvFrom(List<EnvFromSource> envFrom) {
    if (envFrom != null) {
        this.envFrom = new ArrayList();
        for (EnvFromSource item : envFrom) {
          this.addToEnvFrom(item);
        }
    } else {
      this.envFrom = null;
    }
    return (A) this;
  }
  
  public A withEnvFrom(EnvFromSource... envFrom) {
    if (this.envFrom != null) {
        this.envFrom.clear();
        _visitables.remove("envFrom");
    }
    if (envFrom != null) {
      for (EnvFromSource item : envFrom) {
        this.addToEnvFrom(item);
      }
    }
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withLifecycle(Lifecycle lifecycle) {
    this.lifecycle = lifecycle;
    return (A) this;
  }
  
  public A withLivenessProbe(Probe livenessProbe) {
    this.livenessProbe = livenessProbe;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public RefNested<A> withNewRef() {
    return new RefNested(null);
  }
  
  public RefNested<A> withNewRefLike(Ref item) {
    return new RefNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public StderrConfigNested<A> withNewStderrConfig() {
    return new StderrConfigNested(null);
  }
  
  public A withNewStderrConfig(String path) {
    return (A) this.withStderrConfig(new StepOutputConfig(path));
  }
  
  public StderrConfigNested<A> withNewStderrConfigLike(StepOutputConfig item) {
    return new StderrConfigNested(item);
  }
  
  public StdoutConfigNested<A> withNewStdoutConfig() {
    return new StdoutConfigNested(null);
  }
  
  public A withNewStdoutConfig(String path) {
    return (A) this.withStdoutConfig(new StepOutputConfig(path));
  }
  
  public StdoutConfigNested<A> withNewStdoutConfigLike(StepOutputConfig item) {
    return new StdoutConfigNested(item);
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
  
  public A withPorts(List<ContainerPort> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (ContainerPort item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(ContainerPort... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (ContainerPort item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withReadinessProbe(Probe readinessProbe) {
    this.readinessProbe = readinessProbe;
    return (A) this;
  }
  
  public A withRef(Ref ref) {
    this._visitables.remove("ref");
    if (ref != null) {
        this.ref = new RefBuilder(ref);
        this._visitables.get("ref").add(this.ref);
    } else {
        this.ref = null;
        this._visitables.get("ref").remove(this.ref);
    }
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withResults(List<StepResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (StepResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(StepResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (StepResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withScript(String script) {
    this.script = script;
    return (A) this;
  }
  
  public A withSecurityContext(SecurityContext securityContext) {
    this.securityContext = securityContext;
    return (A) this;
  }
  
  public A withStartupProbe(Probe startupProbe) {
    this.startupProbe = startupProbe;
    return (A) this;
  }
  
  public A withStderrConfig(StepOutputConfig stderrConfig) {
    this._visitables.remove("stderrConfig");
    if (stderrConfig != null) {
        this.stderrConfig = new StepOutputConfigBuilder(stderrConfig);
        this._visitables.get("stderrConfig").add(this.stderrConfig);
    } else {
        this.stderrConfig = null;
        this._visitables.get("stderrConfig").remove(this.stderrConfig);
    }
    return (A) this;
  }
  
  public A withStdin() {
    return withStdin(true);
  }
  
  public A withStdin(Boolean stdin) {
    this.stdin = stdin;
    return (A) this;
  }
  
  public A withStdinOnce() {
    return withStdinOnce(true);
  }
  
  public A withStdinOnce(Boolean stdinOnce) {
    this.stdinOnce = stdinOnce;
    return (A) this;
  }
  
  public A withStdoutConfig(StepOutputConfig stdoutConfig) {
    this._visitables.remove("stdoutConfig");
    if (stdoutConfig != null) {
        this.stdoutConfig = new StepOutputConfigBuilder(stdoutConfig);
        this._visitables.get("stdoutConfig").add(this.stdoutConfig);
    } else {
        this.stdoutConfig = null;
        this._visitables.get("stdoutConfig").remove(this.stdoutConfig);
    }
    return (A) this;
  }
  
  public A withTerminationMessagePath(String terminationMessagePath) {
    this.terminationMessagePath = terminationMessagePath;
    return (A) this;
  }
  
  public A withTerminationMessagePolicy(String terminationMessagePolicy) {
    this.terminationMessagePolicy = terminationMessagePolicy;
    return (A) this;
  }
  
  public A withTimeout(Duration timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
  public A withTty() {
    return withTty(true);
  }
  
  public A withTty(Boolean tty) {
    this.tty = tty;
    return (A) this;
  }
  
  public A withVolumeDevices(List<VolumeDevice> volumeDevices) {
    if (volumeDevices != null) {
        this.volumeDevices = new ArrayList();
        for (VolumeDevice item : volumeDevices) {
          this.addToVolumeDevices(item);
        }
    } else {
      this.volumeDevices = null;
    }
    return (A) this;
  }
  
  public A withVolumeDevices(VolumeDevice... volumeDevices) {
    if (this.volumeDevices != null) {
        this.volumeDevices.clear();
        _visitables.remove("volumeDevices");
    }
    if (volumeDevices != null) {
      for (VolumeDevice item : volumeDevices) {
        this.addToVolumeDevices(item);
      }
    }
    return (A) this;
  }
  
  public A withVolumeMounts(List<VolumeMount> volumeMounts) {
    if (this.volumeMounts != null) {
      this._visitables.get("volumeMounts").clear();
    }
    if (volumeMounts != null) {
        this.volumeMounts = new ArrayList();
        for (VolumeMount item : volumeMounts) {
          this.addToVolumeMounts(item);
        }
    } else {
      this.volumeMounts = null;
    }
    return (A) this;
  }
  
  public A withVolumeMounts(VolumeMount... volumeMounts) {
    if (this.volumeMounts != null) {
        this.volumeMounts.clear();
        _visitables.remove("volumeMounts");
    }
    if (volumeMounts != null) {
      for (VolumeMount item : volumeMounts) {
        this.addToVolumeMounts(item);
      }
    }
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
  
  public A withWorkingDir(String workingDir) {
    this.workingDir = workingDir;
    return (A) this;
  }
  
  public A withWorkspaces(List<WorkspaceUsage> workspaces) {
    if (this.workspaces != null) {
      this._visitables.get("workspaces").clear();
    }
    if (workspaces != null) {
        this.workspaces = new ArrayList();
        for (WorkspaceUsage item : workspaces) {
          this.addToWorkspaces(item);
        }
    } else {
      this.workspaces = null;
    }
    return (A) this;
  }
  
  public A withWorkspaces(WorkspaceUsage... workspaces) {
    if (this.workspaces != null) {
        this.workspaces.clear();
        _visitables.remove("workspaces");
    }
    if (workspaces != null) {
      for (WorkspaceUsage item : workspaces) {
        this.addToWorkspaces(item);
      }
    }
    return (A) this;
  }
  public class EnvNested<N> extends EnvVarFluent<EnvNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    EnvNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
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
      return (N) StepFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class PortsNested<N> extends ContainerPortFluent<PortsNested<N>> implements Nested<N>{
  
    ContainerPortBuilder builder;
    int index;
  
    PortsNested(int index,ContainerPort item) {
      this.index = index;
      this.builder = new ContainerPortBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class RefNested<N> extends RefFluent<RefNested<N>> implements Nested<N>{
  
    RefBuilder builder;
  
    RefNested(Ref item) {
      this.builder = new RefBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.withRef(builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class ResultsNested<N> extends StepResultFluent<ResultsNested<N>> implements Nested<N>{
  
    StepResultBuilder builder;
    int index;
  
    ResultsNested(int index,StepResult item) {
      this.index = index;
      this.builder = new StepResultBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
  public class StderrConfigNested<N> extends StepOutputConfigFluent<StderrConfigNested<N>> implements Nested<N>{
  
    StepOutputConfigBuilder builder;
  
    StderrConfigNested(StepOutputConfig item) {
      this.builder = new StepOutputConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.withStderrConfig(builder.build());
    }
    
    public N endStderrConfig() {
      return and();
    }
    
  }
  public class StdoutConfigNested<N> extends StepOutputConfigFluent<StdoutConfigNested<N>> implements Nested<N>{
  
    StepOutputConfigBuilder builder;
  
    StdoutConfigNested(StepOutputConfig item) {
      this.builder = new StepOutputConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.withStdoutConfig(builder.build());
    }
    
    public N endStdoutConfig() {
      return and();
    }
    
  }
  public class VolumeMountsNested<N> extends VolumeMountFluent<VolumeMountsNested<N>> implements Nested<N>{
  
    VolumeMountBuilder builder;
    int index;
  
    VolumeMountsNested(int index,VolumeMount item) {
      this.index = index;
      this.builder = new VolumeMountBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.setToVolumeMounts(index, builder.build());
    }
    
    public N endVolumeMount() {
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
      return (N) StepFluent.this.setToWhen(index, builder.build());
    }
    
    public N endWhen() {
      return and();
    }
    
  }
  public class WorkspacesNested<N> extends WorkspaceUsageFluent<WorkspacesNested<N>> implements Nested<N>{
  
    WorkspaceUsageBuilder builder;
    int index;
  
    WorkspacesNested(int index,WorkspaceUsage item) {
      this.index = index;
      this.builder = new WorkspaceUsageBuilder(this, item);
    }
  
    public N and() {
      return (N) StepFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}