
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * FleetsMemberClassSpec defines the FleetsMemberSpec properties that may be shared across several Azure clusters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "managerName",
    "managerResourceGroup"
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
public class FleetsMemberClassSpec implements Editable<FleetsMemberClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("managerName")
    private String managerName;
    @JsonProperty("managerResourceGroup")
    private String managerResourceGroup;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FleetsMemberClassSpec() {
    }

    public FleetsMemberClassSpec(String group, String managerName, String managerResourceGroup) {
        super();
        this.group = group;
        this.managerName = managerName;
        this.managerResourceGroup = managerResourceGroup;
    }

    /**
     * Group is the group this member belongs to for multi-cluster update management.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * Group is the group this member belongs to for multi-cluster update management.
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * ManagerName is the name of the fleet manager.
     */
    @JsonProperty("managerName")
    public String getManagerName() {
        return managerName;
    }

    /**
     * ManagerName is the name of the fleet manager.
     */
    @JsonProperty("managerName")
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * ManagerResourceGroup is the resource group of the fleet manager.
     */
    @JsonProperty("managerResourceGroup")
    public String getManagerResourceGroup() {
        return managerResourceGroup;
    }

    /**
     * ManagerResourceGroup is the resource group of the fleet manager.
     */
    @JsonProperty("managerResourceGroup")
    public void setManagerResourceGroup(String managerResourceGroup) {
        this.managerResourceGroup = managerResourceGroup;
    }

    @JsonIgnore
    public FleetsMemberClassSpecBuilder edit() {
        return new FleetsMemberClassSpecBuilder(this);
    }

    @JsonIgnore
    public FleetsMemberClassSpecBuilder toBuilder() {
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
