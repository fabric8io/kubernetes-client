
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HostSelector specifies matching criteria for labels on BareMetalHosts. This is used to limit the set of BareMetalHost objects considered for claiming for a Machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "inNamespace",
    "matchExpressions",
    "matchLabels"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HostSelector implements Editable<HostSelectorBuilder>, KubernetesResource
{

    @JsonProperty("inNamespace")
    private String inNamespace;
    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostSelectorRequirement> matchExpressions = new ArrayList<>();
    @JsonProperty("matchLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> matchLabels = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostSelector() {
    }

    public HostSelector(String inNamespace, List<HostSelectorRequirement> matchExpressions, Map<String, String> matchLabels) {
        super();
        this.inNamespace = inNamespace;
        this.matchExpressions = matchExpressions;
        this.matchLabels = matchLabels;
    }

    /**
     * InNamespace specifies a single namespace where the BareMetalHost should reside. If not specified, the selection will be done over all available namespaces with a compliant policy.
     */
    @JsonProperty("inNamespace")
    public String getInNamespace() {
        return inNamespace;
    }

    /**
     * InNamespace specifies a single namespace where the BareMetalHost should reside. If not specified, the selection will be done over all available namespaces with a compliant policy.
     */
    @JsonProperty("inNamespace")
    public void setInNamespace(String inNamespace) {
        this.inNamespace = inNamespace;
    }

    /**
     * Label match expressions that must be true on a chosen BareMetalHost
     */
    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostSelectorRequirement> getMatchExpressions() {
        return matchExpressions;
    }

    /**
     * Label match expressions that must be true on a chosen BareMetalHost
     */
    @JsonProperty("matchExpressions")
    public void setMatchExpressions(List<HostSelectorRequirement> matchExpressions) {
        this.matchExpressions = matchExpressions;
    }

    /**
     * Key/value pairs of labels that must exist on a chosen BareMetalHost
     */
    @JsonProperty("matchLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getMatchLabels() {
        return matchLabels;
    }

    /**
     * Key/value pairs of labels that must exist on a chosen BareMetalHost
     */
    @JsonProperty("matchLabels")
    public void setMatchLabels(Map<String, String> matchLabels) {
        this.matchLabels = matchLabels;
    }

    @JsonIgnore
    public HostSelectorBuilder edit() {
        return new HostSelectorBuilder(this);
    }

    @JsonIgnore
    public HostSelectorBuilder toBuilder() {
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
        if (!(o instanceof HostSelector)) {
            return false;
        }
        HostSelector other = (HostSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$inNamespace = this.getInNamespace();
        Object other$inNamespace = other.getInNamespace();
        if (this$inNamespace == null ? other$inNamespace != null : !this$inNamespace.equals(other$inNamespace)) {
            return false;
        }
        Object this$matchExpressions = this.getMatchExpressions();
        Object other$matchExpressions = other.getMatchExpressions();
        if (this$matchExpressions == null ? other$matchExpressions != null : !this$matchExpressions.equals(other$matchExpressions)) {
            return false;
        }
        Object this$matchLabels = this.getMatchLabels();
        Object other$matchLabels = other.getMatchLabels();
        if (this$matchLabels == null ? other$matchLabels != null : !this$matchLabels.equals(other$matchLabels)) {
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
        return other instanceof HostSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $inNamespace = this.getInNamespace();
        result = result * prime + ($inNamespace == null ? 43 : $inNamespace.hashCode());
        Object $matchExpressions = this.getMatchExpressions();
        result = result * prime + ($matchExpressions == null ? 43 : $matchExpressions.hashCode());
        Object $matchLabels = this.getMatchLabels();
        result = result * prime + ($matchLabels == null ? 43 : $matchLabels.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostSelector(" + "inNamespace=" + this.getInNamespace() + ", matchExpressions=" + this.getMatchExpressions() + ", matchLabels=" + this.getMatchLabels() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
