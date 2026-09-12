
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
 * ResourceRequest is a request for resources from one particular driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namedResources",
    "vendorParameters"
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
public class ResourceRequest implements Editable<ResourceRequestBuilder>, KubernetesResource
{

    @JsonProperty("namedResources")
    private NamedResourcesRequest namedResources;
    @JsonProperty("vendorParameters")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object vendorParameters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceRequest() {
    }

    public ResourceRequest(NamedResourcesRequest namedResources, Object vendorParameters) {
        super();
        this.namedResources = namedResources;
        this.vendorParameters = vendorParameters;
    }

    /**
     * ResourceRequest is a request for resources from one particular driver.
     */
    @JsonProperty("namedResources")
    public NamedResourcesRequest getNamedResources() {
        return namedResources;
    }

    /**
     * ResourceRequest is a request for resources from one particular driver.
     */
    @JsonProperty("namedResources")
    public void setNamedResources(NamedResourcesRequest namedResources) {
        this.namedResources = namedResources;
    }

    /**
     * ResourceRequest is a request for resources from one particular driver.
     */
    @JsonProperty("vendorParameters")
    public Object getVendorParameters() {
        return vendorParameters;
    }

    /**
     * ResourceRequest is a request for resources from one particular driver.
     */
    @JsonProperty("vendorParameters")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setVendorParameters(Object vendorParameters) {
        this.vendorParameters = vendorParameters;
    }

    @JsonIgnore
    public ResourceRequestBuilder edit() {
        return new ResourceRequestBuilder(this);
    }

    @JsonIgnore
    public ResourceRequestBuilder toBuilder() {
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
        if (!(o instanceof ResourceRequest)) {
            return false;
        }
        ResourceRequest other = (ResourceRequest) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$namedResources = this.getNamedResources();
        Object other$namedResources = other.getNamedResources();
        if (this$namedResources == null ? other$namedResources != null : !this$namedResources.equals(other$namedResources)) {
            return false;
        }
        Object this$vendorParameters = this.getVendorParameters();
        Object other$vendorParameters = other.getVendorParameters();
        if (this$vendorParameters == null ? other$vendorParameters != null : !this$vendorParameters.equals(other$vendorParameters)) {
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
        return other instanceof ResourceRequest;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $namedResources = this.getNamedResources();
        result = result * prime + ($namedResources == null ? 43 : $namedResources.hashCode());
        Object $vendorParameters = this.getVendorParameters();
        result = result * prime + ($vendorParameters == null ? 43 : $vendorParameters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceRequest(" + "namedResources=" + this.getNamedResources() + ", vendorParameters=" + this.getVendorParameters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
