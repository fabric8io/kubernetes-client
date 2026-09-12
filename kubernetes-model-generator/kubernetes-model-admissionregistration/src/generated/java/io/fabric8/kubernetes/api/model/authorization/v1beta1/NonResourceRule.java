
package io.fabric8.kubernetes.api.model.authorization.v1beta1;

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
 * NonResourceRule holds information that describes a rule for the non-resource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nonResourceURLs",
    "verbs"
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
public class NonResourceRule implements Editable<NonResourceRuleBuilder>, KubernetesResource
{

    @JsonProperty("nonResourceURLs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nonResourceURLs = new ArrayList<>();
    @JsonProperty("verbs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verbs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NonResourceRule() {
    }

    public NonResourceRule(List<String> nonResourceURLs, List<String> verbs) {
        super();
        this.nonResourceURLs = nonResourceURLs;
        this.verbs = verbs;
    }

    /**
     * NonResourceURLs is a set of partial urls that a user should have access to.  &#42;s are allowed, but only as the full, final step in the path.  "&#42;" means all.
     */
    @JsonProperty("nonResourceURLs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNonResourceURLs() {
        return nonResourceURLs;
    }

    /**
     * NonResourceURLs is a set of partial urls that a user should have access to.  &#42;s are allowed, but only as the full, final step in the path.  "&#42;" means all.
     */
    @JsonProperty("nonResourceURLs")
    public void setNonResourceURLs(List<String> nonResourceURLs) {
        this.nonResourceURLs = nonResourceURLs;
    }

    /**
     * Verb is a list of kubernetes non-resource API verbs, like: get, post, put, delete, patch, head, options.  "&#42;" means all.
     */
    @JsonProperty("verbs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVerbs() {
        return verbs;
    }

    /**
     * Verb is a list of kubernetes non-resource API verbs, like: get, post, put, delete, patch, head, options.  "&#42;" means all.
     */
    @JsonProperty("verbs")
    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

    @JsonIgnore
    public NonResourceRuleBuilder edit() {
        return new NonResourceRuleBuilder(this);
    }

    @JsonIgnore
    public NonResourceRuleBuilder toBuilder() {
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
        if (!(o instanceof NonResourceRule)) {
            return false;
        }
        NonResourceRule other = (NonResourceRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nonResourceURLs = this.getNonResourceURLs();
        Object other$nonResourceURLs = other.getNonResourceURLs();
        if (this$nonResourceURLs == null ? other$nonResourceURLs != null : !this$nonResourceURLs.equals(other$nonResourceURLs)) {
            return false;
        }
        Object this$verbs = this.getVerbs();
        Object other$verbs = other.getVerbs();
        if (this$verbs == null ? other$verbs != null : !this$verbs.equals(other$verbs)) {
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
        return other instanceof NonResourceRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nonResourceURLs = this.getNonResourceURLs();
        result = result * prime + ($nonResourceURLs == null ? 43 : $nonResourceURLs.hashCode());
        Object $verbs = this.getVerbs();
        result = result * prime + ($verbs == null ? 43 : $verbs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NonResourceRule(" + "nonResourceURLs=" + this.getNonResourceURLs() + ", verbs=" + this.getVerbs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
