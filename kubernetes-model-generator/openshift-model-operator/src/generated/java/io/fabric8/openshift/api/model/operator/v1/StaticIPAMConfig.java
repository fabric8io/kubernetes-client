
package io.fabric8.openshift.api.model.operator.v1;

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
    "addresses",
    "dns",
    "routes"
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
public class StaticIPAMConfig implements KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StaticIPAMAddresses> addresses = new ArrayList<StaticIPAMAddresses>();
    @JsonProperty("dns")
    private StaticIPAMDNS dns;
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StaticIPAMRoutes> routes = new ArrayList<StaticIPAMRoutes>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StaticIPAMConfig() {
    }

    public StaticIPAMConfig(List<StaticIPAMAddresses> addresses, StaticIPAMDNS dns, List<StaticIPAMRoutes> routes) {
        super();
        this.addresses = addresses;
        this.dns = dns;
        this.routes = routes;
    }

    @JsonProperty("addresses")
    public List<StaticIPAMAddresses> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<StaticIPAMAddresses> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("dns")
    public StaticIPAMDNS getDns() {
        return dns;
    }

    @JsonProperty("dns")
    public void setDns(StaticIPAMDNS dns) {
        this.dns = dns;
    }

    @JsonProperty("routes")
    public List<StaticIPAMRoutes> getRoutes() {
        return routes;
    }

    @JsonProperty("routes")
    public void setRoutes(List<StaticIPAMRoutes> routes) {
        this.routes = routes;
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
