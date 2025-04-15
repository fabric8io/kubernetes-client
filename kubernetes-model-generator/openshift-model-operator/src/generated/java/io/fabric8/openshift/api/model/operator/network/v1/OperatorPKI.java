
package io.fabric8.openshift.api.model.operator.network.v1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * OperatorPKI is a simple certificate authority. It is not intended for external use - rather, it is internal to the network operator. The CNO creates a CA and a certificate signed by that CA. The certificate has both ClientAuth and ServerAuth extended usages enabled.<br><p> <br><p> 	More specifically, given an OperatorPKI with &lt;name&gt;, the CNO will manage:<br><p> <br><p> - A Secret called &lt;name&gt;-ca with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the CA certificate<br><p> <br><p> - A ConfigMap called &lt;name&gt;-ca with a single data key:<br><p>   - cabundle.crt - the CA certificate(s)<br><p> <br><p> - A Secret called &lt;name&gt;-cert with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the certificate, signed by the CA<br><p> <br><p> The CA certificate will have a validity of 10 years, rotated after 9. The target certificate will have a validity of 6 months, rotated after 3<br><p> <br><p> The CA certificate will have a CommonName of "&lt;namespace&gt;_&lt;name&gt;-ca@&lt;timestamp&gt;", where &lt;timestamp&gt; is the last rotation time.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("network.operator.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OperatorPKI implements Editable<OperatorPKIBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "network.operator.openshift.io/v1";
    @JsonProperty("kind")
    private String kind = "OperatorPKI";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private OperatorPKISpec spec;
    @JsonProperty("status")
    private OperatorPKIStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperatorPKI() {
    }

    public OperatorPKI(String apiVersion, String kind, ObjectMeta metadata, OperatorPKISpec spec, OperatorPKIStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * OperatorPKI is a simple certificate authority. It is not intended for external use - rather, it is internal to the network operator. The CNO creates a CA and a certificate signed by that CA. The certificate has both ClientAuth and ServerAuth extended usages enabled.<br><p> <br><p> 	More specifically, given an OperatorPKI with &lt;name&gt;, the CNO will manage:<br><p> <br><p> - A Secret called &lt;name&gt;-ca with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the CA certificate<br><p> <br><p> - A ConfigMap called &lt;name&gt;-ca with a single data key:<br><p>   - cabundle.crt - the CA certificate(s)<br><p> <br><p> - A Secret called &lt;name&gt;-cert with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the certificate, signed by the CA<br><p> <br><p> The CA certificate will have a validity of 10 years, rotated after 9. The target certificate will have a validity of 6 months, rotated after 3<br><p> <br><p> The CA certificate will have a CommonName of "&lt;namespace&gt;_&lt;name&gt;-ca@&lt;timestamp&gt;", where &lt;timestamp&gt; is the last rotation time.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * OperatorPKI is a simple certificate authority. It is not intended for external use - rather, it is internal to the network operator. The CNO creates a CA and a certificate signed by that CA. The certificate has both ClientAuth and ServerAuth extended usages enabled.<br><p> <br><p> 	More specifically, given an OperatorPKI with &lt;name&gt;, the CNO will manage:<br><p> <br><p> - A Secret called &lt;name&gt;-ca with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the CA certificate<br><p> <br><p> - A ConfigMap called &lt;name&gt;-ca with a single data key:<br><p>   - cabundle.crt - the CA certificate(s)<br><p> <br><p> - A Secret called &lt;name&gt;-cert with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the certificate, signed by the CA<br><p> <br><p> The CA certificate will have a validity of 10 years, rotated after 9. The target certificate will have a validity of 6 months, rotated after 3<br><p> <br><p> The CA certificate will have a CommonName of "&lt;namespace&gt;_&lt;name&gt;-ca@&lt;timestamp&gt;", where &lt;timestamp&gt; is the last rotation time.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * OperatorPKI is a simple certificate authority. It is not intended for external use - rather, it is internal to the network operator. The CNO creates a CA and a certificate signed by that CA. The certificate has both ClientAuth and ServerAuth extended usages enabled.<br><p> <br><p> 	More specifically, given an OperatorPKI with &lt;name&gt;, the CNO will manage:<br><p> <br><p> - A Secret called &lt;name&gt;-ca with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the CA certificate<br><p> <br><p> - A ConfigMap called &lt;name&gt;-ca with a single data key:<br><p>   - cabundle.crt - the CA certificate(s)<br><p> <br><p> - A Secret called &lt;name&gt;-cert with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the certificate, signed by the CA<br><p> <br><p> The CA certificate will have a validity of 10 years, rotated after 9. The target certificate will have a validity of 6 months, rotated after 3<br><p> <br><p> The CA certificate will have a CommonName of "&lt;namespace&gt;_&lt;name&gt;-ca@&lt;timestamp&gt;", where &lt;timestamp&gt; is the last rotation time.
     */
    @JsonProperty("spec")
    public OperatorPKISpec getSpec() {
        return spec;
    }

    /**
     * OperatorPKI is a simple certificate authority. It is not intended for external use - rather, it is internal to the network operator. The CNO creates a CA and a certificate signed by that CA. The certificate has both ClientAuth and ServerAuth extended usages enabled.<br><p> <br><p> 	More specifically, given an OperatorPKI with &lt;name&gt;, the CNO will manage:<br><p> <br><p> - A Secret called &lt;name&gt;-ca with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the CA certificate<br><p> <br><p> - A ConfigMap called &lt;name&gt;-ca with a single data key:<br><p>   - cabundle.crt - the CA certificate(s)<br><p> <br><p> - A Secret called &lt;name&gt;-cert with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the certificate, signed by the CA<br><p> <br><p> The CA certificate will have a validity of 10 years, rotated after 9. The target certificate will have a validity of 6 months, rotated after 3<br><p> <br><p> The CA certificate will have a CommonName of "&lt;namespace&gt;_&lt;name&gt;-ca@&lt;timestamp&gt;", where &lt;timestamp&gt; is the last rotation time.
     */
    @JsonProperty("spec")
    public void setSpec(OperatorPKISpec spec) {
        this.spec = spec;
    }

    /**
     * OperatorPKI is a simple certificate authority. It is not intended for external use - rather, it is internal to the network operator. The CNO creates a CA and a certificate signed by that CA. The certificate has both ClientAuth and ServerAuth extended usages enabled.<br><p> <br><p> 	More specifically, given an OperatorPKI with &lt;name&gt;, the CNO will manage:<br><p> <br><p> - A Secret called &lt;name&gt;-ca with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the CA certificate<br><p> <br><p> - A ConfigMap called &lt;name&gt;-ca with a single data key:<br><p>   - cabundle.crt - the CA certificate(s)<br><p> <br><p> - A Secret called &lt;name&gt;-cert with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the certificate, signed by the CA<br><p> <br><p> The CA certificate will have a validity of 10 years, rotated after 9. The target certificate will have a validity of 6 months, rotated after 3<br><p> <br><p> The CA certificate will have a CommonName of "&lt;namespace&gt;_&lt;name&gt;-ca@&lt;timestamp&gt;", where &lt;timestamp&gt; is the last rotation time.
     */
    @JsonProperty("status")
    public OperatorPKIStatus getStatus() {
        return status;
    }

    /**
     * OperatorPKI is a simple certificate authority. It is not intended for external use - rather, it is internal to the network operator. The CNO creates a CA and a certificate signed by that CA. The certificate has both ClientAuth and ServerAuth extended usages enabled.<br><p> <br><p> 	More specifically, given an OperatorPKI with &lt;name&gt;, the CNO will manage:<br><p> <br><p> - A Secret called &lt;name&gt;-ca with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the CA certificate<br><p> <br><p> - A ConfigMap called &lt;name&gt;-ca with a single data key:<br><p>   - cabundle.crt - the CA certificate(s)<br><p> <br><p> - A Secret called &lt;name&gt;-cert with two data keys:<br><p>   - tls.key - the private key<br><p>   - tls.crt - the certificate, signed by the CA<br><p> <br><p> The CA certificate will have a validity of 10 years, rotated after 9. The target certificate will have a validity of 6 months, rotated after 3<br><p> <br><p> The CA certificate will have a CommonName of "&lt;namespace&gt;_&lt;name&gt;-ca@&lt;timestamp&gt;", where &lt;timestamp&gt; is the last rotation time.
     */
    @JsonProperty("status")
    public void setStatus(OperatorPKIStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public OperatorPKIBuilder edit() {
        return new OperatorPKIBuilder(this);
    }

    @JsonIgnore
    public OperatorPKIBuilder toBuilder() {
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
