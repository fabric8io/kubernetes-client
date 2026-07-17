package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
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
public class HostClaimSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostClaimSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder consumerRef;
  private CustomDeployBuilder customDeploy;
  private String failureDomain;
  private HostSelectorBuilder hostSelector;
  private ImageBuilder image;
  private SecretReference metaData;
  private SecretReference networkData;
  private Boolean poweredOn;
  private SecretReference userData;

  public HostClaimSpecFluent() {
  }
  
  public HostClaimSpecFluent(HostClaimSpec instance) {
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
  
  public ObjectReference buildConsumerRef() {
    return this.consumerRef != null ? this.consumerRef.build() : null;
  }
  
  public CustomDeploy buildCustomDeploy() {
    return this.customDeploy != null ? this.customDeploy.build() : null;
  }
  
  public HostSelector buildHostSelector() {
    return this.hostSelector != null ? this.hostSelector.build() : null;
  }
  
  public Image buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  protected void copyInstance(HostClaimSpec instance) {
    instance = instance != null ? instance : new HostClaimSpec();
    if (instance != null) {
        this.withConsumerRef(instance.getConsumerRef());
        this.withCustomDeploy(instance.getCustomDeploy());
        this.withFailureDomain(instance.getFailureDomain());
        this.withHostSelector(instance.getHostSelector());
        this.withImage(instance.getImage());
        this.withMetaData(instance.getMetaData());
        this.withNetworkData(instance.getNetworkData());
        this.withPoweredOn(instance.getPoweredOn());
        this.withUserData(instance.getUserData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConsumerRefNested<A> editConsumerRef() {
    return this.withNewConsumerRefLike(Optional.ofNullable(this.buildConsumerRef()).orElse(null));
  }
  
  public CustomDeployNested<A> editCustomDeploy() {
    return this.withNewCustomDeployLike(Optional.ofNullable(this.buildCustomDeploy()).orElse(null));
  }
  
  public HostSelectorNested<A> editHostSelector() {
    return this.withNewHostSelectorLike(Optional.ofNullable(this.buildHostSelector()).orElse(null));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
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
  
  public HostSelectorNested<A> editOrNewHostSelector() {
    return this.withNewHostSelectorLike(Optional.ofNullable(this.buildHostSelector()).orElse(new HostSelectorBuilder().build()));
  }
  
  public HostSelectorNested<A> editOrNewHostSelectorLike(HostSelector item) {
    return this.withNewHostSelectorLike(Optional.ofNullable(this.buildHostSelector()).orElse(item));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ImageBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(Image item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
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
    HostClaimSpecFluent that = (HostClaimSpecFluent) o;
    if (!(Objects.equals(consumerRef, that.consumerRef))) {
      return false;
    }
    if (!(Objects.equals(customDeploy, that.customDeploy))) {
      return false;
    }
    if (!(Objects.equals(failureDomain, that.failureDomain))) {
      return false;
    }
    if (!(Objects.equals(hostSelector, that.hostSelector))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(metaData, that.metaData))) {
      return false;
    }
    if (!(Objects.equals(networkData, that.networkData))) {
      return false;
    }
    if (!(Objects.equals(poweredOn, that.poweredOn))) {
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
  
  public String getFailureDomain() {
    return this.failureDomain;
  }
  
  public SecretReference getMetaData() {
    return this.metaData;
  }
  
  public SecretReference getNetworkData() {
    return this.networkData;
  }
  
  public Boolean getPoweredOn() {
    return this.poweredOn;
  }
  
  public SecretReference getUserData() {
    return this.userData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConsumerRef() {
    return this.consumerRef != null;
  }
  
  public boolean hasCustomDeploy() {
    return this.customDeploy != null;
  }
  
  public boolean hasFailureDomain() {
    return this.failureDomain != null;
  }
  
  public boolean hasHostSelector() {
    return this.hostSelector != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasMetaData() {
    return this.metaData != null;
  }
  
  public boolean hasNetworkData() {
    return this.networkData != null;
  }
  
  public boolean hasPoweredOn() {
    return this.poweredOn != null;
  }
  
  public boolean hasUserData() {
    return this.userData != null;
  }
  
  public int hashCode() {
    return Objects.hash(consumerRef, customDeploy, failureDomain, hostSelector, image, metaData, networkData, poweredOn, userData, additionalProperties);
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
    if (!(failureDomain == null)) {
        sb.append("failureDomain:");
        sb.append(failureDomain);
        sb.append(",");
    }
    if (!(hostSelector == null)) {
        sb.append("hostSelector:");
        sb.append(hostSelector);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
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
    if (!(poweredOn == null)) {
        sb.append("poweredOn:");
        sb.append(poweredOn);
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
  
  public A withFailureDomain(String failureDomain) {
    this.failureDomain = failureDomain;
    return (A) this;
  }
  
  public A withHostSelector(HostSelector hostSelector) {
    this._visitables.remove("hostSelector");
    if (hostSelector != null) {
        this.hostSelector = new HostSelectorBuilder(hostSelector);
        this._visitables.get("hostSelector").add(this.hostSelector);
    } else {
        this.hostSelector = null;
        this._visitables.get("hostSelector").remove(this.hostSelector);
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
  
  public A withMetaData(SecretReference metaData) {
    this.metaData = metaData;
    return (A) this;
  }
  
  public A withNetworkData(SecretReference networkData) {
    this.networkData = networkData;
    return (A) this;
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
  
  public HostSelectorNested<A> withNewHostSelector() {
    return new HostSelectorNested(null);
  }
  
  public HostSelectorNested<A> withNewHostSelectorLike(HostSelector item) {
    return new HostSelectorNested(item);
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
  
  public A withNewUserData(String name,String namespace) {
    return (A) this.withUserData(new SecretReference(name, namespace));
  }
  
  public A withPoweredOn() {
    return withPoweredOn(true);
  }
  
  public A withPoweredOn(Boolean poweredOn) {
    this.poweredOn = poweredOn;
    return (A) this;
  }
  
  public A withUserData(SecretReference userData) {
    this.userData = userData;
    return (A) this;
  }
  public class ConsumerRefNested<N> extends ObjectReferenceFluent<ConsumerRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ConsumerRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HostClaimSpecFluent.this.withConsumerRef(builder.build());
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
      return (N) HostClaimSpecFluent.this.withCustomDeploy(builder.build());
    }
    
    public N endCustomDeploy() {
      return and();
    }
    
  }
  public class HostSelectorNested<N> extends HostSelectorFluent<HostSelectorNested<N>> implements Nested<N>{
  
    HostSelectorBuilder builder;
  
    HostSelectorNested(HostSelector item) {
      this.builder = new HostSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) HostClaimSpecFluent.this.withHostSelector(builder.build());
    }
    
    public N endHostSelector() {
      return and();
    }
    
  }
  public class ImageNested<N> extends ImageFluent<ImageNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
  
    ImageNested(Image item) {
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) HostClaimSpecFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
}