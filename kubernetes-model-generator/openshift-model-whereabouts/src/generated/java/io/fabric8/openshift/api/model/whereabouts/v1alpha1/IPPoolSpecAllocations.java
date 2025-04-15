
package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IPAllocation represents metadata about the pod/container owner of a specific IP
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "ifname",
    "podref"
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
public class IPPoolSpecAllocations implements Editable<IPPoolSpecAllocationsBuilder>, KubernetesResource
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("ifname")
    private String ifname;
    @JsonProperty("podref")
    private String podref;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPPoolSpecAllocations() {
    }

    public IPPoolSpecAllocations(String id, String ifname, String podref) {
        super();
        this.id = id;
        this.ifname = ifname;
        this.podref = podref;
    }

    /**
     * IPAllocation represents metadata about the pod/container owner of a specific IP
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * IPAllocation represents metadata about the pod/container owner of a specific IP
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * IPAllocation represents metadata about the pod/container owner of a specific IP
     */
    @JsonProperty("ifname")
    public String getIfname() {
        return ifname;
    }

    /**
     * IPAllocation represents metadata about the pod/container owner of a specific IP
     */
    @JsonProperty("ifname")
    public void setIfname(String ifname) {
        this.ifname = ifname;
    }

    /**
     * IPAllocation represents metadata about the pod/container owner of a specific IP
     */
    @JsonProperty("podref")
    public String getPodref() {
        return podref;
    }

    /**
     * IPAllocation represents metadata about the pod/container owner of a specific IP
     */
    @JsonProperty("podref")
    public void setPodref(String podref) {
        this.podref = podref;
    }

    @JsonIgnore
    public IPPoolSpecAllocationsBuilder edit() {
        return new IPPoolSpecAllocationsBuilder(this);
    }

    @JsonIgnore
    public IPPoolSpecAllocationsBuilder toBuilder() {
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
