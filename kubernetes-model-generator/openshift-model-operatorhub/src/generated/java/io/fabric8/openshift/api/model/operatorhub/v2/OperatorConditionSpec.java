
package io.fabric8.openshift.api.model.operatorhub.v2;

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
import io.fabric8.kubernetes.api.model.Condition;
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

/**
 * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "deployments",
    "overrides",
    "serviceAccounts"
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
public class OperatorConditionSpec implements Editable<OperatorConditionSpecBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("deployments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> deployments = new ArrayList<>();
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> overrides = new ArrayList<>();
    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceAccounts = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperatorConditionSpec() {
    }

    public OperatorConditionSpec(List<Condition> conditions, List<String> deployments, List<Condition> overrides, List<String> serviceAccounts) {
        super();
        this.conditions = conditions;
        this.deployments = deployments;
        this.overrides = overrides;
        this.serviceAccounts = serviceAccounts;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("deployments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDeployments() {
        return deployments;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("deployments")
    public void setDeployments(List<String> deployments) {
        this.deployments = deployments;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getOverrides() {
        return overrides;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("overrides")
    public void setOverrides(List<Condition> overrides) {
        this.overrides = overrides;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceAccounts() {
        return serviceAccounts;
    }

    /**
     * OperatorConditionSpec allows an operator to report state to OLM and provides cluster admin with the ability to manually override state reported by the operator.
     */
    @JsonProperty("serviceAccounts")
    public void setServiceAccounts(List<String> serviceAccounts) {
        this.serviceAccounts = serviceAccounts;
    }

    @JsonIgnore
    public OperatorConditionSpecBuilder edit() {
        return new OperatorConditionSpecBuilder(this);
    }

    @JsonIgnore
    public OperatorConditionSpecBuilder toBuilder() {
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
        if (!(o instanceof OperatorConditionSpec)) {
            return false;
        }
        OperatorConditionSpec other = (OperatorConditionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$deployments = this.getDeployments();
        Object other$deployments = other.getDeployments();
        if (this$deployments == null ? other$deployments != null : !this$deployments.equals(other$deployments)) {
            return false;
        }
        Object this$overrides = this.getOverrides();
        Object other$overrides = other.getOverrides();
        if (this$overrides == null ? other$overrides != null : !this$overrides.equals(other$overrides)) {
            return false;
        }
        Object this$serviceAccounts = this.getServiceAccounts();
        Object other$serviceAccounts = other.getServiceAccounts();
        if (this$serviceAccounts == null ? other$serviceAccounts != null : !this$serviceAccounts.equals(other$serviceAccounts)) {
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
        return other instanceof OperatorConditionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $deployments = this.getDeployments();
        result = result * prime + ($deployments == null ? 43 : $deployments.hashCode());
        Object $overrides = this.getOverrides();
        result = result * prime + ($overrides == null ? 43 : $overrides.hashCode());
        Object $serviceAccounts = this.getServiceAccounts();
        result = result * prime + ($serviceAccounts == null ? 43 : $serviceAccounts.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OperatorConditionSpec(" + "conditions=" + this.getConditions() + ", deployments=" + this.getDeployments() + ", overrides=" + this.getOverrides() + ", serviceAccounts=" + this.getServiceAccounts() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
