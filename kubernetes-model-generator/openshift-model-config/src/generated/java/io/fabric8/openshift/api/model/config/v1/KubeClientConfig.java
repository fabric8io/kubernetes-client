
package io.fabric8.openshift.api.model.config.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionOverrides",
    "kubeConfig"
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
public class KubeClientConfig implements Editable<KubeClientConfigBuilder>, KubernetesResource
{

    @JsonProperty("connectionOverrides")
    private ClientConnectionOverrides connectionOverrides;
    @JsonProperty("kubeConfig")
    private String kubeConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KubeClientConfig() {
    }

    public KubeClientConfig(ClientConnectionOverrides connectionOverrides, String kubeConfig) {
        super();
        this.connectionOverrides = connectionOverrides;
        this.kubeConfig = kubeConfig;
    }

    @JsonProperty("connectionOverrides")
    public ClientConnectionOverrides getConnectionOverrides() {
        return connectionOverrides;
    }

    @JsonProperty("connectionOverrides")
    public void setConnectionOverrides(ClientConnectionOverrides connectionOverrides) {
        this.connectionOverrides = connectionOverrides;
    }

    /**
     * kubeConfig is a .kubeconfig filename for going to the owning kube-apiserver.  Empty uses an in-cluster-config
     */
    @JsonProperty("kubeConfig")
    public String getKubeConfig() {
        return kubeConfig;
    }

    /**
     * kubeConfig is a .kubeconfig filename for going to the owning kube-apiserver.  Empty uses an in-cluster-config
     */
    @JsonProperty("kubeConfig")
    public void setKubeConfig(String kubeConfig) {
        this.kubeConfig = kubeConfig;
    }

    @JsonIgnore
    public KubeClientConfigBuilder edit() {
        return new KubeClientConfigBuilder(this);
    }

    @JsonIgnore
    public KubeClientConfigBuilder toBuilder() {
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
        if (!(o instanceof KubeClientConfig)) {
            return false;
        }
        KubeClientConfig other = (KubeClientConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$connectionOverrides = this.getConnectionOverrides();
        Object other$connectionOverrides = other.getConnectionOverrides();
        if (this$connectionOverrides == null ? other$connectionOverrides != null : !this$connectionOverrides.equals(other$connectionOverrides)) {
            return false;
        }
        Object this$kubeConfig = this.getKubeConfig();
        Object other$kubeConfig = other.getKubeConfig();
        if (this$kubeConfig == null ? other$kubeConfig != null : !this$kubeConfig.equals(other$kubeConfig)) {
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
        return other instanceof KubeClientConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $connectionOverrides = this.getConnectionOverrides();
        result = result * prime + ($connectionOverrides == null ? 43 : $connectionOverrides.hashCode());
        Object $kubeConfig = this.getKubeConfig();
        result = result * prime + ($kubeConfig == null ? 43 : $kubeConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KubeClientConfig(" + "connectionOverrides=" + this.getConnectionOverrides() + ", kubeConfig=" + this.getKubeConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
