/*
 * Copyright (c) 2015 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

import java.net.URI;
import java.net.URL;
import java.util.Map;

import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class ModelEvaluatorCacheTest {

	@Test
	public void getAndRemove() throws Exception {
		URL url = ModelEvaluatorCacheTest.class.getResource("/pmml/" + MixedNeighborhoodTest.class.getSimpleName() + ".pmml");

		ModelEvaluatorCache cache = new ModelEvaluatorCache(CacheBuilder.newBuilder());

		Map<URI, ModelEvaluator<?>> map = cache.asMap();

		assertEquals(0, map.size());

		ModelEvaluator<?> firstEvaluator = cache.get(url);

		assertEquals(1, map.size());

		assertTrue(firstEvaluator instanceof NearestNeighborModelEvaluator);

		ModelEvaluator<?> secondEvaluator = cache.get(url);

		assertEquals(1, map.size());

		assertSame(firstEvaluator, secondEvaluator);

		cache.remove(url);

		assertEquals(0, map.size());
	}
}