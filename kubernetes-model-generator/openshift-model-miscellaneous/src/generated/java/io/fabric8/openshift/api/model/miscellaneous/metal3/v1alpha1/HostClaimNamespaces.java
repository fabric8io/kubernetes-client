
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hasLabels",
    "nameMatches",
    "names"
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
public class HostClaimNamespaces implements Editable<HostClaimNamespacesBuilder>, KubernetesResource
{

    @JsonProperty("hasLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NameValuePair> hasLabels = new ArrayList<>();
    @JsonProperty("nameMatches")
    private String nameMatches;
    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> names = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostClaimNamespaces() {
    }

    public HostClaimNamespaces(List<NameValuePair> hasLabels, String nameMatches, List<String> names) {
        super();
        this.hasLabels = hasLabels;
        this.nameMatches = nameMatches;
        this.names = names;
    }

    /**
     * HasLabels is a list of label names and their associated value. The namespace should have all of those labels. If the value is specified, it must also match.
     */
    @JsonProperty("hasLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NameValuePair> getHasLabels() {
        return hasLabels;
    }

    /**
     * HasLabels is a list of label names and their associated value. The namespace should have all of those labels. If the value is specified, it must also match.
     */
    @JsonProperty("hasLabels")
    public void setHasLabels(List<NameValuePair> hasLabels) {
        this.hasLabels = hasLabels;
    }

    /**
     * NameMatches is a string interpreted as a regular expression that must be matched by the namespace of the HostClaim.
     */
    @JsonProperty("nameMatches")
    public String getNameMatches() {
        return nameMatches;
    }

    /**
     * NameMatches is a string interpreted as a regular expression that must be matched by the namespace of the HostClaim.
     */
    @JsonProperty("nameMatches")
    public void setNameMatches(String nameMatches) {
        this.nameMatches = nameMatches;
    }

    /**
     * Namespaces is a list of namespace names where the hostClaim is authorized to reside in.
     */
    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNames() {
        return names;
    }

    /**
     * Namespaces is a list of namespace names where the hostClaim is authorized to reside in.
     */
    @JsonProperty("names")
    public void setNames(List<String> names) {
        this.names = names;
    }

    @JsonIgnore
    public HostClaimNamespacesBuilder edit() {
        return new HostClaimNamespacesBuilder(this);
    }

    @JsonIgnore
    public HostClaimNamespacesBuilder toBuilder() {
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
        if (!(o instanceof HostClaimNamespaces)) {
            return false;
        }
        HostClaimNamespaces other = (HostClaimNamespaces) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hasLabels = this.getHasLabels();
        Object other$hasLabels = other.getHasLabels();
        if (this$hasLabels == null ? other$hasLabels != null : !this$hasLabels.equals(other$hasLabels)) {
            return false;
        }
        Object this$nameMatches = this.getNameMatches();
        Object other$nameMatches = other.getNameMatches();
        if (this$nameMatches == null ? other$nameMatches != null : !this$nameMatches.equals(other$nameMatches)) {
            return false;
        }
        Object this$names = this.getNames();
        Object other$names = other.getNames();
        if (this$names == null ? other$names != null : !this$names.equals(other$names)) {
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
        return other instanceof HostClaimNamespaces;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hasLabels = this.getHasLabels();
        result = result * prime + ($hasLabels == null ? 43 : $hasLabels.hashCode());
        Object $nameMatches = this.getNameMatches();
        result = result * prime + ($nameMatches == null ? 43 : $nameMatches.hashCode());
        Object $names = this.getNames();
        result = result * prime + ($names == null ? 43 : $names.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostClaimNamespaces(" + "hasLabels=" + this.getHasLabels() + ", nameMatches=" + this.getNameMatches() + ", names=" + this.getNames() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
