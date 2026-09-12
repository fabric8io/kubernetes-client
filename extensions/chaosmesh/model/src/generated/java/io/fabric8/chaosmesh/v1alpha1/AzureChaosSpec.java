
package io.fabric8.chaosmesh.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AzureChaosSpec is the content of the specification for an AzureChaos
 */
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
public class AzureChaosSpec implements Editable<AzureChaosSpecBuilder>, KubernetesResource
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

    /**
     * Action defines the specific azure chaos action. Supported action: vm-stop / vm-restart / disk-detach Default action: vm-stop
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action defines the specific azure chaos action. Supported action: vm-stop / vm-restart / disk-detach Default action: vm-stop
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * DiskName indicates the name of the disk. Needed in disk-detach.
     */
    @JsonProperty("diskName")
    public String getDiskName() {
        return diskName;
    }

    /**
     * DiskName indicates the name of the disk. Needed in disk-detach.
     */
    @JsonProperty("diskName")
    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    /**
     * Duration represents the duration of the chaos action.
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action.
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * LUN indicates the Logical Unit Number of the data disk. Needed in disk-detach.
     */
    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    /**
     * LUN indicates the Logical Unit Number of the data disk. Needed in disk-detach.
     */
    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    /**
     * ResourceGroupName defines the name of ResourceGroup
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * ResourceGroupName defines the name of ResourceGroup
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * SecretName defines the name of kubernetes secret. It is used for Azure credentials.
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * SecretName defines the name of kubernetes secret. It is used for Azure credentials.
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    /**
     * SubscriptionID defines the id of Azure subscription.
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * SubscriptionID defines the id of Azure subscription.
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    /**
     * VMName defines the name of Virtual Machine
     */
    @JsonProperty("vmName")
    public String getVmName() {
        return vmName;
    }

    /**
     * VMName defines the name of Virtual Machine
     */
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
        if (!(o instanceof AzureChaosSpec)) {
            return false;
        }
        AzureChaosSpec other = (AzureChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$diskName = this.getDiskName();
        Object other$diskName = other.getDiskName();
        if (this$diskName == null ? other$diskName != null : !this$diskName.equals(other$diskName)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$lun = this.getLun();
        Object other$lun = other.getLun();
        if (this$lun == null ? other$lun != null : !this$lun.equals(other$lun)) {
            return false;
        }
        Object this$remoteCluster = this.getRemoteCluster();
        Object other$remoteCluster = other.getRemoteCluster();
        if (this$remoteCluster == null ? other$remoteCluster != null : !this$remoteCluster.equals(other$remoteCluster)) {
            return false;
        }
        Object this$resourceGroupName = this.getResourceGroupName();
        Object other$resourceGroupName = other.getResourceGroupName();
        if (this$resourceGroupName == null ? other$resourceGroupName != null : !this$resourceGroupName.equals(other$resourceGroupName)) {
            return false;
        }
        Object this$secretName = this.getSecretName();
        Object other$secretName = other.getSecretName();
        if (this$secretName == null ? other$secretName != null : !this$secretName.equals(other$secretName)) {
            return false;
        }
        Object this$subscriptionID = this.getSubscriptionID();
        Object other$subscriptionID = other.getSubscriptionID();
        if (this$subscriptionID == null ? other$subscriptionID != null : !this$subscriptionID.equals(other$subscriptionID)) {
            return false;
        }
        Object this$vmName = this.getVmName();
        Object other$vmName = other.getVmName();
        if (this$vmName == null ? other$vmName != null : !this$vmName.equals(other$vmName)) {
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
        return other instanceof AzureChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $diskName = this.getDiskName();
        result = result * prime + ($diskName == null ? 43 : $diskName.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $lun = this.getLun();
        result = result * prime + ($lun == null ? 43 : $lun.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $resourceGroupName = this.getResourceGroupName();
        result = result * prime + ($resourceGroupName == null ? 43 : $resourceGroupName.hashCode());
        Object $secretName = this.getSecretName();
        result = result * prime + ($secretName == null ? 43 : $secretName.hashCode());
        Object $subscriptionID = this.getSubscriptionID();
        result = result * prime + ($subscriptionID == null ? 43 : $subscriptionID.hashCode());
        Object $vmName = this.getVmName();
        result = result * prime + ($vmName == null ? 43 : $vmName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureChaosSpec(" + "action=" + this.getAction() + ", diskName=" + this.getDiskName() + ", duration=" + this.getDuration() + ", lun=" + this.getLun() + ", remoteCluster=" + this.getRemoteCluster() + ", resourceGroupName=" + this.getResourceGroupName() + ", secretName=" + this.getSecretName() + ", subscriptionID=" + this.getSubscriptionID() + ", vmName=" + this.getVmName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
