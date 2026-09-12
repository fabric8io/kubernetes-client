
package io.fabric8.openshift.api.model.machine.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PowerVSMachineProviderStatus is the type that will be embedded in a Machine.Status.ProviderStatus field. It contains PowerVS-specific status information.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "conditions",
    "instanceId",
    "instanceState",
    "serviceInstanceID"
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
@Version("v1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PowerVSMachineProviderStatus implements Editable<PowerVSMachineProviderStatusBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1";
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("instanceId")
    private String instanceId;
    @JsonProperty("instanceState")
    private String instanceState;
    @JsonProperty("kind")
    private String kind = "PowerVSMachineProviderStatus";
    @JsonProperty("serviceInstanceID")
    private String serviceInstanceID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PowerVSMachineProviderStatus() {
    }

    public PowerVSMachineProviderStatus(String apiVersion, List<Condition> conditions, String instanceId, String instanceState, String kind, String serviceInstanceID) {
        super();
        this.apiVersion = apiVersion;
        this.conditions = conditions;
        this.instanceId = instanceId;
        this.instanceState = instanceState;
        this.kind = kind;
        this.serviceInstanceID = serviceInstanceID;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * conditions is a set of conditions associated with the Machine to indicate errors or other status
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions is a set of conditions associated with the Machine to indicate errors or other status
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * instanceId is the instance ID of the machine created in PowerVS instanceId uniquely identifies a Power VS server instance(VM) under a Power VS service. This will help in updating or deleting a VM in Power VS Cloud
     */
    @JsonProperty("instanceId")
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * instanceId is the instance ID of the machine created in PowerVS instanceId uniquely identifies a Power VS server instance(VM) under a Power VS service. This will help in updating or deleting a VM in Power VS Cloud
     */
    @JsonProperty("instanceId")
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * instanceState is the state of the PowerVS instance for this machine Possible instance states are Active, Build, ShutOff, Reboot This is used to display additional information to user regarding instance current state
     */
    @JsonProperty("instanceState")
    public String getInstanceState() {
        return instanceState;
    }

    /**
     * instanceState is the state of the PowerVS instance for this machine Possible instance states are Active, Build, ShutOff, Reboot This is used to display additional information to user regarding instance current state
     */
    @JsonProperty("instanceState")
    public void setInstanceState(String instanceState) {
        this.instanceState = instanceState;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * serviceInstanceID is the reference to the Power VS ServiceInstance on which the machine instance will be created. serviceInstanceID uniquely identifies the Power VS service By setting serviceInstanceID it will become easy and efficient to fetch a server instance(VM) within Power VS Cloud.
     */
    @JsonProperty("serviceInstanceID")
    public String getServiceInstanceID() {
        return serviceInstanceID;
    }

    /**
     * serviceInstanceID is the reference to the Power VS ServiceInstance on which the machine instance will be created. serviceInstanceID uniquely identifies the Power VS service By setting serviceInstanceID it will become easy and efficient to fetch a server instance(VM) within Power VS Cloud.
     */
    @JsonProperty("serviceInstanceID")
    public void setServiceInstanceID(String serviceInstanceID) {
        this.serviceInstanceID = serviceInstanceID;
    }

    @JsonIgnore
    public PowerVSMachineProviderStatusBuilder edit() {
        return new PowerVSMachineProviderStatusBuilder(this);
    }

    @JsonIgnore
    public PowerVSMachineProviderStatusBuilder toBuilder() {
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
        if (!(o instanceof PowerVSMachineProviderStatus)) {
            return false;
        }
        PowerVSMachineProviderStatus other = (PowerVSMachineProviderStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$instanceId = this.getInstanceId();
        Object other$instanceId = other.getInstanceId();
        if (this$instanceId == null ? other$instanceId != null : !this$instanceId.equals(other$instanceId)) {
            return false;
        }
        Object this$instanceState = this.getInstanceState();
        Object other$instanceState = other.getInstanceState();
        if (this$instanceState == null ? other$instanceState != null : !this$instanceState.equals(other$instanceState)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$serviceInstanceID = this.getServiceInstanceID();
        Object other$serviceInstanceID = other.getServiceInstanceID();
        if (this$serviceInstanceID == null ? other$serviceInstanceID != null : !this$serviceInstanceID.equals(other$serviceInstanceID)) {
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
        return other instanceof PowerVSMachineProviderStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $instanceId = this.getInstanceId();
        result = result * prime + ($instanceId == null ? 43 : $instanceId.hashCode());
        Object $instanceState = this.getInstanceState();
        result = result * prime + ($instanceState == null ? 43 : $instanceState.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $serviceInstanceID = this.getServiceInstanceID();
        result = result * prime + ($serviceInstanceID == null ? 43 : $serviceInstanceID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PowerVSMachineProviderStatus(" + "apiVersion=" + this.getApiVersion() + ", conditions=" + this.getConditions() + ", instanceId=" + this.getInstanceId() + ", instanceState=" + this.getInstanceState() + ", kind=" + this.getKind() + ", serviceInstanceID=" + this.getServiceInstanceID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
