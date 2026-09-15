
package io.fabric8.openclustermanagement.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hubConnectionTimeoutSeconds",
    "kubeConfigSecrets"
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
public class LocalSecretsConfig implements Editable<LocalSecretsConfigBuilder>, KubernetesResource
{

    @JsonProperty("hubConnectionTimeoutSeconds")
    private Integer hubConnectionTimeoutSeconds;
    @JsonProperty("kubeConfigSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KubeConfigSecret> kubeConfigSecrets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LocalSecretsConfig() {
    }

    public LocalSecretsConfig(Integer hubConnectionTimeoutSeconds, List<KubeConfigSecret> kubeConfigSecrets) {
        super();
        this.hubConnectionTimeoutSeconds = hubConnectionTimeoutSeconds;
        this.kubeConfigSecrets = kubeConfigSecrets;
    }

    /**
     * HubConnectionTimeoutSeconds is used to set the timeout of connecting to the hub cluster. When agent loses the connection to the hub over the timeout seconds, the agent do a rebootstrap. By default is 10 mins.
     */
    @JsonProperty("hubConnectionTimeoutSeconds")
    public Integer getHubConnectionTimeoutSeconds() {
        return hubConnectionTimeoutSeconds;
    }

    /**
     * HubConnectionTimeoutSeconds is used to set the timeout of connecting to the hub cluster. When agent loses the connection to the hub over the timeout seconds, the agent do a rebootstrap. By default is 10 mins.
     */
    @JsonProperty("hubConnectionTimeoutSeconds")
    public void setHubConnectionTimeoutSeconds(Integer hubConnectionTimeoutSeconds) {
        this.hubConnectionTimeoutSeconds = hubConnectionTimeoutSeconds;
    }

    /**
     * KubeConfigSecrets is a list of secret names. The secrets are in the same namespace where the agent controller runs.
     */
    @JsonProperty("kubeConfigSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KubeConfigSecret> getKubeConfigSecrets() {
        return kubeConfigSecrets;
    }

    /**
     * KubeConfigSecrets is a list of secret names. The secrets are in the same namespace where the agent controller runs.
     */
    @JsonProperty("kubeConfigSecrets")
    public void setKubeConfigSecrets(List<KubeConfigSecret> kubeConfigSecrets) {
        this.kubeConfigSecrets = kubeConfigSecrets;
    }

    @JsonIgnore
    public LocalSecretsConfigBuilder edit() {
        return new LocalSecretsConfigBuilder(this);
    }

    @JsonIgnore
    public LocalSecretsConfigBuilder toBuilder() {
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
        if (!(o instanceof LocalSecretsConfig)) {
            return false;
        }
        LocalSecretsConfig other = (LocalSecretsConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hubConnectionTimeoutSeconds = this.getHubConnectionTimeoutSeconds();
        Object other$hubConnectionTimeoutSeconds = other.getHubConnectionTimeoutSeconds();
        if (this$hubConnectionTimeoutSeconds == null ? other$hubConnectionTimeoutSeconds != null : !this$hubConnectionTimeoutSeconds.equals(other$hubConnectionTimeoutSeconds)) {
            return false;
        }
        Object this$kubeConfigSecrets = this.getKubeConfigSecrets();
        Object other$kubeConfigSecrets = other.getKubeConfigSecrets();
        if (this$kubeConfigSecrets == null ? other$kubeConfigSecrets != null : !this$kubeConfigSecrets.equals(other$kubeConfigSecrets)) {
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
        return other instanceof LocalSecretsConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hubConnectionTimeoutSeconds = this.getHubConnectionTimeoutSeconds();
        result = result * prime + ($hubConnectionTimeoutSeconds == null ? 43 : $hubConnectionTimeoutSeconds.hashCode());
        Object $kubeConfigSecrets = this.getKubeConfigSecrets();
        result = result * prime + ($kubeConfigSecrets == null ? 43 : $kubeConfigSecrets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LocalSecretsConfig(" + "hubConnectionTimeoutSeconds=" + this.getHubConnectionTimeoutSeconds() + ", kubeConfigSecrets=" + this.getKubeConfigSecrets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
