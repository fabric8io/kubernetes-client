
package io.fabric8.knative.serving.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TrafficTarget holds a single entry of the routing table for a Route.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configurationName",
    "latestRevision",
    "percent",
    "revisionName",
    "tag",
    "url"
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
public class TrafficTarget implements Editable<TrafficTargetBuilder>, KubernetesResource
{

    @JsonProperty("configurationName")
    private String configurationName;
    @JsonProperty("latestRevision")
    private Boolean latestRevision;
    @JsonProperty("percent")
    private Long percent;
    @JsonProperty("revisionName")
    private String revisionName;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TrafficTarget() {
    }

    public TrafficTarget(String configurationName, Boolean latestRevision, Long percent, String revisionName, String tag, String url) {
        super();
        this.configurationName = configurationName;
        this.latestRevision = latestRevision;
        this.percent = percent;
        this.revisionName = revisionName;
        this.tag = tag;
        this.url = url;
    }

    /**
     * ConfigurationName of a configuration to whose latest revision we will send this portion of traffic. When the "status.latestReadyRevisionName" of the referenced configuration changes, we will automatically migrate traffic from the prior "latest ready" revision to the new one.  This field is never set in Route's status, only its spec.  This is mutually exclusive with RevisionName.
     */
    @JsonProperty("configurationName")
    public String getConfigurationName() {
        return configurationName;
    }

    /**
     * ConfigurationName of a configuration to whose latest revision we will send this portion of traffic. When the "status.latestReadyRevisionName" of the referenced configuration changes, we will automatically migrate traffic from the prior "latest ready" revision to the new one.  This field is never set in Route's status, only its spec.  This is mutually exclusive with RevisionName.
     */
    @JsonProperty("configurationName")
    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    /**
     * LatestRevision may be optionally provided to indicate that the latest ready Revision of the Configuration should be used for this traffic target.  When provided LatestRevision must be true if RevisionName is empty; it must be false when RevisionName is non-empty.
     */
    @JsonProperty("latestRevision")
    public Boolean getLatestRevision() {
        return latestRevision;
    }

    /**
     * LatestRevision may be optionally provided to indicate that the latest ready Revision of the Configuration should be used for this traffic target.  When provided LatestRevision must be true if RevisionName is empty; it must be false when RevisionName is non-empty.
     */
    @JsonProperty("latestRevision")
    public void setLatestRevision(Boolean latestRevision) {
        this.latestRevision = latestRevision;
    }

    /**
     * Percent indicates that percentage based routing should be used and the value indicates the percent of traffic that is be routed to this Revision or Configuration. `0` (zero) mean no traffic, `100` means all traffic. When percentage based routing is being used the follow rules apply: - the sum of all percent values must equal 100 - when not specified, the implied value for `percent` is zero for<br><p>   that particular Revision or Configuration
     */
    @JsonProperty("percent")
    public Long getPercent() {
        return percent;
    }

    /**
     * Percent indicates that percentage based routing should be used and the value indicates the percent of traffic that is be routed to this Revision or Configuration. `0` (zero) mean no traffic, `100` means all traffic. When percentage based routing is being used the follow rules apply: - the sum of all percent values must equal 100 - when not specified, the implied value for `percent` is zero for<br><p>   that particular Revision or Configuration
     */
    @JsonProperty("percent")
    public void setPercent(Long percent) {
        this.percent = percent;
    }

    /**
     * RevisionName of a specific revision to which to send this portion of traffic.  This is mutually exclusive with ConfigurationName.
     */
    @JsonProperty("revisionName")
    public String getRevisionName() {
        return revisionName;
    }

    /**
     * RevisionName of a specific revision to which to send this portion of traffic.  This is mutually exclusive with ConfigurationName.
     */
    @JsonProperty("revisionName")
    public void setRevisionName(String revisionName) {
        this.revisionName = revisionName;
    }

    /**
     * Tag is optionally used to expose a dedicated url for referencing this target exclusively.
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * Tag is optionally used to expose a dedicated url for referencing this target exclusively.
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * TrafficTarget holds a single entry of the routing table for a Route.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * TrafficTarget holds a single entry of the routing table for a Route.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public TrafficTargetBuilder edit() {
        return new TrafficTargetBuilder(this);
    }

    @JsonIgnore
    public TrafficTargetBuilder toBuilder() {
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
