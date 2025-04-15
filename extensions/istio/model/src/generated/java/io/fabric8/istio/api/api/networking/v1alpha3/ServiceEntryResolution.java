
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Resolution determines how the proxy will resolve the IP addresses of the network endpoints associated with the service, so that it can route to one of them. The resolution mode specified here has no impact on how the application resolves the IP address associated with the service. The application may still have to use DNS to resolve the service to an IP so that the outbound traffic can be captured by the Proxy. Alternatively, for HTTP services, the application could directly communicate with the proxy (e.g., by setting HTTP_PROXY) to talk to these services.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum ServiceEntryResolution 
{
    DNS(2),
    DNS_ROUND_ROBIN(3),
    NONE(0),
    STATIC(1);
    private final int value;
    private ServiceEntryResolution(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceEntryResolution fromValue(Object value) {
        if (value instanceof String) {
            for (ServiceEntryResolution e : ServiceEntryResolution.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (ServiceEntryResolution e : ServiceEntryResolution.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
