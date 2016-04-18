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

import javax.xml.bind.annotation.XmlRegistry;

import org.dmg.pmml.ObjectFactory;

@XmlRegistry
public class RichObjectFactory extends ObjectFactory {

	@Override
	public RichBaseCumHazardTables createBaseCumHazardTables(){
		return new RichBaseCumHazardTables();
	}

	@Override
	public RichBayesInput createBayesInput(){
		return new RichBayesInput();
	}

	@Override
	public RichCategoricalPredictor createCategoricalPredictor(){
		return new RichCategoricalPredictor();
	}

	@Override
	public RichDataField createDataField(){
		return new RichDataField();
	}

	@Override
	public RichNormDiscrete createNormDiscrete(){
		return new RichNormDiscrete();
	}

	@Override
	public RichPPCell createPPCell(){
		return new RichPPCell();
	}

	@Override
	public RichSimplePredicate createSimplePredicate(){
		return new RichSimplePredicate();
	}

	@Override
	public RichSimpleSetPredicate createSimpleSetPredicate(){
		return new RichSimpleSetPredicate();
	}
}