
package io.fabric8.openshift.api.model.hive.gcp.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * MachinePool stores the configuration for a machine pool installed on GCP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "networkProjectID",
    "onHostMaintenance",
    "osDisk",
    "secureBoot",
    "serviceAccount",
    "type",
    "userTags",
    "zones"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("networkProjectID")
    private String networkProjectID;
    @JsonProperty("onHostMaintenance")
    private String onHostMaintenance;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("secureBoot")
    private String secureBoot;
    @JsonProperty("serviceAccount")
    private String serviceAccount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserTag> userTags = new ArrayList<>();
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(String networkProjectID, String onHostMaintenance, OSDisk osDisk, String secureBoot, String serviceAccount, String type, List<UserTag> userTags, List<String> zones) {
        super();
        this.networkProjectID = networkProjectID;
        this.onHostMaintenance = onHostMaintenance;
        this.osDisk = osDisk;
        this.secureBoot = secureBoot;
        this.serviceAccount = serviceAccount;
        this.type = type;
        this.userTags = userTags;
        this.zones = zones;
    }

    /**
     * NetworkProjectID specifies which project the network and subnets exist in when they are not in the main ProjectID.
     */
    @JsonProperty("networkProjectID")
    public String getNetworkProjectID() {
        return networkProjectID;
    }

    /**
     * NetworkProjectID specifies which project the network and subnets exist in when they are not in the main ProjectID.
     */
    @JsonProperty("networkProjectID")
    public void setNetworkProjectID(String networkProjectID) {
        this.networkProjectID = networkProjectID;
    }

    /**
     * OnHostMaintenance determines the behavior when a maintenance event occurs that might cause the instance to reboot. This is required to be set to "Terminate" if you want to provision machine with attached GPUs. Otherwise, allowed values are "Migrate" and "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Migrate".
     */
    @JsonProperty("onHostMaintenance")
    public String getOnHostMaintenance() {
        return onHostMaintenance;
    }

    /**
     * OnHostMaintenance determines the behavior when a maintenance event occurs that might cause the instance to reboot. This is required to be set to "Terminate" if you want to provision machine with attached GPUs. Otherwise, allowed values are "Migrate" and "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Migrate".
     */
    @JsonProperty("onHostMaintenance")
    public void setOnHostMaintenance(String onHostMaintenance) {
        this.onHostMaintenance = onHostMaintenance;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on GCP.
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on GCP.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * SecureBoot Defines whether the instance should have secure boot enabled. Verifies the digital signature of all boot components, and halts the boot process if signature verification fails. If omitted, the platform chooses a default, which is subject to change over time. Currently that default is "Disabled".
     */
    @JsonProperty("secureBoot")
    public String getSecureBoot() {
        return secureBoot;
    }

    /**
     * SecureBoot Defines whether the instance should have secure boot enabled. Verifies the digital signature of all boot components, and halts the boot process if signature verification fails. If omitted, the platform chooses a default, which is subject to change over time. Currently that default is "Disabled".
     */
    @JsonProperty("secureBoot")
    public void setSecureBoot(String secureBoot) {
        this.secureBoot = secureBoot;
    }

    /**
     * ServiceAccount is the email of a gcp service account to be attached to worker nodes in order to provide the permissions required by the cloud provider. For the default worker MachinePool, it is the user's responsibility to match this to the value provided in the install-config.
     */
    @JsonProperty("serviceAccount")
    public String getServiceAccount() {
        return serviceAccount;
    }

    /**
     * ServiceAccount is the email of a gcp service account to be attached to worker nodes in order to provide the permissions required by the cloud provider. For the default worker MachinePool, it is the user's responsibility to match this to the value provided in the install-config.
     */
    @JsonProperty("serviceAccount")
    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    /**
     * InstanceType defines the GCP instance type. eg. n1-standard-4
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * InstanceType defines the GCP instance type. eg. n1-standard-4
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * userTags has additional keys and values that we will add as tags to the providerSpec of MachineSets that we creates on GCP. Tag key and tag value should be the shortnames of the tag key and tag value resource. Consumer is responsible for using this only for spokes where custom tags are supported.
     */
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserTag> getUserTags() {
        return userTags;
    }

    /**
     * userTags has additional keys and values that we will add as tags to the providerSpec of MachineSets that we creates on GCP. Tag key and tag value should be the shortnames of the tag key and tag value resource. Consumer is responsible for using this only for spokes where custom tags are supported.
     */
    @JsonProperty("userTags")
    public void setUserTags(List<UserTag> userTags) {
        this.userTags = userTags;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
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
        if (!(o instanceof MachinePool)) {
            return false;
        }
        MachinePool other = (MachinePool) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$networkProjectID = this.getNetworkProjectID();
        Object other$networkProjectID = other.getNetworkProjectID();
        if (this$networkProjectID == null ? other$networkProjectID != null : !this$networkProjectID.equals(other$networkProjectID)) {
            return false;
        }
        Object this$onHostMaintenance = this.getOnHostMaintenance();
        Object other$onHostMaintenance = other.getOnHostMaintenance();
        if (this$onHostMaintenance == null ? other$onHostMaintenance != null : !this$onHostMaintenance.equals(other$onHostMaintenance)) {
            return false;
        }
        Object this$osDisk = this.getOsDisk();
        Object other$osDisk = other.getOsDisk();
        if (this$osDisk == null ? other$osDisk != null : !this$osDisk.equals(other$osDisk)) {
            return false;
        }
        Object this$secureBoot = this.getSecureBoot();
        Object other$secureBoot = other.getSecureBoot();
        if (this$secureBoot == null ? other$secureBoot != null : !this$secureBoot.equals(other$secureBoot)) {
            return false;
        }
        Object this$serviceAccount = this.getServiceAccount();
        Object other$serviceAccount = other.getServiceAccount();
        if (this$serviceAccount == null ? other$serviceAccount != null : !this$serviceAccount.equals(other$serviceAccount)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$userTags = this.getUserTags();
        Object other$userTags = other.getUserTags();
        if (this$userTags == null ? other$userTags != null : !this$userTags.equals(other$userTags)) {
            return false;
        }
        Object this$zones = this.getZones();
        Object other$zones = other.getZones();
        if (this$zones == null ? other$zones != null : !this$zones.equals(other$zones)) {
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
        return other instanceof MachinePool;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $networkProjectID = this.getNetworkProjectID();
        result = result * prime + ($networkProjectID == null ? 43 : $networkProjectID.hashCode());
        Object $onHostMaintenance = this.getOnHostMaintenance();
        result = result * prime + ($onHostMaintenance == null ? 43 : $onHostMaintenance.hashCode());
        Object $osDisk = this.getOsDisk();
        result = result * prime + ($osDisk == null ? 43 : $osDisk.hashCode());
        Object $secureBoot = this.getSecureBoot();
        result = result * prime + ($secureBoot == null ? 43 : $secureBoot.hashCode());
        Object $serviceAccount = this.getServiceAccount();
        result = result * prime + ($serviceAccount == null ? 43 : $serviceAccount.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $userTags = this.getUserTags();
        result = result * prime + ($userTags == null ? 43 : $userTags.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "networkProjectID=" + this.getNetworkProjectID() + ", onHostMaintenance=" + this.getOnHostMaintenance() + ", osDisk=" + this.getOsDisk() + ", secureBoot=" + this.getSecureBoot() + ", serviceAccount=" + this.getServiceAccount() + ", type=" + this.getType() + ", userTags=" + this.getUserTags() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
