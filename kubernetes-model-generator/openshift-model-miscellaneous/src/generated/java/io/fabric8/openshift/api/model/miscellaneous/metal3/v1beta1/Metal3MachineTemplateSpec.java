
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * Metal3MachineTemplateSpec defines the desired state of Metal3MachineTemplate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeReuse",
    "template"
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
public class Metal3MachineTemplateSpec implements Editable<Metal3MachineTemplateSpecBuilder>, KubernetesResource
{

    @JsonProperty("nodeReuse")
    private Boolean nodeReuse;
    @JsonProperty("template")
    private Metal3MachineTemplateResource template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3MachineTemplateSpec() {
    }

    public Metal3MachineTemplateSpec(Boolean nodeReuse, Metal3MachineTemplateResource template) {
        super();
        this.nodeReuse = nodeReuse;
        this.template = template;
    }

    /**
     * When set to True, CAPM3 Machine controller will pick the same pool of BMHs' that were released during the upgrade operation.
     */
    @JsonProperty("nodeReuse")
    public Boolean getNodeReuse() {
        return nodeReuse;
    }

    /**
     * When set to True, CAPM3 Machine controller will pick the same pool of BMHs' that were released during the upgrade operation.
     */
    @JsonProperty("nodeReuse")
    public void setNodeReuse(Boolean nodeReuse) {
        this.nodeReuse = nodeReuse;
    }

    /**
     * Metal3MachineTemplateSpec defines the desired state of Metal3MachineTemplate.
     */
    @JsonProperty("template")
    public Metal3MachineTemplateResource getTemplate() {
        return template;
    }

    /**
     * Metal3MachineTemplateSpec defines the desired state of Metal3MachineTemplate.
     */
    @JsonProperty("template")
    public void setTemplate(Metal3MachineTemplateResource template) {
        this.template = template;
    }

    @JsonIgnore
    public Metal3MachineTemplateSpecBuilder edit() {
        return new Metal3MachineTemplateSpecBuilder(this);
    }

    @JsonIgnore
    public Metal3MachineTemplateSpecBuilder toBuilder() {
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
