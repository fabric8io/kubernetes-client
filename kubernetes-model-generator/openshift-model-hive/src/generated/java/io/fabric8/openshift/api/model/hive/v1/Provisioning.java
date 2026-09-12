
package io.fabric8.openshift.api.model.hive.v1;

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

/**
 * Provisioning contains settings used only for initial cluster provisioning.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageSetRef",
    "installConfigSecretRef",
    "installerEnv",
    "installerImageOverride",
    "manifestsConfigMapRef",
    "manifestsSecretRef",
    "releaseImage",
    "sshKnownHosts",
    "sshPrivateKeySecretRef"
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
public class Provisioning implements Editable<ProvisioningBuilder>, KubernetesResource
{

    @JsonProperty("imageSetRef")
    private ClusterImageSetReference imageSetRef;
    @JsonProperty("installConfigSecretRef")
    private LocalObjectReference installConfigSecretRef;
    @JsonProperty("installerEnv")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> installerEnv = new ArrayList<>();
    @JsonProperty("installerImageOverride")
    private String installerImageOverride;
    @JsonProperty("manifestsConfigMapRef")
    private LocalObjectReference manifestsConfigMapRef;
    @JsonProperty("manifestsSecretRef")
    private LocalObjectReference manifestsSecretRef;
    @JsonProperty("releaseImage")
    private String releaseImage;
    @JsonProperty("sshKnownHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> sshKnownHosts = new ArrayList<>();
    @JsonProperty("sshPrivateKeySecretRef")
    private LocalObjectReference sshPrivateKeySecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Provisioning() {
    }

    public Provisioning(ClusterImageSetReference imageSetRef, LocalObjectReference installConfigSecretRef, List<EnvVar> installerEnv, String installerImageOverride, LocalObjectReference manifestsConfigMapRef, LocalObjectReference manifestsSecretRef, String releaseImage, List<String> sshKnownHosts, LocalObjectReference sshPrivateKeySecretRef) {
        super();
        this.imageSetRef = imageSetRef;
        this.installConfigSecretRef = installConfigSecretRef;
        this.installerEnv = installerEnv;
        this.installerImageOverride = installerImageOverride;
        this.manifestsConfigMapRef = manifestsConfigMapRef;
        this.manifestsSecretRef = manifestsSecretRef;
        this.releaseImage = releaseImage;
        this.sshKnownHosts = sshKnownHosts;
        this.sshPrivateKeySecretRef = sshPrivateKeySecretRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("imageSetRef")
    public ClusterImageSetReference getImageSetRef() {
        return imageSetRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("imageSetRef")
    public void setImageSetRef(ClusterImageSetReference imageSetRef) {
        this.imageSetRef = imageSetRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("installConfigSecretRef")
    public LocalObjectReference getInstallConfigSecretRef() {
        return installConfigSecretRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("installConfigSecretRef")
    public void setInstallConfigSecretRef(LocalObjectReference installConfigSecretRef) {
        this.installConfigSecretRef = installConfigSecretRef;
    }

    /**
     * InstallerEnv are extra environment variables to pass through to the installer. This may be used to enable additional features of the installer.
     */
    @JsonProperty("installerEnv")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getInstallerEnv() {
        return installerEnv;
    }

    /**
     * InstallerEnv are extra environment variables to pass through to the installer. This may be used to enable additional features of the installer.
     */
    @JsonProperty("installerEnv")
    public void setInstallerEnv(List<EnvVar> installerEnv) {
        this.installerEnv = installerEnv;
    }

    /**
     * InstallerImageOverride allows specifying a URI for the installer image, normally gleaned from the metadata within the ReleaseImage.
     */
    @JsonProperty("installerImageOverride")
    public String getInstallerImageOverride() {
        return installerImageOverride;
    }

    /**
     * InstallerImageOverride allows specifying a URI for the installer image, normally gleaned from the metadata within the ReleaseImage.
     */
    @JsonProperty("installerImageOverride")
    public void setInstallerImageOverride(String installerImageOverride) {
        this.installerImageOverride = installerImageOverride;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("manifestsConfigMapRef")
    public LocalObjectReference getManifestsConfigMapRef() {
        return manifestsConfigMapRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("manifestsConfigMapRef")
    public void setManifestsConfigMapRef(LocalObjectReference manifestsConfigMapRef) {
        this.manifestsConfigMapRef = manifestsConfigMapRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("manifestsSecretRef")
    public LocalObjectReference getManifestsSecretRef() {
        return manifestsSecretRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("manifestsSecretRef")
    public void setManifestsSecretRef(LocalObjectReference manifestsSecretRef) {
        this.manifestsSecretRef = manifestsSecretRef;
    }

    /**
     * ReleaseImage is the image containing metadata for all components that run in the cluster, and is the primary and best way to specify what specific version of OpenShift you wish to install.
     */
    @JsonProperty("releaseImage")
    public String getReleaseImage() {
        return releaseImage;
    }

    /**
     * ReleaseImage is the image containing metadata for all components that run in the cluster, and is the primary and best way to specify what specific version of OpenShift you wish to install.
     */
    @JsonProperty("releaseImage")
    public void setReleaseImage(String releaseImage) {
        this.releaseImage = releaseImage;
    }

    /**
     * SSHKnownHosts are known hosts to be configured in the hive install manager pod to avoid ssh prompts. Use of ssh in the install pod is somewhat limited today (failure log gathering from cluster, some bare metal provisioning scenarios), so this setting is often not needed.
     */
    @JsonProperty("sshKnownHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSshKnownHosts() {
        return sshKnownHosts;
    }

    /**
     * SSHKnownHosts are known hosts to be configured in the hive install manager pod to avoid ssh prompts. Use of ssh in the install pod is somewhat limited today (failure log gathering from cluster, some bare metal provisioning scenarios), so this setting is often not needed.
     */
    @JsonProperty("sshKnownHosts")
    public void setSshKnownHosts(List<String> sshKnownHosts) {
        this.sshKnownHosts = sshKnownHosts;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("sshPrivateKeySecretRef")
    public LocalObjectReference getSshPrivateKeySecretRef() {
        return sshPrivateKeySecretRef;
    }

    /**
     * Provisioning contains settings used only for initial cluster provisioning.
     */
    @JsonProperty("sshPrivateKeySecretRef")
    public void setSshPrivateKeySecretRef(LocalObjectReference sshPrivateKeySecretRef) {
        this.sshPrivateKeySecretRef = sshPrivateKeySecretRef;
    }

    @JsonIgnore
    public ProvisioningBuilder edit() {
        return new ProvisioningBuilder(this);
    }

    @JsonIgnore
    public ProvisioningBuilder toBuilder() {
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
        if (!(o instanceof Provisioning)) {
            return false;
        }
        Provisioning other = (Provisioning) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$imageSetRef = this.getImageSetRef();
        Object other$imageSetRef = other.getImageSetRef();
        if (this$imageSetRef == null ? other$imageSetRef != null : !this$imageSetRef.equals(other$imageSetRef)) {
            return false;
        }
        Object this$installConfigSecretRef = this.getInstallConfigSecretRef();
        Object other$installConfigSecretRef = other.getInstallConfigSecretRef();
        if (this$installConfigSecretRef == null ? other$installConfigSecretRef != null : !this$installConfigSecretRef.equals(other$installConfigSecretRef)) {
            return false;
        }
        Object this$installerEnv = this.getInstallerEnv();
        Object other$installerEnv = other.getInstallerEnv();
        if (this$installerEnv == null ? other$installerEnv != null : !this$installerEnv.equals(other$installerEnv)) {
            return false;
        }
        Object this$installerImageOverride = this.getInstallerImageOverride();
        Object other$installerImageOverride = other.getInstallerImageOverride();
        if (this$installerImageOverride == null ? other$installerImageOverride != null : !this$installerImageOverride.equals(other$installerImageOverride)) {
            return false;
        }
        Object this$manifestsConfigMapRef = this.getManifestsConfigMapRef();
        Object other$manifestsConfigMapRef = other.getManifestsConfigMapRef();
        if (this$manifestsConfigMapRef == null ? other$manifestsConfigMapRef != null : !this$manifestsConfigMapRef.equals(other$manifestsConfigMapRef)) {
            return false;
        }
        Object this$manifestsSecretRef = this.getManifestsSecretRef();
        Object other$manifestsSecretRef = other.getManifestsSecretRef();
        if (this$manifestsSecretRef == null ? other$manifestsSecretRef != null : !this$manifestsSecretRef.equals(other$manifestsSecretRef)) {
            return false;
        }
        Object this$releaseImage = this.getReleaseImage();
        Object other$releaseImage = other.getReleaseImage();
        if (this$releaseImage == null ? other$releaseImage != null : !this$releaseImage.equals(other$releaseImage)) {
            return false;
        }
        Object this$sshKnownHosts = this.getSshKnownHosts();
        Object other$sshKnownHosts = other.getSshKnownHosts();
        if (this$sshKnownHosts == null ? other$sshKnownHosts != null : !this$sshKnownHosts.equals(other$sshKnownHosts)) {
            return false;
        }
        Object this$sshPrivateKeySecretRef = this.getSshPrivateKeySecretRef();
        Object other$sshPrivateKeySecretRef = other.getSshPrivateKeySecretRef();
        if (this$sshPrivateKeySecretRef == null ? other$sshPrivateKeySecretRef != null : !this$sshPrivateKeySecretRef.equals(other$sshPrivateKeySecretRef)) {
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
        return other instanceof Provisioning;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $imageSetRef = this.getImageSetRef();
        result = result * prime + ($imageSetRef == null ? 43 : $imageSetRef.hashCode());
        Object $installConfigSecretRef = this.getInstallConfigSecretRef();
        result = result * prime + ($installConfigSecretRef == null ? 43 : $installConfigSecretRef.hashCode());
        Object $installerEnv = this.getInstallerEnv();
        result = result * prime + ($installerEnv == null ? 43 : $installerEnv.hashCode());
        Object $installerImageOverride = this.getInstallerImageOverride();
        result = result * prime + ($installerImageOverride == null ? 43 : $installerImageOverride.hashCode());
        Object $manifestsConfigMapRef = this.getManifestsConfigMapRef();
        result = result * prime + ($manifestsConfigMapRef == null ? 43 : $manifestsConfigMapRef.hashCode());
        Object $manifestsSecretRef = this.getManifestsSecretRef();
        result = result * prime + ($manifestsSecretRef == null ? 43 : $manifestsSecretRef.hashCode());
        Object $releaseImage = this.getReleaseImage();
        result = result * prime + ($releaseImage == null ? 43 : $releaseImage.hashCode());
        Object $sshKnownHosts = this.getSshKnownHosts();
        result = result * prime + ($sshKnownHosts == null ? 43 : $sshKnownHosts.hashCode());
        Object $sshPrivateKeySecretRef = this.getSshPrivateKeySecretRef();
        result = result * prime + ($sshPrivateKeySecretRef == null ? 43 : $sshPrivateKeySecretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Provisioning(" + "imageSetRef=" + this.getImageSetRef() + ", installConfigSecretRef=" + this.getInstallConfigSecretRef() + ", installerEnv=" + this.getInstallerEnv() + ", installerImageOverride=" + this.getInstallerImageOverride() + ", manifestsConfigMapRef=" + this.getManifestsConfigMapRef() + ", manifestsSecretRef=" + this.getManifestsSecretRef() + ", releaseImage=" + this.getReleaseImage() + ", sshKnownHosts=" + this.getSshKnownHosts() + ", sshPrivateKeySecretRef=" + this.getSshPrivateKeySecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
