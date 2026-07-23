package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
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
public class SecurityContextConstraintsFluent<A extends io.fabric8.openshift.api.model.SecurityContextConstraintsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowHostDirVolumePlugin;
  private Boolean allowHostIPC;
  private Boolean allowHostNetwork;
  private Boolean allowHostPID;
  private Boolean allowHostPorts;
  private Boolean allowPrivilegeEscalation;
  private Boolean allowPrivilegedContainer;
  private List<String> allowedCapabilities = new ArrayList<String>();
  private ArrayList<AllowedFlexVolumeBuilder> allowedFlexVolumes = new ArrayList<AllowedFlexVolumeBuilder>();
  private List<String> allowedUnsafeSysctls = new ArrayList<String>();
  private String apiVersion;
  private List<String> defaultAddCapabilities = new ArrayList<String>();
  private Boolean defaultAllowPrivilegeEscalation;
  private List<String> forbiddenSysctls = new ArrayList<String>();
  private FSGroupStrategyOptionsBuilder fsGroup;
  private List<String> groups = new ArrayList<String>();
  private String kind;
  private ObjectMetaBuilder metadata;
  private Integer priority;
  private Boolean readOnlyRootFilesystem;
  private List<String> requiredDropCapabilities = new ArrayList<String>();
  private RunAsUserStrategyOptionsBuilder runAsUser;
  private SELinuxContextStrategyOptionsBuilder seLinuxContext;
  private List<String> seccompProfiles = new ArrayList<String>();
  private SupplementalGroupsStrategyOptionsBuilder supplementalGroups;
  private String userNamespaceLevel;
  private List<String> users = new ArrayList<String>();
  private List<String> volumes = new ArrayList<String>();

  public SecurityContextConstraintsFluent() {
  }
  
  public SecurityContextConstraintsFluent(SecurityContextConstraints instance) {
    this.copyInstance(instance);
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
  
  public A addAllToGroups(Collection<String> items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (String item : items) {
      this.groups.add(item);
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
  
  public A addAllToSeccompProfiles(Collection<String> items) {
    if (this.seccompProfiles == null) {
      this.seccompProfiles = new ArrayList();
    }
    for (String item : items) {
      this.seccompProfiles.add(item);
    }
    return (A) this;
  }
  
  public A addAllToUsers(Collection<String> items) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    for (String item : items) {
      this.users.add(item);
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
  
  public AllowedFlexVolumesNested<A> addNewAllowedFlexVolume() {
    return new AllowedFlexVolumesNested(-1, null);
  }
  
  public A addNewAllowedFlexVolume(String driver) {
    return (A) this.addToAllowedFlexVolumes(new AllowedFlexVolume(driver));
  }
  
  public AllowedFlexVolumesNested<A> addNewAllowedFlexVolumeLike(AllowedFlexVolume item) {
    return new AllowedFlexVolumesNested(-1, item);
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
  
  public A addToGroups(String... items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (String item : items) {
      this.groups.add(item);
    }
    return (A) this;
  }
  
  public A addToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.add(index, item);
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
  
  public A addToSeccompProfiles(String... items) {
    if (this.seccompProfiles == null) {
      this.seccompProfiles = new ArrayList();
    }
    for (String item : items) {
      this.seccompProfiles.add(item);
    }
    return (A) this;
  }
  
  public A addToSeccompProfiles(int index,String item) {
    if (this.seccompProfiles == null) {
      this.seccompProfiles = new ArrayList();
    }
    this.seccompProfiles.add(index, item);
    return (A) this;
  }
  
  public A addToUsers(String... items) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    for (String item : items) {
      this.users.add(item);
    }
    return (A) this;
  }
  
  public A addToUsers(int index,String item) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    this.users.add(index, item);
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
  
  public AllowedFlexVolume buildAllowedFlexVolume(int index) {
    return this.allowedFlexVolumes.get(index).build();
  }
  
  public List<AllowedFlexVolume> buildAllowedFlexVolumes() {
    return this.allowedFlexVolumes != null ? build(allowedFlexVolumes) : null;
  }
  
  public AllowedFlexVolume buildFirstAllowedFlexVolume() {
    return this.allowedFlexVolumes.get(0).build();
  }
  
  public FSGroupStrategyOptions buildFsGroup() {
    return this.fsGroup != null ? this.fsGroup.build() : null;
  }
  
  public AllowedFlexVolume buildLastAllowedFlexVolume() {
    return this.allowedFlexVolumes.get(allowedFlexVolumes.size() - 1).build();
  }
  
  public AllowedFlexVolume buildMatchingAllowedFlexVolume(Predicate<AllowedFlexVolumeBuilder> predicate) {
      for (AllowedFlexVolumeBuilder item : allowedFlexVolumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public RunAsUserStrategyOptions buildRunAsUser() {
    return this.runAsUser != null ? this.runAsUser.build() : null;
  }
  
  public SELinuxContextStrategyOptions buildSeLinuxContext() {
    return this.seLinuxContext != null ? this.seLinuxContext.build() : null;
  }
  
  public SupplementalGroupsStrategyOptions buildSupplementalGroups() {
    return this.supplementalGroups != null ? this.supplementalGroups.build() : null;
  }
  
  protected void copyInstance(SecurityContextConstraints instance) {
    instance = instance != null ? instance : new SecurityContextConstraints();
    if (instance != null) {
        this.withAllowHostDirVolumePlugin(instance.getAllowHostDirVolumePlugin());
        this.withAllowHostIPC(instance.getAllowHostIPC());
        this.withAllowHostNetwork(instance.getAllowHostNetwork());
        this.withAllowHostPID(instance.getAllowHostPID());
        this.withAllowHostPorts(instance.getAllowHostPorts());
        this.withAllowPrivilegeEscalation(instance.getAllowPrivilegeEscalation());
        this.withAllowPrivilegedContainer(instance.getAllowPrivilegedContainer());
        this.withAllowedCapabilities(instance.getAllowedCapabilities());
        this.withAllowedFlexVolumes(instance.getAllowedFlexVolumes());
        this.withAllowedUnsafeSysctls(instance.getAllowedUnsafeSysctls());
        this.withApiVersion(instance.getApiVersion());
        this.withDefaultAddCapabilities(instance.getDefaultAddCapabilities());
        this.withDefaultAllowPrivilegeEscalation(instance.getDefaultAllowPrivilegeEscalation());
        this.withForbiddenSysctls(instance.getForbiddenSysctls());
        this.withFsGroup(instance.getFsGroup());
        this.withGroups(instance.getGroups());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withPriority(instance.getPriority());
        this.withReadOnlyRootFilesystem(instance.getReadOnlyRootFilesystem());
        this.withRequiredDropCapabilities(instance.getRequiredDropCapabilities());
        this.withRunAsUser(instance.getRunAsUser());
        this.withSeLinuxContext(instance.getSeLinuxContext());
        this.withSeccompProfiles(instance.getSeccompProfiles());
        this.withSupplementalGroups(instance.getSupplementalGroups());
        this.withUserNamespaceLevel(instance.getUserNamespaceLevel());
        this.withUsers(instance.getUsers());
        this.withVolumes(instance.getVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllowedFlexVolumesNested<A> editAllowedFlexVolume(int index) {
    if (allowedFlexVolumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allowedFlexVolumes"));
    }
    return this.setNewAllowedFlexVolumeLike(index, this.buildAllowedFlexVolume(index));
  }
  
  public AllowedFlexVolumesNested<A> editFirstAllowedFlexVolume() {
    if (allowedFlexVolumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allowedFlexVolumes"));
    }
    return this.setNewAllowedFlexVolumeLike(0, this.buildAllowedFlexVolume(0));
  }
  
  public FsGroupNested<A> editFsGroup() {
    return this.withNewFsGroupLike(Optional.ofNullable(this.buildFsGroup()).orElse(null));
  }
  
  public AllowedFlexVolumesNested<A> editLastAllowedFlexVolume() {
    int index = allowedFlexVolumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allowedFlexVolumes"));
    }
    return this.setNewAllowedFlexVolumeLike(index, this.buildAllowedFlexVolume(index));
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
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public FsGroupNested<A> editOrNewFsGroup() {
    return this.withNewFsGroupLike(Optional.ofNullable(this.buildFsGroup()).orElse(new FSGroupStrategyOptionsBuilder().build()));
  }
  
  public FsGroupNested<A> editOrNewFsGroupLike(FSGroupStrategyOptions item) {
    return this.withNewFsGroupLike(Optional.ofNullable(this.buildFsGroup()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public RunAsUserNested<A> editOrNewRunAsUser() {
    return this.withNewRunAsUserLike(Optional.ofNullable(this.buildRunAsUser()).orElse(new RunAsUserStrategyOptionsBuilder().build()));
  }
  
  public RunAsUserNested<A> editOrNewRunAsUserLike(RunAsUserStrategyOptions item) {
    return this.withNewRunAsUserLike(Optional.ofNullable(this.buildRunAsUser()).orElse(item));
  }
  
  public SeLinuxContextNested<A> editOrNewSeLinuxContext() {
    return this.withNewSeLinuxContextLike(Optional.ofNullable(this.buildSeLinuxContext()).orElse(new SELinuxContextStrategyOptionsBuilder().build()));
  }
  
  public SeLinuxContextNested<A> editOrNewSeLinuxContextLike(SELinuxContextStrategyOptions item) {
    return this.withNewSeLinuxContextLike(Optional.ofNullable(this.buildSeLinuxContext()).orElse(item));
  }
  
  public SupplementalGroupsNested<A> editOrNewSupplementalGroups() {
    return this.withNewSupplementalGroupsLike(Optional.ofNullable(this.buildSupplementalGroups()).orElse(new SupplementalGroupsStrategyOptionsBuilder().build()));
  }
  
  public SupplementalGroupsNested<A> editOrNewSupplementalGroupsLike(SupplementalGroupsStrategyOptions item) {
    return this.withNewSupplementalGroupsLike(Optional.ofNullable(this.buildSupplementalGroups()).orElse(item));
  }
  
  public RunAsUserNested<A> editRunAsUser() {
    return this.withNewRunAsUserLike(Optional.ofNullable(this.buildRunAsUser()).orElse(null));
  }
  
  public SeLinuxContextNested<A> editSeLinuxContext() {
    return this.withNewSeLinuxContextLike(Optional.ofNullable(this.buildSeLinuxContext()).orElse(null));
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
    SecurityContextConstraintsFluent that = (SecurityContextConstraintsFluent) o;
    if (!(Objects.equals(allowHostDirVolumePlugin, that.allowHostDirVolumePlugin))) {
      return false;
    }
    if (!(Objects.equals(allowHostIPC, that.allowHostIPC))) {
      return false;
    }
    if (!(Objects.equals(allowHostNetwork, that.allowHostNetwork))) {
      return false;
    }
    if (!(Objects.equals(allowHostPID, that.allowHostPID))) {
      return false;
    }
    if (!(Objects.equals(allowHostPorts, that.allowHostPorts))) {
      return false;
    }
    if (!(Objects.equals(allowPrivilegeEscalation, that.allowPrivilegeEscalation))) {
      return false;
    }
    if (!(Objects.equals(allowPrivilegedContainer, that.allowPrivilegedContainer))) {
      return false;
    }
    if (!(Objects.equals(allowedCapabilities, that.allowedCapabilities))) {
      return false;
    }
    if (!(Objects.equals(allowedFlexVolumes, that.allowedFlexVolumes))) {
      return false;
    }
    if (!(Objects.equals(allowedUnsafeSysctls, that.allowedUnsafeSysctls))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
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
    if (!(Objects.equals(groups, that.groups))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(readOnlyRootFilesystem, that.readOnlyRootFilesystem))) {
      return false;
    }
    if (!(Objects.equals(requiredDropCapabilities, that.requiredDropCapabilities))) {
      return false;
    }
    if (!(Objects.equals(runAsUser, that.runAsUser))) {
      return false;
    }
    if (!(Objects.equals(seLinuxContext, that.seLinuxContext))) {
      return false;
    }
    if (!(Objects.equals(seccompProfiles, that.seccompProfiles))) {
      return false;
    }
    if (!(Objects.equals(supplementalGroups, that.supplementalGroups))) {
      return false;
    }
    if (!(Objects.equals(userNamespaceLevel, that.userNamespaceLevel))) {
      return false;
    }
    if (!(Objects.equals(users, that.users))) {
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
  
  public Boolean getAllowHostDirVolumePlugin() {
    return this.allowHostDirVolumePlugin;
  }
  
  public Boolean getAllowHostIPC() {
    return this.allowHostIPC;
  }
  
  public Boolean getAllowHostNetwork() {
    return this.allowHostNetwork;
  }
  
  public Boolean getAllowHostPID() {
    return this.allowHostPID;
  }
  
  public Boolean getAllowHostPorts() {
    return this.allowHostPorts;
  }
  
  public Boolean getAllowPrivilegeEscalation() {
    return this.allowPrivilegeEscalation;
  }
  
  public Boolean getAllowPrivilegedContainer() {
    return this.allowPrivilegedContainer;
  }
  
  public List<String> getAllowedCapabilities() {
    return this.allowedCapabilities;
  }
  
  public String getAllowedCapability(int index) {
    return this.allowedCapabilities.get(index);
  }
  
  public String getAllowedUnsafeSysctl(int index) {
    return this.allowedUnsafeSysctls.get(index);
  }
  
  public List<String> getAllowedUnsafeSysctls() {
    return this.allowedUnsafeSysctls;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
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
  
  public String getFirstAllowedUnsafeSysctl() {
    return this.allowedUnsafeSysctls.get(0);
  }
  
  public String getFirstDefaultAddCapability() {
    return this.defaultAddCapabilities.get(0);
  }
  
  public String getFirstForbiddenSysctl() {
    return this.forbiddenSysctls.get(0);
  }
  
  public String getFirstGroup() {
    return this.groups.get(0);
  }
  
  public String getFirstRequiredDropCapability() {
    return this.requiredDropCapabilities.get(0);
  }
  
  public String getFirstSeccompProfile() {
    return this.seccompProfiles.get(0);
  }
  
  public String getFirstUser() {
    return this.users.get(0);
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
  
  public String getGroup(int index) {
    return this.groups.get(index);
  }
  
  public List<String> getGroups() {
    return this.groups;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastAllowedCapability() {
    return this.allowedCapabilities.get(allowedCapabilities.size() - 1);
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
  
  public String getLastGroup() {
    return this.groups.get(groups.size() - 1);
  }
  
  public String getLastRequiredDropCapability() {
    return this.requiredDropCapabilities.get(requiredDropCapabilities.size() - 1);
  }
  
  public String getLastSeccompProfile() {
    return this.seccompProfiles.get(seccompProfiles.size() - 1);
  }
  
  public String getLastUser() {
    return this.users.get(users.size() - 1);
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
  
  public String getMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
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
  
  public String getMatchingSeccompProfile(Predicate<String> predicate) {
      for (String item : seccompProfiles) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUser(Predicate<String> predicate) {
      for (String item : users) {
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
  
  public Integer getPriority() {
    return this.priority;
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
  
  public String getSeccompProfile(int index) {
    return this.seccompProfiles.get(index);
  }
  
  public List<String> getSeccompProfiles() {
    return this.seccompProfiles;
  }
  
  public String getUser(int index) {
    return this.users.get(index);
  }
  
  public String getUserNamespaceLevel() {
    return this.userNamespaceLevel;
  }
  
  public List<String> getUsers() {
    return this.users;
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
  
  public boolean hasAllowHostDirVolumePlugin() {
    return this.allowHostDirVolumePlugin != null;
  }
  
  public boolean hasAllowHostIPC() {
    return this.allowHostIPC != null;
  }
  
  public boolean hasAllowHostNetwork() {
    return this.allowHostNetwork != null;
  }
  
  public boolean hasAllowHostPID() {
    return this.allowHostPID != null;
  }
  
  public boolean hasAllowHostPorts() {
    return this.allowHostPorts != null;
  }
  
  public boolean hasAllowPrivilegeEscalation() {
    return this.allowPrivilegeEscalation != null;
  }
  
  public boolean hasAllowPrivilegedContainer() {
    return this.allowPrivilegedContainer != null;
  }
  
  public boolean hasAllowedCapabilities() {
    return this.allowedCapabilities != null && !(this.allowedCapabilities.isEmpty());
  }
  
  public boolean hasAllowedFlexVolumes() {
    return this.allowedFlexVolumes != null && !(this.allowedFlexVolumes.isEmpty());
  }
  
  public boolean hasAllowedUnsafeSysctls() {
    return this.allowedUnsafeSysctls != null && !(this.allowedUnsafeSysctls.isEmpty());
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
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
  
  public boolean hasGroups() {
    return this.groups != null && !(this.groups.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
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
  
  public boolean hasMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
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
  
  public boolean hasMatchingSeccompProfile(Predicate<String> predicate) {
      for (String item : seccompProfiles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUser(Predicate<String> predicate) {
      for (String item : users) {
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
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasReadOnlyRootFilesystem() {
    return this.readOnlyRootFilesystem != null;
  }
  
  public boolean hasRequiredDropCapabilities() {
    return this.requiredDropCapabilities != null && !(this.requiredDropCapabilities.isEmpty());
  }
  
  public boolean hasRunAsUser() {
    return this.runAsUser != null;
  }
  
  public boolean hasSeLinuxContext() {
    return this.seLinuxContext != null;
  }
  
  public boolean hasSeccompProfiles() {
    return this.seccompProfiles != null && !(this.seccompProfiles.isEmpty());
  }
  
  public boolean hasSupplementalGroups() {
    return this.supplementalGroups != null;
  }
  
  public boolean hasUserNamespaceLevel() {
    return this.userNamespaceLevel != null;
  }
  
  public boolean hasUsers() {
    return this.users != null && !(this.users.isEmpty());
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allowHostDirVolumePlugin, allowHostIPC, allowHostNetwork, allowHostPID, allowHostPorts, allowPrivilegeEscalation, allowPrivilegedContainer, allowedCapabilities, allowedFlexVolumes, allowedUnsafeSysctls, apiVersion, defaultAddCapabilities, defaultAllowPrivilegeEscalation, forbiddenSysctls, fsGroup, groups, kind, metadata, priority, readOnlyRootFilesystem, requiredDropCapabilities, runAsUser, seLinuxContext, seccompProfiles, supplementalGroups, userNamespaceLevel, users, volumes, additionalProperties);
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
  
  public A removeAllFromGroups(Collection<String> items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groups.remove(item);
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
  
  public A removeAllFromSeccompProfiles(Collection<String> items) {
    if (this.seccompProfiles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.seccompProfiles.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromUsers(Collection<String> items) {
    if (this.users == null) {
      return (A) this;
    }
    for (String item : items) {
      this.users.remove(item);
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
  
  public A removeFromGroups(String... items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groups.remove(item);
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
  
  public A removeFromSeccompProfiles(String... items) {
    if (this.seccompProfiles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.seccompProfiles.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUsers(String... items) {
    if (this.users == null) {
      return (A) this;
    }
    for (String item : items) {
      this.users.remove(item);
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
  
  public AllowedFlexVolumesNested<A> setNewAllowedFlexVolumeLike(int index,AllowedFlexVolume item) {
    return new AllowedFlexVolumesNested(index, item);
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
  
  public A setToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.set(index, item);
    return (A) this;
  }
  
  public A setToRequiredDropCapabilities(int index,String item) {
    if (this.requiredDropCapabilities == null) {
      this.requiredDropCapabilities = new ArrayList();
    }
    this.requiredDropCapabilities.set(index, item);
    return (A) this;
  }
  
  public A setToSeccompProfiles(int index,String item) {
    if (this.seccompProfiles == null) {
      this.seccompProfiles = new ArrayList();
    }
    this.seccompProfiles.set(index, item);
    return (A) this;
  }
  
  public A setToUsers(int index,String item) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    this.users.set(index, item);
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
    if (!(allowHostDirVolumePlugin == null)) {
        sb.append("allowHostDirVolumePlugin:");
        sb.append(allowHostDirVolumePlugin);
        sb.append(",");
    }
    if (!(allowHostIPC == null)) {
        sb.append("allowHostIPC:");
        sb.append(allowHostIPC);
        sb.append(",");
    }
    if (!(allowHostNetwork == null)) {
        sb.append("allowHostNetwork:");
        sb.append(allowHostNetwork);
        sb.append(",");
    }
    if (!(allowHostPID == null)) {
        sb.append("allowHostPID:");
        sb.append(allowHostPID);
        sb.append(",");
    }
    if (!(allowHostPorts == null)) {
        sb.append("allowHostPorts:");
        sb.append(allowHostPorts);
        sb.append(",");
    }
    if (!(allowPrivilegeEscalation == null)) {
        sb.append("allowPrivilegeEscalation:");
        sb.append(allowPrivilegeEscalation);
        sb.append(",");
    }
    if (!(allowPrivilegedContainer == null)) {
        sb.append("allowPrivilegedContainer:");
        sb.append(allowPrivilegedContainer);
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
    if (!(allowedUnsafeSysctls == null) && !(allowedUnsafeSysctls.isEmpty())) {
        sb.append("allowedUnsafeSysctls:");
        sb.append(allowedUnsafeSysctls);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
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
    if (!(groups == null) && !(groups.isEmpty())) {
        sb.append("groups:");
        sb.append(groups);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
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
    if (!(runAsUser == null)) {
        sb.append("runAsUser:");
        sb.append(runAsUser);
        sb.append(",");
    }
    if (!(seLinuxContext == null)) {
        sb.append("seLinuxContext:");
        sb.append(seLinuxContext);
        sb.append(",");
    }
    if (!(seccompProfiles == null) && !(seccompProfiles.isEmpty())) {
        sb.append("seccompProfiles:");
        sb.append(seccompProfiles);
        sb.append(",");
    }
    if (!(supplementalGroups == null)) {
        sb.append("supplementalGroups:");
        sb.append(supplementalGroups);
        sb.append(",");
    }
    if (!(userNamespaceLevel == null)) {
        sb.append("userNamespaceLevel:");
        sb.append(userNamespaceLevel);
        sb.append(",");
    }
    if (!(users == null) && !(users.isEmpty())) {
        sb.append("users:");
        sb.append(users);
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
  
  public A withAllowHostDirVolumePlugin() {
    return withAllowHostDirVolumePlugin(true);
  }
  
  public A withAllowHostDirVolumePlugin(Boolean allowHostDirVolumePlugin) {
    this.allowHostDirVolumePlugin = allowHostDirVolumePlugin;
    return (A) this;
  }
  
  public A withAllowHostIPC() {
    return withAllowHostIPC(true);
  }
  
  public A withAllowHostIPC(Boolean allowHostIPC) {
    this.allowHostIPC = allowHostIPC;
    return (A) this;
  }
  
  public A withAllowHostNetwork() {
    return withAllowHostNetwork(true);
  }
  
  public A withAllowHostNetwork(Boolean allowHostNetwork) {
    this.allowHostNetwork = allowHostNetwork;
    return (A) this;
  }
  
  public A withAllowHostPID() {
    return withAllowHostPID(true);
  }
  
  public A withAllowHostPID(Boolean allowHostPID) {
    this.allowHostPID = allowHostPID;
    return (A) this;
  }
  
  public A withAllowHostPorts() {
    return withAllowHostPorts(true);
  }
  
  public A withAllowHostPorts(Boolean allowHostPorts) {
    this.allowHostPorts = allowHostPorts;
    return (A) this;
  }
  
  public A withAllowPrivilegeEscalation() {
    return withAllowPrivilegeEscalation(true);
  }
  
  public A withAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
    this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    return (A) this;
  }
  
  public A withAllowPrivilegedContainer() {
    return withAllowPrivilegedContainer(true);
  }
  
  public A withAllowPrivilegedContainer(Boolean allowPrivilegedContainer) {
    this.allowPrivilegedContainer = allowPrivilegedContainer;
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
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
  
  public A withGroups(List<String> groups) {
    if (groups != null) {
        this.groups = new ArrayList();
        for (String item : groups) {
          this.addToGroups(item);
        }
    } else {
      this.groups = null;
    }
    return (A) this;
  }
  
  public A withGroups(String... groups) {
    if (this.groups != null) {
        this.groups.clear();
        _visitables.remove("groups");
    }
    if (groups != null) {
      for (String item : groups) {
        this.addToGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public FsGroupNested<A> withNewFsGroup() {
    return new FsGroupNested(null);
  }
  
  public FsGroupNested<A> withNewFsGroupLike(FSGroupStrategyOptions item) {
    return new FsGroupNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public RunAsUserNested<A> withNewRunAsUser() {
    return new RunAsUserNested(null);
  }
  
  public A withNewRunAsUser(String type,Long uid,Long uidRangeMax,Long uidRangeMin) {
    return (A) this.withRunAsUser(new RunAsUserStrategyOptions(type, uid, uidRangeMax, uidRangeMin));
  }
  
  public RunAsUserNested<A> withNewRunAsUserLike(RunAsUserStrategyOptions item) {
    return new RunAsUserNested(item);
  }
  
  public SeLinuxContextNested<A> withNewSeLinuxContext() {
    return new SeLinuxContextNested(null);
  }
  
  public SeLinuxContextNested<A> withNewSeLinuxContextLike(SELinuxContextStrategyOptions item) {
    return new SeLinuxContextNested(item);
  }
  
  public SupplementalGroupsNested<A> withNewSupplementalGroups() {
    return new SupplementalGroupsNested(null);
  }
  
  public SupplementalGroupsNested<A> withNewSupplementalGroupsLike(SupplementalGroupsStrategyOptions item) {
    return new SupplementalGroupsNested(item);
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
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
  
  public A withSeLinuxContext(SELinuxContextStrategyOptions seLinuxContext) {
    this._visitables.remove("seLinuxContext");
    if (seLinuxContext != null) {
        this.seLinuxContext = new SELinuxContextStrategyOptionsBuilder(seLinuxContext);
        this._visitables.get("seLinuxContext").add(this.seLinuxContext);
    } else {
        this.seLinuxContext = null;
        this._visitables.get("seLinuxContext").remove(this.seLinuxContext);
    }
    return (A) this;
  }
  
  public A withSeccompProfiles(List<String> seccompProfiles) {
    if (seccompProfiles != null) {
        this.seccompProfiles = new ArrayList();
        for (String item : seccompProfiles) {
          this.addToSeccompProfiles(item);
        }
    } else {
      this.seccompProfiles = null;
    }
    return (A) this;
  }
  
  public A withSeccompProfiles(String... seccompProfiles) {
    if (this.seccompProfiles != null) {
        this.seccompProfiles.clear();
        _visitables.remove("seccompProfiles");
    }
    if (seccompProfiles != null) {
      for (String item : seccompProfiles) {
        this.addToSeccompProfiles(item);
      }
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
  
  public A withUserNamespaceLevel(String userNamespaceLevel) {
    this.userNamespaceLevel = userNamespaceLevel;
    return (A) this;
  }
  
  public A withUsers(List<String> users) {
    if (users != null) {
        this.users = new ArrayList();
        for (String item : users) {
          this.addToUsers(item);
        }
    } else {
      this.users = null;
    }
    return (A) this;
  }
  
  public A withUsers(String... users) {
    if (this.users != null) {
        this.users.clear();
        _visitables.remove("users");
    }
    if (users != null) {
      for (String item : users) {
        this.addToUsers(item);
      }
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
  public class AllowedFlexVolumesNested<N> extends AllowedFlexVolumeFluent<AllowedFlexVolumesNested<N>> implements Nested<N>{
  
    AllowedFlexVolumeBuilder builder;
    int index;
  
    AllowedFlexVolumesNested(int index,AllowedFlexVolume item) {
      this.index = index;
      this.builder = new AllowedFlexVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextConstraintsFluent.this.setToAllowedFlexVolumes(index, builder.build());
    }
    
    public N endAllowedFlexVolume() {
      return and();
    }
    
  }
  public class FsGroupNested<N> extends FSGroupStrategyOptionsFluent<FsGroupNested<N>> implements Nested<N>{
  
    FSGroupStrategyOptionsBuilder builder;
  
    FsGroupNested(FSGroupStrategyOptions item) {
      this.builder = new FSGroupStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextConstraintsFluent.this.withFsGroup(builder.build());
    }
    
    public N endFsGroup() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextConstraintsFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class RunAsUserNested<N> extends RunAsUserStrategyOptionsFluent<RunAsUserNested<N>> implements Nested<N>{
  
    RunAsUserStrategyOptionsBuilder builder;
  
    RunAsUserNested(RunAsUserStrategyOptions item) {
      this.builder = new RunAsUserStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextConstraintsFluent.this.withRunAsUser(builder.build());
    }
    
    public N endRunAsUser() {
      return and();
    }
    
  }
  public class SeLinuxContextNested<N> extends SELinuxContextStrategyOptionsFluent<SeLinuxContextNested<N>> implements Nested<N>{
  
    SELinuxContextStrategyOptionsBuilder builder;
  
    SeLinuxContextNested(SELinuxContextStrategyOptions item) {
      this.builder = new SELinuxContextStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextConstraintsFluent.this.withSeLinuxContext(builder.build());
    }
    
    public N endSeLinuxContext() {
      return and();
    }
    
  }
  public class SupplementalGroupsNested<N> extends SupplementalGroupsStrategyOptionsFluent<SupplementalGroupsNested<N>> implements Nested<N>{
  
    SupplementalGroupsStrategyOptionsBuilder builder;
  
    SupplementalGroupsNested(SupplementalGroupsStrategyOptions item) {
      this.builder = new SupplementalGroupsStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextConstraintsFluent.this.withSupplementalGroups(builder.build());
    }
    
    public N endSupplementalGroups() {
      return and();
    }
    
  }
}