
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * PrivateLinkServiceConnection defines the specification for a private link service connection associated with a private endpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupIDs",
    "name",
    "privateLinkServiceID",
    "requestMessage"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class PrivateLinkServiceConnection implements Editable<PrivateLinkServiceConnectionBuilder>, KubernetesResource
{

    @JsonProperty("groupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groupIDs = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("privateLinkServiceID")
    private String privateLinkServiceID;
    @JsonProperty("requestMessage")
    private String requestMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrivateLinkServiceConnection() {
    }

    public PrivateLinkServiceConnection(List<String> groupIDs, String name, String privateLinkServiceID, String requestMessage) {
        super();
        this.groupIDs = groupIDs;
        this.name = name;
        this.privateLinkServiceID = privateLinkServiceID;
        this.requestMessage = requestMessage;
    }

    /**
     * GroupIDs specifies the ID(s) of the group(s) obtained from the remote resource that this private endpoint should connect to.
     */
    @JsonProperty("groupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroupIDs() {
        return groupIDs;
    }

    /**
     * GroupIDs specifies the ID(s) of the group(s) obtained from the remote resource that this private endpoint should connect to.
     */
    @JsonProperty("groupIDs")
    public void setGroupIDs(List<String> groupIDs) {
        this.groupIDs = groupIDs;
    }

    /**
     * Name specifies the name of the private link service.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name specifies the name of the private link service.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PrivateLinkServiceID specifies the resource ID of the private link service.
     */
    @JsonProperty("privateLinkServiceID")
    public String getPrivateLinkServiceID() {
        return privateLinkServiceID;
    }

    /**
     * PrivateLinkServiceID specifies the resource ID of the private link service.
     */
    @JsonProperty("privateLinkServiceID")
    public void setPrivateLinkServiceID(String privateLinkServiceID) {
        this.privateLinkServiceID = privateLinkServiceID;
    }

    /**
     * RequestMessage specifies a message passed to the owner of the remote resource with the private endpoint connection request.
     */
    @JsonProperty("requestMessage")
    public String getRequestMessage() {
        return requestMessage;
    }

    /**
     * RequestMessage specifies a message passed to the owner of the remote resource with the private endpoint connection request.
     */
    @JsonProperty("requestMessage")
    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    @JsonIgnore
    public PrivateLinkServiceConnectionBuilder edit() {
        return new PrivateLinkServiceConnectionBuilder(this);
    }

    @JsonIgnore
    public PrivateLinkServiceConnectionBuilder toBuilder() {
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
