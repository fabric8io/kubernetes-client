
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.TypedLocalObjectReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NetworkDataIPv4 represents an ipv4 static network object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fromPoolAnnotation",
    "fromPoolRef",
    "id",
    "ipAddressFromIPPool",
    "link",
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
public class NetworkDataIPv4 implements Editable<NetworkDataIPv4Builder>, KubernetesResource
{

    @JsonProperty("fromPoolAnnotation")
    private FromPoolAnnotation fromPoolAnnotation;
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
     */
    public NetworkDataIPv4() {
    }

    public NetworkDataIPv4(FromPoolAnnotation fromPoolAnnotation, TypedLocalObjectReference fromPoolRef, String id, String ipAddressFromIPPool, String link, List<NetworkDataRoutev4> routes) {
        super();
        this.fromPoolAnnotation = fromPoolAnnotation;
        this.fromPoolRef = fromPoolRef;
        this.id = id;
        this.ipAddressFromIPPool = ipAddressFromIPPool;
        this.link = link;
        this.routes = routes;
    }

    /**
     * NetworkDataIPv4 represents an ipv4 static network object.
     */
    @JsonProperty("fromPoolAnnotation")
    public FromPoolAnnotation getFromPoolAnnotation() {
        return fromPoolAnnotation;
    }

    /**
     * NetworkDataIPv4 represents an ipv4 static network object.
     */
    @JsonProperty("fromPoolAnnotation")
    public void setFromPoolAnnotation(FromPoolAnnotation fromPoolAnnotation) {
        this.fromPoolAnnotation = fromPoolAnnotation;
    }

    /**
     * NetworkDataIPv4 represents an ipv4 static network object.
     */
    @JsonProperty("fromPoolRef")
    public TypedLocalObjectReference getFromPoolRef() {
        return fromPoolRef;
    }

    /**
     * NetworkDataIPv4 represents an ipv4 static network object.
     */
    @JsonProperty("fromPoolRef")
    public void setFromPoolRef(TypedLocalObjectReference fromPoolRef) {
        this.fromPoolRef = fromPoolRef;
    }

    /**
     * ID is the network ID (name)
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID is the network ID (name)
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * IPAddressFromIPPool contains the name of the IP pool to use to get an ip address
     */
    @JsonProperty("ipAddressFromIPPool")
    public String getIpAddressFromIPPool() {
        return ipAddressFromIPPool;
    }

    /**
     * IPAddressFromIPPool contains the name of the IP pool to use to get an ip address
     */
    @JsonProperty("ipAddressFromIPPool")
    public void setIpAddressFromIPPool(String ipAddressFromIPPool) {
        this.ipAddressFromIPPool = ipAddressFromIPPool;
    }

    /**
     * Link is the link on which the network applies
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     * Link is the link on which the network applies
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Routes contains a list of IPv4 routes
     */
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataRoutev4> getRoutes() {
        return routes;
    }

    /**
     * Routes contains a list of IPv4 routes
     */
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
        if (!(o instanceof NetworkDataIPv4)) {
            return false;
        }
        NetworkDataIPv4 other = (NetworkDataIPv4) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fromPoolAnnotation = this.getFromPoolAnnotation();
        Object other$fromPoolAnnotation = other.getFromPoolAnnotation();
        if (this$fromPoolAnnotation == null ? other$fromPoolAnnotation != null : !this$fromPoolAnnotation.equals(other$fromPoolAnnotation)) {
            return false;
        }
        Object this$fromPoolRef = this.getFromPoolRef();
        Object other$fromPoolRef = other.getFromPoolRef();
        if (this$fromPoolRef == null ? other$fromPoolRef != null : !this$fromPoolRef.equals(other$fromPoolRef)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$ipAddressFromIPPool = this.getIpAddressFromIPPool();
        Object other$ipAddressFromIPPool = other.getIpAddressFromIPPool();
        if (this$ipAddressFromIPPool == null ? other$ipAddressFromIPPool != null : !this$ipAddressFromIPPool.equals(other$ipAddressFromIPPool)) {
            return false;
        }
        Object this$link = this.getLink();
        Object other$link = other.getLink();
        if (this$link == null ? other$link != null : !this$link.equals(other$link)) {
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
        return other instanceof NetworkDataIPv4;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fromPoolAnnotation = this.getFromPoolAnnotation();
        result = result * prime + ($fromPoolAnnotation == null ? 43 : $fromPoolAnnotation.hashCode());
        Object $fromPoolRef = this.getFromPoolRef();
        result = result * prime + ($fromPoolRef == null ? 43 : $fromPoolRef.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $ipAddressFromIPPool = this.getIpAddressFromIPPool();
        result = result * prime + ($ipAddressFromIPPool == null ? 43 : $ipAddressFromIPPool.hashCode());
        Object $link = this.getLink();
        result = result * prime + ($link == null ? 43 : $link.hashCode());
        Object $routes = this.getRoutes();
        result = result * prime + ($routes == null ? 43 : $routes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDataIPv4(" + "fromPoolAnnotation=" + this.getFromPoolAnnotation() + ", fromPoolRef=" + this.getFromPoolRef() + ", id=" + this.getId() + ", ipAddressFromIPPool=" + this.getIpAddressFromIPPool() + ", link=" + this.getLink() + ", routes=" + this.getRoutes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
