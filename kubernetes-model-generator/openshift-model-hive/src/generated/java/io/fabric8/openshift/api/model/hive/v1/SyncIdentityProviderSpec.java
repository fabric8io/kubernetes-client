
package io.fabric8.openshift.api.model.hive.v1;

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
import io.fabric8.openshift.api.model.config.v1.IdentityProvider;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SyncIdentityProviderSpec defines the SyncIdentityProviderCommonSpec identity providers to sync along with ClusterDeploymentRefs indicating which clusters the SyncIdentityProvider applies to in the SyncIdentityProvider's namespace.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterDeploymentRefs",
    "identityProviders"
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
public class SyncIdentityProviderSpec implements Editable<SyncIdentityProviderSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterDeploymentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> clusterDeploymentRefs = new ArrayList<>();
    @JsonProperty("identityProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IdentityProvider> identityProviders = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SyncIdentityProviderSpec() {
    }

    public SyncIdentityProviderSpec(List<LocalObjectReference> clusterDeploymentRefs, List<IdentityProvider> identityProviders) {
        super();
        this.clusterDeploymentRefs = clusterDeploymentRefs;
        this.identityProviders = identityProviders;
    }

    /**
     * ClusterDeploymentRefs is the list of LocalObjectReference indicating which clusters the SyncSet applies to in the SyncSet's namespace.
     */
    @JsonProperty("clusterDeploymentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getClusterDeploymentRefs() {
        return clusterDeploymentRefs;
    }

    /**
     * ClusterDeploymentRefs is the list of LocalObjectReference indicating which clusters the SyncSet applies to in the SyncSet's namespace.
     */
    @JsonProperty("clusterDeploymentRefs")
    public void setClusterDeploymentRefs(List<LocalObjectReference> clusterDeploymentRefs) {
        this.clusterDeploymentRefs = clusterDeploymentRefs;
    }

    /**
     * IdentityProviders is an ordered list of ways for a user to identify themselves
     */
    @JsonProperty("identityProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IdentityProvider> getIdentityProviders() {
        return identityProviders;
    }

    /**
     * IdentityProviders is an ordered list of ways for a user to identify themselves
     */
    @JsonProperty("identityProviders")
    public void setIdentityProviders(List<IdentityProvider> identityProviders) {
        this.identityProviders = identityProviders;
    }

    @JsonIgnore
    public SyncIdentityProviderSpecBuilder edit() {
        return new SyncIdentityProviderSpecBuilder(this);
    }

    @JsonIgnore
    public SyncIdentityProviderSpecBuilder toBuilder() {
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
        if (!(o instanceof SyncIdentityProviderSpec)) {
            return false;
        }
        SyncIdentityProviderSpec other = (SyncIdentityProviderSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterDeploymentRefs = this.getClusterDeploymentRefs();
        Object other$clusterDeploymentRefs = other.getClusterDeploymentRefs();
        if (this$clusterDeploymentRefs == null ? other$clusterDeploymentRefs != null : !this$clusterDeploymentRefs.equals(other$clusterDeploymentRefs)) {
            return false;
        }
        Object this$identityProviders = this.getIdentityProviders();
        Object other$identityProviders = other.getIdentityProviders();
        if (this$identityProviders == null ? other$identityProviders != null : !this$identityProviders.equals(other$identityProviders)) {
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
        return other instanceof SyncIdentityProviderSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterDeploymentRefs = this.getClusterDeploymentRefs();
        result = result * prime + ($clusterDeploymentRefs == null ? 43 : $clusterDeploymentRefs.hashCode());
        Object $identityProviders = this.getIdentityProviders();
        result = result * prime + ($identityProviders == null ? 43 : $identityProviders.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SyncIdentityProviderSpec(" + "clusterDeploymentRefs=" + this.getClusterDeploymentRefs() + ", identityProviders=" + this.getIdentityProviders() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
