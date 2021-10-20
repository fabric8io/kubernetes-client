//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.fabric8.kubernetes.client.dsl.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.CertificateSigningRequestsResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.URLUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request.Builder;

public class CertificateSigningRequestsOperationsImpl extends OperationSupport implements CertificateSigningRequestsResource {
  String type;

  public CertificateSigningRequestsOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, (String)null);
  }

  public CertificateSigningRequestsOperationsImpl(OkHttpClient client, Config config, String namespace) {
    super(client, config);
    (new OperationContext()).withOkhttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(HasMetadataOperation.DEFAULT_PROPAGATION_POLICY);
  }

  public CertificateSigningRequest approveOrDeny(String csrName, boolean approve) throws MalformedURLException {
    if (csrName == null || csrName.isEmpty()) {
      throw new KubernetesClientException("Missing required parameter 'name'");
    } else {
      if (approve) {
        this.type = "Approved";
      } else {
        this.type = "Denied";
      }

      final OffsetDateTime now = OffsetDateTime.now();
      KubernetesClient client2 = new DefaultKubernetesClient();
      CertificateSigningRequest csr = (CertificateSigningRequest)((Resource)client2.certificates().v1().certificateSigningRequests().withName(csrName)).get();
      List<CertificateSigningRequestCondition> updated = new ArrayList<CertificateSigningRequestCondition>() {
        {
          this.add(new CertificateSigningRequestCondition(now.toString(), now.toString(), String.format("This csr was %s by Kubernetes Java Client", type), "Kubernetes Java Client", "True", type));
        }
      };
      csr.getStatus().setConditions(updated);
      URL url = new URL(URLUtils.join(new String[]{this.config.getMasterUrl() + "/apis/" + csr.getApiVersion() + "/certificatesigningrequests" + String.format("/%s", csrName) + "/approval"}));
      RequestBody body = null;

      try {
        body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(csr));
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

      Builder request = (new Builder()).put(body).url(url);
      Request request1 = request.build();

      try {
        Response response = this.client.newCall(request1).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }

      return csr;
    }
  }
}
