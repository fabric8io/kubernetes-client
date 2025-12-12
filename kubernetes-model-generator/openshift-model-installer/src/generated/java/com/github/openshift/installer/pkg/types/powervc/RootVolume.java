
package com.github.openshift.installer.pkg.types.powervc;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RootVolume defines the storage for an instance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "size",
    "type",
    "types",
    "zones"
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
public class RootVolume implements Editable<RootVolumeBuilder>, KubernetesResource
{

    @JsonProperty("size")
    private Integer size;
    @JsonProperty("type")
    private String type;
    @JsonProperty("types")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> types = new ArrayList<>();
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RootVolume() {
    }

    public RootVolume(Integer size, String type, List<String> types, List<String> zones) {
        super();
        this.size = size;
        this.type = type;
        this.types = types;
        this.zones = zones;
    }

    /**
     * Size defines the size of the volume in gibibytes (GiB). Required
     */
    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    /**
     * Size defines the size of the volume in gibibytes (GiB). Required
     */
    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Type defines the type of the volume. Deprecated: Use Types instead.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines the type of the volume. Deprecated: Use Types instead.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Types is the list of the volume types of the root volumes. This is mutually exclusive with Type.
     */
    @JsonProperty("types")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTypes() {
        return types;
    }

    /**
     * Types is the list of the volume types of the root volumes. This is mutually exclusive with Type.
     */
    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * Zones is the list of availability zones where the root volumes should be deployed. If no zones are provided, all instances will be deployed on OpenStack Cinder default availability zone
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is the list of availability zones where the root volumes should be deployed. If no zones are provided, all instances will be deployed on OpenStack Cinder default availability zone
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public RootVolumeBuilder edit() {
        return new RootVolumeBuilder(this);
    }

    @JsonIgnore
    public RootVolumeBuilder toBuilder() {
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
