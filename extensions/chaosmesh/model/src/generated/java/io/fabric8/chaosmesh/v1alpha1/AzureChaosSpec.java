
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "diskName",
    "duration",
    "lun",
    "remoteCluster",
    "resourceGroupName",
    "secretName",
    "subscriptionID",
    "vmName"
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
public class AzureChaosSpec implements Editable<AzureChaosSpecBuilder> , KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("diskName")
    private String diskName;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("lun")
    private Integer lun;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonProperty("vmName")
    private String vmName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AzureChaosSpec() {
    }

    public AzureChaosSpec(String action, String diskName, String duration, Integer lun, String remoteCluster, String resourceGroupName, String secretName, String subscriptionID, String vmName) {
        super();
        this.action = action;
        this.diskName = diskName;
        this.duration = duration;
        this.lun = lun;
        this.remoteCluster = remoteCluster;
        this.resourceGroupName = resourceGroupName;
        this.secretName = secretName;
        this.subscriptionID = subscriptionID;
        this.vmName = vmName;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonProperty("diskName")
    public String getDiskName() {
        return diskName;
    }

    @JsonProperty("diskName")
    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    @JsonProperty("vmName")
    public String getVmName() {
        return vmName;
    }

    @JsonProperty("vmName")
    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    @JsonIgnore
    public AzureChaosSpecBuilder edit() {
        return new AzureChaosSpecBuilder(this);
    }

    @JsonIgnore
    public AzureChaosSpecBuilder toBuilder() {
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
