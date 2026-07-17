package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
import java.lang.Boolean;
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
public class AzureMachineProviderSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.AzureMachineProviderSpecFluent<A>> extends BaseFluent<A>{

  private Boolean acceleratedNetworking;
  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> applicationSecurityGroups = new ArrayList<String>();
  private String availabilitySet;
  private String capacityReservationGroupID;
  private SecretReference credentialsSecret;
  private ArrayList<DataDiskBuilder> dataDisks = new ArrayList<DataDiskBuilder>();
  private AzureDiagnosticsBuilder diagnostics;
  private ImageBuilder image;
  private String internalLoadBalancer;
  private String kind;
  private String location;
  private String managedIdentity;
  private ObjectMetaBuilder metadata;
  private Long natRule;
  private String networkResourceGroup;
  private OSDiskBuilder osDisk;
  private Boolean publicIP;
  private String publicLoadBalancer;
  private String resourceGroup;
  private String securityGroup;
  private SecurityProfileBuilder securityProfile;
  private SpotVMOptionsBuilder spotVMOptions;
  private String sshPublicKey;
  private String subnet;
  private Map<String,String> tags;
  private String ultraSSDCapability;
  private SecretReference userDataSecret;
  private String vmSize;
  private String vnet;
  private String zone;

  public AzureMachineProviderSpecFluent() {
  }
  
