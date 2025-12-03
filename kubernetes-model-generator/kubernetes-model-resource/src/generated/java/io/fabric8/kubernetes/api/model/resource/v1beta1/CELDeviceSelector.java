
package io.fabric8.kubernetes.api.model.resource.v1beta1;

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
 * CELDeviceSelector contains a CEL expression for selecting a device.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expression"
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
public class CELDeviceSelector implements Editable<CELDeviceSelectorBuilder>, KubernetesResource
{

    @JsonProperty("expression")
    private String expression;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CELDeviceSelector() {
    }

    public CELDeviceSelector(String expression) {
        super();
        this.expression = expression;
    }

    /**
     * Expression is a CEL expression which evaluates a single device. It must evaluate to true when the device under consideration satisfies the desired criteria, and false when it does not. Any other result is an error and causes allocation of devices to abort.<br><p> <br><p> The expression's input is an object named "device", which carries the following properties:<br><p>  - driver (string): the name of the driver which defines this device.<br><p>  - attributes (map[string]object): the device's attributes, grouped by prefix<br><p>    (e.g. device.attributes["dra.example.com"] evaluates to an object with all<br><p>    of the attributes which were prefixed by "dra.example.com".<br><p>  - capacity (map[string]object): the device's capacities, grouped by prefix.<br><p>  - allowMultipleAllocations (bool): the allowMultipleAllocations property of the device<br><p>    (v1.34+ with the DRAConsumableCapacity feature enabled).<br><p> <br><p> Example: Consider a device with driver="dra.example.com", which exposes two attributes named "model" and "ext.example.com/family" and which exposes one capacity named "modules". This input to this expression would have the following fields:<br><p> <br><p>     device.driver<br><p>     device.attributes["dra.example.com"].model<br><p>     device.attributes["ext.example.com"].family<br><p>     device.capacity["dra.example.com"].modules<br><p> <br><p> The device.driver field can be used to check for a specific driver, either as a high-level precondition (i.e. you only want to consider devices from this driver) or as part of a multi-clause expression that is meant to consider devices from different drivers.<br><p> <br><p> The value type of each attribute is defined by the device definition, and users who write these expressions must consult the documentation for their specific drivers. The value type of each capacity is Quantity.<br><p> <br><p> If an unknown prefix is used as a lookup in either device.attributes or device.capacity, an empty map will be returned. Any reference to an unknown field will cause an evaluation error and allocation to abort.<br><p> <br><p> A robust expression should check for the existence of attributes before referencing them.<br><p> <br><p> For ease of use, the cel.bind() function is enabled, and can be used to simplify expressions that access multiple attributes with the same domain. For example:<br><p> <br><p>     cel.bind(dra, device.attributes["dra.example.com"], dra.someBool &amp;&amp; dra.anotherBool)<br><p> <br><p> The length of the expression must be smaller or equal to 10 Ki. The cost of evaluating it is also limited based on the estimated number of logical steps.
     */
    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    /**
     * Expression is a CEL expression which evaluates a single device. It must evaluate to true when the device under consideration satisfies the desired criteria, and false when it does not. Any other result is an error and causes allocation of devices to abort.<br><p> <br><p> The expression's input is an object named "device", which carries the following properties:<br><p>  - driver (string): the name of the driver which defines this device.<br><p>  - attributes (map[string]object): the device's attributes, grouped by prefix<br><p>    (e.g. device.attributes["dra.example.com"] evaluates to an object with all<br><p>    of the attributes which were prefixed by "dra.example.com".<br><p>  - capacity (map[string]object): the device's capacities, grouped by prefix.<br><p>  - allowMultipleAllocations (bool): the allowMultipleAllocations property of the device<br><p>    (v1.34+ with the DRAConsumableCapacity feature enabled).<br><p> <br><p> Example: Consider a device with driver="dra.example.com", which exposes two attributes named "model" and "ext.example.com/family" and which exposes one capacity named "modules". This input to this expression would have the following fields:<br><p> <br><p>     device.driver<br><p>     device.attributes["dra.example.com"].model<br><p>     device.attributes["ext.example.com"].family<br><p>     device.capacity["dra.example.com"].modules<br><p> <br><p> The device.driver field can be used to check for a specific driver, either as a high-level precondition (i.e. you only want to consider devices from this driver) or as part of a multi-clause expression that is meant to consider devices from different drivers.<br><p> <br><p> The value type of each attribute is defined by the device definition, and users who write these expressions must consult the documentation for their specific drivers. The value type of each capacity is Quantity.<br><p> <br><p> If an unknown prefix is used as a lookup in either device.attributes or device.capacity, an empty map will be returned. Any reference to an unknown field will cause an evaluation error and allocation to abort.<br><p> <br><p> A robust expression should check for the existence of attributes before referencing them.<br><p> <br><p> For ease of use, the cel.bind() function is enabled, and can be used to simplify expressions that access multiple attributes with the same domain. For example:<br><p> <br><p>     cel.bind(dra, device.attributes["dra.example.com"], dra.someBool &amp;&amp; dra.anotherBool)<br><p> <br><p> The length of the expression must be smaller or equal to 10 Ki. The cost of evaluating it is also limited based on the estimated number of logical steps.
     */
    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
    }

    @JsonIgnore
    public CELDeviceSelectorBuilder edit() {
        return new CELDeviceSelectorBuilder(this);
    }

    @JsonIgnore
    public CELDeviceSelectorBuilder toBuilder() {
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
