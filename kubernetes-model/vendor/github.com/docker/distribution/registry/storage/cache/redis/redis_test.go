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
package redis

import (
	"flag"
	"os"
	"testing"
	"time"

	"github.com/docker/distribution/registry/storage/cache/cachecheck"
	"github.com/garyburd/redigo/redis"
)

var redisAddr string

func init() {
	flag.StringVar(&redisAddr, "test.registry.storage.cache.redis.addr", "", "configure the address of a test instance of redis")
}

// TestRedisLayerInfoCache exercises a live redis instance using the cache
// implementation.
func TestRedisBlobDescriptorCacheProvider(t *testing.T) {
	if redisAddr == "" {
		// fallback to an environement variable
		redisAddr = os.Getenv("TEST_REGISTRY_STORAGE_CACHE_REDIS_ADDR")
	}

	if redisAddr == "" {
		// skip if still not set
		t.Skip("please set -test.registry.storage.cache.redis.addr to test layer info cache against redis")
	}

	pool := &redis.Pool{
		Dial: func() (redis.Conn, error) {
			return redis.Dial("tcp", redisAddr)
		},
		MaxIdle:   1,
		MaxActive: 2,
		TestOnBorrow: func(c redis.Conn, t time.Time) error {
			_, err := c.Do("PING")
			return err
		},
		Wait: false, // if a connection is not avialable, proceed without cache.
	}

	// Clear the database
	conn := pool.Get()
	if _, err := conn.Do("FLUSHDB"); err != nil {
		t.Fatalf("unexpected error flushing redis db: %v", err)
	}
	conn.Close()

	cachecheck.CheckBlobDescriptorCache(t, NewRedisBlobDescriptorCacheProvider(pool))
}
