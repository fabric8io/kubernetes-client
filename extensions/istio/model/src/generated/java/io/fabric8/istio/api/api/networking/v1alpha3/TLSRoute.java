
package io.fabric8.istio.api.api.networking.v1alpha3;

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

/**
 * Describes match conditions and actions for routing unterminated TLS traffic (TLS/HTTPS) The following routing rule forwards unterminated TLS traffic arriving at port 443 of gateway called "mygateway" to internal services in the mesh based on the SNI value.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: bookinfo-sni<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- "&#42;.bookinfo.com"<br><p> 	gateways:<br><p> 	- mygateway<br><p> 	tls:<br><p> 	- match:<br><p> 	  - port: 443<br><p> 	    sniHosts:<br><p> 	    - login.bookinfo.com<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: login.prod.svc.cluster.local<br><p> 	- match:<br><p> 	  - port: 443<br><p> 	    sniHosts:<br><p> 	    - reviews.bookinfo.com<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> <br><p> ```
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
public class TLSRoute implements Editable<TLSRouteBuilder>, KubernetesResource
{

    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TLSMatchAttributes> match = new ArrayList<>();
    @JsonProperty("route")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteDestination> route = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TLSRoute() {
    }

    public TLSRoute(List<TLSMatchAttributes> match, List<RouteDestination> route) {
        super();
        this.match = match;
        this.route = route;
    }

    /**
     * Match conditions to be satisfied for the rule to be activated. All conditions inside a single match block have AND semantics, while the list of match blocks have OR semantics. The rule is matched if any one of the match blocks succeed.
     */
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TLSMatchAttributes> getMatch() {
        return match;
    }

    /**
     * Match conditions to be satisfied for the rule to be activated. All conditions inside a single match block have AND semantics, while the list of match blocks have OR semantics. The rule is matched if any one of the match blocks succeed.
     */
    @JsonProperty("match")
    public void setMatch(List<TLSMatchAttributes> match) {
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
    public TLSRouteBuilder edit() {
        return new TLSRouteBuilder(this);
    }

    @JsonIgnore
    public TLSRouteBuilder toBuilder() {
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
