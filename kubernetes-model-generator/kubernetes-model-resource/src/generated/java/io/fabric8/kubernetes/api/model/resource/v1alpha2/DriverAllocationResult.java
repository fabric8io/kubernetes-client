
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namedResources",
    "vendorRequestParameters"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class DriverAllocationResult implements Editable<DriverAllocationResultBuilder> , KubernetesResource
{

    @JsonProperty("namedResources")
    private NamedResourcesAllocationResult namedResources;
    @JsonProperty("vendorRequestParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> vendorRequestParameters = new LinkedHashMap<>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DriverAllocationResult() {
    }

    public DriverAllocationResult(NamedResourcesAllocationResult namedResources, Map<String, Object> vendorRequestParameters) {
        super();
        this.namedResources = namedResources;
        this.vendorRequestParameters = vendorRequestParameters;
    }

    @JsonProperty("namedResources")
    public NamedResourcesAllocationResult getNamedResources() {
        return namedResources;
    }

    @JsonProperty("namedResources")
    public void setNamedResources(NamedResourcesAllocationResult namedResources) {
        this.namedResources = namedResources;
    }

    @JsonProperty("vendorRequestParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getVendorRequestParameters() {
        return vendorRequestParameters;
    }

    @JsonProperty("vendorRequestParameters")
    public void setVendorRequestParameters(Map<String, Object> vendorRequestParameters) {
        this.vendorRequestParameters = vendorRequestParameters;
    }

    @JsonIgnore
    public DriverAllocationResultBuilder edit() {
        return new DriverAllocationResultBuilder(this);
    }

    @JsonIgnore
    public DriverAllocationResultBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<java.lang.String, java.lang.Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
