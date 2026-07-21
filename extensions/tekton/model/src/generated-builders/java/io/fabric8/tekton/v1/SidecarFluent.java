package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.ContainerPortBuilder;
import io.fabric8.kubernetes.api.model.ContainerPortFluent;
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
public class SidecarFluent<A extends io.fabric8.tekton.v1.SidecarFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> args = new ArrayList<String>();
  private List<String> command = new ArrayList<String>();
  private ResourceRequirementsBuilder computeResources;
  private ArrayList<EnvVarBuilder> env = new ArrayList<EnvVarBuilder>();
  private List<EnvFromSource> envFrom = new ArrayList<EnvFromSource>();
  private String image;
  private String imagePullPolicy;
  private Lifecycle lifecycle;
  private Probe livenessProbe;
  private String name;
  private ArrayList<ContainerPortBuilder> ports = new ArrayList<ContainerPortBuilder>();
  private Probe readinessProbe;
  private String restartPolicy;
  private String script;
  private SecurityContext securityContext;
  private Probe startupProbe;
  private Boolean stdin;
  private Boolean stdinOnce;
  private String terminationMessagePath;
  private String terminationMessagePolicy;
  private Boolean tty;
  private List<VolumeDevice> volumeDevices = new ArrayList<VolumeDevice>();
  private ArrayList<VolumeMountBuilder> volumeMounts = new ArrayList<VolumeMountBuilder>();
  private String workingDir;
  private ArrayList<WorkspaceUsageBuilder> workspaces = new ArrayList<WorkspaceUsageBuilder>();

  public SidecarFluent() {
  }
  
  public SidecarFluent(Sidecar instance) {
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
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public A addNewPort(Integer containerPort,String hostIP,Integer hostPort,String name,String protocol) {
    return (A) this.addToPorts(new ContainerPort(containerPort, hostIP, hostPort, name, protocol));
  }
  
  public PortsNested<A> addNewPortLike(ContainerPort item) {
    return new PortsNested(-1, item);
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
  
  public ResourceRequirements buildComputeResources() {
    return this.computeResources != null ? this.computeResources.build() : null;
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
  
  public ContainerPort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public VolumeMount buildFirstVolumeMount() {
    return this.volumeMounts.get(0).build();
  }
  
  public WorkspaceUsage buildFirstWorkspace() {
    return this.workspaces.get(0).build();
  }
  
  public EnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public ContainerPort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public VolumeMount buildLastVolumeMount() {
    return this.volumeMounts.get(volumeMounts.size() - 1).build();
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
  
  public ContainerPort buildMatchingPort(Predicate<ContainerPortBuilder> predicate) {
      for (ContainerPortBuilder item : ports) {
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
  
  public WorkspaceUsage buildMatchingWorkspace(Predicate<WorkspaceUsageBuilder> predicate) {
      for (WorkspaceUsageBuilder item : workspaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerPort buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<ContainerPort> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  public VolumeMount buildVolumeMount(int index) {
    return this.volumeMounts.get(index).build();
  }
  
  public List<VolumeMount> buildVolumeMounts() {
    return this.volumeMounts != null ? build(volumeMounts) : null;
  }
  
  public WorkspaceUsage buildWorkspace(int index) {
    return this.workspaces.get(index).build();
  }
  
  public List<WorkspaceUsage> buildWorkspaces() {
    return this.workspaces != null ? build(workspaces) : null;
  }
  
  protected void copyInstance(Sidecar instance) {
    instance = instance != null ? instance : new Sidecar();
    if (instance != null) {
        this.withArgs(instance.getArgs());
        this.withCommand(instance.getCommand());
        this.withComputeResources(instance.getComputeResources());
        this.withEnv(instance.getEnv());
        this.withEnvFrom(instance.getEnvFrom());
        this.withImage(instance.getImage());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withLifecycle(instance.getLifecycle());
        this.withLivenessProbe(instance.getLivenessProbe());
        this.withName(instance.getName());
        this.withPorts(instance.getPorts());
        this.withReadinessProbe(instance.getReadinessProbe());
        this.withRestartPolicy(instance.getRestartPolicy());
        this.withScript(instance.getScript());
        this.withSecurityContext(instance.getSecurityContext());
        this.withStartupProbe(instance.getStartupProbe());
        this.withStdin(instance.getStdin());
        this.withStdinOnce(instance.getStdinOnce());
        this.withTerminationMessagePath(instance.getTerminationMessagePath());
        this.withTerminationMessagePolicy(instance.getTerminationMessagePolicy());
        this.withTty(instance.getTty());
        this.withVolumeDevices(instance.getVolumeDevices());
        this.withVolumeMounts(instance.getVolumeMounts());
        this.withWorkingDir(instance.getWorkingDir());
        this.withWorkspaces(instance.getWorkspaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComputeResourcesNested<A> editComputeResources() {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(null));
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
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public VolumeMountsNested<A> editFirstVolumeMount() {
    if (volumeMounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(0, this.buildVolumeMount(0));
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
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public VolumeMountsNested<A> editLastVolumeMount() {
    int index = volumeMounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
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
  
  public ComputeResourcesNested<A> editOrNewComputeResources() {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ComputeResourcesNested<A> editOrNewComputeResourcesLike(ResourceRequirements item) {
    return this.withNewComputeResourcesLike(Optional.ofNullable(this.buildComputeResources()).orElse(item));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public VolumeMountsNested<A> editVolumeMount(int index) {
    if (volumeMounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
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
    SidecarFluent that = (SidecarFluent) o;
    if (!(Objects.equals(args, that.args))) {
      return false;
    }
    if (!(Objects.equals(command, that.command))) {
      return false;
    }
    if (!(Objects.equals(computeResources, that.computeResources))) {
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
    if (!(Objects.equals(ports, that.ports))) {
      return false;
    }
    if (!(Objects.equals(readinessProbe, that.readinessProbe))) {
      return false;
    }
    if (!(Objects.equals(restartPolicy, that.restartPolicy))) {
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
    if (!(Objects.equals(stdin, that.stdin))) {
      return false;
    }
    if (!(Objects.equals(stdinOnce, that.stdinOnce))) {
      return false;
    }
    if (!(Objects.equals(terminationMessagePath, that.terminationMessagePath))) {
      return false;
    }
    if (!(Objects.equals(terminationMessagePolicy, that.terminationMessagePolicy))) {
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
  
  public Probe getReadinessProbe() {
    return this.readinessProbe;
  }
  
  public String getRestartPolicy() {
    return this.restartPolicy;
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
  
  public boolean hasComputeResources() {
    return this.computeResources != null;
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
  
  public boolean hasMatchingPort(Predicate<ContainerPortBuilder> predicate) {
      for (ContainerPortBuilder item : ports) {
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
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public boolean hasReadinessProbe() {
    return this.readinessProbe != null;
  }
  
  public boolean hasRestartPolicy() {
    return this.restartPolicy != null;
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
  
  public boolean hasStdin() {
    return this.stdin != null;
  }
  
  public boolean hasStdinOnce() {
    return this.stdinOnce != null;
  }
  
  public boolean hasTerminationMessagePath() {
    return this.terminationMessagePath != null;
  }
  
  public boolean hasTerminationMessagePolicy() {
    return this.terminationMessagePolicy != null;
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
  
  public boolean hasWorkingDir() {
    return this.workingDir != null;
  }
  
  public boolean hasWorkspaces() {
    return this.workspaces != null && !(this.workspaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(args, command, computeResources, env, envFrom, image, imagePullPolicy, lifecycle, livenessProbe, name, ports, readinessProbe, restartPolicy, script, securityContext, startupProbe, stdin, stdinOnce, terminationMessagePath, terminationMessagePolicy, tty, volumeDevices, volumeMounts, workingDir, workspaces, additionalProperties);
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
  
  public PortsNested<A> setNewPortLike(int index,ContainerPort item) {
    return new PortsNested(index, item);
  }
  
  public VolumeMountsNested<A> setNewVolumeMountLike(int index,VolumeMount item) {
    return new VolumeMountsNested(index, item);
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
    if (!(computeResources == null)) {
        sb.append("computeResources:");
        sb.append(computeResources);
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
    if (!(restartPolicy == null)) {
        sb.append("restartPolicy:");
        sb.append(restartPolicy);
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
  
  public ComputeResourcesNested<A> withNewComputeResources() {
    return new ComputeResourcesNested(null);
  }
  
  public ComputeResourcesNested<A> withNewComputeResourcesLike(ResourceRequirements item) {
    return new ComputeResourcesNested(item);
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
  
  public A withRestartPolicy(String restartPolicy) {
    this.restartPolicy = restartPolicy;
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
  
  public A withTerminationMessagePath(String terminationMessagePath) {
    this.terminationMessagePath = terminationMessagePath;
    return (A) this;
  }
  
  public A withTerminationMessagePolicy(String terminationMessagePolicy) {
    this.terminationMessagePolicy = terminationMessagePolicy;
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
  public class ComputeResourcesNested<N> extends ResourceRequirementsFluent<ComputeResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ComputeResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) SidecarFluent.this.withComputeResources(builder.build());
    }
    
    public N endComputeResources() {
      return and();
    }
    
  }
  public class EnvNested<N> extends EnvVarFluent<EnvNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    EnvNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) SidecarFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
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
      return (N) SidecarFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
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
      return (N) SidecarFluent.this.setToVolumeMounts(index, builder.build());
    }
    
    public N endVolumeMount() {
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
      return (N) SidecarFluent.this.setToWorkspaces(index, builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}