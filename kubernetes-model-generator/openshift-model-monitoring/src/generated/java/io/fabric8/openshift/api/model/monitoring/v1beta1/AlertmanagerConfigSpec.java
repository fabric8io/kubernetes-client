
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AlertmanagerConfigSpec implements Editable<AlertmanagerConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("inhibitRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InhibitRule> inhibitRules = new ArrayList<>();
    @JsonProperty("receivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Receiver> receivers = new ArrayList<>();
    @JsonProperty("route")
    private Route route;
    @JsonProperty("timeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TimeInterval> timeIntervals = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpec() {
    }

    public AlertmanagerConfigSpec(List<InhibitRule> inhibitRules, List<Receiver> receivers, Route route, List<TimeInterval> timeIntervals) {
        super();
        this.inhibitRules = inhibitRules;
        this.receivers = receivers;
        this.route = route;
        this.timeIntervals = timeIntervals;
    }

    @JsonProperty("inhibitRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InhibitRule> getInhibitRules() {
        return inhibitRules;
    }

    @JsonProperty("inhibitRules")
    public void setInhibitRules(List<InhibitRule> inhibitRules) {
        this.inhibitRules = inhibitRules;
    }

    @JsonProperty("receivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Receiver> getReceivers() {
        return receivers;
    }

    @JsonProperty("receivers")
    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }

    @JsonProperty("route")
    public Route getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(Route route) {
        this.route = route;
    }

    @JsonProperty("timeIntervals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TimeInterval> getTimeIntervals() {
        return timeIntervals;
    }

    @JsonProperty("timeIntervals")
    public void setTimeIntervals(List<TimeInterval> timeIntervals) {
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
