
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EnvoyFilterWaypointMatch)) {
            return false;
        }
        EnvoyFilterWaypointMatch other = (EnvoyFilterWaypointMatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$filter = this.getFilter();
        Object other$filter = other.getFilter();
        if (this$filter == null ? other$filter != null : !this$filter.equals(other$filter)) {
            return false;
        }
        Object this$portNumber = this.getPortNumber();
        Object other$portNumber = other.getPortNumber();
        if (this$portNumber == null ? other$portNumber != null : !this$portNumber.equals(other$portNumber)) {
            return false;
        }
        Object this$route = this.getRoute();
        Object other$route = other.getRoute();
        if (this$route == null ? other$route != null : !this$route.equals(other$route)) {
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
        return other instanceof EnvoyFilterWaypointMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $filter = this.getFilter();
        result = result * prime + ($filter == null ? 43 : $filter.hashCode());
        Object $portNumber = this.getPortNumber();
        result = result * prime + ($portNumber == null ? 43 : $portNumber.hashCode());
        Object $route = this.getRoute();
        result = result * prime + ($route == null ? 43 : $route.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EnvoyFilterWaypointMatch(" + "filter=" + this.getFilter() + ", portNumber=" + this.getPortNumber() + ", route=" + this.getRoute() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
