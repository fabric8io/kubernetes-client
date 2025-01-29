
package io.fabric8.openshift.api.model.hive.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SyncIdentityProviderSpec defines the SyncIdentityProviderCommonSpec identity providers to sync along with ClusterDeploymentRefs indicating which clusters the SyncIdentityProvider applies to in the SyncIdentityProvider's namespace.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterDeploymentRefs",
    "identityProviders"
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
