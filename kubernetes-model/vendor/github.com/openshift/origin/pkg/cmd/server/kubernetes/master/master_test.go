/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package master

import (
	"testing"
	"time"

	"github.com/coreos/etcd/client"
	"golang.org/x/net/context"
	"k8s.io/apiserver/pkg/registry/generic"
	"k8s.io/apiserver/pkg/storage/etcd/etcdtest"
	etcdtesting "k8s.io/apiserver/pkg/storage/etcd/testing"
	"k8s.io/apiserver/pkg/storage/storagebackend"
	"k8s.io/kubernetes/pkg/api/testapi"
)

func TestNewMasterLeasesHasCorrectTTL(t *testing.T) {
	server := etcdtesting.NewUnsecuredEtcdTestClientServer(t)
	etcdStorage := &storagebackend.Config{
		Type:                     "etcd2",
		Prefix:                   etcdtest.PathPrefix(),
		ServerList:               server.Client.Endpoints(),
		DeserializationCacheSize: etcdtest.DeserializationCacheSize,
		Codec: testapi.Groups[""].StorageCodec(),
	}

	restOptions := generic.RESTOptions{StorageConfig: etcdStorage, Decorator: generic.UndecoratedStorage, DeleteCollectionWorkers: 1}
	storageInterface, _ := restOptions.Decorator(restOptions.StorageConfig, nil, "masterleases", nil, nil, nil, nil)
	defer server.Terminate(t)

	masterLeases := newMasterLeases(storageInterface, 15)
	if err := masterLeases.UpdateLease("1.2.3.4"); err != nil {
		t.Fatalf("error updating lease: %v", err)
	}

	etcdClient := server.Client
	keys := client.NewKeysAPI(etcdClient)
	resp, err := keys.Get(context.Background(), etcdtest.PathPrefix()+"/masterleases/1.2.3.4", nil)
	if err != nil {
		t.Fatalf("error getting key: %v", err)
	}
	ttl := resp.Node.TTLDuration()
	if ttl > 15*time.Second || ttl < 10*time.Second {
		t.Errorf("ttl %v should be ~ 15s", ttl)
	}
}
