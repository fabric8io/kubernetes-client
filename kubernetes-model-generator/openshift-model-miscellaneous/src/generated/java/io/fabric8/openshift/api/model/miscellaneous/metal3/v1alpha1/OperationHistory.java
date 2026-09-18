
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OperationHistory holds information about operations performed on a host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deprovision",
    "inspect",
    "provision",
    "register"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OperationHistory implements Editable<OperationHistoryBuilder>, KubernetesResource
{

    @JsonProperty("deprovision")
    private OperationMetric deprovision;
    @JsonProperty("inspect")
    private OperationMetric inspect;
    @JsonProperty("provision")
    private OperationMetric provision;
    @JsonProperty("register")
    private OperationMetric register;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperationHistory() {
    }

    public OperationHistory(OperationMetric deprovision, OperationMetric inspect, OperationMetric provision, OperationMetric register) {
        super();
        this.deprovision = deprovision;
        this.inspect = inspect;
        this.provision = provision;
        this.register = register;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("deprovision")
    public OperationMetric getDeprovision() {
        return deprovision;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("deprovision")
    public void setDeprovision(OperationMetric deprovision) {
        this.deprovision = deprovision;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("inspect")
    public OperationMetric getInspect() {
        return inspect;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("inspect")
    public void setInspect(OperationMetric inspect) {
        this.inspect = inspect;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("provision")
    public OperationMetric getProvision() {
        return provision;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("provision")
    public void setProvision(OperationMetric provision) {
        this.provision = provision;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("register")
    public OperationMetric getRegister() {
        return register;
    }

    /**
     * OperationHistory holds information about operations performed on a host.
     */
    @JsonProperty("register")
    public void setRegister(OperationMetric register) {
        this.register = register;
    }

    @JsonIgnore
    public OperationHistoryBuilder edit() {
        return new OperationHistoryBuilder(this);
    }

    @JsonIgnore
    public OperationHistoryBuilder toBuilder() {
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
        if (!(o instanceof OperationHistory)) {
            return false;
        }
        OperationHistory other = (OperationHistory) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$deprovision = this.getDeprovision();
        Object other$deprovision = other.getDeprovision();
        if (this$deprovision == null ? other$deprovision != null : !this$deprovision.equals(other$deprovision)) {
            return false;
        }
        Object this$inspect = this.getInspect();
        Object other$inspect = other.getInspect();
        if (this$inspect == null ? other$inspect != null : !this$inspect.equals(other$inspect)) {
            return false;
        }
        Object this$provision = this.getProvision();
        Object other$provision = other.getProvision();
        if (this$provision == null ? other$provision != null : !this$provision.equals(other$provision)) {
            return false;
        }
        Object this$register = this.getRegister();
        Object other$register = other.getRegister();
        if (this$register == null ? other$register != null : !this$register.equals(other$register)) {
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
        return other instanceof OperationHistory;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $deprovision = this.getDeprovision();
        result = result * prime + ($deprovision == null ? 43 : $deprovision.hashCode());
        Object $inspect = this.getInspect();
        result = result * prime + ($inspect == null ? 43 : $inspect.hashCode());
        Object $provision = this.getProvision();
        result = result * prime + ($provision == null ? 43 : $provision.hashCode());
        Object $register = this.getRegister();
        result = result * prime + ($register == null ? 43 : $register.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OperationHistory(" + "deprovision=" + this.getDeprovision() + ", inspect=" + this.getInspect() + ", provision=" + this.getProvision() + ", register=" + this.getRegister() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
