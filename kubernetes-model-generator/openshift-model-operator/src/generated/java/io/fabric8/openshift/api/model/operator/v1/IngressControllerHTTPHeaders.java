
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "forwardedHeaderPolicy",
    "headerNameCaseAdjustments",
    "uniqueId"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class IngressControllerHTTPHeaders implements KubernetesResource
{

    @JsonProperty("forwardedHeaderPolicy")
    private String forwardedHeaderPolicy;
    @JsonProperty("headerNameCaseAdjustments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> headerNameCaseAdjustments = new ArrayList<String>();
    @JsonProperty("uniqueId")
    private IngressControllerHTTPUniqueIdHeaderPolicy uniqueId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerHTTPHeaders() {
    }

    public IngressControllerHTTPHeaders(String forwardedHeaderPolicy, List<String> headerNameCaseAdjustments, IngressControllerHTTPUniqueIdHeaderPolicy uniqueId) {
        super();
        this.forwardedHeaderPolicy = forwardedHeaderPolicy;
        this.headerNameCaseAdjustments = headerNameCaseAdjustments;
        this.uniqueId = uniqueId;
    }

    @JsonProperty("forwardedHeaderPolicy")
    public String getForwardedHeaderPolicy() {
        return forwardedHeaderPolicy;
    }

    @JsonProperty("forwardedHeaderPolicy")
    public void setForwardedHeaderPolicy(String forwardedHeaderPolicy) {
        this.forwardedHeaderPolicy = forwardedHeaderPolicy;
    }

    @JsonProperty("headerNameCaseAdjustments")
    public List<String> getHeaderNameCaseAdjustments() {
        return headerNameCaseAdjustments;
    }

    @JsonProperty("headerNameCaseAdjustments")
    public void setHeaderNameCaseAdjustments(List<String> headerNameCaseAdjustments) {
        this.headerNameCaseAdjustments = headerNameCaseAdjustments;
    }

    @JsonProperty("uniqueId")
    public IngressControllerHTTPUniqueIdHeaderPolicy getUniqueId() {
        return uniqueId;
    }

    @JsonProperty("uniqueId")
    public void setUniqueId(IngressControllerHTTPUniqueIdHeaderPolicy uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
