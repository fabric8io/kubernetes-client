
package io.fabric8.openshift.api.model.operator.v1;

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
    "actions",
    "forwardedHeaderPolicy",
    "headerNameCaseAdjustments",
    "uniqueId"
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
public class IngressControllerSpecHttpHeaders implements Editable<IngressControllerSpecHttpHeadersBuilder> , KubernetesResource
{

    @JsonProperty("actions")
    private IngressControllerSpecHHActions actions;
    @JsonProperty("forwardedHeaderPolicy")
    private String forwardedHeaderPolicy;
    @JsonProperty("headerNameCaseAdjustments")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object headerNameCaseAdjustments;
    @JsonProperty("uniqueId")
    private IngressControllerSpecHHUniqueId uniqueId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerSpecHttpHeaders() {
    }

    public IngressControllerSpecHttpHeaders(IngressControllerSpecHHActions actions, String forwardedHeaderPolicy, Object headerNameCaseAdjustments, IngressControllerSpecHHUniqueId uniqueId) {
        super();
        this.actions = actions;
        this.forwardedHeaderPolicy = forwardedHeaderPolicy;
        this.headerNameCaseAdjustments = headerNameCaseAdjustments;
        this.uniqueId = uniqueId;
    }

    @JsonProperty("actions")
    public IngressControllerSpecHHActions getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(IngressControllerSpecHHActions actions) {
        this.actions = actions;
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
    public Object getHeaderNameCaseAdjustments() {
        return headerNameCaseAdjustments;
    }

    @JsonProperty("headerNameCaseAdjustments")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setHeaderNameCaseAdjustments(Object headerNameCaseAdjustments) {
        this.headerNameCaseAdjustments = headerNameCaseAdjustments;
    }

    @JsonProperty("uniqueId")
    public IngressControllerSpecHHUniqueId getUniqueId() {
        return uniqueId;
    }

    @JsonProperty("uniqueId")
    public void setUniqueId(IngressControllerSpecHHUniqueId uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonIgnore
    public IngressControllerSpecHttpHeadersBuilder edit() {
        return new IngressControllerSpecHttpHeadersBuilder(this);
    }

    @JsonIgnore
    public IngressControllerSpecHttpHeadersBuilder toBuilder() {
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
