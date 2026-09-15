
package io.fabric8.chaosmesh.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * RemoteClusterSpec defines the specification of a remote cluster
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configOverride",
    "kubeConfig",
    "namespace",
    "version"
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
public class RemoteClusterSpec implements Editable<RemoteClusterSpecBuilder>, KubernetesResource
{

    @JsonProperty("configOverride")
    private String configOverride;
    @JsonProperty("kubeConfig")
    private RemoteClusterKubeConfig kubeConfig;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RemoteClusterSpec() {
    }

    public RemoteClusterSpec(String configOverride, RemoteClusterKubeConfig kubeConfig, String namespace, String version) {
        super();
        this.configOverride = configOverride;
        this.kubeConfig = kubeConfig;
        this.namespace = namespace;
        this.version = version;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("configOverride")
    public String getConfigOverride() {
        return configOverride;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("configOverride")
    public void setConfigOverride(String configOverride) {
        this.configOverride = configOverride;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("kubeConfig")
    public RemoteClusterKubeConfig getKubeConfig() {
        return kubeConfig;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("kubeConfig")
    public void setKubeConfig(RemoteClusterKubeConfig kubeConfig) {
        this.kubeConfig = kubeConfig;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * RemoteClusterSpec defines the specification of a remote cluster
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public RemoteClusterSpecBuilder edit() {
        return new RemoteClusterSpecBuilder(this);
    }

    @JsonIgnore
    public RemoteClusterSpecBuilder toBuilder() {
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
        if (!(o instanceof RemoteClusterSpec)) {
            return false;
        }
        RemoteClusterSpec other = (RemoteClusterSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configOverride = this.getConfigOverride();
        Object other$configOverride = other.getConfigOverride();
        if (this$configOverride == null ? other$configOverride != null : !this$configOverride.equals(other$configOverride)) {
            return false;
        }
        Object this$kubeConfig = this.getKubeConfig();
        Object other$kubeConfig = other.getKubeConfig();
        if (this$kubeConfig == null ? other$kubeConfig != null : !this$kubeConfig.equals(other$kubeConfig)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof RemoteClusterSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configOverride = this.getConfigOverride();
        result = result * prime + ($configOverride == null ? 43 : $configOverride.hashCode());
        Object $kubeConfig = this.getKubeConfig();
        result = result * prime + ($kubeConfig == null ? 43 : $kubeConfig.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RemoteClusterSpec(" + "configOverride=" + this.getConfigOverride() + ", kubeConfig=" + this.getKubeConfig() + ", namespace=" + this.getNamespace() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
