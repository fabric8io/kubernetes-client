package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class GCPMachineProviderSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.GCPMachineProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Boolean canIPForward;
  private String confidentialCompute;
  private LocalObjectReferenceBuilder credentialsSecret;
  private Boolean deletionProtection;
  private ArrayList<GCPDiskBuilder> disks = new ArrayList<GCPDiskBuilder>();
  private ArrayList<GCPMetadataBuilder> gcpMetadata = new ArrayList<GCPMetadataBuilder>();
  private ArrayList<GCPGPUConfigBuilder> gpus = new ArrayList<GCPGPUConfigBuilder>();
  private String kind;
  private Map<String,String> labels;
  private String machineType;
  private ObjectMetaBuilder metadata;
  private ArrayList<GCPNetworkInterfaceBuilder> networkInterfaces = new ArrayList<GCPNetworkInterfaceBuilder>();
  private String onHostMaintenance;
  private Boolean preemptible;
  private String projectID;
  private String region;
  private ArrayList<ResourceManagerTagBuilder> resourceManagerTags = new ArrayList<ResourceManagerTagBuilder>();
  private String restartPolicy;
  private ArrayList<GCPServiceAccountBuilder> serviceAccounts = new ArrayList<GCPServiceAccountBuilder>();
  private GCPShieldedInstanceConfigBuilder shieldedInstanceConfig;
  private List<String> tags = new ArrayList<String>();
  private List<String> targetPools = new ArrayList<String>();
  private LocalObjectReferenceBuilder userDataSecret;
  private String zone;

  public GCPMachineProviderSpecFluent() {
  }
  
  public GCPMachineProviderSpecFluent(GCPMachineProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDisks(Collection<GCPDisk> items) {
    if (this.disks == null) {
      this.disks = new ArrayList();
    }
    for (GCPDisk item : items) {
        GCPDiskBuilder builder = new GCPDiskBuilder(item);
        _visitables.get("disks").add(builder);
        this.disks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToGcpMetadata(Collection<GCPMetadata> items) {
    if (this.gcpMetadata == null) {
      this.gcpMetadata = new ArrayList();
    }
    for (GCPMetadata item : items) {
        GCPMetadataBuilder builder = new GCPMetadataBuilder(item);
        _visitables.get("gcpMetadata").add(builder);
        this.gcpMetadata.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToGpus(Collection<GCPGPUConfig> items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (GCPGPUConfig item : items) {
        GCPGPUConfigBuilder builder = new GCPGPUConfigBuilder(item);
        _visitables.get("gpus").add(builder);
        this.gpus.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNetworkInterfaces(Collection<GCPNetworkInterface> items) {
    if (this.networkInterfaces == null) {
      this.networkInterfaces = new ArrayList();
    }
    for (GCPNetworkInterface item : items) {
        GCPNetworkInterfaceBuilder builder = new GCPNetworkInterfaceBuilder(item);
        _visitables.get("networkInterfaces").add(builder);
        this.networkInterfaces.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourceManagerTags(Collection<ResourceManagerTag> items) {
    if (this.resourceManagerTags == null) {
      this.resourceManagerTags = new ArrayList();
    }
    for (ResourceManagerTag item : items) {
        ResourceManagerTagBuilder builder = new ResourceManagerTagBuilder(item);
        _visitables.get("resourceManagerTags").add(builder);
        this.resourceManagerTags.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToServiceAccounts(Collection<GCPServiceAccount> items) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    for (GCPServiceAccount item : items) {
        GCPServiceAccountBuilder builder = new GCPServiceAccountBuilder(item);
        _visitables.get("serviceAccounts").add(builder);
        this.serviceAccounts.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTags(Collection<String> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTargetPools(Collection<String> items) {
    if (this.targetPools == null) {
      this.targetPools = new ArrayList();
    }
    for (String item : items) {
      this.targetPools.add(item);
    }
    return (A) this;
  }
  
  public DisksNested<A> addNewDisk() {
    return new DisksNested(-1, null);
  }
  
  public DisksNested<A> addNewDiskLike(GCPDisk item) {
    return new DisksNested(-1, item);
  }
  
  public GcpMetadataNested<A> addNewGcpMetadatum() {
    return new GcpMetadataNested(-1, null);
  }
  
  public A addNewGcpMetadatum(String key,String value) {
    return (A) this.addToGcpMetadata(new GCPMetadata(key, value));
  }
  
  public GcpMetadataNested<A> addNewGcpMetadatumLike(GCPMetadata item) {
    return new GcpMetadataNested(-1, item);
  }
  
  public GpusNested<A> addNewGpus() {
    return new GpusNested(-1, null);
  }
  
  public A addNewGpus(Integer count,String type) {
    return (A) this.addToGpus(new GCPGPUConfig(count, type));
  }
  
  public GpusNested<A> addNewGpusLike(GCPGPUConfig item) {
    return new GpusNested(-1, item);
  }
  
  public NetworkInterfacesNested<A> addNewNetworkInterface() {
    return new NetworkInterfacesNested(-1, null);
  }
  
  public A addNewNetworkInterface(String network,String projectID,Boolean publicIP,String subnetwork) {
    return (A) this.addToNetworkInterfaces(new GCPNetworkInterface(network, projectID, publicIP, subnetwork));
  }
  
  public NetworkInterfacesNested<A> addNewNetworkInterfaceLike(GCPNetworkInterface item) {
    return new NetworkInterfacesNested(-1, item);
  }
  
  public ResourceManagerTagsNested<A> addNewResourceManagerTag() {
    return new ResourceManagerTagsNested(-1, null);
  }
  
  public A addNewResourceManagerTag(String key,String parentID,String value) {
    return (A) this.addToResourceManagerTags(new ResourceManagerTag(key, parentID, value));
  }
  
  public ResourceManagerTagsNested<A> addNewResourceManagerTagLike(ResourceManagerTag item) {
    return new ResourceManagerTagsNested(-1, item);
  }
  
  public ServiceAccountsNested<A> addNewServiceAccount() {
    return new ServiceAccountsNested(-1, null);
  }
  
  public ServiceAccountsNested<A> addNewServiceAccountLike(GCPServiceAccount item) {
    return new ServiceAccountsNested(-1, item);
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
  
  public A addToDisks(GCPDisk... items) {
    if (this.disks == null) {
      this.disks = new ArrayList();
    }
    for (GCPDisk item : items) {
        GCPDiskBuilder builder = new GCPDiskBuilder(item);
        _visitables.get("disks").add(builder);
        this.disks.add(builder);
    }
    return (A) this;
  }
  
  public A addToDisks(int index,GCPDisk item) {
    if (this.disks == null) {
      this.disks = new ArrayList();
    }
    GCPDiskBuilder builder = new GCPDiskBuilder(item);
    if (index < 0 || index >= disks.size()) {
        _visitables.get("disks").add(builder);
        disks.add(builder);
    } else {
        _visitables.get("disks").add(builder);
        disks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToGcpMetadata(GCPMetadata... items) {
    if (this.gcpMetadata == null) {
      this.gcpMetadata = new ArrayList();
    }
    for (GCPMetadata item : items) {
        GCPMetadataBuilder builder = new GCPMetadataBuilder(item);
        _visitables.get("gcpMetadata").add(builder);
        this.gcpMetadata.add(builder);
    }
    return (A) this;
  }
  
  public A addToGcpMetadata(int index,GCPMetadata item) {
    if (this.gcpMetadata == null) {
      this.gcpMetadata = new ArrayList();
    }
    GCPMetadataBuilder builder = new GCPMetadataBuilder(item);
    if (index < 0 || index >= gcpMetadata.size()) {
        _visitables.get("gcpMetadata").add(builder);
        gcpMetadata.add(builder);
    } else {
        _visitables.get("gcpMetadata").add(builder);
        gcpMetadata.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToGpus(GCPGPUConfig... items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (GCPGPUConfig item : items) {
        GCPGPUConfigBuilder builder = new GCPGPUConfigBuilder(item);
        _visitables.get("gpus").add(builder);
        this.gpus.add(builder);
    }
    return (A) this;
  }
  
  public A addToGpus(int index,GCPGPUConfig item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    GCPGPUConfigBuilder builder = new GCPGPUConfigBuilder(item);
    if (index < 0 || index >= gpus.size()) {
        _visitables.get("gpus").add(builder);
        gpus.add(builder);
    } else {
        _visitables.get("gpus").add(builder);
        gpus.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNetworkInterfaces(GCPNetworkInterface... items) {
    if (this.networkInterfaces == null) {
      this.networkInterfaces = new ArrayList();
    }
    for (GCPNetworkInterface item : items) {
        GCPNetworkInterfaceBuilder builder = new GCPNetworkInterfaceBuilder(item);
        _visitables.get("networkInterfaces").add(builder);
        this.networkInterfaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToNetworkInterfaces(int index,GCPNetworkInterface item) {
    if (this.networkInterfaces == null) {
      this.networkInterfaces = new ArrayList();
    }
    GCPNetworkInterfaceBuilder builder = new GCPNetworkInterfaceBuilder(item);
    if (index < 0 || index >= networkInterfaces.size()) {
        _visitables.get("networkInterfaces").add(builder);
        networkInterfaces.add(builder);
    } else {
        _visitables.get("networkInterfaces").add(builder);
        networkInterfaces.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourceManagerTags(ResourceManagerTag... items) {
    if (this.resourceManagerTags == null) {
      this.resourceManagerTags = new ArrayList();
    }
    for (ResourceManagerTag item : items) {
        ResourceManagerTagBuilder builder = new ResourceManagerTagBuilder(item);
        _visitables.get("resourceManagerTags").add(builder);
        this.resourceManagerTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceManagerTags(int index,ResourceManagerTag item) {
    if (this.resourceManagerTags == null) {
      this.resourceManagerTags = new ArrayList();
    }
    ResourceManagerTagBuilder builder = new ResourceManagerTagBuilder(item);
    if (index < 0 || index >= resourceManagerTags.size()) {
        _visitables.get("resourceManagerTags").add(builder);
        resourceManagerTags.add(builder);
    } else {
        _visitables.get("resourceManagerTags").add(builder);
        resourceManagerTags.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToServiceAccounts(GCPServiceAccount... items) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    for (GCPServiceAccount item : items) {
        GCPServiceAccountBuilder builder = new GCPServiceAccountBuilder(item);
        _visitables.get("serviceAccounts").add(builder);
        this.serviceAccounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToServiceAccounts(int index,GCPServiceAccount item) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    GCPServiceAccountBuilder builder = new GCPServiceAccountBuilder(item);
    if (index < 0 || index >= serviceAccounts.size()) {
        _visitables.get("serviceAccounts").add(builder);
        serviceAccounts.add(builder);
    } else {
        _visitables.get("serviceAccounts").add(builder);
        serviceAccounts.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTags(String... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.add(index, item);
    return (A) this;
  }
  
  public A addToTargetPools(String... items) {
    if (this.targetPools == null) {
      this.targetPools = new ArrayList();
    }
    for (String item : items) {
      this.targetPools.add(item);
    }
    return (A) this;
  }
  
  public A addToTargetPools(int index,String item) {
    if (this.targetPools == null) {
      this.targetPools = new ArrayList();
    }
    this.targetPools.add(index, item);
    return (A) this;
  }
  
  public LocalObjectReference buildCredentialsSecret() {
    return this.credentialsSecret != null ? this.credentialsSecret.build() : null;
  }
  
  public GCPDisk buildDisk(int index) {
    return this.disks.get(index).build();
  }
  
  public List<GCPDisk> buildDisks() {
    return this.disks != null ? build(disks) : null;
  }
  
  public GCPDisk buildFirstDisk() {
    return this.disks.get(0).build();
  }
  
  public GCPMetadata buildFirstGcpMetadatum() {
    return this.gcpMetadata.get(0).build();
  }
  
  public GCPGPUConfig buildFirstGpus() {
    return this.gpus.get(0).build();
  }
  
  public GCPNetworkInterface buildFirstNetworkInterface() {
    return this.networkInterfaces.get(0).build();
  }
  
  public ResourceManagerTag buildFirstResourceManagerTag() {
    return this.resourceManagerTags.get(0).build();
  }
  
  public GCPServiceAccount buildFirstServiceAccount() {
    return this.serviceAccounts.get(0).build();
  }
  
  public List<GCPMetadata> buildGcpMetadata() {
    return this.gcpMetadata != null ? build(gcpMetadata) : null;
  }
  
  public GCPMetadata buildGcpMetadatum(int index) {
    return this.gcpMetadata.get(index).build();
  }
  
  public List<GCPGPUConfig> buildGpus() {
    return this.gpus != null ? build(gpus) : null;
  }
  
  public GCPGPUConfig buildGpus(int index) {
    return this.gpus.get(index).build();
  }
  
  public GCPDisk buildLastDisk() {
    return this.disks.get(disks.size() - 1).build();
  }
  
  public GCPMetadata buildLastGcpMetadatum() {
    return this.gcpMetadata.get(gcpMetadata.size() - 1).build();
  }
  
  public GCPGPUConfig buildLastGpus() {
    return this.gpus.get(gpus.size() - 1).build();
  }
  
  public GCPNetworkInterface buildLastNetworkInterface() {
    return this.networkInterfaces.get(networkInterfaces.size() - 1).build();
  }
  
  public ResourceManagerTag buildLastResourceManagerTag() {
    return this.resourceManagerTags.get(resourceManagerTags.size() - 1).build();
  }
  
  public GCPServiceAccount buildLastServiceAccount() {
    return this.serviceAccounts.get(serviceAccounts.size() - 1).build();
  }
  
  public GCPDisk buildMatchingDisk(Predicate<GCPDiskBuilder> predicate) {
      for (GCPDiskBuilder item : disks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPMetadata buildMatchingGcpMetadatum(Predicate<GCPMetadataBuilder> predicate) {
      for (GCPMetadataBuilder item : gcpMetadata) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPGPUConfig buildMatchingGpus(Predicate<GCPGPUConfigBuilder> predicate) {
      for (GCPGPUConfigBuilder item : gpus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPNetworkInterface buildMatchingNetworkInterface(Predicate<GCPNetworkInterfaceBuilder> predicate) {
      for (GCPNetworkInterfaceBuilder item : networkInterfaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceManagerTag buildMatchingResourceManagerTag(Predicate<ResourceManagerTagBuilder> predicate) {
      for (ResourceManagerTagBuilder item : resourceManagerTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPServiceAccount buildMatchingServiceAccount(Predicate<GCPServiceAccountBuilder> predicate) {
      for (GCPServiceAccountBuilder item : serviceAccounts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public GCPNetworkInterface buildNetworkInterface(int index) {
    return this.networkInterfaces.get(index).build();
  }
  
  public List<GCPNetworkInterface> buildNetworkInterfaces() {
    return this.networkInterfaces != null ? build(networkInterfaces) : null;
  }
  
  public ResourceManagerTag buildResourceManagerTag(int index) {
    return this.resourceManagerTags.get(index).build();
  }
  
  public List<ResourceManagerTag> buildResourceManagerTags() {
    return this.resourceManagerTags != null ? build(resourceManagerTags) : null;
  }
  
  public GCPServiceAccount buildServiceAccount(int index) {
    return this.serviceAccounts.get(index).build();
  }
  
  public List<GCPServiceAccount> buildServiceAccounts() {
    return this.serviceAccounts != null ? build(serviceAccounts) : null;
  }
  
  public GCPShieldedInstanceConfig buildShieldedInstanceConfig() {
    return this.shieldedInstanceConfig != null ? this.shieldedInstanceConfig.build() : null;
  }
  
  public LocalObjectReference buildUserDataSecret() {
    return this.userDataSecret != null ? this.userDataSecret.build() : null;
  }
  
  protected void copyInstance(GCPMachineProviderSpec instance) {
    instance = instance != null ? instance : new GCPMachineProviderSpec();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withCanIPForward(instance.getCanIPForward());
        this.withConfidentialCompute(instance.getConfidentialCompute());
        this.withCredentialsSecret(instance.getCredentialsSecret());
        this.withDeletionProtection(instance.getDeletionProtection());
        this.withDisks(instance.getDisks());
        this.withGcpMetadata(instance.getGcpMetadata());
        this.withGpus(instance.getGpus());
        this.withKind(instance.getKind());
        this.withLabels(instance.getLabels());
        this.withMachineType(instance.getMachineType());
        this.withMetadata(instance.getMetadata());
        this.withNetworkInterfaces(instance.getNetworkInterfaces());
        this.withOnHostMaintenance(instance.getOnHostMaintenance());
        this.withPreemptible(instance.getPreemptible());
        this.withProjectID(instance.getProjectID());
        this.withRegion(instance.getRegion());
        this.withResourceManagerTags(instance.getResourceManagerTags());
        this.withRestartPolicy(instance.getRestartPolicy());
        this.withServiceAccounts(instance.getServiceAccounts());
        this.withShieldedInstanceConfig(instance.getShieldedInstanceConfig());
        this.withTags(instance.getTags());
        this.withTargetPools(instance.getTargetPools());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withZone(instance.getZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsSecretNested<A> editCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(null));
  }
  
  public DisksNested<A> editDisk(int index) {
    if (disks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "disks"));
    }
    return this.setNewDiskLike(index, this.buildDisk(index));
  }
  
  public DisksNested<A> editFirstDisk() {
    if (disks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "disks"));
    }
    return this.setNewDiskLike(0, this.buildDisk(0));
  }
  
  public GcpMetadataNested<A> editFirstGcpMetadatum() {
    if (gcpMetadata.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gcpMetadata"));
    }
    return this.setNewGcpMetadatumLike(0, this.buildGcpMetadatum(0));
  }
  
  public GpusNested<A> editFirstGpus() {
    if (gpus.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gpus"));
    }
    return this.setNewGpusLike(0, this.buildGpus(0));
  }
  
  public NetworkInterfacesNested<A> editFirstNetworkInterface() {
    if (networkInterfaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "networkInterfaces"));
    }
    return this.setNewNetworkInterfaceLike(0, this.buildNetworkInterface(0));
  }
  
  public ResourceManagerTagsNested<A> editFirstResourceManagerTag() {
    if (resourceManagerTags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceManagerTags"));
    }
    return this.setNewResourceManagerTagLike(0, this.buildResourceManagerTag(0));
  }
  
  public ServiceAccountsNested<A> editFirstServiceAccount() {
    if (serviceAccounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "serviceAccounts"));
    }
    return this.setNewServiceAccountLike(0, this.buildServiceAccount(0));
  }
  
  public GcpMetadataNested<A> editGcpMetadatum(int index) {
    if (gcpMetadata.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gcpMetadata"));
    }
    return this.setNewGcpMetadatumLike(index, this.buildGcpMetadatum(index));
  }
  
  public GpusNested<A> editGpus(int index) {
    if (gpus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public DisksNested<A> editLastDisk() {
    int index = disks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "disks"));
    }
    return this.setNewDiskLike(index, this.buildDisk(index));
  }
  
  public GcpMetadataNested<A> editLastGcpMetadatum() {
    int index = gcpMetadata.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gcpMetadata"));
    }
    return this.setNewGcpMetadatumLike(index, this.buildGcpMetadatum(index));
  }
  
  public GpusNested<A> editLastGpus() {
    int index = gpus.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public NetworkInterfacesNested<A> editLastNetworkInterface() {
    int index = networkInterfaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "networkInterfaces"));
    }
    return this.setNewNetworkInterfaceLike(index, this.buildNetworkInterface(index));
  }
  
  public ResourceManagerTagsNested<A> editLastResourceManagerTag() {
    int index = resourceManagerTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceManagerTags"));
    }
    return this.setNewResourceManagerTagLike(index, this.buildResourceManagerTag(index));
  }
  
  public ServiceAccountsNested<A> editLastServiceAccount() {
    int index = serviceAccounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "serviceAccounts"));
    }
    return this.setNewServiceAccountLike(index, this.buildServiceAccount(index));
  }
  
  public DisksNested<A> editMatchingDisk(Predicate<GCPDiskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < disks.size();i++) {
      if (predicate.test(disks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "disks"));
    }
    return this.setNewDiskLike(index, this.buildDisk(index));
  }
  
  public GcpMetadataNested<A> editMatchingGcpMetadatum(Predicate<GCPMetadataBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gcpMetadata.size();i++) {
      if (predicate.test(gcpMetadata.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gcpMetadata"));
    }
    return this.setNewGcpMetadatumLike(index, this.buildGcpMetadatum(index));
  }
  
  public GpusNested<A> editMatchingGpus(Predicate<GCPGPUConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gpus.size();i++) {
      if (predicate.test(gpus.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public NetworkInterfacesNested<A> editMatchingNetworkInterface(Predicate<GCPNetworkInterfaceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < networkInterfaces.size();i++) {
      if (predicate.test(networkInterfaces.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "networkInterfaces"));
    }
    return this.setNewNetworkInterfaceLike(index, this.buildNetworkInterface(index));
  }
  
  public ResourceManagerTagsNested<A> editMatchingResourceManagerTag(Predicate<ResourceManagerTagBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceManagerTags.size();i++) {
      if (predicate.test(resourceManagerTags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceManagerTags"));
    }
    return this.setNewResourceManagerTagLike(index, this.buildResourceManagerTag(index));
  }
  
  public ServiceAccountsNested<A> editMatchingServiceAccount(Predicate<GCPServiceAccountBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < serviceAccounts.size();i++) {
      if (predicate.test(serviceAccounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "serviceAccounts"));
    }
    return this.setNewServiceAccountLike(index, this.buildServiceAccount(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public NetworkInterfacesNested<A> editNetworkInterface(int index) {
    if (networkInterfaces.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "networkInterfaces"));
    }
    return this.setNewNetworkInterfaceLike(index, this.buildNetworkInterface(index));
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
  
  public ShieldedInstanceConfigNested<A> editOrNewShieldedInstanceConfig() {
    return this.withNewShieldedInstanceConfigLike(Optional.ofNullable(this.buildShieldedInstanceConfig()).orElse(new GCPShieldedInstanceConfigBuilder().build()));
  }
  
  public ShieldedInstanceConfigNested<A> editOrNewShieldedInstanceConfigLike(GCPShieldedInstanceConfig item) {
    return this.withNewShieldedInstanceConfigLike(Optional.ofNullable(this.buildShieldedInstanceConfig()).orElse(item));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecretLike(LocalObjectReference item) {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(item));
  }
  
  public ResourceManagerTagsNested<A> editResourceManagerTag(int index) {
    if (resourceManagerTags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceManagerTags"));
    }
    return this.setNewResourceManagerTagLike(index, this.buildResourceManagerTag(index));
  }
  
  public ServiceAccountsNested<A> editServiceAccount(int index) {
    if (serviceAccounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "serviceAccounts"));
    }
    return this.setNewServiceAccountLike(index, this.buildServiceAccount(index));
  }
  
  public ShieldedInstanceConfigNested<A> editShieldedInstanceConfig() {
    return this.withNewShieldedInstanceConfigLike(Optional.ofNullable(this.buildShieldedInstanceConfig()).orElse(null));
  }
  
  public UserDataSecretNested<A> editUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(null));
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
    GCPMachineProviderSpecFluent that = (GCPMachineProviderSpecFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(canIPForward, that.canIPForward))) {
      return false;
    }
    if (!(Objects.equals(confidentialCompute, that.confidentialCompute))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecret, that.credentialsSecret))) {
      return false;
    }
    if (!(Objects.equals(deletionProtection, that.deletionProtection))) {
      return false;
    }
    if (!(Objects.equals(disks, that.disks))) {
      return false;
    }
    if (!(Objects.equals(gcpMetadata, that.gcpMetadata))) {
      return false;
    }
    if (!(Objects.equals(gpus, that.gpus))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(machineType, that.machineType))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(networkInterfaces, that.networkInterfaces))) {
      return false;
    }
    if (!(Objects.equals(onHostMaintenance, that.onHostMaintenance))) {
      return false;
    }
    if (!(Objects.equals(preemptible, that.preemptible))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(resourceManagerTags, that.resourceManagerTags))) {
      return false;
    }
    if (!(Objects.equals(restartPolicy, that.restartPolicy))) {
      return false;
    }
    if (!(Objects.equals(serviceAccounts, that.serviceAccounts))) {
      return false;
    }
    if (!(Objects.equals(shieldedInstanceConfig, that.shieldedInstanceConfig))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(targetPools, that.targetPools))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
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
  
  public Boolean getCanIPForward() {
    return this.canIPForward;
  }
  
  public String getConfidentialCompute() {
    return this.confidentialCompute;
  }
  
  public Boolean getDeletionProtection() {
    return this.deletionProtection;
  }
  
  public String getFirstTag() {
    return this.tags.get(0);
  }
  
  public String getFirstTargetPool() {
    return this.targetPools.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getLastTag() {
    return this.tags.get(tags.size() - 1);
  }
  
  public String getLastTargetPool() {
    return this.targetPools.get(targetPools.size() - 1);
  }
  
  public String getMachineType() {
    return this.machineType;
  }
  
  public String getMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTargetPool(Predicate<String> predicate) {
      for (String item : targetPools) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOnHostMaintenance() {
    return this.onHostMaintenance;
  }
  
  public Boolean getPreemptible() {
    return this.preemptible;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRestartPolicy() {
    return this.restartPolicy;
  }
  
  public String getTag(int index) {
    return this.tags.get(index);
  }
  
  public List<String> getTags() {
    return this.tags;
  }
  
  public String getTargetPool(int index) {
    return this.targetPools.get(index);
  }
  
  public List<String> getTargetPools() {
    return this.targetPools;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasCanIPForward() {
    return this.canIPForward != null;
  }
  
  public boolean hasConfidentialCompute() {
    return this.confidentialCompute != null;
  }
  
  public boolean hasCredentialsSecret() {
    return this.credentialsSecret != null;
  }
  
  public boolean hasDeletionProtection() {
    return this.deletionProtection != null;
  }
  
  public boolean hasDisks() {
    return this.disks != null && !(this.disks.isEmpty());
  }
  
  public boolean hasGcpMetadata() {
    return this.gcpMetadata != null && !(this.gcpMetadata.isEmpty());
  }
  
  public boolean hasGpus() {
    return this.gpus != null && !(this.gpus.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMachineType() {
    return this.machineType != null;
  }
  
  public boolean hasMatchingDisk(Predicate<GCPDiskBuilder> predicate) {
      for (GCPDiskBuilder item : disks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGcpMetadatum(Predicate<GCPMetadataBuilder> predicate) {
      for (GCPMetadataBuilder item : gcpMetadata) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGpus(Predicate<GCPGPUConfigBuilder> predicate) {
      for (GCPGPUConfigBuilder item : gpus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNetworkInterface(Predicate<GCPNetworkInterfaceBuilder> predicate) {
      for (GCPNetworkInterfaceBuilder item : networkInterfaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceManagerTag(Predicate<ResourceManagerTagBuilder> predicate) {
      for (ResourceManagerTagBuilder item : resourceManagerTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceAccount(Predicate<GCPServiceAccountBuilder> predicate) {
      for (GCPServiceAccountBuilder item : serviceAccounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetPool(Predicate<String> predicate) {
      for (String item : targetPools) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNetworkInterfaces() {
    return this.networkInterfaces != null && !(this.networkInterfaces.isEmpty());
  }
  
  public boolean hasOnHostMaintenance() {
    return this.onHostMaintenance != null;
  }
  
  public boolean hasPreemptible() {
    return this.preemptible != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasResourceManagerTags() {
    return this.resourceManagerTags != null && !(this.resourceManagerTags.isEmpty());
  }
  
  public boolean hasRestartPolicy() {
    return this.restartPolicy != null;
  }
  
  public boolean hasServiceAccounts() {
    return this.serviceAccounts != null && !(this.serviceAccounts.isEmpty());
  }
  
  public boolean hasShieldedInstanceConfig() {
    return this.shieldedInstanceConfig != null;
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public boolean hasTargetPools() {
    return this.targetPools != null && !(this.targetPools.isEmpty());
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, canIPForward, confidentialCompute, credentialsSecret, deletionProtection, disks, gcpMetadata, gpus, kind, labels, machineType, metadata, networkInterfaces, onHostMaintenance, preemptible, projectID, region, resourceManagerTags, restartPolicy, serviceAccounts, shieldedInstanceConfig, tags, targetPools, userDataSecret, zone, additionalProperties);
  }
  
  public A removeAllFromDisks(Collection<GCPDisk> items) {
    if (this.disks == null) {
      return (A) this;
    }
    for (GCPDisk item : items) {
        GCPDiskBuilder builder = new GCPDiskBuilder(item);
        _visitables.get("disks").remove(builder);
        this.disks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromGcpMetadata(Collection<GCPMetadata> items) {
    if (this.gcpMetadata == null) {
      return (A) this;
    }
    for (GCPMetadata item : items) {
        GCPMetadataBuilder builder = new GCPMetadataBuilder(item);
        _visitables.get("gcpMetadata").remove(builder);
        this.gcpMetadata.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromGpus(Collection<GCPGPUConfig> items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (GCPGPUConfig item : items) {
        GCPGPUConfigBuilder builder = new GCPGPUConfigBuilder(item);
        _visitables.get("gpus").remove(builder);
        this.gpus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNetworkInterfaces(Collection<GCPNetworkInterface> items) {
    if (this.networkInterfaces == null) {
      return (A) this;
    }
    for (GCPNetworkInterface item : items) {
        GCPNetworkInterfaceBuilder builder = new GCPNetworkInterfaceBuilder(item);
        _visitables.get("networkInterfaces").remove(builder);
        this.networkInterfaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceManagerTags(Collection<ResourceManagerTag> items) {
    if (this.resourceManagerTags == null) {
      return (A) this;
    }
    for (ResourceManagerTag item : items) {
        ResourceManagerTagBuilder builder = new ResourceManagerTagBuilder(item);
        _visitables.get("resourceManagerTags").remove(builder);
        this.resourceManagerTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceAccounts(Collection<GCPServiceAccount> items) {
    if (this.serviceAccounts == null) {
      return (A) this;
    }
    for (GCPServiceAccount item : items) {
        GCPServiceAccountBuilder builder = new GCPServiceAccountBuilder(item);
        _visitables.get("serviceAccounts").remove(builder);
        this.serviceAccounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTags(Collection<String> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetPools(Collection<String> items) {
    if (this.targetPools == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetPools.remove(item);
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
  
  public A removeFromDisks(GCPDisk... items) {
    if (this.disks == null) {
      return (A) this;
    }
    for (GCPDisk item : items) {
        GCPDiskBuilder builder = new GCPDiskBuilder(item);
        _visitables.get("disks").remove(builder);
        this.disks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromGcpMetadata(GCPMetadata... items) {
    if (this.gcpMetadata == null) {
      return (A) this;
    }
    for (GCPMetadata item : items) {
        GCPMetadataBuilder builder = new GCPMetadataBuilder(item);
        _visitables.get("gcpMetadata").remove(builder);
        this.gcpMetadata.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromGpus(GCPGPUConfig... items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (GCPGPUConfig item : items) {
        GCPGPUConfigBuilder builder = new GCPGPUConfigBuilder(item);
        _visitables.get("gpus").remove(builder);
        this.gpus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNetworkInterfaces(GCPNetworkInterface... items) {
    if (this.networkInterfaces == null) {
      return (A) this;
    }
    for (GCPNetworkInterface item : items) {
        GCPNetworkInterfaceBuilder builder = new GCPNetworkInterfaceBuilder(item);
        _visitables.get("networkInterfaces").remove(builder);
        this.networkInterfaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourceManagerTags(ResourceManagerTag... items) {
    if (this.resourceManagerTags == null) {
      return (A) this;
    }
    for (ResourceManagerTag item : items) {
        ResourceManagerTagBuilder builder = new ResourceManagerTagBuilder(item);
        _visitables.get("resourceManagerTags").remove(builder);
        this.resourceManagerTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromServiceAccounts(GCPServiceAccount... items) {
    if (this.serviceAccounts == null) {
      return (A) this;
    }
    for (GCPServiceAccount item : items) {
        GCPServiceAccountBuilder builder = new GCPServiceAccountBuilder(item);
        _visitables.get("serviceAccounts").remove(builder);
        this.serviceAccounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTags(String... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTargetPools(String... items) {
    if (this.targetPools == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetPools.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDisks(Predicate<GCPDiskBuilder> predicate) {
    if (disks == null) {
      return (A) this;
    }
    Iterator<GCPDiskBuilder> each = disks.iterator();
    List visitables = _visitables.get("disks");
    while (each.hasNext()) {
        GCPDiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromGcpMetadata(Predicate<GCPMetadataBuilder> predicate) {
    if (gcpMetadata == null) {
      return (A) this;
    }
    Iterator<GCPMetadataBuilder> each = gcpMetadata.iterator();
    List visitables = _visitables.get("gcpMetadata");
    while (each.hasNext()) {
        GCPMetadataBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromGpus(Predicate<GCPGPUConfigBuilder> predicate) {
    if (gpus == null) {
      return (A) this;
    }
    Iterator<GCPGPUConfigBuilder> each = gpus.iterator();
    List visitables = _visitables.get("gpus");
    while (each.hasNext()) {
        GCPGPUConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromNetworkInterfaces(Predicate<GCPNetworkInterfaceBuilder> predicate) {
    if (networkInterfaces == null) {
      return (A) this;
    }
    Iterator<GCPNetworkInterfaceBuilder> each = networkInterfaces.iterator();
    List visitables = _visitables.get("networkInterfaces");
    while (each.hasNext()) {
        GCPNetworkInterfaceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceManagerTags(Predicate<ResourceManagerTagBuilder> predicate) {
    if (resourceManagerTags == null) {
      return (A) this;
    }
    Iterator<ResourceManagerTagBuilder> each = resourceManagerTags.iterator();
    List visitables = _visitables.get("resourceManagerTags");
    while (each.hasNext()) {
        ResourceManagerTagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromServiceAccounts(Predicate<GCPServiceAccountBuilder> predicate) {
    if (serviceAccounts == null) {
      return (A) this;
    }
    Iterator<GCPServiceAccountBuilder> each = serviceAccounts.iterator();
    List visitables = _visitables.get("serviceAccounts");
    while (each.hasNext()) {
        GCPServiceAccountBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DisksNested<A> setNewDiskLike(int index,GCPDisk item) {
    return new DisksNested(index, item);
  }
  
  public GcpMetadataNested<A> setNewGcpMetadatumLike(int index,GCPMetadata item) {
    return new GcpMetadataNested(index, item);
  }
  
  public GpusNested<A> setNewGpusLike(int index,GCPGPUConfig item) {
    return new GpusNested(index, item);
  }
  
  public NetworkInterfacesNested<A> setNewNetworkInterfaceLike(int index,GCPNetworkInterface item) {
    return new NetworkInterfacesNested(index, item);
  }
  
  public ResourceManagerTagsNested<A> setNewResourceManagerTagLike(int index,ResourceManagerTag item) {
    return new ResourceManagerTagsNested(index, item);
  }
  
  public ServiceAccountsNested<A> setNewServiceAccountLike(int index,GCPServiceAccount item) {
    return new ServiceAccountsNested(index, item);
  }
  
  public A setToDisks(int index,GCPDisk item) {
    if (this.disks == null) {
      this.disks = new ArrayList();
    }
    GCPDiskBuilder builder = new GCPDiskBuilder(item);
    if (index < 0 || index >= disks.size()) {
        _visitables.get("disks").add(builder);
        disks.add(builder);
    } else {
        _visitables.get("disks").add(builder);
        disks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToGcpMetadata(int index,GCPMetadata item) {
    if (this.gcpMetadata == null) {
      this.gcpMetadata = new ArrayList();
    }
    GCPMetadataBuilder builder = new GCPMetadataBuilder(item);
    if (index < 0 || index >= gcpMetadata.size()) {
        _visitables.get("gcpMetadata").add(builder);
        gcpMetadata.add(builder);
    } else {
        _visitables.get("gcpMetadata").add(builder);
        gcpMetadata.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToGpus(int index,GCPGPUConfig item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    GCPGPUConfigBuilder builder = new GCPGPUConfigBuilder(item);
    if (index < 0 || index >= gpus.size()) {
        _visitables.get("gpus").add(builder);
        gpus.add(builder);
    } else {
        _visitables.get("gpus").add(builder);
        gpus.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNetworkInterfaces(int index,GCPNetworkInterface item) {
    if (this.networkInterfaces == null) {
      this.networkInterfaces = new ArrayList();
    }
    GCPNetworkInterfaceBuilder builder = new GCPNetworkInterfaceBuilder(item);
    if (index < 0 || index >= networkInterfaces.size()) {
        _visitables.get("networkInterfaces").add(builder);
        networkInterfaces.add(builder);
    } else {
        _visitables.get("networkInterfaces").add(builder);
        networkInterfaces.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourceManagerTags(int index,ResourceManagerTag item) {
    if (this.resourceManagerTags == null) {
      this.resourceManagerTags = new ArrayList();
    }
    ResourceManagerTagBuilder builder = new ResourceManagerTagBuilder(item);
    if (index < 0 || index >= resourceManagerTags.size()) {
        _visitables.get("resourceManagerTags").add(builder);
        resourceManagerTags.add(builder);
    } else {
        _visitables.get("resourceManagerTags").add(builder);
        resourceManagerTags.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToServiceAccounts(int index,GCPServiceAccount item) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    GCPServiceAccountBuilder builder = new GCPServiceAccountBuilder(item);
    if (index < 0 || index >= serviceAccounts.size()) {
        _visitables.get("serviceAccounts").add(builder);
        serviceAccounts.add(builder);
    } else {
        _visitables.get("serviceAccounts").add(builder);
        serviceAccounts.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.set(index, item);
    return (A) this;
  }
  
  public A setToTargetPools(int index,String item) {
    if (this.targetPools == null) {
      this.targetPools = new ArrayList();
    }
    this.targetPools.set(index, item);
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
    if (!(canIPForward == null)) {
        sb.append("canIPForward:");
        sb.append(canIPForward);
        sb.append(",");
    }
    if (!(confidentialCompute == null)) {
        sb.append("confidentialCompute:");
        sb.append(confidentialCompute);
        sb.append(",");
    }
    if (!(credentialsSecret == null)) {
        sb.append("credentialsSecret:");
        sb.append(credentialsSecret);
        sb.append(",");
    }
    if (!(deletionProtection == null)) {
        sb.append("deletionProtection:");
        sb.append(deletionProtection);
        sb.append(",");
    }
    if (!(disks == null) && !(disks.isEmpty())) {
        sb.append("disks:");
        sb.append(disks);
        sb.append(",");
    }
    if (!(gcpMetadata == null) && !(gcpMetadata.isEmpty())) {
        sb.append("gcpMetadata:");
        sb.append(gcpMetadata);
        sb.append(",");
    }
    if (!(gpus == null) && !(gpus.isEmpty())) {
        sb.append("gpus:");
        sb.append(gpus);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(machineType == null)) {
        sb.append("machineType:");
        sb.append(machineType);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(networkInterfaces == null) && !(networkInterfaces.isEmpty())) {
        sb.append("networkInterfaces:");
        sb.append(networkInterfaces);
        sb.append(",");
    }
    if (!(onHostMaintenance == null)) {
        sb.append("onHostMaintenance:");
        sb.append(onHostMaintenance);
        sb.append(",");
    }
    if (!(preemptible == null)) {
        sb.append("preemptible:");
        sb.append(preemptible);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(resourceManagerTags == null) && !(resourceManagerTags.isEmpty())) {
        sb.append("resourceManagerTags:");
        sb.append(resourceManagerTags);
        sb.append(",");
    }
    if (!(restartPolicy == null)) {
        sb.append("restartPolicy:");
        sb.append(restartPolicy);
        sb.append(",");
    }
    if (!(serviceAccounts == null) && !(serviceAccounts.isEmpty())) {
        sb.append("serviceAccounts:");
        sb.append(serviceAccounts);
        sb.append(",");
    }
    if (!(shieldedInstanceConfig == null)) {
        sb.append("shieldedInstanceConfig:");
        sb.append(shieldedInstanceConfig);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(targetPools == null) && !(targetPools.isEmpty())) {
        sb.append("targetPools:");
        sb.append(targetPools);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
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
  
  public A withCanIPForward() {
    return withCanIPForward(true);
  }
  
  public A withCanIPForward(Boolean canIPForward) {
    this.canIPForward = canIPForward;
    return (A) this;
  }
  
  public A withConfidentialCompute(String confidentialCompute) {
    this.confidentialCompute = confidentialCompute;
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
  
  public A withDeletionProtection() {
    return withDeletionProtection(true);
  }
  
  public A withDeletionProtection(Boolean deletionProtection) {
    this.deletionProtection = deletionProtection;
    return (A) this;
  }
  
  public A withDisks(List<GCPDisk> disks) {
    if (this.disks != null) {
      this._visitables.get("disks").clear();
    }
    if (disks != null) {
        this.disks = new ArrayList();
        for (GCPDisk item : disks) {
          this.addToDisks(item);
        }
    } else {
      this.disks = null;
    }
    return (A) this;
  }
  
  public A withDisks(GCPDisk... disks) {
    if (this.disks != null) {
        this.disks.clear();
        _visitables.remove("disks");
    }
    if (disks != null) {
      for (GCPDisk item : disks) {
        this.addToDisks(item);
      }
    }
    return (A) this;
  }
  
  public A withGcpMetadata(List<GCPMetadata> gcpMetadata) {
    if (this.gcpMetadata != null) {
      this._visitables.get("gcpMetadata").clear();
    }
    if (gcpMetadata != null) {
        this.gcpMetadata = new ArrayList();
        for (GCPMetadata item : gcpMetadata) {
          this.addToGcpMetadata(item);
        }
    } else {
      this.gcpMetadata = null;
    }
    return (A) this;
  }
  
  public A withGcpMetadata(GCPMetadata... gcpMetadata) {
    if (this.gcpMetadata != null) {
        this.gcpMetadata.clear();
        _visitables.remove("gcpMetadata");
    }
    if (gcpMetadata != null) {
      for (GCPMetadata item : gcpMetadata) {
        this.addToGcpMetadata(item);
      }
    }
    return (A) this;
  }
  
  public A withGpus(List<GCPGPUConfig> gpus) {
    if (this.gpus != null) {
      this._visitables.get("gpus").clear();
    }
    if (gpus != null) {
        this.gpus = new ArrayList();
        for (GCPGPUConfig item : gpus) {
          this.addToGpus(item);
        }
    } else {
      this.gpus = null;
    }
    return (A) this;
  }
  
  public A withGpus(GCPGPUConfig... gpus) {
    if (this.gpus != null) {
        this.gpus.clear();
        _visitables.remove("gpus");
    }
    if (gpus != null) {
      for (GCPGPUConfig item : gpus) {
        this.addToGpus(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public A withMachineType(String machineType) {
    this.machineType = machineType;
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
  
  public A withNetworkInterfaces(List<GCPNetworkInterface> networkInterfaces) {
    if (this.networkInterfaces != null) {
      this._visitables.get("networkInterfaces").clear();
    }
    if (networkInterfaces != null) {
        this.networkInterfaces = new ArrayList();
        for (GCPNetworkInterface item : networkInterfaces) {
          this.addToNetworkInterfaces(item);
        }
    } else {
      this.networkInterfaces = null;
    }
    return (A) this;
  }
  
  public A withNetworkInterfaces(GCPNetworkInterface... networkInterfaces) {
    if (this.networkInterfaces != null) {
        this.networkInterfaces.clear();
        _visitables.remove("networkInterfaces");
    }
    if (networkInterfaces != null) {
      for (GCPNetworkInterface item : networkInterfaces) {
        this.addToNetworkInterfaces(item);
      }
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
  
  public ShieldedInstanceConfigNested<A> withNewShieldedInstanceConfig() {
    return new ShieldedInstanceConfigNested(null);
  }
  
  public A withNewShieldedInstanceConfig(String integrityMonitoring,String secureBoot,String virtualizedTrustedPlatformModule) {
    return (A) this.withShieldedInstanceConfig(new GCPShieldedInstanceConfig(integrityMonitoring, secureBoot, virtualizedTrustedPlatformModule));
  }
  
  public ShieldedInstanceConfigNested<A> withNewShieldedInstanceConfigLike(GCPShieldedInstanceConfig item) {
    return new ShieldedInstanceConfigNested(item);
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
  
  public A withOnHostMaintenance(String onHostMaintenance) {
    this.onHostMaintenance = onHostMaintenance;
    return (A) this;
  }
  
  public A withPreemptible() {
    return withPreemptible(true);
  }
  
  public A withPreemptible(Boolean preemptible) {
    this.preemptible = preemptible;
    return (A) this;
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withResourceManagerTags(List<ResourceManagerTag> resourceManagerTags) {
    if (this.resourceManagerTags != null) {
      this._visitables.get("resourceManagerTags").clear();
    }
    if (resourceManagerTags != null) {
        this.resourceManagerTags = new ArrayList();
        for (ResourceManagerTag item : resourceManagerTags) {
          this.addToResourceManagerTags(item);
        }
    } else {
      this.resourceManagerTags = null;
    }
    return (A) this;
  }
  
  public A withResourceManagerTags(ResourceManagerTag... resourceManagerTags) {
    if (this.resourceManagerTags != null) {
        this.resourceManagerTags.clear();
        _visitables.remove("resourceManagerTags");
    }
    if (resourceManagerTags != null) {
      for (ResourceManagerTag item : resourceManagerTags) {
        this.addToResourceManagerTags(item);
      }
    }
    return (A) this;
  }
  
  public A withRestartPolicy(String restartPolicy) {
    this.restartPolicy = restartPolicy;
    return (A) this;
  }
  
  public A withServiceAccounts(List<GCPServiceAccount> serviceAccounts) {
    if (this.serviceAccounts != null) {
      this._visitables.get("serviceAccounts").clear();
    }
    if (serviceAccounts != null) {
        this.serviceAccounts = new ArrayList();
        for (GCPServiceAccount item : serviceAccounts) {
          this.addToServiceAccounts(item);
        }
    } else {
      this.serviceAccounts = null;
    }
    return (A) this;
  }
  
  public A withServiceAccounts(GCPServiceAccount... serviceAccounts) {
    if (this.serviceAccounts != null) {
        this.serviceAccounts.clear();
        _visitables.remove("serviceAccounts");
    }
    if (serviceAccounts != null) {
      for (GCPServiceAccount item : serviceAccounts) {
        this.addToServiceAccounts(item);
      }
    }
    return (A) this;
  }
  
  public A withShieldedInstanceConfig(GCPShieldedInstanceConfig shieldedInstanceConfig) {
    this._visitables.remove("shieldedInstanceConfig");
    if (shieldedInstanceConfig != null) {
        this.shieldedInstanceConfig = new GCPShieldedInstanceConfigBuilder(shieldedInstanceConfig);
        this._visitables.get("shieldedInstanceConfig").add(this.shieldedInstanceConfig);
    } else {
        this.shieldedInstanceConfig = null;
        this._visitables.get("shieldedInstanceConfig").remove(this.shieldedInstanceConfig);
    }
    return (A) this;
  }
  
  public A withTags(List<String> tags) {
    if (tags != null) {
        this.tags = new ArrayList();
        for (String item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(String... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (String item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  
  public A withTargetPools(List<String> targetPools) {
    if (targetPools != null) {
        this.targetPools = new ArrayList();
        for (String item : targetPools) {
          this.addToTargetPools(item);
        }
    } else {
      this.targetPools = null;
    }
    return (A) this;
  }
  
  public A withTargetPools(String... targetPools) {
    if (this.targetPools != null) {
        this.targetPools.clear();
        _visitables.remove("targetPools");
    }
    if (targetPools != null) {
      for (String item : targetPools) {
        this.addToTargetPools(item);
      }
    }
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
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  public class CredentialsSecretNested<N> extends LocalObjectReferenceFluent<CredentialsSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.withCredentialsSecret(builder.build());
    }
    
    public N endCredentialsSecret() {
      return and();
    }
    
  }
  public class DisksNested<N> extends GCPDiskFluent<DisksNested<N>> implements Nested<N>{
  
    GCPDiskBuilder builder;
    int index;
  
    DisksNested(int index,GCPDisk item) {
      this.index = index;
      this.builder = new GCPDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.setToDisks(index, builder.build());
    }
    
    public N endDisk() {
      return and();
    }
    
  }
  public class GcpMetadataNested<N> extends GCPMetadataFluent<GcpMetadataNested<N>> implements Nested<N>{
  
    GCPMetadataBuilder builder;
    int index;
  
    GcpMetadataNested(int index,GCPMetadata item) {
      this.index = index;
      this.builder = new GCPMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.setToGcpMetadata(index, builder.build());
    }
    
    public N endGcpMetadatum() {
      return and();
    }
    
  }
  public class GpusNested<N> extends GCPGPUConfigFluent<GpusNested<N>> implements Nested<N>{
  
    GCPGPUConfigBuilder builder;
    int index;
  
    GpusNested(int index,GCPGPUConfig item) {
      this.index = index;
      this.builder = new GCPGPUConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.setToGpus(index, builder.build());
    }
    
    public N endGpus() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class NetworkInterfacesNested<N> extends GCPNetworkInterfaceFluent<NetworkInterfacesNested<N>> implements Nested<N>{
  
    GCPNetworkInterfaceBuilder builder;
    int index;
  
    NetworkInterfacesNested(int index,GCPNetworkInterface item) {
      this.index = index;
      this.builder = new GCPNetworkInterfaceBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.setToNetworkInterfaces(index, builder.build());
    }
    
    public N endNetworkInterface() {
      return and();
    }
    
  }
  public class ResourceManagerTagsNested<N> extends ResourceManagerTagFluent<ResourceManagerTagsNested<N>> implements Nested<N>{
  
    ResourceManagerTagBuilder builder;
    int index;
  
    ResourceManagerTagsNested(int index,ResourceManagerTag item) {
      this.index = index;
      this.builder = new ResourceManagerTagBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.setToResourceManagerTags(index, builder.build());
    }
    
    public N endResourceManagerTag() {
      return and();
    }
    
  }
  public class ServiceAccountsNested<N> extends GCPServiceAccountFluent<ServiceAccountsNested<N>> implements Nested<N>{
  
    GCPServiceAccountBuilder builder;
    int index;
  
    ServiceAccountsNested(int index,GCPServiceAccount item) {
      this.index = index;
      this.builder = new GCPServiceAccountBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.setToServiceAccounts(index, builder.build());
    }
    
    public N endServiceAccount() {
      return and();
    }
    
  }
  public class ShieldedInstanceConfigNested<N> extends GCPShieldedInstanceConfigFluent<ShieldedInstanceConfigNested<N>> implements Nested<N>{
  
    GCPShieldedInstanceConfigBuilder builder;
  
    ShieldedInstanceConfigNested(GCPShieldedInstanceConfig item) {
      this.builder = new GCPShieldedInstanceConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.withShieldedInstanceConfig(builder.build());
    }
    
    public N endShieldedInstanceConfig() {
      return and();
    }
    
  }
  public class UserDataSecretNested<N> extends LocalObjectReferenceFluent<UserDataSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    UserDataSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPMachineProviderSpecFluent.this.withUserDataSecret(builder.build());
    }
    
    public N endUserDataSecret() {
      return and();
    }
    
  }
}