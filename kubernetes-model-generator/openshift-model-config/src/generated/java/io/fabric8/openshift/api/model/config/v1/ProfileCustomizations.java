
package io.fabric8.openshift.api.model.config.v1;

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
 * ProfileCustomizations contains various parameters for modifying the default behavior of certain profiles
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dynamicResourceAllocation"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ProfileCustomizations implements Editable<ProfileCustomizationsBuilder>, KubernetesResource
{

    @JsonProperty("dynamicResourceAllocation")
    private String dynamicResourceAllocation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProfileCustomizations() {
    }

    public ProfileCustomizations(String dynamicResourceAllocation) {
        super();
        this.dynamicResourceAllocation = dynamicResourceAllocation;
    }

    /**
     * dynamicResourceAllocation allows to enable or disable dynamic resource allocation within the scheduler. Dynamic resource allocation is an API for requesting and sharing resources between pods and containers inside a pod. Third-party resource drivers are responsible for tracking and allocating resources. Different kinds of resources support arbitrary parameters for defining requirements and initialization. Valid values are Enabled, Disabled and omitted. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is Disabled.
     */
    @JsonProperty("dynamicResourceAllocation")
    public String getDynamicResourceAllocation() {
        return dynamicResourceAllocation;
    }

    /**
     * dynamicResourceAllocation allows to enable or disable dynamic resource allocation within the scheduler. Dynamic resource allocation is an API for requesting and sharing resources between pods and containers inside a pod. Third-party resource drivers are responsible for tracking and allocating resources. Different kinds of resources support arbitrary parameters for defining requirements and initialization. Valid values are Enabled, Disabled and omitted. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is Disabled.
     */
    @JsonProperty("dynamicResourceAllocation")
    public void setDynamicResourceAllocation(String dynamicResourceAllocation) {
        this.dynamicResourceAllocation = dynamicResourceAllocation;
    }

    @JsonIgnore
    public ProfileCustomizationsBuilder edit() {
        return new ProfileCustomizationsBuilder(this);
    }

    @JsonIgnore
    public ProfileCustomizationsBuilder toBuilder() {
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
