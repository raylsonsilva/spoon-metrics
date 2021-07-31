package br.ufc.mdcc.spoonmetrics.miner;

import br.ufc.mdcc.spoonmetrics.model.Dataset;
import br.ufc.mdcc.spoonmetrics.model.Measure;
import br.ufc.mdcc.spoonmetrics.model.Metric;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

public class NoseExtractor extends AbstractProcessor<CtClass<?>> {
	
	@Override
	public void process(CtClass<?> element) 
	{
		String name = element.getQualifiedName();
		double qtdThrows = 0;
		
		for (CtMethod<?> e : element.getMethods()) 
		{
			qtdThrows = qtdThrows + e.getThrownTypes().size();
		}
		
		Dataset.store(name, new Measure(Metric.NOSE, qtdThrows));
	}
	
}
