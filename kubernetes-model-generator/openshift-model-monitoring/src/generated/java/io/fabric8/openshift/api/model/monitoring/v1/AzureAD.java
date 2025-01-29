
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureAD defines the configuration for remote write's azuread parameters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloud",
    "managedIdentity",
    "oauth",
    "sdk"
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
public class AzureAD implements Editable<AzureADBuilder>, KubernetesResource
{

    @JsonProperty("cloud")
    private String cloud;
    @JsonProperty("managedIdentity")
    private ManagedIdentity managedIdentity;
    @JsonProperty("oauth")
    private AzureOAuth oauth;
    @JsonProperty("sdk")
    private AzureSDK sdk;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureAD() {
    }

    public AzureAD(String cloud, ManagedIdentity managedIdentity, AzureOAuth oauth, AzureSDK sdk) {
        super();
        this.cloud = cloud;
        this.managedIdentity = managedIdentity;
        this.oauth = oauth;
        this.sdk = sdk;
    }

    /**
     * The Azure Cloud. Options are 'AzurePublic', 'AzureChina', or 'AzureGovernment'.
     */
    @JsonProperty("cloud")
    public String getCloud() {
        return cloud;
    }

    /**
     * The Azure Cloud. Options are 'AzurePublic', 'AzureChina', or 'AzureGovernment'.
     */
    @JsonProperty("cloud")
    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("managedIdentity")
    public ManagedIdentity getManagedIdentity() {
        return managedIdentity;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("managedIdentity")
    public void setManagedIdentity(ManagedIdentity managedIdentity) {
        this.managedIdentity = managedIdentity;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("oauth")
    public AzureOAuth getOauth() {
        return oauth;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("oauth")
    public void setOauth(AzureOAuth oauth) {
        this.oauth = oauth;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("sdk")
    public AzureSDK getSdk() {
        return sdk;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("sdk")
    public void setSdk(AzureSDK sdk) {
        this.sdk = sdk;
    }

    @JsonIgnore
    public AzureADBuilder edit() {
        return new AzureADBuilder(this);
    }

    @JsonIgnore
    public AzureADBuilder toBuilder() {
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
