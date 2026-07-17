package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
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
public class OpenstackProviderSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.OpenstackProviderSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<AdditionalBlockDeviceBuilder> additionalBlockDevices = new ArrayList<AdditionalBlockDeviceBuilder>();
  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String availabilityZone;
  private String cloudName;
  private SecretReference cloudsSecret;
  private Boolean configDrive;
  private String flavor;
  private String floatingIP;
  private String image;
  private String keyName;
  private String kind;
  private ObjectMetaBuilder metadata;
  private ArrayList<NetworkParamBuilder> networks = new ArrayList<NetworkParamBuilder>();
  private ArrayList<PortOptsBuilder> ports = new ArrayList<PortOptsBuilder>();
  private String primarySubnet;
  private RootVolumeBuilder rootVolume;
  private ArrayList<SecurityGroupParamBuilder> securityGroups = new ArrayList<SecurityGroupParamBuilder>();
  private String serverGroupID;
  private String serverGroupName;
  private Map<String,String> serverMetadata;
  private String sshUserName;
  private List<String> tags = new ArrayList<String>();
  private Boolean trunk;
  private SecretReference userDataSecret;

  public OpenstackProviderSpecFluent() {
  }
  
  public OpenstackProviderSpecFluent(OpenstackProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalBlockDevices(Collection<AdditionalBlockDevice> items) {
    if (this.additionalBlockDevices == null) {
      this.additionalBlockDevices = new ArrayList();
    }
    for (AdditionalBlockDevice item : items) {
        AdditionalBlockDeviceBuilder builder = new AdditionalBlockDeviceBuilder(item);
        _visitables.get("additionalBlockDevices").add(builder);
        this.additionalBlockDevices.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNetworks(Collection<NetworkParam> items) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    for (NetworkParam item : items) {
        NetworkParamBuilder builder = new NetworkParamBuilder(item);
        _visitables.get("networks").add(builder);
        this.networks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPorts(Collection<PortOpts> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (PortOpts item : items) {
        PortOptsBuilder builder = new PortOptsBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecurityGroups(Collection<SecurityGroupParam> items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (SecurityGroupParam item : items) {
        SecurityGroupParamBuilder builder = new SecurityGroupParamBuilder(item);
        _visitables.get("securityGroups").add(builder);
        this.securityGroups.add(builder);
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
  
  public AdditionalBlockDevicesNested<A> addNewAdditionalBlockDevice() {
    return new AdditionalBlockDevicesNested(-1, null);
  }
  
  public AdditionalBlockDevicesNested<A> addNewAdditionalBlockDeviceLike(AdditionalBlockDevice item) {
    return new AdditionalBlockDevicesNested(-1, item);
  }
  
  public NetworksNested<A> addNewNetwork() {
    return new NetworksNested(-1, null);
  }
  
  public NetworksNested<A> addNewNetworkLike(NetworkParam item) {
    return new NetworksNested(-1, item);
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public PortsNested<A> addNewPortLike(PortOpts item) {
    return new PortsNested(-1, item);
  }
  
  public SecurityGroupsNested<A> addNewSecurityGroup() {
    return new SecurityGroupsNested(-1, null);
  }
  
  public SecurityGroupsNested<A> addNewSecurityGroupLike(SecurityGroupParam item) {
    return new SecurityGroupsNested(-1, item);
  }
  
  public A addToAdditionalBlockDevices(AdditionalBlockDevice... items) {
    if (this.additionalBlockDevices == null) {
      this.additionalBlockDevices = new ArrayList();
    }
    for (AdditionalBlockDevice item : items) {
        AdditionalBlockDeviceBuilder builder = new AdditionalBlockDeviceBuilder(item);
        _visitables.get("additionalBlockDevices").add(builder);
        this.additionalBlockDevices.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalBlockDevices(int index,AdditionalBlockDevice item) {
    if (this.additionalBlockDevices == null) {
      this.additionalBlockDevices = new ArrayList();
    }
    AdditionalBlockDeviceBuilder builder = new AdditionalBlockDeviceBuilder(item);
    if (index < 0 || index >= additionalBlockDevices.size()) {
        _visitables.get("additionalBlockDevices").add(builder);
        additionalBlockDevices.add(builder);
    } else {
        _visitables.get("additionalBlockDevices").add(builder);
        additionalBlockDevices.add(index, builder);
    }
    return (A) this;
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
  
  public A addToNetworks(NetworkParam... items) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    for (NetworkParam item : items) {
        NetworkParamBuilder builder = new NetworkParamBuilder(item);
        _visitables.get("networks").add(builder);
        this.networks.add(builder);
    }
    return (A) this;
  }
  
  public A addToNetworks(int index,NetworkParam item) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    NetworkParamBuilder builder = new NetworkParamBuilder(item);
    if (index < 0 || index >= networks.size()) {
        _visitables.get("networks").add(builder);
        networks.add(builder);
    } else {
        _visitables.get("networks").add(builder);
        networks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPorts(PortOpts... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (PortOpts item : items) {
        PortOptsBuilder builder = new PortOptsBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,PortOpts item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    PortOptsBuilder builder = new PortOptsBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSecurityGroups(SecurityGroupParam... items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (SecurityGroupParam item : items) {
        SecurityGroupParamBuilder builder = new SecurityGroupParamBuilder(item);
        _visitables.get("securityGroups").add(builder);
        this.securityGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecurityGroups(int index,SecurityGroupParam item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    SecurityGroupParamBuilder builder = new SecurityGroupParamBuilder(item);
    if (index < 0 || index >= securityGroups.size()) {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(builder);
    } else {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToServerMetadata(Map<String,String> map) {
    if (this.serverMetadata == null && map != null) {
      this.serverMetadata = new LinkedHashMap();
    }
    if (map != null) {
      this.serverMetadata.putAll(map);
    }
    return (A) this;
  }
  
  public A addToServerMetadata(String key,String value) {
    if (this.serverMetadata == null && key != null && value != null) {
      this.serverMetadata = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.serverMetadata.put(key, value);
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
  
  public AdditionalBlockDevice buildAdditionalBlockDevice(int index) {
    return this.additionalBlockDevices.get(index).build();
  }
  
  public List<AdditionalBlockDevice> buildAdditionalBlockDevices() {
    return this.additionalBlockDevices != null ? build(additionalBlockDevices) : null;
  }
  
  public AdditionalBlockDevice buildFirstAdditionalBlockDevice() {
    return this.additionalBlockDevices.get(0).build();
  }
  
  public NetworkParam buildFirstNetwork() {
    return this.networks.get(0).build();
  }
  
  public PortOpts buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public SecurityGroupParam buildFirstSecurityGroup() {
    return this.securityGroups.get(0).build();
  }
  
  public AdditionalBlockDevice buildLastAdditionalBlockDevice() {
    return this.additionalBlockDevices.get(additionalBlockDevices.size() - 1).build();
  }
  
  public NetworkParam buildLastNetwork() {
    return this.networks.get(networks.size() - 1).build();
  }
  
  public PortOpts buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public SecurityGroupParam buildLastSecurityGroup() {
    return this.securityGroups.get(securityGroups.size() - 1).build();
  }
  
  public AdditionalBlockDevice buildMatchingAdditionalBlockDevice(Predicate<AdditionalBlockDeviceBuilder> predicate) {
      for (AdditionalBlockDeviceBuilder item : additionalBlockDevices) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkParam buildMatchingNetwork(Predicate<NetworkParamBuilder> predicate) {
      for (NetworkParamBuilder item : networks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PortOpts buildMatchingPort(Predicate<PortOptsBuilder> predicate) {
      for (PortOptsBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecurityGroupParam buildMatchingSecurityGroup(Predicate<SecurityGroupParamBuilder> predicate) {
      for (SecurityGroupParamBuilder item : securityGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public NetworkParam buildNetwork(int index) {
    return this.networks.get(index).build();
  }
  
  public List<NetworkParam> buildNetworks() {
    return this.networks != null ? build(networks) : null;
  }
  
  public PortOpts buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<PortOpts> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  public RootVolume buildRootVolume() {
    return this.rootVolume != null ? this.rootVolume.build() : null;
  }
  
  public SecurityGroupParam buildSecurityGroup(int index) {
    return this.securityGroups.get(index).build();
  }
  
  public List<SecurityGroupParam> buildSecurityGroups() {
    return this.securityGroups != null ? build(securityGroups) : null;
  }
  
  protected void copyInstance(OpenstackProviderSpec instance) {
    instance = instance != null ? instance : new OpenstackProviderSpec();
    if (instance != null) {
        this.withAdditionalBlockDevices(instance.getAdditionalBlockDevices());
        this.withApiVersion(instance.getApiVersion());
        this.withAvailabilityZone(instance.getAvailabilityZone());
        this.withCloudName(instance.getCloudName());
        this.withCloudsSecret(instance.getCloudsSecret());
        this.withConfigDrive(instance.getConfigDrive());
        this.withFlavor(instance.getFlavor());
        this.withFloatingIP(instance.getFloatingIP());
        this.withImage(instance.getImage());
        this.withKeyName(instance.getKeyName());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withNetworks(instance.getNetworks());
        this.withPorts(instance.getPorts());
        this.withPrimarySubnet(instance.getPrimarySubnet());
        this.withRootVolume(instance.getRootVolume());
        this.withSecurityGroups(instance.getSecurityGroups());
        this.withServerGroupID(instance.getServerGroupID());
        this.withServerGroupName(instance.getServerGroupName());
        this.withServerMetadata(instance.getServerMetadata());
        this.withSshUserName(instance.getSshUserName());
        this.withTags(instance.getTags());
        this.withTrunk(instance.getTrunk());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalBlockDevicesNested<A> editAdditionalBlockDevice(int index) {
    if (additionalBlockDevices.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalBlockDevices"));
    }
    return this.setNewAdditionalBlockDeviceLike(index, this.buildAdditionalBlockDevice(index));
  }
  
  public AdditionalBlockDevicesNested<A> editFirstAdditionalBlockDevice() {
    if (additionalBlockDevices.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalBlockDevices"));
    }
    return this.setNewAdditionalBlockDeviceLike(0, this.buildAdditionalBlockDevice(0));
  }
  
  public NetworksNested<A> editFirstNetwork() {
    if (networks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "networks"));
    }
    return this.setNewNetworkLike(0, this.buildNetwork(0));
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public SecurityGroupsNested<A> editFirstSecurityGroup() {
    if (securityGroups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(0, this.buildSecurityGroup(0));
  }
  
  public AdditionalBlockDevicesNested<A> editLastAdditionalBlockDevice() {
    int index = additionalBlockDevices.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalBlockDevices"));
    }
    return this.setNewAdditionalBlockDeviceLike(index, this.buildAdditionalBlockDevice(index));
  }
  
  public NetworksNested<A> editLastNetwork() {
    int index = networks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "networks"));
    }
    return this.setNewNetworkLike(index, this.buildNetwork(index));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public SecurityGroupsNested<A> editLastSecurityGroup() {
    int index = securityGroups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
  }
  
  public AdditionalBlockDevicesNested<A> editMatchingAdditionalBlockDevice(Predicate<AdditionalBlockDeviceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalBlockDevices.size();i++) {
      if (predicate.test(additionalBlockDevices.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalBlockDevices"));
    }
    return this.setNewAdditionalBlockDeviceLike(index, this.buildAdditionalBlockDevice(index));
  }
  
  public NetworksNested<A> editMatchingNetwork(Predicate<NetworkParamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < networks.size();i++) {
      if (predicate.test(networks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "networks"));
    }
    return this.setNewNetworkLike(index, this.buildNetwork(index));
  }
  
  public PortsNested<A> editMatchingPort(Predicate<PortOptsBuilder> predicate) {
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
  
  public SecurityGroupsNested<A> editMatchingSecurityGroup(Predicate<SecurityGroupParamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < securityGroups.size();i++) {
      if (predicate.test(securityGroups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public NetworksNested<A> editNetwork(int index) {
    if (networks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "networks"));
    }
    return this.setNewNetworkLike(index, this.buildNetwork(index));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public RootVolumeNested<A> editOrNewRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(new RootVolumeBuilder().build()));
  }
  
  public RootVolumeNested<A> editOrNewRootVolumeLike(RootVolume item) {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(item));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public RootVolumeNested<A> editRootVolume() {
    return this.withNewRootVolumeLike(Optional.ofNullable(this.buildRootVolume()).orElse(null));
  }
  
  public SecurityGroupsNested<A> editSecurityGroup(int index) {
    if (securityGroups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "securityGroups"));
    }
    return this.setNewSecurityGroupLike(index, this.buildSecurityGroup(index));
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
    OpenstackProviderSpecFluent that = (OpenstackProviderSpecFluent) o;
    if (!(Objects.equals(additionalBlockDevices, that.additionalBlockDevices))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(availabilityZone, that.availabilityZone))) {
      return false;
    }
    if (!(Objects.equals(cloudName, that.cloudName))) {
      return false;
    }
    if (!(Objects.equals(cloudsSecret, that.cloudsSecret))) {
      return false;
    }
    if (!(Objects.equals(configDrive, that.configDrive))) {
      return false;
    }
    if (!(Objects.equals(flavor, that.flavor))) {
      return false;
    }
    if (!(Objects.equals(floatingIP, that.floatingIP))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(keyName, that.keyName))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(networks, that.networks))) {
      return false;
    }
    if (!(Objects.equals(ports, that.ports))) {
      return false;
    }
    if (!(Objects.equals(primarySubnet, that.primarySubnet))) {
      return false;
    }
    if (!(Objects.equals(rootVolume, that.rootVolume))) {
      return false;
    }
    if (!(Objects.equals(securityGroups, that.securityGroups))) {
      return false;
    }
    if (!(Objects.equals(serverGroupID, that.serverGroupID))) {
      return false;
    }
    if (!(Objects.equals(serverGroupName, that.serverGroupName))) {
      return false;
    }
    if (!(Objects.equals(serverMetadata, that.serverMetadata))) {
      return false;
    }
    if (!(Objects.equals(sshUserName, that.sshUserName))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(trunk, that.trunk))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
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
  
  public String getAvailabilityZone() {
    return this.availabilityZone;
  }
  
  public String getCloudName() {
    return this.cloudName;
  }
  
  public SecretReference getCloudsSecret() {
    return this.cloudsSecret;
  }
  
  public Boolean getConfigDrive() {
    return this.configDrive;
  }
  
  public String getFirstTag() {
    return this.tags.get(0);
  }
  
  public String getFlavor() {
    return this.flavor;
  }
  
  public String getFloatingIP() {
    return this.floatingIP;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getKeyName() {
    return this.keyName;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastTag() {
    return this.tags.get(tags.size() - 1);
  }
  
  public String getMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPrimarySubnet() {
    return this.primarySubnet;
  }
  
  public String getServerGroupID() {
    return this.serverGroupID;
  }
  
  public String getServerGroupName() {
    return this.serverGroupName;
  }
  
  public Map<String,String> getServerMetadata() {
    return this.serverMetadata;
  }
  
  public String getSshUserName() {
    return this.sshUserName;
  }
  
  public String getTag(int index) {
    return this.tags.get(index);
  }
  
  public List<String> getTags() {
    return this.tags;
  }
  
  public Boolean getTrunk() {
    return this.trunk;
  }
  
  public SecretReference getUserDataSecret() {
    return this.userDataSecret;
  }
  
  public boolean hasAdditionalBlockDevices() {
    return this.additionalBlockDevices != null && !(this.additionalBlockDevices.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasAvailabilityZone() {
    return this.availabilityZone != null;
  }
  
  public boolean hasCloudName() {
    return this.cloudName != null;
  }
  
  public boolean hasCloudsSecret() {
    return this.cloudsSecret != null;
  }
  
  public boolean hasConfigDrive() {
    return this.configDrive != null;
  }
  
  public boolean hasFlavor() {
    return this.flavor != null;
  }
  
  public boolean hasFloatingIP() {
    return this.floatingIP != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasKeyName() {
    return this.keyName != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingAdditionalBlockDevice(Predicate<AdditionalBlockDeviceBuilder> predicate) {
      for (AdditionalBlockDeviceBuilder item : additionalBlockDevices) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNetwork(Predicate<NetworkParamBuilder> predicate) {
      for (NetworkParamBuilder item : networks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPort(Predicate<PortOptsBuilder> predicate) {
      for (PortOptsBuilder item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecurityGroup(Predicate<SecurityGroupParamBuilder> predicate) {
      for (SecurityGroupParamBuilder item : securityGroups) {
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
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNetworks() {
    return this.networks != null && !(this.networks.isEmpty());
  }
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public boolean hasPrimarySubnet() {
    return this.primarySubnet != null;
  }
  
  public boolean hasRootVolume() {
    return this.rootVolume != null;
  }
  
  public boolean hasSecurityGroups() {
    return this.securityGroups != null && !(this.securityGroups.isEmpty());
  }
  
  public boolean hasServerGroupID() {
    return this.serverGroupID != null;
  }
  
  public boolean hasServerGroupName() {
    return this.serverGroupName != null;
  }
  
  public boolean hasServerMetadata() {
    return this.serverMetadata != null;
  }
  
  public boolean hasSshUserName() {
    return this.sshUserName != null;
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public boolean hasTrunk() {
    return this.trunk != null;
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalBlockDevices, apiVersion, availabilityZone, cloudName, cloudsSecret, configDrive, flavor, floatingIP, image, keyName, kind, metadata, networks, ports, primarySubnet, rootVolume, securityGroups, serverGroupID, serverGroupName, serverMetadata, sshUserName, tags, trunk, userDataSecret, additionalProperties);
  }
  
  public A removeAllFromAdditionalBlockDevices(Collection<AdditionalBlockDevice> items) {
    if (this.additionalBlockDevices == null) {
      return (A) this;
    }
    for (AdditionalBlockDevice item : items) {
        AdditionalBlockDeviceBuilder builder = new AdditionalBlockDeviceBuilder(item);
        _visitables.get("additionalBlockDevices").remove(builder);
        this.additionalBlockDevices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNetworks(Collection<NetworkParam> items) {
    if (this.networks == null) {
      return (A) this;
    }
    for (NetworkParam item : items) {
        NetworkParamBuilder builder = new NetworkParamBuilder(item);
        _visitables.get("networks").remove(builder);
        this.networks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPorts(Collection<PortOpts> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (PortOpts item : items) {
        PortOptsBuilder builder = new PortOptsBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecurityGroups(Collection<SecurityGroupParam> items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (SecurityGroupParam item : items) {
        SecurityGroupParamBuilder builder = new SecurityGroupParamBuilder(item);
        _visitables.get("securityGroups").remove(builder);
        this.securityGroups.remove(builder);
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
  
  public A removeFromAdditionalBlockDevices(AdditionalBlockDevice... items) {
    if (this.additionalBlockDevices == null) {
      return (A) this;
    }
    for (AdditionalBlockDevice item : items) {
        AdditionalBlockDeviceBuilder builder = new AdditionalBlockDeviceBuilder(item);
        _visitables.get("additionalBlockDevices").remove(builder);
        this.additionalBlockDevices.remove(builder);
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
  
  public A removeFromNetworks(NetworkParam... items) {
    if (this.networks == null) {
      return (A) this;
    }
    for (NetworkParam item : items) {
        NetworkParamBuilder builder = new NetworkParamBuilder(item);
        _visitables.get("networks").remove(builder);
        this.networks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPorts(PortOpts... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (PortOpts item : items) {
        PortOptsBuilder builder = new PortOptsBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSecurityGroups(SecurityGroupParam... items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (SecurityGroupParam item : items) {
        SecurityGroupParamBuilder builder = new SecurityGroupParamBuilder(item);
        _visitables.get("securityGroups").remove(builder);
        this.securityGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromServerMetadata(String key) {
    if (this.serverMetadata == null) {
      return (A) this;
    }
    if (key != null && this.serverMetadata != null) {
      this.serverMetadata.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromServerMetadata(Map<String,String> map) {
    if (this.serverMetadata == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.serverMetadata != null) {
          this.serverMetadata.remove(key);
        }
      }
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
  
  public A removeMatchingFromAdditionalBlockDevices(Predicate<AdditionalBlockDeviceBuilder> predicate) {
    if (additionalBlockDevices == null) {
      return (A) this;
    }
    Iterator<AdditionalBlockDeviceBuilder> each = additionalBlockDevices.iterator();
    List visitables = _visitables.get("additionalBlockDevices");
    while (each.hasNext()) {
        AdditionalBlockDeviceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromNetworks(Predicate<NetworkParamBuilder> predicate) {
    if (networks == null) {
      return (A) this;
    }
    Iterator<NetworkParamBuilder> each = networks.iterator();
    List visitables = _visitables.get("networks");
    while (each.hasNext()) {
        NetworkParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPorts(Predicate<PortOptsBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<PortOptsBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        PortOptsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecurityGroups(Predicate<SecurityGroupParamBuilder> predicate) {
    if (securityGroups == null) {
      return (A) this;
    }
    Iterator<SecurityGroupParamBuilder> each = securityGroups.iterator();
    List visitables = _visitables.get("securityGroups");
    while (each.hasNext()) {
        SecurityGroupParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalBlockDevicesNested<A> setNewAdditionalBlockDeviceLike(int index,AdditionalBlockDevice item) {
    return new AdditionalBlockDevicesNested(index, item);
  }
  
  public NetworksNested<A> setNewNetworkLike(int index,NetworkParam item) {
    return new NetworksNested(index, item);
  }
  
  public PortsNested<A> setNewPortLike(int index,PortOpts item) {
    return new PortsNested(index, item);
  }
  
  public SecurityGroupsNested<A> setNewSecurityGroupLike(int index,SecurityGroupParam item) {
    return new SecurityGroupsNested(index, item);
  }
  
  public A setToAdditionalBlockDevices(int index,AdditionalBlockDevice item) {
    if (this.additionalBlockDevices == null) {
      this.additionalBlockDevices = new ArrayList();
    }
    AdditionalBlockDeviceBuilder builder = new AdditionalBlockDeviceBuilder(item);
    if (index < 0 || index >= additionalBlockDevices.size()) {
        _visitables.get("additionalBlockDevices").add(builder);
        additionalBlockDevices.add(builder);
    } else {
        _visitables.get("additionalBlockDevices").add(builder);
        additionalBlockDevices.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNetworks(int index,NetworkParam item) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    NetworkParamBuilder builder = new NetworkParamBuilder(item);
    if (index < 0 || index >= networks.size()) {
        _visitables.get("networks").add(builder);
        networks.add(builder);
    } else {
        _visitables.get("networks").add(builder);
        networks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPorts(int index,PortOpts item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    PortOptsBuilder builder = new PortOptsBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecurityGroups(int index,SecurityGroupParam item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    SecurityGroupParamBuilder builder = new SecurityGroupParamBuilder(item);
    if (index < 0 || index >= securityGroups.size()) {
        _visitables.get("securityGroups").add(builder);
        securityGroups.add(builder);
    } else {
        _visitables.get("securityGroups").add(builder);
        securityGroups.set(index, builder);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalBlockDevices == null) && !(additionalBlockDevices.isEmpty())) {
        sb.append("additionalBlockDevices:");
        sb.append(additionalBlockDevices);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(availabilityZone == null)) {
        sb.append("availabilityZone:");
        sb.append(availabilityZone);
        sb.append(",");
    }
    if (!(cloudName == null)) {
        sb.append("cloudName:");
        sb.append(cloudName);
        sb.append(",");
    }
    if (!(cloudsSecret == null)) {
        sb.append("cloudsSecret:");
        sb.append(cloudsSecret);
        sb.append(",");
    }
    if (!(configDrive == null)) {
        sb.append("configDrive:");
        sb.append(configDrive);
        sb.append(",");
    }
    if (!(flavor == null)) {
        sb.append("flavor:");
        sb.append(flavor);
        sb.append(",");
    }
    if (!(floatingIP == null)) {
        sb.append("floatingIP:");
        sb.append(floatingIP);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(keyName == null)) {
        sb.append("keyName:");
        sb.append(keyName);
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
    if (!(networks == null) && !(networks.isEmpty())) {
        sb.append("networks:");
        sb.append(networks);
        sb.append(",");
    }
    if (!(ports == null) && !(ports.isEmpty())) {
        sb.append("ports:");
        sb.append(ports);
        sb.append(",");
    }
    if (!(primarySubnet == null)) {
        sb.append("primarySubnet:");
        sb.append(primarySubnet);
        sb.append(",");
    }
    if (!(rootVolume == null)) {
        sb.append("rootVolume:");
        sb.append(rootVolume);
        sb.append(",");
    }
    if (!(securityGroups == null) && !(securityGroups.isEmpty())) {
        sb.append("securityGroups:");
        sb.append(securityGroups);
        sb.append(",");
    }
    if (!(serverGroupID == null)) {
        sb.append("serverGroupID:");
        sb.append(serverGroupID);
        sb.append(",");
    }
    if (!(serverGroupName == null)) {
        sb.append("serverGroupName:");
        sb.append(serverGroupName);
        sb.append(",");
    }
    if (!(serverMetadata == null) && !(serverMetadata.isEmpty())) {
        sb.append("serverMetadata:");
        sb.append(serverMetadata);
        sb.append(",");
    }
    if (!(sshUserName == null)) {
        sb.append("sshUserName:");
        sb.append(sshUserName);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(trunk == null)) {
        sb.append("trunk:");
        sb.append(trunk);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalBlockDevices(List<AdditionalBlockDevice> additionalBlockDevices) {
    if (this.additionalBlockDevices != null) {
      this._visitables.get("additionalBlockDevices").clear();
    }
    if (additionalBlockDevices != null) {
        this.additionalBlockDevices = new ArrayList();
        for (AdditionalBlockDevice item : additionalBlockDevices) {
          this.addToAdditionalBlockDevices(item);
        }
    } else {
      this.additionalBlockDevices = null;
    }
    return (A) this;
  }
  
  public A withAdditionalBlockDevices(AdditionalBlockDevice... additionalBlockDevices) {
    if (this.additionalBlockDevices != null) {
        this.additionalBlockDevices.clear();
        _visitables.remove("additionalBlockDevices");
    }
    if (additionalBlockDevices != null) {
      for (AdditionalBlockDevice item : additionalBlockDevices) {
        this.addToAdditionalBlockDevices(item);
      }
    }
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
  
  public A withAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return (A) this;
  }
  
  public A withCloudName(String cloudName) {
    this.cloudName = cloudName;
    return (A) this;
  }
  
  public A withCloudsSecret(SecretReference cloudsSecret) {
    this.cloudsSecret = cloudsSecret;
    return (A) this;
  }
  
  public A withConfigDrive() {
    return withConfigDrive(true);
  }
  
  public A withConfigDrive(Boolean configDrive) {
    this.configDrive = configDrive;
    return (A) this;
  }
  
  public A withFlavor(String flavor) {
    this.flavor = flavor;
    return (A) this;
  }
  
  public A withFloatingIP(String floatingIP) {
    this.floatingIP = floatingIP;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withKeyName(String keyName) {
    this.keyName = keyName;
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
  
  public A withNetworks(List<NetworkParam> networks) {
    if (this.networks != null) {
      this._visitables.get("networks").clear();
    }
    if (networks != null) {
        this.networks = new ArrayList();
        for (NetworkParam item : networks) {
          this.addToNetworks(item);
        }
    } else {
      this.networks = null;
    }
    return (A) this;
  }
  
  public A withNetworks(NetworkParam... networks) {
    if (this.networks != null) {
        this.networks.clear();
        _visitables.remove("networks");
    }
    if (networks != null) {
      for (NetworkParam item : networks) {
        this.addToNetworks(item);
      }
    }
    return (A) this;
  }
  
  public A withNewCloudsSecret(String name,String namespace) {
    return (A) this.withCloudsSecret(new SecretReference(name, namespace));
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public RootVolumeNested<A> withNewRootVolume() {
    return new RootVolumeNested(null);
  }
  
  public RootVolumeNested<A> withNewRootVolumeLike(RootVolume item) {
    return new RootVolumeNested(item);
  }
  
  public A withNewUserDataSecret(String name,String namespace) {
    return (A) this.withUserDataSecret(new SecretReference(name, namespace));
  }
  
  public A withPorts(List<PortOpts> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (PortOpts item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(PortOpts... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (PortOpts item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withPrimarySubnet(String primarySubnet) {
    this.primarySubnet = primarySubnet;
    return (A) this;
  }
  
  public A withRootVolume(RootVolume rootVolume) {
    this._visitables.remove("rootVolume");
    if (rootVolume != null) {
        this.rootVolume = new RootVolumeBuilder(rootVolume);
        this._visitables.get("rootVolume").add(this.rootVolume);
    } else {
        this.rootVolume = null;
        this._visitables.get("rootVolume").remove(this.rootVolume);
    }
    return (A) this;
  }
  
  public A withSecurityGroups(List<SecurityGroupParam> securityGroups) {
    if (this.securityGroups != null) {
      this._visitables.get("securityGroups").clear();
    }
    if (securityGroups != null) {
        this.securityGroups = new ArrayList();
        for (SecurityGroupParam item : securityGroups) {
          this.addToSecurityGroups(item);
        }
    } else {
      this.securityGroups = null;
    }
    return (A) this;
  }
  
  public A withSecurityGroups(SecurityGroupParam... securityGroups) {
    if (this.securityGroups != null) {
        this.securityGroups.clear();
        _visitables.remove("securityGroups");
    }
    if (securityGroups != null) {
      for (SecurityGroupParam item : securityGroups) {
        this.addToSecurityGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withServerGroupID(String serverGroupID) {
    this.serverGroupID = serverGroupID;
    return (A) this;
  }
  
  public A withServerGroupName(String serverGroupName) {
    this.serverGroupName = serverGroupName;
    return (A) this;
  }
  
  public <K,V>A withServerMetadata(Map<String,String> serverMetadata) {
    if (serverMetadata == null) {
      this.serverMetadata = null;
    } else {
      this.serverMetadata = new LinkedHashMap(serverMetadata);
    }
    return (A) this;
  }
  
  public A withSshUserName(String sshUserName) {
    this.sshUserName = sshUserName;
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
  
  public A withTrunk() {
    return withTrunk(true);
  }
  
  public A withTrunk(Boolean trunk) {
    this.trunk = trunk;
    return (A) this;
  }
  
  public A withUserDataSecret(SecretReference userDataSecret) {
    this.userDataSecret = userDataSecret;
    return (A) this;
  }
  public class AdditionalBlockDevicesNested<N> extends AdditionalBlockDeviceFluent<AdditionalBlockDevicesNested<N>> implements Nested<N>{
  
    AdditionalBlockDeviceBuilder builder;
    int index;
  
    AdditionalBlockDevicesNested(int index,AdditionalBlockDevice item) {
      this.index = index;
      this.builder = new AdditionalBlockDeviceBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenstackProviderSpecFluent.this.setToAdditionalBlockDevices(index, builder.build());
    }
    
    public N endAdditionalBlockDevice() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenstackProviderSpecFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class NetworksNested<N> extends NetworkParamFluent<NetworksNested<N>> implements Nested<N>{
  
    NetworkParamBuilder builder;
    int index;
  
    NetworksNested(int index,NetworkParam item) {
      this.index = index;
      this.builder = new NetworkParamBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenstackProviderSpecFluent.this.setToNetworks(index, builder.build());
    }
    
    public N endNetwork() {
      return and();
    }
    
  }
  public class PortsNested<N> extends PortOptsFluent<PortsNested<N>> implements Nested<N>{
  
    PortOptsBuilder builder;
    int index;
  
    PortsNested(int index,PortOpts item) {
      this.index = index;
      this.builder = new PortOptsBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenstackProviderSpecFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class RootVolumeNested<N> extends RootVolumeFluent<RootVolumeNested<N>> implements Nested<N>{
  
    RootVolumeBuilder builder;
  
    RootVolumeNested(RootVolume item) {
      this.builder = new RootVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenstackProviderSpecFluent.this.withRootVolume(builder.build());
    }
    
    public N endRootVolume() {
      return and();
    }
    
  }
  public class SecurityGroupsNested<N> extends SecurityGroupParamFluent<SecurityGroupsNested<N>> implements Nested<N>{
  
    SecurityGroupParamBuilder builder;
    int index;
  
    SecurityGroupsNested(int index,SecurityGroupParam item) {
      this.index = index;
      this.builder = new SecurityGroupParamBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenstackProviderSpecFluent.this.setToSecurityGroups(index, builder.build());
    }
    
    public N endSecurityGroup() {
      return and();
    }
    
  }
}