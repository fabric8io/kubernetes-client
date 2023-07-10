
package io.fabric8.openshift.api.model.miscellaneous.network.operator.v1;

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
    "mode",
    "networkInterface",
    "redirect"
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
public class EgressRouterSpec implements KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EgressRouterAddress> addresses = new ArrayList<EgressRouterAddress>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("networkInterface")
    private EgressRouterInterface networkInterface;
    @JsonProperty("redirect")
    private RedirectConfig redirect;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EgressRouterSpec() {
    }

    public EgressRouterSpec(List<EgressRouterAddress> addresses, String mode, EgressRouterInterface networkInterface, RedirectConfig redirect) {
        super();
        this.addresses = addresses;
        this.mode = mode;
        this.networkInterface = networkInterface;
        this.redirect = redirect;
    }

    @JsonProperty("addresses")
    public List<EgressRouterAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<EgressRouterAddress> addresses) {
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
    public EgressRouterInterface getNetworkInterface() {
        return networkInterface;
    }

    @JsonProperty("networkInterface")
    public void setNetworkInterface(EgressRouterInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    @JsonProperty("redirect")
    public RedirectConfig getRedirect() {
        return redirect;
    }

    @JsonProperty("redirect")
    public void setRedirect(RedirectConfig redirect) {
        this.redirect = redirect;
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
