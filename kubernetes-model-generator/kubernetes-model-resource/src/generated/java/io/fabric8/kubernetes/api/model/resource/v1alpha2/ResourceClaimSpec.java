
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
 * ResourceClaimSpec defines how a resource is to be allocated.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocationMode",
    "parametersRef",
    "resourceClassName"
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
public class ResourceClaimSpec implements Editable<ResourceClaimSpecBuilder>, KubernetesResource
{

    @JsonProperty("allocationMode")
    private String allocationMode;
    @JsonProperty("parametersRef")
    private ResourceClaimParametersReference parametersRef;
    @JsonProperty("resourceClassName")
    private String resourceClassName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceClaimSpec() {
    }

    public ResourceClaimSpec(String allocationMode, ResourceClaimParametersReference parametersRef, String resourceClassName) {
        super();
        this.allocationMode = allocationMode;
        this.parametersRef = parametersRef;
        this.resourceClassName = resourceClassName;
    }

    /**
     * Allocation can start immediately or when a Pod wants to use the resource. "WaitForFirstConsumer" is the default.
     */
    @JsonProperty("allocationMode")
    public String getAllocationMode() {
        return allocationMode;
    }

    /**
     * Allocation can start immediately or when a Pod wants to use the resource. "WaitForFirstConsumer" is the default.
     */
    @JsonProperty("allocationMode")
    public void setAllocationMode(String allocationMode) {
        this.allocationMode = allocationMode;
    }

    /**
     * ResourceClaimSpec defines how a resource is to be allocated.
     */
    @JsonProperty("parametersRef")
    public ResourceClaimParametersReference getParametersRef() {
        return parametersRef;
    }

    /**
     * ResourceClaimSpec defines how a resource is to be allocated.
     */
    @JsonProperty("parametersRef")
    public void setParametersRef(ResourceClaimParametersReference parametersRef) {
        this.parametersRef = parametersRef;
    }

    /**
     * ResourceClassName references the driver and additional parameters via the name of a ResourceClass that was created as part of the driver deployment.
     */
    @JsonProperty("resourceClassName")
    public String getResourceClassName() {
        return resourceClassName;
    }

    /**
     * ResourceClassName references the driver and additional parameters via the name of a ResourceClass that was created as part of the driver deployment.
     */
    @JsonProperty("resourceClassName")
    public void setResourceClassName(String resourceClassName) {
        this.resourceClassName = resourceClassName;
    }

    @JsonIgnore
    public ResourceClaimSpecBuilder edit() {
        return new ResourceClaimSpecBuilder(this);
    }

    @JsonIgnore
    public ResourceClaimSpecBuilder toBuilder() {
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
        if (!(o instanceof ResourceClaimSpec)) {
            return false;
        }
        ResourceClaimSpec other = (ResourceClaimSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allocationMode = this.getAllocationMode();
        Object other$allocationMode = other.getAllocationMode();
        if (this$allocationMode == null ? other$allocationMode != null : !this$allocationMode.equals(other$allocationMode)) {
            return false;
        }
        Object this$parametersRef = this.getParametersRef();
        Object other$parametersRef = other.getParametersRef();
        if (this$parametersRef == null ? other$parametersRef != null : !this$parametersRef.equals(other$parametersRef)) {
            return false;
        }
        Object this$resourceClassName = this.getResourceClassName();
        Object other$resourceClassName = other.getResourceClassName();
        if (this$resourceClassName == null ? other$resourceClassName != null : !this$resourceClassName.equals(other$resourceClassName)) {
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
        return other instanceof ResourceClaimSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allocationMode = this.getAllocationMode();
        result = result * prime + ($allocationMode == null ? 43 : $allocationMode.hashCode());
        Object $parametersRef = this.getParametersRef();
        result = result * prime + ($parametersRef == null ? 43 : $parametersRef.hashCode());
        Object $resourceClassName = this.getResourceClassName();
        result = result * prime + ($resourceClassName == null ? 43 : $resourceClassName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceClaimSpec(" + "allocationMode=" + this.getAllocationMode() + ", parametersRef=" + this.getParametersRef() + ", resourceClassName=" + this.getResourceClassName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
