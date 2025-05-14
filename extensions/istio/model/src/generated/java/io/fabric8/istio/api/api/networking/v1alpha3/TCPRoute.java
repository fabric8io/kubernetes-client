
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * Describes match conditions and actions for routing TCP traffic. The following routing rule forwards traffic arriving at port 27017 for mongo.prod.svc.cluster.local to another Mongo server on port 5555.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: bookinfo-mongo<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- mongo.prod.svc.cluster.local<br><p> 	tcp:<br><p> 	- match:<br><p> 	  - port: 27017<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: mongo.backup.svc.cluster.local<br><p> 	      port:<br><p> 	        number: 5555<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "match",
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
public class TCPRoute implements Editable<TCPRouteBuilder>, KubernetesResource
{

    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<L4MatchAttributes> match = new ArrayList<>();
    @JsonProperty("route")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteDestination> route = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TCPRoute() {
    }

    public TCPRoute(List<L4MatchAttributes> match, List<RouteDestination> route) {
        super();
        this.match = match;
        this.route = route;
    }

    /**
     * Match conditions to be satisfied for the rule to be activated. All conditions inside a single match block have AND semantics, while the list of match blocks have OR semantics. The rule is matched if any one of the match blocks succeed.
     */
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<L4MatchAttributes> getMatch() {
        return match;
    }

    /**
     * Match conditions to be satisfied for the rule to be activated. All conditions inside a single match block have AND semantics, while the list of match blocks have OR semantics. The rule is matched if any one of the match blocks succeed.
     */
    @JsonProperty("match")
    public void setMatch(List<L4MatchAttributes> match) {
        this.match = match;
    }

    /**
     * The destination to which the connection should be forwarded to.
     */
    @JsonProperty("route")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteDestination> getRoute() {
        return route;
    }

    /**
     * The destination to which the connection should be forwarded to.
     */
    @JsonProperty("route")
    public void setRoute(List<RouteDestination> route) {
        this.route = route;
    }

    @JsonIgnore
    public TCPRouteBuilder edit() {
        return new TCPRouteBuilder(this);
    }

    @JsonIgnore
    public TCPRouteBuilder toBuilder() {
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
