
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Metal3MachineSpec defines the desired state of Metal3Machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "automatedCleaningMode",
    "customDeploy",
    "dataTemplate",
    "hostSelector",
    "image",
    "metaData",
    "networkData",
    "providerID",
    "userData"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

    public Metal3MachineSpec(String automatedCleaningMode, CustomDeploy customDeploy, ObjectReference dataTemplate, HostSelector hostSelector, Image image, SecretReference metaData, SecretReference networkData, String providerID, SecretReference userData) {
        super();
        this.automatedCleaningMode = automatedCleaningMode;
        this.customDeploy = customDeploy;
        this.dataTemplate = dataTemplate;
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
     * ProviderID will be the Metal3 machine in ProviderID format (metal3://&lt;bmh-uuid&gt;)
     */
    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    /**
     * ProviderID will be the Metal3 machine in ProviderID format (metal3://&lt;bmh-uuid&gt;)
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

}
