
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Metal3MachineSpec defines the desired state of Metal3Machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "automatedCleaningMode",
    "customDeploy",
    "dataTemplate",
    "failureDomain",
    "hostSelector",
    "image",
    "metaData",
    "networkData",
    "providerID",
    "userData"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Metal3MachineSpec implements Editable<Metal3MachineSpecBuilder>, KubernetesResource
{

    @JsonProperty("automatedCleaningMode")
    private String automatedCleaningMode;
    @JsonProperty("customDeploy")
    private CustomDeploy customDeploy;
    @JsonProperty("dataTemplate")
    private ObjectReference dataTemplate;
    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("hostSelector")
    private HostSelector hostSelector;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("metaData")
    private SecretReference metaData;
    @JsonProperty("networkData")
    private SecretReference networkData;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("userData")
    private SecretReference userData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3MachineSpec() {
    }

    public Metal3MachineSpec(String automatedCleaningMode, CustomDeploy customDeploy, ObjectReference dataTemplate, String failureDomain, HostSelector hostSelector, Image image, SecretReference metaData, SecretReference networkData, String providerID, SecretReference userData) {
        super();
        this.automatedCleaningMode = automatedCleaningMode;
        this.customDeploy = customDeploy;
        this.dataTemplate = dataTemplate;
        this.failureDomain = failureDomain;
        this.hostSelector = hostSelector;
        this.image = image;
        this.metaData = metaData;
        this.networkData = networkData;
        this.providerID = providerID;
        this.userData = userData;
    }

    /**
     * When set to disabled, automated cleaning of host disks will be skipped during provisioning and deprovisioning.
     */
    @JsonProperty("automatedCleaningMode")
    public String getAutomatedCleaningMode() {
        return automatedCleaningMode;
    }

    /**
     * When set to disabled, automated cleaning of host disks will be skipped during provisioning and deprovisioning.
     */
    @JsonProperty("automatedCleaningMode")
    public void setAutomatedCleaningMode(String automatedCleaningMode) {
        this.automatedCleaningMode = automatedCleaningMode;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("customDeploy")
    public CustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("customDeploy")
    public void setCustomDeploy(CustomDeploy customDeploy) {
        this.customDeploy = customDeploy;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("dataTemplate")
    public ObjectReference getDataTemplate() {
        return dataTemplate;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("dataTemplate")
    public void setDataTemplate(ObjectReference dataTemplate) {
        this.dataTemplate = dataTemplate;
    }

    /**
     * FailureDomain is the failure domain unique identifier this Machine should be attached to, as defined in Cluster API.
     */
    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    /**
     * FailureDomain is the failure domain unique identifier this Machine should be attached to, as defined in Cluster API.
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("hostSelector")
    public HostSelector getHostSelector() {
        return hostSelector;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("hostSelector")
    public void setHostSelector(HostSelector hostSelector) {
        this.hostSelector = hostSelector;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("metaData")
    public SecretReference getMetaData() {
        return metaData;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("metaData")
    public void setMetaData(SecretReference metaData) {
        this.metaData = metaData;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("networkData")
    public SecretReference getNetworkData() {
        return networkData;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("networkData")
    public void setNetworkData(SecretReference networkData) {
        this.networkData = networkData;
    }

    /**
     * ProviderID will be the Metal3 machine in ProviderID format (metal3://&lt;namespace&gt;/&lt;bmh-name&gt;/&lt;m3m-name&gt;). The legacy format (metal3://&lt;bmh-uuid&gt;) will be deprecated in CAPM3 v1.13 and removed in CAPM3 v1.14.
     */
    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    /**
     * ProviderID will be the Metal3 machine in ProviderID format (metal3://&lt;namespace&gt;/&lt;bmh-name&gt;/&lt;m3m-name&gt;). The legacy format (metal3://&lt;bmh-uuid&gt;) will be deprecated in CAPM3 v1.13 and removed in CAPM3 v1.14.
     */
    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("userData")
    public SecretReference getUserData() {
        return userData;
    }

    /**
     * Metal3MachineSpec defines the desired state of Metal3Machine.
     */
    @JsonProperty("userData")
    public void setUserData(SecretReference userData) {
        this.userData = userData;
    }

    @JsonIgnore
    public Metal3MachineSpecBuilder edit() {
        return new Metal3MachineSpecBuilder(this);
    }

    @JsonIgnore
    public Metal3MachineSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Metal3MachineSpec)) {
            return false;
        }
        Metal3MachineSpec other = (Metal3MachineSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$automatedCleaningMode = this.getAutomatedCleaningMode();
        Object other$automatedCleaningMode = other.getAutomatedCleaningMode();
        if (this$automatedCleaningMode == null ? other$automatedCleaningMode != null : !this$automatedCleaningMode.equals(other$automatedCleaningMode)) {
            return false;
        }
        Object this$customDeploy = this.getCustomDeploy();
        Object other$customDeploy = other.getCustomDeploy();
        if (this$customDeploy == null ? other$customDeploy != null : !this$customDeploy.equals(other$customDeploy)) {
            return false;
        }
        Object this$dataTemplate = this.getDataTemplate();
        Object other$dataTemplate = other.getDataTemplate();
        if (this$dataTemplate == null ? other$dataTemplate != null : !this$dataTemplate.equals(other$dataTemplate)) {
            return false;
        }
        Object this$failureDomain = this.getFailureDomain();
        Object other$failureDomain = other.getFailureDomain();
        if (this$failureDomain == null ? other$failureDomain != null : !this$failureDomain.equals(other$failureDomain)) {
            return false;
        }
        Object this$hostSelector = this.getHostSelector();
        Object other$hostSelector = other.getHostSelector();
        if (this$hostSelector == null ? other$hostSelector != null : !this$hostSelector.equals(other$hostSelector)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$metaData = this.getMetaData();
        Object other$metaData = other.getMetaData();
        if (this$metaData == null ? other$metaData != null : !this$metaData.equals(other$metaData)) {
            return false;
        }
        Object this$networkData = this.getNetworkData();
        Object other$networkData = other.getNetworkData();
        if (this$networkData == null ? other$networkData != null : !this$networkData.equals(other$networkData)) {
            return false;
        }
        Object this$providerID = this.getProviderID();
        Object other$providerID = other.getProviderID();
        if (this$providerID == null ? other$providerID != null : !this$providerID.equals(other$providerID)) {
            return false;
        }
        Object this$userData = this.getUserData();
        Object other$userData = other.getUserData();
        if (this$userData == null ? other$userData != null : !this$userData.equals(other$userData)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Metal3MachineSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $automatedCleaningMode = this.getAutomatedCleaningMode();
        result = result * prime + ($automatedCleaningMode == null ? 43 : $automatedCleaningMode.hashCode());
        Object $customDeploy = this.getCustomDeploy();
        result = result * prime + ($customDeploy == null ? 43 : $customDeploy.hashCode());
        Object $dataTemplate = this.getDataTemplate();
        result = result * prime + ($dataTemplate == null ? 43 : $dataTemplate.hashCode());
        Object $failureDomain = this.getFailureDomain();
        result = result * prime + ($failureDomain == null ? 43 : $failureDomain.hashCode());
        Object $hostSelector = this.getHostSelector();
        result = result * prime + ($hostSelector == null ? 43 : $hostSelector.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $metaData = this.getMetaData();
        result = result * prime + ($metaData == null ? 43 : $metaData.hashCode());
        Object $networkData = this.getNetworkData();
        result = result * prime + ($networkData == null ? 43 : $networkData.hashCode());
        Object $providerID = this.getProviderID();
        result = result * prime + ($providerID == null ? 43 : $providerID.hashCode());
        Object $userData = this.getUserData();
        result = result * prime + ($userData == null ? 43 : $userData.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metal3MachineSpec(" + "automatedCleaningMode=" + this.getAutomatedCleaningMode() + ", customDeploy=" + this.getCustomDeploy() + ", dataTemplate=" + this.getDataTemplate() + ", failureDomain=" + this.getFailureDomain() + ", hostSelector=" + this.getHostSelector() + ", image=" + this.getImage() + ", metaData=" + this.getMetaData() + ", networkData=" + this.getNetworkData() + ", providerID=" + this.getProviderID() + ", userData=" + this.getUserData() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
