
package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
 * PackageManifestStatus represents the current status of the PackageManifest
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "catalogSource",
    "catalogSourceDisplayName",
    "catalogSourceNamespace",
    "catalogSourcePublisher",
    "channels",
    "defaultChannel",
    "deprecation",
    "packageName",
    "provider"
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
public class PackageManifestStatus implements Editable<PackageManifestStatusBuilder>, KubernetesResource
{

    @JsonProperty("catalogSource")
    private String catalogSource;
    @JsonProperty("catalogSourceDisplayName")
    private String catalogSourceDisplayName;
    @JsonProperty("catalogSourceNamespace")
    private String catalogSourceNamespace;
    @JsonProperty("catalogSourcePublisher")
    private String catalogSourcePublisher;
    @JsonProperty("channels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PackageChannel> channels = new ArrayList<>();
    @JsonProperty("defaultChannel")
    private String defaultChannel;
    @JsonProperty("deprecation")
    private Deprecation deprecation;
    @JsonProperty("packageName")
    private String packageName;
    @JsonProperty("provider")
    private AppLink provider;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PackageManifestStatus() {
    }

    public PackageManifestStatus(String catalogSource, String catalogSourceDisplayName, String catalogSourceNamespace, String catalogSourcePublisher, List<PackageChannel> channels, String defaultChannel, Deprecation deprecation, String packageName, AppLink provider) {
        super();
        this.catalogSource = catalogSource;
        this.catalogSourceDisplayName = catalogSourceDisplayName;
        this.catalogSourceNamespace = catalogSourceNamespace;
        this.catalogSourcePublisher = catalogSourcePublisher;
        this.channels = channels;
        this.defaultChannel = defaultChannel;
        this.deprecation = deprecation;
        this.packageName = packageName;
        this.provider = provider;
    }

    /**
     * CatalogSource is the name of the CatalogSource this package belongs to
     */
    @JsonProperty("catalogSource")
    public String getCatalogSource() {
        return catalogSource;
    }

    /**
     * CatalogSource is the name of the CatalogSource this package belongs to
     */
    @JsonProperty("catalogSource")
    public void setCatalogSource(String catalogSource) {
        this.catalogSource = catalogSource;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("catalogSourceDisplayName")
    public String getCatalogSourceDisplayName() {
        return catalogSourceDisplayName;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("catalogSourceDisplayName")
    public void setCatalogSourceDisplayName(String catalogSourceDisplayName) {
        this.catalogSourceDisplayName = catalogSourceDisplayName;
    }

    /**
     * CatalogSourceNamespace is the namespace of the owning CatalogSource
     */
    @JsonProperty("catalogSourceNamespace")
    public String getCatalogSourceNamespace() {
        return catalogSourceNamespace;
    }

    /**
     * CatalogSourceNamespace is the namespace of the owning CatalogSource
     */
    @JsonProperty("catalogSourceNamespace")
    public void setCatalogSourceNamespace(String catalogSourceNamespace) {
        this.catalogSourceNamespace = catalogSourceNamespace;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("catalogSourcePublisher")
    public String getCatalogSourcePublisher() {
        return catalogSourcePublisher;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("catalogSourcePublisher")
    public void setCatalogSourcePublisher(String catalogSourcePublisher) {
        this.catalogSourcePublisher = catalogSourcePublisher;
    }

    /**
     * Channels are the declared channels for the package, ala `stable` or `alpha`.
     */
    @JsonProperty("channels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PackageChannel> getChannels() {
        return channels;
    }

    /**
     * Channels are the declared channels for the package, ala `stable` or `alpha`.
     */
    @JsonProperty("channels")
    public void setChannels(List<PackageChannel> channels) {
        this.channels = channels;
    }

    /**
     * DefaultChannel is, if specified, the name of the default channel for the package. The default channel will be installed if no other channel is explicitly given. If the package has a single channel, then that channel is implicitly the default.
     */
    @JsonProperty("defaultChannel")
    public String getDefaultChannel() {
        return defaultChannel;
    }

    /**
     * DefaultChannel is, if specified, the name of the default channel for the package. The default channel will be installed if no other channel is explicitly given. If the package has a single channel, then that channel is implicitly the default.
     */
    @JsonProperty("defaultChannel")
    public void setDefaultChannel(String defaultChannel) {
        this.defaultChannel = defaultChannel;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("deprecation")
    public Deprecation getDeprecation() {
        return deprecation;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("deprecation")
    public void setDeprecation(Deprecation deprecation) {
        this.deprecation = deprecation;
    }

    /**
     * PackageName is the name of the overall package, ala `etcd`.
     */
    @JsonProperty("packageName")
    public String getPackageName() {
        return packageName;
    }

    /**
     * PackageName is the name of the overall package, ala `etcd`.
     */
    @JsonProperty("packageName")
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("provider")
    public AppLink getProvider() {
        return provider;
    }

    /**
     * PackageManifestStatus represents the current status of the PackageManifest
     */
    @JsonProperty("provider")
    public void setProvider(AppLink provider) {
        this.provider = provider;
    }

    @JsonIgnore
    public PackageManifestStatusBuilder edit() {
        return new PackageManifestStatusBuilder(this);
    }

    @JsonIgnore
    public PackageManifestStatusBuilder toBuilder() {
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
        if (!(o instanceof PackageManifestStatus)) {
            return false;
        }
        PackageManifestStatus other = (PackageManifestStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$catalogSource = this.getCatalogSource();
        Object other$catalogSource = other.getCatalogSource();
        if (this$catalogSource == null ? other$catalogSource != null : !this$catalogSource.equals(other$catalogSource)) {
            return false;
        }
        Object this$catalogSourceDisplayName = this.getCatalogSourceDisplayName();
        Object other$catalogSourceDisplayName = other.getCatalogSourceDisplayName();
        if (this$catalogSourceDisplayName == null ? other$catalogSourceDisplayName != null : !this$catalogSourceDisplayName.equals(other$catalogSourceDisplayName)) {
            return false;
        }
        Object this$catalogSourceNamespace = this.getCatalogSourceNamespace();
        Object other$catalogSourceNamespace = other.getCatalogSourceNamespace();
        if (this$catalogSourceNamespace == null ? other$catalogSourceNamespace != null : !this$catalogSourceNamespace.equals(other$catalogSourceNamespace)) {
            return false;
        }
        Object this$catalogSourcePublisher = this.getCatalogSourcePublisher();
        Object other$catalogSourcePublisher = other.getCatalogSourcePublisher();
        if (this$catalogSourcePublisher == null ? other$catalogSourcePublisher != null : !this$catalogSourcePublisher.equals(other$catalogSourcePublisher)) {
            return false;
        }
        Object this$channels = this.getChannels();
        Object other$channels = other.getChannels();
        if (this$channels == null ? other$channels != null : !this$channels.equals(other$channels)) {
            return false;
        }
        Object this$defaultChannel = this.getDefaultChannel();
        Object other$defaultChannel = other.getDefaultChannel();
        if (this$defaultChannel == null ? other$defaultChannel != null : !this$defaultChannel.equals(other$defaultChannel)) {
            return false;
        }
        Object this$deprecation = this.getDeprecation();
        Object other$deprecation = other.getDeprecation();
        if (this$deprecation == null ? other$deprecation != null : !this$deprecation.equals(other$deprecation)) {
            return false;
        }
        Object this$packageName = this.getPackageName();
        Object other$packageName = other.getPackageName();
        if (this$packageName == null ? other$packageName != null : !this$packageName.equals(other$packageName)) {
            return false;
        }
        Object this$provider = this.getProvider();
        Object other$provider = other.getProvider();
        if (this$provider == null ? other$provider != null : !this$provider.equals(other$provider)) {
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
        return other instanceof PackageManifestStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $catalogSource = this.getCatalogSource();
        result = result * prime + ($catalogSource == null ? 43 : $catalogSource.hashCode());
        Object $catalogSourceDisplayName = this.getCatalogSourceDisplayName();
        result = result * prime + ($catalogSourceDisplayName == null ? 43 : $catalogSourceDisplayName.hashCode());
        Object $catalogSourceNamespace = this.getCatalogSourceNamespace();
        result = result * prime + ($catalogSourceNamespace == null ? 43 : $catalogSourceNamespace.hashCode());
        Object $catalogSourcePublisher = this.getCatalogSourcePublisher();
        result = result * prime + ($catalogSourcePublisher == null ? 43 : $catalogSourcePublisher.hashCode());
        Object $channels = this.getChannels();
        result = result * prime + ($channels == null ? 43 : $channels.hashCode());
        Object $defaultChannel = this.getDefaultChannel();
        result = result * prime + ($defaultChannel == null ? 43 : $defaultChannel.hashCode());
        Object $deprecation = this.getDeprecation();
        result = result * prime + ($deprecation == null ? 43 : $deprecation.hashCode());
        Object $packageName = this.getPackageName();
        result = result * prime + ($packageName == null ? 43 : $packageName.hashCode());
        Object $provider = this.getProvider();
        result = result * prime + ($provider == null ? 43 : $provider.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PackageManifestStatus(" + "catalogSource=" + this.getCatalogSource() + ", catalogSourceDisplayName=" + this.getCatalogSourceDisplayName() + ", catalogSourceNamespace=" + this.getCatalogSourceNamespace() + ", catalogSourcePublisher=" + this.getCatalogSourcePublisher() + ", channels=" + this.getChannels() + ", defaultChannel=" + this.getDefaultChannel() + ", deprecation=" + this.getDeprecation() + ", packageName=" + this.getPackageName() + ", provider=" + this.getProvider() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
