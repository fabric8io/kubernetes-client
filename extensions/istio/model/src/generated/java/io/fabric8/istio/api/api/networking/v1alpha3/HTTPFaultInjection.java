
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * HTTPFaultInjection can be used to specify one or more faults to inject while forwarding HTTP requests to the destination specified in a route. Fault specification is part of a VirtualService rule. Faults include aborting the Http request from downstream service, and/or delaying proxying of requests. A fault rule MUST HAVE delay or abort or both.<br><p> <br><p> &#42;Note:&#42; Delay and abort faults are independent of one another, even if both are specified simultaneously.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "abort",
    "delay"
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
public class HTTPFaultInjection implements Editable<HTTPFaultInjectionBuilder>, KubernetesResource
{

    @JsonProperty("abort")
    private HTTPFaultInjectionAbort abort;
    @JsonProperty("delay")
    private HTTPFaultInjectionDelay delay;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPFaultInjection() {
    }

    public HTTPFaultInjection(HTTPFaultInjectionAbort abort, HTTPFaultInjectionDelay delay) {
        super();
        this.abort = abort;
        this.delay = delay;
    }

    /**
     * HTTPFaultInjection can be used to specify one or more faults to inject while forwarding HTTP requests to the destination specified in a route. Fault specification is part of a VirtualService rule. Faults include aborting the Http request from downstream service, and/or delaying proxying of requests. A fault rule MUST HAVE delay or abort or both.<br><p> <br><p> &#42;Note:&#42; Delay and abort faults are independent of one another, even if both are specified simultaneously.
     */
    @JsonProperty("abort")
    public HTTPFaultInjectionAbort getAbort() {
        return abort;
    }

    /**
     * HTTPFaultInjection can be used to specify one or more faults to inject while forwarding HTTP requests to the destination specified in a route. Fault specification is part of a VirtualService rule. Faults include aborting the Http request from downstream service, and/or delaying proxying of requests. A fault rule MUST HAVE delay or abort or both.<br><p> <br><p> &#42;Note:&#42; Delay and abort faults are independent of one another, even if both are specified simultaneously.
     */
    @JsonProperty("abort")
    public void setAbort(HTTPFaultInjectionAbort abort) {
        this.abort = abort;
    }

    /**
     * HTTPFaultInjection can be used to specify one or more faults to inject while forwarding HTTP requests to the destination specified in a route. Fault specification is part of a VirtualService rule. Faults include aborting the Http request from downstream service, and/or delaying proxying of requests. A fault rule MUST HAVE delay or abort or both.<br><p> <br><p> &#42;Note:&#42; Delay and abort faults are independent of one another, even if both are specified simultaneously.
     */
    @JsonProperty("delay")
    public HTTPFaultInjectionDelay getDelay() {
        return delay;
    }

    /**
     * HTTPFaultInjection can be used to specify one or more faults to inject while forwarding HTTP requests to the destination specified in a route. Fault specification is part of a VirtualService rule. Faults include aborting the Http request from downstream service, and/or delaying proxying of requests. A fault rule MUST HAVE delay or abort or both.<br><p> <br><p> &#42;Note:&#42; Delay and abort faults are independent of one another, even if both are specified simultaneously.
     */
    @JsonProperty("delay")
    public void setDelay(HTTPFaultInjectionDelay delay) {
        this.delay = delay;
    }

    @JsonIgnore
    public HTTPFaultInjectionBuilder edit() {
        return new HTTPFaultInjectionBuilder(this);
    }

    @JsonIgnore
    public HTTPFaultInjectionBuilder toBuilder() {
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
