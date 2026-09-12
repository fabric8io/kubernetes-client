
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
     * activeTimeIntervals is a list of TimeInterval names when this route should be active.
     */
    @JsonProperty("activeTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getActiveTimeIntervals() {
        return activeTimeIntervals;
    }

    /**
     * activeTimeIntervals is a list of TimeInterval names when this route should be active.
     */
    @JsonProperty("activeTimeIntervals")
    public void setActiveTimeIntervals(List<String> activeTimeIntervals) {
        this.activeTimeIntervals = activeTimeIntervals;
    }

    /**
     * continue defines the boolean indicating whether an alert should continue matching subsequent sibling nodes. It will always be overridden to true for the first-level route by the Prometheus operator.
     */
    @JsonProperty("continue")
    public Boolean getContinue() {
        return _continue;
    }

    /**
     * continue defines the boolean indicating whether an alert should continue matching subsequent sibling nodes. It will always be overridden to true for the first-level route by the Prometheus operator.
     */
    @JsonProperty("continue")
    public void setContinue(Boolean _continue) {
        this._continue = _continue;
    }

    /**
     * groupBy defines the list of labels to group by. Labels must not be repeated (unique list). Special label "..." (aggregate by all possible labels), if provided, must be the only element in the list.
     */
    @JsonProperty("groupBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroupBy() {
        return groupBy;
    }

    /**
     * groupBy defines the list of labels to group by. Labels must not be repeated (unique list). Special label "..." (aggregate by all possible labels), if provided, must be the only element in the list.
     */
    @JsonProperty("groupBy")
    public void setGroupBy(List<String> groupBy) {
        this.groupBy = groupBy;
    }

    /**
     * groupInterval defines how long to wait before sending an updated notification. Must be greater than 0. Example: "5m"
     */
    @JsonProperty("groupInterval")
    public String getGroupInterval() {
        return groupInterval;
    }

    /**
     * groupInterval defines how long to wait before sending an updated notification. Must be greater than 0. Example: "5m"
     */
    @JsonProperty("groupInterval")
    public void setGroupInterval(String groupInterval) {
        this.groupInterval = groupInterval;
    }

    /**
     * groupWait defines how long to wait before sending the initial notification. Example: "30s"
     */
    @JsonProperty("groupWait")
    public String getGroupWait() {
        return groupWait;
    }

    /**
     * groupWait defines how long to wait before sending the initial notification. Example: "30s"
     */
    @JsonProperty("groupWait")
    public void setGroupWait(String groupWait) {
        this.groupWait = groupWait;
    }

    /**
     * matchers defines the list of matchers that the alert's labels should match. For the first level route, the operator removes any existing equality and regexp matcher on the `namespace` label and adds a `namespace: &lt;object namespace&gt;` matcher, unless configured otherwise in Alertmanager's AlertmanagerConfigMatcherStrategyType.
     */
    @JsonProperty("matchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Matcher> getMatchers() {
        return matchers;
    }

    /**
     * matchers defines the list of matchers that the alert's labels should match. For the first level route, the operator removes any existing equality and regexp matcher on the `namespace` label and adds a `namespace: &lt;object namespace&gt;` matcher, unless configured otherwise in Alertmanager's AlertmanagerConfigMatcherStrategyType.
     */
    @JsonProperty("matchers")
    public void setMatchers(List<Matcher> matchers) {
        this.matchers = matchers;
    }

    /**
     * muteTimeIntervals is a list of MuteTimeInterval names that will mute this route when matched,
     */
    @JsonProperty("muteTimeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMuteTimeIntervals() {
        return muteTimeIntervals;
    }

    /**
     * muteTimeIntervals is a list of MuteTimeInterval names that will mute this route when matched,
     */
    @JsonProperty("muteTimeIntervals")
    public void setMuteTimeIntervals(List<String> muteTimeIntervals) {
        this.muteTimeIntervals = muteTimeIntervals;
    }

    /**
     * receiver defines the name of the receiver for this route. If not empty, it should be listed in the `receivers` field.
     */
    @JsonProperty("receiver")
    public String getReceiver() {
        return receiver;
    }

    /**
     * receiver defines the name of the receiver for this route. If not empty, it should be listed in the `receivers` field.
     */
    @JsonProperty("receiver")
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * repeatInterval defines how long to wait before repeating the last notification. Must be greater than 0. Example: "4h"
     */
    @JsonProperty("repeatInterval")
    public String getRepeatInterval() {
        return repeatInterval;
    }

    /**
     * repeatInterval defines how long to wait before repeating the last notification. Must be greater than 0. Example: "4h"
     */
    @JsonProperty("repeatInterval")
    public void setRepeatInterval(String repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    /**
     * routes defines the child routes.
     */
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JsonNode> getRoutes() {
        return routes;
    }

    /**
     * routes defines the child routes.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Route)) {
            return false;
        }
        Route other = (Route) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$activeTimeIntervals = this.getActiveTimeIntervals();
        Object other$activeTimeIntervals = other.getActiveTimeIntervals();
        if (this$activeTimeIntervals == null ? other$activeTimeIntervals != null : !this$activeTimeIntervals.equals(other$activeTimeIntervals)) {
            return false;
        }
        Object this$_continue = this.getContinue();
        Object other$_continue = other.getContinue();
        if (this$_continue == null ? other$_continue != null : !this$_continue.equals(other$_continue)) {
            return false;
        }
        Object this$groupBy = this.getGroupBy();
        Object other$groupBy = other.getGroupBy();
        if (this$groupBy == null ? other$groupBy != null : !this$groupBy.equals(other$groupBy)) {
            return false;
        }
        Object this$groupInterval = this.getGroupInterval();
        Object other$groupInterval = other.getGroupInterval();
        if (this$groupInterval == null ? other$groupInterval != null : !this$groupInterval.equals(other$groupInterval)) {
            return false;
        }
        Object this$groupWait = this.getGroupWait();
        Object other$groupWait = other.getGroupWait();
        if (this$groupWait == null ? other$groupWait != null : !this$groupWait.equals(other$groupWait)) {
            return false;
        }
        Object this$matchers = this.getMatchers();
        Object other$matchers = other.getMatchers();
        if (this$matchers == null ? other$matchers != null : !this$matchers.equals(other$matchers)) {
            return false;
        }
        Object this$muteTimeIntervals = this.getMuteTimeIntervals();
        Object other$muteTimeIntervals = other.getMuteTimeIntervals();
        if (this$muteTimeIntervals == null ? other$muteTimeIntervals != null : !this$muteTimeIntervals.equals(other$muteTimeIntervals)) {
            return false;
        }
        Object this$receiver = this.getReceiver();
        Object other$receiver = other.getReceiver();
        if (this$receiver == null ? other$receiver != null : !this$receiver.equals(other$receiver)) {
            return false;
        }
        Object this$repeatInterval = this.getRepeatInterval();
        Object other$repeatInterval = other.getRepeatInterval();
        if (this$repeatInterval == null ? other$repeatInterval != null : !this$repeatInterval.equals(other$repeatInterval)) {
            return false;
        }
        Object this$routes = this.getRoutes();
        Object other$routes = other.getRoutes();
        if (this$routes == null ? other$routes != null : !this$routes.equals(other$routes)) {
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
        return other instanceof Route;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $activeTimeIntervals = this.getActiveTimeIntervals();
        result = result * prime + ($activeTimeIntervals == null ? 43 : $activeTimeIntervals.hashCode());
        Object $_continue = this.getContinue();
        result = result * prime + ($_continue == null ? 43 : $_continue.hashCode());
        Object $groupBy = this.getGroupBy();
        result = result * prime + ($groupBy == null ? 43 : $groupBy.hashCode());
        Object $groupInterval = this.getGroupInterval();
        result = result * prime + ($groupInterval == null ? 43 : $groupInterval.hashCode());
        Object $groupWait = this.getGroupWait();
        result = result * prime + ($groupWait == null ? 43 : $groupWait.hashCode());
        Object $matchers = this.getMatchers();
        result = result * prime + ($matchers == null ? 43 : $matchers.hashCode());
        Object $muteTimeIntervals = this.getMuteTimeIntervals();
        result = result * prime + ($muteTimeIntervals == null ? 43 : $muteTimeIntervals.hashCode());
        Object $receiver = this.getReceiver();
        result = result * prime + ($receiver == null ? 43 : $receiver.hashCode());
        Object $repeatInterval = this.getRepeatInterval();
        result = result * prime + ($repeatInterval == null ? 43 : $repeatInterval.hashCode());
        Object $routes = this.getRoutes();
        result = result * prime + ($routes == null ? 43 : $routes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Route(" + "activeTimeIntervals=" + this.getActiveTimeIntervals() + ", _continue=" + this.getContinue() + ", groupBy=" + this.getGroupBy() + ", groupInterval=" + this.getGroupInterval() + ", groupWait=" + this.getGroupWait() + ", matchers=" + this.getMatchers() + ", muteTimeIntervals=" + this.getMuteTimeIntervals() + ", receiver=" + this.getReceiver() + ", repeatInterval=" + this.getRepeatInterval() + ", routes=" + this.getRoutes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
