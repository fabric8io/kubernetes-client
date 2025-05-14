
package io.fabric8.openshift.api.model;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodSecurityPolicySubjectReviewStatus contains information/status for PodSecurityPolicySubjectReview.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedBy",
    "reason",
    "template"
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
public class PodSecurityPolicySubjectReviewStatus implements Editable<PodSecurityPolicySubjectReviewStatusBuilder>, KubernetesResource
{

    @JsonProperty("allowedBy")
    private ObjectReference allowedBy;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSecurityPolicySubjectReviewStatus() {
    }

    public PodSecurityPolicySubjectReviewStatus(ObjectReference allowedBy, String reason, PodTemplateSpec template) {
        super();
        this.allowedBy = allowedBy;
        this.reason = reason;
        this.template = template;
    }

    /**
     * PodSecurityPolicySubjectReviewStatus contains information/status for PodSecurityPolicySubjectReview.
     */
    @JsonProperty("allowedBy")
    public ObjectReference getAllowedBy() {
        return allowedBy;
    }

    /**
     * PodSecurityPolicySubjectReviewStatus contains information/status for PodSecurityPolicySubjectReview.
     */
    @JsonProperty("allowedBy")
    public void setAllowedBy(ObjectReference allowedBy) {
        this.allowedBy = allowedBy;
    }

    /**
     * A machine-readable description of why this operation is in the "Failure" status. If this value is empty there is no information available.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * A machine-readable description of why this operation is in the "Failure" status. If this value is empty there is no information available.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * PodSecurityPolicySubjectReviewStatus contains information/status for PodSecurityPolicySubjectReview.
     */
    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    /**
     * PodSecurityPolicySubjectReviewStatus contains information/status for PodSecurityPolicySubjectReview.
     */
    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    @JsonIgnore
    public PodSecurityPolicySubjectReviewStatusBuilder edit() {
        return new PodSecurityPolicySubjectReviewStatusBuilder(this);
    }

    @JsonIgnore
    public PodSecurityPolicySubjectReviewStatusBuilder toBuilder() {
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
