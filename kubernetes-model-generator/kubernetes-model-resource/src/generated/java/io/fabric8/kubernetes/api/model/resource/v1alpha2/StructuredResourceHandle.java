
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
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(GenericKubernetesResource.class),
    @BuildableReference(RawExtension.class)
})
@Generated("jsonschema2pojo")
public class StructuredResourceHandle implements Editable<StructuredResourceHandleBuilder> , KubernetesResource
{

    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DriverAllocationResult> results = new ArrayList<>();
    @JsonProperty("vendorClaimParameters")
    private KubernetesResource vendorClaimParameters;
    @JsonProperty("vendorClassParameters")
    private KubernetesResource vendorClassParameters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StructuredResourceHandle() {
    }

    public StructuredResourceHandle(String nodeName, List<DriverAllocationResult> results, KubernetesResource vendorClaimParameters, KubernetesResource vendorClassParameters) {
        super();
        this.nodeName = nodeName;
        this.results = results;
        this.vendorClaimParameters = vendorClaimParameters;
        this.vendorClassParameters = vendorClassParameters;
    }

    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
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
    public KubernetesResource getVendorClaimParameters() {
        return vendorClaimParameters;
    }

    @JsonProperty("vendorClaimParameters")
    public void setVendorClaimParameters(KubernetesResource vendorClaimParameters) {
        this.vendorClaimParameters = vendorClaimParameters;
    }

    @JsonProperty("vendorClassParameters")
    public KubernetesResource getVendorClassParameters() {
        return vendorClassParameters;
    }

    @JsonProperty("vendorClassParameters")
    public void setVendorClassParameters(KubernetesResource vendorClassParameters) {
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
