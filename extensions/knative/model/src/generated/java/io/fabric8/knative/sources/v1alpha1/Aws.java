
package io.fabric8.knative.sources.v1alpha1;

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
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSDDBStreams;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQS;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.Auth;
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
    "auth",
    "ddbStreams",
    "s3",
    "sqs"
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
public class Aws implements Editable<AwsBuilder>, KubernetesResource
{

    @JsonProperty("auth")
    private Auth auth;
    @JsonProperty("ddbStreams")
    private AWSDDBStreams ddbStreams;
    @JsonProperty("s3")
    private AWSS3 s3;
    @JsonProperty("sqs")
    private AWSSQS sqs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Aws() {
    }

    public Aws(Auth auth, AWSDDBStreams ddbStreams, AWSS3 s3, AWSSQS sqs) {
        super();
        this.auth = auth;
        this.ddbStreams = ddbStreams;
        this.s3 = s3;
        this.sqs = sqs;
    }

    @JsonProperty("auth")
    public Auth getAuth() {
        return auth;
    }

    @JsonProperty("auth")
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @JsonProperty("ddbStreams")
    public AWSDDBStreams getDdbStreams() {
        return ddbStreams;
    }

    @JsonProperty("ddbStreams")
    public void setDdbStreams(AWSDDBStreams ddbStreams) {
        this.ddbStreams = ddbStreams;
    }

    @JsonProperty("s3")
    public AWSS3 getS3() {
        return s3;
    }

    @JsonProperty("s3")
    public void setS3(AWSS3 s3) {
        this.s3 = s3;
    }

    @JsonProperty("sqs")
    public AWSSQS getSqs() {
        return sqs;
    }

    @JsonProperty("sqs")
    public void setSqs(AWSSQS sqs) {
        this.sqs = sqs;
    }

    @JsonIgnore
    public AwsBuilder edit() {
        return new AwsBuilder(this);
    }

    @JsonIgnore
    public AwsBuilder toBuilder() {
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
