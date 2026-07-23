package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PodSecurityPolicySpecFluent<A extends io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowPrivilegeEscalation;
  private ArrayList<AllowedCSIDriverBuilder> allowedCSIDrivers = new ArrayList<AllowedCSIDriverBuilder>();
  private List<String> allowedCapabilities = new ArrayList<String>();
  private ArrayList<AllowedFlexVolumeBuilder> allowedFlexVolumes = new ArrayList<AllowedFlexVolumeBuilder>();
  private ArrayList<AllowedHostPathBuilder> allowedHostPaths = new ArrayList<AllowedHostPathBuilder>();
  private List<String> allowedProcMountTypes = new ArrayList<String>();
  private List<String> allowedUnsafeSysctls = new ArrayList<String>();
  private List<String> defaultAddCapabilities = new ArrayList<String>();
  private Boolean defaultAllowPrivilegeEscalation;
  private List<String> forbiddenSysctls = new ArrayList<String>();
  private FSGroupStrategyOptionsBuilder fsGroup;
  private Boolean hostIPC;
  private Boolean hostNetwork;
  private Boolean hostPID;
  private ArrayList<HostPortRangeBuilder> hostPorts = new ArrayList<HostPortRangeBuilder>();
  private Boolean privileged;
  private Boolean readOnlyRootFilesystem;
  private List<String> requiredDropCapabilities = new ArrayList<String>();
  private RunAsGroupStrategyOptionsBuilder runAsGroup;
  private RunAsUserStrategyOptionsBuilder runAsUser;
  private RuntimeClassStrategyOptionsBuilder runtimeClass;
  private SELinuxStrategyOptionsBuilder seLinux;
  private SupplementalGroupsStrategyOptionsBuilder supplementalGroups;
  private List<String> volumes = new ArrayList<String>();

  public PodSecurityPolicySpecFluent() {
  }
  
  public PodSecurityPolicySpecFluent(PodSecurityPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedCSIDrivers(Collection<AllowedCSIDriver> items) {
    if (this.allowedCSIDrivers == null) {
      this.allowedCSIDrivers = new ArrayList();
    }
    for (AllowedCSIDriver item : items) {
        AllowedCSIDriverBuilder builder = new AllowedCSIDriverBuilder(item);
        _visitables.get("allowedCSIDrivers").add(builder);
        this.allowedCSIDrivers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToAllowedCapabilities(Collection<String> items) {
    if (this.allowedCapabilities == null) {
      this.allowedCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.allowedCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addAllToAllowedFlexVolumes(Collection<AllowedFlexVolume> items) {
    if (this.allowedFlexVolumes == null) {
      this.allowedFlexVolumes = new ArrayList();
    }
    for (AllowedFlexVolume item : items) {
        AllowedFlexVolumeBuilder builder = new AllowedFlexVolumeBuilder(item);
        _visitables.get("allowedFlexVolumes").add(builder);
        this.allowedFlexVolumes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToAllowedHostPaths(Collection<AllowedHostPath> items) {
    if (this.allowedHostPaths == null) {
      this.allowedHostPaths = new ArrayList();
    }
    for (AllowedHostPath item : items) {
        AllowedHostPathBuilder builder = new AllowedHostPathBuilder(item);
        _visitables.get("allowedHostPaths").add(builder);
        this.allowedHostPaths.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToAllowedProcMountTypes(Collection<String> items) {
    if (this.allowedProcMountTypes == null) {
      this.allowedProcMountTypes = new ArrayList();
    }
    for (String item : items) {
      this.allowedProcMountTypes.add(item);
    }
    return (A) this;
  }
  
  public A addAllToAllowedUnsafeSysctls(Collection<String> items) {
    if (this.allowedUnsafeSysctls == null) {
      this.allowedUnsafeSysctls = new ArrayList();
    }
    for (String item : items) {
      this.allowedUnsafeSysctls.add(item);
    }
    return (A) this;
  }
  
  public A addAllToDefaultAddCapabilities(Collection<String> items) {
    if (this.defaultAddCapabilities == null) {
      this.defaultAddCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.defaultAddCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addAllToForbiddenSysctls(Collection<String> items) {
    if (this.forbiddenSysctls == null) {
      this.forbiddenSysctls = new ArrayList();
    }
    for (String item : items) {
      this.forbiddenSysctls.add(item);
    }
    return (A) this;
  }
  
  public A addAllToHostPorts(Collection<HostPortRange> items) {
    if (this.hostPorts == null) {
      this.hostPorts = new ArrayList();
    }
    for (HostPortRange item : items) {
        HostPortRangeBuilder builder = new HostPortRangeBuilder(item);
        _visitables.get("hostPorts").add(builder);
        this.hostPorts.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRequiredDropCapabilities(Collection<String> items) {
    if (this.requiredDropCapabilities == null) {
      this.requiredDropCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.requiredDropCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addAllToVolumes(Collection<String> items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (String item : items) {
      this.volumes.add(item);
    }
    return (A) this;
  }
  
  public AllowedCSIDriversNested<A> addNewAllowedCSIDriver() {
    return new AllowedCSIDriversNested(-1, null);
  }
  
  public A addNewAllowedCSIDriver(String name) {
    return (A) this.addToAllowedCSIDrivers(new AllowedCSIDriver(name));
  }
  
  public AllowedCSIDriversNested<A> addNewAllowedCSIDriverLike(AllowedCSIDriver item) {
    return new AllowedCSIDriversNested(-1, item);
  }
  
  public AllowedFlexVolumesNested<A> addNewAllowedFlexVolume() {
    return new AllowedFlexVolumesNested(-1, null);
  }
  
  public A addNewAllowedFlexVolume(String driver) {
    return (A) this.addToAllowedFlexVolumes(new AllowedFlexVolume(driver));
  }
  
  public AllowedFlexVolumesNested<A> addNewAllowedFlexVolumeLike(AllowedFlexVolume item) {
    return new AllowedFlexVolumesNested(-1, item);
  }
  
  public AllowedHostPathsNested<A> addNewAllowedHostPath() {
    return new AllowedHostPathsNested(-1, null);
  }
  
  public A addNewAllowedHostPath(String pathPrefix,Boolean readOnly) {
    return (A) this.addToAllowedHostPaths(new AllowedHostPath(pathPrefix, readOnly));
  }
  
  public AllowedHostPathsNested<A> addNewAllowedHostPathLike(AllowedHostPath item) {
    return new AllowedHostPathsNested(-1, item);
  }
  
  public HostPortsNested<A> addNewHostPort() {
    return new HostPortsNested(-1, null);
  }
  
  public A addNewHostPort(Integer max,Integer min) {
    return (A) this.addToHostPorts(new HostPortRange(max, min));
  }
  
  public HostPortsNested<A> addNewHostPortLike(HostPortRange item) {
    return new HostPortsNested(-1, item);
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
  
  public A addToAllowedCSIDrivers(AllowedCSIDriver... items) {
    if (this.allowedCSIDrivers == null) {
      this.allowedCSIDrivers = new ArrayList();
    }
    for (AllowedCSIDriver item : items) {
        AllowedCSIDriverBuilder builder = new AllowedCSIDriverBuilder(item);
        _visitables.get("allowedCSIDrivers").add(builder);
        this.allowedCSIDrivers.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllowedCSIDrivers(int index,AllowedCSIDriver item) {
    if (this.allowedCSIDrivers == null) {
      this.allowedCSIDrivers = new ArrayList();
    }
    AllowedCSIDriverBuilder builder = new AllowedCSIDriverBuilder(item);
    if (index < 0 || index >= allowedCSIDrivers.size()) {
        _visitables.get("allowedCSIDrivers").add(builder);
        allowedCSIDrivers.add(builder);
    } else {
        _visitables.get("allowedCSIDrivers").add(builder);
        allowedCSIDrivers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAllowedCapabilities(String... items) {
    if (this.allowedCapabilities == null) {
      this.allowedCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.allowedCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedCapabilities(int index,String item) {
    if (this.allowedCapabilities == null) {
      this.allowedCapabilities = new ArrayList();
    }
    this.allowedCapabilities.add(index, item);
    return (A) this;
  }
  
  public A addToAllowedFlexVolumes(AllowedFlexVolume... items) {
    if (this.allowedFlexVolumes == null) {
      this.allowedFlexVolumes = new ArrayList();
    }
    for (AllowedFlexVolume item : items) {
        AllowedFlexVolumeBuilder builder = new AllowedFlexVolumeBuilder(item);
        _visitables.get("allowedFlexVolumes").add(builder);
        this.allowedFlexVolumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllowedFlexVolumes(int index,AllowedFlexVolume item) {
    if (this.allowedFlexVolumes == null) {
      this.allowedFlexVolumes = new ArrayList();
    }
    AllowedFlexVolumeBuilder builder = new AllowedFlexVolumeBuilder(item);
    if (index < 0 || index >= allowedFlexVolumes.size()) {
        _visitables.get("allowedFlexVolumes").add(builder);
        allowedFlexVolumes.add(builder);
    } else {
        _visitables.get("allowedFlexVolumes").add(builder);
        allowedFlexVolumes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAllowedHostPaths(AllowedHostPath... items) {
    if (this.allowedHostPaths == null) {
      this.allowedHostPaths = new ArrayList();
    }
    for (AllowedHostPath item : items) {
        AllowedHostPathBuilder builder = new AllowedHostPathBuilder(item);
        _visitables.get("allowedHostPaths").add(builder);
        this.allowedHostPaths.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllowedHostPaths(int index,AllowedHostPath item) {
    if (this.allowedHostPaths == null) {
      this.allowedHostPaths = new ArrayList();
    }
    AllowedHostPathBuilder builder = new AllowedHostPathBuilder(item);
    if (index < 0 || index >= allowedHostPaths.size()) {
        _visitables.get("allowedHostPaths").add(builder);
        allowedHostPaths.add(builder);
    } else {
        _visitables.get("allowedHostPaths").add(builder);
        allowedHostPaths.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAllowedProcMountTypes(String... items) {
    if (this.allowedProcMountTypes == null) {
      this.allowedProcMountTypes = new ArrayList();
    }
    for (String item : items) {
      this.allowedProcMountTypes.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedProcMountTypes(int index,String item) {
    if (this.allowedProcMountTypes == null) {
      this.allowedProcMountTypes = new ArrayList();
    }
    this.allowedProcMountTypes.add(index, item);
    return (A) this;
  }
  
  public A addToAllowedUnsafeSysctls(String... items) {
    if (this.allowedUnsafeSysctls == null) {
      this.allowedUnsafeSysctls = new ArrayList();
    }
    for (String item : items) {
      this.allowedUnsafeSysctls.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedUnsafeSysctls(int index,String item) {
    if (this.allowedUnsafeSysctls == null) {
      this.allowedUnsafeSysctls = new ArrayList();
    }
    this.allowedUnsafeSysctls.add(index, item);
    return (A) this;
  }
  
  public A addToDefaultAddCapabilities(String... items) {
    if (this.defaultAddCapabilities == null) {
      this.defaultAddCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.defaultAddCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addToDefaultAddCapabilities(int index,String item) {
    if (this.defaultAddCapabilities == null) {
      this.defaultAddCapabilities = new ArrayList();
    }
    this.defaultAddCapabilities.add(index, item);
    return (A) this;
  }
  
  public A addToForbiddenSysctls(String... items) {
    if (this.forbiddenSysctls == null) {
      this.forbiddenSysctls = new ArrayList();
    }
    for (String item : items) {
      this.forbiddenSysctls.add(item);
    }
    return (A) this;
  }
  
  public A addToForbiddenSysctls(int index,String item) {
    if (this.forbiddenSysctls == null) {
      this.forbiddenSysctls = new ArrayList();
    }
    this.forbiddenSysctls.add(index, item);
    return (A) this;
  }
  
  public A addToHostPorts(HostPortRange... items) {
    if (this.hostPorts == null) {
      this.hostPorts = new ArrayList();
    }
    for (HostPortRange item : items) {
        HostPortRangeBuilder builder = new HostPortRangeBuilder(item);
        _visitables.get("hostPorts").add(builder);
        this.hostPorts.add(builder);
    }
    return (A) this;
  }
  
  public A addToHostPorts(int index,HostPortRange item) {
    if (this.hostPorts == null) {
      this.hostPorts = new ArrayList();
    }
    HostPortRangeBuilder builder = new HostPortRangeBuilder(item);
    if (index < 0 || index >= hostPorts.size()) {
        _visitables.get("hostPorts").add(builder);
        hostPorts.add(builder);
    } else {
        _visitables.get("hostPorts").add(builder);
        hostPorts.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRequiredDropCapabilities(String... items) {
    if (this.requiredDropCapabilities == null) {
      this.requiredDropCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.requiredDropCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addToRequiredDropCapabilities(int index,String item) {
    if (this.requiredDropCapabilities == null) {
      this.requiredDropCapabilities = new ArrayList();
    }
    this.requiredDropCapabilities.add(index, item);
    return (A) this;
  }
  
  public A addToVolumes(String... items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (String item : items) {
      this.volumes.add(item);
    }
    return (A) this;
  }
  
  public A addToVolumes(int index,String item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    this.volumes.add(index, item);
    return (A) this;
  }
  
  public AllowedCSIDriver buildAllowedCSIDriver(int index) {
    return this.allowedCSIDrivers.get(index).build();
  }
  
  public List<AllowedCSIDriver> buildAllowedCSIDrivers() {
    return this.allowedCSIDrivers != null ? build(allowedCSIDrivers) : null;
  }
  
  public AllowedFlexVolume buildAllowedFlexVolume(int index) {
    return this.allowedFlexVolumes.get(index).build();
  }
  
  public List<AllowedFlexVolume> buildAllowedFlexVolumes() {
    return this.allowedFlexVolumes != null ? build(allowedFlexVolumes) : null;
  }
  
  public AllowedHostPath buildAllowedHostPath(int index) {
    return this.allowedHostPaths.get(index).build();
  }
  
  public List<AllowedHostPath> buildAllowedHostPaths() {
    return this.allowedHostPaths != null ? build(allowedHostPaths) : null;
  }
  
  public AllowedCSIDriver buildFirstAllowedCSIDriver() {
    return this.allowedCSIDrivers.get(0).build();
  }
  
  public AllowedFlexVolume buildFirstAllowedFlexVolume() {
    return this.allowedFlexVolumes.get(0).build();
  }
  
  public AllowedHostPath buildFirstAllowedHostPath() {
    return this.allowedHostPaths.get(0).build();
  }
  
  public HostPortRange buildFirstHostPort() {
    return this.hostPorts.get(0).build();
  }
  
  public FSGroupStrategyOptions buildFsGroup() {
    return this.fsGroup != null ? this.fsGroup.build() : null;
  }
  
  public HostPortRange buildHostPort(int index) {
    return this.hostPorts.get(index).build();
  }
  
  public List<HostPortRange> buildHostPorts() {
    return this.hostPorts != null ? build(hostPorts) : null;
  }
  
  public AllowedCSIDriver buildLastAllowedCSIDriver() {
    return this.allowedCSIDrivers.get(allowedCSIDrivers.size() - 1).build();
  }
  
  public AllowedFlexVolume buildLastAllowedFlexVolume() {
    return this.allowedFlexVolumes.get(allowedFlexVolumes.size() - 1).build();
  }
  
  public AllowedHostPath buildLastAllowedHostPath() {
    return this.allowedHostPaths.get(allowedHostPaths.size() - 1).build();
  }
  
  public HostPortRange buildLastHostPort() {
    return this.hostPorts.get(hostPorts.size() - 1).build();
  }
  
  public AllowedCSIDriver buildMatchingAllowedCSIDriver(Predicate<AllowedCSIDriverBuilder> predicate) {
      for (AllowedCSIDriverBuilder item : allowedCSIDrivers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AllowedFlexVolume buildMatchingAllowedFlexVolume(Predicate<AllowedFlexVolumeBuilder> predicate) {
      for (AllowedFlexVolumeBuilder item : allowedFlexVolumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AllowedHostPath buildMatchingAllowedHostPath(Predicate<AllowedHostPathBuilder> predicate) {
      for (AllowedHostPathBuilder item : allowedHostPaths) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HostPortRange buildMatchingHostPort(Predicate<HostPortRangeBuilder> predicate) {
      for (HostPortRangeBuilder item : hostPorts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RunAsGroupStrategyOptions buildRunAsGroup() {
    return this.runAsGroup != null ? this.runAsGroup.build() : null;
  }
  
  public RunAsUserStrategyOptions buildRunAsUser() {
    return this.runAsUser != null ? this.runAsUser.build() : null;
  }
  
  public RuntimeClassStrategyOptions buildRuntimeClass() {
    return this.runtimeClass != null ? this.runtimeClass.build() : null;
  }
  
  public SELinuxStrategyOptions buildSeLinux() {
    return this.seLinux != null ? this.seLinux.build() : null;
  }
  
  public SupplementalGroupsStrategyOptions buildSupplementalGroups() {
    return this.supplementalGroups != null ? this.supplementalGroups.build() : null;
  }
  
  protected void copyInstance(PodSecurityPolicySpec instance) {
    instance = instance != null ? instance : new PodSecurityPolicySpec();
    if (instance != null) {
        this.withAllowPrivilegeEscalation(instance.getAllowPrivilegeEscalation());
        this.withAllowedCSIDrivers(instance.getAllowedCSIDrivers());
        this.withAllowedCapabilities(instance.getAllowedCapabilities());
        this.withAllowedFlexVolumes(instance.getAllowedFlexVolumes());
        this.withAllowedHostPaths(instance.getAllowedHostPaths());
        this.withAllowedProcMountTypes(instance.getAllowedProcMountTypes());
        this.withAllowedUnsafeSysctls(instance.getAllowedUnsafeSysctls());
        this.withDefaultAddCapabilities(instance.getDefaultAddCapabilities());
        this.withDefaultAllowPrivilegeEscalation(instance.getDefaultAllowPrivilegeEscalation());
        this.withForbiddenSysctls(instance.getForbiddenSysctls());
        this.withFsGroup(instance.getFsGroup());
        this.withHostIPC(instance.getHostIPC());
        this.withHostNetwork(instance.getHostNetwork());
        this.withHostPID(instance.getHostPID());
        this.withHostPorts(instance.getHostPorts());
        this.withPrivileged(instance.getPrivileged());
        this.withReadOnlyRootFilesystem(instance.getReadOnlyRootFilesystem());
        this.withRequiredDropCapabilities(instance.getRequiredDropCapabilities());
        this.withRunAsGroup(instance.getRunAsGroup());
        this.withRunAsUser(instance.getRunAsUser());
        this.withRuntimeClass(instance.getRuntimeClass());
        this.withSeLinux(instance.getSeLinux());
        this.withSupplementalGroups(instance.getSupplementalGroups());
        this.withVolumes(instance.getVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllowedCSIDriversNested<A> editAllowedCSIDriver(int index) {
    if (allowedCSIDrivers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allowedCSIDrivers"));
    }
    return this.setNewAllowedCSIDriverLike(index, this.buildAllowedCSIDriver(index));
  }
  
  public AllowedFlexVolumesNested<A> editAllowedFlexVolume(int index) {
    if (allowedFlexVolumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allowedFlexVolumes"));
    }
    return this.setNewAllowedFlexVolumeLike(index, this.buildAllowedFlexVolume(index));
  }
  
  public AllowedHostPathsNested<A> editAllowedHostPath(int index) {
    if (allowedHostPaths.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allowedHostPaths"));
    }
    return this.setNewAllowedHostPathLike(index, this.buildAllowedHostPath(index));
  }
  
  public AllowedCSIDriversNested<A> editFirstAllowedCSIDriver() {
    if (allowedCSIDrivers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allowedCSIDrivers"));
    }
    return this.setNewAllowedCSIDriverLike(0, this.buildAllowedCSIDriver(0));
  }
  
  public AllowedFlexVolumesNested<A> editFirstAllowedFlexVolume() {
    if (allowedFlexVolumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allowedFlexVolumes"));
    }
    return this.setNewAllowedFlexVolumeLike(0, this.buildAllowedFlexVolume(0));
  }
  
  public AllowedHostPathsNested<A> editFirstAllowedHostPath() {
    if (allowedHostPaths.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allowedHostPaths"));
    }
    return this.setNewAllowedHostPathLike(0, this.buildAllowedHostPath(0));
  }
  
  public HostPortsNested<A> editFirstHostPort() {
    if (hostPorts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hostPorts"));
    }
    return this.setNewHostPortLike(0, this.buildHostPort(0));
  }
  
  public FsGroupNested<A> editFsGroup() {
    return this.withNewFsGroupLike(Optional.ofNullable(this.buildFsGroup()).orElse(null));
  }
  
  public HostPortsNested<A> editHostPort(int index) {
    if (hostPorts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hostPorts"));
    }
    return this.setNewHostPortLike(index, this.buildHostPort(index));
  }
  
  public AllowedCSIDriversNested<A> editLastAllowedCSIDriver() {
    int index = allowedCSIDrivers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allowedCSIDrivers"));
    }
    return this.setNewAllowedCSIDriverLike(index, this.buildAllowedCSIDriver(index));
  }
  
  public AllowedFlexVolumesNested<A> editLastAllowedFlexVolume() {
    int index = allowedFlexVolumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allowedFlexVolumes"));
    }
    return this.setNewAllowedFlexVolumeLike(index, this.buildAllowedFlexVolume(index));
  }
  
  public AllowedHostPathsNested<A> editLastAllowedHostPath() {
    int index = allowedHostPaths.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allowedHostPaths"));
    }
    return this.setNewAllowedHostPathLike(index, this.buildAllowedHostPath(index));
  }
  
  public HostPortsNested<A> editLastHostPort() {
    int index = hostPorts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hostPorts"));
    }
    return this.setNewHostPortLike(index, this.buildHostPort(index));
  }
  
  public AllowedCSIDriversNested<A> editMatchingAllowedCSIDriver(Predicate<AllowedCSIDriverBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allowedCSIDrivers.size();i++) {
      if (predicate.test(allowedCSIDrivers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allowedCSIDrivers"));
    }
    return this.setNewAllowedCSIDriverLike(index, this.buildAllowedCSIDriver(index));
  }
  
  public AllowedFlexVolumesNested<A> editMatchingAllowedFlexVolume(Predicate<AllowedFlexVolumeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allowedFlexVolumes.size();i++) {
      if (predicate.test(allowedFlexVolumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allowedFlexVolumes"));
    }
    return this.setNewAllowedFlexVolumeLike(index, this.buildAllowedFlexVolume(index));
  }
  
  public AllowedHostPathsNested<A> editMatchingAllowedHostPath(Predicate<AllowedHostPathBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allowedHostPaths.size();i++) {
      if (predicate.test(allowedHostPaths.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allowedHostPaths"));
    }
    return this.setNewAllowedHostPathLike(index, this.buildAllowedHostPath(index));
  }
  
  public HostPortsNested<A> editMatchingHostPort(Predicate<HostPortRangeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hostPorts.size();i++) {
      if (predicate.test(hostPorts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hostPorts"));
    }
    return this.setNewHostPortLike(index, this.buildHostPort(index));
  }
  
  public FsGroupNested<A> editOrNewFsGroup() {
    return this.withNewFsGroupLike(Optional.ofNullable(this.buildFsGroup()).orElse(new FSGroupStrategyOptionsBuilder().build()));
  }
  
  public FsGroupNested<A> editOrNewFsGroupLike(FSGroupStrategyOptions item) {
    return this.withNewFsGroupLike(Optional.ofNullable(this.buildFsGroup()).orElse(item));
  }
  
  public RunAsGroupNested<A> editOrNewRunAsGroup() {
    return this.withNewRunAsGroupLike(Optional.ofNullable(this.buildRunAsGroup()).orElse(new RunAsGroupStrategyOptionsBuilder().build()));
  }
  
  public RunAsGroupNested<A> editOrNewRunAsGroupLike(RunAsGroupStrategyOptions item) {
    return this.withNewRunAsGroupLike(Optional.ofNullable(this.buildRunAsGroup()).orElse(item));
  }
  
  public RunAsUserNested<A> editOrNewRunAsUser() {
    return this.withNewRunAsUserLike(Optional.ofNullable(this.buildRunAsUser()).orElse(new RunAsUserStrategyOptionsBuilder().build()));
  }
  
  public RunAsUserNested<A> editOrNewRunAsUserLike(RunAsUserStrategyOptions item) {
    return this.withNewRunAsUserLike(Optional.ofNullable(this.buildRunAsUser()).orElse(item));
  }
  
  public RuntimeClassNested<A> editOrNewRuntimeClass() {
    return this.withNewRuntimeClassLike(Optional.ofNullable(this.buildRuntimeClass()).orElse(new RuntimeClassStrategyOptionsBuilder().build()));
  }
  
  public RuntimeClassNested<A> editOrNewRuntimeClassLike(RuntimeClassStrategyOptions item) {
    return this.withNewRuntimeClassLike(Optional.ofNullable(this.buildRuntimeClass()).orElse(item));
  }
  
  public SeLinuxNested<A> editOrNewSeLinux() {
    return this.withNewSeLinuxLike(Optional.ofNullable(this.buildSeLinux()).orElse(new SELinuxStrategyOptionsBuilder().build()));
  }
  
  public SeLinuxNested<A> editOrNewSeLinuxLike(SELinuxStrategyOptions item) {
    return this.withNewSeLinuxLike(Optional.ofNullable(this.buildSeLinux()).orElse(item));
  }
  
  public SupplementalGroupsNested<A> editOrNewSupplementalGroups() {
    return this.withNewSupplementalGroupsLike(Optional.ofNullable(this.buildSupplementalGroups()).orElse(new SupplementalGroupsStrategyOptionsBuilder().build()));
  }
  
  public SupplementalGroupsNested<A> editOrNewSupplementalGroupsLike(SupplementalGroupsStrategyOptions item) {
    return this.withNewSupplementalGroupsLike(Optional.ofNullable(this.buildSupplementalGroups()).orElse(item));
  }
  
  public RunAsGroupNested<A> editRunAsGroup() {
    return this.withNewRunAsGroupLike(Optional.ofNullable(this.buildRunAsGroup()).orElse(null));
  }
  
  public RunAsUserNested<A> editRunAsUser() {
    return this.withNewRunAsUserLike(Optional.ofNullable(this.buildRunAsUser()).orElse(null));
  }
  
  public RuntimeClassNested<A> editRuntimeClass() {
    return this.withNewRuntimeClassLike(Optional.ofNullable(this.buildRuntimeClass()).orElse(null));
  }
  
  public SeLinuxNested<A> editSeLinux() {
    return this.withNewSeLinuxLike(Optional.ofNullable(this.buildSeLinux()).orElse(null));
  }
  
  public SupplementalGroupsNested<A> editSupplementalGroups() {
    return this.withNewSupplementalGroupsLike(Optional.ofNullable(this.buildSupplementalGroups()).orElse(null));
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
    PodSecurityPolicySpecFluent that = (PodSecurityPolicySpecFluent) o;
    if (!(Objects.equals(allowPrivilegeEscalation, that.allowPrivilegeEscalation))) {
      return false;
    }
    if (!(Objects.equals(allowedCSIDrivers, that.allowedCSIDrivers))) {
      return false;
    }
    if (!(Objects.equals(allowedCapabilities, that.allowedCapabilities))) {
      return false;
    }
    if (!(Objects.equals(allowedFlexVolumes, that.allowedFlexVolumes))) {
      return false;
    }
    if (!(Objects.equals(allowedHostPaths, that.allowedHostPaths))) {
      return false;
    }
    if (!(Objects.equals(allowedProcMountTypes, that.allowedProcMountTypes))) {
      return false;
    }
    if (!(Objects.equals(allowedUnsafeSysctls, that.allowedUnsafeSysctls))) {
      return false;
    }
    if (!(Objects.equals(defaultAddCapabilities, that.defaultAddCapabilities))) {
      return false;
    }
    if (!(Objects.equals(defaultAllowPrivilegeEscalation, that.defaultAllowPrivilegeEscalation))) {
      return false;
    }
    if (!(Objects.equals(forbiddenSysctls, that.forbiddenSysctls))) {
      return false;
    }
    if (!(Objects.equals(fsGroup, that.fsGroup))) {
      return false;
    }
    if (!(Objects.equals(hostIPC, that.hostIPC))) {
      return false;
    }
    if (!(Objects.equals(hostNetwork, that.hostNetwork))) {
      return false;
    }
    if (!(Objects.equals(hostPID, that.hostPID))) {
      return false;
    }
    if (!(Objects.equals(hostPorts, that.hostPorts))) {
      return false;
    }
    if (!(Objects.equals(privileged, that.privileged))) {
      return false;
    }
    if (!(Objects.equals(readOnlyRootFilesystem, that.readOnlyRootFilesystem))) {
      return false;
    }
    if (!(Objects.equals(requiredDropCapabilities, that.requiredDropCapabilities))) {
      return false;
    }
    if (!(Objects.equals(runAsGroup, that.runAsGroup))) {
      return false;
    }
    if (!(Objects.equals(runAsUser, that.runAsUser))) {
      return false;
    }
    if (!(Objects.equals(runtimeClass, that.runtimeClass))) {
      return false;
    }
    if (!(Objects.equals(seLinux, that.seLinux))) {
      return false;
    }
    if (!(Objects.equals(supplementalGroups, that.supplementalGroups))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
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
  
  public Boolean getAllowPrivilegeEscalation() {
    return this.allowPrivilegeEscalation;
  }
  
  public List<String> getAllowedCapabilities() {
    return this.allowedCapabilities;
  }
  
  public String getAllowedCapability(int index) {
    return this.allowedCapabilities.get(index);
  }
  
  public String getAllowedProcMountType(int index) {
    return this.allowedProcMountTypes.get(index);
  }
  
  public List<String> getAllowedProcMountTypes() {
    return this.allowedProcMountTypes;
  }
  
  public String getAllowedUnsafeSysctl(int index) {
    return this.allowedUnsafeSysctls.get(index);
  }
  
  public List<String> getAllowedUnsafeSysctls() {
    return this.allowedUnsafeSysctls;
  }
  
  public List<String> getDefaultAddCapabilities() {
    return this.defaultAddCapabilities;
  }
  
  public String getDefaultAddCapability(int index) {
    return this.defaultAddCapabilities.get(index);
  }
  
  public Boolean getDefaultAllowPrivilegeEscalation() {
    return this.defaultAllowPrivilegeEscalation;
  }
  
  public String getFirstAllowedCapability() {
    return this.allowedCapabilities.get(0);
  }
  
  public String getFirstAllowedProcMountType() {
    return this.allowedProcMountTypes.get(0);
  }
  
  public String getFirstAllowedUnsafeSysctl() {
    return this.allowedUnsafeSysctls.get(0);
  }
  
  public String getFirstDefaultAddCapability() {
    return this.defaultAddCapabilities.get(0);
  }
  
  public String getFirstForbiddenSysctl() {
    return this.forbiddenSysctls.get(0);
  }
  
  public String getFirstRequiredDropCapability() {
    return this.requiredDropCapabilities.get(0);
  }
  
  public String getFirstVolume() {
    return this.volumes.get(0);
  }
  
  public String getForbiddenSysctl(int index) {
    return this.forbiddenSysctls.get(index);
  }
  
  public List<String> getForbiddenSysctls() {
    return this.forbiddenSysctls;
  }
  
  public Boolean getHostIPC() {
    return this.hostIPC;
  }
  
  public Boolean getHostNetwork() {
    return this.hostNetwork;
  }
  
  public Boolean getHostPID() {
    return this.hostPID;
  }
  
  public String getLastAllowedCapability() {
    return this.allowedCapabilities.get(allowedCapabilities.size() - 1);
  }
  
  public String getLastAllowedProcMountType() {
    return this.allowedProcMountTypes.get(allowedProcMountTypes.size() - 1);
  }
  
  public String getLastAllowedUnsafeSysctl() {
    return this.allowedUnsafeSysctls.get(allowedUnsafeSysctls.size() - 1);
  }
  
  public String getLastDefaultAddCapability() {
    return this.defaultAddCapabilities.get(defaultAddCapabilities.size() - 1);
  }
  
  public String getLastForbiddenSysctl() {
    return this.forbiddenSysctls.get(forbiddenSysctls.size() - 1);
  }
  
  public String getLastRequiredDropCapability() {
    return this.requiredDropCapabilities.get(requiredDropCapabilities.size() - 1);
  }
  
  public String getLastVolume() {
    return this.volumes.get(volumes.size() - 1);
  }
  
  public String getMatchingAllowedCapability(Predicate<String> predicate) {
      for (String item : allowedCapabilities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingAllowedProcMountType(Predicate<String> predicate) {
      for (String item : allowedProcMountTypes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingAllowedUnsafeSysctl(Predicate<String> predicate) {
      for (String item : allowedUnsafeSysctls) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingDefaultAddCapability(Predicate<String> predicate) {
      for (String item : defaultAddCapabilities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingForbiddenSysctl(Predicate<String> predicate) {
      for (String item : forbiddenSysctls) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRequiredDropCapability(Predicate<String> predicate) {
      for (String item : requiredDropCapabilities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingVolume(Predicate<String> predicate) {
      for (String item : volumes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getPrivileged() {
    return this.privileged;
  }
  
  public Boolean getReadOnlyRootFilesystem() {
    return this.readOnlyRootFilesystem;
  }
  
  public List<String> getRequiredDropCapabilities() {
    return this.requiredDropCapabilities;
  }
  
  public String getRequiredDropCapability(int index) {
    return this.requiredDropCapabilities.get(index);
  }
  
  public String getVolume(int index) {
    return this.volumes.get(index);
  }
  
  public List<String> getVolumes() {
    return this.volumes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowPrivilegeEscalation() {
    return this.allowPrivilegeEscalation != null;
  }
  
  public boolean hasAllowedCSIDrivers() {
    return this.allowedCSIDrivers != null && !(this.allowedCSIDrivers.isEmpty());
  }
  
  public boolean hasAllowedCapabilities() {
    return this.allowedCapabilities != null && !(this.allowedCapabilities.isEmpty());
  }
  
  public boolean hasAllowedFlexVolumes() {
    return this.allowedFlexVolumes != null && !(this.allowedFlexVolumes.isEmpty());
  }
  
  public boolean hasAllowedHostPaths() {
    return this.allowedHostPaths != null && !(this.allowedHostPaths.isEmpty());
  }
  
  public boolean hasAllowedProcMountTypes() {
    return this.allowedProcMountTypes != null && !(this.allowedProcMountTypes.isEmpty());
  }
  
  public boolean hasAllowedUnsafeSysctls() {
    return this.allowedUnsafeSysctls != null && !(this.allowedUnsafeSysctls.isEmpty());
  }
  
  public boolean hasDefaultAddCapabilities() {
    return this.defaultAddCapabilities != null && !(this.defaultAddCapabilities.isEmpty());
  }
  
  public boolean hasDefaultAllowPrivilegeEscalation() {
    return this.defaultAllowPrivilegeEscalation != null;
  }
  
  public boolean hasForbiddenSysctls() {
    return this.forbiddenSysctls != null && !(this.forbiddenSysctls.isEmpty());
  }
  
  public boolean hasFsGroup() {
    return this.fsGroup != null;
  }
  
  public boolean hasHostIPC() {
    return this.hostIPC != null;
  }
  
  public boolean hasHostNetwork() {
    return this.hostNetwork != null;
  }
  
  public boolean hasHostPID() {
    return this.hostPID != null;
  }
  
  public boolean hasHostPorts() {
    return this.hostPorts != null && !(this.hostPorts.isEmpty());
  }
  
  public boolean hasMatchingAllowedCSIDriver(Predicate<AllowedCSIDriverBuilder> predicate) {
      for (AllowedCSIDriverBuilder item : allowedCSIDrivers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAllowedCapability(Predicate<String> predicate) {
      for (String item : allowedCapabilities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAllowedFlexVolume(Predicate<AllowedFlexVolumeBuilder> predicate) {
      for (AllowedFlexVolumeBuilder item : allowedFlexVolumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAllowedHostPath(Predicate<AllowedHostPathBuilder> predicate) {
      for (AllowedHostPathBuilder item : allowedHostPaths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAllowedProcMountType(Predicate<String> predicate) {
      for (String item : allowedProcMountTypes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAllowedUnsafeSysctl(Predicate<String> predicate) {
      for (String item : allowedUnsafeSysctls) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDefaultAddCapability(Predicate<String> predicate) {
      for (String item : defaultAddCapabilities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingForbiddenSysctl(Predicate<String> predicate) {
      for (String item : forbiddenSysctls) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHostPort(Predicate<HostPortRangeBuilder> predicate) {
      for (HostPortRangeBuilder item : hostPorts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequiredDropCapability(Predicate<String> predicate) {
      for (String item : requiredDropCapabilities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolume(Predicate<String> predicate) {
      for (String item : volumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPrivileged() {
    return this.privileged != null;
  }
  
  public boolean hasReadOnlyRootFilesystem() {
    return this.readOnlyRootFilesystem != null;
  }
  
  public boolean hasRequiredDropCapabilities() {
    return this.requiredDropCapabilities != null && !(this.requiredDropCapabilities.isEmpty());
  }
  
  public boolean hasRunAsGroup() {
    return this.runAsGroup != null;
  }
  
  public boolean hasRunAsUser() {
    return this.runAsUser != null;
  }
  
  public boolean hasRuntimeClass() {
    return this.runtimeClass != null;
  }
  
  public boolean hasSeLinux() {
    return this.seLinux != null;
  }
  
  public boolean hasSupplementalGroups() {
    return this.supplementalGroups != null;
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allowPrivilegeEscalation, allowedCSIDrivers, allowedCapabilities, allowedFlexVolumes, allowedHostPaths, allowedProcMountTypes, allowedUnsafeSysctls, defaultAddCapabilities, defaultAllowPrivilegeEscalation, forbiddenSysctls, fsGroup, hostIPC, hostNetwork, hostPID, hostPorts, privileged, readOnlyRootFilesystem, requiredDropCapabilities, runAsGroup, runAsUser, runtimeClass, seLinux, supplementalGroups, volumes, additionalProperties);
  }
  
  public A removeAllFromAllowedCSIDrivers(Collection<AllowedCSIDriver> items) {
    if (this.allowedCSIDrivers == null) {
      return (A) this;
    }
    for (AllowedCSIDriver item : items) {
        AllowedCSIDriverBuilder builder = new AllowedCSIDriverBuilder(item);
        _visitables.get("allowedCSIDrivers").remove(builder);
        this.allowedCSIDrivers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromAllowedCapabilities(Collection<String> items) {
    if (this.allowedCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromAllowedFlexVolumes(Collection<AllowedFlexVolume> items) {
    if (this.allowedFlexVolumes == null) {
      return (A) this;
    }
    for (AllowedFlexVolume item : items) {
        AllowedFlexVolumeBuilder builder = new AllowedFlexVolumeBuilder(item);
        _visitables.get("allowedFlexVolumes").remove(builder);
        this.allowedFlexVolumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromAllowedHostPaths(Collection<AllowedHostPath> items) {
    if (this.allowedHostPaths == null) {
      return (A) this;
    }
    for (AllowedHostPath item : items) {
        AllowedHostPathBuilder builder = new AllowedHostPathBuilder(item);
        _visitables.get("allowedHostPaths").remove(builder);
        this.allowedHostPaths.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromAllowedProcMountTypes(Collection<String> items) {
    if (this.allowedProcMountTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedProcMountTypes.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromAllowedUnsafeSysctls(Collection<String> items) {
    if (this.allowedUnsafeSysctls == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedUnsafeSysctls.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromDefaultAddCapabilities(Collection<String> items) {
    if (this.defaultAddCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.defaultAddCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromForbiddenSysctls(Collection<String> items) {
    if (this.forbiddenSysctls == null) {
      return (A) this;
    }
    for (String item : items) {
      this.forbiddenSysctls.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromHostPorts(Collection<HostPortRange> items) {
    if (this.hostPorts == null) {
      return (A) this;
    }
    for (HostPortRange item : items) {
        HostPortRangeBuilder builder = new HostPortRangeBuilder(item);
        _visitables.get("hostPorts").remove(builder);
        this.hostPorts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRequiredDropCapabilities(Collection<String> items) {
    if (this.requiredDropCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requiredDropCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumes(Collection<String> items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.volumes.remove(item);
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
  
  public A removeFromAllowedCSIDrivers(AllowedCSIDriver... items) {
    if (this.allowedCSIDrivers == null) {
      return (A) this;
    }
    for (AllowedCSIDriver item : items) {
        AllowedCSIDriverBuilder builder = new AllowedCSIDriverBuilder(item);
        _visitables.get("allowedCSIDrivers").remove(builder);
        this.allowedCSIDrivers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAllowedCapabilities(String... items) {
    if (this.allowedCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAllowedFlexVolumes(AllowedFlexVolume... items) {
    if (this.allowedFlexVolumes == null) {
      return (A) this;
    }
    for (AllowedFlexVolume item : items) {
        AllowedFlexVolumeBuilder builder = new AllowedFlexVolumeBuilder(item);
        _visitables.get("allowedFlexVolumes").remove(builder);
        this.allowedFlexVolumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAllowedHostPaths(AllowedHostPath... items) {
    if (this.allowedHostPaths == null) {
      return (A) this;
    }
    for (AllowedHostPath item : items) {
        AllowedHostPathBuilder builder = new AllowedHostPathBuilder(item);
        _visitables.get("allowedHostPaths").remove(builder);
        this.allowedHostPaths.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAllowedProcMountTypes(String... items) {
    if (this.allowedProcMountTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedProcMountTypes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAllowedUnsafeSysctls(String... items) {
    if (this.allowedUnsafeSysctls == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedUnsafeSysctls.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromDefaultAddCapabilities(String... items) {
    if (this.defaultAddCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.defaultAddCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromForbiddenSysctls(String... items) {
    if (this.forbiddenSysctls == null) {
      return (A) this;
    }
    for (String item : items) {
      this.forbiddenSysctls.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromHostPorts(HostPortRange... items) {
    if (this.hostPorts == null) {
      return (A) this;
    }
    for (HostPortRange item : items) {
        HostPortRangeBuilder builder = new HostPortRangeBuilder(item);
        _visitables.get("hostPorts").remove(builder);
        this.hostPorts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRequiredDropCapabilities(String... items) {
    if (this.requiredDropCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requiredDropCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromVolumes(String... items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.volumes.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllowedCSIDrivers(Predicate<AllowedCSIDriverBuilder> predicate) {
    if (allowedCSIDrivers == null) {
      return (A) this;
    }
    Iterator<AllowedCSIDriverBuilder> each = allowedCSIDrivers.iterator();
    List visitables = _visitables.get("allowedCSIDrivers");
    while (each.hasNext()) {
        AllowedCSIDriverBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllowedFlexVolumes(Predicate<AllowedFlexVolumeBuilder> predicate) {
    if (allowedFlexVolumes == null) {
      return (A) this;
    }
    Iterator<AllowedFlexVolumeBuilder> each = allowedFlexVolumes.iterator();
    List visitables = _visitables.get("allowedFlexVolumes");
    while (each.hasNext()) {
        AllowedFlexVolumeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllowedHostPaths(Predicate<AllowedHostPathBuilder> predicate) {
    if (allowedHostPaths == null) {
      return (A) this;
    }
    Iterator<AllowedHostPathBuilder> each = allowedHostPaths.iterator();
    List visitables = _visitables.get("allowedHostPaths");
    while (each.hasNext()) {
        AllowedHostPathBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHostPorts(Predicate<HostPortRangeBuilder> predicate) {
    if (hostPorts == null) {
      return (A) this;
    }
    Iterator<HostPortRangeBuilder> each = hostPorts.iterator();
    List visitables = _visitables.get("hostPorts");
    while (each.hasNext()) {
        HostPortRangeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllowedCSIDriversNested<A> setNewAllowedCSIDriverLike(int index,AllowedCSIDriver item) {
    return new AllowedCSIDriversNested(index, item);
  }
  
  public AllowedFlexVolumesNested<A> setNewAllowedFlexVolumeLike(int index,AllowedFlexVolume item) {
    return new AllowedFlexVolumesNested(index, item);
  }
  
  public AllowedHostPathsNested<A> setNewAllowedHostPathLike(int index,AllowedHostPath item) {
    return new AllowedHostPathsNested(index, item);
  }
  
  public HostPortsNested<A> setNewHostPortLike(int index,HostPortRange item) {
    return new HostPortsNested(index, item);
  }
  
  public A setToAllowedCSIDrivers(int index,AllowedCSIDriver item) {
    if (this.allowedCSIDrivers == null) {
      this.allowedCSIDrivers = new ArrayList();
    }
    AllowedCSIDriverBuilder builder = new AllowedCSIDriverBuilder(item);
    if (index < 0 || index >= allowedCSIDrivers.size()) {
        _visitables.get("allowedCSIDrivers").add(builder);
        allowedCSIDrivers.add(builder);
    } else {
        _visitables.get("allowedCSIDrivers").add(builder);
        allowedCSIDrivers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToAllowedCapabilities(int index,String item) {
    if (this.allowedCapabilities == null) {
      this.allowedCapabilities = new ArrayList();
    }
    this.allowedCapabilities.set(index, item);
    return (A) this;
  }
  
  public A setToAllowedFlexVolumes(int index,AllowedFlexVolume item) {
    if (this.allowedFlexVolumes == null) {
      this.allowedFlexVolumes = new ArrayList();
    }
    AllowedFlexVolumeBuilder builder = new AllowedFlexVolumeBuilder(item);
    if (index < 0 || index >= allowedFlexVolumes.size()) {
        _visitables.get("allowedFlexVolumes").add(builder);
        allowedFlexVolumes.add(builder);
    } else {
        _visitables.get("allowedFlexVolumes").add(builder);
        allowedFlexVolumes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToAllowedHostPaths(int index,AllowedHostPath item) {
    if (this.allowedHostPaths == null) {
      this.allowedHostPaths = new ArrayList();
    }
    AllowedHostPathBuilder builder = new AllowedHostPathBuilder(item);
    if (index < 0 || index >= allowedHostPaths.size()) {
        _visitables.get("allowedHostPaths").add(builder);
        allowedHostPaths.add(builder);
    } else {
        _visitables.get("allowedHostPaths").add(builder);
        allowedHostPaths.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToAllowedProcMountTypes(int index,String item) {
    if (this.allowedProcMountTypes == null) {
      this.allowedProcMountTypes = new ArrayList();
    }
    this.allowedProcMountTypes.set(index, item);
    return (A) this;
  }
  
  public A setToAllowedUnsafeSysctls(int index,String item) {
    if (this.allowedUnsafeSysctls == null) {
      this.allowedUnsafeSysctls = new ArrayList();
    }
    this.allowedUnsafeSysctls.set(index, item);
    return (A) this;
  }
  
  public A setToDefaultAddCapabilities(int index,String item) {
    if (this.defaultAddCapabilities == null) {
      this.defaultAddCapabilities = new ArrayList();
    }
    this.defaultAddCapabilities.set(index, item);
    return (A) this;
  }
  
  public A setToForbiddenSysctls(int index,String item) {
    if (this.forbiddenSysctls == null) {
      this.forbiddenSysctls = new ArrayList();
    }
    this.forbiddenSysctls.set(index, item);
    return (A) this;
  }
  
  public A setToHostPorts(int index,HostPortRange item) {
    if (this.hostPorts == null) {
      this.hostPorts = new ArrayList();
    }
    HostPortRangeBuilder builder = new HostPortRangeBuilder(item);
    if (index < 0 || index >= hostPorts.size()) {
        _visitables.get("hostPorts").add(builder);
        hostPorts.add(builder);
    } else {
        _visitables.get("hostPorts").add(builder);
        hostPorts.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRequiredDropCapabilities(int index,String item) {
    if (this.requiredDropCapabilities == null) {
      this.requiredDropCapabilities = new ArrayList();
    }
    this.requiredDropCapabilities.set(index, item);
    return (A) this;
  }
  
  public A setToVolumes(int index,String item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    this.volumes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowPrivilegeEscalation == null)) {
        sb.append("allowPrivilegeEscalation:");
        sb.append(allowPrivilegeEscalation);
        sb.append(",");
    }
    if (!(allowedCSIDrivers == null) && !(allowedCSIDrivers.isEmpty())) {
        sb.append("allowedCSIDrivers:");
        sb.append(allowedCSIDrivers);
        sb.append(",");
    }
    if (!(allowedCapabilities == null) && !(allowedCapabilities.isEmpty())) {
        sb.append("allowedCapabilities:");
        sb.append(allowedCapabilities);
        sb.append(",");
    }
    if (!(allowedFlexVolumes == null) && !(allowedFlexVolumes.isEmpty())) {
        sb.append("allowedFlexVolumes:");
        sb.append(allowedFlexVolumes);
        sb.append(",");
    }
    if (!(allowedHostPaths == null) && !(allowedHostPaths.isEmpty())) {
        sb.append("allowedHostPaths:");
        sb.append(allowedHostPaths);
        sb.append(",");
    }
    if (!(allowedProcMountTypes == null) && !(allowedProcMountTypes.isEmpty())) {
        sb.append("allowedProcMountTypes:");
        sb.append(allowedProcMountTypes);
        sb.append(",");
    }
    if (!(allowedUnsafeSysctls == null) && !(allowedUnsafeSysctls.isEmpty())) {
        sb.append("allowedUnsafeSysctls:");
        sb.append(allowedUnsafeSysctls);
        sb.append(",");
    }
    if (!(defaultAddCapabilities == null) && !(defaultAddCapabilities.isEmpty())) {
        sb.append("defaultAddCapabilities:");
        sb.append(defaultAddCapabilities);
        sb.append(",");
    }
    if (!(defaultAllowPrivilegeEscalation == null)) {
        sb.append("defaultAllowPrivilegeEscalation:");
        sb.append(defaultAllowPrivilegeEscalation);
        sb.append(",");
    }
    if (!(forbiddenSysctls == null) && !(forbiddenSysctls.isEmpty())) {
        sb.append("forbiddenSysctls:");
        sb.append(forbiddenSysctls);
        sb.append(",");
    }
    if (!(fsGroup == null)) {
        sb.append("fsGroup:");
        sb.append(fsGroup);
        sb.append(",");
    }
    if (!(hostIPC == null)) {
        sb.append("hostIPC:");
        sb.append(hostIPC);
        sb.append(",");
    }
    if (!(hostNetwork == null)) {
        sb.append("hostNetwork:");
        sb.append(hostNetwork);
        sb.append(",");
    }
    if (!(hostPID == null)) {
        sb.append("hostPID:");
        sb.append(hostPID);
        sb.append(",");
    }
    if (!(hostPorts == null) && !(hostPorts.isEmpty())) {
        sb.append("hostPorts:");
        sb.append(hostPorts);
        sb.append(",");
    }
    if (!(privileged == null)) {
        sb.append("privileged:");
        sb.append(privileged);
        sb.append(",");
    }
    if (!(readOnlyRootFilesystem == null)) {
        sb.append("readOnlyRootFilesystem:");
        sb.append(readOnlyRootFilesystem);
        sb.append(",");
    }
    if (!(requiredDropCapabilities == null) && !(requiredDropCapabilities.isEmpty())) {
        sb.append("requiredDropCapabilities:");
        sb.append(requiredDropCapabilities);
        sb.append(",");
    }
    if (!(runAsGroup == null)) {
        sb.append("runAsGroup:");
        sb.append(runAsGroup);
        sb.append(",");
    }
    if (!(runAsUser == null)) {
        sb.append("runAsUser:");
        sb.append(runAsUser);
        sb.append(",");
    }
    if (!(runtimeClass == null)) {
        sb.append("runtimeClass:");
        sb.append(runtimeClass);
        sb.append(",");
    }
    if (!(seLinux == null)) {
        sb.append("seLinux:");
        sb.append(seLinux);
        sb.append(",");
    }
    if (!(supplementalGroups == null)) {
        sb.append("supplementalGroups:");
        sb.append(supplementalGroups);
        sb.append(",");
    }
    if (!(volumes == null) && !(volumes.isEmpty())) {
        sb.append("volumes:");
        sb.append(volumes);
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
  
  public A withAllowPrivilegeEscalation() {
    return withAllowPrivilegeEscalation(true);
  }
  
  public A withAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
    this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    return (A) this;
  }
  
  public A withAllowedCSIDrivers(List<AllowedCSIDriver> allowedCSIDrivers) {
    if (this.allowedCSIDrivers != null) {
      this._visitables.get("allowedCSIDrivers").clear();
    }
    if (allowedCSIDrivers != null) {
        this.allowedCSIDrivers = new ArrayList();
        for (AllowedCSIDriver item : allowedCSIDrivers) {
          this.addToAllowedCSIDrivers(item);
        }
    } else {
      this.allowedCSIDrivers = null;
    }
    return (A) this;
  }
  
  public A withAllowedCSIDrivers(AllowedCSIDriver... allowedCSIDrivers) {
    if (this.allowedCSIDrivers != null) {
        this.allowedCSIDrivers.clear();
        _visitables.remove("allowedCSIDrivers");
    }
    if (allowedCSIDrivers != null) {
      for (AllowedCSIDriver item : allowedCSIDrivers) {
        this.addToAllowedCSIDrivers(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowedCapabilities(List<String> allowedCapabilities) {
    if (allowedCapabilities != null) {
        this.allowedCapabilities = new ArrayList();
        for (String item : allowedCapabilities) {
          this.addToAllowedCapabilities(item);
        }
    } else {
      this.allowedCapabilities = null;
    }
    return (A) this;
  }
  
  public A withAllowedCapabilities(String... allowedCapabilities) {
    if (this.allowedCapabilities != null) {
        this.allowedCapabilities.clear();
        _visitables.remove("allowedCapabilities");
    }
    if (allowedCapabilities != null) {
      for (String item : allowedCapabilities) {
        this.addToAllowedCapabilities(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowedFlexVolumes(List<AllowedFlexVolume> allowedFlexVolumes) {
    if (this.allowedFlexVolumes != null) {
      this._visitables.get("allowedFlexVolumes").clear();
    }
    if (allowedFlexVolumes != null) {
        this.allowedFlexVolumes = new ArrayList();
        for (AllowedFlexVolume item : allowedFlexVolumes) {
          this.addToAllowedFlexVolumes(item);
        }
    } else {
      this.allowedFlexVolumes = null;
    }
    return (A) this;
  }
  
  public A withAllowedFlexVolumes(AllowedFlexVolume... allowedFlexVolumes) {
    if (this.allowedFlexVolumes != null) {
        this.allowedFlexVolumes.clear();
        _visitables.remove("allowedFlexVolumes");
    }
    if (allowedFlexVolumes != null) {
      for (AllowedFlexVolume item : allowedFlexVolumes) {
        this.addToAllowedFlexVolumes(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowedHostPaths(List<AllowedHostPath> allowedHostPaths) {
    if (this.allowedHostPaths != null) {
      this._visitables.get("allowedHostPaths").clear();
    }
    if (allowedHostPaths != null) {
        this.allowedHostPaths = new ArrayList();
        for (AllowedHostPath item : allowedHostPaths) {
          this.addToAllowedHostPaths(item);
        }
    } else {
      this.allowedHostPaths = null;
    }
    return (A) this;
  }
  
  public A withAllowedHostPaths(AllowedHostPath... allowedHostPaths) {
    if (this.allowedHostPaths != null) {
        this.allowedHostPaths.clear();
        _visitables.remove("allowedHostPaths");
    }
    if (allowedHostPaths != null) {
      for (AllowedHostPath item : allowedHostPaths) {
        this.addToAllowedHostPaths(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowedProcMountTypes(List<String> allowedProcMountTypes) {
    if (allowedProcMountTypes != null) {
        this.allowedProcMountTypes = new ArrayList();
        for (String item : allowedProcMountTypes) {
          this.addToAllowedProcMountTypes(item);
        }
    } else {
      this.allowedProcMountTypes = null;
    }
    return (A) this;
  }
  
  public A withAllowedProcMountTypes(String... allowedProcMountTypes) {
    if (this.allowedProcMountTypes != null) {
        this.allowedProcMountTypes.clear();
        _visitables.remove("allowedProcMountTypes");
    }
    if (allowedProcMountTypes != null) {
      for (String item : allowedProcMountTypes) {
        this.addToAllowedProcMountTypes(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowedUnsafeSysctls(List<String> allowedUnsafeSysctls) {
    if (allowedUnsafeSysctls != null) {
        this.allowedUnsafeSysctls = new ArrayList();
        for (String item : allowedUnsafeSysctls) {
          this.addToAllowedUnsafeSysctls(item);
        }
    } else {
      this.allowedUnsafeSysctls = null;
    }
    return (A) this;
  }
  
  public A withAllowedUnsafeSysctls(String... allowedUnsafeSysctls) {
    if (this.allowedUnsafeSysctls != null) {
        this.allowedUnsafeSysctls.clear();
        _visitables.remove("allowedUnsafeSysctls");
    }
    if (allowedUnsafeSysctls != null) {
      for (String item : allowedUnsafeSysctls) {
        this.addToAllowedUnsafeSysctls(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultAddCapabilities(List<String> defaultAddCapabilities) {
    if (defaultAddCapabilities != null) {
        this.defaultAddCapabilities = new ArrayList();
        for (String item : defaultAddCapabilities) {
          this.addToDefaultAddCapabilities(item);
        }
    } else {
      this.defaultAddCapabilities = null;
    }
    return (A) this;
  }
  
  public A withDefaultAddCapabilities(String... defaultAddCapabilities) {
    if (this.defaultAddCapabilities != null) {
        this.defaultAddCapabilities.clear();
        _visitables.remove("defaultAddCapabilities");
    }
    if (defaultAddCapabilities != null) {
      for (String item : defaultAddCapabilities) {
        this.addToDefaultAddCapabilities(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultAllowPrivilegeEscalation() {
    return withDefaultAllowPrivilegeEscalation(true);
  }
  
  public A withDefaultAllowPrivilegeEscalation(Boolean defaultAllowPrivilegeEscalation) {
    this.defaultAllowPrivilegeEscalation = defaultAllowPrivilegeEscalation;
    return (A) this;
  }
  
  public A withForbiddenSysctls(List<String> forbiddenSysctls) {
    if (forbiddenSysctls != null) {
        this.forbiddenSysctls = new ArrayList();
        for (String item : forbiddenSysctls) {
          this.addToForbiddenSysctls(item);
        }
    } else {
      this.forbiddenSysctls = null;
    }
    return (A) this;
  }
  
  public A withForbiddenSysctls(String... forbiddenSysctls) {
    if (this.forbiddenSysctls != null) {
        this.forbiddenSysctls.clear();
        _visitables.remove("forbiddenSysctls");
    }
    if (forbiddenSysctls != null) {
      for (String item : forbiddenSysctls) {
        this.addToForbiddenSysctls(item);
      }
    }
    return (A) this;
  }
  
  public A withFsGroup(FSGroupStrategyOptions fsGroup) {
    this._visitables.remove("fsGroup");
    if (fsGroup != null) {
        this.fsGroup = new FSGroupStrategyOptionsBuilder(fsGroup);
        this._visitables.get("fsGroup").add(this.fsGroup);
    } else {
        this.fsGroup = null;
        this._visitables.get("fsGroup").remove(this.fsGroup);
    }
    return (A) this;
  }
  
  public A withHostIPC() {
    return withHostIPC(true);
  }
  
  public A withHostIPC(Boolean hostIPC) {
    this.hostIPC = hostIPC;
    return (A) this;
  }
  
  public A withHostNetwork() {
    return withHostNetwork(true);
  }
  
  public A withHostNetwork(Boolean hostNetwork) {
    this.hostNetwork = hostNetwork;
    return (A) this;
  }
  
  public A withHostPID() {
    return withHostPID(true);
  }
  
  public A withHostPID(Boolean hostPID) {
    this.hostPID = hostPID;
    return (A) this;
  }
  
  public A withHostPorts(List<HostPortRange> hostPorts) {
    if (this.hostPorts != null) {
      this._visitables.get("hostPorts").clear();
    }
    if (hostPorts != null) {
        this.hostPorts = new ArrayList();
        for (HostPortRange item : hostPorts) {
          this.addToHostPorts(item);
        }
    } else {
      this.hostPorts = null;
    }
    return (A) this;
  }
  
  public A withHostPorts(HostPortRange... hostPorts) {
    if (this.hostPorts != null) {
        this.hostPorts.clear();
        _visitables.remove("hostPorts");
    }
    if (hostPorts != null) {
      for (HostPortRange item : hostPorts) {
        this.addToHostPorts(item);
      }
    }
    return (A) this;
  }
  
  public FsGroupNested<A> withNewFsGroup() {
    return new FsGroupNested(null);
  }
  
  public FsGroupNested<A> withNewFsGroupLike(FSGroupStrategyOptions item) {
    return new FsGroupNested(item);
  }
  
  public RunAsGroupNested<A> withNewRunAsGroup() {
    return new RunAsGroupNested(null);
  }
  
  public RunAsGroupNested<A> withNewRunAsGroupLike(RunAsGroupStrategyOptions item) {
    return new RunAsGroupNested(item);
  }
  
  public RunAsUserNested<A> withNewRunAsUser() {
    return new RunAsUserNested(null);
  }
  
  public RunAsUserNested<A> withNewRunAsUserLike(RunAsUserStrategyOptions item) {
    return new RunAsUserNested(item);
  }
  
  public RuntimeClassNested<A> withNewRuntimeClass() {
    return new RuntimeClassNested(null);
  }
  
  public RuntimeClassNested<A> withNewRuntimeClassLike(RuntimeClassStrategyOptions item) {
    return new RuntimeClassNested(item);
  }
  
  public SeLinuxNested<A> withNewSeLinux() {
    return new SeLinuxNested(null);
  }
  
  public SeLinuxNested<A> withNewSeLinuxLike(SELinuxStrategyOptions item) {
    return new SeLinuxNested(item);
  }
  
  public SupplementalGroupsNested<A> withNewSupplementalGroups() {
    return new SupplementalGroupsNested(null);
  }
  
  public SupplementalGroupsNested<A> withNewSupplementalGroupsLike(SupplementalGroupsStrategyOptions item) {
    return new SupplementalGroupsNested(item);
  }
  
  public A withPrivileged() {
    return withPrivileged(true);
  }
  
  public A withPrivileged(Boolean privileged) {
    this.privileged = privileged;
    return (A) this;
  }
  
  public A withReadOnlyRootFilesystem() {
    return withReadOnlyRootFilesystem(true);
  }
  
  public A withReadOnlyRootFilesystem(Boolean readOnlyRootFilesystem) {
    this.readOnlyRootFilesystem = readOnlyRootFilesystem;
    return (A) this;
  }
  
  public A withRequiredDropCapabilities(List<String> requiredDropCapabilities) {
    if (requiredDropCapabilities != null) {
        this.requiredDropCapabilities = new ArrayList();
        for (String item : requiredDropCapabilities) {
          this.addToRequiredDropCapabilities(item);
        }
    } else {
      this.requiredDropCapabilities = null;
    }
    return (A) this;
  }
  
  public A withRequiredDropCapabilities(String... requiredDropCapabilities) {
    if (this.requiredDropCapabilities != null) {
        this.requiredDropCapabilities.clear();
        _visitables.remove("requiredDropCapabilities");
    }
    if (requiredDropCapabilities != null) {
      for (String item : requiredDropCapabilities) {
        this.addToRequiredDropCapabilities(item);
      }
    }
    return (A) this;
  }
  
  public A withRunAsGroup(RunAsGroupStrategyOptions runAsGroup) {
    this._visitables.remove("runAsGroup");
    if (runAsGroup != null) {
        this.runAsGroup = new RunAsGroupStrategyOptionsBuilder(runAsGroup);
        this._visitables.get("runAsGroup").add(this.runAsGroup);
    } else {
        this.runAsGroup = null;
        this._visitables.get("runAsGroup").remove(this.runAsGroup);
    }
    return (A) this;
  }
  
  public A withRunAsUser(RunAsUserStrategyOptions runAsUser) {
    this._visitables.remove("runAsUser");
    if (runAsUser != null) {
        this.runAsUser = new RunAsUserStrategyOptionsBuilder(runAsUser);
        this._visitables.get("runAsUser").add(this.runAsUser);
    } else {
        this.runAsUser = null;
        this._visitables.get("runAsUser").remove(this.runAsUser);
    }
    return (A) this;
  }
  
  public A withRuntimeClass(RuntimeClassStrategyOptions runtimeClass) {
    this._visitables.remove("runtimeClass");
    if (runtimeClass != null) {
        this.runtimeClass = new RuntimeClassStrategyOptionsBuilder(runtimeClass);
        this._visitables.get("runtimeClass").add(this.runtimeClass);
    } else {
        this.runtimeClass = null;
        this._visitables.get("runtimeClass").remove(this.runtimeClass);
    }
    return (A) this;
  }
  
  public A withSeLinux(SELinuxStrategyOptions seLinux) {
    this._visitables.remove("seLinux");
    if (seLinux != null) {
        this.seLinux = new SELinuxStrategyOptionsBuilder(seLinux);
        this._visitables.get("seLinux").add(this.seLinux);
    } else {
        this.seLinux = null;
        this._visitables.get("seLinux").remove(this.seLinux);
    }
    return (A) this;
  }
  
  public A withSupplementalGroups(SupplementalGroupsStrategyOptions supplementalGroups) {
    this._visitables.remove("supplementalGroups");
    if (supplementalGroups != null) {
        this.supplementalGroups = new SupplementalGroupsStrategyOptionsBuilder(supplementalGroups);
        this._visitables.get("supplementalGroups").add(this.supplementalGroups);
    } else {
        this.supplementalGroups = null;
        this._visitables.get("supplementalGroups").remove(this.supplementalGroups);
    }
    return (A) this;
  }
  
  public A withVolumes(List<String> volumes) {
    if (volumes != null) {
        this.volumes = new ArrayList();
        for (String item : volumes) {
          this.addToVolumes(item);
        }
    } else {
      this.volumes = null;
    }
    return (A) this;
  }
  
  public A withVolumes(String... volumes) {
    if (this.volumes != null) {
        this.volumes.clear();
        _visitables.remove("volumes");
    }
    if (volumes != null) {
      for (String item : volumes) {
        this.addToVolumes(item);
      }
    }
    return (A) this;
  }
  public class AllowedCSIDriversNested<N> extends AllowedCSIDriverFluent<AllowedCSIDriversNested<N>> implements Nested<N>{
  
    AllowedCSIDriverBuilder builder;
    int index;
  
    AllowedCSIDriversNested(int index,AllowedCSIDriver item) {
      this.index = index;
      this.builder = new AllowedCSIDriverBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.setToAllowedCSIDrivers(index, builder.build());
    }
    
    public N endAllowedCSIDriver() {
      return and();
    }
    
  }
  public class AllowedFlexVolumesNested<N> extends AllowedFlexVolumeFluent<AllowedFlexVolumesNested<N>> implements Nested<N>{
  
    AllowedFlexVolumeBuilder builder;
    int index;
  
    AllowedFlexVolumesNested(int index,AllowedFlexVolume item) {
      this.index = index;
      this.builder = new AllowedFlexVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.setToAllowedFlexVolumes(index, builder.build());
    }
    
    public N endAllowedFlexVolume() {
      return and();
    }
    
  }
  public class AllowedHostPathsNested<N> extends AllowedHostPathFluent<AllowedHostPathsNested<N>> implements Nested<N>{
  
    AllowedHostPathBuilder builder;
    int index;
  
    AllowedHostPathsNested(int index,AllowedHostPath item) {
      this.index = index;
      this.builder = new AllowedHostPathBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.setToAllowedHostPaths(index, builder.build());
    }
    
    public N endAllowedHostPath() {
      return and();
    }
    
  }
  public class FsGroupNested<N> extends FSGroupStrategyOptionsFluent<FsGroupNested<N>> implements Nested<N>{
  
    FSGroupStrategyOptionsBuilder builder;
  
    FsGroupNested(FSGroupStrategyOptions item) {
      this.builder = new FSGroupStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.withFsGroup(builder.build());
    }
    
    public N endFsGroup() {
      return and();
    }
    
  }
  public class HostPortsNested<N> extends HostPortRangeFluent<HostPortsNested<N>> implements Nested<N>{
  
    HostPortRangeBuilder builder;
    int index;
  
    HostPortsNested(int index,HostPortRange item) {
      this.index = index;
      this.builder = new HostPortRangeBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.setToHostPorts(index, builder.build());
    }
    
    public N endHostPort() {
      return and();
    }
    
  }
  public class RunAsGroupNested<N> extends RunAsGroupStrategyOptionsFluent<RunAsGroupNested<N>> implements Nested<N>{
  
    RunAsGroupStrategyOptionsBuilder builder;
  
    RunAsGroupNested(RunAsGroupStrategyOptions item) {
      this.builder = new RunAsGroupStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.withRunAsGroup(builder.build());
    }
    
    public N endRunAsGroup() {
      return and();
    }
    
  }
  public class RunAsUserNested<N> extends RunAsUserStrategyOptionsFluent<RunAsUserNested<N>> implements Nested<N>{
  
    RunAsUserStrategyOptionsBuilder builder;
  
    RunAsUserNested(RunAsUserStrategyOptions item) {
      this.builder = new RunAsUserStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.withRunAsUser(builder.build());
    }
    
    public N endRunAsUser() {
      return and();
    }
    
  }
  public class RuntimeClassNested<N> extends RuntimeClassStrategyOptionsFluent<RuntimeClassNested<N>> implements Nested<N>{
  
    RuntimeClassStrategyOptionsBuilder builder;
  
    RuntimeClassNested(RuntimeClassStrategyOptions item) {
      this.builder = new RuntimeClassStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.withRuntimeClass(builder.build());
    }
    
    public N endRuntimeClass() {
      return and();
    }
    
  }
  public class SeLinuxNested<N> extends SELinuxStrategyOptionsFluent<SeLinuxNested<N>> implements Nested<N>{
  
    SELinuxStrategyOptionsBuilder builder;
  
    SeLinuxNested(SELinuxStrategyOptions item) {
      this.builder = new SELinuxStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.withSeLinux(builder.build());
    }
    
    public N endSeLinux() {
      return and();
    }
    
  }
  public class SupplementalGroupsNested<N> extends SupplementalGroupsStrategyOptionsFluent<SupplementalGroupsNested<N>> implements Nested<N>{
  
    SupplementalGroupsStrategyOptionsBuilder builder;
  
    SupplementalGroupsNested(SupplementalGroupsStrategyOptions item) {
      this.builder = new SupplementalGroupsStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicySpecFluent.this.withSupplementalGroups(builder.build());
    }
    
    public N endSupplementalGroups() {
      return and();
    }
    
  }
}