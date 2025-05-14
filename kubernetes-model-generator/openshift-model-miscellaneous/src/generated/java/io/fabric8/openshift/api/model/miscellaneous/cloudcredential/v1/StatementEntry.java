
package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * StatementEntry models an AWS policy statement entry.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "effect",
    "policyCondition",
    "resource"
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
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class StatementEntry implements Editable<StatementEntryBuilder>, KubernetesResource
{

    @JsonProperty("action")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> action = new ArrayList<>();
    @JsonProperty("effect")
    private String effect;
    @JsonProperty("policyCondition")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Map<String, Object>> policyCondition = new LinkedHashMap<>();
    @JsonProperty("resource")
    private String resource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatementEntry() {
    }

    public StatementEntry(List<String> action, String effect, Map<String, Map<String, Object>> policyCondition, String resource) {
        super();
        this.action = action;
        this.effect = effect;
        this.policyCondition = policyCondition;
        this.resource = resource;
    }

    /**
     * Action describes the particular AWS service actions that should be allowed or denied. (i.e. ec2:StartInstances, iam:ChangePassword)
     */
    @JsonProperty("action")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAction() {
        return action;
    }

    /**
     * Action describes the particular AWS service actions that should be allowed or denied. (i.e. ec2:StartInstances, iam:ChangePassword)
     */
    @JsonProperty("action")
    public void setAction(List<String> action) {
        this.action = action;
    }

    /**
     * Effect indicates if this policy statement is to Allow or Deny.
     */
    @JsonProperty("effect")
    public String getEffect() {
        return effect;
    }

    /**
     * Effect indicates if this policy statement is to Allow or Deny.
     */
    @JsonProperty("effect")
    public void setEffect(String effect) {
        this.effect = effect;
    }

    /**
     * PolicyCondition specifies under which condition StatementEntry will apply
     */
    @JsonProperty("policyCondition")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Map<String, Object>> getPolicyCondition() {
        return policyCondition;
    }

    /**
     * PolicyCondition specifies under which condition StatementEntry will apply
     */
    @JsonProperty("policyCondition")
    public void setPolicyCondition(Map<String, Map<String, Object>> policyCondition) {
        this.policyCondition = policyCondition;
    }

    /**
     * Resource specifies the object(s) this statement should apply to. (or "&#42;" for all)
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * Resource specifies the object(s) this statement should apply to. (or "&#42;" for all)
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    @JsonIgnore
    public StatementEntryBuilder edit() {
        return new StatementEntryBuilder(this);
    }

    @JsonIgnore
    public StatementEntryBuilder toBuilder() {
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

}
