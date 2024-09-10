
package io.fabric8.openshift.api.model.operator.network.v1;

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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "mode",
    "networkInterface",
    "redirect"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class EgressRouterSpec implements Editable<EgressRouterSpecBuilder> , KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EgressRouterSpecAddresses> addresses = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("networkInterface")
    private EgressRouterSpecNetworkInterface networkInterface;
    @JsonProperty("redirect")
    private EgressRouterSpecRedirect redirect;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EgressRouterSpec() {
    }

    public EgressRouterSpec(List<EgressRouterSpecAddresses> addresses, String mode, EgressRouterSpecNetworkInterface networkInterface, EgressRouterSpecRedirect redirect) {
        super();
        this.addresses = addresses;
        this.mode = mode;
        this.networkInterface = networkInterface;
        this.redirect = redirect;
    }

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EgressRouterSpecAddresses> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<EgressRouterSpecAddresses> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("networkInterface")
    public EgressRouterSpecNetworkInterface getNetworkInterface() {
        return networkInterface;
    }

    @JsonProperty("networkInterface")
    public void setNetworkInterface(EgressRouterSpecNetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    @JsonProperty("redirect")
    public EgressRouterSpecRedirect getRedirect() {
        return redirect;
    }

    @JsonProperty("redirect")
    public void setRedirect(EgressRouterSpecRedirect redirect) {
        this.redirect = redirect;
    }

    @JsonIgnore
    public EgressRouterSpecBuilder edit() {
        return new EgressRouterSpecBuilder(this);
    }

    @JsonIgnore
    public EgressRouterSpecBuilder toBuilder() {
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
