package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
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
public class Metal3MachineSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3MachineSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String automatedCleaningMode;
  private CustomDeployBuilder customDeploy;
  private ObjectReferenceBuilder dataTemplate;
  private String failureDomain;
  private HostSelectorBuilder hostSelector;
  private ImageBuilder image;
  private SecretReference metaData;
  private SecretReference networkData;
  private String providerID;
  private SecretReference userData;

  public Metal3MachineSpecFluent() {
  }
  
  public Metal3MachineSpecFluent(Metal3MachineSpec instance) {
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
  
  public ObjectReference buildDataTemplate() {
    return this.dataTemplate != null ? this.dataTemplate.build() : null;
  }
  
  public HostSelector buildHostSelector() {
    return this.hostSelector != null ? this.hostSelector.build() : null;
  }
  
  public Image buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  protected void copyInstance(Metal3MachineSpec instance) {
    instance = instance != null ? instance : new Metal3MachineSpec();
    if (instance != null) {
        this.withAutomatedCleaningMode(instance.getAutomatedCleaningMode());
        this.withCustomDeploy(instance.getCustomDeploy());
        this.withDataTemplate(instance.getDataTemplate());
        this.withFailureDomain(instance.getFailureDomain());
        this.withHostSelector(instance.getHostSelector());
        this.withImage(instance.getImage());
        this.withMetaData(instance.getMetaData());
        this.withNetworkData(instance.getNetworkData());
        this.withProviderID(instance.getProviderID());
        this.withUserData(instance.getUserData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomDeployNested<A> editCustomDeploy() {
    return this.withNewCustomDeployLike(Optional.ofNullable(this.buildCustomDeploy()).orElse(null));
  }
  
  public DataTemplateNested<A> editDataTemplate() {
    return this.withNewDataTemplateLike(Optional.ofNullable(this.buildDataTemplate()).orElse(null));
  }
  
  public HostSelectorNested<A> editHostSelector() {
    return this.withNewHostSelectorLike(Optional.ofNullable(this.buildHostSelector()).orElse(null));
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
  
  public DataTemplateNested<A> editOrNewDataTemplate() {
    return this.withNewDataTemplateLike(Optional.ofNullable(this.buildDataTemplate()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public DataTemplateNested<A> editOrNewDataTemplateLike(ObjectReference item) {
    return this.withNewDataTemplateLike(Optional.ofNullable(this.buildDataTemplate()).orElse(item));
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
    Metal3MachineSpecFluent that = (Metal3MachineSpecFluent) o;
    if (!(Objects.equals(automatedCleaningMode, that.automatedCleaningMode))) {
      return false;
    }
    if (!(Objects.equals(customDeploy, that.customDeploy))) {
      return false;
    }
    if (!(Objects.equals(dataTemplate, that.dataTemplate))) {
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
    if (!(Objects.equals(providerID, that.providerID))) {
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
  
  public String getAutomatedCleaningMode() {
    return this.automatedCleaningMode;
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
  
  public String getProviderID() {
    return this.providerID;
  }
  
  public SecretReference getUserData() {
    return this.userData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutomatedCleaningMode() {
    return this.automatedCleaningMode != null;
  }
  
  public boolean hasCustomDeploy() {
    return this.customDeploy != null;
  }
  
  public boolean hasDataTemplate() {
    return this.dataTemplate != null;
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
  
  public boolean hasProviderID() {
    return this.providerID != null;
  }
  
  public boolean hasUserData() {
    return this.userData != null;
  }
  
  public int hashCode() {
    return Objects.hash(automatedCleaningMode, customDeploy, dataTemplate, failureDomain, hostSelector, image, metaData, networkData, providerID, userData, additionalProperties);
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
    if (!(automatedCleaningMode == null)) {
        sb.append("automatedCleaningMode:");
        sb.append(automatedCleaningMode);
        sb.append(",");
    }
    if (!(customDeploy == null)) {
        sb.append("customDeploy:");
        sb.append(customDeploy);
        sb.append(",");
    }
    if (!(dataTemplate == null)) {
        sb.append("dataTemplate:");
        sb.append(dataTemplate);
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
    if (!(providerID == null)) {
        sb.append("providerID:");
        sb.append(providerID);
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
  
  public A withAutomatedCleaningMode(String automatedCleaningMode) {
    this.automatedCleaningMode = automatedCleaningMode;
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
  
  public A withDataTemplate(ObjectReference dataTemplate) {
    this._visitables.remove("dataTemplate");
    if (dataTemplate != null) {
        this.dataTemplate = new ObjectReferenceBuilder(dataTemplate);
        this._visitables.get("dataTemplate").add(this.dataTemplate);
    } else {
        this.dataTemplate = null;
        this._visitables.get("dataTemplate").remove(this.dataTemplate);
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
  
  public CustomDeployNested<A> withNewCustomDeploy() {
    return new CustomDeployNested(null);
  }
  
  public A withNewCustomDeploy(String method) {
    return (A) this.withCustomDeploy(new CustomDeploy(method));
  }
  
  public CustomDeployNested<A> withNewCustomDeployLike(CustomDeploy item) {
    return new CustomDeployNested(item);
  }
  
  public DataTemplateNested<A> withNewDataTemplate() {
    return new DataTemplateNested(null);
  }
  
  public DataTemplateNested<A> withNewDataTemplateLike(ObjectReference item) {
    return new DataTemplateNested(item);
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
  
  public A withNewImage(String checksum,String checksumType,String format,String url) {
    return (A) this.withImage(new Image(checksum, checksumType, format, url));
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
  
  public A withProviderID(String providerID) {
    this.providerID = providerID;
    return (A) this;
  }
  
  public A withUserData(SecretReference userData) {
    this.userData = userData;
    return (A) this;
  }
  public class CustomDeployNested<N> extends CustomDeployFluent<CustomDeployNested<N>> implements Nested<N>{
  
    CustomDeployBuilder builder;
  
    CustomDeployNested(CustomDeploy item) {
      this.builder = new CustomDeployBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3MachineSpecFluent.this.withCustomDeploy(builder.build());
    }
    
    public N endCustomDeploy() {
      return and();
    }
    
  }
  public class DataTemplateNested<N> extends ObjectReferenceFluent<DataTemplateNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    DataTemplateNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3MachineSpecFluent.this.withDataTemplate(builder.build());
    }
    
    public N endDataTemplate() {
      return and();
    }
    
  }
  public class HostSelectorNested<N> extends HostSelectorFluent<HostSelectorNested<N>> implements Nested<N>{
  
    HostSelectorBuilder builder;
  
    HostSelectorNested(HostSelector item) {
      this.builder = new HostSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3MachineSpecFluent.this.withHostSelector(builder.build());
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
      return (N) Metal3MachineSpecFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
}