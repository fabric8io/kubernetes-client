
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
