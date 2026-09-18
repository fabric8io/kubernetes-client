
package io.fabric8.certmanager.api.model.acme.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
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
 * ACMEIssuerDNS01ProviderWebhook specifies configuration for a webhook DNS01 provider, including where to POST ChallengePayload resources.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "config",
    "groupName",
    "solverName"
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
public class ACMEIssuerDNS01ProviderWebhook implements Editable<ACMEIssuerDNS01ProviderWebhookBuilder>, KubernetesResource
{

    @JsonProperty("config")
    private JsonNode config;
    @JsonProperty("groupName")
    private String groupName;
    @JsonProperty("solverName")
    private String solverName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderWebhook() {
    }

    public ACMEIssuerDNS01ProviderWebhook(JsonNode config, String groupName, String solverName) {
        super();
        this.config = config;
        this.groupName = groupName;
        this.solverName = solverName;
    }

    /**
     * ACMEIssuerDNS01ProviderWebhook specifies configuration for a webhook DNS01 provider, including where to POST ChallengePayload resources.
     */
    @JsonProperty("config")
    public JsonNode getConfig() {
        return config;
    }

    /**
     * ACMEIssuerDNS01ProviderWebhook specifies configuration for a webhook DNS01 provider, including where to POST ChallengePayload resources.
     */
    @JsonProperty("config")
    public void setConfig(JsonNode config) {
        this.config = config;
    }

    /**
     * The API group name that should be used when POSTing ChallengePayload resources to the webhook apiserver. This should be the same as the GroupName specified in the webhook provider implementation.
     */
    @JsonProperty("groupName")
    public String getGroupName() {
        return groupName;
    }

    /**
     * The API group name that should be used when POSTing ChallengePayload resources to the webhook apiserver. This should be the same as the GroupName specified in the webhook provider implementation.
     */
    @JsonProperty("groupName")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * The name of the solver to use, as defined in the webhook provider implementation. This will typically be the name of the provider, e.g., 'cloudflare'.
     */
    @JsonProperty("solverName")
    public String getSolverName() {
        return solverName;
    }

    /**
     * The name of the solver to use, as defined in the webhook provider implementation. This will typically be the name of the provider, e.g., 'cloudflare'.
     */
    @JsonProperty("solverName")
    public void setSolverName(String solverName) {
        this.solverName = solverName;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderWebhookBuilder edit() {
        return new ACMEIssuerDNS01ProviderWebhookBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderWebhookBuilder toBuilder() {
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
        if (!(o instanceof ACMEIssuerDNS01ProviderWebhook)) {
            return false;
        }
        ACMEIssuerDNS01ProviderWebhook other = (ACMEIssuerDNS01ProviderWebhook) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$config = this.getConfig();
        Object other$config = other.getConfig();
        if (this$config == null ? other$config != null : !this$config.equals(other$config)) {
            return false;
        }
        Object this$groupName = this.getGroupName();
        Object other$groupName = other.getGroupName();
        if (this$groupName == null ? other$groupName != null : !this$groupName.equals(other$groupName)) {
            return false;
        }
        Object this$solverName = this.getSolverName();
        Object other$solverName = other.getSolverName();
        if (this$solverName == null ? other$solverName != null : !this$solverName.equals(other$solverName)) {
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
        return other instanceof ACMEIssuerDNS01ProviderWebhook;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $config = this.getConfig();
        result = result * prime + ($config == null ? 43 : $config.hashCode());
        Object $groupName = this.getGroupName();
        result = result * prime + ($groupName == null ? 43 : $groupName.hashCode());
        Object $solverName = this.getSolverName();
        result = result * prime + ($solverName == null ? 43 : $solverName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEIssuerDNS01ProviderWebhook(" + "config=" + this.getConfig() + ", groupName=" + this.getGroupName() + ", solverName=" + this.getSolverName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
