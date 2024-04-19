
package io.fabric8.istio.api.telemetry.v1alpha1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.telemetry.v1alpha1.TracingCustomTagEnvironment;
import io.fabric8.istio.api.telemetry.v1alpha1.TracingCustomTagHeader;
import io.fabric8.istio.api.telemetry.v1alpha1.TracingCustomTagLiteral;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(TracingCustomTagLiteral.class),
    @JsonSubTypes.Type(TracingCustomTagEnvironment.class),
    @JsonSubTypes.Type(TracingCustomTagHeader.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
public interface IsTracingCustomTagType {


}
