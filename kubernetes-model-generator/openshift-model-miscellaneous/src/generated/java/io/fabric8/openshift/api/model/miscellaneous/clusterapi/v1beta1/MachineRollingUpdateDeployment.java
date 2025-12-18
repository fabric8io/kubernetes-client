
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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

/**
 * MachineRollingUpdateDeployment is used to control the desired behavior of rolling update.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deletePolicy",
    "maxSurge",
    "maxUnavailable"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class MachineRollingUpdateDeployment implements Editable<MachineRollingUpdateDeploymentBuilder>, KubernetesResource
{

    @JsonProperty("deletePolicy")
    private String deletePolicy;
    @JsonProperty("maxSurge")
    private IntOrString maxSurge;
    @JsonProperty("maxUnavailable")
    private IntOrString maxUnavailable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineRollingUpdateDeployment() {
    }

    public MachineRollingUpdateDeployment(String deletePolicy, IntOrString maxSurge, IntOrString maxUnavailable) {
        super();
        this.deletePolicy = deletePolicy;
        this.maxSurge = maxSurge;
        this.maxUnavailable = maxUnavailable;
    }

    /**
     * deletePolicy defines the policy used by the MachineDeployment to identify nodes to delete when downscaling. Valid values are "Random, "Newest", "Oldest" When no value is supplied, the default DeletePolicy of MachineSet is used
     */
    @JsonProperty("deletePolicy")
    public String getDeletePolicy() {
        return deletePolicy;
    }

    /**
     * deletePolicy defines the policy used by the MachineDeployment to identify nodes to delete when downscaling. Valid values are "Random, "Newest", "Oldest" When no value is supplied, the default DeletePolicy of MachineSet is used
     */
    @JsonProperty("deletePolicy")
    public void setDeletePolicy(String deletePolicy) {
        this.deletePolicy = deletePolicy;
    }

    /**
     * MachineRollingUpdateDeployment is used to control the desired behavior of rolling update.
     */
    @JsonProperty("maxSurge")
    public IntOrString getMaxSurge() {
        return maxSurge;
    }

    /**
     * MachineRollingUpdateDeployment is used to control the desired behavior of rolling update.
     */
    @JsonProperty("maxSurge")
    public void setMaxSurge(IntOrString maxSurge) {
        this.maxSurge = maxSurge;
    }

    /**
     * MachineRollingUpdateDeployment is used to control the desired behavior of rolling update.
     */
    @JsonProperty("maxUnavailable")
    public IntOrString getMaxUnavailable() {
        return maxUnavailable;
    }

    /**
     * MachineRollingUpdateDeployment is used to control the desired behavior of rolling update.
     */
    @JsonProperty("maxUnavailable")
    public void setMaxUnavailable(IntOrString maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    @JsonIgnore
    public MachineRollingUpdateDeploymentBuilder edit() {
        return new MachineRollingUpdateDeploymentBuilder(this);
    }

    @JsonIgnore
    public MachineRollingUpdateDeploymentBuilder toBuilder() {
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

}
