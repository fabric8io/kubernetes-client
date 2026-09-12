
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
 * SubscriptionSpec defines the desired state of Subscription
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allow",
    "channel",
    "deny",
    "hooksecretref",
    "name",
    "overrides",
    "packageFilter",
    "packageOverrides",
    "placement",
    "secondaryChannel",
    "timewindow",
    "watchHelmNamespaceScopedResources"
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
public class SubscriptionSpec implements Editable<SubscriptionSpecBuilder>, KubernetesResource
{

    @JsonProperty("allow")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowDenyItem> allow = new ArrayList<>();
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("deny")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowDenyItem> deny = new ArrayList<>();
    @JsonProperty("hooksecretref")
    private ObjectReference hooksecretref;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterOverrides> overrides = new ArrayList<>();
    @JsonProperty("packageFilter")
    private PackageFilter packageFilter;
    @JsonProperty("packageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Overrides> packageOverrides = new ArrayList<>();
    @JsonProperty("placement")
    private Placement placement;
    @JsonProperty("secondaryChannel")
    private String secondaryChannel;
    @JsonProperty("timewindow")
    private TimeWindow timewindow;
    @JsonProperty("watchHelmNamespaceScopedResources")
    private Boolean watchHelmNamespaceScopedResources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriptionSpec() {
    }

    public SubscriptionSpec(List<AllowDenyItem> allow, String channel, List<AllowDenyItem> deny, ObjectReference hooksecretref, String name, List<ClusterOverrides> overrides, PackageFilter packageFilter, List<Overrides> packageOverrides, Placement placement, String secondaryChannel, TimeWindow timewindow, Boolean watchHelmNamespaceScopedResources) {
        super();
        this.allow = allow;
        this.channel = channel;
        this.deny = deny;
        this.hooksecretref = hooksecretref;
        this.name = name;
        this.overrides = overrides;
        this.packageFilter = packageFilter;
        this.packageOverrides = packageOverrides;
        this.placement = placement;
        this.secondaryChannel = secondaryChannel;
        this.timewindow = timewindow;
        this.watchHelmNamespaceScopedResources = watchHelmNamespaceScopedResources;
    }

    /**
     * Specify a list of resources allowed for deployment
     */
    @JsonProperty("allow")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AllowDenyItem> getAllow() {
        return allow;
    }

    /**
     * Specify a list of resources allowed for deployment
     */
    @JsonProperty("allow")
    public void setAllow(List<AllowDenyItem> allow) {
        this.allow = allow;
    }

    /**
     * The primary channel namespaced name used by the subscription. Its format is "&lt;channel NameSpace&gt;/&lt;channel Name&gt;"
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * The primary channel namespaced name used by the subscription. Its format is "&lt;channel NameSpace&gt;/&lt;channel Name&gt;"
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Specify a list of resources denied for deployment
     */
    @JsonProperty("deny")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AllowDenyItem> getDeny() {
        return deny;
    }

    /**
     * Specify a list of resources denied for deployment
     */
    @JsonProperty("deny")
    public void setDeny(List<AllowDenyItem> deny) {
        this.deny = deny;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("hooksecretref")
    public ObjectReference getHooksecretref() {
        return hooksecretref;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("hooksecretref")
    public void setHooksecretref(ObjectReference hooksecretref) {
        this.hooksecretref = hooksecretref;
    }

    /**
     * Subscribe a package by its package name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Subscribe a package by its package name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Specify overrides when applied to clusters. Hub use only
     */
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterOverrides> getOverrides() {
        return overrides;
    }

    /**
     * Specify overrides when applied to clusters. Hub use only
     */
    @JsonProperty("overrides")
    public void setOverrides(List<ClusterOverrides> overrides) {
        this.overrides = overrides;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("packageFilter")
    public PackageFilter getPackageFilter() {
        return packageFilter;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("packageFilter")
    public void setPackageFilter(PackageFilter packageFilter) {
        this.packageFilter = packageFilter;
    }

    /**
     * Override packages
     */
    @JsonProperty("packageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Overrides> getPackageOverrides() {
        return packageOverrides;
    }

    /**
     * Override packages
     */
    @JsonProperty("packageOverrides")
    public void setPackageOverrides(List<Overrides> packageOverrides) {
        this.packageOverrides = packageOverrides;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("placement")
    public Placement getPlacement() {
        return placement;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("placement")
    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    /**
     * The secondary channel will be applied if the primary channel fails to connect
     */
    @JsonProperty("secondaryChannel")
    public String getSecondaryChannel() {
        return secondaryChannel;
    }

    /**
     * The secondary channel will be applied if the primary channel fails to connect
     */
    @JsonProperty("secondaryChannel")
    public void setSecondaryChannel(String secondaryChannel) {
        this.secondaryChannel = secondaryChannel;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("timewindow")
    public TimeWindow getTimewindow() {
        return timewindow;
    }

    /**
     * SubscriptionSpec defines the desired state of Subscription
     */
    @JsonProperty("timewindow")
    public void setTimewindow(TimeWindow timewindow) {
        this.timewindow = timewindow;
    }

    /**
     * WatchHelmNamespaceScopedResources is used to enable watching namespace scope Helm chart resources
     */
    @JsonProperty("watchHelmNamespaceScopedResources")
    public Boolean getWatchHelmNamespaceScopedResources() {
        return watchHelmNamespaceScopedResources;
    }

    /**
     * WatchHelmNamespaceScopedResources is used to enable watching namespace scope Helm chart resources
     */
    @JsonProperty("watchHelmNamespaceScopedResources")
    public void setWatchHelmNamespaceScopedResources(Boolean watchHelmNamespaceScopedResources) {
        this.watchHelmNamespaceScopedResources = watchHelmNamespaceScopedResources;
    }

    @JsonIgnore
    public SubscriptionSpecBuilder edit() {
        return new SubscriptionSpecBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecBuilder toBuilder() {
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
        if (!(o instanceof SubscriptionSpec)) {
            return false;
        }
        SubscriptionSpec other = (SubscriptionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allow = this.getAllow();
        Object other$allow = other.getAllow();
        if (this$allow == null ? other$allow != null : !this$allow.equals(other$allow)) {
            return false;
        }
        Object this$channel = this.getChannel();
        Object other$channel = other.getChannel();
        if (this$channel == null ? other$channel != null : !this$channel.equals(other$channel)) {
            return false;
        }
        Object this$deny = this.getDeny();
        Object other$deny = other.getDeny();
        if (this$deny == null ? other$deny != null : !this$deny.equals(other$deny)) {
            return false;
        }
        Object this$hooksecretref = this.getHooksecretref();
        Object other$hooksecretref = other.getHooksecretref();
        if (this$hooksecretref == null ? other$hooksecretref != null : !this$hooksecretref.equals(other$hooksecretref)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$overrides = this.getOverrides();
        Object other$overrides = other.getOverrides();
        if (this$overrides == null ? other$overrides != null : !this$overrides.equals(other$overrides)) {
            return false;
        }
        Object this$packageFilter = this.getPackageFilter();
        Object other$packageFilter = other.getPackageFilter();
        if (this$packageFilter == null ? other$packageFilter != null : !this$packageFilter.equals(other$packageFilter)) {
            return false;
        }
        Object this$packageOverrides = this.getPackageOverrides();
        Object other$packageOverrides = other.getPackageOverrides();
        if (this$packageOverrides == null ? other$packageOverrides != null : !this$packageOverrides.equals(other$packageOverrides)) {
            return false;
        }
        Object this$placement = this.getPlacement();
        Object other$placement = other.getPlacement();
        if (this$placement == null ? other$placement != null : !this$placement.equals(other$placement)) {
            return false;
        }
        Object this$secondaryChannel = this.getSecondaryChannel();
        Object other$secondaryChannel = other.getSecondaryChannel();
        if (this$secondaryChannel == null ? other$secondaryChannel != null : !this$secondaryChannel.equals(other$secondaryChannel)) {
            return false;
        }
        Object this$timewindow = this.getTimewindow();
        Object other$timewindow = other.getTimewindow();
        if (this$timewindow == null ? other$timewindow != null : !this$timewindow.equals(other$timewindow)) {
            return false;
        }
        Object this$watchHelmNamespaceScopedResources = this.getWatchHelmNamespaceScopedResources();
        Object other$watchHelmNamespaceScopedResources = other.getWatchHelmNamespaceScopedResources();
        if (this$watchHelmNamespaceScopedResources == null ? other$watchHelmNamespaceScopedResources != null : !this$watchHelmNamespaceScopedResources.equals(other$watchHelmNamespaceScopedResources)) {
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
        return other instanceof SubscriptionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allow = this.getAllow();
        result = result * prime + ($allow == null ? 43 : $allow.hashCode());
        Object $channel = this.getChannel();
        result = result * prime + ($channel == null ? 43 : $channel.hashCode());
        Object $deny = this.getDeny();
        result = result * prime + ($deny == null ? 43 : $deny.hashCode());
        Object $hooksecretref = this.getHooksecretref();
        result = result * prime + ($hooksecretref == null ? 43 : $hooksecretref.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $overrides = this.getOverrides();
        result = result * prime + ($overrides == null ? 43 : $overrides.hashCode());
        Object $packageFilter = this.getPackageFilter();
        result = result * prime + ($packageFilter == null ? 43 : $packageFilter.hashCode());
        Object $packageOverrides = this.getPackageOverrides();
        result = result * prime + ($packageOverrides == null ? 43 : $packageOverrides.hashCode());
        Object $placement = this.getPlacement();
        result = result * prime + ($placement == null ? 43 : $placement.hashCode());
        Object $secondaryChannel = this.getSecondaryChannel();
        result = result * prime + ($secondaryChannel == null ? 43 : $secondaryChannel.hashCode());
        Object $timewindow = this.getTimewindow();
        result = result * prime + ($timewindow == null ? 43 : $timewindow.hashCode());
        Object $watchHelmNamespaceScopedResources = this.getWatchHelmNamespaceScopedResources();
        result = result * prime + ($watchHelmNamespaceScopedResources == null ? 43 : $watchHelmNamespaceScopedResources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubscriptionSpec(" + "allow=" + this.getAllow() + ", channel=" + this.getChannel() + ", deny=" + this.getDeny() + ", hooksecretref=" + this.getHooksecretref() + ", name=" + this.getName() + ", overrides=" + this.getOverrides() + ", packageFilter=" + this.getPackageFilter() + ", packageOverrides=" + this.getPackageOverrides() + ", placement=" + this.getPlacement() + ", secondaryChannel=" + this.getSecondaryChannel() + ", timewindow=" + this.getTimewindow() + ", watchHelmNamespaceScopedResources=" + this.getWatchHelmNamespaceScopedResources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
