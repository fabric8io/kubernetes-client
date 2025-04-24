
package io.fabric8.kubernetes.api.model;

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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Endpoints is a collection of endpoints that implement the actual service. Example:<br><p> <br><p> 	 Name: "mysvc",<br><p> 	 Subsets: [<br><p> 	   {<br><p> 	     Addresses: [{"ip": "10.10.1.1"}, {"ip": "10.10.2.2"}],<br><p> 	     Ports: [{"name": "a", "port": 8675}, {"name": "b", "port": 309}]<br><p> 	   },<br><p> 	   {<br><p> 	     Addresses: [{"ip": "10.10.3.3"}],<br><p> 	     Ports: [{"name": "a", "port": 93}, {"name": "b", "port": 76}]<br><p> 	   },<br><p> 	]<br><p> <br><p> Endpoints is a legacy API and does not contain information about all Service features. Use discoveryv1.EndpointSlice for complete information about Service endpoints.<br><p> <br><p> Deprecated: This API is deprecated in v1.33+. Use discoveryv1.EndpointSlice.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "subsets"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Endpoints implements Editable<EndpointsBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("kind")
    private String kind = "Endpoints";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("subsets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EndpointSubset> subsets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Endpoints() {
    }

    public Endpoints(String apiVersion, String kind, ObjectMeta metadata, List<EndpointSubset> subsets) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.subsets = subsets;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Endpoints is a collection of endpoints that implement the actual service. Example:<br><p> <br><p> 	 Name: "mysvc",<br><p> 	 Subsets: [<br><p> 	   {<br><p> 	     Addresses: [{"ip": "10.10.1.1"}, {"ip": "10.10.2.2"}],<br><p> 	     Ports: [{"name": "a", "port": 8675}, {"name": "b", "port": 309}]<br><p> 	   },<br><p> 	   {<br><p> 	     Addresses: [{"ip": "10.10.3.3"}],<br><p> 	     Ports: [{"name": "a", "port": 93}, {"name": "b", "port": 76}]<br><p> 	   },<br><p> 	]<br><p> <br><p> Endpoints is a legacy API and does not contain information about all Service features. Use discoveryv1.EndpointSlice for complete information about Service endpoints.<br><p> <br><p> Deprecated: This API is deprecated in v1.33+. Use discoveryv1.EndpointSlice.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Endpoints is a collection of endpoints that implement the actual service. Example:<br><p> <br><p> 	 Name: "mysvc",<br><p> 	 Subsets: [<br><p> 	   {<br><p> 	     Addresses: [{"ip": "10.10.1.1"}, {"ip": "10.10.2.2"}],<br><p> 	     Ports: [{"name": "a", "port": 8675}, {"name": "b", "port": 309}]<br><p> 	   },<br><p> 	   {<br><p> 	     Addresses: [{"ip": "10.10.3.3"}],<br><p> 	     Ports: [{"name": "a", "port": 93}, {"name": "b", "port": 76}]<br><p> 	   },<br><p> 	]<br><p> <br><p> Endpoints is a legacy API and does not contain information about all Service features. Use discoveryv1.EndpointSlice for complete information about Service endpoints.<br><p> <br><p> Deprecated: This API is deprecated in v1.33+. Use discoveryv1.EndpointSlice.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * The set of all endpoints is the union of all subsets. Addresses are placed into subsets according to the IPs they share. A single address with multiple ports, some of which are ready and some of which are not (because they come from different containers) will result in the address being displayed in different subsets for the different ports. No address will appear in both Addresses and NotReadyAddresses in the same subset. Sets of addresses and ports that comprise a service.
     */
    @JsonProperty("subsets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EndpointSubset> getSubsets() {
        return subsets;
    }

    /**
     * The set of all endpoints is the union of all subsets. Addresses are placed into subsets according to the IPs they share. A single address with multiple ports, some of which are ready and some of which are not (because they come from different containers) will result in the address being displayed in different subsets for the different ports. No address will appear in both Addresses and NotReadyAddresses in the same subset. Sets of addresses and ports that comprise a service.
     */
    @JsonProperty("subsets")
    public void setSubsets(List<EndpointSubset> subsets) {
        this.subsets = subsets;
    }

    @JsonIgnore
    public EndpointsBuilder edit() {
        return new EndpointsBuilder(this);
    }

    @JsonIgnore
    public EndpointsBuilder toBuilder() {
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
