
package io.fabric8.openshift.api.model.operatorhub.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
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
    "deployments",
    "overrides",
    "serviceAccounts"
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
public class OperatorConditionSpec implements KubernetesResource
{

    @JsonProperty("deployments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> deployments = new ArrayList<String>();
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> overrides = new ArrayList<Condition>();
    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceAccounts = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OperatorConditionSpec() {
    }

    public OperatorConditionSpec(List<String> deployments, List<Condition> overrides, List<String> serviceAccounts) {
        super();
        this.deployments = deployments;
        this.overrides = overrides;
        this.serviceAccounts = serviceAccounts;
    }

    @JsonProperty("deployments")
    public List<String> getDeployments() {
        return deployments;
    }

    @JsonProperty("deployments")
    public void setDeployments(List<String> deployments) {
        this.deployments = deployments;
    }

    @JsonProperty("overrides")
    public List<Condition> getOverrides() {
        return overrides;
    }

    @JsonProperty("overrides")
    public void setOverrides(List<Condition> overrides) {
        this.overrides = overrides;
    }

    @JsonProperty("serviceAccounts")
    public List<String> getServiceAccounts() {
        return serviceAccounts;
    }

    @JsonProperty("serviceAccounts")
    public void setServiceAccounts(List<String> serviceAccounts) {
        this.serviceAccounts = serviceAccounts;
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
