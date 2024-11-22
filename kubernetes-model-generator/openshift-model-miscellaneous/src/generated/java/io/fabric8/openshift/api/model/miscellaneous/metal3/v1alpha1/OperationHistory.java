
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.LinkedHashMap;
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
    "deprovision",
    "inspect",
    "provision",
    "register"
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
public class OperationHistory implements Editable<OperationHistoryBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("deprovision")
    public OperationMetric getDeprovision() {
        return deprovision;
    }

    @JsonProperty("deprovision")
    public void setDeprovision(OperationMetric deprovision) {
        this.deprovision = deprovision;
    }

    @JsonProperty("inspect")
    public OperationMetric getInspect() {
        return inspect;
    }

    @JsonProperty("inspect")
    public void setInspect(OperationMetric inspect) {
        this.inspect = inspect;
    }

    @JsonProperty("provision")
    public OperationMetric getProvision() {
        return provision;
    }

    @JsonProperty("provision")
    public void setProvision(OperationMetric provision) {
        this.provision = provision;
    }

    @JsonProperty("register")
    public OperationMetric getRegister() {
        return register;
    }

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
