
package io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.placementrule.v1.Placement;
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
    "timewindow"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class SubscriptionSpec implements KubernetesResource
{

    @JsonProperty("allow")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowDenyItem> allow = new ArrayList<AllowDenyItem>();
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("deny")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowDenyItem> deny = new ArrayList<AllowDenyItem>();
    @JsonProperty("hooksecretref")
    private io.fabric8.kubernetes.api.model.ObjectReference hooksecretref;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterOverrides> overrides = new ArrayList<ClusterOverrides>();
    @JsonProperty("packageFilter")
    private PackageFilter packageFilter;
    @JsonProperty("packageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Overrides> packageOverrides = new ArrayList<Overrides>();
    @JsonProperty("placement")
    private Placement placement;
    @JsonProperty("secondaryChannel")
    private String secondaryChannel;
    @JsonProperty("timewindow")
    private TimeWindow timewindow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionSpec() {
    }

    /**
     * 
     * @param allow
     * @param deny
     * @param timewindow
     * @param channel
     * @param hooksecretref
     * @param name
     * @param packageOverrides
     * @param secondaryChannel
     * @param overrides
     * @param placement
     * @param packageFilter
     */
    public SubscriptionSpec(List<AllowDenyItem> allow, String channel, List<AllowDenyItem> deny, io.fabric8.kubernetes.api.model.ObjectReference hooksecretref, String name, List<ClusterOverrides> overrides, PackageFilter packageFilter, List<Overrides> packageOverrides, Placement placement, String secondaryChannel, TimeWindow timewindow) {
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
    }

    @JsonProperty("allow")
    public List<AllowDenyItem> getAllow() {
        return allow;
    }

    @JsonProperty("allow")
    public void setAllow(List<AllowDenyItem> allow) {
        this.allow = allow;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("deny")
    public List<AllowDenyItem> getDeny() {
        return deny;
    }

    @JsonProperty("deny")
    public void setDeny(List<AllowDenyItem> deny) {
        this.deny = deny;
    }

    @JsonProperty("hooksecretref")
    public io.fabric8.kubernetes.api.model.ObjectReference getHooksecretref() {
        return hooksecretref;
    }

    @JsonProperty("hooksecretref")
    public void setHooksecretref(io.fabric8.kubernetes.api.model.ObjectReference hooksecretref) {
        this.hooksecretref = hooksecretref;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("overrides")
    public List<ClusterOverrides> getOverrides() {
        return overrides;
    }

    @JsonProperty("overrides")
    public void setOverrides(List<ClusterOverrides> overrides) {
        this.overrides = overrides;
    }

    @JsonProperty("packageFilter")
    public PackageFilter getPackageFilter() {
        return packageFilter;
    }

    @JsonProperty("packageFilter")
    public void setPackageFilter(PackageFilter packageFilter) {
        this.packageFilter = packageFilter;
    }

    @JsonProperty("packageOverrides")
    public List<Overrides> getPackageOverrides() {
        return packageOverrides;
    }

    @JsonProperty("packageOverrides")
    public void setPackageOverrides(List<Overrides> packageOverrides) {
        this.packageOverrides = packageOverrides;
    }

    @JsonProperty("placement")
    public Placement getPlacement() {
        return placement;
    }

    @JsonProperty("placement")
    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    @JsonProperty("secondaryChannel")
    public String getSecondaryChannel() {
        return secondaryChannel;
    }

    @JsonProperty("secondaryChannel")
    public void setSecondaryChannel(String secondaryChannel) {
        this.secondaryChannel = secondaryChannel;
    }

    @JsonProperty("timewindow")
    public TimeWindow getTimewindow() {
        return timewindow;
    }

    @JsonProperty("timewindow")
    public void setTimewindow(TimeWindow timewindow) {
        this.timewindow = timewindow;
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
