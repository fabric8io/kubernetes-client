
package io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PackageManifestStatus implements Editable<PackageManifestStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("catalogSource")
    public String getCatalogSource() {
        return catalogSource;
    }

    @JsonProperty("catalogSource")
    public void setCatalogSource(String catalogSource) {
        this.catalogSource = catalogSource;
    }

    @JsonProperty("catalogSourceDisplayName")
    public String getCatalogSourceDisplayName() {
        return catalogSourceDisplayName;
    }

    @JsonProperty("catalogSourceDisplayName")
    public void setCatalogSourceDisplayName(String catalogSourceDisplayName) {
        this.catalogSourceDisplayName = catalogSourceDisplayName;
    }

    @JsonProperty("catalogSourceNamespace")
    public String getCatalogSourceNamespace() {
        return catalogSourceNamespace;
    }

    @JsonProperty("catalogSourceNamespace")
    public void setCatalogSourceNamespace(String catalogSourceNamespace) {
        this.catalogSourceNamespace = catalogSourceNamespace;
    }

    @JsonProperty("catalogSourcePublisher")
    public String getCatalogSourcePublisher() {
        return catalogSourcePublisher;
    }

    @JsonProperty("catalogSourcePublisher")
    public void setCatalogSourcePublisher(String catalogSourcePublisher) {
        this.catalogSourcePublisher = catalogSourcePublisher;
    }

    @JsonProperty("channels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PackageChannel> getChannels() {
        return channels;
    }

    @JsonProperty("channels")
    public void setChannels(List<PackageChannel> channels) {
        this.channels = channels;
    }

    @JsonProperty("defaultChannel")
    public String getDefaultChannel() {
        return defaultChannel;
    }

    @JsonProperty("defaultChannel")
    public void setDefaultChannel(String defaultChannel) {
        this.defaultChannel = defaultChannel;
    }

    @JsonProperty("deprecation")
    public Deprecation getDeprecation() {
        return deprecation;
    }

    @JsonProperty("deprecation")
    public void setDeprecation(Deprecation deprecation) {
        this.deprecation = deprecation;
    }

    @JsonProperty("packageName")
    public String getPackageName() {
        return packageName;
    }

    @JsonProperty("packageName")
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @JsonProperty("provider")
    public AppLink getProvider() {
        return provider;
    }

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
