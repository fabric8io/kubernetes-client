
package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

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
    "matchResources",
    "paramRef",
    "policyName",
    "validationActions"
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
public class ValidatingAdmissionPolicyBindingSpec implements KubernetesResource
{

    @JsonProperty("matchResources")
    private MatchResources matchResources;
    @JsonProperty("paramRef")
    private ParamRef paramRef;
    @JsonProperty("policyName")
    private String policyName;
    @JsonProperty("validationActions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> validationActions = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidatingAdmissionPolicyBindingSpec() {
    }

    public ValidatingAdmissionPolicyBindingSpec(MatchResources matchResources, ParamRef paramRef, String policyName, List<String> validationActions) {
        super();
        this.matchResources = matchResources;
        this.paramRef = paramRef;
        this.policyName = policyName;
        this.validationActions = validationActions;
    }

    @JsonProperty("matchResources")
    public MatchResources getMatchResources() {
        return matchResources;
    }

    @JsonProperty("matchResources")
    public void setMatchResources(MatchResources matchResources) {
        this.matchResources = matchResources;
    }

    @JsonProperty("paramRef")
    public ParamRef getParamRef() {
        return paramRef;
    }

    @JsonProperty("paramRef")
    public void setParamRef(ParamRef paramRef) {
        this.paramRef = paramRef;
    }

    @JsonProperty("policyName")
    public String getPolicyName() {
        return policyName;
    }

    @JsonProperty("policyName")
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    @JsonProperty("validationActions")
    public List<String> getValidationActions() {
        return validationActions;
    }

    @JsonProperty("validationActions")
    public void setValidationActions(List<String> validationActions) {
        this.validationActions = validationActions;
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
