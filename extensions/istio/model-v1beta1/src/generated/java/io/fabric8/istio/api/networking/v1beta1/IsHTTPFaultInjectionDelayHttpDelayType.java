
package io.fabric8.istio.api.networking.v1beta1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionDelayExponentialDelay;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionDelayFixedDelay;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(HTTPFaultInjectionDelayExponentialDelay.class),
    @JsonSubTypes.Type(HTTPFaultInjectionDelayFixedDelay.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
public interface IsHTTPFaultInjectionDelayHttpDelayType {


}
