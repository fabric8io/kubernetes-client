
package io.fabric8.openshift.api.model.hive.openstack.v1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * MachinePool stores the configuration for a machine pool installed on OpenStack.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalSecurityGroupIDs",
    "flavor",
    "rootVolume"
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

    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalSecurityGroupIDs = new ArrayList<>();
    @JsonProperty("flavor")
    private String flavor;
    @JsonProperty("rootVolume")
    private RootVolume rootVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(List<String> additionalSecurityGroupIDs, String flavor, RootVolume rootVolume) {
        super();
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
        this.flavor = flavor;
        this.rootVolume = rootVolume;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in the UUID format.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalSecurityGroupIDs() {
        return additionalSecurityGroupIDs;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in the UUID format.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    public void setAdditionalSecurityGroupIDs(List<String> additionalSecurityGroupIDs) {
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
    }

    /**
     * Flavor defines the OpenStack Nova flavor. eg. m1.large The json key here differs from the installer which uses both "computeFlavor" and type "type" depending on which type you're looking at, and the resulting field on the MachineSet is "flavor". We are opting to stay consistent with the end result.
     */
    @JsonProperty("flavor")
    public String getFlavor() {
        return flavor;
    }

    /**
     * Flavor defines the OpenStack Nova flavor. eg. m1.large The json key here differs from the installer which uses both "computeFlavor" and type "type" depending on which type you're looking at, and the resulting field on the MachineSet is "flavor". We are opting to stay consistent with the end result.
     */
    @JsonProperty("flavor")
    public void setFlavor(String flavor) {
        this.flavor = flavor;
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
        Object this$additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        Object other$additionalSecurityGroupIDs = other.getAdditionalSecurityGroupIDs();
        if (this$additionalSecurityGroupIDs == null ? other$additionalSecurityGroupIDs != null : !this$additionalSecurityGroupIDs.equals(other$additionalSecurityGroupIDs)) {
            return false;
        }
        Object this$flavor = this.getFlavor();
        Object other$flavor = other.getFlavor();
        if (this$flavor == null ? other$flavor != null : !this$flavor.equals(other$flavor)) {
            return false;
        }
        Object this$rootVolume = this.getRootVolume();
        Object other$rootVolume = other.getRootVolume();
        if (this$rootVolume == null ? other$rootVolume != null : !this$rootVolume.equals(other$rootVolume)) {
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
        Object $additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        result = result * prime + ($additionalSecurityGroupIDs == null ? 43 : $additionalSecurityGroupIDs.hashCode());
        Object $flavor = this.getFlavor();
        result = result * prime + ($flavor == null ? 43 : $flavor.hashCode());
        Object $rootVolume = this.getRootVolume();
        result = result * prime + ($rootVolume == null ? 43 : $rootVolume.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "additionalSecurityGroupIDs=" + this.getAdditionalSecurityGroupIDs() + ", flavor=" + this.getFlavor() + ", rootVolume=" + this.getRootVolume() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
