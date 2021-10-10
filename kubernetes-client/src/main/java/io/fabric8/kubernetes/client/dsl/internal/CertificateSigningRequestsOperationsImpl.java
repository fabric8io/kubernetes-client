package io.fabric8.kubernetes.client.dsl.internal;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition;
import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


//public class CertificateSigningRequestsOperationsImpl  implements CertificateSigningRequestsResource<CertificateSigningRequest> {



//public CertificateSigningRequestsOperationsImpl(){
//  super();
//}
//  @Override
//  public CertificateSigningRequests approve(CertificateSigningRequest client, String csrName) {
//
//    OffsetDateTime now = OffsetDateTime.now();
//    List<CertificateSigningRequestCondition> csrc = new ArrayList<CertificateSigningRequestCondition>() {
//      {
//        add(new CertificateSigningRequestCondition(now.toString(), now.toString(), "", "Kubernetes Java Client", "True", "Approved"));
//      }
//    };
//
//}

