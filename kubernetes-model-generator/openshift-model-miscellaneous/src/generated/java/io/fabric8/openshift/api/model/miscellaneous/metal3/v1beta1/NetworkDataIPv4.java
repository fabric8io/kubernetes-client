
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.TypedLocalObjectReference;
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
    "fromPoolRef",
    "id",
    "ipAddressFromIPPool",
    "link",
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
public class NetworkDataIPv4 implements Editable<NetworkDataIPv4Builder> , KubernetesResource
{

    @JsonProperty("fromPoolRef")
    private TypedLocalObjectReference fromPoolRef;
    @JsonProperty("id")
    private String id;
    @JsonProperty("ipAddressFromIPPool")
    private String ipAddressFromIPPool;
    @JsonProperty("link")
    private String link;
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataRoutev4> routes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkDataIPv4() {
    }

    public NetworkDataIPv4(TypedLocalObjectReference fromPoolRef, String id, String ipAddressFromIPPool, String link, List<NetworkDataRoutev4> routes) {
        super();
        this.fromPoolRef = fromPoolRef;
        this.id = id;
        this.ipAddressFromIPPool = ipAddressFromIPPool;
        this.link = link;
        this.routes = routes;
    }

    @JsonProperty("fromPoolRef")
    public TypedLocalObjectReference getFromPoolRef() {
        return fromPoolRef;
    }

    @JsonProperty("fromPoolRef")
    public void setFromPoolRef(TypedLocalObjectReference fromPoolRef) {
        this.fromPoolRef = fromPoolRef;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("ipAddressFromIPPool")
    public String getIpAddressFromIPPool() {
        return ipAddressFromIPPool;
    }

    @JsonProperty("ipAddressFromIPPool")
    public void setIpAddressFromIPPool(String ipAddressFromIPPool) {
        this.ipAddressFromIPPool = ipAddressFromIPPool;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataRoutev4> getRoutes() {
        return routes;
    }

    @JsonProperty("routes")
    public void setRoutes(List<NetworkDataRoutev4> routes) {
        this.routes = routes;
    }

    @JsonIgnore
    public NetworkDataIPv4Builder edit() {
        return new NetworkDataIPv4Builder(this);
    }

    @JsonIgnore
    public NetworkDataIPv4Builder toBuilder() {
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
