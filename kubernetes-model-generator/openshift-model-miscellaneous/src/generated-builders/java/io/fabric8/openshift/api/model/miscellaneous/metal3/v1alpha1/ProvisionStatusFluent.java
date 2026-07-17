package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ProvisionStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.ProvisionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bootMode;
  private CustomDeployBuilder customDeploy;
  private FirmwareConfigBuilder firmware;
  private String iD;
  private ImageBuilder image;
  private RAIDConfigBuilder raid;
  private RootDeviceHintsBuilder rootDeviceHints;
  private String state;

  public ProvisionStatusFluent() {
  }
  
  public ProvisionStatusFluent(ProvisionStatus instance) {
    this.copyInstance(instance);
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
  
  protected void copyInstance(ProvisionStatus instance) {
    instance = instance != null ? instance : new ProvisionStatus();
    if (instance != null) {
        this.withID(instance.getID());
        this.withBootMode(instance.getBootMode());
        this.withCustomDeploy(instance.getCustomDeploy());
        this.withFirmware(instance.getFirmware());
        this.withImage(instance.getImage());
        this.withRaid(instance.getRaid());
        this.withRootDeviceHints(instance.getRootDeviceHints());
        this.withState(instance.getState());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ProvisionStatusFluent that = (ProvisionStatusFluent) o;
    if (!(Objects.equals(iD, that.iD))) {
      return false;
    }
    if (!(Objects.equals(bootMode, that.bootMode))) {
      return false;
    }
    if (!(Objects.equals(customDeploy, that.customDeploy))) {
      return false;
    }
    if (!(Objects.equals(firmware, that.firmware))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(raid, that.raid))) {
      return false;
    }
    if (!(Objects.equals(rootDeviceHints, that.rootDeviceHints))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
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
  
  public String getBootMode() {
    return this.bootMode;
  }
  
  public String getID() {
    return this.iD;
  }
  
  public String getState() {
    return this.state;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootMode() {
    return this.bootMode != null;
  }
  
  public boolean hasCustomDeploy() {
    return this.customDeploy != null;
  }
  
  public boolean hasFirmware() {
    return this.firmware != null;
  }
  
  public boolean hasID() {
    return this.iD != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasRaid() {
    return this.raid != null;
  }
  
  public boolean hasRootDeviceHints() {
    return this.rootDeviceHints != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public int hashCode() {
    return Objects.hash(iD, bootMode, customDeploy, firmware, image, raid, rootDeviceHints, state, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(iD == null)) {
        sb.append("iD:");
        sb.append(iD);
        sb.append(",");
    }
    if (!(bootMode == null)) {
        sb.append("bootMode:");
        sb.append(bootMode);
        sb.append(",");
    }
    if (!(customDeploy == null)) {
        sb.append("customDeploy:");
        sb.append(customDeploy);
        sb.append(",");
    }
    if (!(firmware == null)) {
        sb.append("firmware:");
        sb.append(firmware);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
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
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
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
  
  public A withBootMode(String bootMode) {
    this.bootMode = bootMode;
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
  
  public A withID(String iD) {
    this.iD = iD;
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
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  public class CustomDeployNested<N> extends CustomDeployFluent<CustomDeployNested<N>> implements Nested<N>{
  
    CustomDeployBuilder builder;
  
    CustomDeployNested(CustomDeploy item) {
      this.builder = new CustomDeployBuilder(this, item);
    }
  
    public N and() {
      return (N) ProvisionStatusFluent.this.withCustomDeploy(builder.build());
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
      return (N) ProvisionStatusFluent.this.withFirmware(builder.build());
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
      return (N) ProvisionStatusFluent.this.withImage(builder.build());
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
      return (N) ProvisionStatusFluent.this.withRaid(builder.build());
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
      return (N) ProvisionStatusFluent.this.withRootDeviceHints(builder.build());
    }
    
    public N endRootDeviceHints() {
      return and();
    }
    
  }
}