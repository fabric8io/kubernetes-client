
package io.fabric8.openshift.api.model.installer.powervc.v1;

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
 * MachinePool stores the configuration for a machine pool installed on OpenStack.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalNetworkIDs",
    "additionalSecurityGroupIDs",
    "rootVolume",
    "serverGroupPolicy",
    "type",
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

    @JsonProperty("additionalNetworkIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalNetworkIDs = new ArrayList<>();
    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalSecurityGroupIDs = new ArrayList<>();
    @JsonProperty("rootVolume")
    private RootVolume rootVolume;
    @JsonProperty("serverGroupPolicy")
    private String serverGroupPolicy;
    @JsonProperty("type")
    private String type;
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

    public MachinePool(List<String> additionalNetworkIDs, List<String> additionalSecurityGroupIDs, RootVolume rootVolume, String serverGroupPolicy, String type, List<String> zones) {
        super();
        this.additionalNetworkIDs = additionalNetworkIDs;
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
        this.rootVolume = rootVolume;
        this.serverGroupPolicy = serverGroupPolicy;
        this.type = type;
        this.zones = zones;
    }

    /**
     * AdditionalNetworkIDs contains IDs of additional networks for machines, where each ID is presented in UUID v4 format. Allowed address pairs won't be created for the additional networks.
     */
    @JsonProperty("additionalNetworkIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalNetworkIDs() {
        return additionalNetworkIDs;
    }

    /**
     * AdditionalNetworkIDs contains IDs of additional networks for machines, where each ID is presented in UUID v4 format. Allowed address pairs won't be created for the additional networks.
     */
    @JsonProperty("additionalNetworkIDs")
    public void setAdditionalNetworkIDs(List<String> additionalNetworkIDs) {
        this.additionalNetworkIDs = additionalNetworkIDs;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in UUID v4 format.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalSecurityGroupIDs() {
        return additionalSecurityGroupIDs;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in UUID v4 format.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    public void setAdditionalSecurityGroupIDs(List<String> additionalSecurityGroupIDs) {
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on OpenStack.
     */
    @JsonProperty("rootVolume")
    public RootVolume getRootVolume() {
        return rootVolume;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on OpenStack.
     */
    @JsonProperty("rootVolume")
    public void setRootVolume(RootVolume rootVolume) {
        this.rootVolume = rootVolume;
    }

    /**
     * ServerGroupPolicy will be used to create the Server Group that will contain all the machines of this MachinePool. Defaults to "soft-anti-affinity".
     */
    @JsonProperty("serverGroupPolicy")
    public String getServerGroupPolicy() {
        return serverGroupPolicy;
    }

    /**
     * ServerGroupPolicy will be used to create the Server Group that will contain all the machines of this MachinePool. Defaults to "soft-anti-affinity".
     */
    @JsonProperty("serverGroupPolicy")
    public void setServerGroupPolicy(String serverGroupPolicy) {
        this.serverGroupPolicy = serverGroupPolicy;
    }

    /**
     * FlavorName defines the OpenStack Nova flavor. eg. m1.large
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * FlavorName defines the OpenStack Nova flavor. eg. m1.large
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Zones is the list of availability zones where the instances should be deployed. If no zones are provided, all instances will be deployed on OpenStack Nova default availability zone
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is the list of availability zones where the instances should be deployed. If no zones are provided, all instances will be deployed on OpenStack Nova default availability zone
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
        Object this$additionalNetworkIDs = this.getAdditionalNetworkIDs();
        Object other$additionalNetworkIDs = other.getAdditionalNetworkIDs();
        if (this$additionalNetworkIDs == null ? other$additionalNetworkIDs != null : !this$additionalNetworkIDs.equals(other$additionalNetworkIDs)) {
            return false;
        }
        Object this$additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        Object other$additionalSecurityGroupIDs = other.getAdditionalSecurityGroupIDs();
        if (this$additionalSecurityGroupIDs == null ? other$additionalSecurityGroupIDs != null : !this$additionalSecurityGroupIDs.equals(other$additionalSecurityGroupIDs)) {
            return false;
        }
        Object this$rootVolume = this.getRootVolume();
        Object other$rootVolume = other.getRootVolume();
        if (this$rootVolume == null ? other$rootVolume != null : !this$rootVolume.equals(other$rootVolume)) {
            return false;
        }
        Object this$serverGroupPolicy = this.getServerGroupPolicy();
        Object other$serverGroupPolicy = other.getServerGroupPolicy();
        if (this$serverGroupPolicy == null ? other$serverGroupPolicy != null : !this$serverGroupPolicy.equals(other$serverGroupPolicy)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        Object $additionalNetworkIDs = this.getAdditionalNetworkIDs();
        result = result * prime + ($additionalNetworkIDs == null ? 43 : $additionalNetworkIDs.hashCode());
        Object $additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        result = result * prime + ($additionalSecurityGroupIDs == null ? 43 : $additionalSecurityGroupIDs.hashCode());
        Object $rootVolume = this.getRootVolume();
        result = result * prime + ($rootVolume == null ? 43 : $rootVolume.hashCode());
        Object $serverGroupPolicy = this.getServerGroupPolicy();
        result = result * prime + ($serverGroupPolicy == null ? 43 : $serverGroupPolicy.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "additionalNetworkIDs=" + this.getAdditionalNetworkIDs() + ", additionalSecurityGroupIDs=" + this.getAdditionalSecurityGroupIDs() + ", rootVolume=" + this.getRootVolume() + ", serverGroupPolicy=" + this.getServerGroupPolicy() + ", type=" + this.getType() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
