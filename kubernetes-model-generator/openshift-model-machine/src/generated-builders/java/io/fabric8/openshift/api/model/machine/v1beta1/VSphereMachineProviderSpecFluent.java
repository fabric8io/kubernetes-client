package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class VSphereMachineProviderSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.VSphereMachineProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String cloneMode;
  private LocalObjectReferenceBuilder credentialsSecret;
  private ArrayList<VSphereDiskBuilder> dataDisks = new ArrayList<VSphereDiskBuilder>();
  private Integer diskGiB;
  private String kind;
  private Long memoryMiB;
  private ObjectMetaBuilder metadata;
  private NetworkSpecBuilder network;
  private Integer numCPUs;
  private Integer numCoresPerSocket;
  private String snapshot;
  private List<String> tagIDs = new ArrayList<String>();
  private String template;
  private LocalObjectReferenceBuilder userDataSecret;
  private WorkspaceBuilder workspace;

  public VSphereMachineProviderSpecFluent() {
  }
  
  public VSphereMachineProviderSpecFluent(VSphereMachineProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDataDisks(Collection<VSphereDisk> items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (VSphereDisk item : items) {
        VSphereDiskBuilder builder = new VSphereDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTagIDs(Collection<String> items) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    for (String item : items) {
      this.tagIDs.add(item);
    }
    return (A) this;
  }
  
  public DataDisksNested<A> addNewDataDisk() {
    return new DataDisksNested(-1, null);
  }
  
  public A addNewDataDisk(String name,String provisioningMode,Integer sizeGiB) {
    return (A) this.addToDataDisks(new VSphereDisk(name, provisioningMode, sizeGiB));
  }
  
  public DataDisksNested<A> addNewDataDiskLike(VSphereDisk item) {
    return new DataDisksNested(-1, item);
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
  
  public A addToDataDisks(VSphereDisk... items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (VSphereDisk item : items) {
        VSphereDiskBuilder builder = new VSphereDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addToDataDisks(int index,VSphereDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    VSphereDiskBuilder builder = new VSphereDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTagIDs(String... items) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    for (String item : items) {
      this.tagIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToTagIDs(int index,String item) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    this.tagIDs.add(index, item);
    return (A) this;
  }
  
  public LocalObjectReference buildCredentialsSecret() {
    return this.credentialsSecret != null ? this.credentialsSecret.build() : null;
  }
  
  public VSphereDisk buildDataDisk(int index) {
    return this.dataDisks.get(index).build();
  }
  
  public List<VSphereDisk> buildDataDisks() {
    return this.dataDisks != null ? build(dataDisks) : null;
  }
  
  public VSphereDisk buildFirstDataDisk() {
    return this.dataDisks.get(0).build();
  }
  
  public VSphereDisk buildLastDataDisk() {
    return this.dataDisks.get(dataDisks.size() - 1).build();
  }
  
  public VSphereDisk buildMatchingDataDisk(Predicate<VSphereDiskBuilder> predicate) {
      for (VSphereDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public NetworkSpec buildNetwork() {
    return this.network != null ? this.network.build() : null;
  }
  
  public LocalObjectReference buildUserDataSecret() {
    return this.userDataSecret != null ? this.userDataSecret.build() : null;
  }
  
  public Workspace buildWorkspace() {
    return this.workspace != null ? this.workspace.build() : null;
  }
  
  protected void copyInstance(VSphereMachineProviderSpec instance) {
    instance = instance != null ? instance : new VSphereMachineProviderSpec();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withCloneMode(instance.getCloneMode());
        this.withCredentialsSecret(instance.getCredentialsSecret());
        this.withDataDisks(instance.getDataDisks());
        this.withDiskGiB(instance.getDiskGiB());
        this.withKind(instance.getKind());
        this.withMemoryMiB(instance.getMemoryMiB());
        this.withMetadata(instance.getMetadata());
        this.withNetwork(instance.getNetwork());
        this.withNumCPUs(instance.getNumCPUs());
        this.withNumCoresPerSocket(instance.getNumCoresPerSocket());
        this.withSnapshot(instance.getSnapshot());
        this.withTagIDs(instance.getTagIDs());
        this.withTemplate(instance.getTemplate());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withWorkspace(instance.getWorkspace());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsSecretNested<A> editCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(null));
  }
  
  public DataDisksNested<A> editDataDisk(int index) {
    if (dataDisks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public DataDisksNested<A> editFirstDataDisk() {
    if (dataDisks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(0, this.buildDataDisk(0));
  }
  
  public DataDisksNested<A> editLastDataDisk() {
    int index = dataDisks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public DataDisksNested<A> editMatchingDataDisk(Predicate<VSphereDiskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dataDisks.size();i++) {
      if (predicate.test(dataDisks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public NetworkNested<A> editNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(null));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecretLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public NetworkNested<A> editOrNewNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(new NetworkSpecBuilder().build()));
  }
  
  public NetworkNested<A> editOrNewNetworkLike(NetworkSpec item) {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(item));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecretLike(LocalObjectReference item) {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(item));
  }
  
  public WorkspaceNested<A> editOrNewWorkspace() {
    return this.withNewWorkspaceLike(Optional.ofNullable(this.buildWorkspace()).orElse(new WorkspaceBuilder().build()));
  }
  
  public WorkspaceNested<A> editOrNewWorkspaceLike(Workspace item) {
    return this.withNewWorkspaceLike(Optional.ofNullable(this.buildWorkspace()).orElse(item));
  }
  
  public UserDataSecretNested<A> editUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(null));
  }
  
  public WorkspaceNested<A> editWorkspace() {
    return this.withNewWorkspaceLike(Optional.ofNullable(this.buildWorkspace()).orElse(null));
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
    VSphereMachineProviderSpecFluent that = (VSphereMachineProviderSpecFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(cloneMode, that.cloneMode))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecret, that.credentialsSecret))) {
      return false;
    }
    if (!(Objects.equals(dataDisks, that.dataDisks))) {
      return false;
    }
    if (!(Objects.equals(diskGiB, that.diskGiB))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(memoryMiB, that.memoryMiB))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(numCPUs, that.numCPUs))) {
      return false;
    }
    if (!(Objects.equals(numCoresPerSocket, that.numCoresPerSocket))) {
      return false;
    }
    if (!(Objects.equals(snapshot, that.snapshot))) {
      return false;
    }
    if (!(Objects.equals(tagIDs, that.tagIDs))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
      return false;
    }
    if (!(Objects.equals(workspace, that.workspace))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getCloneMode() {
    return this.cloneMode;
  }
  
  public Integer getDiskGiB() {
    return this.diskGiB;
  }
  
  public String getFirstTagID() {
    return this.tagIDs.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastTagID() {
    return this.tagIDs.get(tagIDs.size() - 1);
  }
  
  public String getMatchingTagID(Predicate<String> predicate) {
      for (String item : tagIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getMemoryMiB() {
    return this.memoryMiB;
  }
  
  public Integer getNumCPUs() {
    return this.numCPUs;
  }
  
  public Integer getNumCoresPerSocket() {
    return this.numCoresPerSocket;
  }
  
  public String getSnapshot() {
    return this.snapshot;
  }
  
  public String getTagID(int index) {
    return this.tagIDs.get(index);
  }
  
  public List<String> getTagIDs() {
    return this.tagIDs;
  }
  
  public String getTemplate() {
    return this.template;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasCloneMode() {
    return this.cloneMode != null;
  }
  
  public boolean hasCredentialsSecret() {
    return this.credentialsSecret != null;
  }
  
  public boolean hasDataDisks() {
    return this.dataDisks != null && !(this.dataDisks.isEmpty());
  }
  
  public boolean hasDiskGiB() {
    return this.diskGiB != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingDataDisk(Predicate<VSphereDiskBuilder> predicate) {
      for (VSphereDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTagID(Predicate<String> predicate) {
      for (String item : tagIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemoryMiB() {
    return this.memoryMiB != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasNumCPUs() {
    return this.numCPUs != null;
  }
  
  public boolean hasNumCoresPerSocket() {
    return this.numCoresPerSocket != null;
  }
  
  public boolean hasSnapshot() {
    return this.snapshot != null;
  }
  
  public boolean hasTagIDs() {
    return this.tagIDs != null && !(this.tagIDs.isEmpty());
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public boolean hasWorkspace() {
    return this.workspace != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, cloneMode, credentialsSecret, dataDisks, diskGiB, kind, memoryMiB, metadata, network, numCPUs, numCoresPerSocket, snapshot, tagIDs, template, userDataSecret, workspace, additionalProperties);
  }
  
  public A removeAllFromDataDisks(Collection<VSphereDisk> items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (VSphereDisk item : items) {
        VSphereDiskBuilder builder = new VSphereDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTagIDs(Collection<String> items) {
    if (this.tagIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagIDs.remove(item);
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
  
  public A removeFromDataDisks(VSphereDisk... items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (VSphereDisk item : items) {
        VSphereDiskBuilder builder = new VSphereDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTagIDs(String... items) {
    if (this.tagIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagIDs.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDataDisks(Predicate<VSphereDiskBuilder> predicate) {
    if (dataDisks == null) {
      return (A) this;
    }
    Iterator<VSphereDiskBuilder> each = dataDisks.iterator();
    List visitables = _visitables.get("dataDisks");
    while (each.hasNext()) {
        VSphereDiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DataDisksNested<A> setNewDataDiskLike(int index,VSphereDisk item) {
    return new DataDisksNested(index, item);
  }
  
  public A setToDataDisks(int index,VSphereDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    VSphereDiskBuilder builder = new VSphereDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTagIDs(int index,String item) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    this.tagIDs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(cloneMode == null)) {
        sb.append("cloneMode:");
        sb.append(cloneMode);
        sb.append(",");
    }
    if (!(credentialsSecret == null)) {
        sb.append("credentialsSecret:");
        sb.append(credentialsSecret);
        sb.append(",");
    }
    if (!(dataDisks == null) && !(dataDisks.isEmpty())) {
        sb.append("dataDisks:");
        sb.append(dataDisks);
        sb.append(",");
    }
    if (!(diskGiB == null)) {
        sb.append("diskGiB:");
        sb.append(diskGiB);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(memoryMiB == null)) {
        sb.append("memoryMiB:");
        sb.append(memoryMiB);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(numCPUs == null)) {
        sb.append("numCPUs:");
        sb.append(numCPUs);
        sb.append(",");
    }
    if (!(numCoresPerSocket == null)) {
        sb.append("numCoresPerSocket:");
        sb.append(numCoresPerSocket);
        sb.append(",");
    }
    if (!(snapshot == null)) {
        sb.append("snapshot:");
        sb.append(snapshot);
        sb.append(",");
    }
    if (!(tagIDs == null) && !(tagIDs.isEmpty())) {
        sb.append("tagIDs:");
        sb.append(tagIDs);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
        sb.append(",");
    }
    if (!(workspace == null)) {
        sb.append("workspace:");
        sb.append(workspace);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withCloneMode(String cloneMode) {
    this.cloneMode = cloneMode;
    return (A) this;
  }
  
  public A withCredentialsSecret(LocalObjectReference credentialsSecret) {
    this._visitables.remove("credentialsSecret");
    if (credentialsSecret != null) {
        this.credentialsSecret = new LocalObjectReferenceBuilder(credentialsSecret);
        this._visitables.get("credentialsSecret").add(this.credentialsSecret);
    } else {
        this.credentialsSecret = null;
        this._visitables.get("credentialsSecret").remove(this.credentialsSecret);
    }
    return (A) this;
  }
  
  public A withDataDisks(List<VSphereDisk> dataDisks) {
    if (this.dataDisks != null) {
      this._visitables.get("dataDisks").clear();
    }
    if (dataDisks != null) {
        this.dataDisks = new ArrayList();
        for (VSphereDisk item : dataDisks) {
          this.addToDataDisks(item);
        }
    } else {
      this.dataDisks = null;
    }
    return (A) this;
  }
  
  public A withDataDisks(VSphereDisk... dataDisks) {
    if (this.dataDisks != null) {
        this.dataDisks.clear();
        _visitables.remove("dataDisks");
    }
    if (dataDisks != null) {
      for (VSphereDisk item : dataDisks) {
        this.addToDataDisks(item);
      }
    }
    return (A) this;
  }
  
  public A withDiskGiB(Integer diskGiB) {
    this.diskGiB = diskGiB;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMemoryMiB(Long memoryMiB) {
    this.memoryMiB = memoryMiB;
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
  
  public A withNetwork(NetworkSpec network) {
    this._visitables.remove("network");
    if (network != null) {
        this.network = new NetworkSpecBuilder(network);
        this._visitables.get("network").add(this.network);
    } else {
        this.network = null;
        this._visitables.get("network").remove(this.network);
    }
    return (A) this;
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecret() {
    return new CredentialsSecretNested(null);
  }
  
  public A withNewCredentialsSecret(String name) {
    return (A) this.withCredentialsSecret(new LocalObjectReference(name));
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecretLike(LocalObjectReference item) {
    return new CredentialsSecretNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public NetworkNested<A> withNewNetwork() {
    return new NetworkNested(null);
  }
  
  public NetworkNested<A> withNewNetworkLike(NetworkSpec item) {
    return new NetworkNested(item);
  }
  
  public UserDataSecretNested<A> withNewUserDataSecret() {
    return new UserDataSecretNested(null);
  }
  
  public A withNewUserDataSecret(String name) {
    return (A) this.withUserDataSecret(new LocalObjectReference(name));
  }
  
  public UserDataSecretNested<A> withNewUserDataSecretLike(LocalObjectReference item) {
    return new UserDataSecretNested(item);
  }
  
  public WorkspaceNested<A> withNewWorkspace() {
    return new WorkspaceNested(null);
  }
  
  public WorkspaceNested<A> withNewWorkspaceLike(Workspace item) {
    return new WorkspaceNested(item);
  }
  
  public A withNumCPUs(Integer numCPUs) {
    this.numCPUs = numCPUs;
    return (A) this;
  }
  
  public A withNumCoresPerSocket(Integer numCoresPerSocket) {
    this.numCoresPerSocket = numCoresPerSocket;
    return (A) this;
  }
  
  public A withSnapshot(String snapshot) {
    this.snapshot = snapshot;
    return (A) this;
  }
  
  public A withTagIDs(List<String> tagIDs) {
    if (tagIDs != null) {
        this.tagIDs = new ArrayList();
        for (String item : tagIDs) {
          this.addToTagIDs(item);
        }
    } else {
      this.tagIDs = null;
    }
    return (A) this;
  }
  
  public A withTagIDs(String... tagIDs) {
    if (this.tagIDs != null) {
        this.tagIDs.clear();
        _visitables.remove("tagIDs");
    }
    if (tagIDs != null) {
      for (String item : tagIDs) {
        this.addToTagIDs(item);
      }
    }
    return (A) this;
  }
  
  public A withTemplate(String template) {
    this.template = template;
    return (A) this;
  }
  
  public A withUserDataSecret(LocalObjectReference userDataSecret) {
    this._visitables.remove("userDataSecret");
    if (userDataSecret != null) {
        this.userDataSecret = new LocalObjectReferenceBuilder(userDataSecret);
        this._visitables.get("userDataSecret").add(this.userDataSecret);
    } else {
        this.userDataSecret = null;
        this._visitables.get("userDataSecret").remove(this.userDataSecret);
    }
    return (A) this;
  }
  
  public A withWorkspace(Workspace workspace) {
    this._visitables.remove("workspace");
    if (workspace != null) {
        this.workspace = new WorkspaceBuilder(workspace);
        this._visitables.get("workspace").add(this.workspace);
    } else {
        this.workspace = null;
        this._visitables.get("workspace").remove(this.workspace);
    }
    return (A) this;
  }
  public class CredentialsSecretNested<N> extends LocalObjectReferenceFluent<CredentialsSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereMachineProviderSpecFluent.this.withCredentialsSecret(builder.build());
    }
    
    public N endCredentialsSecret() {
      return and();
    }
    
  }
  public class DataDisksNested<N> extends VSphereDiskFluent<DataDisksNested<N>> implements Nested<N>{
  
    VSphereDiskBuilder builder;
    int index;
  
    DataDisksNested(int index,VSphereDisk item) {
      this.index = index;
      this.builder = new VSphereDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereMachineProviderSpecFluent.this.setToDataDisks(index, builder.build());
    }
    
    public N endDataDisk() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereMachineProviderSpecFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class NetworkNested<N> extends NetworkSpecFluent<NetworkNested<N>> implements Nested<N>{
  
    NetworkSpecBuilder builder;
  
    NetworkNested(NetworkSpec item) {
      this.builder = new NetworkSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereMachineProviderSpecFluent.this.withNetwork(builder.build());
    }
    
    public N endNetwork() {
      return and();
    }
    
  }
  public class UserDataSecretNested<N> extends LocalObjectReferenceFluent<UserDataSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    UserDataSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereMachineProviderSpecFluent.this.withUserDataSecret(builder.build());
    }
    
    public N endUserDataSecret() {
      return and();
    }
    
  }
  public class WorkspaceNested<N> extends WorkspaceFluent<WorkspaceNested<N>> implements Nested<N>{
  
    WorkspaceBuilder builder;
  
    WorkspaceNested(Workspace item) {
      this.builder = new WorkspaceBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereMachineProviderSpecFluent.this.withWorkspace(builder.build());
    }
    
    public N endWorkspace() {
      return and();
    }
    
  }
}