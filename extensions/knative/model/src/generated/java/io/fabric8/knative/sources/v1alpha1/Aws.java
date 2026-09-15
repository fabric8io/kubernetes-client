
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "auth",
    "ddbStreams",
    "s3",
    "sqs"
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Aws)) {
            return false;
        }
        Aws other = (Aws) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$auth = this.getAuth();
        Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) {
            return false;
        }
        Object this$ddbStreams = this.getDdbStreams();
        Object other$ddbStreams = other.getDdbStreams();
        if (this$ddbStreams == null ? other$ddbStreams != null : !this$ddbStreams.equals(other$ddbStreams)) {
            return false;
        }
        Object this$s3 = this.getS3();
        Object other$s3 = other.getS3();
        if (this$s3 == null ? other$s3 != null : !this$s3.equals(other$s3)) {
            return false;
        }
        Object this$sqs = this.getSqs();
        Object other$sqs = other.getSqs();
        if (this$sqs == null ? other$sqs != null : !this$sqs.equals(other$sqs)) {
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
        return other instanceof Aws;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $ddbStreams = this.getDdbStreams();
        result = result * prime + ($ddbStreams == null ? 43 : $ddbStreams.hashCode());
        Object $s3 = this.getS3();
        result = result * prime + ($s3 == null ? 43 : $s3.hashCode());
        Object $sqs = this.getSqs();
        result = result * prime + ($sqs == null ? 43 : $sqs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Aws(" + "auth=" + this.getAuth() + ", ddbStreams=" + this.getDdbStreams() + ", s3=" + this.getS3() + ", sqs=" + this.getSqs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
