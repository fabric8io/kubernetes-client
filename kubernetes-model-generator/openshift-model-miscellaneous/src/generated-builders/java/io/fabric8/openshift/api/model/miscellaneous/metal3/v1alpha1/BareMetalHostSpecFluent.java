package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Taint;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class BareMetalHostSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String architecture;
  private String automatedCleaningMode;
  private BMCDetailsBuilder bmc;
  private String bootMACAddress;
  private String bootMode;
  private ObjectReferenceBuilder consumerRef;
  private CustomDeployBuilder customDeploy;
  private String description;
  private Boolean disablePowerOff;
  private Boolean externallyProvisioned;
  private FirmwareConfigBuilder firmware;
  private String hardwareProfile;
  private ImageBuilder image;
  private String inspectionMode;
  private SecretReference metaData;
  private SecretReference networkData;
  private Boolean online;
  private String preprovisioningNetworkDataName;
  private RAIDConfigBuilder raid;
  private RootDeviceHintsBuilder rootDeviceHints;
  private List<Taint> taints = new ArrayList<Taint>();
  private SecretReference userData;

  public BareMetalHostSpecFluent() {
  }
  
  public BareMetalHostSpecFluent(BareMetalHostSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTaints(Collection<Taint> items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
      this.taints.add(item);
    }
    return (A) this;
  }
  
  public A addNewTaint(String effect,String key,String timeAdded,String value) {
    return (A) this.addToTaints(new Taint(effect, key, timeAdded, value));
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
  
  public A addToTaints(Taint... items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
      this.taints.add(item);
    }
    return (A) this;
  }
  
  public A addToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    this.taints.add(index, item);
    return (A) this;
  }
  
  public BMCDetails buildBmc() {
    return this.bmc != null ? this.bmc.build() : null;
  }
  
  public ObjectReference buildConsumerRef() {
    return this.consumerRef != null ? this.consumerRef.build() : null;
  }
  
  public CustomDeploy buildCustomDeploy() {
    return this.customDeploy != null ? this.customDeploy.build() : null;
  }
  
  public FirmwareConfig buildFirmware() {
    return this.firmware != null ? this.firmware.build() : null;
  }
  
  public Image buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public RAIDConfig buildRaid() {
    return this.raid != null ? this.raid.build() : null;
  }
  
  public RootDeviceHints buildRootDeviceHints() {
    return this.rootDeviceHints != null ? this.rootDeviceHints.build() : null;
  }
  
  protected void copyInstance(BareMetalHostSpec instance) {
    instance = instance != null ? instance : new BareMetalHostSpec();
    if (instance != null) {
        this.withArchitecture(instance.getArchitecture());
        this.withAutomatedCleaningMode(instance.getAutomatedCleaningMode());
        this.withBmc(instance.getBmc());
        this.withBootMACAddress(instance.getBootMACAddress());
        this.withBootMode(instance.getBootMode());
        this.withConsumerRef(instance.getConsumerRef());
        this.withCustomDeploy(instance.getCustomDeploy());
        this.withDescription(instance.getDescription());
        this.withDisablePowerOff(instance.getDisablePowerOff());
        this.withExternallyProvisioned(instance.getExternallyProvisioned());
        this.withFirmware(instance.getFirmware());
        this.withHardwareProfile(instance.getHardwareProfile());
        this.withImage(instance.getImage());
        this.withInspectionMode(instance.getInspectionMode());
        this.withMetaData(instance.getMetaData());
        this.withNetworkData(instance.getNetworkData());
        this.withOnline(instance.getOnline());
        this.withPreprovisioningNetworkDataName(instance.getPreprovisioningNetworkDataName());
        this.withRaid(instance.getRaid());
        this.withRootDeviceHints(instance.getRootDeviceHints());
        this.withTaints(instance.getTaints());
        this.withUserData(instance.getUserData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BmcNested<A> editBmc() {
    return this.withNewBmcLike(Optional.ofNullable(this.buildBmc()).orElse(null));
  }
  
  public ConsumerRefNested<A> editConsumerRef() {
    return this.withNewConsumerRefLike(Optional.ofNullable(this.buildConsumerRef()).orElse(null));
  }
  
  public CustomDeployNested<A> editCustomDeploy() {
    return this.withNewCustomDeployLike(Optional.ofNullable(this.buildCustomDeploy()).orElse(null));
  }
  
  public FirmwareNested<A> editFirmware() {
    return this.withNewFirmwareLike(Optional.ofNullable(this.buildFirmware()).orElse(null));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public BmcNested<A> editOrNewBmc() {
    return this.withNewBmcLike(Optional.ofNullable(this.buildBmc()).orElse(new BMCDetailsBuilder().build()));
  }
  
  public BmcNested<A> editOrNewBmcLike(BMCDetails item) {
    return this.withNewBmcLike(Optional.ofNullable(this.buildBmc()).orElse(item));
  }
  
  public ConsumerRefNested<A> editOrNewConsumerRef() {
    return this.withNewConsumerRefLike(Optional.ofNullable(this.buildConsumerRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ConsumerRefNested<A> editOrNewConsumerRefLike(ObjectReference item) {
    return this.withNewConsumerRefLike(Optional.ofNullable(this.buildConsumerRef()).orElse(item));
  }
  
  public CustomDeployNested<A> editOrNewCustomDeploy() {
    return this.withNewCustomDeployLike(Optional.ofNullable(this.buildCustomDeploy()).orElse(new CustomDeployBuilder().build()));
  }
  
  public CustomDeployNested<A> editOrNewCustomDeployLike(CustomDeploy item) {
    return this.withNewCustomDeployLike(Optional.ofNullable(this.buildCustomDeploy()).orElse(item));
  }
  
  public FirmwareNested<A> editOrNewFirmware() {
    return this.withNewFirmwareLike(Optional.ofNullable(this.buildFirmware()).orElse(new FirmwareConfigBuilder().build()));
  }
  
  public FirmwareNested<A> editOrNewFirmwareLike(FirmwareConfig item) {
    return this.withNewFirmwareLike(Optional.ofNullable(this.buildFirmware()).orElse(item));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ImageBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(Image item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
  }
  
  public RaidNested<A> editOrNewRaid() {
    return this.withNewRaidLike(Optional.ofNullable(this.buildRaid()).orElse(new RAIDConfigBuilder().build()));
  }
  
  public RaidNested<A> editOrNewRaidLike(RAIDConfig item) {
    return this.withNewRaidLike(Optional.ofNullable(this.buildRaid()).orElse(item));
  }
  
  public RootDeviceHintsNested<A> editOrNewRootDeviceHints() {
    return this.withNewRootDeviceHintsLike(Optional.ofNullable(this.buildRootDeviceHints()).orElse(new RootDeviceHintsBuilder().build()));
  }
  
  public RootDeviceHintsNested<A> editOrNewRootDeviceHintsLike(RootDeviceHints item) {
    return this.withNewRootDeviceHintsLike(Optional.ofNullable(this.buildRootDeviceHints()).orElse(item));
  }
  
  public RaidNested<A> editRaid() {
    return this.withNewRaidLike(Optional.ofNullable(this.buildRaid()).orElse(null));
  }
  
  public RootDeviceHintsNested<A> editRootDeviceHints() {
    return this.withNewRootDeviceHintsLike(Optional.ofNullable(this.buildRootDeviceHints()).orElse(null));
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
    BareMetalHostSpecFluent that = (BareMetalHostSpecFluent) o;
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(automatedCleaningMode, that.automatedCleaningMode))) {
      return false;
    }
    if (!(Objects.equals(bmc, that.bmc))) {
      return false;
    }
    if (!(Objects.equals(bootMACAddress, that.bootMACAddress))) {
      return false;
    }
    if (!(Objects.equals(bootMode, that.bootMode))) {
      return false;
    }
    if (!(Objects.equals(consumerRef, that.consumerRef))) {
      return false;
    }
    if (!(Objects.equals(customDeploy, that.customDeploy))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(disablePowerOff, that.disablePowerOff))) {
      return false;
    }
    if (!(Objects.equals(externallyProvisioned, that.externallyProvisioned))) {
      return false;
    }
    if (!(Objects.equals(firmware, that.firmware))) {
      return false;
    }
    if (!(Objects.equals(hardwareProfile, that.hardwareProfile))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(inspectionMode, that.inspectionMode))) {
      return false;
    }
    if (!(Objects.equals(metaData, that.metaData))) {
      return false;
    }
    if (!(Objects.equals(networkData, that.networkData))) {
      return false;
    }
    if (!(Objects.equals(online, that.online))) {
      return false;
    }
    if (!(Objects.equals(preprovisioningNetworkDataName, that.preprovisioningNetworkDataName))) {
      return false;
    }
    if (!(Objects.equals(raid, that.raid))) {
      return false;
    }
    if (!(Objects.equals(rootDeviceHints, that.rootDeviceHints))) {
      return false;
    }
    if (!(Objects.equals(taints, that.taints))) {
      return false;
    }
    if (!(Objects.equals(userData, that.userData))) {
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
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public String getAutomatedCleaningMode() {
    return this.automatedCleaningMode;
  }
  
  public String getBootMACAddress() {
    return this.bootMACAddress;
  }
  
  public String getBootMode() {
    return this.bootMode;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public Boolean getDisablePowerOff() {
    return this.disablePowerOff;
  }
  
  public Boolean getExternallyProvisioned() {
    return this.externallyProvisioned;
  }
  
  public Taint getFirstTaint() {
    return this.taints.get(0);
  }
  
  public String getHardwareProfile() {
    return this.hardwareProfile;
  }
  
  public String getInspectionMode() {
    return this.inspectionMode;
  }
  
  public Taint getLastTaint() {
    return this.taints.get(taints.size() - 1);
  }
  
  public Taint getMatchingTaint(Predicate<Taint> predicate) {
      for (Taint item : taints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public SecretReference getMetaData() {
    return this.metaData;
  }
  
  public SecretReference getNetworkData() {
    return this.networkData;
  }
  
  public Boolean getOnline() {
    return this.online;
  }
  
  public String getPreprovisioningNetworkDataName() {
    return this.preprovisioningNetworkDataName;
  }
  
  public Taint getTaint(int index) {
    return this.taints.get(index);
  }
  
  public List<Taint> getTaints() {
    return this.taints;
  }
  
  public SecretReference getUserData() {
    return this.userData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasAutomatedCleaningMode() {
    return this.automatedCleaningMode != null;
  }
  
  public boolean hasBmc() {
    return this.bmc != null;
  }
  
  public boolean hasBootMACAddress() {
    return this.bootMACAddress != null;
  }
  
  public boolean hasBootMode() {
    return this.bootMode != null;
  }
  
  public boolean hasConsumerRef() {
    return this.consumerRef != null;
  }
  
  public boolean hasCustomDeploy() {
    return this.customDeploy != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisablePowerOff() {
    return this.disablePowerOff != null;
  }
  
  public boolean hasExternallyProvisioned() {
    return this.externallyProvisioned != null;
  }
  
  public boolean hasFirmware() {
    return this.firmware != null;
  }
  
  public boolean hasHardwareProfile() {
    return this.hardwareProfile != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasInspectionMode() {
    return this.inspectionMode != null;
  }
  
  public boolean hasMatchingTaint(Predicate<Taint> predicate) {
      for (Taint item : taints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetaData() {
    return this.metaData != null;
  }
  
  public boolean hasNetworkData() {
    return this.networkData != null;
  }
  
  public boolean hasOnline() {
    return this.online != null;
  }
  
  public boolean hasPreprovisioningNetworkDataName() {
    return this.preprovisioningNetworkDataName != null;
  }
  
  public boolean hasRaid() {
    return this.raid != null;
  }
  
  public boolean hasRootDeviceHints() {
    return this.rootDeviceHints != null;
  }
  
  public boolean hasTaints() {
    return this.taints != null && !(this.taints.isEmpty());
  }
  
  public boolean hasUserData() {
    return this.userData != null;
  }
  
  public int hashCode() {
    return Objects.hash(architecture, automatedCleaningMode, bmc, bootMACAddress, bootMode, consumerRef, customDeploy, description, disablePowerOff, externallyProvisioned, firmware, hardwareProfile, image, inspectionMode, metaData, networkData, online, preprovisioningNetworkDataName, raid, rootDeviceHints, taints, userData, additionalProperties);
  }
  
  public A removeAllFromTaints(Collection<Taint> items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
      this.taints.remove(item);
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
  
  public A removeFromTaints(Taint... items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
      this.taints.remove(item);
    }
    return (A) this;
  }
  
  public A setToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    this.taints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(automatedCleaningMode == null)) {
        sb.append("automatedCleaningMode:");
        sb.append(automatedCleaningMode);
        sb.append(",");
    }
    if (!(bmc == null)) {
        sb.append("bmc:");
        sb.append(bmc);
        sb.append(",");
    }
    if (!(bootMACAddress == null)) {
        sb.append("bootMACAddress:");
        sb.append(bootMACAddress);
        sb.append(",");
    }
    if (!(bootMode == null)) {
        sb.append("bootMode:");
        sb.append(bootMode);
        sb.append(",");
    }
    if (!(consumerRef == null)) {
        sb.append("consumerRef:");
        sb.append(consumerRef);
        sb.append(",");
    }
    if (!(customDeploy == null)) {
        sb.append("customDeploy:");
        sb.append(customDeploy);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(disablePowerOff == null)) {
        sb.append("disablePowerOff:");
        sb.append(disablePowerOff);
        sb.append(",");
    }
    if (!(externallyProvisioned == null)) {
        sb.append("externallyProvisioned:");
        sb.append(externallyProvisioned);
        sb.append(",");
    }
    if (!(firmware == null)) {
        sb.append("firmware:");
        sb.append(firmware);
        sb.append(",");
    }
    if (!(hardwareProfile == null)) {
        sb.append("hardwareProfile:");
        sb.append(hardwareProfile);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(inspectionMode == null)) {
        sb.append("inspectionMode:");
        sb.append(inspectionMode);
        sb.append(",");
    }
    if (!(metaData == null)) {
        sb.append("metaData:");
        sb.append(metaData);
        sb.append(",");
    }
    if (!(networkData == null)) {
        sb.append("networkData:");
        sb.append(networkData);
        sb.append(",");
    }
    if (!(online == null)) {
        sb.append("online:");
        sb.append(online);
        sb.append(",");
    }
    if (!(preprovisioningNetworkDataName == null)) {
        sb.append("preprovisioningNetworkDataName:");
        sb.append(preprovisioningNetworkDataName);
        sb.append(",");
    }
    if (!(raid == null)) {
        sb.append("raid:");
        sb.append(raid);
        sb.append(",");
    }
    if (!(rootDeviceHints == null)) {
        sb.append("rootDeviceHints:");
        sb.append(rootDeviceHints);
        sb.append(",");
    }
    if (!(taints == null) && !(taints.isEmpty())) {
        sb.append("taints:");
        sb.append(taints);
        sb.append(",");
    }
    if (!(userData == null)) {
        sb.append("userData:");
        sb.append(userData);
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
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withAutomatedCleaningMode(String automatedCleaningMode) {
    this.automatedCleaningMode = automatedCleaningMode;
    return (A) this;
  }
  
  public A withBmc(BMCDetails bmc) {
    this._visitables.remove("bmc");
    if (bmc != null) {
        this.bmc = new BMCDetailsBuilder(bmc);
        this._visitables.get("bmc").add(this.bmc);
    } else {
        this.bmc = null;
        this._visitables.get("bmc").remove(this.bmc);
    }
    return (A) this;
  }
  
  public A withBootMACAddress(String bootMACAddress) {
    this.bootMACAddress = bootMACAddress;
    return (A) this;
  }
  
  public A withBootMode(String bootMode) {
    this.bootMode = bootMode;
    return (A) this;
  }
  
  public A withConsumerRef(ObjectReference consumerRef) {
    this._visitables.remove("consumerRef");
    if (consumerRef != null) {
        this.consumerRef = new ObjectReferenceBuilder(consumerRef);
        this._visitables.get("consumerRef").add(this.consumerRef);
    } else {
        this.consumerRef = null;
        this._visitables.get("consumerRef").remove(this.consumerRef);
    }
    return (A) this;
  }
  
  public A withCustomDeploy(CustomDeploy customDeploy) {
    this._visitables.remove("customDeploy");
    if (customDeploy != null) {
        this.customDeploy = new CustomDeployBuilder(customDeploy);
        this._visitables.get("customDeploy").add(this.customDeploy);
    } else {
        this.customDeploy = null;
        this._visitables.get("customDeploy").remove(this.customDeploy);
    }
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisablePowerOff() {
    return withDisablePowerOff(true);
  }
  
  public A withDisablePowerOff(Boolean disablePowerOff) {
    this.disablePowerOff = disablePowerOff;
    return (A) this;
  }
  
  public A withExternallyProvisioned() {
    return withExternallyProvisioned(true);
  }
  
  public A withExternallyProvisioned(Boolean externallyProvisioned) {
    this.externallyProvisioned = externallyProvisioned;
    return (A) this;
  }
  
  public A withFirmware(FirmwareConfig firmware) {
    this._visitables.remove("firmware");
    if (firmware != null) {
        this.firmware = new FirmwareConfigBuilder(firmware);
        this._visitables.get("firmware").add(this.firmware);
    } else {
        this.firmware = null;
        this._visitables.get("firmware").remove(this.firmware);
    }
    return (A) this;
  }
  
  public A withHardwareProfile(String hardwareProfile) {
    this.hardwareProfile = hardwareProfile;
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
  
  public A withInspectionMode(String inspectionMode) {
    this.inspectionMode = inspectionMode;
    return (A) this;
  }
  
  public A withMetaData(SecretReference metaData) {
    this.metaData = metaData;
    return (A) this;
  }
  
  public A withNetworkData(SecretReference networkData) {
    this.networkData = networkData;
    return (A) this;
  }
  
  public BmcNested<A> withNewBmc() {
    return new BmcNested(null);
  }
  
  public A withNewBmc(String address,String credentialsName,Boolean disableCertificateVerification) {
    return (A) this.withBmc(new BMCDetails(address, credentialsName, disableCertificateVerification));
  }
  
  public BmcNested<A> withNewBmcLike(BMCDetails item) {
    return new BmcNested(item);
  }
  
  public ConsumerRefNested<A> withNewConsumerRef() {
    return new ConsumerRefNested(null);
  }
  
  public ConsumerRefNested<A> withNewConsumerRefLike(ObjectReference item) {
    return new ConsumerRefNested(item);
  }
  
  public CustomDeployNested<A> withNewCustomDeploy() {
    return new CustomDeployNested(null);
  }
  
  public A withNewCustomDeploy(String method) {
    return (A) this.withCustomDeploy(new CustomDeploy(method));
  }
  
  public CustomDeployNested<A> withNewCustomDeployLike(CustomDeploy item) {
    return new CustomDeployNested(item);
  }
  
  public FirmwareNested<A> withNewFirmware() {
    return new FirmwareNested(null);
  }
  
  public A withNewFirmware(Boolean simultaneousMultithreadingEnabled,Boolean sriovEnabled,Boolean virtualizationEnabled) {
    return (A) this.withFirmware(new FirmwareConfig(simultaneousMultithreadingEnabled, sriovEnabled, virtualizationEnabled));
  }
  
  public FirmwareNested<A> withNewFirmwareLike(FirmwareConfig item) {
    return new FirmwareNested(item);
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public A withNewImage(String checksum,String checksumType,String format,String ociAuthSecretName,String url) {
    return (A) this.withImage(new Image(checksum, checksumType, format, ociAuthSecretName, url));
  }
  
  public ImageNested<A> withNewImageLike(Image item) {
    return new ImageNested(item);
  }
  
  public A withNewMetaData(String name,String namespace) {
    return (A) this.withMetaData(new SecretReference(name, namespace));
  }
  
  public A withNewNetworkData(String name,String namespace) {
    return (A) this.withNetworkData(new SecretReference(name, namespace));
  }
  
  public RaidNested<A> withNewRaid() {
    return new RaidNested(null);
  }
  
  public RaidNested<A> withNewRaidLike(RAIDConfig item) {
    return new RaidNested(item);
  }
  
  public RootDeviceHintsNested<A> withNewRootDeviceHints() {
    return new RootDeviceHintsNested(null);
  }
  
  public RootDeviceHintsNested<A> withNewRootDeviceHintsLike(RootDeviceHints item) {
    return new RootDeviceHintsNested(item);
  }
  
  public A withNewUserData(String name,String namespace) {
    return (A) this.withUserData(new SecretReference(name, namespace));
  }
  
  public A withOnline() {
    return withOnline(true);
  }
  
  public A withOnline(Boolean online) {
    this.online = online;
    return (A) this;
  }
  
  public A withPreprovisioningNetworkDataName(String preprovisioningNetworkDataName) {
    this.preprovisioningNetworkDataName = preprovisioningNetworkDataName;
    return (A) this;
  }
  
  public A withRaid(RAIDConfig raid) {
    this._visitables.remove("raid");
    if (raid != null) {
        this.raid = new RAIDConfigBuilder(raid);
        this._visitables.get("raid").add(this.raid);
    } else {
        this.raid = null;
        this._visitables.get("raid").remove(this.raid);
    }
    return (A) this;
  }
  
  public A withRootDeviceHints(RootDeviceHints rootDeviceHints) {
    this._visitables.remove("rootDeviceHints");
    if (rootDeviceHints != null) {
        this.rootDeviceHints = new RootDeviceHintsBuilder(rootDeviceHints);
        this._visitables.get("rootDeviceHints").add(this.rootDeviceHints);
    } else {
        this.rootDeviceHints = null;
        this._visitables.get("rootDeviceHints").remove(this.rootDeviceHints);
    }
    return (A) this;
  }
  
  public A withTaints(List<Taint> taints) {
    if (taints != null) {
        this.taints = new ArrayList();
        for (Taint item : taints) {
          this.addToTaints(item);
        }
    } else {
      this.taints = null;
    }
    return (A) this;
  }
  
  public A withTaints(Taint... taints) {
    if (this.taints != null) {
        this.taints.clear();
        _visitables.remove("taints");
    }
    if (taints != null) {
      for (Taint item : taints) {
        this.addToTaints(item);
      }
    }
    return (A) this;
  }
  
  public A withUserData(SecretReference userData) {
    this.userData = userData;
    return (A) this;
  }
  public class BmcNested<N> extends BMCDetailsFluent<BmcNested<N>> implements Nested<N>{
  
    BMCDetailsBuilder builder;
  
    BmcNested(BMCDetails item) {
      this.builder = new BMCDetailsBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostSpecFluent.this.withBmc(builder.build());
    }
    
    public N endBmc() {
      return and();
    }
    
  }
  public class ConsumerRefNested<N> extends ObjectReferenceFluent<ConsumerRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ConsumerRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostSpecFluent.this.withConsumerRef(builder.build());
    }
    
    public N endConsumerRef() {
      return and();
    }
    
  }
  public class CustomDeployNested<N> extends CustomDeployFluent<CustomDeployNested<N>> implements Nested<N>{
  
    CustomDeployBuilder builder;
  
    CustomDeployNested(CustomDeploy item) {
      this.builder = new CustomDeployBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostSpecFluent.this.withCustomDeploy(builder.build());
    }
    
    public N endCustomDeploy() {
      return and();
    }
    
  }
  public class FirmwareNested<N> extends FirmwareConfigFluent<FirmwareNested<N>> implements Nested<N>{
  
    FirmwareConfigBuilder builder;
  
    FirmwareNested(FirmwareConfig item) {
      this.builder = new FirmwareConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostSpecFluent.this.withFirmware(builder.build());
    }
    
    public N endFirmware() {
      return and();
    }
    
  }
  public class ImageNested<N> extends ImageFluent<ImageNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
  
    ImageNested(Image item) {
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostSpecFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class RaidNested<N> extends RAIDConfigFluent<RaidNested<N>> implements Nested<N>{
  
    RAIDConfigBuilder builder;
  
    RaidNested(RAIDConfig item) {
      this.builder = new RAIDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostSpecFluent.this.withRaid(builder.build());
    }
    
    public N endRaid() {
      return and();
    }
    
  }
  public class RootDeviceHintsNested<N> extends RootDeviceHintsFluent<RootDeviceHintsNested<N>> implements Nested<N>{
  
    RootDeviceHintsBuilder builder;
  
    RootDeviceHintsNested(RootDeviceHints item) {
      this.builder = new RootDeviceHintsBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostSpecFluent.this.withRootDeviceHints(builder.build());
    }
    
    public N endRootDeviceHints() {
      return and();
    }
    
  }
}