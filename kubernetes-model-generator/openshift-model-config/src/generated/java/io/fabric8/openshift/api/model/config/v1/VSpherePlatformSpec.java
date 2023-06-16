
package io.fabric8.openshift.api.model.config.v1;

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
    "failureDomains",
    "nodeNetworking",
    "vcenters"
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
public class VSpherePlatformSpec implements KubernetesResource
{

    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VSpherePlatformFailureDomainSpec> failureDomains = new ArrayList<VSpherePlatformFailureDomainSpec>();
    @JsonProperty("nodeNetworking")
    private VSpherePlatformNodeNetworking nodeNetworking;
    @JsonProperty("vcenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VSpherePlatformVCenterSpec> vcenters = new ArrayList<VSpherePlatformVCenterSpec>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VSpherePlatformSpec() {
    }

    public VSpherePlatformSpec(List<VSpherePlatformFailureDomainSpec> failureDomains, VSpherePlatformNodeNetworking nodeNetworking, List<VSpherePlatformVCenterSpec> vcenters) {
        super();
        this.failureDomains = failureDomains;
        this.nodeNetworking = nodeNetworking;
        this.vcenters = vcenters;
    }

    @JsonProperty("failureDomains")
    public List<VSpherePlatformFailureDomainSpec> getFailureDomains() {
        return failureDomains;
    }

    @JsonProperty("failureDomains")
    public void setFailureDomains(List<VSpherePlatformFailureDomainSpec> failureDomains) {
        this.failureDomains = failureDomains;
    }

    @JsonProperty("nodeNetworking")
    public VSpherePlatformNodeNetworking getNodeNetworking() {
        return nodeNetworking;
    }

    @JsonProperty("nodeNetworking")
    public void setNodeNetworking(VSpherePlatformNodeNetworking nodeNetworking) {
        this.nodeNetworking = nodeNetworking;
    }

    @JsonProperty("vcenters")
    public List<VSpherePlatformVCenterSpec> getVcenters() {
        return vcenters;
    }

    @JsonProperty("vcenters")
    public void setVcenters(List<VSpherePlatformVCenterSpec> vcenters) {
        this.vcenters = vcenters;
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
