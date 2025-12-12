
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * ManagedClusterSecurityProfile defines the security profile for the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "azureKeyVaultKms",
    "defender",
    "imageCleaner",
    "workloadIdentity"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class ManagedClusterSecurityProfile implements Editable<ManagedClusterSecurityProfileBuilder>, KubernetesResource
{

    @JsonProperty("azureKeyVaultKms")
    private AzureKeyVaultKms azureKeyVaultKms;
    @JsonProperty("defender")
    private ManagedClusterSecurityProfileDefender defender;
    @JsonProperty("imageCleaner")
    private ManagedClusterSecurityProfileImageCleaner imageCleaner;
    @JsonProperty("workloadIdentity")
    private ManagedClusterSecurityProfileWorkloadIdentity workloadIdentity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedClusterSecurityProfile() {
    }

    public ManagedClusterSecurityProfile(AzureKeyVaultKms azureKeyVaultKms, ManagedClusterSecurityProfileDefender defender, ManagedClusterSecurityProfileImageCleaner imageCleaner, ManagedClusterSecurityProfileWorkloadIdentity workloadIdentity) {
        super();
        this.azureKeyVaultKms = azureKeyVaultKms;
        this.defender = defender;
        this.imageCleaner = imageCleaner;
        this.workloadIdentity = workloadIdentity;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("azureKeyVaultKms")
    public AzureKeyVaultKms getAzureKeyVaultKms() {
        return azureKeyVaultKms;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("azureKeyVaultKms")
    public void setAzureKeyVaultKms(AzureKeyVaultKms azureKeyVaultKms) {
        this.azureKeyVaultKms = azureKeyVaultKms;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("defender")
    public ManagedClusterSecurityProfileDefender getDefender() {
        return defender;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("defender")
    public void setDefender(ManagedClusterSecurityProfileDefender defender) {
        this.defender = defender;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("imageCleaner")
    public ManagedClusterSecurityProfileImageCleaner getImageCleaner() {
        return imageCleaner;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("imageCleaner")
    public void setImageCleaner(ManagedClusterSecurityProfileImageCleaner imageCleaner) {
        this.imageCleaner = imageCleaner;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("workloadIdentity")
    public ManagedClusterSecurityProfileWorkloadIdentity getWorkloadIdentity() {
        return workloadIdentity;
    }

    /**
     * ManagedClusterSecurityProfile defines the security profile for the cluster.
     */
    @JsonProperty("workloadIdentity")
    public void setWorkloadIdentity(ManagedClusterSecurityProfileWorkloadIdentity workloadIdentity) {
        this.workloadIdentity = workloadIdentity;
    }

    @JsonIgnore
    public ManagedClusterSecurityProfileBuilder edit() {
        return new ManagedClusterSecurityProfileBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterSecurityProfileBuilder toBuilder() {
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
