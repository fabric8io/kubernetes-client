
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
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
 * $hide_from_docs
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filter",
    "portNumber",
    "route"
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
public class EnvoyFilterWaypointMatch implements Editable<EnvoyFilterWaypointMatchBuilder>, KubernetesResource
{

    @JsonProperty("filter")
    private EnvoyFilterWaypointMatchFilterMatch filter;
    @JsonProperty("portNumber")
    private Long portNumber;
    @JsonProperty("route")
    private EnvoyFilterWaypointMatchRouteMatch route;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilterWaypointMatch() {
    }

    public EnvoyFilterWaypointMatch(EnvoyFilterWaypointMatchFilterMatch filter, Long portNumber, EnvoyFilterWaypointMatchRouteMatch route) {
        super();
        this.filter = filter;
        this.portNumber = portNumber;
        this.route = route;
    }

    /**
     * $hide_from_docs
     */
    @JsonProperty("filter")
    public EnvoyFilterWaypointMatchFilterMatch getFilter() {
        return filter;
    }

    /**
     * $hide_from_docs
     */
    @JsonProperty("filter")
    public void setFilter(EnvoyFilterWaypointMatchFilterMatch filter) {
        this.filter = filter;
    }

    /**
     * The service port to match on. If not specified, matches all ports.
     */
    @JsonProperty("portNumber")
    public Long getPortNumber() {
        return portNumber;
    }

    /**
     * The service port to match on. If not specified, matches all ports.
     */
    @JsonProperty("portNumber")
    public void setPortNumber(Long portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * $hide_from_docs
     */
    @JsonProperty("route")
    public EnvoyFilterWaypointMatchRouteMatch getRoute() {
        return route;
    }

    /**
     * $hide_from_docs
     */
    @JsonProperty("route")
    public void setRoute(EnvoyFilterWaypointMatchRouteMatch route) {
        this.route = route;
    }

    @JsonIgnore
    public EnvoyFilterWaypointMatchBuilder edit() {
        return new EnvoyFilterWaypointMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterWaypointMatchBuilder toBuilder() {
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
