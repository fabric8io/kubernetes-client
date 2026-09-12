
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HostDeployPolicySpec defines the desired state of HostDeployPolicy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostClaimNamespaces"
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
public class HostDeployPolicySpec implements Editable<HostDeployPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("hostClaimNamespaces")
    private HostClaimNamespaces hostClaimNamespaces;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostDeployPolicySpec() {
    }

    public HostDeployPolicySpec(HostClaimNamespaces hostClaimNamespaces) {
        super();
        this.hostClaimNamespaces = hostClaimNamespaces;
    }

    /**
     * HostDeployPolicySpec defines the desired state of HostDeployPolicy.
     */
    @JsonProperty("hostClaimNamespaces")
    public HostClaimNamespaces getHostClaimNamespaces() {
        return hostClaimNamespaces;
    }

    /**
     * HostDeployPolicySpec defines the desired state of HostDeployPolicy.
     */
    @JsonProperty("hostClaimNamespaces")
    public void setHostClaimNamespaces(HostClaimNamespaces hostClaimNamespaces) {
        this.hostClaimNamespaces = hostClaimNamespaces;
    }

    @JsonIgnore
    public HostDeployPolicySpecBuilder edit() {
        return new HostDeployPolicySpecBuilder(this);
    }

    @JsonIgnore
    public HostDeployPolicySpecBuilder toBuilder() {
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
        if (!(o instanceof HostDeployPolicySpec)) {
            return false;
        }
        HostDeployPolicySpec other = (HostDeployPolicySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hostClaimNamespaces = this.getHostClaimNamespaces();
        Object other$hostClaimNamespaces = other.getHostClaimNamespaces();
        if (this$hostClaimNamespaces == null ? other$hostClaimNamespaces != null : !this$hostClaimNamespaces.equals(other$hostClaimNamespaces)) {
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
        return other instanceof HostDeployPolicySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hostClaimNamespaces = this.getHostClaimNamespaces();
        result = result * prime + ($hostClaimNamespaces == null ? 43 : $hostClaimNamespaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostDeployPolicySpec(" + "hostClaimNamespaces=" + this.getHostClaimNamespaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
