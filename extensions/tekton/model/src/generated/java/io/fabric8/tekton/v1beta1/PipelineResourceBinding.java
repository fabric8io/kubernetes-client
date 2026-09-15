
package io.fabric8.tekton.v1beta1;

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
import io.fabric8.tekton.v1alpha1.PipelineResourceSpec;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PipelineResourceBinding connects a reference to an instance of a PipelineResource with a PipelineResource dependency that the Pipeline has declared<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "resourceRef",
    "resourceSpec"
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
public class PipelineResourceBinding implements Editable<PipelineResourceBindingBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceRef")
    private PipelineResourceRef resourceRef;
    @JsonProperty("resourceSpec")
    private PipelineResourceSpec resourceSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineResourceBinding() {
    }

    public PipelineResourceBinding(String name, PipelineResourceRef resourceRef, PipelineResourceSpec resourceSpec) {
        super();
        this.name = name;
        this.resourceRef = resourceRef;
        this.resourceSpec = resourceSpec;
    }

    /**
     * Name is the name of the PipelineResource in the Pipeline's declaration
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the PipelineResource in the Pipeline's declaration
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PipelineResourceBinding connects a reference to an instance of a PipelineResource with a PipelineResource dependency that the Pipeline has declared<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceRef")
    public PipelineResourceRef getResourceRef() {
        return resourceRef;
    }

    /**
     * PipelineResourceBinding connects a reference to an instance of a PipelineResource with a PipelineResource dependency that the Pipeline has declared<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceRef")
    public void setResourceRef(PipelineResourceRef resourceRef) {
        this.resourceRef = resourceRef;
    }

    /**
     * PipelineResourceBinding connects a reference to an instance of a PipelineResource with a PipelineResource dependency that the Pipeline has declared<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceSpec")
    public PipelineResourceSpec getResourceSpec() {
        return resourceSpec;
    }

    /**
     * PipelineResourceBinding connects a reference to an instance of a PipelineResource with a PipelineResource dependency that the Pipeline has declared<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceSpec")
    public void setResourceSpec(PipelineResourceSpec resourceSpec) {
        this.resourceSpec = resourceSpec;
    }

    @JsonIgnore
    public PipelineResourceBindingBuilder edit() {
        return new PipelineResourceBindingBuilder(this);
    }

    @JsonIgnore
    public PipelineResourceBindingBuilder toBuilder() {
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
        if (!(o instanceof PipelineResourceBinding)) {
            return false;
        }
        PipelineResourceBinding other = (PipelineResourceBinding) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$resourceRef = this.getResourceRef();
        Object other$resourceRef = other.getResourceRef();
        if (this$resourceRef == null ? other$resourceRef != null : !this$resourceRef.equals(other$resourceRef)) {
            return false;
        }
        Object this$resourceSpec = this.getResourceSpec();
        Object other$resourceSpec = other.getResourceSpec();
        if (this$resourceSpec == null ? other$resourceSpec != null : !this$resourceSpec.equals(other$resourceSpec)) {
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
        return other instanceof PipelineResourceBinding;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $resourceRef = this.getResourceRef();
        result = result * prime + ($resourceRef == null ? 43 : $resourceRef.hashCode());
        Object $resourceSpec = this.getResourceSpec();
        result = result * prime + ($resourceSpec == null ? 43 : $resourceSpec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PipelineResourceBinding(" + "name=" + this.getName() + ", resourceRef=" + this.getResourceRef() + ", resourceSpec=" + this.getResourceSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
