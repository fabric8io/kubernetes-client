
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
