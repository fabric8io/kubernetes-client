
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
 * GRPC status code to use to abort the request. The supported codes are documented in https://github.com/grpc/grpc/blob/master/doc/statuscodes.md Note: If you want to return the status "Unavailable", then you should specify the code as `UNAVAILABLE`(all caps), but not `14`.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "grpcStatus"
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
public class HTTPFaultInjectionAbortGrpcStatus implements IsHTTPFaultInjectionAbortErrorType, Editable<HTTPFaultInjectionAbortGrpcStatusBuilder>, KubernetesResource
{

    @JsonProperty("grpcStatus")
    private String grpcStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPFaultInjectionAbortGrpcStatus() {
    }

    public HTTPFaultInjectionAbortGrpcStatus(String grpcStatus) {
        super();
        this.grpcStatus = grpcStatus;
    }

    /**
     * GRPC status code to use to abort the request. The supported codes are documented in https://github.com/grpc/grpc/blob/master/doc/statuscodes.md Note: If you want to return the status "Unavailable", then you should specify the code as `UNAVAILABLE`(all caps), but not `14`.
     */
    @JsonProperty("grpcStatus")
    public String getGrpcStatus() {
        return grpcStatus;
    }

    /**
     * GRPC status code to use to abort the request. The supported codes are documented in https://github.com/grpc/grpc/blob/master/doc/statuscodes.md Note: If you want to return the status "Unavailable", then you should specify the code as `UNAVAILABLE`(all caps), but not `14`.
     */
    @JsonProperty("grpcStatus")
    public void setGrpcStatus(String grpcStatus) {
        this.grpcStatus = grpcStatus;
    }

    @JsonIgnore
    public HTTPFaultInjectionAbortGrpcStatusBuilder edit() {
        return new HTTPFaultInjectionAbortGrpcStatusBuilder(this);
    }

    @JsonIgnore
    public HTTPFaultInjectionAbortGrpcStatusBuilder toBuilder() {
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
