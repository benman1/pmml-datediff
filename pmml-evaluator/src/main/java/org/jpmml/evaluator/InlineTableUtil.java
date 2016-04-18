/*
 * Copyright (c) 2013 Villu Ruusmann
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

import java.util.List;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import org.dmg.pmml.InlineTable;
import org.dmg.pmml.Row;
import org.w3c.dom.Element;

public class InlineTableUtil {

	private InlineTableUtil(){
	}

	static
	public Table<Integer, String, String> getContent(InlineTable inlineTable){
		return CacheUtil.getValue(inlineTable, InlineTableUtil.contentCache);
	}

	static
	Table<Integer, String, String> parse(InlineTable inlineTable){
		Table<Integer, String, String> result = HashBasedTable.create();

		Integer rowKey = 1;

		List<Row> rows = inlineTable.getRows();
		for(Row row : rows){
			List<Object> cells = row.getContent();

			for(Object cell : cells){

				if(cell instanceof Element){
					Element element = (Element)cell;

					result.put(rowKey, element.getTagName(), element.getTextContent());
				}
			}

			rowKey += 1;
		}

		return result;
	}

	private static final LoadingCache<InlineTable, Table<Integer, String, String>> contentCache = CacheUtil.buildLoadingCache(new CacheLoader<InlineTable, Table<Integer, String, String>>(){

		@Override
		public Table<Integer, String, String> load(InlineTable inlineTable){
			return Tables.unmodifiableTable(parse(inlineTable));
		}
	});
}