  public AzureMachineProviderSpecFluent(AzureMachineProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToApplicationSecurityGroups(Collection<String> items) {
    if (this.applicationSecurityGroups == null) {
      this.applicationSecurityGroups = new ArrayList();
    }
    for (String item : items) {
      this.applicationSecurityGroups.add(item);
    }
    return (A) this;
  }
  
  public A addAllToDataDisks(Collection<DataDisk> items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public DataDisksNested<A> addNewDataDisk() {
    return new DataDisksNested(-1, null);
  }
  
  public DataDisksNested<A> addNewDataDiskLike(DataDisk item) {
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
  
  public A addToApplicationSecurityGroups(String... items) {
    if (this.applicationSecurityGroups == null) {
      this.applicationSecurityGroups = new ArrayList();
    }
    for (String item : items) {
      this.applicationSecurityGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToApplicationSecurityGroups(int index,String item) {
    if (this.applicationSecurityGroups == null) {
      this.applicationSecurityGroups = new ArrayList();
    }
    this.applicationSecurityGroups.add(index, item);
    return (A) this;
  }
  
  public A addToDataDisks(DataDisk... items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addToDataDisks(int index,DataDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    DataDiskBuilder builder = new DataDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTags(Map<String,String> map) {
    if (this.tags == null && map != null) {
      this.tags = new LinkedHashMap();
    }
    if (map != null) {
      this.tags.putAll(map);
    }
    return (A) this;
  }
  
  public A addToTags(String key,String value) {
    if (this.tags == null && key != null && value != null) {
      this.tags = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.tags.put(key, value);
    }
    return (A) this;
  }
  
  public DataDisk buildDataDisk(int index) {
    return this.dataDisks.get(index).build();
  }
  
  public List<DataDisk> buildDataDisks() {
    return this.dataDisks != null ? build(dataDisks) : null;
  }
  
  public AzureDiagnostics buildDiagnostics() {
    return this.diagnostics != null ? this.diagnostics.build() : null;
  }
  
  public DataDisk buildFirstDataDisk() {
    return this.dataDisks.get(0).build();
  }
  
  public Image buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public DataDisk buildLastDataDisk() {
    return this.dataDisks.get(dataDisks.size() - 1).build();
  }
  
  public DataDisk buildMatchingDataDisk(Predicate<DataDiskBuilder> predicate) {
      for (DataDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public OSDisk buildOsDisk() {
    return this.osDisk != null ? this.osDisk.build() : null;
  }
  
  public SecurityProfile buildSecurityProfile() {
    return this.securityProfile != null ? this.securityProfile.build() : null;
  }
  
  public SpotVMOptions buildSpotVMOptions() {
    return this.spotVMOptions != null ? this.spotVMOptions.build() : null;
  }
  
  protected void copyInstance(AzureMachineProviderSpec instance) {
    instance = instance != null ? instance : new AzureMachineProviderSpec();
    if (instance != null) {
        this.withAcceleratedNetworking(instance.getAcceleratedNetworking());
        this.withApiVersion(instance.getApiVersion());
        this.withApplicationSecurityGroups(instance.getApplicationSecurityGroups());
        this.withAvailabilitySet(instance.getAvailabilitySet());
        this.withCapacityReservationGroupID(instance.getCapacityReservationGroupID());
        this.withCredentialsSecret(instance.getCredentialsSecret());
        this.withDataDisks(instance.getDataDisks());
        this.withDiagnostics(instance.getDiagnostics());
        this.withImage(instance.getImage());
        this.withInternalLoadBalancer(instance.getInternalLoadBalancer());
        this.withKind(instance.getKind());
        this.withLocation(instance.getLocation());
        this.withManagedIdentity(instance.getManagedIdentity());
        this.withMetadata(instance.getMetadata());
        this.withNatRule(instance.getNatRule());
        this.withNetworkResourceGroup(instance.getNetworkResourceGroup());
        this.withOsDisk(instance.getOsDisk());
        this.withPublicIP(instance.getPublicIP());
        this.withPublicLoadBalancer(instance.getPublicLoadBalancer());
        this.withResourceGroup(instance.getResourceGroup());
        this.withSecurityGroup(instance.getSecurityGroup());
        this.withSecurityProfile(instance.getSecurityProfile());
        this.withSpotVMOptions(instance.getSpotVMOptions());
        this.withSshPublicKey(instance.getSshPublicKey());
        this.withSubnet(instance.getSubnet());
        this.withTags(instance.getTags());
        this.withUltraSSDCapability(instance.getUltraSSDCapability());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withVmSize(instance.getVmSize());
        this.withVnet(instance.getVnet());
        this.withZone(instance.getZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DataDisksNested<A> editDataDisk(int index) {
    if (dataDisks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public DiagnosticsNested<A> editDiagnostics() {
    return this.withNewDiagnosticsLike(Optional.ofNullable(this.buildDiagnostics()).orElse(null));
  }
  
  public DataDisksNested<A> editFirstDataDisk() {
    if (dataDisks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(0, this.buildDataDisk(0));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public DataDisksNested<A> editLastDataDisk() {
    int index = dataDisks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public DataDisksNested<A> editMatchingDataDisk(Predicate<DataDiskBuilder> predicate) {
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
  
  public DiagnosticsNested<A> editOrNewDiagnostics() {
    return this.withNewDiagnosticsLike(Optional.ofNullable(this.buildDiagnostics()).orElse(new AzureDiagnosticsBuilder().build()));
  }
  
  public DiagnosticsNested<A> editOrNewDiagnosticsLike(AzureDiagnostics item) {
    return this.withNewDiagnosticsLike(Optional.ofNullable(this.buildDiagnostics()).orElse(item));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ImageBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(Image item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public OsDiskNested<A> editOrNewOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(new OSDiskBuilder().build()));
  }
  
  public OsDiskNested<A> editOrNewOsDiskLike(OSDisk item) {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(item));
  }
  
  public SecurityProfileNested<A> editOrNewSecurityProfile() {
    return this.withNewSecurityProfileLike(Optional.ofNullable(this.buildSecurityProfile()).orElse(new SecurityProfileBuilder().build()));
  }
  
  public SecurityProfileNested<A> editOrNewSecurityProfileLike(SecurityProfile item) {
    return this.withNewSecurityProfileLike(Optional.ofNullable(this.buildSecurityProfile()).orElse(item));
  }
  
  public SpotVMOptionsNested<A> editOrNewSpotVMOptions() {
    return this.withNewSpotVMOptionsLike(Optional.ofNullable(this.buildSpotVMOptions()).orElse(new SpotVMOptionsBuilder().build()));
  }
  
  public SpotVMOptionsNested<A> editOrNewSpotVMOptionsLike(SpotVMOptions item) {
    return this.withNewSpotVMOptionsLike(Optional.ofNullable(this.buildSpotVMOptions()).orElse(item));
  }
  
  public OsDiskNested<A> editOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(null));
  }
  
  public SecurityProfileNested<A> editSecurityProfile() {
    return this.withNewSecurityProfileLike(Optional.ofNullable(this.buildSecurityProfile()).orElse(null));
  }
  
  public SpotVMOptionsNested<A> editSpotVMOptions() {
    return this.withNewSpotVMOptionsLike(Optional.ofNullable(this.buildSpotVMOptions()).orElse(null));
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
    AzureMachineProviderSpecFluent that = (AzureMachineProviderSpecFluent) o;
    if (!(Objects.equals(acceleratedNetworking, that.acceleratedNetworking))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(applicationSecurityGroups, that.applicationSecurityGroups))) {
      return false;
    }
    if (!(Objects.equals(availabilitySet, that.availabilitySet))) {
      return false;
    }
    if (!(Objects.equals(capacityReservationGroupID, that.capacityReservationGroupID))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecret, that.credentialsSecret))) {
      return false;
    }
    if (!(Objects.equals(dataDisks, that.dataDisks))) {
      return false;
    }
    if (!(Objects.equals(diagnostics, that.diagnostics))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(internalLoadBalancer, that.internalLoadBalancer))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(location, that.location))) {
      return false;
    }
    if (!(Objects.equals(managedIdentity, that.managedIdentity))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(natRule, that.natRule))) {
      return false;
    }
    if (!(Objects.equals(networkResourceGroup, that.networkResourceGroup))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(publicIP, that.publicIP))) {
      return false;
    }
    if (!(Objects.equals(publicLoadBalancer, that.publicLoadBalancer))) {
      return false;
    }
    if (!(Objects.equals(resourceGroup, that.resourceGroup))) {
      return false;
    }
    if (!(Objects.equals(securityGroup, that.securityGroup))) {
      return false;
    }
    if (!(Objects.equals(securityProfile, that.securityProfile))) {
      return false;
    }
    if (!(Objects.equals(spotVMOptions, that.spotVMOptions))) {
      return false;
    }
    if (!(Objects.equals(sshPublicKey, that.sshPublicKey))) {
      return false;
    }
    if (!(Objects.equals(subnet, that.subnet))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(ultraSSDCapability, that.ultraSSDCapability))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
      return false;
    }
    if (!(Objects.equals(vmSize, that.vmSize))) {
      return false;
    }
    if (!(Objects.equals(vnet, that.vnet))) {
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
  
  public Boolean getAcceleratedNetworking() {
    return this.acceleratedNetworking;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getApplicationSecurityGroup(int index) {
    return this.applicationSecurityGroups.get(index);
  }
  
  public List<String> getApplicationSecurityGroups() {
    return this.applicationSecurityGroups;
  }
  
  public String getAvailabilitySet() {
    return this.availabilitySet;
  }
  
  public String getCapacityReservationGroupID() {
    return this.capacityReservationGroupID;
  }
  
  public SecretReference getCredentialsSecret() {
    return this.credentialsSecret;
  }
  
  public String getFirstApplicationSecurityGroup() {
    return this.applicationSecurityGroups.get(0);
  }
  
  public String getInternalLoadBalancer() {
    return this.internalLoadBalancer;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastApplicationSecurityGroup() {
    return this.applicationSecurityGroups.get(applicationSecurityGroups.size() - 1);
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public String getManagedIdentity() {
    return this.managedIdentity;
  }
  
  public String getMatchingApplicationSecurityGroup(Predicate<String> predicate) {
      for (String item : applicationSecurityGroups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getNatRule() {
    return this.natRule;
  }
  
  public String getNetworkResourceGroup() {
    return this.networkResourceGroup;
  }
  
  public Boolean getPublicIP() {
    return this.publicIP;
  }
  
  public String getPublicLoadBalancer() {
    return this.publicLoadBalancer;
  }
  
  public String getResourceGroup() {
    return this.resourceGroup;
  }
  
  public String getSecurityGroup() {
    return this.securityGroup;
  }
  
  public String getSshPublicKey() {
    return this.sshPublicKey;
  }
  
  public String getSubnet() {
    return this.subnet;
  }
  
  public Map<String,String> getTags() {
    return this.tags;
  }
  
  public String getUltraSSDCapability() {
    return this.ultraSSDCapability;
  }
  
  public SecretReference getUserDataSecret() {
    return this.userDataSecret;
  }
  
  public String getVmSize() {
    return this.vmSize;
  }
  
  public String getVnet() {
    return this.vnet;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAcceleratedNetworking() {
    return this.acceleratedNetworking != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasApplicationSecurityGroups() {
    return this.applicationSecurityGroups != null && !(this.applicationSecurityGroups.isEmpty());
  }
  
  public boolean hasAvailabilitySet() {
    return this.availabilitySet != null;
  }
  
  public boolean hasCapacityReservationGroupID() {
    return this.capacityReservationGroupID != null;
  }
  
  public boolean hasCredentialsSecret() {
    return this.credentialsSecret != null;
  }
  
  public boolean hasDataDisks() {
    return this.dataDisks != null && !(this.dataDisks.isEmpty());
  }
  
  public boolean hasDiagnostics() {
    return this.diagnostics != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasInternalLoadBalancer() {
    return this.internalLoadBalancer != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLocation() {
    return this.location != null;
  }
  
  public boolean hasManagedIdentity() {
    return this.managedIdentity != null;
  }
  
  public boolean hasMatchingApplicationSecurityGroup(Predicate<String> predicate) {
      for (String item : applicationSecurityGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDataDisk(Predicate<DataDiskBuilder> predicate) {
      for (DataDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNatRule() {
    return this.natRule != null;
  }
  
  public boolean hasNetworkResourceGroup() {
    return this.networkResourceGroup != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasPublicIP() {
    return this.publicIP != null;
  }
  
  public boolean hasPublicLoadBalancer() {
    return this.publicLoadBalancer != null;
  }
  
  public boolean hasResourceGroup() {
    return this.resourceGroup != null;
  }
  
  public boolean hasSecurityGroup() {
    return this.securityGroup != null;
  }
  
  public boolean hasSecurityProfile() {
    return this.securityProfile != null;
  }
  
  public boolean hasSpotVMOptions() {
    return this.spotVMOptions != null;
  }
  
  public boolean hasSshPublicKey() {
    return this.sshPublicKey != null;
  }
  
  public boolean hasSubnet() {
    return this.subnet != null;
  }
  
  public boolean hasTags() {
    return this.tags != null;
  }
  
  public boolean hasUltraSSDCapability() {
    return this.ultraSSDCapability != null;
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public boolean hasVmSize() {
    return this.vmSize != null;
  }
  
  public boolean hasVnet() {
    return this.vnet != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(acceleratedNetworking, apiVersion, applicationSecurityGroups, availabilitySet, capacityReservationGroupID, credentialsSecret, dataDisks, diagnostics, image, internalLoadBalancer, kind, location, managedIdentity, metadata, natRule, networkResourceGroup, osDisk, publicIP, publicLoadBalancer, resourceGroup, securityGroup, securityProfile, spotVMOptions, sshPublicKey, subnet, tags, ultraSSDCapability, userDataSecret, vmSize, vnet, zone, additionalProperties);
  }
  
  public A removeAllFromApplicationSecurityGroups(Collection<String> items) {
    if (this.applicationSecurityGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.applicationSecurityGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromDataDisks(Collection<DataDisk> items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
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
  
  public A removeFromApplicationSecurityGroups(String... items) {
    if (this.applicationSecurityGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.applicationSecurityGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromDataDisks(DataDisk... items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTags(String key) {
    if (this.tags == null) {
      return (A) this;
    }
    if (key != null && this.tags != null) {
      this.tags.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromTags(Map<String,String> map) {
    if (this.tags == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.tags != null) {
          this.tags.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDataDisks(Predicate<DataDiskBuilder> predicate) {
    if (dataDisks == null) {
      return (A) this;
    }
    Iterator<DataDiskBuilder> each = dataDisks.iterator();
    List visitables = _visitables.get("dataDisks");
    while (each.hasNext()) {
        DataDiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DataDisksNested<A> setNewDataDiskLike(int index,DataDisk item) {
    return new DataDisksNested(index, item);
  }
  
  public A setToApplicationSecurityGroups(int index,String item) {
    if (this.applicationSecurityGroups == null) {
      this.applicationSecurityGroups = new ArrayList();
    }
    this.applicationSecurityGroups.set(index, item);
    return (A) this;
  }
  
  public A setToDataDisks(int index,DataDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    DataDiskBuilder builder = new DataDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(acceleratedNetworking == null)) {
        sb.append("acceleratedNetworking:");
        sb.append(acceleratedNetworking);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(applicationSecurityGroups == null) && !(applicationSecurityGroups.isEmpty())) {
        sb.append("applicationSecurityGroups:");
        sb.append(applicationSecurityGroups);
        sb.append(",");
    }
    if (!(availabilitySet == null)) {
        sb.append("availabilitySet:");
        sb.append(availabilitySet);
        sb.append(",");
    }
    if (!(capacityReservationGroupID == null)) {
        sb.append("capacityReservationGroupID:");
        sb.append(capacityReservationGroupID);
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
    if (!(diagnostics == null)) {
        sb.append("diagnostics:");
        sb.append(diagnostics);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(internalLoadBalancer == null)) {
        sb.append("internalLoadBalancer:");
        sb.append(internalLoadBalancer);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(location == null)) {
        sb.append("location:");
        sb.append(location);
        sb.append(",");
    }
    if (!(managedIdentity == null)) {
        sb.append("managedIdentity:");
        sb.append(managedIdentity);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(natRule == null)) {
        sb.append("natRule:");
        sb.append(natRule);
        sb.append(",");
    }
    if (!(networkResourceGroup == null)) {
        sb.append("networkResourceGroup:");
        sb.append(networkResourceGroup);
        sb.append(",");
    }
    if (!(osDisk == null)) {
        sb.append("osDisk:");
        sb.append(osDisk);
        sb.append(",");
    }
    if (!(publicIP == null)) {
        sb.append("publicIP:");
        sb.append(publicIP);
        sb.append(",");
    }
    if (!(publicLoadBalancer == null)) {
        sb.append("publicLoadBalancer:");
        sb.append(publicLoadBalancer);
        sb.append(",");
    }
    if (!(resourceGroup == null)) {
        sb.append("resourceGroup:");
        sb.append(resourceGroup);
        sb.append(",");
    }
    if (!(securityGroup == null)) {
        sb.append("securityGroup:");
        sb.append(securityGroup);
        sb.append(",");
    }
    if (!(securityProfile == null)) {
        sb.append("securityProfile:");
        sb.append(securityProfile);
        sb.append(",");
    }
    if (!(spotVMOptions == null)) {
        sb.append("spotVMOptions:");
        sb.append(spotVMOptions);
        sb.append(",");
    }
    if (!(sshPublicKey == null)) {
        sb.append("sshPublicKey:");
        sb.append(sshPublicKey);
        sb.append(",");
    }
    if (!(subnet == null)) {
        sb.append("subnet:");
        sb.append(subnet);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(ultraSSDCapability == null)) {
        sb.append("ultraSSDCapability:");
        sb.append(ultraSSDCapability);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
        sb.append(",");
    }
    if (!(vmSize == null)) {
        sb.append("vmSize:");
        sb.append(vmSize);
        sb.append(",");
    }
    if (!(vnet == null)) {
        sb.append("vnet:");
        sb.append(vnet);
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
  
  public A withAcceleratedNetworking() {
    return withAcceleratedNetworking(true);
  }
  
  public A withAcceleratedNetworking(Boolean acceleratedNetworking) {
    this.acceleratedNetworking = acceleratedNetworking;
    return (A) this;
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
  
  public A withApplicationSecurityGroups(List<String> applicationSecurityGroups) {
    if (applicationSecurityGroups != null) {
        this.applicationSecurityGroups = new ArrayList();
        for (String item : applicationSecurityGroups) {
          this.addToApplicationSecurityGroups(item);
        }
    } else {
      this.applicationSecurityGroups = null;
    }
    return (A) this;
  }
  
  public A withApplicationSecurityGroups(String... applicationSecurityGroups) {
    if (this.applicationSecurityGroups != null) {
        this.applicationSecurityGroups.clear();
        _visitables.remove("applicationSecurityGroups");
    }
    if (applicationSecurityGroups != null) {
      for (String item : applicationSecurityGroups) {
        this.addToApplicationSecurityGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withAvailabilitySet(String availabilitySet) {
    this.availabilitySet = availabilitySet;
    return (A) this;
  }
  
  public A withCapacityReservationGroupID(String capacityReservationGroupID) {
    this.capacityReservationGroupID = capacityReservationGroupID;
    return (A) this;
  }
  
  public A withCredentialsSecret(SecretReference credentialsSecret) {
    this.credentialsSecret = credentialsSecret;
    return (A) this;
  }
  
  public A withDataDisks(List<DataDisk> dataDisks) {
    if (this.dataDisks != null) {
      this._visitables.get("dataDisks").clear();
    }
    if (dataDisks != null) {
        this.dataDisks = new ArrayList();
        for (DataDisk item : dataDisks) {
          this.addToDataDisks(item);
        }
    } else {
      this.dataDisks = null;
    }
    return (A) this;
  }
  
  public A withDataDisks(DataDisk... dataDisks) {
    if (this.dataDisks != null) {
        this.dataDisks.clear();
        _visitables.remove("dataDisks");
    }
    if (dataDisks != null) {
      for (DataDisk item : dataDisks) {
        this.addToDataDisks(item);
      }
    }
    return (A) this;
  }
  
  public A withDiagnostics(AzureDiagnostics diagnostics) {
    this._visitables.remove("diagnostics");
    if (diagnostics != null) {
        this.diagnostics = new AzureDiagnosticsBuilder(diagnostics);
        this._visitables.get("diagnostics").add(this.diagnostics);
    } else {
        this.diagnostics = null;
        this._visitables.get("diagnostics").remove(this.diagnostics);
    }
    return (A) this;
  }
  
  public A withImage(Image image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new ImageBuilder(image);
        this._visitables.get("image").add(this.image);
    } else {
        this.image = null;
        this._visitables.get("image").remove(this.image);
    }
    return (A) this;
  }
  
  public A withInternalLoadBalancer(String internalLoadBalancer) {
    this.internalLoadBalancer = internalLoadBalancer;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLocation(String location) {
    this.location = location;
    return (A) this;
  }
  
  public A withManagedIdentity(String managedIdentity) {
    this.managedIdentity = managedIdentity;
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
  
  public A withNatRule(Long natRule) {
    this.natRule = natRule;
    return (A) this;
  }
  
  public A withNetworkResourceGroup(String networkResourceGroup) {
    this.networkResourceGroup = networkResourceGroup;
    return (A) this;
  }
  
  public A withNewCredentialsSecret(String name,String namespace) {
    return (A) this.withCredentialsSecret(new SecretReference(name, namespace));
  }
  
  public DiagnosticsNested<A> withNewDiagnostics() {
    return new DiagnosticsNested(null);
  }
  
  public DiagnosticsNested<A> withNewDiagnosticsLike(AzureDiagnostics item) {
    return new DiagnosticsNested(item);
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public ImageNested<A> withNewImageLike(Image item) {
    return new ImageNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public OsDiskNested<A> withNewOsDisk() {
    return new OsDiskNested(null);
  }
  
  public OsDiskNested<A> withNewOsDiskLike(OSDisk item) {
    return new OsDiskNested(item);
  }
  
  public SecurityProfileNested<A> withNewSecurityProfile() {
    return new SecurityProfileNested(null);
  }
  
  public SecurityProfileNested<A> withNewSecurityProfileLike(SecurityProfile item) {
    return new SecurityProfileNested(item);
  }
  
  public SpotVMOptionsNested<A> withNewSpotVMOptions() {
    return new SpotVMOptionsNested(null);
  }
  
  public SpotVMOptionsNested<A> withNewSpotVMOptionsLike(SpotVMOptions item) {
    return new SpotVMOptionsNested(item);
  }
  
  public A withNewUserDataSecret(String name,String namespace) {
    return (A) this.withUserDataSecret(new SecretReference(name, namespace));
  }
  
  public A withOsDisk(OSDisk osDisk) {
    this._visitables.remove("osDisk");
    if (osDisk != null) {
        this.osDisk = new OSDiskBuilder(osDisk);
        this._visitables.get("osDisk").add(this.osDisk);
    } else {
        this.osDisk = null;
        this._visitables.get("osDisk").remove(this.osDisk);
    }
    return (A) this;
  }
  
  public A withPublicIP() {
    return withPublicIP(true);
  }
  
  public A withPublicIP(Boolean publicIP) {
    this.publicIP = publicIP;
    return (A) this;
  }
  
  public A withPublicLoadBalancer(String publicLoadBalancer) {
    this.publicLoadBalancer = publicLoadBalancer;
    return (A) this;
  }
  
  public A withResourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
    return (A) this;
  }
  
  public A withSecurityGroup(String securityGroup) {
    this.securityGroup = securityGroup;
    return (A) this;
  }
  
  public A withSecurityProfile(SecurityProfile securityProfile) {
    this._visitables.remove("securityProfile");
    if (securityProfile != null) {
        this.securityProfile = new SecurityProfileBuilder(securityProfile);
        this._visitables.get("securityProfile").add(this.securityProfile);
    } else {
        this.securityProfile = null;
        this._visitables.get("securityProfile").remove(this.securityProfile);
    }
    return (A) this;
  }
  
  public A withSpotVMOptions(SpotVMOptions spotVMOptions) {
    this._visitables.remove("spotVMOptions");
    if (spotVMOptions != null) {
        this.spotVMOptions = new SpotVMOptionsBuilder(spotVMOptions);
        this._visitables.get("spotVMOptions").add(this.spotVMOptions);
    } else {
        this.spotVMOptions = null;
        this._visitables.get("spotVMOptions").remove(this.spotVMOptions);
    }
    return (A) this;
  }
  
  public A withSshPublicKey(String sshPublicKey) {
    this.sshPublicKey = sshPublicKey;
    return (A) this;
  }
  
  public A withSubnet(String subnet) {
    this.subnet = subnet;
    return (A) this;
  }
  
  public <K,V>A withTags(Map<String,String> tags) {
    if (tags == null) {
      this.tags = null;
    } else {
      this.tags = new LinkedHashMap(tags);
    }
    return (A) this;
  }
  
  public A withUltraSSDCapability(String ultraSSDCapability) {
    this.ultraSSDCapability = ultraSSDCapability;
    return (A) this;
  }
  
  public A withUserDataSecret(SecretReference userDataSecret) {
    this.userDataSecret = userDataSecret;
    return (A) this;
  }
  
  public A withVmSize(String vmSize) {
    this.vmSize = vmSize;
    return (A) this;
  }
  
  public A withVnet(String vnet) {
    this.vnet = vnet;
    return (A) this;
  }
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  public class DataDisksNested<N> extends DataDiskFluent<DataDisksNested<N>> implements Nested<N>{
  
    DataDiskBuilder builder;
    int index;
  
    DataDisksNested(int index,DataDisk item) {
      this.index = index;
      this.builder = new DataDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureMachineProviderSpecFluent.this.setToDataDisks(index, builder.build());
    }
    
    public N endDataDisk() {
      return and();
    }
    
  }
  public class DiagnosticsNested<N> extends AzureDiagnosticsFluent<DiagnosticsNested<N>> implements Nested<N>{
  
    AzureDiagnosticsBuilder builder;
  
    DiagnosticsNested(AzureDiagnostics item) {
      this.builder = new AzureDiagnosticsBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureMachineProviderSpecFluent.this.withDiagnostics(builder.build());
    }
    
    public N endDiagnostics() {
      return and();
    }
    
  }
  public class ImageNested<N> extends ImageFluent<ImageNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
  
    ImageNested(Image item) {
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureMachineProviderSpecFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureMachineProviderSpecFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class OsDiskNested<N> extends OSDiskFluent<OsDiskNested<N>> implements Nested<N>{
  
    OSDiskBuilder builder;
  
    OsDiskNested(OSDisk item) {
      this.builder = new OSDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureMachineProviderSpecFluent.this.withOsDisk(builder.build());
    }
    
    public N endOsDisk() {
      return and();
    }
    
  }
  public class SecurityProfileNested<N> extends SecurityProfileFluent<SecurityProfileNested<N>> implements Nested<N>{
  
    SecurityProfileBuilder builder;
  
    SecurityProfileNested(SecurityProfile item) {
      this.builder = new SecurityProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureMachineProviderSpecFluent.this.withSecurityProfile(builder.build());
    }
    
    public N endSecurityProfile() {
      return and();
    }
    
  }
  public class SpotVMOptionsNested<N> extends SpotVMOptionsFluent<SpotVMOptionsNested<N>> implements Nested<N>{
  
    SpotVMOptionsBuilder builder;
  
    SpotVMOptionsNested(SpotVMOptions item) {
      this.builder = new SpotVMOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureMachineProviderSpecFluent.this.withSpotVMOptions(builder.build());
    }
    
    public N endSpotVMOptions() {
      return and();
    }
    
  }
}