
package io.fabric8.openclustermanagement.api.model.agent.v1;

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
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedCluster;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ImagePullPolicy",
    "ImagePullSecret",
    "ImagePullSecretNamespace",
    "KlusterletAddonConfig",
    "ManagedCluster",
    "NodeSelector"
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
public class AddonAgentConfig implements Editable<AddonAgentConfigBuilder>, KubernetesResource
{

    @JsonProperty("ImagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("ImagePullSecret")
    private String imagePullSecret;
    @JsonProperty("ImagePullSecretNamespace")
    private String imagePullSecretNamespace;
    @JsonProperty("KlusterletAddonConfig")
    private KlusterletAddonConfig klusterletAddonConfig;
    @JsonProperty("ManagedCluster")
    private ManagedCluster managedCluster;
    @JsonProperty("NodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AddonAgentConfig() {
    }

    public AddonAgentConfig(String imagePullPolicy, String imagePullSecret, String imagePullSecretNamespace, KlusterletAddonConfig klusterletAddonConfig, ManagedCluster managedCluster, Map<String, String> nodeSelector) {
        super();
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.imagePullSecretNamespace = imagePullSecretNamespace;
        this.klusterletAddonConfig = klusterletAddonConfig;
        this.managedCluster = managedCluster;
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("ImagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("ImagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("ImagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    @JsonProperty("ImagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    @JsonProperty("ImagePullSecretNamespace")
    public String getImagePullSecretNamespace() {
        return imagePullSecretNamespace;
    }

    @JsonProperty("ImagePullSecretNamespace")
    public void setImagePullSecretNamespace(String imagePullSecretNamespace) {
        this.imagePullSecretNamespace = imagePullSecretNamespace;
    }

    @JsonProperty("KlusterletAddonConfig")
    public KlusterletAddonConfig getKlusterletAddonConfig() {
        return klusterletAddonConfig;
    }

    @JsonProperty("KlusterletAddonConfig")
    public void setKlusterletAddonConfig(KlusterletAddonConfig klusterletAddonConfig) {
        this.klusterletAddonConfig = klusterletAddonConfig;
    }

    @JsonProperty("ManagedCluster")
    public ManagedCluster getManagedCluster() {
        return managedCluster;
    }

    @JsonProperty("ManagedCluster")
    public void setManagedCluster(ManagedCluster managedCluster) {
        this.managedCluster = managedCluster;
    }

    @JsonProperty("NodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("NodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonIgnore
    public AddonAgentConfigBuilder edit() {
        return new AddonAgentConfigBuilder(this);
    }

    @JsonIgnore
    public AddonAgentConfigBuilder toBuilder() {
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
