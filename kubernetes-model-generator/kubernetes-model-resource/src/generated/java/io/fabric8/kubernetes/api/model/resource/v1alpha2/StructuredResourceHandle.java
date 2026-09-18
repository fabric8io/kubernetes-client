
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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

/**
 * StructuredResourceHandle is the in-tree representation of the allocation result.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeName",
    "results",
    "vendorClaimParameters",
    "vendorClassParameters"
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
public class StructuredResourceHandle implements Editable<StructuredResourceHandleBuilder>, KubernetesResource
{

    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DriverAllocationResult> results = new ArrayList<>();
    @JsonProperty("vendorClaimParameters")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object vendorClaimParameters;
    @JsonProperty("vendorClassParameters")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object vendorClassParameters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StructuredResourceHandle() {
    }

    public StructuredResourceHandle(String nodeName, List<DriverAllocationResult> results, Object vendorClaimParameters, Object vendorClassParameters) {
        super();
        this.nodeName = nodeName;
        this.results = results;
        this.vendorClaimParameters = vendorClaimParameters;
        this.vendorClassParameters = vendorClassParameters;
    }

    /**
     * NodeName is the name of the node providing the necessary resources if the resources are local to a node.
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * NodeName is the name of the node providing the necessary resources if the resources are local to a node.
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Results lists all allocated driver resources.
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DriverAllocationResult> getResults() {
        return results;
    }

    /**
     * Results lists all allocated driver resources.
     */
    @JsonProperty("results")
    public void setResults(List<DriverAllocationResult> results) {
        this.results = results;
    }

    /**
     * StructuredResourceHandle is the in-tree representation of the allocation result.
     */
    @JsonProperty("vendorClaimParameters")
    public Object getVendorClaimParameters() {
        return vendorClaimParameters;
    }

    /**
     * StructuredResourceHandle is the in-tree representation of the allocation result.
     */
    @JsonProperty("vendorClaimParameters")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setVendorClaimParameters(Object vendorClaimParameters) {
        this.vendorClaimParameters = vendorClaimParameters;
    }

    /**
     * StructuredResourceHandle is the in-tree representation of the allocation result.
     */
    @JsonProperty("vendorClassParameters")
    public Object getVendorClassParameters() {
        return vendorClassParameters;
    }

    /**
     * StructuredResourceHandle is the in-tree representation of the allocation result.
     */
    @JsonProperty("vendorClassParameters")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setVendorClassParameters(Object vendorClassParameters) {
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
        if (!(o instanceof StructuredResourceHandle)) {
            return false;
        }
        StructuredResourceHandle other = (StructuredResourceHandle) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nodeName = this.getNodeName();
        Object other$nodeName = other.getNodeName();
        if (this$nodeName == null ? other$nodeName != null : !this$nodeName.equals(other$nodeName)) {
            return false;
        }
        Object this$results = this.getResults();
        Object other$results = other.getResults();
        if (this$results == null ? other$results != null : !this$results.equals(other$results)) {
            return false;
        }
        Object this$vendorClaimParameters = this.getVendorClaimParameters();
        Object other$vendorClaimParameters = other.getVendorClaimParameters();
        if (this$vendorClaimParameters == null ? other$vendorClaimParameters != null : !this$vendorClaimParameters.equals(other$vendorClaimParameters)) {
            return false;
        }
        Object this$vendorClassParameters = this.getVendorClassParameters();
        Object other$vendorClassParameters = other.getVendorClassParameters();
        if (this$vendorClassParameters == null ? other$vendorClassParameters != null : !this$vendorClassParameters.equals(other$vendorClassParameters)) {
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
        return other instanceof StructuredResourceHandle;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $results = this.getResults();
        result = result * prime + ($results == null ? 43 : $results.hashCode());
        Object $vendorClaimParameters = this.getVendorClaimParameters();
        result = result * prime + ($vendorClaimParameters == null ? 43 : $vendorClaimParameters.hashCode());
        Object $vendorClassParameters = this.getVendorClassParameters();
        result = result * prime + ($vendorClassParameters == null ? 43 : $vendorClassParameters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StructuredResourceHandle(" + "nodeName=" + this.getNodeName() + ", results=" + this.getResults() + ", vendorClaimParameters=" + this.getVendorClaimParameters() + ", vendorClassParameters=" + this.getVendorClassParameters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
