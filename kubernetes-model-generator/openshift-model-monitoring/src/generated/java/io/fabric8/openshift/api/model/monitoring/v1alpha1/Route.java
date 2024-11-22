
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import com.fasterxml.jackson.databind.JsonNode;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "activeTimeIntervals",
    "continue",
    "groupBy",
    "groupInterval",
    "groupWait",
    "matchers",
    "muteTimeIntervals",
    "receiver",
    "repeatInterval",
    "routes"
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
public class Route implements Editable<RouteBuilder> , KubernetesResource
{

    @JsonProperty("activeTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> activeTimeIntervals = new ArrayList<>();
    @JsonProperty("continue")
    private Boolean _continue;
    @JsonProperty("groupBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groupBy = new ArrayList<>();
    @JsonProperty("groupInterval")
    private String groupInterval;
    @JsonProperty("groupWait")
    private String groupWait;
    @JsonProperty("matchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Matcher> matchers = new ArrayList<>();
    @JsonProperty("muteTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> muteTimeIntervals = new ArrayList<>();
    @JsonProperty("receiver")
    private String receiver;
    @JsonProperty("repeatInterval")
    private String repeatInterval;
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JsonNode> routes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Route() {
    }

    public Route(List<String> activeTimeIntervals, Boolean _continue, List<String> groupBy, String groupInterval, String groupWait, List<Matcher> matchers, List<String> muteTimeIntervals, String receiver, String repeatInterval, List<JsonNode> routes) {
        super();
        this.activeTimeIntervals = activeTimeIntervals;
        this._continue = _continue;
        this.groupBy = groupBy;
        this.groupInterval = groupInterval;
        this.groupWait = groupWait;
        this.matchers = matchers;
        this.muteTimeIntervals = muteTimeIntervals;
        this.receiver = receiver;
        this.repeatInterval = repeatInterval;
        this.routes = routes;
    }

    @JsonProperty("activeTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getActiveTimeIntervals() {
        return activeTimeIntervals;
    }

    @JsonProperty("activeTimeIntervals")
    public void setActiveTimeIntervals(List<String> activeTimeIntervals) {
        this.activeTimeIntervals = activeTimeIntervals;
    }

    @JsonProperty("continue")
    public Boolean getContinue() {
        return _continue;
    }

    @JsonProperty("continue")
    public void setContinue(Boolean _continue) {
        this._continue = _continue;
    }

    @JsonProperty("groupBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroupBy() {
        return groupBy;
    }

    @JsonProperty("groupBy")
    public void setGroupBy(List<String> groupBy) {
        this.groupBy = groupBy;
    }

    @JsonProperty("groupInterval")
    public String getGroupInterval() {
        return groupInterval;
    }

    @JsonProperty("groupInterval")
    public void setGroupInterval(String groupInterval) {
        this.groupInterval = groupInterval;
    }

    @JsonProperty("groupWait")
    public String getGroupWait() {
        return groupWait;
    }

    @JsonProperty("groupWait")
    public void setGroupWait(String groupWait) {
        this.groupWait = groupWait;
    }

    @JsonProperty("matchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Matcher> getMatchers() {
        return matchers;
    }

    @JsonProperty("matchers")
    public void setMatchers(List<Matcher> matchers) {
        this.matchers = matchers;
    }

    @JsonProperty("muteTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMuteTimeIntervals() {
        return muteTimeIntervals;
    }

    @JsonProperty("muteTimeIntervals")
    public void setMuteTimeIntervals(List<String> muteTimeIntervals) {
        this.muteTimeIntervals = muteTimeIntervals;
    }

    @JsonProperty("receiver")
    public String getReceiver() {
        return receiver;
    }

    @JsonProperty("receiver")
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @JsonProperty("repeatInterval")
    public String getRepeatInterval() {
        return repeatInterval;
    }

    @JsonProperty("repeatInterval")
    public void setRepeatInterval(String repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JsonNode> getRoutes() {
        return routes;
    }

    @JsonProperty("routes")
    public void setRoutes(List<JsonNode> routes) {
        this.routes = routes;
    }

    @JsonIgnore
    public RouteBuilder edit() {
        return new RouteBuilder(this);
    }

    @JsonIgnore
    public RouteBuilder toBuilder() {
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
