
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "nodeName",
    "results",
    "vendorClaimParameters",
    "vendorClassParameters"
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
public class StructuredResourceHandle implements Editable<StructuredResourceHandleBuilder> , KubernetesResource
{

    @JsonProperty("nodeName")
    private java.lang.String nodeName;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DriverAllocationResult> results = new ArrayList<>();
    @JsonProperty("vendorClaimParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> vendorClaimParameters = new LinkedHashMap<>();
    @JsonProperty("vendorClassParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> vendorClassParameters = new LinkedHashMap<>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StructuredResourceHandle() {
    }

    public StructuredResourceHandle(java.lang.String nodeName, List<DriverAllocationResult> results, Map<String, Object> vendorClaimParameters, Map<String, Object> vendorClassParameters) {
        super();
        this.nodeName = nodeName;
        this.results = results;
        this.vendorClaimParameters = vendorClaimParameters;
        this.vendorClassParameters = vendorClassParameters;
    }

    @JsonProperty("nodeName")
    public java.lang.String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(java.lang.String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DriverAllocationResult> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<DriverAllocationResult> results) {
        this.results = results;
    }

    @JsonProperty("vendorClaimParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getVendorClaimParameters() {
        return vendorClaimParameters;
    }

    @JsonProperty("vendorClaimParameters")
    public void setVendorClaimParameters(Map<String, Object> vendorClaimParameters) {
        this.vendorClaimParameters = vendorClaimParameters;
    }

    @JsonProperty("vendorClassParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getVendorClassParameters() {
        return vendorClassParameters;
    }

    @JsonProperty("vendorClassParameters")
    public void setVendorClassParameters(Map<String, Object> vendorClassParameters) {
        this.vendorClassParameters = vendorClassParameters;
    }

    @JsonIgnore
    public StructuredResourceHandleBuilder edit() {
        return new StructuredResourceHandleBuilder(this);
    }

    @JsonIgnore
    public StructuredResourceHandleBuilder toBuilder() {
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
