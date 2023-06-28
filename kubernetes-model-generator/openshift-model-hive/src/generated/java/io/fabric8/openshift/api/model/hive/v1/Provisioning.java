
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "imageSetRef",
    "installConfigSecretRef",
    "installerEnv",
    "installerImageOverride",
    "manifestsConfigMapRef",
    "releaseImage",
    "sshKnownHosts",
    "sshPrivateKeySecretRef"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Provisioning implements KubernetesResource
{

    @JsonProperty("imageSetRef")
    private ClusterImageSetReference imageSetRef;
    @JsonProperty("installConfigSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference installConfigSecretRef;
    @JsonProperty("installerEnv")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> installerEnv = new ArrayList<EnvVar>();
    @JsonProperty("installerImageOverride")
    private String installerImageOverride;
    @JsonProperty("manifestsConfigMapRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference manifestsConfigMapRef;
    @JsonProperty("releaseImage")
    private String releaseImage;
    @JsonProperty("sshKnownHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> sshKnownHosts = new ArrayList<String>();
    @JsonProperty("sshPrivateKeySecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference sshPrivateKeySecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Provisioning() {
    }

    public Provisioning(ClusterImageSetReference imageSetRef, io.fabric8.kubernetes.api.model.LocalObjectReference installConfigSecretRef, List<EnvVar> installerEnv, String installerImageOverride, io.fabric8.kubernetes.api.model.LocalObjectReference manifestsConfigMapRef, String releaseImage, List<String> sshKnownHosts, io.fabric8.kubernetes.api.model.LocalObjectReference sshPrivateKeySecretRef) {
        super();
        this.imageSetRef = imageSetRef;
        this.installConfigSecretRef = installConfigSecretRef;
        this.installerEnv = installerEnv;
        this.installerImageOverride = installerImageOverride;
        this.manifestsConfigMapRef = manifestsConfigMapRef;
        this.releaseImage = releaseImage;
        this.sshKnownHosts = sshKnownHosts;
        this.sshPrivateKeySecretRef = sshPrivateKeySecretRef;
    }

    @JsonProperty("imageSetRef")
    public ClusterImageSetReference getImageSetRef() {
        return imageSetRef;
    }

    @JsonProperty("imageSetRef")
    public void setImageSetRef(ClusterImageSetReference imageSetRef) {
        this.imageSetRef = imageSetRef;
    }

    @JsonProperty("installConfigSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getInstallConfigSecretRef() {
        return installConfigSecretRef;
    }

    @JsonProperty("installConfigSecretRef")
    public void setInstallConfigSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference installConfigSecretRef) {
        this.installConfigSecretRef = installConfigSecretRef;
    }

    @JsonProperty("installerEnv")
    public List<EnvVar> getInstallerEnv() {
        return installerEnv;
    }

    @JsonProperty("installerEnv")
    public void setInstallerEnv(List<EnvVar> installerEnv) {
        this.installerEnv = installerEnv;
    }

    @JsonProperty("installerImageOverride")
    public String getInstallerImageOverride() {
        return installerImageOverride;
    }

    @JsonProperty("installerImageOverride")
    public void setInstallerImageOverride(String installerImageOverride) {
        this.installerImageOverride = installerImageOverride;
    }

    @JsonProperty("manifestsConfigMapRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getManifestsConfigMapRef() {
        return manifestsConfigMapRef;
    }

    @JsonProperty("manifestsConfigMapRef")
    public void setManifestsConfigMapRef(io.fabric8.kubernetes.api.model.LocalObjectReference manifestsConfigMapRef) {
        this.manifestsConfigMapRef = manifestsConfigMapRef;
    }

    @JsonProperty("releaseImage")
    public String getReleaseImage() {
        return releaseImage;
    }

    @JsonProperty("releaseImage")
    public void setReleaseImage(String releaseImage) {
        this.releaseImage = releaseImage;
    }

    @JsonProperty("sshKnownHosts")
    public List<String> getSshKnownHosts() {
        return sshKnownHosts;
    }

    @JsonProperty("sshKnownHosts")
    public void setSshKnownHosts(List<String> sshKnownHosts) {
        this.sshKnownHosts = sshKnownHosts;
    }

    @JsonProperty("sshPrivateKeySecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getSshPrivateKeySecretRef() {
        return sshPrivateKeySecretRef;
    }

    @JsonProperty("sshPrivateKeySecretRef")
    public void setSshPrivateKeySecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference sshPrivateKeySecretRef) {
        this.sshPrivateKeySecretRef = sshPrivateKeySecretRef;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
