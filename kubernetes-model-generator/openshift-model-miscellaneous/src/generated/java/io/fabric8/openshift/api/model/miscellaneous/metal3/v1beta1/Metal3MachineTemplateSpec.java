
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

/**
 * Metal3MachineTemplateSpec defines the desired state of Metal3MachineTemplate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeReuse",
    "template"
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Metal3MachineTemplateSpec)) {
            return false;
        }
        Metal3MachineTemplateSpec other = (Metal3MachineTemplateSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nodeReuse = this.getNodeReuse();
        Object other$nodeReuse = other.getNodeReuse();
        if (this$nodeReuse == null ? other$nodeReuse != null : !this$nodeReuse.equals(other$nodeReuse)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
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
        return other instanceof Metal3MachineTemplateSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nodeReuse = this.getNodeReuse();
        result = result * prime + ($nodeReuse == null ? 43 : $nodeReuse.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metal3MachineTemplateSpec(" + "nodeReuse=" + this.getNodeReuse() + ", template=" + this.getTemplate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
