
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
    "inhibitRules",
    "receivers",
    "route",
    "timeIntervals"
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
public class AlertmanagerConfigSpec implements Editable<AlertmanagerConfigSpecBuilder> , KubernetesResource
{

    @JsonProperty("inhibitRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecInhibitRules> inhibitRules = new ArrayList<>();
    @JsonProperty("receivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecReceivers> receivers = new ArrayList<>();
    @JsonProperty("route")
    private AlertmanagerConfigSpecRoute route;
    @JsonProperty("timeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecTimeIntervals> timeIntervals = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpec() {
    }

    public AlertmanagerConfigSpec(List<AlertmanagerConfigSpecInhibitRules> inhibitRules, List<AlertmanagerConfigSpecReceivers> receivers, AlertmanagerConfigSpecRoute route, List<AlertmanagerConfigSpecTimeIntervals> timeIntervals) {
        super();
        this.inhibitRules = inhibitRules;
        this.receivers = receivers;
        this.route = route;
        this.timeIntervals = timeIntervals;
    }

    @JsonProperty("inhibitRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecInhibitRules> getInhibitRules() {
        return inhibitRules;
    }

    @JsonProperty("inhibitRules")
    public void setInhibitRules(List<AlertmanagerConfigSpecInhibitRules> inhibitRules) {
        this.inhibitRules = inhibitRules;
    }

    @JsonProperty("receivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecReceivers> getReceivers() {
        return receivers;
    }

    @JsonProperty("receivers")
    public void setReceivers(List<AlertmanagerConfigSpecReceivers> receivers) {
        this.receivers = receivers;
    }

    @JsonProperty("route")
    public AlertmanagerConfigSpecRoute getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(AlertmanagerConfigSpecRoute route) {
        this.route = route;
    }

    @JsonProperty("timeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecTimeIntervals> getTimeIntervals() {
        return timeIntervals;
    }

    @JsonProperty("timeIntervals")
    public void setTimeIntervals(List<AlertmanagerConfigSpecTimeIntervals> timeIntervals) {
        this.timeIntervals = timeIntervals;
    }

    @JsonIgnore
    public AlertmanagerConfigSpecBuilder edit() {
        return new AlertmanagerConfigSpecBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecBuilder toBuilder() {
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
