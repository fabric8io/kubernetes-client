
package io.fabric8.openshift.api.model;

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
 * PodSecurityPolicyReviewSpec defines specification for PodSecurityPolicyReview
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceAccountNames",
    "template"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodSecurityPolicyReviewSpec implements Editable<PodSecurityPolicyReviewSpecBuilder>, KubernetesResource
{

    @JsonProperty("serviceAccountNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceAccountNames = new ArrayList<>();
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSecurityPolicyReviewSpec() {
    }

    public PodSecurityPolicyReviewSpec(List<String> serviceAccountNames, PodTemplateSpec template) {
        super();
        this.serviceAccountNames = serviceAccountNames;
        this.template = template;
    }

    /**
     * serviceAccountNames is an optional set of ServiceAccounts to run the check with. If serviceAccountNames is empty, the template.spec.serviceAccountName is used, unless it's empty, in which case "default" is used instead. If serviceAccountNames is specified, template.spec.serviceAccountName is ignored.
     */
    @JsonProperty("serviceAccountNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceAccountNames() {
        return serviceAccountNames;
    }

    /**
     * serviceAccountNames is an optional set of ServiceAccounts to run the check with. If serviceAccountNames is empty, the template.spec.serviceAccountName is used, unless it's empty, in which case "default" is used instead. If serviceAccountNames is specified, template.spec.serviceAccountName is ignored.
     */
    @JsonProperty("serviceAccountNames")
    public void setServiceAccountNames(List<String> serviceAccountNames) {
        this.serviceAccountNames = serviceAccountNames;
    }

    /**
     * PodSecurityPolicyReviewSpec defines specification for PodSecurityPolicyReview
     */
    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    /**
     * PodSecurityPolicyReviewSpec defines specification for PodSecurityPolicyReview
     */
    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    @JsonIgnore
    public PodSecurityPolicyReviewSpecBuilder edit() {
        return new PodSecurityPolicyReviewSpecBuilder(this);
    }

    @JsonIgnore
    public PodSecurityPolicyReviewSpecBuilder toBuilder() {
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
        if (!(o instanceof PodSecurityPolicyReviewSpec)) {
            return false;
        }
        PodSecurityPolicyReviewSpec other = (PodSecurityPolicyReviewSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$serviceAccountNames = this.getServiceAccountNames();
        Object other$serviceAccountNames = other.getServiceAccountNames();
        if (this$serviceAccountNames == null ? other$serviceAccountNames != null : !this$serviceAccountNames.equals(other$serviceAccountNames)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
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
        return other instanceof PodSecurityPolicyReviewSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $serviceAccountNames = this.getServiceAccountNames();
        result = result * prime + ($serviceAccountNames == null ? 43 : $serviceAccountNames.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodSecurityPolicyReviewSpec(" + "serviceAccountNames=" + this.getServiceAccountNames() + ", template=" + this.getTemplate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
