
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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

/**
 * Route defines a node in the routing tree.
 */
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
public class Route implements Editable<RouteBuilder>, KubernetesResource
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

    /**
     * ActiveTimeIntervals is a list of TimeInterval names when this route should be active.
     */
    @JsonProperty("activeTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getActiveTimeIntervals() {
        return activeTimeIntervals;
    }

    /**
     * ActiveTimeIntervals is a list of TimeInterval names when this route should be active.
     */
    @JsonProperty("activeTimeIntervals")
    public void setActiveTimeIntervals(List<String> activeTimeIntervals) {
        this.activeTimeIntervals = activeTimeIntervals;
    }

    /**
     * Boolean indicating whether an alert should continue matching subsequent sibling nodes. It will always be overridden to true for the first-level route by the Prometheus operator.
     */
    @JsonProperty("continue")
    public Boolean getContinue() {
        return _continue;
    }

    /**
     * Boolean indicating whether an alert should continue matching subsequent sibling nodes. It will always be overridden to true for the first-level route by the Prometheus operator.
     */
    @JsonProperty("continue")
    public void setContinue(Boolean _continue) {
        this._continue = _continue;
    }

    /**
     * List of labels to group by. Labels must not be repeated (unique list). Special label "..." (aggregate by all possible labels), if provided, must be the only element in the list.
     */
    @JsonProperty("groupBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroupBy() {
        return groupBy;
    }

    /**
     * List of labels to group by. Labels must not be repeated (unique list). Special label "..." (aggregate by all possible labels), if provided, must be the only element in the list.
     */
    @JsonProperty("groupBy")
    public void setGroupBy(List<String> groupBy) {
        this.groupBy = groupBy;
    }

    /**
     * How long to wait before sending an updated notification. Must match the regular expression`^(([0-9]+)y)?(([0-9]+)w)?(([0-9]+)d)?(([0-9]+)h)?(([0-9]+)m)?(([0-9]+)s)?(([0-9]+)ms)?$` Example: "5m"
     */
    @JsonProperty("groupInterval")
    public String getGroupInterval() {
        return groupInterval;
    }

    /**
     * How long to wait before sending an updated notification. Must match the regular expression`^(([0-9]+)y)?(([0-9]+)w)?(([0-9]+)d)?(([0-9]+)h)?(([0-9]+)m)?(([0-9]+)s)?(([0-9]+)ms)?$` Example: "5m"
     */
    @JsonProperty("groupInterval")
    public void setGroupInterval(String groupInterval) {
        this.groupInterval = groupInterval;
    }

    /**
     * How long to wait before sending the initial notification. Must match the regular expression`^(([0-9]+)y)?(([0-9]+)w)?(([0-9]+)d)?(([0-9]+)h)?(([0-9]+)m)?(([0-9]+)s)?(([0-9]+)ms)?$` Example: "30s"
     */
    @JsonProperty("groupWait")
    public String getGroupWait() {
        return groupWait;
    }

    /**
     * How long to wait before sending the initial notification. Must match the regular expression`^(([0-9]+)y)?(([0-9]+)w)?(([0-9]+)d)?(([0-9]+)h)?(([0-9]+)m)?(([0-9]+)s)?(([0-9]+)ms)?$` Example: "30s"
     */
    @JsonProperty("groupWait")
    public void setGroupWait(String groupWait) {
        this.groupWait = groupWait;
    }

    /**
     * List of matchers that the alert's labels should match. For the first level route, the operator removes any existing equality and regexp matcher on the `namespace` label and adds a `namespace: &lt;object namespace&gt;` matcher.
     */
    @JsonProperty("matchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Matcher> getMatchers() {
        return matchers;
    }

    /**
     * List of matchers that the alert's labels should match. For the first level route, the operator removes any existing equality and regexp matcher on the `namespace` label and adds a `namespace: &lt;object namespace&gt;` matcher.
     */
    @JsonProperty("matchers")
    public void setMatchers(List<Matcher> matchers) {
        this.matchers = matchers;
    }

    /**
     * Note: this comment applies to the field definition above but appears below otherwise it gets included in the generated manifest. CRD schema doesn't support self-referential types for now (see https://github.com/kubernetes/kubernetes/issues/62872). We have to use an alternative type to circumvent the limitation. The downside is that the Kube API can't validate the data beyond the fact that it is a valid JSON representation. MuteTimeIntervals is a list of TimeInterval names that will mute this route when matched.
     */
    @JsonProperty("muteTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMuteTimeIntervals() {
        return muteTimeIntervals;
    }

    /**
     * Note: this comment applies to the field definition above but appears below otherwise it gets included in the generated manifest. CRD schema doesn't support self-referential types for now (see https://github.com/kubernetes/kubernetes/issues/62872). We have to use an alternative type to circumvent the limitation. The downside is that the Kube API can't validate the data beyond the fact that it is a valid JSON representation. MuteTimeIntervals is a list of TimeInterval names that will mute this route when matched.
     */
    @JsonProperty("muteTimeIntervals")
    public void setMuteTimeIntervals(List<String> muteTimeIntervals) {
        this.muteTimeIntervals = muteTimeIntervals;
    }

    /**
     * Name of the receiver for this route. If not empty, it should be listed in the `receivers` field.
     */
    @JsonProperty("receiver")
    public String getReceiver() {
        return receiver;
    }

    /**
     * Name of the receiver for this route. If not empty, it should be listed in the `receivers` field.
     */
    @JsonProperty("receiver")
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * How long to wait before repeating the last notification. Must match the regular expression`^(([0-9]+)y)?(([0-9]+)w)?(([0-9]+)d)?(([0-9]+)h)?(([0-9]+)m)?(([0-9]+)s)?(([0-9]+)ms)?$` Example: "4h"
     */
    @JsonProperty("repeatInterval")
    public String getRepeatInterval() {
        return repeatInterval;
    }

    /**
     * How long to wait before repeating the last notification. Must match the regular expression`^(([0-9]+)y)?(([0-9]+)w)?(([0-9]+)d)?(([0-9]+)h)?(([0-9]+)m)?(([0-9]+)s)?(([0-9]+)ms)?$` Example: "4h"
     */
    @JsonProperty("repeatInterval")
    public void setRepeatInterval(String repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    /**
     * Child routes.
     */
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JsonNode> getRoutes() {
        return routes;
    }

    /**
     * Child routes.
     */
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

}
