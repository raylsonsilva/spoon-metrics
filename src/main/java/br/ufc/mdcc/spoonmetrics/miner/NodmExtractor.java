package br.ufc.mdcc.spoonmetrics.miner;

import br.ufc.mdcc.spoonmetrics.model.Dataset;
import br.ufc.mdcc.spoonmetrics.model.Measure;
import br.ufc.mdcc.spoonmetrics.model.Metric;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;

public class NodmExtractor extends AbstractProcessor<CtClass<?>> {

	@Override
	public void process(CtClass<?> element) 
	{
		String name = element.getQualifiedName();
		int size = element.getMethods().size();
		
		Dataset.store(name, new Measure(Metric.NODM, size));
	}
	
}
