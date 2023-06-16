
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "capabilities",
    "channel",
    "clusterID",
    "desiredUpdate",
    "overrides",
    "upstream"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterVersionSpec implements KubernetesResource
{

    @JsonProperty("capabilities")
    private ClusterVersionCapabilitiesSpec capabilities;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("clusterID")
    private String clusterID;
    @JsonProperty("desiredUpdate")
    private Update desiredUpdate;
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ComponentOverride> overrides = new ArrayList<ComponentOverride>();
    @JsonProperty("upstream")
    private String upstream;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterVersionSpec() {
    }

    public ClusterVersionSpec(ClusterVersionCapabilitiesSpec capabilities, String channel, String clusterID, Update desiredUpdate, List<ComponentOverride> overrides, String upstream) {
        super();
        this.capabilities = capabilities;
        this.channel = channel;
        this.clusterID = clusterID;
        this.desiredUpdate = desiredUpdate;
        this.overrides = overrides;
        this.upstream = upstream;
    }

    @JsonProperty("capabilities")
    public ClusterVersionCapabilitiesSpec getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(ClusterVersionCapabilitiesSpec capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("clusterID")
    public String getClusterID() {
        return clusterID;
    }

    @JsonProperty("clusterID")
    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    @JsonProperty("desiredUpdate")
    public Update getDesiredUpdate() {
        return desiredUpdate;
    }

    @JsonProperty("desiredUpdate")
    public void setDesiredUpdate(Update desiredUpdate) {
        this.desiredUpdate = desiredUpdate;
    }

    @JsonProperty("overrides")
    public List<ComponentOverride> getOverrides() {
        return overrides;
    }

    @JsonProperty("overrides")
    public void setOverrides(List<ComponentOverride> overrides) {
        this.overrides = overrides;
    }

    @JsonProperty("upstream")
    public String getUpstream() {
        return upstream;
    }

    @JsonProperty("upstream")
    public void setUpstream(String upstream) {
        this.upstream = upstream;
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
