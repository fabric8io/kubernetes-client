
package io.fabric8.openshift.api.model.monitoring.v1;

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
 * NamespaceSelector is a selector for selecting either all namespaces or a list of namespaces. If `any` is true, it takes precedence over `matchNames`. If `matchNames` is empty and `any` is false, it means that the objects are selected from the current namespace.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "any",
    "matchNames"
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
public class NamespaceSelector implements Editable<NamespaceSelectorBuilder>, KubernetesResource
{

    @JsonProperty("any")
    private Boolean any;
    @JsonProperty("matchNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> matchNames = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NamespaceSelector() {
    }

    public NamespaceSelector(Boolean any, List<String> matchNames) {
        super();
        this.any = any;
        this.matchNames = matchNames;
    }

    /**
     * any defines the boolean describing whether all namespaces are selected in contrast to a list restricting them.
     */
    @JsonProperty("any")
    public Boolean getAny() {
        return any;
    }

    /**
     * any defines the boolean describing whether all namespaces are selected in contrast to a list restricting them.
     */
    @JsonProperty("any")
    public void setAny(Boolean any) {
        this.any = any;
    }

    /**
     * matchNames defines the list of namespace names to select from.
     */
    @JsonProperty("matchNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMatchNames() {
        return matchNames;
    }

    /**
     * matchNames defines the list of namespace names to select from.
     */
    @JsonProperty("matchNames")
    public void setMatchNames(List<String> matchNames) {
        this.matchNames = matchNames;
    }

    @JsonIgnore
    public NamespaceSelectorBuilder edit() {
        return new NamespaceSelectorBuilder(this);
    }

    @JsonIgnore
    public NamespaceSelectorBuilder toBuilder() {
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
        if (!(o instanceof NamespaceSelector)) {
            return false;
        }
        NamespaceSelector other = (NamespaceSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$any = this.getAny();
        Object other$any = other.getAny();
        if (this$any == null ? other$any != null : !this$any.equals(other$any)) {
            return false;
        }
        Object this$matchNames = this.getMatchNames();
        Object other$matchNames = other.getMatchNames();
        if (this$matchNames == null ? other$matchNames != null : !this$matchNames.equals(other$matchNames)) {
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
        return other instanceof NamespaceSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $any = this.getAny();
        result = result * prime + ($any == null ? 43 : $any.hashCode());
        Object $matchNames = this.getMatchNames();
        result = result * prime + ($matchNames == null ? 43 : $matchNames.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NamespaceSelector(" + "any=" + this.getAny() + ", matchNames=" + this.getMatchNames() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
